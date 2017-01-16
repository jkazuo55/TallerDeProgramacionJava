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
     
      public T deserialize() {
        T data = null;
        FileInputStream fis=null;
        ObjectInputStream ois= null;
          // data = new Lista();
        try {
            fis = new FileInputStream(fileName);
            if (fis!=null) {
                System.out.println(fis);
                ois = new ObjectInputStream(fis);
                data = (T) ois.readObject();
            }

            // System.out.println(data+"-----------------------------la data despues del casting");

            ois.close();
            fis.close();
        }catch(IOException e) {
            e.printStackTrace();
        }catch(ClassNotFoundException e) {
            System.out.println( data +" class not found");
            e.printStackTrace();
        }
        return data;
      }

      public boolean tieneDatos(){
          boolean res = false;
          FileInputStream fis = null;
          ObjectInputStream ois= null;
          try{
          fis = new FileInputStream(fileName);
          if (fis!=null) {
              System.out.println(fis);
              ois = new ObjectInputStream(fis);
              if(ois != null){
                  res = true;
                  System.out.println("Archivo con datos");
              }else{
                  System.out.println("Archivo sin datos");
              
              }
          }
          }catch(IOException e){
              e.printStackTrace();
          }
          return res;
      }
 
}
