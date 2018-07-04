/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.fabrics;

import basisFx.appCore.dataSource.DbEmbeded;
import basisFx.appCore.dataSource.DbServer;

import java.sql.SQLException;

/**
 *
 * @author Alek
 */
public class DbFactory {
    
    public static DbEmbeded createEmbeded() throws ClassNotFoundException, SQLException{
    
        return new DbEmbeded();
    
    }
    public static DbServer createDbServer() throws ClassNotFoundException, SQLException{
    
        return new DbServer();
    
    }
    
  
    
}
