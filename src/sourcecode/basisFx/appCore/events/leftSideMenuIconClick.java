package basisFx.appCore.events;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.menu.FontItemComposite;
import basisFx.appCore.menu.LeftAndTopMenuRepresent;
import basisFx.appCore.menu.MenuComponent;
import basisFx.appCore.settings.CSSid;
import javafx.scene.Node;
import javafx.scene.control.Button;

public class leftSideMenuIconClick extends AppEvent{
    protected FontItemComposite component;
    protected LeftAndTopMenuRepresent represent;
    protected Button  but;


    public leftSideMenuIconClick(MenuComponent component,LeftAndTopMenuRepresent represent) {
        this.represent=represent;
        this.component = (FontItemComposite) component;
    }

    @Override
    public void setEventToElement(AppNode n) {
        but=(Button) n.getElement();

        but.setOnAction((event) -> {
            run();
        });


    }

    @Override
    public void setEventToElement(Node node) {

    }

    @Override
    public void run() {

        represent.setDefaultStyleVerticalButtons();
        represent.setCommonTextName(component);
        represent.setHorisontalButtons(component);
        but.setId(CSSid.LEFT_SIDE_MENU_VERTICAL_BUTTONS_CLICKED.get());



             }



    }







