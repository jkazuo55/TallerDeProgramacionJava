import java.util.ArrayList;

public class Ciudad{

	public String nombre;
	public long poblacion;
	public Persona persona;
	public PersonaSaliente personaSaliente;
	public PersonaEntrante personaEntrante;

	public static ArrayList<Persona>listaDepersonas;
	public static ArrayList<PersonaSaliente>listaDePersonasSalientes;
	public static ArrayList<PersonaEntrante>listaDePersonasEntrantes;

	
	public Ciudad(String nombre, Persona persona){
		this.nombre=nombre;
		this.persona=persona;
	}

	public Ciudad(String nombre){
		this.nombre=nombre;
	}


	public void setNonbre(String nombre){
		this.nombre=nombre;
	}
	public String getNombre(){
		return this.nombre;
	}

	// public long getPoblacion(){
	// 	return this.listaDepersonas.size();
	// }


	// public void agregarPersonas(Persona nuevaPersona){
	// 	listaDepersonas.add(nuevaPersona);
	// }
	// public void mostrarListaDePersonas(){
	// 	for (int i=0;i<listaDepersonas.size() ;i++ ) {
	// 		System.out.println(listaDepersonas.get(i));
	// 	}
	// }

	// public void registrarPersonaSaliente(PersonaSaliente nuevaPersona){
	// 	listaDePersonasSalientes.add(nuevaPersona);
	// }
	// public void mostrarListaDePersonasSalientes(){
	// 	for (int i=0;i<listaDePersonasSalientes.size();i++ ) {
	// 		System.out.println(listaDePersonasSalientes.get(i));
	// 	}
	// }

	// public void registrarPersonaEntrante(PersonaEntrante nuevaPersona){
	// 	listaDePersonasEntrantes.add(nuevaPersona);
	// }
	// public void mostrarListaDePersonasEntrantes(){
	// 	for (int i=0;i<listaDePersonasEntrantes.size;i++ ) {
	// 		System.out.println(listaDePersonasEntrantes.get(i));
	// 	}
	// }

	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nNombre: ");
        sb.append(nombre);
        sb.append("\nPersona: ");
        sb.append(persona);
        sb.append("\nPoblacion: ");
        sb.append(poblacion);

        return sb.toString();
    }




}