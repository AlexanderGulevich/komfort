package basisFx.appCore.table;

import basisFx.appCore.windows.WindowBuilder;

public interface ColumnFabric {
    static  ColWrapper doubleCol(String name, String property, double size, boolean isEditable){
       return ColWrapperDouble.newBuilder()
                        .setColumnName(name)
                        .setColumnSize(size)
                        .setIsEditeble(isEditable)
                        .setPropertyName(property)
                        .build();
    }
    static  ColWrapper dateCol(String name, String property, double size, boolean isEditable){
       return ColWrapperDate.newBuilder()
                        .setColumnName(name)
                        .setColumnSize(size)
                        .setIsEditeble(isEditable)
                        .setPropertyName(property)
                        .build();
    }
    static  ColWrapper stringCol(String name, String property, double size, boolean isEditable){
       return ColWrapperString.newBuilder()
                        .setColumnName(name)
                        .setColumnSize(size)
                        .setIsEditeble(isEditable)
                        .setPropertyName(property)
                        .build();
    }
    static  ColWrapper comboBoxCol(Class aClass, String name, String property, double size, boolean isEditable){
       return ColWrapperComboBox.newBuilder(aClass)
                        .setColumnName(name)
                        .setColumnSize(size)
                        .setIsEditeble(isEditable)
                        .setPropertyName(property)
                        .build();
    }
    static  ColWrapper intCol(String name, String property, double size, boolean isEditable){
       return ColWrapperInt.newBuilder()
               .setColumnName(name)
               .setColumnSize(size)
               .setIsEditeble(isEditable)
               .setPropertyName(property)
               .build();
    }

    static  ColWrapper popupViaBtnCol(String name,String butName, double size, WindowBuilder windowBuilder){
       return   ColWrapperPopupViaBtn.newBuilder()
               .setBtnName(butName)
               .setColumnName(name)
               .setColumnSize(size)
               .setWindowBuilder(windowBuilder)
               .build();
    }
    static  ColWrapper popup(String name,String property, double size, WindowBuilder windowBuilder){
       return   ColWrapperPopup.newBuilder()
               .setColumnName(name)
               .setColumnSize(size)
               .setIsEditeble(true)
               .setPropertyName(property)
               .setWindowBuilder(windowBuilder)
               .build();
    }



}
