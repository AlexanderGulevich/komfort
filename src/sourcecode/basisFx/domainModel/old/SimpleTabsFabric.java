package basisFx.domainModel.old;

//package hepo.appCustomLogic;
//
////import hepo.appCore.AbstractTab;
////import hepo.appCore.CommonVar;
//import hepo.appCore.Stable;
//import hepo.domainModel.CategoryTnpTab;
//import hepo.domainModel.PriceTab;
//import hepo.domainModel.RollTab;
//import hepo.domainModel.TnpReseachTab;
//import java.sql.SQLException;
//
//
//
//public class SimpleTabsFabric{
//
//    String id;
////    TabsOpenCloseLogic tabsOpenCloseLogic;
//
//
//    public SimpleTabsFabric(String id) throws SQLException {
//        this.id=id;
//        createTab(this.id);
//    }
//
//    
//    public AbstractTab createTab(String menuId) throws SQLException{
//        
//     if(!openedTabs.containsKey(menuId+"Tab")){
//         
//            switch (menuId) {
//                
//            case "tnpReseach":return new TnpReseachTab(menuId, "Обработка ТНП",true);
//            case "roll":return new RollTab(menuId, "Обработка заявок Роль",true);
//            case "checkPrice":return new PriceTab(menuId, "Обработка прайса",true);
//            case "categoryTnp":return new CategoryTnpTab(menuId, "Обработка категорий ТНП ",true);
//
//
//                }}
//
//                 return null;
//         }    
//    
//    
//    
//     }
//
//           
//    
//    
//    
//   
//    
//    
//
