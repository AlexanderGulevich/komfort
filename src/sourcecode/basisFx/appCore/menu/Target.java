/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.menu;

import basisFx.appCore.controlPolicy.CheckingFactory;
import basisFx.appCore.controlPolicy.ColumnManager;
import basisFx.domainModel.DataMapperFabric;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Alek
 */
public abstract class Target {
        
    protected AnchorPane panel;

    protected CheckingFactory check=new CheckingFactory();

    protected ColumnManager colManeger=new ColumnManager();
    
    protected DataMapperFabric dataMapperFabric=new DataMapperFabric();
    
    public abstract void createElement();
  
    public AnchorPane getTargetElement() {
       return  this.panel;
    }
    
    
    
    
    
}
