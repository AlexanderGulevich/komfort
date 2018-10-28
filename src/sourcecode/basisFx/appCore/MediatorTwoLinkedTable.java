package basisFx.appCore;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.TableWrapper;
import basisFx.domain.ActiveRecord;
import basisFx.service.AplicationService;
import basisFx.service.ServiceTwoLinkedTable;
import javafx.collections.ObservableList;

public class MediatorTwoLinkedTable extends Mediator {

    private TableWrapper primaryTableWrapper;
    private TableWrapper accessoryTableWrapper;
    public int idFromPrimeTable;

    public MediatorTwoLinkedTable(TableWrapper primaryTableWrapper, TableWrapper accessoryTableWrapper) {
        this.primaryTableWrapper = primaryTableWrapper;
        this.primaryTableWrapper.setMediator(this);
        this.accessoryTableWrapper = accessoryTableWrapper;
        this.accessoryTableWrapper.setMediator(this);

    }

    public MediatorTwoLinkedTable() {
    }

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
            System.err.println("Mediator----------node==primaryTableWrapper");
        }
        if (node == accessoryTableWrapper) {
            System.err.println("Mediator----------node==accessoryTableWrapper)");
        }
    }

    @Override
    public void wasRemoved(AppNode node, ActiveRecord record) {
        if (node == primaryTableWrapper) {
            System.err.println("MediatorTwoLinkedTable.wasRemoved   if (node==primaryTableWrapper){");
            ServiceTwoLinkedTable.wasRemoved(node, record);
        }
        if (node == accessoryTableWrapper) {
            System.err.println("MediatorTwoLinkedTable.wasRemoved   if (node==accessoryTableWrapper){");
            ServiceTwoLinkedTable.wasRemoved(node, record);
        }
    }

    @Override
    public void wasChanged(AppNode node, ActiveRecord record) {
        if (node == primaryTableWrapper) {
            System.err.println("MediatorTwoLinkedTable.wasChanged   if (node==primaryTableWrapper){");
            ServiceTwoLinkedTable.wasChanged(node, record);
        }
        if (node == accessoryTableWrapper) {
            System.err.println("MediatorTwoLinkedTable.wasChanged   if (node==accessoryTableWrapper){");
            record.outerId = idFromPrimeTable;
            ServiceTwoLinkedTable.wasChanged(node, record);
        }
    }

    @Override
    public void refresh(AppNode node) {
        if (node == primaryTableWrapper) {
            AplicationService.refreshTable(primaryTableWrapper,primaryTableWrapper.activeRecord.getAll());
        }
        if (node == accessoryTableWrapper) {
            AplicationService.refreshTable(accessoryTableWrapper,accessoryTableWrapper.activeRecord.findAllByOuterId(idFromPrimeTable));
        }
    }

    private void refreshAccessoryTable() {
            ObservableList<ActiveRecord> list = accessoryTableWrapper.activeRecord.findAllByOuterId(idFromPrimeTable);
            if (accessoryTableWrapper.isItemListExist()) {
                accessoryTableWrapper.clearItems();
                accessoryTableWrapper.getItems().addAll(list);
            }else{
                accessoryTableWrapper.getElement().setItems(list);
            }
    }
}




