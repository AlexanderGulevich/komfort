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
    
    
    public IntegerColumn<T> createIntegerColumn(Column.Bulder builder){
        
        return new IntegerColumn<T>(builder);
    
    }
    public TextColumn<T>  createTextColumn(Column.Bulder builder){
    
        return new TextColumn<T>(builder);
    
    }
}
