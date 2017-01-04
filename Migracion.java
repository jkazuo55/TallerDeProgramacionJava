//package modelo;

import java.util.Scanner;
import java.util.Hashtable;

public class Migracion{
    private Lista<Ciudad>listaCiudades;
    private Grafo grafoEmigrantes;
    private Grafo grafoMapa;
    private int flujoEmigrantes[][];
    private Hashtable<String,Integer> tablaCiudadCodigo; 
    private Hashtable<Integer,String> tablaCodigoCiudad;
    private int[][]matrizMapa =  { {0,1,0,1,0,1,0,0,0},
                                   {1,0,1,0,0,0,0,0,0},
                                   {0,1,0,0,1,0,0,0,0},
                                   {1,0,0,0,1,1,0,1,0},
                                   {0,0,1,1,0,0,0,1,0},
                                   {1,0,0,1,0,0,1,0,0},
                                   {0,0,0,0,0,1,0,0,1},
                                   {0,0,0,1,1,0,0,0,1},
                                   {0,0,0,0,0,0,1,1,0}
                                };
    public Migracion(){
        listaCiudades = new Lista<Ciudad>();
        tablaCiudadCodigo = new Hashtable<String,Integer>();
        tablaCodigoCiudad = new Hashtable<Integer,String>();
        grafoEmigrantes = new Grafo(9);
        grafoMapa = new Grafo(matrizMapa);
        init_tablaCiudadCodigo();
        init_tablaCodigoCiudad();
        flujoEmigrantes = grafoEmigrantes.getMatriz();
    }
    
    public Lista<Reporte> flujoEmigrantes(String nombreCiudad){
        Lista<Reporte> listaReporte =new Lista<Reporte>();
        boolean estadoCiudad = buscarCiudad(nombreCiudad);
        int indiceCiudadInicio= tablaCiudadCodigo.get(nombreCiudad);
        String indiceCiudadDestino;
        int flujoEmigrantes[][] = grafoEmigrantes.getMatriz();
        if (estadoCiudad) {
            for (int i=0;i<8;i++ ) {
                if (flujoEmigrantes[indiceCiudadInicio][i]>0){
                    listaReporte.insertarAlFinal(new Reporte(tablaCodigoCiudad.get(i),flujoEmigrantes[indiceCiudadInicio][i]));
                }
            }
        }
        return listaReporte;       
    }
    
    public boolean buscarCiudad(String nombreCiudad){
        boolean encontrado =false;
        int i=0;
        while(encontrado == false && i<listaCiudades.getTamanio()){
            if (listaCiudades.get(i).getNombre().compareToIgnoreCase(nombreCiudad)==0) {
                encontrado=true;
            }else{
                i++;
            }
        }
        return encontrado;
    }

    public void mostrarFlujoEmigrantesPorCiudad(String nombreCiudad){
        boolean estadoCiudad=buscarCiudad(nombreCiudad);
        int indiceCiudad=tablaCiudadCodigo.get(nombreCiudad);
        if(estadoCiudad){
            int total=totalEmigrantesDeCiudad(nombreCiudad);
            System.out.println("      TOTAL EMIGRANTES DE LA CIUDAD DE  " +nombreCiudad+" "  + total);            
            for (int i=0;i<flujoEmigrantes.length ;i++ ) {
                if (flujoEmigrantes[indiceCiudad][i]>0) {
                    System.out.println("      "+flujoEmigrantes[indiceCiudad][i] + " hacia " + tablaCodigoCiudad.get(i));
                }
            }
        }
    }
    public int totalEmigrantesDeCiudad(String nombreCiudad){
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
        Lista<PersonaEmigrante> listaGeneralEmigrantes = listaGeneral();
        PersonaEmigrante emigrante_encontrado = null;
        PersonaEmigrante emigrante;
        String name;
        String last_name;
        Boolean encontrado = false;
        int index = 0;
        while(!encontrado && index < listaGeneralEmigrantes.getTamanio()){
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
        this.listaCiudades.insertarAlFinal(ciudad);
    }
    public Lista<PersonaEmigrante> listaGeneral(){
        Lista<PersonaEmigrante> listaEmigrantesGeneral = new Lista<PersonaEmigrante>();
        Lista<PersonaEmigrante> listaEmigrantesParticular;
        Lista<Ciudad> list = this.listaCiudades;
        if(!list.esVacia()){
            for(Ciudad ciudad: list){
                listaEmigrantesParticular = ciudad.getListaEmigrantes();
                if(!listaEmigrantesParticular.esVacia()){
                    for(PersonaEmigrante emigrante: listaEmigrantesParticular){
                        listaEmigrantesGeneral.insertarAlFinal(emigrante);
                    }
                }
            } 
        }
        return listaEmigrantesGeneral; 
    }
    public void representacionMatrizDePesos(Lista<PersonaEmigrante> listaEmigrantes){
        String origen;
        String destino;
        int indice_origen;
        int indice_destino;
        int cantidad;
        int valor_mapa;
        //int flujoEmigrantes[][] = grafoEmigrantes.getMatriz();
        //int matrizMapa[][] = grafoMapa.getMatriz();
        if(!listaEmigrantes.esVacia()){
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

        PersonaEmigrante jose = new PersonaEmigrante("Jose","Dominguez Serrano","masculino","9350610CB","cochabamba",35,"la paz","01/01/1993"); 
        PersonaEmigrante pedro = new PersonaEmigrante("Pedro","Dominguez Serrano","masculino","9350610CB","cochabamba",35,"la paz","01/01/1993"); 
        PersonaEmigrante carlos = new PersonaEmigrante("Carlos","Dominguez Serrano","masculino","9350610CB","cochabamba",35,"la paz","01/01/1993"); 
        PersonaEmigrante juan = new PersonaEmigrante("Juan","Serrano","masculino","5678543LP","la paz",45,"cochabamba","25/06/1985"); 
        PersonaEmigrante gabriel = new PersonaEmigrante("Gabriel","Cardona","masculino","3452647O","oruro",23,"cochabamba","23/05/1989");
        PersonaEmigrante guilder = new PersonaEmigrante("GUILDER","VILLARROEL CONDORI","masculino","782345CH","chuquisaca",40,"tarija","04/10/2016");
        PersonaEmigrante romel = new PersonaEmigrante("ROMEL BORIS","ZAMORANO COBARRUVIAS","masculino","4412847ST","santa cruz",40,"chuquisaca","25/08/2015");
        PersonaEmigrante maximo = new PersonaEmigrante("MAXIMO RAFAEL","GUZMAN MURILLO","masculino","4427462PA","pando",45,"beni","22/06/2015");
        PersonaEmigrante ronald = new PersonaEmigrante("RONALD ALBERTO","VEIZAGA BAQUEROS","masculino","3756245B","beni",55,"pando","18/01/2013");
        PersonaEmigrante hilbert = new PersonaEmigrante("HILBERT","FLORES RIOJA","masculino","4534306PO","potosi",35,"cochabamba","12/07/2012");
        PersonaEmigrante demetrio = new PersonaEmigrante("DEMETRIO SATURNINO","QUISBERT CHOQUE","masculino","2616320T","tarija",34,"potosi","24/08/2010");

        lapaz.registrarEmigrante(jose);
        lapaz.registrarEmigrante(pedro);
        lapaz.registrarEmigrante(carlos);
        cochabamba.registrarEmigrante(juan);
        cochabamba.registrarEmigrante(gabriel);
        tarija.registrarEmigrante(guilder);
        chuquisaca.registrarEmigrante(romel);
        beni.registrarEmigrante(maximo);
        pando.registrarEmigrante(ronald);
        cochabamba.registrarEmigrante(hilbert);
        potosi.registrarEmigrante(demetrio);


        PersonaEmigrante marcos = new PersonaEmigrante("marcos","Serrano Jimenez","masculino","315010CB","cochabamba",35,"santa cruz","01/01/1993"); 
        PersonaEmigrante quinteros = new PersonaEmigrante("Juan","Quinteros Serrano","masculino","897854LP","la paz",45,"pando","25/06/1985"); 
        PersonaEmigrante jose_gabriel = new PersonaEmigrante("Jose Gabriel","Cardona Gutierrez","masculino","6542647O","oruro",23,"potosi","23/05/1989");
        PersonaEmigrante julio_guilder = new PersonaEmigrante("JULIO GUILDER","VILLARROEL CONDORI","masculino","876345CH","chuquisaca",40,"santa cruz","04/10/2016");
        PersonaEmigrante boris = new PersonaEmigrante("BORIS","ZAMORANO COBARRUVIAS","masculino","441284ST","santa cruz",40,"cochabamba","25/08/2015");
        PersonaEmigrante rafael = new PersonaEmigrante("RAFAEL","GUZMAN MURILLO","masculino","534746PA","pando",45,"la paz","22/06/2015");
        PersonaEmigrante alberto = new PersonaEmigrante("ALBERTO","VEIZAGA BAQUEROS","masculino","2766245B","beni",55,"santa cruz","18/01/2013");
        PersonaEmigrante rodrigo_flores = new PersonaEmigrante("RODRIGO","FLORES RIOJA","masculino","3544306PO","potosi",35,"oruro","12/07/2012");
        PersonaEmigrante saturnino = new PersonaEmigrante("SATURNINO","QUISBERT CHOQUE","masculino","2716320T","tarija",34,"pando","24/08/2010");

        santacruz.registrarEmigrante(marcos);
        pando.registrarEmigrante(quinteros);
        potosi.registrarEmigrante(jose_gabriel);
        santacruz.registrarEmigrante(julio_guilder);
        cochabamba.registrarEmigrante(boris);
        lapaz.registrarEmigrante(rafael);
        santacruz.registrarEmigrante(alberto);
        oruro.registrarEmigrante(rodrigo_flores);
        pando.registrarEmigrante(saturnino);
    }
    public Lista<PersonaEmigrante> reportePorCiudad(String nombreCiudad){
        Lista<PersonaEmigrante>emigrantesCiudad=new Lista<PersonaEmigrante>();
        for (PersonaEmigrante emigrante:listaGeneral()) {
            if (emigrante.getNacidoEn()==nombreCiudad) {
                emigrantesCiudad.insertarAlFinal(emigrante);
            }
        }
        return emigrantesCiudad;
    }    
    public void menu(){
        System.out.println("#######  MENU REPORTES #######");
        System.out.println("1. Generacion de matriz de pesos");
        System.out.println("2. Menu Reporte por ciudades");
        System.out.println("3. Fecha de Migracion");
        System.out.println("4. Salir");
    }

    public void menuFechaMigracion(){
        System.out.println("Ingrese nombre de ciudadano:");
        Scanner inputC = new Scanner(System.in);
        String nombre =  inputC.nextLine();
        System.out.println("Ingrese apellido de ciudadano:");
        String apellido = inputC.nextLine();
        System.out.println("Fecha de migracion de " +nombre+" "+apellido+":");
        System.out.println(fechaMigracion(nombre,apellido)); 
    }
    public void menuReportePorCiudad(){
        int numero;
        do{
            System.out.println("========= OPCIONES DE UNA CIUDAD =========");
            System.out.println("    4 la paz");
            System.out.println("    5 pando");
            System.out.println("    6 beni");
            System.out.println("    7 cochabamba");
            System.out.println("    8 santa cruz");
            System.out.println("    9 oruro");
            System.out.println("    10 potosi");
            System.out.println("    11 chuquisaca");
            System.out.println("    12 tarija");

            System.out.println("    13.Volver Atraz");
            System.out.println("=> ingrese una opcion");

            Scanner lector =new Scanner(System.in);
            numero = lector.nextInt();

            switch(numero){
                case 4:
                    for (PersonaEmigrante emigranteCiudad:reportePorCiudad("la paz")) {
                        System.out.println("####################"+emigranteCiudad);
                    }
                    mostrarFlujoEmigrantesPorCiudad("la paz");
                break;
                case 5:
                    for (PersonaEmigrante emigranteCiudad:reportePorCiudad("pando")) {
                        System.out.println("####################"+emigranteCiudad);
                    }
                    mostrarFlujoEmigrantesPorCiudad("pando");
                break;
                case 6:
                    for (PersonaEmigrante emigranteCiudad:reportePorCiudad("beni")) {
                        System.out.println("####################"+emigranteCiudad);
                    }
                    mostrarFlujoEmigrantesPorCiudad("beni");
                break;
                case 7:
                    for (PersonaEmigrante emigranteCiudad:reportePorCiudad("cochabamba")) {
                        System.out.println("####################"+emigranteCiudad);
                    }
                    mostrarFlujoEmigrantesPorCiudad("cochabamba");
                break;
                case 8:
                    for (PersonaEmigrante emigranteCiudad:reportePorCiudad("santa cruz")) {
                        System.out.println("####################"+emigranteCiudad);
                    }
                    mostrarFlujoEmigrantesPorCiudad("santa cruz");
                break;
                case 9:
                    for (PersonaEmigrante emigranteCiudad:reportePorCiudad("oruro")) {
                        System.out.println("####################"+emigranteCiudad);
                    }
                    mostrarFlujoEmigrantesPorCiudad("oruro");
                break;
                case 10:
                    for (PersonaEmigrante emigranteCiudad:reportePorCiudad("potosi")) {
                        System.out.println("####################"+emigranteCiudad);
                    }
                    mostrarFlujoEmigrantesPorCiudad("potosi");
                break;
                case 11:
                    for (PersonaEmigrante emigranteCiudad:reportePorCiudad("chuquisaca")) {
                        System.out.println("####################"+emigranteCiudad);
                    }
                    mostrarFlujoEmigrantesPorCiudad("chuquisaca");
                break;
                case 12:
                    for (PersonaEmigrante emigranteCiudad:reportePorCiudad("tarija")) {
                        System.out.println("####################"+emigranteCiudad);
                    }
                    mostrarFlujoEmigrantesPorCiudad("tarija");
                break;
                
                default: if (numero!=13) {
                    System.out.println("OPCION INCORECTA");
                };
            }

        }while(numero != 13);
    }
    public static void main(String args[]){
        Migracion migracion = new Migracion();
        GrafoND<Integer> grafoND = new GrafoND<Integer>();
        System.out.println("comenz");
        grafoND.insertarVertice(50);
        grafoND.insertarVertice(100);
        boolean hola = grafoND.insertarAristaP(50,100,343);
        System.out.println(grafoND.longRutaMinimaDijkstra(50,100));
        migracion.datosIniciales(migracion);
        migracion.representacionMatrizDePesos(migracion.listaGeneral());
        int opcion;
        do{
            migracion.menu();
            System.out.println("=> Ingrese una opcion");
            Scanner in = new Scanner(System.in);
            opcion = in.nextInt();
            
            switch(opcion){
            case 1: migracion.mostrarMatrizDePesos();break;
            case 2: migracion.menuReportePorCiudad();break;
            case 3: migracion.menuFechaMigracion();break;
            default: if (opcion!=4) {
                    System.out.println("OPCION INCORECTA");
                };
            }
        }while(opcion != 4);   
    }
}