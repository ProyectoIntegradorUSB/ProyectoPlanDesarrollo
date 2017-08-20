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
@Table(name = "gluoTipoRecurso", schema = "public")
public class GluoTipoRecurso implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer tireId;
    @NotNull
    @NotEmpty
    @Size(max = 1)
    private String activo;
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String codigo;
    private String descripcion;
    @NotNull
    private Date fechaCreacion;
    private Date fechaModificacion;
    @NotNull
    private Integer usuCreador;
    private Integer usuModificador;
    private Set<GluoDetallePresupuesto> gluoDetallePresupuestos = new HashSet<GluoDetallePresupuesto>(0);

    public GluoTipoRecurso() {
    }

    public GluoTipoRecurso(Integer tireId, String activo, String codigo,
        String descripcion, Date fechaCreacion, Date fechaModificacion,
        Set<GluoDetallePresupuesto> gluoDetallePresupuestos,
        Integer usuCreador, Integer usuModificador) {
        this.tireId = tireId;
        this.activo = activo;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.usuCreador = usuCreador;
        this.usuModificador = usuModificador;
        this.gluoDetallePresupuestos = gluoDetallePresupuestos;
    }

    public Integer getTireId() {
        return this.tireId;
    }

    public void setTireId(Integer tireId) {
        this.tireId = tireId;
    }

    public String getActivo() {
        return this.activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public Set<GluoDetallePresupuesto> getGluoDetallePresupuestos() {
        return this.gluoDetallePresupuestos;
    }

    public void setGluoDetallePresupuestos(
        Set<GluoDetallePresupuesto> gluoDetallePresupuestos) {
        this.gluoDetallePresupuestos = gluoDetallePresupuestos;
    }
}
