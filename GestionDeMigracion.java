public class GestionDeMigracion {

	public static void main(String[] args) {
		// el modelo:
		ModeloPrincipal modelo = new ModeloPrincipal();
		// la vista:
		VentanaPrincipal vista = new VentanaPrincipal();
		// y el control:
		ControlPrincipal control = new ControlPrincipal (vista,modelo);
		// configura la vista
		vista.setControlador(control);
		// y arranca la interfaz (vista):
		vista.arranca();
	}
}