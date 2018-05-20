package basisFx.appCore.windows;

public enum KindOfPopup {


    ERROR("ERROR"),
    MESSAGE("MESSAGE");





    private final String type;

    private KindOfPopup(String id) {
        this.type = id;
    }

    public String get() {
        return type;
    }

}
