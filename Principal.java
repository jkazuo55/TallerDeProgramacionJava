import java.util.Scanner;

public class Principal{
	public static void main(String[] args) {
		Persona p1 =new Persona("julian","464665165 LP","La Paz","Hombre",26);
		Ciudad c1 =new Ciudad("cochabamba");

		c1.agregarPersonas(p1);
		boolean valor=false;
		Scanner lector=new Scanner(System.in);
		System.out.println("ingres un nombre");
		String nombre=lector.nextLine();
		valor=c1.buscarPorNombre(nombre);

	}
}