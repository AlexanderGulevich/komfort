/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.functional;

/**
 *
 * @author Alek
 * @param <T>
 * @param <K>
 */
@FunctionalInterface
public interface DomainChanging<T,K>{
 public <T,K> void change(T d, K val);
}
