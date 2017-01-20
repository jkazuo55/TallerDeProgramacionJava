/**
* @class PanelEstadisticoModel.java 
* @brief Implementacion de la Clase PanelEstadisticoModel</br>
* La clase PanelEstadisticoModel represena al modelo del analisis estadistico;
* @author SoftTux
* @version 0.2
* @since 1.0
* @see https://github.com/jkazuo55/TallerDeProgramacionJava
*/
public class PanelEstadisticoModel {
    // private Lista<Emigrante> listaEmigrantes;
    // private String fileName;
    // private DeserializableGenerico<Lista> deser_gen;
    Controlador control;

    public PanelEstadisticoModel(){
        // fileName = "dataHistorialEmigrantes.ser";
        // deser_gen = new DeserializableGenerico<Lista>(fileName);
        // if(deser_gen.tieneDatos()){
        //     //listaEmigrantes = deser_gen.deserialize();
        // }
    }

    public Lista<Emigrante> getListaGeneral(){
        // if(deser_gen.tieneDatos()){
        //     listaEmigrantes = deser_gen.deserialize();
        // }
        // return this.listaEmigrantes;
        return control.getListaGeneralEmigrante();
    }
    public void setControlador(Controlador control) {
        this.control=control;
    }
}
