import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.Box;
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
import java.awt.Component;
import javax.swing.JScrollPane;
import javax.swing.table.*;
import javax.swing.JScrollPane;

public class PestaniaMapa{
    public  JPanel panelGeneral;
    private JPanel panelIzquierda;
    private JPanel panelDerecha;

    private JPanel panelDerSup;
    private JPanel panelDerInf;

    private JPanel panelDerInfIsq;
    private JPanel panelDerInfDer;

    private JPanel panelRelacion;
    private JPanel panelPesoDistancias;
    private JPanel panelPesoFujoEmigrantes;

    private JLabel labelTituloIzq;
    private JLabel labelTituloDerSup;
    private JLabel labelTituloDerInfDer;
    private JLabel labelTituloDerInfIzq;

    VistaGrafo matrizRelacion;
    VistaGrafo matrizDistancias;
    VistaGrafo matrizFlujoEmi;

    private Controlador control;

    // Lista<Emigrante> listaPersonaEmigrante;   //lista    

    // String fileName = "/home/xenial/proyectos/java/TallerDeProgramacionJava/dataEmigrantes.ser"; 

    // DeserializableGenerico<Lista> deser_gen;  


    public PestaniaMapa(){ 
        inicializarRegistroEmigrante();
        // model= new DefaultTableModel(data,cabecera);
        // tablaEmigrante.setModel(model);
    }        
    private void inicializarRegistroEmigrante(){

        // listaPersonaEmigrante = new Lista<Emigrante>(); 
        // deser_gen = new DeserializableGenerico<Lista>(fileName);        
        panelGeneral = new JPanel();

        matrizRelacion = new VistaGrafo();
        matrizDistancias = new VistaGrafo();
        matrizFlujoEmi = new VistaGrafo();

        panelIzquierda = new JPanel();
        panelDerecha = new JPanel();
        
        panelDerSup = new JPanel();
        panelDerInf =   new JPanel();
        // panelDerPie =      new JPanel();

        panelDerInfIsq = new JPanel();
        panelDerInfDer = new JPanel();

        labelTituloIzq = new JLabel();
        labelTituloDerSup = new JLabel();
        labelTituloDerInfDer = new JLabel();
        labelTituloDerInfIzq = new JLabel();

        labelTituloIzq.setText("REPRESENTACION GRAFICA DEL GRAFO");
        labelTituloDerSup.setText("MATRIZ DE ADYACENCIA");
        labelTituloDerInfIzq.setText("MATRIZ CON PESOS DISTANCIAS");        
        labelTituloDerInfDer.setText("FLUJO DE EMIGRANTES");
        
        panelIzquierda.setLayout(new BoxLayout(panelIzquierda,BoxLayout.Y_AXIS));
        panelIzquierda.add(labelTituloIzq);

        panelIzquierda.setMaximumSize(new Dimension(500, 600));
        panelIzquierda.setMinimumSize(new Dimension(500, 600));
        panelIzquierda.setPreferredSize(new Dimension(500, 600));

        panelDerSup.setLayout(new BoxLayout(panelDerSup,BoxLayout.Y_AXIS));
        panelDerSup.add(labelTituloDerSup);
        panelDerSup.add(matrizRelacion.panelGeneral);

        panelDerInfDer.setLayout(new BoxLayout(panelDerInfDer,BoxLayout.Y_AXIS));
        panelDerInfDer.add(labelTituloDerInfDer);
        panelDerInfDer.add(matrizDistancias.panelGeneral);

        panelDerInfIsq.setLayout(new BoxLayout(panelDerInfIsq,BoxLayout.Y_AXIS));
        panelDerInfIsq.add(labelTituloDerInfIzq);
        panelDerInfIsq.add(matrizFlujoEmi.panelGeneral);

        panelDerInf.setLayout(new BoxLayout(panelDerInf,BoxLayout.X_AXIS));
        panelDerInf.add(panelDerInfDer);
        panelDerInf.add(panelDerInfIsq);

        panelDerecha.setLayout(new BoxLayout(panelDerecha,BoxLayout.Y_AXIS));
        panelDerecha.add(panelDerSup);
        panelDerecha.add(panelDerInf);

        panelGeneral.setLayout(new BoxLayout(panelGeneral,BoxLayout.X_AXIS));
        panelGeneral.add(panelIzquierda);
        panelGeneral.add(panelDerecha);


        // panelIzquierda.setLayout(new BoxLayout(panelIzquierda,BoxLayout.Y_AXIS));
        // panelIzquierda.add(labelSeleccionCiudad);
        // panelIzquierda.add(comboBoxCiudad);
        // panelIzquierda.add(Box.createVerticalStrut(60));
        // panelIzquierda.add(labelSeleccionReporte);
        // panelIzquierda.add(comboBoxReporte);
        // panelIzquierda.add(Box.createVerticalStrut(70));
        // panelIzquierda.add(botonAceptar);

        // labelSeleccionCiudad.setAlignmentX(Component.CENTER_ALIGNMENT);
        // labelSeleccionReporte.setAlignmentX(Component.CENTER_ALIGNMENT);
        // comboBoxReporte.setAlignmentX(Component.CENTER_ALIGNMENT);
        // comboBoxCiudad.setAlignmentX(Component.CENTER_ALIGNMENT);
        // botonAceptar.setAlignmentX(Component.CENTER_ALIGNMENT);

        // panelIzquierda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 250, 0))); //verde
        // panelIzquierda.setMaximumSize(new Dimension(300, 600));
        // panelIzquierda.setMinimumSize(new Dimension(300, 600));
        // panelIzquierda.setPreferredSize(new Dimension(300, 600));

        // scrollpane.setMaximumSize(new Dimension(780, 450));
        // scrollpane.setMinimumSize(new Dimension(780, 450));
        // scrollpane.setPreferredSize(new Dimension(780, 450));

        // scrollpane.setViewportView(tablaEmigrante);
        // panelDerInf.setLayout(new FlowLayout());
        // panelDerInf.add(scrollpane);

        // panelDerInf.setBorder(BorderFactory.createLineBorder(new Color(0,0 , 250)));
        // panelDerInf.setMaximumSize(new Dimension(790, 450));
        // panelDerInf.setMinimumSize(new Dimension(790, 450));
        // panelDerInf.setPreferredSize(new Dimension(790, 450));

        
        // labelTituloDerSup.setText("Resumen Flujo de Emigrantes");
        // panelDerInfIsq.setLayout(new FlowLayout());
        // panelDerInfIsq.add(labelTituloDerSup);

        // labelTituloDerInfIzq.setText("Emigrantes-Entrantes");
        // labelTituloDerInfDer.setText("Emigrantes-Salientes");
        // labelTotal.setText("Total-Emigrantes");
        // resLabelEntrantes.setText("----");
        // resLabelSalientes.setText("----");
        // resLabelTotal.setText("----");
        // panelDerInfDer.setLayout(new GridLayout(3,2));
        // panelDerInfDer.add(labelTituloDerInfIzq);        
        // panelDerInfDer.add(resLabelEntrantes);        
        // panelDerInfDer.add(labelTituloDerInfDer);        
        // panelDerInfDer.add(resLabelSalientes);        
        // panelDerInfDer.add(labelTotal);        
        // panelDerInfDer.add(resLabelTotal);
        // panelDerPie.setLayout(new BoxLayout(panelDerPie,BoxLayout.Y_AXIS));
        // panelDerPie.add(panelDerInfIsq);
        // panelDerPie.add(panelDerInfDer);
        // panelDerPie.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 50, 60)));

        // panelDerecha.setLayout(new BoxLayout(panelDerecha,BoxLayout.Y_AXIS));
        // panelDerecha.add(panelDerSup);
        // panelDerecha.add(panelDerInf);
        // panelDerecha.add(panelDerPie);

        // panelDerecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 100)));
        // panelDerecha.setMaximumSize(new Dimension(800, 600));
        // panelDerecha.setMinimumSize(new Dimension(800, 600));
        // panelDerecha.setPreferredSize(new Dimension(800, 600));

        // panelGeneral.setLayout(new BoxLayout(panelGeneral,BoxLayout.X_AXIS));
        // panelGeneral.add(panelIzquierda);
        // panelGeneral.add(panelDerecha);

        // panelGeneral.setBorder(BorderFactory.createLineBorder(new Color(250, 0, 0)));
        // panelGeneral.setMaximumSize(new Dimension(1100, 600));
        // panelGeneral.setMinimumSize(new Dimension(1100, 600));
        // panelGeneral.setPreferredSize(new Dimension(1100, 600));

    }
    public void setControlador(Controlador control) {
        this.control=control;
    }

    


    // private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {
    //     System.out.println("botonAceptar");
    //     vaciar_tabla();
    //     tipoDeReporte();
    // }

    // // public void escribir(String texto){
    // //     JOptionPane.showMessageDialog(panelGeneral, texto);
    // // }
    // public void setControlador(Controlador control) {
    //     this.control=control;
    // }

    // public void tipoDeReporte(){        
    //     String ciudad   = comboBoxCiudad.getSelectedItem().toString();
    //     String reporte  = comboBoxReporte.getSelectedItem().toString();

    //     System.out.println("tipoDeReporte=======: "+ciudad+"||"+reporte);

    //     if (reporte=="Emigrantes-Salientes") {
    //         emigrantesSalientes(ciudad);
    //         resumen(ciudad);
    //     }else if (reporte=="Emigrantes-Entrantes") {
    //         System.out.println("entro a entrantes:::::");
    //         emigrantesEntrantes(ciudad);
    //         resumen(ciudad);
    //     }else if (reporte=="General") {
    //         generalEmigrantes(ciudad);
    //         resumen(ciudad);
    //     }
    // }
    // public void emigrantesEntrantes(String ciudad){
    //     String aux;
    //     for (Emigrante obj:listaPersonaEmigrante) {
    //         aux = obj.getDestino();
    //         if (aux.equalsIgnoreCase(ciudad)) {
    //             System.out.println("entro al if ");    
    //             String nombre=obj.getNombre();
    //             String apellidos=obj.getApellidos();
    //             long cedula = obj.getCedula();
    //             String origen = obj.getOrigen();
    //             String destino = obj.getDestino();
    //             String motivo  = obj.getMotivoDeMigracion();

    //             System.out.println("las personas entrantesssssss::"+obj.toString());
                
    //             Object[] fila={nombre,apellidos,cedula,origen,destino,motivo};
    //             model.addRow(fila);
    //         }
    //     }
    // }
    // public void emigrantesSalientes(String ciudad){
    //     String aux;
    //     for (Emigrante obj:listaPersonaEmigrante) {
    //         aux=obj.getOrigen();
    //         if (aux.equalsIgnoreCase(ciudad)) {
    //             String nombre=obj.getNombre();
    //             String apellidos=obj.getApellidos();
    //             long cedula = obj.getCedula();
    //             String origen = obj.getOrigen();
    //             String destino = obj.getDestino();
    //             String motivo  = obj.getMotivoDeMigracion();
    //             Object[] fila={nombre,apellidos,cedula,origen,destino,motivo};
    //             model.addRow(fila);

    //         }
    //     }
    // }
    // public void generalEmigrantes(String ciudad){
    //     String aux1;
    //     String aux2;
    //     for (Emigrante obj:listaPersonaEmigrante) {
    //         aux1=obj.getOrigen();
    //         aux2=obj.getDestino();
    //         if (aux1.equalsIgnoreCase(ciudad)||aux2.equalsIgnoreCase(ciudad)) {
    //             String nombre=obj.getNombre();
    //             String apellidos=obj.getApellidos();
    //             long cedula = obj.getCedula();
    //             String origen = obj.getOrigen();
    //             String destino = obj.getDestino();
    //             String motivo  = obj.getMotivoDeMigracion();
    //             Object[] fila={nombre,apellidos,cedula,origen,destino,motivo};
    //             model.addRow(fila);
    //         }
    //     }       
    // }

    // public void resumen(String ciudad){
    //     String aux1;
    //     String aux2;
    //     int salientes=0,entrantes=0,total=0;
    //     for (Emigrante obj:listaPersonaEmigrante) {
    //         aux1=obj.getOrigen();
    //         aux2=obj.getDestino();

    //         if (aux1.equalsIgnoreCase(ciudad)) {
    //             salientes++;
    //         }else if (aux2.equalsIgnoreCase(ciudad)) {
    //             entrantes++;
    //         }
    //     }
    //     total = salientes+entrantes;
    //     // resLabelSalientes.setVisible(false);
    //     resLabelSalientes.setText(Integer.toString(salientes));
    //     // resLabelEntrantes.setVisible(false);
    //     resLabelEntrantes.setText(Integer.toString(entrantes));
    //     // resLabelTotal.setVisible(false);
    //     resLabelTotal.setText(Integer.toString(total));
    // }

    // public void vaciar_tabla(){
    //     int n = tablaEmigrante.getRowCount();
    //     for(int p=0;p<n;p++){
    //         model.removeRow(0);
    //     }
    // }

    // public void consultar(){
       
    //     long obtenidoCedula;
    //     long cedula = Long.parseLong(textFildCi.getText());

    //     System.out.println("########## El numero a buscar  : "+cedula);
        
    //     int i=0;

    //     System.out.println("tmanio de la lista : " + listaPersonaEmigrante.getTamanio());

    //     // while(i<=listaPersonaEmigrante.getTamanio()){
    //     if (buscarPersonaEmigrante(cedula)) {

    //         for(Emigrante objEmigrante:listaPersonaEmigrante){
    //                 // System.out.println(i);
    //                 // Emigrante objEmigrante = listaPersonaEmigrante.get(i);

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