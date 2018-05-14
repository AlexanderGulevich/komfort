/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.interfaces;

import basisFx.appCore.domainScetch.DomainObject;

/**
 *
 * @author Alek
 * @param <T>
 * @param <K>
 */
@FunctionalInterface
public interface DomainChanging{
 public  void change(DomainObject d, Object val);
}
