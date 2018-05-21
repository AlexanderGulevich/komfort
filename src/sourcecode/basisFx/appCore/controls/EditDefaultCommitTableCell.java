/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.controls;

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

                if (Checking.check(kindOfColumn, event)) {

                    DomainObject domain = (DomainObject) event.getRowValue();

                //проверяет, есть ли такой id в бд
                if (unitOfWork.getStoredPojoesId().contains(domain.getId())) {

                    System.err.println("\n");
                    System.err.println(" EditDefaultCommitTableCell");
                    System.err.println(" Доменный объект есть В БД ");
                    System.err.println("\n");

                    this.domainChanging.change(domain, event.getNewValue());

                    unitOfWork.setChangedPojoes(domain);
                    unitOfWork.commitChanged();


                } else {

                    //проверяет, новый ли это объект из уже созданных но не имеющихся в БД
                    if (unitOfWork.getNewPojoes().contains(domain)) {

                        //вставить значение в домен
                        this.domainChanging.change(domain, event.getNewValue());

                        System.err.println("\n");
                        System.err.println("EditDefaultCommitTableCell");
                        System.err.println("редактирование части кортежа НОВОГО ОБЪЕКТА");
                        System.err.println("НОВЫЙ ОБЪЕКТ отправляется ТРАНЗАКЦИИ, если кортеж полный");
                        System.err.println("\n");

                        unitOfWork.commitNew();

                    }
                }

            } });
             
       }
       
       
      
    
    
    
    
}
