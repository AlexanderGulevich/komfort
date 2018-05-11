package basisFx.domainModel.domaine;

import basisFx.appCore.domainScetch.DomainObject;
import javafx.beans.property.SimpleObjectProperty;

public class PacketSize extends DomainObject{

    private SimpleObjectProperty<String> size =new SimpleObjectProperty<>(this, "size", null);

    public String getSize() {
        return size.get();
    }

    public SimpleObjectProperty<String> sizeProperty() {
        return size;
    }

    public void setSize(String size) {
        this.size.set(size);
    }
}
