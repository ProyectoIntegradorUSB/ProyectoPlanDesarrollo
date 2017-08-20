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
public class GluoDetalleProyectoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(GluoDetalleProyectoDTO.class);
    private String activo;
    private Integer dproId;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private Integer usuCreador;
    private Integer usuModificador;
    private Double valorTotalPresupuesto;
    private Integer anofId_GluoAnoFiscal;
    private Integer proyId_GluoProyecto;

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public Integer getDproId() {
        return dproId;
    }

    public void setDproId(Integer dproId) {
        this.dproId = dproId;
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

    public Double getValorTotalPresupuesto() {
        return valorTotalPresupuesto;
    }

    public void setValorTotalPresupuesto(Double valorTotalPresupuesto) {
        this.valorTotalPresupuesto = valorTotalPresupuesto;
    }

    public Integer getAnofId_GluoAnoFiscal() {
        return anofId_GluoAnoFiscal;
    }

    public void setAnofId_GluoAnoFiscal(Integer anofId_GluoAnoFiscal) {
        this.anofId_GluoAnoFiscal = anofId_GluoAnoFiscal;
    }

    public Integer getProyId_GluoProyecto() {
        return proyId_GluoProyecto;
    }

    public void setProyId_GluoProyecto(Integer proyId_GluoProyecto) {
        this.proyId_GluoProyecto = proyId_GluoProyecto;
    }
}
