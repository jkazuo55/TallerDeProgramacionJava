

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
 
 public T deserialize() {
  T data = null;
  try {
      FileInputStream fis = new FileInputStream(fileName);
      ObjectInputStream ois = new ObjectInputStream(fis);
      data = (T) ois.readObject();
      ois.close();
      fis.close();
  } catch(Exception e) {
      e.printStackTrace();
  }
  return data;
 }
 
}