package com.vortexbird.gluon.plan.modelo;

import org.hibernate.validator.constraints.*;

import java.util.Date;

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
@Table(name = "gluoHistorialIndicador", schema = "public")
public class GluoHistorialIndicador implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer hiinId;
    @NotNull
    private GluoIndicador gluoIndicador;
    @NotNull
    @NotEmpty
    @Size(max = 1)
    private String activo;
    @NotNull
    private Date fecha;
    @NotNull
    private Date fechaCreacion;
    private Date fechaModificacion;
    @NotNull
    private Integer usuCreador;
    private Integer usuModificador;
    @NotNull
    private Double valorReal;

    public GluoHistorialIndicador() {
    }

    public GluoHistorialIndicador(Integer hiinId, String activo, Date fecha,
        Date fechaCreacion, Date fechaModificacion,
        GluoIndicador gluoIndicador, Integer usuCreador,
        Integer usuModificador, Double valorReal) {
        this.hiinId = hiinId;
        this.gluoIndicador = gluoIndicador;
        this.activo = activo;
        this.fecha = fecha;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.usuCreador = usuCreador;
        this.usuModificador = usuModificador;
        this.valorReal = valorReal;
    }

    public Integer getHiinId() {
        return this.hiinId;
    }

    public void setHiinId(Integer hiinId) {
        this.hiinId = hiinId;
    }

    public GluoIndicador getGluoIndicador() {
        return this.gluoIndicador;
    }

    public void setGluoIndicador(GluoIndicador gluoIndicador) {
        this.gluoIndicador = gluoIndicador;
    }

    public String getActivo() {
        return this.activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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

    public Double getValorReal() {
        return this.valorReal;
    }

    public void setValorReal(Double valorReal) {
        this.valorReal = valorReal;
    }
}
