/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.controlPolicy;

import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

/**
 *
 * @author Alek
 * @param <T>
 */
public class TextColumn<T> extends Column<T>{
    protected TableColumn<T,String> column;
    protected String propertyName;
    
    public TextColumn(String columnName,String propertyName) {
        
        this.column =  new TableColumn<>(columnName);
        this.propertyName=propertyName;
        setEddingPoliticy();
        
    }
 
    public TextColumn<T>  setEddingPoliticy(){
        
        column.setCellValueFactory(new PropertyValueFactory<>(propertyName));
        column.setCellFactory(TextFieldTableCell.forTableColumn());

        return this;
    }
    
      public TableColumn<T,String> getColumn(){
    
        return this.column;
    
    }
      
}
