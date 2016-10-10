public class Viajes{

	PersonaEntrante personaEntrante;
	PersonaSaliente personaSaliente;
	String origen;
	String destino;
	String fecha;

	public Viajes(PersonaEntrante persona,String origen, String destino){
		this.personaEntrante=persona;
		this.origen=origen;
		this.destino=destino;
		this.fecha=fecha;		
	}



	public void enviarPersona(PersonaSaliente nuevaPersona){
		destino=nuevaPersona.destino;
		origen=nuevaPersona.origen;

		

	}

	public void setPersona(Persona persona){
		this.persona=persona;
	}
	public Persona getPersona(){
		return this.persona;
	}
	public void setOrigen(String origen){
		this.origen=origen;
	}
	public String	 setOrigen(){
		return this.origen;
	}
	public void setDestino(String destino){
		this.destino=destino;
	}
	public String setDestino(){
		return this.destino;
	}
	public void setFecha(String fecha){
		this.fecha=fecha;
	}
	public String setFecha(){
		return this.fecha;
	}

	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nPersona: ");
        sb.append(persona);
        sb.append("\nOrigen: ");
        sb.append(origen);
        sb.append("\ndestino: ");
        sb.append(destino);
        sb.append("\nFecha: ");
        sb.append(fecha);        
        return sb.toString();
    }
}