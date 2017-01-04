//package controlador;

//import modelo.Modelo;
//import modelo.listaCDE.Lista;
//import vista.VentanaPrincipal;

public class GestionDeMigracion {
	public void iniciarSistema() {
		// el modelo:
		Modelo modelo = new Modelo();
		// la vista:
		VentanaPrincipal vista = new VentanaPrincipal();
		VentanaLogin login = new VentanaLogin(vista,true);
		// y el control:
		Controlador control = new Controlador ();

		//Relacionamos las clases con el control
		vista.setControlador(control);
		login.setControlador(control);
		modelo.setControlador(control);
		//Relacionamos el control con las clases
		control.setModeloPrincipal(modelo);
		control.setVentanaPrincipal(vista);
		control.setVentanaPrincipal(login);
		// configura la vista
		// vista.setControlador(control);
		// y arranca la interfaz (vista):

		// vista.arranca();
		control.arranca();
	}
}