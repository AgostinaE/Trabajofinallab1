package proyectoFinalG1.Vistas;

import javax.swing.JOptionPane;
import proyectoFinalG1.Data.Conexion;
import proyectoFinalG1.Data.InquilinoData;
import proyectoFinalG1.Modelos.Inquilino;

/**
 *
 * @author Grupo 1
 */
public class NuevoInquilino extends javax.swing.JInternalFrame {

    /**
     * Creates new form NuevoInquilino
     */
    private InquilinoData id;
    
    public NuevoInquilino(Conexion conexion) {
        initComponents();
        inhabilitar();
        id = new InquilinoData(conexion);
    }
    
    private void limpiar(){
        jTxtNombre.setText("");  
        jTxtApellido.setText("");  
        jTxtCuil.setText("");
        jTxtTrabajo.setText(""); 
        jTxtGaranteN.setText(""); 
        jTxtGaranteDni.setText("");
    }
    
    private void habilitar(){
        jTxtNombre.setEnabled(true);  
        jTxtApellido.setEnabled(true);  
        jTxtTrabajo.setEnabled(true);
        jTxtGaranteN.setEnabled(true);   
        jTxtGaranteDni.setEnabled(true);
        jButton2.setEnabled(true);
        jButton5.setEnabled(true);
    }

    private void inhabilitar(){
        jTxtNombre.setEnabled(false);  
        jTxtApellido.setEnabled(false);  
        jTxtTrabajo.setEnabled(false);
        jTxtGaranteN.setEnabled(false);   
        jTxtGaranteDni.setEnabled(false);
        jButton2.setEnabled(false);
        jButton5.setEnabled(false);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTxtNombre = new javax.swing.JTextField();
        jTxtApellido = new javax.swing.JTextField();
        jTxtCuil = new javax.swing.JTextField();
        jTxtTrabajo = new javax.swing.JTextField();
        jTxtGaranteN = new javax.swing.JTextField();
        jTxtGaranteDni = new javax.swing.JTextField();
        jBtnNuevo = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jBtnBuscarXCuil = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();

        jButton3.setBackground(new java.awt.Color(204, 204, 255));
        jButton3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setText("Buscar Propiedad");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(204, 204, 255));
        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gestion de Inquilinos");
        jLabel1.setOpaque(true);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nombre");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Apellido");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("CUIT");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Lugar de Trabajo");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Nombre del Garante");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("DNI del Garante");

        jTxtNombre.setBackground(new java.awt.Color(204, 204, 204));
        jTxtNombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTxtNombre.setForeground(new java.awt.Color(0, 0, 0));

        jTxtApellido.setBackground(new java.awt.Color(204, 204, 204));
        jTxtApellido.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTxtApellido.setForeground(new java.awt.Color(0, 0, 0));

        jTxtCuil.setBackground(new java.awt.Color(204, 204, 204));
        jTxtCuil.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTxtCuil.setForeground(new java.awt.Color(0, 0, 0));
        jTxtCuil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtCuilActionPerformed(evt);
            }
        });

        jTxtTrabajo.setBackground(new java.awt.Color(204, 204, 204));
        jTxtTrabajo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTxtTrabajo.setForeground(new java.awt.Color(0, 0, 0));
        jTxtTrabajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtTrabajoActionPerformed(evt);
            }
        });

        jTxtGaranteN.setBackground(new java.awt.Color(204, 204, 204));
        jTxtGaranteN.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTxtGaranteN.setForeground(new java.awt.Color(0, 0, 0));
        jTxtGaranteN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtGaranteNActionPerformed(evt);
            }
        });

        jTxtGaranteDni.setBackground(new java.awt.Color(204, 204, 204));
        jTxtGaranteDni.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTxtGaranteDni.setForeground(new java.awt.Color(0, 0, 0));

        jBtnNuevo.setBackground(new java.awt.Color(204, 204, 255));
        jBtnNuevo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jBtnNuevo.setForeground(new java.awt.Color(0, 0, 0));
        jBtnNuevo.setText("Nuevo Inquilino");
        jBtnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnNuevoActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(204, 204, 255));
        jButton2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(204, 204, 255));
        jButton4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 0, 0));
        jButton4.setText("Editar datos de Inquilino");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(204, 204, 255));
        jButton5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 0, 0));
        jButton5.setText("Borrar Inquilino");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jBtnBuscarXCuil.setBackground(new java.awt.Color(204, 204, 255));
        jBtnBuscarXCuil.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jBtnBuscarXCuil.setForeground(new java.awt.Color(0, 0, 0));
        jBtnBuscarXCuil.setText("Buscar Inquilino Por CUIT");
        jBtnBuscarXCuil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnBuscarXCuilActionPerformed(evt);
            }
        });

        jToggleButton1.setBackground(new java.awt.Color(204, 204, 204));
        jToggleButton1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jToggleButton1.setForeground(new java.awt.Color(0, 0, 0));
        jToggleButton1.setText("Salir");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxtGaranteDni, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTxtGaranteN)
                                    .addComponent(jTxtApellido)
                                    .addComponent(jTxtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                                    .addComponent(jTxtCuil)
                                    .addComponent(jTxtTrabajo))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jBtnBuscarXCuil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jBtnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(169, 169, 169)
                        .addComponent(jToggleButton1)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jBtnNuevo))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTxtCuil, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnBuscarXCuil))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtGaranteN, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtGaranteDni, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jButton2))
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jToggleButton1))
                .addContainerGap(105, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTxtCuilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtCuilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtCuilActionPerformed

    private void jTxtTrabajoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtTrabajoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtTrabajoActionPerformed

    private void jTxtGaranteNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtGaranteNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtGaranteNActionPerformed

    private void jBtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNuevoActionPerformed
        // TODO add your handling code here:
        habilitar();
        limpiar();
    }//GEN-LAST:event_jBtnNuevoActionPerformed

    private void jBtnBuscarXCuilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnBuscarXCuilActionPerformed
        // TODO add your handling code here:
        try{
            Inquilino in=id.obetenerInquilinoPorCuil(Long.parseLong(jTxtCuil.getText()));
            jTxtNombre.setText(in.getNombre());  
        jTxtApellido.setText(in.getApellido());  
        jTxtTrabajo.setText(in.getTrabajo()); 
        jTxtGaranteN.setText(in.getGarante()); 
        jTxtGaranteDni.setText(in.getApellido()); 
        habilitar();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Debe cargar un Cuit valido para buscar un Inquilino");
        }
        
    }//GEN-LAST:event_jBtnBuscarXCuilActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        habilitar();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try{
            Inquilino in=new Inquilino();
            String nombre=jTxtNombre.getText();  
        String apellido =jTxtApellido.getText();  
        String trabajo=jTxtTrabajo.getText(); 
        String garante =jTxtGaranteN.getText(); 
        int dniGarante =Integer.parseInt(jTxtGaranteDni.getText()); 
        long cuil = Long.parseLong(jTxtCuil.getText());
        in.setNombre(nombre);
        in.setApellido(apellido);
        in.setCuil(cuil);
        in.setActivo(true);
        in.setTrabajo(trabajo);
        in.setGarante(garante);
        in.setDniGarante(dniGarante);
        id.agregarInquilino(in);
        limpiar();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "El Inquilino ya se encuentra en el sistema");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        try{
            Inquilino in = id.obetenerInquilinoPorCuil(Long.parseLong(jTxtCuil.getText()));
            id.borrarInquilino(in.getIdInquilino());
            limpiar();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Debe cargar un Cuit valido para buscar un Inquilino");
        }
    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnBuscarXCuil;
    private javax.swing.JButton jBtnNuevo;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextField jTxtApellido;
    private javax.swing.JTextField jTxtCuil;
    private javax.swing.JTextField jTxtGaranteDni;
    private javax.swing.JTextField jTxtGaranteN;
    private javax.swing.JTextField jTxtNombre;
    private javax.swing.JTextField jTxtTrabajo;
    // End of variables declaration//GEN-END:variables
}
