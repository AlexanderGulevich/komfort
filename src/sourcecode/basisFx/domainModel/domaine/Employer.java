package basisFx.domainModel.domaine;

import basisFx.appCore.domainScetch.DomainObject;
import javafx.beans.property.SimpleObjectProperty;

import java.time.LocalDate;

/**
 *
 * Created by AlexanderGulevich on 11.03.2018.
 *
 */
public class Employer extends DomainObject {

    private SimpleObjectProperty<String> name =new SimpleObjectProperty<>(this, "name", null);
    private SimpleObjectProperty<LocalDate> startingRateDate =new SimpleObjectProperty<>(this, "startingRateDate", null);
    private SimpleObjectProperty<Boolean> isFired =new SimpleObjectProperty<>(this, "isFired", false);
    private SimpleObjectProperty<DomainObject> rate =new SimpleObjectProperty<>(this, "rate", null);

    public String getName() {
        return name.get();
    }

    public SimpleObjectProperty<String> nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }
    public DomainObject getRate() {
        return rate.get();
    }

    public SimpleObjectProperty<DomainObject> rateProperty() {
        return rate;
    }

    public void setRate(DomainObject rate) {
        this.rate.set(rate);
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

    public Boolean getIsFired() {
        return isFired.get();
    }

    public SimpleObjectProperty<Boolean> isFiredProperty() {
        return isFired;
    }

    public void setIsFired(Boolean isFired) {
        this.isFired.set(isFired);
    }




}
