package basisFx.service;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.ButtonWrapper;
import basisFx.appCore.elements.DatePickerWrapper;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.interfaces.RecordWithDate;
import basisFx.dataSource.UnitOfWork;
import basisFx.domain.ActiveRecord;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;

import java.time.LocalDate;

public class ServiceBlankContentTableAndCommonDate extends ServiceMediator{
    private TableWrapper tableWrapper;
    private DatePickerWrapper datePickerWrapper;
    private ButtonWrapper buttonWrapper;

    @Override
    public void inform(AppNode node) {
        if (node==datePickerWrapper){
            refresh();
        }
        if (node==buttonWrapper)    {
            tableWrapper.unitOfWork.commit();
            refresh();
            datePickerWrapper.getElement().setValue(null);
        }

    }


    @Override
    public void wasRemoved(AppNode node, ActiveRecord record) {
        UnitOfWork unitOfWork = ((TableWrapper) node).unitOfWork;
        boolean newDomane = ActiveRecord.isNewDomane(record);
        if (!newDomane) {
            unitOfWork.registercDeleted(record.entityName,record);
        }
    }

    @Override
    public void wasChanged(AppNode node, ActiveRecord record) {
        UnitOfWork unitOfWork = ((TableWrapper) node).unitOfWork;
        LocalDate date = datePickerWrapper.getDate();
        ((RecordWithDate) record).setDate(date);
        boolean readyToTransaction = record.isReadyToTransaction();
        if (readyToTransaction) {
            boolean newDomane = ActiveRecord.isNewDomane(record);
            if (newDomane) {
                unitOfWork.registerNew(record.entityName,record);
            }else{
                unitOfWork.registercDirty(record.entityName,record);
            }
        }
    }

    @Override
    public void refresh(AppNode node) {

    }

    public void refresh() {
        clearTable();
        initElements();
    }

    private void clearTable() {
        tableWrapper.getElement().getItems().clear();
    }

    @Override
    public void initElements() {
        ObservableList <ActiveRecord> list=tableWrapper.activeRecord.getAllByDate(datePickerWrapper.getDate());
        if (list == null) {
            list=FXCollections.observableArrayList();
        }
        tableWrapper.setItems(list);
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
