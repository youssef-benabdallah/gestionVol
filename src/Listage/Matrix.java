package Listage;


import com.mongodb.DBCursor;
import com.mongodb.DBObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ben Abdallah Youssef
 */
public class Matrix {
    public Object[][] MyArray;
    int longueur;
    public Matrix(int ligne, int colonne) {
        MyArray = new Object[ligne][colonne];
        longueur=0;
    }
    
    public Object[][] remplirAvion(DBCursor list)
    {
        int i=-1;
          while (list.hasNext()) {
			DBObject object = list.next();
                        i++;                                             
                        MyArray[i][0]= object.get("num").toString().toUpperCase();
                        MyArray[i][1]= object.get("type").toString().toUpperCase();
                        MyArray[i][2]= object.get("capacite").toString().toUpperCase();                           
		}       
          list.close();
          return MyArray;
    }
     public Object[][] remplirDepart(DBCursor list)
    {
        int i=-1;
          while (list.hasNext()) {
			DBObject object = list.next();
                        i++;                                             
                        MyArray[i][0]= object.get("num").toString().toUpperCase();
                        MyArray[i][1]= object.get("jour").toString()+"/"
                                +object.get("mois").toString()+"/"
                                +object.get("annee").toString();
          }
          list.close();
          return MyArray;
    }
     
     public Object[][] remplirPersonne(DBCursor list)
    {
        int i=-1;
          while (list.hasNext()) {
			DBObject object = list.next();
                        i++;                                             
                        MyArray[i][0]= object.get("cin");
                        MyArray[i][1]= object.get("nom").toString().toUpperCase();
                        MyArray[i][2]= object.get("prenom").toString().toUpperCase();                           
                        MyArray[i][3]= object.get("adresse").toString().toUpperCase();
                        MyArray[i][4]= object.get("numTel");
		}       
          list.close();
          return MyArray;
    }
     
     public Object[][] remplirPersonne(DBCursor list,String collection)
    {
        int i=-1;
          while (list.hasNext()) {
			DBObject object = list.next();
                        i++;                                             
                        MyArray[i][0]= (collection);
                        MyArray[i][1]= object.get("cin");
                        MyArray[i][2]= object.get("nom").toString().toUpperCase();
                        MyArray[i][3]= object.get("prenom").toString().toUpperCase();                           
                        MyArray[i][4]= object.get("adresse").toString().toUpperCase();
                        MyArray[i][5]= object.get("numTel");
		}       
          list.close();
          return MyArray;
    }
     public Object[][] remplirTroncon(DBCursor list)
    {
        int i=-1;
          while (list.hasNext()) {
			DBObject object = list.next();
                        i++;                                             
                        MyArray[i][0]= object.get("num").toString().toUpperCase();
                        MyArray[i][1]= object.get("villeDepart").toString().toUpperCase();
                        MyArray[i][2]= object.get("villeArrive").toString().toUpperCase();                           
		}       
          list.close();
          return MyArray;
    }

    public Object[][] remplirVol(DBCursor list) {
        
        int i=-1;
          while (list.hasNext()) {
			DBObject object = list.next();
                        i++;                                             
                        MyArray[i][0]= object.get("num").toString().toUpperCase();
                        MyArray[i][1]= object.get("distance").toString().toUpperCase();
                        MyArray[i][2]= object.get("frequence").toString().toUpperCase();   
		}       
          list.close();
          return MyArray;
    }

    public Object[][] remplirDAR(DBCursor list) {
          int i=-1;
          while (list.hasNext()) {
			DBObject object = list.next();
                        i++;                                             
                        MyArray[i][0]= object.get("numD").toString().toUpperCase();
                        MyArray[i][1]= object.get("jour").toString().toUpperCase();
                        MyArray[i][2]= object.get("mois").toString().toUpperCase();   
                        MyArray[i][3]= object.get("annee").toString().toUpperCase();   
                        MyArray[i][4]= object.get("numA").toString().toUpperCase();   
                        MyArray[i][5]= object.get("type").toString().toUpperCase();   
                        MyArray[i][6]= object.get("capacite").toString().toUpperCase(); 
                        MyArray[i][7]= object.get("qc").toString().toUpperCase(); 
                        
		}       
          list.close();
          return MyArray;
    }
    public Object[][] remplirDPR(DBCursor list) {
          int i=-1;
          while (list.hasNext()) {
			DBObject object = list.next();
                        i++;                                             
                        MyArray[i][0]= object.get("numD").toString().toUpperCase();
                        MyArray[i][1]= object.get("jour").toString().toUpperCase();
                        MyArray[i][2]= object.get("mois").toString().toUpperCase();
                        MyArray[i][3]= object.get("annee").toString().toUpperCase();
                        MyArray[i][4]= object.get("type").toString().toUpperCase();
                        MyArray[i][5]= object.get("numCIN").toString().toUpperCase();
                        MyArray[i][6]= object.get("nom").toString().toUpperCase();
                        MyArray[i][7]= object.get("prenom").toString().toUpperCase();
                        MyArray[i][8]= object.get("adresse").toString().toUpperCase();
                        MyArray[i][9]= object.get("numTel").toString().toUpperCase();
		}       
          list.close();
          return MyArray;
    }
    public Object[][] remplirVDR(DBCursor list) {
          int i=-1;
          while (list.hasNext()) {
			DBObject object = list.next();
                        i++;                                             
                        MyArray[i][0]= object.get("numV").toString().toUpperCase();
                        MyArray[i][1]= object.get("distance").toString().toUpperCase();
                        MyArray[i][2]= object.get("frequence").toString().toUpperCase();
                        MyArray[i][3]= object.get("numD").toString().toUpperCase();
                        MyArray[i][4]= object.get("jour").toString().toUpperCase()+"/"
                                +object.get("mois").toString().toUpperCase()+"/"
                                +object.get("annee").toString().toUpperCase();
		}       
          list.close();
          return MyArray;
    }
     public Object[][] remplirVTR(DBCursor list) {
          int i=-1;
          while (list.hasNext()) {
			DBObject object = list.next();
                        i++;                                             
                        MyArray[i][0]= object.get("numV");
                        MyArray[i][1]= object.get("distance");
                        MyArray[i][2]= object.get("frequence");
                        MyArray[i][3]= object.get("numero");
                        MyArray[i][4]= object.get("numT");
                        MyArray[i][5]= object.get("villeDepart").toString().toUpperCase();
                        MyArray[i][6]= object.get("villeArrive").toString().toUpperCase(); 
                        MyArray[i][7]= object.get("heureD");
                        MyArray[i][8]= object.get("heureA");
                        
		}       
          list.close();
          return MyArray;
    }
     
     public Object[][] add(Object[][] MyArray1,int l1,int c)
    {
        int l=longueur;
         for(int i=l;i<l1+l;i++)
         {             
             System.arraycopy(MyArray1[i-l], 0, MyArray[i], 0, c);
             longueur++;
         }           
         
          return(MyArray);
    }
}