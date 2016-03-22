package pe.gob.inabif.bean;

import java.io.Serializable;

public class Ocurrencia implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int codigo;
	private String tipo;
	private String residenteExpediente;
	private String categoria;
	private String subCategoria;
	private String fecha;
	private String hora;
	private String detalle;
	private String ultimaAccion;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getResidenteExpediente() {
		return residenteExpediente;
	}

	public void setResidenteExpediente(String residenteExpediente) {
		this.residenteExpediente = residenteExpediente;
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

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public String getUltimaAccion() {
		return ultimaAccion;
	}

	public void setUltimaAccion(String ultimaAccion) {
		this.ultimaAccion = ultimaAccion;
	}

}
