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
public class EquipmentMapper extends DataMapper {
    
    private Equipment domainObject;
    
    private static EquipmentMapper instance;
   
    private EquipmentMapper() {}
    
    public static EquipmentMapper getInstance(){
     
        if(EquipmentMapper.instance!=null){
            return EquipmentMapper.instance;
        }else{
            EquipmentMapper.instance=new EquipmentMapper();
            return  EquipmentMapper.instance;
        }
        
    }


    @Override
    public void insertDomainObject(DomainObject d) throws SQLException {
        
        domainObject=(Equipment) d;


        if (isReadyToTransaction(d)) {

                String expression = "INSERT INTO " + "Equipment"
                        + "("
                        + "name"
                        + ") VALUES(?)";

                PreparedStatement pstmt = Db.getConnection().prepareStatement(expression);
                pstmt.setString(1, domainObject.getName());

                pstmt.executeUpdate();

        }

    }

    @Override
    public void updateDomainObject(DomainObject d) throws SQLException {
        if (isReadyToTransaction(d)) {

                domainObject = (Equipment) d;

                String expression = "UPDATE " + "Equipment"+
                        " SET  name = ? "
                        + "WHERE id= ?";


                PreparedStatement pstmt = Db.getConnection().prepareStatement(expression);

                pstmt.setString(1, domainObject.getName());
                pstmt.setInt(2, domainObject.getId());


                pstmt.executeUpdate();

        }
    }

    @Override
    public void deleteDomainObject(DomainObject d) throws SQLException {
        super.delete(d,"Equipment");
    }

    @Override
    public boolean isReadyToTransaction(DomainObject d) {
        Equipment equipment= (Equipment) d;
        if (equipment.getName()!=null
                ) {
            return true;
        }

        return false;
    }

    @Override
    public void getDomainList(ObservableList list) throws SQLException {

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
    }

    @Override
    public void getDomainListForObserverTables(ObservableList list, DomainObject selectedDomainObject) {

    }


}
