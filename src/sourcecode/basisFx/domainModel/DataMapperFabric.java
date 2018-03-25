/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.domainModel;

import basisFx.appCore.domainScetch.NamedDataMapper;
import basisFx.domainModel.mapper.CounterpartyDataMapper;
import basisFx.domainModel.mapper.CountryDataMapper;
import basisFx.domainModel.mapper.CurrencyDataMapper;
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

        return new CounterpartyDataMapper();
    }


    public CountryDataMapper getCountryDataMapper() {

        return CountryDataMapper.getInstance();
    }
    public CurrencyDataMapper getCurrencyDataMapper() {

        return CurrencyDataMapper.getInstance();
    }
}
