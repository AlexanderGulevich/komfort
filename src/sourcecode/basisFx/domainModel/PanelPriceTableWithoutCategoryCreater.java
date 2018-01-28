package basisFx.domainModel;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package hepo.domainModel;
//
//import hepo.appCore.TableCreater;
//import hepo.domainModel.GoodsPojoCommunicator;
//import hepo.domainModel.GoodsPojo;
//import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javafx.beans.property.ReadOnlyDoubleProperty;
//import javafx.event.EventHandler;
//import javafx.scene.control.TableView;
//import javafx.scene.input.MouseEvent;
//
//public class PanelPriceTableWithoutCategoryCreater implements TableCreater{
//    
//    private   TableView<GoodsPojo> table=null;
//    private GoodsPojoCommunicator gpc=null;
//
//    public TableView<GoodsPojo> getTable() {
//        return table;
//    }
//       
//               
//
//    public PanelPriceTableWithoutCategoryCreater(GoodsPojoCommunicator gpc) {
//       
//        this.gpc=gpc;
//        this.table =new TableView<>(gpc.getAllPojoes());
//        
//        
//
//         table.getColumns().addAll( 
//                 gpc.getOrderColumn(),
//                 gpc.getNameColumnPrice()
//        );
//         this.table.setEditable(true);
//         this.table.getColumns().get(1).setEditable(true);
//         this.table.getColumns().get(0).setEditable(true);
//         
//         this.table.setOnMousePressed(new EventHandler<MouseEvent>() {
//            @Override 
//            public void handle(MouseEvent event) {
//                
//                
//                if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
//                    
//  
//                      GoodsPojo selectedPojo=table.getSelectionModel().getSelectedItem();
//
//         
//                    try {
//                        new CategoryTNPSelect(gpc, selectedPojo, 700, 500);
//                    } catch (SQLException ex) {
//                        Logger.getLogger(PanelPlanTableWithoutCategoryCreater.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                     }
//                    }
//            }
//        );
//         
//         
//    }
//
//    @Override
//    public void setPrefWidthBindToColums(ReadOnlyDoubleProperty widthProperty) {
//         table.getColumns().get(0).prefWidthProperty().bind(widthProperty.multiply(0.1));
//         table.getColumns().get(1).prefWidthProperty().bind(widthProperty.multiply(0.9));
//    }
//
//
//}
