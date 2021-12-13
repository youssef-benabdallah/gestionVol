/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personnages;

/**
 *
 * @author Ben Abdallah Youssef
 */
public class NonNavigant extends Personnel{
    public NonNavigant(String cin,String nom, String prenom, String adresse, String numTel) {
        super(cin,nom, prenom, adresse, numTel);
    }
     
     public NonNavigant(String cin) {
         super(cin);
    }
}
