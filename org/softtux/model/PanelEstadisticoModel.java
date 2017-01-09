package org.softtux.model;
import java.util.Hashtable;

public class PanelEstadisticoModel {
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
    public PanelEstadisticoModel(){
        listaCiudades = new Lista<Ciudad>();
        tablaCiudadCodigo = new Hashtable<String,Integer>();
        tablaCodigoCiudad = new Hashtable<Integer,String>();
        grafoEmigrantes = new Grafo(9);
        grafoMapa = new Grafo(matrizMapa);
        init_tablaCiudadCodigo();
        init_tablaCodigoCiudad();
        flujoEmigrantes = grafoEmigrantes.getMatriz();
        datosIniciales();
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
    
    public Ciudad getCiudad(String nombreCiudad){
        boolean encontrado =false;
        Ciudad ciudad = null;
        int i=0;
        while(encontrado == false && i<listaCiudades.getTamanio()){
            if (listaCiudades.get(i).getNombre().compareToIgnoreCase(nombreCiudad)==0) {
                encontrado=true;
                ciudad = listaCiudades.get(i);
            }else{
                i++;
            }
        }
        return ciudad;
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
        Lista<Emigrante> listaGeneralEmigrantes = listaGeneral();
        Emigrante emigrante_encontrado = null;
        Emigrante emigrante;
        String name;
        String last_name;
        Boolean encontrado = false;
        int index = 0;
        while(!encontrado && index < listaGeneralEmigrantes.getTamanio()){
            emigrante = listaGeneralEmigrantes.get(index);
            name = emigrante.getNombre();
            apellido = emigrante.getApellidos();
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
    public Lista<Emigrante> listaGeneral(){
        Lista<Emigrante> listaEmigrantesGeneral = new Lista<Emigrante>();
        Lista<Emigrante> listaEmigrantesParticular;
        Lista<Ciudad> list = this.listaCiudades;
        if(!list.esVacia()){
            for(Ciudad ciudad: list){
                listaEmigrantesParticular = ciudad.getListaEmigrantes();
                if(!listaEmigrantesParticular.esVacia()){
                    for(Emigrante emigrante: listaEmigrantesParticular){
                        listaEmigrantesGeneral.insertarAlFinal(emigrante);
                    }
                }
            } 
        }
        return listaEmigrantesGeneral; 
    }
    public void representacionMatrizDePesos(Lista<Emigrante> listaEmigrantes){
        String origen;
        String destino;
        int indice_origen;
        int indice_destino;
        int cantidad;
        int valor_mapa;
        //int flujoEmigrantes[][] = grafoEmigrantes.getMatriz();
        //int matrizMapa[][] = grafoMapa.getMatriz();
        if(!listaEmigrantes.esVacia()){
            for(Emigrante emigrante: listaEmigrantes){
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
    public void datosIniciales(){
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

        this.registrarCiudad(cochabamba);
        this.registrarCiudad(lapaz);
        this.registrarCiudad(oruro);
        this.registrarCiudad(chuquisaca);
        this.registrarCiudad(santacruz);
        this.registrarCiudad(pando);
        this.registrarCiudad(beni);
        this.registrarCiudad(potosi);
        this.registrarCiudad(tarija);

        Emigrante jose = new Emigrante("Jose","Dominguez Serrano",9350610,"masculino","cochabamba","Av. Cap.Victor Ustariz","4591799","jdominguez@gmail.com","Si","01/01/2016","cochabamba","la paz","CBB-LPZ","Trabajo");

        Emigrante pedro = new Emigrante("Pedro","Dominguez Serrano",9455619,"masculino","cochabamba","Av. Heroinas","4194759","pdominguezs@gmail.com","Si","31/12/2016","cochabamba","la paz","CBB-LPZ","Trabajo");

        Emigrante carlos = new Emigrante("Carlos","Dominguez Serrano",9567332,"masculino","cochabamba","Av. Heroinas","4194759","cdominguezs@gmail.com","Si","31/12/2016","cochabamba","la paz","CBB-LPZ","Trabajo");

        Emigrante juan = new Emigrante("Juan","Serrano",9754321,"masculino","la paz","Av. San Martin","4234569","jserrano@gmail.com","Si","21/10/2016","la paz","cochabamba","LPZ-CBB","Trabajo");

        Emigrante gabriel = new Emigrante("Gabriel","Cardona",1755321,"masculino","oruro","Av. Cusco","4639519","elgrancusco@gmail.com","Si","18/10/2016","oruro","cochabamba","OR-CBB","Trabajo");

        Emigrante guilder = new Emigrante("GUILDER","VILLARROEL CONDORI",2654321,"masculino","chuquisaca","Av. Chuquiago","5637519","gvillacondori@gmail.com","Si","15/04/2016","chuquisaca","tarija","CH-TJ","Familiar");

        Emigrante romel = new Emigrante("ROMEL BORIS","ZAMORANO COBARRUVIAS",4567141,"masculino","santa cruz","Plan 3000","2359619","romel_zamorano@gmail.com","Si","05/02/2016","santa cruz","chuquisaca","ST-CH","Academico");

        Emigrante maximo = new Emigrante("MAXIMO RAFAEL","GUZMAN MURILLO",5367141,"masculino","pando","Av. Tropico","9257819","maximo_rafael@gmail.com","Si","19/08/2016","pando","beni","P-B","Otros");

        Emigrante ronald = new Emigrante("RONALD ALBERTO","VEIZAGA BAQUEROS",3756141,"masculino","beni","Av. Tropico","8237419","ronald_alberto@gmail.com","Si","25/07/2016","beni","pando","B-P","Familiar");

        Emigrante hilbert = new Emigrante("HILBERT","FLORES RIOJA",8235241,"masculino","potosi","Av. Demetrio Canelas","9233412","hilbert_flores@gmail.com","Si","21/10/2016","potosi","cochabamba","P-C","Trabajo");

        Emigrante demetrio = new Emigrante("DEMETRIO SATURNINO","QUISBERT CHOQUE",2616241,"masculino","tarija","Av. Vinopolis","7245727","demetrio_sat@gmail.com","Si","17/05/2016","tarija","cochabamba","T-C","Trabajo");


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
        cochabamba.registrarEmigrante(demetrio);


    }
    public Lista<Emigrante> reportePorCiudad(String nombreCiudad){
        Lista<Emigrante>emigrantesCiudad=new Lista<Emigrante>();
        for (Emigrante emigrante:listaGeneral()) {
            if (emigrante.getNacidoEn()==nombreCiudad) {
                emigrantesCiudad.insertarAlFinal(emigrante);
            }
        }
        return emigrantesCiudad;
    }    

}
