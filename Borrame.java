import java.util.ArrayList;
public class Borrame{
	PersonaEmigrante persona1;
	PersonaEmigrante persona2;
	PersonaEmigrante persona3;
	PersonaEmigrante persona4;
	Lista<PersonaEmigrante> lista;
	public Borrame(){
		lista =  new Lista<PersonaEmigrante>();
		inicio();

	}

	public void inicio (){

		persona1 = new PersonaEmigrante("nombre","apellidos",12321,"sexo","nacidoEn","direccion","telefono","correo","emigrante","fecha","origen","destino","motivo");
		persona2 = new PersonaEmigrante("nombre","apellidos",12321,"sexo","nacidoEn","direccion","telefono","correo","emigrante","fecha","origen","destino","motivo");
		persona3 = new PersonaEmigrante("nombre","apellidos",123,"sexo","nacidoEn","direccion","telefono","correo","emigrante","fecha","origen","destino","motivo");
		persona4 = new PersonaEmigrante("nombre","apellidos",12321,"sexo","nacidoEn","direccion","telefono","correo","emigrante","fecha","origen","destino","motivo");

		lista.insertarAlFinal(persona1);
		lista.insertarAlFinal(persona2);
		lista.insertarAlFinal(persona3);
		lista.insertarAlFinal(persona4);

	}



}