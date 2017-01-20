/**
* @class ReglasForumulario.java 
* @brief Implementacion de la Clase ReglasForumulario</br>
* La clase ReglasForumulario es una clase de modelo donde se hacenlas validaciones para los formularios;
* @author SoftTux
* @version 0.2
* @since 1.0
* @see https://github.com/jkazuo55/TallerDeProgramacionJava
*/
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
public class ReglasFormulario{

	public boolean validaDatos(String nombre,String apellidos,String cedula, String sexo , String nacidoEn,String direccion, String telefono,String correo,String fecha, String origen,String destino, String motivoDeMigracion){
        boolean res=false;
        System.out.println(motivoDeMigracion.equals(""));

        if (nombre.equals("")||apellidos.equals("")||cedula.equals("")||sexo.equals("Seleccionar")||nacidoEn.equals("")||direccion.equals("")||telefono.equals("")||correo.equals("")||fecha.equals("")||origen.equals("Seleccionar")||destino.equals("Seleccionar")||motivoDeMigracion.equals("")) {
            res= false;
        }else{
            res = true;
        }
        return res;
    }
    public boolean validaDatosEmpleado(String nombre,String apellidos,String cedula, String sexo , String nacidoEn,String direccion, String telefono,String correo,String usuario,String contrasenia, String rol){
		boolean res=false;
		if (nombre.equals("")||apellidos.equals("")||cedula.equals("")||sexo.equals("Seleccionar")||nacidoEn.equals("")||direccion.equals("")||telefono.equals("")||correo.equals("")||usuario.equals("Seleccionar")||contrasenia.equals("Seleccionar")||rol.equals("Seleccionar")) {
			res= false;
		}else{
			res = true;
		}
		return res;
	}

	public void escribir(String texto){
        JOptionPane.showMessageDialog(null, texto);
    }

    public boolean validarCampoBusqueda(String cedulaBusqueda){
    	boolean res=false;
    	System.out.println("al momento de validar campos :"+cedulaBusqueda);
    	System.out.println("resultado : "+cedulaBusqueda.equals(""));
    	if (cedulaBusqueda.equals("")) {
    		res=true;
    	}
    	return res;
    }
    public boolean validarTamanioBusquedaDocumento(String cedula){
    	boolean res=false;
    	if ((cedula.length()<=8)&&(cedula.length()>=5)) {
    		res=true;
    	}
    	return res;
    }

    public boolean validarTamanioCelular(String celular){
        boolean res=false;
        if (celular.length()==8) {
            res=true;
        }
        return res;	
    }

    public boolean validarTamanioNombre(String nombre){
    	boolean res=false;  	
    	if (nombre.length()<=20){
    		res=true;
    	}
    	return res;
    }
    public boolean validarTamanioDireccionLugarNacimieno(String nombre){
    	boolean res=false;  	
    	if (nombre.length()<=30){
    		res=true;
    	}
    	return res;
    }

     
    public boolean validateEmail(String email) {
    	String patronCorreo = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(patronCorreo);    
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }    
     
    
}