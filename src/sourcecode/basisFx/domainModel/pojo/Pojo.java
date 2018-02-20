/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.domainModel.pojo;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 *
 * @author 62
 */
public class Pojo {
    
    private  IntegerProperty id =new SimpleIntegerProperty(this, "id", 0);

    public int getId() {
            return id.get();
        }
    public void setId(int value) {
        this.id.set(value);
    }
}
