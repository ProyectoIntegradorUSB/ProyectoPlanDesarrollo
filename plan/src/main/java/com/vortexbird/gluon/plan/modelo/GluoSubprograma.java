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
@Table(name = "gluoSubprograma", schema = "public")
public class GluoSubprograma implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer subpId;
    @NotNull
    private GluoPrograma gluoPrograma;
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
    private Set<GluoProyecto> gluoProyectos = new HashSet<GluoProyecto>(0);

    public GluoSubprograma() {
    }

    public GluoSubprograma(Integer subpId, String activo, String descripcion,
        Date fechaCreacion, Date fechaModificacion, GluoPrograma gluoPrograma,
        Set<GluoProyecto> gluoProyectos, Integer usuCreador,
        Integer usuModificador) {
        this.subpId = subpId;
        this.gluoPrograma = gluoPrograma;
        this.activo = activo;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.usuCreador = usuCreador;
        this.usuModificador = usuModificador;
        this.gluoProyectos = gluoProyectos;
    }

    public Integer getSubpId() {
        return this.subpId;
    }

    public void setSubpId(Integer subpId) {
        this.subpId = subpId;
    }

    public GluoPrograma getGluoPrograma() {
        return this.gluoPrograma;
    }

    public void setGluoPrograma(GluoPrograma gluoPrograma) {
        this.gluoPrograma = gluoPrograma;
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

    public Set<GluoProyecto> getGluoProyectos() {
        return this.gluoProyectos;
    }

    public void setGluoProyectos(Set<GluoProyecto> gluoProyectos) {
        this.gluoProyectos = gluoProyectos;
    }
}
