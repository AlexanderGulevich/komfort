package basisFx.appCore.fabrics;

import basisFx.appCore.KindOfSubmitElement;
import basisFx.appCore.Submitted;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.utils.Coordinate;
import basisFx.appCore.settings.CSSID;
import basisFx.appCore.settings.FontsStore;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


/**
 * Created by AlexanderGulevich on 24.03.2018.
 *
 * @autor AlexanderGulevich
 */
public class ButtonFactory {

    private double bigButWidth=130;


    protected EventFactory eventFactory=EventFactory.getInstance();


    private double littleButWidth=30d;
    private double littleButHeight=20d;
    private double littleFontHeight=20d;


    public Button littleRowAddButton(TableWrapper tableWrapper, AnchorPane panel, Class c, Coordinate coordinate ){


        Button button = (Button) AppNode.NodeBuilder.create()
                .setId(CSSID.Little_PANELS_BUTTON)
                .setCoordinate(coordinate)
                .setParent(panel)
                .setText("\uF216").setFont(FontsStore.IONICONS, littleFontHeight)
                .setWidth(littleButWidth).setHeight(littleButHeight)
                .setEvent(eventFactory.
                        rowAdd(
                                tableWrapper,
                                (l) -> {
                                    try {
                                        l.add(c.newInstance());
                                    } catch (InstantiationException e) {
                                        e.printStackTrace();
                                    } catch (IllegalAccessException e) {
                                        e.printStackTrace();
                                    }
                                }))
                .createNButton().getElement();



        return button;


    }
    public Button littleRowAddButton(TableWrapper tableWrapper,  Class c){

        Button button = (Button)AppNode.NodeBuilder.create()
                .setId(CSSID.Little_PANELS_BUTTON)
                .setText("\uF216").setFont(FontsStore.IONICONS, littleFontHeight)
                .setWidth(littleButWidth).setHeight(littleButHeight)
                .setEvent(eventFactory.
                        rowAdd(
                                tableWrapper,
                                (l)->{
                                    try {
                                        l.add( c.newInstance());
                                    } catch (InstantiationException e) {
                                        e.printStackTrace();
                                    } catch (IllegalAccessException e) {
                                        e.printStackTrace();
                                    }
                                }))
                .createNButton().getElement();


        return button;

    }
    public Button littleRowDeleteButton(TableWrapper tableWrapper, AnchorPane panel,  Coordinate coordinate ){

        Button button = (Button)AppNode.NodeBuilder.create()
                .setId(CSSID.Little_PANELS_BUTTON)
                .setCoordinate(coordinate)
                .setParent(panel)
                .setText("\uF128").setFont(FontsStore.IONICONS, littleFontHeight)
                .setWidth(littleButWidth).setHeight(littleButHeight)
                .setEvent(eventFactory.rowDeleteFromTable(tableWrapper))
                .createNButton().getElement();


        return button;



    }
    public Button littleRowDeleteButton(TableWrapper tableWrapper ){

        Button button = (Button)AppNode.NodeBuilder.create()
                .setId(CSSID.Little_PANELS_BUTTON)
                .setText("\uF128").setFont(FontsStore.IONICONS, littleFontHeight)
                .setWidth(littleButWidth).setHeight(littleButHeight)
                .setEvent(eventFactory.rowDeleteFromTable(tableWrapper))
                .createNButton().getElement();


        return button;



    }
    public Button addRowButton(AnchorPane panel, Coordinate coordinate, TableWrapper tableWrapper, Class cl){

        return (Button)AppNode.NodeBuilder.create()
                .setId(CSSID.PANELS_BUTTON)
                .setParent(panel)
                .setCoordinate(coordinate)
                .setText("ДОБАВИТЬ").setFont(FontsStore.ROBOTO_LIGHT, 15)
                .setWidth(bigButWidth).setHeight(20d)
                .setEvent(eventFactory.
                        rowAdd(
                                tableWrapper,
                                (l)->{
                                    try {
                                        l.add(cl.newInstance());
                                    } catch (InstantiationException e) {
                                        e.printStackTrace();
                                    } catch (IllegalAccessException e) {
                                        e.printStackTrace();
                                    }
                                }))
                .createNButton().getElement();



    }
    public Button addRowButton(TableWrapper tableWrapper, Class cl){

        return (Button)AppNode.NodeBuilder.create()
                .setId(CSSID.PANELS_BUTTON)
                .setText("ДОБАВИТЬ").setFont(FontsStore.ROBOTO_LIGHT, 15)
                .setWidth(bigButWidth).setHeight(20d)
                .setEvent(eventFactory.
                        rowAdd(
                                tableWrapper,
                                (l)->{
                                    try {
                                        l.add(cl.newInstance());
                                    } catch (InstantiationException e) {
                                        e.printStackTrace();
                                    } catch (IllegalAccessException e) {
                                        e.printStackTrace();
                                    }
                                }))
                .createNButton().getElement();



    }
    public Button deleteRowButton(AnchorPane panel, Coordinate coordinate, TableWrapper tableWrapper){
        return (Button)AppNode.NodeBuilder.create()
                .setId(CSSID.PANELS_BUTTON)
                .setParent(panel)
                .setCoordinate(coordinate)
                .setText("УДАЛИТЬ").setFont(FontsStore.ROBOTO_LIGHT, 15)
                .setWidth(bigButWidth).setHeight(20d)
                .setEvent(eventFactory.rowDeleteFromTable(tableWrapper))
                .createNButton().getElement();



    }
    public Button deleteRowButton(  TableWrapper tableWrapper){
        return (Button) AppNode.NodeBuilder.create()
                .setId(CSSID.PANELS_BUTTON)
                .setText("УДАЛИТЬ").setFont(FontsStore.ROBOTO_LIGHT, 15)
                .setWidth(bigButWidth).setHeight(20d)
                .setEvent(eventFactory.rowDeleteFromTable(tableWrapper))
                .createNButton().getElement();



    }

    public Button submitButton(KindOfSubmitElement mark, AnchorPane panel, Coordinate coordinate, Submitted...submitted){

        return (Button)AppNode.NodeBuilder.create()
                .setId(CSSID.PANELS_BUTTON)
                .setKindOfSubmitElement(mark)
                .setParent(panel)
                .setCoordinate(coordinate)
                .setText("ОТПРАВИТЬ").setFont(FontsStore.ROBOTO_LIGHT, 15)
                .setWidth(130d).setHeight(20d)
                .createNButton().getElement();


    }
    public Button submitButton(KindOfSubmitElement mark, Submitted...submitted){

        return (Button)AppNode.NodeBuilder.create()
                .setId(CSSID.PANELS_BUTTON)
                .setKindOfSubmitElement(mark)
                .setText("ОТПРАВИТЬ").setFont(FontsStore.ROBOTO_LIGHT, 15)
                .setWidth(130d).setHeight(20d)
                .createNButton().getElement();


    }
    public Button popupCloseOkButton( AnchorPane panel, Coordinate coordinate, Stage stage){

        return (Button)AppNode.NodeBuilder.create()
                .setId(CSSID.PANELS_BUTTON)
                .setParent(panel)
                .setCoordinate(coordinate)
                .setStage(stage)
                .setText("ОК").setFont(FontsStore.ROBOTO_BOLD, 17)
                .setWidth(50d).setHeight(30d)
                .setEvent(eventFactory.closingPopup())
                .createNButton().getElement();


    }
}
