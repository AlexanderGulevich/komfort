package basisFx.domainModel;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package hepo.domainModel;
//
//import javafx.scene.control.Button;
//import javafx.scene.layout.AnchorPane;
//import javafx.scene.text.Text;
//
///**
// *
// * @author Alek
// */
//public abstract class WindowConfirmation extends Window{
//    protected Button yesBut=null;
//    protected Button noBut=null;
//    protected Text text=new Text();
//    
//    public WindowConfirmation() {
//        super(500, 300);
//        
//        yesBut=new Button("ДА");
//        yesBut.setPrefSize(50.0, 30.0);
//        
//        noBut=new Button("НЕТ");
//        noBut.setPrefSize(50.0, 30.0);
//        
//         popupRoot.getChildren().add(yesBut);
//        AnchorPane.setBottomAnchor(yesBut, 20.0);
//        AnchorPane.setRightAnchor(yesBut, 20.0);
//        
//        popupRoot.getChildren().add(noBut);
//        AnchorPane.setBottomAnchor(noBut, 20.0);
//        AnchorPane.setRightAnchor(noBut, 100.0);
//        
//        popupRoot.getChildren().add(text);
//        text.wrappingWidthProperty().bind(popupRoot.widthProperty().multiply(0.7));
//        AnchorPane.setTopAnchor(text, 40.0);
//        AnchorPane.setLeftAnchor(text, 30.0);  
//        AnchorPane.setRightAnchor(text, 30.0);    
//        
//        
//         text.setStyle(
//                "-fx-font-size:20px;"
//                + "fx-font-weight:800;"
//                + ""
//                + ""
//                + ""
//                + "");
//        
//        
//    }
//    protected abstract void setEvents();
//    public abstract void setMessege();
//    public abstract void setTitle();
//    
//}
