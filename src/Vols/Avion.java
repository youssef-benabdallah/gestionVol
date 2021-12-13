/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vols;

import NOSQL.Connexion;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ben Abdallah Youssef
 */
public class Avion {
    protected String num;
    protected String type;
    protected String capacite;

    public Avion(String num, String type, String capacite) {
        this.num = num;
        this.type = type;
        this.capacite = capacite;
    }
    public Avion(String num) {
        this.num = num;
      
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCapacite() {
        return capacite;
    }

    public void setCapacite(String capacite) {
        this.capacite = capacite;
    }
    
    
     public boolean recherche(String collection) throws UnknownHostException
    {
        Connexion maBase = new Connexion("Airport");       
        return maBase.search(collection, new BasicDBObject().append("num",num));
        
    }
    public void supprimer(String collection) throws UnknownHostException
    {       
             Connexion maBase = new Connexion("Airport");            
             maBase.delete(collection, new  BasicDBObject().append("num", num));
    }
    public void  ajouter(String collection) throws UnknownHostException
    {
        Connexion maBase = new Connexion("Airport");        
        BasicDBObject avion = new BasicDBObject();
         avion.put("num",num);
         avion.put("type",type);
         avion.put("capacite",capacite);
        maBase.add(collection, avion);
    
    }
    
}
