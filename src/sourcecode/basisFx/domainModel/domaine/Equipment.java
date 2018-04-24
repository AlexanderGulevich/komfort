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
    private ObjectProperty<String> rodWidth =new SimpleObjectProperty<>(this, "rodWidth", null);

    

    public String getRodWidth() {
            return rodWidth.get();
        }
    public void setRodWidth(String value) {
        this.rodWidth.set(value);
    }
    public ObjectProperty<String> rodWidthProperty() {
            return rodWidth;
        }


    
}
