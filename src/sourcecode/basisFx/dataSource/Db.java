/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.dataSource;

import org.hsqldb.Server;

import java.sql.Connection;

public abstract class Db {
   
    public static Connection connection = null;

    public static Server sonicServer = null;


}
