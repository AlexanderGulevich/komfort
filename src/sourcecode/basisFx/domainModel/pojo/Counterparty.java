/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.domainModel.pojo;

import basisFx.appCore.domainScetch.NamedDomainObject;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 *
 * @author Alek
 */
public class Counterparty  extends NamedDomainObject {

    private ObjectProperty<Country> country =new SimpleObjectProperty<>(this, "country", null);
    private ObjectProperty<Currency> currency =new SimpleObjectProperty<>(this, "currency", null);

    public Counterparty( ) {
        this.dataMapper=mapperFabric.getCounterpartyDataMapper();
        this.tableName="Equipment";
    }


    public Country getCountry() {
        return country.get();
    }

    public ObjectProperty<Country> countryProperty() {
        return country;
    }

    public void setCountry(Country country) {
        this.country.set(country);
    }

    public Currency getCurrency() {
        return currency.get();
    }

    public ObjectProperty<Currency> currencyProperty() {
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
