package basisFx.domain;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

import basisFx.appCore.utils.DomainPropertiesMetaInfo;
import basisFx.appCore.reflection.*;
import basisFx.appCore.utils.Range;
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
        ResultSet rs = Reflection.executeQuery("Select * from " + this.entityName + " order by id ");
        return ReflectionGet.getAllDomains(this,list, domainPropertiesMetaInfoList, rs);
    }

    public ObservableList<ActiveRecord> findAllByOuterId(int id){
        ObservableList <ActiveRecord> list= FXCollections.observableArrayList();
        ArrayList<DomainPropertiesMetaInfo> domainPropertiesMetaInfoList = ReflectionInspectDomain.inspectDomainProperties(this);
        String exp = ReflectionGet.createfindAllByOuterIdExpression(this,domainPropertiesMetaInfoList, id);
        ResultSet rs = Reflection.executeQuery(exp);
        return ReflectionGet.getAllDomains(this,list, domainPropertiesMetaInfoList, rs);
    }

    public ObservableList<ActiveRecord> findAllByOuterIdAndRange(int id, Range   range){
        ObservableList <ActiveRecord> list= FXCollections.observableArrayList();
        ArrayList<DomainPropertiesMetaInfo> domainPropertiesMetaInfoList = ReflectionInspectDomain.inspectDomainProperties(this);
        String exp = ReflectionGet.createfindAllByOuterIdAndRangeExpression(this,domainPropertiesMetaInfoList, id,range);
        ResultSet rs = Reflection.executeQuery(exp);
        return ReflectionGet.getAllDomains(this,list, domainPropertiesMetaInfoList, rs);
    }

    public ActiveRecord find(int id) {
        ActiveRecord activeRecord = Reflection.createNewInstance(this);
        ArrayList<DomainPropertiesMetaInfo> domainPropertiesMetaInfoList = ReflectionInspectDomain.inspectDomainProperties(this);
        String expression="SELECT  * FROM " +this.entityName+" WHERE ID=?";
        return ReflectionGet.findDomain(id, activeRecord, domainPropertiesMetaInfoList, expression);
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

}


