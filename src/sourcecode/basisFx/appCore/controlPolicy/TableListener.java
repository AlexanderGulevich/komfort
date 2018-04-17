/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.controlPolicy;

import basisFx.appCore.dataSource.UnitOfWork;
import basisFx.appCore.elements.TableViewWrapper;
import basisFx.appCore.domainScetch.DomainObject;
import java.util.List;
import javafx.collections.ListChangeListener;
import javafx.scene.control.TableView;


/**
 *
 * @author 62
 */
public class TableListener  implements ListChangeListener  {

    private  TableViewWrapper tableViewWrapper;
    private  UnitOfWork unitOfWork;
    private TableView<DomainObject> table;

    public TableListener() {}

    public TableListener(TableViewWrapper t) {
        this.tableViewWrapper=t;
        this.unitOfWork=tableViewWrapper.getUnitOfWork();
    }

    public void setNTableView(TableViewWrapper t){
        this.tableViewWrapper=t;
        this.unitOfWork=tableViewWrapper.getUnitOfWork();
    }

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

                this.tableViewWrapper.setDataMapperToObject(domainObject);

                if ( !unitOfWork.getStoredPojoesId().contains(domainObject.getId())) {
                    this.unitOfWork.setNewPojoes(domainObject);

                    System.out.println("wasAdded");

                    this.table = (TableView<DomainObject>) this.tableViewWrapper.getElement();

                    int newPojoIndex = table.getItems().indexOf(domainObject);

                    System.out.println("newPojoIndex--------"+ newPojoIndex);

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

    
    
    
    
    