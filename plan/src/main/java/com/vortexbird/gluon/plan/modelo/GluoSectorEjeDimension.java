package com.vortexbird.gluon.plan.modelo;

import org.hibernate.validator.constraints.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.*;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
@Entity
@Table(name = "gluoSectorEjeDimension", schema = "public")
public class GluoSectorEjeDimension implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer sediId;
    @NotNull
    private GluoPlanDesarrollo gluoPlanDesarrollo;
    @NotNull
    @NotEmpty
    @Size(max = 1)
    private String activo;
    @NotNull
    @NotEmpty
    @Size(max = 255)
   
    private String descripcion;
    @NotNull
    private Date fechaCreacion;
    private Date fechaModificacion;
    @NotNull
    private Integer usuCreador;
    private Integer usuModificador;
    private Set<GluoObjetivo> gluoObjetivos = new HashSet<GluoObjetivo>(0);

    public GluoSectorEjeDimension() {
    }

    public GluoSectorEjeDimension(Integer sediId, String activo,
        String descripcion, Date fechaCreacion, Date fechaModificacion,
        Set<GluoObjetivo> gluoObjetivos, GluoPlanDesarrollo gluoPlanDesarrollo,
        Integer usuCreador, Integer usuModificador) {
        this.sediId = sediId;
        this.gluoPlanDesarrollo = gluoPlanDesarrollo;
        this.activo = activo;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.usuCreador = usuCreador;
        this.usuModificador = usuModificador;
        this.gluoObjetivos = gluoObjetivos;
    }

    public Integer getSediId() {
        return this.sediId;
    }

    public void setSediId(Integer sediId) {
        this.sediId = sediId;
    }

    public GluoPlanDesarrollo getGluoPlanDesarrollo() {
        return this.gluoPlanDesarrollo;
    }

    public void setGluoPlanDesarrollo(GluoPlanDesarrollo gluoPlanDesarrollo) {
        this.gluoPlanDesarrollo = gluoPlanDesarrollo;
    }
    

    public String getActivo() {
        return this.activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaCreacion() {
        return this.fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion() {
        return this.fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Integer getUsuCreador() {
        return this.usuCreador;
    }

    public void setUsuCreador(Integer usuCreador) {
        this.usuCreador = usuCreador;
    }

    public Integer getUsuModificador() {
        return this.usuModificador;
    }

    public void setUsuModificador(Integer usuModificador) {
        this.usuModificador = usuModificador;
    }

    public Set<GluoObjetivo> getGluoObjetivos() {
        return this.gluoObjetivos;
    }

    public void setGluoObjetivos(Set<GluoObjetivo> gluoObjetivos) {
        this.gluoObjetivos = gluoObjetivos;
    }
}
