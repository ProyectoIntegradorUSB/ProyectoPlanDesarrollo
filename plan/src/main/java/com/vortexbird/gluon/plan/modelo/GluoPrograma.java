package com.vortexbird.gluon.plan.modelo;

import org.hibernate.validator.constraints.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
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
@Table(name = "gluoPrograma", schema = "public")
public class GluoPrograma implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer progId;
    @NotNull
    private GluoObjetivo gluoObjetivo;
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
    private Set<GluoSubprograma> gluoSubprogramas = new HashSet<GluoSubprograma>(0);

    public GluoPrograma() {
    }

    public GluoPrograma(Integer progId, String activo, String descripcion,
        Date fechaCreacion, Date fechaModificacion, GluoObjetivo gluoObjetivo,
        Set<GluoSubprograma> gluoSubprogramas, Integer usuCreador,
        Integer usuModificador) {
        this.progId = progId;
        this.gluoObjetivo = gluoObjetivo;
        this.activo = activo;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.usuCreador = usuCreador;
        this.usuModificador = usuModificador;
        this.gluoSubprogramas = gluoSubprogramas;
    }

    public Integer getProgId() {
        return this.progId;
    }

    public void setProgId(Integer progId) {
        this.progId = progId;
    }

    public GluoObjetivo getGluoObjetivo() {
        return this.gluoObjetivo;
    }

    public void setGluoObjetivo(GluoObjetivo gluoObjetivo) {
        this.gluoObjetivo = gluoObjetivo;
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

    public Set<GluoSubprograma> getGluoSubprogramas() {
        return this.gluoSubprogramas;
    }

    public void setGluoSubprogramas(Set<GluoSubprograma> gluoSubprogramas) {
        this.gluoSubprogramas = gluoSubprogramas;
    }
}
