//package basisFx.domainModel.old;
//
///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package hepo.domainModel;
//
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//
///**
// *
// * @author Alek
// */
//public abstract class Communicator  <T>{
//    
//    protected ObservableList<T>  allPojo=FXCollections.<T> observableArrayList();
//    
//    public  ObservableList <T> getAllPojoes(){
//    
//        return this.allPojo;
//    };        
//    public void setPojo(T pojo){
//        this.allPojo.add(pojo);
//    };
//    public ObservableList cloneAllPojo()throws CloneNotSupportedException{
//    
//    ObservableList<T>  col=FXCollections.observableArrayList(this.allPojo);
//    
//    return col;
// 
//    }
//    public GoodsPojoCommunicator clone()throws CloneNotSupportedException{
//    
//        ObjectOutputStream out=null;
//        try {
//            ByteArrayOutputStream bout=new ByteArrayOutputStream();
//            out = new ObjectOutputStream(bout);
//            out.writeObject(this);
//            InputStream bin=new ByteArrayInputStream(bout.toByteArray());
//            ObjectInputStream in=new ObjectInputStream(bin);
//            try {
//                return (GoodsPojoCommunicator) in.readObject();
//            } catch (ClassNotFoundException ex) {
//                Logger.getLogger(GoodsPojoCommunicator.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } catch (IOException ex) {
//            Logger.getLogger(GoodsPojoCommunicator.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                out.close();
//            } catch (IOException ex) {
//                Logger.getLogger(GoodsPojoCommunicator.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    return null;
//    }
//  
//    
//}
