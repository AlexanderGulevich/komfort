/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.windows;

import javafx.stage.Stage;

/**
 *
 * @author Alek
 */
public class WindowFabric {
    
     
     public  WindowFx createPopapDecoratedWindow(double width, double height){
     
         return new WindowDecorated(width, height);

     }
     
     public  WindowFx createDecoratedWindow(double width, double height, Stage stage){
     
         return new WindowDecorated(width, height, stage);

     }

     public  WindowUndecorated createPopapUnDecoratedWindow(double width, double height){
     
         return new WindowUndecorated(width, height);

     }
     
     public  WindowUndecorated createUnDecoratedWindow(double width, double height, Stage stage){
     
         return new WindowUndecorated(width, height, stage);

     }
     
}
