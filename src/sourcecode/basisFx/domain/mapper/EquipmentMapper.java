///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package basisFx.domain.mapper;
//
//import basisFx.appCore.domainScetch.DomainObject;
//import basisFx.domain.domaine.ActiveRecord;
//import basisFx.dataSource.Db;
//import basisFx.domain.domaine.*;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//import javafx.collections.ObservableList;
//
///**
// *
// * @author Alek
// */
//public class EquipmentMapper extends ActiveRecord {
//
//
//    private Equipment domainObject;
//
//    private static EquipmentMapper instance;
//
//    private EquipmentMapper() {}
//
//    public static EquipmentMapper getInstance(){
//
//        if(EquipmentMapper.instance!=null){
//            return EquipmentMapper.instance;
//        }else{
//            EquipmentMapper.instance=new EquipmentMapper();
//            return  EquipmentMapper.instance;
//        }
//
//    }
//
//
//    @Override
//    public void insertDomainObject(DomainObject d)   {
//
//        domainObject=(Equipment) d;
//
//
//        try {
//            if (isReadyToTransaction(d)) {
//
//                    String expression = "INSERT INTO " + "Equipment"
//                            + "("
//                            + "name"
//                            + ") VALUES(?)";
//
//                    PreparedStatement pstmt = Db.getConnection().prepareStatement(expression);
//                    pstmt.setName(1, domainObject.getName());
//
//                    pstmt.executeUpdate();
//
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    @Override
//    public void updateDomainObject(DomainObject d)   {
//        try {
//            if (isReadyToTransaction(d)) {
//
//                    domainObject = (Equipment) d;
//
//                    String expression = "UPDATE " + "Equipment"+
//                            " SET  name = ? "
//                            + "WHERE id= ?";
//
//
//                    PreparedStatement pstmt = Db.getConnection().prepareStatement(expression);
//
//                    pstmt.setName(1, domainObject.getName());
//                    pstmt.setInt(2, domainObject.getId());
//
//
//                    pstmt.executeUpdate();
//
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void deleteDomainObject(DomainObject d)   {
//        super.delete(d,"Equipment");
//    }
//
//    @Override
//    public boolean isReadyToTransaction(DomainObject d) {
//        Equipment equipment= (Equipment) d;
//        if (equipment.getName()!=null
//                ) {
//            return true;
//        }
//
//        return false;
//    }
//
//    @Override
//    public void getDomainList(ObservableList list)   {
//
//        String expression="SELECT * FROM " +"Equipment"+" ORDER BY ID";
//
//        try {
//            Statement stmt  = Db.getConnection().createStatement();
//
//            ResultSet rs    = stmt.executeQuery(expression);
//
//
//            while (rs.next()) {
//
//                Equipment pojo=new Equipment();
//
//                int id=rs.getInt("id");
//                pojo.setId(id);
//
//                pojo.setName(rs.getString("name"));
//
//                setStoredId(id);
//
//                list.add(pojo);
//
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void getDomainListForAccessoryTable(ObservableList list, DomainObject selectedDomainObject) {
//
//    }
//
//
//}
