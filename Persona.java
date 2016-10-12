public class Persona{

	private String nombre;
	private String apellido;
	private String sexo;
	private String cedula;
	private String nacidoEn;
	private int edad;

	public Persona(String nombre,String apellido, String sexo , String cedula,String nacidoEn, int edad){
		this.nombre=nombre;
		this.apellido=apellido;
		this.sexo=sexo;
		this.cedula=cedula;
		this.nacidoEn=nacidoEn;
		this.edad=edad;
	}

	//======Metodos Setters======

	public void setNonbre(String nombre){
		this.nombre=nombre;
	}
	public void setApellido(String apellido){
		this.apellido=apellido;
	}
	public void setSexo(String sexo){
		this.sexo=sexo;
	}
	public void setCedula(String cedula){
		this.cedula=cedula;
	}
	public void setNacidoEn(String ciudad){
		this.nacidoEn=nacidoEn;
	}
	public void setEdad(int edad){
		this.edad=edad;
	}

	//======Metodos Getters ======
	
	public String getNombre(){
		return this.nombre;
	}
	public String getApellido(){
		return this.apellido;
	}
	public String getSexo(){
		return this.sexo;
	}
	public String getCedula(){
		return this.cedula;
	}
	public String getNacidoEn(){
		return this.nacidoEn;
	}
	public int getEdad(){
		return this.edad;
	}

	//=====Funciones Operacionales

	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nNombre: ");
        sb.append(nombre);
        sb.append("\nApellido: ");
        sb.append(apellido);
        sb.append("\nSexo: ");
        sb.append(sexo);
        sb.append("\ncedula: ");
        sb.append(cedula);
        sb.append("\nNacidoEn: ");
        sb.append(nacidoEn);    
        sb.append("\nEdad: ");
        sb.append(edad);    
        return sb.toString();
    }
}