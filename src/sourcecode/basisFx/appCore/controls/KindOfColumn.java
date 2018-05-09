package basisFx.appCore.controls;

public enum KindOfColumn {


    STRING("STRING"),
    INT("INT"),
    BOOL("BOOL"),
    DOUBLE("DOUBLE"),
    DATE("DATE"),
    COMBOBOX("COMBOBOX");


    private final String kindOfColumn;

    private KindOfColumn(String id) {
        this.kindOfColumn = id;
    }

    public String get() {
        return kindOfColumn;
    }





}
