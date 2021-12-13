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
public class Troncon {
    protected String num;
    protected String villeDepart;
    protected String villeArrive;

    public Troncon(String num, String villeDepart, String villeArrive) {
        this.num = num;
        this.villeDepart = villeDepart;
        this.villeArrive = villeArrive;
    }
    public Troncon(String num) {
        this.num = num;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getVilleDepart() {
        return villeDepart;
    }

    public void setVilleDepart(String villeDepart) {
        this.villeDepart = villeDepart;
    }

    public String getVilleArrive() {
        return villeArrive;
    }

    public void setVilleArrive(String villeArrive) {
        this.villeArrive = villeArrive;
    }
  


    
    
    public boolean recherche(String collection) throws UnknownHostException
    {
        MongoClient mongoClient = new MongoClient();
        DB maBase = mongoClient.getDB("Airport");
        DBCollection passager = maBase.getCollection(collection);
        DBObject dbObject = passager.findOne(new BasicDBObject().append("num",num));
        return dbObject == null;
        
    }
    public void supprimer(String collection) throws UnknownHostException
    {
        if(recherche(collection))
            JOptionPane.showMessageDialog(null, "N'existe Pas");
        else 
        {
             MongoClient mongoClient = new MongoClient();
            DB maBase = mongoClient.getDB("Airport");
        DBCollection passager = maBase.getCollection(collection);
        passager.remove(new BasicDBObject().append("num", num));
    }
    }
    public void  ajouter(String collection) throws UnknownHostException
    {
        Connexion maBase = new Connexion("Airport");
        BasicDBObject passager = new BasicDBObject();
         passager.put("num",num);
         passager.put("villeDepart",villeDepart);
         passager.put("villeArrive",villeArrive);
        maBase.add(collection, passager);
    
    }
}
