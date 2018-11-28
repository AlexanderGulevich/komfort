package basisFx.domain;

import basisFx.appCore.interfaces.RecordWithDate;
import basisFx.dataSource.Db;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDate;

public class TimeRecordingForEmployers extends ActiveRecord implements RecordWithDate {
    private static TimeRecordingForEmployers INSTANCE = new TimeRecordingForEmployers();
    private SimpleObjectProperty<Employer> employer =new SimpleObjectProperty<>(this, "employer", null);
    private SimpleObjectProperty<Double> hours =new SimpleObjectProperty<>(this, "hours", null);
    private SimpleObjectProperty<LocalDate> date =new SimpleObjectProperty<>(this, "date", null);

    public static TimeRecordingForEmployers getINSTANCE() {
        return INSTANCE;
    }

    public Double getHours() {
        return hours.get();
    }

    public SimpleObjectProperty<Double> hoursProperty() {
        return hours;
    }

    public void setHours(Double hours) {
        this.hours.set(hours);
    }

    public Employer getEmployer() {
        return employer.get();
    }

    public SimpleObjectProperty<Employer> employerProperty() {
        return employer;
    }

    public LocalDate getDate() {
        return date.get();
    }

    public SimpleObjectProperty<LocalDate> dateProperty() {
        return date;
    }
    @Override
    public void setDate(LocalDate date) {
        this.date.set(date);
    }

    public void setEmployer(Employer employer) {
        this.employer.set(employer);
    }

    public TimeRecordingForEmployers() {
        super("TimeRecordingForEmployers");
    }

    @Override
    public ObservableList<ActiveRecord> getAll() {
        return null;
    }

    @Override
    public void update() {

    }

    @Override
    public ActiveRecord find(int id) {
        return null;
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public void insert() {
        boolean check = isUniquenessStartingDate(
            findAllByOuterId(getEmployer().id.get()),
            activeRecord -> ((TimeRecordingForEmployers) activeRecord).getDate(),
            getDate());


        if (check) {

            try {
                String expression = "INSERT INTO " + this.entityName
                        + " ("
                        + " employerId ,  "
                        + " date, "
                        + " hours "
                        + ") VALUES(?,?,?)";

                PreparedStatement pstmt = Db.connection.prepareStatement(expression);
                pstmt.setInt(1, getEmployer().id.get());
                pstmt.setDate(2, Date.valueOf(getDate()));
                pstmt.setDouble(3, getHours());
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public ObservableList<ActiveRecord> findAllByOuterId(int id) {
        ObservableList <ActiveRecord> list=createNewActiveRecordList();
        String expression="SELECT * FROM Employer TimeRecordingForEmployers where employerId= " +id;

        try {
            Statement stmt  = Db.connection.createStatement();
            ResultSet rs    = stmt.executeQuery(expression);

            while (rs.next()) {

                TimeRecordingForEmployers pojo=new TimeRecordingForEmployers();

                pojo.setId( rs.getInt("id"));
                pojo.setDate(rs.getDate("date").toLocalDate());

                list.add(pojo);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public ObservableList<ActiveRecord> getAllByDate(LocalDate date) {
        ObservableList <ActiveRecord> list= FXCollections.observableArrayList();
        ObservableList<ActiveRecord> allEmployers = Employer.getINSTANCE().getAll();

        for (ActiveRecord record : allEmployers) {
            TimeRecordingForEmployers pojo=new TimeRecordingForEmployers();
            Employer employer = (Employer) record;
            pojo.setEmployer(employer);

//            String expression=

            SELECT * FROM (
                    SELECT * FROM EMPLOYER e WHERE e.ISFIRED=FALSE) AS allemployers
            left join
            (SELECT * FROM(
                    SELECT * FROM (SELECT e.id AS EmployerId, e.isfired, e.name,t.date,t.hours FROM Employer AS e
                            left join TIMERECORDINGFOREMPLOYERS t on t.employerId =e.id where date='2018-11-09'
                    ) AS overall
                    WHERE overall.isfired=FALSE
                    OR  overall.isfired=TRUE
                    and  overall.HOURS IS NOT NULL) )AS byDate
            on byDate.employerId =allemployers.id





//            try {
//                PreparedStatement pstmt = Db.connection.prepareStatement(expression);
//                pstmt.setDate(1, Date.valueOf(date));
//                ResultSet rs = pstmt.executeQuery();
//
//                while (rs.next()) {
//
////                    TimeRecordingForEmployers pojo=new TimeRecordingForEmployers();
//
//                    pojo.setId( rs.getInt("id"));
//                    pojo.setDate(rs.getDate("date").toLocalDate());
//
//                    list.add(pojo);
//
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            pojo.setDate();
//            pojo.setHours();
//            list.add(pojo);
        }



        return list;
    }
}
