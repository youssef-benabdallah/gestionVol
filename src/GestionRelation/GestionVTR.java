/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionRelation;

import Gestion.GestionAvion;
import Listage.Matrix;
import NOSQL.Connexion;
import Vols.Troncon;
import Vols.VTR;
import Vols.Vol;
import com.mongodb.BasicDBObject;
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
public class GestionVTR extends javax.swing.JFrame {

    /**
     * Creates new form pp
     */
    
  
    public GestionVTR() {
        initComponents();
        affiche();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableVD = new javax.swing.JTable();
        ajouter1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        villeD = new javax.swing.JTextField();
        villeA = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        numT = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        distance = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        frequence = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        numV = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        heureD = new javax.swing.JTextField();
        heureA = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        any = new javax.swing.JTextField();
        supprimer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("TUNISAIR");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        // Code of sub-components - not shown here
        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setForeground(new java.awt.Color(255, 51, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Tunisair_logo.png")));
        jLabel1.setOpaque(true);

        jDesktopPane1.setBackground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        jTableVD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero Depart", "Jour", "Mois", "Ann??e", "Type", "N?? CIN", "Nom", "Pr??nom", "Adresse", "N?? TEL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableVD);

        ajouter1.setText("Annuler");
        ajouter1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouter1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Numero Troncon");

        villeD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                villeDKeyReleased(evt);
            }
        });

        villeA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                villeAKeyReleased(evt);
            }
        });

        jLabel4.setText("Ville de Depart");

        jLabel9.setText("Ville d'Arriv??e");

        numT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                numTKeyReleased(evt);
            }
        });

        jLabel7.setText("Distance");

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

        jLabel8.setText("Fr??quence");

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

        jLabel2.setText("Numero Vol");

        numV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                numVKeyReleased(evt);
            }
        });

        jLabel5.setText("Heure Depart");

        jLabel6.setText("Heure Arriv??e");

        heureD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                heureDKeyReleased(evt);
            }
        });

        heureA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                heureAKeyReleased(evt);
            }
        });

        jLabel10.setText("Tous");

        any.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                anyKeyReleased(evt);
            }
        });

        supprimer.setText("Supprimer ");
        supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(191, 191, 191))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(supprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(numT, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2)
                                .addComponent(numV, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel7)
                                    .addComponent(distance, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(frequence, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(any, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(155, 155, 155)
                                        .addComponent(ajouter1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(villeD, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(villeA, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5)
                                    .addComponent(heureD, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(heureA, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(647, 647, 647))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(numT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(numV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(heureD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(villeA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(heureA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(frequence, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(any, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(6, 6, 6)
                        .addComponent(villeD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(distance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ajouter1)
                        .addGap(18, 18, 18)
                        .addComponent(supprimer))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(193, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
  
    private void afficheJTableVD(Object[][] MyArray)
    {
         jTableVT.setModel(new javax.swing.table.DefaultTableModel(
                        MyArray,
                        new String [] {
                            "Numero Vol", "Distance", "Fr??quence",                            
                            "N?? Troncon","Numero Troncon","Ville Depart","Ville Arriv??e",
                            "Heure Depart","Heure Arriv??e"
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
        String C[][]=new String[8][2];
   C[0][0]="numV";C[0][1]=numV.getText();
   C[1][0]="distance";C[1][1]=distance.getText();
   C[2][0]="frequence";C[2][1]=frequence.getText();      
   C[3][0]="numT";C[3][1]=numT.getText();
   C[4][0]="villeDepart";C[4][1]=villeD.getText().toUpperCase();
   C[5][0]="villeArrive";C[5][1]=villeA.getText().toUpperCase();
   C[6][0]="heureD";C[6][1]=heureD.getText();
   C[7][0]="heureA";C[7][1]=heureA.getText();
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
             Object[][] tab = new Object[listAvion.count()][8];             
             while (listAvion.hasNext())
             {
                 DBObject object = listAvion.next();
                 if(testVD(object,e))   
                 {                   
                       tab[i][0]=object.get("numV");
                       tab[i][1]=object.get("distance");
                       tab[i][2]=object.get("frequence");                       
                       tab[i][3]=object.get("numT").toString().toUpperCase();     
                       tab[i][4]=object.get("villeDepart").toString().toUpperCase();
                       tab[i][5]=object.get("villeArrive").toString().toUpperCase();
                       tab[i][6]=object.get("heureD");
                       tab[i][7]=object.get("heureA");
                      i++;
                 }
             }                                          
             Object[][] MyArray = new Object[i][8];
             for(int j=0;j<i;j++)
             {
                System.arraycopy(tab[j], 0, MyArray[j], 0, 8);
             }            
         
       afficheJTableVD(MyArray);
    
        } catch (UnknownHostException ex) {
            Logger.getLogger(GestionAvion.class.getName()).log(Level.SEVERE, null, ex);        
        }
   
}
  private void affiche()
{
   String C[][]=new String[8][2];
   C[0][0]="numV";C[0][1]=numV.getText();
   C[1][0]="distance";C[1][1]=distance.getText();
   C[2][0]="frequence";C[2][1]=frequence.getText();      
   C[3][0]="numT";C[3][1]=numT.getText();
   C[4][0]="villeDepart";C[4][1]=villeD.getText().toUpperCase();
   C[5][0]="villeArrive";C[5][1]=villeA.getText().toUpperCase();
   C[6][0]="heureD";C[6][1]=heureD.getText();
   C[7][0]="heureA";C[7][1]=heureA.getText();
   
    try {         
           Connexion connexion = new Connexion("Airport");           
           BasicDBObject BDB = new BasicDBObject();
                     
            for(int i=0;i<8;i++)
            {
                if(C[i][1].length()>0)
                    BDB.append(C[i][0],C[i][1]);
            }
                        
            DBCursor list = connexion.findListe("VTR", BDB);
           
         Matrix tab = new Matrix(list.count(),9);         
         Object[][] MyArray;
            MyArray = tab.remplirVTR(list);
            
         jTableVD.setModel(new javax.swing.table.DefaultTableModel(
                        MyArray,
                        new String [] {
                            "Numero Vol", "Distance", "Fr??quence",                            
                            "N?? Troncon","Numero Troncon","Ville Depart","Ville Arriv??e",
                            "Heure Depart","Heure Arriv??e"
                        }
                        )
                  {
                            boolean[] canEdit = new boolean [] {
                             false, false, false, false, false, false, false,
                                false, false
                        };
                        @Override
                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                            return canEdit [columnIndex];
                        }
                    }
         );
        } catch (UnknownHostException ex) {
            Logger.getLogger(GestionVDR.class.getName()).log(Level.SEVERE, null, ex);        
        }

}
    

    
    private void ajouter1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouter1ActionPerformed
        numT.setText("");
        numV.setText("");
        distance.setText("");
        frequence.setText("");
        villeA.setText("");
        villeD.setText("");
        heureA.setText("");
        heureD.setText("");
        any.setText("");
        affiche();// TODO add your handling code here:
    }//GEN-LAST:event_ajouter1ActionPerformed

    private void villeDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_villeDKeyReleased
affiche();        // TODO add your handling code here:
    }//GEN-LAST:event_villeDKeyReleased

    private void villeAKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_villeAKeyReleased
affiche();        // TODO add your handling code here:
    }//GEN-LAST:event_villeAKeyReleased

    private void numTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numTKeyReleased
affiche();        // TODO add your handling code here:
    }//GEN-LAST:event_numTKeyReleased

    private void distanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_distanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_distanceActionPerformed

    private void distanceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_distanceKeyReleased
affiche();
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
affiche();
    }//GEN-LAST:event_frequenceKeyReleased

    private void frequenceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_frequenceKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE))
        {   getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_frequenceKeyTyped

    private void numVKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numVKeyReleased
affiche();        // TODO add your handling code here:
    }//GEN-LAST:event_numVKeyReleased

    private void heureDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_heureDKeyReleased
affiche();        // TODO add your handling code here:
    }//GEN-LAST:event_heureDKeyReleased

    private void heureAKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_heureAKeyReleased
affiche();        // TODO add your handling code here:
    }//GEN-LAST:event_heureAKeyReleased

    private void anyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_anyKeyReleased
if(any.getText().length()==0)
        affiche();
        else{
            try{
                String C[]=new String[8];
   C[0]="numV";
   C[1]="distance";
   C[2]="frequence";
   C[3]="numT";
   C[4]="villeDepart";
   C[5]="villeArrive";
   C[6]="heureD";
   C[7]="heureA";
   
                Connexion connexion = new Connexion("Airport");         
                DBCursor list[] = new DBCursor[8];                
                int l=0;
                for(int i=0;i<8;i++)
                {
                    list[i]=connexion.findListe("VTR",new BasicDBObject().append(C[i], any.getText().toUpperCase()));                                       
                    l+=list[i].count();                   
                }
                Matrix tab = new Matrix(l,9);
                Object[][] MyArray = null;
                for(int i=0;i<8;i++)
                {
                 Matrix tab1 = new Matrix(list[i].count(),9);
                Object[][] MyArray1 = tab1.remplirVTR(list[i]);
                MyArray = tab.add(MyArray1,list[i].count(),9);
                }

                jTableVD.setModel(new javax.swing.table.DefaultTableModel(
                    MyArray ,
                    new String [] {
                            "Numero Vol", "Distance", "Fr??quence",                            
                            "N?? Troncon","Numero Troncon","Ville Depart","Ville Arriv??e",
                            "Heure Depart","Heure Arriv??e"
                    }
                )
                {
                    boolean[] canEdit = new boolean [] {
                        false, false, false,false, false, false
                            ,false, false, false
                    };
                    @Override
                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit [columnIndex];
                    }
                }
            );
        } catch (UnknownHostException ex) {
            Logger.getLogger(GestionVDR.class.getName()).log(Level.SEVERE, null, ex);
        }      }        // TODO add your handling code here:
    }//GEN-LAST:event_anyKeyReleased

    private void supprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimerActionPerformed
        if(jTableVD.getSelectedRow()<0)
        {
            JOptionPane.showMessageDialog(null, "*****  Selectionner Une Seule Relation  *****");
        }
        else
        {
            VTR p = new VTR(new Vol(jTableVD.getValueAt(jTableVD.getSelectedRow(), 0).toString()),new Troncon(jTableVD.getValueAt(jTableVD.getSelectedRow(), 4).toString()));
            try {
                p.supprimer("VTR");
                  numT.setText("");
        numV.setText("");
        distance.setText("");
        frequence.setText("");
        villeA.setText("");
        villeD.setText("");
        heureA.setText("");
        heureD.setText("");
        any.setText("");        
                affiche();
            } catch (UnknownHostException ex) {
                Logger.getLogger(GestionVDR.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }//GEN-LAST:event_supprimerActionPerformed

    /**
     * @param args the command line arguments
     */
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionVTR().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ajouter1;
    private javax.swing.JTextField any;
    private javax.swing.JTextField distance;
    private javax.swing.JTextField frequence;
    private javax.swing.JTextField heureA;
    private javax.swing.JTextField heureD;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableVD;
    private javax.swing.JTextField numT;
    private javax.swing.JTextField numV;
    private javax.swing.JButton supprimer;
    private javax.swing.JTextField villeA;
    private javax.swing.JTextField villeD;
    // End of variables declaration//GEN-END:variables
}
