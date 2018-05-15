/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.dataSource;

import basisFx.appCore.domainScetch.ComboBoxValue;
import basisFx.appCore.domainScetch.DomainObject;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import basisFx.appCore.interfaces.DeleteDomainObject;
import basisFx.appCore.interfaces.StringGetterFromDomain;
import basisFx.domainModel.DataMapperFabric;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Alek
 */
public abstract class DataMapper   {

    protected ObservableList<DomainObject> list=FXCollections.observableArrayList();
    protected DataMapperFabric dataMapperFabric=new DataMapperFabric();
    private Map<Integer,DomainObject> map= new HashMap<>();
    private int observableDomaineId;

    
    protected UnitOfWork unitOfWork;

    public abstract boolean isReadyToTransaction(DomainObject d);
    public abstract void getDomainList(ObservableList  list);
    public abstract void getDomainListForObserverTables(ObservableList  list, DomainObject selectedDomainObject);

    public abstract void updateDomainObject(DomainObject d);
    public abstract void deleteDomainObject(DomainObject d) throws SQLException;
    public abstract void insertDomainObject(DomainObject d);

    public void delete(DomainObject domainObject, String tableName) throws SQLException{
        String expression="delete from " +tableName+" where id=? ";
        PreparedStatement pstmt =  Db.getConnection().prepareStatement(expression);
        pstmt.setInt(1, domainObject.getId());
        pstmt.executeUpdate();

    }

    public void deleteForBoundTables(DomainObject domainObject, String observedtableName,String observertableName) throws SQLException{

        String expression_1="delete from " +observedtableName+" where id=? ";
        PreparedStatement pstmt_1 =  Db.getConnection().prepareStatement(expression_1);
        pstmt_1.setInt(1, domainObject.getId());
        pstmt_1.executeUpdate();


        String expression_2="delete from " +observertableName+" where id=? ";
        PreparedStatement pstmt_2 =  Db.getConnection().prepareStatement(expression_2);
        pstmt_2.setInt(1, domainObject.getId());
        pstmt_2.executeUpdate();



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

    // getDomainList(list) записывает в  list значения ReturnSet БД
    // далее идет преобразование каждой строки БД в ComboBoxValue и возвращается список
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


}
 
        
       