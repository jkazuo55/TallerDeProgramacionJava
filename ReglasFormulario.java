import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
public class ReglasFormulario{

	public boolean validaDatos(String nombre,String apellidos,long cedula, String sexo , String nacidoEn,String direccion, long telefono,String correo,String fecha, String origen,String destino, String motivoDeMigracion){
		boolean res=false;

		// System.out.println("asd "+nombre.equals(""));
		// System.out.println(apellidos.equals(""));
		// System.out.println(cedula==0);
		// System.out.println(sexo.equals(""));
		// System.out.println(nacidoEn.equals(""));
		// System.out.println(direccion.equals(""));
		// System.out.println(telefono.equals(""));
		// System.out.println(correo.equals(""));
		// System.out.println(emigranteSiNo.equals(""));
		// System.out.println(fecha.equals(""));
		// System.out.println(origen.equals(""));
		// System.out.println(destino.equals(""));
		// // System.out.println("-"+ruta.equals(""));
		System.out.println(motivoDeMigracion.equals(""));

		if (nombre.equals("")||apellidos.equals("")||cedula==0||sexo.equals("")||nacidoEn.equals("")||direccion.equals("")||telefono==0||correo.equals("")||fecha.equals("")||origen.equals("")||destino.equals("")||motivoDeMigracion.equals("")) {
			res= false;
			escribir("no puede dejar espacios en blanco");		
		}else{
			escribir("se completo los campos del formulario");
			res = true;
		}
		return res;
	}
	public void escribir(String texto){
        JOptionPane.showMessageDialog(null, texto);
    }

    // public boolean validarTamanioDocumento(long cedula){
    // 	boolean res=false;
    // 	Long tamanioCI;
    // 	String cadenaCi=Long.toString(cedula);  	
    // 	tamanioCI=Long.valueOf(cadenaCi.length());
    // 	System.out.println("el tamanio del documento es ???"+ tamanioCI);
    // 	if (tamanioCI<=7) {
    // 		res=true;
    // 	}
    // 	return res;
    // }
    
    // public boolean validarTamanioDocumento(String cedula){
    // 	boolean res=false;
    // 	if (cedula.length()<=7) {
    // 		res=true;
    // 	}
    // 	return res;
    // }
    public boolean validarTamanioBusquedaDocumento(String cedula){
    	boolean res=false;
    	if (cedula.length()<=7) {
    		res=true;
    	}
    	return res;
    }

    public boolean validarTamanioCelular(long celular){
    	boolean res=false;
    	Long tamanioCelular;
    	String cadenaCelular=Long.toString(celular);  	
    	tamanioCelular=Long.valueOf(cadenaCelular.length());
    	if (tamanioCelular<=8) {
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