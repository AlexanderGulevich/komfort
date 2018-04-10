package basisFx.domainModel.pojo;

import basisFx.appCore.domainScetch.StringValueDomainObject;
import javafx.beans.property.SimpleObjectProperty;

import java.time.LocalDate;

/**
 *
 * Created by AlexanderGulevich on 11.03.2018.
 *
 */
public class Employer extends StringValueDomainObject {

    private SimpleObjectProperty<LocalDate> startingRateDate =new SimpleObjectProperty<>(this, "startingRateDate", null);
    private SimpleObjectProperty<Boolean> isFired =new SimpleObjectProperty<>(this, "isFired", false);
    private SimpleObjectProperty<StringValueDomainObject> rate =new SimpleObjectProperty<>(this, "rate", null);

    public Employer( ) {
        this.dataMapper=mapperFabric.getEmployeesDataMapper();
        this.tableName="Employer";
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

    @Override
    public boolean isReadyToTransaction() {
        if (
                super.isReadyToTransaction()
                        && getRate()!=null
                        && getStartingRateDate()!=null


                )
        {

            System.err.println("isReadyToTransaction".toUpperCase());
            return true;

        }
        System.err.println("NOT isReadyToTransaction".toUpperCase());
        return false;
    }




















}
