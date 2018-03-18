/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.domainModel.pojo;

import basisFx.appCore.domainScetch.NamedDomainObject;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 *
 * @author Alek
 */
public class Counterparty  extends NamedDomainObject {

    private IntegerProperty countryId =new SimpleIntegerProperty(this, "countryId", 0);
    private IntegerProperty currencyId =new SimpleIntegerProperty(this, "currencyId", 0);

    public Counterparty( ) {
        this.dataMapper=mapperFabric.getCounterpartyDataMapper();
        this.tableName="Equipment";
    }

    public Integer getCountryId() {
        return countryId.get();
    }

    public IntegerProperty countryIdProperty() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId.set(countryId);
    }

    public Integer getCurrencyId() {
        return currencyId.get();
    }

    public IntegerProperty currencyIdProperty() {
        return currencyId;
    }

    public void setCurrencyId(int currencyId) {
        this.currencyId.set(currencyId);
    }




    @Override
    public boolean isReadyToTransaction() {
        if (
                getName()!=null
                && getCountryId()!=null
                && getCurrencyId()!=null
                && getId()!=null
                )
        {
            return true;

        }

        return false;
    }









}
