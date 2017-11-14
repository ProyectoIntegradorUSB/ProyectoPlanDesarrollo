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
@Table(name = "gluoDetalleProyectoXRubro", schema = "public")
public class GluoDetalleProyectoXRubro implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer dpruId;
    @NotNull
    private GluoDetallePresupuesto gluoDetallePresupuesto;
    @NotNull
    private GluoDetalleProyecto gluoDetalleProyecto;
    @NotNull
    @NotEmpty
    @Size(max = 1)
    private String activo;
    @NotNull
    @NotEmpty
    @Size(max = 255)
    
    private String descripcion;
    @NotNull
    private Date fechaCreacion;
    private Date fechaModificacion;
    @NotNull
    private Integer usuCreador;
    private Integer usuModificador;
    @NotNull
    
    private Double valor;

    public GluoDetalleProyectoXRubro() {
    }

    public GluoDetalleProyectoXRubro(Integer dpruId, String activo,
        String descripcion, Date fechaCreacion, Date fechaModificacion,
        GluoDetallePresupuesto gluoDetallePresupuesto,
        GluoDetalleProyecto gluoDetalleProyecto, Integer usuCreador,
        Integer usuModificador, Double valor) {
        this.dpruId = dpruId;
        this.gluoDetallePresupuesto = gluoDetallePresupuesto;
        this.gluoDetalleProyecto = gluoDetalleProyecto;
        this.activo = activo;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.usuCreador = usuCreador;
        this.usuModificador = usuModificador;
        this.valor = valor;
    }

    public Integer getDpruId() {
        return this.dpruId;
    }

    public void setDpruId(Integer dpruId) {
        this.dpruId = dpruId;
    }

    public GluoDetallePresupuesto getGluoDetallePresupuesto() {
        return this.gluoDetallePresupuesto;
    }

    public void setGluoDetallePresupuesto(
        GluoDetallePresupuesto gluoDetallePresupuesto) {
        this.gluoDetallePresupuesto = gluoDetallePresupuesto;
    }

    public GluoDetalleProyecto getGluoDetalleProyecto() {
        return this.gluoDetalleProyecto;
    }

    public void setGluoDetalleProyecto(GluoDetalleProyecto gluoDetalleProyecto) {
        this.gluoDetalleProyecto = gluoDetalleProyecto;
    }

    public String getActivo() {
        return this.activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public Double getValor() {
        return this.valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
