/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.domainModel.pojo;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Alek
 */
public class Product {
    
    private final String tableName="Product";
    private IntegerProperty id =new SimpleIntegerProperty(this, "id", 0);
    private StringProperty name =new SimpleStringProperty(this, "name", null);
    private DoubleProperty width =new SimpleDoubleProperty(this, "width", 0);
    private DoubleProperty price =new SimpleDoubleProperty(this, "price", 0);
    
    
    public String getTableName() {
        return tableName;
    }
    public int getId() {
            return id.get();
        }
    public void setId(int value) {
        this.id.set(value);
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
