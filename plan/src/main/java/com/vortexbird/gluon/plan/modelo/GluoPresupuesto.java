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
@Table(name = "gluoPresupuesto", schema = "public")
public class GluoPresupuesto implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer pptoId;
    @NotNull
    private GluoAnoFiscal gluoAnoFiscal;
    private String activo;
    @NotNull
    @NotEmpty
    @Size(max = 1)
    private String aprobado;
    @NotNull
    @NotEmpty
    @Size(max = 1)
    private String contabilizado;
    @NotNull
    private Date fechaCreacion;
    private Date fechaModificacion;
    @NotNull
    private Integer tippId;
    private Integer usuAprobador;
    @NotNull
    private Integer usuCreador;
    private Integer usuModificador;
    private Set<GluoDetallePresupuesto> gluoDetallePresupuestos = new HashSet<GluoDetallePresupuesto>(0);

    public GluoPresupuesto() {
    }

    public GluoPresupuesto(Integer pptoId, String activo, String aprobado,
        String contabilizado, Date fechaCreacion, Date fechaModificacion,
        GluoAnoFiscal gluoAnoFiscal,
        Set<GluoDetallePresupuesto> gluoDetallePresupuestos, Integer tippId,
        Integer usuAprobador, Integer usuCreador, Integer usuModificador) {
        this.pptoId = pptoId;
        this.gluoAnoFiscal = gluoAnoFiscal;
        this.activo = activo;
        this.aprobado = aprobado;
        this.contabilizado = contabilizado;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.tippId = tippId;
        this.usuAprobador = usuAprobador;
        this.usuCreador = usuCreador;
        this.usuModificador = usuModificador;
        this.gluoDetallePresupuestos = gluoDetallePresupuestos;
    }

    public Integer getPptoId() {
        return this.pptoId;
    }

    public void setPptoId(Integer pptoId) {
        this.pptoId = pptoId;
    }

    public GluoAnoFiscal getGluoAnoFiscal() {
        return this.gluoAnoFiscal;
    }

    public void setGluoAnoFiscal(GluoAnoFiscal gluoAnoFiscal) {
        this.gluoAnoFiscal = gluoAnoFiscal;
    }

    public String getActivo() {
        return this.activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getAprobado() {
        return this.aprobado;
    }

    public void setAprobado(String aprobado) {
        this.aprobado = aprobado;
    }

    public String getContabilizado() {
        return this.contabilizado;
    }

    public void setContabilizado(String contabilizado) {
        this.contabilizado = contabilizado;
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

    public Integer getTippId() {
        return this.tippId;
    }

    public void setTippId(Integer tippId) {
        this.tippId = tippId;
    }

    public Integer getUsuAprobador() {
        return this.usuAprobador;
    }

    public void setUsuAprobador(Integer usuAprobador) {
        this.usuAprobador = usuAprobador;
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

    public Set<GluoDetallePresupuesto> getGluoDetallePresupuestos() {
        return this.gluoDetallePresupuestos;
    }

    public void setGluoDetallePresupuestos(
        Set<GluoDetallePresupuesto> gluoDetallePresupuestos) {
        this.gluoDetallePresupuestos = gluoDetallePresupuestos;
    }
}
