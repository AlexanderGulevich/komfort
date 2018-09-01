///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package basisFx.dataSource;
//
//import basisFx.appCore.interfaces.Refreshable;
//import basisFx.appCore.domainScetch.DomainObject;
//
//import java.sql.SQLException;
//import java.util.*;
//import java.util.concurrent.ConcurrentHashMap;
//
///**
// *
// * @author Alek
// */
//public class UnitOfWork {
//    private List<Integer> storedPojoesId=new ArrayList<>();
//    private List <DomainObject>newPojoes=new ArrayList<>();
//    private List <DomainObject>removedPojoes=new ArrayList<>();
//    private List <DomainObject>changedPojoes=new ArrayList<>();
//    private Refreshable refreshable;
//
//    public void setNewPojoes(DomainObject p){
//
//        this.newPojoes.add(p);
//
//    }
//    public void setRemovedPojoes(DomainObject p){
//
//        this.removedPojoes.add(p);
//
//    }
//    public void setChangedPojoes(DomainObject p){
//
//        System.err.println("UnitOfWork.setChangedPojoes,   getTableName==="+p.getTableName());
//
//        this.changedPojoes.add(p);
//
//    }
//    public List <DomainObject> getNewPojoes(){
//
//        return newPojoes;
//
//    }
//    public List<DomainObject> getRemovedPojoes() {
//
//        return removedPojoes;
//    }
//    public List<DomainObject> getChangedPojoes() {
//
//        return changedPojoes;
//    }
//    public List<Integer> getStoredPojoesId() {
//
//        return storedPojoesId;
//    }
//    public void clearStoredPojoesId(){
//
//
//        this.storedPojoesId.clear();
//
//    }
//    public void clearNewPojoesList(){
//
//        this.newPojoes.clear();
//    }
//    public void clearRemovedPojoesList(){
//
//        this.removedPojoes.clear();
//    }
//    public void clearChangedPojoesList(){
//        System.err.println("UnitOfWork.clearChangedPojoesList");
//        this.changedPojoes.clear();
//
//    }
//    public void commitAll() throws SQLException{
//        commitNew();
//        commitChanged();
//        commitRemoved();
//
//        System.err.println("UnitOfWork.commitAll");
//    }
//    public void commitNew(){
//
//        boolean isReady=true;
//        Set<DomainObject> domainObjects = Collections.newSetFromMap(new ConcurrentHashMap<DomainObject, Boolean>() {});
//        domainObjects.addAll(newPojoes);
//
//
//
//        for (Iterator<DomainObject> iterator = domainObjects.iterator(); iterator.hasNext();) {
//            DomainObject next = iterator.next();
//
//            if (next.getDataMapper().isReadyToTransaction(next)) {
//
//                next.getDataMapper().insertDomainObject(next);
//
//
//
//
//                System.err.println("\n");
//                System.err.println("UnitOfWork ");
//                System.err.println("ПРОИЗОШЕЛА попытка КОММИТА НОВОГО ДОМЕНА  в UnitOfWork next.getDataMapper().insertDomainObject(next);");
//                System.err.println("ДАТА МАППЕР----" + next.getDataMapper());
//                System.err.println("ДОМЕН----" + next);
//                System.err.println("\n");
//
//
//            }else {
//                isReady=false;
//            }
//
//
//        }
//
//
//        if (isReady){
//
//            clearNewPojoesList();
//            refreshable.refresh();
//
//        }
//
//    }
//    public void commitChanged(){
//
//        boolean isReady=true;
//
//        for (Iterator<DomainObject> iterator = changedPojoes.iterator(); iterator.hasNext();) {
//            DomainObject next = iterator.next();
//
//            if (next.getDataMapper().isReadyToTransaction(next)) {
//
//                next.getDataMapper().updateDomainObject(next);
//
//                System.err.println("\n");
//                System.err.println("UnitOfWork ");
//                System.err.println("ПРОИЗОШЕЛ КОММИТ ИЗМЕНЕННОГО ДОМЕНА");
//                System.err.println("ДАТА МАППЕР----" + next.getDataMapper());
//                System.err.println("ДОМЕН----" + next);
//                System.err.println("\n");
//
//
//            }else {
//                isReady=false;
//            }
//
//
//        }
//
//
//        if (isReady){
//
//            clearChangedPojoesList();
//            refreshable.refresh();
//
//        }
//
//
//
//    }
//    public void commitRemoved() throws SQLException{
//
//        for (Iterator<DomainObject> iterator = removedPojoes.iterator(); iterator.hasNext();) {
//            DomainObject next = iterator.next();
//
//            if (!getNewPojoes().contains(next)) {// если обеъект не является новым, то удаляем их БД
//
//                next.getDataMapper().deleteDomainObject(next);
//
//                System.err.println("UnitOfWork.commitRemoved");
//            }else {
//                System.err.println("Объект является новым, поэтому нет обращения к БД на удаление");
//            }
//
//        }
//        clearRemovedPojoesList();
//
//
//    }
//
//    public void setRefreshable(Refreshable r) {
//
//
//       this.refreshable=r;
//
//    }
//
//}
