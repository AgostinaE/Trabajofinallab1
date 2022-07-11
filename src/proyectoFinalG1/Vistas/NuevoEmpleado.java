package proyectoFinalG1.Vistas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyectoFinalG1.Data.Conexion;
import proyectoFinalG1.Data.EmpleadoData;
import proyectoFinalG1.Modelos.Empleado;

/**
 *
 * @author Grupo 1
 */
public class NuevoEmpleado extends javax.swing.JInternalFrame {

    private EmpleadoData ed;
    private ArrayList<Empleado> listaEmpleados;
    private DefaultTableModel modelo;

    public NuevoEmpleado(Conexion conexion) {
        initComponents();
        limpiarCampos();
        ed = new EmpleadoData(conexion);
        desactivaCampos();

        listaEmpleados = (ArrayList<Empleado>) ed.obtenerEmpleados();
        cargoCombo();
        modelo = new DefaultTableModel();
        cargaEmpleados();
        
        jCBEmpleado.enable(true);
        jBBorrarEmpleado.enable(false);
        jBBuscarEmpleado.enable(false);
        jBEditarEmpleado.enable(false);
        jBGuardar.enable(false);
        jBNuevo.enable(true);
        
    }

    private void cargaEmpleados() {

        Empleado selec = (Empleado) jCBEmpleado.getSelectedItem();
        listaEmpleados = (ArrayList<Empleado>) ed.obtenerEmpleados();

        for (Empleado a : listaEmpleados) {
            modelo.addRow(new Object[]{a.getApellido(), a.getNombre(), a.getDni()});
        }

    }

    public void cargoCombo() {
        //Carga los Empleado al ComboBox
        Collections.sort(listaEmpleados, new Comparator<Empleado>() {
            @Override
            public int compare(Empleado t, Empleado t1) {
                return t.getApellido().compareTo(t1.getApellido());
            }
        });
        for (Empleado aux : listaEmpleados) {
            jCBEmpleado.addItem(aux);
        }

    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTNombre = new javax.swing.JTextField();
        jTApellido = new javax.swing.JTextField();
        jTDni = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jBNuevo = new javax.swing.JButton();
        jBGuardar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jCBEmpleado = new javax.swing.JComboBox<>();
        jBEditarEmpleado = new javax.swing.JButton();
        jBBorrarEmpleado = new javax.swing.JButton();
        jcbActivo = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        jBSalir = new javax.swing.JButton();
        jBBuscarEmpleado = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTId = new javax.swing.JTextField();

        jTNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTNombreActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre");

        jLabel2.setText("Apellido");

        jLabel3.setText("DNI");

        jBNuevo.setText("Agregar Nuevo Empleado");
        jBNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBNuevoActionPerformed(evt);
            }
        });

        jBGuardar.setText("Guardar");
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 24)); // NOI18N
        jLabel5.setText("Nuevo Empleado");

        jCBEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBEmpleadoActionPerformed(evt);
            }
        });

        jBEditarEmpleado.setText("Editar datos de empleado");
        jBEditarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEditarEmpleadoActionPerformed(evt);
            }
        });

        jBBorrarEmpleado.setText("Borrar Empleado");
        jBBorrarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBorrarEmpleadoActionPerformed(evt);
            }
        });

        jcbActivo.setSelected(true);

        jLabel6.setText("Activo");

        jBSalir.setText("Salir");
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });

        jBBuscarEmpleado.setText("Buscar empleado");
        jBBuscarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarEmpleadoActionPerformed(evt);
            }
        });

        jLabel4.setText("Codigo Empleado");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBNuevo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBEditarEmpleado)
                                .addGap(70, 70, 70)
                                .addComponent(jBBorrarEmpleado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbActivo)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTApellido)
                                .addComponent(jTNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTDni, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTId, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(jBBuscarEmpleado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCBEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
            .addGroup(layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbActivo)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBNuevo)
                    .addComponent(jBGuardar))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jCBEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBBuscarEmpleado))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBEditarEmpleado)
                    .addComponent(jBBorrarEmpleado)
                    .addComponent(jBSalir))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTNombreActionPerformed

    private void jBNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNuevoActionPerformed
        limpiarCampos();
        activaCampos();
        jBGuardar.enable(true);

    }//GEN-LAST:event_jBNuevoActionPerformed

    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed

        
        String nombre = jTNombre.getText();
        String apellido = jTApellido.getText();
        int dni = Integer.parseInt(jTDni.getText());
        Boolean activo = jcbActivo.isSelected();

        Empleado empleado = new Empleado(nombre, apellido, dni, activo);
        if (ed.agregarEmpleado(empleado)) {
            jTId.setText(empleado.getIdEmpleado() + "");
            JOptionPane.showMessageDialog(this, "Empleado Agregado con Exito");
        }
        limpiarCampos();
        
        //Actualiza el jComboBox Empleado para que muestre los datos Actualizados.
        jCBEmpleado.removeAllItems();
        listaEmpleados = (ArrayList<Empleado>) ed.obtenerEmpleados();
        cargoCombo();
        modelo = new DefaultTableModel();
        cargaEmpleados();
    }//GEN-LAST:event_jBGuardarActionPerformed

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jBSalirActionPerformed

    private void jBEditarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEditarEmpleadoActionPerformed
        activaCampos();
        try {
            int id = Integer.parseInt(jTId.getText());
            String nombre = jTNombre.getText();
            String apellido = jTApellido.getText();
            boolean activo = jcbActivo.isSelected();
            int dni = Integer.parseInt(jTDni.getText());
            Empleado empleado = new Empleado(id, nombre, apellido, dni, activo);
            if (ed.modificarEmpleado(empleado)) {

            JOptionPane.showMessageDialog(this, "Empleado modificado con Exito");
        }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, "Usted debe ingresar un numero");
            jTDni.requestFocus();

        }

        
        
        limpiarCampos();
        borraFilasTabla();
        
        //Actualiza el jComboBox Empleado para que muestre los datos Actualizados.
        jCBEmpleado.removeAllItems();
        listaEmpleados = (ArrayList<Empleado>) ed.obtenerEmpleados();
        cargoCombo();
        modelo = new DefaultTableModel();
        cargaEmpleados();
        
    }//GEN-LAST:event_jBEditarEmpleadoActionPerformed

    private void jBBuscarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarEmpleadoActionPerformed

        jBBorrarEmpleado.enable(true);       
        jBEditarEmpleado.enable(true);
        jBGuardar.enable(false);
        jBNuevo.enable(false);
        activaCampos();
        Empleado em = (Empleado) jCBEmpleado.getSelectedItem();
        long dni = em.getDni();

        Empleado empleado = ed.obtenerEmpleadoXDNI(dni);
        if (empleado != null) {
            jTId.setText(empleado.getIdEmpleado() + "");
            jTDni.setText(empleado.getDni() + "");
            jTApellido.setText(empleado.getApellido() + "");
            jTNombre.setText(empleado.getNombre() + "");
            jcbActivo.enable(false);

        } else {
            JOptionPane.showMessageDialog(this, "No hay un empleado activo asociado a ese codigo");
        }
    }//GEN-LAST:event_jBBuscarEmpleadoActionPerformed

    private void jBBorrarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBorrarEmpleadoActionPerformed

        Empleado empleado = new Empleado();
        int id = -1;
        id = Integer.parseInt(jTId.getText());
        
        if (ed.borrarEmpleado(id)) {
            JOptionPane.showMessageDialog(null, "Empleado borrado con Exito");
            limpiarCampos();
            desactivaCampos();
        }
        
         //Actualiza el jComboBox Empleado para que muestre los datos Actualizados.
        jCBEmpleado.removeAllItems();
        listaEmpleados = (ArrayList<Empleado>) ed.obtenerEmpleados();
        cargoCombo();
        modelo = new DefaultTableModel();
        cargaEmpleados();
    }//GEN-LAST:event_jBBorrarEmpleadoActionPerformed

    private void jCBEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBEmpleadoActionPerformed
        jBGuardar.enable(false);
        jBNuevo.enable(false);
        jBBuscarEmpleado.enable(true);
        borraFilasTabla();
        
        
    }//GEN-LAST:event_jCBEmpleadoActionPerformed

    private void limpiarCampos() {

        jTId.setText("");
        jTNombre.setText("");
        jTApellido.setText("");
        jTDni.setText("");
    }

    private void activaCampos() {
        jTId.setEnabled(false);
        jTNombre.setEnabled(true);
        jTApellido.setEnabled(true);
        jTDni.setEnabled(true);

    }

    private void desactivaCampos() {
        jTId.setEnabled(false);
        jTNombre.setEnabled(false);
        jTApellido.setEnabled(false);
        jTDni.setEnabled(false);

    }

    private void borraFilasTabla() {
        if (modelo != null) {
            int a = modelo.getRowCount() - 1;

            for (int i = a; i >= 0; i--) {

                modelo.removeRow(i);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBBorrarEmpleado;
    private javax.swing.JButton jBBuscarEmpleado;
    private javax.swing.JButton jBEditarEmpleado;
    private javax.swing.JButton jBGuardar;
    private javax.swing.JButton jBNuevo;
    private javax.swing.JButton jBSalir;
    private javax.swing.JComboBox<Empleado> jCBEmpleado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTApellido;
    private javax.swing.JTextField jTDni;
    private javax.swing.JTextField jTId;
    private javax.swing.JTextField jTNombre;
    private javax.swing.JCheckBox jcbActivo;
    // End of variables declaration//GEN-END:variables
}
