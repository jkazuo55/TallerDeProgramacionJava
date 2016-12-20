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

    private JPanel panelCabecera;
    private JPanel panelCuerpo;
    private JPanel panelPie;

    private JPanel panelCuerpoDatosPersonales;
    private JPanel panelCuerpoDatosEmigrante;

    private JPanel panelCuerpoDatosPersonalesContenido;
    private JPanel panelCuerpoDatosPersonalesCabecera;

    private JPanel panelCuerpoDatosEmigranteContenido;
    private JPanel panelCuerpoDatosEmigranteCabecera;

    private JPanel panelCentro;
    
    public JPanel panelTodo;

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
    //BtnsModificarEmigrar
    private JButton btnRegistrar;
    private JButton btnLimpiar;

    //datosPersonales

    PersonaEmigrante perEmigrante;
    
    Lista<PersonaEmigrante> listaPersonaEmigrante;   //lista    
    // Serializable obj;     

    String fileName = "serial.txt"; 

    SerializableGenerico<Lista<PersonaEmigrante>> ser_gen; 
    DeserializableGenerico<Lista<PersonaEmigrante>> deser_gen;  

    Lista<PersonaEmigrante> prueba;

    public RegistroEmigrante(){   
        inicializarRegistroEmigrante();
        
        // aki();

        // ser_gen = new SerializableGenerico<Lista<PersonaEmigrante>>(fileName,listaPersonaEmigrante);
        // ser_gen.serialize();

        // deser_gen = new DeserializableGenerico<Lista<PersonaEmigrante>>(fileName);

        // Lista<PersonaEmigrante> new_data = deser_gen.deserialize();

        // for (PersonaEmigrante person: new_data) {
        //     System.out.println("entro al for de desserializacion");
        //     System.out.println(person.toString());
        // }

        // obj = new Serializable();
        // obj.cargaDatos();
    }   

        
    private void inicializarRegistroEmigrante(){
        listaPersonaEmigrante = new Lista<PersonaEmigrante>(); 
        prueba =  new Lista<PersonaEmigrante>(); 

        panelCabecera = new JPanel();
        panelCuerpo = new JPanel();
        panelPie = new JPanel();

        panelTodo = new JPanel();

        panelCuerpoDatosPersonales = new JPanel();
        panelCuerpoDatosEmigrante = new JPanel();

        panelCuerpoDatosPersonalesContenido = new JPanel();
        panelCuerpoDatosPersonalesCabecera = new JPanel();

        panelCuerpoDatosEmigranteContenido = new JPanel();
        panelCuerpoDatosEmigranteCabecera = new JPanel();

        panelCentro = new JPanel();

        tituloPrincipal = new JLabel();
        tituloDatosPersonales = new JLabel();
        tituloDatosEmigrante = new JLabel();

        btnRegistrar = new JButton();
        btnLimpiar = new JButton();


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
        panelCuerpoDatosPersonales.setMinimumSize(new java.awt.Dimension(500, 100));
        panelCuerpoDatosPersonales.setPreferredSize(new java.awt.Dimension(500, 100));
        panelCuerpoDatosPersonales.setLayout(new BoxLayout(panelCuerpoDatosPersonales,BoxLayout.Y_AXIS));
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

        //Botones

        btnRegistrar = new JButton();
        btnLimpiar = new JButton();

        btnRegistrar.setText("Emigrar/Registrar");

        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");

        panelPie.setLayout(new FlowLayout());
        panelPie.add(btnRegistrar);
        panelPie.add(btnLimpiar);

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
        
        //General

        tituloPrincipal =  new JLabel("REGISTRO DE EMIGRANTES");

        panelCabecera.setLayout(new FlowLayout());
        panelCabecera.add(tituloPrincipal);

        panelPie.setMaximumSize(new java.awt.Dimension(500, 100));
        panelPie.setMinimumSize(new java.awt.Dimension(500, 100));
        panelPie.setPreferredSize(new java.awt.Dimension(500, 100));

        panelTodo.setLayout(new BoxLayout(panelTodo,BoxLayout.Y_AXIS));
        panelTodo.add(panelCabecera);
        panelTodo.add(panelCuerpo);
        panelTodo.add(panelPie);

        panelTodo.setBorder(BorderFactory.createLineBorder(new Color(10, 100, 0)));
        panelTodo.setMaximumSize(new Dimension(1100, 600));
        panelTodo.setMinimumSize(new Dimension(1100, 600));
        panelTodo.setPreferredSize(new Dimension(1100, 600));

    }

    // public void aki (){

    //     persona1 = new PersonaEmigrante("nombre","apellidos",12321,"sexo","nacidoEn","direccion","telefono","correo","emigrante","fecha","origen","destino","motivo");
    //     persona2 = new PersonaEmigrante("nombre","apellidos",12321,"sexo","nacidoEn","direccion","telefono","correo","emigrante","fecha","origen","destino","motivo");
    //     persona3 = new PersonaEmigrante("nombre","apellidos",123,"sexo","nacidoEn","direccion","telefono","correo","emigrante","fecha","origen","destino","motivo");
    //     persona4 = new PersonaEmigrante("nombre","apellidos",12321,"sexo","nacidoEn","direccion","telefono","correo","emigrante","fecha","origen","destino","motivo");
    //     persona5 = new PersonaEmigrante("nombre","apellidos",12321,"sexo","nacidoEn","direccion","telefono","correo","emigrante","fecha","origen","destino","motivo");

    //     prueba.insertarAlFinal(persona1);
    //     prueba.insertarAlFinal(persona2);
    //     prueba.insertarAlFinal(persona3);
    //     prueba.insertarAlFinal(persona4);
    //     prueba.insertarAlFinal(persona5);

    // }

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {
        guardar();
        System.out.println("RegistroExitoso");
    }


    public void escribir(String texto){
        JOptionPane.showMessageDialog(panelTodo, texto);
    }


    public void setControlador(ControlPrincipal c) {
        btnRegistrar.addActionListener(c);
        btnLimpiar.addActionListener(c);
    }

    public void guardar(){

        String nombre   = textNombre.getText();
        String apellidos= textApellidos.getText();
        long   cedula   = Integer.parseInt(textCedula.getText());
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
            escribir("El codigo del empleado ya existe");
        }else{
            System.out.println("LA PERSONA A REGISTRARSE ES: ");

            listaPersonaEmigrante.insertarAlFinal(perEmigrante);
            System.out.println(perEmigrante.toString());
            
            System.out.println("EMIGRANTE AGREGADO ALA LISTA");
            // obj.grabar();
            

            // System.out.println("grabado en el archivo  binario");
            // actualizar();
           // limpiar();
        }
        System.out.println("tmanio de la lista de registro: " + listaPersonaEmigrante.getTamanio());
        System.out.println("llamando al tamanioLista : "+tamanioLista());
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

    public int tamanioLista(){
        System.out.println("antes del return en tamanioLista :"+listaPersonaEmigrante.getTamanio());
        return listaPersonaEmigrante.getTamanio();
    }

    public void holamundo(){
        System.out.println("holamundo");
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
                
    //             if (textNombre.getText().length()>=12) {
    //                 event.consume();
    //             }

    //             char tipoDeLetra = event.getKeyChar();
    //             if (Character.isDigit(tipoDeLetra)) {
    //                 event.consume();
    //             }
    //         }
}