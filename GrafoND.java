//package modelo.grafoND;

//import modelo.listaCDE.Lista;

/**
 * @class Nodo.java 
 * @brief Implementacion de la Clase para el manejo de Grafos No Dirigidos; <br>
 * Para este Grafo el conjunto de las aristas no tiene una dirección definida. <br>
 * @param <T> Tipo de Objetos que se almacenan en los Vertices y Aristas del Grafo
 * @author SoftTux
 * @version 0.2
 * @since 1.0
 * @see https://github.com/jkazuo55/TallerDeProgramacionJava
 */

public class GrafoND<T> {

    private Lista<Vertice> vertices;//<!Representa el listado de Vertices del Grafo
    private Lista<Arista> aristas;//!<Representa el listado de Aristas del Grafo
    
    /**
     * @brief Metodo constructor del Grafo que inicializa el Listado de Vertices y Aristas.
     * <b> post: </b> Se creo un nuevo Grafo sin Vertices y Aristas.
     */
    public GrafoND() {
        this.vertices = new Lista<Vertice>();
        this.aristas = new Lista<Arista>();
    }
    
    /**
     * @brief Metodo que permite conocer el listado de Vertices del Grafo. <br>
     * <b> post: </b> Se retorno el listado de Vertices del Grafo. <br>
     * @return Una Lista con el conjunto de Vertices del Grafo.
     */
    public Lista<Vertice> getVertices() {
        return vertices;
    }

    /**
     * @brief Metodo que permite conocer el listado de Aristas del Grafo. <br>
     * <b> post: </b> Se retorno el listado de Aristas del Grafo. <br>
     * @return Una Lista con el conjunto de Aristas del Grafo.
     */
    public Lista<Arista> getAristas() {
        return aristas;
    } 
    
    /**
     * @brief Metodo que permite editar el listado de Vertices del Grafo. <br>
     * <b> post: </b> Se edito el listado de Vertices del Grafo. <br>
     * @param l Representa el nuevo listado de Vertices a reemplazar.
     */
    public void setVertices(Lista<Vertice> l) {
        this.vertices = l;
    }

    /**
     * @brief Metodo que permite editar el listado de Aristas del Grafo. <br>
     * <b> post: </b> Se edito el listado de Aristas del Grafo. <br>
     * @param l Representa el nuevo listado de Aristas a reemplazar.
     */
    public void setAristas(Lista<Arista> l) {
        this.aristas = l;
    }
    
    /**
     * @brief Metodo que permite insertar un nuevo Vertice dentro en el listado del Grafo. <br>
     * <b> post: </b> Se inserto un Vertice dentro del Grafo. <br>
     * @param info Representa la informacion del Vertice que se desea ingresar al Grafo. <br>
     * @return Un objeto de tipo boolean que representa el resultado de la operacion.
     */
    public boolean insertarVertice(T info){
        Vertice v = new Vertice(info);
        if(esta((T) v.getInfo()))
            return (false);
        this.vertices.insertarAlFinal(v);        
        return (true);
    }
    
    /**
     * @brief Metodo que permite insertar una nueva Arista en el Listado del Grafo. <br>
     * <b> post: </b> Se inserto una nueva Arista dentro del Listado del Grafo. <br>
     * @param info1 Representa uno de los Vertices de la Arista del Grafo. <br>
     * @param info2 Representa el otro Vertice de la Arista del Grafo. <br>
     * @return Un objeto de tipo boolean que representa el resultado de la operacion.
     */
    public boolean insertarArista(T info1, T info2){
        Vertice<T> a = this.buscarVertice(info1);
        Vertice<T> b = this.buscarVertice(info2);
        if(a==null || b==null)
            return (false);
        a.insertarVecino(b);
        if(!a.equals(b))
            b.insertarVecino(a);
        this.aristas.insertarAlFinal(new Arista<T>(a,b,-1));
        return (true);
    }
    
    /**
     * @brief Metodo que permite insertar una nueva Arista en el Listado del Grafo. <br>
     * <b> post: </b> Se inserto una nueva Arista dentro del Listado del Grafo. <br>
     * @param info1 Representa uno de los Vertices de la Arista del Grafo. <br>
     * @param info2 Representa el otro Vertice de la Arista del Grafo. <br>
     * @param peso Representa el peso de la Arista que se desea ingresar. <br>
     * @return Un objeto de tipo boolean que representa el resultado de la operacion.
     */
    public boolean insertarAristaP(T info1, T info2, int peso){
        Vertice<T> a = this.buscarVertice(info1);
        Vertice<T> b = this.buscarVertice(info2);
        if(a==null || b==null || peso<0)
            return (false);
        a.insertarVecino(b);
        if(!a.equals(b))
            b.insertarVecino(a);
        this.aristas.insertarAlFinal(new Arista<T>(a,b,peso));
        return (true);
    }
    
    /**
     * @brief Metodo que permite eliminar un Vertice del listado del Grafo; Se eliminan tambien sus relaciones. <br>
     * <b> post: </b> Se elimino el Vertice del grafo, incluso sus relaciones en el mismo. <br>
     * @param info Representa la informacion del Vertice que se desea eliminar. <br>
     * @return  
     */
    public boolean eliminarVertice(T info){
        Lista<Vertice> vaux = new Lista<Vertice>();
        Lista<Arista> aaux = new Lista<Arista>();        
        Vertice v = this.buscarVertice(info);
        if(v==null)
            return false;
        //Eliminar todos los vertices
        for(Arista a: this.aristas){
            if(!a.getVertA().equals(v) && !a.getVertB().equals(v))
                aaux.insertarAlFinal(a);
        }
        this.aristas = aaux;
        for(Vertice vert : this.vertices){
            if(!vert.equals(v))
                vaux.insertarAlFinal(vert);
            else
            vert.eliminarVecino(v);
        }
        this.vertices = vaux;
        return (true);
    }
  
    /**
     * @brief Metodo que permite eliminar una Arista dentro del Grafo. <br>
     * <b> post: </b> Se elimino la Arista del Grafo. <br>
     * @param orig Representa la informacion del Vertice origen de la Arista. <br>
     * @param dest Representa la informacion del Vertice destino de la Arista. <br>
     * @return  
     */
    public boolean eliminarArista(T orig, T dest){
        Lista<Arista> aaux = new Lista<Arista>();        
        Vertice v1 = this.buscarVertice(orig);
        Vertice v2 = this.buscarVertice(dest);
        if(v1==null || v2==null)
            return false;
        //Eliminar todos los vertices
        for(Arista a: this.aristas){
            Vertice vOrig = a.getVertA();
            Vertice vDest = a.getVertB();
            boolean es = (vOrig.equals(v1)&&vDest.equals(v2))||(vOrig.equals(v2)&&vDest.equals(v1));
            if(!es)
                aaux.insertarAlFinal(a);
            else{
                v1.eliminarVecino(v2);
                v2.eliminarVecino(v1);
            }
        }
        this.aristas = aaux;    
        return (true);
    }
    
    /**
     * @brief Metodo que permite buscar un Vertice dentro del listado de Vertices en el Grafo. <br>
     * <b> post: </b> Se retorno el Vertice consultado dentro del Listado. <br>
     * @param info Representa la informacion del Vertice consultado. <br>
     * @return Un Objeto de tipo Vertice que representa el Vertice consultado. <br>
     */
    public Vertice<T> buscarVertice(T info){
        for(Vertice v: this.vertices){
            if(v.getInfo().equals(info))
                return (v);
        }
        return (null);
    }
    
    /**
     * @brief Metodo que permite buscar una Arista dentro del listado de Aristas en el Grafo. <br>
     * <b> post: </b> Se retorno la Arista consultada dentro del Listado. <br>
     * @param info1 Representa la informacion del Vertice en un extremo de la Arista. <br>
     * @param info2 Representa la informacion del Vertice en un extremo de la Arista. <br>
     * @return Un Objeto de tipo Arista que representa la Arista consultada. <br>
     */
    public Arista<T> buscarArista(T info1, T info2){
        for(Arista a : this.aristas){
            if(a.equalsND(new Arista(new Vertice(info1),new Vertice(info2),-1)))
                return (a);
        }
        return (null);
    }
    
    /**
     * @brief Metodo que permite evaluar la existencia de un Vertice dentro del Grafo. <br>
     * <b> post: </b> Se evaluo la existencia de un Vertice dentro del Grafo. <br>
     * @param x Representa el Vertice que se desea consultar. <br>
     * @return Un Objeto de tipo boolean que representa el resultado de la operacion.
     */
    public boolean esta(T x){
        for(Vertice v: this.vertices){
            if(v.getInfo().equals(x))
                return (true);
        }
        return (false);
    }
    
    /**
     * @brief Metodo que permite conocer la matriz de adyacencia del Grafo, que es una de sus representaciones; <br>
     * La primera fila y columna de la matriz representan la informacion de los Vertices, por lo que no posee valores. <br>
     * <b> post: </b> Se retorno la representacion de la matriz de adyacencia del Grafo. <br>
     * @return Una matriz de Object con la representacion del Grafo en su matriz de Adyacencia.
     */
    public Object[][] getMatrizAdyacencia(){       
        Object m[][] = new Object[this.vertices.getTamanio()+1][this.vertices.getTamanio()+1];    
        //Coloco los datos
        int k=1;
        for(Vertice v: this.vertices){
            m[0][k] = v.getInfo().toString();
            m[k++][0] = v.getInfo().toString();            
        }   
        for(int i=1; i<m[0].length; i++)
            for(int j=1; j<m.length; j++)
                m[i][j]=0;
        //Creo la relacion entre los vertices
        m[0][0] = 0;
        for(Arista a: this.aristas){
            int i=vertices.getIndice(a.getVertA())+1;
            int j=vertices.getIndice(a.getVertB())+1;              
            m[i][j]= ((Integer) m[i][j])+1;
            m[j][i]= ((Integer) m[j][i])+1;     
        }  
        return (m);
    }
    
    /**
     * @brief Metodo que permite conocer la Lista de Adyacencia de Grafo; Es una mas de sus representacione; <br>
     * Se ha implementado de manera que se represente atravez de un Arreglo de ListasCD de Vertices. <br>
     * <b> post: </b> Se retorno la lista de Adyacencias del Grafo. <br>
     * @return Un Objecto de tipo Array de Listas (Lista[]) que representa el grado como Lista de Adyacencias.
     */
    public Lista[] getListaAdyacencia(){
        Lista lad[]= new Lista[this.vertices.getTamanio()];
        int i=0;
        while(i<this.vertices.getTamanio()){
            Vertice v = this.vertices.get(i);
            int j=0;
            Lista<Vertice<T>> l = new Lista<Vertice<T>>();
            l.insertarAlFinal(v);
            while(j<v.getVecinos().getTamanio()){
                l.insertarAlFinal((Vertice<T>) v.getVecinos().get(j++));
            }
            lad[i++]=l;
        }
        return (lad);
    }    
    
    /**
     * @brief Metodo que permite conocer si un Grafo es Ponderado; Un Grafo es ponderado cuando <br>
     * sus Aristas poseen un valor que representa costos, tiempos, distancias. <br>
     * <b>post:</b> Se evaluo si el Grafo creado es un Grafo Ponderado. <br>
     * @return Un objeto de tipo boolean con el resultado de la operacion.
     */
    public boolean esGrafoPonderado() {
        for(Arista a: this.aristas){
            if(a.getPeso()==-1)
                return (false);
        }
        return (true);
    }
    
    
    
    /**
     * @brief Metodo de tipo privado que permite visitar los Vecinos de un Vertice y marcalos como visitados. <br>
     * @param v Representa el Vertice del cual se quieren visitar sus vecinos. <br>
     */
    private void visitarVecinos(Vertice v){        
        Lista l = v.getVecinos();
        for(Object obj : l){
            Vertice v2 = (Vertice) obj;
            v2 = this.buscarVertice((T) v2.getInfo());
            if(v2!=null && !v2.getVisit()){
                v2.setVisit(true);
                if(this.visitadosTodos())
                    return;
                this.visitarVecinos(v2);   
            }                   
        }           
    }
    
    /**
     * @brief Metodo de tipo privado que permite evaluar si todos los vertices del Grafo han sido visitados. <br>
     * @return Un objeto de tipo boolean qeu es true= si ha visitado todos los Vertices en el recorrido.
     */
    private boolean visitadosTodos(){
        for(Vertice v : this.vertices)
            if(!v.getVisit())
                return (false);
        return (true);
    }
    
    /**
     * @brief Metodo de tipo privado que permite limpiar la visita de los Vertices dentro de un recorrido. <br>
     */
    private void limpiaVisitasV(){
        for(Vertice v : this.vertices)
            v.setVisit(false);
    }
    
    /**
     * @brief Metodo de tipo privado que permite limpiar la visita de las Aristas dentro de un recorrido. <br>
     */
    private void limpiaVisitasA(){
        for(Arista a : this.aristas)
            a.setVisit(false);
    }
    
    /**
     * @brief Metodo que permite evaluar la existencia de un camino entre dos vertices del Grafo Conexo. <br>
     * <b> post: </b> Se evaluo la existencia de una ruta entre dos vertices. <br>
     * @param orig Representa el vertice en el orgen de la ruta a consultar. <br>
     * @param dest Representa el vertice en el destino de la ruta a consultar. <br>
     * @return Un objeto de tipo boolean que es true si existe ruta entre los vertices.
     */
    public boolean existeRutaEntre(T orig, T dest){
        this.limpiaVisitasV();   
        Vertice v1 = this.buscarVertice(orig);
        Vertice v2 = this.buscarVertice(dest);
        if(v1==null || v2==null)
            return (false);
        boolean rta = existeRuta(v1,v2);
        this.limpiaVisitasV();            
        return (rta);
    }
    
    /**
     * @brief Metodo de tipo privado que permite evaluar la existencia de un camino entre dos vertices del Grafo Conexo. <br>
     * <b> post: </b> Se evaluo la existencia de una ruta entre dos vertices. <br>
     * @param orig Representa el vertice en el orgen de la ruta a consultar. <br>
     * @param dest Representa el vertice en el destino de la ruta a consultar. <br>
     * @return Un objeto de tipo boolean que es true si existe ruta entre los vertices.
     */
    private boolean existeRuta(Vertice orig, Vertice dest){
        if(orig.esAdyacente(dest))
            return (true);        
        Vertice v = this.buscarVertice((T) orig.getInfo());
        if(v==null)
            return (false);
        v.setVisit(true);
        for(Object v3: v.getVecinos()){
            Vertice vert = (Vertice) v3;
            if(!vert.getVisit()){
                if(existeRuta(vert,dest))
                    return (true);
            }
        }
        v.setVisit(false);
        return (false);
    }
    
    /**
     * @brief Metodo que permite devolver el camino entre dos vertices del Grafo Conexo. <br>
     * <b> post: </b> Se retorno la ruta entre dos Vertices de un Grafo conexo. <br>
     * @param orig Representa el vertice en el orgen de la ruta a consultar. <br>
     * @param dest Representa el vertice en el destino de la ruta a consultar. <br>
     * @return La ruta entre los dos vertices indicados, representados en una Lista.
     */
    public Lista<Vertice> getRutaEntre(T orig, T dest){
        Lista<Vertice> l = new Lista<Vertice>();
        this.limpiaVisitasV();   
        Vertice v1 = this.buscarVertice(orig);
        Vertice v2 = this.buscarVertice(dest);
        if(v1==null || v2==null)
            return (l);
        l.insertarAlInicio(v1);            
        if(!getRuta(v1,v2,l))
            l.eliminar(l.getTamanio()-1);
        else 
            l.insertarAlFinal(v2);
        this.limpiaVisitasV();
        return (l);
    }
    
    /**
     * @brief Metodo de tipo privado que permite devolver el camino entre dos vertices del Grafo Conexo. <br>
     * <b> post: </b> Se retorno la ruta entre dos Vertices de un Grafo conexo. <br>
     * @param orig Representa el vertice en el orgen de la ruta a consultar. <br>
     * @param dest Representa el vertice en el destino de la ruta a consultar. <br>
     * @param l Representa la ruta entre los dos Vertices indicados. <br>
     * @return La ruta entre los dos vertices indicados, representados en una Lista.
     */
    public boolean getRuta(Vertice orig, Vertice dest, Lista<Vertice> l){
       if(orig.esAdyacente(dest))
            return (true);        
        Vertice v = this.buscarVertice((T) orig.getInfo());
        if(v==null)
            return (false);
        v.setVisit(true);
        for(Object v3: v.getVecinos()){
            Vertice vert = (Vertice) v3;
            if(!vert.getVisit()){
                l.insertarAlFinal(vert);
                if(getRuta(vert,dest,l))
                    return (true);
                else l.eliminar(l.getTamanio()-1);
            }
        }
        v.setVisit(false);
        return (false);
    }
    
    /**
     * @brief Metodo que permite conocer la longitud en numero de Nodos de camino entre dos vertices del Grafo Conexo. <br>
     * <b> post: </b> Se retorno la longitud de camino de la ruta entre dos Vertices de un Grafo conexo. <br>
     * @param orig Representa el vertice en el orgen de la ruta a consultar. <br>
     * @param dest Representa el vertice en el destino de la ruta a consultar. <br>
     * @return Un objeto de tipo int con la longitud de camino entre los Vertices.
     */
    public int getLongitudDeCamino(T orig, T dest){
        int longi[] = {0};
        this.limpiaVisitasV();   
        Vertice v1 = this.buscarVertice(orig);
        Vertice v2 = this.buscarVertice(dest);
        if(v1==null || v2==null)
            return (-1);          
        if(!longitudDeCam(v1,v2,longi))
            return (-1);
        this.limpiaVisitasV();
        return (longi[0]);
    }
    
    /**
     * @brief Metodo que permite conocer la longitud en numero de Nodos de camino entre dos vertices del Grafo Conexo. <br>
     * <b> post: </b> Se retorno la longitud de camino de la ruta entre dos Vertices de un Grafo conexo. <br>
     * @param orig Representa el vertice en el orgen de la ruta a consultar. <br>
     * @param dest Representa el vertice en el destino de la ruta a consultar. <br>
     * @param longi Representa las longitud de camino para cada uno de los Vertices. <br>
     * @return Un objeto de tipo int con la longitud de camino entre los Vertices.
     */
    public boolean longitudDeCam(Vertice orig, Vertice dest, int longi[]){
       if(orig.esAdyacente(dest)){
           longi[0]++; 
           return (true);        
       }
        Vertice v = this.buscarVertice((T) orig.getInfo());
        if(v==null)
            return (false);
        v.setVisit(true);
        for(Object v3: v.getVecinos()){
            Vertice vert = (Vertice) v3;
            if(!vert.getVisit()){
                longi[0]++;
                if(longitudDeCam(vert,dest,longi))
                    return (true);
                else longi[0]--;
            }
        }
        v.setVisit(false);
        return (false);
    }
    
    /**
     * @brief Metodo que permite conocer la longitud ponderada de camino entre dos vertices del Grafo Conexo. <br>
     * <b> post: </b> Se retorno la longitud de camino de la ruta entre dos Vertices de un Grafo conexo. <br>
     * @param orig Representa el vertice en el orgen de la ruta a consultar. <br>
     * @param dest Representa el vertice en el destino de la ruta a consultar. <br>
     * @return Un objeto de tipo int con la longitud de camino entre los Vertices.
     */
    public int getLongitudPonderadaDeCamino(T orig, T dest){
        if(!esGrafoPonderado())
            return (-1);
        int longi[] = {0};
        this.limpiaVisitasV();   
        Vertice v1 = this.buscarVertice(orig);
        Vertice v2 = this.buscarVertice(dest);
        if(v1==null || v2==null)
            return (-1);          
        if(!longitudPondeDeCam(v1,v2,longi))
            return (-1);
        this.limpiaVisitasV();
        return (longi[0]);
    }
    
    /**
     * @brief Metodo que permite conocer la longitud en sumatoria del peso de aristas de camino entre dos vertices del Grafo Conexo. <br>
     * <b> post: </b> Se retorno la longitud de camino de la ruta entre dos Vertices de un Grafo conexo. <br>
     * @param orig Representa el vertice en el orgen de la ruta a consultar. <br>
     * @param dest Representa el vertice en el destino de la ruta a consultar. <br>
     * @param longi Representa las longitud de camino para cada uno de los Vertices. <br>
     * @return Un objeto de tipo int con la longitud de camino entre los Vertices.
     */
    public boolean longitudPondeDeCam(Vertice orig, Vertice dest, int longi[]){
       if(orig.esAdyacente(dest)){ 
           longi[0] = (Integer)longi[0] + ((Integer)this.buscarArista((T)orig.getInfo(),(T)dest.getInfo()).getPeso()); 
           return (true);        
       }
        Vertice v = this.buscarVertice((T) orig.getInfo());
        if(v==null)
            return (false);
        v.setVisit(true);
        for(Object v3: v.getVecinos()){
            Vertice vert = (Vertice) v3;
            if(!vert.getVisit()){
                longi[0] = (Integer)longi[0] + ((Integer)this.buscarArista((T)v.getInfo(),(T)vert.getInfo()).getPeso()); 
                if(longitudPondeDeCam(vert,dest,longi))
                    return (true);
                else 
                    longi[0] = longi[0] - ((Integer) this.buscarArista((T)v.getInfo(),(T)vert.getInfo()).getPeso()); 
            }
        }
        v.setVisit(false);
        return (false);
    }
    
    /**
     * @brief Metodo que permite calcular el peso de la ruta minima entre dos Vertices indicados. <br>
     * <b> post:</b> Se retorno la longitud de la ruta minima entre dos Vertices. <br>
     * @param ini Representa el Vertice inicial en el recorrido del Dijsktra. <br>
     * @param fin Representa el Vertice final en el recorrido del Dijsktra. <br>
     * @return Un objeto de tipo int con el valor de la longitud de la ruta Minima.
     */    
    public int longRutaMinimaDijkstra(T ini, T fin){
        if(this.hayPesosNegativosONullos())
            return (-1);
        this.limpiaVisitasV();
        int costos[] = new int[vertices.getTamanio()];
        Vertice vIni = this.buscarVertice(ini);
        Vertice vFin = this.buscarVertice(fin);
        if(vIni==null || vFin==null)
            return (-1);  
        vIni.setVisit(true);              
        this.dijkstra(vIni,vFin,costos);
        this.limpiaVisitasV();
        return (costos[vertices.getIndice(vFin)]);
    }
    
    
    /**
     * @brief Metodo que permite calcular el peso de la ruta minima entre dos Vertices indicados. <br>
     * <b> post:</b> Se retorno la longitud de la ruta minima entre dos Vertices. <br>
     * @param vIni Representa el Vertice inicial en el recorrido del Dijsktra. <br>
     * @param vFin Representa el Vertice final en el recorrido del Dijsktra. <br>
     * @param costos Representa los costos minimos de cada vertice en el recorrido. <br>
     */ 
    private void dijkstra(Vertice vIni, Vertice vFin, int costos[]) {        
        if(vIni.equals(vFin)){
            return;            
        }
        for(Object v: vIni.getVecinos()){
            Vertice vert = (Vertice)v;
            Vertice orig = this.buscarVertice((T) vert.getInfo());
            int p = costos[vertices.getIndice(vIni)];
            int c = costos[vertices.getIndice(orig)];
            int pesoAri = ((Integer) buscarArista((T) vIni.getInfo(), (T) orig.getInfo()).getPeso());
            if(!orig.getVisit()){
                orig.setVisit(true);
                if(c==0 || c>(p+pesoAri)){
                    costos[vertices.getIndice(orig)] = (p+pesoAri);
                }
                dijkstra(orig,vFin,costos);
                orig.setVisit(false);
            }
        }
        
    }
    
    /**
     * @brief Metodo de tipo privado que permite calcular el peso de la ruta minima entre dos Vertices indicados. <br>
     * <b> post:</b> Se retorno la ruta minima entre dos Vertices. <br>
     * @param ini Representa el Vertice inicial en el recorrido del Dijsktra. <br>
     * @param fin Representa el Vertice final en el recorrido del Dijsktra. <br>
     * @return Un objeto de tipo int con el valor de la longitud de la ruta Minima.
     */
    public Lista<Vertice> rutaMinimaDijkstra(T ini, T fin){
        Lista<Vertice> l = new Lista<Vertice>();
        if(this.hayPesosNegativosONullos())
            return (l);
        this.limpiaVisitasV();
        int costos[] = new int[vertices.getTamanio()];
        Vertice vIni = this.buscarVertice(ini);
        Vertice vFin = this.buscarVertice(fin);
        if(vIni==null || vFin==null)
            return (l);  
        vIni.setVisit(true);              
        this.dijkstra(vIni,vFin,costos,l);
        //Aqui deberia hacer el recorrido invertido
        vFin = this.buscarVertice(fin);
        while(vFin!=null){
            l.insertarAlInicio(vFin);
            vFin = vFin.getPredecesor();
        }
        this.limpiarPredecesores();
        this.limpiaVisitasV();
        return (l);
    }
    
    /**
     * @brief Metodo que permite calcular el peso de la ruta minima entre dos Vertices indicados. <br>
     * <b> post:</b> Se retorno la ruta minima entre dos Vertices. <br>
     * @param vIni Representa el Vertice inicial en el recorrido del Dijsktra. <br>
     * @param vFin Representa el Vertice final en el recorrido del Dijsktra. <br>
     * @param costos Representa los costos minimos de cada vertice en el recorrido. <br>
     * @param l Representa el recorrido del camino minimo entre dos vertices. <br>
     */ 
    private void dijkstra(Vertice vIni, Vertice vFin, int costos[], Lista<Vertice> l) {        
        if(vIni.equals(vFin)){
            return ;            
        }
        for(Object v: vIni.getVecinos()){
            Vertice vert = (Vertice)v;
            Vertice orig = this.buscarVertice((T) vert.getInfo());
            int p = costos[vertices.getIndice(vIni)];
            int c = costos[vertices.getIndice(orig)];
            int pesoAri = ((Integer) buscarArista((T) vIni.getInfo(), (T) orig.getInfo()).getPeso());
            if(!orig.getVisit()){
                orig.setVisit(true);
                if(c==0 || c>(p+pesoAri)){                    
                    costos[vertices.getIndice(orig)] = (p+pesoAri); 
                    orig.setPredecesor(vIni);
                }
                dijkstra(orig,vFin,costos,l);
                orig.setVisit(false);
            }
        }
    }

    /**
     * @brief Metodo de tipo privado que permite evaluar la existencia de Aristas con peso negativo. <br>
     * @return Un objeto de tipo boolean con true si existen aristas con pesos negativos. <br>
     */
    private boolean hayPesosNegativosONullos() {
        for(Arista a: this.aristas){
            if(a.getPeso()==-1 || (a.getPeso()!=-1&&((Integer)a.getPeso())<0))
                return (true);
        }
        return (false);
    }
    
    /**
     * @brief Metodo que permite calcular la ruta mas corta entre dos Vertices indicados. <br>
     * <b> post:</b> Se retorno la ruta mas corta entre dos Vertices. <br>
     * @param ini Representa el Vertice inicial en el recorrido. <br>
     * @param fin Representa el Vertice final en el recorrido. <br>
     * @return Un objeto de tipo int con el valor de la longitud de la ruta mas corta.
     */
    public int rutaMasCorta(T ini, T fin){
        this.limpiaVisitasV();
        int cant[] = new int[vertices.getTamanio()];
        Vertice vIni = this.buscarVertice(ini);
        Vertice vFin = this.buscarVertice(fin);
        if(vIni==null || vFin==null)
            return (-1);   
        vIni.setVisit(true);             
        int tam =1;
        this.rutaMasCorta(vIni,vFin,cant,tam);
        this.limpiaVisitasV();
        return (cant[vertices.getIndice(vFin)]);
    }

    /**
     * @brief Metodo de tipo privado que permite retornar la longitud de la ruta mas corta entre 2 vertices. <br>
     * @param vIni Representa el Vertice inicial del recorrido. <br>
     * @param vFin Representa el Vertice final o destino final del recorrido. <br>
     * @param cant Representa la cantidada de iteraciones realizadas sobre e Grafo. <br>
     * @param tam Representa el tamaño la ruta minima entre los 2 vertices.
     */
    private void rutaMasCorta(Vertice vIni, Vertice vFin, int cant[], int tam) {        
        tam++;
        if(vIni.equals(vFin)){
            return;            
        }
        for(Object v: vIni.getVecinos()){
            Vertice vert = (Vertice)v;
            Vertice orig = this.buscarVertice((T) vert.getInfo());
            int c = cant[vertices.getIndice(orig)];
            if(!orig.getVisit()){
                orig.setVisit(true);
                if(c==0)
                    cant[vertices.getIndice(orig)]=tam;
                else 
                if(c==0 || c>tam){
                    cant[vertices.getIndice(orig)] = tam;
                }
                rutaMasCorta(orig,vFin,cant,tam);
                orig.setVisit(false);
            }
        }
        
    }
    
    /**
     * @brief Metodo que permite conocer si un Grafo se encuentra o no vacio. <br>
     * <b>post:</b> Se evaluo la existencia de datos dentro del Grafo. <br>
     * @return Un objeto de tipo boolean con true si el Grafo se encuentra vacio.
     */
    public boolean esVacio(){
        return (this.vertices.esVacia());
    }
    
    /**
     * @brief Metodo que permite conocer si dos vertices son adyacentes/vecinos. <br>
     * @param orig Representa el Vertice del cual se desea saber si es adyacente. <br>
     * @param dest Representa el Vertice del cual se desea saber si es adyacente. <br>
     * @return Un objeto de tipo boolean que evalua la adyacencia de los dos Vertices.
     */
    public boolean sonVerticesAdyacentes(T orig, T dest){
        Vertice<T> a = this.buscarVertice(orig);
        Vertice<T> b = this.buscarVertice(dest);
        if(a==null || b==null)
            return (false);
        //Vertice a es Adyacenta a b, o es adyacente desde b.
        return (a.esAdyacente(b)||b.esAdyacente(a));
    }
    
    
    /**
     * @brief Metodo que permite conocer los vertices adyacentes/vecinos a un vertice indicado. <br>
     * <b>post:</b> Se retorno el conjunto de Vertices vecinos al info indicado. <br>
     * @param info Representa la informacion del Vertice que se desea evaluar. <br>
     * @return Un objeto de tipo Lista con los vertices vecinos al Vertice indicado. 
     */
    public Lista<Vertice> getVecinosVertice(T info){
        Vertice v = this.buscarVertice(info);
        if(v==null)
            return (null);
        return (v.getVecinos());
    }

    /**
     * @brief Metodo que permite limpiar el apuntador a los Vertices predecesores en el recorrido realizado. <br>
     */
    private void limpiarPredecesores() {
        for(Vertice v : this.vertices)
            v.setPredecesor(null);
    }
    
    /**
     * @brief Metodo que permite conocer el peso del Grafo. <br>
     * <b>post:</b> Se retorno el peso del Grafo. <br> 
     * @return Un valor int con el peso del Grafo.
     */
    public int getPeso(){
        return (this.vertices.getTamanio());
    }    
    
    @Override
    public String toString(){
        String cad = "Vertices: ";
        for(Vertice v:this.vertices){
            cad+=v.getInfo()+",";
        }
        cad+="\nAristas:";
        for(Arista a:this.aristas){
            cad+=a.toString()+",";
        }
        return (cad);
    }
    
}// Fin de la Clase GrafoND - Grafo No Dirigido
