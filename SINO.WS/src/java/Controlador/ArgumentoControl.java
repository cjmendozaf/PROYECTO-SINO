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
import Modelo.Tsaccioargume;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ArgumentoControl {
    
    public List<Tsaccioargume> ListarArgumentos()
    {
        SessionFactory hUtil = HibernateUtil.getSessionFactory();
        Session sCon = hUtil.openSession();
        Transaction tx = sCon.beginTransaction();
        Query q = sCon.createQuery("from Tsaccioargume");
        List<Tsaccioargume> lstArgumentos = q.list();        
        tx.commit();
        sCon.close();
       
        return lstArgumentos;
    }
    
    public List<Tsaccioargume> ListarArgumentosAccion(String idAccion)
    {
        SessionFactory hUtil = HibernateUtil.getSessionFactory();
        Session sCon = hUtil.openSession();
        Transaction tx = sCon.beginTransaction();
        Query q = sCon.createQuery("from Tsaccioargume where idocurraccion=" + idAccion);
        List<Tsaccioargume> lstArgumentos = q.list();        
        tx.commit();
        sCon.close();
       
        return lstArgumentos;
    }
    
    public Respuesta altaArgumentos(Tsaccioargume argumento)
    {
        Respuesta oRespuesta = new Respuesta();
        
        try{
            SessionFactory hUtil = HibernateUtil.getSessionFactory();
            Session sCon = hUtil.openSession();
            Transaction tx = sCon.beginTransaction();
            sCon.save(argumento);       
            tx.commit();
            sCon.close();
            oRespuesta.setCodRespuesta("1");
        } catch (Exception e) {
            oRespuesta.setCodRespuesta("2");
        }  
            
        return oRespuesta;    
    }
    
    public List<Tsaccioargume> ListarAccionOcurrencia(String idAccion)
    {
        SessionFactory hUtil = HibernateUtil.getSessionFactory();
        Session sCon = hUtil.openSession();
        Transaction tx = sCon.beginTransaction();
        Query q = sCon.createQuery("from Tsaccioargume where idocurraccion=" + idAccion);
        List<Tsaccioargume> lstArgumentos = q.list();        
        tx.commit();
        sCon.close();
       
        return lstArgumentos;
    }
}
