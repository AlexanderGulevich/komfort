package basisFx.appCore.mediators;

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
        if (node == primaryTableWrapper) {
            ServiceTwoLinkedTable.wasRemoved(node, record);
        }
        if (node == accessoryTableWrapper) {
            ServiceTwoLinkedTable.wasRemoved(node, record);
        }
    }

    @Override
    public void wasChanged(AppNode node, ActiveRecord record) {
        if (node == primaryTableWrapper) {
            ServiceTwoLinkedTable.wasChanged(node, record);
        }
        if (node == accessoryTableWrapper) {
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




