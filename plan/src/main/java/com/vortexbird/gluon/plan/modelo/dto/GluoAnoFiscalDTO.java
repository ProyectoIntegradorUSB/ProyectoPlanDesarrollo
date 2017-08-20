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
public class GluoAnoFiscalDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(GluoAnoFiscalDTO.class);
    private String activo;
    private Integer anoFiscal;
    private Integer anofId;
    private String descripcion;
    private Integer emprId;
    private String estado;
    private Date fechaCreacion;
    private Date fechaIncioAnoFiscal;
    private Date fechaModificacion;
    private Integer usuCreador;
    private Integer usuModificador;
    private Double valorSalarioMinimo;

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public Integer getAnoFiscal() {
        return anoFiscal;
    }

    public void setAnoFiscal(Integer anoFiscal) {
        this.anoFiscal = anoFiscal;
    }

    public Integer getAnofId() {
        return anofId;
    }

    public void setAnofId(Integer anofId) {
        this.anofId = anofId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getEmprId() {
        return emprId;
    }

    public void setEmprId(Integer emprId) {
        this.emprId = emprId;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaIncioAnoFiscal() {
        return fechaIncioAnoFiscal;
    }

    public void setFechaIncioAnoFiscal(Date fechaIncioAnoFiscal) {
        this.fechaIncioAnoFiscal = fechaIncioAnoFiscal;
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

    public Double getValorSalarioMinimo() {
        return valorSalarioMinimo;
    }

    public void setValorSalarioMinimo(Double valorSalarioMinimo) {
        this.valorSalarioMinimo = valorSalarioMinimo;
    }
}
