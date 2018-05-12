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

    public EquipmentDM equipmentDataMapper(){
        return EquipmentDM.getInstance();
    }
    public CounterpartyDataMapper counterpartyDataMapper() {
        return new CounterpartyDataMapper();
    }

    public CurrencyDataMapper currencyDataMapper() {
        return CurrencyDataMapper.getInstance();
    }
    public EmployerDataMapper employerDataMapper() {
        return new EmployerDataMapper();
    }
    public RatePerHourTemplatesDataMapper ratePerHourTemplatesDataMapper() {
        return  RatePerHourTemplatesDataMapper.getInstance();
    }
    public RatePerHourDataMapper ratePerHourDataMapper() {
        return  new RatePerHourDataMapper();
    }
    public ExchangeRatesDataMapper exchangeRatesDataMapper(){return new ExchangeRatesDataMapper();}
    public ProductDataMapper productDataMapper(){return new ProductDataMapper();}
    public ProductPriceMapper priceDataMapper(){return new ProductPriceMapper();}
    public PacketSizeMapper packetSizeMapper(){return new PacketSizeMapper();}




}
