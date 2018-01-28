package basisFx.domainModel;

//
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
///**
// *
// * @author Alek
// */
//public class PanelNotInPlanTableCreater implements TableCreater{
//    private   TableView<GoodsPojo> table=null;
//    private GoodsPojoCommunicator<GoodsPojo> gpc;
//
//    public TableView<GoodsPojo> getTable() {
//        return table;
//    }
//       
//               
//
//    public PanelNotInPlanTableCreater(GoodsPojoCommunicator<GoodsPojo> gpc) {
//        this.gpc = null;
//       
//        this.gpc=gpc;
//        this.table =new TableView<>(gpc.getAllPojoes());
//        
//         setEvents();
//         
//
//         table.getColumns().addAll( 
//                 gpc.getOrderColumn(),
//                 gpc.getProductNameCommonColumn(),
//                 gpc.getRealCategoryColumn()
//
//                         
//             
//        );
//         
//         table.setEditable(true);
//         
//         this.table.getColumns().get(2).setEditable(false);
//         this.table.getColumns().get(1).setEditable(false);
//         this.table.getColumns().get(0).setEditable(false);
//         
//         
//    
//
//    }
//
//    @Override
//    public void setPrefWidthBindToColums(ReadOnlyDoubleProperty widthProperty) {
//               
//        table.getColumns().get(0).prefWidthProperty().bind(widthProperty.multiply(0.1));
//        table.getColumns().get(1).prefWidthProperty().bind(widthProperty.multiply(0.6));
//        table.getColumns().get(2).prefWidthProperty().bind(widthProperty.multiply(0.3));
////        table.getColumns().get(3).prefWidthProperty().bind(widthProperty.multiply(0.1));
//    }
//
//    
//     private void setEvents() {
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
//                        new CloseOrder(gpc,selectedePojo);
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
//  
//}
