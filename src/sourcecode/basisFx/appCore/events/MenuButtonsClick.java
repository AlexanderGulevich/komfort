package basisFx.appCore.events;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.menu.FontItemLeaf;
import basisFx.appCore.menu.LeftAndTopMenuRepresent;
import basisFx.appCore.settings.CSSID;
import basisFx.appCore.utils.Registry;
import basisFx.appCore.windows.WindowImplMain;
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
            but.setId(CSSID.LEFT_SIDE_MENU_HORIZONTAL_BUTTONS_CLICKED.get());

            run();
        });

    }

    @Override
    public void run() {
        clearChildren();
        fontItemLeaf.getDynamicElementsCreator().create().init();


    }

    private void clearChildren() {

        AppNode node = Registry.mainWindow.getNode("contentAnchorPane_mainWindow");
        AnchorPane element = ((AnchorPane) node.getElement());


        element.getChildren().clear();
    }

}
