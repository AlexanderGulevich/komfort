package basisFx.domainModel.dataMappers;

//
//package hepo.domainModel.dao;
//
//import hepo.domainModel.GoodsPojoCommunicator;
//import hepo.appCore.Stable;
//import hepo.domainModel.CategoryPojo;
//import hepo.domainModel.GoodsPojo;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.text.DecimalFormat;
////import static jdk.nashorn.internal.runtime.Debug.id;
//
///**
// *
// * @author Alek
// */
//public class TnpDao {
//    
//    Connection connecttion=Stable.getInstance().getDb().getConnection();
//           
//    public void insertOrder(GoodsPojo gp, CategoryPojo scp  ) throws SQLException {
//         
//        String sql = "INSERT INTO orders("
//                  + "year,"
//                  + "orderNumberInt,"
//                  + "orderNumberText,"
//                  + "ordersCategoryId,"
//                  + "inArchiv"
//                  + ") VALUES(?,?,?,?,?)";
//
//            PreparedStatement pstmt= connecttion.prepareStatement(sql);
//            pstmt.setInt(1, gp.getYear());
//            pstmt.setInt(2, gp.getLeftOrderNum()); 
//            pstmt.setString(3, gp.getOrder());     
//            pstmt.setInt(4, scp.getId());       
//            pstmt.setInt(5, 0);       
//
//            pstmt.executeUpdate();
//       
//        
//}
//
//    public Boolean isExist(Integer leftOrderNum, Integer year) throws SQLException {
//        
//         String sql = "SELECT ordersId "
//                          + "FROM orders WHERE year = ? AND orderNumberInt = ? ";
//        
//       
//            PreparedStatement pstmt  = connecttion.prepareStatement(sql);
//            
//           
//            pstmt.setDouble(1,year);
//            pstmt.setDouble(2,leftOrderNum);
//            
//            ResultSet rs  = pstmt.executeQuery();
//
//        if(rs.next()){
//            return Boolean.TRUE;
//            }
//        else{
//            return Boolean.FALSE;
//
//        }
//
//    }
//    //когда вставляю данные в таблицу orders то эта функция добавляет
//    // ordersId в таблицу goodsName
//    public void insertToGoodsNameTableId() throws SQLException{
//        String sql = "  insert INTO goodsName (ordersId) SELECT orders.ordersId FROM orders  "
//                + " LEFT JOIN goodsName   on  orders.ordersId  = goodsName.ordersId "
//                + "  WHERE goodsName.ordersId IS NULL";
//        
//         PreparedStatement pstmt= connecttion.prepareStatement(sql);
//         pstmt.executeUpdate();
//    }
//    public void setGoodsNameWithoutId(GoodsPojo goodsPojo ) throws SQLException {
//    
//      Integer leftOrderNum=goodsPojo.getLeftOrderNum();
//      Integer year=goodsPojo.getYear();
//      String text=null;
//      Integer id=getGoodsId(leftOrderNum, year);  
// 
//        if (goodsPojo.getProductNamePlan()!=null){
//
//            text=goodsPojo.getProductNamePlan();
//
//        }
//        if(goodsPojo.getProductNamePrice()!=null){
//
//            text=goodsPojo.getProductNamePrice();
//
//                }
//        
//        if(text!=null){
//
//               if (getAmountOfNamesOrders(id)==1){
//
//
//                   if(isNameNull(id)){
//
//
//                   String sql = "  UPDATE goodsName SET presentationName=? where  goodsName.ordersId =?";
//
//
//
//                   PreparedStatement pstmt = connecttion.prepareStatement(sql);
//                   pstmt.setString(1, text); 
//                   pstmt.setInt(2, id);   
//
//                   pstmt.executeUpdate();
//
//                   }else{
//                   
//                        if(!isNameExist(id,text)){
//
//                           String sql = "INSERT INTO goodsName( presentationName,ordersId) VALUES(?,?)";
//
//                            PreparedStatement pstmt= connecttion.prepareStatement(sql);
//                            pstmt.setString(1, text);
//                            pstmt.setInt(2, id); 
//
//                            pstmt.executeUpdate();
//
//
//
//                        }
//                   
//                   }
//
//               }
//        }    
//
//    }
//    public Boolean isNameExist(Integer id, String text) throws SQLException{
//    
//        String sql = "SELECT * FROM goodsName AS g "
//             + "WHERE g.ordersId=?  AND  g.presentationName = ?";
//
//       
//            PreparedStatement pstmt  = connecttion.prepareStatement(sql);
//            
//           
//            pstmt.setInt(1,id);
//            pstmt.setString(2, text);
//  
//            
//            ResultSet rs  = pstmt.executeQuery();
//
//        if(rs.next()){
//            return Boolean.TRUE;
//            }
//        else{
//            return Boolean.FALSE;
//
//        }
//      
//    
//    }
//    public Integer getGoodsId(Integer leftOrderNum, Integer year) throws SQLException {
//       
//    String sql = "  select ordersId FROM orders  "
//             
//                + "  WHERE orderNumberInt=? and year=?";
//        
//          PreparedStatement pstmt= connecttion.prepareStatement(sql);
//          pstmt.setInt(1,leftOrderNum);
//          pstmt.setInt(2,year);
//      
//  
//       
//           ResultSet rs    = pstmt.executeQuery();
//            
//            while (rs.next()) {
//                    return  rs.getInt("ordersId");
//                                 
//            }
//        return null;
//      
//
//
//    }
//    private Integer getAmountOfNamesOrders(Integer id) throws SQLException {
//         String sql = "SELECT count(*) from goodsName where ordersId=?";
//
//       
//            PreparedStatement pstmt  = connecttion.prepareStatement(sql);
//            
//            pstmt.setInt(1,id);
//            
//            ResultSet rs  = pstmt.executeQuery();
//    
//        
//    
//            return rs.getInt(1);
//          
//            
//            
//    
//    }
//    private boolean isNameNull(Integer id) throws SQLException {
//
//            String sql = "SELECT *  FROM goodsName AS g WHERE g.ordersId=?  AND  g.presentationName is NULL";
//
//            PreparedStatement pstmt  = connecttion.prepareStatement(sql);
//
//            pstmt.setInt(1,id);
//
//
//            ResultSet rs  = pstmt.executeQuery();
//            
//
//            
//
//            if(rs.next()){
//                return Boolean.TRUE;
//                }
//            else{
//                return Boolean.FALSE;
//
//            }
//
//    
//    
//    }
//    public GoodsPojoCommunicator retrieveOpenOrders(GoodsPojoCommunicator gpc) throws SQLException {
//        String sql = "SELECT *  FROM orders as o INNER JOIN ordersCategory as c "
//                + "ON  o.ordersCategoryId=c.ordersCategoryId WHERE inArchiv=0 ORDER BY leftId ASC";
//
//            PreparedStatement pstmt  = connecttion.prepareStatement(sql);
//
//            ResultSet rs  = pstmt.executeQuery();
//
//
//            while(rs.next()){
//                
//                GoodsPojo gp= new GoodsPojo();
//                gp.setId(rs.getInt("ordersId"));
//                gp.setOrder(rs.getString("orderNumberText"));
//                gp.setProductNameCommon(rs.getString("commonName"));
//                gp.setAmountOfOrder(rs.getDouble("orderedAmount"));
//                gp.setLeftOrderNum(rs.getInt("orderNumberInt"));
//                gp.setYear(rs.getInt("year"));
//                gp.setPricePerUnit(rs.getDouble("price"));
//                gp.setRealCategory(rs.getString("name")  );
//                gp.setIsInArchiv(rs.getInt("inArchiv"));
//                gp.setPercentRemained(rs.getDouble("percent"));
//                gp.setEmittedAmountOfOrder(rs.getDouble("emitted"));
//                gp.setPricePerUnit(rs.getDouble("price"));
//                gp.setRemainAmountOfOrder(rs.getDouble("remained"));
//                gp.setCategoryId(rs.getInt("ordersCategoryId"));
//                
//
////                DecimalFormat formatter=new DecimalFormat("#,##0.00");
//                DecimalFormat formatter=new DecimalFormat("###,###,##0");
//                String stringRemain=formatter.format(rs.getDouble("remained"));
//                String stringAmount=formatter.format(rs.getDouble("orderedAmount"));
//                String stringEmitted=formatter.format(rs.getDouble("emitted"));
//                
//                gp.setAmountOfOrderString(stringAmount);
//                gp.setEmittedAmountOfOrderString(stringEmitted);
//                gp.setRemainAmountOfOrderString(stringRemain);
//
//                        
//                gpc.setPojo(gp);
//                }
//            
//            return gpc;
//    
//    }   
//    public Boolean isAmountNull(Integer id) throws SQLException{
//    
//            String sql = "SELECT * FROM orders as o WHERE o.ordersId=? and orderedAmount is Null ";
//            
//            PreparedStatement pstmt  = connecttion.prepareStatement(sql);
//            
//            pstmt.setInt(1,id);
//          
//            ResultSet rs  = pstmt.executeQuery();
//
//        if(rs.next()){
//            return Boolean.TRUE;
//            }
//        else{
//            return Boolean.FALSE;
//
//        }
//    
//    }
//    public void updateOrderAmountAndPrice(GoodsPojo next) throws SQLException {
//       
//        if (next.getProductNamePlan()!=null) {
//            
//            Integer id=getGoodsId(next.getLeftOrderNum(), next.getYear());
//            
//            if(isAmountNull(id)){
//
//                String sql = "UPDATE orders SET  orderedAmount = ?  WHERE ordersId= ?";
//               
//            
//                PreparedStatement pstmt = connecttion.prepareStatement(sql);
//
//
//                 pstmt.setDouble(1, next.getAmountOfOrder());
//                 pstmt.setInt(2, id);
//
//
//                 pstmt.executeUpdate();
//            
//            }
//            
//                   String sql = "  UPDATE orders SET emitted=?, remained=?, price=?, percent=? ,orderedAmount=?"
//                           + " where  orders.ordersId =?";
//
//                   PreparedStatement pstmt = connecttion.prepareStatement(sql);
//                   
//                   pstmt.setDouble(1, next.getEmittedAmountOfOrder()); 
//                   pstmt.setDouble(2, next.getRemainAmountOfOrder()); 
//                   pstmt.setDouble(3, next.getPricePerUnit()); 
//                   pstmt.setDouble(4, next.getPercentRemained()); 
//                   pstmt.setDouble(5, next.getAmountOfOrder()); 
//                   pstmt.setInt(6, id); 
//                   
//                   pstmt.executeUpdate();
//            System.out.println("hepo.model.dao.TnpDao.updateOrderAmountAndPrice()");
//            
//        }
//    
//    }  
//    public void setNameFromPlanToCommonName(GoodsPojo next) throws SQLException{
//        
//        if(next.getProductNamePlan()!=null){
//        
//            Integer id=getGoodsId(next.getLeftOrderNum(), next.getYear());
//            
//            if(isCommonNameNull(id)){
//
//                String sql = "UPDATE orders SET  commonName = ?   WHERE ordersId= ?";
//               
//            
//                PreparedStatement pstmt = connecttion.prepareStatement(sql);
//
//
//                 pstmt.setString(1, next.getProductNamePlan());
//                 pstmt.setInt(2, id);
//
//
//                 pstmt.executeUpdate();
//            
//            
//            }
//        
//        }
//    
//    }
//    private boolean isCommonNameNull(Integer id) throws SQLException {
//        
//         String sql = "SELECT * FROM orders as o WHERE o.ordersId=? and commonName is Null ";
//
//       
//            PreparedStatement pstmt  = connecttion.prepareStatement(sql);
//            
//           
//            pstmt.setInt(1,id);
//          
//            
//            ResultSet rs  = pstmt.executeQuery();
//
//        if(rs.next()){
//            return Boolean.TRUE;
//            }
//        else{
//            return Boolean.FALSE;
//
//        }
//    
//    }
//    public void setDataFromPlanToTempTable(GoodsPojo gp) throws SQLException {
//        
//    String sql = "INSERT INTO tempTablePlan("
//                  + "year,"
//                  + "orderNumberInt,"
//                  + "name"
//                  + ") VALUES(?,?,?)";
//
//            PreparedStatement pstmt= connecttion.prepareStatement(sql);
//            pstmt.setInt(1, gp.getYear());
//            pstmt.setInt(2, gp.getLeftOrderNum()); 
//            pstmt.setString(3, gp.getProductNamePlan());     
//  
//
//            pstmt.executeUpdate();
//    
//    
//    
//    }  
//    public void deleteAllFromPlanTempTable() throws SQLException {
//        
//    String sql = "delete from tempTablePlan";
//
//            PreparedStatement pstmt= connecttion.prepareStatement(sql);
//            pstmt.executeUpdate();
//    
//    
//    
//    }
//    public void retrieveDataFromTempTablePlanDeletedOrders(GoodsPojoCommunicator gpc) throws SQLException {
//         String sql = "select * from orders o LEFT JOIN tempTablePlan t"
//                 + " ON  t.orderNumberInt = o.orderNumberInt and   t.year =o.year "
//                 + "where  t.orderNumberInt is Null  and   t.year is Null  ";
//
//            PreparedStatement pstmt  = connecttion.prepareStatement(sql);
//
//            ResultSet rs  = pstmt.executeQuery();
//
//
//            while(rs.next()){
//                
//                GoodsPojo gp= new GoodsPojo();
//                gp.setOrder(rs.getString("orderNumberText"));
//                gp.setProductNameCommon(rs.getString("commonName"));
//                gp.setRealCategory(rs.getString("name")  );
//                
//
//                        
//                gpc.setPojo(gp);
//                }
//            
//           
//    
//    
//    } 
//    public void clearTempTablePlan() throws SQLException{
//    String sql = "delete from tempTablePlan";
//
//    Statement stmt=connecttion.createStatement();
//    stmt.execute(sql);
//    
//    
//    }
//    public void setClosed(Integer id) throws SQLException {
//           
//        String sql = "UPDATE orders SET  inArchiv = 1   WHERE ordersId= ?";
//               
//            System.err.println(id);
//                PreparedStatement pstmt = connecttion.prepareStatement(sql);
//
//                 pstmt.setInt(1, id);
//
//                 pstmt.executeUpdate();
//        
//    
//    }
//    public void deleteFromOpenOrders(GoodsPojo selectedePojo) throws SQLException {
//       
//        Integer id =getGoodsId(selectedePojo.getLeftOrderNum(),selectedePojo.getYear());
//        
//         String sql_1 = "delete from  goodsName where ordersId=? ";
//
//           PreparedStatement pstmt_1 = connecttion.prepareStatement(sql_1);
//
//                 pstmt_1.setInt(1, id);
//
//                 pstmt_1.executeUpdate();
//                 
//                 
//                 
//            
//         String sql_2 = "delete from  orders where ordersId=? ";
//
//           PreparedStatement pstmt_2 = connecttion.prepareStatement(sql_2);
//
//                 pstmt_2.setInt(1, id);
//
//                 pstmt_2.executeUpdate();
//
//    
//    }
//    public void retriveDataFromGoodsId(int id, GoodsPojo analyzed) throws SQLException {
//         String sql = "select * from orders o LEFT JOIN ordersCategory c ON  o.ordersCategoryId =c.ordersCategoryId where  o.ordersId =?";
//
//            PreparedStatement pstmt  = connecttion.prepareStatement(sql);
//     
//            pstmt.setInt(1, id);
//            
//            ResultSet rs  = pstmt.executeQuery();
//    
//            
//            while(rs.next()){
//                
//                analyzed.setProductNameCommon(rs.getString("commonName"));
//                analyzed.setRealCategory(rs.getString("name"));
//                analyzed.setPricePerUnit(rs.getDouble("price"));
//                analyzed.setAmountOfOrder(rs.getDouble("orderedAmount"));
//
// 
//                }
//    
//    
//    }
//    public void retrieveCategoryId(GoodsPojo concreteGoodsPojo) throws SQLException {
//      
//          String sql = "SELECT *  FROM orders as o INNER JOIN ordersCategory as c "
//                + "ON  o.ordersCategoryId=c.ordersCategoryId WHERE ordersId=?";
//
//            PreparedStatement pstmt  = connecttion.prepareStatement(sql);
//            
//            int id=getGoodsId(concreteGoodsPojo.getLeftOrderNum(),concreteGoodsPojo.getYear());
//            
//            pstmt.setInt(1, id);
//            
//            ResultSet rs  = pstmt.executeQuery();
//
//
//            while(rs.next()){
//
//                concreteGoodsPojo.setCategoryId(rs.getInt("ordersCategoryId"));
//
//                }
//            
//          
//    
//    }
//    public GoodsPojoCommunicator retrieveOpenOrdersLowPerCent(GoodsPojoCommunicator gpc) throws SQLException {
//        String sql = "SELECT *  FROM orders as o INNER JOIN ordersCategory as c "
//                + "ON  o.ordersCategoryId=c.ordersCategoryId WHERE inArchiv=0 and percent <20.0 ORDER BY leftId ASC";
//
//            PreparedStatement pstmt  = connecttion.prepareStatement(sql);
//
//            ResultSet rs  = pstmt.executeQuery();
//
//
//            while(rs.next()){
//                
//                GoodsPojo gp= new GoodsPojo();
//                gp.setOrder(rs.getString("orderNumberText"));
//                gp.setProductNameCommon(rs.getString("commonName"));
//                gp.setAmountOfOrder(rs.getDouble("orderedAmount"));
//                gp.setLeftOrderNum(rs.getInt("orderNumberInt"));
//                gp.setYear(rs.getInt("year"));
//                gp.setPricePerUnit(rs.getDouble("price"));
//                gp.setRealCategory(rs.getString("name")  );
//                gp.setIsInArchiv(rs.getInt("inArchiv"));
//                gp.setPercentRemained(rs.getDouble("percent"));
//                gp.setEmittedAmountOfOrder(rs.getDouble("emitted"));
//                gp.setPricePerUnit(rs.getDouble("price"));
//                gp.setRemainAmountOfOrder(rs.getDouble("remained"));
//                gp.setCategoryId(rs.getInt("ordersCategoryId"));
//                
//
////                DecimalFormat formatter=new DecimalFormat("#,##0.00");
//                DecimalFormat formatter=new DecimalFormat("###,###,##0");
//                String stringRemain=formatter.format(rs.getDouble("remained"));
//                String stringAmount=formatter.format(rs.getDouble("orderedAmount"));
//                String stringEmitted=formatter.format(rs.getDouble("emitted"));
//                
//                gp.setAmountOfOrderString(stringAmount);
//                gp.setEmittedAmountOfOrderString(stringEmitted);
//                gp.setRemainAmountOfOrderString(stringRemain);
//
//                        
//                gpc.setPojo(gp);
//                }
//            
//            return gpc;
//    }
//    public String getRandomProductName(GoodsPojo pojo) throws SQLException {
//        
//    
//         int id = getGoodsId(pojo.getLeftOrderNum(), pojo.getYear());
//                 
//                 
//          String sql = "SELECT presentationName  FROM goodsName WHERE ordersId=?";
//
//            PreparedStatement pstmt  = connecttion.prepareStatement(sql);
//            
//            pstmt.setInt(1, id);
//            
//            ResultSet rs  = pstmt.executeQuery();
//
//
//            while(rs.next()){
//
//                return rs.getString("presentationName");
//
//                }
//            
//            return null;
//    
//    }
//    public double getPricePerUnit() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//    public double getEmmited() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
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
//    
//        
//}
