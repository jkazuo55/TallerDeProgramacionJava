import java.util.Hashtable;
import java.util.ArrayList;

public class Migracion{

    private ArrayList<Ciudad>listaCiudades;

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

    public Migracion(){
        this.listaCiudades = new ArrayList<Ciudad>();
    }

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

    public void mostrarFlujoEmigrantes(String nombreCiudad){
    
    
    }

    public String fechaMigracion(String nombre, String apellido){
        String res = "";
        ArrayList<PersonaEmigrante> listaGeneralEmigrantes = listaGeneral();
        PersonaEmigrante emigrante_encontrado = null;
        PersonaEmigrante emigrante;
        String name;
        String last_name;
        Boolean encontrado = false;
        int index = 0;
        while(!encontrado && index <= listaGeneralEmigrantes.size()){
            emigrante = listaGeneralEmigrantes.get(index);
            name = emigrante.getNombre();
            apellido = emigrante.getApellido();
            if(name.equals(nombre) && apellido.equals(apellido)){
                emigrante_encontrado = emigrante;
                encontrado = true;
            }
            index++;
        }
        if(emigrante_encontrado != null){
            res = emigrante_encontrado.getFecha();
        }else{
            res = "noencontrado";
        }
        return res;
    }

    public void registrarCiudad(Ciudad ciudad){
        this.listaCiudades.add(ciudad);
    }

    public ArrayList<PersonaEmigrante> listaGeneral(){
        ArrayList<PersonaEmigrante> listaEmigrantesGeneral = new ArrayList<PersonaEmigrante>();
        ArrayList<PersonaEmigrante> listaEmigrantesParticular;
        ArrayList<Ciudad> list = this.listaCiudades;
        if(!list.isEmpty()){
            for(Ciudad ciudad: list){
                listaEmigrantesParticular = ciudad.getListaEmigrantes();
                if(!listaEmigrantesParticular.isEmpty()){
                    for(PersonaEmigrante emigrante: listaEmigrantesParticular){
                        listaEmigrantesGeneral.add(emigrante);
                    }
                }
            } 
        }
        return listaEmigrantesGeneral; 
    }

    public void representacionMatrizDePesos(ArrayList<PersonaEmigrante> listaEmigrantes){
        String origen;
        String destino;
        int cantidad;
        if(!listaEmigrantes.isEmpty()){
            for(PersonaEmigrante emigrante: listaEmigrantes){
                origen = emigrante.getNacidoEn();
                destino = emigrante.getDestino();
                System.out.println(origen);
                System.out.println(destino);
            }
        }
    }

    public void mostrarMatrizDePesos(){
    
    
    }

    public void menu(){
    
    
    }

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
        Migracion migracion = new Migracion();
        Ciudad cochabamba = new Ciudad();
        Ciudad lapaz = new Ciudad();
        cochabamba.setNombre("Cochabamba");
        cochabamba.setCodigo(4);
        lapaz.setNombre("La Paz");
        lapaz.setCodigo(1);
        PersonaEmigrante pedro = new PersonaEmigrante("Jose Pedro","Dominguez Serrano","masculino","9350610CB","Cochabamba",35,"La Paz","01/01/1993"); 
        PersonaEmigrante juan = new PersonaEmigrante("Juan","Serrano","masculino","5678543LP","La Paz",45,"Cochabamba","01/01/1999"); 
        cochabamba.registrarEmigrante(pedro);
        lapaz.registrarEmigrante(juan);
        migracion.registrarCiudad(cochabamba);
        migracion.registrarCiudad(lapaz);
         for(PersonaEmigrante emigrante: migracion.listaGeneral()){
            System.out.println(emigrante.getNombre());
         }
         String fecha = migracion.fechaMigracion("Jose Pedro","Dominguez Serrano");
         System.out.println(fecha);
         migracion.representacionMatrizDePesos(migracion.listaGeneral());

        ArrayList<Reporte> reportes =  migracion.flujoEmigrantes("cochabamba");
        for(Reporte reporte: reportes){
            System.out.println(reporte.getNombreCiudad());
            System.out.println(reporte.getFlujo());
        
        
        }
        
    }

}
