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
public class ColumnFabric <T,K> {
    
    
    public IntegerColumn<T> createIntegerColumn(ColumnWrapper.Bulder builder){
        
        return new IntegerColumn<T>(builder);
    
    }
    public TextColumn<T>  createTextColumn(ColumnWrapper.Bulder builder){

        return new TextColumn<T>(builder);

    }
    public ComboBoxColumn<T>  createComboBoxColumn(ColumnWrapper.Bulder builder){

        return new ComboBoxColumn<T>(builder);

    }
}
