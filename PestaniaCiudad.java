//package vista;

// import modelo.PersonaEmigrante;
// import modelo.listaCDE.Lista;
// import controlador.ControlPrincipal;
// import modelo.serializacion.SerializableGenerico;
// import modelo.serializacion.DeserializableGenerico;


import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.*;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollPane;


public class PestaniaCiudad{

    public JPanel panelGeneral;

    private JPanel panelIzquierda;
    private JPanel panelDerecha;

    private JPanel panelDerCabecera;
    private JPanel panelDerCuerpo;
    private JPanel panelDerPie;

    private JPanel panelDerPieTitulo;
    private JPanel panelDerPieCuerpo;

    private JTable   tablaEmigrante;
    private DefaultTableModel model;
    private JScrollPane scrollpane;

    private JLabel   labelTituloIzq;
    private JComboBox comboBoxCiudad;
    private JComboBox comboBoxReporte;
    private JButton  botonAceptar;

    private JLabel   labelTituloDerecha;

    private JLabel   labelTituloPie;
    private JLabel   labelSalientes;
    private JLabel   labelEntrantes;
    private JLabel   labelTotal;

    private JLabel   resLabelSalientes;
    private JLabel   resLabelEntrantes;
    private JLabel   resLabelTotal;

    public PestaniaCiudad(){ 
        inicializarRegistroEmigrante();
        System.out.println("Inicializa el programa");    
    }   
        
    private void inicializarRegistroEmigrante(){

        panelGeneral = new JPanel();
        
        panelDerCabecera = new JPanel();
        panelDerCuerpo =   new JPanel();
        panelDerPie =      new JPanel();

        panelIzquierda = new JPanel();
        panelDerecha = new JPanel();

        panelDerPieTitulo = new JPanel();
        panelDerPieCuerpo = new JPanel();

        labelTituloIzq = new JLabel();
        labelTituloDerecha = new JLabel();

        labelTituloPie = new JLabel();
        labelSalientes = new JLabel();
        labelEntrantes = new JLabel();
        labelTotal = new JLabel();

        resLabelSalientes = new JLabel();
        resLabelEntrantes = new JLabel();
        resLabelTotal = new JLabel();
        
        
        comboBoxCiudad = new JComboBox();
        comboBoxReporte = new JComboBox();
        botonAceptar = new JButton();

        tablaEmigrante = new JTable();
        model = new DefaultTableModel();
        scrollpane = new JScrollPane();


        labelTituloIzq.setText(" SELECCIONE UNA CIUDAD ");

        comboBoxCiudad.addItem("cochabamba");
        comboBoxCiudad.addItem("la paz");
        comboBoxCiudad.addItem("tarija");
        comboBoxCiudad.addItem("chuquisaca");
        comboBoxCiudad.addItem("beni");
        comboBoxCiudad.addItem("oruro");
        comboBoxCiudad.addItem("santa cruz");
        comboBoxCiudad.addItem("pando");
        comboBoxCiudad.addItem("potosi");

        comboBoxReporte.addItem("Emigrantes-Salientes");
        comboBoxReporte.addItem("Emigrantes-Entrantes");
        comboBoxReporte.addItem("Salientes-Entrantes");
        
        botonAceptar.setText("Aceptar");

        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });

        panelIzquierda.setLayout(new BoxLayout(panelIzquierda,BoxLayout.Y_AXIS));
        panelIzquierda.add(labelTituloIzq);
        panelIzquierda.add(comboBoxCiudad);
        panelIzquierda.add(comboBoxReporte);
        panelIzquierda.add(botonAceptar);

        panelIzquierda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 50, 60)));
        panelDerCabecera.setLayout(new FlowLayout());
        panelDerCabecera.add(labelTituloDerecha); 
        
        tablaEmigrante.setModel(model);
        model.addColumn("cedula");
        model.addColumn("nombre");
        model.addColumn("apellidos");
        model.addColumn("cedula");
        model.addColumn("sexo");
        model.addColumn("nacidoEn");
        model.addColumn("direccion");
        model.addColumn("telefono");
        tablaEmigrante.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tablaEmigrante.getTableHeader().setReorderingAllowed(false);
        scrollpane.setViewportView(tablaEmigrante);
        panelDerCuerpo.setLayout(new FlowLayout());
        panelDerCuerpo.add(scrollpane);       
        
        labelTituloPie.setText("Resumen Flujo de Emigrantes");
        panelDerPieTitulo.setLayout(new FlowLayout());
        panelDerPieTitulo.add(labelTituloPie);

        labelEntrantes.setText("Emigrantes-Entrantes");
        labelSalientes.setText("Emigrantes-Salientes");
        labelTotal.setText("Total-Emigrantes");
        resLabelEntrantes.setText("----");
        resLabelSalientes.setText("----");
        resLabelTotal.setText("----");
        panelDerPieCuerpo.setLayout(new GridLayout(3,2));
        panelDerPieCuerpo.add(labelEntrantes);        
        panelDerPieCuerpo.add(resLabelEntrantes);        
        panelDerPieCuerpo.add(labelSalientes);        
        panelDerPieCuerpo.add(resLabelSalientes);        
        panelDerPieCuerpo.add(labelTotal);        
        panelDerPieCuerpo.add(resLabelTotal);
        panelDerPie.setLayout(new BoxLayout(panelDerPie,BoxLayout.Y_AXIS));
        panelDerPie.add(panelDerPieTitulo);
        panelDerPie.add(panelDerPieCuerpo);
        panelDerPie.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 50, 60)));

        panelDerecha.setLayout(new BoxLayout(panelDerecha,BoxLayout.Y_AXIS));
        panelDerecha.add(panelDerCabecera);
        panelDerecha.add(panelDerCuerpo);
        panelDerecha.add(panelDerPie);

        panelGeneral.setLayout(new BoxLayout(panelGeneral,BoxLayout.X_AXIS));
        panelGeneral.add(panelIzquierda);
        panelGeneral.add(panelDerecha);

        panelGeneral.setBorder(BorderFactory.createLineBorder(new Color(10, 100, 0)));
        panelGeneral.setMaximumSize(new Dimension(1100, 600));
        panelGeneral.setMinimumSize(new Dimension(1100, 600));
        panelGeneral.setPreferredSize(new Dimension(1100, 600));

    }


    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("botonAceptar");
    }

    // public void escribir(String texto){
    //     JOptionPane.showMessageDialog(panelGeneral, texto);
    // }


    // public void setControlador(ControlPrincipal c) {
    //     btnPrueba.addActionListener(c);
    // }

    // public void guardar(){

    //     String nombre   = textNombre.getText();
    //     String apellidos= textApellidos.getText();
    //     long   cedula   = Long.parseLong(textCedula.getText());
    //     String sexo     = comboBoxSexo.getSelectedItem().toString();
    //     String nacidoEn = textNacidoEn.getText();
    //     String direccion= textDireccion.getText();
    //     String telefono = textTelefono.getText();
    //     String correo   = textCorreo.getText();

    //     String emigrante= textEmigranteSiNo.getText();
    //     String fecha    = textFecha.getText();
    //     String origen   = comboBoxOrigen.getSelectedItem().toString();
    //     String destino  = comboBoxDestino.getSelectedItem().toString();
    //     String motivo   = comboBoxMotivoDeMigracion.getSelectedItem().toString();

    //     perEmigrante = new PersonaEmigrante(nombre,apellidos,cedula,sexo,nacidoEn,direccion,telefono,correo,emigrante,fecha,origen,destino,motivo);
    //     //condicion del arreglo buscar el objeto con el codiog que se acaba de colocar

    //     if(buscarPersonaEmigrante(cedula)){
    //         escribir("Hay otra persona registrada con el numero de cedula Cambie la Cedula de Identidad");
    //     }else{
    //         System.out.println("LA PERSONA A REGISTRARSE ES: ");

    //         listaPersonaEmigrante.insertarAlFinal(perEmigrante);
    //         System.out.println(perEmigrante.toString());
            
    //         System.out.println("EMIGRANTE AGREGADO ALA LISTA");
    //         // obj.grabar();
            

    //         // System.out.println("grabado en el archivo  binario");
    //         // actualizar();
    //        limpiar();
    //     }
    //     System.out.println("llamando al tamanioLista : "+listaPersonaEmigrante.getTamanio());
    // }

    // public void consultar(){
       
    //     long obtenidoCedula;
    //     long cedula = Long.parseLong(textFildCi.getText());

    //     System.out.println("########## El numero a buscar  : "+cedula);
        
    //     int i=0;

    //     System.out.println("tmanio de la lista : " + listaPersonaEmigrante.getTamanio());

    //     // while(i<=listaPersonaEmigrante.getTamanio()){
    //     if (buscarPersonaEmigrante(cedula)) {

    //         for(PersonaEmigrante objEmigrante:listaPersonaEmigrante){
    //                 // System.out.println(i);
    //                 // PersonaEmigrante objEmigrante = listaPersonaEmigrante.get(i);

    //                 System.out.println("entroo al for De busqueda");
             
    //                 // obtenidoCedula = objEmigrante.getCedula();
    //                 obtenidoCedula = objEmigrante.getCedula();

    //                 if (obtenidoCedula == cedula) {

    //                     System.out.println("persona encontrada"+objEmigrante.toString());

    //                     String nombre   = objEmigrante.getNombre();
    //                     String apellidos= objEmigrante.getApellidos();
    //                     String carnet   = String.valueOf(objEmigrante.getCedula());
    //                     String sexo     = objEmigrante.getSexo();
    //                     String nacidoEn = objEmigrante.getNacidoEn();
    //                     String direccion= objEmigrante.getDireccion();
    //                     String telefono = objEmigrante.getTelefono();
    //                     String correo   = objEmigrante.getCorreo();

    //                     String esEmigrante= objEmigrante.getEmigranteSiNo();
    //                     String fecha    = objEmigrante.getFecha();
    //                     String origen   = objEmigrante.getOrigen();
    //                     String destino  = objEmigrante.getDestino();
    //                     String motivo   = objEmigrante.getMotivoDeMigracion();

    //                     textNombre.setText(nombre);
    //                     textApellidos.setText(apellidos);
    //                     textCedula.setText(carnet);
    //                     textNacidoEn.setText(nacidoEn);
    //                     textDireccion.setText(direccion);
    //                     textTelefono.setText(telefono);
    //                     textCorreo.setText(correo);
                        
    //                     textEmigranteSiNo.setText(esEmigrante);        
    //                     textFecha.setText(fecha);        

    //                     if(sexo.equalsIgnoreCase("masculino")){
    //                         comboBoxSexo.setSelectedIndex(1);
    //                     }else if(sexo.equalsIgnoreCase("femenino")){
    //                         comboBoxSexo.setSelectedIndex(2);
    //                     }                    
    //                     if(origen.equalsIgnoreCase("cochabamba")){
    //                         comboBoxOrigen.setSelectedIndex(1);
    //                     }else if(origen.equalsIgnoreCase("tarija")){
    //                         comboBoxOrigen.setSelectedIndex(2);
    //                     }
    //                     if(destino.equalsIgnoreCase("cochabamba")){
    //                         comboBoxDestino.setSelectedIndex(1);
    //                     }else if(destino.equalsIgnoreCase("tarija")){
    //                         comboBoxDestino.setSelectedIndex(2);
    //                     }else if(destino.equalsIgnoreCase("pando")){
    //                         comboBoxDestino.setSelectedIndex(3);
    //                     }
    //                     if(motivo.equalsIgnoreCase("Economico")){
    //                         comboBoxMotivoDeMigracion.setSelectedIndex(1);
    //                     }else if(motivo.equalsIgnoreCase("Trabajo")){
    //                         comboBoxMotivoDeMigracion.setSelectedIndex(2);
    //                     }else if(motivo.equalsIgnoreCase("Estudios")){
    //                         comboBoxMotivoDeMigracion.setSelectedIndex(3);
    //                     }else{
    //                          System.out.println("se mostro");
    //                     }
    //                 } 
    //                 // else{
    //                 //     escribir("cedula no encontrada");
    //                 // }
    //         }
            
    //     }else{
    //         escribir("cedula no encontrada");
    //     }
    // }

    // public void limpiar(){
    //     textNombre.setText("");
    //     textApellidos.setText("");
    //     textCedula.setText("");
    //     comboBoxSexo.setSelectedIndex(0);
    //     textNacidoEn.setText("");
    //     textDireccion.setText("");
    //     textTelefono.setText("");
    //     textCorreo.setText("");
        
    //     textEmigranteSiNo.setText("");        
    //     textFecha.setText("");        
    //     comboBoxOrigen.setSelectedIndex(0);        
    //     comboBoxDestino.setSelectedIndex(0);        
    //     comboBoxMotivoDeMigracion.setSelectedIndex(0);        
    // }

    // public boolean buscarPersonaEmigrante(long cedula){

    //     boolean encontrado =false;
    //     int i=0;
    //     while(encontrado == false && i<listaPersonaEmigrante.getTamanio()){
    //         if (listaPersonaEmigrante.get(i).getCedula() == cedula) {
    //             encontrado=true;
    //         }else{
    //             i++;
    //         }
    //     }
    //     return encontrado;    
    // }

}