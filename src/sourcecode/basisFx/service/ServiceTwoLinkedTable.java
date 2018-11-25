package basisFx.service;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.TableWrapper;
import basisFx.domain.ActiveRecord;
import javafx.collections.ObservableList;

public class ServiceTwoLinkedTable extends ServiceMediator {

    private TableWrapper primaryTableWrapper;
    private TableWrapper accessoryTableWrapper;
    public int idFromPrimeTable;

    public void setPrimaryTableWrapper(TableWrapper primaryTableWrapper) {
        this.primaryTableWrapper = primaryTableWrapper;
    }

    public void setAccessoryTableWrapper(TableWrapper accessoryTableWrapper) {
        this.accessoryTableWrapper = accessoryTableWrapper;
    }

    public TableWrapper getPrimaryTableWrapper() {
        return primaryTableWrapper;
    }

    public TableWrapper getAccessoryTableWrapper() {
        return accessoryTableWrapper;
    }

    @Override
    public void inform(AppNode node) {
        if (node == primaryTableWrapper) {
            if (!ActiveRecord.isNewDomane(primaryTableWrapper.clickedDomain)) {
                idFromPrimeTable = primaryTableWrapper.clickedDomain.id.get();
                refreshAccessoryTable();
            }
        }
        if (node == accessoryTableWrapper) {
        }
    }

    @Override
    public void wasRemoved(AppNode node, ActiveRecord record) {
        TableWrapper tableWrapper = (TableWrapper) node;
        ServiceTwoLinkedTable mediator = (ServiceTwoLinkedTable) tableWrapper.getServiceMediator();
        Boolean isNewDomane = ActiveRecord.isNewDomane(record);
        boolean readyToTransaction = record.isReadyToTransaction();
        if (readyToTransaction) {
            if (!isNewDomane) {
                tableWrapper.unitOfWork.registercDeleted(record.entityName, record);
                if (tableWrapper == mediator.getPrimaryTableWrapper()) {
                    removeAccessoryTableItems(mediator);
                }
                commit(tableWrapper);
            }
        }
    }
    private  void removeAccessoryTableItems(ServiceTwoLinkedTable mediator) {
        ObservableList<ActiveRecord> items = mediator.getAccessoryTableWrapper().getElement().getItems();
        if (items != null) {
            for (ActiveRecord record:items) {
                if (ActiveRecord.isNewDomane(record)) {
                    continue;
                }
                mediator.getAccessoryTableWrapper().unitOfWork.registercDeleted(record.entityName,record);
            }
            commit(mediator.getAccessoryTableWrapper());
        }

    }

    @Override
    public void wasChanged(AppNode node, ActiveRecord record) {
        if (node == accessoryTableWrapper) record.outerId = idFromPrimeTable;
        TableWrapper tableWrapper = (TableWrapper) node;
        Boolean isNewDomane = ActiveRecord.isNewDomane(record);
        boolean readyToTransaction = record.isReadyToTransaction();
        if (readyToTransaction) {
            if (isNewDomane){
                tableWrapper.unitOfWork.registerNew(record.entityName,record);
            }else {
                tableWrapper.unitOfWork.registercDirty(record.entityName,record);
            }
            commit(tableWrapper);
        }

    }

    @Override
    public void refresh(AppNode node) {
        if (node == primaryTableWrapper) {
            refreshTable(primaryTableWrapper,primaryTableWrapper.activeRecord.getAll());
        }
        if (node == accessoryTableWrapper) {
            refreshTable(accessoryTableWrapper,accessoryTableWrapper.activeRecord.findAllByOuterId(idFromPrimeTable));
        }
    }

    @Override
    public void initElements() {
           primaryTableWrapper.setItems(primaryTableWrapper.activeRecord.getAll());
           accessoryTableWrapper.setItems(null);
    }

    private void refreshAccessoryTable() {
            ObservableList<ActiveRecord> list = accessoryTableWrapper.activeRecord.findAllByOuterId(idFromPrimeTable);
            accessoryTableWrapper.setItems(list);
    }
}




