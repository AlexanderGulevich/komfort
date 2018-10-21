package basisFx.service;

import basisFx.appCore.Mediator;
import basisFx.appCore.MediatorTwoLinkedTable;
import basisFx.appCore.elements.AppNode;
import basisFx.dataSource.UnitOfWork;
import basisFx.domain.ActiveRecord;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class ServiceTwoLinkedTable implements AplicationService {

    public static void commitAll(UnitOfWork unitOfWork) {

    }

    public static void wasRemoved(ActiveRecord record,  MediatorTwoLinkedTable mediator) {
        Boolean isNewDomane = AplicationService.checkIsNewDomane(record);
        if (!isNewDomane){
            mediator.gunitOfWork.registercDeleted(record.entityName,record);
            removeAccessoryTableItems(mediator);
            try {
                unitOfWork.commit();
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

    public static void wasChanged(AppNode node, ActiveRecord record, UnitOfWork unitOfWork) {

        Boolean isNewDomane = AplicationService.checkIsNewDomane(record);

        if (!isNewDomane){
            unitOfWork.registercDirty(record.entityName,record);
        }else {
            unitOfWork.registerNew(record.entityName,record);
        }
        try {
            unitOfWork.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
