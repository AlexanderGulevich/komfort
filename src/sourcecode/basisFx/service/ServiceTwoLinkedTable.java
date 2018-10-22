package basisFx.service;

import basisFx.appCore.MediatorTwoLinkedTable;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.TableWrapper;
import basisFx.dataSource.UnitOfWork;
import basisFx.domain.ActiveRecord;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class ServiceTwoLinkedTable implements AplicationService {

    public static void commitAll(UnitOfWork unitOfWork) {}

    public static void wasRemoved(AppNode node, ActiveRecord record) {
        TableWrapper tableWrapper = (TableWrapper) node;
        Boolean isNewDomane = AplicationService.checkIsNewDomane(record);
        if (!isNewDomane){
            tableWrapper.unitOfWork.registercDeleted(record.entityName,record);
            removeAccessoryTableItems(((MediatorTwoLinkedTable) tableWrapper.getMediator()));
            try {
                tableWrapper.unitOfWork.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void removeAccessoryTableItems(MediatorTwoLinkedTable mediator) {
        ObservableList<ActiveRecord> items = mediator.getAccessoryTableWrapper().getElement().getItems();
        for (ActiveRecord record:items) {
            mediator.getAccessoryTableWrapper().unitOfWork.registercDeleted(record.entityName,record);
            try {
                mediator.getAccessoryTableWrapper().unitOfWork.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void wasChanged(AppNode node, ActiveRecord record) {
        TableWrapper tableWrapper = (TableWrapper) node;
        Boolean isNewDomane = AplicationService.checkIsNewDomane(record);
        if (!isNewDomane){
            tableWrapper.unitOfWork.registercDirty(record.entityName,record);
        }else {
            tableWrapper.unitOfWork.registerNew(record.entityName,record);
        }
        try {
            tableWrapper.unitOfWork.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
