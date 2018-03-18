package basisFx.domainModel.mapper;

import basisFx.appCore.dataSource.DataMapper;
import basisFx.appCore.dataSource.Db;
import basisFx.domainModel.pojo.Counterparty;
import basisFx.domainModel.pojo.Country;
import basisFx.domainModel.pojo.Currency;
import basisFx.appCore.domainScetch.DomainObject;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by AlexanderGulevich on 11.03.2018.
 *
 * @autor AlexanderGulevich
 */
public class CounterpartyDataMapper extends DataMapper {

    private static Map<String,Currency> currencyMapByName=null;
    private static Map<String,Country> countryMapByName=null;
    private static Map<Integer,Currency> currencyMapById=null;
    private static Map<Integer,Country> countryMapById=null;
    private Counterparty domainObject;
    private static CounterpartyDataMapper ourInstance = new CounterpartyDataMapper();
    public static CounterpartyDataMapper getInstance() {
        return ourInstance;
    }
    private CounterpartyDataMapper() {}

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
                pojo.setCountryId(rs.getInt("countryId"));
                pojo.setCurrencyId(rs.getInt("currencyId"));

                //вставляю id в список хранимых в бд
                this.unitOfWork.getStoredPojoesId().add(rs.getInt("id"));

                list.add(pojo);



            }

        } catch (SQLException ex) {
            Logger.getLogger(EquipmentDataMapper.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
    private void getCurrencyMapFromStoreByName() {

        String expression="SELECT * FROM " +"Currency"+" ORDER BY ID";
        Statement stmt  = null;
        currencyMapByName=new HashMap<>();
        try {

            stmt = Db.getConnection().createStatement();

            ResultSet rs    = stmt.executeQuery(expression);

            while (rs.next()) {
                Currency domainObject = new Currency();
                domainObject.setId(rs.getInt("id"));
                domainObject.setName(rs.getString("name"));


                currencyMapByName.put(rs.getString("name"),  domainObject);
//                currencyMap.put(rs.getInt("id"),  domainObject);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    private void getCountryMapFromStoreById() {
        String expression="SELECT * FROM " +"Country"+" ORDER BY ID";
        Statement stmt  = null;
        countryMapById  =new HashMap<>();
        try {

            stmt = Db.getConnection().createStatement();

            ResultSet rs    = stmt.executeQuery(expression);

            while (rs.next()) {
                Country domainObject = new Country();
                domainObject.setId(rs.getInt("id"));
                domainObject.setName(rs.getString("name"));


                countryMapById.put(rs.getInt("id"),  domainObject);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }




    }
    private void getCurrencyMapFromStoreById() {

        String expression="SELECT * FROM " +"Currency"+" ORDER BY ID";
        Statement stmt  = null;
        currencyMapById=new HashMap<>();
        try {

            stmt = Db.getConnection().createStatement();

            ResultSet rs    = stmt.executeQuery(expression);

            while (rs.next()) {
                Currency domainObject = new Currency();
                domainObject.setId(rs.getInt("id"));
                domainObject.setName(rs.getString("name"));


                currencyMapById.put(rs.getInt("id"),  domainObject);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    private void getCountryMapFromStoreByName() {
        String expression="SELECT * FROM " +"Country"+" ORDER BY ID";
        Statement stmt  = null;
        countryMapByName=new HashMap<>();
        try {

            stmt = Db.getConnection().createStatement();

            ResultSet rs    = stmt.executeQuery(expression);

            while (rs.next()) {
                Country domainObject = new Country();
                domainObject.setId(rs.getInt("id"));
                domainObject.setName(rs.getString("name"));



                countryMapByName.put(rs.getString("name"),  domainObject);

//                countryMap.put(rs.getInt("id"),  domainObject);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }




    }
    public  Map<String,Currency>  getCurrencyMapByName() {

        if (currencyMapByName != null) {

            return currencyMapByName;

        }else {

            getCurrencyMapFromStoreByName();
            return currencyMapByName;

        }

    }
    public  Map<String,Country> getCountryMapByName() {

        if (countryMapByName != null) {

            return countryMapByName;
        }else {
            getCountryMapFromStoreByName();

            return countryMapByName;

        }
    }
    public  Map<Integer,Currency>  getCurrencyMapById() {

        if (currencyMapById != null) {

            return currencyMapById;

        }else {

            getCurrencyMapFromStoreByName();
            return currencyMapById;

        }

    }
    public  Map<Integer,Country>  getCountryMapById() {

        if (countryMapById != null) {

            return countryMapById;
        }else {
            getCountryMapFromStoreByName();

            return countryMapById;

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
            pstmt.setInt(2, domainObject.getCountryId());
            pstmt.setInt(3, domainObject.getCurrencyId());
            pstmt.setInt(4, domainObject.getId());

            pstmt.executeUpdate();


        } catch (SQLException ex) {
            Logger.getLogger(EquipmentDataMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
