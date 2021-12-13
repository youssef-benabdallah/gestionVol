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
public class Depart {
    protected String num;

    /**
     *
     */
    protected Date date;

    public Depart(String num, Date date) {
        this.num = num;
        this.date = date;
    }
    
     public Depart(String num) {
        this.num = num;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
        BasicDBObject depart = new BasicDBObject();
         depart.put("num",num);
         depart.put("jour",date.getJour());
         depart.put("mois",date.getMois());
         depart.put("annee",date.getAnnee());
        maBase.add(collection, depart);
    
    }
}
