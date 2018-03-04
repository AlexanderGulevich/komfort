/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.controlPolicy;

/**
 *
 * @author Alek
 * @param <T>
 * @param <K>
 */
public class EditFabric<T,K> {
    public  EditCommitDefault<T,K> createEditCommitDefault (){
    
        return new EditCommitDefault<>();
    
    }
}
