package basisFx.domain;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
import java.time.LocalDate;

public class EmployeesRatePerHour extends ActiveRecord {

    private SimpleObjectProperty<LocalDate> startingRateDate =new SimpleObjectProperty<>(this, "startingDate", null);
    private SimpleObjectProperty<Integer> employerId =new SimpleObjectProperty<>(this, "employerId", null);
    private SimpleObjectProperty<Double> rate =new SimpleObjectProperty<>(this, "rate", null);

    public EmployeesRatePerHour() {
        super("EmployeesRatePerHour");
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

    }

    @Override
    public ObservableList<ActiveRecord> findAllByOuterId(int id) {
        return null;
    }
}
