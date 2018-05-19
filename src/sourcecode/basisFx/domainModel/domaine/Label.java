package basisFx.domainModel.domaine;

import basisFx.appCore.domainScetch.ComboBoxValue;
import basisFx.appCore.domainScetch.DomainObject;
import javafx.beans.property.SimpleObjectProperty;

import java.time.LocalDate;

public class Label extends DomainObject {

    private SimpleObjectProperty<String> name =new SimpleObjectProperty<>(this, "name", null);
    private SimpleObjectProperty<ComboBoxValue> counterparty =new SimpleObjectProperty<>(this, "counterparty", null);
    private SimpleObjectProperty<String> actualPrice =new SimpleObjectProperty<>(this, "price", null);
    private SimpleObjectProperty<LocalDate> startingDate =new SimpleObjectProperty<>(this, "startingDate", null);

    public Label() {
        setTableName("Label");
    }

    public String getName() {
        return name.get();
    }

    public SimpleObjectProperty<String> nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public ComboBoxValue getCounterparty() {
        return counterparty.get();
    }

    public SimpleObjectProperty<ComboBoxValue> counterpartyProperty() {
        return counterparty;
    }

    public void setCounterparty(ComboBoxValue counterparty) {
        this.counterparty.set(counterparty);
    }

    public String getActualPrice() {
        return actualPrice.get();
    }

    public SimpleObjectProperty<String> actualPriceProperty() {
        return actualPrice;
    }

    public void setActualPrice(String actualPrice) {
        this.actualPrice.set(actualPrice);
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
        return new ComboBoxValue(getName(),getId());
    }
}
