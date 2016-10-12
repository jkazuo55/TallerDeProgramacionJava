import java.util.ArrayList;

public class Ciudad{

	private String nombre;
	private int codigo;
	private ArrayList<PersonaEmigrante>listaEmigrantes;

	public Ciudad(){
		// this.nombre=nombre;
		listaEmigrantes= new ArrayList<PersonaEmigrante>();
	}

	//===========Metodos setters ==============

	public void setNonbre(String nombre){
		this.nombre=nombre;
	}
	public void setCodigo(int codigo){
		this.codigo=codigo;
	}

	//==========Metodos getters =================

	public String getNombre(){
		return this.nombre;
	}
	public int getCodigo(){
		return this.codigo;
	}

	//=========== Metodos operacionales===========

	public void registrarEmigrante(PersonaEmigrante emigrante){
		listaEmigrantes.add(emigrante);
	}

	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nNombre: ");
        sb.append(nombre);
        sb.append("\ncodigo: ");
        sb.append(codigo);

        return sb.toString();
    }

}