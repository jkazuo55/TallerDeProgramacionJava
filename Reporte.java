//package modelo;

public class Reporte {
    private String nombreCiudad;
    private int flujo;

    public Reporte(String nombreCiudad, int flujo){
        this.nombreCiudad = nombreCiudad;
        this.flujo = flujo;
    }

    public void setNombreCiudad(String nombre){
        this.nombreCiudad = nombre;
    }

    public String getNombreCiudad(){
        return this.nombreCiudad;
    }

    public void setFlujo(int flujo){
        this.flujo = flujo;
    }

    public int getFlujo(){
        return this.flujo;
    }
} 
