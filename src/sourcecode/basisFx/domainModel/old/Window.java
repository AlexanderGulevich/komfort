package basisFx.domainModel.old;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package hepo.domainModel;
//
//import hepo.appCore.CommonVar;
//import javafx.scene.Scene;
//import javafx.scene.image.Image;
//import javafx.scene.layout.AnchorPane;
//import javafx.stage.Stage;
//import hepo.appCore.Conctractable;
//
///**
// *
// * @author Alek
// */
//abstract class Window extends Conctractable{
//    
//    protected  Stage popupStage;
//    protected  AnchorPane popupRoot;
//    protected  Scene popupScene;
//    
//
//    public Window(int x, int y) {
//                           
//        this.popupStage =new Stage();
//        this.popupRoot=new AnchorPane();
//        this.popupScene= new Scene(popupRoot, x, y);
//        this.popupStage.setScene(popupScene);
//        popupStage.getIcons().add(
//                new Image(getClass().getResourceAsStream("/hepo/resources/bank.png")
//                ));
//      
//        popupStage.show();
//                    
//        
//    }
//
//    
//    
//}
