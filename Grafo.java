public class Grafo{
    private int matriz[][];
    private final int NUMERO_VERTICES;

    public Grafo(int num_vertices){
        this.NUMERO_VERTICES = num_vertices;
        this.matriz = new int[NUMERO_VERTICES][NUMERO_VERTICES];

        for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[i].length; j++) {
                        matriz[i][j] = 0;
                }
        }
        
    }

    public Grafo(int grafo[][]){
        this.matriz = grafo;
        this.NUMERO_VERTICES = grafo.length;
    }

    public int[][] getMatriz(){
        return this.matriz;
    }

    public int getNumeroVertices(){
        return this.NUMERO_VERTICES;
    }

    public void modificarVertice(int i,int j,int value){
        this.matriz[i][j] = value;
    }

    public int obtenerVertice(int i,int j){
        return this.matriz[i][j];
    }
}
