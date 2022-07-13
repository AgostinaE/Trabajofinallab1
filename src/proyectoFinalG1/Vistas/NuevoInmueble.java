package proyectoFinalG1.Vistas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JOptionPane;
import proyectoFinalG1.Data.Conexion;
import proyectoFinalG1.Data.InmuebleData;
import proyectoFinalG1.Data.PropietarioData;
import proyectoFinalG1.Data.Validacion;
import proyectoFinalG1.Modelos.Empleado;
import proyectoFinalG1.Modelos.Inmueble;
import proyectoFinalG1.Modelos.Propietario;

/**
 *
 * @author Grupo 1
 */
public class NuevoInmueble extends javax.swing.JInternalFrame {

    /**
     * Creates new form NuevoInmueble
     */
    private InmuebleData id;
    private PropietarioData pd;
    private ArrayList<Propietario> listaPropietarios;
    private Validacion vd;

    public NuevoInmueble(Conexion conexion) {
        initComponents();
        limpiarCampos();
        desactivaCampos();
        jBtnNuevo.setEnabled(false);
        jButton1.setEnabled(false);
        jTxtCodigoPropiedad.setEnabled(true);
        id = new InmuebleData(conexion);
        vd = new Validacion();
        pd = new PropietarioData(conexion);
        listaPropietarios = (ArrayList<Propietario>) pd.obtenerPropietarios();
        cargarPropietarios();
    }

    private void cargarPropietarios() {
        Collections.sort(listaPropietarios, new Comparator<Propietario>() {
            @Override
            public int compare(Propietario t, Propietario t1) {
                return t.getApellido().compareTo(t1.getApellido());
            }
        });
        for (Propietario aux : listaPropietarios) {
            jCbPropietarios.addItem(aux);
        }
    }

    private boolean validarCampos() {
        boolean valido = true;
        if (vd.EstaVacio(jTxtCodigoPropiedad.getText())) {
            JOptionPane.showMessageDialog(this, "No indico un codigo para la propiedad");
            valido = false;
        }
        if (!vd.EsPalabra(jTxtTipo.getText())) {
            JOptionPane.showMessageDialog(this, "No indico un tipo valido para la propiedad");
            valido = false;
        }
        if (jCbPropietarios.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "No indico un propietario para la propiedad");
            valido = false;
        }
        if (Integer.parseInt((String) jCbZona.getSelectedItem()) < 0) {
            JOptionPane.showMessageDialog(this, "No indico una zona para la propiedad");
            valido = false;
        }
        if (Float.parseFloat(jTxtSuperficie.getText()) < 0) {
            JOptionPane.showMessageDialog(this, "No indico una superficie para la propiedad");
            valido = false;
        }
        if (Double.parseDouble(jTxtPrecio.getText()) < 0) {
            JOptionPane.showMessageDialog(this, "No indico un precio para la propiedad");
            valido = false;
        }
        if (vd.EstaVacio(jTxtDireccion.getText())) {
            JOptionPane.showMessageDialog(this, "No indico una direccion para la propiedad");
            valido = false;
        }
        if (vd.EstaVacio(jTxtAreaCaracteristicas.getText())) {
            JOptionPane.showMessageDialog(this, "No indico caracteristicas para la propiedad");
            valido = false;
        }
        return valido;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCBTipo = new javax.swing.JComboBox<>();
        jBGuardar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTxtPrecio = new javax.swing.JTextField();
        jTxtSuperficie = new javax.swing.JTextField();
        jTxtTipo = new javax.swing.JTextField();
        jTxtCodigoPropiedad = new javax.swing.JTextField();
        jCbPropietarios = new javax.swing.JComboBox<>();
        jBtnNuevo = new javax.swing.JButton();
        jBtnSalir = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jCbZona = new javax.swing.JComboBox<>();
        jTxtDireccion = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTxtAreaCaracteristicas = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jTxtId = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jBtNuevaPropiedad = new javax.swing.JButton();

        jBGuardar.setText("Guardar");
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(51, 102, 255));
        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Nueva Propiedad");
        jLabel1.setOpaque(true);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setText("Elige el Propietario");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setText("Dirección");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setText("Codigo de Propiedad");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setText("Tipo de Inmueble");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setText("Superficie (m²)");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setText("Caracteristicas");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel8.setText("Zona");

        jTxtPrecio.setBackground(new java.awt.Color(204, 204, 204));
        jTxtPrecio.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        jTxtSuperficie.setBackground(new java.awt.Color(204, 204, 204));
        jTxtSuperficie.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        jTxtTipo.setBackground(new java.awt.Color(204, 204, 204));
        jTxtTipo.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        jTxtCodigoPropiedad.setBackground(new java.awt.Color(204, 204, 204));
        jTxtCodigoPropiedad.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        jCbPropietarios.setBackground(new java.awt.Color(204, 204, 204));
        jCbPropietarios.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        jBtnNuevo.setBackground(new java.awt.Color(153, 153, 153));
        jBtnNuevo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jBtnNuevo.setText("Cargar Nueva Propiedad");
        jBtnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnNuevoActionPerformed(evt);
            }
        });

        jBtnSalir.setBackground(new java.awt.Color(153, 153, 153));
        jBtnSalir.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jBtnSalir.setText("Salir");
        jBtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalirActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel9.setText("Precio de Alquiler ( $ AR)");

        jCbZona.setBackground(new java.awt.Color(204, 204, 204));
        jCbZona.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jCbZona.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));

        jTxtDireccion.setBackground(new java.awt.Color(204, 204, 204));
        jTxtDireccion.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        jTxtAreaCaracteristicas.setBackground(new java.awt.Color(204, 204, 204));
        jTxtAreaCaracteristicas.setColumns(20);
        jTxtAreaCaracteristicas.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTxtAreaCaracteristicas.setRows(5);
        jScrollPane1.setViewportView(jTxtAreaCaracteristicas);

        jButton1.setBackground(new java.awt.Color(153, 153, 153));
        jButton1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Modificar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(153, 153, 153));
        jButton2.setText("Buscar Por Numero Propiedad");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel10.setText("Numero de Inmueble (ID)");

        jTxtId.setBackground(new java.awt.Color(204, 204, 204));
        jTxtId.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jButton4.setBackground(new java.awt.Color(153, 153, 153));
        jButton4.setText("Buscar Por Codigo Propiedad");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jBtNuevaPropiedad.setBackground(new java.awt.Color(153, 153, 153));
        jBtNuevaPropiedad.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jBtNuevaPropiedad.setText("Nueva Propiedad");
        jBtNuevaPropiedad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNuevaPropiedadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2))
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCbPropietarios, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTxtId, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTxtCodigoPropiedad, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTxtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jCbZona, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxtSuperficie, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtNuevaPropiedad)
                        .addGap(39, 39, 39))))
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jBtnNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89)
                .addComponent(jBtnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jTxtId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTxtCodigoPropiedad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTxtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCbPropietarios, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jCbZona, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTxtSuperficie, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jTxtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtNuevaPropiedad, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTxtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNuevoActionPerformed
        try {
            String codigoPropiedad = (String) jTxtCodigoPropiedad.getText();
            String tipo = (String) jTxtTipo.getText();
            Propietario propietario = (Propietario) jCbPropietarios.getSelectedItem();
            int zona = Integer.parseInt((String) jCbZona.getSelectedItem());
            float superficie = Float.parseFloat(jTxtSuperficie.getText());
            double precio = Double.parseDouble(jTxtPrecio.getText());
            String direccion = (String) jTxtDireccion.getText();
            String caracteristicas = (String) jTxtAreaCaracteristicas.getText();

            if (validarCampos()) {
                Inmueble inmueble = new Inmueble(caracteristicas, direccion, precio, superficie, tipo, zona, propietario, codigoPropiedad, true);
                if (id.agregarInmueble(inmueble)) {
                    JOptionPane.showMessageDialog(this, "La propiedad se cargo con exito");
                    limpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo cargar la propiedad");
                }

            } else {
                JOptionPane.showMessageDialog(this, "Faltan datos en el formulario o son incorrectos");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Faltan datos en el formulario o son incorrectos");
        }

        jBGuardar.setEnabled(true);

    }//GEN-LAST:event_jBtnNuevoActionPerformed

    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed

        /*String direccion = jTDireccion.getText();
        String altura = jtApellidoAlumno.getText();        
        Long dni = Long.parseLong(jtDni.getText());
        Boolean activo = jcbActivo.isSelected();
        
        //Obtenemos la fecja del jcalendar y la pasamos a LocalDate
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");        
        String fecha = formatoFecha.format(jdFechaNacimiento.getDate());
        LocalDate fechNac = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        
        
        //(int idAlumno, String nombre, String apellido, LocalDate fechNac, long dni, boolean activo) {
        Alumno alumno = new Alumno(nombre,apellido,fechNac,dni,activo);
        if(ad.agregarAlumno(alumno)){
            jtIdAlumno.setText(alumno.getIdAlumno()+"");
            JOptionPane.showMessageDialog(this, "Alumno Agregado con Exito");            
            jbNuevo.setEnabled(true);
            
        }*/

    }//GEN-LAST:event_jBGuardarActionPerformed

    private void jBtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jBtnSalirActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            String codigoPropiedad = (String) jTxtCodigoPropiedad.getText();
            String tipo = (String) jTxtTipo.getText();
            Propietario propietario = (Propietario) jCbPropietarios.getSelectedItem();
            int zona = Integer.parseInt((String) jCbZona.getSelectedItem());
            float superficie = Float.parseFloat(jTxtSuperficie.getText());
            double precio = Double.parseDouble(jTxtPrecio.getText());
            String direccion = (String) jTxtDireccion.getText();
            String caracteristicas = (String) jTxtAreaCaracteristicas.getText();
            int iD = Integer.parseInt(jTxtId.getText());

            if (validarCampos()) {
                Inmueble inmueble = new Inmueble(iD, caracteristicas, direccion, precio, superficie, tipo, zona, propietario, codigoPropiedad, true);
                if (id.modificarInmueble(inmueble)) {
                    JOptionPane.showMessageDialog(this, "La propiedad se cargo con exito");
                    limpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo cargar la propiedad");
                }

            } else {
                JOptionPane.showMessageDialog(this, "Faltan datos en el formulario o son incorrectos");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Faltan datos en el formulario o son incorrectos");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        try {
            activaCampos();
            jButton1.setEnabled(true);
            String codigo = jTxtCodigoPropiedad.getText();
            Inmueble in = id.obtenerInmuebleXCodigoInmueble(codigo);
            jTxtId.setText(in.getIdInmueble() + "");
            jTxtTipo.setText(in.getTipoLocal());
            jCbPropietarios.setSelectedItem(in.getPropietario().toString());
            jCbZona.setSelectedItem(in.getZona());
            jTxtSuperficie.setText(in.getSuperficie() + "");
            jTxtPrecio.setText(in.getPrecio() + "");
            jTxtDireccion.setText(in.getDireccion());
            jTxtAreaCaracteristicas.setText(in.getCaracteristicas());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Codigo de Inmueble incorrecto");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            activaCampos();
            jButton1.setEnabled(true);
            int iD = Integer.parseInt(jTxtId.getText());
            Inmueble in = id.obtenerInmuebleXId(iD);
            jTxtCodigoPropiedad.setText(in.getCodigoInmueble());
            jTxtTipo.setText(in.getTipoLocal());
            jCbPropietarios.setSelectedItem(in.getPropietario().toString());
            jCbZona.setSelectedItem(in.getZona());
            jTxtSuperficie.setText(in.getSuperficie() + "");
            jTxtPrecio.setText(in.getPrecio() + "");
            jTxtDireccion.setText(in.getDireccion());
            jTxtAreaCaracteristicas.setText(in.getCaracteristicas());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Numero de Inmueble incorrecto");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jBtNuevaPropiedadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNuevaPropiedadActionPerformed
        // TODO add your handling code here:
        limpiarCampos();
        activaCampos();
        jButton4.setEnabled(false);
        jButton2.setEnabled(false);
        jBtnNuevo.setEnabled(true);
        jButton1.setEnabled(false);  
        jTxtId.setEnabled(false);
    }//GEN-LAST:event_jBtNuevaPropiedadActionPerformed

    private void limpiarCampos() {
        jTxtId.setText("");
        jTxtSuperficie.setText("");
        jTxtPrecio.setText("");
        jTxtCodigoPropiedad.setText("");
        jTxtTipo.setText("");
        jTxtAreaCaracteristicas.setText("");
        jTxtDireccion.setText("");
    }

    private void activaCampos() {
        jTxtSuperficie.setEnabled(true);
        jTxtPrecio.setEnabled(true);
        jTxtCodigoPropiedad.setEnabled(true);
        jTxtTipo.setEnabled(true);
        jCbPropietarios.setEnabled(true);
        jCBTipo.setEnabled(true);
        jCbPropietarios.setEnabled(true);
        jTxtDireccion.setEnabled(true);
        jTxtAreaCaracteristicas.setEnabled(true);
    }

    private void desactivaCampos() {
        jTxtSuperficie.setEnabled(false);
        jTxtPrecio.setEnabled(false);
        jTxtCodigoPropiedad.setEnabled(false);
        jTxtTipo.setEnabled(false);
        jCbPropietarios.setEnabled(false);
        jCBTipo.setEnabled(false);
        jCbPropietarios.setEnabled(false);
        jTxtDireccion.setEnabled(false);
        jTxtAreaCaracteristicas.setEnabled(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBGuardar;
    private javax.swing.JButton jBtNuevaPropiedad;
    private javax.swing.JButton jBtnNuevo;
    private javax.swing.JButton jBtnSalir;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jCBTipo;
    private javax.swing.JComboBox<Propietario> jCbPropietarios;
    private javax.swing.JComboBox<String> jCbZona;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTxtAreaCaracteristicas;
    private javax.swing.JTextField jTxtCodigoPropiedad;
    private javax.swing.JTextField jTxtDireccion;
    private javax.swing.JTextField jTxtId;
    private javax.swing.JTextField jTxtPrecio;
    private javax.swing.JTextField jTxtSuperficie;
    private javax.swing.JTextField jTxtTipo;
    // End of variables declaration//GEN-END:variables
}
