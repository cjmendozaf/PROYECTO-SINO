/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Respuesta;
import Modelo.Tsestado;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Christopher
 */
public class EstadoControl {
    
    public List<Tsestado> ListarEstados()
    {
        SessionFactory hUtil = HibernateUtil.getSessionFactory();
        Session sCon = hUtil.openSession();
        Transaction tx = sCon.beginTransaction();
        Query q = sCon.createQuery("from Tsestado");
        List<Tsestado> lstEstados = q.list();        
        tx.commit();
        sCon.close();
       
        return lstEstados;
    }
    
    public Respuesta altaEstado(Tsestado estado)
    {
        Respuesta oRespuesta = new Respuesta();
        try{
            SessionFactory hUtil = HibernateUtil.getSessionFactory();
            Session sCon = hUtil.openSession();
            Transaction tx = sCon.beginTransaction();
            sCon.save(estado);
            tx.commit();
            sCon.close();
            oRespuesta.setCodRespuesta("1");
        } catch (Exception e) {
            oRespuesta.setCodRespuesta("2");
            e.printStackTrace();            
        }  
            
        return oRespuesta;    
    }
    
    public Tsestado getEstadoID(String id){

        Tsestado estado = null;

        try {
            SessionFactory hUtil = HibernateUtil.getSessionFactory();
            Session sCon = hUtil.openSession();
            Transaction tx = sCon.beginTransaction();
            Query q = sCon.createQuery("from Tsestado where idestado=" + id);
            estado = (Tsestado) q.uniqueResult();
            tx.commit();        
            sCon.close();
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return estado;
    }
}
