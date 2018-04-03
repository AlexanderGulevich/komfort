package basisFx.domainModel.mapper;

import basisFx.appCore.dataSource.DataMapper;
import basisFx.appCore.dataSource.Db;
import basisFx.appCore.domainScetch.DomainObject;
import basisFx.appCore.domainScetch.NamedDomainObject;
import basisFx.domainModel.pojo.Employees;
import basisFx.domainModel.pojo.RatePerHour;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeesDataMapper extends DataMapper {

    private  ObservableList <RatePerHour> ratePerHoursList =null;
    private static EmployeesDataMapper ourInstance = new EmployeesDataMapper();

    public static EmployeesDataMapper getInstance() {
        return ourInstance;
    }

    private EmployeesDataMapper() {
    }


    @Override
    public void getAllDomainObjectList(ObservableList list, String tableName) {
        try {

            String expression="SELECT * FROM " +tableName+" ORDER BY ID";

            Statement stmt  = Db.getConnection().createStatement();

            ResultSet rs    = stmt.executeQuery(expression);


            while (rs.next()) {

                Employees pojo=new Employees();
                pojo.setId(rs.getInt("id"));
                pojo.setName(rs.getString("name"));
                pojo.setIsFired(rs.getBoolean("isFired"));

                RatePerHour ratePerHour=getActualRatePerHoursFromStore(rs.getInt("id"));

                pojo.setRatePerHour(ratePerHour);
                pojo.setStartingRateDate(ratePerHour.getStartingRateDate());

                //вставляю id в список хранимых в бд
                this.unitOfWork.getStoredPojoesId().add(rs.getInt("id"));

//                list.add(pojo);
                list.add(null);



            }

        } catch (SQLException ex) {
            Logger.getLogger(EquipmentDataMapper.class.getName()).log(Level.SEVERE, null, ex);
        }


    }


    @Override
    public void updateDomainObject(DomainObject d) {

    }

    @Override
    public void insertDomainObject(DomainObject d) {

    }

    public void getRateList(DomainObject d) {

    }


    public  ObservableList <RatePerHour> getRateList() {

        if (ratePerHoursList != null) {
            System.out.println("EmployeesDataMapper.getRateList -----ratePerHoursList = null");
            return ratePerHoursList;
        }else {
            System.out.println("EmployeesDataMapper.getRateList---ratePerHoursList = null");
            getRatePerHoursListFromStore();
            return ratePerHoursList;

        }
    }

    private void getRatePerHoursListFromStore() {

        String expression="SELECT * FROM " +"RatePerHour"+" ORDER BY ID";
        Statement stmt  = null;
        ratePerHoursList = FXCollections.<RatePerHour>observableArrayList();

        try {

            stmt = Db.getConnection().createStatement();

            ResultSet rs    = stmt.executeQuery(expression);

            while (rs.next()) {
                RatePerHour domainObject = new RatePerHour();
                domainObject.setId(rs.getInt("id"));
                domainObject.setValue(rs.getDouble("ratePerHour"));

                ratePerHoursList.add(domainObject);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    private RatePerHour getActualRatePerHoursFromStore(int emploeerId) {

        String expression="SELECT * FROM " +"RatePerHourStory"+" ORDER BY ID";
        Statement stmt  = null;
        ratePerHoursList = FXCollections.<RatePerHour>observableArrayList();

        try {

            stmt = Db.getConnection().createStatement();

            ResultSet rs    = stmt.executeQuery(expression);

            while (rs.next()) {
                RatePerHour domainObject = new RatePerHour();
                domainObject.setId(rs.getInt("id"));
                domainObject.setValue(rs.getDouble("ratePerHour"));

                ratePerHoursList.add(domainObject);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }









}
