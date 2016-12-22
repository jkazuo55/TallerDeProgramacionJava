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


public class RegistroEmigrante{

    //paneles de RegistroEmigrante 
    public JPanel panelGeneral;

    private JPanel panelCabecera;
    private JPanel panelCuerpo;
    private JPanel panelPie;

    private JPanel panelCabeceraTitulo;
    private JPanel panelCabeceraCuerpo;

    private JPanel panelCuerpoDatosPersonales;
    private JPanel panelCuerpoDatosEmigrante;

    private JPanel panelCuerpoDatosPersonalesContenido;
    private JPanel panelCuerpoDatosPersonalesCabecera;

    private JPanel panelCuerpoDatosEmigranteContenido;
    private JPanel panelCuerpoDatosEmigranteCabecera;

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
    private JLabel labelEmigranteSiNo;
    private JLabel labelFecha;
    private JLabel labelOrigen;
    private JLabel labelDestino;
    private JLabel labelMotivoDeMigracion;

    private JTextField textEmigranteSiNo;
    private JTextField textFecha;
    private JComboBox comboBoxOrigen;
    private JComboBox comboBoxDestino;
    private JComboBox comboBoxMotivoDeMigracion;
    //Cabecera
    private JLabel labelTituloCabecera;
    private JLabel labelIngreseCi;
    private JTextField textFildCi;
    private JButton btnBuscar;

    //Pie
    private JButton btnRegistrar;
    private JButton btnModificar;
    private JButton btnBorrar;

    //datosPersonales

    PersonaEmigrante perEmigrante;
    
    Lista<PersonaEmigrante> listaPersonaEmigrante;   //lista    
    // Serializable obj;     

    String fileName = "serializaciones.ser"; 

    SerializableGenerico<Lista> ser_gen; 
    DeserializableGenerico<Lista> deser_gen;  

    // Lista<PersonaEmigrante> prueba;

    public RegistroEmigrante(){ 

        System.out.println("Inicializa el programa");    
        
        // deser_gen = new DeserializableGenerico<Lista>(fileName);

        // Lista<PersonaEmigrante> new_data = deser_gen.deserialize();

        // listaPersonaEmigrante = new_data;
        
        // for (PersonaEmigrante person: new_data) {
        //     System.out.println("entro al for de desserializacion");
        //     System.out.println(person.toString());
        // }

        inicializarRegistroEmigrante();
        // obj = new Serializable();
        // obj.cargaDatos();
    }   

        
    private void inicializarRegistroEmigrante(){

        listaPersonaEmigrante = new Lista<PersonaEmigrante>(); 

        deser_gen = new DeserializableGenerico<Lista>(fileName);
        listaPersonaEmigrante = deser_gen.deserialize();


        ser_gen = new SerializableGenerico<Lista>(fileName,listaPersonaEmigrante);
    
        

        // prueba =  new Lista<PersonaEmigrante>(); 

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

        panelCuerpoDatosEmigranteContenido = new JPanel();
        panelCuerpoDatosEmigranteCabecera = new JPanel();

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

        tituloDatosPersonales.setText("  DATOS PERSONALES ");

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
        comboBoxSexo.addItem("Masculino");
        comboBoxSexo.addItem("Femenino");
        textNacidoEn.setText("");
        textDireccion.setText("");
        textTelefono.setText("");
        textCorreo.setText("");

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

        labelEmigranteSiNo = new JLabel();
        labelFecha = new JLabel();
        labelOrigen = new JLabel();
        labelDestino = new JLabel();
        labelMotivoDeMigracion = new JLabel();

        textEmigranteSiNo = new JTextField();
        textFecha = new JTextField();
        comboBoxOrigen = new JComboBox();
        comboBoxDestino = new JComboBox();
        comboBoxMotivoDeMigracion = new JComboBox();

        tituloDatosEmigrante.setText(" DATOS DE MIGRACION ");

        labelEmigranteSiNo.setText("Emigrante si/no");
        labelFecha.setText("Ultima Fecha Migracion");
        labelOrigen.setText("Origen");
        labelDestino.setText("Destino");
        labelMotivoDeMigracion.setText("Motivo de Migracion");

        textEmigranteSiNo.setText("");
        textFecha.setText("");
        comboBoxOrigen.addItem("cochabamba");
        comboBoxOrigen.addItem("la paz");
        comboBoxOrigen.addItem("tarija");
        comboBoxOrigen.addItem("chuquisaca");
        comboBoxOrigen.addItem("pando");
        comboBoxOrigen.addItem("beni");
        comboBoxOrigen.addItem("oruro");
        comboBoxOrigen.addItem("santa cruz");
        comboBoxOrigen.addItem("pando");
        comboBoxOrigen.addItem("potosi");
        comboBoxDestino.addItem("cochabamba");
        comboBoxDestino.addItem("la paz");
        comboBoxDestino.addItem("tarija");
        comboBoxDestino.addItem("chuquisaca");
        comboBoxDestino.addItem("pando");
        comboBoxDestino.addItem("beni");
        comboBoxDestino.addItem("oruro");
        comboBoxDestino.addItem("santa cruz");
        comboBoxDestino.addItem("pando");
        comboBoxDestino.addItem("potosi");
        comboBoxMotivoDeMigracion.addItem("Economico");
        comboBoxMotivoDeMigracion.addItem("Trabajo");
        comboBoxMotivoDeMigracion.addItem("Estudios");
        comboBoxMotivoDeMigracion.addItem("Otros");

        panelCuerpoDatosEmigranteCabecera .setLayout(new FlowLayout());
        panelCuerpoDatosEmigranteCabecera .add(tituloDatosEmigrante);

        panelCuerpoDatosEmigranteContenido.setLayout(new GridLayout(5,2));
        panelCuerpoDatosEmigranteContenido.add(labelEmigranteSiNo);
        panelCuerpoDatosEmigranteContenido.add(textEmigranteSiNo);
        panelCuerpoDatosEmigranteContenido.add(labelFecha);
        panelCuerpoDatosEmigranteContenido.add(textFecha);
        panelCuerpoDatosEmigranteContenido.add(labelOrigen);
        panelCuerpoDatosEmigranteContenido.add(comboBoxOrigen);
        panelCuerpoDatosEmigranteContenido.add(labelDestino);
        panelCuerpoDatosEmigranteContenido.add(comboBoxDestino);
        panelCuerpoDatosEmigranteContenido.add(labelMotivoDeMigracion);
        panelCuerpoDatosEmigranteContenido.add(comboBoxMotivoDeMigracion);

        panelCuerpoDatosEmigranteCabecera.setMaximumSize(new java.awt.Dimension(500, 30));
        panelCuerpoDatosEmigranteCabecera.setMinimumSize(new java.awt.Dimension(500, 30));
        panelCuerpoDatosEmigranteCabecera.setPreferredSize(new java.awt.Dimension(500, 30));

        panelCuerpoDatosEmigranteContenido.setMaximumSize(new java.awt.Dimension(500, 350));
        panelCuerpoDatosEmigranteContenido.setMinimumSize(new java.awt.Dimension(500, 350));
        panelCuerpoDatosEmigranteContenido.setPreferredSize(new java.awt.Dimension(500, 350));

        panelCuerpoDatosEmigrante.setLayout(new BoxLayout(panelCuerpoDatosEmigrante,BoxLayout.Y_AXIS));
        panelCuerpoDatosEmigrante.add(panelCuerpoDatosEmigranteCabecera);
        panelCuerpoDatosEmigrante.add(panelCuerpoDatosEmigranteContenido);

        panelCuerpoDatosEmigrante.setSize(1000,300);
        panelCuerpoDatosEmigrante.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        //panelPie

        btnRegistrar = new JButton();
        btnModificar = new JButton();
        btnBorrar    = new JButton();

        btnRegistrar.setText("REGISTRAR");
        btnModificar.setText("MODIFICAR");
        btnBorrar.setText("BORRAR");


        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        //btnLimpiar.setText("Limpiar");

        panelPie.setLayout(new FlowLayout());
        panelPie.add(btnRegistrar);
        panelPie.add(btnModificar);
        panelPie.add(btnBorrar);

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
        textFildCi.setText("      ");
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


    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {
        guardar();
        ser_gen.serialize();
        System.out.println("RegistroExitoso");
    }
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {
        // System.out.println("tmanio de la listaa #### : " + listaRegistroPersonaEmigrante.tamanioLista());
        for(PersonaEmigrante objEmigrante:listaPersonaEmigrante){
            System.out.println(objEmigrante.toString());
        }
        consultar();
    }
    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {
        borrar();
        ser_gen.serialize();
    }

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {
        modificar();
        ser_gen.serialize();
    }

    public void escribir(String texto){
        JOptionPane.showMessageDialog(panelGeneral, texto);
    }


    // public void setControlador(ControlPrincipal c) {
    //     btnRegistrar.addActionListener(c);
    //     btnLimpiar.addActionListener(c);
    // }

    public void guardar(){

        String nombre   = textNombre.getText();
        String apellidos= textApellidos.getText();
        long   cedula   = Long.parseLong(textCedula.getText());
        String sexo     = comboBoxSexo.getSelectedItem().toString();
        String nacidoEn = textNacidoEn.getText();
        String direccion= textDireccion.getText();
        String telefono = textTelefono.getText();
        String correo   = textCorreo.getText();

        String emigrante= textEmigranteSiNo.getText();
        String fecha    = textFecha.getText();
        String origen   = comboBoxOrigen.getSelectedItem().toString();
        String destino  = comboBoxDestino.getSelectedItem().toString();
        String motivo   = comboBoxMotivoDeMigracion.getSelectedItem().toString();

        perEmigrante = new PersonaEmigrante(nombre,apellidos,cedula,sexo,nacidoEn,direccion,telefono,correo,emigrante,fecha,origen,destino,motivo);
        //condicion del arreglo buscar el objeto con el codiog que se acaba de colocar

        if(buscarPersonaEmigrante(cedula)){
            escribir("Hay otra persona registrada con el numero de cedula Cambie la Cedula de Identidad");
        }else{
            System.out.println("LA PERSONA A REGISTRARSE ES: ");

            listaPersonaEmigrante.insertarAlFinal(perEmigrante);
            System.out.println(perEmigrante.toString());
            
            System.out.println("EMIGRANTE AGREGADO ALA LISTA");
            // obj.grabar();
            

            // System.out.println("grabado en el archivo  binario");
            // actualizar();
           limpiar();
        }
        System.out.println("llamando al tamanioLista : "+listaPersonaEmigrante.getTamanio());
    }

    public void consultar(){
       
        long obtenidoCedula;
        long cedula = Long.parseLong(textFildCi.getText());

        System.out.println("########## El numero a buscar  : "+cedula);
        
        int i=0;

        System.out.println("tmanio de la lista : " + listaPersonaEmigrante.getTamanio());

        // while(i<=listaPersonaEmigrante.getTamanio()){
        if (buscarPersonaEmigrante(cedula)) {

            for(PersonaEmigrante objEmigrante:listaPersonaEmigrante){
                    // System.out.println(i);
                    // PersonaEmigrante objEmigrante = listaPersonaEmigrante.get(i);

                    System.out.println("entroo al for De busqueda");
             
                    // obtenidoCedula = objEmigrante.getCedula();
                    obtenidoCedula = objEmigrante.getCedula();

                    if (obtenidoCedula == cedula) {

                        System.out.println("persona encontrada"+objEmigrante.toString());

                        String nombre   = objEmigrante.getNombre();
                        String apellidos= objEmigrante.getApellidos();
                        String carnet   = String.valueOf(objEmigrante.getCedula());
                        String sexo     = objEmigrante.getSexo();
                        String nacidoEn = objEmigrante.getNacidoEn();
                        String direccion= objEmigrante.getDireccion();
                        String telefono = objEmigrante.getTelefono();
                        String correo   = objEmigrante.getCorreo();

                        String esEmigrante= objEmigrante.getEmigranteSiNo();
                        String fecha    = objEmigrante.getFecha();
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
                        
                        textEmigranteSiNo.setText(esEmigrante);        
                        textFecha.setText(fecha);        

                        if(sexo.equalsIgnoreCase("masculino")){
                            comboBoxSexo.setSelectedIndex(1);
                        }else if(sexo.equalsIgnoreCase("femenino")){
                            comboBoxSexo.setSelectedIndex(2);
                        }                    
                        if(origen.equalsIgnoreCase("cochabamba")){
                            comboBoxOrigen.setSelectedIndex(1);
                        }else if(origen.equalsIgnoreCase("tarija")){
                            comboBoxOrigen.setSelectedIndex(2);
                        }
                        if(destino.equalsIgnoreCase("cochabamba")){
                            comboBoxDestino.setSelectedIndex(1);
                        }else if(destino.equalsIgnoreCase("tarija")){
                            comboBoxDestino.setSelectedIndex(2);
                        }else if(destino.equalsIgnoreCase("pando")){
                            comboBoxDestino.setSelectedIndex(3);
                        }
                        if(motivo.equalsIgnoreCase("Economico")){
                            comboBoxMotivoDeMigracion.setSelectedIndex(1);
                        }else if(motivo.equalsIgnoreCase("Trabajo")){
                            comboBoxMotivoDeMigracion.setSelectedIndex(2);
                        }else if(motivo.equalsIgnoreCase("Estudios")){
                            comboBoxMotivoDeMigracion.setSelectedIndex(3);
                        }else{
                             System.out.println("se mostro");
                        }
                    } 
                    // else{
                    //     escribir("cedula no encontrada");
                    // }
            }
            
        }else{
            escribir("cedula no encontrada");
        }
    }

    public  void modificar(){
        int op = JOptionPane.showConfirmDialog(null,"Deves consultar primero \nDeseas consultar ahora presiona <Si>\nSi ya consultastes presionsa <No>");//confirmacion
        if(op==0){
            consultar();
        }else if(op==1){ //si a puesto opcion no modificar el objeto en el cual nosotros ayamos modificado
            int n = listaPersonaEmigrante.getTamanio();
            System.out.println("tamanio de la lista es :" +n);

                String nombre   = textNombre.getText();
                String apellidos= textApellidos.getText();
                String convirtiendo = textCedula.getText();
                long   cedula   = Long.parseLong(convirtiendo);
                String sexo     = comboBoxSexo.getSelectedItem().toString();
                String nacidoEn = textNacidoEn.getText();
                String direccion= textDireccion.getText();
                String telefono = textTelefono.getText();
                String correo   = textCorreo.getText();

                String emigrante= textEmigranteSiNo.getText();
                String fecha    = textFecha.getText();
                String origen   = comboBoxOrigen.getSelectedItem().toString();
                String destino  = comboBoxDestino.getSelectedItem().toString();
                String motivo   = comboBoxMotivoDeMigracion.getSelectedItem().toString();

                perEmigrante = new PersonaEmigrante(nombre,apellidos,cedula,sexo,nacidoEn,direccion,telefono,correo,emigrante,fecha,origen,destino,motivo);
                
                if(!buscarPersonaEmigrante(cedula)){
                    listaPersonaEmigrante.insertarAlFinal(perEmigrante);
                }else{
                    for(PersonaEmigrante objEmigrante:listaPersonaEmigrante){
                        long ci = objEmigrante.getCedula();
                        if (ci==cedula) {
                            int indice = listaPersonaEmigrante.getIndice(objEmigrante);
                            System.out.println("el indice antes de modificar"+indice);
                            listaPersonaEmigrante.set(indice,perEmigrante);                    
                        }
                    }    
                    limpiar();
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
        
        textEmigranteSiNo.setText("");        
        textFecha.setText("");        
        comboBoxOrigen.setSelectedIndex(0);        
        comboBoxDestino.setSelectedIndex(0);        
        comboBoxMotivoDeMigracion.setSelectedIndex(0);        
    }

    public boolean buscarPersonaEmigrante(long cedula){

        boolean encontrado =false;
        int i=0;
        while(encontrado == false && i<listaPersonaEmigrante.getTamanio()){
            if (listaPersonaEmigrante.get(i).getCedula() == cedula) {
                encontrado=true;
            }else{
                i++;
            }
        }
        return encontrado;    
    }

    public void borrar(){
        long op = Long.parseLong(JOptionPane.showInputDialog("Codigo a borrar : "));

        if(!buscarPersonaEmigrante(op)){
            escribir("Codigo no existe");
        }else{
            for(PersonaEmigrante objEmigrante:listaPersonaEmigrante){
                    System.out.println("entroo al for De busqueda");
             
                    if (objEmigrante.getCedula() == op) {
                        System.out.println("##### persona A ELIMINAR ES #####:"+objEmigrante.toString());

                        int i = JOptionPane.showConfirmDialog(null,"Estas seguro de borrar...");
                        if(i==0){           
                            listaPersonaEmigrante.eliminar(listaPersonaEmigrante.getIndice(objEmigrante));
                        }else if(i==1){
                            escribir("Vuela a intentarlo");
                        }
                    }    

            } 

        }
    }




    //         private void botonGuardarActionPerformed(ActionEvent event){
    //             if (textNombre.getText().equals("")) {
    //                 JOptionPane.showMessageDialog(null,"por favor ingrese el nombre");
    //                 return;
    //             }
    //             if (textApellidos.getText().equals("")) {
    //                 JOptionPane.showMessageDialog(null,"por favor ingrese su apellido");
    //                 return;
    //             }
    //             if (textCedula.getText().equals("")) {
    //                 JOptionPane.showMessageDialog(null,"por favor ingrese el Cedula");
    //                 return;
    //             }
    //             if (textNacidoEn.getText().equals("")) {
    //                 JOptionPane.showMessageDialog(null,"por favor ingrese su lugar de Nacimiento");
    //                 return;
    //             }
    //             if (textDireccion.getText().equals("")) {
    //                 JOptionPane.showMessageDialog(null,"por favor ingrese su direccion");
    //                 return;
    //             }
    //             if (textTelefono.getText().equals("")) {
    //                 JOptionPane.showMessageDialog(null,"por favor ingrese su Telefono");
    //                 return;
    //             }
    //         }
    //         private void txtNombreKeyTyped(java.awt.event.KeyEvent event){
    //             }

    //             char tipoDeLetra = event.getKeyChar();
    //             if (Character.isDigit(tipoDeLetra)) {
    //                 event.consume();
    //             }
    //         }
}