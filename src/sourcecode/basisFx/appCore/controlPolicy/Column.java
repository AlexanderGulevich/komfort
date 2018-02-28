/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.controlPolicy;

import basisFx.appCore.dataSource.UnitOfWork;
import basisFx.appCore.elements.NTableView;
import java.time.LocalDate;
import javafx.scene.control.TableColumn;

/**
 *
 * @author Alek
 */
public abstract class Column<T> {

    protected NTableView tableManeger;
    
    
   
         public abstract   TableColumn getColumn();
         
    
         public void  setTableViewManager(NTableView t){
         
             this.tableManeger=t;
             
         
         };
       
     
    
}
