/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.dataSource;

import basisFx.appCore.domainScetch.DomainObject;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import basisFx.domainModel.DataMapperFabric;
import javafx.collections.ObservableList;

/**
 *
 * @author Alek
 */
public abstract class DataMapper {

    protected ObservableList<DomainObject> list;
    protected DataMapperFabric dataMapperFabric=new DataMapperFabric();
    private Map<Integer,DomainObject> map= new HashMap<>();
    private int observableDomaineId;

    
     protected UnitOfWork unitOfWork;

    public abstract boolean isReadyToTransaction(DomainObject d);
    public abstract void getAllDomainObjectList(ObservableList  list);
    public abstract void getAllDomainObjectList(ObservableList  list,DomainObject selectedDomainObject);


    public abstract void updateDomainObject(DomainObject d);
    public abstract void insertDomainObject(DomainObject d);
     
     public void deleteDomainObject(DomainObject domainObject) throws SQLException{
        String expression="delete from " +domainObject.getTableName()+" where id=? ";
        PreparedStatement pstmt =  Db.getConnection().prepareStatement(expression);
                 pstmt.setInt(1, domainObject.getId());
                 pstmt.executeUpdate();

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



    // getAllDomainObjectList(list) записывает в  list значения ReturnSet БД
    // далее идет преобразование каждой строки БД в HashMap, где ключем является id
    public HashMap<Integer,DomainObject> toHashMapByCommonRawId(){

        getAllDomainObjectList(list);

        HashMap<Integer,DomainObject> hm=new HashMap<>();

        for (DomainObject domainObject : list) {

            Integer id = domainObject.getId();
            hm.put(id,domainObject);
        }

        return hm;

    }


}
 
        
       