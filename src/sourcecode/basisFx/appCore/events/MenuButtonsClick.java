package basisFx.appCore.events;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.menu.FontItemLeaf;
import basisFx.appCore.menu.LeftAndTopMenuRepresent;
import basisFx.appCore.settings.CSSid;
import basisFx.appCore.utils.Registry;
import basisFx.appCore.windows.WindowAbstraction;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class MenuButtonsClick extends AppEvent{

    protected FontItemLeaf fontItemLeaf;
    protected LeftAndTopMenuRepresent represent;

    protected  Button  but;

    public MenuButtonsClick(FontItemLeaf component,LeftAndTopMenuRepresent represent ) {
        this.fontItemLeaf = component;
        this.represent=represent;

    }

    @Override
    public void setEventToElement(AppNode node) {
        this.but=(Button) node.getElement();

        but.setOnMouseClicked((event) -> {

            represent.setDefaultStyleHorisontalButtons();
            but.setId(CSSid.LEFT_SIDE_MENU_HORIZONTAL_BUTTONS_CLICKED.get());

            run();
        });

    }

    @Override
    public void setEventToElement(Node node) {

    }

    @Override
    public void run() {
        clearContent();
        fontItemLeaf.getDynamicElementsCreator().create().initTemplateMethod(Registry.mainWindow);


    }

    private void clearContent() {
        AppNode node = Registry.mainWindow.getAppNode(WindowAbstraction.DefaultPanelsNames.mainContentAnchor.name());
        AnchorPane mainContentAnchor = ((AnchorPane) node.getElement());
        mainContentAnchor.getChildren().clear();
        Registry.mainWindow.clearCurrentDynamicContentPanel();
    }

}
