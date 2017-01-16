//package org.softtux.model;
public class PanelEstadisticoModel {
    private Lista<Emigrante> listaEmigrantes;
    private String fileName;
    private DeserializableGenerico<Lista> deser_gen;
    public PanelEstadisticoModel(){
        fileName = "dataHistorialEmigrantes.ser";
        deser_gen = new DeserializableGenerico<Lista>(fileName);
        if(deser_gen.tieneDatos()){
            //listaEmigrantes = deser_gen.deserialize();
        }
    }

    public Lista<Emigrante> getListaGeneral(){
        if(deser_gen.tieneDatos()){
            listaEmigrantes = deser_gen.deserialize();
        }
        return this.listaEmigrantes;
    }
}
