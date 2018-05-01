/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.controls;

import basisFx.appCore.dataSource.UnitOfWork;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.domainScetch.DomainObject;
import java.util.List;

import javafx.collections.ListChangeListener;
import javafx.scene.control.TableView;


/**
 *
 * @author 62
 */
public class TableListener  implements ListChangeListener  {

    private TableWrapper tableWrapper;
    private  UnitOfWork unitOfWork;
    private TableView<DomainObject> table;

    public TableListener() {}

    public TableListener(TableWrapper t) {
        this.tableWrapper =t;
        this.unitOfWork= tableWrapper.getUnitOfWork();
    }

    public void setNTableView(TableWrapper t){
        this.tableWrapper =t;
        this.unitOfWork= tableWrapper.getUnitOfWork();
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

                this.tableWrapper.setDataMapperToObject(domainObject);

                if ( !unitOfWork.getStoredPojoesId().contains(domainObject.getId())) {
                    this.unitOfWork.setNewPojoes(domainObject);

                    System.out.println("wasAdded");

                    this.table = (TableView<DomainObject>) this.tableWrapper.getElement();

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

    
    
    
    
    