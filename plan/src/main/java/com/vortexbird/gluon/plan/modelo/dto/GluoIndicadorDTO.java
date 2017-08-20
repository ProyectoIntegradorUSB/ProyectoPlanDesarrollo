package com.vortexbird.gluon.plan.modelo.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import java.sql.*;

import java.util.Date;


/**
*
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public class GluoIndicadorDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(GluoIndicadorDTO.class);
    private String activo;
    private String descripcionIndicador;
    private String descripcionLineaBase;
    private String descripcionMeta;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private Integer indiId;
    private Integer usuCreador;
    private Integer usuModificador;
    private Double valorMeta;
    private Integer proyId_GluoProyecto;

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getDescripcionIndicador() {
        return descripcionIndicador;
    }

    public void setDescripcionIndicador(String descripcionIndicador) {
        this.descripcionIndicador = descripcionIndicador;
    }

    public String getDescripcionLineaBase() {
        return descripcionLineaBase;
    }

    public void setDescripcionLineaBase(String descripcionLineaBase) {
        this.descripcionLineaBase = descripcionLineaBase;
    }

    public String getDescripcionMeta() {
        return descripcionMeta;
    }

    public void setDescripcionMeta(String descripcionMeta) {
        this.descripcionMeta = descripcionMeta;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Integer getIndiId() {
        return indiId;
    }

    public void setIndiId(Integer indiId) {
        this.indiId = indiId;
    }

    public Integer getUsuCreador() {
        return usuCreador;
    }

    public void setUsuCreador(Integer usuCreador) {
        this.usuCreador = usuCreador;
    }

    public Integer getUsuModificador() {
        return usuModificador;
    }

    public void setUsuModificador(Integer usuModificador) {
        this.usuModificador = usuModificador;
    }

    public Double getValorMeta() {
        return valorMeta;
    }

    public void setValorMeta(Double valorMeta) {
        this.valorMeta = valorMeta;
    }

    public Integer getProyId_GluoProyecto() {
        return proyId_GluoProyecto;
    }

    public void setProyId_GluoProyecto(Integer proyId_GluoProyecto) {
        this.proyId_GluoProyecto = proyId_GluoProyecto;
    }
}
