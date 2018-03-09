/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.windows;

import basisFx.domainModel.settings.Settings;
import basisFx.domainModel.settings.WindowsTitlesNames;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author 62
 */
public class WindowDecorated extends WindowFx{

    public WindowDecorated(double w,double h) { 
        this.root=new AnchorPane();
        this.width=w;
        this.height=h;
        this.stage=new Stage();
      
        
    }

    public WindowDecorated(double w,double h, Stage primaryStage) {
        this.root=new AnchorPane();
        this.width=w;
        this.height=h;
        this.stage=primaryStage;
        stage.setTitle(WindowsTitlesNames.MAIN_WINDOW_NAME.get());
      
 
    }
    

    @Override
    void initIcon() {
        
          stage.getIcons().add(
                new Image(getClass().getResourceAsStream(Settings.TITLEICONDIR
                )));
    }

    @Override
    void initControlTopButton() {

    }
    
    @Override
    void initTitle() {}

   

    @Override
    public WindowFx windowShow() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
    
    
    
    
    
}
