/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.controlPolicy;

import basisFx.domainModel.pojo.DomainObject;

/**
 *
 * @author Alek
 */
public interface DomainChange<T,K> {
 public <T,K> void add(T d, K val);
}
