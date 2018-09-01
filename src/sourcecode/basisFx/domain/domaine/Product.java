///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package basisFx.domain.domaine;
//
//import basisFx.appCore.domainScetch.BoolComboBox;
//import basisFx.appCore.domainScetch.ComboBoxValue;
//import basisFx.appCore.domainScetch.DomainObject;
//import javafx.beans.property.*;
//
///**
// *
// * @author Alek
// */
//public class Product  extends DomainObject {
//
//    private SimpleObjectProperty<String> name =new SimpleObjectProperty<>(this, "name", null);
//    private SimpleObjectProperty<BoolComboBox> sleeve =new SimpleObjectProperty<>(this, "sleeve", null);
//
//    public BoolComboBox getSleeve() {
//        return sleeve.get();
//    }
//
//    public SimpleObjectProperty<BoolComboBox> sleeveProperty() {
//        return sleeve;
//    }
//
//    public void setSleeve(BoolComboBox sleeve) {
//        this.sleeve.set(sleeve);
//    }
//
//    public String getName() {
//        return name.get();
//    }
//
//    public SimpleObjectProperty<String> nameProperty() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name.set(name);
//    }
//
//
//    @Override
//    public ComboBoxValue toComboBoxValue() {
//        return new ComboBoxValue(getName(),getId());
//    }
//}
