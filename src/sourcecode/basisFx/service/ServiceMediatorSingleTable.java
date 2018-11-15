package basisFx.service;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.TableWrapper;
import basisFx.dataSource.UnitOfWork;
import basisFx.domain.ActiveRecord;

import java.sql.SQLException;

public class ServiceMediatorSingleTable extends ServiceMediator {

    private TableWrapper tableWrapper;

    public void setTableWrapper(TableWrapper tableWrapper) {
        this.tableWrapper = tableWrapper;
    }

    @Override
    public void inform(AppNode node) {

    }

    @Override
    public void wasRemoved(AppNode node, ActiveRecord record) {
        UnitOfWork unitOfWork = ((TableWrapper) node).unitOfWork;
        boolean readyToTransaction = record.isReadyToTransaction();
        if (readyToTransaction) {
            Boolean isNewDomane = ActiveRecord.isNewDomane(record);
            if (!isNewDomane){
                unitOfWork.registercDeleted(record.entityName,record);
                try {
                    unitOfWork.commit();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void wasChanged(AppNode node, ActiveRecord record) {
        UnitOfWork unitOfWork = ((TableWrapper) node).unitOfWork;
        boolean readyToTransaction = record.isReadyToTransaction();
        if (readyToTransaction) {
            Boolean isNewDomane = ActiveRecord.isNewDomane(record);

            if (!isNewDomane){
                unitOfWork.registercDirty(record.entityName,record);
            }else {
                unitOfWork.registerNew(record.entityName,record);
            }
            try {
                unitOfWork.commit();
                ((TableWrapper) node).getServiceMediator().refresh(node);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void refresh(AppNode node) {
        TableWrapper tableWrapper = (TableWrapper) node;
        refreshTable(tableWrapper,tableWrapper.activeRecord.getAll());
    }

    @Override
    public void initElements() {
        tableWrapper.setItems(tableWrapper.activeRecord.getAll());
    }

}
