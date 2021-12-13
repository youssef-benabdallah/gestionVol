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
public class DAR {
   protected Depart numD;
    protected Avion numA;
    protected String qc;

    public DAR(Depart numD, Avion numA, String qc) {
        this.numD = numD;
        this.numA = numA;
        this.qc = qc;
    }
    public DAR(Depart numD, Avion numA) {
        this.numD = numD;
        this.numA = numA;
    }
    public DAR(Depart numD) {
        this.numD = numD;
    }
    public DAR(Avion numA) {
        this.numA = numA;
    }

   
   
     public boolean rechercheDepart(String collection) throws UnknownHostException
    {
        MongoClient mongoClient = new MongoClient();
        DB maBase = mongoClient.getDB("Airport");
        DBCollection passager = maBase.getCollection(collection);
        DBObject dbObject = passager.findOne(new BasicDBObject().append("numD",numD.getNum()));
        return dbObject == null;
        
    }
     public boolean rechercheAvion(String collection) throws UnknownHostException
    {
        MongoClient mongoClient = new MongoClient();
        DB maBase = mongoClient.getDB("Airport");
        DBCollection passager = maBase.getCollection(collection);
        DBObject dbObject = passager.findOne(new BasicDBObject().append("numA",numA.getNum()));
        return dbObject == null;
        
    }
      public boolean recherche(String collection) throws UnknownHostException
    {
        MongoClient mongoClient = new MongoClient();
        DB maBase = mongoClient.getDB("Airport");
        DBCollection passager = maBase.getCollection(collection);
        DBObject dbObject = passager.findOne(new BasicDBObject().append("numD", numD.getNum()).append("numA",numA.getNum()));
        return dbObject == null;
        
    }
     public void supprimer(String collection) throws UnknownHostException
    {
        if(recherche(collection))
          JOptionPane.showMessageDialog(null, "N'existe Pas");
        else 
        {   MongoClient mongoClient = new MongoClient();
            DB maBase = mongoClient.getDB("Airport");
        DBCollection passager = maBase.getCollection(collection);
        passager.remove(new BasicDBObject().append("numD", numD.getNum()).append("numA", numA.getNum()));
        }
    }
    public void supprimerAvion(String collection) throws UnknownHostException
    {
        if(rechercheAvion(collection))
            JOptionPane.showMessageDialog(null, "Avion N'existe Pas");
        else 
       {
             MongoClient mongoClient = new MongoClient();
            DB maBase = mongoClient.getDB("Airport");
        DBCollection passager = maBase.getCollection(collection);
        passager.remove(new BasicDBObject().append("numA", numA.getNum()));
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
        }
    }
    public void  ajouter(String collection) throws UnknownHostException
    {
        Connexion connexion = new Connexion("Airport");
        BasicDBObject object = new BasicDBObject();
        DBCursor listD = connexion.findListe("Depart",new BasicDBObject().append("num", numD.getNum()));
        DBCursor listA = connexion.findListe("Avion",new BasicDBObject().append("num", numA.getNum()));
        DBObject listd = listD.next();
        DBObject lista = listA.next();
         object.put("numD",numD.getNum());
         object.put("jour",listd.get("jour"));
         object.put("mois",listd.get("mois"));
         object.put("annee",listd.get("annee"));
         object.put("numA",numA.getNum());
         object.put("type",lista.get("type"));
         object.put("capacite",lista.get("capacite"));
         object.put("qc",qc);
         connexion.add(collection, object);
    
    }
    

}
