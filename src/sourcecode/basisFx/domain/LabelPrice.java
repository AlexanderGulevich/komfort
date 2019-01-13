package basisFx.domain;

import basisFx.dataSource.Db;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDate;

public class LabelPrice extends ActiveRecord {

    private static LabelPrice INSTANCE = new LabelPrice();
    private SimpleObjectProperty<String> price =new SimpleObjectProperty<>(this, "price", null);
    private SimpleObjectProperty<LocalDate> startDate =new SimpleObjectProperty<>(this, "startDate", null);

    public static LabelPrice getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public String toString() {
        return getPrice();
    }




}
