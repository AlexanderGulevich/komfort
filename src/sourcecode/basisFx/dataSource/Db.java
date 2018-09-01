/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.dataSource;

import org.hsqldb.Server;

import java.sql.Connection;

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
