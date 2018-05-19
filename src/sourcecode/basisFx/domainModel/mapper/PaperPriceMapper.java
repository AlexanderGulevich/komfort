package basisFx.domainModel.mapper;

import basisFx.appCore.dataSource.DataMapper;
import basisFx.appCore.dataSource.Db;
import basisFx.appCore.domainScetch.DomainObject;
import basisFx.domainModel.domaine.Price;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PaperPriceMapper extends DataMapper {


    private static PaperPriceMapper ourInstance = new PaperPriceMapper();

    public static PaperPriceMapper getInstance() {
        return ourInstance;
    }

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
    public void getDomainList(ObservableList list) {

    }

    @Override
    public void getDomainListForObserverTables(ObservableList list, DomainObject selectedDomainObject)   {

        try {
            int selectedDomainObjectId=selectedDomainObject.getId();

            String expression="SELECT * FROM " +"PaperPriceStore "+" where productId= " +selectedDomainObjectId+" ORDER BY startDate desc";

            Statement stmt  = Db.getConnection().createStatement();

            ResultSet rs    = stmt.executeQuery(expression);

            while (rs.next()) {

                Price pojo=new Price();

                int id=rs.getInt("id");
                pojo.setId(id);


                pojo.setProductId(rs.getInt("productId"));
                pojo.setPrice( Double.toString(rs.getDouble("price")));
                pojo.setStartingDate(rs.getDate("startDate").toLocalDate());

                setStoredId(id);

                list.add(pojo);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateDomainObject(DomainObject d)   {

        if(isReadyToTransaction(d)) {

            Price price= (Price) d;

            String expression = "UPDATE "+    "PaperPriceStore"+ " SET  " +
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
    public void deleteDomainObject(DomainObject d)   {
        super.delete(d, "PaperPriceStore");
    }

    @Override
    public void insertDomainObject(DomainObject d)   {
        Price domainObject=(Price) d;

        try {
            if(isReadyToTransaction(d)) {

                    String expression = "INSERT INTO " + "PaperPriceStore "
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

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
