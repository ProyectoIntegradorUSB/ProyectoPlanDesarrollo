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
@Table(name = "gluoObjetivo", schema = "public")
public class GluoObjetivo implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer objeId;
    @NotNull
    private GluoSectorEjeDimension gluoSectorEjeDimension;
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
    private Set<GluoPrograma> gluoProgramas = new HashSet<GluoPrograma>(0);

    public GluoObjetivo() {
    }

    public GluoObjetivo(Integer objeId, String activo, String descripcion,
        Date fechaCreacion, Date fechaModificacion,
        Set<GluoPrograma> gluoProgramas,
        GluoSectorEjeDimension gluoSectorEjeDimension, Integer usuCreador,
        Integer usuModificador) {
        this.objeId = objeId;
        this.gluoSectorEjeDimension = gluoSectorEjeDimension;
        this.activo = activo;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.usuCreador = usuCreador;
        this.usuModificador = usuModificador;
        this.gluoProgramas = gluoProgramas;
    }

    public Integer getObjeId() {
        return this.objeId;
    }

    public void setObjeId(Integer objeId) {
        this.objeId = objeId;
    }

    public GluoSectorEjeDimension getGluoSectorEjeDimension() {
        return this.gluoSectorEjeDimension;
    }

    public void setGluoSectorEjeDimension(
        GluoSectorEjeDimension gluoSectorEjeDimension) {
        this.gluoSectorEjeDimension = gluoSectorEjeDimension;
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

    public Set<GluoPrograma> getGluoProgramas() {
        return this.gluoProgramas;
    }

    public void setGluoProgramas(Set<GluoPrograma> gluoProgramas) {
        this.gluoProgramas = gluoProgramas;
    }
}
