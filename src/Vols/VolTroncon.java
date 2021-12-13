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
public class VolTroncon {
    protected String heureDepart;
     protected String heureArrive;

    public VolTroncon(String heureDepart, String heureArrive) {
        this.heureDepart = heureDepart;
        this.heureArrive = heureArrive;
    }

    public String getHeureDepart() {
        return heureDepart;
    }

    public void setHeureDepart(String heureDepart) {
        this.heureDepart = heureDepart;
    }

    public String getHeureArrive() {
        return heureArrive;
    }

    public void setHeureArrive(String heureArrive) {
        this.heureArrive = heureArrive;
    }

    
}
