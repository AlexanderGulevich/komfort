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
public class Equipment  extends Pojo {
      
    private final String tableName="Equipment";
    private StringProperty name =new SimpleStringProperty(this, "name", null);
    private IntegerProperty rodWidth =new SimpleIntegerProperty(this, "rodWidth", 0);

    
    public String getTableName() {
        return tableName;
    }
     public String getName() {
            return name.get();
        }
    public void setName(String value) {
        this.name.set(value);
    }
    public int getRodWidth() {
            return rodWidth.get();
        }
    public void setRodWidth(int value) {
        this.rodWidth.set(value);
    }
    
     public StringProperty nameProperty() {
            return name;
        }
    
    public IntegerProperty rodWidthProperty() {
            return rodWidth;
        }
    
    
    
    
}
