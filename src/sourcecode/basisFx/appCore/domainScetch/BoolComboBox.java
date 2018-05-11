package basisFx.appCore.domainScetch;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BoolComboBox extends ComboBoxValue {

    public static ObservableList<BoolComboBox> comboBoxes= FXCollections.observableArrayList(new BoolComboBox("ДА"),new BoolComboBox("НЕТ"));


    private SimpleObjectProperty<String> stringValue =new SimpleObjectProperty(this, "stringValue", null);

    public String getStringValue() {
        return stringValue.get();
    }

    public SimpleObjectProperty getStringValueProperty() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue.set(stringValue);
    }

    public BoolComboBox() {

    }
    public BoolComboBox(boolean val) {
        setBoolean(val);
    }
    public BoolComboBox(String str) {
        stringValue.set(str);
    }

    public String toString(){

        return this.stringValue.get();

    }
    public Boolean getBoolean(){

        if(stringValue.get()=="ДА"){
            return true;
        }else{
            return false;
        }
    }
    public void setBoolean(boolean val){

        if(val==true){
          setStringValue("ДА");
        }else{
            setStringValue("НЕТ");
        }
    }
}
