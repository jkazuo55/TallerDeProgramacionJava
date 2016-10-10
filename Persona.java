public class Persona{

	public String nombre;
	public String cedula;
	public String nacidoEn;
	public String sexo;
	public int edad;

	public Persona(String nombre, String cedula , String nacidoEn, String sexo, int edad){
		this.nombre=nombre;
		this.cedula=cedula;
		this.nacidoEn=nacidoEn;
		this.sexo=sexo;
		this.edad=edad;
	}

	public void setNonbre(String nombre){
		this.nombre=nombre;
	}
	public String getNombre(){
		return this.nombre;
	}

	public void setCedula(String nombre){
		this.cedula=cedula;
	}
	public String getCedula(){
		return this.cedula;
	}

	public void setOrigen(String nombre){
		this.nacidoEn=nacidoEn;
	}
	public String getOrigen(){
		return this.nacidoEn;
	}

	public void setSexo(String nombre){
		this.sexo=sexo;
	}
	public String getSexo(){
		return this.sexo;
	}

	public void setEdad(String nombre){
		this.edad=edad;
	}
	public int getEdad(){
		return this.edad;
	}

	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nNombre: ");
        sb.append(nombre);
        sb.append("\nCedula: ");
        sb.append(cedula);
        sb.append("\nNacidoEn: ");
        sb.append(nacidoEn);
        sb.append("\nSexo: ");
        sb.append(sexo);    
        sb.append("\nEdad: ");
        sb.append(edad);    
        return sb.toString();
    }
}