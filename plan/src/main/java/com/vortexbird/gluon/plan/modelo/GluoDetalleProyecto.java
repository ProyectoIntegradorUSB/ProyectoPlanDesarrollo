package com.vortexbird.gluon.plan.modelo;

import org.hibernate.validator.constraints.*;
import org.primefaces.component.selectonemenu.SelectOneMenu;

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
@Table(name = "gluoDetalleProyecto", schema = "public")
public class GluoDetalleProyecto implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer dproId;
    @NotNull
    private GluoAnoFiscal gluoAnoFiscal;
    @NotNull
    private GluoProyecto gluoProyecto;
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
    @NotNull
    
    private Double valorTotalPresupuesto;
    private Set<GluoDetalleProyectoXRubro> gluoDetalleProyectoXRubros = new HashSet<GluoDetalleProyectoXRubro>(0);

    public GluoDetalleProyecto() {
    }

    public GluoDetalleProyecto(Integer dproId, String activo,
        Date fechaCreacion, Date fechaModificacion,
        GluoAnoFiscal gluoAnoFiscal,
        Set<GluoDetalleProyectoXRubro> gluoDetalleProyectoXRubros,
        GluoProyecto gluoProyecto, Integer usuCreador, Integer usuModificador,
        Double valorTotalPresupuesto) {
        this.dproId = dproId;
        this.gluoAnoFiscal = gluoAnoFiscal;
        this.gluoProyecto = gluoProyecto;
        this.activo = activo;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.usuCreador = usuCreador;
        this.usuModificador = usuModificador;
        this.valorTotalPresupuesto = valorTotalPresupuesto;
        this.gluoDetalleProyectoXRubros = gluoDetalleProyectoXRubros;
    }

    public Integer getDproId() {
        return this.dproId;
    }

    public void setDproId(Integer dproId) {
        this.dproId = dproId;
    }

    public GluoAnoFiscal getGluoAnoFiscal() {
        return this.gluoAnoFiscal;
    }

    public void setGluoAnoFiscal(GluoAnoFiscal gluoAnoFiscal) {
        this.gluoAnoFiscal = gluoAnoFiscal;
    }

    public GluoProyecto getGluoProyecto() {
        return this.gluoProyecto;
    }

    public void setGluoProyecto(GluoProyecto gluoProyecto) {
        this.gluoProyecto = gluoProyecto;
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

    public Double getValorTotalPresupuesto() {
        return this.valorTotalPresupuesto;
    }

    public void setValorTotalPresupuesto(Double valorTotalPresupuesto) {
        this.valorTotalPresupuesto = valorTotalPresupuesto;
    }

    public Set<GluoDetalleProyectoXRubro> getGluoDetalleProyectoXRubros() {
        return this.gluoDetalleProyectoXRubros;
    }

    public void setGluoDetalleProyectoXRubros(
        Set<GluoDetalleProyectoXRubro> gluoDetalleProyectoXRubros) {
        this.gluoDetalleProyectoXRubros = gluoDetalleProyectoXRubros;
    }
}
