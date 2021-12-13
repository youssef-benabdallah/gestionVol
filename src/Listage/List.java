/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listage;

import com.mongodb.DBCursor;
import com.mongodb.DBObject;

/**
 *
 * @author Ben Abdallah Youssef
 */
public class List {
    String list[];
    
    public List(int l)
    {
    this.list = new String[l];
    }
    
    public String[] remplirByNum(DBCursor listAvion)
    { int i=-1;
        while(listAvion.hasNext()){
            i++;            
           DBObject object = listAvion.next();
           list[i]=object.get("num").toString();
        }
        return list;
    }
    
     public String[] remplirPersonne(DBCursor listAvion)
    { int i=-1;
        while(listAvion.hasNext()){
            i++;            
           DBObject object = listAvion.next();
           list[i]=object.get("cin").toString();
        }
        return list;
    }
    
    
}
