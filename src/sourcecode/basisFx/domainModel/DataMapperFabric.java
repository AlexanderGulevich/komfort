/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.domainModel;

import basisFx.appCore.domainScetch.NamedDataMapper;
import basisFx.domainModel.mapper.CounterpartyDataMapper;
import basisFx.domainModel.mapper.EquipmentDataMapper;

/**
 *
 * @author Alek
 */
public class DataMapperFabric {

    public EquipmentDataMapper getEquipmentDataMapper(){

        return EquipmentDataMapper.getInstance();

    }

    public CounterpartyDataMapper getCounterpartyDataMapper() {

        return CounterpartyDataMapper.getInstance();
    }

    public NamedDataMapper getNamedDataMapper() {

        return NamedDataMapper.getInstance();
    }
}
