/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.controlPolicy;

import basisFx.appCore.dataSource.UnitOfWork;
import basisFx.appCore.elements.TableViewWrapper;
import basisFx.domainModel.pojo.DomainObject;
import java.util.List;
import javafx.collections.ListChangeListener;

/**
 *
 * @author 62
 */
public class TableListener  implements ListChangeListener  {

    private  TableViewWrapper nTableView;
    private  UnitOfWork unitOfWork;

    public TableListener() {}

    public TableListener(TableViewWrapper nTableView) {
        this.nTableView=nTableView;
        this.unitOfWork=nTableView.getUnitOfWork();
    }
    
    public void setNTableView(TableViewWrapper nTableView){
        this.nTableView=nTableView;
        this.unitOfWork=nTableView.getUnitOfWork();
    }
    
    @Override
    public void onChanged(ListChangeListener.Change change) {

		while (change.next()) {
			if (change.wasPermutated()) {
                        System.out.println("wasPermutated");
			}
			else if (change.wasUpdated()) {
                        System.out.println("wasUpdated");
			}
			else if (change.wasReplaced()) {
                        System.out.println("wasReplaced");
			}
			else if (change.wasRemoved()) {
                       
                            System.out.println("wasRemoved");
                            List removed = change.getRemoved();
                            
                        
                        }
                        else if (change.wasAdded()) {
                        
                            @SuppressWarnings("unchecked")
                            List<DomainObject> subList = change.getAddedSubList();
                            DomainObject p = subList.get(0);
                            
                            if ( !unitOfWork.getStoredPojoesId().contains(p.getId())) {
                              this.unitOfWork.setNewPojoes(p);
                              System.out.println("wasAdded");
                            }else{
                            
//                              System.out.println("not was added");

                            }
                            
                           
                            
                        }
			}
		}
	}

    
    
    
    
    