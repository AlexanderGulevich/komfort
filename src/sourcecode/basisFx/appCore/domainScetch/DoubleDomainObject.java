package basisFx.appCore.domainScetch;

import javafx.beans.property.SimpleObjectProperty;

public class DoubleDomainObject extends DomainObject {

    private SimpleObjectProperty<Double> value =new SimpleObjectProperty(this, "value", 0d);


    public Double getValue() {
        return value.get();
    }

    public SimpleObjectProperty<Double> valueProperty() {
        return value;
    }

    public void setValue(Double value) {
        this.value.set(value);
    }

    @Override
    public boolean isReadyToTransaction() {

        if ( getValue()!=null     ) {

                return true;
        }

        return false;
    }

    public String toString(){

        return this.value.get().toString();
    }

}
