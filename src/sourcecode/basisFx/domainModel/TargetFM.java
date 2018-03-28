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

    public EquipmentTargetPanel createEquipmentPanel(){
        return new EquipmentTargetPanel();
    }
    public CounterpartyTargetPanel createCounterpartyPanel(){
        return new CounterpartyTargetPanel();
    }
    public CountryTargetPanel createCountryPanel(){
        return new CountryTargetPanel();
    }
    public CurrencyTargetPanel createCurrencyPanel(){
        return new CurrencyTargetPanel();
    }
    public EmployeesTargetPanel createEmployeesPanel(){
        return new EmployeesTargetPanel();
    }



}
