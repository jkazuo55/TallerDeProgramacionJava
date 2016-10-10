import java.util.Scanner;


public class Main {
	

	public static void menu(){
		System.out.println("####### OPCIONES GENERALES  #######");
		System.out.println("1. Mapa de la ciudad");
		System.out.println("2. Total De personas Registradas Bolivia");
		System.out.println("3. Total Registro De personas por por Ciudades");
		System.out.println("4. Mas opciones En una siudad ciudad");
		// System.out.println("5. Viajar");
		// System.out.println("3. camino mas corto");
		System.out.println("6. Salir");
	}	
	public static void mostrarGrafo(Grafo grafo){
		grafo.imprimirGrafo();
	}	
	public static void mostrarListaDeVerticesAdyacentes(Grafo g){
		Scanner in = new Scanner(System.in);
		System.out.println("Inserte vertice");
		int v = in.nextInt();
		if(!g.tieneAdyacentes(v)){
			System.out.println("La lista esta vacia");
		}
		else{
			int aux = g.obtenerPrimerAdy(v);
			System.out.println("Lista: ");
			while(aux != -1){
				System.out.print(" " + aux);
				aux = g.sgteAdyacente(v, aux);
			}
			System.out.println();
		}
	}
	public static void caminoMasCorto(Grafo g){
		String resultado=g.floyd();
		System.out.println(resultado);
	}

	public static void mostrarListaDePersonasDeLaCiudad(){
		System.out.println("hola des mostrarListaDePersonasDeLaCiudad");
	}
	public static void mostrarListaDePersonasDeSalientes(){
		System.out.println("hola desde mostrarListaDePersonasDeSalientes");

	}
	public static void mostrarListaDePersonasDeEntrantes(){
		System.out.println("hola des mostrarListaDePersonasDeEntrantes");

	}

	public static void totalDePersonasRegistradasEnBolivia(){
		System.out.println("");
		System.out.println("");
		System.out.println(" ");

	}
	public static void totalDePersonasRegistradasPorCiudad(){
		System.out.println("hola desde totalDePersonasRegistradasPorCiudad");

	}

	public static void viajar(){
		System.out.println("hola desde viajar");	
	}
	public static void masOpcionesEnUnaCiudad(){
		int numero;
		do{
			System.out.println("========= OPCIONES DE UNA CIUDAD =========");
			System.out.println("    7. Personas Actuales");
			System.out.println("    8. Lista de de personas Salientes");
			System.out.println("    9. Lista de personas entrantes");
			System.out.println("    10.Viajar");
			System.out.println("    11.Volver Atraz");
			System.out.println("=> ingrese una opcion");

			Scanner lector =new Scanner(System.in);
			numero = lector.nextInt();
			switch(numero){
				case 7:mostrarListaDePersonasDeLaCiudad();break;
				case 8:mostrarListaDePersonasDeSalientes();break;
				case 9:mostrarListaDePersonasDeEntrantes();break;
				case 10:viajar();break;
				default: if (numero!=11) {
					System.out.println("opcion incorrecta");
				};
			}

		}while(numero != 11);
	}	

	public static void imprimirMatriz(Grafo ciudad){		
		for (int i=0;i<4;i++ ) {
			for (int j=0;j<4;j++ ) {
				System.out.println(ciudad.ciudades[i][j].getNombre());
			}
		}
	}

	public static void main(String[] args) {
		int opcion;
		
		Grafo g = new Grafo();
		
		do{
			menu();
			
			System.out.println("=> Ingrese una opcion");
			Scanner in = new Scanner(System.in);
			opcion = in.nextInt();
			
			switch(opcion){
			// case 0: imprimirMatriz(g);break;
			case 0: caminoMasCorto(g);break;
			case 1: mostrarGrafo(g);break;
			case 2: totalDePersonasRegistradasEnBolivia();break;
			case 3: totalDePersonasRegistradasPorCiudad();break;
			case 4: masOpcionesEnUnaCiudad();break;
			case 5: mostrarListaDeVerticesAdyacentes(g);break;
			default: System.out.println("Incorrect option");
			}
		}while(opcion != 6);
	}
}
