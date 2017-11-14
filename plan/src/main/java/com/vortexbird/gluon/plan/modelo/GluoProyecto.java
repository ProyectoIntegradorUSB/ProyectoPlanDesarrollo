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
@Table(name = "gluoProyecto", schema = "public")
public class GluoProyecto implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer proyId;
    @NotNull
    private GluoSubprograma gluoSubprograma;
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
    private Set<GluoDetalleProyecto> gluoDetalleProyectos = new HashSet<GluoDetalleProyecto>(0);
    private Set<GluoIndicador> gluoIndicadors = new HashSet<GluoIndicador>(0);

    public GluoProyecto() {
    }

    public GluoProyecto(Integer proyId, String activo, String descripcion,
        Date fechaCreacion, Date fechaModificacion,
        Set<GluoDetalleProyecto> gluoDetalleProyectos,
        Set<GluoIndicador> gluoIndicadors, GluoSubprograma gluoSubprograma,
        Integer usuCreador, Integer usuModificador) {
        this.proyId = proyId;
        this.gluoSubprograma = gluoSubprograma;
        this.activo = activo;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.usuCreador = usuCreador;
        this.usuModificador = usuModificador;
        this.gluoDetalleProyectos = gluoDetalleProyectos;
        this.gluoIndicadors = gluoIndicadors;
    }

    public Integer getProyId() {
        return this.proyId;
    }

    public void setProyId(Integer proyId) {
        this.proyId = proyId;
    }

    public GluoSubprograma getGluoSubprograma() {
        return this.gluoSubprograma;
    }

    public void setGluoSubprograma(GluoSubprograma gluoSubprograma) {
        this.gluoSubprograma = gluoSubprograma;
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

    public Set<GluoDetalleProyecto> getGluoDetalleProyectos() {
        return this.gluoDetalleProyectos;
    }

    public void setGluoDetalleProyectos(
        Set<GluoDetalleProyecto> gluoDetalleProyectos) {
        this.gluoDetalleProyectos = gluoDetalleProyectos;
    }

    public Set<GluoIndicador> getGluoIndicadors() {
        return this.gluoIndicadors;
    }

    public void setGluoIndicadors(Set<GluoIndicador> gluoIndicadors) {
        this.gluoIndicadors = gluoIndicadors;
    }
}
