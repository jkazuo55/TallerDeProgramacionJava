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

public class PestaniaCiudad{

    public JPanel panelGeneral;
    private JPanel panelIzquierda;
    private JPanel panelDerecha;

    private JPanel panelDerCabecera;
    private JPanel panelDerCuerpo;
    private JPanel panelDerPie;

    private JPanel panelDerPieTitulo;
    private JPanel panelDerPieCuerpo;

    private JLabel   labelSeleccionCiudad;
    private JLabel   labelSeleccionReporte;
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

    private JTable   tablaEmigrante;
    private DefaultTableModel model;
    private JScrollPane scrollpane;
    private String[] cabecera={"NOMBRE","APELLIDOS","CEDULA","ORIGEN","DESTINO","MOTIVO"};
    private String[][] data={};

    private Controlador control;

    Lista<Emigrante> listaPersonaEmigrante;   //lista    
    String fileName = "dataEmigrantes.ser"; 

    DeserializableGenerico<Lista> deser_gen;  


    public PestaniaCiudad(){
        inicializarRegistroEmigrante();
        model= new DefaultTableModel(data,cabecera);
        tablaEmigrante.setModel(model);
    }

    private void inicializarRegistroEmigrante(){

        listaPersonaEmigrante = new Lista<Emigrante>(); 
        deser_gen = new DeserializableGenerico<Lista>(fileName);        
        // listaPersonaEmigrante = deser_gen.deserialize();
        System.out.println("tam listaPersonaEmigrante dl arch listaEmigrantes.ser en PestaniaCiudad/// "+listaPersonaEmigrante.getTamanio());

        panelGeneral = new JPanel();
        
        panelDerCabecera = new JPanel();
        panelDerCuerpo =   new JPanel();
        panelDerPie =      new JPanel();

        panelIzquierda = new JPanel();
        panelDerecha = new JPanel();

        panelDerPieTitulo = new JPanel();
        panelDerPieCuerpo = new JPanel();

        labelSeleccionCiudad = new JLabel();
        labelSeleccionReporte = new JLabel();
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


        labelSeleccionCiudad.setText("SELECCIONE UNA CIUDAD");
        labelSeleccionReporte.setText("SELECCIONE EL TIPO DE REPORTE");

        comboBoxCiudad.addItem("la paz");
        comboBoxCiudad.addItem("pando");
        comboBoxCiudad.addItem("beni");
        comboBoxCiudad.addItem("cochabamba");
        comboBoxCiudad.addItem("santa cruz");
        comboBoxCiudad.addItem("oruro");
        comboBoxCiudad.addItem("potosi");
        comboBoxCiudad.addItem("chuquisaca");
        comboBoxCiudad.addItem("tarija");

        comboBoxReporte.addItem("Emigrantes-Salientes");
        comboBoxReporte.addItem("Emigrantes-Entrantes");
        comboBoxReporte.addItem("General");
        
        botonAceptar.setText("Aceptar");

        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });

        labelSeleccionCiudad.setMaximumSize(new Dimension(170, 50));
        labelSeleccionCiudad.setMinimumSize(new Dimension(170, 50));
        labelSeleccionCiudad.setPreferredSize(new Dimension(170, 50));

        comboBoxCiudad.setMaximumSize(new Dimension(200, 50));
        comboBoxCiudad.setMinimumSize(new Dimension(200, 50));
        comboBoxCiudad.setPreferredSize(new Dimension(200, 50));

        labelSeleccionReporte.setMaximumSize(new Dimension(210, 50));
        labelSeleccionReporte.setMinimumSize(new Dimension(210, 50));
        labelSeleccionReporte.setPreferredSize(new Dimension(210, 50));

        comboBoxReporte.setMaximumSize(new Dimension(200, 50));
        comboBoxReporte.setMinimumSize(new Dimension(200, 50));
        comboBoxReporte.setPreferredSize(new Dimension(200, 50));

        botonAceptar.setMaximumSize(new Dimension(100, 80));
        botonAceptar.setMinimumSize(new Dimension(100, 80));
        botonAceptar.setPreferredSize(new Dimension(100, 80));

        panelIzquierda.setLayout(new BoxLayout(panelIzquierda,BoxLayout.Y_AXIS));
        panelIzquierda.add(labelSeleccionCiudad);
        panelIzquierda.add(comboBoxCiudad);
        panelIzquierda.add(Box.createVerticalStrut(60));
        panelIzquierda.add(labelSeleccionReporte);
        panelIzquierda.add(comboBoxReporte);
        panelIzquierda.add(Box.createVerticalStrut(70));
        panelIzquierda.add(botonAceptar);

        labelSeleccionCiudad.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelSeleccionReporte.setAlignmentX(Component.CENTER_ALIGNMENT);
        comboBoxReporte.setAlignmentX(Component.CENTER_ALIGNMENT);
        comboBoxCiudad.setAlignmentX(Component.CENTER_ALIGNMENT);
        botonAceptar.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelIzquierda.setMaximumSize(new Dimension(300, 600));
        panelIzquierda.setMinimumSize(new Dimension(300, 600));
        panelIzquierda.setPreferredSize(new Dimension(300, 600));

       
        labelTituloDerecha.setText("LISTA PERSONAS EMIGRANTES");
        panelDerCabecera.setLayout(new FlowLayout());
        panelDerCabecera.add(labelTituloDerecha); 
        
        tablaEmigrante = new JTable();
        scrollpane = new JScrollPane();

        tablaEmigrante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        scrollpane.setMaximumSize(new Dimension(780, 450));
        scrollpane.setMinimumSize(new Dimension(780, 450));
        scrollpane.setPreferredSize(new Dimension(780, 450));

        scrollpane.setViewportView(tablaEmigrante);
        panelDerCuerpo.setLayout(new FlowLayout());
        panelDerCuerpo.add(scrollpane);

        panelDerCuerpo.setMaximumSize(new Dimension(790, 450));
        panelDerCuerpo.setMinimumSize(new Dimension(790, 450));
        panelDerCuerpo.setPreferredSize(new Dimension(790, 450));

        
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

        panelDerecha.setLayout(new BoxLayout(panelDerecha,BoxLayout.Y_AXIS));
        panelDerecha.add(panelDerCabecera);
        panelDerecha.add(panelDerCuerpo);
        panelDerecha.add(panelDerPie);

        panelDerecha.setMaximumSize(new Dimension(800, 600));
        panelDerecha.setMinimumSize(new Dimension(800, 600));
        panelDerecha.setPreferredSize(new Dimension(800, 600));

        panelGeneral.setLayout(new BoxLayout(panelGeneral,BoxLayout.X_AXIS));
        panelGeneral.add(panelIzquierda);
        panelGeneral.add(panelDerecha);

        panelGeneral.setMaximumSize(new Dimension(1100, 600));
        panelGeneral.setMinimumSize(new Dimension(1100, 600));
        panelGeneral.setPreferredSize(new Dimension(1100, 600));

    }
    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("botonAceptar");
        // vaciar_tabla();
        // tipoDeReporte();
    }
    public void setControlador(Controlador control) {
        this.control=control;
    }
    public void tipoDeReporte(){        
        String ciudad   = comboBoxCiudad.getSelectedItem().toString();
        String reporte  = comboBoxReporte.getSelectedItem().toString();

        System.out.println("tipoDeReporte=======: "+ciudad+"||"+reporte);

        if (reporte=="Emigrantes-Salientes") {
            emigrantesSalientes(ciudad);
            resumen(ciudad);
        }else if (reporte=="Emigrantes-Entrantes") {
            System.out.println("entro a entrantes:::::");
            emigrantesEntrantes(ciudad);
            resumen(ciudad);
        }else if (reporte=="General") {
            generalEmigrantes(ciudad);
            resumen(ciudad);
        }
    }
    public void emigrantesEntrantes(String ciudad){
        String aux;
        for (Emigrante obj:listaPersonaEmigrante) {
            aux = obj.getDestino();
            if (aux.equalsIgnoreCase(ciudad)) {
                System.out.println("entro al if ");    
                String nombre=obj.getNombre();
                String apellidos=obj.getApellidos();
                long cedula = obj.getCedula();
                String origen = obj.getOrigen();
                String destino = obj.getDestino();
                String motivo  = obj.getMotivoDeMigracion();

                System.out.println("las personas entrantesssssss::"+obj.toString());
                
                Object[] fila={nombre,apellidos,cedula,origen,destino,motivo};
                model.addRow(fila);
            }
        }
    }
    public void emigrantesSalientes(String ciudad){
        String aux;
        for (Emigrante obj:listaPersonaEmigrante) {
            aux=obj.getOrigen();
            if (aux.equalsIgnoreCase(ciudad)) {
                String nombre=obj.getNombre();
                String apellidos=obj.getApellidos();
                long cedula = obj.getCedula();
                String origen = obj.getOrigen();
                String destino = obj.getDestino();
                String motivo  = obj.getMotivoDeMigracion();
                Object[] fila={nombre,apellidos,cedula,origen,destino,motivo};
                model.addRow(fila);

            }
        }
    }
    public void generalEmigrantes(String ciudad){
        String aux1;
        String aux2;
        for (Emigrante obj:listaPersonaEmigrante) {
            aux1=obj.getOrigen();
            aux2=obj.getDestino();
            if (aux1.equalsIgnoreCase(ciudad)||aux2.equalsIgnoreCase(ciudad)) {
                String nombre=obj.getNombre();
                String apellidos=obj.getApellidos();
                long cedula = obj.getCedula();
                String origen = obj.getOrigen();
                String destino = obj.getDestino();
                String motivo  = obj.getMotivoDeMigracion();
                Object[] fila={nombre,apellidos,cedula,origen,destino,motivo};
                model.addRow(fila);
            }
        }       
    }
    public void resumen(String ciudad){
        String aux1;
        String aux2;
        int salientes=0,entrantes=0,total=0;
        for (Emigrante obj:listaPersonaEmigrante) {
            aux1=obj.getOrigen();
            aux2=obj.getDestino();

            if (aux1.equalsIgnoreCase(ciudad)) {
                salientes++;
            }else if (aux2.equalsIgnoreCase(ciudad)) {
                entrantes++;
            }
        }
        total = salientes+entrantes;
        // resLabelSalientes.setVisible(false);
        resLabelSalientes.setText(Integer.toString(salientes));
        // resLabelEntrantes.setVisible(false);
        resLabelEntrantes.setText(Integer.toString(entrantes));
        // resLabelTotal.setVisible(false);
        resLabelTotal.setText(Integer.toString(total));
    }

    public void vaciar_tabla(){
        int n = tablaEmigrante.getRowCount();
        for(int p=0;p<n;p++){
            model.removeRow(0);
        }
    }

}