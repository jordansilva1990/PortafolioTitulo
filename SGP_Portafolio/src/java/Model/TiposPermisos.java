package Model;
// Generated 13-11-2017 13:26:02 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * TiposPermisos generated by hbm2java
 */
public class TiposPermisos  implements java.io.Serializable {


     private byte[] idTipoPermiso;
     private String detallepermiso;
     private BigDecimal diasafectos;
     private BigDecimal eliminado;
     private Set permisoses = new HashSet(0);

    public TiposPermisos() {
    }

	
    public TiposPermisos(byte[] idTipoPermiso, String detallepermiso, BigDecimal diasafectos, BigDecimal eliminado) {
        this.idTipoPermiso = idTipoPermiso;
        this.detallepermiso = detallepermiso;
        this.diasafectos = diasafectos;
        this.eliminado = eliminado;
    }
    public TiposPermisos(byte[] idTipoPermiso, String detallepermiso, BigDecimal diasafectos, BigDecimal eliminado, Set permisoses) {
       this.idTipoPermiso = idTipoPermiso;
       this.detallepermiso = detallepermiso;
       this.diasafectos = diasafectos;
       this.eliminado = eliminado;
       this.permisoses = permisoses;
    }
   
    public byte[] getIdTipoPermiso() {
        return this.idTipoPermiso;
    }
    
    public void setIdTipoPermiso(byte[] idTipoPermiso) {
        this.idTipoPermiso = idTipoPermiso;
    }
    public String getDetallepermiso() {
        return this.detallepermiso;
    }
    
    public void setDetallepermiso(String detallepermiso) {
        this.detallepermiso = detallepermiso;
    }
    public BigDecimal getDiasafectos() {
        return this.diasafectos;
    }
    
    public void setDiasafectos(BigDecimal diasafectos) {
        this.diasafectos = diasafectos;
    }
    public BigDecimal getEliminado() {
        return this.eliminado;
    }
    
    public void setEliminado(BigDecimal eliminado) {
        this.eliminado = eliminado;
    }
    public Set getPermisoses() {
        return this.permisoses;
    }
    
    public void setPermisoses(Set permisoses) {
        this.permisoses = permisoses;
    }




}


