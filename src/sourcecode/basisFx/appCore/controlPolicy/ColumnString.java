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
public class ColumnString<T> extends ColumnWrapper<T>{
    protected TableColumn<T,String> column;
//    protected DomainChangeAction<T,String> domainChangeAction;
   
    
    
    @SuppressWarnings("unchecked")
    public ColumnString(ColumnWrapper.Bulder builder) {
        
        super(builder);


        
        this.column =  new TableColumn<>(columnName);

        column.setEditable(isEditeble);
      
        column.setCellValueFactory(new PropertyValueFactory<>(propertyName));
        column.setCellFactory(TextFieldTableCell.forTableColumn());
        
    }



    public void initEditPoliticy(){

//        for (Edit edit : editPoliticy) {
//            edit.setColumn(this.column);
//            edit.setDomainChangeAction(this.domainChangeAction);
//            edit.setUnitOfWork(this.tableWrapper.getUnitOfWork());
//            edit.setTvw(this.tableWrapper);
//            edit.run();
//
//        }

        editPoliticy.setColumn(this.column);
        editPoliticy.setDomainChangeAction(this.domainChangeAction);
        editPoliticy.setUnitOfWork(this.tableWrapper.getUnitOfWork());
        editPoliticy.setTvw(this.tableWrapper);
        editPoliticy.run();
    }
      public TableColumn<T,String> getColumn(){
    
        return this.column;
    
    }

}
