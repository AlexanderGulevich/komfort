/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.domain.domaine;

import basisFx.appCore.domainScetch.ComboBoxValue;
import basisFx.appCore.domainScetch.DomainObject;
import javafx.beans.property.SimpleObjectProperty;

public class Equipment  extends DomainObject {

    public Equipment() {
        this.tableName="Equipment";
    }

    private SimpleObjectProperty<String> name =new SimpleObjectProperty<>(null, "name", null);

    public String getName() {
        return name.get();
    }

    public SimpleObjectProperty<String> nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    @Override
    public ComboBoxValue toComboBoxValue() {
        return new ComboBoxValue(getName(),getId());
    }
}
