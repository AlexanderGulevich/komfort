/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.dataSource;

import basisFx.appCore.domainScetch.ComboBoxValue;
import basisFx.appCore.domainScetch.DomainObject;

import java.sql.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;


import basisFx.appCore.interfaces.StringGetterFromDomain;
import basisFx.domain.DataMapperFabric;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public abstract class ActiveRecord {

    protected ObservableList<DomainObject> list=FXCollections.observableArrayList();
    protected DataMapperFabric dataMapperFabric=new DataMapperFabric();
    private Map<Integer,DomainObject> map= new HashMap<>();
    private int observableDomaineId;
    protected UnitOfWork unitOfWork;

    public abstract boolean isReadyToTransaction(DomainObject d);
    public abstract void getDomainList(ObservableList  list);
    public abstract void getDomainListForObserverTables(ObservableList  list, DomainObject selectedDomainObject);
    public abstract void updateDomainObject(DomainObject d);
    public abstract void deleteDomainObject(DomainObject d);
    public abstract void insertDomainObject(DomainObject d);

    /**
     *
     * @param domainObject it is domainObject.
     * @param tableName
     */
    public void delete(DomainObject domainObject, String tableName){

        if (domainObject != null) {
            try {
                String expression="delete from " +tableName+" where id=? ";
                PreparedStatement pstmt =  Db.getConnection().prepareStatement(expression);
                pstmt.setInt(1, domainObject.getId());
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("ActiveRecord.delete - domainObject is NULL");
        }

    }

    /**
     * @param domainObject  - it is domainObject from observedtable.
     * @param observedtableName
     * @param observertableName
     */
    public void deleteForBoundTables(DomainObject domainObject, String observedtableName,String observertableName){

        if (domainObject != null) {
            try {
                String expression_1="delete from " +observedtableName+" where id=? ";
                PreparedStatement pstmt_1 =  Db.getConnection().prepareStatement(expression_1);
                pstmt_1.setInt(1, domainObject.getId());
                pstmt_1.executeUpdate();


                String expression_2="delete from " +observertableName+" where id=? ";
                PreparedStatement pstmt_2 =  Db.getConnection().prepareStatement(expression_2);
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

    protected void setStoredId(int id){
        if (unitOfWork != null) {
            //вставляю id в список хранимых в бд
            this.unitOfWork.getStoredPojoesId().add(id);
        }
    }

    public void setUnitOfWork(UnitOfWork u) {
        this.unitOfWork=u;
    }

    public UnitOfWork getUnitOfWork() {
        return unitOfWork;
    }

    public void setObservableDomaineId(int observableDomaineId) {
        this.observableDomaineId = observableDomaineId;
    }

    public int getObservableDomaineId() {
        return observableDomaineId;
    }

    // getDomainList(list) записывает в  list значения ReturnSet БД
    // далее идет преобразование каждой строки БД в HashMap, где ключем является id
    public HashMap<Integer,DomainObject> toHashMapByCommonRawId(){
        list.clear();
        getDomainList(list);

        HashMap<Integer,DomainObject> hm=new HashMap<>();

        for (DomainObject domainObject : list) {

            Integer id = domainObject.getId();
            hm.put(id,domainObject);
        }

        return hm;

    }


    // getDomainList(list) записывает в  list значения ReturnSet БД
    // далее идет преобразование каждой строки БД в HashMap, где ключем является id
    // а значение ComboBoxValue для вставки в ComboBox
    public HashMap<Integer,ComboBoxValue> toComboBoxValHashMap(StringGetterFromDomain stringGetterFromDomain){
        list.clear();
        getDomainList(list);

        HashMap<Integer,ComboBoxValue> hm=new HashMap<>();

        for (DomainObject domainObject : list) {

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
     * getDomainList(list) записывает в  list значения ReturnSet БД\
     * далее идет преобразование каждой строки БД в ComboBoxValue и возвращается список
     * @param stringGetterFromDomain
     * @return
     */
    public ObservableList<ComboBoxValue> toComboBoxValueList(StringGetterFromDomain stringGetterFromDomain){
        list.clear();
        getDomainList(list);

        ObservableList<ComboBoxValue> comboBoxValueList= FXCollections.observableArrayList();

        for (DomainObject domainObject : list) {

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

            Statement stmt  = Db.getConnection().createStatement();

            PreparedStatement pstmt = Db.getConnection().prepareStatement(expression);
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
                    PopupUndecorated popup = PopupFabric.popupUndecorated(
                            KindOfPopup.ERROR, message
                    );
                });


                return true;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return false;
    }




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


