package basisFx.domain;

import javafx.beans.property.SimpleObjectProperty;

import java.time.LocalDate;

public class ActualEmployersRate extends ActiveRecord {

    private static ActualEmployersRate INSTANCE = new ActualEmployersRate();
    private SimpleObjectProperty<Employer> EMPLOYER  =new SimpleObjectProperty<>(this, "EMPLOYER", null);
    private SimpleObjectProperty<Double> RATE =new SimpleObjectProperty<>(this, "RATE", null);
    private SimpleObjectProperty<LocalDate> STARTDATE =new SimpleObjectProperty<>(this, "STARTDATE", null);
    private SimpleObjectProperty<String> NAME =new SimpleObjectProperty<>(this, "NAME", null);
    private SimpleObjectProperty<BoolComboBox> ISFIRED =new SimpleObjectProperty<>(this, "ISFIRED", null);

    public static ActualEmployersRate getINSTANCE() {
        return INSTANCE;
    }

    public static void setINSTANCE(ActualEmployersRate INSTANCE) {
        ActualEmployersRate.INSTANCE = INSTANCE;
    }

    public Employer getEMPLOYER() {
        return EMPLOYER.get();
    }

    public SimpleObjectProperty<Employer> EMPLOYERProperty() {
        return EMPLOYER;
    }

    public void setEMPLOYER(Employer EMPLOYER) {
        this.EMPLOYER.set(EMPLOYER);
    }

    public Double getRATE() {
        return RATE.get();
    }

    public SimpleObjectProperty<Double> RATEProperty() {
        return RATE;
    }

    public void setRATE(Double RATE) {
        this.RATE.set(RATE);
    }

    public LocalDate getSTARTDATE() {
        return STARTDATE.get();
    }

    public SimpleObjectProperty<LocalDate> STARTDATEProperty() {
        return STARTDATE;
    }

    public void setSTARTDATE(LocalDate STARTDATE) {
        this.STARTDATE.set(STARTDATE);
    }

    public String getNAME() {
        return NAME.get();
    }

    public SimpleObjectProperty<String> NAMEProperty() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME.set(NAME);
    }

    public BoolComboBox getISFIRED() {
        return ISFIRED.get();
    }

    public SimpleObjectProperty<BoolComboBox> ISFIREDProperty() {
        return ISFIRED;
    }

    public void setISFIRED(BoolComboBox ISFIRED) {
        this.ISFIRED.set(ISFIRED);
    }

    @Override
    public String toString() {
        return getNAME().toString();
    }
}
