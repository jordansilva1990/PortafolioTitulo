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
import java.math.BigDecimal;
import java.util.Date;
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
public class PermisosDetalleDAO {

    //Hibernate CRUD
    public void ingresar(PermisosDetalles permisoDet) {
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            session.save(permisoDet);
            tx.commit();
            session.close();
        } catch (Exception ex) {
            tx.rollback();
            throw new RuntimeException("No se pudo guardar el Detalle del Permiso");
        }

    }

    public void modificar(PermisosDetalles permisoDet) {
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            session.save(permisoDet);
            tx.commit();
            session.close();
        } catch (Exception ex) {
            tx.rollback();
            throw new RuntimeException("No se pudo modificar el Permiso");
        }
    }

    //Se rescatan todos los permisos del sistema
    public List<Model.PermisosDetalles> findAll() {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
                applySettings(configuration.getProperties());
        SessionFactory sf = configuration.buildSessionFactory(builder.build());
        ///  SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Query query = session.createQuery("from PermisosDetalles");
        List<Model.PermisosDetalles> permisos = query.list();
        return permisos;
    }

    //Se rescata un permiso especifico por su id
    public List<Model.PermisosDetalles> find(String idDetallePermiso) {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
                applySettings(configuration.getProperties());
        SessionFactory sf = configuration.buildSessionFactory(builder.build());
        ///  SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Query query = session.createQuery("from PermisosDetalles where idDetallePermiso ='"+idDetallePermiso+"'");
      
        List<Model.PermisosDetalles> permisos = query.list();
        return permisos;
    }

    //Se rescatan todos los permisos correspondientes al usuario activo
    public List<Model.PermisosDetalles> findAllByUser(Usuarios usuario) {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
                applySettings(configuration.getProperties());
        SessionFactory sf = configuration.buildSessionFactory(builder.build());
        ///  SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Query query = session.createQuery("from PermisosDetalles where usuarios =:USUARIO");
        query.setParameter("USUARIO", usuario);
        List<Model.PermisosDetalles> permisos = query.list();
        return permisos;
    }

    //Se rescatan los permisos pendientes correspondientes al departamento del usuario activo
    public List<Model.PermisosDetalles> findAllByUserDepto(Usuarios usuario) {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
                applySettings(configuration.getProperties());
        SessionFactory sf = configuration.buildSessionFactory(builder.build());
        ///  SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Query query = session.createQuery("from PermisosDetalles where usuarios.unidades =:UNIDAD and estado =:ESTADO");
        query.setParameter("UNIDAD", usuario.getUnidades());
        query.setParameter("ESTADO", new BigDecimal(1));
        List<Model.PermisosDetalles> permisos = query.list();
        return permisos;
    }

    //Se rescatan los permisos pendientes correspondientes al departamento del usuario activo
    public List<Model.PermisosDetalles> findAllByUserDeptoDate(String depto, String date) {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
                applySettings(configuration.getProperties());
        SessionFactory sf = configuration.buildSessionFactory(builder.build());
        ///  SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Query query = session.createQuery("from PermisosDetalles where usuarios.unidades.nombreunidad =:UNIDAD AND to_char(fechaemision,'mm-yyyy') =:DATE");
        query.setParameter("UNIDAD",depto);
        query.setParameter("DATE",date);
        List<Model.PermisosDetalles> permisos = query.list();
        return permisos;
    }
    
    public void eliminar(int idDetallePermiso) {
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            session.delete(idDetallePermiso);
            tx.commit();
            session.close();
        } catch (Exception ex) {
            tx.rollback();
            throw new RuntimeException("No se pudo eliminar el Permiso");
        }
    }

    //Stored Procedures CRUD 
    public void ingresarSP(PermisosDetalles perDet, byte[] idUsuario, String idPermiso) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createSQLQuery("begin PERMISOS_DETALLES_TAPI.ins( :ESTADO,SYSDATE,:FECHAINICIO,:FECHAFIN,:MOTIVO, sys_guid(),:DIAS, :IDPERMISO, :IDUSUARIO ); end;");
        query.setParameter("ESTADO", new BigDecimal(1));
        query.setParameter("FECHAINICIO", perDet.getFechainicio());
        query.setParameter("FECHAFIN", perDet.getFechafin());
        query.setParameter("MOTIVO", perDet.getMotivo());
        query.setParameter("DIAS", perDet.getDias());
        query.setParameter("IDPERMISO", idPermiso);
        query.setParameter("IDUSUARIO", idUsuario);
        query.executeUpdate();
        tx.commit();
        session.close();

    }

    public void actualizarPermiso(PermisosDetalles perDet) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createSQLQuery("begin PERMISOS_DETALLES_TAPI.upd( :ESTADO,:FECHAEMISION,:FECHAINICIO,:FECHAFIN,:MOTIVO, :ID,:DIAS, :IDPERMISO, :IDUSUARIO ); end;");
        query.setParameter("ESTADO", perDet.getEstado());
        query.setParameter("FECHAEMISION", perDet.getFechaemision());
        query.setParameter("FECHAINICIO", perDet.getFechainicio());
        query.setParameter("FECHAFIN", perDet.getFechafin());
        query.setParameter("MOTIVO", perDet.getMotivo());
        query.setParameter("ID", perDet.getIdDetallePermiso());
        query.setParameter("DIAS", perDet.getDias());
        query.setParameter("IDPERMISO", perDet.getPermisos().getIdPermiso());
        query.setParameter("IDUSUARIO", perDet.getUsuarios().getIdUsuario());
        query.executeUpdate();
        tx.commit();
        session.close();
    }

}
