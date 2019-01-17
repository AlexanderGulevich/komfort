package basisFx.appCore.table;

import basisFx.domain.ActiveRecord;
import basisFx.appCore.elements.TableWrapper;
import javafx.collections.ListChangeListener;

public class TableListener  implements ListChangeListener  {

    public TableWrapper tableWrapper;

    public TableListener(TableWrapper t) {
        this.tableWrapper =t;
    }

    @Override
    public void onChanged(ListChangeListener.Change change) {

        while (change.next()) {

            if (change.wasRemoved()) {
                ActiveRecord domainObject = (ActiveRecord) change.getRemoved().get(0);
                tableWrapper.getServiceTables().wasRemoved(tableWrapper,domainObject);

            }
        }
    }


}





