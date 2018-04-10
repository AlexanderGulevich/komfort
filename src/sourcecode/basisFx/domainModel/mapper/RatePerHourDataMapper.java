package basisFx.domainModel.mapper;

import basisFx.appCore.dataSource.DataMapper;
import basisFx.appCore.dataSource.Db;
import basisFx.appCore.domainScetch.DomainObject;
import basisFx.domainModel.pojo.RatePerHour;
import javafx.collections.ObservableList;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RatePerHourDataMapper extends DataMapper {
    private static RatePerHourDataMapper ourInstance = new RatePerHourDataMapper();

    public static RatePerHourDataMapper getInstance() {
        return ourInstance;
    }

    @Override
    public void getAllDomainObjectList(ObservableList list, String tableName) {
        try {

            String expression="SELECT * FROM " +"RateTemplates"+" ORDER BY ID";

            Statement stmt  = Db.getConnection().createStatement();

            ResultSet rs    = stmt.executeQuery(expression);


            while (rs.next()) {

                RatePerHour pojo=new RatePerHour();
                pojo.setId(rs.getInt("id"));
                pojo.setStringValue(String.valueOf(rs.getDouble("rate")));

                //вставляю id в список хранимых в бд
                this.unitOfWork.getStoredPojoesId().add(rs.getInt("id"));

                list.add(pojo);



            }

        } catch (SQLException ex) {
            Logger.getLogger(EquipmentDataMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void updateDomainObject(DomainObject d) {
        RatePerHour ratePerHour= (RatePerHour) d;
        String expression = "UPDATE "+ "RATETEMPLATES"+ " SET  " +
                " id = ?," +
                " rate = ?" ;

        PreparedStatement pstmt = null;
        try {
            pstmt = Db.getConnection().prepareStatement(expression);

            pstmt.setInt(1, ratePerHour.getId());
            pstmt.setDouble(2, Double.valueOf(ratePerHour.getStringValue()));

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void insertDomainObject(DomainObject d) {
        RatePerHour ratePerHour= (RatePerHour) d;
        try {
            String expression= "INSERT INTO "+ "RateTemplates "
                    + "(rate "
                    + ") VALUES(?)";

            PreparedStatement pstmt =  Db.getConnection().prepareStatement(expression);
            pstmt.setDouble(1, Double.valueOf(ratePerHour.getStringValue()));


            pstmt.executeUpdate();


        } catch (SQLException ex) {
            Logger.getLogger(EquipmentDataMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
