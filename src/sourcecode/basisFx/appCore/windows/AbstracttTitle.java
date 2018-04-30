/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.windows;

import basisFx.appCore.utils.Coordinate;
import basisFx.appCore.interfaces.Initiated;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Alek
 */
public abstract class AbstracttTitle implements Initiated{
    
    
    protected AnchorPane titlePanel;

    protected Coordinate titleNameCoordinate;
    
    public abstract void init();
    public abstract AbstracttTitle getInstance();
    
    public AbstracttTitle setTitleCoordinate(Coordinate c){
          this.titleNameCoordinate=c;
          return this;
      }
    
    public AbstracttTitle setTitlePanel(AnchorPane ap){
          this.titlePanel=ap;
          return this;
      }
      
}
