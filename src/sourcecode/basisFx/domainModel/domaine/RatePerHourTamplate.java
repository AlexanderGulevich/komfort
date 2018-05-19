package basisFx.domainModel.domaine;

import basisFx.appCore.domainScetch.ComboBoxValue;
import basisFx.appCore.domainScetch.DomainObject;
import javafx.beans.property.SimpleObjectProperty;

public class RatePerHourTamplate extends DomainObject{

    private SimpleObjectProperty<String> name =new SimpleObjectProperty<>(this, "name", null);

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
