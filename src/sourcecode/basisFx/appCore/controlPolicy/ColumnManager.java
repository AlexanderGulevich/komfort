/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.controlPolicy;

import javafx.scene.control.TableColumn;

/**
 *
 * @author Alek
 */
public class ColumnManager <T> {
    
    
    public TableColumn<T,Integer> createIntegerColumn(String columnName,String propertyName){
    
        return new IntegerColumn<T>(columnName, propertyName).getColumn();
    
    }
    public TableColumn<T,String>  createTextColumn(String columnName,String propertyName){
    
        return new TextColumn<T>(columnName, propertyName).getColumn();
    
    }
}
