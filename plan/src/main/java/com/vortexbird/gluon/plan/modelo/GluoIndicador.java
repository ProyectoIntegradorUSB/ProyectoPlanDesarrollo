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
@Table(name = "gluoIndicador", schema = "public")
public class GluoIndicador implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer indiId;
    @NotNull
    private GluoProyecto gluoProyecto;
    @NotNull
    @NotEmpty
    @Size(max = 1)
    private String activo;
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String descripcionIndicador;
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String descripcionLineaBase;
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String descripcionMeta;
    @NotNull
    private Date fechaCreacion;
    private Date fechaModificacion;
    @NotNull
    private Integer usuCreador;
    private Integer usuModificador;
    @NotNull
    private Double valorMeta;
    private Set<GluoHistorialIndicador> gluoHistorialIndicadors = new HashSet<GluoHistorialIndicador>(0);

    public GluoIndicador() {
    }

    public GluoIndicador(Integer indiId, String activo,
        String descripcionIndicador, String descripcionLineaBase,
        String descripcionMeta, Date fechaCreacion, Date fechaModificacion,
        Set<GluoHistorialIndicador> gluoHistorialIndicadors,
        GluoProyecto gluoProyecto, Integer usuCreador, Integer usuModificador,
        Double valorMeta) {
        this.indiId = indiId;
        this.gluoProyecto = gluoProyecto;
        this.activo = activo;
        this.descripcionIndicador = descripcionIndicador;
        this.descripcionLineaBase = descripcionLineaBase;
        this.descripcionMeta = descripcionMeta;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.usuCreador = usuCreador;
        this.usuModificador = usuModificador;
        this.valorMeta = valorMeta;
        this.gluoHistorialIndicadors = gluoHistorialIndicadors;
    }

    public Integer getIndiId() {
        return this.indiId;
    }

    public void setIndiId(Integer indiId) {
        this.indiId = indiId;
    }

    public GluoProyecto getGluoProyecto() {
        return this.gluoProyecto;
    }

    public void setGluoProyecto(GluoProyecto gluoProyecto) {
        this.gluoProyecto = gluoProyecto;
    }

    public String getActivo() {
        return this.activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getDescripcionIndicador() {
        return this.descripcionIndicador;
    }

    public void setDescripcionIndicador(String descripcionIndicador) {
        this.descripcionIndicador = descripcionIndicador;
    }

    public String getDescripcionLineaBase() {
        return this.descripcionLineaBase;
    }

    public void setDescripcionLineaBase(String descripcionLineaBase) {
        this.descripcionLineaBase = descripcionLineaBase;
    }

    public String getDescripcionMeta() {
        return this.descripcionMeta;
    }

    public void setDescripcionMeta(String descripcionMeta) {
        this.descripcionMeta = descripcionMeta;
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

    public Double getValorMeta() {
        return this.valorMeta;
    }

    public void setValorMeta(Double valorMeta) {
        this.valorMeta = valorMeta;
    }

    public Set<GluoHistorialIndicador> getGluoHistorialIndicadors() {
        return this.gluoHistorialIndicadors;
    }

    public void setGluoHistorialIndicadors(
        Set<GluoHistorialIndicador> gluoHistorialIndicadors) {
        this.gluoHistorialIndicadors = gluoHistorialIndicadors;
    }
}
