/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.events;

import basisFx.appCore.dataSource.UnitOfWork;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.interfaces.RowCreater;
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
    private TableWrapper tableWrapper;
    private   UnitOfWork unitOfWork;



    @SuppressWarnings("unchecked")
    public RowAddToTable(TableWrapper tableWrapper, RowCreater rowCreater) {
        this.tableWrapper = tableWrapper;
        this.table= (TableView<T>) this.tableWrapper.getElement();
        this.list=this.table.getItems();
        this.rowCreater=rowCreater;
        this.unitOfWork = this.tableWrapper.getUnitOfWork();
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

            if(tableWrapper.isObserver()&& tableWrapper.getClickedDomain()!=null){
                rowCreater.createRow(list);

            }
            if (!tableWrapper.isObserver()){
                rowCreater.createRow(list);
            }


        }


    
    }
    

}
