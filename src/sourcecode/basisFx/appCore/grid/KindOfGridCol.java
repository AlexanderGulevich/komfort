package basisFx.appCore.grid;

public enum KindOfGridCol {

    percent("percent"),
    fixed("fixed"),
    byChild("byChild"),
    computed("computed");

    private final String kind;

    private KindOfGridCol(String kind) {
        this.kind = kind;
    }

    public String getKind() {
        return kind;
    }


}
