/**
* @class SerializableGenerico.java 
* @brief Implementacion de la Clase SerializableGenerico</br>
* La clase SerializableGenerico Clase que  nos ayuda a serializar objetos a ficheros Binarios;
* @param <T> tipo de dato a serializarse
* @author SoftTux
* @version 0.2
* @since 1.0
* @see https://github.com/jkazuo55/TallerDeProgramacionJava
*/
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializableGenerico<T> {
 private String fileName;
 private T serData;
 
 public SerializableGenerico(String fileName, T serData) {
  super();
  this.fileName = fileName;
  this.serData = serData;
 }

 public String getFileName() {
  return fileName;
 }

 public void setFileName(String fileName) {
  this.fileName = fileName;
 }

 public T getSerData() {
  return serData;
 }

 public void setSerData(T serData) {
  this.serData = serData;
 }
 
 
 public void serialize() {
  FileOutputStream fos = null;
  ObjectOutputStream oos = null;
  
  try {
   fos = new FileOutputStream(fileName);
   oos = new ObjectOutputStream(fos);
   oos.writeObject(serData);
   oos.close();
   fos.close();
  } catch(Exception e) {
   e.printStackTrace();
  }
 }
}