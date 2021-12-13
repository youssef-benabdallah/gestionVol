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
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ben Abdallah Youssef
 */
public class VDR {
    protected Vol numV;
    protected Depart numD;

    public VDR(Vol numV, Depart numD) {
        this.numV = numV;
        this.numD = numD;
    }
    public VDR(Vol numV) {
        this.numV = numV;
    }
    public VDR(Depart numD) {
        this.numD = numD;
    }
   
     public boolean recherche(String collection) throws UnknownHostException
    {
        MongoClient mongoClient = new MongoClient();
        DB maBase = mongoClient.getDB("Airport");
        DBCollection passager = maBase.getCollection(collection);
        DBObject dbObject = passager.findOne(new BasicDBObject().append("numV",numV.getNum()).append("numD",numD.getNum()));
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
       public boolean rechercheVol(String collection) throws UnknownHostException
    {
        MongoClient mongoClient = new MongoClient();
        DB maBase = mongoClient.getDB("Airport");
        DBCollection passager = maBase.getCollection(collection);
        DBObject dbObject = passager.findOne(new BasicDBObject().append("numV",numV.getNum()));
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
        passager.remove(new BasicDBObject().append("numV",numV.getNum()).append("numD", numD.getNum()));
        JOptionPane.showMessageDialog(null, "Relation Supprimer");
        }
    }
    public void supprimerDepart(String collection) throws UnknownHostException
    {
             MongoClient mongoClient = new MongoClient();
            DB maBase = mongoClient.getDB("Airport");
        DBCollection passager = maBase.getCollection(collection);
        passager.remove(new BasicDBObject().append("numD", numD.getNum()));
       
    }
     public void supprimerVol(String collection) throws UnknownHostException
    {
        if(rechercheVol(collection))
            JOptionPane.showMessageDialog(null, "N'existe Pas");
        else 
        {
             MongoClient mongoClient = new MongoClient();
            DB maBase = mongoClient.getDB("Airport");
        DBCollection passager = maBase.getCollection(collection);
        passager.remove(new BasicDBObject().append("numV",numV.getNum()));
        JOptionPane.showMessageDialog(null, "Relation Supprimer");
        }
    }
    public void  ajouter(String collection) throws UnknownHostException
    {
        Connexion connexion = new Connexion("Airport");
        BasicDBObject object = new BasicDBObject();                
        DBCursor listD = connexion.findListe("Depart",new BasicDBObject().append("num", numD.getNum()));
        DBCursor listA = connexion.findListe("Vol",new BasicDBObject().append("num", numV.getNum()));
        DBObject listd = listD.next();
        DBObject lista = listA.next();
         object.put("numV",numV.getNum());
         object.put("distance",lista.get("distance"));
         object.put("frequence",lista.get("frequence"));
         object.put("numD",numD.getNum());
         object.put("jour",listd.get("jour"));
         object.put("mois",listd.get("mois"));
         object.put("annee",listd.get("annee"));         
        connexion.add(collection, object);
    
    
    }
    

}
