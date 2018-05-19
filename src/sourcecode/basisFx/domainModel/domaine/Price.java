package basisFx.domainModel.domaine;

import basisFx.appCore.domainScetch.ComboBoxValue;
import basisFx.appCore.domainScetch.DomainObject;
import javafx.beans.property.SimpleObjectProperty;

import java.time.LocalDate;

public class Price extends DomainObject{

    private SimpleObjectProperty<String> price =new SimpleObjectProperty<>(this, "price", null);
    private SimpleObjectProperty<LocalDate> startingDate =new SimpleObjectProperty<>(this, "startingDate", null);
    private SimpleObjectProperty<Integer> productId =new SimpleObjectProperty<>(this, "productId", null);


    public Integer getProductId() {
        return productId.get();
    }

    public SimpleObjectProperty<Integer> productIdProperty() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId.set(productId);
    }

    public String getPrice() {
        return price.get();
    }

    public SimpleObjectProperty<String> priceProperty() {
        return price;
    }

    public void setPrice(String price) {
        this.price.set(price);
    }

    public LocalDate getStartingDate() {
        return startingDate.get();
    }

    public SimpleObjectProperty<LocalDate> startingDateProperty() {
        return startingDate;
    }

    public void setStartingDate(LocalDate startingDate) {
        this.startingDate.set(startingDate);
    }

    @Override
    public ComboBoxValue toComboBoxValue() {
        return new ComboBoxValue(getPrice(),getId());
    }
}
