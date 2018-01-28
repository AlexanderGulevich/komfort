package basisFx.domainModel.old;

//package hepo.domainModel;
//import hepo.appCore.AbstractTab;
//import hepo.appCore.FileChoose;
//import hepo.domainModel.poi.PlanReader;
//import hepo.domainModel.poi.PriceReader;
//import java.io.File;
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.ScrollPane;
//import javafx.scene.control.TableView;
//import javafx.scene.layout.AnchorPane;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.VBox;
//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//
//
//public class TnpReseachTab extends AbstractTab{
//   
//    private GoodsPojoCommunicator gpcPlan;
//    private GoodsPojoCommunicator gpcPrice;
//    private GoodsPojoCommunicator gpcNoIntoPlanFileButExistInDB;
//    private Button priceBut;
//    private Button planBut;
//    private Button saveReportBut;
//    private Plan plan;
//    private Price price;  
//    private List<File> files;
//    private AnchorPane anchorInsideScroll=null;
//    private Double boxHeight=500.0;
//    private Double boxTopMargin=40.0;
//    public static TnpReseachTab entity=null;
//    private PanelOpenedOrdersTableCreater   openedOrdersTableCreater=null;
//    private ObservableList pricePojoListCloned;
//    private String priceDate;
//    
//    public TnpReseachTab(String id, String name, boolean closeable) {
//        
//        super(id,name,closeable);
//        
//        TnpReseachTab.entity=this;
//        
//        init ();
//       
//    }
//
//    public GoodsPojoCommunicator getGpcPlan() {
//        return gpcPlan;
//    }
//
//    public GoodsPojoCommunicator getGpcPrice() {
//        return gpcPrice;
//    }
//    
//    private void init (){
//    
//        this.gpcPlan=new GoodsPojoCommunicator<GoodsPojo>();
//        gpcPlan.setTab(currentTab);
//        gpcPlan.setTabCreater(this);
//        
//        this.gpcPrice=new GoodsPojoCommunicator<GoodsPojo>();
//        gpcPrice.setTab(currentTab);
//        gpcPrice.setTabCreater(this);
//        
//        
//        gpcNoIntoPlanFileButExistInDB=new GoodsPojoCommunicator<GoodsPojo>();
//        gpcNoIntoPlanFileButExistInDB.setTab(currentTab);
//        gpcNoIntoPlanFileButExistInDB.setTabCreater(this);
//  
//        buildContent();
//    
//    }
//
//    @Override
//    public  void buildContent() {
//        
//        ScrollPane sp=new ScrollPane();
//        anchorHandler(anchorPane, sp, 0.0, 0.0, 0.0, 0.0);
//        sp.setPannable(true);
//        
//        anchorInsideScroll =new AnchorPane();
//        sp.setContent(anchorInsideScroll);
////        insideAnchorPane.setStyle(" -fx-background-color: blue");
//        anchorInsideScroll.prefWidthProperty().bind(anchorPane.widthProperty().subtract(15.0));
//        
//        saveReportBut=new Button("Сохранить отчет");
//        saveReportBut.setId("saveReportButTnpReseachTab");
//        anchorHandler(anchorInsideScroll, saveReportBut, 10.0, 10.0, null, null);
//       
//        setSaveReportButEvent();
//        
//        try {
//            createTopBox();
//            createMiddleBox();
//            createBottomBox();       
//        } catch (SQLException ex) {
//            Logger.getLogger(TnpReseachTab.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        anchorPane.setMinHeight(500.0);   
//        tab.currentTab.getTabPane().setMinHeight(500.0);
//
//    }
//    
//    private void createTopBox() throws SQLException {
//      
//        HBox hboxTop= new HBox();
//        hboxTop.setPrefHeight(boxHeight);
//      //  hboxTop.setStyle(" -fx-background-color: #4fb3bf");
//        anchorHandler(anchorInsideScroll, hboxTop, boxTopMargin, 10.0, null, 10.0);
//      
//
//        Label label1=new Label("Заказы из Прайса, \n     отсутствующие в Базе");
//        label1.setStyle(""
//                + "-fx-font-size:15px;"
//                + "-fx-font-weight:800"
//                + "");
//        anchorHandler(null, label1, -5.0, null, null, 10.0);
//       
//        PanelPriceTableWithoutCategoryCreater   priceTableWithoutCategoryCreater=
//                new PanelPriceTableWithoutCategoryCreater(gpcPrice );
//        TableView <GoodsPojo>priceTableWithoutCategory =priceTableWithoutCategoryCreater.getTable();
//        priceTableWithoutCategory.setEditable(true);
//        anchorHandler(null, priceTableWithoutCategory, 40.0, 5.0, 5.0, 5.0);
//     
//        priceBut= new Button("Загрузить ПРАЙС");
//        priceBut.setId("priceButTnpReseachTab");
//        anchorHandler(null, priceBut, 5.0, 5.0, null, null);
//        
//        setPriceButEvent();
//
//        Label label2=new Label("Заказы из Плана, \n     отсутствующие в Базе");
//        AnchorPane.setLeftAnchor(label2, 5.0);
//        AnchorPane.setTopAnchor(label2, -5.0);
//         label2.setStyle(""
//                + "-fx-font-size:15px;"
//                + "-fx-font-weight:800"
//                + "");
//        
//        
//        PanelPlanTableWithoutCategoryCreater planTableWithoutCategoryCreater =
//                new PanelPlanTableWithoutCategoryCreater(gpcPlan);
//        TableView <GoodsPojo>planTableWithoutCategory =planTableWithoutCategoryCreater.getTable();
//        anchorHandler(null, planTableWithoutCategory,40.0, 5.0, 5.0, 5.0);
//
//        planBut= new Button("Загрузить ПЛАН");
//        planBut.setId("planButTnpReseachTab");
//        anchorHandler(null, planBut, 5.0, 5.0, null, null);
//        
//        setPlanButEnent();
//        
//        VBox vbox_1=new  VBox(new AnchorPane(
//                priceTableWithoutCategory,label1,priceBut
//        ));
//        VBox vbox_2=new  VBox(new AnchorPane(
//                planTableWithoutCategory,label2,planBut
//        ));
//        
//        
//        priceTableWithoutCategory.prefWidthProperty().bind(vbox_1.widthProperty().subtract(10.0));
//        priceTableWithoutCategory.prefHeightProperty().bind(hboxTop.heightProperty().subtract(10.0));
//       
//        planTableWithoutCategory.prefWidthProperty().bind(vbox_2.widthProperty().subtract(10.0));
//        planTableWithoutCategory.prefHeightProperty().bind(hboxTop.heightProperty().subtract(10.0));
//        
//        vbox_1.prefWidthProperty().bind(hboxTop.widthProperty().divide(2));
//        vbox_2.prefWidthProperty().bind(hboxTop.widthProperty().divide(2));
//        
//        priceTableWithoutCategoryCreater.setPrefWidthBindToColums(vbox_2.widthProperty());
//        planTableWithoutCategoryCreater.setPrefWidthBindToColums(vbox_1.widthProperty());
//        
//        hboxTop.getChildren().addAll(vbox_1,vbox_2);
//
//    }
//
//    private void createMiddleBox() throws SQLException {
//        HBox hboxMiddle= new HBox();
//        hboxMiddle.setPrefHeight(boxHeight);
////        hboxMiddle.setStyle(" -fx-background-color: #4fb3bf");
//        anchorHandler(anchorInsideScroll, hboxMiddle, boxHeight+boxTopMargin*2, 10.0, null, 10.0);
//
//        Label label1=new Label("Заказы, помеченные в Базе, как открытые");
//        label1.setStyle(""
//                + "-fx-font-size:15px;"
//                + "-fx-font-weight:800"
//                + "");
//        anchorHandler(null, label1, 5.0, null, null, 10.0);
//        
//        openedOrdersTableCreater=
//                new PanelOpenedOrdersTableCreater(
//                        new GoodsLogic().createGpc()
//                                .retrieveOpenOrders().getGpc()
//                );
//        openedOrdersTableCreater.getGpc().setTabCreater(this);
//        
//        TableView <GoodsPojo>openedOrdersTable =openedOrdersTableCreater.getTable();
//        anchorHandler(null, openedOrdersTable, 40.0, 5.0, 5.0, 5.0);
//        
//        VBox vbox_3=new  VBox(new AnchorPane(
//                openedOrdersTable,label1
//        ));
//        
//        openedOrdersTable.prefWidthProperty().bind(hboxMiddle.widthProperty());
//        openedOrdersTable.prefHeightProperty().bind(hboxMiddle.heightProperty().subtract(10.0));
//                
//        hboxMiddle.getChildren().addAll(vbox_3);
//        
//        openedOrdersTableCreater.setPrefWidthBindToColums(hboxMiddle.widthProperty());
//
//    }
//
//    private void createBottomBox() throws SQLException {
//        HBox hboxBottom= new HBox();
//        hboxBottom.setPrefHeight(boxHeight);
////        hboxBottom.setStyle(" -fx-background-color: #4fb3bf");
//        anchorHandler(anchorInsideScroll,hboxBottom,boxHeight*2+boxTopMargin*3, 10.0,  50.0, 10.0);
//
//        Label label=new Label("Есть в БД, но нет в Плане");
//        label.setStyle(""
//                + "-fx-font-size:15px;"
//                + "-fx-font-weight:800"
//                + "");
//        anchorHandler(null, label, 5.0, null, null, 10.0);
//
//        PanelNotInPlanTableCreater   notInPlalTableCreater=
//                new PanelNotInPlanTableCreater(gpcNoIntoPlanFileButExistInDB);
//
//        TableView <GoodsPojo>notInPlalTable =notInPlalTableCreater.getTable();
//        anchorHandler(null, notInPlalTable, 40.0, 5.0, 5.0, 5.0);
//
//        VBox vbox_4=new  VBox(new AnchorPane(
//                notInPlalTable,label
//        ));
//
//        
//        notInPlalTable.prefWidthProperty().bind(hboxBottom.widthProperty());
//        notInPlalTable.prefHeightProperty().bind(hboxBottom.heightProperty().subtract(10.0));
//        notInPlalTableCreater.setPrefWidthBindToColums(vbox_4.widthProperty());
//
//        hboxBottom.getChildren().addAll(vbox_4);
//    }
//    
//    public  void refreshAllTables() throws SQLException{
//        
//        GoodsLogic glPlan=new GoodsLogic(gpcPlan);
//        GoodsLogic glPrice=new GoodsLogic(gpcPrice);
//
//        glPrice.handleOrderList();
//        glPlan.handleOrderList();
//        
//        createMiddleBox();
////        createBottomBox();
//        
//        
//    }
//    
//    private void setPriceButEvent(){
//     
//      priceBut.setOnAction(new EventHandler<ActionEvent>() {
//          @Override
//          public void handle(final ActionEvent e) {
//              files=new FileChoose().getFiles();
//              if (files!=null) {
//                  for (File concreteFile : files) {
//                      try {
//                          TnpReseachTab.this.price = new PriceReader(concreteFile).getPrice();
//                          TnpReseachTab.this.price.setCommunicator(gpcPrice);
//                          TnpReseachTab.this.price.setDataToCommunicator();
//                          TnpReseachTab.this.priceDate=TnpReseachTab.this.price.getPriceDateString();
//                          TnpReseachTab.this.pricePojoListCloned = gpcPrice.cloneAllPojo();
//                          GoodsLogic gl=new GoodsLogic(gpcPrice);
//                          gl.handleOrderList();
//                          TnpReseachTab.this.gpcPrice = gl.getGpc();
//                      }//                tnpResearchStage = new TnpResearchStage(700, 600);
//                      catch (IOException | InvalidFormatException | CloneNotSupportedException | SQLException ex) {
//                          Logger.getLogger(TnpReseachTab.class.getName()).log(Level.SEVERE, null, ex);
//                      }
//                  }
//              }
//          }
//      });
//     
//     }
//
//    private void setPlanButEnent(){
//        planBut.setOnAction((final ActionEvent e) -> {
//            files=new FileChoose().getFiles();
//            if(files!=null){
//                for(File concreteFile:files){
//
//                    try {
//                        
//                        this.plan=new PlanReader(concreteFile).getPlan();
//                        this.plan.setCommunicator(gpcPlan);
//                        this.plan.setDataToCommunicator();
//                        //вставляю закрытые заказы в нижнюю таблицу
//                        new GoodsLogic(gpcNoIntoPlanFileButExistInDB).findClosedOrdersInPlan(gpcPlan);
//                        this.gpcPlan=new GoodsLogic(gpcPlan).handleOrderList().getGpc();
//                  
//                    } catch (IOException ex) {
//                        Logger.getLogger(TnpReseachTab.class.getName()).log(Level.SEVERE, null, ex);
//                    } catch (InvalidFormatException ex) {
//                        Logger.getLogger(TnpReseachTab.class.getName()).log(Level.SEVERE, null, ex);
//                    } catch (SQLException ex) {
//                        Logger.getLogger(TnpReseachTab.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//               
//                       
//                        
//               
//            }   
//            }
//        });
//        
//    }
//
//    private void setSaveReportButEvent() {
//      saveReportBut.setOnAction((final ActionEvent e) -> {
//          
//              if(pricePojoListCloned==null){
//                  
//                  System.out.println("pricePojoListCloned"+pricePojoListCloned);
//                  
//              
//              }else{
//              
//                  try {
//
//                      ReportTnp report =new ReportTnp(
//                              pricePojoListCloned,
//                              new DirectoryChooserWrapper().getPath(),
//                              this.priceDate
//                      );
//
//                      
//                  } catch (SQLException ex) {
//                      Logger.getLogger(TnpReseachTab.class.getName()).log(Level.SEVERE, null, ex);
//                  } catch (IOException ex) {
//                      Logger.getLogger(TnpReseachTab.class.getName()).log(Level.SEVERE, null, ex);
//                  }
//                  
//                  
//              
//              
//              }
//              
//        
//
//        });
//    }
//    
//}
