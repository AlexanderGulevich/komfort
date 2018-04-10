package basisFx.domainModel.pojo;


import basisFx.appCore.domainScetch.StringValueDomainObject;

/**
 * Created by AlexanderGulevich on 11.03.2018.
 *
 * @autor AlexanderGulevich
 */
public class Country extends StringValueDomainObject {


    public Country() {
        this.dataMapper=mapperFabric.getCountryDataMapper();
        this.tableName="Country";
    }





}
