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
@Table(name = "gluoAnoFiscal", schema = "public")
public class GluoAnoFiscal implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer anofId;
    private String activo;
    @NotNull
    private Integer anoFiscal;
    private String descripcion;
    @NotNull
    private Integer emprId;
    @NotNull
    @NotEmpty
    @Size(max = 1)
    private String estado;
    @NotNull
    private Date fechaCreacion;
    @NotNull
    private Date fechaIncioAnoFiscal;
    private Date fechaModificacion;
    @NotNull
    private Integer usuCreador;
    private Integer usuModificador;
    @NotNull
    private Double valorSalarioMinimo;
    private Set<GluoDetalleProyecto> gluoDetalleProyectos = new HashSet<GluoDetalleProyecto>(0);
    private Set<GluoPresupuesto> gluoPresupuestos = new HashSet<GluoPresupuesto>(0);

    public GluoAnoFiscal() {
    }

    public GluoAnoFiscal(Integer anofId, String activo, Integer anoFiscal,
        String descripcion, Integer emprId, String estado, Date fechaCreacion,
        Date fechaIncioAnoFiscal, Date fechaModificacion,
        Set<GluoDetalleProyecto> gluoDetalleProyectos,
        Set<GluoPresupuesto> gluoPresupuestos, Integer usuCreador,
        Integer usuModificador, Double valorSalarioMinimo) {
        this.anofId = anofId;
        this.activo = activo;
        this.anoFiscal = anoFiscal;
        this.descripcion = descripcion;
        this.emprId = emprId;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.fechaIncioAnoFiscal = fechaIncioAnoFiscal;
        this.fechaModificacion = fechaModificacion;
        this.usuCreador = usuCreador;
        this.usuModificador = usuModificador;
        this.valorSalarioMinimo = valorSalarioMinimo;
        this.gluoDetalleProyectos = gluoDetalleProyectos;
        this.gluoPresupuestos = gluoPresupuestos;
    }

    public Integer getAnofId() {
        return this.anofId;
    }

    public void setAnofId(Integer anofId) {
        this.anofId = anofId;
    }

    public String getActivo() {
        return this.activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public Integer getAnoFiscal() {
        return this.anoFiscal;
    }

    public void setAnoFiscal(Integer anoFiscal) {
        this.anoFiscal = anoFiscal;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getEmprId() {
        return this.emprId;
    }

    public void setEmprId(Integer emprId) {
        this.emprId = emprId;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaCreacion() {
        return this.fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaIncioAnoFiscal() {
        return this.fechaIncioAnoFiscal;
    }

    public void setFechaIncioAnoFiscal(Date fechaIncioAnoFiscal) {
        this.fechaIncioAnoFiscal = fechaIncioAnoFiscal;
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

    public Double getValorSalarioMinimo() {
        return this.valorSalarioMinimo;
    }

    public void setValorSalarioMinimo(Double valorSalarioMinimo) {
        this.valorSalarioMinimo = valorSalarioMinimo;
    }

    public Set<GluoDetalleProyecto> getGluoDetalleProyectos() {
        return this.gluoDetalleProyectos;
    }

    public void setGluoDetalleProyectos(
        Set<GluoDetalleProyecto> gluoDetalleProyectos) {
        this.gluoDetalleProyectos = gluoDetalleProyectos;
    }

    public Set<GluoPresupuesto> getGluoPresupuestos() {
        return this.gluoPresupuestos;
    }

    public void setGluoPresupuestos(Set<GluoPresupuesto> gluoPresupuestos) {
        this.gluoPresupuestos = gluoPresupuestos;
    }
}
