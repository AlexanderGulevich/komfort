package basisFx.appCore.chart;

public class NumberStringValue {

    private String stringVal;
    private Number numberVal;

    public NumberStringValue(String stringVal, Number numberVal) {
        this.stringVal = stringVal;
        this.numberVal = numberVal;
    }

    public String getStringVal() {
        return stringVal;
    }

    public Number getNumberVal() {
        return numberVal;
    }
}
