/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.controlPolicy;

import basisFx.appCore.domainScetch.DomainObject;
import basisFx.appCore.domainScetch.NamedDomainObject;
import basisFx.domainModel.pojo.Currency;

/**
 *
 * @author Alek
 * @param <T>
 * @param <K>
 */
public class EditDefaultCommitTableCell<T,K> extends Edit<T,K>{


    public void run() {
            
            column.setOnEditCommit((event) -> {


//                System.out.println("22222222222222222222222222222222");

                DomainObject domain= (DomainObject) event.getRowValue();
                NamedDomainObject namedDomainObject= (NamedDomainObject) event.getRowValue();

                //проверяет, есть ли такой id в бд
                if (unitOfWork.getStoredPojoesId().contains(domain.getId())) {

                   System.out.println("EditDefaultCommitTableCell------ ЕСТЬ ТАКОЙ ОБЪЕКТ В БД ---getId--- "+domain.getId());

                   this.domainChangeAction.change(domain,event.getNewValue());

                    System.out.println(" this.domainChangeAction.change(domain   --"+domain);

                      if (domain.isReadyToTransaction()) {
                         unitOfWork.setChangedPojoes(domain);
                         unitOfWork.commitChanged();
                       
                      } 
                    
                }else{

                    //проверяет, новый ли это объект из уже созданных но не имеющихся в БД
                        if (unitOfWork.getNewPojoes().contains(domain)) {

                            System.out.println("EditDefaultCommitTableCell------ НОВЫЙ ОБЪЕКТ");

                            //вставить значение в домен
                            this.domainChangeAction.change(domain,event.getNewValue());

                            if (domain.isReadyToTransaction()) {

                                System.out.println("EditDefaultCommitTableCell------ ГОТОВ К ТРАНЗАКЦИИ {");

                                unitOfWork.commitNew();
                            } 
                        }
                }
                
        });
//       this.tvw.refresh();
             
       }
       
       
      
    
    
    
    
}
