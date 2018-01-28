package basisFx.domainModel.old;

//package hepo.domainModel;
//
//
//import hepo.appCore.AbstractTab;
//import hepo.domainModel.CategoryCommunicator;
//import hepo.domainModel.CategoryPojo;
//import hepo.domainModel.PanelCategoryTableCreater;
//import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javafx.collections.ObservableList;
//import javafx.scene.control.Button;
//import javafx.scene.control.ContentDisplay;
//import javafx.scene.control.TreeItem;
//import javafx.scene.control.TreeTableColumn;
//import javafx.scene.control.TreeTableView;
//import javafx.scene.control.TreeTableView.TreeTableViewSelectionModel;
//
//import javafx.scene.layout.AnchorPane;
//
//
///**
// *
// * @author Alek
// */
//public class CategoryTnpTab extends AbstractTab{
//    
////    private CategoryHierarchyEvents eventHandler=null;
//    private TreeTableView <CategoryPojo> treeTable=null;
////    private TreeView <CategoryTnpPojo> treeTable=null;
//    
//    
//    private CategoryCommunicator ctc=null;
//    private Button newItemBut;
//    private Button deleteItemBut;
//    private ObservableList<CategoryPojo>  allPojo=null;
//    private PanelCategoryTableCreater categoryTnpTableCreater=null;
//
//
//    public CategoryTnpTab(String id, String name, boolean closeable) throws SQLException {
//        
//        super(id, name, closeable);
//        
//        ctc=new CategoryCommunicator();
//        
//        ctc.setTab(this);
//        
//        init();
//        
//       
//
//        
//    }
//    
//     private void init() throws SQLException{
//
//        categoryTnpTableCreater=new PanelCategoryTableCreater(ctc);
//        categoryTnpTableCreater.showFullTable();
//        treeTable=categoryTnpTableCreater.getTreeTable();
//        
////        eventHandler=new CategoryHierarchyEvents(ctc,treeTable,stable);
//        
//        buildContent();
//
//     
//     }
//    
//    @SuppressWarnings("unchecked")
//     public void refresh() throws SQLException{ 
//         
//        ctc.getAllPojoes().clear();
//        anchorPane.getChildren().clear();
//        init();
//        
//     }
//    
//
//   
//    @Override
//    public void buildContent() {
//        
//        
//        AnchorPane.setLeftAnchor(treeTable, 10.0);
//        AnchorPane.setRightAnchor(treeTable, 200.0);
//        AnchorPane.setTopAnchor(treeTable, 50.0);  
//        AnchorPane.setBottomAnchor(treeTable, 50.0);
//  
//        anchorPane.getChildren().add(treeTable);
// 
////       Icons525View iconAdd = new Icons525View(Icons525.CIRCLEADD);
////        iconAdd.setSize("20px");
////        Icons525View iconDel = new Icons525View(Icons525.CIRCLE_MINUS);
////        iconDel.setSize("20px");
//       
//
//       
//        newItemBut= new Button("Добавить");
//    
////        newItemBut.setGraphic(iconAdd);
//        newItemBut.setContentDisplay(ContentDisplay.RIGHT);
//       
//        newItemBut.setId("newItemButForTreeTable");
//        AnchorPane.setRightAnchor(newItemBut, 50.0);
//        AnchorPane.setTopAnchor(newItemBut, 50.0);
//        anchorPane.getChildren().add(newItemBut);
//        newItemBut.setPrefWidth(100.0);
//        newItemBut.setPrefHeight(30.0);
//        newItemBut.setOnAction(e -> {
//            try {
//                addRow();
//            } catch (SQLException ex) {
//                Logger.getLogger(CategoryTnpTab.class.getName()).log(Level.SEVERE, null, ex);
//                
//            }
//        });
//        
//        
//
//         
//        deleteItemBut= new Button("Удалить   ");
//        
//
////        deleteItemBut.setGraphic(iconDel);
//        deleteItemBut.setContentDisplay(ContentDisplay.RIGHT);
//        
//        deleteItemBut.setId("deleteItemButForTreeTable");
//        AnchorPane.setRightAnchor(deleteItemBut, 50.0);
//        AnchorPane.setTopAnchor(deleteItemBut, 100.0);
//        anchorPane.getChildren().add(deleteItemBut);
//        deleteItemBut.setPrefWidth(100.0);
//        deleteItemBut.setPrefHeight(30.0);
//        deleteItemBut.setOnAction(e ->  {
//            try {
//                deleteRow();
//            } catch (SQLException ex) {
//                Logger.getLogger(CategoryTnpTab.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        });
//
//        
//
//        this.tabPane.setOnMouseClicked(e ->  
//            treeTable.getSelectionModel().clearSelection());
//        
//         }
//    
//    private void addRow() throws SQLException {
//            
//            TreeItem<CategoryPojo> item=null;
//
//                    if ((treeTable.getExpandedItemCount() == 0)//если количество видимых веток равно 0
//                    || (treeTable.getSelectionModel().isEmpty()) )  {//если не выбрано ничего
//                    
//                         CategoryPojo pojo=new CategoryPojo("");
//                         pojo.setLevelId(1);
//                    
//                         item = new TreeItem<>(pojo);
//                        
//                        treeTable.getRoot().getChildren().add(item);
//                        
//                        
//                    } else {//если какая-то строка выбрана
//
//                            TreeTableViewSelectionModel<CategoryPojo> sm = treeTable.getSelectionModel();
//                            int rowIndex = sm.getSelectedIndex();
//                            TreeItem<CategoryPojo> selectedItem = sm.getModelItem(rowIndex);
//                            
//                            CategoryPojo pojo=new CategoryPojo("");
//  
//                            Integer selectedItemLevel=selectedItem.getValue().getLevelId();
//                            pojo.setLevelId(selectedItemLevel+1);
//
//                            item = new TreeItem<>(pojo);
// 
//                            selectedItem.getChildren().add(item);
//                            selectedItem.setExpanded(true);
//
//                    }
//        
//
//                int newRowIndex = treeTable.getRow(item);
//		treeTable.scrollTo(newRowIndex);
//		TreeTableColumn<CategoryPojo, ?> firstCol =treeTable.getColumns().get(0);
//		treeTable.getSelectionModel().select(item);
//                treeTable.getFocusModel().focus(newRowIndex);
//		treeTable.getFocusModel().focus(newRowIndex, firstCol);
//		treeTable.edit(newRowIndex, firstCol);
//            
//                treeTable.getSelectionModel().clearSelection();
//                
//                
//                
//                
//                
//
////                              
//                
//	}
//         
//    private void deleteRow() throws SQLException {
//		TreeTableViewSelectionModel<CategoryPojo> sm = treeTable.getSelectionModel();
//		if (sm.isEmpty()) {
//			return;
//		}
//                if(sm==null){
//                    return;
//                }
//		int rowIndex = sm.getSelectedIndex();
//		TreeItem<CategoryPojo> selectedItem = sm.getModelItem(rowIndex);
//               
//	
//		TreeItem<CategoryPojo> parent = selectedItem.getParent();	
//		if (parent != null) {
//			parent.getChildren().remove(selectedItem);
//		} else {
////			treeTable.setRoot(null);
//		}
//                
//                CategoryPojo selectedPojo=selectedItem.getValue();
//                //ctc.getAllPojoes().remove(selectedPojo);
//                
//                categoryTnpTableCreater.remove(selectedPojo);
//	}
//
//
//	
//        
//}
