package basisFx.domainModel.mapper;

import basisFx.appCore.dataSource.DataMapper;
import basisFx.appCore.dataSource.Db;
import basisFx.appCore.domainScetch.ComboBoxValue;
import basisFx.domainModel.domaine.Counterparty;
import basisFx.domainModel.domaine.Currency;
import basisFx.appCore.domainScetch.DomainObject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by AlexanderGulevich on 11.03.2018.
 *
 * @autor AlexanderGulevich
 */
public class CounterpartyDataMapper extends DataMapper {

    private static CounterpartyDataMapper ourInstance = new CounterpartyDataMapper();

    @Override
    public boolean isReadyToTransaction(DomainObject d) {
        Counterparty counterparty= (Counterparty) d;
        if (counterparty.getCurrency()!=null
                &&counterparty.getName()!=null) {
            return true;
        }
        return false;
    }

    @Override
    public void getDomainList(ObservableList list) throws SQLException {

            String expression="SELECT * FROM " +"Counterparty"+" ORDER BY ID";

            Statement stmt  = Db.getConnection().createStatement();

            ResultSet rs    = stmt.executeQuery(expression);


            while (rs.next()) {

                Counterparty pojo=new Counterparty();
                pojo.setId(rs.getInt("id"));
                pojo.setName(rs.getString("name"));

                int currencyId=rs.getInt("currencyId");


                ComboBoxValue comboBoxValue =  dataMapperFabric
                        .currencyDataMapper()
                        .toComboBoxValHashMap((val)->{return ((Currency)val).getName();})
                        .get(currencyId);


                pojo.setCurrency(comboBoxValue);


                if (unitOfWork != null) {
                    //вставляю id в список хранимых в бд
                    this.unitOfWork.getStoredPojoesId().add(rs.getInt("id"));
                }

                list.add(pojo);

            }

    }


    @Override
    public void getDomainListForObserverTables(ObservableList list, DomainObject selectedDomainObject) {

    }


    @Override
    public void updateDomainObject(DomainObject d) throws SQLException {


        Counterparty counterparty= (Counterparty) d;

        if(isReadyToTransaction(counterparty)) {


            String expression = "UPDATE " + "Counterparty" + " SET  " +
                    " name = ?," +
                    " currencyId = ?" +
                    " WHERE id= ?";

            PreparedStatement pstmt = null;

                pstmt = Db.getConnection().prepareStatement(expression);

                pstmt.setString(1, counterparty.getName());
                pstmt.setInt(2, counterparty.getCurrency().getId());
                pstmt.setInt(3, counterparty.getId());


                pstmt.executeUpdate();
        }

    }

    @Override
    public void deleteDomainObject(DomainObject d) throws SQLException {
        super.delete(d,"Counterparty");
    }

    @Override
    public void insertDomainObject(DomainObject d) throws SQLException {

        if(isReadyToTransaction(d)) {

            Counterparty domainObject = (Counterparty) d;

                String expression = "INSERT INTO " + "Counterparty"
                        + "(name ,"
                        + "currencyId"
                        + ") VALUES(?,?)";

                PreparedStatement pstmt = Db.getConnection().prepareStatement(expression);
                pstmt.setString(1, domainObject.getName());
                pstmt.setInt(2, domainObject.getCurrency().getId());

                pstmt.executeUpdate();

        }

    }

}
