/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.events;

import basisFx.appCore.dataSource.UnitOfWork;
import basisFx.appCore.elements.NTableView;
import basisFx.domainModel.pojo.DomainObject;
import java.util.List;
import javafx.collections.ListChangeListener;

/**
 *
 * @author 62
 */
public class TableListener  implements ListChangeListener  {

    private  NTableView nTableView;
    private  UnitOfWork unitOfWork;

    public TableListener() {}

    public TableListener(NTableView nTableView) {
        this.nTableView=nTableView;
        this.unitOfWork=nTableView.getUnitOfWork();
    }
    
    public void setNTableView(NTableView nTableView){
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
                        }
                        else if (change.wasAdded()) {
                        
                            @SuppressWarnings("unchecked")
                            List<DomainObject> subList = change.getAddedSubList();
                            DomainObject p = subList.get(0);
                            this.unitOfWork.setNewPojoes(p);

                            System.out.println("wasAdded");
                        }
			}
		}
	}

    
    
    
    
    