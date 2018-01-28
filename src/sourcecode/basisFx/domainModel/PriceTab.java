package basisFx.domainModel;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package hepo.domainModel;
//
//import hepo.appCore.AbstractTab;
//import hepo.appCore.FileChoose;
//import hepo.domainModel.GoodsPojoCommunicator;
//import hepo.domainModel.GoodsPojo;
//import hepo.domainModel.Price;
//import hepo.domainModel.poi.WritePrice;
//import hepo.domainModel.poi.PriceReader;
//import hepo.domainModel.PanelPriceTableWithoutCategoryCreater;
//import hepo.domainModel.DirectoryChooserWrapper;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javafx.event.ActionEvent;
//import javafx.scene.control.Button;
//import javafx.scene.control.TableView;
//import javafx.scene.layout.AnchorPane;
//import javafx.stage.DirectoryChooser;
//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//
//public class PriceTab extends AbstractTab{
//    
//    protected Button priceBut;
//    
//    protected Button savingBut;
//    
//    protected TableView<GoodsPojo> table=null;
//    
//    protected List<File> files;
//    
//    protected GoodsPojoCommunicator gpc;
//    
//    protected Price price;
//    
//    
//    
//    public PriceTab(String id, String name, boolean closeable) {
//        
//        super(id, name, closeable);
//            
//        this.gpc=new GoodsPojoCommunicator();
//        
//        this.table=new PanelPriceTableWithoutCategoryCreater(gpc).getTable();
//        
//  
//        
//         table.getColumns().get(0).prefWidthProperty().bind(anchorPane.widthProperty().multiply(0.1));
//         table.getColumns().get(1).prefWidthProperty().bind(anchorPane.widthProperty().multiply(0.85));
//         
//        
//        
//      
//        
//        
//        
//        
//        
//        buildContent();
//        
//        
//        
//      
//              
//       
//    }
//
//    @Override
//    public void buildContent() {
//        
//        priceBut= new Button("Открыть остатки");
//        priceBut.setId("priceButTnpReseachTab");
//        AnchorPane.setLeftAnchor(priceBut, 10.0);
//        AnchorPane.setTopAnchor(priceBut, 50.0);
//        anchorPane.getChildren().add(priceBut);
//        
//        savingBut= new Button("Сохранить прайс");
//        savingBut.setId("savingBut");
//        AnchorPane.setRightAnchor(savingBut, 10.0);
//        AnchorPane.setTopAnchor(savingBut, 20.0);
//        anchorPane.getChildren().add(savingBut);
//        
//        
//        anchorPane.getChildren().add(table);   
//        AnchorPane.setLeftAnchor(table, 10.0);
//        AnchorPane.setBottomAnchor(table, 10.0);
////        AnchorPane.setRightAnchor(tablePlanNotBase, 10.0);
//        AnchorPane.setTopAnchor(this.table, 100.0);
//        
//        
//       
//
//      
//           priceBut.setOnAction((final ActionEvent e) -> {
//            files=new FileChoose().getFiles();
//            
//            if(files!=null){
//                
//                for(File concreteFile:files){
//                    
//                     
//                    try {
//                        try {
//                            this.price=new PriceReader(concreteFile).getPrice();
//                        } catch (FileNotFoundException ex) {
//                            Logger.getLogger(PriceTab.class.getName()).log(Level.SEVERE, null, ex);
//                        } catch (InvalidFormatException ex) {
//                            Logger.getLogger(PriceTab.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                        this.price.setCommunicator(gpc);
//                        this.price.setDataToCommunicator();
//                       
//                    } catch (IOException ex) {
//                        Logger.getLogger(TnpReseachTab.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                 
//                    
//                }
//                
////                tnpResearchStage = new TnpResearchStage(700, 600);
//                
//            }
//        });
//           
//           savingBut.setOnAction((final ActionEvent e) -> {
//
//            try {
//                WritePrice wp=new WritePrice(price,new DirectoryChooserWrapper().getPath());
//            } catch (IOException ex) {
//                Logger.getLogger(PriceTab.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            
//            
//            
//          
//            
//            
//               
//            
//        });
//        
//        }
//    
//}
