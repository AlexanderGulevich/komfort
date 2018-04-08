package basisFx.appCore.domainScetch;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by AlexanderGulevich on 14.03.2018.
 *
 * @autor AlexanderGulevich
 */
public class NamedDomainObject extends DomainObject{

    private SimpleObjectProperty<String> name =new SimpleObjectProperty(this, "name", "");

    public String getName() {
        return name.get();
    }

    public SimpleObjectProperty getNameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    @Override
    public boolean isReadyToTransaction() {

        if ( getName()!=null     )
        {
            if (!getName().trim().isEmpty()){
                return true;
            }


        }

        return false;
    }

    public String toString(){

        return this.name.get();

    }

}
