package basisFx.appCore.events;

import basisFx.appCore.dataSource.Db;
import basisFx.appCore.elements.AppNode;
import javafx.scene.control.Button;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClosePopup extends AppEvent{
    protected Button but;
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
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        appNode.getStage().close();





    }

}
