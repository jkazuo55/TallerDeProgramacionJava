public class PersonaEntrante extends Persona{
	public String origen;
	public String fecha;

	public PersonaEntrante(String nombre, String cedula , String nacidoEn, String sexo, int edad,String origen, String fecha){
		super(nombre,cedula ,nacidoEn,sexo,edad);
		this.origen=origen;
		this.fecha=fecha;
	}
	public void setOrigen( String origen){
		this.origen=origen;
	}	
	public String getDestino(){
		return this.origen;
	}

	public void setFecha(String fecha){
		this.fecha=fecha;
	}
	public String getFecha(){
		return this.fecha;
	}	
}