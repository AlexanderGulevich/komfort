package basisFx.domainModel;

import basisFx.appCore.utils.AnchorCoordinate;
import basisFx.appCore.MenuTrigger;
import basisFx.appCore.dataSource.DbFactory;
import basisFx.domainModel.settings.Settings;
import javafx.stage.Stage;
import basisFx.appCore.menu.MenuCreator;
import basisFx.appCore.menu.MenuFabric;
import basisFx.appCore.registry.Layers;
import java.sql.SQLException;
import basisFx.appCore.panels.AbstractPanel;
import basisFx.appCore.panels.PanelFabric;
import basisFx.appCore.windows.TitleFabric;
import basisFx.appCore.windows.WindowFabric;

/**
 *
 * @author Alek
 */
public class App{
    
    private WindowFabric windowFabric=new WindowFabric();
    private TitleFabric  titleFabric =new TitleFabric();
    private PanelFabric  panelFabric =new PanelFabric();
    private MenuTrigger  menuTrigger =new MenuTrigger();
    private MenuFabric   menuFabric  =new MenuFabric();
    
    

    public App(Stage primaryStage) throws ClassNotFoundException, SQLException {
        
        new DbFactory().createDbServer();
        
        

        windowFabric.createUnDecoratedWindow(Settings.WIDTH, Settings.HEIGHT, primaryStage)
                .setPanel(panelFabric.createContentPanel(//ПАНЕЛЬ ДИНАМИЧЕСКОГО КОНТНЕНТА 
                                new AbstractPanel.PanelBuilder()
                                .setPanelCoordinate(new AnchorCoordinate(50d,0d,0d,60d))
                                .setParent(Layers.getVisibleRoot())
                        ))
                .setPanel(panelFabric.createTitlePanel(//ПАНЕЛЬ С ЗАГЛАВИЕМ
                                new AbstractPanel.PanelBuilder().setHeight(50d)
                                .setPanelCoordinate(new AnchorCoordinate(0d,0d,null,0d))
                                .setParent(Layers.getVisibleRoot())
                        ))
                .setPanel(panelFabric.createVerticalMenuPanel(//ВЕРТИКАЛЬНОЕ МЕНЮ
                                new AbstractPanel.PanelBuilder().setWidth(60d)
                                .setPanelCoordinate(new AnchorCoordinate(0d,null,0d,0d))
                                .setParent(Layers.getVisibleRoot())
                        ))
                .setPanel(panelFabric.createHorisontalFlowPanel(//ГОРИЗОНТАЛЬНОЕ МЕНЮ
                                new AbstractPanel.PanelBuilder().setHeight(35d)
                                .setPanelCoordinate( new AnchorCoordinate(49d,0d,null,60d))
                                .setParent(Layers.getVisibleRoot())
                        ))
                .setPanel(panelFabric.createTextAnchorPanel(//Текстовая панель вывода
                                new AbstractPanel.PanelBuilder().setHeight(35d)
                                .setPanelCoordinate( new AnchorCoordinate(20d, 70d, 0d, null))
                                .setParent(Layers.getTitlePanel())
                        ))
                .setTitle(titleFabric.createImageTitle()//КАРТИНКА С ЗАГЛАВИЕМ
                                .setTitleCoordinate(new AnchorCoordinate(10d, null, null, 70d))
                                .setTitlePanel(Layers.getTitlePanel())
                                .getInstance()
                )
                .setIconAnchor(
                        new AnchorCoordinate(0d, 0d, null, 0d), 
                        Layers.getVerticalMenuPanel())
                .windowShow();
        
       
        
        
        MenuCreator.create()
                .setMenuSketch(new MainMenuSketch())
                .setRepresent(
                     menuFabric.createMenuLeftSideRepresentation()
                ).init();
        
        
        menuTrigger.verticalMenuButtonFire(1);
        
       

    }
    
}
