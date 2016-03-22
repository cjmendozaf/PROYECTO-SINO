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

import Modelo.Respuesta;
import Modelo.Tsnocorrespon;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class NocorrespondeControl {
    
    public List<Tsnocorrespon> ListarNocorrespondes()
    {
        SessionFactory hUtil = HibernateUtil.getSessionFactory();
        Session sCon = hUtil.openSession();
        Transaction tx = sCon.beginTransaction();
        Query q = sCon.createQuery("from Tsnocorrespon");
        List<Tsnocorrespon> lstNocorrespondes = q.list();        
        tx.commit();
        sCon.close();
       
        return lstNocorrespondes;
    }
    
    public Respuesta altaNocorresponde(Tsnocorrespon nocorresponde)
    {
        Respuesta oRespuesta = new Respuesta();
        
        try{
            SessionFactory hUtil = HibernateUtil.getSessionFactory();
            Session sCon = hUtil.openSession();
            Transaction tx = sCon.beginTransaction();
            sCon.save(nocorresponde);       
            tx.commit();
            sCon.close();
            oRespuesta.setCodRespuesta("1");
        } catch (Exception e) {
            oRespuesta.setCodRespuesta("2");
        }  
            
        return oRespuesta;    
    }
    
    public List<Tsnocorrespon> ListarNocorrespondeOcurrencia(String idOcurrencia)
    {
        SessionFactory hUtil = HibernateUtil.getSessionFactory();
        Session sCon = hUtil.openSession();
        Transaction tx = sCon.beginTransaction();
        Query q = sCon.createQuery("from Tsnocorrespon where idocurrencia=" + idOcurrencia);
        List<Tsnocorrespon> lstNocorrespondes = q.list();        
        tx.commit();
        sCon.close();
       
        return lstNocorrespondes;
    }
}
