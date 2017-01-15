//package modelo;

import java.io.Serializable;
public class Funcionario extends Persona implements Serializable{

	private String nombreUsuario;
	private String contrasenia;
	private String rol;

	//====== constructor ==========

	public Funcionario(){

	}

	public Funcionario(String nombre,String apellidos,long cedula, String sexo , String nacidoEn,String direccion, long telefono,String correo, String nombreUsuario,String contrasenia, String rol){
		super(nombre,apellidos,cedula,sexo,nacidoEn,direccion,telefono,correo);
		this.nombreUsuario=nombreUsuario;
		this.contrasenia=contrasenia;
		this.rol=rol;
	}

	//========Metodos Setters========

	public void setNombreUsuario( String nombreUsuario){
		this.nombreUsuario=nombreUsuario;
	}	
	public void setContrasenia(String contrasenia){
		this.contrasenia=contrasenia;
	}
	public void setRol( String rol){
		this.rol=rol;
	}	

	//=========Metosos Getters==========
	
	public String getNombreUsuario(){
		return this.nombreUsuario;
	}
	public String getContrasenia(){
		return this.contrasenia;
	}
	public String getRol(){
		return this.rol;
	}
	
  
	public String toString() {
		String atributosPadre=super.toString();
        StringBuilder sb = new StringBuilder(atributosPadre);
        sb.append("\nNombreUsuario: ");
        sb.append(nombreUsuario);
        sb.append("\nContrasenia: ");
        sb.append(contrasenia);    
        sb.append("\nRol: ");
        sb.append(rol);
        return sb.toString();
    }
}