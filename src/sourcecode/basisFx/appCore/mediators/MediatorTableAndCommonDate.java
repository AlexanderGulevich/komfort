package basisFx.appCore.mediators;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.ButtonWrapper;
import basisFx.appCore.elements.DatePickerWrapper;
import basisFx.appCore.elements.TableWrapper;
import basisFx.domain.ActiveRecord;

import java.time.LocalDate;

public class MediatorTableAndCommonDate  extends Mediator{
    private TableWrapper tableWrapper;
    private DatePickerWrapper datePickerWrapper;
    private ButtonWrapper buttonWrapper;

    public static void setDate(LocalDate date) {
        MediatorTableAndCommonDate.date = date;
    }

    @Override
    public void inform(AppNode node) {
        if (node==datePickerWrapper){

        }
        if (node==buttonWrapper){

        }


    }

    @Override
    public void wasRemoved(AppNode node, ActiveRecord record) {

    }

    @Override
    public void wasChanged(AppNode node, ActiveRecord record) {

    }

    @Override
    public void refresh(AppNode node) {

    }

    @Override
    public void initElements() {
        date=null;
    }

    public void setTableWrapper(TableWrapper tableWrapper) {
        this.tableWrapper = tableWrapper;
    }

    public void setDatePickerWrapper(DatePickerWrapper datePickerWrapper) {
        this.datePickerWrapper = datePickerWrapper;
    }

    public void setButtonWrapper(ButtonWrapper buttonWrapper) {
        this.buttonWrapper = buttonWrapper;
    }
}
