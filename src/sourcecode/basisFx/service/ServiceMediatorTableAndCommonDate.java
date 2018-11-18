package basisFx.service;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.ButtonWrapper;
import basisFx.appCore.elements.DatePickerWrapper;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.interfaces.RecordWithDate;
import basisFx.dataSource.UnitOfWork;
import basisFx.domain.ActiveRecord;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;

public class ServiceMediatorTableAndCommonDate extends ServiceMediator {
    private TableWrapper tableWrapper;
    private DatePickerWrapper datePickerWrapper;
    private ButtonWrapper buttonWrapper;
    private int columsToActiveEditOption[];

    public ServiceMediatorTableAndCommonDate(int ...colums) {
        if (colums != null) {
            columsToActiveEditOption=colums;
        }else throw new NullPointerException();

    }


    @Override
    public void inform(AppNode node) {
        if (node==datePickerWrapper){
            refresh(tableWrapper);
            setEditableColums();
            insertDateInActiveRecords();
        }
        if (node==buttonWrapper)     tableWrapper.unitOfWork.commit();
    }

    private void insertDateInActiveRecords() {
        ObservableList<ActiveRecord> items = tableWrapper.getElement().getItems();
        for (ActiveRecord activeRecord : items) {
            ((RecordWithDate) activeRecord).setDate(datePickerWrapper.getDate());
        }
    }

    private void setEditableColums() {
//        tableWrapper.getElement().setEditable(true);
        ObservableList<TableColumn<ActiveRecord, ?>> columns = tableWrapper.getElement().getColumns();
        for (int i : columsToActiveEditOption) {
            columns.get(i).setEditable(true);
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
                unitOfWork.registerNew(record.entityName,record);
        }
    }

    @Override
    public void refresh(AppNode node) {
        tableWrapper.getElement().getItems().clear();
        initElements();
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
