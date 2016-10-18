public class PersonaEmigrante extends Persona{
	public String destino;
	public String fecha;

	public PersonaEmigrante(String nombre,String apellido, String sexo , String cedula,String nacidoEn, int edad,String destino, String fecha){
		super(nombre,apellido,sexo,cedula,nacidoEn,edad);
		this.destino=destino;
		this.fecha=fecha;
	}

	//========Metodos Setters========
	public void setDestino( String destino){
		this.destino=destino;
	}	
	public void setFecha(String fecha){
		this.fecha=fecha;
	}
	//=========Metosos Getters==========
	public String getDestino(){
		return this.destino;
	}

	public String getFecha(){
		return this.fecha;
	}

	public String toString() {
		String atributosPadre=super.toString();
        StringBuilder sb = new StringBuilder(atributosPadre);
        sb.append("\nDestino: ");
        sb.append(destino);
        sb.append("\nFecha: ");
        sb.append(fecha);    
        return sb.toString();
    }
}