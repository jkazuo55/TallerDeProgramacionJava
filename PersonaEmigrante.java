public class PersonaEmigrante extends Persona{
	public String destino;
	public String fecha;

	public PersonaEmigrante(String nombre, String cedula , String nacidoEn, String sexo, int edad,String destino, String fecha){
		super(nombre, cedula ,nacidoEn,sexo,edad);
		this.destino=destino;
		this.fecha=fecha;
	}
	public void setDestino( String destino){
		this.destino=destino;
	}	
	public String getDestino(){
		return this.destino;
	}

	public void setFecha(String fecha){
		this.fecha=fecha;
	}
	public String getFecha(){
		return this.fecha;
	}
}