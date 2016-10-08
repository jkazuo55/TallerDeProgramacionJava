public class Grafo {
	private final int NUM_VERTICES=14;
	private int grafo[][]={
							{0,34,34,65,34,34,3,342,43,3,3,3,34,1},
							{0,0,20,65,41,3,5,2,23,12,2,80,10,1},
							{0,5,0,65,41,3,5,2,23,12,2,80,10,1},
							{0,5,20,0,41,3,5,2,23,12,2,80,10,1},
							{0,5,20,65,0,3,5,2,23,12,2,80,10,1},
							{0,5,20,65,41,0,5,2,23,12,2,80,10,1},
							{0,5,20,65,41,3,0,2,23,12,2,80,10,1},
							{0,5,20,65,41,3,5,0,23,12,2,80,10,1},
							{0,5,20,65,41,3,5,2,0,12,2,80,10,1},
							{0,5,20,65,41,3,5,2,23,0,2,80,10,1},
							{0,5,20,65,41,3,5,2,23,12,0,80,10,1},
							{0,5,20,65,41,3,5,2,23,12,2,0,10,1},
							{0,5,20,65,41,3,5,2,23,12,2,80,0,1},
							{0,5,20,65,41,3,5,2,23,12,2,80,10,0},

	};
	
	//Imprimir el Estado actual del Grafo=================

	public void imprimirGrafo(){
		System.out.printf("  %d" , 0);
		for (int i = 1; i < grafo.length; i++) {
			System.out.printf(" %d" , i);
		}
		System.out.println();
		
		for(int i = 0; i < grafo.length; i++){
			System.out.printf("%d ",i);
			for(int j = 0; j < grafo[i].length; j++){
				System.out.printf("%d " , grafo[i][j]);
			}
			System.out.println();
		}
	}
	
   // ----- Mostrar la lista de adyacencia de un vértice -----//
	public boolean tieneAdyacentes(int v){
		int vActual = 0;
		boolean existeLista = false;
		
		while(vActual < this.NUM_VERTICES && !existeLista){
			if(grafo[v][vActual] != 0){
				existeLista = true;
			}
			else{
				vActual = vActual + 1;
			}
		}
		
		return existeLista;
	}
	

	public int obtenerPrimerAdy(int v){
		int adyacente = -1;
		int vActual = 0;
		boolean existeLista = false;
		
		while(vActual < this.NUM_VERTICES && !existeLista){
			if(grafo[v][vActual] == 0){
				vActual = vActual + 1;
			}
			else{
				adyacente = vActual;
				existeLista = true;
			}
		}
		
		if(!existeLista);
		
		return adyacente;		
	}
	
	public int sgteAdyacente(int v, int anteriorAd){
		int adyacente = 0;
		int vActual = anteriorAd + 1;
		boolean existeLista = false;
		
		while(vActual < this.NUM_VERTICES && !existeLista){
			if(grafo[v][vActual] == 0){
				vActual = vActual + 1;
			}
			else{
				adyacente = vActual;
				existeLista = true;
			}
		}
		
		if(!existeLista)adyacente = -1;
		return adyacente;
	}
}
