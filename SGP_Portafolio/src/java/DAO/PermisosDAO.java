/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Hibernate.HibernateUtil;
import Model.Permisos;
import Model.PermisosDetalles;
import Model.Usuarios;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Jordan Silva
 */
public class PermisosDAO {

    //Hibernate CRUD
    public void ingresar(Permisos permiso) {
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            session.save(permiso);
            tx.commit();
            session.close();
        } catch (Exception ex) {
            tx.rollback();
            throw new RuntimeException("No se pudo guardar el Permiso");
        }

    }

    public void modificar(Permisos permiso) {
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            session.save(permiso);
            tx.commit();
            session.close();
        } catch (Exception ex) {
            tx.rollback();
            throw new RuntimeException("No se pudo modificar el Permiso");
        }
    }

    public List<Permisos> findAll() {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
                applySettings(configuration.getProperties());
        SessionFactory sf = configuration.buildSessionFactory(builder.build());
        ///  SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Query query = session.createQuery("from Permisos");
        List<Permisos> permisos = query.list();
        return permisos;
    }

    public void eliminar(int idPermiso) {
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            session.delete(idPermiso);
            tx.commit();
            session.close();
        } catch (Exception ex) {
            tx.rollback();
            throw new RuntimeException("No se pudo eliminar el Permiso");
        }
    }

    
    
    public List<Permisos> findLast() {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
                applySettings(configuration.getProperties());
        SessionFactory sf = configuration.buildSessionFactory(builder.build());
        ///  SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Query query = session.createQuery("from Permisos where idIncrement = (SELECT MAX (idIncrement) FROM Permisos)");
        List<Permisos> permisos = query.list();
        return permisos;
    }

    //Stored Procedures CRUD  
    public void ingresarSP(Permisos permiso, byte[] idUsuario, String idTipoPermiso) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createSQLQuery("begin PERMISOS_TAPI.ins( :TIPOPERMISO,sys_guid(),:IDTIPOPERMISO,:IDUSUARIO); end;");
        query.setParameter("TIPOPERMISO", permiso.getTipopermiso());
        query.setParameter("IDTIPOPERMISO", idTipoPermiso);
        query.setParameter("IDUSUARIO", idUsuario);
        query.executeUpdate();
        tx.commit();
        session.close();

    }

}
