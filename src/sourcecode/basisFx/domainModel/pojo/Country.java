package basisFx.domainModel.pojo;


import basisFx.appCore.domainScetch.NamedDomainObject;

/**
 * Created by AlexanderGulevich on 11.03.2018.
 *
 * @autor AlexanderGulevich
 */
public class Country extends NamedDomainObject {


    public Country() {
        this.dataMapper=mapperFabric.getNamedDataMapper();
        this.tableName="Country";
    }





}
