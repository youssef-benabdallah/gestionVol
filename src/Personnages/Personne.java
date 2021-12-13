package Personnages;


import NOSQL.Connexion;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ben Abdallah Youssef
 */
public class Personne {
    protected String cin;
    protected String nom;
    protected String prenom;
    protected String adresse;
    protected String numTel;
    
    Personne(String cin,String nom, String prenom, String adresse,String numTel)
    {   this.cin = cin;
        this.nom=nom;
        this.prenom=prenom;
        this.adresse=adresse;
        this.numTel=numTel;
        
    }
    Personne(String cin)
    {
        this.cin = cin;
    }

    

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }
    
     public boolean recherche(String collection) throws UnknownHostException
    {
        MongoClient mongoClient = new MongoClient();
        DB maBase = mongoClient.getDB("Airport");
        DBCollection passager = maBase.getCollection(collection);
        DBObject dbObject = passager.findOne(new BasicDBObject().append("cin",cin));
        return dbObject == null;
        
    }
    public void supprimer(String collection) throws UnknownHostException
    {
        if(recherche(collection))
            JOptionPane.showMessageDialog(null, "*****  N'existe Pas  *****");
        else 
        {
             MongoClient mongoClient = new MongoClient();
            DB maBase = mongoClient.getDB("Airport");
        DBCollection passager = maBase.getCollection(collection);
        passager.remove(new BasicDBObject().append("cin", cin));
    }
    }
    public void  ajouter(String collection) throws UnknownHostException
    {
         Connexion maBase = new Connexion("Airport");
         BasicDBObject passager = new BasicDBObject();
         passager.put("cin",cin);
         passager.put("nom",nom);
         passager.put("prenom",prenom);
         passager.put("adresse",adresse);
         passager.put("numTel",numTel);
         maBase.add(collection, passager);
    }    
}
