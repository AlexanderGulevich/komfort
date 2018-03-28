/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.controlPolicy;

/**
 *
 * @author Alek
 */
public class ColumnFabric <T,K> {
    
    
    public ColumnInteger<T> createIntegerColumn(ColumnWrapper.Bulder builder){
        
        return new ColumnInteger<T>(builder);
    
    }
    public ColumnString<T> createStringColumn(ColumnWrapper.Bulder builder){

        return new ColumnString<T>(builder);

    }
    public ColumnComboBox<T,K> createComboBoxColumn(ColumnWrapper.Bulder builder){

        return new ColumnComboBox<T,K>(builder);

    }
    public ColumnLocalDate<T,K> createLocalDateColumn(ColumnWrapper.Bulder builder){

        return new ColumnLocalDate<T,K>(builder);

    }

    public ColumnDouble<T,K> createDoubleColumn(ColumnWrapper.Bulder builder){

        return new ColumnDouble<T,K>(builder);

    }



}
