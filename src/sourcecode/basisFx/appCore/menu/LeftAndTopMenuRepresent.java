package basisFx.appCore.menu;

import basisFx.appCore.elements.ButtonWrapper;
import basisFx.appCore.events.MenuButtonsClick;
import basisFx.appCore.events.leftSideMenuIconClick;
import basisFx.appCore.settings.CSSID;
import java.util.ArrayList;
import java.util.Iterator;
import basisFx.appCore.settings.FontsStore;
import basisFx.appCore.utils.Coordinate;
import basisFx.appCore.windows.WindowImplMain;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;

public class LeftAndTopMenuRepresent extends MenuRepresent {

    protected Text text = ((Text) WindowImplMain.getInstance().getWindowNode("leftCideMenuCommonText").getElement());
    protected FlowPane horisontalFlowPane = ((FlowPane) WindowImplMain.getInstance().getWindowNode("horisontalMenuFlowPane").getElement());
    protected AnchorPane verticalMenuAnchorPane = (AnchorPane) WindowImplMain.getInstance().getWindowNode("verticalMenuAnchorWrapper").getElement();
    protected AnchorPane contentAnchorPane = (AnchorPane) WindowImplMain.getInstance().getWindowNode("contentAnchorPane").getElement();
    private double heightCounterForIcon = 0d;
    private ArrayList<ButtonWrapper> buttonWrappers=new ArrayList<>();

    public LeftAndTopMenuRepresent(MenuSketch sketch) {
        text.setText("");
        makeStructuredMenuView(sketch.getComponents(), null);
        setDefaultStyleVerticalButtons();
        setDefaultStyleHorisontalButtons();
        fireActiveMarckedButton();
    }

    private void fireActiveMarckedButton() {
        for (ButtonWrapper wrapper:buttonWrappers) {
            if (wrapper.isActive()){
                wrapper.makeActive();

            }
        }
    }

    @Override
    protected <T> void makeStructuredMenuView(MenuComponent c, MenuComposite parentMenu) {
        ArrayList<MenuComponent> components = null;
        if (c.isComposit()) {
            components = ((MenuComposite) c).getChilds();
            seachVerticalBut(components);
        } else {

        }

    }

    private void seachVerticalBut(ArrayList<MenuComponent> components) {
        for (Iterator<MenuComponent> iterator = components.iterator(); iterator.hasNext(); ) {
            MenuComponent verticalBut = iterator.next();

            if (verticalBut.isComposit()) {
                createVerticalBut((FontItemComposite) verticalBut);
            }

        }
    }

    private void createVerticalBut(FontItemComposite verticalBut) {
        FontItemComposite composite = verticalBut;

        this.heightCounterForIcon += 50d;

        //создание кнопок вертикальных
        ButtonWrapper wrapper = ButtonWrapper.newBuilder()
                .setCSSid(CSSID.LEFT_SIDE_MENU_VERTICAL_BUTTONS)
                .setCoordinate(new Coordinate(heightCounterForIcon, 0d, null, 0d))
                .setName(composite.fontSymbol)
                .setFont(composite.fontsStore)
                .setIsActive(composite.isActive)
                .setFontSize(composite.fontSize)
                .setEvents(new leftSideMenuIconClick(verticalBut, this))
                .setParentAnchor((AnchorPane) WindowImplMain.getInstance().getWindowNode("verticalMenuAnchorWrapper").getElement())
                .build();

        buttonWrappers.add(wrapper);
    }


    public void setDefaultStyleHorisontalButtons() {

        ObservableList<Node> buttons = (
                (FlowPane) WindowImplMain.getInstance().getWindowNode("horisontalMenuFlowPane").getElement()).getChildren();

        for (Iterator<Node> iterator = buttons.iterator(); iterator.hasNext(); ) {
            Node next = iterator.next();

            if (next instanceof Button) {

                next.setId(CSSID.LEFT_SIDE_MENU_HORIZONTAL_BUTTONS.get());
            }

        }
    }

    public void setDefaultStyleVerticalButtons() {

        ObservableList<Node> buttons = verticalMenuAnchorPane.getChildren();

        for (Iterator<Node> iterator = buttons.iterator(); iterator.hasNext(); ) {
            Node next = iterator.next();

            if (next instanceof Button) {

                next.setId(CSSID.LEFT_SIDE_MENU_VERTICAL_BUTTONS.get());
            }

        }
    }

    public void setCommonTextName(FontItemComposite itemComposite) {

        text.setText(itemComposite.getDescription());

    }


    public void setHorisontalButtons(FontItemComposite itemComposite) {

        horisontalFlowPane.getChildren().clear();

        if (itemComposite.isComposit()) {

            contentAnchorPane.getChildren().clear();

            ArrayList<MenuComponent> inerLevelComponents = itemComposite.getChilds();
//
            for (Iterator<MenuComponent> iterator1 = inerLevelComponents.iterator(); iterator1.hasNext(); ) {
                FontItemLeaf innerLevelComponent = (FontItemLeaf) iterator1.next();

                //создание кнопок горизонтальных
                ButtonWrapper.newBuilder()
                        .setCSSid(CSSID.LEFT_SIDE_MENU_HORIZONTAL_BUTTONS)
                        .setName(innerLevelComponent.getDescription())
                        .setFont(FontsStore.ROBOTO_LIGHT)
//                        .setFontSize( 17d)
                        .setEvents(new MenuButtonsClick(innerLevelComponent,this))
                        .setParentFlowPane(horisontalFlowPane)
                        .build();

//
            }
//


        }


    }
}




