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

/**
 *
 * @author Alek
 */
public class Currency {
    
    
    private  IntegerProperty id =new SimpleIntegerProperty(this, "id", 0);
    private final String tableName=null;

    public String getTableName() {
        return tableName;
    }
    
    
    private StringProperty name =new SimpleStringProperty(this, "name", null);

    
    public String getName() {
            return name.get();
        }
    public void setName(String stringPricePerUnit) {
        this.name.set(stringPricePerUnit);
    }
    
    
//    ExchangeRates
    
    
}