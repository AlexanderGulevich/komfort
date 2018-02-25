/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.domainModel.pojo;

/**
 *
 * @author Alek
 */
public class Jumbo  extends DomainObject{
    
    private final String tableName=null;

    public String getTableName() {
        return tableName;
    }

    @Override
    public boolean isReadyToTransaction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
