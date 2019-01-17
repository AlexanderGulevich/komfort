package basisFx;

import basisFx.appCore.fabrics.*;
import basisFx.appCore.menu.MenuFabric;
import basisFx.appCore.settings.Settings;
import basisFx.appCore.settings.StylesPathes;
import basisFx.appCore.utils.CSSHandler;
import basisFx.appCore.utils.IconToPlatform;
import basisFx.appCore.utils.Registry;
import basisFx.appCore.windows.ButtonsForStageThreeEntity;
import basisFx.appCore.windows.WindowAbstraction;
import basisFx.appCore.windows.WindowBuilder;
import basisFx.presentation.MainMenuSketch;
import basisFx.appCore.guiStructura.LeftAndTopMenuGUI;
import javafx.stage.Stage;
import java.sql.SQLException;

public class App{

    public App(Stage primaryStage) throws ClassNotFoundException, SQLException {
        IconToPlatform.init(primaryStage);
        CSSHandler.init(StylesPathes.CUSTOM_1);
        WindowFabric.WindowUndecorated();

        Registry.windowFabric.mainWindow(primaryStage,
                WindowBuilder.newBuilder()
                        .setGUIStructura(new LeftAndTopMenuGUI())
                        .setButtonsForStage(new ButtonsForStageThreeEntity(LeftAndTopMenuGUI.Structura.titleAnchor.name()))
                        .setFxmlFileName(null)
                        .setParentAnchorNameForFXML(null)
                        .setWidth(Settings.WIDTH)
                        .setHeight(Settings.HEIGHT)
                        .setDynamicContentPanelCreator(null)
                        .setTitle(Settings.TITLE)
                        .setMessage(null)
                        .build()
                );
        DbFactory.createDbServer();
        MenuFabric.menuLeftAndTopRepresentation( new MainMenuSketch());


//        ScenicView.show(WindowImplMain.getInstance().getWindowAbstraction().getScene());

//        Registry.windowFabric.customSubWindow(
//                WindowBuilder.newBuilder()
//                        .setGUIStructura(null)
//                        .setButtonsForStage(null)
//                        .setFxmlFileName("ByDateResearchWindow")
//                        .setParentAnchorNameForFXML(WindowAbstraction.DefaultPanelsNames.topVisibleAnchor.name())
//                        .setWidth(900d)
//                        .setHeight(600d)
//                        .setDynamicContentPanelCreator(null)
//                        .setTitle(null)
//                        .setMessage(null)
//                        .build()
//        );
//        Registry.windowFabric.customSubWindow(
//                WindowBuilder.newBuilder()
//                        .setGUIStructura(null)
//                        .setButtonsForStage(null)
//                        .setFxmlFileName("EmployerHire")
//                        .setParentAnchorNameForFXML(WindowAbstraction.DefaultPanelsNames.topVisibleAnchor.name())
//                        .setWidth(530d)
//                        .setHeight(350d)
//                        .setDynamicContentPanelCreator(null)
//                        .setTitle(null)
//                        .setMessage(null)
//                        .build()
//        );
//        Registry.windowFabric.customSubWindow(
//                WindowBuilder.newBuilder()
//                        .setGUIStructura(null)
//                        .setButtonsForStage(null)
//                        .setFxmlFileName("AddDellPopupTable")
//                        .setParentAnchorNameForFXML(WindowAbstraction.DefaultPanelsNames.topVisibleAnchor.name())
//                        .setWidth(720d)
//                        .setHeight(500d)
//                        .setDynamicContentPanelCreator(null)
//                        .setTitle(null)
//                        .setMessage(null)
//                        .build()
//        );
//        Registry.windowFabric.infoWindow("yhyntyn");
//
//        Registry.windowFabric.customSubWindow(
//                WindowBuilder.newBuilder()
//                        .setGUIStructura(null)
//                        .setButtonsForStage(null)
//                        .setFxmlFileName("YN")
//                        .setParentAnchorNameForFXML(WindowAbstraction.DefaultPanelsNames.topVisibleAnchor.name())
//                        .setHeight(230d)
//                        .setWidth(500d)
//                        .setDynamicContentPanelCreator(null)
//                        .setTitle(null)
//                        .setMessage(null)
//                        .build()
//        );






    }
    
}
// ColumnWrapperSubWindow.newBuilder()
//         .setColumnSize(1d)
//         .setPropertyName("ftgnfrg")
//         .setCurrentWindow(window)
//         .setIsEditeble(true)
//         .setWindowBuilder(
//         WindowBuilder.newBuilder()
//         .setFxmlFileName("q")
//         .setParentAnchorNameForFXML(
//         WindowAbstraction.DefaultPanelsNames.topVisibleAnchor.name())
//         .setHeight(400d)
//         .setWidth(800d)
//         .setTitle("111111111")
//         .build()
//         ).build()

//todo
//todo
//todo
//todo
//todo
//todo
//todo
//todo
//todo
//todo
//todo
//todo
//todo
//todo
//todo
//todo
//todo
//todo
//todo
//todo
//todo
//todo


//     todo           Platform.runLater(() -> {
//
//
//                    DefaultPanelsNames message="В Базе Данных уже есть значение на дату: "
//                            + date.toString()+
//                            ". Создать новую запись с такой же датой нельзя." +
//                            " Вы можете изменить старую, либо удалить ее.";
//                });
//


