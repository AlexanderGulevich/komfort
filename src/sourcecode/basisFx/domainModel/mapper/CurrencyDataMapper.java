package basisFx.domainModel.mapper;

import basisFx.appCore.dataSource.DataMapper;
import basisFx.appCore.dataSource.Db;

import basisFx.appCore.domainScetch.DomainObject;
import basisFx.domainModel.domaine.Currency;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by AlexanderGulevich on 24.03.2018.
 *
 * @autor AlexanderGulevich
 */
public class CurrencyDataMapper extends DataMapper {


    private Currency domainObject;
    private static CurrencyDataMapper ourInstance = new CurrencyDataMapper();

    public static CurrencyDataMapper getInstance() {
        return ourInstance;
    }


    @Override
    public boolean isReadyToTransaction(DomainObject d) {
        domainObject = (Currency) d;

        if (domainObject.getName() != null) {
            return true;
        }
        return false;
    }



    @Override
    public void getDomainList(ObservableList list) throws SQLException {

            String expression="SELECT * FROM " +"Currency"+" ORDER BY ID";

            Statement stmt  = Db.getConnection().createStatement();

            ResultSet rs    = stmt.executeQuery(expression);


            while (rs.next()) {

                Currency pojo=new Currency();
                pojo.setId(rs.getInt("id"));
                pojo.setName(rs.getString("name"));


                if (unitOfWork != null) {
                    unitOfWork.getStoredPojoesId().add(rs.getInt("id"));

                }

                list.add(pojo);

            }

    }

    @Override
    public void getDomainListForObserverTables(ObservableList list, DomainObject selectedDomainObject) {

    }


    @Override
    public void updateDomainObject(DomainObject d) throws SQLException {


        if(isReadyToTransaction(d)) {

                domainObject = (Currency) d;


                String expression = "UPDATE " + " Currency " +
                        " SET  name = ? WHERE id= ?";


                PreparedStatement pstmt = Db.getConnection().prepareStatement(expression);

                pstmt.setString(1, domainObject.getName());
                pstmt.setInt(2, domainObject.getId());


                pstmt.executeUpdate();

        }
    }

    @Override
    public void deleteDomainObject(DomainObject d) throws SQLException {
        super.deleteForBoundTables(d,"Currency","ExchangeRates");
    }

    @Override
    public void insertDomainObject(DomainObject d) throws SQLException {

        domainObject=(Currency) d;

        if(isReadyToTransaction(d)) {

                String expression = "INSERT INTO " + " Currency "
                        + "(name) VALUES(?)";

                PreparedStatement pstmt = Db.getConnection().prepareStatement(expression);
                pstmt.setString(1, domainObject.getName());

                pstmt.executeUpdate();

        }
    }



}
