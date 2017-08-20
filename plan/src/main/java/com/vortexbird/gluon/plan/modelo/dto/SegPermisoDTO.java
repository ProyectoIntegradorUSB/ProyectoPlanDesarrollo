package com.vortexbird.gluon.plan.modelo.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import java.sql.*;

import java.util.Date;


/**
*
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public class SegPermisoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(SegPermisoDTO.class);
    private String activo;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private Integer permId;
    private Integer rolId;
    private Integer usuCreador;
    private Integer usuId;
    private Integer usuModificador;
    private Integer opcnId_SegOpcion;
    private Integer rlusId_SegRolUsuario;

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Integer getPermId() {
        return permId;
    }

    public void setPermId(Integer permId) {
        this.permId = permId;
    }

    public Integer getRolId() {
        return rolId;
    }

    public void setRolId(Integer rolId) {
        this.rolId = rolId;
    }

    public Integer getUsuCreador() {
        return usuCreador;
    }

    public void setUsuCreador(Integer usuCreador) {
        this.usuCreador = usuCreador;
    }

    public Integer getUsuId() {
        return usuId;
    }

    public void setUsuId(Integer usuId) {
        this.usuId = usuId;
    }

    public Integer getUsuModificador() {
        return usuModificador;
    }

    public void setUsuModificador(Integer usuModificador) {
        this.usuModificador = usuModificador;
    }

    public Integer getOpcnId_SegOpcion() {
        return opcnId_SegOpcion;
    }

    public void setOpcnId_SegOpcion(Integer opcnId_SegOpcion) {
        this.opcnId_SegOpcion = opcnId_SegOpcion;
    }

    public Integer getRlusId_SegRolUsuario() {
        return rlusId_SegRolUsuario;
    }

    public void setRlusId_SegRolUsuario(Integer rlusId_SegRolUsuario) {
        this.rlusId_SegRolUsuario = rlusId_SegRolUsuario;
    }
}
