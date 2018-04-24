package basisFx.domainModel.mapper;

import basisFx.appCore.dataSource.DataMapper;
import basisFx.appCore.dataSource.Db;
import basisFx.appCore.domainScetch.StringValueDomainObject;
import basisFx.domainModel.domaine.Counterparty;
import basisFx.domainModel.domaine.Country;
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

    private  ObservableList <DomainObject> currencyList =null;
    private  ObservableList <DomainObject> countryList =null;
    private Counterparty domainObject;
    private static CounterpartyDataMapper ourInstance = new CounterpartyDataMapper();

    @Override
    public boolean isReadyToTransaction(DomainObject d) {
        Counterparty counterparty= (Counterparty) d;
        if (counterparty.getCountry()!= null
                &&counterparty.getCurrency()!=null
                &&counterparty.getName()!=null) {
            System.out.println("!!!!!!!!!!!!!!CounterpartyDataMapper --- объект готов к транзакции");
            return true;
        }

        System.out.println("!!!!!!!!!!!!!!CounterpartyDataMapper --- объект НЕ готов к транзакции");

        return false;
    }

    @Override
    public void getAllDomainObjectList(ObservableList list) {

        getCountryList();
        getCurrencyList();

        try {

            String expression="SELECT * FROM " +"Counterparty"+" ORDER BY ID";

            Statement stmt  = Db.getConnection().createStatement();

            ResultSet rs    = stmt.executeQuery(expression);


            while (rs.next()) {

                Counterparty pojo=new Counterparty();
                pojo.setId(rs.getInt("id"));
                pojo.setName(rs.getString("name"));

                int сountryId=rs.getInt("countryId");
                int currencyId=rs.getInt("currencyId");



                for (Iterator iterator = countryList.iterator(); iterator.hasNext(); ) {
                    Country next = (Country) iterator.next();

                    if (сountryId==next.getId().intValue()){


                        pojo.setCountry(next);

                    }
                }


                for (Iterator iterator = currencyList.iterator(); iterator.hasNext(); ) {
                    Currency next = (Currency) iterator.next();

                    if (currencyId==next.getId().intValue()){

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

    @Override
    public void getAllDomainObjectList(ObservableList list, DomainObject selectedDomainObject) {

    }

    private void getCurrencyListFromStore() {

        String expression="SELECT * FROM " +"Currency"+" ORDER BY ID";
        Statement stmt  = null;
        currencyList = FXCollections.<DomainObject>observableArrayList();

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
        String expression="SELECT * FROM Country ORDER BY ID";
        Statement stmt  = null;
        countryList = FXCollections.<DomainObject>observableArrayList();

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
    public  ObservableList <DomainObject> getCurrencyList() {

        if (currencyList != null) {
            return currencyList;
        }else {
            getCurrencyListFromStore();
            return currencyList;

        }
    }
    public  ObservableList <DomainObject>  getCountryList() {

        if (countryList != null) {
            return countryList;
        }else {
            getCountryListFromStore();
            return countryList;

        }
    }
    @Override
    public void updateDomainObject(DomainObject d) {


        Counterparty counterparty= (Counterparty) d;

        if(isReadyToTransaction(counterparty)) {


            String expression = "UPDATE " + "Counterparty" + " SET  " +
                    " name = ?," +
                    " countryId = ?," +
                    " currencyId = ?" +
                    " WHERE id= ?";

            PreparedStatement pstmt = null;
            try {
                pstmt = Db.getConnection().prepareStatement(expression);

                pstmt.setString(1, counterparty.getName());
                pstmt.setInt(2, counterparty.getCountry().getId());
                pstmt.setInt(3, counterparty.getCurrency().getId());
                pstmt.setInt(4, counterparty.getId());


                pstmt.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }

            System.out.println("ДАТАМАППЕР CounterpartyDataMapper ОБНОВЛЕНИЕ ОБЪЕКТА");

        }

    }
    @Override
    public void insertDomainObject(DomainObject d) {

        if(isReadyToTransaction(d)) {

            domainObject = (Counterparty) d;

            try {
                String expression = "INSERT INTO " + "Counterparty"
                        + "(name ,"
                        + "countryId,"
                        + "currencyId"
                        + ") VALUES(?,?,?)";

                PreparedStatement pstmt = Db.getConnection().prepareStatement(expression);
                pstmt.setString(1, domainObject.getName());
                pstmt.setInt(2, domainObject.getCountry().getId());
                pstmt.setInt(3, domainObject.getCurrency().getId());


                pstmt.executeUpdate();


            } catch (SQLException ex) {
                Logger.getLogger(EquipmentDataMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
