/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.menu;

import basisFx.appCore.AnchorCoordinate;
import basisFx.appCore.TargetStackLogic;
import basisFx.appCore.controlPolicy.CheckingFactory;
import basisFx.appCore.controlPolicy.ColumnFabric;
import basisFx.appCore.controlPolicy.EditFabric;
import basisFx.appCore.events.EventFactory;
import basisFx.appCore.panels.AbstractPanel;
import basisFx.appCore.panels.PanelFabric;
import basisFx.domainModel.DataMapperFabric;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Alek
 */
public abstract class Target {
    
    protected PanelFabric panelFabric=new PanelFabric();
    protected AnchorPane panel;
    protected CheckingFactory check=new CheckingFactory();
    protected ColumnFabric columnFabric=new ColumnFabric();
    protected DataMapperFabric dataMapperFabric=new DataMapperFabric();
    protected EditFabric editFabric=new EditFabric();
    protected EventFactory eventFactory=EventFactory.getInstance();
    protected TargetStackLogic targetStack=TargetStackLogic.getInstance();
    
    
    protected abstract void createElement();
  
    public AnchorPane getTargetElement() {
       return  this.panel;
    }
    
    
    public void init() {
        
        targetStackLogic();
        createPanel();
        createElement();
        
 
    }
   
    protected void targetStackLogic(){
    
         targetStack.handle(this);
    
    }
    
    protected void createPanel(){
         panel=panelFabric.createInnerContentPanel(
            new AbstractPanel.PanelBuilder()
                    .setPanelCoordinate(new AnchorCoordinate(10d, 10d, 10d, 10d)))
                .getPanel();
    }
    
    
    
    
    
}
