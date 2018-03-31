package basisFx.domainModel.pojo;

import basisFx.appCore.domainScetch.DomainObject;
import basisFx.appCore.domainScetch.NamedDomainObject;
import javafx.beans.property.SimpleObjectProperty;

import java.time.LocalDate;

/**
 *
 * Created by AlexanderGulevich on 11.03.2018.
 *
 */
public class Employees  extends NamedDomainObject {

    private SimpleObjectProperty<Integer> ratePerHourId =new SimpleObjectProperty<>(this, "ratePerHourId", null);
    private SimpleObjectProperty<Integer> ratePerHourHistoryId =new SimpleObjectProperty<>(this, "currency", null);
    private SimpleObjectProperty<LocalDate> hireDay =new SimpleObjectProperty<>(this, "currency", null);
    private SimpleObjectProperty<NamedDomainObject> fireDay =new SimpleObjectProperty<>(this, "currency", null);
    private SimpleObjectProperty<NamedDomainObject> isFired =new SimpleObjectProperty<>(this, "currency", null);
    private SimpleObjectProperty<NamedDomainObject> RatePerHourStory =new SimpleObjectProperty<>(this, "currency", null);
    private SimpleObjectProperty<NamedDomainObject> currency =new SimpleObjectProperty<>(this, "currency", null);

    public Employees( ) {
        this.dataMapper=mapperFabric.getCounterpartyDataMapper();
        this.tableName="Employees";
    }



    @Override
    public boolean isReadyToTransaction() {
//        if (
//                super.isReadyToTransaction()
//                        && getCountry()!=null
//                        && getCurrency()!=null
//
//                )
//        {
//            return true;
//
//        }

        return false;
    }




















}
