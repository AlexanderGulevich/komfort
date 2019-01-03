package basisFx.appCore.fabrics;

import basisFx.appCore.elements.ButtonWrapper;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.events.MultyPushToDataStore;
import basisFx.appCore.events.RowAddToSubmitTableWhisCommonDate;
import basisFx.appCore.events.RowAddToTable;
import basisFx.appCore.events.RowDeleteFromTable;
import basisFx.appCore.utils.Coordinate;
import basisFx.appCore.settings.CSSID;
import basisFx.appCore.settings.FontsStore;
import basisFx.service.ServiceMediator;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class ButtonFactory {

    private static ButtonFactory INSTANCE = new ButtonFactory();
    private double bigButWidth=130;
    private double littleButWidth=25d;
    private double littleButHeight=17d;
    private double littleFontHeight=17d;

    private ButtonFactory() {
    }

    public static ButtonFactory getInstance() {
        return INSTANCE;
    }

    public Button littleRowAddButton(TableWrapper tableWrapper){

        Button button = ButtonWrapper.newBuilder()
                .setCSSid(CSSID.Little_PANELS_BUTTON_ADD)
                .setText("\uF199")
                .setFont(FontsStore.FOUNDATION)
                .setFontSize(littleFontHeight)
                .setWidth(littleButWidth)
                .setHeight(littleButHeight)
                .setEvents(new RowAddToTable(tableWrapper ))
                .build().getElement();


        return button;

    }
    public Button littleRowDeleteButton(TableWrapper tableWrapper ){

        Button button = ButtonWrapper.newBuilder()
                .setCSSid(CSSID.Little_PANELS_BUTTON_DEL)
                .setText("\uF176")
                .setFont(FontsStore.FOUNDATION)
                .setFontSize(littleFontHeight)
                .setWidth(littleButWidth)
                .setHeight(littleButHeight)
                .setEvents(new RowDeleteFromTable(tableWrapper))
                .build().getElement();


        return button;



    }
    public Button littleRowAddButtonForSubmitTable(TableWrapper tableWrapper){

        Button button = ButtonWrapper.newBuilder()
                .setCSSid(CSSID.Little_PANELS_BUTTON_ADD)
                .setText("\uF199")
                .setFont(FontsStore.FOUNDATION)
                .setFontSize(littleFontHeight)
                .setWidth(littleButWidth)
                .setHeight(littleButHeight)
                .setEvents(new RowAddToSubmitTableWhisCommonDate(tableWrapper ))
                .build().getElement();


        return button;

    }
    public Button addRowButton(TableWrapper tableWrapper){

        return  ButtonWrapper.newBuilder()
                .setCSSid(CSSID.PANELS_BUTTON)
                .setText("ДОБАВИТЬ")
                .setFont(FontsStore.ROBOTO_LIGHT)
                .setFontSize(15)
                .setWidth(bigButWidth)
                .setHeight(20d)
                .setEvents(new RowAddToTable(tableWrapper ))
                .build().getElement();



    }

    public Button deleteRowButton(  TableWrapper tableWrapper){
        return ButtonWrapper.newBuilder()
                .setCSSid(CSSID.PANELS_BUTTON)
                .setText("УДАЛИТЬ")
                .setFont(FontsStore.ROBOTO_LIGHT)
                .setFontSize(15)
                .setWidth(bigButWidth)
                .setHeight(20d)
                .setEvents(new RowDeleteFromTable(tableWrapper))
                .build().getElement();



    }

    public ButtonWrapper submitButton(AnchorPane panel, Coordinate coordinate, ServiceMediator mediator){

        return ButtonWrapper.newBuilder()
                .setCSSid(CSSID.PANELS_BUTTON)
                .setParentAnchor(panel)
                .setEvents(new MultyPushToDataStore())
                .setServiceMediator(mediator)
                .setCoordinate(coordinate)
                .setText("ОТПРАВИТЬ")
                .setFont(FontsStore.ROBOTO_LIGHT)
                .setFontSize(15)
                .setWidth(130d)
                .setHeight(20d)
                .build();


    }
//    public Button submitButton(DefaultPanelsNames mark, Submitted...submitted){
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
