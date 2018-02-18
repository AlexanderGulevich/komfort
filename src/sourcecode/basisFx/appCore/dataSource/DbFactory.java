/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.dataSource;

import java.sql.SQLException;

/**
 *
 * @author Alek
 */
public class DbFactory {
    
    public DbEmbeded createEmbeded() throws ClassNotFoundException, SQLException{
    
        return new DbEmbeded();
    
    }
    
  
    
}
