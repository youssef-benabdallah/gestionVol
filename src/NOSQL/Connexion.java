/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NOSQL;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import java.net.UnknownHostException;
/**
 *
 * @author Ben Abdallah Youssef
 */
public class Connexion {

    private MongoClient client ; 
    private DB dataBase ; 
 
    public Connexion(String DBname) throws UnknownHostException
    {
        client = new MongoClient(); 
        dataBase = client.getDB(DBname); 
    }
   public void add(String collectionName , BasicDBObject object)
    {
        DBCollection collection = dataBase.getCollection(collectionName);
        collection.insert( object);
    }
    public void delete(String collectionName , BasicDBObject object)
    {
             DBCollection collection = dataBase.getCollection(collectionName);
             collection.remove(object);
    }
     public DBCursor getListe(String collectionName)
    {
       DBCollection collection = dataBase.getCollection(collectionName);
       return collection.find();
    }

     public boolean search(String collectionName,BasicDBObject object) throws UnknownHostException
    {
        DBCollection collection = dataBase.getCollection(collectionName);
        DBObject dbObject = collection.findOne(object);
        return dbObject == null;        
    }
     
    public DBCursor findListe(String collectionName , BasicDBObject object)
    {
        DBCollection coll = dataBase.getCollection(collectionName);
        return coll.find(object);
    }
    
//    public Object[][] findListe(String collectionName, BasicDBObject object, String ch)
//    {
//         Vector <DBObject> find = new Vector();
//         DBCollection collection = dataBase.getCollection(collectionName);
//         DBCursor all =collection.find();
//         while(all.hasNext())
//         {
//         DBObject list = all.next();
//         if(list.get(ch).toString().startsWith(object.get(ch).toString().toUpperCase()))
//         find = find.    
//                 }
//        object.getString(ch).startsWith(collectionName);
//        DBCollection coll = dataBase.getCollection(collectionName);
//        return coll.find( object);
//    }
//        
}