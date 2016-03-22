/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

/**
 *
 * @author Christopher
 */

import Controlador.AccionControl;
import Modelo.Respuesta;
import Modelo.Tsocurraccion;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

@Path("/Accion")
public class AccionServicio {    
    @Context
    UriInfo uriInfo;
    
    @Context
    Request request;
    
    AccionControl accionControl;
    
    public AccionServicio() {
        accionControl = new AccionControl();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tsocurraccion> getOcurraccions() {
        return accionControl.ListarOcurraccions();
    }
    
    @POST
    @Path("alta")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta save(Tsocurraccion ocurracion) {
        Respuesta oRespuesta;
        oRespuesta = accionControl.altaOcurracions(ocurracion);        
        return oRespuesta;
    }
    
    @GET
    @Path("{ocurrencia}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tsocurraccion> ListarCategorias(@PathParam("ocurrencia") String idOCurrencia) {
        List<Tsocurraccion> acciones = accionControl.ListarAccionOcurrencia(idOCurrencia);
        return acciones;
    }
}
