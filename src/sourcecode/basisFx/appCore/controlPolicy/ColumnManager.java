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
public class ColumnManager <T,K> {
    
    
    public IntegerColumn<T> createIntegerColumn(String columnName,String propertyName,DomainChange embBeh){
    
        return new IntegerColumn<T>(columnName, propertyName,embBeh);
    
    }
    public TextColumn<T>  createTextColumn(String columnName,String propertyName,DomainChange embBeh){
    
        return new TextColumn<T>(columnName, propertyName, embBeh);
    
    }
}
