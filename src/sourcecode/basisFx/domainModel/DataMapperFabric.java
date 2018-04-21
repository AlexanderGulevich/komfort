/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.domainModel;

import basisFx.domainModel.mapper.*;

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
    public EmployerDataMapper getEmployerDataMapper() {
        return new EmployerDataMapper();
    }
    public RatePerHourTemplatesDataMapper getRatePerHourTemplatesDataMapper() {
        return  RatePerHourTemplatesDataMapper.getInstance();
    }
    public RatePerHourDataMapper getRatePerHourDataMapper() {
        return  new RatePerHourDataMapper();
    }
    public ExchangeRatesDataMapper getExchangeRatesDataMapper(){return new ExchangeRatesDataMapper();}




}
