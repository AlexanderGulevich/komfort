/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.dataSource;

import basisFx.appCore.settings.Settings;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.hsqldb.persist.HsqlProperties;

/**
 *
 * @author Alek
 */
public class DbServer extends Db{

    protected Statement statement = null;



    public DbServer() throws ClassNotFoundException, SQLException {

        HsqlProperties props = new HsqlProperties();

        props.setProperty("server.database.0", "file:" + Settings.DB_SERVER_PATH + "komdb;");

        props.setProperty("server.dbname.0", "db");


        sonicServer = new org.hsqldb.Server();
       
        try {
            sonicServer.setProperties(props);
        } catch (Exception e) {
            return;
        }
        
        try {
               sonicServer.start();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
     
        
//           sonicServer.shutdown();


        
        
        
        try {

            Class.forName("org.hsqldb.jdbc.JDBCDriver" );
            Db.connection= DriverManager.getConnection(
//                    "jdbc:hsqldb:hsql://localhost:9001/", "SA", "");
                    "jdbc:hsqldb:hsql://localhost/db", "SA", "");
            statement=this.connection.createStatement();
            statement.setQueryTimeout(30);

            System.out.println("Database connected!");



        } catch (Exception e) {

            System.err.println(" failed to loadStylesToScene ");
            e.printStackTrace();
            return;
        
        }
        init();

     
    }




    private void init(){
        
        new DbSchema();
    
    }

}
