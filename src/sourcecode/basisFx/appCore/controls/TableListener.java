package basisFx.appCore.controls;

import basisFx.dataSource.UnitOfWork;
import basisFx.appCore.elements.TableWrapper;
import basisFx.domain.domaine.DomainObject;
import java.util.List;
import javafx.collections.ListChangeListener;
import javafx.scene.control.TableView;

public class TableListener  implements ListChangeListener  {

    private TableWrapper tableWrapper;
    private  UnitOfWork unitOfWork;
    private TableView<DomainObject> table;

    public TableListener() {}

    public TableListener(TableWrapper t) {
        this.tableWrapper =t;
        this.unitOfWork= tableWrapper.getUnitOfWork();
    }
//
//    public void setNTableView(TableWrapper t){
//        this.tableWrapper =t;
//        this.unitOfWork= tableWrapper.getUnitOfWork();
//    }

    @Override
    public void onChanged(ListChangeListener.Change change) {

        while (change.next()) {

            if (change.wasPermutated()) {
                System.out.println("wasPermutated");
            }
            else if (change.wasUpdated()) {
                System.out.println("wasUpdated");
            }
            else if (change.wasReplaced()) {
                System.out.println("wasReplaced");
            }
            else if (change.wasRemoved()) {

                System.out.println("TableListener---wasRemoved");
                List removed = change.getRemoved();


            }

            else if (change.wasAdded()) {

                @SuppressWarnings("unchecked")
                List<DomainObject> subList = change.getAddedSubList();
                DomainObject domainObject = subList.get(0);

                this.tableWrapper.setDataMapperToObject(domainObject);

                if ( !unitOfWork.getStoredPojoesId().contains(domainObject.getId())) {
                    this.unitOfWork.setNewPojoes(domainObject);

                    System.err.println("TableListener - Новый доменнй объект был добавлен в список");

                    this.table = (TableView<DomainObject>) this.tableWrapper.getElement();

                    int newPojoIndex = table.getItems().indexOf(domainObject);

                    table.scrollTo(newPojoIndex);
                    table.getSelectionModel().select(newPojoIndex);
//                                table.getSelectionModel().focus(newPojoIndex);



                }else{

//                              System.out.println("not was added");

                }



            }
        }
    }
}





