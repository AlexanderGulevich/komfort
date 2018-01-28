package basisFx.domainModel;

//package hepo.domainModel;
//
//import hepo.domainModel.CategoryPojo;
//import hepo.domainModel.GoodsPojo;
//import hepo.appCore.HierarchyForTreeTable;
//import hepo.domainModel.CategoryCommunicator;
//import hepo.domainModel.GoodsLogic;
//import hepo.appCore.dao.CategoryDao;
//import hepo.domainModel.dao.TnpDao;
//import hepo.domainModel.poi.WriteReportTnp;
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.Iterator;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//
///**
// *
// * @author 62
// */
//public class ReportTnp {
//    
//    // здесь могут  быть дубликаты заказов из прайса
//    private ObservableList<GoodsPojo>  pricePojoListCloned;
//    //здесь дубликатов быть не должно
//    private ObservableList<GoodsPojo>  analyzedGoodsPojoListFromPrice=FXCollections.<GoodsPojo>observableArrayList();
//    private WriteReportTnp writter;
//    @SuppressWarnings("unchecked")
//    private CategoryCommunicator <CategoryPojo>ctc=new CategoryCommunicator();
//    private TnpDao tnpDao=new TnpDao();
//    private CategoryDao ordersCategoryDao=new CategoryDao();
//    private ObservableList <HierarchyForTreeTable.Node> headNods;
//    private String path;
//    private String priceDate;
//    private ObservableList<GoodsPojo> openOrders;
//    private ObservableList<GoodsPojo> openOrdersLowPerCent;
//    
//    @SuppressWarnings("unchecked")
//    public ReportTnp(ObservableList pricePojoListCloned, String path, String priceDate) throws SQLException, IOException {
//        
//       this.pricePojoListCloned=pricePojoListCloned;
//       this.path=path;
//       this.priceDate=priceDate;
//       analyzeOrderSumAmount();
//       setOrdersIdToPricePojo(analyzedGoodsPojoListFromPrice);
//       retriveCategoriesToCommunicator();
//       headNods=new HierarchyForTreeTable(ctc).getHeadNods();
//       openOrders= new GoodsLogic().createGpc().retrieveOpenOrders().getGpc().getAllPojoes();
//       openOrdersLowPerCent= new GoodsLogic().createGpc().retrieveOpenOrdersLowPerCent().getGpc().getAllPojoes();
//
//       this.writter=new WriteReportTnp(this);
//       
//    }
//
//    private void analyzeOrderSumAmount() throws SQLException {
//            //проходим список и если есть повторение заказов, 
//            //то суммируем их добавляю в итоговый
//            //список pojo
//            Object []arr= pricePojoListCloned.toArray();
//            int lengh =arr.length;
//            
//            
//            for (int i = 0; i < lengh;     i++) {
//               
//                GoodsPojo analyzed;
//                
//                if(arr[i]!=null){
//
//                            analyzed=(GoodsPojo) arr[i];
//                            int analyzedYear=analyzed.getYear();
//                            int analyzedLeftInt=analyzed.getLeftOrderNum();
//
//                             for (int j = i+1; j < lengh; j++) {
//
//                                GoodsPojo next=(GoodsPojo) arr[j];
//                                int nextYear=next.getYear();
//                                int nextLeftInt=next.getLeftOrderNum();
//
//                                 if(analyzedYear==nextYear){
//
//                                     if (analyzedLeftInt==nextLeftInt) {
//
//                                         Double amount= analyzed.getAmountOfPrice()+next.getAmountOfPrice();
//                                         analyzed.setAmountOfPrice(amount);
//                                         arr[j]=null;
//                                         continue;
//
//                                     }
//
//                                 }
//                                 
//
//                            }
//
//                        }else{
//                continue;
//                }
//                
//                addDataFromDbToGoodsPojo(analyzed);
//                analyzedGoodsPojoListFromPrice.add(analyzed);
//            }
//    }
//    private void addDataFromDbToGoodsPojo(GoodsPojo analyzed) throws SQLException {
//       
//        int id=tnpDao.getGoodsId(analyzed.getLeftOrderNum(),analyzed.getYear()); 
//        tnpDao.retriveDataFromGoodsId(id,analyzed);
//        
//    
//    }
//    private void retriveCategoriesToCommunicator() throws SQLException {
//        
//         ordersCategoryDao.selectAllCategories(ctc);
//  
//    }
//    private void setOrdersIdToPricePojo(ObservableList<GoodsPojo> analyzedGoodsPojoList) throws SQLException {
//    
//        for (Iterator<GoodsPojo> iterator = analyzedGoodsPojoList.iterator(); iterator.hasNext();) {
//            GoodsPojo concreteGoodsPojo = iterator.next();
//            
//            tnpDao.retrieveCategoryId(concreteGoodsPojo);
//            
//            
//        }
//    }
//    public ObservableList<HierarchyForTreeTable.Node> getHeadNods() {
//        return headNods;
//    }
//    public String getPath() {
//        return path;
//    }
//    public String getPriceDate() {
//        return priceDate;
//    }
//    public ObservableList<GoodsPojo> getOpenOrders() {
//        return openOrders;
//    }
//    public ObservableList<GoodsPojo> getAnalyzedGoodsPojoListFromPrice() {
//        return analyzedGoodsPojoListFromPrice;
//    }
//    public ObservableList<GoodsPojo> getOpenOrdersLowPerCent() {
//        return openOrdersLowPerCent;
//    }
//    public TnpDao getDao(){
//    
//        return tnpDao;
//        
//    }
//  
//}
