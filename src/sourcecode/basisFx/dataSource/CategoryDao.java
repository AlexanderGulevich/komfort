package basisFx.dataSource;

//package hepo.appCore.dao;
//
//import hepo.domain.CategoryCommunicator;
//import hepo.appCore.Stable;
//import hepo.domain.CategoryPojo;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
///**
// *
// * @author Alek
// */
//public class CategoryDao {
//    
//   Connection connecttion=Stable.getInstance().getDb().getConnection();
//           
//
//    public void insert(String name, Integer levelId, Integer  rightId , Integer leftId ) throws SQLException {
//        String sql = "INSERT INTO ordersCategory(name,levelId,rightId,leftId,isExpanded) VALUES(?,?,?,?,?)";
//
//        PreparedStatement pstmt = connecttion.prepareStatement(sql);
//            pstmt.setName(1, name);
//            pstmt.setInt(2, levelId);
//            pstmt.setInt(3, rightId);
//            pstmt.setInt(4, leftId);     
//            pstmt.setInt(5, 0);       
//            
//            pstmt.executeUpdate();
//
//}
//    public void insertToRoot(String name) throws SQLException {
//        
//            int maxId=0;
//        
//            String sql ="SELECT Max(rightId) as maxRightId FROM ordersCategory";
//            
//            Statement stmt =connecttion.createStatement();
//
//            ResultSet rs = stmt.executeQuery( sql );
//            
//            
//            while ( rs.next() ) {
//            
//                 maxId = rs.getInt("maxRightId");
//                
//                System.err.println("insertToRoot ----maxRightId --"+maxId);
//            }
////                rs.wasNull();
////                rs.absolute(maxId);
//                rs.close();
//                stmt.close();
//            
////            
//            insert(name, 1, maxId+2,maxId+1 );
//            
//             
//}
//    public void insertToParentNode(String name, Integer parentLevel, Integer parentRightId ) throws SQLException {
//            
//         //Обновляем ключи существующего дерева, узлы стоящие за родительским узлом:
//          String sql_1 = "UPDATE ordersCategory SET leftId =leftId +2,"
//                  + " rightId=rightId+2 "
//                + "WHERE leftId > ?";
//          
//          PreparedStatement pstmt_1 = connecttion.prepareStatement(sql_1);
//          pstmt_1.setInt(1, parentRightId);
//          pstmt_1.executeUpdate();
//          
//          
//          //Обновляем родительскую ветку, а не конкретно родительский узел
//          String sql_2 = "UPDATE ordersCategory SET rightId =rightId +2"
//                + " WHERE rightId >= ? "
//                  + "AND leftId<?";
//          
//          PreparedStatement pstmt_2 = connecttion.prepareStatement(sql_2);
//          pstmt_2.setInt(1, parentRightId);
//          pstmt_2.setInt(2, parentRightId);
//          pstmt_2.executeUpdate();
//          
//          String sql_3 = "INSERT INTO ordersCategory(name,levelId,rightId,leftId,isExpanded) VALUES(?,?,?,?,?)";
//
//            PreparedStatement pstmt_3 = connecttion.prepareStatement(sql_3);
//            pstmt_3.setName(1, name);
//            pstmt_3.setInt(2, parentLevel+1);
//            pstmt_3.setInt(3, parentRightId+1);
//            pstmt_3.setInt(4, parentRightId);     
//            pstmt_3.setInt(5, 0);       
//
//            pstmt_3.executeUpdate();
//       
//        
//}
//    public CategoryCommunicator selectAllCategories(CategoryCommunicator ctc) throws SQLException {
//        String sql = "SELECT * FROM ordersCategory ORDER BY leftId";
//
//        Statement stmt  = connecttion.createStatement();
//        
//        ResultSet rs    = stmt.executeQuery(sql);
//        
//         while (rs.next()) {
//             
//             CategoryPojo domaine=new CategoryPojo("");
//             domaine.setId(rs.getInt("ordersCategoryId"));
//             domaine.setLeftId(rs.getInt("leftId") );
//             domaine.setLevelId(rs.getInt("levelId"));
//             domaine.setRightId(rs.getInt("rightId"));
//             domaine.setCategoryNameOfTnp(rs.getString("name") );
//             domaine.setIsExpanded(rs.getInt("isExpanded"));
//             domaine.setShortName(rs.getString("shortName"));
//             
//             ctc.setPojo(domaine);
//                 
//                
//            }
//
//          
//        return ctc;
//            
//}
//    public void updateCategoryLongName(int id, String name) throws SQLException {
//        String sql = "UPDATE ordersCategory SET name = ?  "
//                + "WHERE ordersCategoryId = ?";
// 
//        
//            PreparedStatement pstmt = connecttion.prepareStatement(sql);
// 
//            // set the corresponding param
//            pstmt.setName(1, name);
//            pstmt.setInt(2, id);
//            // update 
//            pstmt.executeUpdate();
//
//    }
//    public void delete(int leftKeyOfDelete, int rightKeyOfDelete ) throws SQLException {
//        String sql_1 = "DELETE FROM ordersCategory "
//                + "WHERE leftId >= ?  "
//                + "AND rightId <= ? ";
// 
//        
//            PreparedStatement pstmt_1 = connecttion.prepareStatement(sql_1);
//
//            pstmt_1.setInt(1, leftKeyOfDelete);
//            pstmt_1.setInt(2, rightKeyOfDelete);
//            pstmt_1.executeUpdate();
//
//
//        String sql_2 = "UPDATE ordersCategory SET "
//                + "  rightId = rightId-(?-?+1)  "
//                + " WHERE rightId > ? "
//                + " AND leftId<?";    
//            
//           PreparedStatement pstmt_2 = connecttion.prepareStatement(sql_2);
//
//            pstmt_2.setInt(1, rightKeyOfDelete);
//            pstmt_2.setInt(2, leftKeyOfDelete);
//            pstmt_2.setInt(3, rightKeyOfDelete);
//            pstmt_2.setInt(4, leftKeyOfDelete);
//            pstmt_2.executeUpdate();
//        
//
//        String sql_3 = "UPDATE ordersCategory SET "
//                + "  leftId = leftId-(?-?+1),"
//                + "  rightId=rightId-(?-?+1)"
//                + " WHERE leftId > ? "
//                + " ";    
//            
//           PreparedStatement pstmt_3 = connecttion.prepareStatement(sql_3);
//
//            pstmt_3.setInt(1, rightKeyOfDelete);
//            pstmt_3.setInt(2, leftKeyOfDelete);
//            pstmt_3.setInt(3, rightKeyOfDelete);
//            pstmt_3.setInt(4, leftKeyOfDelete);
//            pstmt_3.setInt(4, rightKeyOfDelete);
//            pstmt_3.executeUpdate();
//        
//    }
//    public void closeAllExpandedItems() throws SQLException {
//       String sql = "UPDATE ordersCategory SET "
//                + "  isExpanded = 0  ";
//               
//
//           PreparedStatement pstmt = connecttion.prepareStatement(sql);
//
//            pstmt.executeUpdate();
//    }
//    public void setExpandedItem(Integer id) throws SQLException {
//       String sql = "UPDATE ordersCategory SET "
//                + "  isExpanded = 1  "
//               + " WHERE ordersCategoryId=?";
//               
//            
//           PreparedStatement pstmt = connecttion.prepareStatement(sql);
//           
//           
//            pstmt.setInt(1, id);
//
//       
//            pstmt.executeUpdate();
//    }
//    public Integer getParentId(CategoryPojo domaine) throws SQLException {
//                
//       String sql = "SELECT ordersCategoryId From ordersCategory "
//               + " WHERE leftId <=  ? "
//               + " AND rightId >= ?"
//               + " AND levelId = ? - 1 "
//               + "ORDER BY leftId";
//               
//           PreparedStatement pstmt = connecttion.prepareStatement(sql);
//   
//           pstmt.setInt(1, domaine.getLeftId());
//           pstmt.setInt(2, domaine.getRightId());
//           pstmt.setInt(3, domaine.getLevelId());
//  
//           ResultSet rs  = pstmt.executeQuery();
//            
//            if(rs.next()){
//              
//                return rs.getInt("ordersCategoryId");
//                
//                }
//                            return null;
//
//    }
//    public void setClosedItem(Integer id) throws SQLException {
//       String sql = "UPDATE ordersCategory SET "
//                + "  isExpanded = 0  "
//               + " WHERE ordersCategoryId=?";
//               
//            
//           PreparedStatement pstmt = connecttion.prepareStatement(sql);
//           
//           
//            pstmt.setInt(1, id);
//
//       
//            pstmt.executeUpdate();
//    }
//    public void updateCategoryShortName(Integer id, String shortName) throws SQLException {
//       
//            String sql = "UPDATE ordersCategory SET shortName = ?  "
//                + "WHERE ordersCategoryId = ?";
// 
//        
//            PreparedStatement pstmt = connecttion.prepareStatement(sql);
// 
//            // set the corresponding param
//            pstmt.setName(1, shortName);
//            pstmt.setInt(2, id);
//            // update 
//            pstmt.executeUpdate();
//    
//    }
//    public void move(CategoryPojo target, CategoryPojo movedPojo) throws SQLException {
//        
//        Integer movedPojoId=movedPojo.getId();
//        Integer movedPojoLeft=movedPojo.getLeftId();
//        Integer movedPojoRight=movedPojo.getRightId();
//        Integer movedPojoLevel=movedPojo.getLevelId();
//        
//        System.err.println(movedPojo.getCategoryNameOfTnp()+"---"+target.getCategoryNameOfTnp());
//        
//        Integer parentMovedId=getParentId(movedPojo);
//        
//        CategoryPojo  parentMovedPojo=retrieveSinglePojoesData(parentMovedId);
//        Integer parentMovedPojoLeft=parentMovedPojo.getLeftId();
//        Integer parentMovedPojoRight=parentMovedPojo.getRightId();
//        Integer parentMovedPojoLevel=parentMovedPojo.getLevelId();
//        
//        Integer targetPojoId=target.getId();
//        Integer targetPojoLeft=target.getLeftId();
//        Integer targetPojoRight=target.getRightId();
//        Integer targetPojoLevel=target.getLevelId();
//        
//        
//              //Обновляем правый ключ  targetPojo и родительских узлов 
//          String sql_1 = "UPDATE ordersCategory SET "
//                  + " rightId=rightId  + 2 "
//                 + "WHERE ordersCategoryId IN "
//                  + "(SELECT ordersCategoryId FROM ordersCategory   "
//                  + "WHERE leftId <=  ? AND rightId >= ?)";
//          
//          
//          PreparedStatement pstmt_1 = connecttion.prepareStatement(sql_1);
//          pstmt_1.setInt(1, targetPojoLeft);
//          pstmt_1.setInt(2, targetPojoRight);
//          pstmt_1.executeUpdate();
//          
//        
//          
//    //Уменьшаю правые ключи родительских узлов ветки, из которой происходит изъятие
//          String sql_4= "UPDATE ordersCategory SET "
//                  + "rightId=rightId-2 "
//                  + "WHERE ordersCategoryId IN "
//                  + "(SELECT ordersCategoryId FROM ordersCategory   "
//                  + "WHERE leftId <  ? AND rightId > ?)";
//          
//          PreparedStatement pstmt_4 = connecttion.prepareStatement(sql_4);
//          pstmt_4.setInt(1, movedPojoLeft);
//          pstmt_4.setInt(2, movedPojoRight);
//          pstmt_4.executeUpdate();
//
//     //Уменьшаю ключи правее перемещаемого
//          String sql_2= "UPDATE ordersCategory SET leftId =leftId -2,"
//                  + " rightId=rightId-2 "
//                + " WHERE leftId > ?";
//          
//          PreparedStatement pstmt_2 = connecttion.prepareStatement(sql_2);
//          pstmt_2.setInt(1, movedPojoLeft);
//          pstmt_2.executeUpdate();     
//          
//          
//    //Увеличивать ключи существующего дерева правее targetPojo
//          String sql_7= "UPDATE ordersCategory SET leftId =leftId +2,"
//                  + " rightId=rightId+2 "
//                  + " WHERE leftId > ?";
//          
//          PreparedStatement pstmt_7 = connecttion.prepareStatement(sql_7);
//          pstmt_7.setInt(1, targetPojoLeft);
//          pstmt_7.executeUpdate();
//                
//          
//
//          if (!target.hasDescendants()) {
//         
//        //Увеличиваю правый ключ targetPojo, делая его веткой а не листом
//          String sql_10 = "UPDATE ordersCategory SET "
//                  + " rightId=rightId  +1 "
//                + " WHERE ordersCategoryId = ?";
//          
//          PreparedStatement pstmt_10 = connecttion.prepareStatement(sql_10);
//          pstmt_10.setInt(1, targetPojoId);
//          pstmt_10.executeUpdate();
//              
//            
//        }
//                
//                   
//         //Вставляю ключи для перемещаемого узла
//          String sql_5 = "UPDATE ordersCategory SET "
//                  + " leftId =? +1,"
//                  + " rightId=?  +2, "
//                  + " levelId=? +1"
//                + " WHERE ordersCategoryId = ?";
//          
//          PreparedStatement pstmt_5 = connecttion.prepareStatement(sql_5);
//          pstmt_5.setInt(1, targetPojoLeft);
//          pstmt_5.setInt(2, targetPojoLeft);
//          pstmt_5.setInt(3, targetPojoLevel);
//          pstmt_5.setInt(4, movedPojoId);
//          pstmt_5.executeUpdate();
//          
//     
//                 
//    
//    }
//    public  CategoryPojo retrieveSinglePojoesData(Integer id) throws SQLException {
//       
//    String sql = "  select * FROM ordersCategory  "
//             
//                + "  WHERE ordersCategoryId=? ";
//        
//          PreparedStatement pstmt= connecttion.prepareStatement(sql);
//          pstmt.setInt(1,id);
//    
//  
//           ResultSet rs    = pstmt.executeQuery();
//           
//           CategoryPojo domaine=new CategoryPojo();
//            
//            while (rs.next()) {
//                 domaine.setId(rs.getInt("ordersCategoryId"));
//                 domaine.setLeftId(rs.getInt("leftId"));
//                 domaine.setLevelId(rs.getInt("levelId"));
//                 domaine.setRightId(rs.getInt("rightId"));
//                 domaine.setShortName(rs.getString("shortName"));
//                 domaine.setCategoryNameOfTnp(rs.getString("name"));
//                                 
//            }
//        return domaine;
//      
//
//
//    }
//       
//           
//
//    
//}
