//package vista;

//import modelo.Funcionario;
//import modelo.listaCDE.Lista;
//import controlador.ControlPrincipal;
//import modelo.serializacion.SerializableGenerico;
//import modelo.serializacion.DeserializableGenerico;


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
    private JButton btnBorrar;
    static public JButton btnPrueba;

    //datosPersonales


    Funcionario perFuncionario;
    
    Lista<Funcionario> listaFuncionario;   //lista    
    // Serializable obj;     

    String fileName = "/home/xenial/proyectos/java/TallerDeProgramacionJava/funcionarios.ser"; 

    SerializableGenerico<Lista> ser_gen; 
    DeserializableGenerico<Lista> deser_gen;  

    // Lista<Funcionario> prueba;

    public PestaniaFuncionarios(){ 

        System.out.println("Inicializa el programa");    
        
        // deser_gen = new DeserializableGenerico<Lista>(fileName);

        // Lista<Funcionario> new_data = deser_gen.deserialize();

        // listaFuncionario = new_data;
        
        // for (Funcionario person: new_data) {
        //     System.out.println("entro al for de desserializacion");
        //     System.out.println(person.toString());
        // }

        inicializarRegistroFuncionario();
        // obj = new Serializable();
        // obj.cargaDatos();    
    }   

        
    private void inicializarRegistroFuncionario(){

        listaFuncionario = new Lista<Funcionario>(); 

        ser_gen = new SerializableGenerico<Lista>(fileName,listaFuncionario);

        deser_gen = new DeserializableGenerico<Lista>(fileName);


        

        System.out.println("llegoHasta aki 1 PestaniaFuncionarios");
        // if (deser_gen.deserialize()!=null) {
        //     listaFuncionario = deser_gen.deserialize();
        // }
        System.out.println("llegoHasta aki 2 PestaniaFuncionarios");

    
        
        // prueba =  new Lista<Funcionario>(); 

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

        //Datos funcionario 

        tituloDatosEmigrante = new JLabel();

        labelNombreUsuario = new JLabel();
        labelContrasenia = new JLabel();
        labelRol = new JLabel();

        textNombreUsuario = new JTextField();
        textContrasenia = new JTextField();
        comboBoxRol = new JComboBox();

        tituloDatosEmigrante.setText(" DATOS DEL USUARIO ");

        labelNombreUsuario.setText("Nombre de Usuario");
        labelContrasenia.setText("Contrasenia");
        labelRol.setText("Rol");

        textNombreUsuario.setText("");
        textContrasenia.setText("");
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
        btnPrueba    = new JButton();

        btnRegistrar.setText("REGISTRAR");
        btnModificar.setText("MODIFICAR");
        btnBorrar.setText("BORRAR");
        btnPrueba.setText("prueba");


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
        panelPie.add(btnPrueba);

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
        for(Funcionario objEmigrante:listaFuncionario){
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
    //     btnPrueba.addActionListener(c);
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

        String funcionario = textNombreUsuario.getText();
        String contrasenia    = textContrasenia.getText();
        String rol   = comboBoxRol.getSelectedItem().toString();

        perFuncionario = new Funcionario(nombre,apellidos,cedula,sexo,nacidoEn,direccion,telefono,correo,funcionario ,contrasenia,rol);
        //condicion del arreglo buscar el objeto con el codiog que se acaba de colocar

        if(buscarPersonaEmigrante(cedula)){
            escribir("Hay otra persona registrada con el numero de cedula Cambie la Cedula de Identidad");
        }else{
            System.out.println("LA PERSONA A REGISTRARSE ES: ");

            listaFuncionario.insertarAlFinal(perFuncionario);
            System.out.println(perFuncionario.toString());
            
            System.out.println("funcionario  AGREGADO ALA LISTA");
            // obj.grabar();
            

            // System.out.println("grabado en el archivo  binario");
            // actualizar();
           limpiar();
        }
        System.out.println("llamando al tamanioLista : "+listaFuncionario.getTamanio());
    }

    public void consultar(){
       
        long obtenidoCedula;
        long cedula = Long.parseLong(textFildCi.getText());

        System.out.println("########## El numero a buscar  : "+cedula);
        
        int i=0;

        System.out.println("tmanio de la lista : " + listaFuncionario.getTamanio());

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
                        String telefono = objEmigrante.getTelefono();
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

                        if(rol.equalsIgnoreCase("administrador")){
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
        int op = JOptionPane.showConfirmDialog(null,"Deves consultar primero \nDeseas consultar ahora presiona <Si>\nSi ya consultastes presionsa <No>");//confirmacion
        if(op==0){
            consultar();
        }else if(op==1){ //si a puesto opcion no modificar el objeto en el cual nosotros ayamos modificado
            int n = listaFuncionario.getTamanio();
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

                String funcionario = textNombreUsuario.getText();
                String contrasenia    = textContrasenia.getText();
                String rol   = comboBoxRol.getSelectedItem().toString();

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
        long op = Long.parseLong(JOptionPane.showInputDialog("Codigo a borrar : "));

        if(!buscarPersonaEmigrante(op)){
            escribir("Codigo no existe");
        }else{
            for(Funcionario objEmigrante:listaFuncionario){
                    System.out.println("entroo al for De busqueda");
             
                    if (objEmigrante.getCedula() == op) {
                        System.out.println("##### persona A ELIMINAR ES #####:"+objEmigrante.toString());

                        int i = JOptionPane.showConfirmDialog(null,"Estas seguro de borrar...");
                        if(i==0){           
                            listaFuncionario.eliminar(listaFuncionario.getIndice(objEmigrante));
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