package pe.gob.inabif.bean;

import java.io.Serializable;

public class ClaveValor implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int clave;
	private String valor;
	
	public int getClave() {
		return clave;
	}
	public void setClave(int clave) {
		this.clave = clave;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
}
