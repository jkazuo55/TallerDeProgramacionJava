import java.io.Serializable;
public class PersonaEmigrante extends Persona implements Serializable{
	private String emigranteSiNo;
	private String fecha;
	private String origen;
	private String destino;
	private String motivoDeMigracion;

	//====== constructor ==========

	public PersonaEmigrante(){

	}

	public PersonaEmigrante(String nombre,String apellidos,long cedula, String sexo , String nacidoEn,String direccion, String telefono,String correo, String emigranteSiNo,String fecha, String origen,String destino, String motivoDeMigracion){
		super(nombre,apellidos,cedula,sexo,nacidoEn,direccion,telefono,correo);
		this.emigranteSiNo=emigranteSiNo;
		this.fecha=fecha;
		this.origen=origen;
		this.destino=destino;
		this.motivoDeMigracion=motivoDeMigracion;
	}

	//========Metodos Setters========

	public void setEmigranteSiNo( String emigranteSiNo){
		this.emigranteSiNo=emigranteSiNo;
	}	
	public void setFecha(String fecha){
		this.fecha=fecha;
	}
	public void setOrigen( String origen){
		this.origen=origen;
	}	
	public void setDestino( String destino){
		this.destino=destino;
	}
	public void setMotivoDeMigracion( String motivoDeMigracion){
		this.motivoDeMigracion=motivoDeMigracion;
	}

	//=========Metosos Getters==========
	
	public String getEmigranteSiNo(){
		return this.emigranteSiNo;
	}
	public String getFecha(){
		return this.fecha;
	}
	public String getOrigen(){
		return this.origen;
	}
	public String getDestino(){
		return this.destino;
	}
	public String getMotivoDeMigracion(){
		return this.motivoDeMigracion;
	}
	
  
	public String toString() {
		String atributosPadre=super.toString();
        StringBuilder sb = new StringBuilder(atributosPadre);
        sb.append("\nEmigranteSiNo: ");
        sb.append(emigranteSiNo);
        sb.append("\nFecha: ");
        sb.append(fecha);    
        sb.append("\nOrigen: ");
        sb.append(origen);
        sb.append("\nDestino: ");
        sb.append(destino);
        sb.append("\nMotivoDeMigracion: ");
        sb.append(motivoDeMigracion);
        return sb.toString();
    }
}