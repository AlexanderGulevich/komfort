package basisFx.appCore.utils;

//package hepo.appCore;
//
//import javafx.scene.control.Tab;
//import javafx.event.Event;
//import javafx.scene.Node;
//import javafx.scene.control.Alert;
//import javafx.scene.control.ButtonType;
//import javafx.scene.layout.AnchorPane;
//import javafx.primaryStage.Modality;
//
//public abstract class AbstractTab{
//    
//    
//    public Tab currentTab;
//    protected String menuId;
//    protected String tabName;
//    protected AnchorPane anchorPane;
//    protected boolean closeable;
//    
//    public AbstractTab(String id, String metaName, boolean closeable) {
//        
//        this.menuId = id;
//        this.tabName=metaName;
//        this.closeable=closeable;
//        this.anchorPane=new AnchorPane();
//
//        createTab();
//        
//        setClosability();
//        
////        buildContent();//построить содержимое
//        
//        tabCloserHandler();
//        addToOpenTabs();
//        
//        
//       
//    }
//        
//
//    public abstract void buildContent();//метод построения содержимого
//    
//    
//    private void setClosability(){
//        
//        if(closeable==true){
//            currentTab.setClosable(true);
//         } else{ 
//             currentTab.setClosable(false);
//         }
//         
//    
//    }
//    
//    
//    public void createTab(){
//        
//        
//       
//       currentTab=new Tab();
//        
//       currentTab.setId(menuId+"Tab");
//
//       tabPane.getSelectionModel().select(currentTab);// Сделать активной
//
//       currentTab.setText(tabName);//вставить имя
//
//       tabPane.getTabs().add(currentTab);//добавить на TabPane
//        
////       tabsOpenLogic.addOpenedTabsObj(currentTab);
//       
//       currentTab.setContent(anchorPane);
//               
//        tabCloserHandler();
//   
//
//    }
//    
//     private void tabCloserHandler  (){
//        
//        if(currentTab.isClosable()){
//
//         currentTab.setOnCloseRequest((Event ev) -> {
//         Alert alert=new Alert( Alert.AlertType.CONFIRMATION);
//
//       
//         alert.setTitle("Подтверждение");
//         alert.setHeaderText(
//                 "  Закрыть панель \n " + "\""+ tabName+ "?\""
//         );
//         alert.initModality(Modality.APPLICATION_MODAL);
//         alert.showAndWait();
//
//         if (alert.getResult() == ButtonType.OK){
//             
//         }else if (alert.getResult() == ButtonType.CANCEL) 
//         ev.consume();
//       
//        });
//        
//         
//        currentTab.setOnClosed((Event ev) -> {
//           openedTabs.remove(currentTab.getId());
//         }   
//         );
//
//             
//     }}
//     
//      public void addToOpenTabs(){
//          
//         
//        openedTabs.put(currentTab.getId(), currentTab);
//        
//
//      
//    }
//      
//      
//      protected void anchorHandler(
//              AnchorPane anchor,
//              Node node,
//              Double top,
//              Double right,
//              Double bottom, 
//              Double left
//      ){
//          
//          
//        if (anchor!=null){
//        
//            anchor.getChildren().add(node);
//            
//        }
//        
//          
//        if(top!=null){
//            AnchorPane.setTopAnchor(node, top);
//        }
//        if(right!=null){
//            AnchorPane.setRightAnchor(node, right);
//        }
//        if(bottom!=null){
//           AnchorPane.setBottomAnchor(node, bottom);
//        }
//        if(left!=null){
//            AnchorPane.setLeftAnchor(node, left);
//        }
//              }
//        
//    
//
//}
