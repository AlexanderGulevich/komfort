//package basisFx.domain.domaine;
//
//import basisFx.appCore.domainScetch.ComboBoxValue;
//import basisFx.appCore.domainScetch.DomainObject;
//import javafx.beans.property.SimpleObjectProperty;
//
//public class PacketSize extends DomainObject{
//    public PacketSize() {
//        this.tableName="PacketSize";
//    }
//
//    private SimpleObjectProperty<String> size =new SimpleObjectProperty<>(this, "size", null);
//
//    public String getSize() {
//        return size.get();
//    }
//
//    public SimpleObjectProperty<String> sizeProperty() {
//        return size;
//    }
//
//    public void setSize(String size) {
//        this.size.set(size);
//    }
//
//    @Override
//    public ComboBoxValue toComboBoxValue() {
//        return new ComboBoxValue(getSize(),getId());
//    }
//}
