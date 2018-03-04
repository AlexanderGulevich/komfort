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
public class IntegerColumn <T> extends ColumnWrapper<T>{
    protected TableColumn<T,Integer> column;
    protected PojoChanging<T,String> pojoChanging;

    @SuppressWarnings("unchecked")
    public IntegerColumn(ColumnWrapper.Bulder builder) {
                
        super(builder);
        this.pojoChanging=builder.domainChangeAction;
        this.column =  new TableColumn<>(columnName);
   
        column.setCellValueFactory(new PropertyValueFactory<>(propertyName));
        column.setCellFactory(
                        TextFieldTableCell.forTableColumn(
               new IntegerStringConverter()
                        ));
        
        
    }
    
    
    
    public void initEditPoliticy(){

        for (Edit edit : editPoliticy) {
            edit.setColumn(this.column);
            edit.setPojoChanging(this.pojoChanging);
            edit.setUnitOfWork(this.tableWrapper.getUnitOfWork());
            edit.setTvw(this.tableWrapper);
            edit.run();
            
        }
          
          
    }
      

      public TableColumn<T,Integer>  getColumn(){
    
        return this.column;
    
    }
      
}
