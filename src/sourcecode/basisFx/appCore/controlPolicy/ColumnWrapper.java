/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.controlPolicy;

import basisFx.appCore.NamedObjectListGetter;
import basisFx.appCore.domainScetch.ComboBoxCellValueInitLogic;
import basisFx.appCore.elements.TableViewWrapper;
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
//    protected List <Edit> editPoliticy;
    protected EditFabric editFabric=new EditFabric();
    protected Edit editPoliticy=editFabric.createDefaultEditCommit();
    protected ComboBoxCellValueInitLogic comboBoxCellValueInitLogic;
    protected TableColumn column;
    protected DomainChangeAction domainChangeAction;
//    protected DataMapper dataMapper;
    protected NamedObjectListGetter namedObjectListGetter;



    public ColumnWrapper(Bulder b) {
        
        this.propertyName=b.propertyName;
        this.columnName=b.columnName;
        this.valueChecking=b.valueChecking;
        this.columnSize=b.columnSize;
//        this.editPoliticy=b.editPoliticy;
        this.comboBoxCellValueInitLogic=b.comboBoxCellValueInitLogic;
//        this.dataMapper=b.dataMapper;
        this.namedObjectListGetter=b.namedObjectListGetter;
        this.domainChangeAction =b.domainChangeAction;

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
        protected DomainChangeAction domainChangeAction;
        protected double columnSize;
//        protected List <Edit> editPoliticy=new ArrayList<>();
         protected ComboBoxCellValueInitLogic comboBoxCellValueInitLogic;
//         protected DataMapper dataMapper;
         protected NamedObjectListGetter namedObjectListGetter;



        public static Bulder create(){
            return new Bulder();
        }
      
         public  Bulder setColumnName(String columnName){
         this.columnName=columnName;
         return this;
         
         }
//
//         public  Bulder setEditPoliticy(Edit ...editPoliticy ){
//             for (Edit edit : editPoliticy) {
//                  this.editPoliticy.add(edit);
//             }
//
//
//         return this;
//
//         }

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
         public  Bulder setDomainChangeAction(DomainChangeAction domainChangeAction){
         this.domainChangeAction=domainChangeAction;         
         return this;
         
         }
//         public Bulder setDataMapper(DataMapper dm) {
//             this.dataMapper=dm;
//
//             return this;
//         }

         public Bulder setNamedObjectListGetter(NamedObjectListGetter namedObjectListGetter) {
             this.namedObjectListGetter = namedObjectListGetter;
             return this;
         }
     }
    
}
