/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Respuesta;
import Modelo.Tsocurrencia;
import Modelo.OcurrenciaBusqueda;
import Modelo.ResumenTipo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Christopher
 */
public class OcurrenciaControl {
    
    public List<Tsocurrencia> ListarOcurrencias()
    {
        SessionFactory hUtil = HibernateUtil.getSessionFactory();
        Session sCon = hUtil.openSession();
        Transaction tx = sCon.beginTransaction();
        Query q = sCon.createQuery("from Tsocurrencia");
        List<Tsocurrencia> lstOcurrencias = q.list();        
        tx.commit();
        sCon.close();
       
        return lstOcurrencias;
    }
    
    public List<OcurrenciaBusqueda> BuscarOcurrencias(OcurrenciaBusqueda ocurrencia)
    {
        List<OcurrenciaBusqueda> lstOcurrencias = null;
        try{
            SessionFactory hUtil = HibernateUtil.getSessionFactory();
            Session sCon = hUtil.openSession();
            Transaction tx = sCon.beginTransaction();
            Query q = sCon.getNamedQuery("buscarOcurrencias")            
                .setParameter("fechainicio",ocurrencia.getFechainicio())
                .setParameter("fechafin",ocurrencia.getFechafin())
                .setParameter("idtipo",ocurrencia.getIdtipo())
                .setParameter("idcategoria",ocurrencia.getIdcategoria())
                .setParameter("idsubcategoria",ocurrencia.getIdsubcategoria())
                .setParameter("ocuestado",ocurrencia.getOcuestado());                  
            lstOcurrencias = q.list();        
            tx.commit();
            sCon.close();
        } catch (Exception e) {
            throw e;
        }
        return lstOcurrencias;
    }
    
    public List<ResumenTipo> ResumenTipo(ResumenTipo resumen)
    {
        List<ResumenTipo> lstResumenTipo = null;
        try{
            SessionFactory hUtil = HibernateUtil.getSessionFactory();
            Session sCon = hUtil.openSession();
            Transaction tx = sCon.beginTransaction();
            Query q = sCon.getNamedQuery("resumenTipo")            
                .setParameter("fechainicio",resumen.getFechainicio())
                .setParameter("fechafin",resumen.getFechafin())
                .setParameter("idtipo",resumen.getIdtipo());                  
            lstResumenTipo = q.list();        
            tx.commit();
            sCon.close();
        } catch (Exception e) {
            throw e;
        }
        return lstResumenTipo;
    }
    
    public Respuesta altaOcurrencia(Tsocurrencia ocurrencia)
    {
        Respuesta oRespuesta = new Respuesta();
        
        try{
            SessionFactory hUtil = HibernateUtil.getSessionFactory();
            Session sCon = hUtil.openSession();
            Transaction tx = sCon.beginTransaction();
            sCon.save(ocurrencia);       
            tx.commit();
            sCon.close();
            oRespuesta.setCodRespuesta("1");
        } catch (Exception e) {
            oRespuesta.setCodRespuesta("2");
        }  
            
        return oRespuesta;    
    }
    
    public Respuesta actualizarOcurrencia(Tsocurrencia ocurrencia)
    {
        Respuesta oRespuesta = new Respuesta();
        
        try{
            SessionFactory hUtil = HibernateUtil.getSessionFactory();
            Session sCon = hUtil.openSession();
            Transaction tx = sCon.beginTransaction();
            sCon.update(ocurrencia);       
            tx.commit();
            sCon.close();
            oRespuesta.setCodRespuesta("1");
        } catch (Exception e) {
            oRespuesta.setCodRespuesta("2");
        }  
            
        return oRespuesta;    
    }
    
    public Tsocurrencia getOcurrenciaID(String id){

        Tsocurrencia ocurrencia = null;

        try {
            SessionFactory hUtil = HibernateUtil.getSessionFactory();
            Session sCon = hUtil.openSession();
            Transaction tx = sCon.beginTransaction();
            Query q = sCon.createQuery("from Tsocurrencia where idocurrencia=" + id);
            ocurrencia = (Tsocurrencia) q.uniqueResult();
            tx.commit();        
            sCon.close();
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return ocurrencia;
    }
}
