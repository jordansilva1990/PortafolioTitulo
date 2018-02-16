/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Hibernate.HibernateUtil;
import Model.Resoluciones;
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
public class ResolucionDAO {
    //Hibernate CRUD

    public void ingresar(Resoluciones resoluc) {
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            session.save(resoluc);
            tx.commit();
            session.close();
        } catch (Exception ex) {
            tx.rollback();
            throw new RuntimeException("No se pudo guardar la Resolucion");
        }

    }

    public void modificar(Resoluciones resoluc) {
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            session.save(resoluc);
            tx.commit();
            session.close();
        } catch (Exception ex) {
            tx.rollback();
            throw new RuntimeException("No se pudo modificar la Resolucion");
        }
    }

    public List<Resoluciones> findAll() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Query query = session.createQuery("from Resoluciones");
        List<Resoluciones> lista = query.list();
        session.close();
        return lista;
    }

    public List<Resoluciones> find(String idResoluc){
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
        applySettings(configuration.getProperties());
        SessionFactory sf = configuration.buildSessionFactory(builder.build());          
      ///  SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Query query = session.createQuery("from Resoluciones where idResolucion='"+idResoluc+"'");
        List<Resoluciones> resoluc =  query.list();
        session.close();
        return resoluc;
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
            throw new RuntimeException("No se pudo eliminar la Resolucion");
        }
    }

    //Stored Procedures CRUD  
     public void ingresarSP(Resoluciones resoluc) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createSQLQuery("begin RESOLUCIONES_TAPI.ins( :RESOLUCION, sys_guid()); end;");
        query.setParameter("RESOLUCION",resoluc.getResolucion());        
        query.executeUpdate();
        tx.commit();
        session.close();

    }
     
    public List<Resoluciones> findLast(){
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
        applySettings(configuration.getProperties());
        SessionFactory sf = configuration.buildSessionFactory(builder.build());          
      ///  SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Query query = session.createQuery(" from Resoluciones where idResolucion = (select max(idResolucion) from Resoluciones)");
        List<Resoluciones> resoluc =  query.list();
        session.close();
        return resoluc;
    }
}
