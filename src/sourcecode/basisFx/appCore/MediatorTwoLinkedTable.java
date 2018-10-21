package basisFx.appCore;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.TableWrapper;
import basisFx.domain.ActiveRecord;
import basisFx.service.ServiceTwoLinkedTable;
import javafx.collections.ObservableList;

public class MediatorTwoLinkedTable implements Mediator {

    private  TableWrapper primaryTableWrapper;
    private  TableWrapper accessoryTableWrapper;
    private int idFromOuterTable;

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
        if (node==primaryTableWrapper){
            refreshAccessoryTable(primaryTableWrapper.clickedDomain);

            System.err.println("MediatorTwoLinkedTable.inform   if (node==primaryTableWrapper){);");
        }
        if (node==accessoryTableWrapper){
            System.err.println("MediatorTwoLinkedTable.inform   if (node==accessoryTableWrapper){");
        }
    }

    @Override
    public void wasRemoved(AppNode node, ActiveRecord record) {
        if (node==primaryTableWrapper){
            System.err.println("MediatorTwoLinkedTable.wasRemoved   if (node==primaryTableWrapper){");
            ServiceTwoLinkedTable.wasRemoved(record,this);
        }
        if (node==accessoryTableWrapper){
            System.err.println("MediatorTwoLinkedTable.wasRemoved   if (node==accessoryTableWrapper){");
            ServiceTwoLinkedTable.wasRemoved(record,this);
        }

    }

    @Override
    public void wasChanged(AppNode node, ActiveRecord record) {
        if (node==primaryTableWrapper){
            System.err.println("MediatorTwoLinkedTable.wasChanged   if (node==primaryTableWrapper){");
            ServiceTwoLinkedTable.wasChanged(node,record,primaryTableWrapper.unitOfWork);
        }
        if (node==accessoryTableWrapper){
            System.err.println("MediatorTwoLinkedTable.wasChanged   if (node==accessoryTableWrapper){");
            ServiceTwoLinkedTable.wasChanged(node,record,accessoryTableWrapper.unitOfWork);
        }
    }


    private void refreshAccessoryTable(ActiveRecord record) {

        if (record.getId() !=null) {

            ObservableList<ActiveRecord> listFromDataStore = accessoryTableWrapper.activeRecord.findAllByOuterId(record.getId());
            ObservableList<ActiveRecord> tablesItems = accessoryTableWrapper.getElement().getItems();
            tablesItems.clear();
            tablesItems.addAll(listFromDataStore);

        }
    }



}

