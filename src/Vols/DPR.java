/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vols;

import NOSQL.Connexion;
import Personnages.Passager;
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
public class DPR {
    protected Passager numCIN;
    protected Depart numD;
    protected String type;

    public DPR(Passager numCIN, Depart numD) {
        this.numCIN = numCIN;
        this.numD = numD;
    }
    public DPR(Depart numD,Passager numCIN, String type) {
        this.numD = numD;  
        this.numCIN = numCIN;              
        this.type = type;
    }
     public DPR(Depart numD,String type) {
        this.numD = numD;            
        this.type = type;
    }
    public DPR(Passager numCIN) {
        this.numCIN = numCIN;
    }
    public DPR(Depart numD) {
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
     public boolean rechercheType(String collection) throws UnknownHostException
    {
        MongoClient mongoClient = new MongoClient();
        DB maBase = mongoClient.getDB("Airport");
        DBCollection passager = maBase.getCollection(collection);
        DBObject dbObject = passager.findOne(new BasicDBObject().append("numD",numD.getNum()).append("type",type).append("numCIN",numCIN.getCin()));
        return dbObject == null;
        
    }
     public boolean recherchePassager(String collection) throws UnknownHostException
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
        passager.remove(new BasicDBObject().append("numD", numD.getNum()).append("numCIN", numCIN.getCin()).append("type", type));
        }
    }
    public void supprimerPassager(String collection, String type) throws UnknownHostException
    {
        if(recherchePassager(collection))
            JOptionPane.showMessageDialog(null, "N'existe Pas");
        else 
        {
             MongoClient mongoClient = new MongoClient();
            DB maBase = mongoClient.getDB("Airport");
        DBCollection passager = maBase.getCollection(collection);
        passager.remove(new BasicDBObject().append("numCIN", numCIN.getCin()).append("type", type));
        }
    }
    
     public void supprimerDepart(String collection) throws UnknownHostException
    {
             MongoClient mongoClient = new MongoClient();
            DB maBase = mongoClient.getDB("Airport");
        DBCollection passager = maBase.getCollection(collection);
        passager.remove(new BasicDBObject().append("numD", numD.getNum()).append("type", type));
    }
    
    public void  ajouter(String collection, String Type) throws UnknownHostException
    {
        Connexion connexion = new Connexion("Airport");
        BasicDBObject object = new BasicDBObject();                
        DBCursor listD = connexion.findListe("Depart",new BasicDBObject().append("num", numD.getNum()));
        DBCursor listA = connexion.findListe(Type,new BasicDBObject().append("cin", numCIN.getCin()));
        DBObject listd = listD.next();
        DBObject lista = listA.next();
         object.put("numD",numD.getNum());
         object.put("jour",listd.get("jour"));
         object.put("mois",listd.get("mois"));
         object.put("annee",listd.get("annee"));
         object.put("type",Type);
         object.put("numCIN",numCIN.getCin());
         object.put("nom",lista.get("nom"));
         object.put("prenom",lista.get("prenom"));
         object.put("adresse",lista.get("adresse"));         
         object.put("numTel",lista.get("numTel"));
        connexion.add(collection, object);
    
    }
    

}
