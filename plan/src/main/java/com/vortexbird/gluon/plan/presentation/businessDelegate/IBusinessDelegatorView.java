package com.vortexbird.gluon.plan.presentation.businessDelegate;

import com.vortexbird.gluon.plan.modelo.GluoAnoFiscal;
import com.vortexbird.gluon.plan.modelo.GluoDetallePresupuesto;
import com.vortexbird.gluon.plan.modelo.GluoDetalleProyecto;
import com.vortexbird.gluon.plan.modelo.GluoDetalleProyectoXRubro;
import com.vortexbird.gluon.plan.modelo.GluoHistorialIndicador;
import com.vortexbird.gluon.plan.modelo.GluoIndicador;
import com.vortexbird.gluon.plan.modelo.GluoObjetivo;
import com.vortexbird.gluon.plan.modelo.GluoPlanDesarrollo;
import com.vortexbird.gluon.plan.modelo.GluoPresupuesto;
import com.vortexbird.gluon.plan.modelo.GluoPrograma;
import com.vortexbird.gluon.plan.modelo.GluoProyecto;
import com.vortexbird.gluon.plan.modelo.GluoSectorEjeDimension;
import com.vortexbird.gluon.plan.modelo.GluoSubprograma;
import com.vortexbird.gluon.plan.modelo.GluoTipoRecurso;
import com.vortexbird.gluon.plan.modelo.SegOpcion;
import com.vortexbird.gluon.plan.modelo.SegPermiso;
import com.vortexbird.gluon.plan.modelo.SegRol;
import com.vortexbird.gluon.plan.modelo.SegRolUsuario;
import com.vortexbird.gluon.plan.modelo.SegUsuario;
import com.vortexbird.gluon.plan.modelo.control.GluoAnoFiscalLogic;
import com.vortexbird.gluon.plan.modelo.control.GluoDetallePresupuestoLogic;
import com.vortexbird.gluon.plan.modelo.control.GluoDetalleProyectoLogic;
import com.vortexbird.gluon.plan.modelo.control.GluoDetalleProyectoXRubroLogic;
import com.vortexbird.gluon.plan.modelo.control.GluoHistorialIndicadorLogic;
import com.vortexbird.gluon.plan.modelo.control.GluoIndicadorLogic;
import com.vortexbird.gluon.plan.modelo.control.GluoObjetivoLogic;
import com.vortexbird.gluon.plan.modelo.control.GluoPlanDesarrolloLogic;
import com.vortexbird.gluon.plan.modelo.control.GluoPresupuestoLogic;
import com.vortexbird.gluon.plan.modelo.control.GluoProgramaLogic;
import com.vortexbird.gluon.plan.modelo.control.GluoProyectoLogic;
import com.vortexbird.gluon.plan.modelo.control.GluoSectorEjeDimensionLogic;
import com.vortexbird.gluon.plan.modelo.control.GluoSubprogramaLogic;
import com.vortexbird.gluon.plan.modelo.control.GluoTipoRecursoLogic;
import com.vortexbird.gluon.plan.modelo.control.IGluoAnoFiscalLogic;
import com.vortexbird.gluon.plan.modelo.control.IGluoDetallePresupuestoLogic;
import com.vortexbird.gluon.plan.modelo.control.IGluoDetalleProyectoLogic;
import com.vortexbird.gluon.plan.modelo.control.IGluoDetalleProyectoXRubroLogic;
import com.vortexbird.gluon.plan.modelo.control.IGluoHistorialIndicadorLogic;
import com.vortexbird.gluon.plan.modelo.control.IGluoIndicadorLogic;
import com.vortexbird.gluon.plan.modelo.control.IGluoObjetivoLogic;
import com.vortexbird.gluon.plan.modelo.control.IGluoPlanDesarrolloLogic;
import com.vortexbird.gluon.plan.modelo.control.IGluoPresupuestoLogic;
import com.vortexbird.gluon.plan.modelo.control.IGluoProgramaLogic;
import com.vortexbird.gluon.plan.modelo.control.IGluoProyectoLogic;
import com.vortexbird.gluon.plan.modelo.control.IGluoSectorEjeDimensionLogic;
import com.vortexbird.gluon.plan.modelo.control.IGluoSubprogramaLogic;
import com.vortexbird.gluon.plan.modelo.control.IGluoTipoRecursoLogic;
import com.vortexbird.gluon.plan.modelo.control.ISegOpcionLogic;
import com.vortexbird.gluon.plan.modelo.control.ISegPermisoLogic;
import com.vortexbird.gluon.plan.modelo.control.ISegRolLogic;
import com.vortexbird.gluon.plan.modelo.control.ISegRolUsuarioLogic;
import com.vortexbird.gluon.plan.modelo.control.ISegUsuarioLogic;
import com.vortexbird.gluon.plan.modelo.control.SegOpcionLogic;
import com.vortexbird.gluon.plan.modelo.control.SegPermisoLogic;
import com.vortexbird.gluon.plan.modelo.control.SegRolLogic;
import com.vortexbird.gluon.plan.modelo.control.SegRolUsuarioLogic;
import com.vortexbird.gluon.plan.modelo.control.SegUsuarioLogic;
import com.vortexbird.gluon.plan.modelo.dto.GluoAnoFiscalDTO;
import com.vortexbird.gluon.plan.modelo.dto.GluoDetallePresupuestoDTO;
import com.vortexbird.gluon.plan.modelo.dto.GluoDetalleProyectoDTO;
import com.vortexbird.gluon.plan.modelo.dto.GluoDetalleProyectoXRubroDTO;
import com.vortexbird.gluon.plan.modelo.dto.GluoHistorialIndicadorDTO;
import com.vortexbird.gluon.plan.modelo.dto.GluoIndicadorDTO;
import com.vortexbird.gluon.plan.modelo.dto.GluoObjetivoDTO;
import com.vortexbird.gluon.plan.modelo.dto.GluoPlanDesarrolloDTO;
import com.vortexbird.gluon.plan.modelo.dto.GluoPresupuestoDTO;
import com.vortexbird.gluon.plan.modelo.dto.GluoProgramaDTO;
import com.vortexbird.gluon.plan.modelo.dto.GluoProyectoDTO;
import com.vortexbird.gluon.plan.modelo.dto.GluoSectorEjeDimensionDTO;
import com.vortexbird.gluon.plan.modelo.dto.GluoSubprogramaDTO;
import com.vortexbird.gluon.plan.modelo.dto.GluoTipoRecursoDTO;
import com.vortexbird.gluon.plan.modelo.dto.SegOpcionDTO;
import com.vortexbird.gluon.plan.modelo.dto.SegPermisoDTO;
import com.vortexbird.gluon.plan.modelo.dto.SegRolDTO;
import com.vortexbird.gluon.plan.modelo.dto.SegRolUsuarioDTO;
import com.vortexbird.gluon.plan.modelo.dto.SegUsuarioDTO;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface IBusinessDelegatorView {
	
    public List<GluoPlanDesarrollo> consultarTodoPlanDesarrollo() throws Exception;

	public List<GluoAnoFiscal> getGluoAnoFiscal() throws Exception;

    public void saveGluoAnoFiscal(GluoAnoFiscal entity)
        throws Exception;

    public void deleteGluoAnoFiscal(GluoAnoFiscal entity)
        throws Exception;

    public void updateGluoAnoFiscal(GluoAnoFiscal entity)
        throws Exception;

    public GluoAnoFiscal getGluoAnoFiscal(Integer anofId)
        throws Exception;

    public List<GluoAnoFiscal> findByCriteriaInGluoAnoFiscal(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<GluoAnoFiscal> findPageGluoAnoFiscal(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberGluoAnoFiscal() throws Exception;

    public List<GluoAnoFiscalDTO> getDataGluoAnoFiscal()
        throws Exception;

    public void validateGluoAnoFiscal(GluoAnoFiscal gluoAnoFiscal)
        throws Exception;

    public List<GluoDetallePresupuesto> getGluoDetallePresupuesto()
        throws Exception;

    public void saveGluoDetallePresupuesto(GluoDetallePresupuesto entity)
        throws Exception;

    public void deleteGluoDetallePresupuesto(GluoDetallePresupuesto entity)
        throws Exception;

    public void updateGluoDetallePresupuesto(GluoDetallePresupuesto entity)
        throws Exception;

    public GluoDetallePresupuesto getGluoDetallePresupuesto(Integer dptoId)
        throws Exception;

    public List<GluoDetallePresupuesto> findByCriteriaInGluoDetallePresupuesto(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<GluoDetallePresupuesto> findPageGluoDetallePresupuesto(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberGluoDetallePresupuesto()
        throws Exception;

    public List<GluoDetallePresupuestoDTO> getDataGluoDetallePresupuesto()
        throws Exception;

    public void validateGluoDetallePresupuesto(
        GluoDetallePresupuesto gluoDetallePresupuesto)
        throws Exception;

    public List<GluoDetalleProyecto> getGluoDetalleProyecto()
        throws Exception;

    public void saveGluoDetalleProyecto(GluoDetalleProyecto entity)
        throws Exception;

    public void deleteGluoDetalleProyecto(GluoDetalleProyecto entity)
        throws Exception;

    public void updateGluoDetalleProyecto(GluoDetalleProyecto entity)
        throws Exception;

    public GluoDetalleProyecto getGluoDetalleProyecto(Integer dproId)
        throws Exception;

    public List<GluoDetalleProyecto> findByCriteriaInGluoDetalleProyecto(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<GluoDetalleProyecto> findPageGluoDetalleProyecto(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberGluoDetalleProyecto() throws Exception;

    public List<GluoDetalleProyectoDTO> getDataGluoDetalleProyecto()
        throws Exception;

    public void validateGluoDetalleProyecto(
        GluoDetalleProyecto gluoDetalleProyecto) throws Exception;

    public List<GluoDetalleProyectoXRubro> getGluoDetalleProyectoXRubro()
        throws Exception;

    public void saveGluoDetalleProyectoXRubro(GluoDetalleProyectoXRubro entity)
        throws Exception;

    public void deleteGluoDetalleProyectoXRubro(
        GluoDetalleProyectoXRubro entity) throws Exception;

    public void updateGluoDetalleProyectoXRubro(
        GluoDetalleProyectoXRubro entity) throws Exception;

    public GluoDetalleProyectoXRubro getGluoDetalleProyectoXRubro(
        Integer dpruId) throws Exception;

    public List<GluoDetalleProyectoXRubro> findByCriteriaInGluoDetalleProyectoXRubro(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<GluoDetalleProyectoXRubro> findPageGluoDetalleProyectoXRubro(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberGluoDetalleProyectoXRubro()
        throws Exception;

    public List<GluoDetalleProyectoXRubroDTO> getDataGluoDetalleProyectoXRubro()
        throws Exception;

    public void validateGluoDetalleProyectoXRubro(
        GluoDetalleProyectoXRubro gluoDetalleProyectoXRubro)
        throws Exception;

    public List<GluoHistorialIndicador> getGluoHistorialIndicador()
        throws Exception;

    public void saveGluoHistorialIndicador(GluoHistorialIndicador entity)
        throws Exception;

    public void deleteGluoHistorialIndicador(GluoHistorialIndicador entity)
        throws Exception;

    public void updateGluoHistorialIndicador(GluoHistorialIndicador entity)
        throws Exception;

    public GluoHistorialIndicador getGluoHistorialIndicador(Integer hiinId)
        throws Exception;

    public List<GluoHistorialIndicador> findByCriteriaInGluoHistorialIndicador(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<GluoHistorialIndicador> findPageGluoHistorialIndicador(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberGluoHistorialIndicador()
        throws Exception;

    public List<GluoHistorialIndicadorDTO> getDataGluoHistorialIndicador()
        throws Exception;

    public void validateGluoHistorialIndicador(
        GluoHistorialIndicador gluoHistorialIndicador)
        throws Exception;

    public List<GluoIndicador> getGluoIndicador() throws Exception;

    public void saveGluoIndicador(GluoIndicador entity)
        throws Exception;

    public void deleteGluoIndicador(GluoIndicador entity)
        throws Exception;

    public void updateGluoIndicador(GluoIndicador entity)
        throws Exception;

    public GluoIndicador getGluoIndicador(Integer indiId)
        throws Exception;

    public List<GluoIndicador> findByCriteriaInGluoIndicador(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<GluoIndicador> findPageGluoIndicador(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberGluoIndicador() throws Exception;

    public List<GluoIndicadorDTO> getDataGluoIndicador()
        throws Exception;

    public void validateGluoIndicador(GluoIndicador gluoIndicador)
        throws Exception;

    public List<GluoObjetivo> getGluoObjetivo() throws Exception;

    public void saveGluoObjetivo(GluoObjetivo entity) throws Exception;

    public void deleteGluoObjetivo(GluoObjetivo entity)
        throws Exception;

    public void updateGluoObjetivo(GluoObjetivo entity)
        throws Exception;

    public GluoObjetivo getGluoObjetivo(Integer objeId)
        throws Exception;

    public List<GluoObjetivo> findByCriteriaInGluoObjetivo(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<GluoObjetivo> findPageGluoObjetivo(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberGluoObjetivo() throws Exception;

    public List<GluoObjetivoDTO> getDataGluoObjetivo()
        throws Exception;

    public void validateGluoObjetivo(GluoObjetivo gluoObjetivo)
        throws Exception;

    public List<GluoPlanDesarrollo> getGluoPlanDesarrollo()
        throws Exception;

    public void saveGluoPlanDesarrollo(GluoPlanDesarrollo entity)
        throws Exception;

    public void deleteGluoPlanDesarrollo(GluoPlanDesarrollo entity)
        throws Exception;

    public void updateGluoPlanDesarrollo(GluoPlanDesarrollo entity)
        throws Exception;

    public GluoPlanDesarrollo getGluoPlanDesarrollo(Integer planId)
        throws Exception;

    public List<GluoPlanDesarrollo> findByCriteriaInGluoPlanDesarrollo(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<GluoPlanDesarrollo> findPageGluoPlanDesarrollo(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberGluoPlanDesarrollo() throws Exception;

    public List<GluoPlanDesarrolloDTO> getDataGluoPlanDesarrollo()
        throws Exception;

    public void validateGluoPlanDesarrollo(
        GluoPlanDesarrollo gluoPlanDesarrollo) throws Exception;

    public List<GluoPresupuesto> getGluoPresupuesto() throws Exception;

    public void saveGluoPresupuesto(GluoPresupuesto entity)
        throws Exception;

    public void deleteGluoPresupuesto(GluoPresupuesto entity)
        throws Exception;

    public void updateGluoPresupuesto(GluoPresupuesto entity)
        throws Exception;

    public GluoPresupuesto getGluoPresupuesto(Integer pptoId)
        throws Exception;

    public List<GluoPresupuesto> findByCriteriaInGluoPresupuesto(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<GluoPresupuesto> findPageGluoPresupuesto(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberGluoPresupuesto() throws Exception;

    public List<GluoPresupuestoDTO> getDataGluoPresupuesto()
        throws Exception;

    public void validateGluoPresupuesto(GluoPresupuesto gluoPresupuesto)
        throws Exception;

    public List<GluoPrograma> getGluoPrograma() throws Exception;

    public void saveGluoPrograma(GluoPrograma entity) throws Exception;

    public void deleteGluoPrograma(GluoPrograma entity)
        throws Exception;

    public void updateGluoPrograma(GluoPrograma entity)
        throws Exception;

    public GluoPrograma getGluoPrograma(Integer progId)
        throws Exception;

    public List<GluoPrograma> findByCriteriaInGluoPrograma(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<GluoPrograma> findPageGluoPrograma(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberGluoPrograma() throws Exception;

    public List<GluoProgramaDTO> getDataGluoPrograma()
        throws Exception;

    public void validateGluoPrograma(GluoPrograma gluoPrograma)
        throws Exception;

    public List<GluoProyecto> getGluoProyecto() throws Exception;
    
   

    public void saveGluoProyecto(GluoProyecto entity) throws Exception;

    public void deleteGluoProyecto(GluoProyecto entity)
        throws Exception;

    public void updateGluoProyecto(GluoProyecto entity)
        throws Exception;

    public GluoProyecto getGluoProyecto(Integer proyId)
        throws Exception;

    public List<GluoProyecto> findByCriteriaInGluoProyecto(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<GluoProyecto> findPageGluoProyecto(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberGluoProyecto() throws Exception;

    public List<GluoProyectoDTO> getDataGluoProyecto()
        throws Exception;

    public void validateGluoProyecto(GluoProyecto gluoProyecto)
        throws Exception;

    public List<GluoSectorEjeDimension> getGluoSectorEjeDimension()
        throws Exception;

    public void saveGluoSectorEjeDimension(GluoSectorEjeDimension entity)
        throws Exception;

    public void deleteGluoSectorEjeDimension(GluoSectorEjeDimension entity)
        throws Exception;

    public void updateGluoSectorEjeDimension(GluoSectorEjeDimension entity)
        throws Exception;

    public GluoSectorEjeDimension getGluoSectorEjeDimension(Integer sediId)
        throws Exception;

    public List<GluoSectorEjeDimension> findByCriteriaInGluoSectorEjeDimension(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<GluoSectorEjeDimension> findPageGluoSectorEjeDimension(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberGluoSectorEjeDimension()
        throws Exception;

    public List<GluoSectorEjeDimensionDTO> getDataGluoSectorEjeDimension()
        throws Exception;

    public void validateGluoSectorEjeDimension(
        GluoSectorEjeDimension gluoSectorEjeDimension)
        throws Exception;

    public List<GluoSubprograma> getGluoSubprograma() throws Exception;

    public void saveGluoSubprograma(GluoSubprograma entity)
        throws Exception;

    public void deleteGluoSubprograma(GluoSubprograma entity)
        throws Exception;

    public void updateGluoSubprograma(GluoSubprograma entity)
        throws Exception;

    public GluoSubprograma getGluoSubprograma(Integer subpId)
        throws Exception;

    public List<GluoSubprograma> findByCriteriaInGluoSubprograma(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<GluoSubprograma> findPageGluoSubprograma(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberGluoSubprograma() throws Exception;

    public List<GluoSubprogramaDTO> getDataGluoSubprograma()
        throws Exception;

    public void validateGluoSubprograma(GluoSubprograma gluoSubprograma)
        throws Exception;

    public List<GluoTipoRecurso> getGluoTipoRecurso() throws Exception;

    public void saveGluoTipoRecurso(GluoTipoRecurso entity)
        throws Exception;

    public void deleteGluoTipoRecurso(GluoTipoRecurso entity)
        throws Exception;

    public void updateGluoTipoRecurso(GluoTipoRecurso entity)
        throws Exception;

    public GluoTipoRecurso getGluoTipoRecurso(Integer tireId)
        throws Exception;

    public List<GluoTipoRecurso> findByCriteriaInGluoTipoRecurso(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<GluoTipoRecurso> findPageGluoTipoRecurso(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberGluoTipoRecurso() throws Exception;

    public List<GluoTipoRecursoDTO> getDataGluoTipoRecurso()
        throws Exception;

    public void validateGluoTipoRecurso(GluoTipoRecurso gluoTipoRecurso)
        throws Exception;

    public List<SegOpcion> getSegOpcion() throws Exception;

    public void saveSegOpcion(SegOpcion entity) throws Exception;

    public void deleteSegOpcion(SegOpcion entity) throws Exception;

    public void updateSegOpcion(SegOpcion entity) throws Exception;

    public SegOpcion getSegOpcion(Integer opcnId) throws Exception;

    public List<SegOpcion> findByCriteriaInSegOpcion(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<SegOpcion> findPageSegOpcion(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberSegOpcion() throws Exception;

    public List<SegOpcionDTO> getDataSegOpcion() throws Exception;

    public void validateSegOpcion(SegOpcion segOpcion)
        throws Exception;

    public List<SegPermiso> getSegPermiso() throws Exception;

    public void saveSegPermiso(SegPermiso entity) throws Exception;

    public void deleteSegPermiso(SegPermiso entity) throws Exception;

    public void updateSegPermiso(SegPermiso entity) throws Exception;

    public SegPermiso getSegPermiso(Integer permId) throws Exception;

    public List<SegPermiso> findByCriteriaInSegPermiso(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<SegPermiso> findPageSegPermiso(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberSegPermiso() throws Exception;

    public List<SegPermisoDTO> getDataSegPermiso() throws Exception;

    public void validateSegPermiso(SegPermiso segPermiso)
        throws Exception;

    public List<SegRol> getSegRol() throws Exception;

    public void saveSegRol(SegRol entity) throws Exception;

    public void deleteSegRol(SegRol entity) throws Exception;

    public void updateSegRol(SegRol entity) throws Exception;

    public SegRol getSegRol(Integer rolId) throws Exception;

    public List<SegRol> findByCriteriaInSegRol(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<SegRol> findPageSegRol(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberSegRol() throws Exception;

    public List<SegRolDTO> getDataSegRol() throws Exception;

    public void validateSegRol(SegRol segRol) throws Exception;

    public List<SegRolUsuario> getSegRolUsuario() throws Exception;

    public void saveSegRolUsuario(SegRolUsuario entity)
        throws Exception;

    public void deleteSegRolUsuario(SegRolUsuario entity)
        throws Exception;

    public void updateSegRolUsuario(SegRolUsuario entity)
        throws Exception;

    public SegRolUsuario getSegRolUsuario(Integer rlusId)
        throws Exception;

    public List<SegRolUsuario> findByCriteriaInSegRolUsuario(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<SegRolUsuario> findPageSegRolUsuario(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberSegRolUsuario() throws Exception;

    public List<SegRolUsuarioDTO> getDataSegRolUsuario()
        throws Exception;

    public void validateSegRolUsuario(SegRolUsuario segRolUsuario)
        throws Exception;

    public List<SegUsuario> getSegUsuario() throws Exception;

    public void saveSegUsuario(SegUsuario entity) throws Exception;

    public void deleteSegUsuario(SegUsuario entity) throws Exception;

    public void updateSegUsuario(SegUsuario entity) throws Exception;

    public SegUsuario getSegUsuario(Integer usuId) throws Exception;

    public List<SegUsuario> findByCriteriaInSegUsuario(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<SegUsuario> findPageSegUsuario(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberSegUsuario() throws Exception;

    public List<SegUsuarioDTO> getDataSegUsuario() throws Exception;

    public void validateSegUsuario(SegUsuario segUsuario)
        throws Exception;

	public void crearGluoPlanDesarrollo(GluoPlanDesarrolloDTO gluoPlanDesarrolloDTO) throws Exception;
	
	public SegUsuario validarUsuario(String usuLogin, String password) throws Exception;
	
	public SegRolUsuario obtenerIdRolUsuario(Integer id) throws Exception;

	public List<GluoObjetivo> consultarTodoObjetivo() throws Exception;
}
