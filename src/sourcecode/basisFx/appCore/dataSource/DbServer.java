/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.dataSource;

import basisFx.domainModel.DbSchema;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Alek
 */
public class DbServer extends Db{
     
   protected Statement statement = null;

    public DbServer() throws ClassNotFoundException, SQLException {
    
        try {

            Class.forName("org.hsqldb.jdbc.JDBCDriver" );
            Db.connection= DriverManager.getConnection(
                    "jdbc:hsqldb:hsql://localhost/test", "SA", "");
            statement=this.connection.createStatement();
            statement.setQueryTimeout(30);

            System.out.println("Database connected!");



        } catch (Exception e) {

            System.err.println(" failed to load ");
            e.printStackTrace();
            return;
        
        }
        init();

     
    }

    private void init(){
        
        new DbSchema();
    
    }

}
