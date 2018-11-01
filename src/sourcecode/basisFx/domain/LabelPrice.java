package basisFx.domain;

import javafx.collections.ObservableList;

public class LabelPrice extends ActiveRecord {
    public LabelPrice(String entityName) {
        super("LabelPrice");
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
