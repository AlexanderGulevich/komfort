package basisFx.appCore.events;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.utils.Registry;
import basisFx.dataSource.Db;
import javafx.scene.control.Button;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClosePopupWindow extends AppEvent{
    protected Button  but;
    @Override
    public void setEventToElement(AppNode n) {

        this.nodeWrapper =n;
        this.but=(Button) n.getElement();


        but.setOnMouseClicked((event) -> {
            run();
        }
        ) ;

    }

    @Override
    public void run() {
        try {

            Thread.sleep(500);
            nodeWrapper.getStage().close();
            Registry.infoWindow=null;

            } catch (InterruptedException ex) {
                Logger.getLogger(ClosePopupWindow.class.getName()).log(Level.SEVERE, null, ex);
            }

    }



}
