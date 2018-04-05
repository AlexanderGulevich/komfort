package basisFx.domainModel.mapper;

import basisFx.appCore.dataSource.DataMapper;
import basisFx.appCore.dataSource.Db;
import basisFx.appCore.domainScetch.DomainObject;
import basisFx.appCore.domainScetch.DoubleDomainObject;
import basisFx.domainModel.pojo.Employees;
import basisFx.domainModel.pojo.RatePerHour;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeesDataMapper extends DataMapper {

    private  ObservableList <DoubleDomainObject> ratePerHoursList =null;

    private  ObservableList <Employees> currentEmployees =null;


    @Override
    public void getAllDomainObjectList(ObservableList list, String tableName) {
        try {

            String expression="SELECT * FROM " +"CurrentEmployeesState"+" ORDER BY ID";

            Statement stmt  = Db.getConnection().createStatement();

            ResultSet rs    = stmt.executeQuery(expression);


            while (rs.next()) {

                Employees pojo=new Employees();
                pojo.setId(rs.getInt("id"));
                pojo.setName(rs.getString("name"));
                pojo.setIsFired(rs.getBoolean("isFired"));

//                RatePerHour ratePerHour=getActualRatePerHoursFromStore(rs.getInt("id"));
//
//                pojo.setRatePerHour(ratePerHour);
//                pojo.setStartingRateDate(ratePerHour.getStartingRateDate());

                //вставляю id в список хранимых в бд


                this.unitOfWork.getStoredPojoesId().add(rs.getInt("id"));



//                list.add(pojo);
                list.add(null);

            }

        } catch (SQLException ex) {
            Logger.getLogger(EquipmentDataMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

        currentEmployees=list;


    }


    @Override
    public void updateDomainObject(DomainObject d) {

    }

    @Override
    public void insertDomainObject(DomainObject d) {
        Employees domainObject=(Employees) d;

        try {
            String expression= "INSERT INTO "+ "CurrentEmployeesState "
                    + "(name , "
                    +"rate , "
                    +"startDate  "
                    + ") VALUES(?,?,?)";

            PreparedStatement pstmt =  Db.getConnection().prepareStatement(expression);
            pstmt.setString(1, domainObject.getName());
            pstmt.setDouble(2,((DoubleDomainObject)domainObject.getRatePerHour()).getValue());
            pstmt.setDate(3,  java.sql.Date.from(  Instant.from(domainObject.getStartingRateDate())  ));
//            pstmt.setBoolean(4,domainObject.getIsFired());



            pstmt.executeUpdate();


        } catch (SQLException ex) {
            Logger.getLogger(EquipmentDataMapper.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    public  ObservableList <DoubleDomainObject> getRateList() {

        if (ratePerHoursList != null) {
            System.out.println("EmployeesDataMapper.getRateList -----ratePerHoursList = null");
            return ratePerHoursList;
        }else {
            System.out.println("EmployeesDataMapper.getRateList---ratePerHoursList = null");

            String expression="SELECT * FROM " +"RateExamples"+" ORDER BY ID";
            Statement stmt  = null;
            ratePerHoursList = FXCollections.<DoubleDomainObject>observableArrayList();

            try {

                stmt = Db.getConnection().createStatement();

                ResultSet rs    = stmt.executeQuery(expression);

                while (rs.next()) {
                    DoubleDomainObject domainObject = new DoubleDomainObject();
                    domainObject.setId(rs.getInt("id"));
                    domainObject.setValue(rs.getDouble("rate"));

                    ratePerHoursList.add(domainObject);

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return ratePerHoursList;

        }
    }








}
