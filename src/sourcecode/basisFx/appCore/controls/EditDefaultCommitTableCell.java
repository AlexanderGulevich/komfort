//package basisFx.appCore.controls;
//
//import basisFx.appCore.domainScetch.DomainObject;
//import javafx.beans.value.ObservableValue;
//import javafx.beans.value.WritableValue;
//
//public class EditDefaultCommitTableCell<T,K> extends Edit<T,K>{
//
//    public void run() {
//
//
//
//            column.setOnEditCommit((event) -> {
//
//                if (Checking.check(kindOfColumn, event)) {
//
//                    DomainObject domain = (DomainObject) event.getRowValue();
//
//                //проверяет, есть ли такой id в бд
//                if (unitOfWork.getStoredPojoesId().contains(domain.getId())) {
//
//                    System.err.println("\n");
//                    System.err.println(" EditDefaultCommitTableCell");
//                    System.err.println(" Доменный объект есть В БД ");
//                    System.err.println("\n");
//
//
//                    //todo НАШЕЛ, КАК ИЗМЕНЯТЬ ДОМЕН БЕЗ ЛЯМБДЫ
//                    int row = event.getTablePosition().getRow();
////                    T cellObservableValue = (T)event.getTableColumn().getCellObservableValue(row);
//                    ObservableValue<K> v = event.getTableColumn().getCellObservableValue(row);
//                    if (v instanceof WritableValue) {
//                        ((WritableValue<K>)v).setValue(event.getNewValue());
//                    }
//
////                    System.out.println("11111111111111111111"+cellObservableValue1);
//
////                    this.domainChanging.change(domain, event.getNewValue());
//
//                    unitOfWork.setChangedPojoes(domain);
//                    unitOfWork.updateDirty();
//
//
//                } else {
//
//                    //проверяет, новый ли это объект из уже созданных но не имеющихся в БД
//                    if (unitOfWork.getNewPojoes().contains(domain)) {
//
//                        //вставить значение в домен
//                        this.domainChanging.change(domain, event.getNewValue());
//
//                        System.err.println("\n");
//                        System.err.println("EditDefaultCommitTableCell");
//                        System.err.println("редактирование части кортежа НОВОГО ОБЪЕКТА");
//                        System.err.println("НОВЫЙ ОБЪЕКТ отправляется ТРАНЗАКЦИИ, если кортеж полный");
//                        System.err.println("\n");
//
//                        unitOfWork.updateNew();
//
//                    }
//                }
//
//            } });
//
//       }
//
//
//
//
//
//
//
//}
