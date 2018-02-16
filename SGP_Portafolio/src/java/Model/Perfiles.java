package Model;
// Generated 13-11-2017 13:26:02 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Perfiles generated by hbm2java
 */
public class Perfiles  implements java.io.Serializable {


     private byte[] idPerfil;
     private String nombreperfil;
     private BigDecimal crudTiposAuth;
     private BigDecimal crudMotivosAuth;
     private BigDecimal crudUnidadesAuth;
     private BigDecimal genPermisosAuth;
     private BigDecimal genResolucionesAuth;
     private BigDecimal authPermisosAuth;
     private BigDecimal qryPermisosAuth;
     private BigDecimal qryResolucionesAuth;
     private BigDecimal verDocumentosAuth;
     private BigDecimal dowDocumentosAuth;
     private BigDecimal genReportesAuth;
     private Set usuarioses = new HashSet(0);

    public Perfiles() {
    }

	
    public Perfiles(byte[] idPerfil, String nombreperfil, BigDecimal crudTiposAuth, BigDecimal crudMotivosAuth, BigDecimal crudUnidadesAuth, BigDecimal genPermisosAuth, BigDecimal genResolucionesAuth, BigDecimal authPermisosAuth, BigDecimal qryPermisosAuth, BigDecimal qryResolucionesAuth, BigDecimal verDocumentosAuth, BigDecimal dowDocumentosAuth, BigDecimal genReportesAuth) {
        this.idPerfil = idPerfil;
        this.nombreperfil = nombreperfil;
        this.crudTiposAuth = crudTiposAuth;
        this.crudMotivosAuth = crudMotivosAuth;
        this.crudUnidadesAuth = crudUnidadesAuth;
        this.genPermisosAuth = genPermisosAuth;
        this.genResolucionesAuth = genResolucionesAuth;
        this.authPermisosAuth = authPermisosAuth;
        this.qryPermisosAuth = qryPermisosAuth;
        this.qryResolucionesAuth = qryResolucionesAuth;
        this.verDocumentosAuth = verDocumentosAuth;
        this.dowDocumentosAuth = dowDocumentosAuth;
        this.genReportesAuth = genReportesAuth;
    }
    public Perfiles(byte[] idPerfil, String nombreperfil, BigDecimal crudTiposAuth, BigDecimal crudMotivosAuth, BigDecimal crudUnidadesAuth, BigDecimal genPermisosAuth, BigDecimal genResolucionesAuth, BigDecimal authPermisosAuth, BigDecimal qryPermisosAuth, BigDecimal qryResolucionesAuth, BigDecimal verDocumentosAuth, BigDecimal dowDocumentosAuth, BigDecimal genReportesAuth, Set usuarioses) {
       this.idPerfil = idPerfil;
       this.nombreperfil = nombreperfil;
       this.crudTiposAuth = crudTiposAuth;
       this.crudMotivosAuth = crudMotivosAuth;
       this.crudUnidadesAuth = crudUnidadesAuth;
       this.genPermisosAuth = genPermisosAuth;
       this.genResolucionesAuth = genResolucionesAuth;
       this.authPermisosAuth = authPermisosAuth;
       this.qryPermisosAuth = qryPermisosAuth;
       this.qryResolucionesAuth = qryResolucionesAuth;
       this.verDocumentosAuth = verDocumentosAuth;
       this.dowDocumentosAuth = dowDocumentosAuth;
       this.genReportesAuth = genReportesAuth;
       this.usuarioses = usuarioses;
    }
   
    public byte[] getIdPerfil() {
        return this.idPerfil;
    }
    
    public void setIdPerfil(byte[] idPerfil) {
        this.idPerfil = idPerfil;
    }
    public String getNombreperfil() {
        return this.nombreperfil;
    }
    
    public void setNombreperfil(String nombreperfil) {
        this.nombreperfil = nombreperfil;
    }
    public BigDecimal getCrudTiposAuth() {
        return this.crudTiposAuth;
    }
    
    public void setCrudTiposAuth(BigDecimal crudTiposAuth) {
        this.crudTiposAuth = crudTiposAuth;
    }
    public BigDecimal getCrudMotivosAuth() {
        return this.crudMotivosAuth;
    }
    
    public void setCrudMotivosAuth(BigDecimal crudMotivosAuth) {
        this.crudMotivosAuth = crudMotivosAuth;
    }
    public BigDecimal getCrudUnidadesAuth() {
        return this.crudUnidadesAuth;
    }
    
    public void setCrudUnidadesAuth(BigDecimal crudUnidadesAuth) {
        this.crudUnidadesAuth = crudUnidadesAuth;
    }
    public BigDecimal getGenPermisosAuth() {
        return this.genPermisosAuth;
    }
    
    public void setGenPermisosAuth(BigDecimal genPermisosAuth) {
        this.genPermisosAuth = genPermisosAuth;
    }
    public BigDecimal getGenResolucionesAuth() {
        return this.genResolucionesAuth;
    }
    
    public void setGenResolucionesAuth(BigDecimal genResolucionesAuth) {
        this.genResolucionesAuth = genResolucionesAuth;
    }
    public BigDecimal getAuthPermisosAuth() {
        return this.authPermisosAuth;
    }
    
    public void setAuthPermisosAuth(BigDecimal authPermisosAuth) {
        this.authPermisosAuth = authPermisosAuth;
    }
    public BigDecimal getQryPermisosAuth() {
        return this.qryPermisosAuth;
    }
    
    public void setQryPermisosAuth(BigDecimal qryPermisosAuth) {
        this.qryPermisosAuth = qryPermisosAuth;
    }
    public BigDecimal getQryResolucionesAuth() {
        return this.qryResolucionesAuth;
    }
    
    public void setQryResolucionesAuth(BigDecimal qryResolucionesAuth) {
        this.qryResolucionesAuth = qryResolucionesAuth;
    }
    public BigDecimal getVerDocumentosAuth() {
        return this.verDocumentosAuth;
    }
    
    public void setVerDocumentosAuth(BigDecimal verDocumentosAuth) {
        this.verDocumentosAuth = verDocumentosAuth;
    }
    public BigDecimal getDowDocumentosAuth() {
        return this.dowDocumentosAuth;
    }
    
    public void setDowDocumentosAuth(BigDecimal dowDocumentosAuth) {
        this.dowDocumentosAuth = dowDocumentosAuth;
    }
    public BigDecimal getGenReportesAuth() {
        return this.genReportesAuth;
    }
    
    public void setGenReportesAuth(BigDecimal genReportesAuth) {
        this.genReportesAuth = genReportesAuth;
    }
    public Set getUsuarioses() {
        return this.usuarioses;
    }
    
    public void setUsuarioses(Set usuarioses) {
        this.usuarioses = usuarioses;
    }




}


