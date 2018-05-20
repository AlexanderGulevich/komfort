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

    public EquipmentMapper equipmentMapper(){
        return EquipmentMapper.getInstance();
    }
    public CounterpartyMapper counterpartyMapper() {
        return  CounterpartyMapper.getInstance();
    }
    public CurrencyMapper currencyMapper() {
        return CurrencyMapper.getInstance();
    }
    public EmployerMapper employerMapper() {
        return  EmployerMapper.getInstance();
    }
    public RatePerHourTemplatesMapper ratePerHourTemplatesMapper() {
        return  RatePerHourTemplatesMapper.getInstance();
    }
    public EmployeesRateMapper employeesRateMapper() {
        return   EmployeesRateMapper.getInstance();
    }
    public ExchangeRatesMapper exchangeRatesMapper(){return  ExchangeRatesMapper.getInstance();}
    public ProductMapper productMapper(){return  ProductMapper.getInstance();}
    public ProductPriceMapper productPriceMapper(){return  ProductPriceMapper.getInstance();}
    public PacketSizeMapper packetSizeMapper(){return  PacketSizeMapper.getInstance();}
    public PacketProductAccordanceMapper     packetProductAccordanceMapper(){return  PacketProductAccordanceMapper.getInstance();}
    public PacketMapper     packetMapper(){return  PacketMapper.getInstance();}
    public PacketPriceMapper     packetPriceMapper(){return  PacketPriceMapper.getInstance();}
    public LabelMapper labelMapper(){return  LabelMapper.getInstance();}
    public LabelPriceMapper labelPriceMapper(){return  LabelPriceMapper.getInstance();}
    public SleevePriceMapper sleevePriceMapper(){return  SleevePriceMapper.getInstance();}
    public PaperPriceMapper paperPriceMapper(){return  PaperPriceMapper.getInstance();}
    public PaperMapper paperMapper(){return  PaperMapper.getInstance();}
    public SleeveMapper sleeveMapper(){return  SleeveMapper.getInstance();}
    public EmployeesActualRateMapper employeesActualRateMapper(){return  EmployeesActualRateMapper.getInstance();}




}
