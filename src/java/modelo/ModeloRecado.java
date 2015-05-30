/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import hibernate.HibernateUtil;
import hibernate.Recado;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Mariangeles
 */
public class ModeloRecado {

    public static List<Recado> get() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        String hql = "from Recado";
        Query q = session.createQuery(hql);
        List<Recado> list = q.list();
        
        session.getTransaction().commit();
        session.close();
        return list;
    }
    
    public static Recado getParametro(String id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Recado o = (Recado) session.get(Recado.class,Integer.parseInt(id));
        
        session.getTransaction().commit();
        session.close();
        return o;
    }

    public static void delete(String id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Recado o = (Recado) session.load(Recado.class,Integer.parseInt(id));
        session.delete(o);
        
        session.getTransaction().commit();
        session.flush();
        session.close();
    }
    
    public static void insert(Recado o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        session.save(o);
        
        session.getTransaction().commit();
        session.flush();
        session.close();
    }
    
    public static void update(Recado o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        session.update(o);
        
        session.getTransaction().commit();
        session.flush();
        session.close();
    }
}
