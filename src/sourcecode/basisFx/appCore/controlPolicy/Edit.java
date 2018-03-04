/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.controlPolicy;

import basisFx.appCore.dataSource.UnitOfWork;
import basisFx.appCore.elements.TableViewWrapper;
import basisFx.domainModel.pojo.Equipment;
import javafx.scene.control.TableColumn;

/**
 *
 * @author Alek
 */
public class Edit<T,K> {
    
    protected TableColumn<T,K> column;
    protected UnitOfWork unitOfWork;
    protected PojoChanging <T,K>pojoChanging;
    protected TableViewWrapper tvw;

    public void setTvw(TableViewWrapper tvw) {
        this.tvw = tvw;
    }

    public void setColumn(TableColumn<T, K> column) {
        this.column = column;
    }

    public void setUnitOfWork(UnitOfWork unitOfWork) {
        this.unitOfWork = unitOfWork;
    }

    public void setPojoChanging(PojoChanging<T, K> pojoChanging) {
        this.pojoChanging = pojoChanging;
    }

    public void run() {}
    
    
}
