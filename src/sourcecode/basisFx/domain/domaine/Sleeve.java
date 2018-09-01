//package basisFx.domain.domaine;
//
//import basisFx.appCore.domainScetch.ComboBoxValue;
//import basisFx.appCore.domainScetch.DomainObject;
//import javafx.beans.property.SimpleObjectProperty;
//
//public class Sleeve extends DomainObject {
//
//    private SimpleObjectProperty<ComboBoxValue> counterparty = new SimpleObjectProperty<>(this, "counterparty", null);
//
//    public ComboBoxValue getCounterparty() {
//        return counterparty.get();
//    }
//
//    public SimpleObjectProperty<ComboBoxValue> counterpartyProperty() {
//        return counterparty;
//    }
//
//    public void setCounterparty(ComboBoxValue counterparty) {
//        this.counterparty.set(counterparty);
//    }
//
//    @Override
//    public ComboBoxValue toComboBoxValue() {
//        return new ComboBoxValue(getCounterparty().getStringValue(),getId());
//    }
//}
