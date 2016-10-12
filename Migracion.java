import java.util.Hashtable;
import java.util.ArrayList;

public class Migracion{
    private ArrayList<Ciudad>listaCiudades;
    // private Grafo mapa;
    private int[][]flujoEmigrantes ={{0,1,0,1,0,1,0,0,0},
                                   {1,0,1,0,0,0,0,0,0},
                                   {0,45,0,0,34,0,0,0,0},
                                   {1,0,0,0,1,1,0,1,0},
                                   {0,0,56,7,0,0,0,5,0},
                                   {1,0,0,1,0,0,1,0,0},
                                   {0,0,0,0,0,1,0,0,1},
                                   {0,0,0,1,1,0,0,0,1},
                                   {0,0,0,0,0,0,1,1,0}};

    private int[][]matrizMapa =  { {0,1,0,1,0,1,0,0,0},
                                   {1,0,1,0,0,0,0,0,0},
                                   {0,1,0,0,1,0,0,0,0},
                                   {1,0,0,0,1,1,0,1,0},
                                   {0,0,1,1,0,0,0,1,0},
                                   {1,0,0,1,0,0,1,0,0},
                                   {0,0,0,0,0,1,0,0,1},
                                   {0,0,0,1,1,0,0,0,1},
                                   {0,0,0,0,0,0,1,1,0}};
    // public Migracion(){
    //     this.listaCiudades = new ArrayList<Ciudad>();
    //     this.mapa = new Grafo();
    //     // this.flujoEmigrantes = new Grafo();
    // }

    public ArrayList<Reporte> flujoEmigrantes(String nombreCiudad){

        ArrayList<Reporte> listaReporte =new ArrayList<Reporte>();
        boolean estadoCiudad = buscarCiudad(nombreCiudad);
        int indiceCiudadInicio= tablas(nombreCiudad);
        String indiceCiudadDestino;
        // Reporte reporte=new Reporte();
        if (estadoCiudad) {
            for (int i=0;i<8;i++ ) {
                if (flujoEmigrantes[indiceCiudadInicio][i]>0){
                    listaReporte.add(new Reporte(tablas2(i),flujoEmigrantes[indiceCiudadInicio][i]));
                }
            }
        }
        return listaReporte;       
    }

    public boolean buscarCiudad(String nombreCiudad){
        boolean encontrado =false;
        int i=0;
        while(encontrado == false && i<listaCiudades.size()){
            if (listaCiudades.get(i).getNombre().compareToIgnoreCase(nombreCiudad)==0) {
                encontrado=true;
            }else{
                i++;
            }
        }
        if (encontrado) {
            return true;
        }else{
            return false;
        }
    }

    // public void mostrarFlujoEmigrantes(String nombreCiudad){
        
        
    // }

    // public String fechaMigracion(String nombre, String apellido){
        
    
    // }

    // public ArrayList<PersonaSaliente> listaGeneral(){
    
    
    // }

    // public Grafo representacionMatrizDePesos(ArrayList<PersonaSaliente> listaEmigrantes){
    
    
    // }

    // public void mostrarMatrizDePesos(){
    
    
    // }

    // public void menu(){
    
    
    // }

        public  int tablas(String nombreCiudad){
            Hashtable<String,Integer> tabla = new Hashtable<String,Integer>();
            tabla.put("la paz",1);
            tabla.put("pando",2);
            tabla.put("beni",3);
            tabla.put("cochabamba",4);
            tabla.put("santa cruz",5);
            tabla.put("oruro",6);
            tabla.put("potosi",7);
            tabla.put("chuquisaca",8);
            tabla.put("tarija",9);

            return tabla.get(nombreCiudad);
        }
        public  String tablas2(int numero){
            Hashtable<Integer,String> tabla = new Hashtable<Integer,String>();
            tabla.put(1,"la paz");
            tabla.put(2,"pando");
            tabla.put(3,"beni");
            tabla.put(4,"cochabamba");
            tabla.put(5,"santa cruz");
            tabla.put(6,"oruro");
            tabla.put(7,"potosi");
            tabla.put(8,"chuquisaca");
            tabla.put(9,"tarija");

            return tabla.get(numero);
        }

    public static void main(String args[]){

        Migracion probando=new Migracion();
        probando.tablas("cochabamba");
        probando.tablas2(4);
        probando.flujoEmigrantes("cochabamba");
    
    }




}
