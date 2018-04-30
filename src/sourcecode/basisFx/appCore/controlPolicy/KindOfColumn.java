package basisFx.appCore.controlPolicy;

public enum KindOfColumn {


    STRING("STRING"),
    INT("INT"),
    BOOL("BOOL"),
    DOUBLE("DOUBLE"),
    DATE("STRING"),
    COMBOBOX("COMBOBOX");


    private final String kindOfColumn;

    private KindOfColumn(String id) {
        this.kindOfColumn = id;
    }

    public String get() {
        return kindOfColumn;
    }





}
