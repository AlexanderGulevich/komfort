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


                DomainObject domain= (DomainObject) event.getRowValue();
                NamedDomainObject namedDomainObject= (NamedDomainObject) event.getRowValue();

                //проверяет, есть ли такой id в бд
                if (unitOfWork.getStoredPojoesId().contains(domain.getId())) {

                   System.out.println("Доменный объект есть В БД ");

                   this.domainChangeAction.change(domain,event.getNewValue());


                      if (domain.isReadyToTransaction()) {

                          System.out.println("Доменный объект готов к транзакции ");

                          unitOfWork.setChangedPojoes(domain);
                         unitOfWork.commitChanged();
                       
                      } else {

                          System.out.println("Доменный объект  НЕ готов к транзакции ");
                      }
                    
                }else{

                    //проверяет, новый ли это объект из уже созданных но не имеющихся в БД
                        if (unitOfWork.getNewPojoes().contains(domain)) {

                            System.out.println("НОВЫЙ ОБЪЕКТ");

                            //вставить значение в домен
                            this.domainChangeAction.change(domain,event.getNewValue());

                            if (domain.isReadyToTransaction()) {

                                System.out.println("НОВЫЙ ОБЪЕКТ ГОТОВ К ТРАНЗАКЦИИ {");

                                unitOfWork.commitNew();
                            } else {

                                System.out.println("НОВЫЙ ОБЪЕКТ не ГОТОВ К ТРАНЗАКЦИИ {");
                            }
                        }
                }
                
        });
//       this.tvw.refresh();
             
       }
       
       
      
    
    
    
    
}
