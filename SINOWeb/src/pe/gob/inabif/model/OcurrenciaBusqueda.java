/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.inabif.model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Christopher
 */
public class OcurrenciaBusqueda {

	private long idocurrencia;
	private String ocufechaocurrencia;
	private String fecharegistro;
	private String horaregistro;
	private String fechainicio;
	private String fechafin;
	private int idtipo;
	private String tipdescripcion;
	private int idcategoria;
	private String ctgdescripcion;
	private int idsubcategoria;
	private String sctdescripcion;
	private int ocuestado;
	private String ocudetalle;
	private String tsdetalle;
	private int usuregistra;

	public OcurrenciaBusqueda() {
	}

	public OcurrenciaBusqueda(long idocurrencia) {
		this.idocurrencia = idocurrencia;
	}

	public OcurrenciaBusqueda(long idocurrencia, String ocufechaocurrencia,
			String fecharegistro, String horaregistro, int idtipo,
			String tipdescripcion, int idcategoria, String ctgdescripcion,
			int idsubcategoria, String sctdescripcion, String ocudetalle) {
		this.idocurrencia = idocurrencia;
		this.ocufechaocurrencia = ocufechaocurrencia;
		this.fecharegistro = fecharegistro;
		this.horaregistro = horaregistro;
		this.idtipo = idtipo;
		this.tipdescripcion = tipdescripcion;
		this.idcategoria = idcategoria;
		this.ctgdescripcion = ctgdescripcion;
		this.idsubcategoria = idsubcategoria;
		this.sctdescripcion = sctdescripcion;
		this.ocudetalle = ocudetalle;
	}

	/**
	 * @return the idocurrencia
	 */
	public long getIdocurrencia() {
		return idocurrencia;
	}

	/**
	 * @param idocurrencia
	 *            the idocurrencia to set
	 */
	public void setIdocurrencia(long idocurrencia) {
		this.idocurrencia = idocurrencia;
	}

	/**
	 * @return the ocufechaocurrencia
	 */
	public String getOcufechaocurrencia() {
		return ocufechaocurrencia;
	}

	/**
	 * @param ocufechaocurrencia
	 *            the ocufechaocurrencia to set
	 */
	public void setOcufechaocurrencia(String ocufechaocurrencia) {
		this.ocufechaocurrencia = ocufechaocurrencia;
	}

	/**
	 * @return the fecharegistro
	 */
	public String getFecharegistro() {
		return fecharegistro;
	}

	/**
	 * @param fecharegistro
	 *            the fecharegistro to set
	 */
	public void setFecharegistro(String fecharegistro) {
		this.fecharegistro = fecharegistro;
	}

	/**
	 * @return the horaregistro
	 */
	public String getHoraregistro() {
		return horaregistro;
	}

	/**
	 * @param horaregistro
	 *            the horaregistro to set
	 */
	public void setHoraregistro(String horaregistro) {
		this.horaregistro = horaregistro;
	}

	/**
	 * @return the idtipo
	 */
	public int getIdtipo() {
		return idtipo;
	}

	/**
	 * @param idtipo
	 *            the idtipo to set
	 */
	public void setIdtipo(int idtipo) {
		this.idtipo = idtipo;
	}

	/**
	 * @return the tipdescripcion
	 */
	public String getTipdescripcion() {
		return tipdescripcion;
	}

	/**
	 * @param tipdescripcion
	 *            the tipdescripcion to set
	 */
	public void setTipdescripcion(String tipdescripcion) {
		this.tipdescripcion = tipdescripcion;
	}

	/**
	 * @return the idcategoria
	 */
	public int getIdcategoria() {
		return idcategoria;
	}

	/**
	 * @param idcategoria
	 *            the idcategoria to set
	 */
	public void setIdcategoria(int idcategoria) {
		this.idcategoria = idcategoria;
	}

	/**
	 * @return the ctgdescripcion
	 */
	public String getCtgdescripcion() {
		return ctgdescripcion;
	}

	/**
	 * @param ctgdescripcion
	 *            the ctgdescripcion to set
	 */
	public void setCtgdescripcion(String ctgdescripcion) {
		this.ctgdescripcion = ctgdescripcion;
	}

	/**
	 * @return the idsubcategoria
	 */
	public int getIdsubcategoria() {
		return idsubcategoria;
	}

	/**
	 * @param idsubcategoria
	 *            the idsubcategoria to set
	 */
	public void setIdsubcategoria(int idsubcategoria) {
		this.idsubcategoria = idsubcategoria;
	}

	/**
	 * @return the sctdescripcion
	 */
	public String getSctdescripcion() {
		return sctdescripcion;
	}

	/**
	 * @param sctdescripcion
	 *            the sctdescripcion to set
	 */
	public void setSctdescripcion(String sctdescripcion) {
		this.sctdescripcion = sctdescripcion;
	}

	/**
	 * @return the ocudetalle
	 */
	public String getOcudetalle() {
		return ocudetalle;
	}

	/**
	 * @param ocudetalle
	 *            the ocudetalle to set
	 */
	public void setOcudetalle(String ocudetalle) {
		this.ocudetalle = ocudetalle;
	}

	/**
	 * @return the fechainicio
	 */
	public String getFechainicio() {
		return fechainicio;
	}

	/**
	 * @param fechainicio
	 *            the fechainicio to set
	 */
	public void setFechainicio(String fechainicio) {
		this.fechainicio = fechainicio;
	}

	/**
	 * @return the fechafin
	 */
	public String getFechafin() {
		return fechafin;
	}

	/**
	 * @param fechafin
	 *            the fechafin to set
	 */
	public void setFechafin(String fechafin) {
		this.fechafin = fechafin;
	}

	public String getTsdetalle() {
		return tsdetalle;
	}

	public void setTsdetalle(String tsdetalle) {
		this.tsdetalle = tsdetalle;
	}

	public int getOcuestado() {
		return ocuestado;
	}

	public void setOcuestado(int ocuestado) {
		this.ocuestado = ocuestado;
	}

	public int getUsuregistra() {
		return usuregistra;
	}

	public void setUsuregistra(int usuregistra) {
		this.usuregistra = usuregistra;
	}
}
