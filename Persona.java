import java.io.Serializable;

public class Persona implements Serializable{

	private String nombre;
	private String apellidos;
	private long cedula;
	private String sexo;
	private String nacidoEn;
	private String direccion;
	private long telefono;
	private String correo;

	public Persona(String nombre,String apellidos,long cedula ,String sexo, String nacidoEn, String direccion,long telefono, String correo){
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.cedula=cedula;
		this.sexo=sexo;
		this.nacidoEn=nacidoEn;
		this.direccion=direccion;
		this.telefono=telefono;
		this.correo=correo;
	}
	public Persona(){

	}

	//======Metodos Setters======

	public void setNonbre(String nombre){
		this.nombre=nombre;
	}
	public void setApellidos(String apellidos){
		this.apellidos=apellidos;
	}
	public void setCedula(long cedula){
		this.cedula=cedula;
	}
	public void setSexo(String sexo){
		this.sexo=sexo;
	}
	public void setNacidoEn(String ciudad){
		this.nacidoEn=nacidoEn;
	}
	public void setDireccion(String direccion){
		this.direccion=direccion;
	}
	public void setTelefono(long telefono){
		this.telefono=telefono;
	}
	public void setCorreo(String correo){
		this.correo=correo;
	}
	

	//======Metodos Getters ======
	
	public String getNombre(){
		return this.nombre;
	}
	public String getApellidos(){
		return this.apellidos;
	}
	public long getCedula(){
		return this.cedula;
	}
	public String getSexo(){
		return this.sexo;
	}
	public String getNacidoEn(){
		return this.nacidoEn;
	}
	public String getDireccion(){
		return this.direccion;
	}
	public long getTelefono(){
		return this.telefono;
	}
	public String getCorreo(){
		return this.correo;
	}

	//=====Funciones Operacionales

	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nNombre: ");
        sb.append(nombre);
        sb.append("\nApellido: ");
        sb.append(apellidos);
        sb.append("\ncedula: ");
        sb.append(cedula);
        sb.append("\nsexo: ");
        sb.append(sexo);
        sb.append("\nNacidoEn: ");
        sb.append(nacidoEn);
        sb.append("\nDireccion: ");
        sb.append(direccion);    
        sb.append("\nTelefono: ");
        sb.append(telefono);    
        sb.append("\nCorreo: ");
        sb.append(correo);
    
        return sb.toString();
    }
}