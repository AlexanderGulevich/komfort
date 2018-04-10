package basisFx.domainModel.pojo;

import basisFx.appCore.domainScetch.DoubleDomainObject;
import basisFx.appCore.domainScetch.NamedDomainObject;
import javafx.beans.property.SimpleObjectProperty;

import java.time.LocalDate;

/**
 *
 * Created by AlexanderGulevich on 11.03.2018.
 *
 */
public class Employees  extends NamedDomainObject {

    private SimpleObjectProperty<LocalDate> startingRateDate =new SimpleObjectProperty<>(this, "startingRateDate", null);
    private SimpleObjectProperty<Boolean> isFired =new SimpleObjectProperty<>(this, "isFired", false);
    private SimpleObjectProperty<NamedDomainObject> rate =new SimpleObjectProperty<>(this, "rate", null);

    public Employees( ) {
        this.dataMapper=mapperFabric.getEmployeesDataMapper();
        this.tableName="Employees";
    }

    public NamedDomainObject getRate() {
        return rate.get();
    }

    public SimpleObjectProperty<NamedDomainObject> rateProperty() {
        return rate;
    }

    public void setRate(NamedDomainObject rate) {
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

        return false;
    }




















}
