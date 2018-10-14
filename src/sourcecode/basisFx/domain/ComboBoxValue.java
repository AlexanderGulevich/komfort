package basisFx.domain;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;

public class ComboBoxValue extends ActiveRecord{

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

    public ComboBoxValue(String str, int id) {
        super("ComboBoxValue");
        stringValue.set(str);
        setId(id);

    }
    public ComboBoxValue(String str) {
        super("ComboBoxValue");
        stringValue.set(str);
    }

    public String toString(){

        return this.stringValue.get();

    }

    @Override
    public ComboBoxValue toComboBoxValue() {
        return this;
    }

    @Override
    public boolean isReadyToTransaction() {
        return false;
    }

    @Override
    public ObservableList<ActiveRecord> getAll() {
        return null;
    }


    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }

    @Override
    public ObservableList<ActiveRecord> getAllByRelatedId(Integer id) {
        return null;
    }

    @Override
    public void insert() {

    }
}
