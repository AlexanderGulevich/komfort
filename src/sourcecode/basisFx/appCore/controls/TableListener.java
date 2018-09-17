package basisFx.appCore.controls;

import basisFx.dataSource.UnitOfWork;
import basisFx.appCore.elements.TableWrapper;
import basisFx.domain.domaine.DomainObject;
import java.util.List;
import javafx.collections.ListChangeListener;
import javafx.scene.control.TableView;

public class TableListener  implements ListChangeListener  {

    private TableWrapper tableWrapper;
    private TableView<DomainObject> table;

    public TableListener() {}

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

                List removed = change.getRemoved();

            } else if (change.wasAdded()) {

                @SuppressWarnings("unchecked")
                List<DomainObject> subList = change.getAddedSubList();
                DomainObject domainObject = subList.get(0);

                if ( !unitOfWork.getStoredPojoesId().contains(domainObject.getId())) {
                    this.unitOfWork.setNewPojoes(domainObject);

                    this.table = (TableView<DomainObject>) this.tableWrapper.getElement();


                }else{

                }



            }
        }
    }


}





