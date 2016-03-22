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

import Controlador.SubcategoriaControl;
import Modelo.Tssubcategori;

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

@Path("/Subcategoria")
public class SubcategoriaServicio {
    @Context
    UriInfo uriInfo;
    
    @Context
    Request request;
    
    SubcategoriaControl subcategoriaControl;
    
    public SubcategoriaServicio() {
        subcategoriaControl = new SubcategoriaControl();
    }
    
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public List<Tssubcategori> getSubcategoris() {
        return subcategoriaControl.ListarSubcategoris();
    }
    
    @GET
    @Path("{categoria}")
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public List<Tssubcategori> ListarCategorias(@PathParam("categoria") String idCategoria) {
        List<Tssubcategori> subcategorias = subcategoriaControl.ListarSubcategoriasCategoria(idCategoria);
        return subcategorias;
    }
}
