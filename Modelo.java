//package modelo;

public class Modelo{

	final int SELECCION= 0;
	final int ADMINISTRADOR=1;
	final int USUARIO=2;

	final String PASS_ADMIN="admin";
	final String PASS_USER="1234";

	Controlador control;
	
	public Modelo(){
		
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
}