package basisFx.appCore.menu;

import basisFx.appCore.elements.ButtonWrapper;
import basisFx.appCore.events.MenuButtonsClick;
import basisFx.appCore.events.leftSideMenuIconClick;
import basisFx.appCore.settings.CSSclasses;
import java.util.ArrayList;
import java.util.Iterator;

import basisFx.appCore.settings.FontsStore;
import basisFx.appCore.utils.FXMLLoader;
import basisFx.appCore.utils.FontLogic;
import basisFx.appCore.utils.Registry;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class LeftAndTopBar extends MenuRepresent {
    protected Label label = ((Label) Registry.mainWindow.getNodeFromMap("commonMenuLabel"));
    protected HBox horisontalMenuButHolder = ((HBox) Registry.mainWindow.getNodeFromMap("horisontalMenuButHolder"));
    protected VBox vButHolder = (VBox) Registry.mainWindow.getNodeFromMap("vButHolder")  ;
    protected AnchorPane contentAnchorPane = (AnchorPane) Registry.mainWindow.getNodeFromMap("mainContentAnchor")  ;
    private ArrayList<ButtonWrapper> buttonWrappers=new ArrayList<>();
    private leftSideMenuIconClick startButEvent;

    public LeftAndTopBar(MenuSketch sketch) {
        label.setText("");
        makeStructuredMenuView(sketch.getComponents(), null);
        setDefaultStyleVerticalButtons();
        setDefaultStyleHorisontalButtons();
        fireStartButton();
    }

    private void fireStartButton() {
        startButEvent.run();
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
//        //создание кнопок вертикальных
//        ButtonWrapper wrapper = ButtonWrapper.newBuilder()
//                .setCssClasses(CSSclasses.LEFT_SIDE_MENU_VERTICAL_BUTTONS)
//                .setText(composite.fontSymbol)
//                .setFont(composite.fontsStore)
//                .setIsActive(composite.isActive)
//                .setFontSize(composite.fontSize)
//                .setEvents(new leftSideMenuIconClick(verticalBut, this))
//                .setParentVBox(vButHolder)
//                .build();
//        buttonWrappers.add(wrapper);


        Button button = FXMLLoader.loadButton(composite.fxmlFileName);
        button.setText(composite.fontSymbol);
        button.setFont(FontLogic.loadFont(composite.fontsStore,composite.fontSize));
        vButHolder.getChildren().add(button);
        leftSideMenuIconClick clickEvent = new leftSideMenuIconClick(verticalBut, this,button);
        if (composite.isActive) {
            startButEvent=clickEvent;
        }

    }
    public void setDefaultStyleHorisontalButtons() {
        ObservableList<Node> buttons = horisontalMenuButHolder.getChildren();
        for (Iterator<Node> iterator = buttons.iterator(); iterator.hasNext(); ) {
            Node next = iterator.next();
            if (next instanceof Button) {
                next.getStyleClass().clear();
                next.getStyleClass().add(CSSclasses.LEFT_SIDE_MENU_HORIZONTAL_BUTTONS.name());
            }
        }
    }
    public void setDefaultStyleVerticalButtons() {
        ObservableList<Node> buttons = vButHolder.getChildren();
        for (Iterator<Node> iterator = buttons.iterator(); iterator.hasNext(); ) {
            Node next = iterator.next();
            if (next instanceof Button) {
                next.getStyleClass().clear();
                next.getStyleClass().add(CSSclasses.LEFT_SIDE_MENU_VERTICAL_BUTTONS.name());
            }
//            buttons.get(0).getStyleClass().add(CSSclasses.LEFT_SIDE_MENU_VERTICAL_BUTTONS_FIRST.name());
        }
    }
    public void setCommonTextName(FontItemComposite itemComposite) {
        label.setText(itemComposite.getDescription());
    }
    public void setHorisontalButtons(FontItemComposite itemComposite) {
        horisontalMenuButHolder.getChildren().clear();
        if (itemComposite.isComposit()) {
            contentAnchorPane.getChildren().clear();
            ArrayList<MenuComponent> inerLevelComponents = itemComposite.getChilds();
            for (Iterator<MenuComponent> iterator1 = inerLevelComponents.iterator(); iterator1.hasNext(); ) {
                FontItemLeaf innerLevelComponent = (FontItemLeaf) iterator1.next();
                //создание кнопок горизонтальных
                ButtonWrapper.newBuilder()
                        .setCssClasses(CSSclasses.LEFT_SIDE_MENU_HORIZONTAL_BUTTONS)
                        .setText(innerLevelComponent.getDescription())
                        .setFont(FontsStore.ROBOTO_LIGHT)
                        .setEvents(new MenuButtonsClick(innerLevelComponent,this))
                        .setParentHBox(horisontalMenuButHolder)
                        .build();
            }
        }
        ObservableList<Node> children = horisontalMenuButHolder.getChildren();
        if (!children.isEmpty()) {
            Node node = children.get(0);
            if (node != null) {
                node.getStyleClass().add(CSSclasses.LEFT_SIDE_MENU_VERTICAL_BUTTONS_FIRST.name());
            }

        }

    }
}




