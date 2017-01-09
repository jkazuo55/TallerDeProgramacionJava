/**
* <h2>SISTEMA GESTION DE EMIGRANTES </h2>
* @class Ciudad.java
* @brief Implementacion de la clase Ciudad ayuda a manejar la informacion de una Ciudad 
* @author SoftTux
* @version 0.2
* @since 1.0
* @see <a>https://github.com/jkazuo55/TallerDeProgramacionJava<a/>
*/
package org.softtux.model;

public class Ciudad{
  
	private String nombre; //!< Representa el nombre de la Ciudad
	private int codigo;    //!< Representa el codido asignado ala Ciudad
	private Lista<Emigrante>listaEmigrantes;//!<Representa una Lista de tipo PersonaEmigrange

	/**
     * @brief Metodo constructor de Ciudad que inicializa una listaEmigrantes de Tipo PersonaEmigrante.</br>
     * <b> post: </b> Se creo un nueva Ciudad sin Emigrantes.
     */
	public Ciudad(){
		listaEmigrantes= new Lista<Emigrante>();//!<Inicializar una listaEmigrantes vacia
	}

	//===========Metodos setters ==============

	/**
	* @brief funsion setNombre modifica el nombre de la ciudad 
	* @param nombre representa en nuevo nombre de ciudad
	*/
	public void setNombre(String nombre){
		this.nombre=nombre;
	}
	/**
	* @brief funsion setCodigo modifica el codigo de la ciudad 
	* @param codigo representa en nuevo codigo de ciudad
	*/
	public void setCodigo(int codigo){
		this.codigo=codigo;
	}

	//==========Metodos getters =================

	/**
	* @brief funsion getNombre solicita el nombre de la Ciudad 
	* @return Devuelve el nombre de la Ciudad
	*/
	public String getNombre(){
		return this.nombre;
	}

	/**
	* @brief funsion getCodigo solicita el codigo de la Ciudad 
	* @return Devuelve el codigo de la Ciudad
	*/
	public int getCodigo(){
		return this.codigo;
	}

    /**
	* @brief Solicita la lista de PersonasEmigrante de la Ciudad 
	* @return Devuelve el una lista de Emigrantes
	*/
    public Lista<Emigrante> getListaEmigrantes(){
        return this.listaEmigrantes;
    }

	//=========== Metodos operacionales===========

	/**
	* @brief Agrega personas emigrantes en la listaEmigrantes 
	* @param emigrante es una nueva PersonaEmigrante
	*/
	public void registrarEmigrante(Emigrante emigrante){
		listaEmigrantes.insertarAlFinal(emigrante);
	}

	/**
	* @brief concatenacion de Strings    
	* @return imprimi concatenacion de variable y valor de Ciudad 
	*/
	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nNombre: ");
        sb.append(nombre);
        sb.append("\ncodigo: ");
        sb.append(codigo);

        return sb.toString();
    }

}
