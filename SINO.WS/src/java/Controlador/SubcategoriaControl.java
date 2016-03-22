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

import Modelo.Tssubcategori;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class SubcategoriaControl {
 
    public List<Tssubcategori> ListarSubcategoris()
    {
        SessionFactory hUtil = HibernateUtil.getSessionFactory();
        Session sCon = hUtil.openSession();
        Transaction tx = sCon.beginTransaction();
        Query q = sCon.createQuery("from Tssubcategori");
        List<Tssubcategori> lstSubcategorias = q.list();        
        tx.commit();
        sCon.close();
       
        return lstSubcategorias;
    }
    
    public List<Tssubcategori> ListarSubcategoriasCategoria(String idCategoria)
    {
        SessionFactory hUtil = HibernateUtil.getSessionFactory();
        Session sCon = hUtil.openSession();
        Transaction tx = sCon.beginTransaction();
        Query q = sCon.createQuery("from Tssubcategori where idcategoria=" + idCategoria);
        List<Tssubcategori> lstSubcategorias = q.list();        
        tx.commit();
        sCon.close();
       
        return lstSubcategorias;
    }
}
