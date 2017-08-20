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
public class GluoDetallePresupuestoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(GluoDetallePresupuestoDTO.class);
    private String activo;
    private String codigoCuenta;
    private String descripcionCuenta;
    private Integer dptoId;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private Double saldoEnCdps;
    private Integer sectId;
    private String tipoTransferencia;
    private Integer usuCreador;
    private Integer usuModificador;
    private Double valorAplazado;
    private Double valorDespuesDeModificaciones;
    private Double valorInicial;
    private Integer dptoId_GluoDetallePresupuesto;
    private Integer pptoId_GluoPresupuesto;
    private Integer tireId_GluoTipoRecurso;

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getCodigoCuenta() {
        return codigoCuenta;
    }

    public void setCodigoCuenta(String codigoCuenta) {
        this.codigoCuenta = codigoCuenta;
    }

    public String getDescripcionCuenta() {
        return descripcionCuenta;
    }

    public void setDescripcionCuenta(String descripcionCuenta) {
        this.descripcionCuenta = descripcionCuenta;
    }

    public Integer getDptoId() {
        return dptoId;
    }

    public void setDptoId(Integer dptoId) {
        this.dptoId = dptoId;
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

    public Double getSaldoEnCdps() {
        return saldoEnCdps;
    }

    public void setSaldoEnCdps(Double saldoEnCdps) {
        this.saldoEnCdps = saldoEnCdps;
    }

    public Integer getSectId() {
        return sectId;
    }

    public void setSectId(Integer sectId) {
        this.sectId = sectId;
    }

    public String getTipoTransferencia() {
        return tipoTransferencia;
    }

    public void setTipoTransferencia(String tipoTransferencia) {
        this.tipoTransferencia = tipoTransferencia;
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

    public Double getValorAplazado() {
        return valorAplazado;
    }

    public void setValorAplazado(Double valorAplazado) {
        this.valorAplazado = valorAplazado;
    }

    public Double getValorDespuesDeModificaciones() {
        return valorDespuesDeModificaciones;
    }

    public void setValorDespuesDeModificaciones(
        Double valorDespuesDeModificaciones) {
        this.valorDespuesDeModificaciones = valorDespuesDeModificaciones;
    }

    public Double getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(Double valorInicial) {
        this.valorInicial = valorInicial;
    }

    public Integer getDptoId_GluoDetallePresupuesto() {
        return dptoId_GluoDetallePresupuesto;
    }

    public void setDptoId_GluoDetallePresupuesto(
        Integer dptoId_GluoDetallePresupuesto) {
        this.dptoId_GluoDetallePresupuesto = dptoId_GluoDetallePresupuesto;
    }

    public Integer getPptoId_GluoPresupuesto() {
        return pptoId_GluoPresupuesto;
    }

    public void setPptoId_GluoPresupuesto(Integer pptoId_GluoPresupuesto) {
        this.pptoId_GluoPresupuesto = pptoId_GluoPresupuesto;
    }

    public Integer getTireId_GluoTipoRecurso() {
        return tireId_GluoTipoRecurso;
    }

    public void setTireId_GluoTipoRecurso(Integer tireId_GluoTipoRecurso) {
        this.tireId_GluoTipoRecurso = tireId_GluoTipoRecurso;
    }
}
