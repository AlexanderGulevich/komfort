package basisFx.appCore.events;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.menu.LeftAndTopBarItemLeaf;
import basisFx.appCore.menu.LeftAndTopBar;
import basisFx.appCore.settings.CSSclasses;
import basisFx.appCore.utils.Registry;
import basisFx.appCore.windows.WindowAbstraction;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class MenuButtonsClick extends AppEvent{

    protected LeftAndTopBarItemLeaf LeftAndTopBarItemLeaf;
    protected LeftAndTopBar represent;

    protected  Button  but;

    public MenuButtonsClick(LeftAndTopBarItemLeaf component, LeftAndTopBar represent ) {
        this.LeftAndTopBarItemLeaf = component;
        this.represent=represent;

    }

    @Override
    public void setEventToElement(AppNode node) {
        this.but=(Button) node.getElement();

        but.setOnMouseClicked((event) -> {

            represent.setDefaultStyleHorisontalButtons();
            but.getStyleClass().add(CSSclasses.LEFT_SIDE_MENU_HORIZONTAL_BUTTONS_CLICKED.get());

            run();
        });

    }

    @Override
    public void setEventToElement(Node node) {

    }

    @Override
    public void run() {
        clearContent();
        LeftAndTopBarItemLeaf.getPanelCreator().create().initTemplateMethod(Registry.mainWindow);


    }

    private void clearContent() {
        AnchorPane mainContentAnchor =
                (AnchorPane)  Registry.mainWindow.getNodeFromMap(WindowAbstraction.DefaultPanelsNames.mainContentAnchor.name());
        mainContentAnchor.getChildren().clear();
        Registry.mainWindow.closeDynamicContentPanel();
    }

}
