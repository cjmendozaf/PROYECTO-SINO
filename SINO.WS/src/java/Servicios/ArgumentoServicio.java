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
import Controlador.ArgumentoControl;
import Modelo.Respuesta;
import Modelo.Tsaccioargume;

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

@Path("/Argumento")
public class ArgumentoServicio {
    @Context
    UriInfo uriInfo;
    
    @Context
    Request request;
    
    ArgumentoControl argumentoControl;
    
    public ArgumentoServicio() {
        argumentoControl = new ArgumentoControl();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tsaccioargume> getArgumentos() {
        return argumentoControl.ListarArgumentos();
    }
    
    @POST
    @Path("alta")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta save(Tsaccioargume argumento) {
        Respuesta oRespuesta;
        oRespuesta = argumentoControl.altaArgumentos(argumento);        
        return oRespuesta;
    }
    
    @GET
    @Path("{accion}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tsaccioargume> ListarCategorias(@PathParam("accion") String idAccion) {
        List<Tsaccioargume> acciones = argumentoControl.ListarAccionOcurrencia(idAccion);
        return acciones;
    }
}
