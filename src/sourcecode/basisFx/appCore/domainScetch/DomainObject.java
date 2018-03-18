/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.domainScetch;

import basisFx.appCore.dataSource.DataMapper;
import basisFx.domainModel.DataMapperFabric;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 *
 * @author 62
 */
public abstract class DomainObject {
    
    protected DataMapper dataMapper;
    protected String tableName;
    protected DataMapperFabric mapperFabric=new DataMapperFabric();

    private ObjectProperty<Integer> id =new SimpleObjectProperty<>(this, "id", null);
//    private  IntegerProperty id =new SimpleIntegerProperty(this, "id", 0);

    public abstract boolean isReadyToTransaction();

    public Integer getId() {
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


    
}
