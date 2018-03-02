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
    
    private static EquipmentDataMapper instance;
   
    private EquipmentDataMapper() {}
    
    public static EquipmentDataMapper getInstanse(){
     
        if(EquipmentDataMapper.instance!=null){
            return EquipmentDataMapper.instance;
        }else{
            EquipmentDataMapper.instance=new EquipmentDataMapper();
            return  EquipmentDataMapper.instance;
        }
        
    }
  
    @Override
    public void insertDomainObject(DomainObject d) {
        
        domainObject=(Equipment) d;
        
        try {
            String expression= "INSERT INTO "+ d.getTableName()
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
    public void updateDomainObject(DomainObject d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObservableList getAllDomainObjectList(ObservableList list,String tableName) {
        
      try {
             
        String expression="SELECT * FROM " +tableName+" ORDER BY ID";
        
        Statement stmt  = Db.getConnection().createStatement();
        
        ResultSet rs    = stmt.executeQuery(expression);

            
            while (rs.next()) { 
                
                Equipment pojo=new Equipment();
                pojo.setId(rs.getInt("id"));
                pojo.setName(rs.getString("name"));
                pojo.setRodWidth(rs.getInt("rodWidth"));
        
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EquipmentDataMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
        
        
        
        
    }

   
    
}
