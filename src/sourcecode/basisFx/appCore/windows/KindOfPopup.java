package basisFx.appCore.windows;

public enum KindOfPopup {


    ERROR("ERROR");





    private final String type;

    private KindOfPopup(String id) {
        this.type = id;
    }

    public String get() {
        return type;
    }

}
