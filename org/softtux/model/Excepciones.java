/**
* @class Excepciones.java 
* @brief Implementacion de clase para manejo de las excepciones generadas en algunas Estructuras de Datos
* @author SoftTux
* @version 0.2
* @since 1.0
* @see https://github.com/jkazuo55/TallerDeProgramacionJava
*/ 
package org.softtux.model;

public class Excepciones extends Exception{
    
    /**
     * @brief Constructor con mensaje
     * @param mensaje Mensaje de error
     */
    public Excepciones(String mensaje)
    {
        super(mensaje);
    }
    
    /**
     * @brief Metodo que retorna el mensaje de error para la excepcion generada. <br>
     * @return Mensaje de error representativo de la Excepcion generada.
     */
    public String getMensaje(){
        return (super.getMessage());
    }
}
