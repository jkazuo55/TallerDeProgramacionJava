import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ControlPrincipal implements ActionListener {

	private VentanaPrincipal vista;
	private ModeloPrincipal modelo;
	
	public ControlPrincipal(VentanaPrincipal vista, ModeloPrincipal modelo){
		this.vista = vista;
		this.modelo = modelo;
	}
	public void actionPerformed(ActionEvent evento) {
		// double cantidad = vista.getCantidad();
		// if ( evento.getActionCommand().equals(VentanaPrincipal.AEUROS) ) {
		// 	vista.escribeCambio( cantidad + " pesetas son: " + modelo.pesetasAeuros(cantidad) + " euros" );
		// }
		// else if ( evento.getActionCommand().equals(VentanaPrincipal.APESETAS)) {
		// 	vista.escribeCambio( cantidad + " euros son: "+ modelo.eurosApesetas(cantidad) + " pesetas" );
		// }
		// else
		// 	vista.escribeCambio( "ERROR" );
	}
}