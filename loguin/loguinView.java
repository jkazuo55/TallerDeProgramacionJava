package loguin;

import java.awt.Color;
import java.awt.Font;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.*;
import java.awt.event.*;

public class loguinView extends JFrame {
	
	// El Objeto ImageIcon para la imagen
	JLabel mi_logo = new JLabel();	
	JLabel label1 = new JLabel();
	JLabel label2 = new JLabel();
	JLabel label3 = new JLabel();
	JLabel label4 = new JLabel();
	JLabel label5 = new JLabel();
	JLabel label6 = new JLabel();
	//ArrayList<loguin>register;
	 //register=new ArrayList<loguin>();
	
	//	Construimos los campos de texto
	private JTextField campo1 = new JTextField();
	//	Construimos el campo de texto para contrasenias
	private JPasswordField campo3 = new JPasswordField();
	//	Creamos un arreglo de objetos
	private String[] cadenas = {"Usuario", "Administrador"};	
	//	Creando un JComboBox, una lista desplegable
	private JComboBox combo = new JComboBox(cadenas);
	// Construimos otro botòn con el constructor que recibe el texto del boton
	private JButton ingresar = new JButton("INGRESAR");
	
	public loguinView() {
		super("Loguin");
		setLayout(null);		
		//getContentPane().setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 150, 355, 500);
		
		ajustarComponentes();
		anadirComponentes();
		anadirOyentes();
		
		setVisible(true);
		
	}
	
	private void ajustarComponentes(){
		//posicion del logo y escalamiento de la imagen
		mi_logo.setBounds(120,15,100,100);	
		Image i=new
			ImageIcon("C:/eclipse/Taller/src/imagen.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		mi_logo.setIcon(new ImageIcon(i));
		
		//valores para las etiquetas
		label1.setText("SISTEMA GESTION");
		label2.setText("DE EMIGRANTES");
		label3.setText("LOGUIN");
		label4.setText("User");
		label5.setText("Pasword");
		label6.setText("Rol");
				
		//estableciendo el color de fuente de la etiqueta
		//cambiando la fuente de la etiqueta
		label1.setFont(new Font("Courier", Font.BOLD, 30));
		label2.setFont(new Font("Courier", Font.BOLD, 30));
		label3.setFont(new Font("Courier", Font.BOLD, 25));
		label4.setFont(new Font("Arial", Font.PLAIN, 18));
		label5.setFont(new Font("Arial", Font.PLAIN, 18));
		label6.setFont(new Font("Arial", Font.PLAIN, 18));
				
		//posicion y tamanio
		label1.setBounds(30, 120, 300, 25);
		label2.setBounds(50, 150, 300, 25);
		label3.setBounds(130, 200, 120, 25);
		label4.setBounds(45, 250, 120, 25);
		label5.setBounds(10, 320, 120, 25);
		label6.setBounds(10, 390, 120, 25);
		
		/****	JTextField	****/		
		//	Un color de fondo para el campo1
		campo1.setBackground(Color.white);
		campo1.setBounds(100, 250, 200, 25);
		//campo1.setText("hola");
		
		//		El campo para contrasenias	
		campo3.setBackground(Color.white);
		campo3.setBounds(100, 320, 150, 25);
		
		/****	JComboBox	****/
		//	Estableciendo el item seleccionado
		combo.setSelectedIndex(0);
		//	Hacemos editable nuestra lista desplegable
		combo.setEditable(false);
		combo.setBounds(55, 390, 120, 25);
		
		//		Establecemos el color del texto del boton
		ingresar.setForeground(Color.blue);		
		//	Establecemos las posiciones y dimensiones del boton
		ingresar.setBounds(220, 390, 100, 25);
	}
	
	private void anadirComponentes(){
		//	Añadimos los componentes al contenedor principal
		add(mi_logo);
		add(label1);
		add(label2);
		add(label3);
		add(label4);
		add(label5);
		add(label6);
		add(campo1);
		add(campo3);
		add(combo);
		add(ingresar);
	}
	
	private void anadirOyentes(){
		OyenteBotones oyenteBotones = new OyenteBotones();
		ingresar.addActionListener(oyenteBotones);
		
		OyenteCombo oyenteCombo=new OyenteCombo();
		combo.addItemListener(oyenteCombo);
		
	}
	
	class OyenteBotones implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getSource() == ingresar){
				
				//String contraseña =campo3.getText();
				//campo1.setText(contraseña);
			}
			
		}
		
	}
	
	class OyenteCombo implements ItemListener{
		public void itemStateChanged(ItemEvent e){
			int ind=combo.getSelectedIndex();
			campo1.setText("valor: "+ind);
		}
	}

}