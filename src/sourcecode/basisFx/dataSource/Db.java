/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.dataSource;

import org.hsqldb.Server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class Db {


   
    public static Connection connection = null;

    public static Server sonicServer = null;


    public Connection getConnection() {
        return newConnection();
    }
    public static void fullClose() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sonicServer.shutdown();
    }

    public abstract Connection newConnection() ;






}
