package basisFx.domain;

import basisFx.appCore.annotation.DataStore;
import basisFx.appCore.annotation.Sorting;
import javafx.beans.property.SimpleObjectProperty;
import org.hsqldb.index.Index;
import java.time.LocalDate;

public class SleevePrice extends ActiveRecord {
    private static SleevePrice INSTANCE =
            new SleevePrice();
    private SimpleObjectProperty<Double> price =
            new SimpleObjectProperty<>(this, "price", null);
    @DataStore (SORTING = Sorting.DESC) private SimpleObjectProperty<LocalDate> startDate =
            new SimpleObjectProperty<>(this, "startDate", null);
    @DataStore (AS_OUTER_ID = true)private SimpleObjectProperty<Index> sleeveId =
            new SimpleObjectProperty<>(this, "sleeveId", null);


    public static SleevePrice getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public String toString() {
        return getPrice().toString();
    }

    public Double getPrice() {
        return price.get();
    }

    public SimpleObjectProperty<Double> priceProperty() {
        return price;
    }

    public void setPrice(Double price) {
        this.price.set(price);
    }

    public LocalDate getStartDate() {
        return startDate.get();
    }

    public SimpleObjectProperty<LocalDate> startDateProperty() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate.set(startDate);
    }

    public Index getSleeveId() {
        return sleeveId.get();
    }

    public SimpleObjectProperty<Index> sleeveIdProperty() {
        return sleeveId;
    }

    public void setSleeveId(Index sleeveId) {
        this.sleeveId.set(sleeveId);
    }
}
