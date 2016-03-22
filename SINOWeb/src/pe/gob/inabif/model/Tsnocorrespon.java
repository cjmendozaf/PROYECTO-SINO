/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.inabif.model;

import java.util.Date;

/**
 *
 * @author Christopher
 */
public class Tsnocorrespon implements java.io.Serializable  {
    private long idnocorrespon;
     private int idocurrencia;
     private String nocdetalle;
     private Long usuregistra;
     private Date fecharegistra;
     private Long usuactualiza;
     private Date fechaactualiza;
     private Long usuelimina;
     private Date fechaelimina;
     
     public Tsnocorrespon(){
     }

    public Tsnocorrespon(long idnocorrespon, int idocurrencia, String nocdetalle, Long usuregistra, Date fecharegistra, Long usuactualiza, Date fechaactualiza, Long usuelimina, Date fechaelimina) {
        this.idnocorrespon = idnocorrespon;
        this.idocurrencia = idocurrencia;
        this.nocdetalle = nocdetalle;
        this.usuregistra = usuregistra;
        this.fecharegistra = fecharegistra;
        this.usuactualiza = usuactualiza;
        this.fechaactualiza = fechaactualiza;
        this.usuelimina = usuelimina;
        this.fechaelimina = fechaelimina;
    }

    /**
     * @return the idnocorresponde
     */
    public long getIdnocorrespon() {
        return idnocorrespon;
    }

    
    public void setIdnocorrespon(long idnocorrespon) {
        this.idnocorrespon = idnocorrespon;
    }

    /**
     * @return the idocurrencia
     */
    public int getIdocurrencia() {
        return idocurrencia;
    }

    /**
     * @param idocurrencia the idocurrencia to set
     */
    public void setIdocurrencia(int idocurrencia) {
        this.idocurrencia = idocurrencia;
    }

    /**
     * @return the nocdetalle
     */
    public String getNocdetalle() {
        return nocdetalle;
    }

    /**
     * @param nocdetalle the nocdetalle to set
     */
    public void setNocdetalle(String nocdetalle) {
        this.nocdetalle = nocdetalle;
    }

    /**
     * @return the usuregistra
     */
    public Long getUsuregistra() {
        return usuregistra;
    }

    /**
     * @param usuregistra the usuregistra to set
     */
    public void setUsuregistra(Long usuregistra) {
        this.usuregistra = usuregistra;
    }

    /**
     * @return the fecharegistra
     */
    public Date getFecharegistra() {
        return fecharegistra;
    }

    /**
     * @param fecharegistra the fecharegistra to set
     */
    public void setFecharegistra(Date fecharegistra) {
        this.fecharegistra = fecharegistra;
    }

    /**
     * @return the usuactualiza
     */
    public Long getUsuactualiza() {
        return usuactualiza;
    }

    /**
     * @param usuactualiza the usuactualiza to set
     */
    public void setUsuactualiza(Long usuactualiza) {
        this.usuactualiza = usuactualiza;
    }

    /**
     * @return the fechaactualiza
     */
    public Date getFechaactualiza() {
        return fechaactualiza;
    }

    /**
     * @param fechaactualiza the fechaactualiza to set
     */
    public void setFechaactualiza(Date fechaactualiza) {
        this.fechaactualiza = fechaactualiza;
    }

    /**
     * @return the usuelimina
     */
    public Long getUsuelimina() {
        return usuelimina;
    }

    /**
     * @param usuelimina the usuelimina to set
     */
    public void setUsuelimina(Long usuelimina) {
        this.usuelimina = usuelimina;
    }

    /**
     * @return the fechaelimina
     */
    public Date getFechaelimina() {
        return fechaelimina;
    }

    /**
     * @param fechaelimina the fechaelimina to set
     */
    public void setFechaelimina(Date fechaelimina) {
        this.fechaelimina = fechaelimina;
    }
     
}
