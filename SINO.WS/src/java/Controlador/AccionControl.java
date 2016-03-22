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
import Modelo.Tsocurraccion;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class AccionControl {
    
    public List<Tsocurraccion> ListarOcurraccions()
    {
        SessionFactory hUtil = HibernateUtil.getSessionFactory();
        Session sCon = hUtil.openSession();
        Transaction tx = sCon.beginTransaction();
        Query q = sCon.createQuery("from Tsocurraccion");
        List<Tsocurraccion> lstOCurraccions = q.list();        
        tx.commit();
        sCon.close();
       
        return lstOCurraccions;
    }
    
    public Respuesta altaOcurracions(Tsocurraccion ocurracion)
    {
        Respuesta oRespuesta = new Respuesta();
        
        try{
            SessionFactory hUtil = HibernateUtil.getSessionFactory();
            Session sCon = hUtil.openSession();
            Transaction tx = sCon.beginTransaction();
            sCon.save(ocurracion);       
            tx.commit();
            sCon.close();
            oRespuesta.setCodRespuesta("1");
        } catch (Exception e) {
            oRespuesta.setCodRespuesta("2");
        }  
            
        return oRespuesta;    
    }
    
    public List<Tsocurraccion> ListarAccionOcurrencia(String idOcurrencia)
    {
        SessionFactory hUtil = HibernateUtil.getSessionFactory();
        Session sCon = hUtil.openSession();
        Transaction tx = sCon.beginTransaction();
        Query q = sCon.createQuery("from Tsocurraccion where idocurrencia=" + idOcurrencia);
        List<Tsocurraccion> lstAccions = q.list();        
        tx.commit();
        sCon.close();
       
        return lstAccions;
    }
    
}
