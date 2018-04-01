package basisFx.domainModel.pojo;

import basisFx.appCore.domainScetch.DomainObject;
import javafx.beans.property.SimpleObjectProperty;

public class RatePerHour extends DomainObject {


    private SimpleObjectProperty<Double> ratePerHour =new SimpleObjectProperty<>(this, "ratePerHour", null);

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

    @Override
    public boolean isReadyToTransaction() {
        if(getRatePerHour()!=null){
            return true;

        }else {

            return false;
        }
    }
}
