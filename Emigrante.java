import java.io.Serializable;
public class Emigrante extends Persona implements Serializable{
	private String fecha;
	private String origen;
	private String destino;
	private String ruta;
	private String motivoDeMigracion;

	//====== constructor ==========

	public Emigrante(){

	}

	public Emigrante(String nombre,String apellidos,long cedula, String sexo , String nacidoEn,String direccion,long telefono,String correo,String fecha, String origen,String destino, String ruta, String motivoDeMigracion){
		super(nombre,apellidos,cedula,sexo,nacidoEn,direccion,telefono,correo);
		this.fecha=fecha;
		this.origen=origen;
		this.destino=destino;
		this.ruta=ruta;
		this.motivoDeMigracion=motivoDeMigracion;
	}

	//========Metodos Setters========

	public void setFecha(String fecha){
		this.fecha=fecha;
	}
	public void setOrigen( String origen){
		this.origen=origen;
	}	
	public void setDestino( String destino){
		this.destino=destino;
	}
	public void setRuta( String ruta){
		this.ruta=ruta;
	}
	public void setMotivoDeMigracion( String motivoDeMigracion){
		this.motivoDeMigracion=motivoDeMigracion;
	}

	//=========Metosos Getters==========
	
	
	public String getFecha(){
		return this.fecha;
	}
	public String getOrigen(){
		return this.origen;
	}
	public String getDestino(){
		return this.destino;
	}
	public String getRuta(){
		return this.ruta;
	}
	public String getMotivoDeMigracion(){
		return this.motivoDeMigracion;
	}
	
  
	public String toString() {
		String atributosPadre=super.toString();
        StringBuilder sb = new StringBuilder(atributosPadre);
        sb.append("\nFecha: ");
        sb.append(fecha);    
        sb.append("\nOrigen: ");
        sb.append(origen);
        sb.append("\nDestino: ");
        sb.append(destino);
        sb.append("\nRuta: ");
        sb.append(ruta);
        sb.append("\nMotivoDeMigracion: ");
        sb.append(motivoDeMigracion);
        return sb.toString();
    }
}