package basisFx.domain;

import basisFx.appCore.interfaces.RecordWithDate;
import basisFx.dataSource.Db;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class JumboAccounting extends ActiveRecord implements RecordWithDate {

    private static JumboAccounting INSTANCE = new JumboAccounting();
    private SimpleObjectProperty<Counterparty> counterparty=new SimpleObjectProperty<>(this, "counterparty", null);
    private SimpleObjectProperty<LocalDate> date =new SimpleObjectProperty<>(this, "date", null);
    private SimpleObjectProperty<Double> overallWeight=new SimpleObjectProperty<>(this, "overallWeight", null);

    public static JumboAccounting getINSTANCE() {
        return INSTANCE;
    }

    public Counterparty getCounterparty() {
        return counterparty.get();
    }

    public SimpleObjectProperty<Counterparty> counterpartyProperty() {
        return counterparty;
    }

    public void setCounterparty(Counterparty counterparty) {
        this.counterparty.set(counterparty);
    }

    public void setDate(LocalDate date) {
        this.date.set(date);
    }

    public LocalDate getDate() {
        return date.get();
    }

    public SimpleObjectProperty<LocalDate> dateProperty() {
        return date;
    }

    public Double getOverallWeight() {
        return overallWeight.get();
    }

    public SimpleObjectProperty<Double> overallWeightProperty() {
        return overallWeight;
    }

    public void setOverallWeight(Double overallWeight) {
        this.overallWeight.set(overallWeight);
    }

    public JumboAccounting() {
        super("JumboAccounting");
    }

    public static JumboAccounting getInstance() {
        return INSTANCE;
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
        try {
            String expression = "INSERT INTO " + this.entityName
                    + "("
                    + " overallWeight ,  "
                    + " date ,  "
                    + " CounterpartyId "
                    + ") VALUES(?,?,?)";

            PreparedStatement pstmt = Db.connection.prepareStatement(expression);
            pstmt.setDouble(1, getOverallWeight());
            pstmt.setDate(2, Date.valueOf(getDate()));
            pstmt.setInt(3, getCounterparty().getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ObservableList<ActiveRecord> findAllByOuterId(int id) {
        return null;
    }
}
