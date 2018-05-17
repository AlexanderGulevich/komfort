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
        return new CounterpartyMapper();
    }
    public CurrencyMapper currencyMapper() {
        return CurrencyMapper.getInstance();
    }
    public EmployerMapper employerMapper() {
        return new EmployerMapper();
    }
    public RatePerHourTemplatesMapper ratePerHourTemplatesMapper() {
        return  RatePerHourTemplatesMapper.getInstance();
    }
    public RatePerHourMapper ratePerHourMapper() {
        return  new RatePerHourMapper();
    }
    public ExchangeRatesMapper exchangeRatesMapper(){return new ExchangeRatesMapper();}
    public ProductMapper productMapper(){return new ProductMapper();}
    public ProductPriceMapper productPriceMapper(){return new ProductPriceMapper();}
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




}
