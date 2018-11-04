package basisFx.service;

import basisFx.appCore.mediators.MediatorTwoLinkedTable;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.TableWrapper;
import basisFx.domain.ActiveRecord;
import javafx.collections.ObservableList;

public class ServiceTwoLinkedTable extends AplicationService {


    public static void wasRemoved(AppNode node, ActiveRecord record) {
        TableWrapper tableWrapper = (TableWrapper) node;
        MediatorTwoLinkedTable mediator = (MediatorTwoLinkedTable) tableWrapper.getMediator();
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


    private static void removeAccessoryTableItems(MediatorTwoLinkedTable mediator) {
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

    public static void wasChanged(AppNode node, ActiveRecord record) {
        TableWrapper tableWrapper = (TableWrapper) node;
        Boolean isNewDomane = ActiveRecord.isNewDomane(record);
        System.err.println("ServiceTwoLinkedTable.wasChanged");
        boolean readyToTransaction = record.isReadyToTransaction();
        if (readyToTransaction) {
            if (isNewDomane){
                System.err.println("ServiceTwoLinkedTable.wasChanged---isNewDomane");
                tableWrapper.unitOfWork.registerNew(record.entityName,record);
            }else {
                tableWrapper.unitOfWork.registercDirty(record.entityName,record);
                System.err.println("ServiceTwoLinkedTable.wasChanged---Not NewDomane");
            }
            commit(tableWrapper);
        }

    }
}
