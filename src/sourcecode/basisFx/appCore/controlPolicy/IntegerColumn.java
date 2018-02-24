/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.controlPolicy;

import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;

/**
 *
 * @author 62
 * @param <T>
 */
public class IntegerColumn <T> extends Column<T>{
    protected TableColumn<T,Integer> column;
    protected String propertyName;


    public IntegerColumn(String columnName,String propertyName) {
        
        this.column =  new TableColumn<>(columnName);
        this.propertyName=propertyName;
        setEddingPoliticy();
 
    }

    public IntegerColumn<T>  setEddingPoliticy(){
        
        column.setCellValueFactory(new PropertyValueFactory<>(propertyName));
        column.setCellFactory(
                        TextFieldTableCell.forTableColumn(
               new IntegerStringConverter()
                        ));
        return this;
    }

      public TableColumn<T,Integer>  getColumn(){
    
        return this.column;
    
    }
}
