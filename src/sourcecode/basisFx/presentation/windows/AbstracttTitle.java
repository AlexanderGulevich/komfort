/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.presentation.windows;

import basisFx.appCore.utils.Coordinate;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Alek
 */
public abstract class AbstracttTitle {
    
    
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
