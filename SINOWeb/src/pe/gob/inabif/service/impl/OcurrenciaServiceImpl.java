package pe.gob.inabif.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.client.ClientConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.inabif.bean.Estadistica;
import pe.gob.inabif.bean.EstadisticaVo;
import pe.gob.inabif.bean.Grafico;
import pe.gob.inabif.bean.Ocurrencia;
import pe.gob.inabif.bean.Usuario;
import pe.gob.inabif.model.OcurrenciaBusqueda;
import pe.gob.inabif.model.Tsaccioargume;
import pe.gob.inabif.model.Tsnocorrespon;
import pe.gob.inabif.model.Tsocurraccion;
import pe.gob.inabif.model.Tsocurrencia;
import pe.gob.inabif.model.TsocurrenciaResponse;
import pe.gob.inabif.service.EnviarMensajeService;
import pe.gob.inabif.service.OcurrenciaService;
import pe.gob.inabif.type.EstadoType;
import pe.gob.inabif.type.TipoType;
import pe.gob.inabif.util.Constantes;
import pe.gob.inabif.util.FechaUtil;
import pe.gob.inabif.util.GsonUtil;
import pe.gob.inabif.util.RESTUtil;
import pe.gob.inabif.util.RESTUtil.MetodoEnvio;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

@Service
public class OcurrenciaServiceImpl implements OcurrenciaService {
	
	@Autowired
	private EnviarMensajeService enviarMensajeService;
	
	@Override
	public String obtenerCategoria(String tipo) throws Exception {
		Properties prop = new Properties();
		InputStream input = getClass().getClassLoader().getResourceAsStream(Constantes.URL_RESOURCE_WS);			
		prop.load(input);
		String endPoint = prop.getProperty("endPoint.sinoWS");
		
		ClientConfig config = new ClientConfig();
	    Client client = ClientBuilder.newClient(config);
	    WebTarget target = client.target(endPoint);
	    String response = target.path("WSSINO").path("Categoria/"+tipo).request().accept(MediaType.APPLICATION_JSON).get(String.class);
	    return response;
	}
	
	@Override
	public String obtenerSubCategoria(String idCategoria) throws Exception {
		Properties prop = new Properties();
		InputStream input = getClass().getClassLoader().getResourceAsStream(Constantes.URL_RESOURCE_WS);			
		prop.load(input);
		String endPoint = prop.getProperty("endPoint.sinoWS");
		
		ClientConfig config = new ClientConfig();
	    Client client = ClientBuilder.newClient(config);
	    WebTarget target = client.target(endPoint);
	    
	    String response = target.path("WSSINO").path("Subcategoria/"+idCategoria).request().accept(MediaType.APPLICATION_JSON).get(String.class);
	    return response;
	}
	
	@Override
	public String guardarOcurrencia(Ocurrencia ocurrencia, Usuario usuario) throws Exception {
		try {
			Tsocurrencia envOcurrencia = new Tsocurrencia();
			envOcurrencia.setIdestado(1);//ACTIVO
			envOcurrencia.setIdsubcategoria(Integer.parseInt(ocurrencia.getSubCategoria()));
			envOcurrencia.setOcuresidente(ocurrencia.getResidenteExpediente());
			envOcurrencia.setOcudetalle(ocurrencia.getDetalle());
			envOcurrencia.setOcuestado(EstadoType.REGISTRAR.getKey());
			envOcurrencia.setUsuregistra(usuario.getIdUsuario());
			envOcurrencia.setOcufechaocurrencia(FechaUtil.obtenerFechaEnvio(ocurrencia.getFecha(),ocurrencia.getHora()));
			
			Gson gson = null;
			String json = "[]";
			gson = new Gson();
			json = gson.toJson(envOcurrencia);
			
			Properties prop = new Properties();
			InputStream input = getClass().getClassLoader().getResourceAsStream(Constantes.URL_RESOURCE_WS);			
			prop.load(input);
			String endPoint = prop.getProperty("endPoint.sinoWS");
			endPoint += "/WSSINO/Ocurrencia/alta";
			String respuesta = RESTUtil.conectaRest(endPoint, MetodoEnvio.POST, json);
			
			try {
				String colaborado = "Usuario 2";
				String codigo = "10";
				String categoria = "";
				String subCategoria = "";
				String detalle = ocurrencia.getDetalle();
				String fecha = ocurrencia.getFecha();
				String hora = ocurrencia.getHora();
				String centro = "";
				
				String from = "mailprueba101@gmail.com";
				String subject = "Mensaje";
				String msg = "";
								
				msg += "Estimado(a) colaborador(a): " + colaborado;
				msg += "\nSe informa que se ha registrado una ocurrencia de tipo "+ TipoType.get(Integer.parseInt(ocurrencia.getTipo())).getValue() +" para su validación con el siguiente detalle:";
				msg += "\nCódigo: " + "35";
				msg += "\nCategoría: " + categoria;
				msg += "\nSub-Categoría: " + subCategoria;
				msg += "\nDetalle: " + detalle;
				msg += "\nFecha de ocurrencia: " + fecha;
				msg += "\nHora de ocurrencia: " + hora;
				msg += "\nCentro que registra: " + centro;
				msg += "\nSaludos.";

				enviarMensajeService.sendMail(from, null, subject, msg, null);
				System.out.println("mensaje enviado");
			} catch (Exception e) {
				e.printStackTrace();
			}                        
                        
			return respuesta;
		} catch (IOException e) {
			throw new Exception(e);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	@Override
	public String buscarEstadistica(Estadistica estadistica, Usuario usuario) throws Exception {
		OcurrenciaBusqueda bean = new OcurrenciaBusqueda();
		bean.setIdtipo(Integer.parseInt(estadistica.getTipo()));
		bean.setIdcategoria(Integer.parseInt(estadistica.getCategoria()));
		bean.setIdsubcategoria(Integer.parseInt(estadistica.getSubCategoria()));
		bean.setFechainicio(estadistica.getFechaDesde()+"T00:00:00");
		bean.setFechafin(estadistica.getFechaHasta()+"T23:59:59");
		bean.setOcuestado(0);
		
		List<EstadisticaVo> lista = null;
		String json = "[]";
		json = GsonUtil.toJson(bean);
		
		Properties prop = new Properties();
		InputStream input = getClass().getClassLoader().getResourceAsStream(Constantes.URL_RESOURCE_WS);			
		prop.load(input);
		String endPoint = prop.getProperty(Constantes.END_POINT_SINOWS_WS);
		endPoint = endPoint.concat("/WSSINO/Ocurrencia/buscar");
		
		String response = RESTUtil.conectaRest(endPoint, MetodoEnvio.POST, json);
		
		
		
		
	/*	ClientConfig config = new ClientConfig();
	    Client client = ClientBuilder.newClient(config);
	    WebTarget target = client.target(endPoint);
	    String response = target.path("WSSINO").path("Ocurrencia/buscar").request().accept(MediaType.APPLICATION_JSON).get(String.class);
	*/    
		Gson gson = new Gson();	
	    JsonParser parser = new JsonParser();
	    JsonArray jArray = parser.parse(response).getAsJsonArray();
	    
	    lista = new ArrayList<EstadisticaVo>();
	    
	    for(JsonElement obj : jArray ) {
	    	OcurrenciaBusqueda entity = gson.fromJson( obj , OcurrenciaBusqueda.class);
	        EstadisticaVo est = new EstadisticaVo();
	        est.setId(entity.getIdocurrencia());
	        est.setCentroAtencion("---" + entity.getOcudetalle());
	        est.setFechaOcurrencia(FechaUtil.getFecha(entity.getOcufechaocurrencia()));
	        est.setHoraOcurrencia(FechaUtil.getHora(entity.getOcufechaocurrencia()));
	        est.setFechaRegistro(entity.getFecharegistro());
	        est.setHoraRegistro(entity.getHoraregistro());
	        	        
	        est.setIdTipo(entity.getIdtipo());
	        est.setTipo(TipoType.get(entity.getIdtipo()).getValue());
	        	        
	        est.setCategoria(entity.getCtgdescripcion());
	        est.setSubCategoria(entity.getSctdescripcion());
	        est.setEstado(entity.getOcuestado());
	        //est.setEstadoDescripcion(entity.getTsdetalle());
	        est.setEstadoDescripcion(EstadoType.get(entity.getOcuestado()).getValue());
	        
	       if(usuario.getIdUsuario() == entity.getUsuregistra())
	        	est.setUsuarioRegistro(true);
	        
	        lista.add(est);			
	    }		
	    gson = new Gson();
		json = gson.toJson(lista);		
		return json;
	}

	@Override
	public String verDetalle(int codigo) throws Exception {
		Properties prop = new Properties();
		InputStream input = getClass().getClassLoader().getResourceAsStream(Constantes.URL_RESOURCE_WS);			
		prop.load(input);
		String endPoint = prop.getProperty("endPoint.sinoWS");
		
		ClientConfig config = new ClientConfig();
	    Client client = ClientBuilder.newClient(config);
	    WebTarget target = client.target(endPoint);
	    String response = target.path("WSSINO").path("Ocurrencia/"+codigo).request().accept(MediaType.APPLICATION_JSON).get(String.class);
	    return response;
	}

	@Override
	public String validarEstadistica(int id, Usuario usuario) throws Exception {
		Tsocurrencia envOcurrencia = new Tsocurrencia();
		envOcurrencia.setIdocurrencia(new Long(id));
		envOcurrencia.setIdestado(1);//ACTIVO
		envOcurrencia.setOcuestado(EstadoType.VALIDAR.getKey());
		envOcurrencia.setUsuregistra(usuario.getIdUsuario());		
		
		String json = "[]";
		json = GsonUtil.toJson(envOcurrencia);
		
		Properties prop = new Properties();
		InputStream input = getClass().getClassLoader().getResourceAsStream(Constantes.URL_RESOURCE_WS);			
		prop.load(input);
		String endPoint = prop.getProperty(Constantes.END_POINT_SINOWS_WS);
		endPoint = endPoint.concat("/WSSINO/Ocurrencia/actualizar");	
                
                try {
                    String colaborado = "Usuario 1";
                    String codigo = "10";
                    String categoria = "";
                    String subCategoria = "";
                    String detalle = "35";
                    String fecha = "15/03/2016";
                    String hora = "13:30:00";
                    String centro = "";

                    String from = "cj.mendozaf@gmail.com";
                    String subject = "Mensaje";
                    String msg = "";

                    msg += "Estimado(a) colaborador(a): " + colaborado;
                    msg += "\nSe informa que su ocurrencia registrada ha sido validada.:";
                    msg += "\nCódigo: " + "35";
                    msg += "\nCategoría: " + categoria;
                    msg += "\nSub-Categoría: " + subCategoria;
                    msg += "\nDetalle: " + detalle;
                    msg += "\nFecha de ocurrencia: " + fecha;
                    msg += "\nHora de ocurrencia: " + hora;
                    msg += "\nCentro que registra: " + centro;
                    msg += "\nSe le recuerda que debe de registrar sus acciones correspondientes con respecto a la ocurrencia cada 24 horas según la directiva vigente" + centro;
                    msg += "\nSaludos.";

                    enviarMensajeService.sendMail(from, null, subject, msg, null);
                    System.out.println("mensaje enviado");
                } catch (Exception e) {
                        e.printStackTrace();
                }
                
                return RESTUtil.conectaRest(endPoint, MetodoEnvio.POST, json);
	}
	
	@Override
	public String enviarNoCorrespondeEstadistica(String id, String detalle, Usuario usuario)
			throws Exception {
		Tsnocorrespon obj = new Tsnocorrespon();
		//obj.setFecharegistra(new Date());
		obj.setIdocurrencia(Integer.parseInt(id));
		obj.setNocdetalle(detalle);
		obj.setUsuregistra(usuario.getIdUsuario());
		
		String json = "[]";
		json = GsonUtil.toJson(obj);
		
		Properties prop = new Properties();
		InputStream input = getClass().getClassLoader().getResourceAsStream(Constantes.URL_RESOURCE_WS);			
		prop.load(input);
		String endPoint = prop.getProperty(Constantes.END_POINT_SINOWS_WS);
		endPoint = endPoint.concat("/WSSINO/Nocorresponde/alta");
		RESTUtil.conectaRest(endPoint, MetodoEnvio.POST, json);
		
		//TODO optimizar
		Tsocurrencia envOcurrencia = new Tsocurrencia();
		envOcurrencia.setIdocurrencia(new Long(id));
		envOcurrencia.setIdestado(1);//ACTIVO
		envOcurrencia.setOcuestado(EstadoType.NO_CORRESPONDE.getKey());
		envOcurrencia.setUsuregistra(usuario.getIdUsuario());		
		
		json = GsonUtil.toJson(envOcurrencia);		
		endPoint = prop.getProperty(Constantes.END_POINT_SINOWS_WS);
		endPoint = endPoint.concat("/WSSINO/Ocurrencia/actualizar");
                
                try {
                    String colaborado = "Usuario 1";
                    String codigo = "10";
                    String categoria = "";
                    String subCategoria = "";                    
                    String fecha = "15/03/2016";
                    String hora = "13:30:00";
                    String centro = "";

                    String from = "cj.mendozaf@gmail.com";
                    String subject = "Mensaje";
                    String msg = "";

                    msg += "Estimado(a) colaborador(a): " + colaborado;
                    msg += "\nSe informa que su ocurrencia de intervención registrada ha sido evaluada y se determinó que no es ocurrencia:";
                    msg += "\nCódigo: " + "35";
                    msg += "\nCategoría: " + categoria;
                    msg += "\nSub-Categoría: " + subCategoria;
                    msg += "\nDetalle: " + detalle;
                    msg += "\nFecha de ocurrencia: " + fecha;
                    msg += "\nHora de ocurrencia: " + hora;
                    msg += "\nCentro que registra: " + centro;
                    msg += "\nDe acuerdo a la evaluación, se menciona lo siguiente";
                    msg += "\n" + detalle;
                    msg += "\nSaludos.";

                    enviarMensajeService.sendMail(from, null, subject, msg, null);
                    System.out.println("mensaje enviado");
                } catch (Exception e) {
                        e.printStackTrace();
                }
                
		return RESTUtil.conectaRest(endPoint, MetodoEnvio.POST, json);
	}
	
	@Override
	public String atendidoEstadistica(int id, Usuario usuario)
			throws Exception {
		Tsocurrencia envOcurrencia = new Tsocurrencia();
		envOcurrencia.setIdocurrencia(new Long(id));
		envOcurrencia.setIdestado(1);//ACTIVO
		envOcurrencia.setOcuestado(EstadoType.ATENDIDA.getKey());
		envOcurrencia.setUsuregistra(usuario.getIdUsuario());		
		
		String json = "[]";
		json = GsonUtil.toJson(envOcurrencia);
		
		Properties prop = new Properties();
		InputStream input = getClass().getClassLoader().getResourceAsStream(Constantes.URL_RESOURCE_WS);			
		prop.load(input);
		String endPoint = prop.getProperty(Constantes.END_POINT_SINOWS_WS);
		endPoint = endPoint.concat("/WSSINO/Ocurrencia/actualizar");
                
                try {
                    String colaborado = "Usuario 2";
                    String codigo = "10";
                    String categoria = "";
                    String subCategoria = "";                    
                    String fecha = "15/03/2016";
                    String hora = "13:30:00";
                    String centro = "";

                    String from = "mailprueba101@gmail.com";
                    String subject = "Mensaje";
                    String msg = "";

                    msg += "Estimado(a) colaborador(a): " + colaborado;
                    msg += "\nSe informa que la ocurrencia que usted validó ha sido atendida.";
                    msg += "\nCódigo: " + "35";
                    msg += "\nCategoría: " + categoria;
                    msg += "\nSub-Categoría: " + subCategoria;
                    msg += "\nDetalle: Prueba ocurrencia";
                    msg += "\nFecha de ocurrencia: " + fecha;
                    msg += "\nHora de ocurrencia: " + hora;
                    msg += "\nCentro que registra: " + centro;
                    msg += "\nSe le informa que debe dar la conformidad de la atención, caso contrario, se colocará en proceso hasta la atención final.";
                    msg += "\nSaludos.";

                    enviarMensajeService.sendMail(from, null, subject, msg, null);
                    System.out.println("mensaje enviado");
                } catch (Exception e) {
                        e.printStackTrace();
                }
                
		return RESTUtil.conectaRest(endPoint, MetodoEnvio.POST, json);
	}

	@Override
	public String enviarRegistrarAccionAtendidaEstadistica(String id,
			String detalle, Usuario usuario) throws Exception {
		Tsocurraccion obj = new Tsocurraccion();
		obj.setFecharegistra(new Date());
		obj.setIdocurrencia(Integer.parseInt(id));
		obj.setOacdetalle(detalle);
		obj.setUsuregistra(usuario.getIdUsuario());
		
		String json = "[]";
		json = GsonUtil.toJson(obj);
		
		Properties prop = new Properties();
		InputStream input = getClass().getClassLoader().getResourceAsStream(Constantes.URL_RESOURCE_WS);			
		prop.load(input);
		String endPoint = prop.getProperty(Constantes.END_POINT_SINOWS_WS);
		endPoint = endPoint.concat("/WSSINO/Accion/alta");
		RESTUtil.conectaRest(endPoint, MetodoEnvio.POST, json);
		
		//TODO optimizar
				Tsocurrencia envOcurrencia = new Tsocurrencia();
				envOcurrencia.setIdocurrencia(new Long(id));
				envOcurrencia.setIdestado(1);//ACTIVO
				envOcurrencia.setOcuestado(EstadoType.PROCESO_ACCION.getKey());
				envOcurrencia.setUsuregistra(usuario.getIdUsuario());		
				
				json = GsonUtil.toJson(envOcurrencia);		
				endPoint = prop.getProperty(Constantes.END_POINT_SINOWS_WS);
				endPoint = endPoint.concat("/WSSINO/Ocurrencia/actualizar");
                                
                try {
                    String colaborado = "Usuario 2";
                    String from = "mailprueba101@gmail.com";
                    
                    //String colaborado = "Usuario 2";
                    //String from = "mailprueba101@gmail.com";
                    
                    String codigo = "10";
                    String categoria = "";
                    String subCategoria = "";                    
                    String fecha = "15/03/2016";
                    String hora = "13:30:00";
                    String centro = "";
                                        
                    
                    String subject = "Mensaje";
                    String msg = "";

                    msg += "Estimado(a) colaborador(a): " + colaborado;
                    msg += "\nSe informa que se ha registrado una acción en su ocurrencia con el siguiente detalle: ";
                    msg += "\nCódigo: " + "35";
                    msg += "\nCategoría: " + categoria;
                    msg += "\nSub-Categoría: " + subCategoria;
                    msg += "\nDetalle: Prueba ocurrencia";
                    msg += "\nFecha de ocurrencia: " + fecha;
                    msg += "\nHora de ocurrencia: " + hora;
                    msg += "\nCentro que registra: " + centro;
                    msg += "\nAcción registrada: " + detalle;
                    msg += "\nSaludos.";

                    enviarMensajeService.sendMail(from, null, subject, msg, null);
                    System.out.println("mensaje enviado");
                } catch (Exception e) {
                        e.printStackTrace();
                }
				return RESTUtil.conectaRest(endPoint, MetodoEnvio.POST, json);

	}

	@Override
	public String cerrarOcurrenciaEstadistica(int codigo, Usuario usuario) throws Exception {
		Tsocurrencia envOcurrencia = new Tsocurrencia();
		envOcurrencia.setIdocurrencia(new Long(codigo));
		envOcurrencia.setIdestado(1);//ACTIVO
		envOcurrencia.setOcuestado(EstadoType.CERRADA.getKey());//CERRAR
		envOcurrencia.setUsuregistra(usuario.getIdUsuario());		
		
		String json = "[]";
		json = GsonUtil.toJson(envOcurrencia);
		
		Properties prop = new Properties();
		InputStream input = getClass().getClassLoader().getResourceAsStream(Constantes.URL_RESOURCE_WS);			
		prop.load(input);
		String endPoint = prop.getProperty(Constantes.END_POINT_SINOWS_WS);
		endPoint = endPoint.concat("/WSSINO/Ocurrencia/actualizar");
                
                try {
                    String colaborado = "Usuario 1";
                    
                    String categoria = "";
                    String subCategoria = "";                    
                    String fecha = "15/03/2016";
                    String hora = "13:30:00";
                    String centro = "";

                    String from = "cj.mendozaf@gmail.com";
                    String subject = "Mensaje";
                    String msg = "";

                    msg += "Estimado(a) colaborador(a): " + colaborado;
                    msg += "\nSe informa que se ha dado la conformidad a la ocurrencia que usted atendió:";
                    msg += "\nCódigo: " + "35";
                    msg += "\nCategoría: " + categoria;
                    msg += "\nSub-Categoría: " + subCategoria;
                    msg += "\nDetalle: Prueba ocurrencia";
                    msg += "\nFecha de ocurrencia: " + fecha;
                    msg += "\nHora de ocurrencia: " + hora;
                    msg += "\nCentro que registra: " + centro;
                    
                    msg += "\nSaludos.";

                    enviarMensajeService.sendMail(from, null, subject, msg, null);
                    System.out.println("mensaje enviado");
                } catch (Exception e) {
                        e.printStackTrace();
                }
                
		return RESTUtil.conectaRest(endPoint, MetodoEnvio.POST, json);
	}

	@Override
	public String enviarDenegarArgumentoSuspendidaEstadistica(String id, String detalle, Usuario usuario)
			throws Exception {
		Tsaccioargume obj = new Tsaccioargume();
		obj.setFecharegistra(new Date());
		obj.setIdocurraccion(Integer.parseInt(id));
		obj.setAardetalle(detalle);
		obj.setUsuregistra(usuario.getIdUsuario());
		
		String json = "[]";
		json = GsonUtil.toJson(obj);
		
		Properties prop = new Properties();
		InputStream input = getClass().getClassLoader().getResourceAsStream(Constantes.URL_RESOURCE_WS);			
		prop.load(input);
		String endPoint = prop.getProperty(Constantes.END_POINT_SINOWS_WS);
		endPoint = endPoint.concat("/WSSINO/Argumento/alta");
		 RESTUtil.conectaRest(endPoint, MetodoEnvio.POST, json);
		
		//TODO optimizar
		Tsocurrencia envOcurrencia = new Tsocurrencia();
		envOcurrencia.setIdocurrencia(new Long(id));
		envOcurrencia.setIdestado(1);//ACTIVO
		envOcurrencia.setOcuestado(EstadoType.PROCESO_ACCION.getKey());
		envOcurrencia.setUsuregistra(usuario.getIdUsuario());		
		
		json = GsonUtil.toJson(envOcurrencia);	
		endPoint = prop.getProperty(Constantes.END_POINT_SINOWS_WS);
		endPoint = endPoint.concat("/WSSINO/Ocurrencia/actualizar");
                
                try {
                    String colaborado = "Usuario 1";
                    
                    String categoria = "";
                    String subCategoria = "";                    
                    String fecha = "15/03/2016";
                    String hora = "13:30:00";
                    String centro = "";

                    String from = "cj.mendozaf@gmail.com";
                    String subject = "Mensaje";
                    String msg = "";

                    msg += "Estimado(a) colaborador(a): " + colaborado;
                    msg += "\nSe informa que no se ha dado la conformidad a la ocurrencia que usted atendió:";
                    msg += "\nCódigo: " + "35";
                    msg += "\nCategoría: " + categoria;
                    msg += "\nSub-Categoría: " + subCategoria;
                    msg += "\nDetalle: Prueba ocurrencia";
                    msg += "\nFecha de ocurrencia: " + fecha;
                    msg += "\nHora de ocurrencia: " + hora;
                    msg += "\nCentro que registra: " + centro;
                    msg += "\nDetalle de No Conformidad: " + detalle;
                    msg += "\nFavor de atender según lo indicado.";
                        
                    msg += "\nSaludos.";

                    enviarMensajeService.sendMail(from, null, subject, msg, null);
                    System.out.println("mensaje enviado");
                } catch (Exception e) {
                        e.printStackTrace();
                }
                
		return RESTUtil.conectaRest(endPoint, MetodoEnvio.POST, json);

	}

	@Override
	public String datosGrafico() throws Exception {
		/*OcurrenciaBusqueda bean = new OcurrenciaBusqueda();
		//bean.setIdtipo(Integer.parseInt(estadistica.getTipo()));
		bean.setIdtipo(2);
		bean.setFechainicio("2016-02-01T20:32:27");
		bean.setFechafin("2016-04-10T20:32:27");
		bean.setOcuestado(0);
		*/
		List<EstadisticaVo> lista = null;
		String json = "[]";
		//json = GsonUtil.toJson(bean);
		
		Properties prop = new Properties();
		InputStream input = getClass().getClassLoader().getResourceAsStream(Constantes.URL_RESOURCE_WS);			
		prop.load(input);
		String endPoint = prop.getProperty(Constantes.END_POINT_SINOWS_WS);
		endPoint = endPoint.concat("/WSSINO/Ocurrencia/grafico");
		
		//String response = RESTUtil.conectaRest(endPoint, MetodoEnvio.POST, json);
		Grafico grafico = new Grafico();
		grafico.setData("30,25,20,15,10");
		grafico.setLabels("['Nuevas','En proceso','Atendida','Cerradas','Suspendidas']");
		json = GsonUtil.toJson(grafico);
		
		return json;
	}
	
}