/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Controlador.OcurrenciaControl;
import Modelo.Respuesta;
import Modelo.Tsocurrencia;
import Modelo.OcurrenciaBusqueda;
import Modelo.ResumenTipo;
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

/**
 *
 * @author Christopher
 */
@Path("/Ocurrencia")
public class OcurrenciaServicio {
    @Context
    UriInfo uriInfo;
	
    @Context
    Request request;

    OcurrenciaControl ocurrenciaControl;
    
    public OcurrenciaServicio() {
        ocurrenciaControl = new OcurrenciaControl();
    }
    
    @GET
    @Path("{ocurrencia}")
    @Produces(MediaType.APPLICATION_JSON)
    public Tsocurrencia getOcurrencia(@PathParam("ocurrencia") String id) {
        Tsocurrencia ocurrencia = ocurrenciaControl.getOcurrenciaID(id);
        return ocurrencia;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tsocurrencia> getOCurrencias() {
        return ocurrenciaControl.ListarOcurrencias();
    }
    
    @POST
    @Path("buscar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<OcurrenciaBusqueda> buscarOcurrencias(OcurrenciaBusqueda ocurrencia) {
        return ocurrenciaControl.BuscarOcurrencias(ocurrencia);
    }
    
    @POST
    @Path("resumentipo")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<ResumenTipo> buscarOcurrencias(ResumenTipo resumen) {
        return ocurrenciaControl.ResumenTipo(resumen);
    }
    
    @POST
    @Path("alta")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta save(Tsocurrencia ocurrencia) {
        Respuesta oRespuesta;
        oRespuesta = ocurrenciaControl.altaOcurrencia(ocurrencia);        
        return oRespuesta;
    }
    
    @POST
    @Path("actualizar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta update(Tsocurrencia ocurrencia) {
        Respuesta oRespuesta;
        Tsocurrencia ocurrencia_all = ocurrenciaControl.getOcurrenciaID(String.valueOf(ocurrencia.getIdocurrencia()));
        ocurrencia_all.setOcuestado(ocurrencia.getOcuestado());
        oRespuesta = ocurrenciaControl.actualizarOcurrencia(ocurrencia_all);        
        return oRespuesta;
    }
}
