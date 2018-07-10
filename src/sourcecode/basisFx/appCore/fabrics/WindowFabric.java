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
public interface WindowFabric {

    public void createWindow();
    public WindowAbstraction createWindow(WindowImplimentation impl);
    public WindowAbstraction createWindow(Stage st,WindowImplimentation impl);
     
}
