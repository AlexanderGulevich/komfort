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

        ObservableList <ActiveRecord> list= FXCollections.observableArrayList();
        ObservableList<ActiveRecord> allEmployers = Employer.getINSTANCE().getAll();

        for (ActiveRecord record : allEmployers) {
            TimeRecordingForEmployers pojo=new TimeRecordingForEmployers();
            pojo.setEmployer(((Employer) record));
            list.add(pojo);
        }



        return list;
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
        String expression="SELECT * FROM " + this.entityName+" where employerId= " +id;

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


}
