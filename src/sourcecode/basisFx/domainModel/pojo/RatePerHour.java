package basisFx.domainModel.pojo;

import basisFx.appCore.domainScetch.DomainObject;
import basisFx.appCore.domainScetch.DoubleDomainObject;
import javafx.beans.property.SimpleObjectProperty;

import java.time.LocalDate;

public class RatePerHour extends DoubleDomainObject {

    public RatePerHour() {

            this.dataMapper=mapperFabric.getRatePerHourDataMapper();
            this.tableName="RateExamples";
    }

}
