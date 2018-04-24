package basisFx.domainModel.domaine;

import basisFx.appCore.domainScetch.DomainObject;
import basisFx.appCore.domainScetch.StringValueDomainObject;
import javafx.beans.property.SimpleObjectProperty;

import java.time.LocalDate;

public class RatePerHour extends DomainObject {

    private SimpleObjectProperty<LocalDate> startingRateDate =new SimpleObjectProperty<>(this, "startingDate", null);
    private SimpleObjectProperty<Integer> employerId =new SimpleObjectProperty<>(this, "employerId", null);
    private SimpleObjectProperty<StringValueDomainObject> rate =new SimpleObjectProperty<>(this, "rate", null);

    private SimpleObjectProperty<String> name =new SimpleObjectProperty<>(this, "name", null);

    public String getName() {
        return name.get();
    }

    public SimpleObjectProperty<String> nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

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
