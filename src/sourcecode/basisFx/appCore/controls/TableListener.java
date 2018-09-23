package basisFx.appCore.controls;

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

            } else if (change.wasReplaced()) {

            } else if (change.wasRemoved()) {

                ActiveRecord domainObject = (ActiveRecord) change.getRemoved().get(0);
                tableWrapper.unitOfWork.registercDeletedDomainObject(domainObject.entityName,domainObject);

            } else if (change.wasAdded()) {

                ActiveRecord domainObject = (ActiveRecord) change.getAddedSubList().get(0);
                tableWrapper.unitOfWork.registerNew(domainObject.entityName,domainObject);

            }
        }
    }


}





