package basisFx.domainModel.mapper;

import basisFx.appCore.dataSource.DataMapper;
import basisFx.appCore.dataSource.Db;
import basisFx.appCore.domainScetch.ComboBoxValue;
import basisFx.appCore.domainScetch.DomainObject;
import basisFx.domainModel.domaine.Employer;
import basisFx.domainModel.domaine.RatePerHour;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployerDataMapper extends DataMapper {
//todo change
    private  ObservableList <ComboBoxValue> rateTamlateList =null;
    private  ObservableList <RatePerHour> ratesStoredList =null;
    private  ObservableList <Employer> currentEmployees =null;
    private  HashMap<Integer,ArrayList<RatePerHour>> ratesMapById =new HashMap<>();


    @Override
    public boolean isReadyToTransaction(DomainObject d) {
        Employer employer= (Employer) d;
        if (employer.getName()!= null
             && employer.getIsFired()!= null
                ) {
            return true;
        }
        return false;
    }



    @Override
    public void getDomainList(ObservableList list)  {

            String expression="SELECT * FROM " +"Employer"+" ORDER BY ID";

            Statement stmt  = Db.getConnection().createStatement();

            ResultSet rs    = stmt.executeQuery(expression);


            while (rs.next()) {

                getRateListFromeStore();
                convertStoredRatesToHashMap();

                Employer pojo=new Employer();
                pojo.setId(rs.getInt("id"));
                pojo.setName(rs.getString("name"));
                pojo.setIsFired(rs.getBoolean("isFired"));

                RatePerHour rate=getNewest(rs.getInt("id"));

                if (rate != null) {

                    pojo.setStartingRateDate(rate.getStartingDate());

                    pojo.setRate(rate);
                }



                //вставляю id в список хранимых в бд
                this.unitOfWork.getStoredPojoesId().add(rs.getInt("id"));

                list.add(pojo);
            }

        currentEmployees=list;

        System.out.println(currentEmployees);


    }

    @Override
    public void getDomainListForObserverTables(ObservableList list, DomainObject selectedDomainObject) {

    }

    private RatePerHour getNewest(Integer id){
//todo put in basic class
        RatePerHour newestRate=null;

        ArrayList<RatePerHour> ratePerHoursList = ratesMapById.get(id);

        if (ratePerHoursList != null) {
            for (RatePerHour rate:ratePerHoursList) {

                if (newestRate == null) {

                    newestRate=rate;

                }

                if (rate.getStartingDate().isAfter(newestRate.getStartingDate())){
                    newestRate=rate;
                }
            }
        }


        return newestRate;



    }

    private void convertStoredRatesToHashMap() {

        for (RatePerHour rate: ratesStoredList) {

            Integer id=rate.getEmployerId();

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
    public void updateDomainObject(DomainObject d)   {

        if(isReadyToTransaction(d)) {

            Employer employer= (Employer) d;
            String expression = "UPDATE "+    "Employer"+ " SET  " +
                    " name = ?," +
                    " isFired = ?" +
                    " WHERE id= ?" ;

            PreparedStatement pstmt = null;

                pstmt = Db.getConnection().prepareStatement(expression);
                pstmt.setString(1, employer.getName());
                pstmt.setBoolean(2, employer.getIsFired());
                pstmt.setInt(3, employer.getId());
                pstmt.executeUpdate();

        }

    }

    @Override
    public void deleteDomainObject(DomainObject d)   {
        if(isReadyToTransaction(d)) {

            Employer employer= (Employer) d;
            String expression = "UPDATE "+    "Employer"+ " SET  " +
                    " name = ?," +
                    " isFired = ?" +
                    " WHERE id= ?" ;

            PreparedStatement pstmt = null;

            pstmt = Db.getConnection().prepareStatement(expression);
            pstmt.setString(1, employer.getName());
            pstmt.setBoolean(2, true);
            pstmt.setInt(3, employer.getId());
            pstmt.executeUpdate();

        }

    }

    @Override
    public void insertDomainObject(DomainObject d)   {
        Employer domainObject=(Employer) d;

        if(isReadyToTransaction(d)) {

            int maxId = getMaxEmployersId();

                String expression = "INSERT INTO " + "Employer "
                        + "("
                        + " name ,  "
                        + " isFired,  "
                        + " id        "
                        + ") VALUES(?,?,?)";

                PreparedStatement pstmt = Db.getConnection().prepareStatement(expression);
                pstmt.setString(1, domainObject.getName());
                pstmt.setBoolean(2, domainObject.getIsFired());
                pstmt.setInt(3, maxId + 1);

                pstmt.executeUpdate();


        }

    }

    public  ObservableList <ComboBoxValue> getRateTemplateList()   {

        if (rateTamlateList != null) {
            return rateTamlateList;
        }else {

            String expression="SELECT * FROM " +"RateTemplates"+" ORDER BY ID";
            Statement stmt  = null;
            rateTamlateList = FXCollections.<ComboBoxValue>observableArrayList();



                stmt = Db.getConnection().createStatement();

                ResultSet rs    = stmt.executeQuery(expression);

                while (rs.next()) {
                    ComboBoxValue domainObject = new ComboBoxValue();
                    domainObject.setId(rs.getInt("id"));
                    domainObject.setStringValue(String.valueOf(rs.getDouble("rate")));

                    rateTamlateList.add(domainObject);

                }

            return rateTamlateList;

        }
    }

    private void getRateListFromeStore()   {

        String expression="SELECT * FROM " +"RateStore"+" ORDER BY ID";
        Statement stmt  = null;
        ratesStoredList = FXCollections.<RatePerHour>observableArrayList();

            stmt = Db.getConnection().createStatement();

            ResultSet rs    = stmt.executeQuery(expression);

            while (rs.next()) {
                RatePerHour domainObject = new RatePerHour();
                domainObject.setId(rs.getInt("id"));
                domainObject.setName(String.valueOf(rs.getDouble("rate")));
                domainObject.setStartingRateDate(rs.getDate("startDate").toLocalDate());
                domainObject.setEmployerId(rs.getInt("employerId"));


                ratesStoredList.add(domainObject);

            }

    }

    private Integer getMaxEmployersId()  {

            String expression="SELECT id FROM " +"Employer"+" where id=(SELECT MAX(id) FROM Employer)";

            Statement stmt  = Db.getConnection().createStatement();

            ResultSet rs    = stmt.executeQuery(expression);


            while (rs.next()) {

                int id=rs.getInt("id");

                return id;

            }


        return 0;

    }





}
