/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.domainModel;

import basisFx.domainModel.mapper.EquipmentDataMapper;

/**
 *
 * @author Alek
 */
public class DataMapperFabric {
    
    public EquipmentDataMapper getEquipmentDataMapper(){
      
        return EquipmentDataMapper.getInstanse();
    
    
    }
    
}
