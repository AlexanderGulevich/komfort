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
public class ColumnInteger<T> extends ColumnWrapper<T>{
    protected TableColumn<T,Integer> column;

    @SuppressWarnings("unchecked")
    public ColumnInteger(ColumnWrapper.Bulder builder) {
                
        super(builder);
//        this.domainChanging =builder.domainChanging;
        this.column =  new TableColumn<>(columnName);
   
        column.setCellValueFactory(new PropertyValueFactory<>(propertyName));
        column.setCellFactory(
                TextFieldTableCell.forTableColumn(
                        new IntegerStringConverter()
                ));
        
        
    }
    
    
    
    public void initEditPoliticy(){

        editPoliticy.setColumn(this.column);
        editPoliticy.setDomainChanging(this.domainChanging);
        editPoliticy.setUnitOfWork(this.tableWrapper.getUnitOfWork());
        editPoliticy.setTvw(this.tableWrapper);
        editPoliticy.run();
    }
      

      public TableColumn<T,Integer>  getColumn(){
    
        return this.column;
    
    }
      
}
