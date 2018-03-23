/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.dataSource;

import org.hsqldb.Server;

import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author Alek
 */
public abstract class Db {
   
    protected static Connection connection = null;

    protected static Server sonicServer = null;
    

    public static Connection getConnection() {
        return connection;
    }

    public static Server getSonicServer() {
        return sonicServer;
    }
}
