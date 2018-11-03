//package basisFx.domain.domaine;
//
//import basisFx.appCore.domainScetch.ComboBoxValue;
//import basisFx.appCore.domainScetch.DomainObject;
//import javafx.beans.property.SimpleObjectProperty;
//
//import java.time.LocalDate;
//
//public class EmployeesRatePerHour extends DomainObject {
//
//    private SimpleObjectProperty<LocalDate> startingRateDate =new SimpleObjectProperty<>(this, "startingDate", null);
//    private SimpleObjectProperty<Integer> employerId =new SimpleObjectProperty<>(this, "employerId", null);
//    private SimpleObjectProperty<ComboBoxValue> rate =new SimpleObjectProperty<>(this, "rate", null);
//
//
//
//    public LocalDate getStartingDate() {
//        return startingRateDate.get();
//    }
//
//    public SimpleObjectProperty<LocalDate> startingRateDateProperty() {
//        return startingRateDate;
//    }
//
//    public void setStartingRateDate(LocalDate startingRateDate) {
//        this.startingRateDate.set(startingRateDate);
//    }
//
//    public Integer getEmployerId() {
//        return employerId.get();
//    }
//
//    public SimpleObjectProperty<Integer> employerIdProperty() {
//        return employerId;
//    }
//
//    public void setEmployerId(Integer employerId) {
//        this.employerId.set(employerId);
//    }
//
//    public ComboBoxValue getRate() {
//        return rate.get();
//    }
//
//    public SimpleObjectProperty<ComboBoxValue> rateProperty() {
//        return rate;
//    }
//
//    public void setRate(ComboBoxValue rate) {
//        this.rate.set(rate);
//    }
//
//    @Override
//    public ComboBoxValue toComboBoxValue() {
//        return new ComboBoxValue(getRate().getStringValue(),getId());
//    }
//}
