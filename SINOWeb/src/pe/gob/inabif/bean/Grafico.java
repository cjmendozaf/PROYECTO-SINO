package pe.gob.inabif.bean;

import java.io.Serializable;

public class Grafico implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String data;
	private String labels;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getLabels() {
		return labels;
	}

	public void setLabels(String labels) {
		this.labels = labels;
	}
}
