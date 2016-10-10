import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdministradorDeVertices{
	
	public static void main(String[]args){
		 
		 ArrayList<Ciudad>  ciudades  = new ArrayList<Ciudad>();
	     ArrayList<Persona> personas = new ArrayList<Persona>();

	     personas.add(new Persona("julian","464665165 LP","La Paz","Hombre",26));
	     personas.add(new Persona("Maria","464665165 LP","La Paz","Hombre",26));
	     personas.add(new Persona("Marcos","464665165 LP","La Paz","Hombre",26));
	     
	     ciudades.add(new Ciudad("Cochabamba",new Persona("Maria","464665165 LP","La Paz","Hombre",26)));
	     ciudades.add(new Ciudad("La Paz",new Persona("Laura","464665165 LP","La Paz","Hombre",26)));
	     ciudades.add(new Ciudad("Santa Cruz",new Persona("Julian","464665165 LP","La Paz","Hombre",26)));
	     

	     System.out.println(personas.get(1));
	     System.out.println(ciudades.get(1));
	}
}