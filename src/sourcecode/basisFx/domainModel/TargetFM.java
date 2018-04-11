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

    public EquipmentPanel createEquipmentPanel(){
        return new EquipmentPanel();
    }
    public CounterpartyPanel createCounterpartyPanel(){
        return new CounterpartyPanel();
    }
    public CountryPanel createCountryPanel(){
        return new CountryPanel();
    }
    public CurrencyPanel createCurrencyPanel(){
        return new CurrencyPanel();
    }
    public EmployeesActualRatePanel createEmployeesActualRate(){
        return new EmployeesActualRatePanel();
    }
    public RatePerHourPanel createRatePerHourPanel(){
        return new RatePerHourPanel();
    }
    public EmployeesManagerPanel createEmployeesManagerPanel(){
        return new EmployeesManagerPanel();
    }



}
