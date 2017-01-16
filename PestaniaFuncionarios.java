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
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;


public class PestaniaFuncionarios{

    //paneles de PestaniaFuncionarios 
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
    
    //Datos funcionario 
    private JLabel labelNombreUsuario;
    private JLabel labelContrasenia;
    private JLabel labelRol;

    private JTextField textNombreUsuario;
    private JTextField textContrasenia;
    private JComboBox comboBoxRol;
    //Cabecera
    private JLabel labelTituloCabecera;
    private JLabel labelIngreseCi;
    private JTextField textFildCi;
    private JButton btnBuscar;

    //Pie
    private JButton btnRegistrar;
    private JButton btnModificar;
    private JButton btnLimpiar;
    private JButton btnBorrar;

    ReglasFormulario validarDatos;

    //datosPersonales


    Funcionario perFuncionario;
    
    Lista<Funcionario> listaFuncionario;   //lista    
    String fileName = "dataFuncionarios.ser"; 

    SerializableGenerico<Lista> ser_gen; 
    DeserializableGenerico<Lista> deser_gen;  
    public PestaniaFuncionarios(){ 
        inicializarRegistroFuncionario();
    }   
        
    private void inicializarRegistroFuncionario(){

        validarDatos = new ReglasFormulario(); 
        listaFuncionario = new Lista<Funcionario>(); 

        ser_gen = new SerializableGenerico<Lista>(fileName,listaFuncionario);

        deser_gen = new DeserializableGenerico<Lista>(fileName);
        

        System.out.println("llegoHasta aki 1 PestaniaFuncionarios");
        if(deser_gen.tieneDatos()){
            listaFuncionario = deser_gen.deserialize();
        }      
        System.out.println("llegoHasta aki 2 PestaniaFuncionarios");

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

        labelNombre.setText("Nombres del Empleado");
        labelApellidos.setText("Apellidos del Empleado");
        labelCedula.setText("Cedula de Identidad del Empleado");
        labelSexo.setText("Seleccione Sexo");
        labelNacidoEn.setText("Lugar de nacimiento del Empleado");
        labelDireccion.setText("Direccion actual del Empleado");
        labelTelefono.setText("Telefono Celular del Empleado");
        labelCorreo.setText("Correo electronico del Empleado");

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

        panelCuerpoDatosPersonales.setLayout(new BoxLayout(panelCuerpoDatosPersonales,BoxLayout.Y_AXIS));
        panelCuerpoDatosPersonales.add(panelCuerpoDatosPersonalesCabecera);
        panelCuerpoDatosPersonales.add(panelCuerpoDatosPersonalesContenido);         


        //Datos funcionario 

        tituloDatosEmigrante = new JLabel();

        labelNombreUsuario = new JLabel();
        labelContrasenia = new JLabel();
        labelRol = new JLabel();

        textNombreUsuario = new JTextField();
        textContrasenia = new JTextField();
        comboBoxRol = new JComboBox();

        tituloDatosEmigrante.setText(" DATOS DEL EMPLEADO ");

        labelNombreUsuario.setText("Nombre de Usuario del Empleado");
        labelContrasenia.setText("Crear una contrasenia");
        labelRol.setText("Rol que cumplira el Empleado");

        textNombreUsuario.setText("");
        textContrasenia.setText("");
        comboBoxRol.addItem("Seleccionar");
        comboBoxRol.addItem("Administrador");
        comboBoxRol.addItem("Usuario");

        panelCuerpoDatosEmigranteCabecera .setLayout(new FlowLayout());
        panelCuerpoDatosEmigranteCabecera .add(tituloDatosEmigrante);

        panelCuerpoDatosEmigranteContenido.setLayout(new GridLayout(5,2));
        panelCuerpoDatosEmigranteContenido.add(labelNombreUsuario);
        panelCuerpoDatosEmigranteContenido.add(textNombreUsuario);
        panelCuerpoDatosEmigranteContenido.add(labelContrasenia);
        panelCuerpoDatosEmigranteContenido.add(textContrasenia);
        panelCuerpoDatosEmigranteContenido.add(labelRol);
        panelCuerpoDatosEmigranteContenido.add(comboBoxRol);

        panelCuerpoDatosEmigranteCabecera.setMaximumSize(new java.awt.Dimension(500, 30));
        panelCuerpoDatosEmigranteCabecera.setMinimumSize(new java.awt.Dimension(500, 30));
        panelCuerpoDatosEmigranteCabecera.setPreferredSize(new java.awt.Dimension(500, 30));

        panelCuerpoDatosEmigranteContenido.setMaximumSize(new java.awt.Dimension(500, 240));
        panelCuerpoDatosEmigranteContenido.setMinimumSize(new java.awt.Dimension(500, 240));
        panelCuerpoDatosEmigranteContenido.setPreferredSize(new java.awt.Dimension(500, 240));

        panelCuerpoDatosEmigrante.setLayout(new BoxLayout(panelCuerpoDatosEmigrante,BoxLayout.Y_AXIS));
        panelCuerpoDatosEmigrante.add(panelCuerpoDatosEmigranteCabecera);
        panelCuerpoDatosEmigrante.add(panelCuerpoDatosEmigranteContenido);

        panelCuerpoDatosEmigrante.setSize(1000,300);

        //panelPie

        btnRegistrar = new JButton();
        btnModificar = new JButton();
        btnLimpiar    = new JButton();
        btnBorrar    = new JButton();

        btnRegistrar.setText("REGISTRAR");
        btnModificar.setText("MODIFICAR");
        btnLimpiar.setText("LIMPIAR");
        btnBorrar.setText("BORRAR");

        btnRegistrar.setMaximumSize(new java.awt.Dimension(120, 60));
        btnRegistrar.setMinimumSize(new java.awt.Dimension(120, 60));
        btnRegistrar.setPreferredSize(new java.awt.Dimension(120, 60));

        btnModificar.setMaximumSize(new java.awt.Dimension(120, 60));
        btnModificar.setMinimumSize(new java.awt.Dimension(120, 60));
        btnModificar.setPreferredSize(new java.awt.Dimension(120, 60));

        btnLimpiar.setMaximumSize(new java.awt.Dimension(120, 60));
        btnLimpiar.setMinimumSize(new java.awt.Dimension(120, 60));
        btnLimpiar.setPreferredSize(new java.awt.Dimension(120, 60));

        btnBorrar.setMaximumSize(new java.awt.Dimension(120, 60));
        btnBorrar.setMinimumSize(new java.awt.Dimension(120, 60));
        btnBorrar.setPreferredSize(new java.awt.Dimension(120, 60));


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

        //btnLimpiar.setText("Limpiar");

        panelPie.setLayout(new FlowLayout());
        panelPie.add(btnRegistrar);
        panelPie.add(btnModificar);
        panelPie.add(btnLimpiar);
        panelPie.add(btnBorrar);


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

        
        //PanelCabecera

        labelTituloCabecera = new JLabel();
        labelIngreseCi = new JLabel();
        textFildCi = new JTextField();
        btnBuscar = new JButton();

        labelTituloCabecera.setText("Busqueda de Ciudadano ");

        labelTituloCabecera.setText("Busqueda de Ciudadano ");
        labelIngreseCi.setText("Ingrese su Cedula de Identidad  ");
        textFildCi.setPreferredSize( new Dimension( 200, 30 ) );
        btnBuscar.setText("BUSCAR");
        btnBuscar.setMaximumSize(new java.awt.Dimension(90, 50));
        btnBuscar.setMinimumSize(new java.awt.Dimension(90, 50));
        btnBuscar.setPreferredSize(new java.awt.Dimension(90, 50));

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

        //General

        panelPie.setMaximumSize(new java.awt.Dimension(500, 100));
        panelPie.setMinimumSize(new java.awt.Dimension(500, 100));
        panelPie.setPreferredSize(new java.awt.Dimension(500, 100));

        panelGeneral.setLayout(new BoxLayout(panelGeneral,BoxLayout.Y_AXIS));
        panelGeneral.add(panelCabecera);
        panelGeneral.add(panelCuerpo);
        panelGeneral.add(panelPie);

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
            ser_gen.serialize();
            escribir("Empleado registrado exitosamente");    
        }else{
            escribir("no puede dejar los campos vacios");
        }
    }
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {        
        if (!validarBusqueda()) {
            if (validarDatos.validarTamanioBusquedaDocumento(textFildCi.getText())) {
                consultar();
                        
            }else{
                escribir("cedula demasiada grande");
            }

            //vaciar_tabla();
            //filtrar();
        }else{
            escribir("Debe ingresar una Cedula ");
        }
    }

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {
        limpiar();
    }

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {
        borrar();
        ser_gen.serialize();       
    }

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {
        if (validarFormulario()) {
            modificar();
            ser_gen.serialize();
            escribir("Empleado modifcado exitosamente!");
        }else{
            escribir("Antes debe hacer la busqueda");
        }
    }

    public void escribir(String texto){
        JOptionPane.showMessageDialog(panelGeneral, texto);
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

            String funcionario = textNombreUsuario.getText();
            String contrasenia    = textContrasenia.getText();
            String rol   = comboBoxRol.getSelectedItem().toString();

            if (validarDatos.validateEmail(correo)) {

                perFuncionario = new Funcionario(nombre,apellidos,cedula,sexo,nacidoEn,direccion,telefono,correo,funcionario ,contrasenia,rol);
                //condicion del arreglo buscar el objeto con el codiog que se acaba de colocar

                if(buscarPersonaEmigrante(cedula)){
                    escribir("Hay otra persona registrada con el numero de cedula Cambie la Cedula de Identidad");
                }else{
                    System.out.println("LA PERSONA A REGISTRARSE ES: ");

                    listaFuncionario.insertarAlFinal(perFuncionario);
                    System.out.println(perFuncionario.toString());
                    
                    //obj.grabar();
                    //actualizar();
                   limpiar();
                   escribir("persona registrada exitosamente");
                }
            }else{
                escribir("correo invalido");
            }    
        }else{
            escribir("la cedula de identidad exede los 7 digitos");
        }    
    }

    public void consultar(){
       
        long obtenidoCedula;
        long cedula = Long.parseLong(textFildCi.getText());
        System.out.println("########## El numero a buscar  : "+cedula);
        int i=0;

        // while(i<=listaFuncionario.getTamanio()){
        if (buscarPersonaEmigrante(cedula)) {

            for(Funcionario objEmigrante:listaFuncionario){
                    // System.out.println(i);
                    // Funcionario objEmigrante = listaFuncionario.get(i);

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
                        String telefono = String.valueOf(objEmigrante.getTelefono());
                        String correo   = objEmigrante.getCorreo();

                        String usuario  = objEmigrante.getNombreUsuario();
                        String contrasenia    = objEmigrante.getContrasenia();
                        String rol      = objEmigrante.getRol();

                        textNombre.setText(nombre);
                        textApellidos.setText(apellidos);
                        textCedula.setText(carnet);
                        textNacidoEn.setText(nacidoEn);
                        textDireccion.setText(direccion);
                        textTelefono.setText(telefono);
                        textCorreo.setText(correo);
                        
                        textNombreUsuario.setText(usuario);        
                        textContrasenia.setText(contrasenia);        

                        if(rol.equalsIgnoreCase("Seleccionar")){
                            comboBoxSexo.setSelectedIndex(0);
                        }else if(rol.equalsIgnoreCase("administrador")){
                            comboBoxSexo.setSelectedIndex(1);
                        }else if(rol.equalsIgnoreCase("usuario")){
                            comboBoxSexo.setSelectedIndex(2);
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
                String convirtiendo2=textTelefono.getText();
                long telefono =   Long.parseLong(convirtiendo2);
                String correo   = textCorreo.getText();

                String funcionario = textNombreUsuario.getText();
                String contrasenia    = textContrasenia.getText();
                String rol   = comboBoxRol.getSelectedItem().toString();

                if (validarDatos.validateEmail(correo)) {

                    perFuncionario = new Funcionario(nombre,apellidos,cedula,sexo,nacidoEn,direccion,telefono,correo,funcionario ,contrasenia,rol);
                    
                    if(!buscarPersonaEmigrante(cedula)){
                        listaFuncionario.insertarAlFinal(perFuncionario);
                    }else{
                        for(Funcionario objEmigrante:listaFuncionario){
                            long ci = objEmigrante.getCedula();
                            if (ci==cedula) {
                                int indice = listaFuncionario.getIndice(objEmigrante);
                                System.out.println("el indice antes de modificar"+indice);
                                listaFuncionario.set(indice,perFuncionario);                    
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

    public void limpiar(){
        textNombre.setText("");
        textApellidos.setText("");
        textCedula.setText("");
        comboBoxSexo.setSelectedIndex(0);
        textNacidoEn.setText("");
        textDireccion.setText("");
        textTelefono.setText("");
        textCorreo.setText("");
        
        textNombreUsuario.setText("");        
        textContrasenia.setText("");        
        comboBoxRol.setSelectedIndex(0);        
    }

    public boolean buscarPersonaEmigrante(long cedula){

        boolean encontrado =false;
        int i=0;
        while(encontrado == false && i<listaFuncionario.getTamanio()){
            if (listaFuncionario.get(i).getCedula() == cedula) {
                encontrado=true;
            }else{
                i++;
            }
        }
        return encontrado;    
    }

    public void borrar(){
        long op = Long.parseLong(JOptionPane.showInputDialog("Cedula de Empleado a borrar : "));

        if(!buscarPersonaEmigrante(op)){
            escribir("Empleado no existe");
        }else{
            for(Funcionario objEmigrante:listaFuncionario){
                    System.out.println("entroo al for De busqueda");
             
                    if (objEmigrante.getCedula() == op) {
                        System.out.println("##### persona A ELIMINAR ES #####:"+objEmigrante.toString());

                        int i = JOptionPane.showConfirmDialog(null,"Estas seguro de borrar...");
                        if(i==0){           
                            listaFuncionario.eliminar(listaFuncionario.getIndice(objEmigrante));
                            escribir("Empleado eliminado exitosamente!");
                        }else if(i==1){
                            escribir("Vuela a intentarlo");
                        }
                    }    

            } 

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

        String usuario      = textNombreUsuario.getText();
        String contrasenia  = textContrasenia.getText();
        String rol          = comboBoxRol.getSelectedItem().toString();

        return validarDatos.validaDatosEmpleado(nombre,apellidos,cedula,sexo,nacidoEn,direccion,telefono,correo,usuario,contrasenia,rol);
    }
    public boolean validarBusqueda(){
        String busqueda = textFildCi.getText();
        return validarDatos.validarCampoBusqueda(busqueda);
    }
    
}
