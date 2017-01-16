/**
* @class Modelo.java 
* @brief Implementacion de la Clase Modelo</br>
* La clase Modelo representa Al modelo principal donde se tine informacion de usuarios ;
* @author SoftTux
* @version 0.2
* @since 1.0
* @see https://github.com/jkazuo55/TallerDeProgramacionJava
*/

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Modelo{

	final int SELECCION= 0;
	final int ADMINISTRADOR=1;
	final int USUARIO=2;

	final String PASS_ADMIN="admin";
	final String PASS_USER="1234";

	Controlador control;

	Lista<Funcionario> listaFuncionario; 
    String fileName = "dataFuncionarios.ser"; 

    DeserializableGenerico<Lista> deser_gen;  

	public Modelo(){
    	listaFuncionario = new Lista<Funcionario>();
            deser_gen = new DeserializableGenerico<Lista>(fileName);
            if(deser_gen.tieneDatos()){
                listaFuncionario = deser_gen.deserialize();
            }        
	}

	public void setControlador(Controlador control){
		this.control=control;
	}

	public String validarIngreso(int index,String user,String pass){
		String retorno="";
		if (index==SELECCION) {
			retorno="error";
		}else{
			retorno = validarPass(index,user,pass);
		}
		return retorno;
	}
	private String validarPass(int index,String user,String pass){
		String retorno="";
		switch(index){
			case ADMINISTRADOR:
                                if(deser_gen.tieneDatos()){
                                    if (validarPasswordFromFile("Administrador",user,pass)) {
                                            retorno="Administrador";	
                                    }else{
                                            retorno="invalido";
                                    }
                                }else{
                                    if(pass.equals(PASS_ADMIN)) {
                                            retorno="Administrador";	
                                    }else{
                                            retorno="invalido";
                                    } 
                                }
			break;
			case USUARIO:
                                if(deser_gen.tieneDatos()){
                                    if (validarPasswordFromFile("Usuario",user,pass)) {
                                            retorno="Usuario";	
                                    }else{
                                            retorno="invalido";
                                    }
                                }else{
                                    if(pass.equals(PASS_USER)) {
                                            retorno="Usuario";	
                                    }else{
                                            retorno="invalido";
                                    } 
                                }
			break;			
		}
		return retorno;
	}
	private boolean validarPasswordFromFile(String tipoUser, String user, String password){
		boolean res=false;
		String rol;
		String us;
		String pass;
		for (Funcionario obj:listaFuncionario) {
			rol=obj.getRol();
			us=obj.getNombreUsuario();
			pass=obj.getContrasenia();
			if (rol.equalsIgnoreCase(tipoUser)&&us.equalsIgnoreCase(user)&&pass.equalsIgnoreCase(password)) {
				res = true;
			}
		}
		return res;
	}

	public String getFechaAcualDelSistema() {
	    Calendar calendar = new GregorianCalendar();
	    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	 	return dateFormat.format(calendar.getTime());
	}

}














