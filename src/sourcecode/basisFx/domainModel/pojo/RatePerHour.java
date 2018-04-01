package basisFx.domainModel.pojo;

import basisFx.appCore.domainScetch.DomainObject;
import javafx.beans.property.SimpleObjectProperty;

import java.time.LocalDate;

public class RatePerHour extends DomainObject {


    private SimpleObjectProperty<Double> ratePerHour =new SimpleObjectProperty<>(this, "ratePerHour", null);
    private SimpleObjectProperty<LocalDate> startingDate =new SimpleObjectProperty<>(this, "startingDate", null);

    public RatePerHour() {

            this.dataMapper=mapperFabric.getRatePerHourDataMapper();
            this.tableName="RatePerHour";
    }

    public Double getRatePerHour() {
        return ratePerHour.get();
    }

    public SimpleObjectProperty<Double> ratePerHourProperty() {
        return ratePerHour;
    }

    public void setRatePerHour(Double ratePerHour) {
        this.ratePerHour.set(ratePerHour);
    }

    public LocalDate getStartingDate() {
        return startingDate.get();
    }

    public SimpleObjectProperty<LocalDate> startingDateProperty() {
        return startingDate;
    }

    public void setStartingDate(LocalDate startingDate) {
        this.startingDate.set(startingDate);
    }

    @Override
    public boolean isReadyToTransaction() {
        if(getRatePerHour()!=null){
            return true;

        }else {

            return false;
        }
    }
}
