/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.controlPolicy;

import basisFx.appCore.DateCellValueInitLogic;
import basisFx.appCore.DomainsListGetter;
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
    protected EditFabric editFabric=new EditFabric();
    protected Edit editPoliticy=editFabric.createDefaultEditCommit();
    protected ComboBoxCellValueInitLogic comboBoxCellValueInitLogic;
    protected TableColumn column;
    protected DomainChanging domainChanging;
    protected DomainsListGetter domainObjectsListGetter;
    protected DateCellValueInitLogic dateCellValueInitLogic;
    protected Boolean isEditeble;



    public ColumnWrapper(Bulder b) {
        
        this.propertyName=b.propertyName;
        this.columnName=b.columnName;
        this.valueChecking=b.valueChecking;
        this.columnSize=b.columnSize;
        this.comboBoxCellValueInitLogic=b.comboBoxCellValueInitLogic;
        this.domainObjectsListGetter =b.domainsListGetter;
        this.domainChanging =b.domainChanging;
        this.dateCellValueInitLogic=b.dateCellValueInitLogic;
        this.isEditeble=b.isEditeble;

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
         protected DomainChanging domainChanging;
         protected double columnSize;
         protected ComboBoxCellValueInitLogic comboBoxCellValueInitLogic;
         protected DomainsListGetter domainsListGetter;
         protected DateCellValueInitLogic dateCellValueInitLogic;
         protected Boolean isEditeble;


         public Bulder() {
         }

         public Bulder(String columnName, String propertyName, Double columnSize ) {
             setColumnName(columnName);
             setColumnSize(columnSize);
             setPropertyName(propertyName);
         }

         public static Bulder create(){
             return new Bulder();
         }
         public static Bulder create(String columnName, String propertyName, Double columnSize ){
             return new Bulder( columnName,  propertyName,  columnSize);
         }

         public Bulder setEditeble(Boolean editeble) {
             isEditeble = editeble;
             return this;
         }

         public  Bulder setColumnName(String columnName){
         this.columnName=columnName;
         return this;
         
         }

         public Bulder setComboBoxCellValueInitLogic(ComboBoxCellValueInitLogic comboBoxCellValueInitLogic) {
             this.comboBoxCellValueInitLogic = comboBoxCellValueInitLogic;
             return this;
         }

         public Bulder setDateCellValueInitLogic(DateCellValueInitLogic dateCellValueInitLogic) {
             this.dateCellValueInitLogic = dateCellValueInitLogic;
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
         public  Bulder setDomainChanging(DomainChanging domainChanging){
         this.domainChanging = domainChanging;
         return this;
         
         }


         public Bulder setDomainsListGetter(DomainsListGetter domainsListGetter) {
             this.domainsListGetter = domainsListGetter;
             return this;
         }
     }
    
}
