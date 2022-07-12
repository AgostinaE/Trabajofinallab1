/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoFinalG1.Vistas;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyectoFinalG1.Data.Conexion;
import proyectoFinalG1.Data.ContratoData;
import proyectoFinalG1.Data.EmpleadoData;
import proyectoFinalG1.Data.InmuebleData;
import proyectoFinalG1.Data.InquilinoData;
import proyectoFinalG1.Modelos.Contrato;
import proyectoFinalG1.Modelos.Empleado;
import proyectoFinalG1.Modelos.Inmueble;
import proyectoFinalG1.Modelos.Inquilino;

/**
 *
 * @author fotin
 */
public class BusquedaContrato extends javax.swing.JInternalFrame {

    /**
     * Creates new form BusquedaContrato
     */
    private ContratoData cd;
    private InmuebleData id;
    private InquilinoData ind;
    private EmpleadoData ed;
    private DefaultTableModel modelo;
    private ArrayList<Inquilino> listaInquilinos;
    private ArrayList<Inmueble> listaInmuebles;
    private ArrayList<Empleado> listaEmpleados;
    private ArrayList<Contrato> listaContratos;
    
    public BusquedaContrato(Conexion conexion) {
        initComponents();
        cd = new ContratoData(conexion);
        id = new InmuebleData(conexion);
        ind = new InquilinoData(conexion);
        ed = new EmpleadoData(conexion);
        modelo = new DefaultTableModel();
        armarTabla();
        listaInquilinos = (ArrayList<Inquilino>) ind.obtenerInquilino();
        cargarInquilinos();
        listaInmuebles = (ArrayList<Inmueble>) id.alquilados();
        cargarInmuebles();
        listaEmpleados = (ArrayList<Empleado>) ed.obtenerEmpleados();
        cargarEmpleados();
        listaContratos = (ArrayList<Contrato>) cd.obtenerContratos();
        cargarContratos();
        inhabilitar();
    }
    
    private void cargarContratos(){
        Collections.sort(listaContratos, new Comparator<Contrato>() {
            @Override
            public int compare(Contrato t, Contrato t1) {
                return t.getInquilino().getApellido().compareTo(t1.getInquilino().getApellido());
            }
        });
        for (Contrato c : listaContratos) {
            String estado;
            if(c.isActivo()){
                estado="Activo";
            }else{
                estado="Inactivo";
            }
            modelo.addRow(new Object[]{c.getIdContrato(), c.getInquilino().toString(), c.getInmueble().getCodigoInmueble(), c.getInmueble().getPrecio(), c.getInicio(),c.getFinalizacion(),c.getEmpleado().toString(),estado});
        }
    }
    
    private void cargarEmpleados(){
        Collections.sort(listaEmpleados, new Comparator<Empleado>() {
            @Override
            public int compare(Empleado t, Empleado t1) {
                return t.getApellido().compareTo(t1.getApellido());
            }
        });
        for (Empleado aux : listaEmpleados) {
            jCbEmpleados.addItem(aux);
        }
    }
    
    private void cargarInmuebles(){
        Collections.sort(listaInmuebles, new Comparator<Inmueble>() {
            @Override
            public int compare(Inmueble t, Inmueble t1) {
                return t.getCodigoInmueble().compareTo(t1.getCodigoInmueble());
            }
        });
        for (Inmueble aux : listaInmuebles) {
            jCbInmuebles.addItem(aux);
        }
    }
    
    private void cargarInquilinos(){
        Collections.sort(listaInquilinos, new Comparator<Inquilino>() {
            @Override
            public int compare(Inquilino t, Inquilino t1) {
                return t.getApellido().compareTo(t1.getApellido());
            }
        });
        for (Inquilino aux : listaInquilinos) {
            jCbInquilinos.addItem(aux);
        }
    }

    private void armarTabla(){
        ArrayList<Object> columnas = new ArrayList<>();
        columnas.add("Codigo del Contrato");
        columnas.add("Inquilino");
        columnas.add("Codigo Inmueble");
        columnas.add("Precio");
        columnas.add("Inicio");
        columnas.add("Finalizacion");
        columnas.add("Vendedor");
        columnas.add("Estado");
        for (Object it : columnas) {

            modelo.addColumn(it);
        }
        jTContratos.setModel(modelo);
    }
    
    private void cargarXInquilino(){
        borrarFilas();
        Inquilino selected = (Inquilino) jCbInquilinos.getSelectedItem();
        listaContratos = (ArrayList<Contrato>)cd.buscarContratosXInquilino(selected.getCuil());
        for (Contrato c : listaContratos) {
            String estado;
            if(c.isActivo()){
                estado="Activo";
            }else{
                estado="Inactivo";
            }
            modelo.addRow(new Object[]{c.getIdContrato(), c.getInquilino().toString(), c.getInmueble().getCodigoInmueble(), c.getInmueble().getPrecio(), c.getInicio(),c.getFinalizacion(),c.getEmpleado().toString(),estado});
        }
    }
    
    private void cargarXPropiedad(){
        borrarFilas();
        Inmueble selected = (Inmueble) jCbInmuebles.getSelectedItem();
        listaContratos = (ArrayList<Contrato>)cd.buscarContratosXPropiedad(selected.getCodigoInmueble());
        for (Contrato c : listaContratos) {
            String estado;
            if(c.isActivo()){
                estado="Activo";
            }else{
                estado="Inactivo";
            }
            modelo.addRow(new Object[]{c.getIdContrato(), c.getInquilino().toString(), c.getInmueble().getCodigoInmueble(), c.getInmueble().getPrecio(), c.getInicio(),c.getFinalizacion(),c.getEmpleado().toString(),estado});
        }
    }
    
    private void cargarXVendedor(){
        borrarFilas();
        Empleado selected = (Empleado) jCbEmpleados.getSelectedItem();
        listaContratos = (ArrayList<Contrato>) cd.buscarContratosXVendedor(selected.getDni());
        for (Contrato c : listaContratos) {
            String estado;
            if(c.isActivo()){
                estado="Activo";
            }else{
                estado="Inactivo";
            }
            modelo.addRow(new Object[]{c.getIdContrato(), c.getInquilino().toString(), c.getInmueble().getCodigoInmueble(), c.getInmueble().getPrecio(), c.getInicio(),c.getFinalizacion(),c.getEmpleado().toString(),estado});
        }
    }
    
    private void borrarFilas(){
        if (modelo != null) {
            int a = modelo.getRowCount() - 1;

            for (int i = a; i >= 0; i--) {

                modelo.removeRow(i);
            }
        }
    }
    
    private void vencidos(){
        borrarFilas();
        listaContratos = (ArrayList<Contrato>) cd.buscarContratosVencidos();
        for (Contrato c : listaContratos) {
            String estado;
            if(c.isActivo()){
                estado="Activo";
            }else{
                estado="Inactivo";
            }
            modelo.addRow(new Object[]{c.getIdContrato(), c.getInquilino().toString(), c.getInmueble().getCodigoInmueble(), c.getInmueble().getPrecio(), c.getInicio(),c.getFinalizacion(),c.getEmpleado().toString(),estado});
        }
    }
    
    private void cargarContrato(Contrato c){
        borrarFilas();
        String estado;
            if(c.isActivo()){
                estado="Activo";
            }else{
                estado="Inactivo";
            }
            modelo.addRow(new Object[]{c.getIdContrato(), c.getInquilino().toString(), c.getInmueble().getCodigoInmueble(), c.getInmueble().getPrecio(), c.getInicio(),c.getFinalizacion(),c.getEmpleado().toString(),estado});
    }
    
    private void mostratContrato(){
        int filaSeleccionada = jTContratos.getSelectedRow();

        if (filaSeleccionada != -1) {
            int idContrato = (Integer) modelo.getValueAt(filaSeleccionada, 0);
            Contrato contrato = cd.buscarContratoXId(idContrato);
            jTxtIdInmueble.setText(idContrato+"");
            jDcInicio.setDate(Date.valueOf(contrato.getInicio()));
            jDcFinalizacion.setDate(Date.valueOf(contrato.getFinalizacion()));
            jDcFirma.setText(Date.valueOf(contrato.getFirma())+"");
            jLVendedor.setText(contrato.getEmpleado().getDni()+"");
            jLInquilino.setText(contrato.getInquilino().toString());
            jLCodigoPropiedad.setText(contrato.getInmueble().getCodigoInmueble());
            if(contrato.isActivo()){
                jLEstado.setText("Activo");
            }else{
                jLEstado.setText("Inactivo");
            }
            

        }
    }
    
    private void mostrarContrato2(){
        int select = jTContratos.getSelectedRow();
        int idContrato = (Integer) modelo.getValueAt(select, 0) ;
            Contrato contrato = cd.buscarContratoXId(idContrato);
            jTxtIdInmueble.setText(idContrato+"");
            jDcInicio.setDate(Date.valueOf(contrato.getInicio()));
            jDcFinalizacion.setDate(Date.valueOf(contrato.getFinalizacion()));
            jDcFirma.setText(Date.valueOf(contrato.getFirma())+"");
            jLVendedor.setText(contrato.getEmpleado().getDni()+"");
            jLInquilino.setText(contrato.getInquilino().toString());
            jLCodigoPropiedad.setText(contrato.getInmueble().getCodigoInmueble());
            if(contrato.isActivo()){
                jLEstado.setText("Activo");
            }else{
                jLEstado.setText("Inactivo");
            }
    }
    
    private void inhabilitar(){
        jDcInicio.setEnabled(false);
        jDcFinalizacion.setEnabled(false);
        jBtnRenovar.setEnabled(false);
        jBtncancelar.setEnabled(false);
        jBtnBorrar.setEnabled(false);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTContratos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jCbInmuebles = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jCbInquilinos = new javax.swing.JComboBox<>();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jCbEmpleados = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTxtIdInmueble = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jDcFinalizacion = new com.toedter.calendar.JDateChooser();
        jDcInicio = new com.toedter.calendar.JDateChooser();
        jButton7 = new javax.swing.JButton();
        jLVendedor = new javax.swing.JLabel();
        jLInquilino = new javax.swing.JLabel();
        jLCodigoPropiedad = new javax.swing.JLabel();
        jLEstado = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jBtncancelar = new javax.swing.JButton();
        jBtnBorrar = new javax.swing.JButton();
        jDcFirma = new javax.swing.JLabel();
        jBtnRenovar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(153, 153, 153));
        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gestion de Contratos");
        jLabel1.setOpaque(true);

        jTContratos.setBackground(new java.awt.Color(204, 204, 204));
        jTContratos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTContratos.setForeground(new java.awt.Color(0, 0, 0));
        jTContratos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTContratos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTContratosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTContratos);

        jButton1.setBackground(new java.awt.Color(153, 204, 255));
        jButton1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton1.setText("Buscar Contratos Por Inquilino");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(153, 204, 255));
        jButton2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton2.setText("Buscar Contratos Por Propiedad");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(153, 204, 255));
        jButton3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton3.setText("Buscar Contrato Por Codigo");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setText("Seleccionar Codigo de Propiedad");

        jCbInmuebles.setBackground(new java.awt.Color(204, 204, 204));
        jCbInmuebles.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jCbInmuebles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCbInmueblesActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setText("Seleccionar Inquilino");

        jCbInquilinos.setBackground(new java.awt.Color(204, 204, 204));
        jCbInquilinos.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jCbInquilinos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCbInquilinosActionPerformed(evt);
            }
        });

        jSeparator2.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator2.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setText("Seleccionar Vendedor");

        jCbEmpleados.setBackground(new java.awt.Color(204, 204, 204));
        jCbEmpleados.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jCbEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCbEmpleadosActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(153, 204, 255));
        jButton4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton4.setText("Buscar Contratos Por Vendedor");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 102, 102));
        jButton5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton5.setText("Buscar Contratos Vencidos");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(204, 204, 204));
        jButton6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton6.setText("Salir");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setText("Codigo Del Contrato");

        jTxtIdInmueble.setBackground(new java.awt.Color(204, 204, 204));
        jTxtIdInmueble.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setText("Inicio del Contrato");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setText("Finalizacion del Contrato");

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel8.setText("Cierre del Contrato");

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel9.setText("DNI del Vendedor");

        jLabel10.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel10.setText("Inquilino");

        jLabel11.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel11.setText("Codigo del Inmueble");

        jLabel12.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel12.setText("Estado del contrato");

        jDcFinalizacion.setBackground(new java.awt.Color(204, 204, 204));

        jDcInicio.setBackground(new java.awt.Color(204, 204, 204));

        jButton7.setBackground(new java.awt.Color(204, 204, 204));
        jButton7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton7.setText("Renovar Contrato");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLVendedor.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLVendedor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLInquilino.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        jLCodigoPropiedad.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLCodigoPropiedad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLEstado.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLEstado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jButton8.setBackground(new java.awt.Color(204, 204, 204));
        jButton8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton8.setText("Modificar contrato");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jBtncancelar.setBackground(new java.awt.Color(204, 204, 204));
        jBtncancelar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jBtncancelar.setText("Cancelar Contrato");
        jBtncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtncancelarActionPerformed(evt);
            }
        });

        jBtnBorrar.setBackground(new java.awt.Color(204, 204, 204));
        jBtnBorrar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jBtnBorrar.setText("Borrar Contrato");
        jBtnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnBorrarActionPerformed(evt);
            }
        });

        jDcFirma.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        jBtnRenovar.setBackground(new java.awt.Color(204, 204, 204));
        jBtnRenovar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jBtnRenovar.setText("Confirmar Renovacion");
        jBtnRenovar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRenovarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(79, 79, 79)
                            .addComponent(jButton6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(57, 57, 57))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(39, 39, 39)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(136, 136, 136)
                                    .addComponent(jCbInquilinos, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(33, 33, 33)
                                    .addComponent(jCbInmuebles, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(116, 116, 116)
                                    .addComponent(jCbEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(181, 181, 181)
                            .addComponent(jButton1))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(178, 178, 178)
                            .addComponent(jButton2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(jButton4)))
                .addGap(12, 12, 12)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLCodigoPropiedad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jBtncancelar))
                        .addGap(102, 102, 102)
                        .addComponent(jButton8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jBtnBorrar))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(160, 160, 160)
                                                .addComponent(jLVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(160, 160, 160)
                                                .addComponent(jLInquilino, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(67, 67, 67)
                                                .addComponent(jTxtIdInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton3))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jDcInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(29, 29, 29)
                                        .addComponent(jBtnRenovar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                                        .addComponent(jDcFinalizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addGap(65, 65, 65)
                                                .addComponent(jButton7))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(112, 112, 112)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(11, 11, 11)
                                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addComponent(jLabel9)
                                                            .addComponent(jLabel8))
                                                        .addGap(111, 111, 111)
                                                        .addComponent(jDcFirma, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(310, 310, 310)
                                .addComponent(jLabel7)))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jSeparator2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jCbInquilinos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1)
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jCbInmuebles, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2)
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jCbEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4)
                                .addGap(54, 54, 54)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton6)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(jTxtIdInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton3))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)
                                    .addComponent(jButton7))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jDcFinalizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jDcInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jBtnRenovar))
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(jDcFirma, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLInquilino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel12))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLCodigoPropiedad, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jButton8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jBtncancelar)
                                    .addComponent(jBtnBorrar))))
                        .addContainerGap(22, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try{
            Contrato contrato=cd.buscarContratoXId(Integer.parseInt(jTxtIdInmueble.getText()));
            //cargarContrato(contrato);
            mostrarContrato2();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Debe cargar el campo del codigo con uno valido");
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        inhabilitar();
        jDcInicio.setEnabled(true);
        jDcFinalizacion.setEnabled(true);
        jBtnRenovar.setEnabled(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        cargarXInquilino();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        cargarXPropiedad();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jCbInquilinosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCbInquilinosActionPerformed
        // TODO add your handling code here:
        borrarFilas();
    }//GEN-LAST:event_jCbInquilinosActionPerformed

    private void jCbInmueblesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCbInmueblesActionPerformed
        // TODO add your handling code here:
        borrarFilas();
    }//GEN-LAST:event_jCbInmueblesActionPerformed

    private void jCbEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCbEmpleadosActionPerformed
        // TODO add your handling code here:
        borrarFilas();
    }//GEN-LAST:event_jCbEmpleadosActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        cargarXVendedor();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        vencidos();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTContratosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTContratosMouseClicked
        // TODO add your handling code here:
        mostratContrato();
    }//GEN-LAST:event_jTContratosMouseClicked

    private void jBtnRenovarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRenovarActionPerformed
        // TODO add your handling code here:
        try{
            SimpleDateFormat formatoFecha1 = new SimpleDateFormat("dd-MM-yyyy");
        String fecha = formatoFecha1.format(jDcFinalizacion.getDate());
        LocalDate fechFinal = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        SimpleDateFormat formatoFecha2 = new SimpleDateFormat("dd-MM-yyyy");
        String fecha2 = formatoFecha2.format(jDcInicio.getDate());
        LocalDate fechInicio = LocalDate.parse(fecha2, DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        cd.renovarContrato(Integer.parseInt(jTxtIdInmueble.getText()) , fechInicio, fechFinal);
        inhabilitar();
        mostrarContrato2();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this,"Error, debe cargar un contrato");
        }
        
    }//GEN-LAST:event_jBtnRenovarActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        inhabilitar();
        jBtncancelar.setEnabled(true);
        jBtnBorrar.setEnabled(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jBtncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtncancelarActionPerformed
        // TODO add your handling code here:
        try{
        cd.cancelarContrato(Integer.parseInt(jTxtIdInmueble.getText()));
        inhabilitar();
        mostrarContrato2();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this,"Error, debe cargar un contrato");
        }
    }//GEN-LAST:event_jBtncancelarActionPerformed

    private void jBtnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnBorrarActionPerformed
        // TODO add your handling code here:
        try{
        cd.borrarContrato(Integer.parseInt(jTxtIdInmueble.getText()));
        inhabilitar();
        //mostrarContrato2();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this,"Error, debe cargar un contrato");
        }
    }//GEN-LAST:event_jBtnBorrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnBorrar;
    private javax.swing.JButton jBtnRenovar;
    private javax.swing.JButton jBtncancelar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox<Empleado> jCbEmpleados;
    private javax.swing.JComboBox<Inmueble> jCbInmuebles;
    private javax.swing.JComboBox<Inquilino> jCbInquilinos;
    private com.toedter.calendar.JDateChooser jDcFinalizacion;
    private javax.swing.JLabel jDcFirma;
    private com.toedter.calendar.JDateChooser jDcInicio;
    private javax.swing.JLabel jLCodigoPropiedad;
    private javax.swing.JLabel jLEstado;
    private javax.swing.JLabel jLInquilino;
    private javax.swing.JLabel jLVendedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTContratos;
    private javax.swing.JTextField jTxtIdInmueble;
    // End of variables declaration//GEN-END:variables
}
