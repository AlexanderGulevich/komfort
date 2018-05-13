/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.domainModel.domaine;

import basisFx.appCore.domainScetch.ComboBoxValue;
import basisFx.appCore.domainScetch.DomainObject;
import javafx.beans.property.SimpleObjectProperty;

/**
 *
 * @author Alek
 */
public class Counterparty  extends DomainObject {

    private SimpleObjectProperty<String> name =new SimpleObjectProperty(this, "name", null);
    private SimpleObjectProperty<ComboBoxValue> currency =new SimpleObjectProperty<>(this, "currency", null);

    public Counterparty() {
        setTableName("Counterparty");
    }

    public DomainObject getCurrency() {
        return currency.get();
    }

    public SimpleObjectProperty<ComboBoxValue> currencyProperty() {
        return currency;
    }

    public void setCurrency(ComboBoxValue currency) {
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
