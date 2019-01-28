package basisFx.appCore.grid;

import basisFx.appCore.elements.ButtonWrapper;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.events.AppEvent;
import basisFx.appCore.events.RowAddToTable;
import basisFx.appCore.events.RowDeleteFromTable;
import basisFx.appCore.settings.CSSid;
import basisFx.appCore.settings.FontsStore;
import javafx.scene.control.Button;
import lombok.Getter;
import lombok.Setter;

public  abstract class ButSizeForGrid {

    @Getter @Setter protected TableWrapper tableWrapper;
    @Getter @Setter  protected Double  columnWidth;
    @Getter protected Button buttonAdd;
    @Getter protected Button  buttonDel;
    protected AppEvent del;
    protected AppEvent  add;

    public ButSizeForGrid() {
    }
    public ButSizeForGrid(AppEvent del, AppEvent add) {
        this.del = del;
        this.add = add;
    }
    public abstract void init();

    public Button littleRowAddButton(TableWrapper tableWrapper){

        AppEvent event;

        if (add != null) {
            event=add;
        }else  {
            event = new RowAddToTable(tableWrapper);
        }

        Button button = ButtonWrapper.newBuilder()
                .setCSSid(CSSid.Little_PANELS_BUTTON_ADD)
                .setText("\uF199")
                .setFont(FontsStore.fontcustom)
                .setEvents(event)
                .build().getElement();


        return button;

    }
    public Button littleRowDeleteButton(TableWrapper tableWrapper ){
        AppEvent event;

        if (del != null) {
            event=del;
        }else  {
            event = new RowDeleteFromTable(tableWrapper);
        }

        Button button = ButtonWrapper.newBuilder()
                .setCSSid(CSSid.Little_PANELS_BUTTON_DEL)
                .setText("\uF176")
                .setFont(FontsStore.fontcustom)
                .setEvents(event)
                .build().getElement();
        return button;

    }
    public Button addRowButtonHuge(TableWrapper tableWrapper){
        AppEvent event;

        if (add != null) {
            event=add;
        }else  {
            event = new RowAddToTable(tableWrapper);
        }
        return  ButtonWrapper.newBuilder()
                .setCSSid(CSSid.PANELS_BUTTON)
                .setText("ДОБАВИТЬ")
                .setFont(FontsStore.ROBOTO_LIGHT)
                .setEvents(event)
                .build().getElement();
    }

    public Button deleteRowButtonHuge(TableWrapper tableWrapper){
        AppEvent event;

        if (del != null) {
            event=del;
        }else  {
            event = new RowDeleteFromTable(tableWrapper);
        }
        return ButtonWrapper.newBuilder()
                .setCSSid(CSSid.PANELS_BUTTON)
                .setText("УДАЛИТЬ")
                .setEvents(event)
                .build().getElement();



    }
}
