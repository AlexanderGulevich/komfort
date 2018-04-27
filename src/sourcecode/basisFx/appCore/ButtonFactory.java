package basisFx.appCore;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.TableViewWrapper;
import basisFx.appCore.events.EventFactory;
import basisFx.appCore.utils.Coordinate;
import basisFx.appCore.settings.CSSID;
import basisFx.appCore.settings.FontsStore;
import javafx.scene.layout.AnchorPane;


/**
 * Created by AlexanderGulevich on 24.03.2018.
 *
 * @autor AlexanderGulevich
 */
public class ButtonFactory {


    protected EventFactory eventFactory=EventFactory.getInstance();

    public void littleRowAddButton(TableViewWrapper tableViewWrapper, AnchorPane panel, Class c, Double top, Double right, Double bottom, Double left ){

        AppNode.NodeBuilder.create()
                .setId(CSSID.PANELS_BUTTON)
                .setCoordinate(panel, top,right, bottom, left)
                .setText("+").setFont(FontsStore.ROBOTO_LIGHT, 15)
                .setWidth(30d).setHeight(20d)
                .setEvent(eventFactory.
                        createRowAdd(
                                tableViewWrapper,
                                (l)->{
                                    try {
                                        l.add( c.newInstance());
                                    } catch (InstantiationException e) {
                                        e.printStackTrace();
                                    } catch (IllegalAccessException e) {
                                        e.printStackTrace();
                                    }
                                }))
                .createNButton();

    }
    public void littleRowDeleteButton(TableViewWrapper tableViewWrapper, AnchorPane panel, Double top, Double right, Double bottom, Double left ){

        AppNode.NodeBuilder.create()
                .setId(CSSID.PANELS_BUTTON)
                .setCoordinate(panel, top,right, bottom, left)
                .setText("-").setFont(FontsStore.ROBOTO_LIGHT, 15)
                .setWidth(30d).setHeight(20d)
                .setEvent(eventFactory.createRowDeleteFromTable(tableViewWrapper))
                .createNButton();



    }
    public void addRowButton(AnchorPane panel, Coordinate coordinate, TableViewWrapper tableViewWrapper, Class cl){

        AppNode.NodeBuilder.create()
                .setId(CSSID.PANELS_BUTTON)
                .setParent(panel)
                .setCoordinate(coordinate)
                .setText("ДОБАВИТЬ").setFont(FontsStore.ROBOTO_LIGHT, 15)
                .setWidth(170d).setHeight(20d)
                .setEvent(eventFactory.
                        createRowAdd(
                                tableViewWrapper,
                                (l)->{
                                    try {
                                        l.add(cl.newInstance());
                                    } catch (InstantiationException e) {
                                        e.printStackTrace();
                                    } catch (IllegalAccessException e) {
                                        e.printStackTrace();
                                    }
                                }))
                .createNButton();



    }
    public void deleteRowButton(AnchorPane panel, Coordinate coordinate, TableViewWrapper tableViewWrapper){
        AppNode.NodeBuilder.create()
                .setId(CSSID.PANELS_BUTTON)
                .setParent(panel)
                .setCoordinate(coordinate)
                .setText("УДАЛИТЬ").setFont(FontsStore.ROBOTO_LIGHT, 15)
                .setWidth(170d).setHeight(20d)
                .setEvent(eventFactory.createRowDeleteFromTable(tableViewWrapper))
                .createNButton();



    }
    public void submitButton(SubmitElement mark,AnchorPane panel, Coordinate coordinate, Submitted ...submitted){

        AppNode.NodeBuilder.create()
                .setId(CSSID.PANELS_BUTTON)
                .setMark(mark)
                .setParent(panel)
                .setCoordinate(coordinate)
                .setText("ОТПРАВИТЬ").setFont(FontsStore.ROBOTO_LIGHT, 15)
                .setWidth(170d).setHeight(20d)

                .createNButton();


    }
}
