/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.fabrics;

import basisFx.appCore.windows.*;
import javafx.stage.Stage;

/**
 *
 * @author Alek
 */
public class WindowFabric {


    public  WindowUndecorated unDecoratedWindow(double width, double height, Stage stage){

        return new WindowUndecorated(width, height, stage);

    }
     public  WindowFx decoratedWindow(double width, double height, Stage stage){
     
         return new WindowDecorated(width, height, stage);

     }



    public PopupUndecorated popupUndecorated(KindOfPopup kindOfPopup){

        return new PopupUndecorated(kindOfPopup);

    }


    public PopupUndecorated popupUndecorated(double width, double height, KindOfPopup kindOfPopup){

        return new PopupUndecorated(width,height,kindOfPopup);

    }

    public WindowFx popupDecorated(double width, double height){

        return new WindowDecorated(width, height);

    }

     
}
