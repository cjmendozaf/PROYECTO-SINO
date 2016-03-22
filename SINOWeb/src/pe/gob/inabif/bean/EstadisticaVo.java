package pe.gob.inabif.bean;

import java.io.Serializable;

public class EstadisticaVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private String centroAtencion;
	private String fechaOcurrencia;
	private String HoraOcurrencia;
	private String fechaRegistro;
	private String horaRegistro;
	private int idTipo;
	private String tipo;
	private String categoria;
	private String subCategoria;
	private int estado;
	private String estadoDescripcion;
	private boolean usuarioRegistro;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCentroAtencion() {
		return centroAtencion;
	}

	public void setCentroAtencion(String centroAtencion) {
		this.centroAtencion = centroAtencion;
	}

	public String getFechaOcurrencia() {
		return fechaOcurrencia;
	}

	public void setFechaOcurrencia(String fechaOcurrencia) {
		this.fechaOcurrencia = fechaOcurrencia;
	}

	public String getHoraOcurrencia() {
		return HoraOcurrencia;
	}

	public void setHoraOcurrencia(String horaOcurrencia) {
		HoraOcurrencia = horaOcurrencia;
	}

	public String getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getHoraRegistro() {
		return horaRegistro;
	}

	public void setHoraRegistro(String horaRegistro) {
		this.horaRegistro = horaRegistro;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getSubCategoria() {
		return subCategoria;
	}

	public void setSubCategoria(String subCategoria) {
		this.subCategoria = subCategoria;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public int getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

	public boolean isUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(boolean usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	public String getEstadoDescripcion() {
		return estadoDescripcion;
	}

	public void setEstadoDescripcion(String estadoDescripcion) {
		this.estadoDescripcion = estadoDescripcion;
	}

}
