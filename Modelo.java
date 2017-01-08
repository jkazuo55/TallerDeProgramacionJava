//package modelo;

public class Modelo{

	final int SELECCION= 0;
	final int ADMINISTRADOR=1;
	final int USUARIO=2;

	final String PASS_ADMIN="admin";
	final String PASS_USER="1234";

	Controlador control;
	// Grafo grafo;
	// Hashtable tablaCiudadCodigo;
	
	public Modelo(){
		// tablaCiudadCodigo = new Hashtable<String,Integer>();
		// grafo = new Grafo<Integer>();
	}

	public void setControlador(Controlador control){
		this.control=control;
	}

	public String validarIngreso(int index,String pass){
		String retorno="";
		if (index==SELECCION) {
			retorno="No hay una leseccion";
		}else{
			retorno = validarPass(index,pass);
		}
		return retorno;
	}
	private String validarPass(int index,String pass){
		String retorno="";
		switch(index){
			case ADMINISTRADOR:
				if (pass.equals(PASS_ADMIN)) {
					retorno="Administrador";	
				}else{
					retorno="pass invalido";
				}
			break;
			case USUARIO:
				if (pass.equals(PASS_USER)) {
					retorno="Usuario";	
				}else{
					retorno="pass invalido";
				}
			break;	
		
		}
		return retorno;
	}

	// public void convertirCiudadCodigo(){
	// 	tablaCiudadCodigo.put("la paz",0);
 //        tablaCiudadCodigo.put("pando",1);
 //        tablaCiudadCodigo.put("beni",2);
 //        tablaCiudadCodigo.put("cochabamba",3);
 //        tablaCiudadCodigo.put("santa cruz",4);
 //        tablaCiudadCodigo.put("oruro",5);
 //        tablaCiudadCodigo.put("potosi",6);
 //        tablaCiudadCodigo.put("chuquisaca",7);
 //        tablaCiudadCodigo.put("tarija",8);
	// }
	// public void insertarVertice(){
	// 	grafo.insertarVertice(tablaCiudadCodigo.get("la paz"));
	// 	grafo.insertarVertice(tablaCiudadCodigo.get("pando"));
	// 	grafo.insertarVertice(tablaCiudadCodigo.get("beni"));
	// 	grafo.insertarVertice(tablaCiudadCodigo.get("cochabamba"));
	// 	grafo.insertarVertice(tablaCiudadCodigo.get("santa cruz"));
	// 	grafo.insertarVertice(tablaCiudadCodigo.get("oruro"));
	// 	grafo.insertarVertice(tablaCiudadCodigo.get("potosi"));
	// 	grafo.insertarVertice(tablaCiudadCodigo.get("chuquisaca"));
	// 	grafo.insertarVertice(tablaCiudadCodigo.get("tarija"));
	// }
	// public void insertarAristas(){
	// 	grafo.insertarAristaP(tablaCiudadCodigo.get("la paz"),tablaCiudadCodigo.get("pando"),300);
	// 	grafo.insertarAristaP(tablaCiudadCodigo.get("la paz"),tablaCiudadCodigo.get("cochabamba"),200);
	// 	grafo.insertarAristaP(tablaCiudadCodigo.get("la paz"),tablaCiudadCodigo.get("oruro"),150);
	// 	grafo.insertarAristaP(tablaCiudadCodigo.get("pando"),tablaCiudadCodigo.get("la paz"),200);
	// 	grafo.insertarAristaP(tablaCiudadCodigo.get("pando"),tablaCiudadCodigo.get("beni"),150);
	// 	grafo.insertarAristaP(tablaCiudadCodigo.get("beni"),tablaCiudadCodigo.get("pando"),150);
	// 	grafo.insertarAristaP(tablaCiudadCodigo.get("beni"),tablaCiudadCodigo.get("santa cruz"),100);
	// 	grafo.insertarAristaP(tablaCiudadCodigo.get("cochabamba"),tablaCiudadCodigo.get("la paz"),200);
	// 	grafo.insertarAristaP(tablaCiudadCodigo.get("cochabamba"),tablaCiudadCodigo.get("santa cruz"),130);
	// 	grafo.insertarAristaP(tablaCiudadCodigo.get("cochabamba"),tablaCiudadCodigo.get("oruro"),100);
	// 	grafo.insertarAristaP(tablaCiudadCodigo.get("cochabamba"),tablaCiudadCodigo.get("chuquisaca"),300);
	// 	grafo.insertarAristaP(tablaCiudadCodigo.get("santa cruz"),tablaCiudadCodigo.get("beni"),100);
	// 	grafo.insertarAristaP(tablaCiudadCodigo.get("santa cruz"),tablaCiudadCodigo.get("cochabamba"),130);
	// 	grafo.insertarAristaP(tablaCiudadCodigo.get("santa cruz"),tablaCiudadCodigo.get("chuquisaca"),230);
	// 	grafo.insertarAristaP(tablaCiudadCodigo.get("oruro"),tablaCiudadCodigo.get("la paz"),150);
	// 	grafo.insertarAristaP(tablaCiudadCodigo.get("oruro"),tablaCiudadCodigo.get("cochabamba"),100);
	// 	grafo.insertarAristaP(tablaCiudadCodigo.get("oruro"),tablaCiudadCodigo.get("potosi"),155);
	// 	grafo.insertarAristaP(tablaCiudadCodigo.get("potosi"),tablaCiudadCodigo.get("oruro"),155);
	// 	grafo.insertarAristaP(tablaCiudadCodigo.get("potosi"),tablaCiudadCodigo.get("tarija"),180);
	// 	grafo.insertarAristaP(tablaCiudadCodigo.get("chuquisaca"),tablaCiudadCodigo.get("cochabamba"),300);
	// 	grafo.insertarAristaP(tablaCiudadCodigo.get("chuquisaca"),tablaCiudadCodigo.get("santa cruz"),230);
	// 	grafo.insertarAristaP(tablaCiudadCodigo.get("chuquisaca"),tablaCiudadCodigo.get("tarija"),600);
	// 	grafo.insertarAristaP(tablaCiudadCodigo.get("tarija"),tablaCiudadCodigo.get("potosi"),180);
	// 	grafo.insertarAristaP(tablaCiudadCodigo.get("tarija"),tablaCiudadCodigo.get("chuquisaca"),600);
	// }
	// public String ruta(String origen , String destino){
	// 	String ruta = grafo.longRutaMinimaDijkstra(tablaCiudadCodigo.get(origen),tablaCiudadCodigo.get(destino));
	// 	return ruta;
	// }

}














