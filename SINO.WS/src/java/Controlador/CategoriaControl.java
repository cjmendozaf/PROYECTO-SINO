/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * @author Christopher
 */
import Modelo.Tscategoria;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class CategoriaControl {
    
    public List<Tscategoria> ListarCategorias()
    {
        SessionFactory hUtil = HibernateUtil.getSessionFactory();
        Session sCon = hUtil.openSession();
        Transaction tx = sCon.beginTransaction();
        Query q = sCon.createQuery("from Tscategoria");
        List<Tscategoria> lstCategorias = q.list();        
        tx.commit();
        sCon.close();
       
        return lstCategorias;
    }
    
    public List<Tscategoria> ListarCategoriasTipo(String idTipo)
    {
        SessionFactory hUtil = HibernateUtil.getSessionFactory();
        Session sCon = hUtil.openSession();
        Transaction tx = sCon.beginTransaction();
        Query q = sCon.createQuery("from Tscategoria where idtipo=" + idTipo);
        List<Tscategoria> lstCategorias = q.list();        
        tx.commit();
        sCon.close();
       
        return lstCategorias;
    }
    
    public Tscategoria getCategoriaID(String id){

        Tscategoria categoria = null;

        try {
            SessionFactory hUtil = HibernateUtil.getSessionFactory();
            Session sCon = hUtil.openSession();
            Transaction tx = sCon.beginTransaction();
            Query q = sCon.createQuery("from Tscategoria where idcategoria=" + id);
            categoria = (Tscategoria) q.uniqueResult();
            tx.commit();        
            sCon.close();
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return categoria;
    }
    
}
