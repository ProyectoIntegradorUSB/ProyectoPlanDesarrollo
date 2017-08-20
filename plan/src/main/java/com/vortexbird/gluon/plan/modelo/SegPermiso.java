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
@Table(name = "segPermiso", schema = "public")
public class SegPermiso implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer permId;
    @NotNull
    private SegOpcion segOpcion;
    @NotNull
    private SegRolUsuario segRolUsuario;
    @NotNull
    @NotEmpty
    @Size(max = 1)
    private String activo;
    @NotNull
    private Date fechaCreacion;
    private Date fechaModificacion;
    @NotNull
    private Integer rolId;
    @NotNull
    private Integer usuCreador;
    @NotNull
    private Integer usuId;
    private Integer usuModificador;

    public SegPermiso() {
    }

    public SegPermiso(Integer permId, String activo, Date fechaCreacion,
        Date fechaModificacion, Integer rolId, SegOpcion segOpcion,
        SegRolUsuario segRolUsuario, Integer usuCreador, Integer usuId,
        Integer usuModificador) {
        this.permId = permId;
        this.segOpcion = segOpcion;
        this.segRolUsuario = segRolUsuario;
        this.activo = activo;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.rolId = rolId;
        this.usuCreador = usuCreador;
        this.usuId = usuId;
        this.usuModificador = usuModificador;
    }

    public Integer getPermId() {
        return this.permId;
    }

    public void setPermId(Integer permId) {
        this.permId = permId;
    }

    public SegOpcion getSegOpcion() {
        return this.segOpcion;
    }

    public void setSegOpcion(SegOpcion segOpcion) {
        this.segOpcion = segOpcion;
    }

    public SegRolUsuario getSegRolUsuario() {
        return this.segRolUsuario;
    }

    public void setSegRolUsuario(SegRolUsuario segRolUsuario) {
        this.segRolUsuario = segRolUsuario;
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

    public Integer getRolId() {
        return this.rolId;
    }

    public void setRolId(Integer rolId) {
        this.rolId = rolId;
    }

    public Integer getUsuCreador() {
        return this.usuCreador;
    }

    public void setUsuCreador(Integer usuCreador) {
        this.usuCreador = usuCreador;
    }

    public Integer getUsuId() {
        return this.usuId;
    }

    public void setUsuId(Integer usuId) {
        this.usuId = usuId;
    }

    public Integer getUsuModificador() {
        return this.usuModificador;
    }

    public void setUsuModificador(Integer usuModificador) {
        this.usuModificador = usuModificador;
    }
}
