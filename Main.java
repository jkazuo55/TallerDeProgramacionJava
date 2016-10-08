import java.util.Scanner;

public class Main {
	
	public static void menu(){
		System.out.println("1. Mostrar Grafo");
		System.out.println("2. Mostrar lista Adyacencia vertice");
		System.out.println("3. Salir");
	}

	
	public static void mostrarGrafo(Grafo g){
		g.imprimirGrafo();
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
	public static void main(String[] args) {
		int opcion;
		Grafo g = new Grafo();
		
		do{
			menu();
			
			System.out.println("Ingrese una opcion");
			Scanner in = new Scanner(System.in);
			opcion = in.nextInt();
			
			switch(opcion){
			case 1: mostrarGrafo(g);break;
			case 2: mostrarListaDeVerticesAdyacentes(g);break;
			case 3: break;
			default: System.out.println("Incorrect option");
			}
		}while(opcion != 6);
	}
}
