package basisFx.domainModel;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package hepo.domainModel;
//
//import hepo.domainModel.GoodsLogic;
//import hepo.domainModel.GoodsPojoCommunicator;
//import hepo.domainModel.dao.TnpDao;
//import hepo.domainModel.GoodsPojo;
//import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javafx.event.ActionEvent;
//
///**
// *
// * @author Alek
// */
//public class DeleteFromOrders extends WindowConfirmation{
//
//    private  TnpDao dao;
//    private  GoodsPojoCommunicator gpc;
//    private  GoodsLogic goodsLogic;
//    private  GoodsPojo selectedPojo;
//    private  TnpReseachTab tab=null;
//    
//    public DeleteFromOrders(GoodsPojoCommunicator gpc,GoodsPojo selected) throws SQLException {
//        this.dao=new TnpDao();
//        this.gpc=gpc;
//        this.goodsLogic=new GoodsLogic(gpc);
//        this.selectedPojo=selected;
//        this.tab = (TnpReseachTab)gpc.getTabCreater();
//        buildContent();
//        
//    }
//
//    @Override
//    protected void setEvents() {
//        yesBut.setOnAction( (final ActionEvent e) -> {
//         
//            try {
//                Integer id=null;
//                
//                
//                id= dao.getGoodsId(selectedPojo.getLeftOrderNum(),selectedPojo.getYear());
//                dao.deleteFromOpenOrders(this.selectedPojo);
//                ((TnpReseachTab) gpc.getTabCreater()).refreshAllTables();
//                
//                
//                
//                popupStage.close();
//            } catch (SQLException ex) {
//                Logger.getLogger(DeleteFromOrders.class.getName()).log(Level.SEVERE, null, ex);
//            }
//         
//         
//     });
//     
//     
//     
//     noBut.setOnAction( (final ActionEvent e) -> {
//     
//          popupStage.close();
//
//      }); }
//
//   @Override
//    public void setMessege() {
//        this.text.setText("Вы действительно желаете удалить из Базы Данных заказ "+"\""
//                +selectedPojo.getOrder()+"\"" 
//                        + " - " 
//                        +"\n"
//                        +"\""
//                        + ""+selectedPojo.getProductNameCommon()
//                        +"\""
//        );
//    }
//
//    @Override
//    public void setTitle() {
//        popupStage.setTitle("Закрытие заказа");
//    }
//
//    @Override
//    protected void buildContent() {
//        setEvents();
//        setMessege();
//        setTitle();
//    }
//    
//}
