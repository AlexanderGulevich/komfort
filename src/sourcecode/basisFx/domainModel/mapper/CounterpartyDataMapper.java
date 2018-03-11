package basisFx.domainModel.mapper;

import basisFx.appCore.dataSource.DataMapper;
import basisFx.domainModel.pojo.Counterparty;
import basisFx.domainModel.pojo.Country;
import basisFx.domainModel.pojo.Currency;
import basisFx.domainModel.pojo.DomainObject;
import javafx.collections.ObservableList;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by AlexanderGulevich on 11.03.2018.
 *
 * @autor AlexanderGulevich
 */
public class CounterpartyDataMapper extends DataMapper {

    private static Map<Integer,Currency> currencyMap= new HashMap<>();

    private Counterparty domainObject;

    private static CounterpartyDataMapper ourInstance = new CounterpartyDataMapper();

    public static CounterpartyDataMapper getInstance() {
        return ourInstance;
    }

    private CounterpartyDataMapper() {
    }



    @Override
    public void getAllDomainObjectList(ObservableList list, String tableName) {

    }

    @Override
    public void updateDomainObject(DomainObject d) {

    }

    @Override
    public void insertDomainObject(DomainObject d) {

    }
}
