package basisFx.appCore.domainScetch;

import javafx.beans.property.SimpleObjectProperty;

/**
 * Created by AlexanderGulevich on 14.03.2018.
 *
 * @autor AlexanderGulevich
 */
public class ComboBoxStringValue extends DomainObject{

    private SimpleObjectProperty<String> stringValue =new SimpleObjectProperty(this, "stringValue", null);

    public String getStringValue() {
        return stringValue.get();
    }

    public SimpleObjectProperty getStringValueProperty() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue.set(stringValue);
    }

    public ComboBoxStringValue() {

    }
    public ComboBoxStringValue(String str) {
        stringValue.set(str);
    }

    public String toString(){

        return this.stringValue.get();

    }

}
