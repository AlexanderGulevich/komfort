/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.domainModel.targets;

import basisFx.domainModel.targets.EquipmentPanel;

/**
 *
 * @author Alek
 */
public class TargetFabric {
    
    public  EquipmentPanel createEquipmentPanel(){
                 return new EquipmentPanel();
    }
}