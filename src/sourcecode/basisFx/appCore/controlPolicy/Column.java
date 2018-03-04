/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.controlPolicy;

import basisFx.appCore.controlPolicy.Column.Bulder;
import basisFx.appCore.elements.AppNode;
import basisFx.appCore.elements.NTableView;
import javafx.scene.control.TableColumn;

/**
 *
 * @author Alek
 */
public  class Column<T> {

    protected NTableView tableManeger;
    protected String propertyName;
    protected String columnName;
    protected ValueChecking valueChecking;

    public Column(Bulder b) {
        
        this.propertyName=b.propertyName;
        this.columnName=b.columnName;
        this.valueChecking=b.valueChecking;
        
        
    }

    
         public TableColumn getColumn(){return null;};
         
    
         public void  setTableViewManager(NTableView t){
         
             this.tableManeger=t;
             
         
         };
       
     public static class Bulder{
         

        protected String propertyName;
        protected String columnName;
        protected ValueChecking valueChecking;
        protected DomainChangeAction domainChangeAction;

        public static Bulder create(){
            return new Bulder();
        }
      
         public  Bulder setColumnName(String columnName){
         this.columnName=columnName;
         return this;
         
         }
         public  Bulder setPropertyName(String propertyName){
         this.propertyName=propertyName;         
         return this;
         
         }
         public  Bulder setValueChecking(ValueChecking valueChecking){
         this.valueChecking=valueChecking;         
         return this;
         
         }
         public  Bulder setDomainChangeAction(DomainChangeAction domainChangeAction){
         this.domainChangeAction=domainChangeAction;         
         return this;
         
         }
         
         
         
     
     }
    
}
