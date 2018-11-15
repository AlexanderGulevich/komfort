package basisFx.service;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.TableWrapper;
import basisFx.domain.ActiveRecord;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public abstract class ServiceMediator {

    public abstract  void inform(AppNode node);
    public abstract void wasRemoved(AppNode node, ActiveRecord record);
    public abstract void wasChanged(AppNode node, ActiveRecord record);
    public abstract void refresh(AppNode node);
    public abstract void initElements();

    protected  void commit(TableWrapper tableWrapper) {
        try {
            boolean isCommitted = tableWrapper.unitOfWork.commit();
            if (isCommitted) {
                tableWrapper.getServiceMediator().refresh(tableWrapper);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public  void refreshTable(TableWrapper tableWrapper, ObservableList<ActiveRecord> list ) {
        tableWrapper.setItems(list);
    }

}
