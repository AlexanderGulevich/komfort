/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.events;

import basisFx.appCore.dataSource.UnitOfWork;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.TableViewWrapper;
import basisFx.appCore.domainScetch.DomainObject;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

import java.sql.SQLException;

/**
 *
 * @author Alek
 */
public class RowDeleteFromTable extends AppEvent{

    private TableView <DomainObject>  table;
    private Button but;
    private final ObservableList list;
    private TableViewWrapper tableViewWrapper;
    private   UnitOfWork unitOfWork;



    @SuppressWarnings("unchecked")
    public RowDeleteFromTable(TableViewWrapper t) {
        this.tableViewWrapper = t;
        this.table= (TableView<DomainObject>) this.tableViewWrapper.getElement();
        this.list=this.table.getItems();
        this.unitOfWork = this.tableViewWrapper.getUnitOfWork();
    }
    
    
    

    @Override
    public void setElement(AppNode node) {
        but=(Button) node.getElement();   
        but.setOnMouseClicked((event) -> {
            try {
                run();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        
    }


    @Override
    public void run() throws SQLException {

        TableView.TableViewSelectionModel<DomainObject> selectionModel = table.getSelectionModel();

        if(!selectionModel.isEmpty()){

            final DomainObject selectedItem = selectionModel.getSelectedItem();
            this.list.remove(selectedItem);
            this.unitOfWork.setRemovedPojoes(selectedItem);
            this.unitOfWork.commitRemoved();

        }


    
    }
    

}
