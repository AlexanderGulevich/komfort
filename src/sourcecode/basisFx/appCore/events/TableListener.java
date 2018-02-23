/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.events;

import basisFx.domainModel.pojo.Pojo;
import java.util.List;
import javafx.collections.ListChangeListener;

/**
 *
 * @author 62
 */
public class TableListener <T>implements ListChangeListener  {

    
    private boolean wasUpdated=false;
    
    /**
     *
     * @param change
     */
    @Override
    public void onChanged(ListChangeListener.Change change) {

		while (change.next()) {
			if (change.wasPermutated()) {
//				handlePermutated(change);
 System.out.println("wasPermutated");
			}
			else if (change.wasUpdated()) {
			    handleUpdated(change);
System.out.println("wasUpdated");
			}
			else if (change.wasReplaced()) {
//			    handleReplaced(change);
System.out.println("wasReplaced");
			}
			else {
                        if (change.wasRemoved()) {
//				    handleRemoved(change);
System.out.println("wasRemoved");
                        }
                        else if (change.wasAdded()) {
                            handleAdded(change);
System.out.println("wasAdded");
                        }
			}
		}
	}

    
    
    
    
    
    

//	public void handlePermutated(ListChangeListener.Change<? extends Person> change) {
//		System.out.println("Change Type: Permutated");		
//		System.out.println("Permutated Range: " + getRangeText(change));		
//		int start = change.getFrom();
//		int end = change.getTo();
//		for(int oldIndex = start; oldIndex < end; oldIndex++) {
//			int newIndex = change.getPermutation(oldIndex);
//			System.out.println("index[" + oldIndex + "] moved to " + 
//			                   "index[" + newIndex + "]");
//		}
//	}
//
	public void handleUpdated(ListChangeListener.Change<T> change) {
		System.out.println("Change Type: Updated");	    
		System.out.println("Updated Range : " + getRangeText(change));		
		System.out.println("Updated elements are: " + 
			change.getList().subList(change.getFrom(), change.getTo()));
	}
//
//	public void handleReplaced(ListChangeListener.Change<? extends Person> change) {
//		System.out.println("Change Type: Replaced");
//
//		// A "replace" is the same as a “remove” followed with an "add"
//		handleRemoved(change);
//		handleAdded(change);
//	}	
//	
//	public void handleRemoved(ListChangeListener.Change<? extends Person> change) {
//		System.out.println("Change Type: Removed");
//
//		int removedSize = change.getRemovedSize();
//		List<? extends Person> subList = change.getRemoved();
//
//		System.out.println("Removed Size: " + removedSize);
//		System.out.println("Removed Range: " + getRangeText(change));
//		System.out.println("Removed List: " + subList);    
//	}	
	
	public void handleAdded(ListChangeListener.Change<T> change) {
		System.out.println("Change Type: Added");
		
		int addedSize = change.getAddedSize();
		List<? extends T> subList = change.getAddedSubList();
		
		System.out.println("Added Size: " + addedSize);
		System.out.println("Added Range: " + getRangeText(change));
		System.out.println("Added List: " + subList);	
	}
	
	public String getRangeText(ListChangeListener.Change<T> change) {
		return "[" + change.getFrom() + ", " + change.getTo() + "]";
	}
//    
}
