package basisFx.domain.domaine;

import java.sql.*;
import java.time.LocalDate;
import java.util.HashMap;

import basisFx.appCore.interfaces.StringGetterFromDomain;
import basisFx.dataSource.Db;
import basisFx.dataSource.UnitOfWork;
import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public abstract class ActiveRecord {

    public String entityName;
    public ObjectProperty<Integer> id =new SimpleObjectProperty<>(this, "id", null);
    private UnitOfWork unitOfWork;

    public Integer getId() {
        return id.get();
    }
    public void setId(int value) {
        this.id.set(value);
    }
    public  abstract ComboBoxValue  toComboBoxValue();
    public abstract boolean isReadyToTransaction();
    public abstract ObservableList <ActiveRecord>  getAll();
    public abstract void update();
    public abstract void insert();

    public void delete(){
            try {
                String expression="delete from " +entityName+" where id=? ";
                PreparedStatement pstmt =  Db.connection.prepareStatement(expression);
                pstmt.setInt(1, id.get());
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    /**
     * @param domainObject  - it is domainObject from observedtable.
     * @param observedtableName
     * @param observertableName
     */
    public void deleteForBoundTables(ActiveRecord domainObject, String observedtableName,String observertableName){

        if (domainObject != null) {
            try {
                String expression_1="delete from " +observedtableName+" where id=? ";
                PreparedStatement pstmt_1 =  Db.connection.prepareStatement(expression_1);
                pstmt_1.setInt(1, domainObject.getId());
                pstmt_1.executeUpdate();


                String expression_2="delete from " +observertableName+" where id=? ";
                PreparedStatement pstmt_2 =  Db.connection.prepareStatement(expression_2);
                pstmt_2.setInt(1, domainObject.getId());
                pstmt_2.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("ActiveRecord.deleteForBoundTables - domainObject is NULL");
        }





    }

    public void setUnitOfWork(UnitOfWork u) {
        this.unitOfWork=u;
    }

    public UnitOfWork getUnitOfWork() {
        return unitOfWork;
    }


    // getAll(list) записывает в  list значения ReturnSet БД
    // далее идет преобразование каждой строки БД в HashMap, где ключем является id
    public HashMap<Integer,ActiveRecord> toHashMapByCommonRawId(ObservableList<ActiveRecord> list){
        list.clear();
        getAll();

        HashMap<Integer,ActiveRecord> hm=new HashMap<>();

        for (ActiveRecord domainObject : list) {

            Integer id = domainObject.getId();
            hm.put(id,domainObject);
        }

        return hm;

    }


    // getAll(list) записывает в  list значения ReturnSet БД
    // далее идет преобразование каждой строки БД в HashMap, где ключем является id
    // а значение ComboBoxValue для вставки в ComboBox
    public HashMap<Integer,ComboBoxValue> toComboBoxValHashMap(ObservableList<ActiveRecord> list, StringGetterFromDomain stringGetterFromDomain){
        list.clear();
        getAll();

        HashMap<Integer,ComboBoxValue> hm=new HashMap<>();

        for (ActiveRecord domainObject : list) {

            Integer id = domainObject.getId();

            ComboBoxValue comboBoxValue = new ComboBoxValue(
                    stringGetterFromDomain.get(domainObject),
                    domainObject.getId()
            );

            hm.put(id,comboBoxValue);


        }

        return hm;

    }

    /**
     * getAll(list) записывает в  list значения ReturnSet БД\
     * далее идет преобразование каждой строки БД в ComboBoxValue и возвращается список
     * @param stringGetterFromDomain
     * @return
     */
    public ObservableList<ComboBoxValue> toComboBoxValueList(ObservableList<ActiveRecord> list,StringGetterFromDomain stringGetterFromDomain){
        list.clear();
        getAll();

        ObservableList<ComboBoxValue> comboBoxValueList= FXCollections.observableArrayList();

        for (ActiveRecord domainObject : list) {

            ComboBoxValue comboBoxValue = new ComboBoxValue(
                    stringGetterFromDomain.get(domainObject),
                    domainObject.getId()
            );

                    comboBoxValueList.add(comboBoxValue);

        }

        return comboBoxValueList;

    }

    /**
     * Эта функция неоходима для того, чтобы не допустить в связанных таблицах попадание тарифа или цены или курса в базу данных
     * с одной и той же датой. Дата в разрезе одного конкретного одентификатора, например сотрудника или продукта должна быть уникальной в БД
     * Должна использоваться в insert и update методах отображателей
     * @param tableName
     * @param dateName
     * @param date
     * @param checkedEntityName
     * @param checkedEntityId
     * @return Возвращает TRUE если в БД есть значение на данную дату по данной сущности
     */
    public boolean checkUniquenessDateById(String tableName, String dateName, LocalDate date, String checkedEntityName, int checkedEntityId ){
        try {

            String expression="SELECT * FROM " + tableName+" where " +checkedEntityName+
                    " =?  and "+dateName+" = ?";

            Statement stmt  = Db.connection.createStatement();

            PreparedStatement pstmt = Db.connection.prepareStatement(expression);
            pstmt.setInt(1, checkedEntityId);
            pstmt.setDate(2,  Date.valueOf(date));
            ResultSet rs    = pstmt.executeQuery();

            if (rs.next()) {

//                System.err.println("\n");
//                System.err.println("ActiveRecord.checkUniquenessDateById () ");
//                System.err.println("Date-"+rs.getDate("startDate"));
//                System.err.println("EmployerId  "+rs.getInt("employerId"));
//                System.err.println("\n");

                String message="В Базе Данных уже есть значение на дату: "
                        + date.toString()+
                        ". Создать новую запись с такой же датой нельзя." +
                        " Вы можете изменить старую, либо удалить ее.";

                Platform.runLater(() -> {


                });


                return true;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return false;
    }

    public abstract ObservableList<ActiveRecord> getAllByRelatedId(Integer id);


//    private EmployeesRatePerHour getNewest(Integer id){}




//    private EmployeesRatePerHour getNewest(Integer id){
//
//        EmployeesRatePerHour newestRate=null;
//
//        ArrayList<EmployeesRatePerHour> ratePerHoursList = ratesMapById.get(id);
//
//        if (ratePerHoursList != null) {
//            for (EmployeesRatePerHour rate:ratePerHoursList) {
//
//                if (newestRate == null) {
//
//                    newestRate=rate;
//
//                }
//
//                if (rate.getStartingDate().isAfter(newestRate.getStartingDate())){
//                    newestRate=rate;
//                }
//            }
//        }
//
//
//        return newestRate;
//
//
//
//    }


//
//    SELECT * FROM PRODUCTPRICESTORE
//    WHERE PRODUCTID=2
//    AND STARTDATE=(
//            SELECT MAX(STARTDATE) FROM PRODUCTPRICESTORE
//    WHERE PRODUCTID=2
//	)

}


