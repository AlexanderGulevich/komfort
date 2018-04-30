/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.fabrics;

import basisFx.appCore.controlPolicy.*;
import basisFx.appCore.interfaces.DomainChanging;
import basisFx.appCore.interfaces.DomainsListGetter;

/**
 *
 * @author Alek
 */
public class ColumnFabric <T,K> {

    public ColumnString<T> createColumn(KindOfColumn kindOfColumn, String name, String property, Double size, Boolean isEditable, DomainChanging domainChanging) {
            ColumnWrapper.Bulder bulder =
                    ColumnWrapper.Bulder.create(name, property, size)
                    .setDomainChanging(domainChanging).setEditeble(isEditable)
                    .setKindOfColumn(kindOfColumn);

            return new ColumnString<T>(bulder);
    }
    public ColumnStringComboBox<T,K> createColumnComboBox(KindOfColumn kindOfColumn, String name, String property, Double size, Boolean isEditable, DomainChanging domainChanging, DomainsListGetter domainsListGetter){

            ColumnWrapper.Bulder bulder =
                    ColumnWrapper.Bulder.create(name, property, size)
                            .setEditeble(isEditable)
                            .setDomainsListGetter(domainsListGetter)
                            .setDomainChanging(domainChanging)
                            .setKindOfColumn(kindOfColumn);

            return new ColumnStringComboBox<T,K>(bulder);

    }
    public ColumnLocalDate<T,K> createDateColumn(KindOfColumn kindOfColumn, String name, String property, Double size, Boolean isEditable, DomainChanging domainChanging){

                ColumnWrapper.Bulder builder =
                        ColumnWrapper.Bulder.create(name, property, size)
                                .setDomainChanging(domainChanging).setEditeble(isEditable)
                                .setKindOfColumn(kindOfColumn);

                return new ColumnLocalDate<T,K>(builder);
    }




}
