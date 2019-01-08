package basisFx.appCore.fabrics;

import basisFx.appCore.elements.ButtonWrapper;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.events.RowAddToTable;
import basisFx.appCore.events.RowDeleteFromTable;
import basisFx.appCore.settings.CSSid;
import basisFx.appCore.settings.FontsStore;
import javafx.scene.control.Button;

public class ButtonFactory {

    private static ButtonFactory INSTANCE = new ButtonFactory();
    private ButtonFactory() {
    }

    public static ButtonFactory getInstance() {
        return INSTANCE;
    }

    public Button littleRowAddButton(TableWrapper tableWrapper){

        Button button = ButtonWrapper.newBuilder()
                .setCSSid(CSSid.Little_PANELS_BUTTON_ADD)
                .setText("\uF199")
                .setFont(FontsStore.fontcustom)
                .setEvents(new RowAddToTable(tableWrapper ))
                .build().getElement();


        return button;

    }
    public Button littleRowDeleteButton(TableWrapper tableWrapper ){

        Button button = ButtonWrapper.newBuilder()
                .setCSSid(CSSid.Little_PANELS_BUTTON_DEL)
                .setText("\uF176")
                .setFont(FontsStore.fontcustom)
                .setEvents(new RowDeleteFromTable(tableWrapper))
                .build().getElement();
        return button;

    }
    public Button addRowButton(TableWrapper tableWrapper){

        return  ButtonWrapper.newBuilder()
                .setCSSid(CSSid.PANELS_BUTTON)
                .setText("ДОБАВИТЬ")
                .setFont(FontsStore.ROBOTO_LIGHT)
                .setEvents(new RowAddToTable(tableWrapper ))
                .build().getElement();
    }

    public Button deleteRowButton(  TableWrapper tableWrapper){
        return ButtonWrapper.newBuilder()
                .setCSSid(CSSid.PANELS_BUTTON)
                .setText("УДАЛИТЬ")
                .setEvents(new RowDeleteFromTable(tableWrapper))
                .build().getElement();



    }

}
