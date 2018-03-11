package basisFx.domainModel.pojo;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by AlexanderGulevich on 11.03.2018.
 *
 * @autor AlexanderGulevich
 */
public class Country extends DomainObject{


    private StringProperty name =new SimpleStringProperty(this, "name", null);

    public Country() {
        this.dataMapper=mapperFabric.getCountryDataMapper();
        this.tableName="Country";
    }


    public String getName() {
        return name.get();
    }
    public void setName(String value) {
        this.name.set(value);
    }


    @Override
    public boolean isReadyToTransaction() {
        if ( getName()!=null )
        {
            return true;

        }

        return false;
    }


}
