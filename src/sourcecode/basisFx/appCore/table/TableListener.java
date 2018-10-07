package basisFx.appCore.table;

import basisFx.domain.domaine.ActiveRecord;
import basisFx.appCore.elements.TableWrapper;
import javafx.collections.ListChangeListener;

public class TableListener  implements ListChangeListener  {

    private TableWrapper tableWrapper;

    public TableListener(TableWrapper t) {
        this.tableWrapper =t;
    }

    @Override
    public void onChanged(ListChangeListener.Change change) {

        while (change.next()) {

            if (change.wasPermutated()) {

            } else if (change.wasUpdated()) {

                System.out.println("change.wasUpdated()");
            } else if (change.wasReplaced()) {

                System.out.println("change.wasReplaced()");
            } else if (change.wasRemoved()) {

                System.out.println("change.wasRemoved()");
                ActiveRecord domainObject = (ActiveRecord) change.getRemoved().get(0);
                tableWrapper.unitOfWork.registercDeletedDomainObject(domainObject.entityName,domainObject);

            } else if (change.wasAdded()) {
                System.out.println("change.wasAdded()");
                ActiveRecord domainObject = (ActiveRecord) change.getAddedSubList().get(0);
                tableWrapper.unitOfWork.registerNew(domainObject.entityName,domainObject);

            }
        }
    }


}





