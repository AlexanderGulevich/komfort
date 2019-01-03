package basisFx.appCore.utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.Arrays;
import java.util.List;

public enum RangeForCombobox {

    ACTUAL("Актуальное значение"),
    LAST10("Последние 10 записей"),
    LAST30("Последние 30 записей"),
    DAY30("За 30 дней"),
    DAY60("За 60 дней"),
    DAY90("За 90 дней"),
    DAY180("За 180 дней"),
    YEAR("За текущий год"),
    ALLTIME("Все время");

    private final String name;
    private RangeForCombobox main;

    RangeForCombobox(String path) {
        this.name = path;
    }

    public String getName() {
        return name;
    }
    public String toString() {return getName();}

    public RangeForCombobox get(String s){
       return  RangeForCombobox.valueOf(s);
    }

    public static  ObservableList<RangeForCombobox> getAsList(RangeForCombobox ... active){
        List<RangeForCombobox> list = Arrays.asList(active);
        return  FXCollections.observableList(list);
    }

    public RangeForCombobox getMain() {
        return main;
    }

}
