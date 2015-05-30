/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import hibernate.HibernateUtil;
import hibernate.Persona;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Mariangeles
 */
public class ModeloPersona {

    public static List<Persona> get() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        String hql = "from Persona";
        Query q = session.createQuery(hql);
        List<Persona> list = q.list();
        
        session.getTransaction().commit();
        session.close();
        return list;
    }
    
    public static Persona getParametro(String id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Persona o = (Persona) session.get(Persona.class,Integer.parseInt(id));
        
        session.getTransaction().commit();
        session.close();
        return o;
    }

    public static void delete(String id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Persona o = (Persona) session.load(Persona.class,Integer.parseInt(id));
        session.delete(o);
        
        session.getTransaction().commit();
        session.flush();
        session.close();
    }
    
    public static void insert(Persona o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        session.save(o);
        
        session.getTransaction().commit();
        session.flush();
        session.close();
    }
    
    public static void update(Persona o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        session.update(o);
        
        session.getTransaction().commit();
        session.flush();
        session.close();
    }
}

