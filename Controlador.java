//package controlador;

//import vista.VentanaPrincipal;
//import modelo.Modelo;


import javax.swing.*;
import java.awt.*;
// import java.awt.event.*;

public class Controlador{

	private VentanaPrincipal vista;
	private Modelo modelo;
	private VentanaLogin login;

	public Controlador(){

	}	
	public Controlador(VentanaPrincipal vista, Modelo modelo){
		this.vista = vista;
		this.modelo = modelo;
	}
	
	public void setVentanaPrincipal(VentanaPrincipal vista){
		this.vista=vista;
	}
	public void setVentanaPrincipal(VentanaLogin login){
		this.login=login;
	}
	public void setModeloPrincipal(Modelo modelo){
		this.modelo=modelo;
	}



	public String validarIngreso(int index,String pass){
		return modelo.validarIngreso(index,pass);
	}
	public void cerrarVentanaLogin(){
		login.dispose();
	}
	
	public void asignarPrivilegios(String usuario){
		vista.asignarPrivilegios(usuario);
	}

	public void mostrarLogin(){
		login.setVisible(true);
		System.out.println("mostrandoVentanaLogin");
	}

	public void arranca() {
	    // visualiza la vista
	    // login = new VentanaLogin(vista,true);
	    // try {
	    //     for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
	    //         if ("Nimbus".equals(info.getName())) {
	    //             javax.swing.UIManager.setLookAndFeel(info.getClassName());
	    //             break;
	    //         }
	    //     }
	    // } catch (ClassNotFoundException ex) {
	    //     java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	    // } catch (InstantiationException ex) {
	    //     java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	    // } catch (IllegalAccessException ex) {
	    //     java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	    // } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	    //     java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	    // }

	    java.awt.EventQueue.invokeLater(new Runnable() {
	        public void run() {
	            // vista = new VentanaPrincipal();
	            // login = new VentanaLogin(vista,true);
	            vista.setVisible(true); //visualiza la vista
	            vista.setSize(1500, 900); //tamanio de la vista
	            vista.setLocationRelativeTo(null);// centra la vista en la pantalla
	            login.setVisible(true);
	        }
	    });    
	}
}