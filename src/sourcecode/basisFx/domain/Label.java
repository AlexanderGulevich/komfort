package basisFx.domain;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
import java.time.LocalDate;

public class Label extends ActiveRecord {

    private SimpleObjectProperty<String> name =new SimpleObjectProperty<>(this, "name", null);
    private SimpleObjectProperty<ComboBoxValue> counterparty =new SimpleObjectProperty<>(this, "counterparty", null);
    private SimpleObjectProperty<String> actualPrice =new SimpleObjectProperty<>(this, "price", null);
    private SimpleObjectProperty<LocalDate> startingDate =new SimpleObjectProperty<>(this, "startingDate", null);




    public Label() {
        super("Label");
    }

    @Override
    public ComboBoxValue toComboBoxValue() {
        return null;
    }

    @Override
    public ObservableList<ActiveRecord> getAll() {
        return null;
    }

    @Override
    public void update() {

    }

    @Override
    public ActiveRecord find(int id) {
        return null;
    }

    @Override
    public void insert() {

    }

    @Override
    public ObservableList<ActiveRecord> findAllByOuterId(int id) {
        return null;
    }
}
