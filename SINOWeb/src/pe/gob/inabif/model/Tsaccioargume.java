package pe.gob.inabif.model;
// Generated 02/03/2016 11:58:20 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Tsaccioargume generated by hbm2java
 */
public class Tsaccioargume  implements java.io.Serializable {


     private long idaccionargumento;
     private int idocurraccion;
     private String aardetalle;
     private Long usuregistra;
     private Date fecharegistra;
     private Long usuactualiza;
     private Date fechaactualiza;
     private Long usuelimina;
     private Date fechaelimina;

    public Tsaccioargume() {
    }

	
    public Tsaccioargume(long idaccionargumento) {
        this.idaccionargumento = idaccionargumento;
    }
    public Tsaccioargume(long idaccionargumento, int idocurraccion, String aardetalle, Long usuregistra, Date fecharegistra, Long usuactualiza, Date fechaactualiza, Long usuelimina, Date fechaelimina) {
       this.idaccionargumento = idaccionargumento;
       this.idocurraccion = idocurraccion;
       this.aardetalle = aardetalle;
       this.usuregistra = usuregistra;
       this.fecharegistra = fecharegistra;
       this.usuactualiza = usuactualiza;
       this.fechaactualiza = fechaactualiza;
       this.usuelimina = usuelimina;
       this.fechaelimina = fechaelimina;
    }
   
    public long getIdaccionargumento() {
        return this.idaccionargumento;
    }
    
    public void setIdaccionargumento(long idaccionargumento) {
        this.idaccionargumento = idaccionargumento;
    }
    public int getIdocurraccion() {
        return this.idocurraccion;
    }
    
    public void setIdocurraccion(int idocurraccion) {
        this.idocurraccion = idocurraccion;
    }
    public String getAardetalle() {
        return this.aardetalle;
    }
    
    public void setAardetalle(String aardetalle) {
        this.aardetalle = aardetalle;
    }
    public Long getUsuregistra() {
        return this.usuregistra;
    }
    
    public void setUsuregistra(Long usuregistra) {
        this.usuregistra = usuregistra;
    }
    public Date getFecharegistra() {
        return this.fecharegistra;
    }
    
    public void setFecharegistra(Date fecharegistra) {
        this.fecharegistra = fecharegistra;
    }
    public Long getUsuactualiza() {
        return this.usuactualiza;
    }
    
    public void setUsuactualiza(Long usuactualiza) {
        this.usuactualiza = usuactualiza;
    }
    public Date getFechaactualiza() {
        return this.fechaactualiza;
    }
    
    public void setFechaactualiza(Date fechaactualiza) {
        this.fechaactualiza = fechaactualiza;
    }
    public Long getUsuelimina() {
        return this.usuelimina;
    }
    
    public void setUsuelimina(Long usuelimina) {
        this.usuelimina = usuelimina;
    }
    public Date getFechaelimina() {
        return this.fechaelimina;
    }
    
    public void setFechaelimina(Date fechaelimina) {
        this.fechaelimina = fechaelimina;
    }

}


