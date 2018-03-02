/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.domainModel.pojo;

import basisFx.appCore.dataSource.DataMapper;
import basisFx.domainModel.DataMapperFabric;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 *
 * @author 62
 */
public abstract class DomainObject {
    
    protected DataMapper dataMapper;
    protected String tableName;
    protected DataMapperFabric mapperFabric=new DataMapperFabric();
    
    private  IntegerProperty id =new SimpleIntegerProperty(this, "id", 0);

    public int getId() {
            return id.get();
        }
    public void setId(int value) {
        this.id.set(value);
    }

    public DataMapper getDataMapper() {
        return dataMapper;
    }
     public String getTableName() {
        
        return tableName;
    }
    public abstract boolean isReadyToTransaction();
    
    
}
