package basisFx.domainModel.pojo;

import basisFx.appCore.domainScetch.DomainObject;
import basisFx.appCore.domainScetch.DoubleDomainObject;
import basisFx.appCore.domainScetch.NamedDomainObject;
import javafx.beans.property.SimpleObjectProperty;

import java.time.LocalDate;

public class RatePerHour extends NamedDomainObject {

    private SimpleObjectProperty<LocalDate> startingRateDate =new SimpleObjectProperty<>(this, "startingDate", null);
    private SimpleObjectProperty<Integer> employerId =new SimpleObjectProperty<>(this, "employerId", null);


    public RatePerHour() {

            this.dataMapper=mapperFabric.getRatePerHourDataMapper();
            this.tableName="RateTemplates";
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
}
