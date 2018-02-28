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
    
    protected DomainObject domainObject;
    
 
   
    public void deleteDomainObject() throws SQLException{
        String expression="delete from " +domainObject.getTableName()+"where id=? ";
        PreparedStatement pstmt =  Db.getConnection().prepareStatement(expression);
                 pstmt.setInt(1, domainObject.getId());
                 pstmt.executeUpdate();

    }
     public abstract void getAllDomainObjectList(ObservableList  list);
     public abstract void updateDomainObject();
     public abstract void insertDomainObject();
     
     public ResultSet readAllDomainObjects() throws SQLException{
     
     String expression="SELECT * FROM " +domainObject.getTableName()+" ORDER BY ID";
        
        Statement stmt  = Db.getConnection().createStatement();
        
        ResultSet rs    = stmt.executeQuery(expression);
        
        return rs;
     }
    
    

          
}
 
        
       