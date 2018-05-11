package basisFx.domainModel.mapper;

import basisFx.appCore.dataSource.DataMapper;
import basisFx.appCore.dataSource.Db;
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

    private  ObservableList <DomainObject> currencyList =null;
    private Counterparty domainObject;
    private static CounterpartyDataMapper ourInstance = new CounterpartyDataMapper();

    @Override
    public boolean isReadyToTransaction(DomainObject d) {
        Counterparty counterparty= (Counterparty) d;
        if (counterparty.getCurrency()!=null
                &&counterparty.getName()!=null) {
            System.out.println("!!!!!!!!!!!!!!CounterpartyDataMapper --- объект готов к транзакции");
            return true;
        }

        System.out.println("!!!!!!!!!!!!!!CounterpartyDataMapper --- объект НЕ готов к транзакции");

        return false;
    }

    @Override
    public void getAllDomainObjectList(ObservableList list) {

        getCurrencyList();

        try {

            String expression="SELECT * FROM " +"Counterparty"+" ORDER BY ID";

            Statement stmt  = Db.getConnection().createStatement();

            ResultSet rs    = stmt.executeQuery(expression);


            while (rs.next()) {

                Counterparty pojo=new Counterparty();
                pojo.setId(rs.getInt("id"));
                pojo.setName(rs.getString("name"));

                int currencyId=rs.getInt("currencyId");




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
            Logger.getLogger(EquipmentDM.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public DataMapper getAllDomainObjectList() {
        getAllDomainObjectList(list);
        return this;
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

    public  ObservableList <DomainObject> getCurrencyList() {

        if (currencyList != null) {
            return currencyList;
        }else {
            getCurrencyListFromStore();
            return currencyList;

        }
    }

    @Override
    public void updateDomainObject(DomainObject d) {


        Counterparty counterparty= (Counterparty) d;

        if(isReadyToTransaction(counterparty)) {


            String expression = "UPDATE " + "Counterparty" + " SET  " +
                    " name = ?," +
                    " currencyId = ?" +
                    " WHERE id= ?";

            PreparedStatement pstmt = null;
            try {
                pstmt = Db.getConnection().prepareStatement(expression);

                pstmt.setString(1, counterparty.getName());
                pstmt.setInt(2, counterparty.getCurrency().getId());
                pstmt.setInt(3, counterparty.getId());


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
                        + "currencyId"
                        + ") VALUES(?,?,?)";

                PreparedStatement pstmt = Db.getConnection().prepareStatement(expression);
                pstmt.setString(1, domainObject.getName());
                pstmt.setInt(2, domainObject.getCurrency().getId());


                pstmt.executeUpdate();


            } catch (SQLException ex) {
                Logger.getLogger(EquipmentDM.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
