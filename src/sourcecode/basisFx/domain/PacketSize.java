package basisFx.domain;


import basisFx.dataSource.Db;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PacketSize extends ActiveRecord {

    private static PacketSize INSTANCE = new PacketSize();
    private SimpleObjectProperty<String> size =new SimpleObjectProperty<>(this, "size", null);

    public static PacketSize getINSTANCE() {
        return INSTANCE;
    }

    public String getSize() {
        return size.get();
    }

    public SimpleObjectProperty<String> sizeProperty() {
        return size;
    }

    public void setSize(String size) {
        this.size.set(size);
    }


    @Override
    public String toString() {
        return getSize();
    }

    @Override
    public ObservableList<ActiveRecord> findAllByOuterId(int id) {
        return null;
    }
}
