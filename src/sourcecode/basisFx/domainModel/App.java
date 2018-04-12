package basisFx.domainModel;

import basisFx.appCore.appStructura.AppStructuraFabric;
import basisFx.appCore.dataSource.DbFactory;
import javafx.stage.Stage;

import java.sql.SQLException;

/**
 *
 * @author Alek
 */
public class App{

    AppStructuraFabric appStructuraFabric=new AppStructuraFabric();

    

    public App(Stage primaryStage) throws ClassNotFoundException, SQLException {
        
        new DbFactory().createDbServer();

        appStructuraFabric.createLeftSideIconMenuStructura(primaryStage);
        

       

    }
    
}
