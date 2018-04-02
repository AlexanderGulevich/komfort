/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.domainModel.pojo;

import basisFx.appCore.domainScetch.NamedDomainObject;
import javafx.beans.property.SimpleObjectProperty;

/**
 *
 * @author Alek
 */
public class Counterparty  extends NamedDomainObject {

    private SimpleObjectProperty<NamedDomainObject> country =new SimpleObjectProperty<>(this, "country", null);
    private SimpleObjectProperty<NamedDomainObject> currency =new SimpleObjectProperty<>(this, "currency", null);

    public Counterparty( ) {
        this.dataMapper=mapperFabric.getCounterpartyDataMapper();
        this.tableName="Counterparty";
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
