/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.fabrics;

import basisFx.presentation.appStructura.GuiStructura;
import basisFx.appCore.windows.*;
import javafx.stage.Stage;

public abstract class WindowFabric {

    public abstract WindowAbstraction mainWindow(GuiStructura guiStructura, Stage st);
    public abstract WindowAbstraction errorWindow(GuiStructura guiStructura);
    public abstract WindowAbstraction dialogWindow(GuiStructura guiStructura);
    public abstract WindowAbstraction infoWindow(String message);
    public abstract WindowAbstraction tooltipWindow(GuiStructura guiStructura);

    public static WindowFabric WindowDecoratedFabric(){

        return new WindowDecoratedFabric();
    }

    public static WindowFabric WindowUndecoratedFabric(){
        return new WindowUndecoratedFabric();
    }


}
