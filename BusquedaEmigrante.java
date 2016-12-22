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


public class BusquedaEmigrante extends JPanel{

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

    private JPanel panelBusqueda;

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

    private JComboBox comboBoxOrigen;
    private JComboBox comboBoxDestino;
    private JTextField textEmigranteSiNo;
    private JTextField textFecha;
    private JComboBox comboBoxMotivoDeMigracion;
    //BtnsModificarEmigrar
    private JButton btnModificar;

    //panel Cabecera
    private JButton btnBuscar;
    private JLabel labelTituloBusq;
    private JLabel lablIngreseCi;
    private JTextField textFildCi;

    //datosPersonales  

    RegistroEmigrante listaRegistroPersonaEmigrante;  
    // Lista<PersonaEmigrante> otraLista;
    
    // Borrame listaRegistroPersonaEmigrante;  
    // RegistroEmigrante lis;  

    // String fileName = "serial.txt";

    // DeserializableGenerico<Lista> deser_gen; 

    public BusquedaEmigrante(){
        inicializarBusquedaEmigrante();

        listaRegistroPersonaEmigrante = new RegistroEmigrante();
        // System.out.println("esto busco :"+listaRegistroPersonaEmigrante.listaPersonaEmigrante.getTamanio());

        // otraLista = listaRegistroPersonaEmigrante.listaPersonaEmigrante;
        // System.out.println("tmanio de la listaaaaaaa" + otraLista.getTamanio());
        // // listaRegistroPersonaEmigrante = new Borrame();
        // lis = new RegistroEmigrante();

        // System.out.println("esto es de borrame $$$$$$"+lis.prueba.getTamanio());
        
        // deser_gen = new DeserializableGenerico<Lista>(fileName);

        // Lista<PersonaEmigrante> new_data = deser_gen.deserialize();
        // System.out.println("entrando al for de deserializacion");
        // for (PersonaEmigrante person: new_data) {
        //     System.out.println(person.toString());
        // }
    
    }

    

    private void inicializarBusquedaEmigrante(){
       

        panelCabecera = new JPanel();
        panelCuerpo = new JPanel();
        panelPie = new JPanel();

        panelCuerpoDatosPersonales = new JPanel();
        panelCuerpoDatosEmigrante = new JPanel();

        panelCuerpoDatosPersonalesContenido = new JPanel();
        panelCuerpoDatosPersonalesCabecera = new JPanel();

        panelCuerpoDatosEmigranteContenido = new JPanel();
        panelCuerpoDatosEmigranteCabecera = new JPanel();

        panelCentro = new JPanel();

        panelBusqueda = new JPanel();

        tituloPrincipal = new JLabel();
        tituloDatosPersonales = new JLabel();
        tituloDatosEmigrante = new JLabel();

        btnModificar = new JButton();


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

        //panel cabecera
        btnBuscar = new JButton();
        labelTituloBusq = new JLabel();
        lablIngreseCi = new JLabel();
        textFildCi = new JTextField();

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

        btnModificar = new JButton();

        btnModificar.setText("Modificar/Emigrar");

        panelPie.setLayout(new FlowLayout());
        panelPie.add(btnModificar);

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

        labelTituloBusq.setText("                                                                             Busqueda de Ciudadano      ");

        lablIngreseCi.setText("                     Ingrese su Cedula de Identidad  ");

        textFildCi.setText("        ");

        btnBuscar.setText("btnBuscar");

        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        panelBusqueda.setLayout(new FlowLayout());
        panelBusqueda.add(labelTituloBusq);
        panelBusqueda.add(lablIngreseCi);
        panelBusqueda.add(textFildCi);
        panelBusqueda.add(btnBuscar);

        panelBusqueda.setMaximumSize(new java.awt.Dimension(700, 80));
        panelBusqueda.setMinimumSize(new java.awt.Dimension(700, 80));
        panelBusqueda.setPreferredSize(new java.awt.Dimension(700, 80));

        panelBusqueda.setSize(1000,100);
        panelBusqueda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));



        tituloPrincipal =  new JLabel("REGISTRO DE EMIGRANTES");

        panelCabecera.setLayout(new FlowLayout());
        panelCabecera.add(tituloPrincipal);

        panelPie.setMaximumSize(new java.awt.Dimension(500, 100));
        panelPie.setMinimumSize(new java.awt.Dimension(500, 100));
        panelPie.setPreferredSize(new java.awt.Dimension(500, 100));

        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.add(panelBusqueda);
        this.add(panelCabecera);
        this.add(panelCuerpo);
        this.add(panelPie);

        this.setBorder(BorderFactory.createLineBorder(new Color(10, 100, 0)));
        this.setMaximumSize(new Dimension(1100, 600));
        this.setMinimumSize(new Dimension(1100, 600));
        this.setPreferredSize(new Dimension(1100, 600));

    }

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {
        // System.out.println("tmanio de la listaa #### : " + listaRegistroPersonaEmigrante.tamanioLista());
        this.m_consultar();
    }

    public void m_consultar(){
       
        long obtenidoCedula;
        long cedula = Long.valueOf(textFildCi.getText()).longValue();



        System.out.println("numero a buscar"+cedula);
        
        int i=0;

        // listaRegistroPersonaEmigrante.holamundo();
    
        // System.out.println("tmanio de la lista : " + listaRegistroPersonaEmigrante.tamanioLista());

        while(i<=listaRegistroPersonaEmigrante.listaPersonaEmigrante.getTamanio()){
        // for(PersonaEmigrante emigrante:listaRegistroPersonaEmigrante.lista){
                System.out.println(i);
                PersonaEmigrante emigrante = listaRegistroPersonaEmigrante.listaPersonaEmigrante.get(i);

                System.out.println("entroo al for De busqueda");
         
                // obtenidoCedula = emigrante.getCedula();

                // if (obtenidoCedula == cedula) {

                //     System.out.println("persona encontrada"+emigrante.toString());

                //     String nombre   = emigrante.getNombre();
                //     String apellidos= emigrante.getApellidos();
                //     String carnet   = String.valueOf(emigrante.getCedula());
                //     String sexo     = emigrante.getSexo();
                //     String nacidoEn = emigrante.getNacidoEn();
                //     String direccion= emigrante.getDireccion();
                //     String telefono = emigrante.getTelefono();
                //     String correo   = emigrante.getCorreo();

                //     String esEmigrante= emigrante.getEmigranteSiNo();
                //     String fecha    = emigrante.getFecha();
                //     String origen   = emigrante.getOrigen();
                //     String destino  = emigrante.getDestino();
                //     String motivo   = emigrante.getMotivoDeMigracion();

                //     textNombre.setText(nombre);
                //     textApellidos.setText(apellidos);
                //     textCedula.setText(carnet);
                //     textNacidoEn.setText(nacidoEn);
                //     textDireccion.setText(direccion);
                //     textTelefono.setText(telefono);
                //     textCorreo.setText(correo);
                    
                //     textEmigranteSiNo.setText(esEmigrante);        
                //     textFecha.setText(fecha);        

                //     if(sexo.equalsIgnoreCase("masculino")){
                //         comboBoxSexo.setSelectedIndex(1);
                //     }else if(sexo.equalsIgnoreCase("femenino")){
                //         comboBoxSexo.setSelectedIndex(2);
                //     }                    
                //     if(origen.equalsIgnoreCase("cochabamba")){
                //         comboBoxOrigen.setSelectedIndex(1);
                //     }else if(origen.equalsIgnoreCase("tarija")){
                //         comboBoxOrigen.setSelectedIndex(2);
                //     }
                //     if(destino.equalsIgnoreCase("cochabamba")){
                //         comboBoxDestino.setSelectedIndex(1);
                //     }else if(destino.equalsIgnoreCase("tarija")){
                //         comboBoxDestino.setSelectedIndex(2);
                //     }else if(destino.equalsIgnoreCase("pando")){
                //         comboBoxDestino.setSelectedIndex(3);
                //     }
                //     if(motivo.equalsIgnoreCase("Economico")){
                //         comboBoxMotivoDeMigracion.setSelectedIndex(1);
                //     }else if(motivo.equalsIgnoreCase("Trabajo")){
                //         comboBoxMotivoDeMigracion.setSelectedIndex(2);
                //     }else if(motivo.equalsIgnoreCase("Estudios")){
                //         comboBoxMotivoDeMigracion.setSelectedIndex(3);
                //     }else{
                //          System.out.println("se mostro");
                //     }
                // } 
                // else{
                //     escribir("cedula no encontrada");
                // }
            i++;
        }

        System.out.println("pasando el for de busqueda");                
    }


    public void escribir(String texto){
        JOptionPane.showMessageDialog(this, texto);
    }        

    // public void registrar(){

    //     PersonaEmigrante listaPersonaEmigrante = new PersonaEmigrante();

        
    //     String nombre     = textNombre.getText();
    //     String apellidos  = textApellidos..getText();
    //     int    cedula     = Integer.parseInt(textCedula.getText());
    //     String sexo       = comboBoxSexo.getSelectedItem().toString();
    //     String nacidoEn   = textNacidoEn.getText();
    //     String direccion  = textDireccion.getText();
    //     String telefono   = textTelefono.getText();
    //     String correo     = textCorreo.getText();

    //     open = new Persona(nombre,apellidos,cedula,sexo,nacidoEn,direccion,telefono,correo);
    //     //condicion del arreglo buscar el objeto con el codiog que se acaba de colocar
    //     if(this.buscar(open.getCedula()) != -1){
    //         escribir("El codigo del empleado ya existe");
    //     }else{
    //         listaPersona.insertarAlFinal(open);
    //         insertar(co,nomb,ht,pa,ph,pu,mo,pla,bo,des,monto);
    //         obj.grabar();
    //         actualizar();
    //         limpiar();
    //     }
    // }
    // public int buscar(String codigo){
    //     int n = listaPersona.getTamanio();
    //     for(int p=0; p<n; p++)
    //     {
    //         if(codigo.equalsIgnoreCase(listaPersona.get(p).getCedula()))
    //         {
    //             return p;
    //         }
    //     }
    //     return -1;
    // }
    // private void botonLimpiarActionPerformed(ActionEvent event){
    //             textNombre.setText("");
    //             textApellidos.setText("");
    //             textCedula.setText("");
    //             textNacidoEn.setText("");
    //             textDireccion.setText("");
    //             textTelefono.setText("");            
    //         }s

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