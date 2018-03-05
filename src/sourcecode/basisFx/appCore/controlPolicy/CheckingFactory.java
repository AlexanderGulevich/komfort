/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.appCore.controlPolicy;

/**
 *
 * @author Alek
 */
public class CheckingFactory <T> {
   
    public CheckingForNumeric  <T> createNumCheck(){
    
        return new CheckingForNumeric<>();
        
    }

    public CheckingForText  <T> createTextCheck(){
    
        return new CheckingForText<>();
        
    }
}