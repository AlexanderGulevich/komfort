/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.domainModel.pojo;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Alek
 */
public class Counterparty  extends DomainObject{



    private IntegerProperty countryId =new SimpleIntegerProperty(this, "countryId", 0);
    private IntegerProperty currencyId =new SimpleIntegerProperty(this, "currencyId", 0);
    private StringProperty name =new SimpleStringProperty(this, "name", null);


    public Counterparty( ) {
        this.dataMapper=mapperFabric.getCounterpartyDataMapper();
        this.tableName="Equipment";
    }

    public int getCountryId() {
        return countryId.get();
    }

    public IntegerProperty countryIdProperty() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId.set(countryId);
    }

    public int getCurrencyId() {
        return currencyId.get();
    }

    public IntegerProperty currencyIdProperty() {
        return currencyId;
    }

    public void setCurrencyId(int currencyId) {
        this.currencyId.set(currencyId);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getTableName() {
        return tableName;
    }

    @Override
    public boolean isReadyToTransaction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
     
     
     
     
     
    
}
