/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import hibernate.HibernateUtil;
import hibernate.Localizacion;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Mariangeles
 */
public class ModeloLocalizacion {

    public static List<Localizacion> get() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        String hql = "from Localizacion";
        Query q = session.createQuery(hql);
        List<Localizacion> list = q.list();
        
        session.getTransaction().commit();
        session.close();
        return list;
    }
    
    public static Localizacion getParametro(String id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Localizacion o = (Localizacion) session.get(Localizacion.class,Integer.parseInt(id));
        
        session.getTransaction().commit();
        session.close();
        return o;
    }

    public static void delete(String id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Localizacion o = (Localizacion) session.load(Localizacion.class,Integer.parseInt(id));
        session.delete(o);
        
        session.getTransaction().commit();
        session.flush();
        session.close();
    }
    
    public static void insert(Localizacion o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        session.save(o);
        
        session.getTransaction().commit();
        session.flush();
        session.close();
    }
    
    public static void update(Localizacion o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        session.update(o);
        
        session.getTransaction().commit();
        session.flush();
        session.close();
    }
}
