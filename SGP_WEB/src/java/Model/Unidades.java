package Model;
// Generated 23-10-2017 13:36:15 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Unidades generated by hbm2java
 */
public class Unidades  implements java.io.Serializable {


     private byte[] idUnidad;
     private String nombreunidad;
     private Set usuarioses = new HashSet(0);

    public Unidades() {
    }

	
    public Unidades(byte[] idUnidad, String nombreunidad) {
        this.idUnidad = idUnidad;
        this.nombreunidad = nombreunidad;
    }
    public Unidades(byte[] idUnidad, String nombreunidad, Set usuarioses) {
       this.idUnidad = idUnidad;
       this.nombreunidad = nombreunidad;
       this.usuarioses = usuarioses;
    }
   
    public byte[] getIdUnidad() {
        return this.idUnidad;
    }
    
    public void setIdUnidad(byte[] idUnidad) {
        this.idUnidad = idUnidad;
    }
    public String getNombreunidad() {
        return this.nombreunidad;
    }
    
    public void setNombreunidad(String nombreunidad) {
        this.nombreunidad = nombreunidad;
    }
    public Set getUsuarioses() {
        return this.usuarioses;
    }
    
    public void setUsuarioses(Set usuarioses) {
        this.usuarioses = usuarioses;
    }




}


