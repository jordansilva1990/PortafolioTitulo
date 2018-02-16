package Model;
// Generated 13-11-2017 13:26:02 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Resoluciones generated by hbm2java
 */
public class Resoluciones  implements java.io.Serializable {


     private byte[] idResolucion;
     private String resolucion;
     private Set resolucionesDetalles = new HashSet(0);

    public Resoluciones() {
    }

	
    public Resoluciones(byte[] idResolucion, String resolucion) {
        this.idResolucion = idResolucion;
        this.resolucion = resolucion;
    }
    public Resoluciones(byte[] idResolucion, String resolucion, Set resolucionesDetalles) {
       this.idResolucion = idResolucion;
       this.resolucion = resolucion;
       this.resolucionesDetalles = resolucionesDetalles;
    }
   
    public byte[] getIdResolucion() {
        return this.idResolucion;
    }
    
    public void setIdResolucion(byte[] idResolucion) {
        this.idResolucion = idResolucion;
    }
    public String getResolucion() {
        return this.resolucion;
    }
    
    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }
    public Set getResolucionesDetalles() {
        return this.resolucionesDetalles;
    }
    
    public void setResolucionesDetalles(Set resolucionesDetalles) {
        this.resolucionesDetalles = resolucionesDetalles;
    }




}


