package basisFx.appCore.events;

import basisFx.dataSource.Db;
import basisFx.appCore.elements.AppNode;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;

public class CloseMainWindow extends AppEvent{
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

//Todo Db.getSonicServer().shutdown();
            if (Db.sonicServer != null) {
                Db.sonicServer.shutdown();
            }
            if (Db.connection!= null) {
                Db.connection.close();

            }

            Thread.sleep(500);
            nodeWrapper.getStage().close();
            System.exit(0);

            } catch (InterruptedException ex) {
                Logger.getLogger(CloseMainWindow.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException e) {
            e.printStackTrace();
        }

    }



}
