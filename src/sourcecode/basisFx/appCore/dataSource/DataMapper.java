/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.dataSource;

import basisFx.domainModel.pojo.DomainObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.ObservableList;

/**
 *
 * @author Alek
 */
public abstract class DataMapper {
    
     
     public abstract void getAllDomainObjectList(ObservableList  list,String tableName);
     public abstract void updateDomainObject(DomainObject d);
     public abstract void insertDomainObject(DomainObject d);
     public void deleteDomainObject(DomainObject domainObject) throws SQLException{
        String expression="delete from " +domainObject.getTableName()+"where id=? ";
        PreparedStatement pstmt =  Db.getConnection().prepareStatement(expression);
                 pstmt.setInt(1, domainObject.getId());
                 pstmt.executeUpdate();

    }
    
    

          
}
 
        
       