/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Controlador.EstadoControl;
import Modelo.Respuesta;
import Modelo.Tsestado;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

@Path("/Estado")
public class EstadoServicio {
    
    @Context
    UriInfo uriInfo;
	
    @Context
    Request request;    

    EstadoControl estadoControl;
    
    public EstadoServicio() {
        estadoControl = new EstadoControl();
    }
    
    @GET
    @Path("{estado}")
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Tsestado getEstado(@PathParam("estado") String id) {
        Tsestado estado = estadoControl.getEstadoID(id);
        return estado;
    }
    
    @GET    
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public List<Tsestado> getEstados() {
        return estadoControl.ListarEstados();
    }
        
    @POST
    @Path("alta")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta save(Tsestado estado) {
        Respuesta oRespuesta;
        oRespuesta = estadoControl.altaEstado(estado);        
        return oRespuesta;
    }
}
