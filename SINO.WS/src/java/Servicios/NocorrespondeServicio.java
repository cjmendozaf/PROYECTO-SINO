/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Controlador.NocorrespondeControl;
import Modelo.Respuesta;
import Modelo.Tsnocorrespon;

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

@Path("/Nocorresponde")
public class NocorrespondeServicio {
    @Context
    UriInfo uriInfo;
	
    @Context
    Request request;

    NocorrespondeControl nocorrespondeControl;
    
    public NocorrespondeServicio() {
        nocorrespondeControl = new NocorrespondeControl();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tsnocorrespon> getNocorrespondes() {
        return nocorrespondeControl.ListarNocorrespondes();
    }
    
    @POST
    @Path("alta")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta save(Tsnocorrespon nocorresponde) {
        Respuesta oRespuesta;
        oRespuesta = nocorrespondeControl.altaNocorresponde(nocorresponde);        
        return oRespuesta;
    }
    
    @GET
    @Path("{ocurrencia}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tsnocorrespon> ListarNocorrespondes(@PathParam("ocurrencia") String idOCurrencia) {
        List<Tsnocorrespon> nocorrespondes = nocorrespondeControl.ListarNocorrespondeOcurrencia(idOCurrencia);
        return nocorrespondes;
    }
}
