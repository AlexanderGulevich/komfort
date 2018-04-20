/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.domainModel.domaine;

import basisFx.appCore.domainScetch.StringValueDomainObject;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 *
 * @author Alek
 */
public class Equipment  extends StringValueDomainObject {
    private ObjectProperty<Integer> rodWidth =new SimpleObjectProperty<>(this, "rodWidth", null);

    

    public Integer getRodWidth() {
            return rodWidth.get();
        }
    public void setRodWidth(Integer value) {
        this.rodWidth.set(value);
    }
    public ObjectProperty<Integer> rodWidthProperty() {
            return rodWidth;
        }


    
}