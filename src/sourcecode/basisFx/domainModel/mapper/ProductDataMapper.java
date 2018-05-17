package basisFx.domainModel.mapper;

import basisFx.appCore.dataSource.DataMapper;
import basisFx.appCore.dataSource.Db;
import basisFx.appCore.domainScetch.BoolComboBox;
import basisFx.appCore.domainScetch.DomainObject;
import basisFx.domainModel.domaine.Product;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductDataMapper  extends DataMapper{


    @Override
    public boolean isReadyToTransaction(DomainObject d) {
        Product product= (Product) d;
        if (
                product.getName() != null &&
                product.getSleeve() != null
                ) {
            return true;
        }
        return false;
    }

    @Override
    public void getDomainList(ObservableList list)   {

        try {
            String expression="SELECT * FROM " +"Product"+" ORDER BY ID";

            Statement stmt  = Db.getConnection().createStatement();

            ResultSet rs    = stmt.executeQuery(expression);

            while (rs.next()) {

                Product pojo=new Product();
                pojo.setId(rs.getInt("id"));
                pojo.setName(rs.getString("name"));
                pojo.setSleeve(new BoolComboBox(rs.getBoolean("sleeve") )  );

                //вставляю id в список хранимых в бд
                if (unitOfWork != null) {
                    this.unitOfWork.getStoredPojoesId().add(rs.getInt("id"));
                }

                list.add(pojo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getDomainListForObserverTables(ObservableList list, DomainObject selectedDomainObject) {

    }

    @Override
    public void updateDomainObject(DomainObject d)   {

        try {
            if(isReadyToTransaction(d)) {

                Product product= (Product) d;
                String expression = "UPDATE "+    "Product"+ " SET  " +
                        " name = ?," +
                        " sleeve = ? " +
                        " WHERE id= ?" ;

                PreparedStatement pstmt = null;

                    pstmt = Db.getConnection().prepareStatement(expression);
                    pstmt.setString(1, product.getName());
                    pstmt.setBoolean(2, product.getSleeve().getBoolean());
                    pstmt.setInt(3, product.getId());
                    pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDomainObject(DomainObject d)   {
        super.deleteForBoundTables(d,"Product","ProductPriceStore");
    }

    @Override
    public void insertDomainObject(DomainObject d)   {

        try {
            Product product= (Product) d;

            if(isReadyToTransaction(d)) {

                    String expression = "INSERT INTO " + "Product "
                            + "("
                            + " name ,  "
                            + " sleeve "
                            + ") VALUES(?,?)";

                    PreparedStatement pstmt = Db.getConnection().prepareStatement(expression);
                    pstmt.setString(1, product.getName());
                    pstmt.setBoolean(2, product.getSleeve().getBoolean());



                    pstmt.executeUpdate();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
