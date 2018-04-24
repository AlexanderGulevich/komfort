package basisFx.appCore.functional;

import basisFx.appCore.domainScetch.DomainObject;

public interface ValueAddToDomain<T> {

    public void  add(DomainObject domainObject, T value);

}
