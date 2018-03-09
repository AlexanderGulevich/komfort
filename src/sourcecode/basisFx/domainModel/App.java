package basisFx.domainModel;

import basisFx.appCore.AnchorCoordinate;
import basisFx.appCore.dataSource.DbFactory;

import basisFx.domainModel.settings.Settings;
import javafx.stage.Stage;
import basisFx.appCore.menu.MenuCreator;
import basisFx.appCore.menu.MenuRepresent;
import basisFx.appCore.registry.Layers;
import java.sql.SQLException;
import basisFx.appCore.menu.LeftSideMenuRepresent.namesPanelPalaced;
import basisFx.appCore.windows.AbstractPanel;
import basisFx.appCore.windows.PanelFabric;
import basisFx.appCore.windows.TitleFabric;
import basisFx.appCore.windows.WindowFabric;

/**
 *
 * @author Alek
 */
public class App{
    
    private WindowFabric windowFabric=new WindowFabric();
    private TitleFabric titleFabric=new TitleFabric();
    private PanelFabric panelFabric=new PanelFabric();

    public App(Stage primaryStage) throws ClassNotFoundException, SQLException {
        
        new DbFactory().createDbServer();
        

        windowFabric.createUnDecoratedWindow(Settings.WIDTH, Settings.HEIGHT, primaryStage)
                .setPanel(panelFabric.createContentPanel(
                                new AbstractPanel.PanelBuilder()
                                .setPanelCoordinate(new AnchorCoordinate(40d,0d,0d,60d))
                                .setParent(Layers.getVisibleRoot())
                        ))
                .setPanel(panelFabric.createTitlePanel(
                                new AbstractPanel.PanelBuilder()
                                .setPanelCoordinate(new AnchorCoordinate(0d,0d,null,0d))
                                .setParent(Layers.getVisibleRoot())
                        ))
                .setTitle(
                        titleFabric.createImageTitle()
                                .setTitleCoordinate(new AnchorCoordinate(5d, null, null, 70d))
                                .setTitlePanel(Layers.getTitlePanel())
                                .getInstance()
                )
                .windowShow();
        
        
        
        
        MenuCreator.create()
                .setParentAnchor(Layers.getVisibleRoot())
                .setCoordinate(new AnchorCoordinate(40d, null, 0d, 0d))
                .setMenuSketch(new MainMenuSketch())
                .setRepresent(
                     MenuRepresent.menuLeftSideFabric(namesPanelPalaced.CONTENT_PANEL)
                ).init();

    }
    
}
