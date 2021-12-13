/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionRelation;

import NOSQL.Connexion;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import java.awt.event.KeyEvent;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Ben Abdallah Youssef
 */
public class GestionVPR extends javax.swing.JFrame {

    /**
     * Creates new form pp
     */
    
  
    public GestionVPR() {
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
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        prenom = new javax.swing.JTextField();
        nom = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        num = new javax.swing.JTextField();
        numTel = new javax.swing.JTextField();
        list = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        adresse = new javax.swing.JTextField();
        numV = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        ajouter1 = new javax.swing.JButton();

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

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(204, 204, 255));
        jTextField1.setFont(new java.awt.Font("Consolas", 0, 36)); // NOI18N
        jTextField1.setText("Gestion Vol Personne Relation");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Prenom");

        jLabel5.setText("Num TEL");

        jLabel6.setText("Adresse");

        prenom.setToolTipText("");
        prenom.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        prenom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prenomActionPerformed(evt);
            }
        });
        prenom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                prenomKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                prenomKeyTyped(evt);
            }
        });

        nom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nomKeyReleased(evt);
            }
        });

        jLabel2.setText("Numero CIN");

        num.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                numKeyReleased(evt);
            }
        });

        numTel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                numTelKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                numTelKeyTyped(evt);
            }
        });

        list.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Navigant", "Non Navigant", "Passager", "Personnel", "Pilote", "Tous" }));
        list.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listActionPerformed(evt);
            }
        });

        jLabel3.setText("Nom");

        adresse.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                adresseKeyReleased(evt);
            }
        });

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

        jLabel9.setText("Numero Vol");

        jTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable);

        ajouter1.setText("Annuler");
        ajouter1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouter1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1076, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(118, 118, 118))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(adresse, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numTel, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(num, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(prenom, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9)
                            .addComponent(numV)
                            .addComponent(list, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(ajouter1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(num, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(list, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addGap(4, 4, 4)
                        .addComponent(prenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(adresse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ajouter1))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
  
      private void affiche()
{
   String C[][]=new String[7][2];
   C[0][0]="numV";C[0][1]=numV.getText();
   String Type = list.getSelectedItem().toString();
   if (Type.equals("Non Navigant"))
       Type = "NonNavigant";
   C[1][0]="type";C[1][1]=Type;
   C[2][0]="numCIN";C[2][1]=num.getText();
   C[3][0]="nom";C[3][1]=nom.getText();
   C[4][0]="prenom";C[4][1]=prenom.getText();   
   C[5][0]="adresse";C[5][1]=adresse.getText();
   C[6][0]="numTel";C[6][1]=numTel.getText();   
   
    try {         
           Connexion connexion = new Connexion("Airport");           
           BasicDBObject BDB = new BasicDBObject();           
            if (!Type.equals("Tous"))
            for(int i=1;i<7;i++)
            {
                if(C[i][1].length()>0)
                    BDB.append(C[i][0],C[i][1]);
            }
            
            if (Type.equals("Tous"))
            for(int i=1;i<7;i++)
            {
                if(i==1)i++;
                if(C[i][1].length()>0)
                {
                BDB.append(C[i][0],C[i][1]);                
                }
            }
            
            
            DBCursor list = connexion.findListe("DPR", BDB);
                       
            Object[][] MyArray = new Object[list.count()][7];
            int i=-1;
            while(list.hasNext())
            {                
                DBObject object = list.next();               
                DBCursor listVD = connexion.findListe("VDR", new BasicDBObject().append("numD",  object.get("numD")));
                if(listVD.hasNext())
                {
                    
                DBObject newobject = listVD.next();               
                       if(C[0][1].length()>0)
                       {
                               if(newobject.get("numV").toString().equals(C[0][1]))
                       {
                           i++;                       
                        MyArray[i][0]= newobject.get("numV").toString().toUpperCase();
                        MyArray[i][1]= object.get("type").toString().toUpperCase();
                        MyArray[i][2]= object.get("numCIN").toString().toUpperCase();
                        MyArray[i][3]= object.get("nom").toString().toUpperCase();
                        MyArray[i][4]= object.get("prenom").toString().toUpperCase();
                        MyArray[i][5]= object.get("adresse").toString().toUpperCase();
                        MyArray[i][6]= object.get("numTel").toString().toUpperCase();
                       }
                       }else
                       {
                               i++;                       
                        MyArray[i][0]= newobject.get("numV").toString().toUpperCase();
                        MyArray[i][1]= object.get("type").toString().toUpperCase();
                        MyArray[i][2]= object.get("numCIN").toString().toUpperCase();
                        MyArray[i][3]= object.get("nom").toString().toUpperCase();
                        MyArray[i][4]= object.get("prenom").toString().toUpperCase();
                        MyArray[i][5]= object.get("adresse").toString().toUpperCase();
                        MyArray[i][6]= object.get("numTel").toString().toUpperCase();
                       }
                               
                }
            }
            Object[][] MyArray1 = new Object[i+1][7];
        for(int j=0;j<=i;j++)
            for(int k=0;k<7;k++)
            MyArray1[j][k]=MyArray[j][k];  
         
         jTable.setModel(new javax.swing.table.DefaultTableModel(
                        MyArray1,
                        new String [] {
                            "Numero Vol", "Type",
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
        } catch (UnknownHostException ex) {
            Logger.getLogger(GestionDAR.class.getName()).log(Level.SEVERE, null, ex);        
        }

}

    
    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void prenomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prenomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prenomActionPerformed

    private void prenomKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prenomKeyReleased
        affiche();
    }//GEN-LAST:event_prenomKeyReleased

    private void prenomKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prenomKeyTyped


    }//GEN-LAST:event_prenomKeyTyped

    private void nomKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomKeyReleased
        affiche();        // TODO add your handling code here:
    }//GEN-LAST:event_nomKeyReleased

    private void numKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numKeyReleased
        affiche();        // TODO add your handling code here:
    }//GEN-LAST:event_numKeyReleased

    private void numTelKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numTelKeyReleased
        affiche();        // TODO add your handling code here:
    }//GEN-LAST:event_numTelKeyReleased

    private void numTelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numTelKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE)|| numTel.getText().length()==8)
        {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_numTelKeyTyped

    private void listActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listActionPerformed
        
        affiche();
        
    }//GEN-LAST:event_listActionPerformed

    private void adresseKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_adresseKeyReleased
        affiche();        // TODO add your handling code here:
    }//GEN-LAST:event_adresseKeyReleased

    private void numVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numVActionPerformed

    private void numVKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numVKeyReleased
        affiche();        // TODO add your handling code here:
    }//GEN-LAST:event_numVKeyReleased

    private void numVKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numVKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE)|| numV.getText().length()==8)
        {   getToolkit().beep();
            evt.consume();
        }

    }//GEN-LAST:event_numVKeyTyped

    private void ajouter1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouter1ActionPerformed
        prenom.setText("");
        numV.setText("");
        nom.setText("");
        num.setText("");
        adresse.setText("");
        numTel.setText("");
        affiche();// TODO add your handling code here:
    }//GEN-LAST:event_ajouter1ActionPerformed

    /**
     * @param args the command line arguments
     */
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionVPR().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField adresse;
    private javax.swing.JButton ajouter1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JComboBox list;
    private javax.swing.JTextField nom;
    private javax.swing.JTextField num;
    private javax.swing.JTextField numTel;
    private javax.swing.JTextField numV;
    private javax.swing.JTextField prenom;
    // End of variables declaration//GEN-END:variables
}
