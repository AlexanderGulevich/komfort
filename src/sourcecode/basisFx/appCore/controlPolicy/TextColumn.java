/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.controlPolicy;

import basisFx.domainModel.pojo.DomainObject;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

/**
 *
 * @author Alek
 * @param <T>
 */
public class TextColumn<T> extends Column<T>{
    private TableColumn<T,String> column;
    private DomainChangeAction <T,String>domainChangeAction;
    
    
    @SuppressWarnings("unchecked")
    public TextColumn(Column.Bulder builder) {
        
        super(builder);
        this.domainChangeAction=builder.domainChangeAction;
        
        this.column =  new TableColumn<>(columnName);
      
        setEddingPoliticy();
        setOnEditCommit();
        
    }
 
    public TextColumn<T>  setEddingPoliticy(){
        
        column.setCellValueFactory(new PropertyValueFactory<>(propertyName));
        column.setCellFactory(TextFieldTableCell.forTableColumn());
        
        
        return this;
    }
    
      public TableColumn<T,String> getColumn(){
    
        return this.column;
    
    }
      
      
      
       public void setOnEditCommit() {
            
            column.setOnEditCommit((event) -> {
               
                DomainObject domain= (DomainObject) event.getRowValue();
              
                //проверяет, новый ли это объект
                if (tableManeger.getUnitOfWork().getNewPojoes().contains(domain)) {

                    //вставить значение в домен
                    this.domainChangeAction.change(domain,event.getNewValue());
                    
                    if (domain.isReadyToTransaction()) {
//                      
System.out.println("basisFx.appCore.controlPolicy.TextColumn.setOnEditCommit()");
                         tableManeger.getUnitOfWork().commitNew();
                        
                         
//                         tableManeger.refresh(event.getTablePosition());
                    } 
                    
                   
                }
                else 
                    if(tableManeger.getUnitOfWork().getChangedPojoes().contains(domain)) {
                     //вставить значение в домен
                    this.domainChangeAction.change(domain,event.getNewValue());
//                    
                    if (domain.isReadyToTransaction()) {
                         tableManeger.getUnitOfWork().setChangedPojoes(domain);
                         tableManeger.getUnitOfWork().commitChanged();
                       
                    } 
                    
                
                
                
                }
                
                
                
             
                
               

        });
             
       }
       
       
      
}
