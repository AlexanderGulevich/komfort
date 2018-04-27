package basisFx.appCore;

public enum SubmitElement {


    SubmitDatePicker("SubmitDatePicker"),
    SubmitTable("SubmitTable"),
    SubmitTextField("SubmitTextField"),
    SubmitIntField("SubmitTextField"),
    SubmitRealField("SubmitTextField");

    private final String name;

    private SubmitElement(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }





}
