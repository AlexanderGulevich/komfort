package basisFx.service;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.ButtonWrapper;
import basisFx.appCore.elements.DatePickerWrapper;
import basisFx.appCore.elements.TableWrapper;
import basisFx.dataSource.UnitOfWork;
import basisFx.domain.ActiveRecord;

import java.sql.SQLException;
import java.time.LocalDate;

public class ServiceMediatorTableAndCommonDate extends ServiceMediator {
    private TableWrapper tableWrapper;
    private DatePickerWrapper datePickerWrapper;
    private ButtonWrapper buttonWrapper;


    @Override
    public void inform(AppNode node) {
        if (node==datePickerWrapper){

        }
        if (node==tableWrapper){

        }

        if (node==buttonWrapper){

        }


    }

    @Override
    public void wasRemoved(AppNode node, ActiveRecord record) {

    }

    @Override
    public void wasChanged(AppNode node, ActiveRecord record) {
        UnitOfWork unitOfWork = ((TableWrapper) node).unitOfWork;
        boolean readyToTransaction = record.isReadyToTransaction();
        if (readyToTransaction) {
            Boolean isNewDomane = ActiveRecord.isNewDomane(record);

            if (!isNewDomane){
                unitOfWork.registercDirty(record.entityName,record);
            }



        }
    }

    @Override
    public void refresh(AppNode node) {

    }
    @Override
    public void initElements() {
        tableWrapper.setItems(tableWrapper.activeRecord.getAll());
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
