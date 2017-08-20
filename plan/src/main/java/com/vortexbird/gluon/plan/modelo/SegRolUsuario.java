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
@Table(name = "segRolUsuario", schema = "public")
public class SegRolUsuario implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer rlusId;
    @NotNull
    private SegRol segRol;
    @NotNull
    private SegUsuario segUsuario;
    @NotNull
    @NotEmpty
    @Size(max = 1)
    private String activo;
    @NotNull
    private Date fechaCreacion;
    private Date fechaModificacion;
    @NotNull
    private Integer usuCreador;
    private Integer usuModificador;
    private Set<SegPermiso> segPermisos = new HashSet<SegPermiso>(0);

    public SegRolUsuario() {
    }

    public SegRolUsuario(Integer rlusId, String activo, Date fechaCreacion,
        Date fechaModificacion, Set<SegPermiso> segPermisos, SegRol segRol,
        SegUsuario segUsuario, Integer usuCreador, Integer usuModificador) {
        this.rlusId = rlusId;
        this.segRol = segRol;
        this.segUsuario = segUsuario;
        this.activo = activo;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.usuCreador = usuCreador;
        this.usuModificador = usuModificador;
        this.segPermisos = segPermisos;
    }

    public Integer getRlusId() {
        return this.rlusId;
    }

    public void setRlusId(Integer rlusId) {
        this.rlusId = rlusId;
    }

    public SegRol getSegRol() {
        return this.segRol;
    }

    public void setSegRol(SegRol segRol) {
        this.segRol = segRol;
    }

    public SegUsuario getSegUsuario() {
        return this.segUsuario;
    }

    public void setSegUsuario(SegUsuario segUsuario) {
        this.segUsuario = segUsuario;
    }

    public String getActivo() {
        return this.activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
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

    public Set<SegPermiso> getSegPermisos() {
        return this.segPermisos;
    }

    public void setSegPermisos(Set<SegPermiso> segPermisos) {
        this.segPermisos = segPermisos;
    }
}
