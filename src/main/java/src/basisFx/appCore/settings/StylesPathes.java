package basisFx.appCore.settings;

public enum  StylesPathes {

    CUSTOM_1("src/res/res/css/custom_1/"),
    MODENA("src/res/res/css/modena/");

    private final String path;

    private StylesPathes(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }


}
