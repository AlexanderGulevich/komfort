package basisFx.appCore;

import basisFx.appCore.domainScetch.DomainObject;

public interface ValueAddToDomain<T> {

    public void  add(DomainObject domainObject, T value);

}
