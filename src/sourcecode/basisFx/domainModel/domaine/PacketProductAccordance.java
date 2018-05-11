package basisFx.domainModel.domaine;

import basisFx.appCore.domainScetch.ComboBoxValue;
import basisFx.appCore.domainScetch.DomainObject;
import javafx.beans.property.SimpleObjectProperty;

public class PacketProductAccordance extends DomainObject {

    private SimpleObjectProperty<ComboBoxValue> size =new SimpleObjectProperty<>(this, "size", null);
    private SimpleObjectProperty<ComboBoxValue> product =new SimpleObjectProperty<>(this, "product", null);
    private SimpleObjectProperty<Integer> number =new SimpleObjectProperty<>(this, "number", null);


    public ComboBoxValue getSize() {
        return size.get();
    }

    public SimpleObjectProperty<ComboBoxValue> sizeProperty() {
        return size;
    }

    public void setSize(ComboBoxValue size) {
        this.size.set(size);
    }

    public ComboBoxValue getProduct() {
        return product.get();
    }

    public SimpleObjectProperty<ComboBoxValue> productProperty() {
        return product;
    }

    public void setProduct(ComboBoxValue product) {
        this.product.set(product);
    }

    public Integer getNumber() {
        return number.get();
    }

    public SimpleObjectProperty<Integer> numberProperty() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number.set(number);
    }
}
