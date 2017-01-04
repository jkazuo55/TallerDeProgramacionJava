package modelo.grafoND;
/**
* @class Arista.java 
* @brief Implementacion de la Clase para el manejo de las Aristas/Arcos del Grafo</br>
* Una Arista corresponde a una relacion entre dos vertices de un Grafo.
* @param <T> Tipo de datos a almacenar dentro de la Arista.
* @author SoftTux
* @version 0.2
* @since 1.0
* @see https://github.com/jkazuo55/TallerDeProgramacionJava
*/

public class Arista<T> {

    private Vertice<T> vertA;//!<Representa el Vertice de un lado de la Arista
    private Vertice<T> vertB;//!<Representa el Vertice del otro de la Arista
    private int peso;//!<Representa el peso de la Arista; Puede representar costos, tiempos, distancias
    private boolean esVisit;//!<Representa un valor que indica si el Vertice ha sido visitado(True=visitado, False=No visitado)
    
    
    /**
    * @brief Metodo constructor que permite crear una nueva Arista con sus 2 vertices definidos. <br>
    * <b> post: </b> Se creo una nueva Arista con la informacion de los 2 vertices. <br>
    * @param vA Objeto de tipo Vertice que representa uno de los extremos de la Arista. <br>
    * @param vB Objeto de tipo Vertice que representa uno de los extremos de la Arista. <br>
    * @param p Objeto de tipo T que representa el peso de la Arista. Para los recorridos debe ser de tipo int.
    */
    public Arista(Vertice<T> vA, Vertice<T> vB, int p) {
        this.vertA = vA;
        this.vertB = vB;
        this.peso = p;
        this.esVisit = false;
    }

    /**
     * @brief Obtiene el Vertice de uno de los extremos de la Arista. <br>
     * <b> post </b> Se retorno el Vertice en uno de los extremos de la Arista. <br>
     * @return Un objeto de tipo Vertice que representa un extremo de la Arista.
     */
    public Vertice<T> getVertA() {
        return vertA;
    }

    /**
     * @brief Metodo que permite editar uno de los Vertices extremos de la Arista. <br>
     * <b> post: </b> Se edito uno de los Vertices que se encuentra en un extremo de la Arista. <br>
     * @param vertA Representa el nuevo Vertice que se ubiciara en un extremo de la Arista. <br>
     */
    public void setVertA(Vertice<T> vertA) {
        this.vertA = vertA;
    }

    /**
     * @brief Obtiene el Vertice de uno de los extremos de la Arista. <br>
     * <b> post </b> Se retorno el Vertice en uno de los extremos de la Arista. <br>
     * @return Un objeto de tipo Vertice que representa un extremo de la Arista.
     */
    public Vertice<T> getVertB() {
        return vertB;
    }

    /**
     * @brief Metodo que permite editar uno de los Vertices extremos de la Arista. <br>
     * <b> post: </b> Se edito uno de los Vertices que se encuentra en un extremo de la Arista. <br>
     * @param vertB Representa el nuevo Vertice que se ubiciara en un extremo de la Arista. <br>
     */
    public void setVertB(Vertice<T> vertB) {
        this.vertB = vertB;
    }

    /**
     * @brief Metodo que permite conocer el peso de la Arista; Puede representar costos, tiempos, distancias. <br>
     * <b> post: </b> Se retorno un objeto de tipo T que representa el peso de la Arista. <br>
     * @return Un objeto de tipo T que representa el peso de la Arista, costo, tiempo o distancia.
     */
    public int getPeso() {
        return peso;
    }

    /**
     * @brief Metodo que permite editar el peso de una Arista, reemplazarlo con un nuevo valor. <br>
     * <b> post: </b> Se edito el peso de la Arista con un nuevo valor. <br>
     * @param peso Representa el nuevo peso de la Arista.
     */
    public void setPeso(int peso) {
        this.peso = peso;
    }
    
    /**
     * @brief Metodo que permite evaular si una Arista ha sido visitada en un recorrido. <br>
     * <b>post: </b> Se retorno un boolean que evalua si la Arista ha sido visitada. <br>
     * @return Un Objeto de tipo boolean que evalua si la Arista ha sido visitada.
     */
    public boolean getVisit() {
        return esVisit;
    }

    /**
     * @brief Metodo que permite marcar la visita de una Arista dentro de un recorrido. <br>
     * <b> post: </b> Se marco la visita de una Arista con un true o false. <br>
     * @param esVisit Es de tipo boolean y representa true=visitado, false=No visitado.
     */
    public void setVisit(boolean esVisit) {
        this.esVisit = esVisit;
    }
    
    /**
     * @brief Metodo que permite evaluar si una Arista incide sobre un Vertice. <br>
     * <b> post: </b> Se retorno un valor booleano con el resultado de la operacion. <br>
     * @param v Vertice del que se desea si la Arista actual incide sobre el. <br>
     * @return Un objeto de tipo boolean true=si la Arista incide en el Vertice.
     */
    public boolean incideEnND(Vertice v){
        return (this.vertA.equals(v)||this.vertB.equals(v));
    }
    
    /**
     * @brief Metodo que permite evaluar si dos Aristas son iguales, comparando sus extremos. <br>
     * <b> post: </b> Se retorno un valor booleano para evaluar la igualdad de las Aristas. <br>
     * @param ar Representa la segunda Arista en comparacion. <br>
     * @return Un objeto de tipo boolean que evalua la igualdad de los extremos de la Arista.
     */
    public boolean equalsND(Arista ar){
        return ((ar.getVertA().equals(this.vertA))||(ar.getVertA().equals(this.vertB)))&&
                ((ar.getVertB().equals(this.vertA))||(ar.getVertB().equals(this.vertB)));
    }
    
    /**
     * @brief Metodo que permite evaluar si dos Aristas son iguales, comparando sus extremos. <br>
     * <b> post: </b> Se retorno un valor booleano para evaluar la igualdad de las Aristas. <br>
     * @param ar Representa la segunda AristaD en comparacion. <br>
     * @return Un objeto de tipo boolean que evalua la igualdad de los extremos de la AristaD.
     */
    public boolean equalsD(Arista ar){
        return ((ar.getVertA().equals(this.vertA))&&(ar.getVertB().equals(this.vertB)));
    }
    
    /**
     * @brief Metodo que sirve de Interfaz del Metodo toString() del Objeto. <br>
     * @return Una cadena de String con la información del Vertice.
     */
    @Override
    public String toString(){
        return ("("+this.vertA.getInfo()+"-"+this.vertB.getInfo()+")");
    }
    
}//Fin de la Clase Arista
