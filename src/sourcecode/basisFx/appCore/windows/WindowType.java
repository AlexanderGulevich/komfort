package basisFx.appCore.windows;

public enum WindowType {

    POPUP("POPUP");





    private final String type;

    private WindowType(String id) {
        this.type = id;
    }

    public String get() {
        return type;
    }


}
