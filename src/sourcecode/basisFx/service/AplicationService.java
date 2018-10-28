package basisFx.service;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.TableWrapper;
import basisFx.dataSource.UnitOfWork;
import basisFx.domain.ActiveRecord;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public  abstract class AplicationService {

    public  static void wasRemoved(AppNode node, ActiveRecord record,UnitOfWork unitOfWork){};
    public  static void wasChanged(AppNode node, ActiveRecord record,UnitOfWork unitOfWork){};
    public  static void wasAdded(AppNode node, ActiveRecord record,UnitOfWork unitOfWork){};

    protected static void commit(TableWrapper tableWrapper) {
        try {
            boolean isCommitted = tableWrapper.unitOfWork.commit();
            if (isCommitted) {
                tableWrapper.getMediator().refresh(tableWrapper);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void refreshTable(TableWrapper tableWrapper, ObservableList<ActiveRecord> list ) {
        tableWrapper.setItems(list);
    }


}
