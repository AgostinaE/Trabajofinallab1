/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoFG1.Vistas;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author fotin
 */
public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
        initComponents();
        //jbPropietarios.setIcon(setIcono("src/images/propietarioIcon.png", jbPropietarios));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageIcon icon = new ImageIcon(getClass().getResource("/src/images/fondo1.jpg"));
        Image image = icon.getImage();
        jDesktopPane1 = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }
        };
        jbInmueblesDisponibles = new javax.swing.JButton();
        jbPropietarios = new javax.swing.JButton();
        jbInquilinos = new javax.swing.JButton();
        jbContratos = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmPropietarios = new javax.swing.JMenu();
        jmiPropietarioNuevo = new javax.swing.JMenuItem();
        jmiNuevoInmueble = new javax.swing.JMenuItem();
        jmInquilinos = new javax.swing.JMenu();
        jmiNuevoInquilino = new javax.swing.JMenuItem();
        jmiInmueblesDisponibles = new javax.swing.JMenuItem();
        jmContratos = new javax.swing.JMenu();
        jmiBuscarContrato = new javax.swing.JMenuItem();
        jmiNuevoContrato = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jbInmueblesDisponibles.setBackground(new java.awt.Color(204, 204, 204));
        jbInmueblesDisponibles.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 18)); // NOI18N
        jbInmueblesDisponibles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buscarAlquilerIconTam.png"))); // NOI18N
        jbInmueblesDisponibles.setText("Inmuebles Disponibles");
        jbInmueblesDisponibles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbInmueblesDisponiblesActionPerformed(evt);
            }
        });

        jbPropietarios.setBackground(java.awt.Color.lightGray);
        jbPropietarios.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 18)); // NOI18N
        jbPropietarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/propietarioIconTam.png"))); // NOI18N
        jbPropietarios.setText("Propietario nuevo");
        jbPropietarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPropietariosActionPerformed(evt);
            }
        });

        jbInquilinos.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 18)); // NOI18N
        jbInquilinos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/inquilinoIconTam.png"))); // NOI18N
        jbInquilinos.setText("Inquilino nuevo");

        jbContratos.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 18)); // NOI18N
        jbContratos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/contratoIconTam.png"))); // NOI18N
        jbContratos.setText("Contrato Nuevo");
        jbContratos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbContratosActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/agregarPropiedadTam.png"))); // NOI18N
        jButton1.setText("Inmuebles Nuevos");

        jButton2.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buscarContratoTam.png"))); // NOI18N
        jButton2.setText("Búsqueda de Contratos");

        jButton3.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 18)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empleadoTam.png"))); // NOI18N
        jButton3.setText("Gestión Empleado");

        jDesktopPane1.setLayer(jbInmueblesDisponibles, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jbPropietarios, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jbInquilinos, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jbContratos, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbContratos)
                .addGap(70, 70, 70))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(jbPropietarios)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 147, Short.MAX_VALUE)
                        .addComponent(jbInmueblesDisponibles)
                        .addGap(25, 25, 25))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jbInquilinos)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(231, 231, 231)
                .addComponent(jButton2)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbInquilinos)
                    .addComponent(jbPropietarios))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jbInmueblesDisponibles))
                .addGap(50, 50, 50)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jbContratos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jmPropietarios.setText("Propietarios");

        jmiPropietarioNuevo.setText("Propietario Nuevo");
        jmiPropietarioNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiPropietarioNuevoActionPerformed(evt);
            }
        });
        jmPropietarios.add(jmiPropietarioNuevo);

        jmiNuevoInmueble.setText("Nuevo inmueble");
        jmPropietarios.add(jmiNuevoInmueble);

        jMenuBar1.add(jmPropietarios);

        jmInquilinos.setText("Inquilinos");

        jmiNuevoInquilino.setText("Nuevo Inquilino");
        jmiNuevoInquilino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiNuevoInquilinoActionPerformed(evt);
            }
        });
        jmInquilinos.add(jmiNuevoInquilino);

        jmiInmueblesDisponibles.setText("Inmuebles Disponibles");
        jmiInmueblesDisponibles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiInmueblesDisponiblesActionPerformed(evt);
            }
        });
        jmInquilinos.add(jmiInmueblesDisponibles);

        jMenuBar1.add(jmInquilinos);

        jmContratos.setText("Contratos");

        jmiBuscarContrato.setText("Busqueda de Contratos");
        jmiBuscarContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiBuscarContratoActionPerformed(evt);
            }
        });
        jmContratos.add(jmiBuscarContrato);

        jmiNuevoContrato.setText("Nuevo contrato");
        jmiNuevoContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiNuevoContratoActionPerformed(evt);
            }
        });
        jmContratos.add(jmiNuevoContrato);

        jMenuBar1.add(jmContratos);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jDesktopPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbInmueblesDisponiblesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbInmueblesDisponiblesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbInmueblesDisponiblesActionPerformed

    private void jbContratosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbContratosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbContratosActionPerformed

    private void jbPropietariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPropietariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbPropietariosActionPerformed

    private void jmiPropietarioNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiPropietarioNuevoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmiPropietarioNuevoActionPerformed

    private void jmiNuevoInquilinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiNuevoInquilinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmiNuevoInquilinoActionPerformed

    private void jmiBuscarContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiBuscarContratoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmiBuscarContratoActionPerformed

    private void jmiNuevoContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiNuevoContratoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmiNuevoContratoActionPerformed

    private void jmiInmueblesDisponiblesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiInmueblesDisponiblesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmiInmueblesDisponiblesActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MenuPrincipal().setVisible(true);
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JButton jbContratos;
    private javax.swing.JButton jbInmueblesDisponibles;
    private javax.swing.JButton jbInquilinos;
    private javax.swing.JButton jbPropietarios;
    private javax.swing.JMenu jmContratos;
    private javax.swing.JMenu jmInquilinos;
    private javax.swing.JMenu jmPropietarios;
    private javax.swing.JMenuItem jmiBuscarContrato;
    private javax.swing.JMenuItem jmiInmueblesDisponibles;
    private javax.swing.JMenuItem jmiNuevoContrato;
    private javax.swing.JMenuItem jmiNuevoInmueble;
    private javax.swing.JMenuItem jmiNuevoInquilino;
    private javax.swing.JMenuItem jmiPropietarioNuevo;
    // End of variables declaration//GEN-END:variables
}
