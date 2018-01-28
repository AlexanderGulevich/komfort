package basisFx.domainModel.old;

//package hepo.domainModel;
//
//import hepo.domainModel.CategoryCommunicator;
//import hepo.appCore.Stable;
//import hepo.domainModel.CategoryPojo;
//import hepo.appCore.dao.CategoryDao;
//import hepo.appCore.HierarchyForTreeTable;
//import java.sql.SQLException;
//import java.util.Iterator;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javafx.beans.value.ChangeListener;
//import javafx.beans.value.ObservableValue;
//import javafx.collections.ListChangeListener;
//import javafx.collections.ObservableList;
//import javafx.event.EventHandler;
//import javafx.scene.control.Label;
//import javafx.scene.control.TreeItem;
//import javafx.scene.control.TreeTableColumn;
//import javafx.scene.control.TreeTableRow;
//import javafx.scene.control.TreeTableView;
//import javafx.scene.control.cell.TextFieldTreeTableCell;
//import javafx.scene.input.ClipboardContent;
//import javafx.scene.input.DragEvent;
//import javafx.scene.input.Dragboard;
//import javafx.scene.input.MouseEvent;
//import javafx.scene.input.TransferMode;
//import javafx.stage.WindowEvent;
//import javafx.util.Callback;
//
///**
// *
// * @author Alek
// */
//public class PanelCategoryTableCreater {
//    
//    private TreeTableView<CategoryPojo> treeTable=null;
//    private CategoryCommunicator ctc=null;
//    private TreeItem <CategoryPojo>rootItem=null;
//    private CategoryDao dao=null;
//    private TreeTableColumn<CategoryPojo, String> categoryNameColumn=null;
//    private TreeTableColumn<CategoryPojo, String> shortNameColumn=null;
//    private ObservableList<CategoryPojo>  allPojo=null;
//    private Stable stable=Stable.getInstance(); 
//   
//    public PanelCategoryTableCreater(CategoryCommunicator ctc) throws SQLException {
//       
//        this.ctc=ctc;
//        dao=new CategoryDao();
//        initTreeTable(); 
//        
//
//}   
//    public void setChangeEvents(){
//    
//        setOnEditCommitLongNameColumn();
//        setOnEditCommitShortNameColumn();
////        addListenerToAllPojo();
//        setCloseEvent();
//        setDragEvent();
//        
//        
//    }
//    public TreeTableColumn<CategoryPojo, String> getСategoryNameCol() {
//        return categoryNameColumn;
//    }
//    public TreeTableView<CategoryPojo> getTreeTable() {
//        return treeTable;
//    }
//    public void showFullTable() {
//        treeTable.getColumns().add(shortNameColumn);
//        categoryNameColumn.prefWidthProperty().bind(treeTable.widthProperty().multiply(0.7)); 
//        shortNameColumn.prefWidthProperty().bind(treeTable.widthProperty().multiply(0.3)); 
//        setChangeEvents();
//    }
//    @SuppressWarnings("unchecked")
//    private void initTreeTable() throws SQLException {
//        
//        insertDataFromDbToAllPojoCategories();
//        
//        shortNameColumn=ctc.getShortNameColumn();
//        categoryNameColumn = ctc.getCategoryNameColumn();
//        
//	categoryNameColumn.
//                setCellFactory(TextFieldTreeTableCell.<CategoryPojo>forTreeTableColumn());
//        shortNameColumn.
//                setCellFactory(TextFieldTreeTableCell.<CategoryPojo>forTreeTableColumn());
//        
//        rootItem=new TreeItem<>( new CategoryPojo("КОРНЕВОЙ ЭЛЕМЕНТ"));
//        rootItem.setExpanded(true); //делаем возможность расширения
//       
//        
//        handleHierarchy(new HierarchyForTreeTable(ctc).getHeadNods());
//
//         treeTable =new TreeTableView<>(rootItem);
//         
////         treeTable.setPrefSize(300, 250);
//         
//         treeTable.getColumns().clear();
//
//         treeTable.setEditable(true);
//         
//         treeTable.setShowRoot(false);
//         
//         categoryNameColumn.prefWidthProperty().bind(treeTable.widthProperty().multiply(1)); 
//         
//         treeTable.getColumns().add(categoryNameColumn);
//      
//         treeTable.setPlaceholder(new Label("Click the Add button to add a row."));
//    
//    }
//    private void handleHierarchy( ObservableList hierarchy){
//    
//           for (Iterator iterator = hierarchy.iterator(); iterator.hasNext();) {
//            
//                HierarchyForTreeTable.Node node = (HierarchyForTreeTable.Node)iterator.next();// корневой узел
//
//                TreeItem <CategoryPojo> headItem=new TreeItem<>(node.getValue());
//                
//                if(headItem.getValue().getIsExpanded()==true){
//                    headItem.setExpanded(true);
//                }
//                
//                setExpandEvent(headItem);
//
//                rootItem.getChildren().add(headItem);
//
//                recursion(node, headItem);
//            
//  
//        }
//    
//    }
//    private void recursion(HierarchyForTreeTable.Node node,  TreeItem parentItem){
//        
//        if(node.hasDescendant()){// если узел имеет потомков
//            
//            for (Iterator iterator = node.getDescendants().iterator(); iterator.hasNext();) {//обход каждого потомка
//                
//                HierarchyForTreeTable.Node innerNode = (HierarchyForTreeTable.Node) iterator.next();
//
//                TreeItem <CategoryPojo> innerItem=new TreeItem(innerNode.getValue());
//                
//                if(innerItem.getValue().getIsExpanded()==true){
//                    innerItem.setExpanded(true);
//                }
//                
//                setExpandEvent(innerItem);
//                
//                parentItem.getChildren().add(innerItem); //вставить в родительский ряд
//              
//                recursion(innerNode,innerItem) ;//выполнить все то же самое для его потомков, если они есть       
//                
//            }
//            
//        
//        }
//    
//    
//    }
//    private void insertDataFromDbToAllPojoCategories() throws SQLException{
//        
//        dao.selectAllCategories(ctc);
//        this.allPojo=ctc.getAllPojoes();
//         
//    }
//    private void setOnEditCommitShortNameColumn(){
//     
//         treeTable.getColumns().get(1).setOnEditCommit((event) -> {
//     
//             try {
//                 editShortName((TreeTableColumn.CellEditEvent<CategoryPojo, String>) event);
//             } catch (SQLException ex) {
//                 Logger.getLogger(PanelCategoryTableCreater.class.getName()).log(Level.SEVERE, null, ex);
//             }
// 
//        });
//        
//        
//     
//    }
//    private void setOnEditCommitLongNameColumn(){
//     
//         treeTable.getColumns().get(0).setOnEditCommit((event) -> {
//             try {
//                 
//                 editLongName((TreeTableColumn.CellEditEvent<CategoryPojo, String>) event);
//                 
//             } catch (SQLException ex) {
//                 Logger.getLogger(PanelCategoryTableCreater.class.getName()).log(Level.SEVERE, null, ex);
//             }
//           
//        });
//        
//        
//     
//    }
//    private void editShortName(TreeTableColumn.CellEditEvent <CategoryPojo,String> e) throws SQLException{
//    
//        CategoryPojo targetPojo=e.getRowValue().getValue();//выдаст pojo
//        
//         if(allPojo.contains(targetPojo)){//если  содержит  pojo т.е НЕ НОВЫЙ
//  
//                    Integer id=targetPojo.getId();   
//                    
//                    dao.updateCategoryShortName(id,  e.getNewValue()); //изменить имя в базе данных
//   
//         }
//     
//         TreeTableView <CategoryPojo> treeTable=e.getTreeTableView();
//         
//        
//         
//         refresh();
//        
//        
//        
//    }
//    private void editLongName(TreeTableColumn.CellEditEvent <CategoryPojo,String> e) throws SQLException{
//         
//         CategoryPojo targetPojo=e.getRowValue().getValue();//выдаст pojo
//
//                 
//         if(!allPojo.contains(targetPojo)){//если не содержит такого pojo т.е НОВЫЙ
//             
//                if ((targetPojo.getLevelId()==1)//если уровень 1 т е КОРНЕВОЙ ЭЛЕМЕНТ
//                        &&(e.getNewValue()!="")){//если сторока не пуста
//                           dao.insertToRoot(e.getNewValue()); //вставить корневым
//                           //dao.setExpandedItems();
//                        
//                        }
//                if(targetPojo.getLevelId()>1){//если уровень больше 1 т е некорневой элемент
//                    
//                    CategoryPojo parentPojo = e.getRowValue().getParent().getValue(); 
//                   
//                    dao.insertToParentNode(e.getNewValue(), parentPojo.getLevelId(), parentPojo.getRightId());
//                   
//                
//                }
//                
//         }else{ //такой pojo имеется 
//                     System.err.println("такой pojo имеется ");
//             
//                    Integer id=targetPojo.getId();   
//                    
//                    dao.updateCategoryLongName(id,  e.getNewValue()); //изменить имя в базе данных
//    
////         e.getOldValue();//выдаст текст
////         e.getNewValue();//выдаст текст
//
//         }
//         
//    
//         TreeTableView <CategoryPojo> treeTable=e.getTreeTableView();
//         
//         refresh();
//         
//        
//
//     }
//    //не использовал
//    private void addListenerToAllPojo(){
//    
//        //один из вариантов того, как можно реализовать интерфейс
//        //дело в том, что пердается имменно интерфес, т.е. некий класс, с реализацией метода
//        //каким-то образом создатели java позволяют реализовывать интерфейсы, передавая их в качестве параметров функций
//        //в принципе, можно и не передавать, а просто реализовать 
//        //статтическую функцию onChanged в данном классе и тогда передать уже через CategoryHierarchyEvents::onChanged
//        
//        allPojo.addListener(new ListChangeListener<CategoryPojo>() {
//            @Override
//            public void onChanged(ListChangeListener.Change<? extends CategoryPojo> c) {
//                
////                changeAllPojoesList(c);
//                
//               
//                }
//        });
//    }
//    private void setCloseEvent(){
//        stable.getPrimaryStage().setOnCloseRequest(new EventHandler<WindowEvent>() {
//            @Override
//            public void handle(WindowEvent event) {
//              
//                try {
//                    
//                    dao.closeAllExpandedItems();
//                    
//                } catch (SQLException ex) {
//                    Logger.getLogger(PanelCategoryTableCreater.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            
//            }
//        });
//    
//    }
//    public void remove(CategoryPojo pojo) throws SQLException{
//    
//        dao.delete(pojo.getLeftId(), pojo.getRightId());
//    
//    
//    }
//    public static void setExpandEvent(TreeItem<CategoryPojo> item) {
//        
//        item.expandedProperty().addListener(new ChangeListener<Boolean>() {
//            @Override
//            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
//                 
//                if(newValue.booleanValue()==true){
//                  
//                    try {
//                        new CategoryDao().setExpandedItem(item.getValue().getId());
//                    } catch (SQLException ex) {
//                        Logger.getLogger(PanelCategoryTableCreater.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                   
//                }else{  
//                   
//                    try {
//                        new CategoryDao().setClosedItem(item.getValue().getId());
//                    } catch (SQLException ex) {
//                        Logger.getLogger(PanelCategoryTableCreater.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                   
//            
//                }
//            
//            }
//                
//                    
//        });
//        
//    
//    }
//    private TreeTableRow setDragEvent() {
//    treeTable.setRowFactory(new Callback<TreeTableView<CategoryPojo>, TreeTableRow<CategoryPojo>>() {
//        @Override
//        public TreeTableRow<CategoryPojo> call(final TreeTableView param) {
//            final TreeTableRow<CategoryPojo> row = new TreeTableRow<CategoryPojo>();
//
//            row.setOnDragDetected(new EventHandler<MouseEvent>() {
//                @Override
//                public void handle(MouseEvent event) {
//                    // drag was detected, start drag-and-drop gesture
//                    TreeItem<CategoryPojo> selected = 
//                            (TreeItem<CategoryPojo>) treeTable.getSelectionModel().getSelectedItem();
//                    // to access your RowContainer use 'selected.getValue()'
//
//                    
//                    
//                    if (selected != null) {
//                        System.out.println(".setOnDragDetected()");
//                        
//                        Dragboard db = treeTable.startDragAndDrop(TransferMode.ANY);
////                        db.setDragView(row.snapshot(null,null));
//
//
//                        ClipboardContent content = new ClipboardContent();
//                        content.putString(selected.getValue().getId().toString());
//                        db.setContent(content);
//
//                        event.consume();
//                    }
//                }
//            });
//            row.setOnDragOver(new EventHandler<DragEvent>() {
//                @Override
//                public void handle(DragEvent event) {
//                    
//                    // data is dragged over the target
//                    Dragboard db = event.getDragboard();
//                    if (event.getDragboard().hasString()){
//                        event.acceptTransferModes(TransferMode.MOVE);
//                        
//                         System.out.println(".setOnDragOver()");
//                    }
//                    event.consume();
//                }});
//            row.setOnDragDropped(new EventHandler<DragEvent>() {
//                @Override
//                public void handle(DragEvent event) {
//                    
//                    Dragboard db = event.getDragboard();
//                    boolean success = false;
//                    
//                    if (event.getDragboard().hasString()) {
//
//                        try {
//                            CategoryPojo target= row.getItem();
//                            
//                            String movedPojoIdString= event.getDragboard().getString();
//                            
//                            Integer movedPojoIdInt=Integer.parseInt(movedPojoIdString);
//                            
//                            CategoryPojo moved=moved = dao.retrieveSinglePojoesData(movedPojoIdInt);
//                            
//        
//                            if (!moved.hasDescendants()) {
//                                
//                                 System.out.println("setOnDragDropped");
//                       
//              
//                                dao.move(target,moved);
//                      
//                                refresh();
//                                
//                                
//                            }
//                            
//                            
//                            success = true;
//                        } catch (SQLException ex) {
//                            Logger.getLogger(PanelCategoryTableCreater.class.getName()).log(Level.SEVERE, null, ex);
//                        }
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
//                    }
//                    event.setDropCompleted(success);
//                    event.consume();
//                }   });
//            return row;
//        }
//            });   
//
//
//    return null;
//
//    }
//    private void refresh() throws SQLException {
//         ctc.getTab().refresh();
//    }
//    
//    
//}
