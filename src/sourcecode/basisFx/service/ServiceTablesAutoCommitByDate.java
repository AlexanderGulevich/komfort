package basisFx.service;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.ButtonWrapper;
import basisFx.appCore.elements.DatePickerWrapper;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.events.AppEvent;
import basisFx.appCore.interfaces.DataStoreCallBack;
import basisFx.appCore.interfaces.RecordWithDate;
import basisFx.dataSource.UnitOfWork;
import basisFx.domain.ActiveRecord;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;

public class ServiceTablesAutoCommitByDate extends ServiceTables {
    private TableWrapper tableWrapper;
    private DatePickerWrapper datePickerWrapper;
    @Setter
    public DataStoreCallBack dataStoreCallBack;

    public void setButtonWrapper(ButtonWrapper buttonWrapper) {
        this.buttonWrapper = buttonWrapper;
        buttonWrapper.setServiceTables(this);
        ArrayList events = buttonWrapper.getEvents();
        for (Object event : events) {
            ((AppEvent) event).setCallBackTyped(
                    ()->{
                        if (datePickerWrapper.getDate() != null) {
                            return Boolean.valueOf(true);
                        }else{
                            return Boolean.valueOf(false);
                        }
                    }
            );
        }
    }

    private ButtonWrapper buttonWrapper;

    @Override
    public void inform(Object node) {
        if (node==datePickerWrapper){
            refresh(tableWrapper);
        }
    }

    public DatePickerWrapper getDatePickerWrapper() {
        return datePickerWrapper;
    }

    @Override
    public void wasRemoved(AppNode node, ActiveRecord record) {
        UnitOfWork unitOfWork = ((TableWrapper) node).unitOfWork;
        boolean newDomane = ActiveRecord.isNewDomane(record);
        if (!newDomane) {
            unitOfWork.registercDeleted(record);
            commit(tableWrapper);
        }
    }

    @Override
    public void wasChanged(AppNode node, ActiveRecord record) {
        UnitOfWork unitOfWork = ((TableWrapper) node).unitOfWork;
        LocalDate date = datePickerWrapper.getDate();
        ((RecordWithDate) record).setDate(date);
        boolean readyToTransaction = record.isReadyToTransaction();
        if (dataStoreCallBack != null) {
            if (dataStoreCallBack.check(record)) {
                write(record, unitOfWork, readyToTransaction);
            }
        }else {
            write(record, unitOfWork, readyToTransaction);
        }

    }

    private void write(ActiveRecord record, UnitOfWork unitOfWork, boolean readyToTransaction) {
        if (readyToTransaction) {
            boolean newDomane = ActiveRecord.isNewDomane(record);
            if (newDomane) {
                unitOfWork.registerNew(record);
            }else{
                unitOfWork.registercDirty(record);
            }
            commit(tableWrapper);
        }
    }

    @Override
    public void refresh(AppNode node) {
        initElements();
    }

    @Override
    public void initElements() {
        LocalDate date = datePickerWrapper.getDate();
        if (date != null) {
            ObservableList <ActiveRecord> list=tableWrapper.activeRecord.getAllByDate(date);
            if (list == null) {
                list=FXCollections.observableArrayList();
            }
            tableWrapper.setItems(list);
        }

    }

    public void setTableWrapper(TableWrapper tableWrapper) {
        this.tableWrapper = tableWrapper;
    }

    public void setDatePickerWrapper(DatePickerWrapper datePickerWrapper) {
        this.datePickerWrapper = datePickerWrapper;
    }


}
