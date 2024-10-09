package gui;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
/**
 *
 * @author Andres D. Diaz
 */
public class SistemaFinancieroMainPage extends javax.swing.JFrame {

    /**
     * Creates new form SistemaFinancieroGUI
     */
    public SistemaFinancieroMainPage() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        usernameLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        mainPasswordField = new javax.swing.JPasswordField();
        cancelButton = new javax.swing.JButton();
        entrarButton = new javax.swing.JButton();
        mainPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        copyrightLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SIFIP - Menú de Entrada");
        setMinimumSize(new java.awt.Dimension(700, 350));
        setPreferredSize(new java.awt.Dimension(740, 400));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        usernameLabel.setText("Nombre de Usuario:");
        getContentPane().add(usernameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, -1, -1));

        passwordLabel.setText("Contraseña: ");
        getContentPane().add(passwordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, -1, -1));

        usernameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(usernameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 210, 90, -1));
        getContentPane().add(mainPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 240, 90, -1));

        cancelButton.setText("Salir");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        getContentPane().add(cancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 280, -1, -1));

        entrarButton.setText("Entrar");
        entrarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrarButtonActionPerformed(evt);
            }
        });
        getContentPane().add(entrarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 280, -1, -1));

        mainPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 204)));
        mainPanel.setToolTipText("");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 204));
        jLabel3.setText("SIFIP - Sistema Financiero Personal");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel3)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel3)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(mainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 670, -1));

        copyrightLabel.setText("Universidad de Santander - Proyecto Integrador I - 2024");
        getContentPane().add(copyrightLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, -1, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usernameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameTextFieldActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // Boton para confirmar salida:
        JFrame Frame = new JFrame("Salir");

        if (JOptionPane.showConfirmDialog( Frame,"¿Deseas cerrar el programa?\nTodos los datos no guardados se perderán.","SIFIP - Salir del Programa",
            JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
            System.exit(0);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void entrarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrarButtonActionPerformed
        // Boton de entrada:
        String usuario = usernameTextField.getText();
        String password = mainPasswordField.getText();
        
        if (usuario.equals("admin") && password.equals("123")){
            WelcomePage next = new WelcomePage();
            JOptionPane.showMessageDialog(rootPane, "Datos de Ingreso Correctos.\nBienvenido, Administrador.\n\nPresione OK para entrar al menú principal.", "Inicio de Sesión Exitoso", JOptionPane.PLAIN_MESSAGE);
            next.setVisible(true);
            dispose();
        }
        else{
            JOptionPane.showMessageDialog(rootPane, "Usuario y/o contraseña incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
            mainPasswordField.setText("");
        }
        
//         if (usuario.equals("Nicole") && password.equals("luna")){
//            WelcomePage next = new WelcomePage();
//            JOptionPane.showMessageDialog(rootPane, "Datos de Ingreso Correctos.\nBienvenidegy, Nicole.\n\nPresione OK para entrar al menú principal.", "Inicio de Sesión Exitoso", JOptionPane.PLAIN_MESSAGE);
//            next.setVisible(true);
//            dispose();
//        }
//        else{
//            JOptionPane.showMessageDialog(rootPane, "Usuario y/o contraseña incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
//            mainPasswordField.setText("");
//        }
    }//GEN-LAST:event_entrarButtonActionPerformed

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
            java.util.logging.Logger.getLogger(SistemaFinancieroMainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SistemaFinancieroMainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SistemaFinancieroMainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SistemaFinancieroMainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SistemaFinancieroMainPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel copyrightLabel;
    private javax.swing.JButton entrarButton;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPasswordField mainPasswordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables
}