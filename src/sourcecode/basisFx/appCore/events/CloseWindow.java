/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.events;

import basisFx.appCore.dataSource.Db;
import basisFx.appCore.elements.AppNode;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;


/**
 *
 * @author 62
 */
public class CloseWindow extends AppEvent{
    protected Button  but;
    @Override
    public void setElement(AppNode n) {
        
        this.appNode=n;
        this.but=(Button) n.getElement();
        
        
        but.setOnMouseClicked((event) -> {
            
            run();
        }
        
        ) ;
        
        

    }

    @Override
    public void run() {
        try {

//Todo Db.getSonicServer().shutdown();
            if (Db.getSonicServer() != null) {
                Db.getSonicServer().shutdown();
            }

                Db.getConnection().close();
                Thread.sleep(500);
                appNode.getStage().close();
                System.exit(0);


            } catch (InterruptedException ex) {
                Logger.getLogger(CloseWindow.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException e) {
            e.printStackTrace();
        }

    }

  
    
}
