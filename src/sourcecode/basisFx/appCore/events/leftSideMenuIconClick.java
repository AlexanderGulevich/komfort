/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.events;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.menu.FontItemComposite;
import basisFx.appCore.menu.LeftAndTopMenuRepresent;
import basisFx.appCore.menu.MenuComponent;
import basisFx.appCore.menu.MenuComposite;
import basisFx.appCore.settings.CSSID;
import basisFx.appCore.settings.FontsStore;
import java.util.ArrayList;
import java.util.Iterator;

import basisFx.presentation.windows.MainWindow;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;

/**
 *
 * @author Alek
 */
public class leftSideMenuIconClick extends AppEvent{
    protected Button  but;
    protected FontItemComposite component;
    protected Text text=((Text) MainWindow.getInstance().getWindowNode("leftCideMenuCommonText").getElement());
    protected FlowPane horisontalFlowPane=((FlowPane) MainWindow.getInstance().getWindowNode("horisontalMenuFlowPane").getElement());

    public leftSideMenuIconClick(MenuComponent component) {
        this.component = (FontItemComposite) component;
    }

    @Override
    public void setElement(AppNode n) {
        this.appNode=n;
        this.but=(Button) n.getElement();

        but.setOnAction((event) -> {

            text.setText("1111");

            but.setId(CSSID.LEFT_SIDE_MENU_VERTICAL_BUTTONS_CLICKED.get());

            run();
        });
    }

    @Override
    public void run() {



        setCommonTextName();
        setButtons();



             }

    private void setCommonTextName() {

        text.setText(component.getDescription());

        }

    private void setButtons() {

//       Layers.getHorisontalFlowPanel().getChildren().clear();
//
//             if(this.component.isComposit()){
//
//               Layers.getContentLayer().getChildren().clear();
//
//               ArrayList<MenuqqqComponent> inerLevelComponents=  component.getComponents();
////
//                for (Iterator<MenuqqqComponent> iterator1 = inerLevelComponents.iterator(); iterator1.hasNext();) {
//                    MenuqqqComponent nextInerLevel = iterator1.next();
//
//                    //создание кнопок горизонтальных
//                          AppNode.NodeBuilder.create()
//                          .setId(CSSID.LEFT_SIDE_MENU_HORIZONTAL_BUTTONS)
//                          .setText(nextInerLevel.getName())
//                          .setFont(FontsStore.ROBOTO_LIGHT, 17d)
//                          .setEvent(
//                                  eventFactory.menuButtonsClick(
//                                          nextInerLevel,
//                                          (button) -> {
//                                              LeftAndTopMenuRepresent.setDefaultStyleHorisontalButtons();
//                                              button.setId(CSSID.LEFT_SIDE_MENU_HORIZONTAL_BUTTONS_CLICKED.get());
//
//                                          }
//                                  )
//                          )
//                          .setParent(Layers.getHorisontalFlowPanel())
//                          .createNButton();
//
////
//                }
////
//
//
//            }
    }








}
