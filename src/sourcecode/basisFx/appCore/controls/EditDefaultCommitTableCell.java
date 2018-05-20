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
                System.err.println(" <<<<<<<<<<<<<<<<<<<column.setOnEditCommit".toUpperCase());
                if (Checking.check(kindOfColumn, event)) {

                DomainObject domain = (DomainObject) event.getRowValue();

                //проверяет, есть ли такой id в бд
                if (unitOfWork.getStoredPojoesId().contains(domain.getId())) {

                    System.err.println("EditDefaultCommitTableCell- Доменный объект есть В БД ");

                    this.domainChanging.change(domain, event.getNewValue());

                    System.err.println("EditDefaultCommitTableCell - Доменный объект готов к транзакции ");

                    unitOfWork.setChangedPojoes(domain);
                    unitOfWork.commitChanged();


                } else {

                    //проверяет, новый ли это объект из уже созданных но не имеющихся в БД
                    if (unitOfWork.getNewPojoes().contains(domain)) {

                        System.err.println("EditDefaultCommitTableCell -редактирование части кортежа НОВОГО ОБЪЕКТА");

                        //вставить значение в домен
                        this.domainChanging.change(domain, event.getNewValue());

                        System.err.println("EditDefaultCommitTableCell - НОВЫЙ ОБЪЕКТ отправляется на попытку ТРАНЗАКЦИИ, есл кортеж окажется полным");

                        unitOfWork.commitNew();

                    }
                }

            } });
             
       }
       
       
      
    
    
    
    
}
