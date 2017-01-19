package Inicio;

import java.io.Serializable;

public class Empleados implements Serializable {
    
    private String codigo;
    private String nombre;
    private int horas;
    private double pago;
    private double pago_hora;
    private String puesto;
    private String planilla;
    private String modalidad;
    private double bonificacion;
    private double descuento;
    private double monto;
    
    public Empleados(){
        
    }
    
    public Empleados(String cod,String nomb,int h,double pag,double ph,String pu,String mod,String pla,double bo,double des,double mon){
        this.setCodigo(cod);
        this.setNombre(nomb);
        this.setHoras(h);
        this.setPago(pag);
        this.setPago_hora(ph);
        this.setPuesto(pu);
        this.setModalidad(mod);
        this.setPlanilla(pla);
        this.setBonificacion(bo);
        this.setDescuento(des);
        this.setMonto(mon);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public double getPago() {
        return pago;
    }

    public void setPago(double pago) {
        this.pago = pago;
    }

    public double getPago_hora() {
        return pago_hora;
    }

    public void setPago_hora(double pago_hora) {
        this.pago_hora = pago_hora;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getPlanilla() {
        return planilla;
    }

    public void setPlanilla(String planilla) {
        this.planilla = planilla;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public double getBonificacion() {
        return bonificacion;
    }

    public void setBonificacion(double bonificacion) {
        this.bonificacion = bonificacion;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
    
    public double pago_hora(String puesto, int horas){
        double pa = 0;
        if(puesto.equalsIgnoreCase("Capataz")){
            pa = 55.00 * horas;
        }else if(puesto.equalsIgnoreCase("Maestro")){
            pa = 42.00 * horas;
        }else if(puesto.equalsIgnoreCase("Operario")){
            pa = 25.00 * horas;
        }
        return pa;
    }
    
    public double bonificacion(double pago, String modalidad){
        double bo=0;
        if(modalidad.equalsIgnoreCase("Estable")){
            bo = 0.25 * pago;
        }else if(modalidad.equalsIgnoreCase("Contratado")){
            bo = 0.10 * pago;
        }
        return bo;
    }
    
    public double p_incial(double pago, double bonificacion){
        return pago + bonificacion;
    }
    
    public double Descuento(String planilla, double pa){
        double des=0;
        if(planilla.equalsIgnoreCase("AFP")){
            des = 0.035 * pa;
        }else if(planilla.equalsIgnoreCase("SEGURO")){
            des = 0.03 * pa;
        }else if(planilla.equalsIgnoreCase("FONAVI")){
            des = 0.025 * pa;
        }
        return des;
    }
    
    public double Monto(double pago, double descuento){
        return pago - descuento;
    }
    
}
