
/**
 * @class Nodo.java 
 * @brief Nodo contiene la informacion de los nodos de una lista Doblemente enlazada
 * @param <T> Tipo de datos a almacenar dentro del Nodo Doble.
 * @author SoftTux
 * @version 0.2
 * @since 1.0
 * @see https://github.com/jkazuo55/TallerDeProgramacionJava
 */

public class Nodo<T> implements java.io.Serializable{
    
    private T info; //!<Informacion del Nodo     
    private Nodo<T> ant; //!<Nodo Anterior
    private Nodo<T> sig; //!<Nodo Siguiente  

       
    /**
     * @brief Constructor de un Nodo Doble vacio. <br>
     * <b>post: </b> Se construyo un Nodo Doble vacio con la informacion en NULL.
     */
    public Nodo() {
        this.info=null;
        this.ant=null;
        this.sig=null; 
    }

    /**
     * @brief Constructor con parametros de la clase Nodo <br>
     * <b>post: </b> Se construyo un nodo doble con los datos especificados.<br>
     * @param info de tipo T y contiene la informacion del nodo
     * @param sig es del tipo Nodo<T> y contiene la direccion del Nodo siguiente
     * @param ant es de tipo Nodo<T> y contiene la direccion del Nodo anterior
     */
    public Nodo(T info, Nodo<T> sig, Nodo<T> ant){        
        this.info=info;
        this.sig=sig;
        this.ant=ant;        
    }
    
    /**
     * @brief Metodo que permite obtener el contenido del Nodo doble<br>
     * <b>post: </b> Se retorno la informacion del Nodo doble.<br>
     * @return un tipo T que contiene la informacion del Nodo doble
     */
    protected T getInfo(){        
        return(this.info);        
    }
    
    /**
     * @brief Metodo que permite obtener la direccion del Nodo anterior al actual<br>
     * <b>post: </b> Se retorno la informacion del Nodo anterior al actual.<br>
     * @return un Nodo<T> que contiene 
     */
    protected Nodo<T> getAnt(){        
        return (this.ant);        
    }
    
    /**
     * @brief Metodo que permite devolver el nodo siguiente al que apunta el Nodo doble<br>
     * <b>post: </b> Se retorno la informacion del Nodo siguiente al actual.<br>
     * @return un tipo Nodo<T> que contiene el nodo siguiente
     */
    protected Nodo<T> getSig(){        
        return (this.sig);        
    }
    
    /**
     * @brief Metodo que permite cambiar la informacion contenida en el Nodo doble<br>
     * <b>post: </b> Se edito la informacion del Nodo Doble. <br>
     * @param info es de tipo T y contiene la informacion nueva del nodo dooble
     */
    protected void setInfo(T info){        
        this.info = info;            
    }

    /**
     * @brief Metodo que permite editar la dirección del nodo anterior por una nueva<br>
     * <b>post: </b> Se edito la informacion del Nodo anterior del nodo actual. <br>
     * @param ant es de tipo Nodo<T> y contiene la nueva dirección del nodo anterior
     */
    protected void setAnt(Nodo<T> ant){        
        this.ant=ant;        
    }
    
    /**
     * @brief Metodo que permite cambiar el nodo siguiente del Nodo doble actual<br>
     * <b>post: </b> Se edito la informacion del Nodo siguiente del nodo actual. <br>
     * @param sig es de tipo Nodo<T> y contien la informacion del nuevo nodo siguiente
     */
    protected void setSig(Nodo<T> sig){        
        this.sig=sig;	        
    }

} //Fin de la Clase Nodo