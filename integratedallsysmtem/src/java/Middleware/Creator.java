/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Middleware;


/**
 *
 * @author Muaz Amir
 */

public class Creator {
    
    public User FactoryMethod(int accountType){
         
        if(accountType == 1){
            return new Alumni();
           
        }
        else {
            return new Admin();
           
        }
        
    }
    
}
