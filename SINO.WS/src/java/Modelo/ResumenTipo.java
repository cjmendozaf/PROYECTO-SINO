/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author Christopher
 */
public class ResumenTipo {
    private int idestado;
    private String tsdetalle;
    private int cantidad;
    private Date fechainicio;
    private Date fechafin;
    private int idtipo;

    public ResumenTipo() {
    }
    
    public ResumenTipo(int idestado) {
        this.idestado = idestado;
    }

    public ResumenTipo(int idestado, String tsdetalle, int cantidad) {
        this.idestado = idestado;
        this.tsdetalle = tsdetalle;
        this.cantidad = cantidad;
    }

    /**
     * @return the idestado
     */
    public int getIdestado() {
        return idestado;
    }

    /**
     * @param idestado the idestado to set
     */
    public void setIdestado(int idestado) {
        this.idestado = idestado;
    }

    /**
     * @return the tsdetalle
     */
    public String getTsdetalle() {
        return tsdetalle;
    }

    /**
     * @param tsdetalle the tsdetalle to set
     */
    public void setTsdetalle(String tsdetalle) {
        this.tsdetalle = tsdetalle;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the fechainicio
     */
    public Date getFechainicio() {
        return fechainicio;
    }

    /**
     * @param fechainicio the fechainicio to set
     */
    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    /**
     * @return the fechafin
     */
    public Date getFechafin() {
        return fechafin;
    }

    /**
     * @param fechafin the fechafin to set
     */
    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    /**
     * @return the idtipo
     */
    public int getIdtipo() {
        return idtipo;
    }

    /**
     * @param idtipo the idtipo to set
     */
    public void setIdtipo(int idtipo) {
        this.idtipo = idtipo;
    }
    
    
    
}
