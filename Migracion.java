import java.util.Hashtable;
import java.util.ArrayList;

public class Migracion{

    private ArrayList<Ciudad>listaCiudades;

    private int[][]flujoEmigrantes ={{0,0,0,0,0,0,0,0,0},
                                   {0,0,0,0,0,0,0,0,0},
                                   {0,0,0,0,0,0,0,0,0},
                                   {0,0,0,0,0,0,0,0,0},
                                   {0,0,0,0,0,0,0,0,0},
                                   {0,0,0,0,0,0,0,0,0},
                                   {0,0,0,0,0,0,0,0,0},
                                   {0,0,0,0,0,0,0,0,0},
                                   {0,0,0,0,0,0,0,0,0}};

    private int[][]matrizMapa =  { {0,1,0,1,0,1,0,0,0},
                                   {1,0,1,0,0,0,0,0,0},
                                   {0,1,0,0,1,0,0,0,0},
                                   {1,0,0,0,1,1,0,1,0},
                                   {0,0,1,1,0,0,0,1,0},
                                   {1,0,0,1,0,0,1,0,0},
                                   {0,0,0,0,0,1,0,0,1},
                                   {0,0,0,1,1,0,0,0,1},
                                   {0,0,0,0,0,0,1,1,0}};

    Hashtable<String,Integer> tablas; 
    Hashtable<Integer,String> tablas2;


    public Migracion(){
        this.listaCiudades = new ArrayList<Ciudad>();
        tablas = new Hashtable<String,Integer>();
        tablas2 = new Hashtable<Integer,String>();
        init_tablas();
        init_tablas2();
    }

    public ArrayList<Reporte> flujoEmigrantes(String nombreCiudad){

        ArrayList<Reporte> listaReporte =new ArrayList<Reporte>();
        boolean estadoCiudad = buscarCiudad(nombreCiudad);
        int indiceCiudadInicio= tablas.get(nombreCiudad);
        String indiceCiudadDestino;
        // Reporte reporte=new Reporte();
        if (estadoCiudad) {
            for (int i=0;i<8;i++ ) {
                if (flujoEmigrantes[indiceCiudadInicio][i]>0){
                    listaReporte.add(new Reporte(tablas2.get(i),flujoEmigrantes[indiceCiudadInicio][i]));
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
        int indice_origen;
        int indice_destino;
        int cantidad;
        if(!listaEmigrantes.isEmpty()){
            for(PersonaEmigrante emigrante: listaEmigrantes){
                origen = emigrante.getNacidoEn();
                destino = emigrante.getDestino();
                indice_origen = tablas.get(origen);
                indice_destino = tablas.get(destino);
                if(matrizMapa[indice_origen][indice_destino]==1){
                    flujoEmigrantes[indice_origen][indice_destino] += 1;
                }
                System.out.println(origen);
                System.out.println(destino);
            }
        }
    }

    public void mostrarMatrizDePesos(){
    
    
    }

    public void menu(){
    
    
    }

        public void init_tablas(){
            
            tablas.put("la paz",0);
            tablas.put("pando",1);
            tablas.put("beni",2);
            tablas.put("cochabamba",3);
            tablas.put("santa cruz",4);
            tablas.put("oruro",5);
            tablas.put("potosi",6);
            tablas.put("chuquisaca",7);
            tablas.put("tarija",8);

        }
        public void init_tablas2(){
            
            tablas2.put(0,"la paz");
            tablas2.put(1,"pando");
            tablas2.put(2,"beni");
            tablas2.put(3,"cochabamba");
            tablas2.put(4,"santa cruz");
            tablas2.put(5,"oruro");
            tablas2.put(6,"potosi");
            tablas2.put(7,"chuquisaca");
            tablas2.put(8,"tarija");
        }

    public void imprimirGrafo(){
        System.out.printf("  %d" , 0);
        for (int i = 1; i < flujoEmigrantes.length; i++) {
            System.out.printf(" %d" , i);
        }
        System.out.println();
        
        for(int i = 0; i < flujoEmigrantes.length; i++){
            System.out.printf("%d ",i);
            for(int j = 0; j < flujoEmigrantes[i].length; j++){
                System.out.printf("%d " , flujoEmigrantes[i][j]);
            }
            System.out.println();
        }
    }    

    public static void main(String args[]){
        Migracion migracion = new Migracion();
        Ciudad cochabamba = new Ciudad();
        Ciudad lapaz = new Ciudad();
        cochabamba.setNombre("cochabamba");
        cochabamba.setCodigo(4);
        lapaz.setNombre("la paz");
        lapaz.setCodigo(1);
        PersonaEmigrante pedro = new PersonaEmigrante("Jose Pedro","Dominguez Serrano","masculino","9350610CB","cochabamba",35,"la paz","01/01/1993"); 
        PersonaEmigrante juan = new PersonaEmigrante("Juan","Serrano","masculino","5678543LP","la paz",45,"cochabamba","01/01/1999"); 
        PersonaEmigrante juan1 = new PersonaEmigrante("Juan","Serrano","masculino","5678543LP","la paz",45,"cochabamba","01/01/1999"); 
        cochabamba.registrarEmigrante(pedro);
        cochabamba.registrarEmigrante(juan1);
        lapaz.registrarEmigrante(juan);
        migracion.registrarCiudad(cochabamba);
        migracion.registrarCiudad(lapaz);
         for(PersonaEmigrante emigrante: migracion.listaGeneral()){
            System.out.println(emigrante.getNombre());
         }
         String fecha = migracion.fechaMigracion("Jose Pedro","Dominguez Serrano");
         System.out.println(fecha);
         migracion.representacionMatrizDePesos(migracion.listaGeneral());

        ArrayList<Reporte> reportes =  migracion.flujoEmigrantes("la paz");
        for(Reporte reporte: reportes){
            System.out.println(reporte.getNombreCiudad());
            System.out.println(reporte.getFlujo());
        
        
        }

        migracion.imprimirGrafo();    

    }

}
