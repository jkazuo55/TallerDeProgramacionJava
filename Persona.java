public class Persona{

	private String nombre;
	private String apellidos;
	private int cedula;
	private String nacidoEn;
	private String direccion;
	private String telefono;
	private String sexo;

	public Persona(String nombre,String apellidos,int cedula ,String nacidoEn, String direccion,String telefono, String sexo){
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.cedula=cedula;
		this.nacidoEn=nacidoEn;
		this.direccion=direccion;
		this.telefono=telefono;
		this.sexo=sexo;
	}
	public Persona(){

	}

	//======Metodos Setters======

	public void setNonbre(String nombre){
		this.nombre=nombre;
	}
	public void setApellido(String apellidos){
		this.apellidos=apellidos;
	}
	public void setCedula(int cedula){
		this.cedula=cedula;
	}
	public void setNacidoEn(String ciudad){
		this.nacidoEn=nacidoEn;
	}
	public void setDireccion(String direccion){
		this.direccion=direccion;
	}
	public void setTelefono(String telefono){
		this.telefono=telefono;
	}
	public void setSexo(String sexo){
		this.sexo=sexo;
	}
	

	//======Metodos Getters ======
	
	public String getNombre(){
		return this.nombre;
	}
	public String getApellido(){
		return this.apellidos;
	}
	public int getCedula(){
		return this.cedula;
	}
	public String getDireccion(){
		return this.direccion;
	}
	public String getNacidoEn(){
		return this.nacidoEn;
	}
	public String getTelefono(){
		return this.telefono;
	}
	public String getSexo(){
		return this.sexo;
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
        sb.append("\nNacidoEn: ");
        sb.append(direccion);    
        sb.append("\nDireccion: ");
        sb.append(telefono);    
        sb.append("\ntelefono: ");
        sb.append(sexo);
        sb.append("\nSexo: ");
        sb.append(sexo);
    
        return sb.toString();
    }
}