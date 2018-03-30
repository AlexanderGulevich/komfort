package basisFx.domainModel.pojo;

import basisFx.appCore.domainScetch.DomainObject;
import basisFx.appCore.domainScetch.NamedDomainObject;
import javafx.beans.property.SimpleObjectProperty;

/**
 *
 * Created by AlexanderGulevich on 11.03.2018.
 *
 */
public class Employees  extends NamedDomainObject {

    private SimpleObjectProperty<Integer> ratePerHourId =new SimpleObjectProperty<>(this, "ratePerHourId", null);
    private SimpleObjectProperty<Integer> ratePerHourHistoryId =new SimpleObjectProperty<>(this, "currency", null);
    private SimpleObjectProperty<NamedDomainObject> currency =new SimpleObjectProperty<>(this, "currency", null);

    public Employees( ) {
        this.dataMapper=mapperFabric.getCounterpartyDataMapper();
        this.tableName="Employees";
    }


    public NamedDomainObject getCountry() {
        return country.get();
    }

    public SimpleObjectProperty<NamedDomainObject> countryProperty() {
        return country;
    }

    public void setCountry(Country country) {
        this.country.set(country);
    }

    public NamedDomainObject getCurrency() {
        return currency.get();
    }

    public SimpleObjectProperty<NamedDomainObject> currencyProperty() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency.set(currency);
    }

    @Override
    public boolean isReadyToTransaction() {
        if (
                super.isReadyToTransaction()
                        && getCountry()!=null
                        && getCurrency()!=null

                )
        {
            return true;

        }

        return false;
    }




















}
