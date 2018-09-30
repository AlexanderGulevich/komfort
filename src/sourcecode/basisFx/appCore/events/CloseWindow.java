package basisFx.appCore.events;

import basisFx.dataSource.Db;
import basisFx.appCore.elements.AppNode;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;

public class CloseWindow extends AppEvent{
    protected Button  but;
    @Override
    public void setEventToElement(AppNode n) {

        this.nodeWrapper =n;
        this.but=(Button) n.getElement();


        but.setOnMouseClicked((event) -> {
                    System.out.println("CloseWindow.setEventToElement");
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
                nodeWrapper.getStage().close();
                System.exit(0);


            } catch (InterruptedException ex) {
                Logger.getLogger(CloseWindow.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException e) {
            e.printStackTrace();
        }

    }



}
