/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import hibernate.HibernateUtil;
import hibernate.Amigo;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Mariangeles
 */
public class ModeloAmigo {

    public static List<Amigo> get() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        String hql = "from Amigo";
        Query q = session.createQuery(hql);
        List<Amigo> list = q.list();
        
        session.getTransaction().commit();
        session.close();
        return list;
    }
    
    public static Amigo getParametro(String id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Amigo o = (Amigo) session.get(Amigo.class,Integer.parseInt(id));
        
        session.getTransaction().commit();
        session.close();
        return o;
    }

    public static void delete(String id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Amigo o = (Amigo) session.load(Amigo.class,Integer.parseInt(id));
        session.delete(o);
        
        session.getTransaction().commit();
        session.flush();
        session.close();
    }
    
    public static void insert(Amigo o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        session.save(o);
        
        session.getTransaction().commit();
        session.flush();
        session.close();
    }
    
    public static void update(Amigo o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        session.update(o);
        
        session.getTransaction().commit();
        session.flush();
        session.close();
    }
}

