/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.domainModel.domaine;

import basisFx.appCore.domainScetch.DomainObject;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Alek
 */
public class Product  extends DomainObject {
    
    private final String tableName="Product";
    private StringProperty name =new SimpleStringProperty(this, "name", null);
    private DoubleProperty width =new SimpleDoubleProperty(this, "width", 0);
    private DoubleProperty price =new SimpleDoubleProperty(this, "price", 0);
    
    public String getTableName() {
        return tableName;
    }
    public String getName() {
            return name.get();
        }
    public void setName(String value) {
        this.name.set(value);
    }
    public Double getWidth() {
            return width.get();
        }
    public void setWidth(Double value) {
        this.width.set(value);
    }
    public Double getPrice() {
            return price.get();
        }
    public void setPrice(Double value) {
        this.price.set(value);
    }


    
    
}
