/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AjoutRelation;


import Listage.List;
import NOSQL.Connexion;
import Personnages.Passager;
import Vols.DPR;
import Vols.Depart;
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
public class AjoutDPR extends javax.swing.JFrame {

    /**
     * Creates new form pp
     */
    
  
    public AjoutDPR() throws UnknownHostException {
        initComponents();
        chargerListPersonne();
        chargerListDepart();
        chargerTout();
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
        ajouter = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jTextField1 = new javax.swing.JTextField();
        jour = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        annee = new javax.swing.JTextField();
        mois = new javax.swing.JTextField();
        listD = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        listP = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        nom = new javax.swing.JTextField();
        prenom = new javax.swing.JTextField();
        numTel = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        adresse = new javax.swing.JTextField();
        listPP = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("TUNISAIR");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        // Code of sub-components - not shown here
        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setForeground(new java.awt.Color(255, 51, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Tunisair_logo.png")));
        jLabel1.setOpaque(true);

        ajouter.setText("Ajouter");
        ajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterActionPerformed(evt);
            }
        });

        jLabel2.setText("Numero CIN Personne");

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
        jTextField1.setText("Ajout Depart Passager Relation");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jour.setToolTipText("Jour");
        jour.setEnabled(false);
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

        jLabel5.setText("Date");

        annee.setToolTipText("Annee");
        annee.setEnabled(false);
        annee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                anneeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                anneeKeyTyped(evt);
            }
        });

        mois.setToolTipText("Mois");
        mois.setEnabled(false);
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

        listD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listDActionPerformed(evt);
            }
        });

        jLabel4.setText("Numero Depart");

        listP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listPActionPerformed(evt);
            }
        });

        jLabel6.setText("Prenom");

        jLabel7.setText("Num TEL");

        jLabel8.setText("Adresse");

        nom.setEnabled(false);
        nom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomActionPerformed(evt);
            }
        });
        nom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nomKeyReleased(evt);
            }
        });

        prenom.setEnabled(false);
        prenom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                prenomKeyReleased(evt);
            }
        });

        numTel.setEnabled(false);
        numTel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                numTelKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                numTelKeyTyped(evt);
            }
        });

        jLabel9.setText("Nom");

        adresse.setEnabled(false);
        adresse.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                adresseKeyReleased(evt);
            }
        });

        listPP.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Navigant", "Non Navigant", "Passager", "Personnel", "Pilote" }));
        listPP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listPPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 874, Short.MAX_VALUE)
            .addComponent(jDesktopPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel6))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(listP, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(prenom, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(adresse, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numTel, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(listPP, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ajouter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(listD, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jour, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(mois, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(annee, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(listD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(listPP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(prenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(adresse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(numTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)
                                    .addComponent(ajouter)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5)
                                .addComponent(annee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(mois, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(listP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(240, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ajouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterActionPerformed
              
        try {
           
            Passager P = new Passager(listP.getSelectedItem().toString());
            Depart D = new Depart(listD.getSelectedItem().toString());         
           
          String collection = listPP.getSelectedItem().toString();
          if(collection.equals("Non Navigant")) collection = "NonNavigant";
         DPR dpr = new DPR(D,P,collection);
            if (dpr.rechercheType("DPR"))
            {                
           dpr.ajouter("DPR",collection);
           JOptionPane.showMessageDialog(null, "*****  Relation Ajouter  *****");
            }
            else JOptionPane.showMessageDialog(null, "Deja Existe");
        
        }   catch (UnknownHostException ex) {
                Logger.getLogger(AjoutDPR.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }//GEN-LAST:event_ajouterActionPerformed

 void chargerListDepart() throws UnknownHostException
    {
    Connexion connexion = new Connexion("Airport");
    DBCursor list = connexion.getListe("Depart");
    List l =  new List(list.count());
    String listAvion[]=l.remplirByNum(list);
    for(int i=0;i<listAvion.length;i++)
    listD.addItem(listAvion[i]);    
    }
    
  void chargerListPersonne() throws UnknownHostException
    {
    Connexion connexion = new Connexion("Airport");
    String collection = "Personnel";
    DBCursor list = connexion.getListe(collection);
    List l =  new List(list.count());
    String listAvion[]=l.remplirPersonne(list);
    for(int i=0;i<listAvion.length;i++)
    listP.addItem(listAvion[i]);    
    }
  
  void chargerTout() throws UnknownHostException
    {
    Connexion connexion = new Connexion("Airport");
     nom.setText("");
    prenom.setText("");
    adresse.setText("");    
    numTel.setText("");    
    jour.setText("");
    mois.setText("");
    annee.setText("");
    if(listP.getSelectedIndex()>=0)
    {
        String collection = listPP.getSelectedItem().toString();
    if(collection.equals("Non Navigant")) collection = "NonNavigant";
    DBCursor list = connexion.findListe(collection,new BasicDBObject().append("cin",listP.getSelectedItem().toString()));
    if(list.count()>0)
    {
    DBObject object = list.next();
    nom.setText(object.get("nom").toString());
    prenom.setText(object.get("prenom").toString());
    adresse.setText(object.get("adresse").toString());    
    numTel.setText(object.get("numTel").toString());    
    }
    }
    if(listD.getSelectedIndex()>=0)
    {
    DBCursor list = connexion.findListe("Depart",new BasicDBObject().append("num",listD.getSelectedItem().toString()));
     if(list.count()>0)
    {
    DBObject object = list.next();
    jour.setText(object.get("jour").toString());
    mois.setText(object.get("mois").toString());
    annee.setText(object.get("annee").toString());
    }
    }
    }
    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

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

    private void jourKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jourKeyReleased

    }//GEN-LAST:event_jourKeyReleased

    private void jourKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jourKeyTyped
        char c=evt.getKeyChar();
        if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE )||jour.getText().length()==2)
        {   getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_jourKeyTyped

    private void anneeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_anneeKeyReleased

    }//GEN-LAST:event_anneeKeyReleased

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

    private void moisKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_moisKeyReleased

    }//GEN-LAST:event_moisKeyReleased

    private void moisKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_moisKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE )||mois.getText().length()==2)
        {   getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_moisKeyTyped

    private void listDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listDActionPerformed
        try {
            chargerTout();        // TODO add your handling code here:
        } catch (UnknownHostException ex) {
            Logger.getLogger(AjoutDPR.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_listDActionPerformed

    private void listPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listPActionPerformed
        try {
            chargerTout();        // TODO add your handling code here:
        } catch (UnknownHostException ex) {
            Logger.getLogger(AjoutDPR.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_listPActionPerformed

    private void nomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomActionPerformed

    private void nomKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomKeyReleased

    }//GEN-LAST:event_nomKeyReleased

    private void prenomKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prenomKeyReleased

    }//GEN-LAST:event_prenomKeyReleased

    private void numTelKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numTelKeyReleased
     
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

    private void adresseKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_adresseKeyReleased

    }//GEN-LAST:event_adresseKeyReleased

    private void listPPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listPPActionPerformed
        try {
            listP.removeAllItems();
            chargerListPersonne();
             chargerListDepart();
            chargerTout();
            
        } catch (UnknownHostException ex) {
            Logger.getLogger(AjoutDPR.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_listPPActionPerformed

    /**
     * @param args the command line arguments
     */
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AjoutDPR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AjoutDPR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AjoutDPR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AjoutDPR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AjoutDPR().setVisible(true);
                } catch (UnknownHostException ex) {
                    Logger.getLogger(AjoutDPR.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField adresse;
    private javax.swing.JButton ajouter;
    private javax.swing.JTextField annee;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jour;
    private javax.swing.JComboBox listD;
    private javax.swing.JComboBox listP;
    private javax.swing.JComboBox listPP;
    private javax.swing.JTextField mois;
    private javax.swing.JTextField nom;
    private javax.swing.JTextField numTel;
    private javax.swing.JTextField prenom;
    // End of variables declaration//GEN-END:variables
}
