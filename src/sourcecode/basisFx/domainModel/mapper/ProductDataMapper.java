package basisFx.domainModel.mapper;

import basisFx.appCore.dataSource.DataMapper;
import basisFx.appCore.dataSource.Db;
import basisFx.appCore.domainScetch.DomainObject;
import basisFx.appCore.domainScetch.StringValueDomainObject;
import basisFx.domainModel.domaine.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductDataMapper  extends DataMapper{

    private ObservableList <StringValueDomainObject> rodWidthList;

    @Override
    public boolean isReadyToTransaction(DomainObject d) {
        Product product= (Product) d;
        if (
                product.getName() != null &&
                product.getNumberFromRods() != null &&
                product.getRod().getStringValue() != null

                ) {
            return true;


        }

        return false;
    }

    @Override
    public void getAllDomainObjectList(ObservableList list) {

        getRodWidthList();


        try {

            String expression="SELECT * FROM " +"Product"+" ORDER BY ID";

            Statement stmt  = Db.getConnection().createStatement();

            ResultSet rs    = stmt.executeQuery(expression);


            while (rs.next()) {


                Product pojo=new Product();
                pojo.setId(rs.getInt("id"));
                pojo.setName(rs.getString("name"));
                pojo.setNumberFromRods(Integer.toString(rs.getInt("numberFromRods")));
                pojo.setRod(findRodWidth(rs.getInt("equipmentId")));

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

    @Override
    public void updateDomainObject(DomainObject d) {

        if(isReadyToTransaction(d)) {

            Product product= (Product) d;
            String expression = "UPDATE "+    "Product"+ " SET  " +
                    " name = ?," +
                    " equipmentId = ?, " +
                    " numberFromRods = ? " +
                    " WHERE id= ?" ;

            PreparedStatement pstmt = null;

            try {
                pstmt = Db.getConnection().prepareStatement(expression);
                pstmt.setString(1, product.getName());
                pstmt.setInt(2, product.getRod().getId());
                pstmt.setInt(3, Integer.valueOf(product.getNumberFromRods()));
                pstmt.setInt(4, product.getId());
                pstmt.executeUpdate();


            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }

    @Override
    public void insertDomainObject(DomainObject d) {

        Product product= (Product) d;

        if(isReadyToTransaction(d)) {


            try {
                String expression = "INSERT INTO " + "Product "
                        + "("
                        + " name ,  "
                        + " equipmentId, "
                        + " numberFromRods "
                        + ") VALUES(?,?,?)";

                PreparedStatement pstmt = Db.getConnection().prepareStatement(expression);
                pstmt.setString(1, product.getName());
                pstmt.setInt(2, product.getRod().getId());
                pstmt.setInt(3, Integer.valueOf((product.getNumberFromRods())));


                pstmt.executeUpdate();


            } catch (SQLException ex) {
                Logger.getLogger(EquipmentDM.class.getName()).log(Level.SEVERE, null, ex);
            }
        }





    }

    public  ObservableList <StringValueDomainObject>  getRodWidthList() {

        if (rodWidthList != null) {
            return rodWidthList;
        }else {
            getRodWidthListFromStore();
            return rodWidthList;

        }
    }

    private void getRodWidthListFromStore() {
        String expression="SELECT * FROM Equipment ORDER BY ID";
        Statement stmt  = null;
        rodWidthList = FXCollections.<StringValueDomainObject>observableArrayList();

        try {

            stmt = Db.getConnection().createStatement();

            ResultSet rs    = stmt.executeQuery(expression);

            while (rs.next()) {
                StringValueDomainObject domainObject = new StringValueDomainObject();
                domainObject.setId(rs.getInt("id"));
                domainObject.setStringValue(Integer.toString(rs.getInt("rodWidth")));

                rodWidthList.add(domainObject);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    private StringValueDomainObject findRodWidth(int id){

        for (StringValueDomainObject d:rodWidthList) {

            if (id==d.getId()) return d;

        }

        return null;
    }


}
