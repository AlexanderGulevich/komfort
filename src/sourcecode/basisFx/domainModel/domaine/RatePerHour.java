package basisFx.domainModel.domaine;

import basisFx.appCore.domainScetch.StringValueDomainObject;
import javafx.beans.property.SimpleObjectProperty;

import java.time.LocalDate;

public class RatePerHour extends StringValueDomainObject {

    private SimpleObjectProperty<LocalDate> startingRateDate =new SimpleObjectProperty<>(this, "startingDate", null);
    private SimpleObjectProperty<Integer> employerId =new SimpleObjectProperty<>(this, "employerId", null);
    private SimpleObjectProperty<StringValueDomainObject> rate =new SimpleObjectProperty<>(this, "rate", null);


    public LocalDate getStartingRateDate() {
        return startingRateDate.get();
    }

    public SimpleObjectProperty<LocalDate> startingRateDateProperty() {
        return startingRateDate;
    }

    public void setStartingRateDate(LocalDate startingRateDate) {
        this.startingRateDate.set(startingRateDate);
    }

    public Integer getEmployerId() {
        return employerId.get();
    }

    public SimpleObjectProperty<Integer> employerIdProperty() {
        return employerId;
    }

    public void setEmployerId(Integer employerId) {
        this.employerId.set(employerId);
    }

    public StringValueDomainObject getRate() {
        return rate.get();
    }

    public SimpleObjectProperty<StringValueDomainObject> rateProperty() {
        return rate;
    }

    public void setRate(StringValueDomainObject rate) {
        this.rate.set(rate);
    }
}
