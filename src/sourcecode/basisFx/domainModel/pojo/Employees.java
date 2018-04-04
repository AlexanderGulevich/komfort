package basisFx.domainModel.pojo;

import basisFx.appCore.domainScetch.DomainObject;
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

    private SimpleObjectProperty<LocalDate> startingRateDate =new SimpleObjectProperty<>(this, "startingDate", null);
    private SimpleObjectProperty<Boolean> isFired =new SimpleObjectProperty<>(this, "isFired", null);
    private SimpleObjectProperty<DoubleDomainObject> ratePerHour =new SimpleObjectProperty<>(this, "ratePerHour", null);

    public Employees( ) {
        this.dataMapper=mapperFabric.getEmployeesDataMapper();
        this.tableName="Employees";
    }

    public DomainObject getRatePerHour() {
        return ratePerHour.get();
    }

    public SimpleObjectProperty<DoubleDomainObject> ratePerHourProperty() {
        return ratePerHour;
    }

    public void setRatePerHour(DoubleDomainObject ratePerHour) {
        this.ratePerHour.set(ratePerHour);
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
                        && getIsFired()!=null
                        && getRatePerHour()!=null
                        && getStartingRateDate()!=null

                )
        {
            return true;

        }

        return false;
    }




















}
