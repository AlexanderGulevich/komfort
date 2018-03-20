package basisFx.domainModel.mapper;

import basisFx.appCore.dataSource.DataMapper;
import basisFx.appCore.dataSource.Db;
import basisFx.appCore.domainScetch.NamedDomainObject;
import basisFx.domainModel.pojo.Counterparty;
import basisFx.domainModel.pojo.Country;
import basisFx.domainModel.pojo.Currency;
import basisFx.appCore.domainScetch.DomainObject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by AlexanderGulevich on 11.03.2018.
 *
 * @autor AlexanderGulevich
 */
public class CounterpartyDataMapper extends DataMapper {

    private  ObservableList <NamedDomainObject> currencyList =null;
    private  ObservableList <NamedDomainObject> countryList =null;
    private Counterparty domainObject;
    private static CounterpartyDataMapper ourInstance = new CounterpartyDataMapper();

    @Override
    public void getAllDomainObjectList(ObservableList list, String tableName) {

        try {

            String expression="SELECT * FROM " +tableName+" ORDER BY ID";

            Statement stmt  = Db.getConnection().createStatement();

            ResultSet rs    = stmt.executeQuery(expression);


            while (rs.next()) {

                Counterparty pojo=new Counterparty();
                pojo.setId(rs.getInt("id"));
                pojo.setName(rs.getString("name"));


                int сountryId=rs.getInt("countryId");
                int currencyId=rs.getInt("currencyId");

                Country currentCountry;
                Currency currentCurrency;

                for (Iterator iterator = countryList.iterator(); iterator.hasNext(); ) {
                    Country next = (Country) iterator.next();

                    if (сountryId==next.getId()){

                        pojo.setCountry(next);

                    }
                }


                for (Iterator iterator = currencyList.iterator(); iterator.hasNext(); ) {
                    Currency next = (Currency) iterator.next();

                    if (currencyId==next.getId()){

                        pojo.setCurrency(next);

                    }
                }

                //вставляю id в список хранимых в бд
                this.unitOfWork.getStoredPojoesId().add(rs.getInt("id"));

                list.add(pojo);



            }

        } catch (SQLException ex) {
            Logger.getLogger(EquipmentDataMapper.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
    private void getCurrencyListFromStore() {

        String expression="SELECT * FROM " +"Currency"+" ORDER BY ID";
        Statement stmt  = null;
        currencyList = FXCollections.<NamedDomainObject>observableArrayList();

        try {

            stmt = Db.getConnection().createStatement();

            ResultSet rs    = stmt.executeQuery(expression);

            while (rs.next()) {
                Currency domainObject = new Currency();
                domainObject.setId(rs.getInt("id"));
                domainObject.setName(rs.getString("name"));

                currencyList.add(domainObject);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    private void getCountryListFromStore() {
        String expression="SELECT * FROM " +"Country"+" ORDER BY ID";
        Statement stmt  = null;
        countryList = FXCollections.<NamedDomainObject>observableArrayList();

        try {

            stmt = Db.getConnection().createStatement();

            ResultSet rs    = stmt.executeQuery(expression);

            while (rs.next()) {
                Country domainObject = new Country();
                domainObject.setId(rs.getInt("id"));
                domainObject.setName(rs.getString("name"));

                countryList.add(domainObject);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }




    }
    public  ObservableList <NamedDomainObject> getCurrencyList() {

        if (currencyList != null) {

            return currencyList;
        }else {
            getCurrencyListFromStore();

            return currencyList;

        }
    }
    public  ObservableList <NamedDomainObject>  getCountryList() {

        if (countryList != null) {

            return countryList;
        }else {
            getCountryListFromStore();

            return countryList;

        }
    }
    @Override
    public void updateDomainObject(DomainObject d) {

    }
    @Override
    public void insertDomainObject(DomainObject d) {
        domainObject=(Counterparty) d;

        try {
            String expression= "INSERT INTO "+ d.getTableName()
                    + "(name ,"
                    + "countryId"
                    + "currencyId"
                    + "id"
                    + ") VALUES(?,?,?,?)";

            PreparedStatement pstmt =  Db.getConnection().prepareStatement(expression);
            pstmt.setString(1, domainObject.getName());
            pstmt.setInt(2, domainObject.getCountry().getId());
            pstmt.setInt(3, domainObject.getCurrency().getId());
            pstmt.setInt(4, domainObject.getId());

            pstmt.executeUpdate();


        } catch (SQLException ex) {
            Logger.getLogger(EquipmentDataMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
