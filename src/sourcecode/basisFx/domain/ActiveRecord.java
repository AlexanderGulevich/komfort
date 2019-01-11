package basisFx.domain;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

import basisFx.appCore.utils.DomainPropertiesMetaInfo;
import basisFx.appCore.interfaces.DateGetter;
import basisFx.appCore.reflection.*;
import basisFx.dataSource.Db;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public abstract class ActiveRecord {
    public String entityName;
    public ActiveRecord outerRecord;
    public ObjectProperty<Integer> id =new SimpleObjectProperty<>(this, "id", null);
    public int outerId;

    public abstract String toString();  //Method for Combobox
    public abstract ObservableList<ActiveRecord> findAllByOuterId(int id);
//    public abstract ObservableList<ActiveRecord> findAllByOuterId(ActiveRecord record);
    public ActiveRecord( ) {
        String name = this.getClass().getName();
        String[] arr = name.split("\\.");
        name= arr[arr.length - 1];
        this.entityName =name;

    }
    public boolean isReadyToTransaction(){
        return Reflection.isReadyToTransaction(this);
    }

    public Integer getId() {
        return id.get();
    }
    public void setId(int value) {
        this.id.set(value);
    }
    public  ObservableList <ActiveRecord>  getAllByDate(LocalDate date){return null;};
    public  ObservableList<ActiveRecord>  createNewActiveRecordList() {
        return FXCollections.<ActiveRecord>observableArrayList();
    }
    public static boolean isNewDomane(ActiveRecord record) {
        if (record != null) {
            if (record.getId() !=null) {
                return false;
            }else{
                return true;
            }
        }else{
            throw new  NullPointerException();
        }
    }
    public  ObservableList <ActiveRecord>  getAll() {
        ObservableList <ActiveRecord> list= FXCollections.observableArrayList();
        ArrayList<DomainPropertiesMetaInfo> domainPropertiesMetaInfoList = ReflectionInspectDomain.inspectDomainProperties(this);
        ResultSet rs = executeQuery("Select * from " + this.entityName + " order by id ");
        return ReflectionGet.getAllDomains(this,list, domainPropertiesMetaInfoList, rs);
    }


    public ActiveRecord find(int id) {
        ActiveRecord activeRecord = Reflection.createNewInstance(this);
        ArrayList<DomainPropertiesMetaInfo> domainPropertiesMetaInfoList = ReflectionInspectDomain.inspectDomainProperties(this);
        String expression="SELECT  * FROM " +this.entityName+" WHERE ID=?";
        return ReflectionGet.findDomain(id, activeRecord, domainPropertiesMetaInfoList, expression);
    }

    private ResultSet executeQuery(String expression)   {
        try (
                Statement stmt = Db.connection.createStatement()) {
                ResultSet resultSet;
            try {
                resultSet = stmt.executeQuery(expression);
                return resultSet;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void delete(){
            try {
                String expression="delete from " +entityName+" where id=? ";
                PreparedStatement pstmt =  Db.connection.prepareStatement(expression);
                pstmt.setInt(1, this.id.get());
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    public void update() {
        ArrayList<DomainPropertiesMetaInfo> domainPropertiesMetaInfoList = ReflectionInspectDomain.inspectDomainProperties(this);
        String updateExpression = ReflectionUpdate.createUpdateExpression(this,domainPropertiesMetaInfoList);
        ReflectionUpdate.executePepareStatement(this,updateExpression,domainPropertiesMetaInfoList);
    }



    public void insert() {
        ArrayList<DomainPropertiesMetaInfo> domainPropertiesMetaInfoList = ReflectionInspectDomain.inspectDomainProperties(this);
        String insertExpression = ReflectionInsert.createInsertExpression(this,domainPropertiesMetaInfoList);
        ReflectionInsert.executeInsertStatement(this,insertExpression,domainPropertiesMetaInfoList);
    }





    /**
     * Эта функция неоходима для того, чтобы не допустить в связанных таблицах попадание тарифа или цены или курса в базу данных
     * с одной и той же датой. Дата в разрезе одного конкретного одентификатора, например сотрудника или продукта должна быть уникальной в БД
     * Должна использоваться в insert и update методах отображателей
     * @return Возвращает TRUE если в БД есть значение на данную дату по данной сущности
     */
    public boolean isUniquenessStartingDate(ObservableList<ActiveRecord>  records, DateGetter dateGetter , LocalDate testedDate ){
//todo сделать вывод сцены
        long count = records.stream().filter(activeRecord -> dateGetter.getDate(activeRecord).isEqual(testedDate)).count();

        if (count>0) {
            return false;

        }
        return true;
    }







}


