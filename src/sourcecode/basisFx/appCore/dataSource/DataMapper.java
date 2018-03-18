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

import javafx.collections.ObservableList;

/**
 *
 * @author Alek
 */
public abstract class DataMapper {

    protected ObservableList<DomainObject> list;
    private Map<Integer,DomainObject> map= new HashMap<>();
    
     protected UnitOfWork unitOfWork;

    public abstract void getAllDomainObjectList(ObservableList  list,String tableName);

    public abstract void updateDomainObject(DomainObject d);
    public abstract void insertDomainObject(DomainObject d);
//    public abstract void getAllDomainObjectHashMap(HashMap m,String tableName);
     
     public void deleteDomainObject(DomainObject domainObject) throws SQLException{
        String expression="delete from " +domainObject.getTableName()+" where id=? ";
        PreparedStatement pstmt =  Db.getConnection().prepareStatement(expression);
                 pstmt.setInt(1, domainObject.getId());
                 pstmt.executeUpdate();

    }

    public void setUnitOfWork(UnitOfWork u) {
        this.unitOfWork=u;
    }




}
 
        
       