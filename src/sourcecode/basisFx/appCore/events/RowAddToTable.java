/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.events;

import basisFx.appCore.elements.AppNode;
import javafx.beans.Observable;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

/**
 *
 * @author Alek
 */
public class RowAddToTable extends AppEvent{
    
    private TableView table;
    private Button but;
    private final ObservableList list;
    protected RowCreater rowCreater;

    public RowAddToTable(TableView t, ObservableList l,RowCreater r) {
        this.table = t;
        this.list=l;
        this.rowCreater=r;
        
//        list.addListener(
//
//                (e)->{
//
//        
//        });
//        
//        
        
        
    }

//    public RowAddToTable(TableView<Equipment> table, ObservableList<Equipment> tablesPojo) {
//       this.table = table;
//    
//    }
    
    
    

    @Override
    public void setElement(AppNode node) {
        but=(Button) node.getElement();   
        but.setOnMouseClicked((event) -> {
            run();
        });
        
    }


    @Override
    public void run() {
        
        
        rowCreater.createRow(list);


            if  (table.getSelectionModel().isEmpty() )  {//если не выбрано ничего

               table.getSelectionModel().getSelectedItem();

            } else {//если какая-то строка выбрана

//
//                    TreeTableViewSelectionModel<CategoryPojo> sm = treeTable.getSelectionModel();
//                    int rowIndex = sm.getSelectedIndex();
//                    TreeItem<CategoryPojo> selectedItem = sm.getModelItem(rowIndex);
//
//                    CategoryPojo pojo=new CategoryPojo("");
//
//                    Integer selectedItemLevel=selectedItem.getValue().getLevelId();
//                    pojo.setLevelId(selectedItemLevel+1);
//
//                    item = new TreeItem<>(pojo);
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
