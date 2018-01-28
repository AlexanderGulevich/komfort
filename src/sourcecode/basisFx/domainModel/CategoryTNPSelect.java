package basisFx.domainModel;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package hepo.domainModel;
//
////import hepo.controller.event.CategoryHierarchyEvents;
//import hepo.appCore.dao.CategoryDao;
//import hepo.domainModel.dao.TnpDao;
//import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javafx.collections.ObservableList;
//import javafx.event.Event;
//import javafx.event.EventHandler;
//import javafx.scene.control.TreeItem;
//import javafx.scene.control.TreeTableView;
//import javafx.scene.input.MouseEvent;
//import javafx.scene.layout.AnchorPane;
//import javafx.scene.text.Text;
//
///**
// *
// * @author Alek
// */
//public class CategoryTNPSelect extends Window{
//    
//    
//   
//    private TreeTableView <CategoryPojo> treeTable=null;
//    private CategoryCommunicator ctc=null;
//    private ObservableList<CategoryPojo>  allPojo=null;
//    private PanelCategoryTableCreater categoryTnpTable=null;
//    private GoodsPojoCommunicator gpc=null;
//    private GoodsPojo selectedPojo=null;
//    private TnpDao dao=null;;
//    private GoodsLogic goodsLogic=null;
//    private TnpReseachTab tab=null;
//
//
//    public CategoryTNPSelect(GoodsPojoCommunicator gpc,GoodsPojo selected,int x, int y) throws SQLException {
//        super(x, y);
//        this.dao=new TnpDao();
//        this.gpc=gpc;
//        this.goodsLogic=new GoodsLogic(gpc);
//        this.selectedPojo=selected;
//        tab = (TnpReseachTab)gpc.getTabCreater();
////        tnpReseachTab.refresh();
//        buildContent();
//        
//    }
//
//    
//    @Override
//    protected void buildContent() {
//        try {
//            ctc=new CategoryCommunicator();
//            categoryTnpTable=new PanelCategoryTableCreater(ctc);
//            treeTable=categoryTnpTable.getTreeTable();
//            treeTable.setEditable(false);
////            eventHandler=new CategoryHierarchyEvents(ctc,treeTable,stable);
//        } catch (SQLException ex) {
//            Logger.getLogger(CategoryTNPSelect.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        
//        popupRoot.getChildren().add(treeTable);
//        AnchorPane.setBottomAnchor(treeTable, 5.0);
//        AnchorPane.setTopAnchor(treeTable, 5.0);
//        AnchorPane.setRightAnchor(treeTable, 5.0);
//        AnchorPane.setLeftAnchor(treeTable, 5.0);
//        
//        popupStage.setTitle("Выбор категории");
//        
//        
//        setEvents();
//      
//    }
//
//    private void setEvents() {
//      
//      popupStage.setOnCloseRequest(new EventHandler() {
//            @Override
//            public void handle(Event event) {
//               
//                try {
//                    new CategoryDao().closeAllExpandedItems();
//                } catch (SQLException ex) {
//                    Logger.getLogger(CategoryTNPSelect.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            
//            }
//        }) ;
//      
//      
//          treeTable.setOnMousePressed(new EventHandler<MouseEvent>() {
//            @Override 
//            public void handle(MouseEvent event) {
//                if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
//          
//
//                if (event.getTarget() instanceof Text){
//                    
//                   
//
//                   TreeItem <CategoryPojo> selectedItem= treeTable.getSelectionModel().getSelectedItem();
//
//                    if(//если нет потомков
//                            selectedItem.getValue().getLeftId()==
//                            selectedItem.getValue().getRightId()-1
//                            ){
//
//
//                        //selected Category pojo
//                        CategoryPojo selectedCategory=selectedItem.getValue();
//
//                           try {
//                                      dao.insertOrder(selectedPojo,selectedCategory);//существующие я не вставляю т.к. они уже отсечены через goodslogic
//                                      dao.insertToGoodsNameTableId();//добавляю id заказов в таблицу представления имен
//                                      dao.setGoodsNameWithoutId(selectedPojo);//добавляю предстваление имен
//
//                                      //куда-то нужно добавлять остаток из прайса
//                                      new CategoryDao().closeAllExpandedItems();
//
//                                      TnpReseachTab.entity.refreshAllTables();//удалит из верхних таблиц существующие заказы
//
//                                  } catch (SQLException ex) {
//                                      Logger.getLogger(CategoryTNPSelect.class.getName()).log(Level.SEVERE, null, ex);
//                                  }
//
//
//                      popupStage.close();    
//
//                    }
//                }
//
//          
//          }}
//      });
//      
//      
//      
//      
//      
//      
//      
//      
//      
//      
//      
//      
//    }
//    
//    
//   
//    
//}
