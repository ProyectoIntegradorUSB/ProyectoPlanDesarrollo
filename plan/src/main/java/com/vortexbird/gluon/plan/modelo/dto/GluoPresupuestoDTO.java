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
public class GluoPresupuestoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(GluoPresupuestoDTO.class);
    private String activo;
    private String aprobado;
    private String contabilizado;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private Integer pptoId;
    private Integer tippId;
    private Integer usuAprobador;
    private Integer usuCreador;
    private Integer usuModificador;
    private Integer anofId_GluoAnoFiscal;

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getAprobado() {
        return aprobado;
    }

    public void setAprobado(String aprobado) {
        this.aprobado = aprobado;
    }

    public String getContabilizado() {
        return contabilizado;
    }

    public void setContabilizado(String contabilizado) {
        this.contabilizado = contabilizado;
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

    public Integer getPptoId() {
        return pptoId;
    }

    public void setPptoId(Integer pptoId) {
        this.pptoId = pptoId;
    }

    public Integer getTippId() {
        return tippId;
    }

    public void setTippId(Integer tippId) {
        this.tippId = tippId;
    }

    public Integer getUsuAprobador() {
        return usuAprobador;
    }

    public void setUsuAprobador(Integer usuAprobador) {
        this.usuAprobador = usuAprobador;
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

    public Integer getAnofId_GluoAnoFiscal() {
        return anofId_GluoAnoFiscal;
    }

    public void setAnofId_GluoAnoFiscal(Integer anofId_GluoAnoFiscal) {
        this.anofId_GluoAnoFiscal = anofId_GluoAnoFiscal;
    }
}
