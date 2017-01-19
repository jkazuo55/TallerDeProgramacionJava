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
                ois.close();
                fis.close();
            }
        }catch(IOException e) {
            e.printStackTrace();
        }catch(ClassNotFoundException e) {
            System.out.println( data +" class not found");
            e.printStackTrace();
        }
        return data;
      }
 
}