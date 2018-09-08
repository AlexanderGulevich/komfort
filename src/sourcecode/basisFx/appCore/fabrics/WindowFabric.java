/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.fabrics;

import basisFx.presentation.appStructura.GuiStructura;
import basisFx.appCore.windows.*;
import javafx.stage.Stage;


/**
 *
 * @author Alek
 */
public abstract class WindowFabric {

    public abstract Window mainWindow(GuiStructura guiStructura,Stage st);
    public abstract Window errorWindow(GuiStructura guiStructura);
    public abstract Window dialogWindow(GuiStructura guiStructura);
    public abstract Window popupWindow(GuiStructura guiStructura);
    public abstract Window tooltipWindow(GuiStructura guiStructura);

    public static WindowFabric WindowDecoratedFabric(){

        return new WindowDecoratedFabric();
    }

    public static WindowFabric WindowUndecoratedFabric(){
        return new WindowUndecoratedFabric();
    }


}
