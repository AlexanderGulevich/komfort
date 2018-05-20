package basisFx.domainModel.mapper;

import basisFx.appCore.dataSource.DataMapper;
import basisFx.appCore.domainScetch.DomainObject;
import javafx.collections.ObservableList;

public class EmployeesFiredMapper  extends DataMapper {

    private static EmployeesFiredMapper ourInstance = new EmployeesFiredMapper();

    public static EmployeesFiredMapper getInstance() {
        return ourInstance;
    }


    @Override
    public boolean isReadyToTransaction(DomainObject d) {
        return false;
    }

    @Override
    public void getDomainList(ObservableList list)   {

    }

    @Override
    public void getDomainListForObserverTables(ObservableList list, DomainObject selectedDomainObject)   {

    }

    @Override
    public void updateDomainObject(DomainObject d)   {

    }

    @Override
    public void deleteDomainObject(DomainObject d)   {

    }

    @Override
    public void insertDomainObject(DomainObject d)   {

    }
}
