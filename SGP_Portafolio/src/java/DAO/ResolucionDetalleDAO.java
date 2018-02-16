/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Hibernate.HibernateUtil;
import Model.ResolucionesDetalle;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Jordan Silva
 */
public class ResolucionDetalleDAO {
    //Hibernate CRUD

    public void ingresar(ResolucionesDetalle resolucDet) {
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            session.save(resolucDet);
            tx.commit();
            session.close();
        } catch (Exception ex) {
            tx.rollback();
            throw new RuntimeException("No se pudo guardar el detalle de la Resolucion");
        }

    }

    public void modificar(ResolucionesDetalle resolucDet) {
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            session.save(resolucDet);
            tx.commit();
            session.close();
        } catch (Exception ex) {
            tx.rollback();
            throw new RuntimeException("No se pudo modificar el detalle de la Resolucion");
        }
    }

    public List<ResolucionesDetalle> findAll() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Query query = session.createQuery("from ResolucionesDetalle");
        List<ResolucionesDetalle> lista = query.list();
        session.close();
        return lista;
    }
    
    public List<ResolucionesDetalle> findById(String idResolucion) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Query query = session.createQuery("from ResolucionesDetalle where resoluciones.idResolucion ='"+idResolucion +"'");
        List<ResolucionesDetalle> lista = query.list();
        session.close();
        return lista;
    }
    public void eliminar(int idResoluc) {
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            session.delete(idResoluc);
            tx.commit();
            session.close();
        } catch (Exception ex) {
            tx.rollback();
            throw new RuntimeException("No se pudo eliminar el detalle la Resolucion");
        }
    }

    //Stored Procedures CRUD  
    public void ingresarSP(ResolucionesDetalle resoluc, String idResolucion, String idPermiso) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createSQLQuery("begin RESOLUCIONES_DETALLE_TAPI.ins( SYSDATE, :RECURSOLEGALAFECTO, sys_guid(),'" + idResolucion + "',:JUSTIFICACION, '" + idPermiso + "'); end;");
        query.setParameter("RECURSOLEGALAFECTO", resoluc.getRecursolegalafecto());
        query.setParameter("JUSTIFICACION", resoluc.getJustificacion());
        query.executeUpdate();
        tx.commit();
        session.close();

    }

}
