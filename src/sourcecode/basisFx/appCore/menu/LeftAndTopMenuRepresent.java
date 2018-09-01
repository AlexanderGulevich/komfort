package basisFx.appCore.menu;

import basisFx.appCore.elements.ButtonWrapper;
import basisFx.appCore.events.leftSideMenuIconClick;
import basisFx.appCore.settings.CSSID;

import java.util.ArrayList;
import java.util.Iterator;

import basisFx.appCore.utils.Coordinate;
import basisFx.presentation.windows.MainWindow;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;

/**
 *
 * @author Alek
 */
public class LeftAndTopMenuRepresent extends MenuRepresent{


    private double heightCounterForIcon=0d;

    public LeftAndTopMenuRepresent(MenuSketch sketch) {
        makeStructuredMenuView(sketch.getComponents(),null);
        setDefaultStyleVerticalButtons();
        setDefaultStyleHorisontalButtons();
    }

    @Override
    protected  <T> void makeStructuredMenuView(MenuComponent c, MenuComposite parentMenu) {
        ArrayList<MenuComponent> components=null;
        if (c.isComposit()) {
            components= ((MenuComposite) c).getChilds();
            seachVerticalBut(components);
        }else {

        }

    }

    private void seachVerticalBut(ArrayList<MenuComponent> components) {
        for (Iterator<MenuComponent> iterator = components.iterator(); iterator.hasNext();) {
            MenuComponent verticalBut = iterator.next();

            if (verticalBut.isComposit()) {
                createVerticalBut((FontItemComposite) verticalBut);
            }

            }
    }

    private void createVerticalBut(FontItemComposite verticalBut) {
        FontItemComposite composite = verticalBut;

        this.heightCounterForIcon+=50d;

        //создание кнопок вертикальных
        ButtonWrapper.newBuilder()
                .setCssid(CSSID.LEFT_SIDE_MENU_VERTICAL_BUTTONS)
                .setCoordinate(new Coordinate(heightCounterForIcon, 0d, null, 0d))
                .setName(composite.fontSymbol)
                .setFont(composite.fontsStore)
                .setFontSize(composite.fontSize)
                .setEvents(new leftSideMenuIconClick(verticalBut))
                .setParentAnchor((AnchorPane) MainWindow.getInstance().getWindowNode("verticalMenuAnchorWrapper").getElement())
                .build();
    }


    private  void setDefaultStyleHorisontalButtons(){


       ObservableList<Node> buttons= (
               (FlowPane) MainWindow.getInstance().getWindowNode("horisontalMenuFlowPane").getElement()).getChildren();

       for (Iterator<Node> iterator = buttons.iterator(); iterator.hasNext();) {
           Node next = iterator.next();
//
           if(next instanceof Button){

             next.setId(CSSID.LEFT_SIDE_MENU_HORIZONTAL_BUTTONS.get());
          }

             }
         }

   private static void setDefaultStyleVerticalButtons(){
       AnchorPane pane = (AnchorPane) MainWindow.getInstance().getWindowNode("verticalMenuAnchorWrapper").getElement();

       ObservableList<Node> buttons=pane.getChildren();
//
       for (Iterator<Node> iterator = buttons.iterator(); iterator.hasNext();) {
           Node next = iterator.next();

          if(next instanceof Button){

             next.setId(CSSID.LEFT_SIDE_MENU_VERTICAL_BUTTONS.get());
          }



         }
   }


   }




