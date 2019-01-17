package basisFx.service;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.TableWrapper;
import basisFx.domain.ActiveRecord;
import javafx.collections.ObservableList;

public abstract class ServiceTables implements Mediator{

    public abstract void wasRemoved(AppNode node, ActiveRecord record);
    public abstract void wasChanged(AppNode node, ActiveRecord record);
    public abstract void refresh(AppNode node);
    public abstract void initElements();

    protected void commit(TableWrapper tableWrapper) {
            boolean isCommitted = tableWrapper.unitOfWork.commit();
            if (isCommitted) {
                tableWrapper.getServiceTables().refresh(tableWrapper);
            }
    }
    public  void refreshTable(TableWrapper tableWrapper, ObservableList<ActiveRecord> list ) {
        tableWrapper.setItems(list);
    }

}
