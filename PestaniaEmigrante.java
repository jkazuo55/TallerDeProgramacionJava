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
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JTable; 
import javax.swing.table.*;
import javax.swing.JScrollPane;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
// import org.junit.Assert;
// import org.junit.BeforeClass;


public class PestaniaEmigrante{

    //paneles de PestaniaEmigrante 
    public JPanel  panelGeneral;

    private JPanel panelCabecera;
    private JPanel panelCuerpo;
    private JPanel panelPie;

    private JPanel panelCabeceraTitulo;
    private JPanel panelCabeceraCuerpo;

    private JPanel panelCuerpoDatosPersonales;
    private JPanel panelCuerpoDatosEmigrante;

    private JPanel panelCuerpoDatosPersonalesContenido;
    private JPanel panelCuerpoDatosPersonalesCabecera;

    private JPanel panelCuerpoDatosEmigranteCabecera;
    private JPanel panelCuerpoDatosEmigranteContenido;
    private JPanel panelCuerpoDatosEmigranteHistorial;
    private JPanel panelCuerpoDatosEmigranteHistorialTitulo;
    private JPanel panelCuerpoDatosEmigranteHistorialCuerpo;

    private JPanel panelCentro;
    
    //datos personales
    private JLabel tituloPrincipal;
    private JLabel tituloDatosPersonales;
    private JLabel tituloDatosEmigrante;

    private JLabel labelNombre;
    private JLabel labelApellidos;
    private JLabel labelCedula;
    private JLabel labelSexo;
    private JLabel labelNacidoEn;
    private JLabel labelDireccion;
    private JLabel labelTelefono;
    private JLabel labelCorreo;

    private JTextField textNombre;
    private JTextField textApellidos;
    private JTextField textCedula;
    private JComboBox  comboBoxSexo;
    private JTextField textNacidoEn;
    private JTextField textDireccion;
    private JTextField textTelefono;
    private JTextField textCorreo;
    
    //Datos Emigrante
    // private JLabel labelFecha;
    private JLabel labelOrigen;
    private JLabel labelDestino;
    private JLabel labelMotivoDeMigracion;

    // private JTextField textFecha;
    private JComboBox comboBoxOrigen;
    private JComboBox comboBoxDestino;
    private JComboBox comboBoxMotivoDeMigracion;
    private JLabel labelTituloHistorial;

    private JTable   tablaEmigrante;
    private DefaultTableModel model;
    private JScrollPane scrollpane;
    private String[] cabecera={"NUMERO","FECHA","RUTA"};
    private String[][] data={};

    //Cabecera
    private JLabel labelTituloCabecera;
    private JLabel labelIngreseCi;
    private JTextField textFildCi;
    private JButton btnBuscar;

    //Pie
    private JButton btnRegistrar;
    private JButton btnEmigrar;
    private JButton btnModificar;
    private JButton btnLimpiar;
    private JButton btnBorrar;
    // static public JButton btnPrueba;

    ReglasFormulario validarDatos;

    private Controlador control;
    //datosPersonales


    Emigrante perEmigrante;
    // Emigrante perGeneralEmigrantes;
    
    Lista<Emigrante> listaEmigrante;   //lista    
    Lista<Emigrante> listaGeneralEmigrantes;   //lista    
    // Serializable obj;     

    String fileEmigrantes     = "dataEmigrantes.ser"; 
    String fileGnrlEmigrantes = "dataHistorialEmigrantes.ser"; 

    SerializableGenerico<Lista> serListEmigrante; 
    SerializableGenerico<Lista> serListGnrlEmigrante; 
    DeserializableGenerico<Lista> deserListEmigrante;  
    DeserializableGenerico<Lista> deserListGnrlEmigrante;  

    // Lista<Emigrante> prueba;

    public PestaniaEmigrante(){ 
        inicializarRegistroEmigrante();
        model= new DefaultTableModel(data,cabecera);
        tablaEmigrante.setModel(model);
    }           
    private void inicializarRegistroEmigrante(){

        validarDatos = new ReglasFormulario(); 
        listaEmigrante = new Lista<Emigrante>(); 
        listaGeneralEmigrantes = new Lista<Emigrante>();

        serListEmigrante = new SerializableGenerico<Lista>(fileEmigrantes,listaEmigrante);
        serListGnrlEmigrante = new SerializableGenerico<Lista>(fileGnrlEmigrantes,listaGeneralEmigrantes);

        deserListEmigrante = new DeserializableGenerico<Lista>(fileEmigrantes);
        deserListGnrlEmigrante = new DeserializableGenerico<Lista>(fileGnrlEmigrantes);
        
        System.out.println("cargar la lista de del archivo serializado");
        // listaEmigrante = deserListEmigrante.deserialize();
        // listaGeneralEmigrantes = deserListGnrlEmigrante.deserialize();
        System.out.println("tam listaEmigrante/"+listaEmigrante.getTamanio());
        

        //DatosPersonales
        panelGeneral = new JPanel();
        
        panelCabecera = new JPanel();
        panelCuerpo =   new JPanel();
        panelPie =      new JPanel();

        panelCabeceraTitulo = new JPanel();
        panelCabeceraCuerpo = new JPanel();

        panelCuerpoDatosPersonales = new JPanel();
        panelCuerpoDatosEmigrante = new JPanel();

        panelCuerpoDatosPersonalesContenido = new JPanel();
        panelCuerpoDatosPersonalesCabecera = new JPanel();

        panelCuerpoDatosEmigranteCabecera = new JPanel();
        panelCuerpoDatosEmigranteContenido = new JPanel();
        panelCuerpoDatosEmigranteHistorial = new JPanel();
        panelCuerpoDatosEmigranteHistorialTitulo = new JPanel();
        panelCuerpoDatosEmigranteHistorialCuerpo = new JPanel();

        panelCentro = new JPanel();

        tituloDatosPersonales = new JLabel();
        tituloDatosEmigrante = new JLabel();

        labelNombre = new JLabel();
        labelApellidos = new JLabel();
        labelCedula = new JLabel();
        labelSexo = new JLabel();
        labelNacidoEn = new JLabel();
        labelDireccion = new JLabel();
        labelTelefono = new JLabel();
        labelCorreo = new JLabel();
        
        textNombre = new JTextField();
        textApellidos = new JTextField();
        textCedula = new JTextField();
        comboBoxSexo = new JComboBox();
        textNacidoEn = new JTextField();
        textDireccion = new JTextField();
        textTelefono = new JTextField();
        textCorreo = new JTextField();

        tituloDatosPersonales.setText("DATOS PERSONALES ");

        labelNombre.setText("Nombre");
        labelApellidos.setText("Apellidos");
        labelCedula.setText("Cedula");
        labelSexo.setText("Sexo");
        labelNacidoEn.setText("Nacido En");
        labelDireccion.setText("Direccion");
        labelTelefono.setText("Telefono");
        labelCorreo.setText("Correo");

        textNombre.setText("");
        textApellidos.setText("");
        textCedula.setText("");
        comboBoxSexo.addItem("Seleccionar");
        comboBoxSexo.addItem("Masculino");
        comboBoxSexo.addItem("Femenino");
        textNacidoEn.setText("");
        textDireccion.setText("");
        textTelefono.setText("");
        textCorreo.setText("");

        textNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cadenaKeyTyped(evt);
            }
        });
        textApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cadenaKeyTyped(evt);
            }
        });
        textCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                numeroKeyTyped(evt);
            }
        });
        textTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                numeroKeyTyped(evt);
            }
        });

        panelCuerpoDatosPersonalesCabecera.setLayout(new FlowLayout());
        panelCuerpoDatosPersonalesCabecera.add(tituloDatosPersonales);    

        panelCuerpoDatosPersonalesContenido.setLayout(new GridLayout(8,2));
        panelCuerpoDatosPersonalesContenido.add(labelNombre);
        panelCuerpoDatosPersonalesContenido.add(textNombre);
        panelCuerpoDatosPersonalesContenido.add(labelApellidos);
        panelCuerpoDatosPersonalesContenido.add(textApellidos);
        panelCuerpoDatosPersonalesContenido.add(labelCedula);
        panelCuerpoDatosPersonalesContenido.add(textCedula);
        panelCuerpoDatosPersonalesContenido.add(labelSexo);
        panelCuerpoDatosPersonalesContenido.add(comboBoxSexo);
        panelCuerpoDatosPersonalesContenido.add(labelNacidoEn);        
        panelCuerpoDatosPersonalesContenido.add(textNacidoEn);
        panelCuerpoDatosPersonalesContenido.add(labelDireccion);
        panelCuerpoDatosPersonalesContenido.add(textDireccion);
        panelCuerpoDatosPersonalesContenido.add(labelTelefono);
        panelCuerpoDatosPersonalesContenido.add(textTelefono);
        panelCuerpoDatosPersonalesContenido.add(labelCorreo);
        panelCuerpoDatosPersonalesContenido.add(textCorreo);

        panelCuerpoDatosPersonalesCabecera.setMaximumSize(new java.awt.Dimension(500, 30));
        panelCuerpoDatosPersonalesCabecera.setMinimumSize(new java.awt.Dimension(500, 30));
        panelCuerpoDatosPersonalesCabecera.setPreferredSize(new java.awt.Dimension(500, 30));

        panelCuerpoDatosPersonalesContenido.setMaximumSize(new java.awt.Dimension(500, 350));
        panelCuerpoDatosPersonalesContenido.setMinimumSize(new java.awt.Dimension(500, 350));
        panelCuerpoDatosPersonalesContenido.setPreferredSize(new java.awt.Dimension(500, 350));
        panelCuerpoDatosPersonales.setMaximumSize(new java.awt.Dimension(500, 100));
        panelCuerpoDatosPersonales.add(panelCuerpoDatosPersonalesCabecera);
        panelCuerpoDatosPersonales.add(panelCuerpoDatosPersonalesContenido);         

        panelCuerpoDatosPersonales.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 50, 60)));

        //Datos Emigrante

        tituloDatosEmigrante = new JLabel();

        // labelFecha = new JLabel();
        labelOrigen = new JLabel();
        labelDestino = new JLabel();
        labelMotivoDeMigracion = new JLabel();

        // textFecha = new JTextField();
        comboBoxOrigen = new JComboBox();
        comboBoxDestino = new JComboBox();
        comboBoxMotivoDeMigracion = new JComboBox();
        labelTituloHistorial = new JLabel();

        tablaEmigrante = new JTable();
        model = new DefaultTableModel();
        scrollpane = new JScrollPane();
        

        tituloDatosEmigrante.setText(" DATOS DE MIGRACION ");

        // labelFecha.setText("Ultima Fecha Migracion");
        labelOrigen.setText("Origen");
        labelDestino.setText("Destino");
        labelMotivoDeMigracion.setText("Motivo de Migracion");

        // textFecha.setText("");
        comboBoxOrigen.addItem("Seleccionar");
        comboBoxOrigen.addItem("la paz");
        comboBoxOrigen.addItem("pando");
        comboBoxOrigen.addItem("beni");
        comboBoxOrigen.addItem("cochabamba");
        comboBoxOrigen.addItem("santa cruz");
        comboBoxOrigen.addItem("oruro");
        comboBoxOrigen.addItem("potosi");
        comboBoxOrigen.addItem("chuquisaca");
        comboBoxOrigen.addItem("tarija");

        comboBoxDestino.addItem("Seleccionar");
        comboBoxDestino.addItem("la paz");
        comboBoxDestino.addItem("pando");
        comboBoxDestino.addItem("beni");
        comboBoxDestino.addItem("cochabamba");
        comboBoxDestino.addItem("santa cruz");
        comboBoxDestino.addItem("oruro");
        comboBoxDestino.addItem("potosi");
        comboBoxDestino.addItem("chuquisaca");
        comboBoxDestino.addItem("tarija");

        comboBoxMotivoDeMigracion.addItem("Seleccionar");
        comboBoxMotivoDeMigracion.addItem("Economico");
        comboBoxMotivoDeMigracion.addItem("Trabajo");
        comboBoxMotivoDeMigracion.addItem("Estudios");
        comboBoxMotivoDeMigracion.addItem("Otros");

        panelCuerpoDatosEmigranteCabecera .setLayout(new FlowLayout());
        panelCuerpoDatosEmigranteCabecera .add(tituloDatosEmigrante);

        panelCuerpoDatosEmigranteCabecera.setMaximumSize(new java.awt.Dimension(500, 30));
        panelCuerpoDatosEmigranteCabecera.setMinimumSize(new java.awt.Dimension(500, 30));
        panelCuerpoDatosEmigranteCabecera.setPreferredSize(new java.awt.Dimension(500, 30));

        panelCuerpoDatosEmigranteContenido.setLayout(new GridLayout(5,2));
        // panelCuerpoDatosEmigranteContenido.add(labelFecha);
        // panelCuerpoDatosEmigranteContenido.add(textFecha);
        panelCuerpoDatosEmigranteContenido.add(labelOrigen);
        panelCuerpoDatosEmigranteContenido.add(comboBoxOrigen);
        panelCuerpoDatosEmigranteContenido.add(labelDestino);
        panelCuerpoDatosEmigranteContenido.add(comboBoxDestino);
        panelCuerpoDatosEmigranteContenido.add(labelMotivoDeMigracion);
        panelCuerpoDatosEmigranteContenido.add(comboBoxMotivoDeMigracion);

        panelCuerpoDatosEmigranteContenido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        labelTituloHistorial.setText("Historial De Migraciones");
        panelCuerpoDatosEmigranteHistorialTitulo.setLayout(new FlowLayout());
        panelCuerpoDatosEmigranteHistorialTitulo.add(labelTituloHistorial);
        panelCuerpoDatosEmigranteHistorialTitulo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tablaEmigrante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        scrollpane.setMaximumSize(new Dimension(500, 450));
        scrollpane.setMinimumSize(new Dimension(500, 450));
        scrollpane.setPreferredSize(new Dimension(500, 450));

        scrollpane.setViewportView(tablaEmigrante);
        panelCuerpoDatosEmigranteHistorialCuerpo.setLayout(new FlowLayout());
        panelCuerpoDatosEmigranteHistorialCuerpo.add(scrollpane);
        panelCuerpoDatosEmigranteHistorialCuerpo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));

        panelCuerpoDatosEmigranteHistorial.setLayout(new BoxLayout(panelCuerpoDatosEmigranteHistorial,BoxLayout.Y_AXIS));
        panelCuerpoDatosEmigranteHistorial.add(panelCuerpoDatosEmigranteHistorialTitulo);
        panelCuerpoDatosEmigranteHistorial.add(panelCuerpoDatosEmigranteHistorialCuerpo);
        panelCuerpoDatosEmigranteHistorial.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(100, 250, 0)));

        panelCuerpoDatosEmigrante.setLayout(new BoxLayout(panelCuerpoDatosEmigrante,BoxLayout.Y_AXIS));
        panelCuerpoDatosEmigrante.add(panelCuerpoDatosEmigranteCabecera);
        panelCuerpoDatosEmigrante.add(panelCuerpoDatosEmigranteContenido);
        panelCuerpoDatosEmigrante.add(panelCuerpoDatosEmigranteHistorial);

        panelCuerpoDatosEmigrante.setSize(1000,300);
        panelCuerpoDatosEmigrante.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        //panelPie

        btnRegistrar = new JButton();
        btnEmigrar = new JButton();
        btnModificar = new JButton();
        btnLimpiar = new JButton();
        btnBorrar    = new JButton();
        // btnPrueba    = new JButton();

        btnRegistrar.setText("REGISTRAR");
        btnEmigrar.setText("EMIGRAR");
        btnModificar.setText("MODIFICAR");
        btnLimpiar.setText("LIMPIAR");
        btnBorrar.setText("BORRAR");
        // btnPrueba.setText("prueba");

        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnEmigrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmigrarActionPerformed(evt);
            }
        });

        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        panelPie.setLayout(new FlowLayout());
        panelPie.add(btnRegistrar);
        panelPie.add(btnEmigrar);
        panelPie.add(btnModificar);
        panelPie.add(btnLimpiar);
        panelPie.add(btnBorrar);
        // panelPie.add(btnPrueba);

        panelPie.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

        //cuerpo
        panelCuerpoDatosPersonales.setMaximumSize(new java.awt.Dimension(500, 0));
        panelCuerpoDatosPersonales.setMinimumSize(new java.awt.Dimension(500, 0));
        panelCuerpoDatosPersonales.setPreferredSize(new java.awt.Dimension(500, 0));

        panelCuerpoDatosEmigrante.setMaximumSize(new java.awt.Dimension(500, 0));
        panelCuerpoDatosEmigrante.setMinimumSize(new java.awt.Dimension(500, 0));
        panelCuerpoDatosEmigrante.setPreferredSize(new java.awt.Dimension(500, 0));

        panelCentro.setMaximumSize(new java.awt.Dimension(20, 0));
        panelCentro.setMinimumSize(new java.awt.Dimension(20, 0));
        panelCentro.setPreferredSize(new java.awt.Dimension(20, 0));

        panelCuerpo.setLayout(new BorderLayout());
        panelCuerpo.add(panelCuerpoDatosPersonales,BorderLayout.WEST);
        panelCuerpo.add(panelCuerpoDatosEmigrante,BorderLayout.EAST);
        panelCuerpo.add(panelCentro,BorderLayout.CENTER);            

        panelCuerpo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 255)));
        
        //PanelCabecera

        labelTituloCabecera = new JLabel();
        labelIngreseCi = new JLabel();
        textFildCi = new JTextField();
        btnBuscar = new JButton();

        labelTituloCabecera.setText("Busqueda de Ciudadano ");
        labelIngreseCi.setText("Ingrese su Cedula de Identidad  ");
        textFildCi.setPreferredSize( new Dimension( 200, 24 ) );

        textFildCi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                numeroKeyTyped(evt);
            }
        });

        btnBuscar.setText("BUSCAR");

        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        panelCabeceraTitulo.setLayout(new FlowLayout());
        panelCabeceraTitulo.add(labelTituloCabecera);

        panelCabeceraCuerpo.setLayout(new FlowLayout());
        panelCabeceraCuerpo.add(labelIngreseCi);
        panelCabeceraCuerpo.add(textFildCi);
        panelCabeceraCuerpo.add(btnBuscar);

        panelCabecera.setLayout(new BoxLayout(panelCabecera,BoxLayout.Y_AXIS));
        panelCabecera.add(panelCabeceraTitulo);
        panelCabecera.add(panelCabeceraCuerpo);

        panelCabecera.setMaximumSize(new java.awt.Dimension(700, 80));
        panelCabecera.setMinimumSize(new java.awt.Dimension(700, 80));
        panelCabecera.setPreferredSize(new java.awt.Dimension(700, 80));

        // panelCabecera.setSize(1000,100);
        panelCabecera.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        //General

        panelPie.setMaximumSize(new java.awt.Dimension(500, 100));
        panelPie.setMinimumSize(new java.awt.Dimension(500, 100));
        panelPie.setPreferredSize(new java.awt.Dimension(500, 100));

        panelGeneral.setLayout(new BoxLayout(panelGeneral,BoxLayout.Y_AXIS));
        panelGeneral.add(panelCabecera);
        panelGeneral.add(panelCuerpo);
        panelGeneral.add(panelPie);

        panelGeneral.setBorder(BorderFactory.createLineBorder(new Color(10, 100, 0)));
        panelGeneral.setMaximumSize(new Dimension(1100, 600));
        panelGeneral.setMinimumSize(new Dimension(1100, 600));
        panelGeneral.setPreferredSize(new Dimension(1100, 600));
    }

    private void numeroKeyTyped(java.awt.event.KeyEvent evt) {                                     
        char c;
        c = evt.getKeyChar();
        if(c<'0'||c>'9'){
            evt.consume();
        }
    }

    private void cadenaKeyTyped(java.awt.event.KeyEvent evt) {                                     
        char c;
        c = evt.getKeyChar();
        if ( (c<'a'||c>'z')&&(c<'A'||c>'Z')&& c!=evt.VK_SPACE){
            evt.consume();
        }
    }

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {

        if(validarFormulario()){
            guardar();
        }

        //serListEmigrante.serialize();        
    }

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {
        if (!validarBusqueda()) {
            // System.out.println("entro a valdiar busqueda");
            if (validarDatos.validarTamanioBusquedaDocumento(textFildCi.getText())) {
                consultar();
                        
            }else{
                escribir("cedula demasiada grande");
            }

            // vaciar_tabla();
            // filtrar();
        }else{
            escribir("Debe ingresar una Cedula ");
        }
    }

    private void btnEmigrarActionPerformed(java.awt.event.ActionEvent evt) {
        if (validarFormulario()) {
            emigrar();
        }
        serListGnrlEmigrante.serialize();
        System.out.println("EmigracionExitosa");
    }
    
    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {
        borrar();
        serListEmigrante.serialize();
    }
    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {
        if (validarFormulario()) {
            modificar();
        }
        serListEmigrante.serialize();
    }
    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {
        limpiar();
    }
    public void guardar(){

        if (validarDatos.validarTamanioBusquedaDocumento(textCedula.getText())) {

            String nombre   = textNombre.getText();
            String apellidos= textApellidos.getText();
            long   cedula   = Long.parseLong(textCedula.getText());
            String sexo     = comboBoxSexo.getSelectedItem().toString();
            String nacidoEn = textNacidoEn.getText();
            String direccion= textDireccion.getText();
            long telefono =   Long.parseLong(textTelefono.getText());
            String correo   = textCorreo.getText();

            // String fecha    = textFecha.getText();
            String fecha    = control.fechaSistema();
            String origen   = comboBoxOrigen.getSelectedItem().toString();
            String destino  = comboBoxDestino.getSelectedItem().toString();
            String motivo   = comboBoxMotivoDeMigracion.getSelectedItem().toString();
            String ruta     = "";

            if (validarDatos.validateEmail(correo)) {
                perEmigrante = new Emigrante(nombre,apellidos,cedula,sexo,nacidoEn,direccion,telefono,correo,fecha,origen,destino,ruta,motivo);
                if(buscarPersonaEmigrante(cedula)){
                    escribir("Hay otra persona registrada con el numero de cedula Cambie la Cedula de Identidad");
                }else{
                    System.out.println("LA PERSONA A REGISTRARSE ES: ");
                    listaEmigrante.insertarAlFinal(perEmigrante);
                    System.out.println(perEmigrante.toString());
                    limpiar();
                    escribir("persona registrada exitosamente");
                }
            }else{
                escribir("correo invalido ");                
            }
            
        }else{
            escribir("la cedula de identidad exede los 7 digitos");
        }
    }
    public void emigrar(){

        String nombre   = textNombre.getText();
        String apellidos= textApellidos.getText();
        long   cedula   = Long.parseLong(textCedula.getText());
        String sexo     = comboBoxSexo.getSelectedItem().toString();
        String nacidoEn = textNacidoEn.getText();
        String direccion= textDireccion.getText();
        long telefono =   Long.parseLong(textTelefono.getText());
        String correo   = textCorreo.getText();

        String fecha    = control.fechaSistema();
        String origen   = comboBoxOrigen.getSelectedItem().toString();
        String destino  = comboBoxDestino.getSelectedItem().toString();
        String motivo   = comboBoxMotivoDeMigracion.getSelectedItem().toString();
        String ruta     = control.ruta(origen,destino);

        perEmigrante = new Emigrante(nombre,apellidos,cedula,sexo,nacidoEn,direccion,telefono,correo,fecha,origen,destino,ruta,motivo);
        
        listaGeneralEmigrantes.insertarAlFinal(perEmigrante);
        // System.out.println(perEmigrante.toString());
        limpiar();
        // System.out.println("llamando al tamanioListageralPersonaEmigrante : "+listaGeneralEmigrantes.getTamanio());
    }
    public void filtrar(){
       long cedula = Long.parseLong(textFildCi.getText()); 
       historial(cedula);
    }
    public void vaciar_tabla(){
        int n = tablaEmigrante.getRowCount();
        for(int p=0;p<n;p++){
            model.removeRow(0);
        }
    }
    public void consultar(){
        long obtenidoCedula;        
        long cedula = Long.parseLong(textFildCi.getText());
        System.out.println("########## CI BUSQUEDA:::__"+cedula);        
        int i=0;
        if (buscarPersonaEmigrante(cedula)) {

            for(Emigrante objEmigrante:listaEmigrante){
                    System.out.println("entroo al for De Consulta");
                    obtenidoCedula = objEmigrante.getCedula();

                    if (obtenidoCedula == cedula) {

                        System.out.println("####### persona encontrada"+objEmigrante.toString());

                        String nombre   = objEmigrante.getNombre();
                        String apellidos= objEmigrante.getApellidos();
                        String carnet   = String.valueOf(objEmigrante.getCedula());
                        String sexo     = objEmigrante.getSexo();
                        String nacidoEn = objEmigrante.getNacidoEn();
                        String direccion= objEmigrante.getDireccion();
                        String telefono   = String.valueOf(objEmigrante.getTelefono());
                        String correo   = objEmigrante.getCorreo();

                        // String fecha    = objEmigrante.getFecha();
                        String origen   = objEmigrante.getOrigen();
                        String destino  = objEmigrante.getDestino();
                        String motivo   = objEmigrante.getMotivoDeMigracion();

                        textNombre.setText(nombre);
                        textApellidos.setText(apellidos);
                        textCedula.setText(carnet);
                        textNacidoEn.setText(nacidoEn);
                        textDireccion.setText(direccion);
                        textTelefono.setText(telefono);
                        textCorreo.setText(correo);
                        
                        // textFecha.setText(fecha);        

                        if(sexo.equalsIgnoreCase("Seleccionar")){
                            comboBoxSexo.setSelectedIndex(0);
                        }else if(sexo.equalsIgnoreCase("Masculino")){
                            comboBoxSexo.setSelectedIndex(1);
                        }else if(sexo.equalsIgnoreCase("Femenino")){
                            comboBoxSexo.setSelectedIndex(2);
                        }                    
                        if(origen.equalsIgnoreCase("Seleccionar")){
                            comboBoxOrigen.setSelectedIndex(0);
                        }else if(origen.equalsIgnoreCase("la paz")){
                            comboBoxOrigen.setSelectedIndex(1);
                        }else if(origen.equalsIgnoreCase("pando")){
                            comboBoxOrigen.setSelectedIndex(2);
                        }else if(origen.equalsIgnoreCase("beni")){
                            comboBoxOrigen.setSelectedIndex(3);
                        }else if(origen.equalsIgnoreCase("cochabamba")){
                            comboBoxOrigen.setSelectedIndex(4);
                        }else if(origen.equalsIgnoreCase("santa cruz")){
                            comboBoxOrigen.setSelectedIndex(5);
                        }else if(origen.equalsIgnoreCase("oruro")){
                            comboBoxOrigen.setSelectedIndex(6);
                        }else if(origen.equalsIgnoreCase("potosi")){
                            comboBoxOrigen.setSelectedIndex(7);
                        }else if(origen.equalsIgnoreCase("chuquisaca")){
                            comboBoxOrigen.setSelectedIndex(8);
                        }else if(origen.equalsIgnoreCase("tarija")){
                            comboBoxOrigen.setSelectedIndex(9);
                        }

                        if(destino.equalsIgnoreCase("Seleccionar")){
                            comboBoxDestino.setSelectedIndex(0);
                        }else if(destino.equalsIgnoreCase("la paz")){
                            comboBoxDestino.setSelectedIndex(1);
                        }else if(destino.equalsIgnoreCase("pando")){
                            comboBoxDestino.setSelectedIndex(2);
                        }else if(destino.equalsIgnoreCase("beni")){
                            comboBoxDestino.setSelectedIndex(3);
                        }else if(destino.equalsIgnoreCase("cochabamba")){
                            comboBoxDestino.setSelectedIndex(4);
                        }else if(destino.equalsIgnoreCase("santa cruz")){
                            comboBoxDestino.setSelectedIndex(5);
                        }else if(destino.equalsIgnoreCase("oruro")){
                            comboBoxDestino.setSelectedIndex(6);
                        }else if(destino.equalsIgnoreCase("potosi")){
                            comboBoxDestino.setSelectedIndex(7);
                        }else if(destino.equalsIgnoreCase("chuquisaca")){
                            comboBoxDestino.setSelectedIndex(8);
                        }else if(destino.equalsIgnoreCase("tarija")){
                            comboBoxDestino.setSelectedIndex(9);
                        }


                        if(motivo.equalsIgnoreCase("Seleccionar")){
                            comboBoxMotivoDeMigracion.setSelectedIndex(0);
                        }else if(motivo.equalsIgnoreCase("Economico")){
                            comboBoxMotivoDeMigracion.setSelectedIndex(1);
                        }else if(motivo.equalsIgnoreCase("Trabajo")){
                            comboBoxMotivoDeMigracion.setSelectedIndex(2);
                        }else if(motivo.equalsIgnoreCase("Estudios")){
                            comboBoxMotivoDeMigracion.setSelectedIndex(3);
                        }
                    } 
            }
            
        }else{
            escribir("cedula no encontrada");
        }
    }
    public void historial(long cedula){
        int i=1;
        long obtenidoCedula;
        // long cedula = Long.parseLong(textFildCi.getText());

        // System.out.println("tmanio de la lista : " + listaGeneralEmigrantes.getTamanio());

        if (buscarPersonaEmigrante(cedula)) {

            for(Emigrante objEmigrante:listaGeneralEmigrantes){
                    System.out.println("entroo al for De busqueda");           
                    obtenidoCedula = objEmigrante.getCedula();
                    if (obtenidoCedula == cedula) {
                        String carnet   = String.valueOf(objEmigrante.getCedula());
                        String fecha    = objEmigrante.getFecha();
                        String origen   = objEmigrante.getOrigen();
                        String destino  = objEmigrante.getDestino();
                        String ruta     = objEmigrante.getRuta();

                        Object[] fila={Integer.toString(i),fecha,ruta};
                        model.addRow(fila);
                        i++;
                    } 
            }
            
        }else{
            escribir("cedula no encontrada");
        }
    }

    public  void modificar(){
        int op = JOptionPane.showConfirmDialog(null,"Estas seguro de modificar?");//confirmacion
        if(op==1){
            System.out.println("modificacion canselada");
        }else if(op==0){ //si a puesto opcion no modificar el objeto en el cual nosotros ayamos modificado
            if (validarDatos.validarTamanioBusquedaDocumento(textCedula.getText())) {
                String nombre   = textNombre.getText();
                String apellidos= textApellidos.getText();
                String convirtiendo = textCedula.getText();
                long   cedula   = Long.parseLong(convirtiendo);
                String sexo     = comboBoxSexo.getSelectedItem().toString();
                String nacidoEn = textNacidoEn.getText();
                String direccion= textDireccion.getText();
                String convirtiendo2 = textTelefono.getText();
                long telefono =   Long.parseLong(convirtiendo2);
                String correo   = textCorreo.getText();

                // String fecha    = textFecha.getText();
                String fecha    = control.fechaSistema();
                String origen   = comboBoxOrigen.getSelectedItem().toString();
                String destino  = comboBoxDestino.getSelectedItem().toString();
                String motivo   = comboBoxMotivoDeMigracion.getSelectedItem().toString();
                String ruta     = "";

                if (validarDatos.validateEmail(correo)) {

                    perEmigrante = new Emigrante(nombre,apellidos,cedula,sexo,nacidoEn,direccion,telefono,correo,fecha,origen,destino,ruta,motivo);
                    
                    if(!buscarPersonaEmigrante(cedula)){
                        listaEmigrante.insertarAlFinal(perEmigrante);
                    }else{
                        for(Emigrante objEmigrante:listaEmigrante){
                            long ci = objEmigrante.getCedula();
                            if (ci==cedula) {
                                int indice = listaEmigrante.getIndice(objEmigrante);
                                listaEmigrante.set(indice,perEmigrante);                    
                            }
                        }    
                        limpiar();
                    }
                }else{
                    escribir("correo invalido ");                
                }
            }else{
                escribir("la cedula de identidad exede los 7 digitos");
            }    
        }
    }

    public void borrar(){        
        long op = Long.parseLong(JOptionPane.showInputDialog("Ingrese nuevamente la Cedula de indentidad \n Para borrar de manera definitiva : "));

        if(!buscarPersonaEmigrante(op)){
            escribir("La Cedula de Identidad Ingresada no existe!!");
        }else{
            for(Emigrante objEmigrante:listaEmigrante){             
                if (objEmigrante.getCedula() == op) {
                    System.out.println("##### persona A ELIMINAR ES #####:"+objEmigrante.toString());

                    int i = JOptionPane.showConfirmDialog(null,"Estas seguro de borrar...");
                    if(i==0){           
                        listaEmigrante.eliminar(listaEmigrante.getIndice(objEmigrante));
                        limpiar();
                        escribir("Emigrante eliminado exitosamente");
                    }else if(i==1){
                        escribir("Vuela a intentarlo");
                    }
                }    
            } 

        }
    }

    public void limpiar(){
        textNombre.setText("");
        textApellidos.setText("");
        textCedula.setText("");
        comboBoxSexo.setSelectedIndex(0);
        textNacidoEn.setText("");
        textDireccion.setText("");
        textTelefono.setText("");
        textCorreo.setText("");
        
        // textFecha.setText("");        
        comboBoxOrigen.setSelectedIndex(0);        
        comboBoxDestino.setSelectedIndex(0);        
        comboBoxMotivoDeMigracion.setSelectedIndex(0);        
    }

    public boolean buscarPersonaEmigrante(long cedula){

        boolean encontrado =false;
        int i=0;
        while(encontrado == false && i<listaEmigrante.getTamanio()){
            if (listaEmigrante.get(i).getCedula() == cedula) {
                encontrado=true;
            }else{
                i++;
            }
        }
        return encontrado;    
    }

    //validaciones
    public void keyTyped(KeyEvent ke) {
        char c=ke.getKeyChar();             
        if(Character.isLetter(c)) { 
            ke.consume();       
            escribir("Ingrese solo numeros");
        }            
    }

    public boolean validarFormulario(){

        String nombre   = textNombre.getText();
        String apellidos= textApellidos.getText();
        String cedula   = textCedula.getText();
        String sexo     = comboBoxSexo.getSelectedItem().toString();
        String nacidoEn = textNacidoEn.getText();
        String direccion= textDireccion.getText();
        String telefono = textTelefono.getText();
        String correo   = textCorreo.getText();

        // String fecha    = textFecha.getText();
        String fecha    = control.fechaSistema();
        String origen   = comboBoxOrigen.getSelectedItem().toString();
        String destino  = comboBoxDestino.getSelectedItem().toString();
        String motivo   = comboBoxMotivoDeMigracion.getSelectedItem().toString();

        return validarDatos.validaDatos(nombre,apellidos,cedula,sexo,nacidoEn,direccion,telefono,correo,fecha,origen,destino,motivo);
    }
    public boolean validarBusqueda(){
        String busqueda = textFildCi.getText();
        return validarDatos.validarCampoBusqueda(busqueda);
    } 

    public void escribir(String texto){
        JOptionPane.showMessageDialog(panelGeneral, texto);
    }
    public void setControlador(Controlador control) {
        this.control=control;
    } 
}
