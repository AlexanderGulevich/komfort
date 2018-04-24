/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.domainModel.domaine;

import basisFx.appCore.domainScetch.DomainObject;
import basisFx.appCore.domainScetch.StringValueDomainObject;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 *
 * @author Alek
 */
public class Equipment  extends DomainObject {

    private SimpleObjectProperty<String> rodWidth =new SimpleObjectProperty<>(null, "rodWidth", null);
    private SimpleObjectProperty<String> name =new SimpleObjectProperty<>(null, "name", null);


    public String getRodWidth() {
        return rodWidth.get();
    }

    public SimpleObjectProperty<String> rodWidthProperty() {
        return rodWidth;
    }

    public void setRodWidth(String rodWidth) {
        this.rodWidth.set(rodWidth);
    }

    public String getName() {
        return name.get();
    }

    public SimpleObjectProperty<String> nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }
}
