package basisFx.domainModel.mapper;

import basisFx.appCore.dataSource.DataMapper;
import basisFx.appCore.dataSource.Db;
import basisFx.appCore.domainScetch.DomainObject;
import basisFx.domainModel.domaine.RatePerHour;
import javafx.collections.ObservableList;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RatePerHourTemplatesMapper extends DataMapper {
    private static RatePerHourTemplatesMapper ourInstance = new RatePerHourTemplatesMapper();

    public static RatePerHourTemplatesMapper getInstance() {
        return ourInstance;
    }

    @Override
    public boolean isReadyToTransaction(DomainObject d) {
        RatePerHour ratePerHour = (RatePerHour) d;
        if (
                 ratePerHour.getName()!=null

                ) {

            return true;
        }

        return false;
    }

    @Override
    public void getDomainList(ObservableList list)   {

        try {
            String expression="SELECT * FROM " +"RateTemplates"+" ORDER BY ID";

            Statement stmt  = Db.getConnection().createStatement();

            ResultSet rs    = stmt.executeQuery(expression);


            while (rs.next()) {

                RatePerHour pojo=new RatePerHour();
                pojo.setId(rs.getInt("id"));
                pojo.setName(String.valueOf(rs.getDouble("rate")));

                //вставляю id в список хранимых в бд
                this.unitOfWork.getStoredPojoesId().add(rs.getInt("id"));

                list.add(pojo);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void getDomainListForObserverTables(ObservableList list, DomainObject selectedDomainObject) {

    }

    @Override
    public void updateDomainObject(DomainObject d)   {

        try {
            if (isReadyToTransaction(d)) {
                RatePerHour ratePerHour = (RatePerHour) d;
                String expression = "UPDATE " + "RATETEMPLATES" + " SET  " +
                        " rate = ?" +
                        " where id=? ";

                PreparedStatement pstmt = null;

                    pstmt = Db.getConnection().prepareStatement(expression);

                    pstmt.setInt(2, ratePerHour.getId());
                    pstmt.setDouble(1, Double.valueOf(ratePerHour.getName()));

                    pstmt.executeUpdate();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDomainObject(DomainObject d)   {
        super.delete(d,"RateTemplates");
    }


    @Override
    public void insertDomainObject(DomainObject d)   {
        try {
            RatePerHour ratePerHour= (RatePerHour) d;

            String expression= "INSERT INTO "+ "RateTemplates "
                    + "(rate "
                    + ") VALUES(?)";

            PreparedStatement pstmt =  Db.getConnection().prepareStatement(expression);
            pstmt.setDouble(1, Double.valueOf(ratePerHour.getName()));


            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
