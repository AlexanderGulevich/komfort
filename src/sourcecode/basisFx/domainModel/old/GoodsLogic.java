package basisFx.domainModel.old;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package hepo.domainModel;
//
//import hepo.domainModel.dao.TnpDao;
//import java.sql.SQLException;
//import java.util.Iterator;
//import javafx.collections.ObservableList;
//
///**
// *
// * @author Alek
// */
//public class GoodsLogic {
//    
//    private GoodsPojoCommunicator gpc=null;
//    private ObservableList<GoodsPojo>  allGoodsPojo=null;
//    public TnpDao dao=null;
//
//    public GoodsLogic(GoodsPojoCommunicator с) throws SQLException {
//        this.gpc=с;
//        this.allGoodsPojo=с.getAllPojoes();
//        this.dao=new TnpDao();
//        
//        
//    }
//    
//    public GoodsLogic createGpc(){
//    
//        this.gpc=new GoodsPojoCommunicator();
//        this.allGoodsPojo=gpc.getAllPojoes();
//
//        return this;
//
//    
//    }
//
//    public GoodsLogic setGpc(GoodsPojoCommunicator gpc) {
//        this.gpc = gpc;
//        
//        return this;
//    }
//    
//    public GoodsLogic() throws SQLException {
//      
//        this.dao=new TnpDao();
//        
//        
//    }
//    
//    public  GoodsPojoCommunicator getGpc(){
//    
//        return this.gpc;
//    
//    }
//    
//    public GoodsLogic handleOrderList() throws SQLException{
//        
//          
//       ObservableList<GoodsPojo> openOrders=new GoodsLogic().createGpc().retrieveOpenOrders().getGpc().getAllPojoes();
//               
//        
//        for (Iterator<GoodsPojo> iterator = allGoodsPojo.iterator(); iterator.hasNext();) {
//            GoodsPojo next = iterator.next();
//                
//            if(dao.isExist(next.getLeftOrderNum(),next.getYear())){
//                
//                //удалить из списка существующий в БД заказ
//                iterator.remove();
//                
//                //добавить в таблицу бд представления имен
//                dao.setGoodsNameWithoutId(next);
//                
//            if (next.getProductNamePlan()!=null) {
//                
//                double priceFromFile=next.getPricePerUnit();
//                double emmitedFromFile=next.getEmittedAmountOfOrder();
//                double amountFromFile=next.getAmountOfOrder();
//                
//
//                int id = dao.getGoodsId(next.getLeftOrderNum(), next.getYear());
//                
//                
//              
//                for (Iterator iterator1 = openOrders.iterator(); iterator1.hasNext();) {
//                    GoodsPojo concrete = (GoodsPojo) iterator1.next();
//                             
//                    if (concrete.getId()==id){
//                    
//                                    
//                       if(
//                               priceFromFile!=concrete.getPricePerUnit()
//                               || 
//                               emmitedFromFile!=concrete.getEmittedAmountOfOrder()
//                               ||
//                               amountFromFile!=concrete.getAmountOfOrder()
//                               ) {
//                       
//                           System.err.println(concrete.getOrder()+"-amountDb-"+concrete.getEmittedAmountOfOrder()
//                           +"amountFile-"+ amountFromFile
//                           );
//                
//                        //добавить количество и остаток, если читаем План
//                        dao.updateOrderAmountAndPrice(next);
//                          
//                       }        
//                                
//                                
//                       
//                        
//                        
//                        
//                    
//                    }
//                    
//                    
//                }
//                
//                
//                
//                
//                //если список из Плана, то добавиться общее имя
//                dao.setNameFromPlanToCommonName(next);
//
//            }else{
//
//            }
//            }
//
//        }
// 
//        return this;
//
//}
//
//    public GoodsLogic  retrieveOpenOrders() throws SQLException {
//       
//        this.gpc=dao.retrieveOpenOrders(gpc);
//  
//        return this; 
//    }
//
//    public GoodsLogic findClosedOrdersInPlan(GoodsPojoCommunicator gpcPlan) throws SQLException {
//        
//        ObservableList<GoodsPojo> openOrders=dao.retrieveOpenOrders(new GoodsPojoCommunicator()).getAllPojoes();
//        
//        ObservableList<GoodsPojo> ordersFromPlan=gpcPlan.getAllPojoes();
//        
//                  for (Iterator<GoodsPojo> iteratorDb = openOrders.iterator(); iteratorDb.hasNext();) {
//                       GoodsPojo goodsPojoDb = iteratorDb.next();
//                       
//                       boolean isFitDbAndPlanFileOrder=false;
//                       
//                       Integer leftDb=goodsPojoDb.getLeftOrderNum();
//                       Integer yearDb=goodsPojoDb.getYear();
//                
//                    for (Iterator<GoodsPojo> iteratorPlan = ordersFromPlan.iterator(); iteratorPlan.hasNext();) {
//                            GoodsPojo  goodsPojoPlan = iteratorPlan.next();
//                           
//                            int leftPlan=goodsPojoPlan.getLeftOrderNum();
//                            int yearPlan=goodsPojoPlan.getYear();
//                           
//                            //есть в бд и плане
//                            if (( (leftDb==leftPlan)  &&   (yearDb==yearPlan)  ) ) { //если все ЛОЖЬ - это значит, что  в плане заказ исчез
//                                
//                                isFitDbAndPlanFileOrder=true;
//                                
//                                
////                                System.out.println("СОВПАЛО -- "+leftDb+" -"+yearDb  +"   "+leftPlan+" -"+yearPlan             );
//                                
//                                break;
//                            }
//                
//                    }
//                    
//                  
//                    
//                    //если бд не нашло себе соответствие в плане
//                      if (isFitDbAndPlanFileOrder==false) {
////                           System.err.println(goodsPojoDb.getLeftOrderNum() +"-"+goodsPojoDb.getYear()); 
//                           
//                       gpc.setPojo(goodsPojoDb);                     
//                      
//                      }
//                    
//                    
//            
//
//        }
//        
//        
//
//        
//        
//
//         return this; 
//   
//
//}
//
//    public void setDataToTempTableFromPlan() throws SQLException {
//        
//        ObservableList <GoodsPojo> all=gpc.getAllPojoes();
//        
//        for (GoodsPojo goodsPojo : all) {
//            dao.setDataFromPlanToTempTable(goodsPojo);
//        }
//        
//        
//    
//    }
//
//    public GoodsLogic getDeletedFromPlan() throws SQLException {
//        
//    dao.retrieveDataFromTempTablePlanDeletedOrders(gpc);  
//    dao.clearTempTablePlan();
//        
//    return this; 
//    }
//
//    public GoodsLogic retrieveOpenOrdersLowPerCent() throws SQLException {
//        
//     this.gpc=dao.retrieveOpenOrdersLowPerCent(gpc);
//     return this; 
//    }
//    
//}
