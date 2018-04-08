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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeesDataMapper extends DataMapper {

    private  ObservableList <DoubleDomainObject> rateTamlateList =null;
    private  ObservableList <RatePerHour> ratesStoredList =null;
    private  ObservableList <Employees> currentEmployees =null;
    private  HashMap<Integer,ArrayList<RatePerHour>> ratesMapById =new HashMap<>();


    @Override
    public void getAllDomainObjectList(ObservableList list, String tableName) {

        getRateListFromeStore();
        convertStoredRatesToHashMap();

        try {

            String expression="SELECT * FROM " +"Employees"+" ORDER BY ID";

            Statement stmt  = Db.getConnection().createStatement();

            ResultSet rs    = stmt.executeQuery(expression);


            while (rs.next()) {

                Employees pojo=new Employees();
                pojo.setId(rs.getInt("id"));
                pojo.setName(rs.getString("name"));
                pojo.setIsFired(rs.getBoolean("isFired"));

                RatePerHour rate=getNewest(rs.getInt("id"));

                pojo.setStartingRateDate(rate.getStartingRateDate());

                pojo.setRate(rate);

                //вставляю id в список хранимых в бд
                this.unitOfWork.getStoredPojoesId().add(rs.getInt("id"));

                list.add(pojo);
            }

        } catch (SQLException ex) {
            Logger.getLogger(EquipmentDataMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

        currentEmployees=list;


    }

    private RatePerHour getNewest(Integer id){

        RatePerHour newestRate=null;

        ArrayList<RatePerHour> ratePerHoursList = ratesMapById.get(id);

        for (RatePerHour rate:ratePerHoursList) {

            if (newestRate == null) {

                newestRate=rate;

            }

            if (rate.getStartingRateDate().isAfter(newestRate.getStartingRateDate())){
                newestRate=rate;
            }
        }

        return newestRate;


    }

    private void convertStoredRatesToHashMap() {

        for (RatePerHour rate: ratesStoredList) {

            Integer id=rate.getId();

            if(ratesMapById.containsKey(id)){

                ratesMapById.get(id).add(rate);

            }else {

                ArrayList<RatePerHour> ratePerHoursList=new ArrayList<>();
                ratePerHoursList.add(rate);

                ratesMapById.put(id,ratePerHoursList);

            }
        }

    }

    @Override
    public void updateDomainObject(DomainObject d) {

    }

    @Override
    public void insertDomainObject(DomainObject d) {
        Employees domainObject=(Employees) d;

        int maxId=getMaxEmployersId();

        try {
            String expression= "INSERT INTO "+ "Employees "
                    + "("
                    +" name ,  "
                    +" isFired,  "
                    +" id        "
                    + ") VALUES(?,?,?)";

            PreparedStatement pstmt =  Db.getConnection().prepareStatement(expression);
            pstmt.setString(1, domainObject.getName());
            pstmt.setBoolean(2,domainObject.getIsFired());
            pstmt.setInt(3,maxId+1);

            pstmt.executeUpdate();


            String expression2= "INSERT INTO "+ " RateStore "
                    + "("
                    +" employerId ,  "
                    +" rate,  "
                    +" startDate        "
                    + ") VALUES(?,?,?)";

            PreparedStatement pstmt2 =  Db.getConnection().prepareStatement(expression2);
            pstmt2.setInt(1, maxId+1);
            pstmt2.setDouble(2,((DoubleDomainObject)domainObject.getRate()).getDoubleValue());
            pstmt2.setDate(3,Date.valueOf(  domainObject.getStartingRateDate()));

            pstmt2.executeUpdate();


        } catch (SQLException ex) {
            Logger.getLogger(EquipmentDataMapper.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    public  ObservableList <DoubleDomainObject> getRateTemplateList() {

        if (rateTamlateList != null) {
            System.out.println("EmployeesDataMapper.getRateTemplateList -----rateTamlateList != null");
            return rateTamlateList;
        }else {
            System.out.println("EmployeesDataMapper.getRateTemplateList---rateTamlateList = null");

            String expression="SELECT * FROM " +"RateTemplates"+" ORDER BY ID";
            Statement stmt  = null;
            rateTamlateList = FXCollections.<DoubleDomainObject>observableArrayList();

            try {

                stmt = Db.getConnection().createStatement();

                ResultSet rs    = stmt.executeQuery(expression);

                while (rs.next()) {
                    DoubleDomainObject domainObject = new DoubleDomainObject();
                    domainObject.setId(rs.getInt("id"));
                    domainObject.setDoubleValue(rs.getDouble("rate"));

                    rateTamlateList.add(domainObject);

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return rateTamlateList;

        }
    }

    private void getRateListFromeStore(){

        String expression="SELECT * FROM " +"RateStore"+" ORDER BY ID";
        Statement stmt  = null;
        ratesStoredList = FXCollections.<RatePerHour>observableArrayList();

        try {

            stmt = Db.getConnection().createStatement();

            ResultSet rs    = stmt.executeQuery(expression);

            while (rs.next()) {
                RatePerHour domainObject = new RatePerHour();
                domainObject.setId(rs.getInt("id"));
                domainObject.setDoubleValue(rs.getDouble("rate"));
                domainObject.setStartingRateDate(rs.getDate("startDate").toLocalDate());
                domainObject.setEmployerId(rs.getInt("employerId"));


                ratesStoredList.add(domainObject);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private Integer getMaxEmployersId(){
        try {

            String expression="SELECT id FROM " +"Employees"+" where id=(SELECT MAX(id) FROM Employees)";

            Statement stmt  = Db.getConnection().createStatement();

            ResultSet rs    = stmt.executeQuery(expression);


            while (rs.next()) {

                int id=rs.getInt("id");

                return id;

            }

        } catch (SQLException ex) {
            Logger.getLogger(EquipmentDataMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;

    }





}
