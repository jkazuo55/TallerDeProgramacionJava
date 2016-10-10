
public class Grafo {
	
	private final int NUM_VERTICES=4;
	private int grafo[][]={
							{0,5,999999999,999999999},
							{50,0,15,5},
							{30,999999999,0,15},
							{15,999999999,5,0}

	};

	public Ciudad ciudades[][]={
							{new Ciudad("cochabamba"),new Ciudad("cochabamba"),new Ciudad("La paz"),new Ciudad("TArija")},
							{new Ciudad("ssssss"),new Ciudad("eeeeee"),new Ciudad("oooooo"),new Ciudad("iiiiiii")},
							{new Ciudad("hhhhhhh"),new Ciudad("Pando"),new Ciudad("llllll"),new Ciudad("yyyyyyy")},
							{new Ciudad("kkkkkk"),new Ciudad("Chuquisaca"),new Ciudad("rrrrrr"),new Ciudad("ppppp")}

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

 	public String floyd(){
 		int[][]adyacencia= grafo;
 	    int n=adyacencia.length;
 	    int[][]D = adyacencia;
 	 
 	    String enlaces[][]=new String [n][n];
 	    String[][] aux_enlaces=new String[adyacencia.length][adyacencia.length];
 	 
 	    for (int i = 0; i < n; i++) {
 	        for (int j = 0; j < n; j++) {
 	            enlaces[i][j]="";
 	            aux_enlaces[i][j]="";
 	        }
 	    }
 	    String enl_rec="";
 	    for (int k = 0; k < n; k++) {
 	        for (int i = 0; i < n; i++) {
 	            for (int j = 0; j < n; j++) {
 	                float aux=D[i][j];
 	                float aux2=D[i][k];
 	                float aux3=D[k][j];
 	                float aux4=aux2+aux3;
 	                float res=Math.min(aux,aux4);
 	                if(aux!=aux4){
 	                    if(res==aux4){
 	                        enl_rec="";
 	                        aux_enlaces[i][j]=k+"";
 	                        enlaces[i][j]=enlaces(i,k,aux_enlaces,enl_rec)+(k+1);
 	                    }
 	                }

 	                D[i][j]=(int) res;
 	            }
 	        }
 	    }
 	 
 	    String cadena="";
 	    for (int i = 0; i < n; i++) {
 	       for (int j = 0; j < n; j++) {
 	              cadena+=D[i][j]+" ";
 	        }
 	        cadena+="\n";
 	    }
 	 
 	    String enlacesres="";
 	    for (int i = 0; i <n; i++) {
 	        for (int j = 0; j < n; j++) {
 	            if(i!=j){
 	                if(enlaces[i][j].equals("")==true) {
 	                    enlacesres+=" De ( "+(i+1)+" a "+(j+1)+" ) = "+"( "+(i+1)+" , "+(j+1)+" )"+"\n";
 	                }
 	                else
 	                    enlacesres+=" De ( "+(i+1)+" a "+(j+1)+" ) = ( "+(i+1)+" , "+enlaces[i][j]+" , "+(j+1)+")\n";
 	            }
 	        }
 	    }
 	  		System.out.println("desdefloyd");

 	    return "las distancias minimas entre nodos son: \n"+cadena+"\nlos caminos minimos entre nodosson:\n"+enlacesres;
 	}
 	 
 	public String enlaces(int i,int k,String[][] aux_enlaces,String enl_rec){
 	    if(aux_enlaces[i][k].equals("")==true){
 	       return "";
 	    }
 	    else{
            enl_rec+=enlaces(i,Integer.parseInt(aux_enlaces[i][k].toString()),aux_enlaces,enl_rec)+(Integer.parseInt(aux_enlaces[i][k].toString())+1)+" , ";
 	        return enl_rec;
 	    }
 	}
}
