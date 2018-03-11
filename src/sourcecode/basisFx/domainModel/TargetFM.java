/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.domainModel;

import basisFx.domainModel.targets.CounterpartyTargetPanel;
import basisFx.domainModel.targets.EquipmentTargetPanel;

/**
 *
 * @author Alek
 */
public class TargetFM {

    public  EquipmentTargetPanel createEquipmentPanel(){
        return new EquipmentTargetPanel();
    }
    public  CounterpartyTargetPanel createCounterpartyPanel(){
        return new CounterpartyTargetPanel();
    }



}
