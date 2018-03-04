/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.controlPolicy;

import basisFx.domainModel.pojo.DomainObject;

/**
 *
 * @author Alek
 * @param <T>
 * @param <K>
 */
public class EditCommitDefault<T,K> extends Edit<T,K>{

    public void run() {
            
            column.setOnEditCommit((event) -> {
               
                DomainObject domain= (DomainObject) event.getRowValue();
          
                //проверяет, есть ли такой id в бд
                if (unitOfWork.getStoredPojoesId().contains(domain.getId())) {
                    
                    
                      this.pojoChanging.change(domain,event.getNewValue());
                      if (domain.isReadyToTransaction()) {
                         unitOfWork.setChangedPojoes(domain);
                         unitOfWork.commitChanged();
                       
                      } 
                    
                }else{
                      
                        //проверяет, новый ли это объект из уже созданных
                        if (unitOfWork.getNewPojoes().contains(domain)) {

                            //вставить значение в домен
                            this.pojoChanging.change(domain,event.getNewValue());

                            if (domain.isReadyToTransaction()) {
                                 unitOfWork.commitNew();
                            } 
                        }
                }
                
        });
//       this.tvw.refresh();
             
       }
       
       
      
    
    
    
    
}
