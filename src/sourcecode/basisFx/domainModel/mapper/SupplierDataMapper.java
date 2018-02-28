/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.domainModel.mapper;

import basisFx.appCore.dataSource.DataMapper;
import basisFx.appCore.dataSource.Db;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;

/**
 *
 * @author Alek
 */
public class SupplierDataMapper extends DataMapper{

    @Override
    public void insertDomainObject() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateDomainObject() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getAllDomainObjectList(ObservableList list) {
        
        try {
            ResultSet allDomainObjects = readAllDomainObjects();
            while (allDomainObjects.next()) {
        
                
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(SupplierDataMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
