package basisFx.domainModel.pojo;

import basisFx.appCore.domainScetch.StringValueDomainObject;

/**
 * Created by AlexanderGulevich on 11.03.2018.
 *
 * @autor AlexanderGulevich
 */
public class Currency extends StringValueDomainObject {


    public Currency() {
        dataMapper=mapperFabric.getCurrencyDataMapper();
        tableName="Currency";
    }



}
