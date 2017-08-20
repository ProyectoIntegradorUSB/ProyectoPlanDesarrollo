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
@Table(name = "gluoDetallePresupuesto", schema = "public")
public class GluoDetallePresupuesto implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer dptoId;
    @NotNull
    private GluoDetallePresupuesto gluoDetallePresupuesto;
    @NotNull
    private GluoPresupuesto gluoPresupuesto;
    @NotNull
    private GluoTipoRecurso gluoTipoRecurso;
    @NotNull
    @NotEmpty
    @Size(max = 1)
    private String activo;
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String codigoCuenta;
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String descripcionCuenta;
    @NotNull
    private Date fechaCreacion;
    private Date fechaModificacion;
    @NotNull
    private Double saldoEnCdps;
    private Integer sectId;
    private String tipoTransferencia;
    @NotNull
    private Integer usuCreador;
    private Integer usuModificador;
    @NotNull
    private Double valorAplazado;
    @NotNull
    private Double valorDespuesDeModificaciones;
    @NotNull
    private Double valorInicial;
    private Set<GluoDetallePresupuesto> gluoDetallePresupuestos = new HashSet<GluoDetallePresupuesto>(0);
    private Set<GluoDetalleProyectoXRubro> gluoDetalleProyectoXRubros = new HashSet<GluoDetalleProyectoXRubro>(0);

    public GluoDetallePresupuesto() {
    }

    public GluoDetallePresupuesto(Integer dptoId, String activo,
        String codigoCuenta, String descripcionCuenta, Date fechaCreacion,
        Date fechaModificacion, GluoDetallePresupuesto gluoDetallePresupuesto,
        Set<GluoDetallePresupuesto> gluoDetallePresupuestos,
        Set<GluoDetalleProyectoXRubro> gluoDetalleProyectoXRubros,
        GluoPresupuesto gluoPresupuesto, GluoTipoRecurso gluoTipoRecurso,
        Double saldoEnCdps, Integer sectId, String tipoTransferencia,
        Integer usuCreador, Integer usuModificador, Double valorAplazado,
        Double valorDespuesDeModificaciones, Double valorInicial) {
        this.dptoId = dptoId;
        this.gluoDetallePresupuesto = gluoDetallePresupuesto;
        this.gluoPresupuesto = gluoPresupuesto;
        this.gluoTipoRecurso = gluoTipoRecurso;
        this.activo = activo;
        this.codigoCuenta = codigoCuenta;
        this.descripcionCuenta = descripcionCuenta;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.saldoEnCdps = saldoEnCdps;
        this.sectId = sectId;
        this.tipoTransferencia = tipoTransferencia;
        this.usuCreador = usuCreador;
        this.usuModificador = usuModificador;
        this.valorAplazado = valorAplazado;
        this.valorDespuesDeModificaciones = valorDespuesDeModificaciones;
        this.valorInicial = valorInicial;
        this.gluoDetallePresupuestos = gluoDetallePresupuestos;
        this.gluoDetalleProyectoXRubros = gluoDetalleProyectoXRubros;
    }

    public Integer getDptoId() {
        return this.dptoId;
    }

    public void setDptoId(Integer dptoId) {
        this.dptoId = dptoId;
    }

    public GluoDetallePresupuesto getGluoDetallePresupuesto() {
        return this.gluoDetallePresupuesto;
    }

    public void setGluoDetallePresupuesto(
        GluoDetallePresupuesto gluoDetallePresupuesto) {
        this.gluoDetallePresupuesto = gluoDetallePresupuesto;
    }

    public GluoPresupuesto getGluoPresupuesto() {
        return this.gluoPresupuesto;
    }

    public void setGluoPresupuesto(GluoPresupuesto gluoPresupuesto) {
        this.gluoPresupuesto = gluoPresupuesto;
    }

    public GluoTipoRecurso getGluoTipoRecurso() {
        return this.gluoTipoRecurso;
    }

    public void setGluoTipoRecurso(GluoTipoRecurso gluoTipoRecurso) {
        this.gluoTipoRecurso = gluoTipoRecurso;
    }

    public String getActivo() {
        return this.activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getCodigoCuenta() {
        return this.codigoCuenta;
    }

    public void setCodigoCuenta(String codigoCuenta) {
        this.codigoCuenta = codigoCuenta;
    }

    public String getDescripcionCuenta() {
        return this.descripcionCuenta;
    }

    public void setDescripcionCuenta(String descripcionCuenta) {
        this.descripcionCuenta = descripcionCuenta;
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

    public Double getSaldoEnCdps() {
        return this.saldoEnCdps;
    }

    public void setSaldoEnCdps(Double saldoEnCdps) {
        this.saldoEnCdps = saldoEnCdps;
    }

    public Integer getSectId() {
        return this.sectId;
    }

    public void setSectId(Integer sectId) {
        this.sectId = sectId;
    }

    public String getTipoTransferencia() {
        return this.tipoTransferencia;
    }

    public void setTipoTransferencia(String tipoTransferencia) {
        this.tipoTransferencia = tipoTransferencia;
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

    public Double getValorAplazado() {
        return this.valorAplazado;
    }

    public void setValorAplazado(Double valorAplazado) {
        this.valorAplazado = valorAplazado;
    }

    public Double getValorDespuesDeModificaciones() {
        return this.valorDespuesDeModificaciones;
    }

    public void setValorDespuesDeModificaciones(
        Double valorDespuesDeModificaciones) {
        this.valorDespuesDeModificaciones = valorDespuesDeModificaciones;
    }

    public Double getValorInicial() {
        return this.valorInicial;
    }

    public void setValorInicial(Double valorInicial) {
        this.valorInicial = valorInicial;
    }

    public Set<GluoDetallePresupuesto> getGluoDetallePresupuestos() {
        return this.gluoDetallePresupuestos;
    }

    public void setGluoDetallePresupuestos(
        Set<GluoDetallePresupuesto> gluoDetallePresupuestos) {
        this.gluoDetallePresupuestos = gluoDetallePresupuestos;
    }

    public Set<GluoDetalleProyectoXRubro> getGluoDetalleProyectoXRubros() {
        return this.gluoDetalleProyectoXRubros;
    }

    public void setGluoDetalleProyectoXRubros(
        Set<GluoDetalleProyectoXRubro> gluoDetalleProyectoXRubros) {
        this.gluoDetalleProyectoXRubros = gluoDetalleProyectoXRubros;
    }
}
