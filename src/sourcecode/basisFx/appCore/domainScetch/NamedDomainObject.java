package basisFx.appCore.domainScetch;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by AlexanderGulevich on 14.03.2018.
 *
 * @autor AlexanderGulevich
 */
public class NamedDomainObject extends DomainObject{

    private StringProperty name =new SimpleStringProperty(this, "name", null);

    public String getName() {
        return name.get();
    }

    public StringProperty getNameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    @Override
    public boolean isReadyToTransaction() {
        if ( getName()!=null && getId()!=null  )
        {
            return true;

        }

        return false;
    }

}
