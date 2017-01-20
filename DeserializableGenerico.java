/**
* @class DeserializableGenerico.java 
* @brief Implementacion de la Clase DeserializableGenerico</br>
* La clase DeserializableGenerico que nos ayuda a descerializar las los archivos serializados y refrescarlos en memoria;
* @param <T> un tpo de objto geneerico 
* @author SoftTux
* @version 0.2
* @since 1.0
* @see https://github.com/jkazuo55/TallerDeProgramacionJava
*/
import java.io.*;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeserializableGenerico<T> {
 
     private String fileName;
     
     public DeserializableGenerico(String fileName) {
      super();
      this.fileName = fileName;
     }

     public String getFileName() {
      return fileName;
     }

     public void setFileName(String fileName) {
      this.fileName = fileName;
     }
     
    public T deserialize(T data){
        // T data=null;
        // System.out.println(a);
        try{
            FileInputStream fis = new FileInputStream(fileName); //creamos un archivo.bin
            ObjectInputStream in = new ObjectInputStream(fis);
            if(in != null){
                data = (T) in.readObject();//leemos el objeto todo lo que se encuentre en archivo bin
                in.close();   
                // System.out.println(a);                   //cerramos
                System.out.println(in+"entro a deserializar");                   //cerramos
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            System.out.println("el fichero esta vacio");
        }
        return data;  
    }
 
}





