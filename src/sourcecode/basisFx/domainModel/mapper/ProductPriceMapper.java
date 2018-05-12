package basisFx.domainModel.mapper;

import basisFx.appCore.dataSource.DataMapper;
import basisFx.appCore.dataSource.Db;
import basisFx.appCore.domainScetch.DomainObject;
import basisFx.domainModel.domaine.Price;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductPriceMapper extends DataMapper {
    @Override
    public boolean isReadyToTransaction(DomainObject d) {
        Price price = (Price) d;

        if (
                price.getPrice()!= null
                        && price.getStartingDate() !=null

                ) {

            return true;
        }

        return false;

    }


    @Override
    public void getAllDomainObjectList(ObservableList list) {

    }

    @Override
    public void getAllDomainObjectList(ObservableList list, DomainObject selectedDomainObject) {
        int id=selectedDomainObject.getId();

        try {

            String expression="SELECT * FROM " +"ProductPriceStore "+" where productId= " +id+" ORDER BY startDate desc";

            Statement stmt  = Db.getConnection().createStatement();

            ResultSet rs    = stmt.executeQuery(expression);

            while (rs.next()) {

                Price pojo=new Price();
                pojo.setId(rs.getInt("id"));

                pojo.setProductId(rs.getInt("productId"));
                pojo.setPrice( Double.toString(rs.getDouble("price")));
                pojo.setStartingDate(rs.getDate("startDate").toLocalDate());

                //вставляю id в список хранимых в бд
                this.unitOfWork.getStoredPojoesId().add(rs.getInt("id"));

                list.add(pojo);

            }

        } catch (SQLException ex) {
            Logger.getLogger(EquipmentDM.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    @Override
    public void updateDomainObject(DomainObject d) {
        if(isReadyToTransaction(d)) {
            System.out.println("Price.updateDomainObject".toUpperCase());

            Price price= (Price) d;

            String expression = "UPDATE "+    "ProductPriceStore"+ " SET  " +
                    " price = ?," +
                    " startDate = ?," +
                    " productId = ? " +
                    " where id =?";

            PreparedStatement pstmt = null;

            try {
                pstmt = Db.getConnection().prepareStatement(expression);

                pstmt.setDouble(1, Double.valueOf(price.getPrice()));
                pstmt.setDate(2, Date.valueOf(price.getStartingDate()));
                pstmt.setInt(3, price.getProductId());
                pstmt.setInt(4, price.getId());
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void insertDomainObject(DomainObject d) {
        Price domainObject=(Price) d;

        if(isReadyToTransaction(d)) {


            try {
                String expression = "INSERT INTO " + "ProductPriceStore "
                        + "("
                        + " price ,  "
                        + " startDate,  "
                        + " productId        "
                        + ") VALUES(?,?,?)";

                PreparedStatement pstmt = Db.getConnection().prepareStatement(expression);

                pstmt.setDouble(1, Double.valueOf(domainObject.getPrice()));
                pstmt.setDate(2, Date.valueOf(domainObject.getStartingDate()));
                pstmt.setInt(3, getObservableDomaineId());

                pstmt.executeUpdate();


            } catch (SQLException ex) {
                Logger.getLogger(EquipmentDM.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }



}
