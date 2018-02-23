/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.domainModel.pojo;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Alek
 */
public class Equipment  extends Pojo {
      
    private final String tableName="Equipment";
    private StringProperty name =new SimpleStringProperty(this, "name", null);
    private ObjectProperty<Integer> rodWidth =new SimpleObjectProperty<>(this, "rodWidth", null);
//    private IntegerProperty rodWidth =new SimpleIntegerProperty(this, "rodWidth", 0);

  
    public String getTableName() {
        
         
        return tableName;
    }
     public String getName() {
            return name.get();
        }
    public void setName(String value) {
        this.name.set(value);
    }
    public Integer getRodWidth() {
            return rodWidth.get();
        }
    public void setRodWidth(Integer value) {
        this.rodWidth.set(value);
    }
    
     public StringProperty nameProperty() {
            return name;
        }
//    
    public ObjectProperty<Integer> rodWidthProperty() {
            return rodWidth;
        }
//    public IntegerProperty rodWidthProperty() {
//            return rodWidth;
//        }
//    
    
    
    
}
