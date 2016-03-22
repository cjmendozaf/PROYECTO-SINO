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
import Controlador.CategoriaControl;
import Modelo.Tscategoria;

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

@Path("/Categoria")
public class CategoriaServicio {    
    @Context
    UriInfo uriInfo;
    
    @Context
    Request request;
    
    CategoriaControl categoriaControl;
    
    public CategoriaServicio() {
        categoriaControl = new CategoriaControl();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tscategoria> getCategorias() {
        return categoriaControl.ListarCategorias();
    }
    
    @GET
    @Path("{tipo}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tscategoria> ListarCategorias(@PathParam("tipo") String idTipo) {
        List<Tscategoria> categorias = categoriaControl.ListarCategoriasTipo(idTipo);
        return categorias;
    }
    
}
