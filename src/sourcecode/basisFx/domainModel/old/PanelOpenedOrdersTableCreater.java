package basisFx.domainModel.old;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package hepo.domainModel;
//
//import hepo.appCore.TableCreater;
//import hepo.domainModel.GoodsPojoCommunicator;
//import hepo.domainModel.dao.TnpDao;
//import hepo.domainModel.GoodsPojo;
//import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javafx.beans.property.ReadOnlyDoubleProperty;
//import javafx.event.EventHandler;
//import javafx.scene.control.TableView;
//import javafx.scene.input.MouseEvent;
//
//
///**
// *
// * @author Alek
// */
//public class PanelOpenedOrdersTableCreater implements TableCreater{
//  
//    private   TableView<GoodsPojo> table=null;
//    private GoodsPojoCommunicator gpc=null;
//    private TnpDao dao=new TnpDao();
//
//    public TableView<GoodsPojo> getTable() {
//        return table;
//    }
//
//    public void setGpc(GoodsPojoCommunicator gpc) {
//        this.gpc=null;
//        this.gpc = gpc;
//        createTable();
//        initColums();
//    }
//    public GoodsPojoCommunicator getGpc() {
//        return gpc;
//    }
//    
//                   
//
//    public PanelOpenedOrdersTableCreater(GoodsPojoCommunicator gpc) {
//       
//        this.gpc=gpc;
//        createTable();
//        initColums();
//         
//    
//}  
//    
//     private  void initColums(){
//     
//           table.getColumns().addAll( 
//                 gpc.getOrderColumn(),
//                 gpc.getProductNameCommonColumn(),
//                 gpc.getAmountOfOrderStringColumn(),
//                 gpc.getEmittedAmountOfOrderStringColumn(),
//                 gpc.getRemainAmountOfOrderStringColumn(),
//                 gpc.getPercentRemainedColumn(),
//                 gpc.getRealCategoryColumn()
//                         
//             
//        );
//     
//     }
//
//    private void createTable() {
//        this.table =new TableView<>(gpc.getAllPojoes());
//        this.table.setEditable(false);
//        setEvents();
//        
//        
//    }
//    private void setEvents() {
//        
//        this.table.setOnMousePressed(new EventHandler<MouseEvent>() {
//            @Override 
//            public void handle(MouseEvent event) {
//                if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
//                    
//  
//                    try {
//                        
//                        GoodsPojo selectedePojo=table.getSelectionModel().getSelectedItem();
//                        new DeleteFromOrders(gpc, selectedePojo);
//                        TnpReseachTab tab=(TnpReseachTab) gpc.getTabCreater();
//                        tab.refreshAllTables();
//                        
//                    } catch (SQLException ex) {
//                        Logger.getLogger(PanelOpenedOrdersTableCreater.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//
//                    
//                }}
//            }
//        );
//        
//        
//    }
//
//    @Override
//    public void setPrefWidthBindToColums(ReadOnlyDoubleProperty widthProperty) {
//        table.getColumns().get(0).prefWidthProperty().bind(widthProperty.multiply(0.1));
//        table.getColumns().get(1).prefWidthProperty().bind(widthProperty.multiply(0.3));
//        table.getColumns().get(2).prefWidthProperty().bind(widthProperty.multiply(0.1));
//        table.getColumns().get(3).prefWidthProperty().bind(widthProperty.multiply(0.1));
//        table.getColumns().get(4).prefWidthProperty().bind(widthProperty.multiply(0.1));
//        table.getColumns().get(5).prefWidthProperty().bind(widthProperty.multiply(0.1));
//        table.getColumns().get(6).prefWidthProperty().bind(widthProperty.multiply(0.2));
//
//    }
//    
//    
//  
//
//
//}
//
//
//               
