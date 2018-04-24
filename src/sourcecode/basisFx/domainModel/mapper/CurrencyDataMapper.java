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
    public void getAllDomainObjectList(ObservableList list) {
        try {

            String expression="SELECT * FROM " +"Currency"+" ORDER BY ID";

            Statement stmt  = Db.getConnection().createStatement();

            ResultSet rs    = stmt.executeQuery(expression);


            while (rs.next()) {

                Currency pojo=new Currency();
                pojo.setId(rs.getInt("id"));
                pojo.setName(rs.getString("name"));

                unitOfWork.getStoredPojoesId().add(rs.getInt("id"));


                list.add(pojo);



            }

        } catch (SQLException ex) {
            Logger.getLogger(EquipmentDataMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void getAllDomainObjectList(ObservableList list, DomainObject selectedDomainObject) {

    }


    @Override
    public void updateDomainObject(DomainObject d) {


        if(isReadyToTransaction(d)) {
            try {
                domainObject = (Currency) d;


                String expression = "UPDATE " + " Currency " +
                        " SET  name = ? WHERE id= ?";


                PreparedStatement pstmt = Db.getConnection().prepareStatement(expression);

                pstmt.setString(1, domainObject.getName());
                pstmt.setInt(2, domainObject.getId());


                pstmt.executeUpdate();

            } catch (SQLException ex) {
                Logger.getLogger(EquipmentDataMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void insertDomainObject(DomainObject d) {

        domainObject=(Currency) d;


        if(isReadyToTransaction(d)) {

            try {
                String expression = "INSERT INTO " + " Currency "
                        + "(name) VALUES(?)";

                PreparedStatement pstmt = Db.getConnection().prepareStatement(expression);
                pstmt.setString(1, domainObject.getName());

                pstmt.executeUpdate();


            } catch (SQLException ex) {
                Logger.getLogger(EquipmentDataMapper.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }



}
