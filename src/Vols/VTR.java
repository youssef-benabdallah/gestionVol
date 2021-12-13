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
public class VTR {
    protected Vol numV;
    protected Troncon numT;
    protected VolTroncon VT;

    public VTR(Vol numV, Troncon numT,VolTroncon VT) {
        this.numV = numV;
        this.numT = numT;
        this.VT = VT;
    }

   public VTR(Vol numV, Troncon numT) {
        this.numV = numV;
        this.numT = numT;
    }
   public VTR(Vol numV) {
        this.numV = numV;
    }
   public VTR(Troncon numT) {
        this.numT = numT;
    }

    
     public boolean recherche(String collection) throws UnknownHostException
    {
        MongoClient mongoClient = new MongoClient();
        DB maBase = mongoClient.getDB("Airport");
        DBCollection passager = maBase.getCollection(collection);
        DBObject dbObject = passager.findOne(new BasicDBObject().append("numV",numV.getNum()).append("numT",numT.getNum()));        
        return dbObject == null;        
    }
//      public boolean rechercheVol(String collection) throws UnknownHostException
//    {
//        
//        MongoClient mongoClient = new MongoClient();
//        DB maBase = mongoClient.getDB("Airport");
//        DBCollection passager = maBase.getCollection(collection);
//        DBObject dbObject = passager.findOne(new BasicDBObject().append("numV",numV.getNum()));
//        return dbObject == null;
//        
//    }
//       public boolean rechercheTroncon(String collection) throws UnknownHostException
//    {
//        MongoClient mongoClient = new MongoClient();
//        DB maBase = mongoClient.getDB("Airport");
//        DBCollection passager = maBase.getCollection(collection);
//        DBObject dbObject = passager.findOne(new BasicDBObject().append("numT1",numT1.getNum()));
//        if(dbObject!=null) return false;
//        dbObject = passager.findOne(new BasicDBObject().append("numT2",numT1.getNum()));
//        if(dbObject!=null) return false;
//        dbObject = passager.findOne(new BasicDBObject().append("numT2",numT1.getNum()));
//        if(dbObject!=null) return false;
//        dbObject = passager.findOne(new BasicDBObject().append("numT2",numT1.getNum()));
//        return dbObject == null;
//        
//    }
    public void supprimer(String collection) throws UnknownHostException
    {
        MongoClient mongoClient = new MongoClient();
        DB maBase = mongoClient.getDB("Airport");
        DBCollection passager = maBase.getCollection(collection);
        passager.remove(new BasicDBObject().append("numV", numV.getNum()).append("numT", numT.getNum()));
                
    }

    public void supprimerVol(String collection) throws UnknownHostException
    {
             MongoClient mongoClient = new MongoClient();
            DB maBase = mongoClient.getDB("Airport");
        DBCollection passager = maBase.getCollection(collection);
        passager.remove(new BasicDBObject().append("numV", numV.getNum()));
       
    }
    public void supprimerTroncon(String collection) throws UnknownHostException
    {   
        MongoClient mongoClient = new MongoClient();
        DB maBase = mongoClient.getDB("Airport");
        DBCollection passager = maBase.getCollection(collection);
        passager.remove(new BasicDBObject().append("numT", numT.getNum()));
    }
    public void  ajouter(String collection) throws UnknownHostException
    {
        Connexion connexion = new Connexion("Airport");
        BasicDBObject object = new BasicDBObject();                
        
        
        DBCursor listD = connexion.findListe("Vol",new BasicDBObject().append("num", numV.getNum()));        
        DBObject listd = listD.next();
         object.put("numV",numV.getNum());
         object.put("distance",listd.get("distance"));
         object.put("frequence",listd.get("frequence"));
         DBCursor list = connexion.findListe(collection,object);
         object.put("numero",String.valueOf(list.count()+1));
         DBCursor listT1 = connexion.findListe("Troncon",new BasicDBObject().append("num", numT.getNum()));
         DBObject listt1 = listT1.next();
         object.put("numT",numT.getNum());
         object.put("villeDepart",listt1.get("villeDepart").toString().toUpperCase());
         object.put("villeArrive",listt1.get("villeArrive").toString().toUpperCase());
         object.put("heureD",VT.getHeureDepart());
         object.put("heureA",VT.getHeureArrive());
         
         
        
       connexion.add(collection, object);
        
    }
}
