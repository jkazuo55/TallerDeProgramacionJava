//package modelo.serializacion;


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