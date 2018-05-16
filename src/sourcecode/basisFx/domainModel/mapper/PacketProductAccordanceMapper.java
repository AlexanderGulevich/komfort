package basisFx.domainModel.mapper;

import basisFx.appCore.dataSource.DataMapper;
import basisFx.appCore.dataSource.Db;
import basisFx.appCore.domainScetch.ComboBoxValue;
import basisFx.appCore.domainScetch.DomainObject;
import basisFx.domainModel.domaine.PacketProductAccordance;
import basisFx.domainModel.domaine.PacketSize;
import basisFx.domainModel.domaine.Product;
import javafx.collections.ObservableList;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PacketProductAccordanceMapper extends DataMapper {

    private static PacketProductAccordanceMapper ourInstance = new PacketProductAccordanceMapper();


    public static PacketProductAccordanceMapper getInstance() {
        return ourInstance;
    }

    @Override
    public boolean isReadyToTransaction(DomainObject d) {
        PacketProductAccordance pojo = (PacketProductAccordance) d;
        if (
                pojo.getSize() != null &&
                        pojo.getProduct() != null &&
                        pojo.getNumber() != null
                ) {
            return true;
        }
        return false;
    }

    @Override
    public void getDomainList(ObservableList list)   {

            String expression = "SELECT * FROM " + "PacketProductAccordance" + " ORDER BY ID";

            Statement stmt = Db.getConnection().createStatement();

            ResultSet rs = stmt.executeQuery(expression);


            while (rs.next()) {

                int packetSizeId = rs.getInt("packetSizeId");
                int productId = rs.getInt("productId");

                PacketSize packetSize =
                        (PacketSize) dataMapperFabric.packetSizeMapper().toHashMapByCommonRawId().get(packetSizeId);
                Product product =
                        (Product) dataMapperFabric.productDataMapper().toHashMapByCommonRawId().get(productId);

                PacketProductAccordance pojo = new PacketProductAccordance();
                pojo.setId(rs.getInt("id"));
                pojo.setSize(new ComboBoxValue(packetSize.getSize(),packetSize.getId()));
                pojo.setProduct(new ComboBoxValue(product.getName(),product.getId()));
                pojo.setNumber(String.valueOf(rs.getInt("number")) );

                //вставляю id в список хранимых в бд
                this.unitOfWork.getStoredPojoesId().add(rs.getInt("id"));

                list.add(pojo);


            }



    }

    @Override
    public void getDomainListForObserverTables(ObservableList list, DomainObject selectedDomainObject) {

    }

    @Override
    public void updateDomainObject(DomainObject d)   {

        if (isReadyToTransaction(d)) {
            PacketProductAccordance pojo = (PacketProductAccordance) d;
            String expression = "UPDATE " + "PacketProductAccordance" + " SET  " +
                    " packetSizeId = ?, " +
                    " productId = ?, " +
                    " number = ? " +
                    " where id=? ";

            PreparedStatement pstmt = null;

                pstmt = Db.getConnection().prepareStatement(expression);

                pstmt.setInt(4, pojo.getId());
                pstmt.setInt(1, pojo.getSize().getId());
                pstmt.setInt(2, pojo.getProduct().getId());
                pstmt.setInt(3, Integer.valueOf(pojo.getNumber()));

                pstmt.executeUpdate();

        }
    }

    @Override
    public void deleteDomainObject(DomainObject d)   {
        super.delete(d,"PacketProductAccordance");
    }

    @Override
    public void insertDomainObject(DomainObject d)   {
        PacketProductAccordance pojo = (PacketProductAccordance) d;

            String expression = "INSERT INTO " + "PacketProductAccordance "
                    + "(packetSizeId,  productId, number "
                    + ") VALUES(?,?,?)";

            PreparedStatement pstmt = Db.getConnection().prepareStatement(expression);
            pstmt.setInt(1, pojo.getSize().getId());
            pstmt.setInt(2, pojo.getProduct().getId());
            pstmt.setInt(3, Integer.valueOf(pojo.getNumber()));


            pstmt.executeUpdate();



    }

}