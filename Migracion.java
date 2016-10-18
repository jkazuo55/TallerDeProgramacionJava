import java.util.Hashtable;
import java.util.ArrayList;

public class Migracion{

    private ArrayList<Ciudad>listaCiudades;

    private Grafo grafoEmigrantes;
    private Grafo grafoMapa;
    int flujoEmigrantes[][];

    private int[][]matrizMapa =  { {0,1,0,1,0,1,0,0,0},
                                   {1,0,1,0,0,0,0,0,0},
                                   {0,1,0,0,1,0,0,0,0},
                                   {1,0,0,0,1,1,0,1,0},
                                   {0,0,1,1,0,0,0,1,0},
                                   {1,0,0,1,0,0,1,0,0},
                                   {0,0,0,0,0,1,0,0,1},
                                   {0,0,0,1,1,0,0,0,1},
                                   {0,0,0,0,0,0,1,1,0}};

    private Hashtable<String,Integer> tablaCiudadCodigo; 
    private Hashtable<Integer,String> tablaCodigoCiudad;


    public Migracion(){
        listaCiudades = new ArrayList<Ciudad>();
        tablaCiudadCodigo = new Hashtable<String,Integer>();
        tablaCodigoCiudad = new Hashtable<Integer,String>();
        grafoEmigrantes = new Grafo(9);
        grafoMapa = new Grafo(matrizMapa);
        init_tablaCiudadCodigo();
        init_tablaCodigoCiudad();
        flujoEmigrantes = grafoEmigrantes.getMatriz();
    }

    public ArrayList<Reporte> flujoEmigrantes(String nombreCiudad){

        ArrayList<Reporte> listaReporte =new ArrayList<Reporte>();
        boolean estadoCiudad = buscarCiudad(nombreCiudad);
        int indiceCiudadInicio= tablaCiudadCodigo.get(nombreCiudad);
        String indiceCiudadDestino;
        int flujoEmigrantes[][] = grafoEmigrantes.getMatriz();
        // Reporte reporte=new Reporte();
        if (estadoCiudad) {
            for (int i=0;i<8;i++ ) {
                if (flujoEmigrantes[indiceCiudadInicio][i]>0){
                    listaReporte.add(new Reporte(tablaCodigoCiudad.get(i),flujoEmigrantes[indiceCiudadInicio][i]));
                }
            }
        }
        return listaReporte;       
    }

    private boolean buscarCiudad(String nombreCiudad){
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

    public void mostrarFlujoEmigrantesPorCiudad(String nombreCiudad){
        boolean estadoCiudad=buscarCiudad(nombreCiudad);
        int indiceCiudad=tablaCiudadCodigo.get(nombreCiudad);
        if(estadoCiudad){
            int total=totalEmigrantesDeCiudad(nombreCiudad);
            System.out.println("Total de emigrantes dela ciudad  = "  + total);            
            for (int i=0;i<flujoEmigrantes.length ;i++ ) {
                if (flujoEmigrantes[indiceCiudad][i]>0) {
                    System.out.println(flujoEmigrantes[indiceCiudad][i] + " hacia " + tablaCodigoCiudad.get(i));
                }
            }
        }
    
    }

    private int totalEmigrantesDeCiudad(String nombreCiudad){
        boolean estadoCiudad=buscarCiudad(nombreCiudad);
        int total=0;
        int indiceCiudad;
        if (estadoCiudad) {
            for (int i=0;i<flujoEmigrantes.length ;i++ ) {
                indiceCiudad = tablaCiudadCodigo.get(nombreCiudad);
                total=total+flujoEmigrantes[indiceCiudad][i];
            }
        }
        return total;
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
        int valor_mapa;
        //int flujoEmigrantes[][] = grafoEmigrantes.getMatriz();
        //int matrizMapa[][] = grafoMapa.getMatriz();
        if(!listaEmigrantes.isEmpty()){
            for(PersonaEmigrante emigrante: listaEmigrantes){
                origen = emigrante.getNacidoEn();
                destino = emigrante.getDestino();
                indice_origen = tablaCiudadCodigo.get(origen);
                indice_destino = tablaCiudadCodigo.get(destino);
                valor_mapa = grafoMapa.obtenerVertice(indice_origen,indice_destino);
                if(valor_mapa==1){
                    //flujoEmigrantes[indice_origen][indice_destino] += 1;
                    cantidad = grafoEmigrantes.obtenerVertice(indice_origen,indice_destino) + 1;
                    grafoEmigrantes.modificarVertice(indice_origen,indice_destino,cantidad);
                }
            }
        }
    }

    public void mostrarMatrizDePesos(){
        // int flujoEmigrantes[][] = grafoEmigrantes.getMatriz();
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

    public void menu(){
    
    
    }

    public void init_tablaCiudadCodigo(){
        
        tablaCiudadCodigo.put("la paz",0);
        tablaCiudadCodigo.put("pando",1);
        tablaCiudadCodigo.put("beni",2);
        tablaCiudadCodigo.put("cochabamba",3);
        tablaCiudadCodigo.put("santa cruz",4);
        tablaCiudadCodigo.put("oruro",5);
        tablaCiudadCodigo.put("potosi",6);
        tablaCiudadCodigo.put("chuquisaca",7);
        tablaCiudadCodigo.put("tarija",8);

    }
    public void init_tablaCodigoCiudad(){
        
        tablaCodigoCiudad.put(0,"la paz");
        tablaCodigoCiudad.put(1,"pando");
        tablaCodigoCiudad.put(2,"beni");
        tablaCodigoCiudad.put(3,"cochabamba");
        tablaCodigoCiudad.put(4,"santa cruz");
        tablaCodigoCiudad.put(5,"oruro");
        tablaCodigoCiudad.put(6,"potosi");
        tablaCodigoCiudad.put(7,"chuquisaca");
        tablaCodigoCiudad.put(8,"tarija");
    }    

    public void datosIniciales(Migracion migracion){
        Ciudad cochabamba = new Ciudad();
        cochabamba.setNombre("cochabamba");
        Ciudad lapaz = new Ciudad();
        lapaz.setNombre("la paz");
        Ciudad oruro = new Ciudad();
        oruro.setNombre("oruro");
        Ciudad chuquisaca = new Ciudad();
        chuquisaca.setNombre("chuquisaca");
        Ciudad santacruz = new Ciudad();
        santacruz.setNombre("santa cruz");
        Ciudad pando = new Ciudad();
        pando.setNombre("pando");
        Ciudad beni = new Ciudad();
        beni.setNombre("beni");
        Ciudad potosi = new Ciudad();
        potosi.setNombre("potosi");
        Ciudad tarija = new Ciudad();
        tarija.setNombre("tarija");


        migracion.registrarCiudad(cochabamba);
        migracion.registrarCiudad(lapaz);
        migracion.registrarCiudad(oruro);
        migracion.registrarCiudad(chuquisaca);
        migracion.registrarCiudad(santacruz);
        migracion.registrarCiudad(pando);
        migracion.registrarCiudad(beni);
        migracion.registrarCiudad(potosi);
        migracion.registrarCiudad(tarija);


        
        PersonaEmigrante pedro2 = new PersonaEmigrante("Jose Pedro","Dominguez Serrano","masculino","9350610CB","cochabamba",35,"la paz","01/01/1993"); 
        PersonaEmigrante pedro1 = new PersonaEmigrante("Jose Pedro","Dominguez Serrano","masculino","9350610CB","cochabamba",35,"la paz","01/01/1993"); 
        PersonaEmigrante pedro = new PersonaEmigrante("Jose Pedro","Dominguez Serrano","masculino","9350610CB","cochabamba",35,"la paz","01/01/1993"); 
        PersonaEmigrante juan = new PersonaEmigrante("Juan","Serrano","masculino","5678543LP","la paz",45,"cochabamba","25/06/1985"); 
        PersonaEmigrante gabriel = new PersonaEmigrante("Gabriel","Cardona","masculino","3452647O","oruro",23,"cochabamba","23/05/1989");
        PersonaEmigrante guilder = new PersonaEmigrante("GUILDER","VILLARROEL CONDORI","masculino","782345CH","chuquisaca",40,"tarija","04/10/2016");
        PersonaEmigrante romel = new PersonaEmigrante("ROMEL BORIS","ZAMORANO COBARRUVIAS","masculino","4412847ST","santa cruz",40,"chuquisaca","25/08/2015");
        PersonaEmigrante maximo = new PersonaEmigrante("MAXIMO RAFAEL","GUZMAN MURILLO","masculino","4427462PA","pando",45,"beni","22/06/2015");
        PersonaEmigrante ronald = new PersonaEmigrante("RONALD ALBERTO","VEIZAGA BAQUEROS","masculino","3756245B","beni",55,"pando","18/01/2013");
        PersonaEmigrante hilbert = new PersonaEmigrante("HILBERT","FLORES RIOJA","masculino","4534306PO","potosi",35,"cochabamba","12/07/2012");
        PersonaEmigrante demetrio = new PersonaEmigrante("DEMETRIO SATURNINO","QUISBERT CHOQUE","masculino","2616320T","tarija",34,"potosi","24/08/2010");

        lapaz.registrarEmigrante(pedro);
        lapaz.registrarEmigrante(pedro1);
        lapaz.registrarEmigrante(pedro2);
        cochabamba.registrarEmigrante(juan);
        cochabamba.registrarEmigrante(gabriel);
        tarija.registrarEmigrante(guilder);
        chuquisaca.registrarEmigrante(romel);
        beni.registrarEmigrante(maximo);
        pando.registrarEmigrante(ronald);
        cochabamba.registrarEmigrante(hilbert);
        potosi.registrarEmigrante(demetrio);


        PersonaEmigrante jose = new PersonaEmigrante("Pedro","Serrano Jimenez","masculino","315010CB","cochabamba",35,"santa cruz","01/01/1993"); 
        PersonaEmigrante quinteros = new PersonaEmigrante("Juan","Quinteros Serrano","masculino","897854LP","la paz",45,"pando","25/06/1985"); 
        PersonaEmigrante jose_gabriel = new PersonaEmigrante("Jose Gabriel","Cardona Gutierrez","masculino","6542647O","oruro",23,"potosi","23/05/1989");
        PersonaEmigrante julio_guilder = new PersonaEmigrante("JULIO GUILDER","VILLARROEL CONDORI","masculino","876345CH","chuquisaca",40,"santa cruz","04/10/2016");
        PersonaEmigrante boris = new PersonaEmigrante("BORIS","ZAMORANO COBARRUVIAS","masculino","441284ST","santa cruz",40,"cochabamba","25/08/2015");
        PersonaEmigrante rafael = new PersonaEmigrante("RAFAEL","GUZMAN MURILLO","masculino","534746PA","pando",45,"la paz","22/06/2015");
        PersonaEmigrante alberto = new PersonaEmigrante("ALBERTO","VEIZAGA BAQUEROS","masculino","2766245B","beni",55,"santa cruz","18/01/2013");
        PersonaEmigrante rodrigo_flores = new PersonaEmigrante("RODRIGO","FLORES RIOJA","masculino","3544306PO","potosi",35,"oruro","12/07/2012");
        PersonaEmigrante saturnino = new PersonaEmigrante("SATURNINO","QUISBERT CHOQUE","masculino","2716320T","tarija",34,"pando","24/08/2010");

        santacruz.registrarEmigrante(jose);
        pando.registrarEmigrante(quinteros);
        potosi.registrarEmigrante(jose_gabriel);
        santacruz.registrarEmigrante(julio_guilder);
        cochabamba.registrarEmigrante(boris);
        lapaz.registrarEmigrante(rafael);
        santacruz.registrarEmigrante(alberto);
        oruro.registrarEmigrante(rodrigo_flores);
        pando.registrarEmigrante(saturnino);


    }    

    public static void main(String args[]){
        Migracion migracion = new Migracion();
        migracion.datosIniciales(migracion);
        for(PersonaEmigrante emigrante: migracion.listaGeneral()){
            System.out.println(emigrante.getNombre());
        }
        String fecha = migracion.fechaMigracion("Jose Pedro","Dominguez Serrano");
        System.out.println(fecha);
        migracion.representacionMatrizDePesos(migracion.listaGeneral());

        /*

        ArrayList<Reporte> reportes =  migracion.flujoEmigrantes("la paz");
        for(Reporte reporte: reportes){
            System.out.println(reporte.getNombreCiudad());
            System.out.println(reporte.getFlujo());
        
        
        }*/

        migracion.mostrarMatrizDePesos(); 
        migracion.mostrarFlujoEmigrantesPorCiudad("cochabamba");   

    }

}
