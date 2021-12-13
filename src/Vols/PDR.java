/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vols;

import NOSQL.Connexion;
import Personnages.Personnel;
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
public class PDR {
    protected Personnel numCIN;
    protected Depart numD;

    public PDR(Personnel numCIN, Depart numD) {
        this.numCIN = numCIN;
        this.numD = numD;
    }
     public PDR(Personnel numCIN) {
        this.numCIN = numCIN;
    }
      public PDR(Depart numD) {
        this.numD = numD;
    }
   
     public boolean recherche(String collection) throws UnknownHostException
    {
        MongoClient mongoClient = new MongoClient();
        DB maBase = mongoClient.getDB("Airport");
        DBCollection passager = maBase.getCollection(collection);
        DBObject dbObject = passager.findOne(new BasicDBObject().append("numD",numD.getNum()).append("numCIN",numCIN.getCin()));
        return dbObject == null;
        
    }
      public boolean recherchePersonnel(String collection) throws UnknownHostException
    {
        MongoClient mongoClient = new MongoClient();
        DB maBase = mongoClient.getDB("Airport");
        DBCollection passager = maBase.getCollection(collection);
        DBObject dbObject = passager.findOne(new BasicDBObject().append("numCIN",numCIN.getCin()));
        return dbObject == null;        
    }
       public boolean rechercheDepart(String collection) throws UnknownHostException
    {
        MongoClient mongoClient = new MongoClient();
        DB maBase = mongoClient.getDB("Airport");
        DBCollection passager = maBase.getCollection(collection);
        DBObject dbObject = passager.findOne(new BasicDBObject().append("numD",numD.getNum()));
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
        passager.remove(new BasicDBObject().append("numD", numD.getNum()).append("numCIN",numCIN.getCin()));
        JOptionPane.showMessageDialog(null, "Relation Supprimer");
        }
    }
    public void supprimerDepart(String collection) throws UnknownHostException
    {
        if(rechercheDepart(collection))
            JOptionPane.showMessageDialog(null, "N'existe Pas");
        else 
        {
             MongoClient mongoClient = new MongoClient();
            DB maBase = mongoClient.getDB("Airport");
        DBCollection passager = maBase.getCollection(collection);
        passager.remove(new BasicDBObject().append("numD", numD.getNum()));
        JOptionPane.showMessageDialog(null, "Relation Supprimer");
        }
    }
    public void supprimerPersonnel(String collection) throws UnknownHostException
    {
        if(recherchePersonnel(collection))
            JOptionPane.showMessageDialog(null, "N'existe Pas");
        else 
        {
             MongoClient mongoClient = new MongoClient();
            DB maBase = mongoClient.getDB("Airport");
        DBCollection passager = maBase.getCollection(collection);
        passager.remove(new BasicDBObject().append("numCIN",numCIN.getCin()));
        JOptionPane.showMessageDialog(null, "Relation Supprimer");
        }
    }
    public void  ajouter(String collection) throws UnknownHostException
    {
        Connexion maBase = new Connexion("Airport");
        BasicDBObject passager = new BasicDBObject();
        passager.put("numD",numD.getNum());
         passager.put("numCIN",numCIN.getCin());         
        maBase.add(collection, passager);
    
    }
    

}
