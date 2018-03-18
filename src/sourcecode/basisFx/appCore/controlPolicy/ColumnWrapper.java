/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.controlPolicy;

import basisFx.appCore.domainScetch.ComboBoxCellValueInitLogic;
import basisFx.appCore.elements.TableViewWrapper;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.TableColumn;

/**
 *
 * @author Alek
 */
public  class ColumnWrapper<T> {

    protected TableViewWrapper tableWrapper;
    protected String propertyName;
    protected String columnName;
    protected Checking valueChecking;
    protected double columnSize;
    protected List <Edit> editPoliticy;
    protected ComboBoxCellValueInitLogic comboBoxCellValueInitLogic;
    protected TableColumn column;
    protected PojoChanging pojoChanging;
    

    public ColumnWrapper(Bulder b) {
        
        this.propertyName=b.propertyName;
        this.columnName=b.columnName;
        this.valueChecking=b.valueChecking;
        this.columnSize=b.columnSize;
        this.editPoliticy=b.editPoliticy;
        this.comboBoxCellValueInitLogic=b.comboBoxCellValueInitLogic;

    }
    
         public TableColumn getColumn(){return null;};
         
    
         public void  setTableWrapper(TableViewWrapper t){
         
             this.tableWrapper=t;
             
         
         };

    public double getColumnSize() {
        return columnSize;
    }

    public void initEditPoliticy() {}


     public static class Bulder{
         

        protected String propertyName;
        protected String columnName;
        protected Checking valueChecking;
        protected PojoChanging domainChangeAction;
        protected double columnSize;
        protected List <Edit> editPoliticy=new ArrayList<>();
        protected ComboBoxCellValueInitLogic comboBoxCellValueInitLogic;

        public static Bulder create(){
            return new Bulder();
        }
      
         public  Bulder setColumnName(String columnName){
         this.columnName=columnName;
         return this;
         
         }
      
         public  Bulder setEditPoliticy(Edit ...editPoliticy ){
             for (Edit edit : editPoliticy) {
                  this.editPoliticy.add(edit);
             }
    
        
         return this;
         
         }

         public Bulder setComboBoxCellValueInitLogic(ComboBoxCellValueInitLogic comboBoxCellValueInitLogic) {
             this.comboBoxCellValueInitLogic = comboBoxCellValueInitLogic;
             return this;
         }

         public  Bulder setColumnSize(double size){
         this.columnSize=size;
         return this;
         
         }
         public  Bulder setPropertyName(String propertyName){
         this.propertyName=propertyName;         
         return this;
         
         }
         public  Bulder setValueChecking(Checking valueChecking){
         this.valueChecking=valueChecking;         
         return this;
         
         }
         public  Bulder setDomainObjectChanging(PojoChanging domainChangeAction){
         this.domainChangeAction=domainChangeAction;         
         return this;
         
         }
         
         
         
     
     }
    
}
