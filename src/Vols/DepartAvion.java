/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vols;

/**
 *
 * @author Ben Abdallah Youssef
 */
public class DepartAvion {
    protected String quantiteCarburant;

    public DepartAvion(String quantiteCarburant) {
        this.quantiteCarburant = quantiteCarburant;
    }

    public String getQuantiteCarburant() {
        return quantiteCarburant;
    }

    public void setQuantiteCarburant(String quantiteCarburant) {
        this.quantiteCarburant = quantiteCarburant;
    }
    
}
