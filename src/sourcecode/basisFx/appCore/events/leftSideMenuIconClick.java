package basisFx.appCore.events;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.menu.LeftAndTopBarItemComposite;
import basisFx.appCore.menu.LeftAndTopBarRepresetation;
import basisFx.appCore.menu.MenuComponent;
import basisFx.appCore.settings.CSSclasses;
import javafx.scene.Node;
import javafx.scene.control.Button;

public class leftSideMenuIconClick extends AppEvent{
    protected LeftAndTopBarItemComposite component;
    protected LeftAndTopBarRepresetation represent;
    protected Button  but;


    public leftSideMenuIconClick(MenuComponent component, LeftAndTopBarRepresetation represent) {
        this.represent=represent;
        this.component = (LeftAndTopBarItemComposite) component;
    }

    public leftSideMenuIconClick(MenuComponent component, LeftAndTopBarRepresetation represent, Button button) {
        this.represent=represent;
        this.component = (LeftAndTopBarItemComposite) component;
        setEventToElement(button);
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
        but= ((Button) node);

        but.setOnAction((event) -> {
            run();
        });

    }

    @Override
    public void run() {

        represent.setDefaultStyleVerticalButtons();
        represent.setCommonTextName(component);
        represent.setHorisontalButtons(component);
        but.getStyleClass().clear();
        but.getStyleClass().add(CSSclasses.LEFT_SIDE_MENU_VERTICAL_BUTTONS_CLICKED.get());

             }



    }







