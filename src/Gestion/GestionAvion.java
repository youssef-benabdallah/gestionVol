/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestion;


import NOSQL.Connexion;
import Vols.Avion;
import Vols.DAR;
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
public class GestionAvion extends javax.swing.JFrame {

    /**
     * Creates new form pp
     */
    
  
    public GestionAvion() {
        initComponents();
        afficheA(1);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        num = new javax.swing.JTextField();
        type = new javax.swing.JTextField();
        capacite = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        any = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        ajouter = new javax.swing.JButton();
        ajouter1 = new javax.swing.JButton();
        ajouter2 = new javax.swing.JButton();

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
        jTextField1.setFont(new java.awt.Font("Consolas", 0, 32)); // NOI18N
        jTextField1.setText("Gestion Avion");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable);

        num.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                numKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                numKeyTyped(evt);
            }
        });

        type.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                typeKeyReleased(evt);
            }
        });

        capacite.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                capaciteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                capaciteKeyTyped(evt);
            }
        });

        jLabel4.setText("Numero");

        jLabel6.setText("Type");

        jLabel7.setText("Capacité");

        any.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                anyKeyReleased(evt);
            }
        });

        jLabel2.setText("Tous");

        ajouter.setText("Ajouter");
        ajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterActionPerformed(evt);
            }
        });

        ajouter1.setText("Anuuler");
        ajouter1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouter1ActionPerformed(evt);
            }
        });

        ajouter2.setText("Supprimer");
        ajouter2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouter2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel6)
                        .addComponent(type, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addComponent(capacite, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addComponent(any, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                        .addComponent(ajouter1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ajouter2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ajouter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel4)
                    .addComponent(num, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(5, 5, 5)
                        .addComponent(num, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(capacite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(any, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ajouter)
                        .addGap(18, 18, 18)
                        .addComponent(ajouter2)
                        .addGap(18, 18, 18)
                        .addComponent(ajouter1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void afficheJTableA(Object[][] MyArray)
    {
         jTable.setModel(new javax.swing.table.DefaultTableModel(
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
        return object.get("num").toString().contains(num.getText().toUpperCase())
                         &&object.get("type").toString().contains(type.getText().toUpperCase())
                         &&object.get("capacite").toString().contains(capacite.getText().toUpperCase());
        else return
                object.get("num").toString().contains(any.getText().toUpperCase())
                         ||object.get("type").toString().contains(any.getText().toUpperCase())
                         ||object.get("capacite").toString().contains(any.getText().toUpperCase());
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


    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void numKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numKeyReleased
afficheA(1);        // TODO add your handling code here:
    }//GEN-LAST:event_numKeyReleased

    private void typeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_typeKeyReleased
afficheA(1);        // TODO add your handling code here:
    }//GEN-LAST:event_typeKeyReleased

    private void capaciteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_capaciteKeyReleased
afficheA(1);        // TODO add your handling code here:
    }//GEN-LAST:event_capaciteKeyReleased

    private void numKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numKeyTyped
        char c=evt.getKeyChar();
        if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE)|| num.getText().length()==8)
        {   getToolkit().beep();
            evt.consume();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_numKeyTyped

    private void capaciteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_capaciteKeyTyped
  char c=evt.getKeyChar();
        if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE)|| capacite.getText().length()==4)
        {   getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_capaciteKeyTyped

    private void anyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_anyKeyReleased
     afficheA(2);
    }//GEN-LAST:event_anyKeyReleased

    private void ajouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterActionPerformed
        if(num.getText().length()==0)
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
                Avion p = new Avion(num.getText().toUpperCase(),type.getText().toUpperCase(),capacite.getText().toUpperCase());
                if (p.recherche("Avion"))
                {
                    p.ajouter("Avion");                    
        num.setText("");
        type.setText("");
        capacite.setText("");
        afficheA(1);
                }
                else JOptionPane.showMessageDialog(null, "Deja Existe");
                
            } catch (UnknownHostException ex) {
                Logger.getLogger(GestionAvion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
    }//GEN-LAST:event_ajouterActionPerformed

    private void ajouter1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouter1ActionPerformed
        num.setText("");
        type.setText("");
        capacite.setText(""); 
        any.setText("");
        afficheA(1);// TODO add your handling code here:
    }//GEN-LAST:event_ajouter1ActionPerformed

    private void ajouter2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouter2ActionPerformed

            if(jTable.getSelectedRow()<0)
        {
            JOptionPane.showMessageDialog(null, "*****  Selectionner Une Avion  *****");
        }
        else
        {
         Avion p = new Avion(jTable.getValueAt(jTable.getSelectedRow(), 0).toString().toUpperCase());
         DAR dar = new DAR(new Avion(jTable.getValueAt(jTable.getSelectedRow(), 0).toString().toUpperCase()));
        try {
           p.supprimer("Avion");
          dar.supprimerAvion("DAR");           
        } catch (UnknownHostException ex) {
            Logger.getLogger(GestionAvion.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        afficheA(1);
    }//GEN-LAST:event_ajouter2ActionPerformed

    /**
     * @param args the command line arguments
     */
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionAvion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ajouter;
    private javax.swing.JButton ajouter1;
    private javax.swing.JButton ajouter2;
    private javax.swing.JTextField any;
    private javax.swing.JTextField capacite;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField num;
    private javax.swing.JTextField type;
    // End of variables declaration//GEN-END:variables
}