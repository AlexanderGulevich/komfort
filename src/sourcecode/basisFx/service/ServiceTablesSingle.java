package basisFx.service;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.TableWrapper;
import basisFx.dataSource.UnitOfWork;
import basisFx.domain.ActiveRecord;

public class ServiceTablesSingle extends ServiceTables {

    private TableWrapper tableWrapper;
    public void setTableWrapper(TableWrapper tableWrapper) {
        this.tableWrapper = tableWrapper;
    }

    @Override
    public void inform(Object node) {
    }

    @Override
    public void wasRemoved(AppNode node, ActiveRecord record) {
        UnitOfWork unitOfWork = ((TableWrapper) node).unitOfWork;
        boolean readyToTransaction = record.isReadyToTransaction();
        if (readyToTransaction) {
            Boolean isNewDomane = ActiveRecord.isNewDomane(record);
            if (!isNewDomane){
                unitOfWork.registercDeleted(record.entityName,record);
                    unitOfWork.commit();
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
                unitOfWork.commit();
                ((TableWrapper) node).getServiceTables().refresh(node);
        }
    }

    @Override
    public void refresh(AppNode node) {
        TableWrapper tableWrapper = (TableWrapper) node;
        setItems(tableWrapper,tableWrapper.activeRecord.getAll());
    }

    @Override
    public void initElements() {
        tableWrapper.setItems(tableWrapper.activeRecord.getAll());
    }

}
