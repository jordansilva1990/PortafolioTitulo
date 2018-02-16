/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Hibernate.HibernateUtil;
import Model.Unidades;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Jordan Silva
 */
public class UnidadesDAO {

    //Hibernate CRUD
    public void ingresar(Unidades unidad) {
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            session.save(unidad);
            tx.commit();
            session.close();
        } catch (Exception ex) {
            tx.rollback();
            throw new RuntimeException("No se pudo guardar la Unidad");
        }

    }

    public void modificar(Unidades unidad) {
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            session.save(unidad);
            tx.commit();
            session.close();
        } catch (Exception ex) {
            tx.rollback();
            throw new RuntimeException("No se pudo modificar la Unidad");
        }
    }

    public List<Unidades> findAll() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Query query = session.createQuery("from Unidades");
        List<Unidades> lista = query.list();
        session.close();
        return lista;
    }

    public void eliminar(int idUnidad) {
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            session.delete(idUnidad);
            tx.commit();
            session.close();
        } catch (Exception ex) {
            tx.rollback();
            throw new RuntimeException("No se pudo eliminar la Unidad");
        }
    }

    //Stored Procedures CRUD  
    public void ingresarSP(Unidades unidad) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createSQLQuery("begin UNIDADES_TAPI.ins(:Nombre,sys_guid(),0); end;");
        query.setParameter("Nombre", unidad.getNombreunidad());
        query.executeUpdate();
        tx.commit();
        session.close();

    }

    public void actualizarSP(Unidades unidad) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createSQLQuery("begin UNIDADES_TAPI.upd(:Nombre,:id); end;");
        query.setParameter("Nombre", unidad.getNombreunidad());
        query.setParameter("id", unidad.getIdUnidad());
        query.executeUpdate();
        tx.commit();
        session.close();

    }

    public void eliminarSP(Unidades unidad) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createSQLQuery("begin UNIDADES_TAPI.del(:id); end;");
        query.setParameter("id", unidad.getIdUnidad());
        query.executeUpdate();
        tx.commit();
        session.close();

    }

}
