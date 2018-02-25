/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.domainModel;

import basisFx.appCore.dataSource.DataMapper;
import basisFx.domainModel.mapper.EquipmentDataMapper;
import basisFx.domainModel.pojo.Equipment;

/**
 *
 * @author Alek
 */
public class MapperFM {
    
    
    public EquipmentDataMapper createEquipmentDataMapper(Equipment eq){
    
        return new EquipmentDataMapper(eq);
    
        
    } 

    
    
    
}
