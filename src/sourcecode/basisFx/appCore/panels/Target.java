/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.panels;

import basisFx.appCore.*;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.GridPaneWrapper;
import basisFx.appCore.fabrics.*;
import basisFx.appCore.utils.Coordinate;
import basisFx.domainModel.DataMapperFabric;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Alek
 */
public abstract class Target {
    
    protected PanelFabric panelFabric=new PanelFabric();
    protected AnchorPane panel;
    protected ColumnFabric columnFabric=new ColumnFabric();
    protected DataMapperFabric dataMapper =new DataMapperFabric();
    protected EditFabric editFabric=new EditFabric();
    protected EventFactory eventFactory=EventFactory.getInstance();
    protected TargetStackLogic targetStack=TargetStackLogic.getInstance();
    protected ButtonFactory buttonFactory =new ButtonFactory();
    protected TableFabric tableFabric=new TableFabric();
    protected InnerPanelsFabric innerPanelsFabric=new InnerPanelsFabric();
    protected TextFabric textFabric=new TextFabric();
    protected VidgetFactory vidgetFactory=new VidgetFactory();
    protected GridPaneWrapper gridPaneWrapper;


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
         panel=panelFabric.innerContentPanel(
            new AbstractPanel.PanelBuilder()
                    .setPanelCoordinate(new Coordinate(10d, 10d, 10d, 10d)))
                .getPanel();
    }

    protected void createGridBasedPanel(){
        gridPaneWrapper = AppNode.NodeBuilder.create()
                .setParent(panel)
                .setCoordinate(new Coordinate(0d,0d,0d,0d))
                .createGridPaneWrapper();

    }
    
    
    
    
    
}
