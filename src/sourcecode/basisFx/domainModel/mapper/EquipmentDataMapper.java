/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.domainModel.mapper;

import basisFx.appCore.dataSource.DataMapper;
import basisFx.appCore.dataSource.Db;
import basisFx.domainModel.pojo.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;

/**
 *
 * @author Alek
 */
public class EquipmentDataMapper extends DataMapper {
    
    private Equipment domainObject;

    public EquipmentDataMapper(Equipment eq) {
      
        this.domainObject=eq;
    
    }

    @Override
    public void insertDomainObject() {
        try {
            String expression= "INSERT INTO "+ domainObject.getTableName()
                  + "(rodWidth ,"
                  + "name"
                  + ") VALUES(?,?)";

            PreparedStatement pstmt =  Db.getConnection().prepareStatement(expression);
            pstmt.setInt(1, domainObject.getRodWidth());
            pstmt.setString(2, domainObject.getName());     
            
            
  

            pstmt.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(EquipmentDataMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void updateDomainObject() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getAllDomainObjectList(ObservableList list) {
        
    }
    
}
