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
public class GluoDetalleProyectoXRubroDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(GluoDetalleProyectoXRubroDTO.class);
    private String activo;
    private String descripcion;
    private Integer dpruId;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private Integer usuCreador;
    private Integer usuModificador;
    private Double valor;
    private Integer dptoId_GluoDetallePresupuesto;
    private Integer dproId_GluoDetalleProyecto;

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getDpruId() {
        return dpruId;
    }

    public void setDpruId(Integer dpruId) {
        this.dpruId = dpruId;
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

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getDptoId_GluoDetallePresupuesto() {
        return dptoId_GluoDetallePresupuesto;
    }

    public void setDptoId_GluoDetallePresupuesto(
        Integer dptoId_GluoDetallePresupuesto) {
        this.dptoId_GluoDetallePresupuesto = dptoId_GluoDetallePresupuesto;
    }

    public Integer getDproId_GluoDetalleProyecto() {
        return dproId_GluoDetalleProyecto;
    }

    public void setDproId_GluoDetalleProyecto(
        Integer dproId_GluoDetalleProyecto) {
        this.dproId_GluoDetalleProyecto = dproId_GluoDetalleProyecto;
    }
}
