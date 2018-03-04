/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.menu;

import basisFx.appCore.controlPolicy.CheckingFactory;
import basisFx.appCore.controlPolicy.ColumnFabric;
import basisFx.appCore.controlPolicy.EditFabric;
import basisFx.domainModel.DataMapperFabric;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Alek
 */
public abstract class Target {
        
    protected AnchorPane panel;

    protected CheckingFactory check=new CheckingFactory();

    protected ColumnFabric columnFabric=new ColumnFabric();
    
    protected DataMapperFabric dataMapperFabric=new DataMapperFabric();
    
    protected EditFabric editFabric=new EditFabric();
    
    
    public abstract void createElement();
  
    public AnchorPane getTargetElement() {
       return  this.panel;
    }
    
    
    
    
    
}
