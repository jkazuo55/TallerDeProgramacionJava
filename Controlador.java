import javax.swing.*;
import java.awt.*;
import java.util.Hashtable;

public class Controlador{

	private VentanaPrincipal vista;
	private Modelo modelo;
	private VentanaLogin login;
	private PestaniaEmigrante pestaniaEmigrante;
    private PestaniaCiudad pestaniaCiudad;
	private PestaniaMapa pestaniaMapa;
	private GrafoND grafo;
	private Hashtable<String,Integer> tablaCiudadCodigo;
	private Hashtable<Integer,String> tablaCodigoCiudad;

    Lista<Emigrante> listaPersonaEmigrante;
    String fileName = "/home/xenial/proyectos/java/TallerDeProgramacionJava/dataHistorialEmigrantes.ser"; 
    DeserializableGenerico<Lista> deser_gen;  

	public Controlador(){
        listaPersonaEmigrante = new Lista<Emigrante>(); 
        // deser_gen = new DeserializableGenerico<Lista>(fileName);        
        // listaPersonaEmigrante = deser_gen.deserialize();

		tablaCiudadCodigo = new Hashtable<String,Integer>();
		tablaCodigoCiudad = new Hashtable<Integer,String>();
		grafo = new GrafoND<Integer>();
	}	
	public Controlador(VentanaPrincipal vista, Modelo modelo){
		this.vista = vista;
		this.modelo = modelo;
	}
	public void setVentanaPrincipal(VentanaPrincipal vista){
		this.vista=vista;
	}
	public void setVentanaPrincipal(VentanaLogin login){
		this.login=login;
	}
	public void setModeloPrincipal(Modelo modelo){
		this.modelo=modelo;
	}
	public void setPanelRegistroEmigrante(PestaniaEmigrante pestaniaEmigrante){	
		this.pestaniaEmigrante = pestaniaEmigrante ; 
	}
	public void setPestaniaCiudad(PestaniaCiudad pestaniaCiudad){  
        this.pestaniaCiudad = pestaniaCiudad ; 
    }
    public void setPestaniaMapa(PestaniaMapa pestaniaMapa){	
		this.pestaniaMapa = pestaniaMapa ; 
	}
	public void setGrafo(GrafoND grafo){
		this.grafo=grafo;
	}
	public String validarIngreso(int index,String user, String pass){
		return modelo.validarIngreso(index,user,pass);
	}
	public void cerrarVentanaLogin(){
		login.dispose();
	}	
	public void asignarPrivilegios(String usuario){
		vista.asignarPrivilegios(usuario);
	}
	public void mostrarLogin(){
        login.limpiar();
		login.setVisible(true);
	}
	public void arranca() {
	    java.awt.EventQueue.invokeLater(new Runnable() {
	        public void run() {
	            // vista = new VentanaPrincipal();
	            // login = new VentanaLogin(vista,true);
	            vista.setVisible(true); //visualiza la vista
	            vista.setSize(1500, 900); //tamanio de la vista
	            vista.setLocationRelativeTo(null);// centra la vista en la pantalla
	            login.setVisible(true);
	        }
	    });
	    convertirCiudadCodigo();
	    convertirCodigoCiudad();
	    insertarVertice();
	    insertarAristas();  
        // matrizAdyacencia();  
        // pesoDistancias();
        // System.out.println(flujoEmigrantes("cochabamba","santa cruz"));
	}    
    public void convertirCiudadCodigo(){
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
    public void convertirCodigoCiudad(){
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
    public void insertarVertice(){
    		grafo.insertarVertice(tablaCiudadCodigo.get("la paz"));
    		grafo.insertarVertice(tablaCiudadCodigo.get("pando"));
    		grafo.insertarVertice(tablaCiudadCodigo.get("beni"));
    		grafo.insertarVertice(tablaCiudadCodigo.get("cochabamba"));
    		grafo.insertarVertice(tablaCiudadCodigo.get("santa cruz"));
    		grafo.insertarVertice(tablaCiudadCodigo.get("oruro"));
    		grafo.insertarVertice(tablaCiudadCodigo.get("potosi"));
    		grafo.insertarVertice(tablaCiudadCodigo.get("chuquisaca"));
    		grafo.insertarVertice(tablaCiudadCodigo.get("tarija"));
    }
    public void insertarAristas(){
    		grafo.insertarAristaP(tablaCiudadCodigo.get("la paz"),tablaCiudadCodigo.get("pando"),1000);
    		grafo.insertarAristaP(tablaCiudadCodigo.get("la paz"),tablaCiudadCodigo.get("cochabamba"),379);
    		grafo.insertarAristaP(tablaCiudadCodigo.get("la paz"),tablaCiudadCodigo.get("oruro"),215);
    		grafo.insertarAristaP(tablaCiudadCodigo.get("pando"),tablaCiudadCodigo.get("la paz"),1000);
    		grafo.insertarAristaP(tablaCiudadCodigo.get("pando"),tablaCiudadCodigo.get("beni"),1189);
    		grafo.insertarAristaP(tablaCiudadCodigo.get("beni"),tablaCiudadCodigo.get("pando"),1189);
    		grafo.insertarAristaP(tablaCiudadCodigo.get("beni"),tablaCiudadCodigo.get("santa cruz"),556);
    		grafo.insertarAristaP(tablaCiudadCodigo.get("cochabamba"),tablaCiudadCodigo.get("la paz"),379);
    		grafo.insertarAristaP(tablaCiudadCodigo.get("cochabamba"),tablaCiudadCodigo.get("santa cruz"),476);
    		grafo.insertarAristaP(tablaCiudadCodigo.get("cochabamba"),tablaCiudadCodigo.get("oruro"),225);
    		grafo.insertarAristaP(tablaCiudadCodigo.get("cochabamba"),tablaCiudadCodigo.get("chuquisaca"),250);
    		grafo.insertarAristaP(tablaCiudadCodigo.get("santa cruz"),tablaCiudadCodigo.get("beni"),556);
    		grafo.insertarAristaP(tablaCiudadCodigo.get("santa cruz"),tablaCiudadCodigo.get("cochabamba"),476);
    		grafo.insertarAristaP(tablaCiudadCodigo.get("santa cruz"),tablaCiudadCodigo.get("chuquisaca"),481);
    		grafo.insertarAristaP(tablaCiudadCodigo.get("oruro"),tablaCiudadCodigo.get("la paz"),215);
    		grafo.insertarAristaP(tablaCiudadCodigo.get("oruro"),tablaCiudadCodigo.get("cochabamba"),225);
    		grafo.insertarAristaP(tablaCiudadCodigo.get("oruro"),tablaCiudadCodigo.get("potosi"),213);
    		grafo.insertarAristaP(tablaCiudadCodigo.get("potosi"),tablaCiudadCodigo.get("oruro"),213);
    		grafo.insertarAristaP(tablaCiudadCodigo.get("potosi"),tablaCiudadCodigo.get("tarija"),247);
    		grafo.insertarAristaP(tablaCiudadCodigo.get("chuquisaca"),tablaCiudadCodigo.get("cochabamba"),250);
    		grafo.insertarAristaP(tablaCiudadCodigo.get("chuquisaca"),tablaCiudadCodigo.get("santa cruz"),481);
    		grafo.insertarAristaP(tablaCiudadCodigo.get("chuquisaca"),tablaCiudadCodigo.get("tarija"),470);
    		grafo.insertarAristaP(tablaCiudadCodigo.get("tarija"),tablaCiudadCodigo.get("potosi"),247);
    		grafo.insertarAristaP(tablaCiudadCodigo.get("tarija"),tablaCiudadCodigo.get("chuquisaca"),470);
    }
    // public String ruta(String origen , String destino){
    // 	String ruta = Integer.toString(grafo.longRutaMinimaDijkstra(tablaCiudadCodigo.get(origen),tablaCiudadCodigo.get(destino)));
    // 	return ruta;
    // }
    public String ruta(String origen , String destino){
    	String cadena="";
    	// Lista<Integer> aux = grafo.rutaMinimaDijkstra(origen,destino);
    	Lista<Vertice> obj=grafo.rutaMinimaDijkstra(tablaCiudadCodigo.get(origen),tablaCiudadCodigo.get(destino));
    	for (Vertice asdf:obj) {
    		cadena = cadena + " | " +tablaCodigoCiudad.get(asdf.getInfo());
    	}
    	return cadena;
    }
    public Object[][] matrizAdyacencia(){
        Object[][]aux = grafo.getMatrizAdyacencia();
        Integer a;
        for (int i=0;i<aux.length;i++) {
            for (int j=0;j<aux[i].length;j++) {
                // System.out.print(aux.[i][j]);
                if (i!=0&&j!=0) {
                    if ((Integer)(aux[i][j])==2) {                         
                       aux[i][j]=(Integer)(aux[i][j])-1;
                    }else{
                       aux[i][j]=aux[i][j];
                    }
                    
                }
            }
        }
        return aux;
    }  
    public Lista<Arista> pesoDistancias(){
        Lista<Arista>aux=grafo.getAristas();
        // for (Arista obj:aux) {
        //     System.out.println("peso "+obj.getPeso());
        // }
        return aux;
    }

    public int flujoEmigrantes(String origen,String destino){
        int cont=0;
        String aux1;        
        String aux2;        
        for (Emigrante obj:listaPersonaEmigrante) {
            // System.out.println(obj.toString());
            aux1=obj.getOrigen();
            aux2=obj.getDestino();
            if (aux1.equalsIgnoreCase(origen)&&aux2.equalsIgnoreCase(destino)) {
                cont=cont+1;
            }
        }
        return cont;
    }

    public String fechaSistema(){
        return modelo.getFechaAcualDelSistema();
    }

}