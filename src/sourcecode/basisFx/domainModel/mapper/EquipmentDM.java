/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.domainModel.mapper;

import basisFx.appCore.domainScetch.DomainObject;
import basisFx.appCore.dataSource.DataMapper;
import basisFx.appCore.dataSource.Db;
import basisFx.domainModel.domaine.*;
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
public class EquipmentDM extends DataMapper {
    
    private Equipment domainObject;
    
    private static EquipmentDM instance;
   
    private EquipmentDM() {}
    
    public static EquipmentDM getInstance(){
     
        if(EquipmentDM.instance!=null){
            return EquipmentDM.instance;
        }else{
            EquipmentDM.instance=new EquipmentDM();
            return  EquipmentDM.instance;
        }
        
    }




    @Override
    public void insertDomainObject(DomainObject d) {
        
        domainObject=(Equipment) d;


        if (isReadyToTransaction(d)) {


            try {
                String expression = "INSERT INTO " + "Equipment"
                        + "("
                        + "name"
                        + ") VALUES(?)";

                PreparedStatement pstmt = Db.getConnection().prepareStatement(expression);
                pstmt.setString(1, domainObject.getName());

                pstmt.executeUpdate();


            } catch (SQLException ex) {
                Logger.getLogger(EquipmentDM.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public void updateDomainObject(DomainObject d) {
        if (isReadyToTransaction(d)) {
            try {
                domainObject = (Equipment) d;

                String expression = "UPDATE " + "Equipment"+
                        " SET  name = ? "
                        + "WHERE id= ?";


                PreparedStatement pstmt = Db.getConnection().prepareStatement(expression);

                pstmt.setString(1, domainObject.getName());
                pstmt.setInt(2, domainObject.getId());


                pstmt.executeUpdate();

            } catch (SQLException ex) {
                Logger.getLogger(EquipmentDM.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public boolean isReadyToTransaction(DomainObject d) {
        Equipment equipment= (Equipment) d;
        if (equipment.getName()!=null
                ) {
            System.out.println("!!!!!!!!!!!!!!EquipmentDM --- объект готов к транзакции");

            return true;
        }
        System.out.println("!!!!!!!!!!!!!!EquipmentDM --- объект НЕ готов к транзакции");

        return false;
    }

    @Override
    public void getAllDomainObjectList(ObservableList list) {
        
      try {
             
        String expression="SELECT * FROM " +"Equipment"+" ORDER BY ID";
        
        Statement stmt  = Db.getConnection().createStatement();
        
        ResultSet rs    = stmt.executeQuery(expression);

            
            while (rs.next()) { 
                
                Equipment pojo=new Equipment();
                pojo.setId(rs.getInt("id"));
                pojo.setName(rs.getString("name"));

                
                //вставляю id в список хранимых в бд
                this.unitOfWork.getStoredPojoesId().add(rs.getInt("id"));
                
                list.add(pojo);
                
              
        
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EquipmentDM.class.getName()).log(Level.SEVERE, null, ex);
        }
 
        
    }

    @Override
    public void getAllDomainObjectList(ObservableList list, DomainObject selectedDomainObject) {

    }


}
