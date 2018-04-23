/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.controlPolicy;

import basisFx.appCore.DomainObjectListGetter;

/**
 *
 * @author Alek
 */
public class ColumnFabric <T,K> {
    
    
    public ColumnInteger<T> createIntegerColumn(ColumnWrapper.Bulder builder){
        return new ColumnInteger<T>(builder);
    }
    public ColumnString<T> createStringColumn(String columnName,String propertyName, Double columnSize,DomainChangeAction domainChangeAction) {
        return new ColumnString<T>(
                ColumnWrapper.Bulder.create(columnName, propertyName, columnSize).setDomainChangeAction(domainChangeAction).setEditeble(true)
        );
    }
    public ColumnStringComboBox<T,K> createColumnStringComboBox(String columnName, String propertyName,Double columnSize,DomainChangeAction domainChangeAction,DomainObjectListGetter domainObjectListGetter){

        return new ColumnStringComboBox<T,K>(
                ColumnWrapper.Bulder.create()
                        .setColumnName(columnName)
                        .setPropertyName(propertyName)
                        .setColumnSize(columnSize)
                        .setDomainObjectListGetter(domainObjectListGetter)
                        .setDomainChangeAction(domainChangeAction)
        );

    }
    public ColumnLocalDate<T,K> createLocalDateColumn(ColumnWrapper.Bulder builder){
        return new ColumnLocalDate<T,K>(builder);

    }
    public ColumnString<T> createNotEditableStringColumn(String columnName,String propertyName, Double columnSize,DomainChangeAction domainChangeAction) {
        return new ColumnString<T>(
                ColumnWrapper.Bulder.create(columnName, propertyName, columnSize).setDomainChangeAction(domainChangeAction).setEditeble(false)
        );
    }




}
