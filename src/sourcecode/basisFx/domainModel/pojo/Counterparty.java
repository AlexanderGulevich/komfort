/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.domainModel.pojo;

import basisFx.appCore.domainScetch.StringValueDomainObject;
import javafx.beans.property.SimpleObjectProperty;

/**
 *
 * @author Alek
 */
public class Counterparty  extends StringValueDomainObject {

    private SimpleObjectProperty<StringValueDomainObject> country =new SimpleObjectProperty<>(this, "country", null);
    private SimpleObjectProperty<StringValueDomainObject> currency =new SimpleObjectProperty<>(this, "currency", null);

    public Counterparty( ) {
        this.dataMapper=mapperFabric.getCounterpartyDataMapper();
        this.tableName="CounterpartyPanel";
    }

    public StringValueDomainObject getCountry() {
        return country.get();
    }

    public SimpleObjectProperty<StringValueDomainObject> countryProperty() {
        return country;
    }

    public void setCountry(Country country) {
        this.country.set(country);
    }

    public StringValueDomainObject getCurrency() {
        return currency.get();
    }

    public SimpleObjectProperty<StringValueDomainObject> currencyProperty() {
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
