package basisFx.appCore.settings;

public enum CSSclasses {

    TABLE_BFx("TABLE_BFx"),
    REGISTRY_BUTTONS_BFx("REGISTRY_BUTTONS_BFx"),
    RADIO_BFx("RADIO_BFx"),
    DATEPICKER_BFx("DATEPICKER_BFx"),
    TEXTFIELD_BFx("TEXTFIELD_BFx"),
    COMBOBOX_BFx("COMBOBOX_BFx");




    private final String id;

    private CSSclasses(String id) {
        this.id = id;
    }

    public String get() {
        return id;
    }
    

    
}
