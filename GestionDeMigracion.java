public class GestionDeMigracion {

	public void iniciarSistema() {
		// el modelo:
		Modelo modelo = new Modelo();
		GrafoND grafo = new GrafoND();
		// la vista:
		VentanaPrincipal vista = new VentanaPrincipal();
		VentanaLogin login = new VentanaLogin(vista,true);
		// y el control:
		Controlador control = new Controlador ();

		//Relacionamos las clases con el control
		vista.setControlador(control);
		login.setControlador(control);
		modelo.setControlador(control);
		vista.pestaniaEmigrante.setControlador(control);
		vista.pestaniaCiudad.setControlador(control);
		vista.pestaniaMapa.setControlador(control);
		//Relacionamos el control con las clases
		control.setModeloPrincipal(modelo);
		control.setVentanaPrincipal(vista);
		control.setVentanaPrincipal(login);
		control.setPanelRegistroEmigrante(vista.pestaniaEmigrante);
		control.setPestaniaCiudad(vista.pestaniaCiudad);
		control.setPestaniaMapa(vista.pestaniaMapa);
		control.setGrafo(grafo);
		
		// vista.arranca();
		control.arranca();
	}

}