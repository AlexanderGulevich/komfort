package basisFx.appCore.utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Range {

    ACTUAL("Актуальное значение"),
    LAST10("Последние 10 записей"),
    LAST30("Последние 30 записей"),
    DAY30("За 30 дней"),
    DAY60("За 60 дней"),
    DAY90("За 90 дней"),
    DAY180("За 180 дней"),
    YEAR("За текущий год"),
    MONTH("За текущий месяц"),
    ALLTIME("Все время");

    private final String name;
    private Range main;

    Range(String path) {
        this.name = path;
    }

    public String getName() {
        return name;
    }
    public String toString() {return getName();}

    public Range get(String s){
       return  Range.valueOf(s);
    }

    public static  ObservableList<Range> getParticular(Range first, Range... subsequent){
        List<Range> list = Arrays.asList(subsequent);
        Collections.reverse(list);
        list.add(first);
        Collections.reverse(list);
        return  FXCollections.observableList(list);
    }
    public static  ObservableList<Range> getAll(){
        List<Range> list = Arrays.asList(Range.values());
        return  FXCollections.observableList(list);
    }
    public static  ObservableList<Range> get(Range ...range){
        List<Range> list = Arrays.asList(range);
        return  FXCollections.observableList(list);
    }
    public Range getMain() {
        return main;
    }



}
