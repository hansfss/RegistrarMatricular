/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

/**
 *
 * @author folke
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        registrar = new javax.swing.JMenu();
        mnuRegistrar = new javax.swing.JMenuItem();
        matricular = new javax.swing.JMenu();
        mnuMatricular = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        registrar.setText("Registrar");

        mnuRegistrar.setText("Registrar");
        mnuRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRegistrarActionPerformed(evt);
            }
        });
        registrar.add(mnuRegistrar);

        jMenuBar1.add(registrar);

        matricular.setText("Matricular");

        mnuMatricular.setText("Matricular");
        mnuMatricular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMatricularActionPerformed(evt);
            }
        });
        matricular.add(mnuMatricular);

        jMenuBar1.add(matricular);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRegistrarActionPerformed
        // TODO add your handling code here:
        FrmRegistrar f = new FrmRegistrar();
        f.setVisible(true);
    }//GEN-LAST:event_mnuRegistrarActionPerformed

    private void mnuMatricularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMatricularActionPerformed
        // TODO add your handling code here:
        FrmMatricular f = new FrmMatricular();
        f.setVisible(true);
    }//GEN-LAST:event_mnuMatricularActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu matricular;
    private javax.swing.JMenuItem mnuMatricular;
    private javax.swing.JMenuItem mnuRegistrar;
    private javax.swing.JMenu registrar;
    // End of variables declaration//GEN-END:variables
}