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
@Table(name = "segRol", schema = "public")
public class SegRol implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer rolId;
    @NotNull
    @NotEmpty
    @Size(max = 1)
    private String activo;
    @NotNull
    private Date fechaCreacion;
    private Date fechaModificacion;
    @NotNull
    @NotEmpty
    @Size(max = 255)
   
    private String nombre;
    @NotNull
    private Integer usuCreador;
    private Integer usuModificador;
    private Set<SegRolUsuario> segRolUsuarios = new HashSet<SegRolUsuario>(0);

    public SegRol() {
    }

    public SegRol(Integer rolId, String activo, Date fechaCreacion,
        Date fechaModificacion, String nombre,
        Set<SegRolUsuario> segRolUsuarios, Integer usuCreador,
        Integer usuModificador) {
        this.rolId = rolId;
        this.activo = activo;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.nombre = nombre;
        this.usuCreador = usuCreador;
        this.usuModificador = usuModificador;
        this.segRolUsuarios = segRolUsuarios;
    }

    public Integer getRolId() {
        return this.rolId;
    }

    public void setRolId(Integer rolId) {
        this.rolId = rolId;
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

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public Set<SegRolUsuario> getSegRolUsuarios() {
        return this.segRolUsuarios;
    }

    public void setSegRolUsuarios(Set<SegRolUsuario> segRolUsuarios) {
        this.segRolUsuarios = segRolUsuarios;
    }
}
