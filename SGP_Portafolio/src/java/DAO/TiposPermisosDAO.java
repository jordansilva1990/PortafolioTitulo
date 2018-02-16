/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Hibernate.HibernateUtil;
import Model.Permisos;
import Model.TiposPermisos;
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
public class TiposPermisosDAO {
      //Hibernate CRUD
      public void ingresar(TiposPermisos tipoPer) {
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            session.save(tipoPer);
            tx.commit();
            session.close();
        } catch (Exception ex) {
            tx.rollback();
            throw new RuntimeException("No se pudo guardar el usuario");
        }
                
    }
      
       public void modificar(TiposPermisos tipoPer) {
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            session.save(tipoPer);
            tx.commit();
            session.close();
        } catch (Exception ex) {
            tx.rollback();
            throw new RuntimeException("No se pudo modificar el Tipo de Permiso");
        }
    }
       
          public List<TiposPermisos> findAll() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Query query = session.createQuery("from TiposPermisos");
        List<TiposPermisos> lista = query.list();
        session.close();
        return lista;
    }
          
        public void eliminar(int idTipoPermiso) {
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            session.delete(idTipoPermiso);
            tx.commit();
            session.close();
        } catch (Exception ex) {
            tx.rollback();
            throw new RuntimeException("No se pudo eliminar el Tipo de Permiso");
        }
    }
      public List<TiposPermisos> find(String nombreTipo) {
          /*
            Configuration configuration = new Configuration().configure();
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
            applySettings(configuration.getProperties());
            SessionFactory sf = configuration.buildSessionFactory(builder.build());          
            ///  SessionFactory sf = HibernateUtil.getSessionFactory();
            Session session = sf.openSession();
            Query query = session.createQuery("from TiposPermisos where detallepermiso="+nombreTipo);
            List<TiposPermisos> tipos =  query.list();
            return tipos;*/
          
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from TiposPermisos where detallepermiso = :nombreTipo");
        query.setParameter("nombreTipo", nombreTipo);
        List<TiposPermisos> lista = query.list();
        session.close();
        return lista;
          
          
          
        }
      
    //Stored Procedures CRUD  
      
}
