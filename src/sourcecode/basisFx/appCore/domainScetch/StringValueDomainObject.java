package basisFx.appCore.domainScetch;

import javafx.beans.property.SimpleObjectProperty;

/**
 * Created by AlexanderGulevich on 14.03.2018.
 *
 * @autor AlexanderGulevich
 */
public class StringValueDomainObject extends DomainObject{

    private SimpleObjectProperty<String> stringValue =new SimpleObjectProperty(this, "stringValue", "");

    public String getStringValue() {
        return stringValue.get();
    }

    public SimpleObjectProperty getNameProperty() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue.set(stringValue);
    }

    @Override
    public boolean isReadyToTransaction() {

        if ( getStringValue()!=null     )
        {
            if (!getStringValue().trim().isEmpty()){
                return true;
            }


        }

        return false;
    }

    public String toString(){

        return this.stringValue.get();

    }

}
