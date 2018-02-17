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
public class DataMapperRealization extends DataSource{

    public DataMapperRealization() throws ClassNotFoundException, SQLException {
        
        new DbEmbeded();
    }
    
}
