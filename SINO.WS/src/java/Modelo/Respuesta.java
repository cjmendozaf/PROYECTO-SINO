/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Christopher
 */
@XmlRootElement
public class Respuesta implements java.io.Serializable {

    private String codRespuesta;
    private String detRespuesta;
    
    public Respuesta() {
    }

    /**
     * @return the codRespuesta
     */
    public String getCodRespuesta() {
        return codRespuesta;
    }

    /**
     * @param codRespuesta the codRespuesta to set
     */
    public void setCodRespuesta(String codRespuesta) {
        this.codRespuesta = codRespuesta;
    }

    /**
     * @return the detRespuesta
     */
    public String getDetRespuesta() {
        return detRespuesta;
    }

    /**
     * @param detRespuesta the detRespuesta to set
     */
    public void setDetRespuesta(String detRespuesta) {
        this.detRespuesta = detRespuesta;
    }
}
