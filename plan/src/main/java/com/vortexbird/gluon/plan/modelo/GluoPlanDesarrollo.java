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
@Table(name = "gluoPlanDesarrollo", schema = "public")
public class GluoPlanDesarrollo implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer planId;
    @NotNull
    @NotEmpty
    @Size(max = 1)
    private String activo;
    @NotNull
    private Date anoFin;
    @NotNull
    private Date anoInicio;
    private String descripcion;
    private String eslogan;
    @NotNull
    private Date fechaCreacion;
    private Date fechaModificacion;
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String nombreAlcalde;
    @NotNull
    private Integer usuCreador;
    private Integer usuModificador;
    private Set<GluoSectorEjeDimension> gluoSectorEjeDimensions = new HashSet<GluoSectorEjeDimension>(0);

    public GluoPlanDesarrollo() {
    }

    public GluoPlanDesarrollo(Integer planId, String activo, Date anoFin,
        Date anoInicio, String descripcion, String eslogan, Date fechaCreacion,
        Date fechaModificacion,
        Set<GluoSectorEjeDimension> gluoSectorEjeDimensions,
        String nombreAlcalde, Integer usuCreador, Integer usuModificador) {
        this.planId = planId;
        this.activo = activo;
        this.anoFin = anoFin;
        this.anoInicio = anoInicio;
        this.descripcion = descripcion;
        this.eslogan = eslogan;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.nombreAlcalde = nombreAlcalde;
        this.usuCreador = usuCreador;
        this.usuModificador = usuModificador;
        this.gluoSectorEjeDimensions = gluoSectorEjeDimensions;
    }

    public Integer getPlanId() {
        return this.planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    public String getActivo() {
        return this.activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public Date getAnoFin() {
        return this.anoFin;
    }

    public void setAnoFin(Date anoFin) {
        this.anoFin = anoFin;
    }

    public Date getAnoInicio() {
        return this.anoInicio;
    }

    public void setAnoInicio(Date anoInicio) {
        this.anoInicio = anoInicio;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEslogan() {
        return this.eslogan;
    }

    public void setEslogan(String eslogan) {
        this.eslogan = eslogan;
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

    public String getNombreAlcalde() {
        return this.nombreAlcalde;
    }

    public void setNombreAlcalde(String nombreAlcalde) {
        this.nombreAlcalde = nombreAlcalde;
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

    public Set<GluoSectorEjeDimension> getGluoSectorEjeDimensions() {
        return this.gluoSectorEjeDimensions;
    }

    public void setGluoSectorEjeDimensions(
        Set<GluoSectorEjeDimension> gluoSectorEjeDimensions) {
        this.gluoSectorEjeDimensions = gluoSectorEjeDimensions;
    }
}
