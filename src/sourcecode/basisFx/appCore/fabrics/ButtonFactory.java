package basisFx.appCore.fabrics;

import basisFx.appCore.elements.ButtonWrapper;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.events.RowAddToTable;
import basisFx.appCore.events.RowDeleteFromTable;
import basisFx.appCore.utils.Coordinate;
import basisFx.appCore.settings.CSSID;
import basisFx.appCore.settings.FontsStore;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class ButtonFactory {

    private double bigButWidth=130;
    private double littleButWidth=25d;
    private double littleButHeight=17d;
    private double littleFontHeight=17d;


    public Button littleRowAddButton(TableWrapper tableWrapper, AnchorPane panel, Class c, Coordinate coordinate ){


        Button button = ButtonWrapper.newBuilder()
                .setCSSid(CSSID.Little_PANELS_BUTTON_ADD)
                .setCoordinate(coordinate)
                .setParentAnchor(panel)
                .setName("\uF199")
                .setFont(FontsStore.FOUNDATION)
                .setFontSize(littleFontHeight)
                .setWidth(littleButWidth)
                .setHeight(littleButHeight)
                .setEvents(new RowAddToTable<>(
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
                .build().getElement();



        return button;


    }
    public Button littleRowAddButton(TableWrapper tableWrapper,  Class c){

        Button button = ButtonWrapper.newBuilder()
                .setCSSid(CSSID.Little_PANELS_BUTTON_ADD)
                .setName("\uF199")
                .setFont(FontsStore.FOUNDATION)
                .setFontSize(littleFontHeight)
                .setWidth(littleButWidth)
                .setHeight(littleButHeight)
                .setEvents(new RowAddToTable<>(
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
                .build().getElement();


        return button;

    }
    public Button littleRowDeleteButton(TableWrapper tableWrapper, AnchorPane panel,  Coordinate coordinate ){

        Button button = ButtonWrapper.newBuilder()
                .setCSSid(CSSID.Little_PANELS_BUTTON_DEL)
                .setCoordinate(coordinate)
                .setParentAnchor(panel)
                .setName("\uF176")
                .setFont(FontsStore.FOUNDATION)
                .setFontSize(littleFontHeight)
                .setWidth(littleButWidth)
                .setHeight(littleButHeight)
                .setEvents( new RowDeleteFromTable(tableWrapper))
                .build().getElement();


        return button;



    }
    public Button littleRowDeleteButton(TableWrapper tableWrapper ){

        Button button = ButtonWrapper.newBuilder()
                .setCSSid(CSSID.Little_PANELS_BUTTON_DEL)
                .setName("\uF176")
                .setFont(FontsStore.FOUNDATION)
                .setFontSize(littleFontHeight)
                .setWidth(littleButWidth)
                .setHeight(littleButHeight)
                .setEvents(new RowDeleteFromTable(tableWrapper))
                .build().getElement();


        return button;



    }
    public Button addRowButton(AnchorPane panel, Coordinate coordinate, TableWrapper tableWrapper, Class cl){

        return  ButtonWrapper.newBuilder()
                .setCSSid(CSSID.PANELS_BUTTON)
                .setParentAnchor(panel)
                .setCoordinate(coordinate)
                .setName("ДОБАВИТЬ")
                .setFontSize(15)
                .setFont(FontsStore.ROBOTO_LIGHT )
                .setWidth(bigButWidth)
                .setHeight(20d)
                .setEvents(
                        new RowAddToTable<>(
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
                .build().getElement();



    }
    public Button addRowButton(TableWrapper tableWrapper, Class cl){

        return  ButtonWrapper.newBuilder()
                .setCSSid(CSSID.PANELS_BUTTON)
                .setName("ДОБАВИТЬ")
                .setFont(FontsStore.ROBOTO_LIGHT)
                .setFontSize(15)
                .setWidth(bigButWidth)
                .setHeight(20d)
                .setEvents(new RowAddToTable(
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
                .build().getElement();



    }
    public Button deleteRowButton(AnchorPane panel, Coordinate coordinate, TableWrapper tableWrapper){
        return ButtonWrapper.newBuilder()
                .setCSSid(CSSID.PANELS_BUTTON)
                .setParentAnchor(panel)
                .setCoordinate(coordinate)
                .setName("УДАЛИТЬ")
                .setFont(FontsStore.ROBOTO_LIGHT)
                .setFontSize(15)
                .setWidth(bigButWidth)
                .setHeight(20d)
                .setEvents(new RowDeleteFromTable(tableWrapper))
                .build().getElement();
    }
    public Button deleteRowButton(  TableWrapper tableWrapper){
        return ButtonWrapper.newBuilder()
                .setCSSid(CSSID.PANELS_BUTTON)
                .setName("УДАЛИТЬ")
                .setFont(FontsStore.ROBOTO_LIGHT)
                .setFontSize(15)
                .setWidth(bigButWidth)
                .setHeight(20d)
                .setEvents(new RowDeleteFromTable(tableWrapper))
                .build().getElement();



    }

//    public Button submitButton(KindOfSubmitElement mark, AnchorPane panel, Coordinate coordinate, Submitted...submitted){
//
//        return ButtonWrapper.newBuilder()
//                .setCSSid(CSSID.PANELS_BUTTON)
//                .setParentAnchor(panel)
//                .setCoordinate(coordinate)
//                .setName("ОТПРАВИТЬ")
//                .setFont(FontsStore.ROBOTO_LIGHT)
//                .setFontSize(15)
//                .setWidth(130d)
//                .setHeight(20d)
//                .build().getElement();
//
//
//    }
//    public Button submitButton(KindOfSubmitElement mark, Submitted...submitted){
//
//        return (Button)AppNode.NodeBuilder.create()
//                .setId(CSSID.PANELS_BUTTON)
//                .setKindOfSubmitElement(mark)
//                .setText("ОТПРАВИТЬ").setFont(FontsStore.ROBOTO_LIGHT, 15)
//                .setWidth(130d).setHeight(20d)
//                .createNButton().getElement();
//
//
//    }
//    public Button popupCloseOkButton( AnchorPane panel, Coordinate coordinate, Stage stage){
//
//        return (Button)AppNode.NodeBuilder.create()
//                .setId(CSSID.PANELS_BUTTON)
//                .setParent(panel)
//                .setCoordinate(coordinate)
//                .setStage(stage)
//                .setText("ОК").setFont(FontsStore.ROBOTO_BOLD, 17)
//                .setWidth(50d).setHeight(30d)
//                .setEvent(eventFactory.closingPopup())
//                .createNButton().getElement();
//
//
//    }
}
