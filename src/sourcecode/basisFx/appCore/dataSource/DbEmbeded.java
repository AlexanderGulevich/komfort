package basisFx.appCore.dataSource;

import basisFx.domainModel.settings.Settings;
import java.sql.*;


public class DbEmbeded extends Db{
    
    private Statement statement = null;
    private Connection connection = null;
    

    public Connection getConnection() {
        return connection;
    }

    public DbEmbeded() throws ClassNotFoundException, SQLException {
          

 
        
        try {
                Class.forName("org.hsqldb.jdbc.JDBCDriver");
                this.connection = DriverManager.getConnection(
                        "jdbc:hsqldb:file:database/db", "SA", "");    
                statement=this.connection.createStatement();
                statement.setQueryTimeout(30);
                
                System.out.println("Соединение с базой данный осуществлено!");
        
        } catch (Exception e) {
                
                System.out.println("Сбой при подключении к БД!");
                System.err.println( e.getMessage());
               
            
        }
        
        init();

}
    
    private void init(){
        
//        
//        
//        String orders = "CREATE TABLE IF NOT EXISTS orders ( "
//                + "	ordersId integer PRIMARY KEY AUTOINCREMENT NOT NULL,  "
//                + "	commonName text,"
//                + "	orderNumberText integer   NOT NULL,  "
//                + "	orderNumberInt integer   NOT NULL,  "
//                + "	year integer   NOT NULL,  "
//                + "     orderedAmount REAL , "
//                + "     emitted REAL , "
//                + "     remained REAL , "
//                + "     price REAL , "
//                + "     percent REAL , "
//                + "     ordersCategoryId integer," 
//                + "     inArchiv integer NOT NULL," 
//                + "     FOREIGN KEY (ordersCategoryId)"
//                + "          REFERENCES ordersCategory(ordersCategoryId)"
//                + ")";
//        
//        String ordersCategory = "CREATE TABLE IF NOT EXISTS ordersCategory ( "
//                + "	ordersCategoryId integer PRIMARY KEY AUTOINCREMENT NOT NULL,  "
//                + "	leftId  integer  NOT NULL,  "
//                + "	rightId integer  NOT NULL,  "
//                + "	levelId integer  NOT NULL,  "
//                + "	name text NOT NULL  ,"    
//                + "	isExpanded integer NOT NULL,  "  
//                + "	shortName TEXT(20)  "     
//                + ")";
//        
//        String goodsNamesPresentation = "CREATE TABLE IF NOT EXISTS goodsName ( "
//                + "	presentationId integer PRIMARY KEY AUTOINCREMENT NOT NULL,  "
//                + "	presentationName text,  "
//                + "	ordersId integer  NOT NULL,  "
//                + "     FOREIGN KEY (ordersId)"
//                + "          REFERENCES orders(ordersId)"
//                + ")";
//          
    
//        try {
//            statement.execute(orders);
//
//        } catch (SQLException e) {
//            System.out.println("Не создалась таблица   orders");   
//        }
//        try {  
//            statement.execute(ordersCategory);
//            
//        } catch (SQLException e) {
//            System.out.println("Не создалась таблица   ordersCategory");
//        }
//        try {  
//            statement.execute(goodsNamesPresentation);
//            
//        } catch (SQLException e) {
//            System.out.println("Не создалась таблица   goodsNamesPresentation");
//        }
// 
   
        
 
    
     
        
        
    
    }


              
           


    
    
    
    
  
}

