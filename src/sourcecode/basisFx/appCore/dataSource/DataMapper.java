/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.dataSource;

import basisFx.domainModel.pojo.DomainObject;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Alek
 */
public abstract class DataMapper {
    
    protected DomainObject domainObject;
    
    public abstract void createDomainObject();
    public void readDomainObject(){}
    public void updateDomainObject(){}
    public void deleteDomainObject() throws SQLException{
        String expression="delete from" +domainObject.getTableName()+"where id=? ";
        PreparedStatement pstmt =  Db.getConnection().prepareStatement(expression);
                 pstmt.setInt(1, domainObject.getId());
                 pstmt.executeUpdate();

    }
    
    
}
 

          