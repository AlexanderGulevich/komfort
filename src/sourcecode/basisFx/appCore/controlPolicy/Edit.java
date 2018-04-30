/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.controlPolicy;

import basisFx.appCore.dataSource.UnitOfWork;
import basisFx.appCore.elements.TableWrapper;
import basisFx.appCore.interfaces.DomainChanging;
import javafx.scene.control.TableColumn;

/**
 *
 * @author Alek
 */
public class Edit<T,K> {
    
    protected TableColumn<T,K> column;
    protected UnitOfWork unitOfWork;
    protected DomainChanging<T,K> domainChanging;
    protected TableWrapper tvw;
    protected KindOfColumn kindOfColumn;

    public void setTvw(TableWrapper tvw) {
        this.tvw = tvw;
    }

    public void setColumn(TableColumn<T, K> column) {
        this.column = column;
    }

    public void setUnitOfWork(UnitOfWork unitOfWork) {
        this.unitOfWork = unitOfWork;
    }

    public void setDomainChanging(DomainChanging<T, K> domainChanging) {
        this.domainChanging = domainChanging;
    }

    public void run() {}

    public void setKindOfColumn(KindOfColumn kindOfColumn) {
        this.kindOfColumn = kindOfColumn;
    }
}
