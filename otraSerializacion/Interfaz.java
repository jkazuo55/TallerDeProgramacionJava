package Inicio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.table.*;

public class Interfaz extends javax.swing.JFrame {

    DefaultTableModel miModelo;  //juagar con la tabla
    Empleados open;
    ArrayEmpleados a;
    String[] cabecera={"CODIGO","NOMBRE","HORAS","PAGO","PAGO.HORA","PUESTO","MODALIDAD","PLANILLA","BONIFICACION","DESCUENTO","SUELDO"};
    String[][] data={};
    int cont=0;
    
    public Interfaz() {
        initComponents();
        miModelo = new DefaultTableModel(data,cabecera);
        jtable.setModel(miModelo);
        
        a = new ArrayEmpleados();
        
        System.out.println(a);
        
        cargaDatos();
        actualizar();

        System.out.println(a);
    }
    
    public void escribir(String texto){
        JOptionPane.showMessageDialog(this, texto);
    }
    
    //metodo que lee del archivo binario
    public void cargaDatos(){
        System.out.println(a);
        try{
            FileInputStream fis = new FileInputStream("Inicio/Empleados.bin"); //creamos un archivo.bin
            ObjectInputStream in = new ObjectInputStream(fis);
            if(in != null){
                a = (ArrayEmpleados) in.readObject();//leemos el objeto todo lo que se encuentre en archivo bin
                in.close();   
                System.out.println(a);                   //cerramos
            }
        }catch(Exception ex){
            escribir(ex.getMessage());
        }   
    }
    
    //escribir un archivo binario
    public void grabar(){
        try{
            FileOutputStream fos = new FileOutputStream("Inicio/Empleados.bin");
            ObjectOutputStream out = new ObjectOutputStream(fos);
            if(out != null){
                out.writeObject(a); 
                out.close();
            }
        }catch(Exception ex){
            escribir(ex.getMessage());
        }
    }
    
    public void vaciar_tabla(){
        int n = jtable.getRowCount();
        for(int p=0;p<n;p++){
            miModelo.removeRow(0);
        }
    }

    public void actualizar(){
        vaciar_tabla();
        int n = a.getNumero();
        for(int p=0; p<n; p++){
            open = a.getEmpleado(p);
            String cod = open.getCodigo();
            String nomb = open.getNombre();
            int ht = open.getHoras();
            double pa = open.getPago();
            double ph = open.getPago_hora();
            String pu = open.getPuesto();
            String mo = open.getModalidad();
            String pla = open.getPlanilla();
            double bo = open.getBonificacion();
            double des = open.getDescuento();
            double mont = open.getMonto();
            insertar(cod,nomb,ht,pa,ph,pu,mo,pla,bo,des,mont);
        }
    }
    
    public void insertar(String cod,String nomb,int ht,double pa,double ph,String pu,String mo,String pla,double bo,double des,double mont){
        DecimalFormat d = new DecimalFormat("####.00"); //limita a 4 caracter y 2 decimales
        String pago = d.format(ph);
        String boni = d.format(bo);
        String desc = d.format(des);
        String monto = d.format(mont);
        Object[] fila={cod, nomb, ht, pa, pago, pu, mo, pla, boni, desc, monto};
        miModelo.addRow(fila);
    }
    
    public void m_borrar(){
        String op = JOptionPane.showInputDialog("Codigo a borrar : ");
        int p = a.buscar(op);
        if(p == -1){
            escribir("Codigo no existe");
        }else{
            int i = JOptionPane.showConfirmDialog(null,"Estas seguro de borrar...");
            if(i==0){
                a.Eliminar(p);
                grabar();
                actualizar();
            }else if(i==1){
                escribir("Vuela a intentarlo");
            }
        }
    }
    
    public void m_consultar(){
        String co = JOptionPane.showInputDialog("Buscar por el codigo....");
        int p = a.buscar(co);
        int n = a.getNumero();
        if(p == -1){
            escribir("Codigo no existe");
        }else{
            for(int i=0; i<n; i++){ //lee todo el arraylist
                open = a.getEmpleado(p);
                String cod = open.getCodigo();
                String nomb = open.getNombre();
                int ht = open.getHoras();
                double pa = open.getPago();
                double ph = open.getPago_hora();
                String pu = open.getPuesto();
                String mo = open.getModalidad();
                String pla = open.getPlanilla();
                double bo = open.getBonificacion();
                double des = open.getDescuento();
                double mont = open.getMonto();
                JTFCodigo.setText(cod);
                JTFNombre.setText(nomb);
                JTFHoras.setText(String.valueOf(ht));
                JTFPago.setText(String.valueOf(pa));
                if(pu.equalsIgnoreCase("Capataz")){
                    JCBPuesto.setSelectedIndex(1);
                }else if(pu.equalsIgnoreCase("Maestro")){
                    JCBPuesto.setSelectedIndex(2);
                }else if(pu.equalsIgnoreCase("Operario")){
                    JCBPuesto.setSelectedIndex(3);
                }
                if(mo.equalsIgnoreCase("Estable")){
                    JCBModalidad.setSelectedIndex(1);
                }else if(mo.equalsIgnoreCase("Contratado")){
                    JCBModalidad.setSelectedIndex(2);
                }
                if(pla.equalsIgnoreCase("AFP")){
                    JCBPlanilla.setSelectedIndex(1);
                }else if(pla.equalsIgnoreCase("SEGURO")){
                    JCBPlanilla.setSelectedIndex(2);
                }else if(pla.equalsIgnoreCase("FONAVI")){
                    JCBPlanilla.setSelectedIndex(3);
                }
            }
        }
    }
    
    public  void m_modificar(){
        int op = JOptionPane.showConfirmDialog(null,"Deves consultar primero \nDeseas consultar ahora presiona <Si>\nSi ya consultastes presionsa <No>");//confirmacion
        if(op==0){
            m_consultar();
        }else if(op==1){ //si a puesto opcion no modificar el objeto en el cual nosotros ayamos modificado
            int n = a.getNumero();
            for(int p=0;p<n;p++){
                String co = JTFCodigo.getText();
                String nomb = JTFNombre.getText();
                int ht = Integer.parseInt(JTFHoras.getText());
                String pu = JCBPuesto.getSelectedItem().toString();
                double pa = Double.parseDouble(JTFPago.getText());
                double ph = open.pago_hora(pu,ht);
                String mo = JCBModalidad.getSelectedItem().toString();
                double bo = open.bonificacion(ph,mo);
                double pi = open.p_incial(ph,bo);
                String pla = JCBPlanilla.getSelectedItem().toString();
                double des = open.Descuento(pla,pa);
                double monto = open.Monto(ph,des);
                open = new Empleados(co,nomb,ht,pa,ph,pu,mo,pla,bo,des,monto);
                int  i = a.buscar(co);
                if(i == -1){
                    a.Agregar(open);
                }else{
                    a.Actualizar(i, open);
                    grabar();
                    actualizar();
                    limpiar();
                }
            }
        }
    }
    
    //limpia las cajas de texto que esta dentro del frame
    public void limpiar(){
        JTFCodigo.setText("");
        JTFHoras.setText("");
        JTFNombre.setText("");
        JTFPago.setText("");
        JCBPuesto.setSelectedIndex(0);
        JCBPlanilla.setSelectedIndex(0);
        JCBModalidad.setSelectedIndex(0);
        JTFCodigo.requestFocus();
    }
    

    public void m_guardar(){
        int ne = Integer.parseInt(JTFEmpleados.getText());
        if(cont < ne){
            cont++;
            Empleados em = new Empleados();
            String co = JTFCodigo.getText();
            String nomb = JTFNombre.getText();
            int ht = Integer.parseInt(JTFHoras.getText());
            String pu = JCBPuesto.getSelectedItem().toString();
            double pa = Double.parseDouble(JTFPago.getText());
            double ph = em.pago_hora(pu,ht);
            String mo = JCBModalidad.getSelectedItem().toString();
            double bo = em.bonificacion(ph,mo);
            double pi = em.p_incial(ph,bo);
            String pla = JCBPlanilla.getSelectedItem().toString();
            double des = em.Descuento(pla,pa);
            double monto = em.Monto(ph ,des);
            open = new Empleados(co,nomb,ht,pa,ph,pu,mo,pla,bo,des,monto);
            //condicion del arreglo buscar el objeto con el codiog que se acaba de colocar
            
            System.out.println(a);

            if(a.buscar(open.getCodigo()) != -1){
                escribir("El codigo del empleado ya existe");
                System.out.println(a);
            }else{
                a.Agregar(open);
                insertar(co,nomb,ht,pa,ph,pu,mo,pla,bo,des,monto);
                System.out.println(a);
                grabar();
                actualizar();
                limpiar();
                System.out.println(a);
            }
        }else{
            escribir("N° empleados ya registrados");
        }
    }
    
    private void initComponents() {

        jbConsultar = new javax.swing.JButton();
        jbModificar = new javax.swing.JButton();
        jbBorrar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        JCBPuesto = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        JCBModalidad = new javax.swing.JComboBox();
        JTFNombre = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        JTFHoras = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JTFEmpleados = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        JCBPlanilla = new javax.swing.JComboBox();
        JTFPago = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jbGuardar = new javax.swing.JButton();
        JTFCodigo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        JCBBuscar = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTABoleta = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jbConsultar.setText("Consultar");
        jbConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConsultarActionPerformed(evt);
            }
        });

        jbModificar.setText("Modificar");
        jbModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarActionPerformed(evt);
            }
        });

        jbBorrar.setText("Borrar");
        jbBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBorrarActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Puesto del empleado");

        JCBPuesto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "----------", "Capataz", "Maestro", "Operario" }));
        JCBPuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCBPuestoActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Modalidad");

        JCBModalidad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-------------", "Estable", "Contratado" }));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Descuento por planilla");

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel1.setText("EMPRESA BOXER S.A. ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("N° empleados");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Nombre del empleado:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Horas trabajadas");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Pago por hora");

        JCBPlanilla.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "----------", "AFP", "SEGURO", "FONAVI" }));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Codigo del empleado");

        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtable);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Resumen");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("buscar por :");

        JCBBuscar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "----------", "Capataz", "Maestro", "Operario" }));
        JCBBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCBBuscarActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Determinar el monto total que la empresa gastara");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("en pagar a sus empleados y cuanto pagara según el Puesto.");

        JTABoleta.setColumns(20);
        JTABoleta.setRows(5);
        jScrollPane2.setViewportView(JTABoleta);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(JCBBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11)))
                .addGap(0, 56, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(JCBBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 810, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JTFEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel14)
                                    .addGap(60, 60, 60)
                                    .addComponent(JTFCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(49, 49, 49)
                                .addComponent(JTFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(107, 107, 107)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbConsultar, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(84, 84, 84)
                                .addComponent(JTFHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel5))
                                .addGap(61, 61, 61)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JTFPago, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JCBPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13))
                                .addGap(54, 54, 54)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JCBPlanilla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JCBModalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(JTFEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JTFCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JTFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(JTFHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JCBPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JTFPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(JCBModalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(JCBPlanilla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1)
                    .addContainerGap(533, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JCBPuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCBPuestoActionPerformed
        int pu = JCBPuesto.getSelectedIndex();
        switch(pu){
            case 1 : JTFPago.setText("55.00");break;
            case 2 : JTFPago.setText("42.00");break;
            case 3 : JTFPago.setText("25.00");break;
        }
    }//GEN-LAST:event_JCBPuestoActionPerformed

    private void jbBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBorrarActionPerformed
        this.m_borrar();
    }//GEN-LAST:event_jbBorrarActionPerformed

    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        this.m_modificar();
    }//GEN-LAST:event_jbModificarActionPerformed

    private void jbConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConsultarActionPerformed
        this.m_consultar();
    }//GEN-LAST:event_jbConsultarActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        this.m_guardar();
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void JCBBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCBBuscarActionPerformed
        this.m_resumen();
    }//GEN-LAST:event_JCBBuscarActionPerformed

    //lee el arraylist de la posicion de cada uno rescata los datos y hace sus respectivo
    public void m_resumen(){
        double sum=0,s1=0,s2=0,s3=0;
        int n = a.getNumero();
        for(int p=0;p<n;p++){
            open = a.getEmpleado(p);
            String cod = open.getCodigo();
            String nomb = open.getNombre();
            int ht = open.getHoras();
            double pa = open.getPago();
            double ph = open.getPago_hora();
            String pu = open.getPuesto();
            String mo = open.getModalidad();
            String pla = open.getPlanilla();
            double bo = open.getBonificacion();
            double des = open.getDescuento();
            double mont = open.getMonto();
            sum = sum + mont;
            if(pu.equalsIgnoreCase("Capataz")){
                s1=s1+mont;
            }else if(pu.equalsIgnoreCase("Maestro")){
                s2=s2+mont;
            }else if(pu.equalsIgnoreCase("Operario")){
                s3=s3+mont;
            }
        }
        DecimalFormat d = new DecimalFormat("####.00");
        String s = d.format(sum);
        String ss1 = d.format(s1);
        String ss2 = d.format(s2);
        String ss3 = d.format(s3);
        int op = JCBBuscar.getSelectedIndex();
        switch(op){
            case 1 : JTABoleta.setText("");
                     JTABoleta.append("\n\nMonto total es: "+s);
                     JTABoleta.append("\nMonto a pagar por Capataz : "+ss1);
                break;
            case 2 : JTABoleta.setText("");
                     JTABoleta.append("\n\nMonto total es: "+s);
                     JTABoleta.append("\nMonto a pagar por Capataz : "+ss2);
                break;
            case 3 : JTABoleta.setText("");
                     JTABoleta.append("\n\nMonto total es: "+s);
                     JTABoleta.append("\nMonto a pagar por Capataz : "+ss3);
                break;
        }
    }
    

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox JCBBuscar;
    private javax.swing.JComboBox JCBModalidad;
    private javax.swing.JComboBox JCBPlanilla;
    private javax.swing.JComboBox JCBPuesto;
    private javax.swing.JTextArea JTABoleta;
    private javax.swing.JTextField JTFCodigo;
    private javax.swing.JTextField JTFEmpleados;
    private javax.swing.JTextField JTFHoras;
    private javax.swing.JTextField JTFNombre;
    private javax.swing.JTextField JTFPago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbBorrar;
    private javax.swing.JButton jbConsultar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbModificar;
    private javax.swing.JTable jtable;
    // End of variables declaration//GEN-END:variables
}
