/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.events;

import basisFx.appCore.dataSource.UnitOfWork;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.TableViewWrapper;
import basisFx.appCore.functional.RowCreater;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

/**
 *
 * @author Alek
 * @param <T>
 */
public class RowAddToTable <T> extends AppEvent{
    
    private TableView <T> table;
    private Button but;
    private final ObservableList list;
    protected RowCreater rowCreater;
    private TableViewWrapper nTableView;
    private   UnitOfWork unitOfWork;



    @SuppressWarnings("unchecked")
    public RowAddToTable(TableViewWrapper nTableView, RowCreater rowCreater) {
        this.nTableView = nTableView;
        this.table= (TableView<T>) this.nTableView.getElement();
        this.list=this.table.getItems();
        this.rowCreater=rowCreater;
        this.unitOfWork = this.nTableView.getUnitOfWork();
    }
    
    
    

    @Override
    public void setElement(AppNode node) {
        but=(Button) node.getElement();   
        but.setOnMouseClicked((event) -> {
            run();
        });
        
    }


    @Override
    public void run() {

        if(this.unitOfWork.getNewPojoes().isEmpty()){
            System.out.println("unitOfWork.getNewPojoes().isEmpty()");
                rowCreater.createRow(list);
        }


            if  (table.getSelectionModel().isEmpty() )  {//если не выбрано ничего
                System.out.println("table.getSelectionModel().isEmpty()");
               table.getSelectionModel().getSelectedItem();
                rowCreater.createRow(list);

            } else {//если какая-то строка выбрана



//                    TreeTableViewSelectionModel<CategoryPojo> sm = treeTable.getSelectionModel();
//                    int rowIndex = sm.getSelectedIndex();
//                    TreeItem<CategoryPojo> selectedItem = sm.getModelItem(rowIndex);
//
//                    CategoryPojo domaine=new CategoryPojo("");
//
//                    Integer selectedItemLevel=selectedItem.getRate().getLevelId();
//                    domaine.setLevelId(selectedItemLevel+1);
//
//                    item = new TreeItem<>(domaine);
//
//                    selectedItem.getChildren().add(item);
//                    selectedItem.setExpanded(true);
//
            }
//
//
//        int newRowIndex = treeTable.getRow(item);
//        treeTable.scrollTo(newRowIndex);
//        TreeTableColumn<CategoryPojo, ?> firstCol =treeTable.getColumns().get(0);
//        treeTable.getSelectionModel().select(item);
//        treeTable.getFocusModel().focus(newRowIndex);
//        treeTable.getFocusModel().focus(newRowIndex, firstCol);
//        treeTable.edit(newRowIndex, firstCol);
//
//        treeTable.getSelectionModel().clearSelection();
//





//
    
    }
    

}
