package basisFx.domainModel.pojo;

import basisFx.appCore.domainScetch.DomainObject;

/**
 *
 * Created by AlexanderGulevich on 11.03.2018.
 *
 */
public class Employees extends DomainObject {






    @Override
    public boolean isReadyToTransaction() {
        return false;
    }


}
