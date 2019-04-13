package basisFx.service;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.RangeDirector;
import basisFx.appCore.elements.TableWrapper;
import basisFx.dataSource.UnitOfWork;
import basisFx.appCore.activeRecord.ActiveRecord;
import lombok.Getter;
import lombok.Setter;

public class ServiceTablesSingle extends ServiceTables {

    @Setter private TableWrapper tableWrapper;
    @Setter private int outrId;

    @Setter @Getter
    private RangeDirector rangeDirector;

    @Override
    public void inform(Object node) {
        if (node == rangeDirector) {
            refreshViaRange(tableWrapper,rangeDirector.getSelectedRange());
        }
    }

    @Override
    public void wasRemoved(AppNode node, ActiveRecord record) {
        UnitOfWork unitOfWork = ((TableWrapper) node).unitOfWork;
        boolean readyToTransaction = record.isReadyToTransaction();
        if (readyToTransaction) {
            Boolean isNewDomane = ActiveRecord.isNewDomane(record);
            if (!isNewDomane){
                unitOfWork.registercDeleted(record);
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
                unitOfWork.registercDirty(record);
            }else {
                unitOfWork.registerNew(record);
            }
                unitOfWork.commit();
                ((TableWrapper) node).getMediator().refresh(node);
        }
    }

    @Override
    public void refresh(AppNode node) {
        if (refreshCallBack != null) {
            refreshCallBack.call();
        }else {
            TableWrapper tableWrapper = (TableWrapper) node;
            setItems(tableWrapper,tableWrapper.activeRecord.getAll());
        }


    }

    @Override
    public void initElements() {
        tableWrapper.setItems(tableWrapper.activeRecord.getAll());
    }

}
