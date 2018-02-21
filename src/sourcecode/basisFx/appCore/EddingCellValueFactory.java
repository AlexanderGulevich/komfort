/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore;

import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TreeTableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

/**
 *
 * @author 62
 */
public class EddingCellValueFactory <T , E> {
//
////    protected TableView<T> table;
    private TableColumn<T,E> column;
    private final String name;

    public EddingCellValueFactory(TableColumn<T, E> column, String name) {
        this.column = column;
        this.name=name;
        setVf();
    }

    
    
    
    public void setVf(){
        
        column.setCellValueFactory(
            new PropertyValueFactory<T, E>(name));
            column.setCellFactory(TextFieldTableCell.forTableColumn());
//            column.setOnEditCommit(
////            new EventHandler<CellEditEvent<T, E>() {
////                
//////                @Override
//////                public void handle(CellEditEvent<T, E> t) {
////////                    ((Person) t.getTableView().getItems().get(
////////                            t.getTablePosition().getRow())
////////                            ).setFirstName(t.getNewValue());
//////                }
////            }
//        );
 
    
    
        
    }

}
