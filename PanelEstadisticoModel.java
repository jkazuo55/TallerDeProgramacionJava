//package org.softtux.model;
public class PanelEstadisticoModel {
    private Lista<Emigrante> listaEmigrantes;
    private String fileName;
    private DeserializableGenerico<Lista> deser_gen;
    public PanelEstadisticoModel(){
        fileName = "dataHistorialEmigrantes.ser";
        deser_gen = new DeserializableGenerico<Lista>(fileName);
        listaEmigrantes = deser_gen.deserialize();


    }

    public Lista<Emigrante> listaGeneral(){
        return this.listaEmigrantes;
    }
}
