package basisFx.domainModel.pojo;

import basisFx.appCore.domainScetch.DomainObject;
import basisFx.appCore.domainScetch.DoubleDomainObject;
import javafx.beans.property.SimpleObjectProperty;

import java.time.LocalDate;

public class RatePerHour extends DoubleDomainObject {

    private SimpleObjectProperty<LocalDate> startingRateDate =new SimpleObjectProperty<>(this, "startingDate", null);

    public RatePerHour() {

            this.dataMapper=mapperFabric.getRatePerHourDataMapper();
            this.tableName="RatePerHour";
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
}
