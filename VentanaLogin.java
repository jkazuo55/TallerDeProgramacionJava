import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Image;
import javax.imageio.ImageIO;


import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class VentanaLogin extends JDialog implements ActionListener{
    private javax.swing.JButton botonAceptar;
    private JTextField campoUser;
    private javax.swing.JPasswordField campoPass;
    private javax.swing.JComboBox comboUsuarios;
    private javax.swing.JLabel imagen;
    private javax.swing.JLabel labelRol;
    private javax.swing.JLabel labelUser;
    private javax.swing.JLabel labelPass;
    private javax.swing.JLabel tituloLogin;
    private javax.swing.JPanel panelLogin;
    private javax.swing.JPanel panelTitulo;
    private javax.swing.JPanel panelImagen;
    private javax.swing.JPanel panelOpciones;
    private javax.swing.JPanel panelAceptar;
    private javax.swing.JLabel labelImagen;
    private Controlador control;
    
    public VentanaLogin(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Login");
        setSize(500,600);
        setLocationRelativeTo(null);
        setResizable(false);
        
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        
        addWindowListener(new WindowAdapter() {
        	
        	@Override
        	public void windowClosing(WindowEvent e) {
        		Object[] options = {"Continuar", "Cerrar"};
            	int n = JOptionPane.showOptionDialog(null,
                        "Seleccione un tipo de Usuario.\nSi sale el sistema se Cerrara","Confirmacion",JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE,null,options,options[0]);
		       
            	if (n == JOptionPane.YES_OPTION){}
		        else if (n == JOptionPane.NO_OPTION) 
		        {
		        	System.exit(0);//Cerrar todo el sistema
		        }
        	}
        });
  
    }

    private void initComponents() {

        panelLogin = new javax.swing.JPanel();
        panelTitulo = new javax.swing.JPanel();
        panelImagen = new javax.swing.JPanel();
        panelOpciones = new javax.swing.JPanel();
        panelAceptar = new javax.swing.JPanel();

        tituloLogin = new javax.swing.JLabel();
        imagen = new javax.swing.JLabel();
        labelRol = new javax.swing.JLabel();
        labelUser = new javax.swing.JLabel();
        labelPass = new javax.swing.JLabel();
        ImageIcon imageBoton = new ImageIcon("imagenes/login_opt.png");
        botonAceptar = new javax.swing.JButton(imageBoton);
        comboUsuarios = new javax.swing.JComboBox();
        campoUser = new JTextField();
        campoPass = new javax.swing.JPasswordField();

        labelImagen= new JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        // panelLogin.setBackground(new java.awt.Color(204, 204, 204));
        panelLogin.setLayout(null);

        
        tituloLogin.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        tituloLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);        
        tituloLogin.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tituloLogin.setText("Ventana Login");        
        panelTitulo.setLayout(new FlowLayout());
        panelTitulo.add(tituloLogin);
        panelTitulo.setMaximumSize(new java.awt.Dimension(400, 150));
        panelTitulo.setMinimumSize(new java.awt.Dimension(400, 150));
        panelTitulo.setPreferredSize(new java.awt.Dimension(400, 150));

        Image imagen= new ImageIcon("imagenes/candado1.png").getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);

        labelImagen.setIcon(new ImageIcon(imagen));
        labelImagen.setMaximumSize(new java.awt.Dimension(400, 200));
        labelImagen.setMinimumSize(new java.awt.Dimension(400, 200));
        labelImagen.setPreferredSize(new java.awt.Dimension(400, 200));

        labelImagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        // imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/candado.png"))); 
        // imagen.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        panelImagen.setLayout(new FlowLayout());
        panelImagen.add(labelImagen);

        panelImagen.setMaximumSize(new java.awt.Dimension(400, 200));
        panelImagen.setMinimumSize(new java.awt.Dimension(400, 200));
        panelImagen.setPreferredSize(new java.awt.Dimension(400, 200));

        labelRol.setText("ROL :");
        labelUser.setText("USUARIO :");
        labelUser.setVisible(false);
        labelPass.setText("CONTRASENIA :");
        labelPass.setVisible(false);
        // // botonAceptar.setText("ACEPTAR");
        // Image img = ImageIO.read(getClass().getResource("/home/xenial/proyectos/java/TallerDeProgramacionJava/imagenes/login.png"));
        // botonAceptar.setIcon(new ImageIcon(img));

        botonAceptar.addActionListener(this);
        comboUsuarios.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "Administrador", "Usuario"}));
        comboUsuarios.addActionListener(this);        
        campoUser.setVisible(false);
        campoPass.setVisible(false);

        panelOpciones.setLayout(new GridLayout(3,3));
        panelOpciones.add(labelRol);
        panelOpciones.add(comboUsuarios);
        panelOpciones.add(labelUser);
        panelOpciones.add(campoUser);
        panelOpciones.add(labelPass);
        panelOpciones.add(campoPass);
        // panelOpciones.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 255)));

        panelOpciones.setMaximumSize(new java.awt.Dimension(400, 150));
        panelOpciones.setMinimumSize(new java.awt.Dimension(400, 150));
        panelOpciones.setPreferredSize(new java.awt.Dimension(400, 150));

        panelAceptar.setLayout(new FlowLayout());
        panelAceptar.add(botonAceptar);
        botonAceptar.setMaximumSize(new java.awt.Dimension(150, 45));
        botonAceptar.setMinimumSize(new java.awt.Dimension(150, 45));
        botonAceptar.setPreferredSize(new java.awt.Dimension(150, 45));

        panelLogin.setLayout(new BoxLayout(panelLogin,BoxLayout.Y_AXIS));
        panelLogin.add(panelTitulo);
        panelLogin.add(panelImagen);
        panelLogin.add(panelOpciones);
        panelLogin.add(panelAceptar);

        getContentPane().add(panelLogin);
        panelLogin.setBounds(0, 0, 500, 550);

        pack();
    }                       

            
    
	public void setControlador(Controlador control) {
		this.control=control;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent evento) {
		if (evento.getSource()==comboUsuarios) {
			mostrarElementos();
		}

        if (evento.getSource()==botonAceptar) {
            String resp = control.validarIngreso(comboUsuarios.getSelectedIndex(),campoUser.getText(),campoPass.getText());
            System.out.println(resp);
                			
    		if (resp.equals("error")) {
    				JOptionPane.showMessageDialog(null, "NO SE A SELECCIONADO UN USUARIO","Advertencia",JOptionPane.WARNING_MESSAGE);
    		}else{
    			if (resp.equals("invalido")) {
    				JOptionPane.showMessageDialog(null, "CONTRASENIA INCORRECTA","Advertencia",JOptionPane.WARNING_MESSAGE);
                    this.limpiar();
    			}else{
    				control.asignarPrivilegios(resp);
    				control.cerrarVentanaLogin();
    			}
    		}
    	}
    			
	}
	
	public void limpiar(){
		comboUsuarios.setSelectedIndex(0);
		campoPass.setText("");
	}

	private void mostrarElementos() {
		String seleccion=(String) comboUsuarios.getSelectedItem();
		int index=comboUsuarios.getSelectedIndex();
		
		if (index==0) {
            labelUser.setVisible(false);
			labelPass.setVisible(false);
            campoUser.setVisible(false);
			campoPass.setVisible(false);
		}else{
            labelUser.setVisible(true);
			labelPass.setVisible(true);
            campoUser.setVisible(true);
			campoPass.setVisible(true);
		}
	}
}

























