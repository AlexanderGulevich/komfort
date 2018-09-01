///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package basisFx.appCore.domainScetch;
//
//import basisFx.dataSource.DataMapper;
//import javafx.beans.property.ObjectProperty;
//import javafx.beans.property.SimpleObjectProperty;
//
///**
// *
// * @author 62
// */
//public abstract class DomainObject {
//
//    protected DataMapper dataMapper;
//    protected String tableName;
//
//    private ObjectProperty<Integer> id =new SimpleObjectProperty<>(this, "id", null);
//    public  abstract ComboBoxValue  toComboBoxValue();
//    public Integer getId() {
//            return id.get();
//        }
//    public void setId(int value) {
//        this.id.set(value);
//    }
//    public DataMapper getDataMapper() {
//        return dataMapper;
//    }
//    public String getTableName() {
//        return tableName;
//    }
//
//    public void setTableName(String tableName) {
//        this.tableName = tableName;
//    }
//
//
//    public void setDataMapper(DataMapper dataMapper) {
//        this.dataMapper = dataMapper;
//    }
//
//
//}
