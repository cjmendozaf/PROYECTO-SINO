package pe.gob.inabif.service;

import pe.gob.inabif.bean.Estadistica;
import pe.gob.inabif.bean.Ocurrencia;
import pe.gob.inabif.bean.Usuario;

public interface OcurrenciaService {

	public String obtenerCategoria(String tipo) throws Exception;
	public String obtenerSubCategoria(String idCategoria) throws Exception;
	public String guardarOcurrencia(Ocurrencia ocurrencia, Usuario usuario) throws Exception;	
	public String buscarEstadistica(Estadistica estadistica, Usuario usuario) throws Exception;
	public String verDetalle(int codigo) throws Exception;
	public String validarEstadistica(int codigo, Usuario usuario) throws Exception;
	public String enviarNoCorrespondeEstadistica(String id, String detalle, Usuario usuario) throws Exception;
	public String atendidoEstadistica(int codigo, Usuario usuario) throws Exception;
	public String enviarRegistrarAccionAtendidaEstadistica(String id, String detalle, Usuario usuario) throws Exception;
	public String cerrarOcurrenciaEstadistica(int codigo, Usuario usuario) throws Exception;	
	public String enviarDenegarArgumentoSuspendidaEstadistica(String id, String detalle, Usuario usuario) throws Exception;
	
	public String datosGrafico() throws Exception;
	
}