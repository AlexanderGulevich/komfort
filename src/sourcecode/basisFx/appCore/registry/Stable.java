package basisFx.appCore;

//package hepo.appCore;
//
//import hepo.appCore.dao.DbInit;
//import javafx.scene.control.Tab;
//import javafx.scene.control.TabPane;
//import javafx.scene.layout.BorderPane;
//import hepo.domainModel.MainTab;
//import java.sql.SQLException;
//import java.util.HashMap;
//import javafx.scene.control.MenuBar;
//import javafx.stage.Stage;
//
//
//public class Stable {
//
//    private   BorderPane root;
//    private   Stage primaryStage;
//    private   TabPane tabPane; 
//    private   MainTab mainTab;
//    private   HashMap<String,Tab> openedTabs=new HashMap<>();
//    private   MenuBar mainMenu;
//    private   DbInit db;
//    
//    private Stable() {}
//    
//    public void createTabPane() {
//       tabPane=new TabPane();
//    }
//    public void createDb() throws ClassNotFoundException, SQLException {
//       db=new DbInit();
//    }
//
//    
//    public void createRoot() {
//        root=new BorderPane();
//        root.setId("root");
//    }
//    
//    public void createMainTab() {
//        mainTab =new MainTab("Main", "Главная" , false);
//    }
//    
//    public void createMainMenu() {
//        mainMenu=(new MenuOld()).getMenu();
//    }
//
//    public MenuBar getMainMenu() {
//        return mainMenu;
//    }
//    public DbInit getDb() {
//        return db;
//    }
//    
//    public HashMap<String,Tab> getOpenedTabs() {
//        return openedTabs;
//    }
//    
//    public MainTab getMainTab() {
//        return mainTab;
//    }
//    
//
//    public Stage getPrimaryStage() {
//        return primaryStage;
//    }
//
//    public void setPrimaryStage(Stage primaryStage) {
//        this.primaryStage = primaryStage;
//    }
//    
//    private static Stable instanse;
//    
//    
//    
//     public static Stable getInstance(){
//        
//        if(instanse==null) {
//            instanse=new Stable();
//        }else{
//             return instanse;
//        }
//        return instanse;
//    }
//
//      public  BorderPane getRoot() {
//        return root;
//    }
//      
//
//    
//     public  TabPane getTabPane() {
//        return tabPane;
//    }
//      
//      
//     
//       
//    
//     
//    
//}
