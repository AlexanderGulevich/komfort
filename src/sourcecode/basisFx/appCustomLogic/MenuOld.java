

//package hepo.appCore;
//
//import hepo.appCustomLogic.SimpleTabsFabric;
//import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javafx.event.ActionEvent;
//import javafx.scene.control.Menu;
//import javafx.scene.control.MenuBar;
//import javafx.scene.control.MenuItem;
//import hepo.appCore.Conctractable;
//
//
//public class MenuOld extends Conctractable{
//
//    private  MenuBar menu;
//   
//    public MenuOld() {
//        buildContent();
//    }
//  
//    public MenuBar getMenu() {
//        return menu;
//    }
//     
//    protected void buildContent(){
//        
//
//        menu =new MenuBar();
//        menu.setId("MenuBar");
//        Menu ved= new Menu ("ВЭД");
//        
//        MenuItemInit(new MenuItem ("Обработка заявок от \"Роль\""),ved,"roll");
//        MenuItemInit(new MenuItem ("Отчет по Экспорту"),ved,"reportExport");
//        MenuItemInit(new MenuItem ("Отчет по Импорту"),ved,"reportImport");
//        MenuItemInit(new MenuItem ("Справка \"Приход продукции\""),ved,"coming");
//        MenuItemInit(new MenuItem ("Справка \"Отгрузка продукции\""),ved,"dispatch");
//        
//      
//        Menu tnp= new Menu ("ТНП");
//        
//        
//        MenuItemInit(new MenuItem ("Отчет - \"Товары Народного Потребления\" из EXEL"),tnp,"tnpReseach"); 
//        MenuItemInit(new MenuItem ("Создать прайс из остатков склада"),tnp,"checkPrice");
//        MenuItemInit(new MenuItem ("Управление категориями товарной номенклуатуры"),tnp,"categoryTnp");
//        MenuItemInit(new MenuItem ("Архив заказов"),tnp,"orderArchiv");
//        MenuItemInit(new MenuItem ("Обложки заказов"),tnp,"notebookSkin");   
//        
//        Menu supply= new Menu ("Снабжение");
//      
//        MenuItemInit(new MenuItem ("Заказы на выполнение - Зарубежье"),supply,"listForeight");
//        MenuItemInit(new MenuItem ("Заказы на выполнение - Беларусь"),supply,"listBelaris");
//        MenuItemInit(new MenuItem ("Заказы на выполнение - Расходные мат."),supply,"listLittleOrders");
//        MenuItemInit(new MenuItem ("Сформировать задачу водителю"),supply,"taskToDriver");
//        MenuItemInit(new MenuItem ("Архив заказов"),supply,"archiv");
//        
//        Menu contacts= new Menu ("Контрагенты");
//        
//        MenuItemInit(new MenuItem ("Управление категориями Контрагентов"),contacts,"contactsCategory");
//        MenuItemInit(new MenuItem ("Список контрагентов"),contacts,"contactList");
//        
//        Menu task= new Menu ("Задачи");
//        
//        Menu settings= new Menu ("Настройки");
//
//        menu.getMenus().addAll(ved,tnp,supply,contacts,task,settings);
//    
//    }
//    
//  
//        
//            public void MenuItemInit(MenuItem mi, Menu parent,String id) {
//                
//                parent.getItems().add(mi);
//                mi.setId(id);
//                mi.setOnAction((ActionEvent e) -> {
//                    try {
//                        new SimpleTabsFabric(mi.getId());
//                    } catch (SQLException ex) {
//                        Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                });
//                
//                
//            }
//
//        
//    
//}
