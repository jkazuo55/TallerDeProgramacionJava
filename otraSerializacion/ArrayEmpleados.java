package Inicio;

import java.util.ArrayList;
import java.io.Serializable;

public class ArrayEmpleados implements Serializable {
    
    // Creamos el ArrayList de la Clase Empleado
    private ArrayList <Empleados> e;
    
    // Inicializamos el ArrayList dentro del constructor aEmpleado
    public ArrayEmpleados(){
        e = new ArrayList();
    }
    
    // Metodod Insertar al arrayList
    public void Agregar(Empleados em){
        e.add(em);
    }
    
    // Metodod devolver la posicion del objeto dentro del arrayList
    public Empleados getEmpleado(int i){
        return e.get(i);
    }
    
    // Metodod Modificar al arrayList
    public void Actualizar(int p, Empleados nuevo){
        e.set(p, nuevo);
    }
    
    // Metodod Eliminar al arrayList
    public void Eliminar(int p){
        e.remove(p);
    }
    
    // Metodod EliminarTodo al arrayList
    public void ElimiarTodos(){
        int n = this.getNumero();
        for(int p=0; p<n; p++)
        {
            e.remove(0);
        }
    }
    
    // Metodod devolver el tamaño del arrayList
    public int getNumero(){
        return e.size();
    }
    
    // Metodod para Buscar la posicion donde se encuentre el objeto
    // dentro del arrayList
    public int buscar(String codigo){
        int n = this.getNumero();
        for(int p=0; p<n; p++)
        {
            if(codigo.equalsIgnoreCase(this.getEmpleado(p).getCodigo()))
            {
                return p;
            }
        }
        return -1;
    }
    
}
