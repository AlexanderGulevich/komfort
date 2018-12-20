package basisFx.appCore.utils;

public enum KindOfSubmitElement {


    SubmitDatePicker("SubmitDatePicker"),
    SubmitTable("SubmitTable"),
    SubmitTextField("SubmitTextField"),
    SubmitIntField("SubmitTextField"),
    SubmitRealField("SubmitTextField");

    private final String name;

    private KindOfSubmitElement(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }





}
