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
@Table(name = "segUsuario", schema = "public")
public class SegUsuario implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer usuId;
    @NotNull
    @NotEmpty
    @Size(max = 1)
    private String activo;
    @NotNull
    private Date fechaCreacion;
    private Date fechaModificacion;
    @NotNull
    private Integer usuCreador;
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String usuLogin;
    private Integer usuModificador;
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String usuPassword;
    private Set<SegRolUsuario> segRolUsuarios = new HashSet<SegRolUsuario>(0);

    public SegUsuario() {
    }

    public SegUsuario(Integer usuId, String activo, Date fechaCreacion,
        Date fechaModificacion, Set<SegRolUsuario> segRolUsuarios,
        Integer usuCreador, String usuLogin, Integer usuModificador,
        String usuPassword) {
        this.usuId = usuId;
        this.activo = activo;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.usuCreador = usuCreador;
        this.usuLogin = usuLogin;
        this.usuModificador = usuModificador;
        this.usuPassword = usuPassword;
        this.segRolUsuarios = segRolUsuarios;
    }

    public Integer getUsuId() {
        return this.usuId;
    }

    public void setUsuId(Integer usuId) {
        this.usuId = usuId;
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

    public String getUsuLogin() {
        return this.usuLogin;
    }

    public void setUsuLogin(String usuLogin) {
        this.usuLogin = usuLogin;
    }

    public Integer getUsuModificador() {
        return this.usuModificador;
    }

    public void setUsuModificador(Integer usuModificador) {
        this.usuModificador = usuModificador;
    }

    public String getUsuPassword() {
        return this.usuPassword;
    }

    public void setUsuPassword(String usuPassword) {
        this.usuPassword = usuPassword;
    }

    public Set<SegRolUsuario> getSegRolUsuarios() {
        return this.segRolUsuarios;
    }

    public void setSegRolUsuarios(Set<SegRolUsuario> segRolUsuarios) {
        this.segRolUsuarios = segRolUsuarios;
    }
}
