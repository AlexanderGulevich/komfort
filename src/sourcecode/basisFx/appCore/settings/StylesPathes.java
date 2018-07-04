package basisFx.appCore.settings;

public enum  StylesPathes {

    CUSTOM_1("/res/css/custom_1"),
    MODENA("/res/css/modena");

    private final String path;

    private StylesPathes(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }


}
