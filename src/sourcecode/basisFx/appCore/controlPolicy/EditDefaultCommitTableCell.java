/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.controlPolicy;

import basisFx.appCore.domainScetch.DomainObject;

/**
 *
 * @author Alek
 * @param <T>
 * @param <K>
 */
public class EditDefaultCommitTableCell<T,K> extends Edit<T,K>{

    public void run() {



            
            column.setOnEditCommit((event) -> {
                System.err.println("EditDefaultCommitTableCell.run");

                if (Checking.check(kindOfColumn, event)) {



                DomainObject domain = (DomainObject) event.getRowValue();

                //проверяет, есть ли такой id в бд
                if (unitOfWork.getStoredPojoesId().contains(domain.getId())) {

                    System.out.println("Доменный объект есть В БД ");

                    this.domainChanging.change(domain, event.getNewValue());


                    System.out.println("Доменный объект готов к транзакции ");

                    unitOfWork.setChangedPojoes(domain);
                    unitOfWork.commitChanged();

//
                } else {

                    //проверяет, новый ли это объект из уже созданных но не имеющихся в БД
                    if (unitOfWork.getNewPojoes().contains(domain)) {

                        System.out.println("НОВЫЙ ОБЪЕКТ");

                        //вставить значение в домен
                        this.domainChanging.change(domain, event.getNewValue());


                        System.out.println("НОВЫЙ отправляется на ТРАНЗАКЦИЮ{");

                        unitOfWork.commitNew();

                    }
                }

            } });
             
       }
       
       
      
    
    
    
    
}
