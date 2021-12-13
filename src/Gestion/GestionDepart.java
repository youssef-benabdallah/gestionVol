/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestion;



import AjoutRelation.AjoutDPR;
import AjoutRelation.AjoutVTR;
import Listage.Matrix;
import NOSQL.Connexion;
import Personnages.Navigant;
import Personnages.Passager;
import Vols.*;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import java.awt.event.KeyEvent;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Ben Abdallah Youssef
 */
public class GestionDepart extends javax.swing.JFrame {

    /**
     * Creates new form pp
     */
    void chargerHeure(){
      for(int i=0;i<24;i++)
      {
          if(i<10)
          {
       listHD.addItem("0"+String.valueOf(i));    
       listHA.addItem("0"+String.valueOf(i));
          }
          else
          {
       listHD.addItem(i);    
       listHA.addItem(i);
          }
      }
      for(int i=0;i<60;i++)
      {
          if(i<10)
          {
       listMD.addItem("0"+String.valueOf(i));    
       listMA.addItem("0"+String.valueOf(i));
          }
          else
          {
       listMD.addItem(i);    
       listMA.addItem(i);
          }
      }
     }
    
      private void afficheJTableT(Object[][] MyArray)
    {
         jTableT.setModel(new javax.swing.table.DefaultTableModel(
                        MyArray,
                        new String [] {
                             "Numero", "Ville de Depart", "Ville d'Arrivée"
                        }
                        )
                  {
                                               boolean[] canEdit = new boolean [] {
                            false, false, false
                        };
                        @Override
                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                            return canEdit [columnIndex];
                        }
                    }
         );
    }
    
    private boolean testT(DBObject object, int i)
    {
        if(i==1)
        return object.get("num").toString().toUpperCase().contains(numTT.getText().toUpperCase())
                         &&object.get("villeDepart").toString().toUpperCase().contains(villeDT.getText().toUpperCase())
                         &&object.get("villeArrive").toString().toUpperCase().contains(villeAT.getText().toUpperCase());
        else return
                object.get("num").toString().contains(anyT.getText().toUpperCase())
                         ||object.get("villeDepart").toString().toUpperCase().contains(anyT.getText().toUpperCase())
                         ||object.get("villeArrive").toString().toUpperCase().contains(anyT.getText().toUpperCase());
    }
   
    
    private void afficheT(int e)
{
        try {
            Connexion connexion = new Connexion("Airport");
             DBCursor listTroncon = connexion.getListe("Troncon");
             int i=0;
             Object[][] tab = new Object[listTroncon.count()][3];             
             while (listTroncon.hasNext())
             {
                 DBObject object = listTroncon.next();
                 if(testT(object,e))                    
                 
                 {                    
                     tab[i][0]=object.get("num");
                     tab[i][1]=object.get("villeDepart");
                     tab[i][2]=object.get("villeArrive");
                      i++;
                 }
             }                             
             
             Object[][] MyArray = new Object[i][3];
             for(int j=0;j<i;j++)
             {
                 MyArray[j][0]=tab[j][0];
                    MyArray[j][1]=tab[j][1];
                       MyArray[j][2]=tab[j][2];
             }            
         
       afficheJTableT(MyArray);
        } catch (UnknownHostException ex) {
            Logger.getLogger(GestionAvion.class.getName()).log(Level.SEVERE, null, ex);        
        }
   
}
    private void afficheJTableVT(Object[][] MyArray)
    {
         jTableVT.setModel(new javax.swing.table.DefaultTableModel(
                        MyArray,
                        new String [] {
                            "Numero Vol", "Distance", "Fréquence",                            
                            "N° Troncon","Numero Troncon","Ville Depart","Ville Arrivée",
                            "Heure Depart","Heure Arrivée"
                        }
                        )
                  {
                            boolean[] canEdit = new boolean [] {
                            false, false, false, false, false
                        };
                        @Override
                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                            return canEdit [columnIndex];
                        }
                    }
         );
    }
    
    private boolean testVT(DBObject object, int n)
    { 
        String C[][]=new String[8][2];
   C[0][0]="numV";C[0][1]=numVVT.getText();
   C[1][0]="distance";C[1][1]=distanceVT.getText();
   C[2][0]="frequence";C[2][1]=frequenceVT.getText();      
   C[3][0]="numT";C[3][1]=numTVT.getText();
   C[4][0]="villeDepart";C[4][1]=villeDVT.getText().toUpperCase();
   C[5][0]="villeArrive";C[5][1]=villeAVT.getText().toUpperCase();
   C[6][0]="heureD";C[6][1]=heureDVT.getText();
   C[7][0]="heureA";C[7][1]=heureAVT.getText();
   int i=0;
   boolean ok;
        if(n==1)
        {
            ok=true;
            while(ok&&i<8)
            {
         ok = object.get(C[i][0]).toString().toUpperCase().contains(C[i][1].toUpperCase());         
         i++;
            }}        
         else 
        {
            ok=false;
             while(i<8)
            {
        ok = ok || object.get(C[i][0]).toString().toUpperCase().contains(anyVT.getText().toUpperCase());         
         i++;
            }
        }
        return ok;
    }
   
    
    private void afficheVT(int e)
{
        try {
            Connexion connexion = new Connexion("Airport");
             DBCursor listAvion = connexion.getListe("VTR");   
             int i=0;
             Object[][] tab = new Object[listAvion.count()][9];             
             while (listAvion.hasNext())
             {
                 DBObject object = listAvion.next();
                 if(testVT(object,e))   
                 {                   
                       tab[i][0]=object.get("numV");
                       tab[i][1]=object.get("distance");
                       tab[i][2]=object.get("frequence");            
                       tab[i][3]= object.get("numero");
                       tab[i][4]=object.get("numT").toString().toUpperCase();     
                       tab[i][5]=object.get("villeDepart").toString().toUpperCase();
                       tab[i][6]=object.get("villeArrive").toString().toUpperCase();
                       tab[i][7]=object.get("heureD");
                       tab[i][8]=object.get("heureA");
                      i++;
                 }
             }                                          
             Object[][] MyArray = new Object[i][9];
             for(int j=0;j<i;j++)
             {
                System.arraycopy(tab[j], 0, MyArray[j], 0, 9);
             }            
         
       afficheJTableVT(MyArray);
    
        } catch (UnknownHostException ex) {
            Logger.getLogger(GestionAvion.class.getName()).log(Level.SEVERE, null, ex);        
        }
   
}
  
    public GestionDepart() throws UnknownHostException {
        initComponents();
        affiche();
                 affiche(1);
                 afficheA(1);
                 afficheV(1);
                 afficheDPR(1);
                 afficheDA();
                   afficheVD(1);  
                   afficheVT(1);
                   afficheT(1);
                   chargerHeure();
                
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane3 = new javax.swing.JTabbedPane();
        jLayeredPane4 = new javax.swing.JLayeredPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableD = new javax.swing.JTable();
        num = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jour = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        annee = new javax.swing.JTextField();
        mois = new javax.swing.JTextField();
        ajouter = new javax.swing.JButton();
        ajouter1 = new javax.swing.JButton();
        supprimer = new javax.swing.JButton();
        qc = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLayeredPane9 = new javax.swing.JLayeredPane();
        jLabel47 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTableT = new javax.swing.JTable();
        numTT = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        ajouter13 = new javax.swing.JButton();
        ajouter14 = new javax.swing.JButton();
        supprimer6 = new javax.swing.JButton();
        villeDT = new javax.swing.JTextField();
        villeAT = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        anyT = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        listHD = new javax.swing.JComboBox();
        listMD = new javax.swing.JComboBox();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        listHA = new javax.swing.JComboBox();
        listMA = new javax.swing.JComboBox();
        jLabel54 = new javax.swing.JLabel();
        ajouter15 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        numV = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        distance = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        frequence = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableV = new javax.swing.JTable();
        ajouter7 = new javax.swing.JButton();
        ajouter8 = new javax.swing.JButton();
        supprimer1 = new javax.swing.JButton();
        jLayeredPane7 = new javax.swing.JLayeredPane();
        numDVD = new javax.swing.JTextField();
        numVVD = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        anyVD = new javax.swing.JTextField();
        distanceVD = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTableVD = new javax.swing.JTable();
        jLabel36 = new javax.swing.JLabel();
        frequenceVD = new javax.swing.JTextField();
        supprimer4 = new javax.swing.JButton();
        jourVD = new javax.swing.JTextField();
        ajouter11 = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        anneeVD = new javax.swing.JTextField();
        moisVD = new javax.swing.JTextField();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jLabel18 = new javax.swing.JLabel();
        nom1 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        ajouter2 = new javax.swing.JButton();
        ajouter3 = new javax.swing.JButton();
        supprimer2 = new javax.swing.JButton();
        ajouter9 = new javax.swing.JButton();
        any = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        numTel1 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableP = new javax.swing.JTable();
        num1 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        list = new javax.swing.JComboBox();
        adresse1 = new javax.swing.JTextField();
        prenom1 = new javax.swing.JTextField();
        jLayeredPane6 = new javax.swing.JLayeredPane();
        numD = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        anneePD = new javax.swing.JTextField();
        moisPD = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTablePD = new javax.swing.JTable();
        annulerPD = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        supprimerPD = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        numPD = new javax.swing.JTextField();
        nomPD = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        anyPD = new javax.swing.JTextField();
        prenomPD = new javax.swing.JTextField();
        numTelPD = new javax.swing.JTextField();
        listPD = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        adressePD = new javax.swing.JTextField();
        jourPD = new javax.swing.JTextField();
        jLayeredPane8 = new javax.swing.JLayeredPane();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTableVT = new javax.swing.JTable();
        ajouter12 = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        villeDVT = new javax.swing.JTextField();
        villeAVT = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        heureAVT = new javax.swing.JTextField();
        numTVT = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        anyVT = new javax.swing.JTextField();
        distanceVT = new javax.swing.JTextField();
        supprimer5 = new javax.swing.JButton();
        jLabel43 = new javax.swing.JLabel();
        frequenceVT = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        numVVT = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        heureDVT = new javax.swing.JTextField();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        ajouter5 = new javax.swing.JButton();
        ajouter6 = new javax.swing.JButton();
        ajouter4 = new javax.swing.JButton();
        anyA = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        capacite = new javax.swing.JTextField();
        type = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        numA = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableA = new javax.swing.JTable();
        jLayeredPane5 = new javax.swing.JLayeredPane();
        moisDA = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTableDA = new javax.swing.JTable();
        numAD = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        typeDA = new javax.swing.JTextField();
        qcDA = new javax.swing.JTextField();
        capaciteDA = new javax.swing.JTextField();
        supprimer3 = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        ajouter10 = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jourDA = new javax.swing.JTextField();
        numDA = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        anneeDA = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("TUNISAIR");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jTableD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero", "Jour", "Mois", "Année"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableD);

        num.setToolTipText("");
        num.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        num.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numActionPerformed(evt);
            }
        });
        num.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                numKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                numKeyTyped(evt);
            }
        });

        jLabel2.setText("Numero");

        jour.setToolTipText("Jour");
        jour.setName(""); // NOI18N
        jour.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jourMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jourMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jourMouseReleased(evt);
            }
        });
        jour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jourActionPerformed(evt);
            }
        });
        jour.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jourKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jourKeyTyped(evt);
            }
        });

        jLabel3.setText("Date");

        annee.setToolTipText("Annee");
        annee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                anneeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                anneeKeyTyped(evt);
            }
        });

        mois.setToolTipText("Mois");
        mois.setName(""); // NOI18N
        mois.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                moisMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                moisMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                moisMouseReleased(evt);
            }
        });
        mois.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moisActionPerformed(evt);
            }
        });
        mois.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                moisKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                moisKeyTyped(evt);
            }
        });

        ajouter.setText("Ajouter");
        ajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterActionPerformed(evt);
            }
        });

        ajouter1.setText("Annuler");
        ajouter1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouter1ActionPerformed(evt);
            }
        });

        supprimer.setText("Supprimer");
        supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimerActionPerformed(evt);
            }
        });

        qc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                qcKeyTyped(evt);
            }
        });

        jLabel10.setText("Quantite Carburant");

        javax.swing.GroupLayout jLayeredPane4Layout = new javax.swing.GroupLayout(jLayeredPane4);
        jLayeredPane4.setLayout(jLayeredPane4Layout);
        jLayeredPane4Layout.setHorizontalGroup(
            jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane4Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(supprimer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ajouter1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ajouter, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jLayeredPane4Layout.createSequentialGroup()
                        .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(71, 71, 71)
                                .addComponent(jLabel3))
                            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                                .addComponent(num, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jour, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mois, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(annee, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(qc, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        jLayeredPane4Layout.setVerticalGroup(
            jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jLayeredPane4Layout.createSequentialGroup()
                        .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mois, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(annee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(num, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jLayeredPane4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(qc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane4Layout.createSequentialGroup()
                        .addComponent(ajouter)
                        .addGap(59, 59, 59)
                        .addComponent(ajouter1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                        .addComponent(supprimer))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jLayeredPane4.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(num, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jour, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(annee, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(mois, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(ajouter, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(ajouter1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(supprimer, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(qc, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTabbedPane3.addTab("Gestion Depart", jLayeredPane4);

        jLabel47.setText("Tous");

        jTableT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero", "Ville de Depart", "Ville d'Arrivée"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane9.setViewportView(jTableT);

        numTT.setToolTipText("");
        numTT.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        numTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numTTActionPerformed(evt);
            }
        });
        numTT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                numTTKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                numTTKeyTyped(evt);
            }
        });

        jLabel48.setText("Numero");

        ajouter13.setText("Ajouter");
        ajouter13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouter13ActionPerformed(evt);
            }
        });

        ajouter14.setText("Annuler");
        ajouter14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouter14ActionPerformed(evt);
            }
        });

        supprimer6.setText("Supprimer");
        supprimer6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimer6ActionPerformed(evt);
            }
        });

        villeDT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                villeDTKeyReleased(evt);
            }
        });

        villeAT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                villeATKeyReleased(evt);
            }
        });

        jLabel49.setText("Ville de Depart");

        jLabel50.setText("Ville d'Arrivée");

        anyT.setToolTipText("");
        anyT.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        anyT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anyTActionPerformed(evt);
            }
        });
        anyT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                anyTKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                anyTKeyTyped(evt);
            }
        });

        jLabel51.setText("Heure Depart");

        listHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listHDActionPerformed(evt);
            }
        });

        listMD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listMDActionPerformed(evt);
            }
        });

        jLabel52.setText(":");

        jLabel53.setText("Heure Arrivée");

        listHA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listHAActionPerformed(evt);
            }
        });

        listMA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listMAActionPerformed(evt);
            }
        });

        jLabel54.setText(":");

        ajouter15.setText("Ajouter Vol");
        ajouter15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouter15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jLayeredPane9Layout = new javax.swing.GroupLayout(jLayeredPane9);
        jLayeredPane9.setLayout(jLayeredPane9Layout);
        jLayeredPane9Layout.setHorizontalGroup(
            jLayeredPane9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane9Layout.createSequentialGroup()
                        .addGroup(jLayeredPane9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel48)
                            .addComponent(numTT, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jLayeredPane9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel49)
                            .addComponent(villeDT, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jLayeredPane9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel50)
                            .addComponent(villeAT, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jLayeredPane9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPane9Layout.createSequentialGroup()
                                .addComponent(jLabel47)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jLayeredPane9Layout.createSequentialGroup()
                                .addComponent(anyT, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ajouter13, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))))
                    .addGroup(jLayeredPane9Layout.createSequentialGroup()
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jLayeredPane9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jLayeredPane9Layout.createSequentialGroup()
                                    .addComponent(listHD, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel52)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(listMD, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel51))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel53)
                                .addGroup(jLayeredPane9Layout.createSequentialGroup()
                                    .addComponent(listHA, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel54)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(listMA, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(supprimer6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ajouter14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ajouter15, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jLayeredPane9Layout.setVerticalGroup(
            jLayeredPane9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jLayeredPane9Layout.createSequentialGroup()
                        .addComponent(jLabel48)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane9Layout.createSequentialGroup()
                        .addGroup(jLayeredPane9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel49)
                            .addComponent(jLabel50))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jLayeredPane9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(villeDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(villeAT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jLayeredPane9Layout.createSequentialGroup()
                        .addComponent(jLabel47)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jLayeredPane9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(anyT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ajouter13))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLayeredPane9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane9Layout.createSequentialGroup()
                        .addComponent(ajouter15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel51)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jLayeredPane9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(listHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel52)
                            .addComponent(listMD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel53)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jLayeredPane9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(listHA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel54)
                            .addComponent(listMA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addComponent(supprimer6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ajouter14))
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jLayeredPane9.setLayer(jLabel47, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane9.setLayer(jScrollPane9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane9.setLayer(numTT, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane9.setLayer(jLabel48, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane9.setLayer(ajouter13, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane9.setLayer(ajouter14, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane9.setLayer(supprimer6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane9.setLayer(villeDT, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane9.setLayer(villeAT, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane9.setLayer(jLabel49, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane9.setLayer(jLabel50, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane9.setLayer(anyT, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane9.setLayer(jLabel51, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane9.setLayer(listHD, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane9.setLayer(listMD, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane9.setLayer(jLabel52, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane9.setLayer(jLabel53, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane9.setLayer(listHA, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane9.setLayer(listMA, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane9.setLayer(jLabel54, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane9.setLayer(ajouter15, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTabbedPane3.addTab("Gestion Tronçon", jLayeredPane9);

        numV.setToolTipText("");
        numV.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        numV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numVActionPerformed(evt);
            }
        });
        numV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                numVKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                numVKeyTyped(evt);
            }
        });

        jLabel9.setText("Numero");

        jLabel25.setText("Distance");

        distance.setToolTipText("");
        distance.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        distance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                distanceActionPerformed(evt);
            }
        });
        distance.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                distanceKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                distanceKeyTyped(evt);
            }
        });

        jLabel26.setText("Fréquence");

        frequence.setToolTipText("");
        frequence.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        frequence.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                frequenceActionPerformed(evt);
            }
        });
        frequence.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                frequenceKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                frequenceKeyTyped(evt);
            }
        });

        jTableV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero", "Distance", "Fréquence"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTableV);

        ajouter7.setText("Ajouter");
        ajouter7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouter7ActionPerformed(evt);
            }
        });

        ajouter8.setText("Annuler");
        ajouter8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouter8ActionPerformed(evt);
            }
        });

        supprimer1.setText("Supprimer");
        supprimer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimer1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(supprimer1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ajouter8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ajouter7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(numV, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addComponent(distance, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26)
                            .addComponent(frequence, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(distance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(frequence, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(ajouter7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                        .addComponent(ajouter8)
                        .addGap(68, 68, 68)
                        .addComponent(supprimer1))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jLayeredPane1.setLayer(numV, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel25, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(distance, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel26, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(frequence, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jScrollPane4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(ajouter7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(ajouter8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(supprimer1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTabbedPane1.addTab("Gestion Vol", jLayeredPane1);

        numDVD.setToolTipText("");
        numDVD.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        numDVD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numDVDActionPerformed(evt);
            }
        });
        numDVD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                numDVDKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                numDVDKeyTyped(evt);
            }
        });

        numVVD.setToolTipText("");
        numVVD.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        numVVD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numVVDActionPerformed(evt);
            }
        });
        numVVD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                numVVDKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                numVVDKeyTyped(evt);
            }
        });

        jLabel32.setText("Numero Depart");

        jLabel33.setText("Numero Vol");

        jLabel34.setText("Tous");

        jLabel35.setText("Distance");

        anyVD.setToolTipText("");
        anyVD.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        anyVD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anyVDActionPerformed(evt);
            }
        });
        anyVD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                anyVDKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                anyVDKeyTyped(evt);
            }
        });

        distanceVD.setToolTipText("");
        distanceVD.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        distanceVD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                distanceVDActionPerformed(evt);
            }
        });
        distanceVD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                distanceVDKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                distanceVDKeyTyped(evt);
            }
        });

        jTableVD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane7.setViewportView(jTableVD);

        jLabel36.setText("Fréquence");

        frequenceVD.setToolTipText("");
        frequenceVD.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        frequenceVD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                frequenceVDActionPerformed(evt);
            }
        });
        frequenceVD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                frequenceVDKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                frequenceVDKeyTyped(evt);
            }
        });

        supprimer4.setText("Supprimer ");
        supprimer4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimer4ActionPerformed(evt);
            }
        });

        jourVD.setToolTipText("Jour");
        jourVD.setName(""); // NOI18N
        jourVD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jourVDMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jourVDMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jourVDMouseReleased(evt);
            }
        });
        jourVD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jourVDActionPerformed(evt);
            }
        });
        jourVD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jourVDKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jourVDKeyTyped(evt);
            }
        });

        ajouter11.setText("Annuler");
        ajouter11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouter11ActionPerformed(evt);
            }
        });

        jLabel37.setText("Date");

        anneeVD.setToolTipText("Annee");
        anneeVD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                anneeVDKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                anneeVDKeyTyped(evt);
            }
        });

        moisVD.setToolTipText("Mois");
        moisVD.setName(""); // NOI18N
        moisVD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                moisVDMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                moisVDMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                moisVDMouseReleased(evt);
            }
        });
        moisVD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moisVDActionPerformed(evt);
            }
        });
        moisVD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                moisVDKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                moisVDKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jLayeredPane7Layout = new javax.swing.GroupLayout(jLayeredPane7);
        jLayeredPane7.setLayout(jLayeredPane7Layout);
        jLayeredPane7Layout.setHorizontalGroup(
            jLayeredPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jLayeredPane7Layout.createSequentialGroup()
                        .addGroup(jLayeredPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel32)
                            .addComponent(numDVD, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jLayeredPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel37)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane7Layout.createSequentialGroup()
                                .addComponent(jourVD, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(moisVD, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(anneeVD, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jLayeredPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPane7Layout.createSequentialGroup()
                                .addComponent(jLabel34)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(anyVD)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jLayeredPane7Layout.createSequentialGroup()
                        .addGroup(jLayeredPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jLayeredPane7Layout.createSequentialGroup()
                                .addGroup(jLayeredPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel33)
                                    .addComponent(numVVD, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jLayeredPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(distanceVD, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel35))
                                .addGap(18, 18, 18)
                                .addGroup(jLayeredPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel36)
                                    .addComponent(frequenceVD, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 78, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(supprimer4)
                    .addComponent(ajouter11, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
                .addContainerGap())
        );
        jLayeredPane7Layout.setVerticalGroup(
            jLayeredPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jLayeredPane7Layout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(frequenceVD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane7Layout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(distanceVD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane7Layout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numVVD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(jLayeredPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32)
                    .addGroup(jLayeredPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel37)
                        .addComponent(jLabel34)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(numDVD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jLayeredPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jourVD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(moisVD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(anneeVD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(anyVD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane7Layout.createSequentialGroup()
                        .addComponent(ajouter11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                        .addComponent(supprimer4))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jLayeredPane7.setLayer(numDVD, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane7.setLayer(numVVD, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane7.setLayer(jLabel32, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane7.setLayer(jLabel33, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane7.setLayer(jLabel34, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane7.setLayer(jLabel35, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane7.setLayer(anyVD, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane7.setLayer(distanceVD, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane7.setLayer(jScrollPane7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane7.setLayer(jLabel36, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane7.setLayer(frequenceVD, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane7.setLayer(supprimer4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane7.setLayer(jourVD, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane7.setLayer(ajouter11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane7.setLayer(jLabel37, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane7.setLayer(anneeVD, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane7.setLayer(moisVD, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTabbedPane1.addTab("Gestion Vol Depart", jLayeredPane7);

        jLabel18.setText("Prenom");

        nom1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nom1ActionPerformed(evt);
            }
        });
        nom1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nom1KeyReleased(evt);
            }
        });

        jLabel23.setText("Nom");

        ajouter2.setText("Ajouter");
        ajouter2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouter2ActionPerformed(evt);
            }
        });

        ajouter3.setText("Annuler");
        ajouter3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouter3ActionPerformed(evt);
            }
        });

        supprimer2.setText("Supprimer");
        supprimer2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimer2ActionPerformed(evt);
            }
        });

        ajouter9.setText("Ajout Depart");
        ajouter9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouter9ActionPerformed(evt);
            }
        });

        any.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                anyKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                anyKeyTyped(evt);
            }
        });

        jLabel21.setText("Tous");

        numTel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                numTel1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                numTel1KeyTyped(evt);
            }
        });

        jLabel19.setText("Num TEL");

        jLabel20.setText("Adresse");

        jTableP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N° CIN", "Nom", "Prenom", "Adresse", "N° Tel"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableP);

        num1.setToolTipText("");
        num1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        num1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num1ActionPerformed(evt);
            }
        });
        num1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                num1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                num1KeyTyped(evt);
            }
        });

        jLabel22.setText("Numero CIN");

        list.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Navigant", "Non Navigant", "Passager", "Personnel", "Pilote", "Tous" }));
        list.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listActionPerformed(evt);
            }
        });

        adresse1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                adresse1KeyReleased(evt);
            }
        });

        prenom1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                prenom1KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(list, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22)
                            .addComponent(num1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nom1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel23))
                                .addGap(18, 18, 18)
                                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(prenom1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane2Layout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addGap(67, 67, 67)))
                                .addGap(18, 18, 18)
                                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20)
                                    .addComponent(adresse1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                .addComponent(ajouter2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ajouter3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(supprimer2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19)
                                    .addComponent(numTel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(any, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel21)))
                            .addComponent(ajouter9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 683, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(list, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ajouter2)
                    .addComponent(supprimer2)
                    .addComponent(ajouter3)
                    .addComponent(ajouter9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(num1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(prenom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(adresse1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numTel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(any, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel18)
                    .addComponent(jLabel20)
                    .addComponent(jLabel19)
                    .addComponent(jLabel21)
                    .addComponent(jLabel23))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                .addContainerGap())
        );
        jLayeredPane2.setLayer(jLabel18, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(nom1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel23, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(ajouter2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(ajouter3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(supprimer2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(ajouter9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(any, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel21, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(numTel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel19, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel20, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(num1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel22, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(list, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(adresse1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(prenom1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTabbedPane2.addTab("Gestion Personne", jLayeredPane2);

        numD.setToolTipText("");
        numD.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        numD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numDActionPerformed(evt);
            }
        });
        numD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                numDKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                numDKeyTyped(evt);
            }
        });

        jLabel8.setText("Date");

        jLabel15.setText("Numero Depart");

        anneePD.setToolTipText("Annee");
        anneePD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                anneePDKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                anneePDKeyTyped(evt);
            }
        });

        moisPD.setToolTipText("Mois");
        moisPD.setName(""); // NOI18N
        moisPD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                moisPDMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                moisPDMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                moisPDMouseReleased(evt);
            }
        });
        moisPD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moisPDActionPerformed(evt);
            }
        });
        moisPD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                moisPDKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                moisPDKeyTyped(evt);
            }
        });

        jTablePD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero Depart", "Jour", "Mois", "Année", "Type", "N° CIN", "Nom", "Prénom", "Adresse", "N° TEL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(jTablePD);

        annulerPD.setText("Annuler");
        annulerPD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                annulerPDActionPerformed(evt);
            }
        });

        jLabel4.setText("Prenom");

        supprimerPD.setText("Supprimer ");
        supprimerPD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimerPDActionPerformed(evt);
            }
        });

        jLabel5.setText("Num TEL");

        jLabel6.setText("Adresse");

        numPD.setToolTipText("");
        numPD.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        numPD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numPDActionPerformed(evt);
            }
        });
        numPD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                numPDKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                numPDKeyTyped(evt);
            }
        });

        nomPD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nomPDKeyReleased(evt);
            }
        });

        jLabel7.setText("Numero CIN");

        jLabel16.setText("Tous");

        anyPD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                anyPDKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                anyPDKeyTyped(evt);
            }
        });

        prenomPD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                prenomPDKeyReleased(evt);
            }
        });

        numTelPD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                numTelPDKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                numTelPDKeyTyped(evt);
            }
        });

        listPD.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Passager", "Navigant", "Non Navigant", "Personnel", "Pilote", "Tous" }));
        listPD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listPDActionPerformed(evt);
            }
        });

        jLabel17.setText("Nom");

        adressePD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                adressePDKeyReleased(evt);
            }
        });

        jourPD.setToolTipText("Jour");
        jourPD.setName(""); // NOI18N
        jourPD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jourPDMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jourPDMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jourPDMouseReleased(evt);
            }
        });
        jourPD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jourPDActionPerformed(evt);
            }
        });
        jourPD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jourPDKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jourPDKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jLayeredPane6Layout = new javax.swing.GroupLayout(jLayeredPane6);
        jLayeredPane6.setLayout(jLayeredPane6Layout);
        jLayeredPane6Layout.setHorizontalGroup(
            jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addGroup(jLayeredPane6Layout.createSequentialGroup()
                        .addGroup(jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(numPD, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nomPD, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addGap(18, 18, 18)
                        .addGroup(jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(prenomPD, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(adressePD, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(numTelPD, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jLayeredPane6Layout.createSequentialGroup()
                        .addGroup(jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(numD, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18)
                        .addGroup(jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPane6Layout.createSequentialGroup()
                                .addComponent(jourPD, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(moisPD, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(anneePD, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPane6Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jLayeredPane6Layout.createSequentialGroup()
                                .addComponent(anyPD, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(supprimerPD)
                                .addGap(18, 18, 18)
                                .addComponent(annulerPD, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                                .addComponent(listPD, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jLayeredPane6Layout.setVerticalGroup(
            jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5)
                    .addComponent(jLabel17)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addGap(4, 4, 4)
                .addGroup(jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numPD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomPD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prenomPD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(adressePD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numTelPD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel8)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jourPD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(moisPD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(anneePD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(anyPD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(supprimerPD)
                    .addComponent(annulerPD)
                    .addComponent(listPD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                .addContainerGap())
        );
        jLayeredPane6.setLayer(numD, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(jLabel15, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(anneePD, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(moisPD, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(jScrollPane5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(annulerPD, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(supprimerPD, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(numPD, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(nomPD, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(jLabel16, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(anyPD, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(prenomPD, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(numTelPD, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(listPD, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(jLabel17, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(adressePD, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(jourPD, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTabbedPane2.addTab("Gestion Personne Depart", jLayeredPane6);

        jTableVT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero Depart", "Jour", "Mois", "Année", "Type", "N° CIN", "Nom", "Prénom", "Adresse", "N° TEL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane8.setViewportView(jTableVT);

        ajouter12.setText("Annuler");
        ajouter12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouter12ActionPerformed(evt);
            }
        });

        jLabel38.setText("Numero Troncon");

        villeDVT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                villeDVTKeyReleased(evt);
            }
        });

        villeAVT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                villeAVTKeyReleased(evt);
            }
        });

        jLabel39.setText("Ville de Depart");

        jLabel40.setText("Ville d'Arrivée");

        heureAVT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                heureAVTKeyReleased(evt);
            }
        });

        numTVT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                numTVTKeyReleased(evt);
            }
        });

        jLabel41.setText("Tous");

        jLabel42.setText("Distance");

        anyVT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                anyVTKeyReleased(evt);
            }
        });

        distanceVT.setToolTipText("");
        distanceVT.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        distanceVT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                distanceVTActionPerformed(evt);
            }
        });
        distanceVT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                distanceVTKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                distanceVTKeyTyped(evt);
            }
        });

        supprimer5.setText("Supprimer ");
        supprimer5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimer5ActionPerformed(evt);
            }
        });

        jLabel43.setText("Fréquence");

        frequenceVT.setToolTipText("");
        frequenceVT.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        frequenceVT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                frequenceVTActionPerformed(evt);
            }
        });
        frequenceVT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                frequenceVTKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                frequenceVTKeyTyped(evt);
            }
        });

        jLabel44.setText("Numero Vol");

        numVVT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                numVVTKeyReleased(evt);
            }
        });

        jLabel45.setText("Heure Depart");

        jLabel46.setText("Heure Arrivée");

        heureDVT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                heureDVTKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jLayeredPane8Layout = new javax.swing.GroupLayout(jLayeredPane8);
        jLayeredPane8.setLayout(jLayeredPane8Layout);
        jLayeredPane8Layout.setHorizontalGroup(
            jLayeredPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane8Layout.createSequentialGroup()
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jLayeredPane8Layout.createSequentialGroup()
                        .addGroup(jLayeredPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel38)
                            .addComponent(numTVT, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel44)
                            .addComponent(numVVT, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jLayeredPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPane8Layout.createSequentialGroup()
                                .addGroup(jLayeredPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel42)
                                    .addComponent(distanceVT, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jLayeredPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel43)
                                    .addComponent(frequenceVT, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jLayeredPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel41)
                                    .addGroup(jLayeredPane8Layout.createSequentialGroup()
                                        .addComponent(anyVT, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(166, 166, 166)
                                        .addComponent(supprimer5, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(19, Short.MAX_VALUE))
                            .addGroup(jLayeredPane8Layout.createSequentialGroup()
                                .addGroup(jLayeredPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel39)
                                    .addComponent(villeDVT, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jLayeredPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel40)
                                    .addComponent(villeAVT, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(jLayeredPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel45)
                                    .addComponent(heureDVT, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jLayeredPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel46)
                                    .addComponent(heureAVT, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ajouter12, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(155, 155, 155))))))
        );
        jLayeredPane8Layout.setVerticalGroup(
            jLayeredPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane8Layout.createSequentialGroup()
                        .addComponent(jLabel38)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numTVT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jLabel44)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numVVT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane8Layout.createSequentialGroup()
                        .addGroup(jLayeredPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jLayeredPane8Layout.createSequentialGroup()
                                .addComponent(jLabel45)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(heureDVT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jLayeredPane8Layout.createSequentialGroup()
                                .addComponent(jLabel40)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(villeAVT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jLayeredPane8Layout.createSequentialGroup()
                                .addComponent(jLabel46)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(heureAVT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jLayeredPane8Layout.createSequentialGroup()
                                .addComponent(jLabel39)
                                .addGap(6, 6, 6)
                                .addComponent(villeDVT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(11, 11, 11)
                        .addGroup(jLayeredPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPane8Layout.createSequentialGroup()
                                .addComponent(jLabel43)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jLayeredPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(frequenceVT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(anyVT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane8Layout.createSequentialGroup()
                                .addComponent(jLabel41)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jLayeredPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ajouter12)
                                    .addComponent(supprimer5)))
                            .addGroup(jLayeredPane8Layout.createSequentialGroup()
                                .addComponent(jLabel42)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(distanceVT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addContainerGap())
        );
        jLayeredPane8.setLayer(jScrollPane8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane8.setLayer(ajouter12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane8.setLayer(jLabel38, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane8.setLayer(villeDVT, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane8.setLayer(villeAVT, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane8.setLayer(jLabel39, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane8.setLayer(jLabel40, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane8.setLayer(heureAVT, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane8.setLayer(numTVT, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane8.setLayer(jLabel41, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane8.setLayer(jLabel42, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane8.setLayer(anyVT, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane8.setLayer(distanceVT, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane8.setLayer(supprimer5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane8.setLayer(jLabel43, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane8.setLayer(frequenceVT, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane8.setLayer(jLabel44, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane8.setLayer(numVVT, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane8.setLayer(jLabel45, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane8.setLayer(jLabel46, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane8.setLayer(heureDVT, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTabbedPane2.addTab("Gestion Vol Troncon", jLayeredPane8);

        ajouter5.setText("Anuuler");
        ajouter5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouter5ActionPerformed(evt);
            }
        });

        ajouter6.setText("Supprimer");
        ajouter6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouter6ActionPerformed(evt);
            }
        });

        ajouter4.setText("Ajouter");
        ajouter4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouter4ActionPerformed(evt);
            }
        });

        anyA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                anyAKeyReleased(evt);
            }
        });

        jLabel12.setText("Tous");

        jLabel11.setText("Capacité");

        capacite.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                capaciteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                capaciteKeyTyped(evt);
            }
        });

        type.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                typeKeyReleased(evt);
            }
        });

        jLabel14.setText("Type");

        numA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                numAKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                numAKeyTyped(evt);
            }
        });

        jLabel13.setText("Numero");

        jTableA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero", "Type", "Capacité"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTableA);

        javax.swing.GroupLayout jLayeredPane3Layout = new javax.swing.GroupLayout(jLayeredPane3);
        jLayeredPane3.setLayout(jLayeredPane3Layout);
        jLayeredPane3Layout.setHorizontalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jLayeredPane3Layout.createSequentialGroup()
                        .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(numA, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(18, 18, 18)
                        .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(capacite, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(anyA, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ajouter6)
                    .addComponent(ajouter4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ajouter5, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jLayeredPane3Layout.setVerticalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jLayeredPane3Layout.createSequentialGroup()
                        .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(numA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jLayeredPane3Layout.createSequentialGroup()
                        .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(capacite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(anyA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane3Layout.createSequentialGroup()
                        .addComponent(ajouter4)
                        .addGap(68, 68, 68)
                        .addComponent(ajouter5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                        .addComponent(ajouter6))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jLayeredPane3.setLayer(ajouter5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(ajouter6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(ajouter4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(anyA, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLabel11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(capacite, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(type, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLabel14, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(numA, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLabel13, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jScrollPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTabbedPane4.addTab("Gestion Avion", jLayeredPane3);

        moisDA.setToolTipText("Mois");
        moisDA.setName(""); // NOI18N
        moisDA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                moisDAMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                moisDAMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                moisDAMouseReleased(evt);
            }
        });
        moisDA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moisDAActionPerformed(evt);
            }
        });
        moisDA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                moisDAKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                moisDAKeyTyped(evt);
            }
        });

        jTableDA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero Depart", "Jour", "Mois", "Année", "Numero Avion", "Type", "Capacité"
            }
        ));
        jScrollPane6.setViewportView(jTableDA);

        numAD.setToolTipText("");
        numAD.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        numAD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numADActionPerformed(evt);
            }
        });
        numAD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                numADKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                numADKeyTyped(evt);
            }
        });

        jLabel24.setText("Numero Avion");

        jLabel27.setText("Quantite Carburant");

        typeDA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                typeDAKeyReleased(evt);
            }
        });

        qcDA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                qcDAKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                qcDAKeyTyped(evt);
            }
        });

        capaciteDA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                capaciteDAKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                capaciteDAKeyTyped(evt);
            }
        });

        supprimer3.setText("Supprimer ");
        supprimer3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimer3ActionPerformed(evt);
            }
        });

        jLabel28.setText("Type");

        ajouter10.setText("Annuler");
        ajouter10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouter10ActionPerformed(evt);
            }
        });

        jLabel29.setText("Capacité");

        jourDA.setToolTipText("Jour");
        jourDA.setName(""); // NOI18N
        jourDA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jourDAMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jourDAMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jourDAMouseReleased(evt);
            }
        });
        jourDA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jourDAActionPerformed(evt);
            }
        });
        jourDA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jourDAKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jourDAKeyTyped(evt);
            }
        });

        numDA.setToolTipText("");
        numDA.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        numDA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numDAActionPerformed(evt);
            }
        });
        numDA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                numDAKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                numDAKeyTyped(evt);
            }
        });

        jLabel30.setText("Date");

        jLabel31.setText("Numero Depart");

        anneeDA.setToolTipText("Annee");
        anneeDA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                anneeDAKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                anneeDAKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jLayeredPane5Layout = new javax.swing.GroupLayout(jLayeredPane5);
        jLayeredPane5.setLayout(jLayeredPane5Layout);
        jLayeredPane5Layout.setHorizontalGroup(
            jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6)
                    .addGroup(jLayeredPane5Layout.createSequentialGroup()
                        .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(numDA, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31))
                        .addGap(18, 18, 18)
                        .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                .addComponent(jourDA, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(moisDA, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(anneeDA, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel30))
                        .addGap(18, 18, 18)
                        .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                .addComponent(qcDA, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                                .addComponent(ajouter10, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jLayeredPane5Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addGap(54, 54, 54)
                        .addComponent(jLabel28)
                        .addGap(102, 102, 102)
                        .addComponent(jLabel29))
                    .addGroup(jLayeredPane5Layout.createSequentialGroup()
                        .addComponent(numAD, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(typeDA, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(capaciteDA, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(supprimer3)))
                .addContainerGap())
        );
        jLayeredPane5Layout.setVerticalGroup(
            jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(jLabel30)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numDA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jourDA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(anneeDA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(moisDA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(qcDA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ajouter10))
                .addGap(7, 7, 7)
                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel28)
                    .addComponent(jLabel29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(typeDA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(capaciteDA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(supprimer3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                .addContainerGap())
        );
        jLayeredPane5.setLayer(moisDA, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(jScrollPane6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(numAD, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(jLabel24, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(jLabel27, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(typeDA, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(qcDA, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(capaciteDA, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(supprimer3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(jLabel28, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(ajouter10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(jLabel29, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(jourDA, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(numDA, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(jLabel30, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(jLabel31, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(anneeDA, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTabbedPane4.addTab("Gestion Depart Avion", jLayeredPane5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTabbedPane1)
                    .addComponent(jTabbedPane3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTabbedPane2)
                    .addComponent(jTabbedPane3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTabbedPane4)
                    .addComponent(jTabbedPane1))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    

    private void numActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numActionPerformed

    private void numKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE)|| num.getText().length()==8)
        {   getToolkit().beep();
            evt.consume();
        }
        
    }//GEN-LAST:event_numKeyTyped

    private void jourMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jourMouseClicked

    }//GEN-LAST:event_jourMouseClicked

    private void jourMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jourMouseExited
        // TODO add your handling code here:

    }//GEN-LAST:event_jourMouseExited

    private void jourMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jourMouseReleased

    }//GEN-LAST:event_jourMouseReleased

    private void jourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jourActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jourActionPerformed

    private void jourKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jourKeyTyped
        char c=evt.getKeyChar();
        if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE )||jour.getText().length()==2)
        {   getToolkit().beep();
            evt.consume();
        }

    }//GEN-LAST:event_jourKeyTyped

    private void anneeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_anneeKeyTyped
        char c=evt.getKeyChar();
        if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE)||annee.getText().length()==4)
        {   getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_anneeKeyTyped

    private void moisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_moisMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_moisMouseClicked

    private void moisMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_moisMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_moisMouseExited

    private void moisMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_moisMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_moisMouseReleased

    private void moisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_moisActionPerformed

    private void moisKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_moisKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE )||mois.getText().length()==2)
        {   getToolkit().beep();
            evt.consume();
        }

    }//GEN-LAST:event_moisKeyTyped

    private void numKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numKeyReleased
 affiche();
    }//GEN-LAST:event_numKeyReleased

      private void afficheJTableVD(Object[][] MyArray)
    {
         jTableVD.setModel(new javax.swing.table.DefaultTableModel(
                        MyArray,
                        new String [] {
                            "Numero Vol", "Distance", "Fréquence", "Numero Depart", "Date"
                        }
                        )
                  {
                            boolean[] canEdit = new boolean [] {
                            false, false, false, false, false
                        };
                        @Override
                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                            return canEdit [columnIndex];
                        }
                    }
         );
    }
    
    private boolean testVD(DBObject object, int n)
    {
           String C[][]=new String[7][2];
   C[0][0]="numV";C[0][1]=numVVD.getText();
   C[1][0]="distance";C[1][1]=distanceVD.getText();
   C[2][0]="frequence";C[2][1]=frequenceVD.getText();   
   C[3][0]="numD";C[3][1]=numDVD.getText();
   C[4][0]="jour";C[4][1]=jourVD.getText();
   C[5][0]="mois";C[5][1]=moisVD.getText();
   C[6][0]="annee";C[6][1]=anneeVD.getText();
   int i=0;
   boolean ok;
        if(n==1)
        {
            ok=true;
            while(ok&&i<7)
            {
         ok = object.get(C[i][0]).toString().toUpperCase().contains(C[i][1].toUpperCase());         
         i++;
            }}        
         else 
        {
            ok=false;
             while(i<7)
            {
        ok = ok || object.get(C[i][0]).toString().toUpperCase().contains(anyVD.getText().toUpperCase());         
         i++;
            }
        }
        return ok;
    }
   
    
    private void afficheVD(int e)
{
        try {
            Connexion connexion = new Connexion("Airport");
             DBCursor listAvion = connexion.getListe("VDR");   
             int i=0;
             Object[][] tab = new Object[listAvion.count()][5];             
             while (listAvion.hasNext())
             {
                 DBObject object = listAvion.next();
                 if(testVD(object,e))   
                 {                   
                       tab[i][0]=object.get("numV");
                       tab[i][1]=object.get("distance");
                       tab[i][2]=object.get("frequence");
                       tab[i][3]=object.get("numD").toString().toUpperCase();                       
                       tab[i][4]=object.get("jour")+"/"+object.get("mois")+"/"+object.get("annee");
                      i++;
                 }
             }                                          
             Object[][] MyArray = new Object[i][5];
             for(int j=0;j<i;j++)
             {
                System.arraycopy(tab[j], 0, MyArray[j], 0, 5);
             }            
         
       afficheJTableVD(MyArray);
    
        } catch (UnknownHostException ex) {
            Logger.getLogger(GestionAvion.class.getName()).log(Level.SEVERE, null, ex);        
        }
   
}
    
    private void afficheJTableDA(Object[][] MyArray)
    {
         jTableDA.setModel(new javax.swing.table.DefaultTableModel(
                        MyArray,
                        new String [] {
                           "Numero Depart", "Date", "Numero Avion",
                            "Type", "Capacité", "Quantité Carburant", 
                        }
                        )
                  {
                                               boolean[] canEdit = new boolean [] {
                            false, false, false,false, false, false
                        };
                        @Override
                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                            return canEdit [columnIndex];
                        }
                    }
         );
    }
    
    private boolean testDA(DBObject object)
    {         
        return object.get("numA").toString().contains(numAD.getText().toUpperCase())
                         &&object.get("type").toString().contains(typeDA.getText().toUpperCase())
                         &&object.get("capacite").toString().contains(capaciteDA.getText().toUpperCase())
                &&object.get("numD").toString().contains(numDA.getText().toUpperCase())
                         &&object.get("jour").toString().contains(jourDA.getText().toUpperCase())
                &&object.get("mois").toString().contains(moisDA.getText().toUpperCase())
                         &&object.get("annee").toString().contains(anneeDA.getText().toUpperCase())
                &&object.get("qc").toString().contains(qcDA.getText().toUpperCase());
    }
   
    
    private void afficheDA()
{
        try {
            Connexion connexion = new Connexion("Airport");
             DBCursor listDAR = connexion.getListe("DAR");
             int i=0;
             Object[][] tab = new Object[listDAR.count()][6];             
             while (listDAR.hasNext())
             {
                 DBObject object = listDAR.next();
                 if(testDA(object))                    
                 
                 {                    
                     tab[i][0]=object.get("numD");
                     tab[i][1]=object.get("jour")+"/"+object.get("mois")+"/"+object.get("annee");
                     tab[i][2]=object.get("numA");
                     tab[i][3]=object.get("type");
                     tab[i][4]=object.get("capacite");
                     tab[i][5]=object.get("qc");
                      i++;
                 }
             }                             
             
             Object[][] MyArray = new Object[i][6];
             for(int j=0;j<i;j++)
             {
                 MyArray[j][0]=tab[j][0];
                    MyArray[j][1]=tab[j][1];
                       MyArray[j][2]=tab[j][2];
                       MyArray[j][3]=tab[j][3];
                       MyArray[j][4]=tab[j][4];
                       MyArray[j][5]=tab[j][5];
             }            
         
       afficheJTableDA(MyArray);
        } catch (UnknownHostException ex) {
            Logger.getLogger(GestionAvion.class.getName()).log(Level.SEVERE, null, ex);        
        }
   
}
    
    private void afficheJTablePD(Object[][] MyArray)
    {
         jTablePD.setModel(new javax.swing.table.DefaultTableModel(
                        MyArray,
                        new String [] {
                              "Numero Depart", "Date", "Type",
                            "N° CIN", "Nom", "Prénom", "Adresse", "N° Tel"
                        }
                        )
                  {
                            boolean[] canEdit = new boolean [] {
                            false, false, false, false, false, false, false, false, false, false
                        };
                        @Override
                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                            return canEdit [columnIndex];
                        }
                    }
         );
    }
    
    private boolean testPD(DBObject object, int n)
    {
        String C[][]=new String[10][2];
   C[0][0]="numD";C[0][1]=numD.getText();
   C[1][0]="jour";C[1][1]=jourPD.getText();
   C[2][0]="mois";C[2][1]=moisPD.getText();
   C[3][0]="annee";C[3][1]=anneePD.getText();
   String Type = listPD.getSelectedItem().toString();
   if (Type.equals("Non Navigant"))
       Type = "NonNavigant";
   C[4][0]="type";C[4][1]=Type;
   C[5][0]="numCIN";C[5][1]=numPD.getText();
   C[6][0]="nom";C[6][1]=nomPD.getText();
   C[7][0]="prenom";C[7][1]=prenomPD.getText();   
   C[8][0]="adresse";C[8][1]=adressePD.getText();
   C[9][0]="numTel";C[9][1]=numTelPD.getText();
   int i=0;
   boolean ok;
        if(n==1)
        {ok=true;
            while(ok&&i<10)
            {
         ok = object.get(C[i][0]).toString().toUpperCase().contains(C[i][1].toUpperCase());
         
         i++;
            }}
        else if(n==2)
        {ok=false;
         if(object.get(C[4][0]).toString().toUpperCase().equals(C[4][1].toUpperCase()))
             while(i<10)
           {        
         ok = ok || object.get(C[i][0]).toString().toUpperCase().contains(anyPD.getText().toUpperCase());         
         i++;         
         if(i==4)i++;
            }
        }
        else if(n==3)
        {
            ok=true;
             while(ok&&i<10)
            {
         ok = object.get(C[i][0]).toString().toUpperCase().contains(C[i][1].toUpperCase());
         i++;
         if(i==4)i++;
            }
        }
         else 
        {
            ok=false;
             while(i<10)
            {
        ok = ok || object.get(C[i][0]).toString().toUpperCase().contains(anyPD.getText().toUpperCase());         
         i++;
         if(i==4)i++;
            }
        }
        return ok;
    }
   
    
    private void afficheDPR(int e)
{
        try {
            Connexion connexion = new Connexion("Airport");
             DBCursor listAvion = connexion.getListe("DPR");
             String Type = listPD.getSelectedItem().toString();
   if (Type.equals("Non Navigant"))
       Type = "NonNavigant";
   if((listPD.getSelectedItem().toString().equals("Tous"))&&(e==2))
       e=4;
   if((listPD.getSelectedItem().toString().equals("Tous"))&&(e==1))
       e=3;
   
             int i=0;
             Object[][] tab = new Object[listAvion.count()][8];             
             while (listAvion.hasNext())
             {
                 DBObject object = listAvion.next();
                 if(testPD(object,e))                    
                 
                 {                   
                       tab[i][0]=object.get("numD");
                       tab[i][1]=object.get("jour")+"/"+object.get("mois")+"/"+object.get("annee");
                       tab[i][2]=object.get("type").toString().toUpperCase();
                       tab[i][3]=object.get("numCIN");
                       tab[i][4]=object.get("nom").toString().toUpperCase();
                       tab[i][5]=object.get("prenom").toString().toUpperCase();
                       tab[i][6]=object.get("adresse").toString().toUpperCase();
                       tab[i][7]=object.get("numTel");
                      i++;
                 }
             }                                          
             Object[][] MyArray = new Object[i][8];
             for(int j=0;j<i;j++)
             {
                System.arraycopy(tab[j], 0, MyArray[j], 0, 8);
             }            
         
       afficheJTablePD(MyArray);
    
        } catch (UnknownHostException ex) {
            Logger.getLogger(GestionAvion.class.getName()).log(Level.SEVERE, null, ex);        
        }
   
}
    
    
    private void afficheJTableV(Object[][] MyArray)
    {
         jTableV.setModel(new javax.swing.table.DefaultTableModel(
                        MyArray,
                        new String [] {
                            "Numero", "Distance", "Fréquence"
                        }
                        )
                  {
                                               boolean[] canEdit = new boolean [] {
                            false, false, false
                        };
                        @Override
                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                            return canEdit [columnIndex];
                        }
                    }
         );
    }
    
    private boolean testV(DBObject object, int i)
    {
        return object.get("num").toString().contains(numV.getText().toUpperCase())
                         &&object.get("frequence").toString().contains(frequence.getText().toUpperCase())
                         &&object.get("distance").toString().contains(distance.getText().toUpperCase());
        
    }
   
    
    private void afficheV(int e)
{
        try {
            Connexion connexion = new Connexion("Airport");
             DBCursor listAvion = connexion.getListe("Vol");
             int i=0;
             Object[][] tab = new Object[listAvion.count()][3];             
             while (listAvion.hasNext())
             {
                 DBObject object = listAvion.next();
                 if(testV(object,e))                    
                 
                 {                    
                     tab[i][0]=object.get("num");
                     tab[i][1]=object.get("distance");
                     tab[i][2]=object.get("frequence");
                      i++;
                 }
             }                             
             
             Object[][] MyArray = new Object[i][3];
             for(int j=0;j<i;j++)
             {
                 MyArray[j][0]=tab[j][0];
                    MyArray[j][1]=tab[j][1];
                       MyArray[j][2]=tab[j][2];
             }            
         
       afficheJTableV(MyArray);
        } catch (UnknownHostException ex) {
            Logger.getLogger(GestionAvion.class.getName()).log(Level.SEVERE, null, ex);        
        }
   
}

    
    private void afficheJTableA(Object[][] MyArray)
    {
         jTableA.setModel(new javax.swing.table.DefaultTableModel(
                        MyArray,
                        new String [] {
                            "Numero", "Type", "Capacité"
                        }
                        )
                  {
                                               boolean[] canEdit = new boolean [] {
                            false, false, false
                        };
                        @Override
                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                            return canEdit [columnIndex];
                        }
                    }
         );
    }
    
    private boolean testA(DBObject object, int i)
    {
        if(i==1)
        return object.get("num").toString().contains(numA.getText().toUpperCase())
                         &&object.get("type").toString().contains(type.getText().toUpperCase())
                         &&object.get("capacite").toString().contains(capacite.getText().toUpperCase());
        else return
                object.get("num").toString().contains(anyA.getText().toUpperCase())
                         ||object.get("type").toString().contains(anyA.getText().toUpperCase())
                         ||object.get("capacite").toString().contains(anyA.getText().toUpperCase());
    }
   
    
    private void afficheA(int e)
{
        try {
            Connexion connexion = new Connexion("Airport");
             DBCursor listAvion = connexion.getListe("Avion");
             int i=0;
             Object[][] tab = new Object[listAvion.count()][3];             
             while (listAvion.hasNext())
             {
                 DBObject object = listAvion.next();
                 if(testA(object,e))                    
                 
                 {                    
                     tab[i][0]=object.get("num");
                     tab[i][1]=object.get("type");
                     tab[i][2]=object.get("capacite");
                      i++;
                 }
             }                                          
             Object[][] MyArray = new Object[i][3];
             for(int j=0;j<i;j++)
             {
                 MyArray[j][0]=tab[j][0];
                    MyArray[j][1]=tab[j][1];
                       MyArray[j][2]=tab[j][2];
             }            
         
       afficheJTableA(MyArray);
        } catch (UnknownHostException ex) {
            Logger.getLogger(GestionAvion.class.getName()).log(Level.SEVERE, null, ex);        
        }
   
}

    
     
   private void afficheJTableP(Object[][] MyArray)
    {
         jTableP.setModel(new javax.swing.table.DefaultTableModel(
                        MyArray,
                        new String [] {
                           "N° CIN", "Nom", "Prenom", "Adresse", "N° Tel"
                        }
                        )
                  {
                                               boolean[] canEdit = new boolean [] {
                            false, false, false,false,false
                        };
                        @Override
                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                            return canEdit [columnIndex];
                        }
                    }
         );
    }
   private boolean test(DBObject object,int e)
   {
       if(e==1)
       {
   return object.get("cin").toString().contains(num1.getText().toUpperCase())
                         &&object.get("nom").toString().toUpperCase().contains(nom1.getText().toUpperCase())
                         &&object.get("prenom").toString().toUpperCase().contains(prenom1.getText().toUpperCase())
                         &&object.get("adresse").toString().toUpperCase().contains(adresse1.getText().toUpperCase())
                          &&object.get("numTel").toString().contains(numTel1.getText().toUpperCase());
       }
       else{ return object.get("cin").toString().contains(any.getText().toUpperCase())
                         ||object.get("nom").toString().toUpperCase().contains(any.getText().toUpperCase())
                         ||object.get("prenom").toString().toUpperCase().contains(any.getText().toUpperCase())
                         ||object.get("adresse").toString().toUpperCase().contains(any.getText().toUpperCase())
                          ||object.get("numTel").toString().contains(any.getText().toUpperCase());}
  }
      private void affiche(int e)
{
        try {
            Connexion connexion = new Connexion("Airport");
            String collection=list.getSelectedItem().toString();
  
    if(collection.equals("Non Navigant"))
    collection="NonNavigant"; 
            if(!collection.equals("Tous"))
            {                
             DBCursor listPersonne = connexion.getListe(collection);             
             Object[][] tab = new Object[listPersonne.count()][5];             
                
    int i=0;
             while (listPersonne.hasNext())
             {
                 DBObject object = listPersonne.next();     
                 if(test(object,e))
                 {                       
                     tab[i][0]=object.get("cin");
                     tab[i][1]=object.get("nom").toString().toUpperCase();
                     tab[i][2]=object.get("prenom").toString().toUpperCase();
                     tab[i][3]=object.get("adresse").toString().toUpperCase();
                     tab[i][4]=object.get("numTel");
                      i++; 
                 }
             }
             Object[][] MyArray = new Object[i][5];
             for(int j=0;j<i;j++)
             {   for(int k=0;k<5;k++)             
                 MyArray[j][k]=tab[j][k];
             } 
       afficheJTableP(MyArray);
            }else
            {
                 String Collection[] = new String[]{
            "Navigant","NonNavigant","Passager","Personnel","Pilote"};
                 
               DBCursor list; 
               int tot=0;
          Object all[] = new Object[5];
          int taille[]=new int[5];
                 for(int i=0;i<5;i++)
                 {
          list = connexion.getListe(Collection[i]);
          Object[][] tab = new Object[list.count()][6];
          int j=0;
          while (list.hasNext())
             {
                 DBObject object = list.next();     
                 if(test(object,e))
                 {      
                     tab[j][0]=Collection[i];
                     tab[j][1]=object.get("cin");
                     tab[j][2]=object.get("nom").toString().toUpperCase();
                     tab[j][3]=object.get("prenom").toString().toUpperCase();
                     tab[j][4]=object.get("adresse").toString().toUpperCase();
                     tab[j][5]=object.get("numTel");
                      j++; 
                 }
             }
          tot+=j;
           Object[][] MyArray1 = new Object[j][6];
             for(int l=0;l<j;l++)
             {   System.arraycopy(tab[l], 0, MyArray1[l], 0, 6);
             } 
             all[i]=MyArray1;
             taille[i]=j;
                 }
        Matrix tab = new Matrix(tot,6);
         Object[][] MyArray = null;
          for(int i=0;i<5;i++)
                 {
         MyArray = tab.add((Object[][])all[i],taille[i],6);
                 }
         jTableP.setModel(new javax.swing.table.DefaultTableModel(
                 MyArray , 
                        new String [] {
                            "Type","N° CIN", "Nom", "Prenom", "Adresse", "N° Tel"
                        }
                        )
                  {
                            boolean[] canEdit = new boolean [] {
                            false, false, false,false,false,false
                        };
                        @Override
                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                            return canEdit [columnIndex];
                        }
                    }
         );
         
            }
        } catch (UnknownHostException ex) {
            Logger.getLogger(GestionAvion.class.getName()).log(Level.SEVERE, null, ex);        
        }
   
}
    private void afficheJTableD(Object[][] MyArray)
    {
         jTableD.setModel(new javax.swing.table.DefaultTableModel(
                        MyArray,
                        new String [] {
                             "Numero", "Date"
                        }
                        )
                  {
                                               boolean[] canEdit = new boolean [] {
                            false, false
                        };
                        @Override
                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                            return canEdit [columnIndex];
                        }
                    }
         );
    }
   
    private void affiche()
{
        try {
            Connexion connexion = new Connexion("Airport");
             DBCursor listDepart = connexion.getListe("Depart");
             int i=0;
             Object[][] tab = new Object[listDepart.count()][2];             
             while (listDepart.hasNext())
             {
                 DBObject object = listDepart.next();
                 if(object.get("num").toString().contains(num.getText().toUpperCase())
                         &&object.get("jour").toString().contains(jour.getText().toUpperCase())
                         &&object.get("mois").toString().contains(mois.getText().toUpperCase())
                         &&object.get("annee").toString().contains(annee.getText().toUpperCase()))                                     
                 {                    
                     tab[i][0]=object.get("num");
                     tab[i][1]=object.get("jour").toString()
                             +"/"+object.get("mois").toString()
                             +"/"+object.get("annee").toString();
                      i++;
                 }
             }                             
             
             Object[][] MyArray = new Object[i][2];
             for(int j=0;j<i;j++)
             {
                 MyArray[j][0]=tab[j][0];
                    MyArray[j][1]=tab[j][1];
             }            
         
       afficheJTableD(MyArray);
        } catch (UnknownHostException ex) {
            Logger.getLogger(GestionDepart.class.getName()).log(Level.SEVERE, null, ex);        
        }
   
}
   
    private void anneeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_anneeKeyReleased
   affiche();
    }//GEN-LAST:event_anneeKeyReleased

    private void moisKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_moisKeyReleased
affiche();
    }//GEN-LAST:event_moisKeyReleased

    private void jourKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jourKeyReleased
affiche();
    }//GEN-LAST:event_jourKeyReleased

    private void ajouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterActionPerformed

        // TODO add your handling code here:
        try{
        String jour1=jour.getText();
        int jour2 = Integer.parseInt(jour1);
        String mois1=mois.getText();
        int mois2 = Integer.parseInt(mois1);
        String annee1=annee.getText();
        int annee2 = Integer.parseInt(annee1);
        if(list.getSelectedIndex()!=3)
            list.setSelectedIndex(3);
        
        if(num.getText().length()==0)
        {
            JOptionPane.showMessageDialog(null, "*****  Saisir Le Numero  *****");

        }
        else if(jour.getText().length()==0)
        {
            JOptionPane.showMessageDialog(null, "*****  Saisir Le Jour  *****");
        }else if(mois.getText().length()==0)
        {
            JOptionPane.showMessageDialog(null, "*****  Saisir Le Mois  *****");
        }else if(annee.getText().length()==0)
        {
            JOptionPane.showMessageDialog(null, "*****  Saisir L'Annee  *****");
        }
        else if(annee.getText().length()<4)
        {
            JOptionPane.showMessageDialog(null, "*****  Annee Incorrect  *****");
        }
        else if((jour2>31)||(jour2==0)){
            JOptionPane.showMessageDialog(null, "*****  Jour Incorrect  *****");
        }
        else if((mois2>12)||jour2==0){
            JOptionPane.showMessageDialog(null, "*****  Mois Incorrect  *****");
        }
        else if(jour.getText().equals("31")&&(!(mois.getText().equals("1")||
            mois.getText().equals("01")||
            mois.getText().equals("3")||mois.getText().equals("03")||
            mois.getText().equals("5")||mois.getText().equals("05")||
            mois.getText().equals("7")||mois.getText().equals("07")||
            mois.getText().equals("8")||mois.getText().equals("08")||
            mois.getText().equals("10")||mois.getText().equals("12"))))
{
    JOptionPane.showMessageDialog(null, "*****  Jour Incorrect  *****");
    }
    else if((mois.getText().equals("2")||mois.getText().equals("02"))&&
        (jour.getText().equals("30")||mois.getText().equals("31")))
        {
            JOptionPane.showMessageDialog(null, "*****  Jour Incorrect  *****");
        }else if((annee2%4!=0)&&(jour2>28)&&(mois2==2))
        {
            JOptionPane.showMessageDialog(null, "*****  Jour Incorrect  *****");
        }else if(qc.getText().length()==0)
        {
             JOptionPane.showMessageDialog(null, "*****  Saisir Le Quantite De Carburant  *****");
             
        }
        else if(jTableP.getSelectedRow()<0)
        {  
                               
            JOptionPane.showMessageDialog(null, "*****  Selectionner Un Personnel  *****");
        }
         else if(jTableA.getSelectedRow()<0)
        {  
                               
            JOptionPane.showMessageDialog(null, "*****  Selectionner Une Avion  *****");
        }
           else if(jTableV.getSelectedRow()<0)
        {  
                               
            JOptionPane.showMessageDialog(null, "*****  Selectionner Une Vol  *****");
        }
        else
            
        {
            Date date = new Date(jour.getText(),mois.getText(),annee.getText());
            Depart d = new Depart(num.getText(),date);
            Passager P = new Passager(jTableP.getValueAt(jTableP.getSelectedRow(), 0).toString());
             DPR dpr = new DPR(d,P,"Personnel");
              Vol V = new Vol(jTableV.getValueAt(jTableV.getSelectedRow(), 0).toString());
               Avion A = new Avion(jTableA.getValueAt(jTableA.getSelectedRow(), 0).toString());
               DAR dar = new DAR(d,A,qc.getText().toUpperCase());
               VDR vdr = new VDR(V,d);
            try {
                if (d.recherche("Depart"))
                {
                    d.ajouter("Depart");
                    vdr.ajouter("VDR");
                    dar.ajouter("DAR");
                     dpr.ajouter("DPR","Personnel");
        affiche();
          afficheVD(1);  
           afficheDA();
                }
                else JOptionPane.showMessageDialog(null, "Deja Existe");
            } catch (UnknownHostException ex) {
                Logger.getLogger(GestionDepart.class.getName()).log(Level.SEVERE, null, ex);
            }       
            
        }
        }
        catch (NumberFormatException n)
            {
                JOptionPane.showMessageDialog(null, "Date Incorrect");
            }
    }//GEN-LAST:event_ajouterActionPerformed

    private void ajouter1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouter1ActionPerformed
        num.setText("");
        jour.setText("");
        mois.setText("");
        annee.setText("");
        qc.setText("");
        affiche();// TODO add your handling code here:
    }//GEN-LAST:event_ajouter1ActionPerformed

    private void supprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimerActionPerformed
        // TODO add your handling code here:
        if(jTableD.getSelectedRow()<0)
        {
            JOptionPane.showMessageDialog(null, "*****  Selectionner Une Seule Depart  *****");
        }else{
            Depart p = new Depart(jTableD.getValueAt(jTableD.getSelectedRow(), 0).toString());
            DAR dar = new DAR(new Depart(jTableD.getValueAt(jTableD.getSelectedRow(), 0).toString()));
            DPR dpr = new DPR(new Depart(jTableD.getValueAt(jTableD.getSelectedRow(), 0).toString()));
            PDR pn = new PDR(new Depart(jTableD.getValueAt(jTableD.getSelectedRow(), 0).toString()));
            VDR vdr = new VDR(new Depart(jTableD.getValueAt(jTableD.getSelectedRow(), 0).toString()));
            try {
                p.supprimer("Depart");
                dar.supprimerDepart("DAR");
                dpr.supprimerDepart("DPR");
                vdr.supprimerDepart("VDR");
                afficheDA(); 
            } catch (UnknownHostException ex) {
                Logger.getLogger(GestionDepart.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        affiche();
    }//GEN-LAST:event_supprimerActionPerformed

    private void qcKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qcKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE)|| qc.getText().length()==5)
        {   getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_qcKeyTyped

    private void supprimer2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimer2ActionPerformed
        // TODO add your handling code here:

        if(jTableP.getSelectedRow()<0)
        {
            JOptionPane.showMessageDialog(null, "*****  Selectionner Une Personne  *****");
        }else
        {
            try {
                String collection = list.getSelectedItem().toString();
                if(collection.equals("Non Navigant"))
                collection="NonNavigant";
                if(!collection.equals("Tous"))
                {
                    Navigant p = new Navigant(jTableP.getValueAt(jTableP.getSelectedRow(), 0).toString());
                    DPR pdr = new DPR(new Passager(jTableP.getValueAt(jTableP.getSelectedRow(), 0).toString()));
                    p.supprimer(collection);
                    pdr.supprimerPassager("DPR",collection);

                }
                else
                {
                    Navigant p = new Navigant(jTableP.getValueAt(jTableP.getSelectedRow(), 1).toString());
                    DPR pdr = new DPR(new Passager(jTableP.getValueAt(jTableP.getSelectedRow(), 1).toString()));
                    p.supprimer(jTableP.getValueAt(jTableP.getSelectedRow(), 0).toString());
                    pdr.supprimerPassager("DPR",jTableP.getValueAt(jTableP.getSelectedRow(), 0).toString());

                }
                affiche(1);
            } catch (UnknownHostException ex) {
                Logger.getLogger(GestionPersonne.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_supprimer2ActionPerformed

    private void adresse1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_adresse1KeyReleased
        affiche(1);        // TODO add your handling code here:
    }//GEN-LAST:event_adresse1KeyReleased

    private void nom1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nom1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nom1ActionPerformed

    private void nom1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nom1KeyReleased
        affiche(1);        // TODO add your handling code here:
    }//GEN-LAST:event_nom1KeyReleased

    private void anyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_anyKeyReleased
        affiche(2);   // TODO add your handling code here:
    }//GEN-LAST:event_anyKeyReleased

    private void anyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_anyKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_anyKeyTyped

    private void listActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listActionPerformed
       
        if(any.getText().length()>0)
        affiche(2);
        else
        affiche(1);

    }//GEN-LAST:event_listActionPerformed

    private void num1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_num1ActionPerformed

    private void num1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_num1KeyReleased
        affiche(1);
    }//GEN-LAST:event_num1KeyReleased

    private void num1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_num1KeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE)|| num1.getText().length()==8)
        {   getToolkit().beep();
            evt.consume();
        }

    }//GEN-LAST:event_num1KeyTyped

    private void prenom1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prenom1KeyReleased
        affiche(1);        // TODO add your handling code here:
    }//GEN-LAST:event_prenom1KeyReleased

    private void numTel1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numTel1KeyReleased
        affiche(1);        // TODO add your handling code here:
    }//GEN-LAST:event_numTel1KeyReleased

    private void numTel1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numTel1KeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE)|| numTel1.getText().length()==8)
        {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_numTel1KeyTyped

    private void ajouter2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouter2ActionPerformed
        // TODO add your handling code here:
 String collection = list.getSelectedItem().toString();
        if(num1.getText().length()<8)
        {
            JOptionPane.showMessageDialog(null, "*****  Numero CIN Incorrect  *****");

        }else if(nom1.getText().length()==0)
        {
            JOptionPane.showMessageDialog(null, "*****  Saisir Votre Nom  *****");
        }else if(numTel1.getText().length()<8)
        {
            JOptionPane.showMessageDialog(null, "*****  Num Tel Incorrect  *****");
        }else if(prenom1.getText().length()==0)
        {
            JOptionPane.showMessageDialog(null, "*****  Saisir Votre Prenom  *****");
        }else if(adresse1.getText().length()==0)
        {
            JOptionPane.showMessageDialog(null, "*****  Saisir Votre Adresse  *****");
        }
         else if((collection.equals("Passager"))&&(jTableD.getSelectedRow()<0))
        {
            JOptionPane.showMessageDialog(null, "*****  Selectionner Un Depart  *****");
        }
        else
        {
            try {
                Navigant n = new Navigant(num1.getText().toUpperCase(),
                    nom1.getText().toUpperCase(),prenom1.getText().toUpperCase(),
                    adresse1.getText().toUpperCase(),numTel1.getText().toUpperCase());
                Passager P = new Passager(num1.getText().toUpperCase());
                if(collection.equals("Non Navigant"))
                collection="NonNavigant";
                if(!collection.equals("Tous"))
                {
                    if (n.recherche(collection))
                    {
                        n.ajouter(collection);
                        if(collection.equals("Passager"))
                        {
                            Depart D = new Depart(jTableD.getValueAt(jTableD.getSelectedRow(), 0).toString());
                            DPR dpr = new DPR(D,P,collection);
                            dpr.ajouter("DPR",collection);
                        }
                        affiche(1);
                    }
                    else JOptionPane.showMessageDialog(null, "Deja Existe");
                }else JOptionPane.showMessageDialog(null, "Choisir Le Type");
            } catch (UnknownHostException ex) {
                Logger.getLogger(GestionPersonne.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_ajouter2ActionPerformed

    private void ajouter3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouter3ActionPerformed
        num1.setText("");
        nom1.setText("");
        prenom1.setText("");
        numTel1.setText("");
        adresse1.setText("");
        any.setText("");
        affiche(1);
    }//GEN-LAST:event_ajouter3ActionPerformed

    private void anyAKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_anyAKeyReleased
        afficheA(2);
    }//GEN-LAST:event_anyAKeyReleased

    private void ajouter4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouter4ActionPerformed
        if(numA.getText().length()==0)
        {
            JOptionPane.showMessageDialog(null, "*****  Saisir Le Numero  *****");

        }else if(type.getText().length()==0)
        {
            JOptionPane.showMessageDialog(null, "*****  Saisir Le Type  *****");
        }else if(capacite.getText().length()==0)
        {
            JOptionPane.showMessageDialog(null, "*****  Saisir La Capacite  *****");
        }

        else
        {
            try {
                Avion p = new Avion(numA.getText().toUpperCase(),type.getText().toUpperCase(),capacite.getText().toUpperCase());
                if (p.recherche("Avion"))
                {
                    p.ajouter("Avion");
                    afficheA(1);
                }
                else JOptionPane.showMessageDialog(null, "Deja Existe");

            } catch (UnknownHostException ex) {
                Logger.getLogger(GestionAvion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_ajouter4ActionPerformed

    private void ajouter5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouter5ActionPerformed
        numA.setText("");
        type.setText("");
        capacite.setText("");
        anyA.setText("");
        afficheA(1);// TODO add your handling code here:
    }//GEN-LAST:event_ajouter5ActionPerformed

    private void ajouter6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouter6ActionPerformed

        if(jTableA.getSelectedRow()<0)
        {
            JOptionPane.showMessageDialog(null, "*****  Selectionner Une Avion  *****");
        }
        else
        {
            Avion p = new Avion(jTableA.getValueAt(jTableA.getSelectedRow(), 0).toString().toUpperCase());
            DAR dar = new DAR(new Avion(jTableA.getValueAt(jTableA.getSelectedRow(), 0).toString().toUpperCase()));
            try {
                p.supprimer("Avion");
                dar.supprimerAvion("DAR");
            } catch (UnknownHostException ex) {
                Logger.getLogger(GestionAvion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        afficheA(1);
    }//GEN-LAST:event_ajouter6ActionPerformed

    private void numAKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numAKeyReleased
        afficheA(1);        // TODO add your handling code here:
    }//GEN-LAST:event_numAKeyReleased

    private void numAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numAKeyTyped
        char c=evt.getKeyChar();
        if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE)|| numA.getText().length()==8)
        {   getToolkit().beep();
            evt.consume();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_numAKeyTyped

    private void typeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_typeKeyReleased
        afficheA(1);        // TODO add your handling code here:
    }//GEN-LAST:event_typeKeyReleased

    private void capaciteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_capaciteKeyReleased
        afficheA(1);        // TODO add your handling code here:
    }//GEN-LAST:event_capaciteKeyReleased

    private void capaciteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_capaciteKeyTyped
        char c=evt.getKeyChar();
        if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE)|| capacite.getText().length()==4)
        {   getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_capaciteKeyTyped

    private void numVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numVActionPerformed

    private void numVKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numVKeyReleased
        afficheV(1);        // TODO add your handling code here:
    }//GEN-LAST:event_numVKeyReleased

    private void numVKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numVKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE)|| numV.getText().length()==8)
        {   getToolkit().beep();
            evt.consume();
        }

    }//GEN-LAST:event_numVKeyTyped

    private void distanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_distanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_distanceActionPerformed

    private void distanceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_distanceKeyReleased
        afficheV(1);        // TODO add your handling code here:
    }//GEN-LAST:event_distanceKeyReleased

    private void distanceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_distanceKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE))
        {   getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_distanceKeyTyped

    private void frequenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_frequenceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_frequenceActionPerformed

    private void frequenceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_frequenceKeyReleased
        afficheV(1);        // TODO add your handling code here:
    }//GEN-LAST:event_frequenceKeyReleased

    private void frequenceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_frequenceKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE))
        {   getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_frequenceKeyTyped

    private void ajouter7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouter7ActionPerformed
        // TODO add your handling code here:

        if(numV.getText().length()==0)
        {
            JOptionPane.showMessageDialog(null, "*****  Saisair Le Numero  *****");

        }else if(distance.getText().length()==0)
        {
            JOptionPane.showMessageDialog(null, "*****  Saisir La Distance  *****");
        }else if(frequence.getText().length()==0)
        {
            JOptionPane.showMessageDialog(null, "*****  Saisir La Frequence  *****");
        }       
        else
        {
            Vol v = new Vol(numV.getText(),distance.getText(),frequence.getText());            
            try {
                if (v.recherche("Vol"))
                {
                    v.ajouter("Vol");
                    afficheV(1);
                }
                else JOptionPane.showMessageDialog(null, "Deja Existe");
            } catch (UnknownHostException ex) {
                Logger.getLogger(GestionVol.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_ajouter7ActionPerformed

    private void ajouter8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouter8ActionPerformed
        numV.setText("");
        frequence.setText(""); distance.setText(""); any.setText("");
        afficheV(1);
    }//GEN-LAST:event_ajouter8ActionPerformed

    private void supprimer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimer1ActionPerformed
        // TODO add your handling code here:

        if(jTableV.getSelectedRow()<0)
        {
            JOptionPane.showMessageDialog(null, "*****  Selectionner Une Vol  *****");
        }

        else
        {
            Vol v = new Vol(jTableV.getValueAt(jTableV.getSelectedRow(), 0).toString());
            VTR vtr = new VTR(new Vol(jTableV.getValueAt(jTableV.getSelectedRow(), 0).toString()));
            VDR p = new VDR(new Vol(jTableV.getValueAt(jTableV.getSelectedRow(), 0).toString()));
            try {
                v.supprimer("Vol");
                vtr.supprimerVol("VTR");
                p.supprimerVol("VDR");
                afficheV(1);

            } catch (UnknownHostException ex) {
                Logger.getLogger(GestionVol.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_supprimer1ActionPerformed

    private void ajouter9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouter9ActionPerformed
        // TODO add your handling code here:
        if(jTableP.getSelectedRow()<0)
        {
             JOptionPane.showMessageDialog(null, "*****  Selectionner Une Personne  *****");
        }
        else 
             if(jTableD.getSelectedRow()<0)
        {
             JOptionPane.showMessageDialog(null, "*****  Selectionner Un Depart  *****");
        }
        else             
             {
                  try {
                      String collection;
                      Passager P;
           if(!list.getSelectedItem().toString().equals("Tous"))
           {
             P = new Passager(jTableP.getValueAt(jTableP.getSelectedRow(), 0).toString());
             collection=list.getSelectedItem().toString();
          if(collection.equals("Non Navigant")) 
              collection = "NonNavigant";
           }else
           {
             P = new Passager(jTableP.getValueAt(jTableP.getSelectedRow(), 1).toString());
            collection=jTableP.getValueAt(jTableP.getSelectedRow(), 0).toString();
           }
            Depart D = new Depart(jTableD.getValueAt(jTableD.getSelectedRow(), 0).toString());           
            
         DPR dpr = new DPR(D,P,collection);
            if (dpr.rechercheType("DPR"))
            {                
           dpr.ajouter("DPR",collection);
           afficheDPR(1);
            }
            else JOptionPane.showMessageDialog(null, "Deja Existe");
        
        }   catch (UnknownHostException ex) {
                Logger.getLogger(AjoutDPR.class.getName()).log(Level.SEVERE, null, ex);
            }
             }
    }//GEN-LAST:event_ajouter9ActionPerformed

    private void numDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numDActionPerformed

    private void numDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numDKeyReleased
        afficheDPR(1);        // TODO add your handling code here:
    }//GEN-LAST:event_numDKeyReleased

    private void numDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numDKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE)|| numD.getText().length()==8)
        {   getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_numDKeyTyped

    private void anneePDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_anneePDKeyReleased
        afficheDPR(1);
    }//GEN-LAST:event_anneePDKeyReleased

    private void anneePDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_anneePDKeyTyped
        char c=evt.getKeyChar();
        if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE)||annee.getText().length()==4)
        {   getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_anneePDKeyTyped

    private void moisPDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_moisPDMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_moisPDMouseClicked

    private void moisPDMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_moisPDMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_moisPDMouseExited

    private void moisPDMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_moisPDMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_moisPDMouseReleased

    private void moisPDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moisPDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_moisPDActionPerformed

    private void moisPDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_moisPDKeyReleased
        afficheDPR(1);
    }//GEN-LAST:event_moisPDKeyReleased

    private void moisPDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_moisPDKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE )||mois.getText().length()==2)
        {   getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_moisPDKeyTyped

    private void annulerPDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_annulerPDActionPerformed
        numPD.setText("");
        numD.setText("");
        jourPD.setText(""); moisPD.setText("");
        anneePD.setText("");
        nomPD.setText("");
        prenomPD.setText("");
        adressePD.setText("");
        anyPD.setText("");
        numTelPD.setText("");
        afficheDPR(1);// TODO add your handling code here:
    }//GEN-LAST:event_annulerPDActionPerformed

    private void supprimerPDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimerPDActionPerformed
        if(jTablePD.getSelectedRow()<0)
        {
            JOptionPane.showMessageDialog(null, "*****  Selectionner Une Relation  *****");
        }
        else
        {
            String type =jTablePD.getValueAt(jTablePD.getSelectedRow(), 2).toString();
            if(type.equals("NAVIGANT"))
            type="Navigant";
            else if(type.equals("NONNAVIGANT"))
            type="NonNavigant";
            if(type.equals("PILOTE"))
            type="Pilote";
            if(type.equals("PERSONNEL"))
            type="Personnel";
            if(type.equals("PASSAGER"))
            type="Passager";
            DPR dpr = new DPR(new Depart(jTablePD.getValueAt(jTablePD.getSelectedRow(), 0).toString()),
                    new Passager(jTablePD.getValueAt(jTablePD.getSelectedRow(), 3).toString()),
                type);
            try {
                dpr.supprimer("DPR");
            } catch (UnknownHostException ex) {
                Logger.getLogger(GestionDepart.class.getName()).log(Level.SEVERE, null, ex);
           }
            afficheDPR(1);
        }
    }//GEN-LAST:event_supprimerPDActionPerformed

    private void numPDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numPDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numPDActionPerformed

    private void numPDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numPDKeyReleased
        afficheDPR(1);
    }//GEN-LAST:event_numPDKeyReleased

    private void numPDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numPDKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE)|| numPD.getText().length()==8)
        {   getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_numPDKeyTyped

    private void nomPDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomPDKeyReleased
        afficheDPR(1);        // TODO add your handling code here:
    }//GEN-LAST:event_nomPDKeyReleased

    private void anyPDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_anyPDKeyReleased
        if(anyPD.getText().length()==0)afficheDPR(1);
        else
        afficheDPR(2);   // TODO add your handling code here:
    }//GEN-LAST:event_anyPDKeyReleased

    private void anyPDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_anyPDKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_anyPDKeyTyped

    private void prenomPDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prenomPDKeyReleased
        afficheDPR(1);        // TODO add your handling code here:
    }//GEN-LAST:event_prenomPDKeyReleased

    private void numTelPDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numTelPDKeyReleased
        afficheDPR(1);        // TODO add your handling code here:
    }//GEN-LAST:event_numTelPDKeyReleased

    private void numTelPDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numTelPDKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE)|| numTelPD.getText().length()==8)
        {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_numTelPDKeyTyped

    private void listPDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listPDActionPerformed
        if(anyPD.getText().length()==0)
        afficheDPR(1);
        else afficheDPR(2);
    }//GEN-LAST:event_listPDActionPerformed

    private void adressePDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_adressePDKeyReleased
        afficheDPR(1);        // TODO add your handling code here:
    }//GEN-LAST:event_adressePDKeyReleased

    private void jourPDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jourPDMouseClicked

    }//GEN-LAST:event_jourPDMouseClicked

    private void jourPDMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jourPDMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jourPDMouseExited

    private void jourPDMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jourPDMouseReleased

    }//GEN-LAST:event_jourPDMouseReleased

    private void jourPDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jourPDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jourPDActionPerformed

    private void jourPDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jourPDKeyReleased
        afficheDPR(1);
    }//GEN-LAST:event_jourPDKeyReleased

    private void jourPDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jourPDKeyTyped
        char c=evt.getKeyChar();
        if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE )||jourPD.getText().length()==2)
        {   getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_jourPDKeyTyped

    private void moisDAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_moisDAMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_moisDAMouseClicked

    private void moisDAMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_moisDAMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_moisDAMouseExited

    private void moisDAMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_moisDAMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_moisDAMouseReleased

    private void moisDAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moisDAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_moisDAActionPerformed

    private void moisDAKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_moisDAKeyReleased
        afficheDA();
    }//GEN-LAST:event_moisDAKeyReleased

    private void moisDAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_moisDAKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE )||mois.getText().length()==2)
        {   getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_moisDAKeyTyped

    private void numADActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numADActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numADActionPerformed

    private void numADKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numADKeyReleased
        afficheDA();         // TODO add your handling code here:
    }//GEN-LAST:event_numADKeyReleased

    private void numADKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numADKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE)|| numA.getText().length()==8)
        {   getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_numADKeyTyped

    private void typeDAKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_typeDAKeyReleased
        afficheDA();        // TODO add your handling code here:
    }//GEN-LAST:event_typeDAKeyReleased

    private void qcDAKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qcDAKeyReleased
        afficheDA();        // TODO add your handling code here:
    }//GEN-LAST:event_qcDAKeyReleased

    private void qcDAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qcDAKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE)|| qc.getText().length()==5)
        {   getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_qcDAKeyTyped

    private void capaciteDAKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_capaciteDAKeyReleased
        afficheDA();        // TODO add your handling code here:
    }//GEN-LAST:event_capaciteDAKeyReleased

    private void capaciteDAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_capaciteDAKeyTyped

    }//GEN-LAST:event_capaciteDAKeyTyped

    private void supprimer3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimer3ActionPerformed
        // TODO add your handling code here:
        if(jTableDA.getSelectedRow()<0)
        {
            JOptionPane.showMessageDialog(null, "*****  Selectionner Une Relation  *****");
        }
        else{
            {
                Depart d = new Depart(jTableDA.getValueAt(jTableDA.getSelectedRow(), 0).toString());
                DAR dar = new DAR(d);
                DPR dpr = new DPR(d);
                VDR vdr = new VDR(d);
                try {
                    d.supprimer("Depart");
                    dar.supprimerDepart("DAR");
                    dpr.supprimerDepart("DPR");
                    vdr.supprimerDepart("VDR");
                } catch (UnknownHostException ex) {
                    Logger.getLogger(GestionDepart.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            numA.setText("");
            numD.setText("");
            jour.setText("");
            mois.setText("");
            annee.setText("");
            type.setText("");
            capacite.setText("");
            qc.setText("");
            affiche();
        }
    }//GEN-LAST:event_supprimer3ActionPerformed

    private void ajouter10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouter10ActionPerformed
        numA.setText("");
        numD.setText("");
        jour.setText(""); mois.setText("");
        annee.setText("");
        type.setText("");
        capacite.setText("");
        qc.setText("");
        affiche();// TODO add your handling code here:
    }//GEN-LAST:event_ajouter10ActionPerformed

    private void jourDAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jourDAMouseClicked

    }//GEN-LAST:event_jourDAMouseClicked

    private void jourDAMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jourDAMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jourDAMouseExited

    private void jourDAMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jourDAMouseReleased

    }//GEN-LAST:event_jourDAMouseReleased

    private void jourDAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jourDAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jourDAActionPerformed

    private void jourDAKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jourDAKeyReleased
        afficheDA();
    }//GEN-LAST:event_jourDAKeyReleased

    private void jourDAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jourDAKeyTyped
        char c=evt.getKeyChar();
        if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE )||jour.getText().length()==2)
        {   getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_jourDAKeyTyped

    private void numDAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numDAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numDAActionPerformed

    private void numDAKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numDAKeyReleased
        afficheDA();        // TODO add your handling code here:
    }//GEN-LAST:event_numDAKeyReleased

    private void numDAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numDAKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE)|| numD.getText().length()==8)
        {   getToolkit().beep();
            evt.consume();
        }

    }//GEN-LAST:event_numDAKeyTyped

    private void anneeDAKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_anneeDAKeyReleased
        afficheDA();
    }//GEN-LAST:event_anneeDAKeyReleased

    private void anneeDAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_anneeDAKeyTyped
        char c=evt.getKeyChar();
        if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE)||annee.getText().length()==4)
        {   getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_anneeDAKeyTyped

    private void numDVDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numDVDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numDVDActionPerformed

    private void numDVDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numDVDKeyReleased
        afficheVD(1);
    }//GEN-LAST:event_numDVDKeyReleased

    private void numDVDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numDVDKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE)|| numVVD.getText().length()==8)
        {   getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_numDVDKeyTyped

    private void numVVDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numVVDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numVVDActionPerformed

    private void numVVDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numVVDKeyReleased
        afficheVD(1);        // TODO add your handling code here:
    }//GEN-LAST:event_numVVDKeyReleased

    private void numVVDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numVVDKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE)|| numVVD.getText().length()==8)
        {   getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_numVVDKeyTyped

    private void anyVDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anyVDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_anyVDActionPerformed

    private void anyVDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_anyVDKeyReleased
        if(anyVD.getText().length()==0)
        afficheVD(1);
        else
        afficheVD(2);
    }//GEN-LAST:event_anyVDKeyReleased

    private void anyVDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_anyVDKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_anyVDKeyTyped

    private void distanceVDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_distanceVDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_distanceVDActionPerformed

    private void distanceVDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_distanceVDKeyReleased
        afficheVD(1);        // TODO add your handling code here:
    }//GEN-LAST:event_distanceVDKeyReleased

    private void distanceVDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_distanceVDKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE))
        {   getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_distanceVDKeyTyped

    private void frequenceVDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_frequenceVDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_frequenceVDActionPerformed

    private void frequenceVDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_frequenceVDKeyReleased
        afficheVD(1);        // TODO add your handling code here:
    }//GEN-LAST:event_frequenceVDKeyReleased

    private void frequenceVDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_frequenceVDKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE))
        {   getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_frequenceVDKeyTyped

    private void supprimer4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimer4ActionPerformed
        if(jTableVD.getSelectedRow()<0)
        {
            JOptionPane.showMessageDialog(null, "*****  Selectionner Une Relation  *****");
        }
        else
        {
            VDR p = new VDR(new Depart(jTableVD.getValueAt(jTableVD.getSelectedRow(), 3).toString()));
            try {
                p.supprimerDepart("VDR");

                afficheVD(1);
            } catch (UnknownHostException ex) {
                Logger.getLogger(GestionDepart.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }//GEN-LAST:event_supprimer4ActionPerformed

    private void jourVDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jourVDMouseClicked

    }//GEN-LAST:event_jourVDMouseClicked

    private void jourVDMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jourVDMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jourVDMouseExited

    private void jourVDMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jourVDMouseReleased

    }//GEN-LAST:event_jourVDMouseReleased

    private void jourVDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jourVDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jourVDActionPerformed

    private void jourVDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jourVDKeyReleased
        afficheVD(1);
    }//GEN-LAST:event_jourVDKeyReleased

    private void jourVDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jourVDKeyTyped
        char c=evt.getKeyChar();
        if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE )||jourVD.getText().length()==2)
        {   getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_jourVDKeyTyped

    private void ajouter11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouter11ActionPerformed
        numVVD.setText("");
        numDVD.setText("");
        jourVD.setText(""); moisVD.setText("");
        anneeVD.setText("");
        frequenceVD.setText("");
        distanceVD.setText("");
        anyVD.setText("");
        afficheVD(1);// TODO add your handling code here:
    }//GEN-LAST:event_ajouter11ActionPerformed

    private void anneeVDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_anneeVDKeyReleased
        afficheVD(1);
    }//GEN-LAST:event_anneeVDKeyReleased

    private void anneeVDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_anneeVDKeyTyped
        char c=evt.getKeyChar();
        if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE)||anneeVD.getText().length()==4)
        {   getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_anneeVDKeyTyped

    private void moisVDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_moisVDMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_moisVDMouseClicked

    private void moisVDMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_moisVDMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_moisVDMouseExited

    private void moisVDMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_moisVDMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_moisVDMouseReleased

    private void moisVDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moisVDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_moisVDActionPerformed

    private void moisVDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_moisVDKeyReleased
        afficheVD(1);
    }//GEN-LAST:event_moisVDKeyReleased

    private void moisVDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_moisVDKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE )||moisVD.getText().length()==2)
        {   getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_moisVDKeyTyped

    private void ajouter12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouter12ActionPerformed
        numTVT.setText("");
        numVVT.setText("");
        distanceVT.setText("");
        frequenceVT.setText("");
        villeAVT.setText("");
        villeDVT.setText("");
        heureAVT.setText("");
        heureDVT.setText("");
        anyVT.setText("");
        afficheVT(1);
    }//GEN-LAST:event_ajouter12ActionPerformed

    private void villeDVTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_villeDVTKeyReleased
        afficheVT(1);        // TODO add your handling code here:
    }//GEN-LAST:event_villeDVTKeyReleased

    private void villeAVTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_villeAVTKeyReleased
        afficheVT(1);        // TODO add your handling code here:
    }//GEN-LAST:event_villeAVTKeyReleased

    private void heureAVTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_heureAVTKeyReleased
        afficheVT(1);        // TODO add your handling code here:
    }//GEN-LAST:event_heureAVTKeyReleased

    private void numTVTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numTVTKeyReleased
        afficheVT(1);        // TODO add your handling code here:
    }//GEN-LAST:event_numTVTKeyReleased

    private void anyVTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_anyVTKeyReleased
        if(anyVT.getText().length()==0)
        afficheVT(1);
        else afficheVT(2);
    }//GEN-LAST:event_anyVTKeyReleased

    private void distanceVTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_distanceVTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_distanceVTActionPerformed

    private void distanceVTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_distanceVTKeyReleased
      afficheVT(1);
    }//GEN-LAST:event_distanceVTKeyReleased

    private void distanceVTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_distanceVTKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE))
        {   getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_distanceVTKeyTyped

    private void supprimer5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimer5ActionPerformed
        if(jTableVD.getSelectedRow()<0)
        {
            JOptionPane.showMessageDialog(null, "*****  Selectionner Une Seule Relation  *****");
        }
        else
        {
            VTR p = new VTR(new Vol(jTableVT.getValueAt(jTableVT.getSelectedRow(), 0).toString()),
                    new Troncon(jTableVT.getValueAt(jTableVT.getSelectedRow(), 4).toString()));
            try {
                p.supprimer("VTR");
                afficheVT(1);
            } catch (UnknownHostException ex) {
                Logger.getLogger(GestionDepart.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_supprimer5ActionPerformed

    private void frequenceVTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_frequenceVTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_frequenceVTActionPerformed

    private void frequenceVTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_frequenceVTKeyReleased
afficheVT(1);
    }//GEN-LAST:event_frequenceVTKeyReleased

    private void frequenceVTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_frequenceVTKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE))
        {   getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_frequenceVTKeyTyped

    private void numVVTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numVVTKeyReleased
      afficheVT(1);       // TODO add your handling code here:
    }//GEN-LAST:event_numVVTKeyReleased

    private void heureDVTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_heureDVTKeyReleased
     afficheVT(1);       // TODO add your handling code here:
    }//GEN-LAST:event_heureDVTKeyReleased

    private void numTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numTTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numTTActionPerformed

    private void numTTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numTTKeyReleased
        afficheT(1);        // TODO add your handling code here:
    }//GEN-LAST:event_numTTKeyReleased

    private void numTTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numTTKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE)|| numTT.getText().length()==8)
        {   getToolkit().beep();
            evt.consume();
        }

    }//GEN-LAST:event_numTTKeyTyped

    private void ajouter13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouter13ActionPerformed
        // TODO add your handling code here:

        if(numTT.getText().length()==0)
        {
            JOptionPane.showMessageDialog(null, "*****  Saisair Le Numero  *****");

        }else if(villeDT.getText().length()==0)
        {
            JOptionPane.showMessageDialog(null, "*****  Saisir La Ville De Depart  *****");
        }else if(villeAT.getText().length()==0)
        {
            JOptionPane.showMessageDialog(null, "*****  Saisir La Ville De Depart  *****");
        }        
        else
        {
            Troncon v = new Troncon(numTT.getText(),villeDT.getText().toUpperCase(),villeAT.getText().toUpperCase());
            try {
                if (v.recherche("Troncon"))
                {
                    v.ajouter("Troncon");
                    afficheT(1);
                }
                else JOptionPane.showMessageDialog(null, "Deja Existe");
            } catch (UnknownHostException ex) {
                Logger.getLogger(GestionTroncon.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_ajouter13ActionPerformed

    private void ajouter14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouter14ActionPerformed
        numTT.setText("");
        villeAT.setText(""); villeDT.setText("");
        anyT.setText("");
        afficheT(1);// TODO add your handling code here:
    }//GEN-LAST:event_ajouter14ActionPerformed

    private void supprimer6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimer6ActionPerformed
        if(jTableT.getSelectedRow()<0)
        {
            JOptionPane.showMessageDialog(null, "*****  Selectionner Une Troncon  *****");
        }
        else{
            try {
                Troncon v = new Troncon(jTableT.getValueAt(jTableT.getSelectedRow(), 0).toString());
                VTR vtr = new VTR(new Troncon(jTableT.getValueAt(jTableT.getSelectedRow(), 0).toString()));
                v.supprimer("Troncon");
                vtr.supprimerTroncon("VTR");
            } catch (UnknownHostException ex) {
                Logger.getLogger(GestionDepart.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        numTT.setText("");
        villeAT.setText(""); villeDT.setText(""); anyT.setText("");
        afficheT(1);        // TODO add your handling code here:
    }//GEN-LAST:event_supprimer6ActionPerformed

    private void villeDTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_villeDTKeyReleased
        afficheT(1);        // TODO add your handling code here:
    }//GEN-LAST:event_villeDTKeyReleased

    private void villeATKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_villeATKeyReleased
        afficheT(1);        // TODO add your handling code here:
    }//GEN-LAST:event_villeATKeyReleased

    private void anyTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anyTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_anyTActionPerformed

    private void anyTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_anyTKeyReleased

        afficheT(2);

    }//GEN-LAST:event_anyTKeyReleased

    private void anyTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_anyTKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_anyTKeyTyped

    private void listHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listHDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listHDActionPerformed

    private void listMDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listMDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listMDActionPerformed

    private void listHAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listHAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listHAActionPerformed

    private void listMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listMAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listMAActionPerformed

    private void ajouter15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouter15ActionPerformed
 if(jTableT.getSelectedRow()<0)
                    JOptionPane.showMessageDialog(null, "*****  Selectionner un Troncon  *****");
 else if(jTableV.getSelectedRow()<0)
                    JOptionPane.showMessageDialog(null, "*****  Selectionner un Vol  *****");
 else
 {
        try {
       
            Vol V = new Vol(jTableV.getValueAt(jTableV.getSelectedRow(), 0).toString());
            Troncon T = new Troncon(jTableT.getValueAt(jTableT.getSelectedRow(), 0).toString());
            VolTroncon VT = new VolTroncon(listHD.getSelectedItem().toString()+":"+listMD.getSelectedItem().toString(),
                    listHA.getSelectedItem().toString()+":"+listMA.getSelectedItem().toString());                      
         VTR vtr = new VTR(V,T,VT);
            if (vtr.recherche("VTR"))
            { 
                if(Integer.parseInt(listHD.getSelectedItem().toString())==Integer.parseInt(listHA.getSelectedItem().toString()))
                    JOptionPane.showMessageDialog(null, "*****  Vérifier L'Heure De Depart ou L'Heure D'Arrivée  *****");
                else
                {
             vtr.ajouter("VTR");
             afficheVT(1);
                }
            }
            else JOptionPane.showMessageDialog(null, "Deja Existe");        
        }   catch (UnknownHostException ex) {
                Logger.getLogger(AjoutVTR.class.getName()).log(Level.SEVERE, null, ex);
            }      
 }
    }//GEN-LAST:event_ajouter15ActionPerformed

    /**
     * @param args the command line arguments
     */
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GestionDepart().setVisible(true);
                } catch (UnknownHostException ex) {
                    Logger.getLogger(GestionDepart.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField adresse1;
    private javax.swing.JTextField adressePD;
    private javax.swing.JButton ajouter;
    private javax.swing.JButton ajouter1;
    private javax.swing.JButton ajouter10;
    private javax.swing.JButton ajouter11;
    private javax.swing.JButton ajouter12;
    private javax.swing.JButton ajouter13;
    private javax.swing.JButton ajouter14;
    private javax.swing.JButton ajouter15;
    private javax.swing.JButton ajouter2;
    private javax.swing.JButton ajouter3;
    private javax.swing.JButton ajouter4;
    private javax.swing.JButton ajouter5;
    private javax.swing.JButton ajouter6;
    private javax.swing.JButton ajouter7;
    private javax.swing.JButton ajouter8;
    private javax.swing.JButton ajouter9;
    private javax.swing.JTextField annee;
    private javax.swing.JTextField anneeDA;
    private javax.swing.JTextField anneePD;
    private javax.swing.JTextField anneeVD;
    private javax.swing.JButton annulerPD;
    private javax.swing.JTextField any;
    private javax.swing.JTextField anyA;
    private javax.swing.JTextField anyPD;
    private javax.swing.JTextField anyT;
    private javax.swing.JTextField anyVD;
    private javax.swing.JTextField anyVT;
    private javax.swing.JTextField capacite;
    private javax.swing.JTextField capaciteDA;
    private javax.swing.JTextField distance;
    private javax.swing.JTextField distanceVD;
    private javax.swing.JTextField distanceVT;
    private javax.swing.JTextField frequence;
    private javax.swing.JTextField frequenceVD;
    private javax.swing.JTextField frequenceVT;
    private javax.swing.JTextField heureAVT;
    private javax.swing.JTextField heureDVT;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JLayeredPane jLayeredPane4;
    private javax.swing.JLayeredPane jLayeredPane5;
    private javax.swing.JLayeredPane jLayeredPane6;
    private javax.swing.JLayeredPane jLayeredPane7;
    private javax.swing.JLayeredPane jLayeredPane8;
    private javax.swing.JLayeredPane jLayeredPane9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTable jTableA;
    private javax.swing.JTable jTableD;
    private javax.swing.JTable jTableDA;
    private javax.swing.JTable jTableP;
    private javax.swing.JTable jTablePD;
    private javax.swing.JTable jTableT;
    private javax.swing.JTable jTableV;
    private javax.swing.JTable jTableVD;
    private javax.swing.JTable jTableVT;
    private javax.swing.JTextField jour;
    private javax.swing.JTextField jourDA;
    private javax.swing.JTextField jourPD;
    private javax.swing.JTextField jourVD;
    private javax.swing.JComboBox list;
    private javax.swing.JComboBox listHA;
    private javax.swing.JComboBox listHD;
    private javax.swing.JComboBox listMA;
    private javax.swing.JComboBox listMD;
    private javax.swing.JComboBox listPD;
    private javax.swing.JTextField mois;
    private javax.swing.JTextField moisDA;
    private javax.swing.JTextField moisPD;
    private javax.swing.JTextField moisVD;
    private javax.swing.JTextField nom1;
    private javax.swing.JTextField nomPD;
    private javax.swing.JTextField num;
    private javax.swing.JTextField num1;
    private javax.swing.JTextField numA;
    private javax.swing.JTextField numAD;
    private javax.swing.JTextField numD;
    private javax.swing.JTextField numDA;
    private javax.swing.JTextField numDVD;
    private javax.swing.JTextField numPD;
    private javax.swing.JTextField numTT;
    private javax.swing.JTextField numTVT;
    private javax.swing.JTextField numTel1;
    private javax.swing.JTextField numTelPD;
    private javax.swing.JTextField numV;
    private javax.swing.JTextField numVVD;
    private javax.swing.JTextField numVVT;
    private javax.swing.JTextField prenom1;
    private javax.swing.JTextField prenomPD;
    private javax.swing.JTextField qc;
    private javax.swing.JTextField qcDA;
    private javax.swing.JButton supprimer;
    private javax.swing.JButton supprimer1;
    private javax.swing.JButton supprimer2;
    private javax.swing.JButton supprimer3;
    private javax.swing.JButton supprimer4;
    private javax.swing.JButton supprimer5;
    private javax.swing.JButton supprimer6;
    private javax.swing.JButton supprimerPD;
    private javax.swing.JTextField type;
    private javax.swing.JTextField typeDA;
    private javax.swing.JTextField villeAT;
    private javax.swing.JTextField villeAVT;
    private javax.swing.JTextField villeDT;
    private javax.swing.JTextField villeDVT;
    // End of variables declaration//GEN-END:variables
}
