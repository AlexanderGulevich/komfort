package basisFx.domainModel;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package hepo.domainModel;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javafx.stage.DirectoryChooser;
//
///**
// *
// * @author Alek
// */
//public class DirectoryChooserWrapper {
//    
//    DirectoryChooser dc;
//    private String path=null;
//
//    public DirectoryChooserWrapper() {
//        
//            dc=new DirectoryChooser();  
//           
//            
//            File dir=dc.showDialog(null);
//            
//            try {
//                path = dir.getCanonicalPath();
//            } catch (IOException ex) {
//                Logger.getLogger(PriceTab.class.getName()).log(Level.SEVERE, null, ex);
//            }
//    }
//    
//    public void setInitialDirectory(String dir){
//    //"D:\\Desctop"
//        dc.setInitialDirectory(new File(dir));
//    
//    }
//    public void setTitle(String dir){
//
//        dc.setTitle(dir);
//    
//    }
//
//    public String getPath() {
//        return path;
//    }
//    
//    
//    
//    
//    
//    
//    
//}
