/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.controlPolicy;

import basisFx.appCore.functional.DomainChanging;
import basisFx.appCore.functional.DomainsListGetter;

/**
 *
 * @author Alek
 */
public class ColumnFabric <T,K> {

    public ColumnString<T> createColumn(String name, String property, Double size,Boolean isEditable, DomainChanging domainChanging) {
            ColumnWrapper.Bulder bulder =
                    ColumnWrapper.Bulder.create(name, property, size)
                    .setDomainChanging(domainChanging).setEditeble(isEditable);

            return new ColumnString<T>(bulder);
    }
    public ColumnStringComboBox<T,K> createColumnComboBox(String name, String property, Double size, Boolean isEditable,DomainChanging domainChanging, DomainsListGetter domainsListGetter){

            ColumnWrapper.Bulder bulder =
                    ColumnWrapper.Bulder.create(name, property, size)
                            .setEditeble(isEditable)
                            .setDomainsListGetter(domainsListGetter)
                            .setDomainChanging(domainChanging);

            return new ColumnStringComboBox<T,K>(bulder);

    }
    public ColumnLocalDate<T,K> createDateColumn(String name, String property, Double size,Boolean isEditable, DomainChanging domainChanging){

                ColumnWrapper.Bulder builder =
                        ColumnWrapper.Bulder.create(name, property, size)
                                .setDomainChanging(domainChanging).setEditeble(isEditable);

                return new ColumnLocalDate<T,K>(builder);
    }




}
