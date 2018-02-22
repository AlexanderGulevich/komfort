/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore;

import basisFx.domainModel.pojo.Equipment;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;

/**
 *
 * @author 62
 */
public class EddingCellValueFactory <T> {
//
////    protected TableView<T> table;
    private TableColumn<T,Integer> column;
    private final String propertyName;

    public EddingCellValueFactory( String propertyName) {
        
        this.column =  new TableColumn<>("Ширина стержня");;
        this.propertyName=propertyName;
        setEddingVF();
    }

    
    
    
    public EddingCellValueFactory<T>  setEddingVF(){
        
        column.setCellValueFactory(new PropertyValueFactory<>(propertyName));
        column.setCellFactory(
                        TextFieldTableCell.forTableColumn(
                                new IntegerStringConverter()));
               
        
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
 
    
    
        return this;
    }
    
    public TableColumn getColumn(){
    
        return this.column;
    
    }

}
