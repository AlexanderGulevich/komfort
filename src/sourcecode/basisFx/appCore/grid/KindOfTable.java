package basisFx.appCore.grid;

public enum KindOfTable {

    SUBMIT("SUBMIT"),
    OBSERVER("OBSERVER"),
    OBSERVED("OBSERVED"),
    SIMPLE("SIMPLE");

    private final String kind;

    private KindOfTable(String kind) {
        this.kind = kind;
    }

    public String getKind() {
        return kind;
    }

}
