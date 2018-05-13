/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.domainModel;

import basisFx.domainModel.targets.*;


/**
 *
 * @author Alek
 */
public class TargetFM {

    public EquipmentPanel equipmentPanel(){
        return new EquipmentPanel();
    }
    public CounterpartyPanel counterpartyPanel(){
        return new CounterpartyPanel();
    }
    public EmployeesActualRatePanel employeesActualRate(){
        return new EmployeesActualRatePanel();
    }
    public RatePerHourPanel ratePerHourPanel(){
        return new RatePerHourPanel();
    }
    public EmployeesManagerPanel employeesManagerPanel(){
        return new EmployeesManagerPanel();
    }
    public ExchangeRatesPanel exchangeRatesPanel(){
        return new ExchangeRatesPanel();
    }
    public TimeRecordingPanel timeRecordingPanel(){
        return new TimeRecordingPanel();
    }
    public CountingRodsPanel countingRodsPanel(){
        return new CountingRodsPanel();
    }
    public RawMateriaAccountingPanel rawMateriaAccountingPanel(){
        return new RawMateriaAccountingPanel();
    }
    public DailyOutputPanel dailyOutputPanel(){
        return new DailyOutputPanel();
    }
    public ProductPanel productPanel(){
        return new ProductPanel();
    }
    public PacketPanel packetPanel(){
        return new PacketPanel();
    }



}
