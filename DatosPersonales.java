import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;

public class DatosPersonales extends JPanel {

    private JLabel titulo;
    private JLabel labelNombre;
    private JLabel labelApellidos;
    private JLabel labelCedula;
    private JLabel labelSexo;
    private JLabel labelNacidoEn;
    private JLabel labelDireccion;
    private JLabel labelTelefono;
    private JLabel labelCorreo;

    private JPanel jpanelSuperior;
    private JPanel jpanelInferior;
    
    private JTextField textNombre;
    private JTextField textApellidos;
    private JTextField textCedula;
    private JComboBox comboBoxSexo;
    private JTextField textNacidoEn;
    private JTextField textDireccion;
    private JTextField textTelefono;
    private JTextField textCorreo;
    
    public DatosPersonales() {
        initComponents();
    }

    private void initComponents() {

        jpanelSuperior = new JPanel();
        jpanelInferior = new JPanel();
        
        titulo = new JLabel();
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

        titulo.setText("  DATOS PERSONALES ");

        labelNombre.setText("Nombre");
        labelApellidos.setText("Apellidos");
        labelCedula.setText("Cedula");
        labelSexo.setText("Sexo");
        labelNacidoEn.setText("Nacido En");
        labelDireccion.setText("Direccion");
        labelTelefono.setText("Telefono");
        labelCorreo.setText("Correo");

        textNombre.setText("textNombre");
        textApellidos.setText("textApellidos");
        textCedula.setText("textCedula");
        comboBoxSexo.addItem("Masculino");
        comboBoxSexo.addItem("Femenino");
        textNacidoEn.setText("textNacidoEn");
        textDireccion.setText("textDireccion");
        textTelefono.setText("telefono");
        textCorreo.setText("Correo");


        jpanelSuperior.setLayout(new FlowLayout());
        jpanelSuperior.add(titulo);    

        jpanelInferior.setLayout(new GridLayout(8,2));
        jpanelInferior.add(labelNombre);
        jpanelInferior.add(textNombre);
        jpanelInferior.add(labelApellidos);
        jpanelInferior.add(textApellidos);
        jpanelInferior.add(labelCedula);
        jpanelInferior.add(textCedula);
        jpanelInferior.add(labelSexo);
        jpanelInferior.add(comboBoxSexo);
        jpanelInferior.add(labelNacidoEn);
        jpanelInferior.add(textNacidoEn);
        jpanelInferior.add(labelDireccion);
        jpanelInferior.add(textDireccion);
        jpanelInferior.add(labelTelefono);
        jpanelInferior.add(textTelefono);
        jpanelInferior.add(labelCorreo);
        jpanelInferior.add(textCorreo);


        jpanelSuperior.setMaximumSize(new java.awt.Dimension(500, 30));
        jpanelSuperior.setMinimumSize(new java.awt.Dimension(500, 30));
        jpanelSuperior.setPreferredSize(new java.awt.Dimension(500, 30));

        jpanelInferior.setMaximumSize(new java.awt.Dimension(500, 350));
        jpanelInferior.setMinimumSize(new java.awt.Dimension(500, 350));
        jpanelInferior.setPreferredSize(new java.awt.Dimension(500, 350));

        this.setMaximumSize(new java.awt.Dimension(500, 100));
        this.setMinimumSize(new java.awt.Dimension(500, 100));
        this.setPreferredSize(new java.awt.Dimension(500, 100));
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.add(jpanelSuperior);
        this.add(jpanelInferior);         


        // this.setSize(100,100);
        this.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 50, 60)));
    }

    private void botonLimpiarActionPerformed(ActionEvent event){
        textNombre.setText("");
        textApellidos.setText("");
        textCedula.setText("");
        textNacidoEn.setText("");
        textDireccion.setText("");
        textTelefono.setText("");            
    }

    private void botonGuardarActionPerformed(ActionEvent event){
        if (textNombre.getText().equals("")) {
            JOptionPane.showMessageDialog(null,"por favor ingrese el nombre");
            return;
        }
        if (textApellidos.getText().equals("")) {
            JOptionPane.showMessageDialog(null,"por favor ingrese su apellido");
            return;
        }
        if (textCedula.getText().equals("")) {
            JOptionPane.showMessageDialog(null,"por favor ingrese el Cedula");
            return;
        }
        if (textNacidoEn.getText().equals("")) {
            JOptionPane.showMessageDialog(null,"por favor ingrese su lugar de Nacimiento");
            return;
        }
        if (textDireccion.getText().equals("")) {
            JOptionPane.showMessageDialog(null,"por favor ingrese su direccion");
            return;
        }
        if (textTelefono.getText().equals("")) {
            JOptionPane.showMessageDialog(null,"por favor ingrese su Telefono");
            return;
        }
    }

    private void txtNombreKeyTyped(java.awt.event.KeyEvent event){
        
        if (textNombre.getText().length()>=12) {
            event.consume();
        }

        char tipoDeLetra = event.getKeyChar();
        if (Character.isDigit(tipoDeLetra)) {
            event.consume();
        }
    }

    // String nombre,apellidos,cedula,nacidoEn,direccion,telefono,sexo;

    // nombre = textNombre.getText();
    // apellidos = textApellidos.getText();
    // cedula = textCedula.getText();
    // nacidoEn = textNacidoEn.getText();
    // direccion = textDireccion.getText();
    // telefono = textTelefono.getText();
    // sexo= "hombre";

    // Persona persona = new Persona(nombre,apellidos,cedula,nacidoEn,direccion,telefono,sexo);
    // ModeloPersona obj= ModeloPersona();
    // obj.guardarPersona(persona);

    // public void botonMostrarActionPerformed(ActionEvent event){
    //     JOptionPane.showMessageDialog(null,obj.mostrarlista);
    // }
}









