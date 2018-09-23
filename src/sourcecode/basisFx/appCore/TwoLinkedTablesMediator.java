package basisFx.appCore;

import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.TableWrapper;
import basisFx.domain.domaine.ActiveRecord;
import javafx.collections.ObservableList;

public class TwoLinkedTablesMediator implements Mediator {

    private  TableWrapper primaryTableWrapper;
    private  TableWrapper accessoryTableWrapper;

    public TwoLinkedTablesMediator(TableWrapper primaryTableWrapper, TableWrapper accessoryTableWrapper) {
        this.primaryTableWrapper = primaryTableWrapper;
        this.primaryTableWrapper.setMediator(this);
        this.accessoryTableWrapper = accessoryTableWrapper;
        this.accessoryTableWrapper.setMediator(this);

    }

    @Override
    public void inform(AppNode node) {
            if (node==primaryTableWrapper){
                refreshAccessoryTable(primaryTableWrapper.clickedDomain);
            }
            //todo create exeption
    }

    private void refreshAccessoryTable(ActiveRecord record) {

        if (record.getId() !=null) {

            ObservableList<ActiveRecord> listFromDataStore = accessoryTableWrapper.activeRecord.getDomainListForAccessoryTable(record.getId());
            ObservableList<ActiveRecord> tablesItems = accessoryTableWrapper.getElement().getItems();
            tablesItems.clear();
            tablesItems.addAll(listFromDataStore);

        }
    }
}

