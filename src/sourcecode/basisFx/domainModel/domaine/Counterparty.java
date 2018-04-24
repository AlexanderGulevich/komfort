/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.domainModel.domaine;

import basisFx.appCore.domainScetch.DomainObject;
import basisFx.appCore.domainScetch.StringValueDomainObject;
import javafx.beans.property.SimpleObjectProperty;

/**
 *
 * @author Alek
 */
public class Counterparty  extends DomainObject {

    private SimpleObjectProperty<String> name =new SimpleObjectProperty(this, "name", null);
    private SimpleObjectProperty<DomainObject> country =new SimpleObjectProperty<>(this, "country", null);
    private SimpleObjectProperty<DomainObject> currency =new SimpleObjectProperty<>(this, "currency", null);

    public DomainObject getCountry() {
        return country.get();
    }

    public SimpleObjectProperty<DomainObject> countryProperty() {
        return country;
    }

    public void setCountry(Country country) {
        this.country.set(country);
    }

    public DomainObject getCurrency() {
        return currency.get();
    }

    public SimpleObjectProperty<DomainObject> currencyProperty() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency.set(currency);
    }

    public String getName() {
        return name.get();
    }

    public SimpleObjectProperty<String> nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }
}
