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
import com.vortexbird.gluon.plan.presentation.businessDelegate.IBusinessDelegatorView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import java.sql.*;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* Use a Business Delegate to reduce coupling between presentation-tier clients and business services.
* The Business Delegate hides the underlying implementation details of the business service, such as lookup and access details of the EJB architecture.
*
* The Business Delegate acts as a client-side business abstraction; it provides an abstraction for, and thus hides,
* the implementation of the business services. Using a Business Delegate reduces the coupling between presentation-tier clients and
* the system's business services. Depending on the implementation strategy, the Business Delegate may shield clients from possible
* volatility in the implementation of the business service API. Potentially, this reduces the number of changes that must be made to the
* presentation-tier client code when the business service API or its underlying implementation changes.
*
* However, interface methods in the Business Delegate may still require modification if the underlying business service API changes.
* Admittedly, though, it is more likely that changes will be made to the business service rather than to the Business Delegate.
*
* Often, developers are skeptical when a design goal such as abstracting the business layer causes additional upfront work in return
* for future gains. However, using this pattern or its strategies results in only a small amount of additional upfront work and provides
* considerable benefits. The main benefit is hiding the details of the underlying service. For example, the client can become transparent
* to naming and lookup services. The Business Delegate also handles the exceptions from the business services, such as java.rmi.Remote
* exceptions, Java Messages Service (JMS) exceptions and so on. The Business Delegate may intercept such service level exceptions and
* generate application level exceptions instead. Application level exceptions are easier to handle by the clients, and may be user friendly.
* The Business Delegate may also transparently perform any retry or recovery operations necessary in the event of a service failure without
* exposing the client to the problem until it is determined that the problem is not resolvable. These gains present a compelling reason to
* use the pattern.
*
* Another benefit is that the delegate may cache results and references to remote business services. Caching can significantly improve performance,
* because it limits unnecessary and potentially costly round trips over the network.
*
* A Business Delegate uses a component called the Lookup Service. The Lookup Service is responsible for hiding the underlying implementation
* details of the business service lookup code. The Lookup Service may be written as part of the Delegate, but we recommend that it be
* implemented as a separate component, as outlined in the Service Locator pattern (See "Service Locator" on page 368.)
*
* When the Business Delegate is used with a Session Facade, typically there is a one-to-one relationship between the two.
* This one-to-one relationship exists because logic that might have been encapsulated in a Business Delegate relating to its interaction
* with multiple business services (creating a one-to-many relationship) will often be factored back into a Session Facade.
*
* Finally, it should be noted that this pattern could be used to reduce coupling between other tiers, not simply the presentation and the
* business tiers.
*
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("BusinessDelegatorView")
public class BusinessDelegatorView implements IBusinessDelegatorView {
    private static final Logger log = LoggerFactory.getLogger(BusinessDelegatorView.class);
    @Autowired
    private IGluoAnoFiscalLogic gluoAnoFiscalLogic;
    @Autowired
    private IGluoDetallePresupuestoLogic gluoDetallePresupuestoLogic;
    @Autowired
    private IGluoDetalleProyectoLogic gluoDetalleProyectoLogic;
    @Autowired
    private IGluoDetalleProyectoXRubroLogic gluoDetalleProyectoXRubroLogic;
    @Autowired
    private IGluoHistorialIndicadorLogic gluoHistorialIndicadorLogic;
    @Autowired
    private IGluoIndicadorLogic gluoIndicadorLogic;
    @Autowired
    private IGluoObjetivoLogic gluoObjetivoLogic;
    @Autowired
    private IGluoPlanDesarrolloLogic gluoPlanDesarrolloLogic;
    @Autowired
    private IGluoPresupuestoLogic gluoPresupuestoLogic;
    @Autowired
    private IGluoProgramaLogic gluoProgramaLogic;
    @Autowired
    private IGluoProyectoLogic gluoProyectoLogic;
    @Autowired
    private IGluoSectorEjeDimensionLogic gluoSectorEjeDimensionLogic;
    @Autowired
    private IGluoSubprogramaLogic gluoSubprogramaLogic;
    @Autowired
    private IGluoTipoRecursoLogic gluoTipoRecursoLogic;
    @Autowired
    private ISegOpcionLogic segOpcionLogic;
    @Autowired
    private ISegPermisoLogic segPermisoLogic;
    @Autowired
    private ISegRolLogic segRolLogic;
    @Autowired
    private ISegRolUsuarioLogic segRolUsuarioLogic;
    @Autowired
    private ISegUsuarioLogic segUsuarioLogic;

    public List<GluoAnoFiscal> getGluoAnoFiscal() throws Exception {
        return gluoAnoFiscalLogic.getGluoAnoFiscal();
    }

    public void saveGluoAnoFiscal(GluoAnoFiscal entity)
        throws Exception {
        gluoAnoFiscalLogic.saveGluoAnoFiscal(entity);
    }

    public void deleteGluoAnoFiscal(GluoAnoFiscal entity)
        throws Exception {
        gluoAnoFiscalLogic.deleteGluoAnoFiscal(entity);
    }

    public void updateGluoAnoFiscal(GluoAnoFiscal entity)
        throws Exception {
        gluoAnoFiscalLogic.updateGluoAnoFiscal(entity);
    }

    public GluoAnoFiscal getGluoAnoFiscal(Integer anofId)
        throws Exception {
        GluoAnoFiscal gluoAnoFiscal = null;

        try {
            gluoAnoFiscal = gluoAnoFiscalLogic.getGluoAnoFiscal(anofId);
        } catch (Exception e) {
            throw e;
        }

        return gluoAnoFiscal;
    }
    
 public List <GluoAnoFiscal> findAnoFiscalActivo()throws Exception{
    	
    	return gluoAnoFiscalLogic.findAnoFiscalActivo();
    	
    	
    }

    public List<GluoAnoFiscal> findByCriteriaInGluoAnoFiscal(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return gluoAnoFiscalLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<GluoAnoFiscal> findPageGluoAnoFiscal(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return gluoAnoFiscalLogic.findPageGluoAnoFiscal(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberGluoAnoFiscal() throws Exception {
        return gluoAnoFiscalLogic.findTotalNumberGluoAnoFiscal();
    }

    public List<GluoAnoFiscalDTO> getDataGluoAnoFiscal()
        throws Exception {
        return gluoAnoFiscalLogic.getDataGluoAnoFiscal();
    }

    public void validateGluoAnoFiscal(GluoAnoFiscal gluoAnoFiscal)
        throws Exception {
        gluoAnoFiscalLogic.validateGluoAnoFiscal(gluoAnoFiscal);
    }

    public List<GluoDetallePresupuesto> getGluoDetallePresupuesto()
        throws Exception {
        return gluoDetallePresupuestoLogic.getGluoDetallePresupuesto();
    }

    public void saveGluoDetallePresupuesto(GluoDetallePresupuesto entity)
        throws Exception {
        gluoDetallePresupuestoLogic.saveGluoDetallePresupuesto(entity);
    }

    public void deleteGluoDetallePresupuesto(GluoDetallePresupuesto entity)
        throws Exception {
        gluoDetallePresupuestoLogic.deleteGluoDetallePresupuesto(entity);
    }

    public void updateGluoDetallePresupuesto(GluoDetallePresupuesto entity)
        throws Exception {
        gluoDetallePresupuestoLogic.updateGluoDetallePresupuesto(entity);
    }

    public GluoDetallePresupuesto getGluoDetallePresupuesto(Integer dptoId)
        throws Exception {
        GluoDetallePresupuesto gluoDetallePresupuesto = null;

        try {
            gluoDetallePresupuesto = gluoDetallePresupuestoLogic.getGluoDetallePresupuesto(dptoId);
        } catch (Exception e) {
            throw e;
        }

        return gluoDetallePresupuesto;
    }

    public List<GluoDetallePresupuesto> findByCriteriaInGluoDetallePresupuesto(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return gluoDetallePresupuestoLogic.findByCriteria(variables,
            variablesBetween, variablesBetweenDates);
    }

    public List<GluoDetallePresupuesto> findPageGluoDetallePresupuesto(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        return gluoDetallePresupuestoLogic.findPageGluoDetallePresupuesto(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberGluoDetallePresupuesto()
        throws Exception {
        return gluoDetallePresupuestoLogic.findTotalNumberGluoDetallePresupuesto();
    }

    public List<GluoDetallePresupuestoDTO> getDataGluoDetallePresupuesto()
        throws Exception {
        return gluoDetallePresupuestoLogic.getDataGluoDetallePresupuesto();
    }

    public void validateGluoDetallePresupuesto(
        GluoDetallePresupuesto gluoDetallePresupuesto)
        throws Exception {
        gluoDetallePresupuestoLogic.validateGluoDetallePresupuesto(gluoDetallePresupuesto);
    }

    public List<GluoDetalleProyecto> getGluoDetalleProyecto()
        throws Exception {
        return gluoDetalleProyectoLogic.getGluoDetalleProyecto();
    }

    public void saveGluoDetalleProyecto(GluoDetalleProyecto entity)
        throws Exception {
        gluoDetalleProyectoLogic.saveGluoDetalleProyecto(entity);
    }

    public void deleteGluoDetalleProyecto(GluoDetalleProyecto entity)
        throws Exception {
        gluoDetalleProyectoLogic.deleteGluoDetalleProyecto(entity);
    }

    public void updateGluoDetalleProyecto(GluoDetalleProyecto entity)
        throws Exception {
        gluoDetalleProyectoLogic.updateGluoDetalleProyecto(entity);
    }

    public GluoDetalleProyecto getGluoDetalleProyecto(Integer dproId)
        throws Exception {
        GluoDetalleProyecto gluoDetalleProyecto = null;

        try {
            gluoDetalleProyecto = gluoDetalleProyectoLogic.getGluoDetalleProyecto(dproId);
        } catch (Exception e) {
            throw e;
        }

        return gluoDetalleProyecto;
    }
    
 public List <GluoDetalleProyecto> findDetalleProyectoActivo()throws Exception{
    	
    	return gluoDetalleProyectoLogic.findDetalleProyectoActivo();
    	
    	
    }

    public List<GluoDetalleProyecto> findByCriteriaInGluoDetalleProyecto(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return gluoDetalleProyectoLogic.findByCriteria(variables,
            variablesBetween, variablesBetweenDates);
    }

    public List<GluoDetalleProyecto> findPageGluoDetalleProyecto(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        return gluoDetalleProyectoLogic.findPageGluoDetalleProyecto(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberGluoDetalleProyecto() throws Exception {
        return gluoDetalleProyectoLogic.findTotalNumberGluoDetalleProyecto();
    }

    public List<GluoDetalleProyectoDTO> getDataGluoDetalleProyecto()
        throws Exception {
        return gluoDetalleProyectoLogic.getDataGluoDetalleProyecto();
    }

    public void validateGluoDetalleProyecto(
        GluoDetalleProyecto gluoDetalleProyecto) throws Exception {
        gluoDetalleProyectoLogic.validateGluoDetalleProyecto(gluoDetalleProyecto);
    }

    public List<GluoDetalleProyectoXRubro> getGluoDetalleProyectoXRubro()
        throws Exception {
        return gluoDetalleProyectoXRubroLogic.getGluoDetalleProyectoXRubro();
    }

    public void saveGluoDetalleProyectoXRubro(GluoDetalleProyectoXRubro entity)
        throws Exception {
        gluoDetalleProyectoXRubroLogic.saveGluoDetalleProyectoXRubro(entity);
    }

    public void deleteGluoDetalleProyectoXRubro(
        GluoDetalleProyectoXRubro entity) throws Exception {
        gluoDetalleProyectoXRubroLogic.deleteGluoDetalleProyectoXRubro(entity);
    }

    public void updateGluoDetalleProyectoXRubro(
        GluoDetalleProyectoXRubro entity) throws Exception {
        gluoDetalleProyectoXRubroLogic.updateGluoDetalleProyectoXRubro(entity);
    }

    public GluoDetalleProyectoXRubro getGluoDetalleProyectoXRubro(
        Integer dpruId) throws Exception {
        GluoDetalleProyectoXRubro gluoDetalleProyectoXRubro = null;

        try {
            gluoDetalleProyectoXRubro = gluoDetalleProyectoXRubroLogic.getGluoDetalleProyectoXRubro(dpruId);
        } catch (Exception e) {
            throw e;
        }

        return gluoDetalleProyectoXRubro;
    }

    public List<GluoDetalleProyectoXRubro> findByCriteriaInGluoDetalleProyectoXRubro(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return gluoDetalleProyectoXRubroLogic.findByCriteria(variables,
            variablesBetween, variablesBetweenDates);
    }

    public List<GluoDetalleProyectoXRubro> findPageGluoDetalleProyectoXRubro(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        return gluoDetalleProyectoXRubroLogic.findPageGluoDetalleProyectoXRubro(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberGluoDetalleProyectoXRubro()
        throws Exception {
        return gluoDetalleProyectoXRubroLogic.findTotalNumberGluoDetalleProyectoXRubro();
    }

    public List<GluoDetalleProyectoXRubroDTO> getDataGluoDetalleProyectoXRubro()
        throws Exception {
        return gluoDetalleProyectoXRubroLogic.getDataGluoDetalleProyectoXRubro();
    }

    public void validateGluoDetalleProyectoXRubro(
        GluoDetalleProyectoXRubro gluoDetalleProyectoXRubro)
        throws Exception {
        gluoDetalleProyectoXRubroLogic.validateGluoDetalleProyectoXRubro(gluoDetalleProyectoXRubro);
    }

    public List<GluoHistorialIndicador> getGluoHistorialIndicador()
        throws Exception {
        return gluoHistorialIndicadorLogic.getGluoHistorialIndicador();
    }
    
    
	public List<GluoHistorialIndicador> findHistorialIndicadorActivo() throws Exception {
		
		return gluoHistorialIndicadorLogic.findHistorialIndicadorActivo();
	}

    public void saveGluoHistorialIndicador(GluoHistorialIndicador entity)
        throws Exception {
        gluoHistorialIndicadorLogic.saveGluoHistorialIndicador(entity);
    }

    public void deleteGluoHistorialIndicador(GluoHistorialIndicador entity)
        throws Exception {
        gluoHistorialIndicadorLogic.deleteGluoHistorialIndicador(entity);
    }

    public void updateGluoHistorialIndicador(GluoHistorialIndicador entity)
        throws Exception {
        gluoHistorialIndicadorLogic.updateGluoHistorialIndicador(entity);
    }

    public GluoHistorialIndicador getGluoHistorialIndicador(Integer hiinId)
        throws Exception {
        GluoHistorialIndicador gluoHistorialIndicador = null;

        try {
            gluoHistorialIndicador = gluoHistorialIndicadorLogic.getGluoHistorialIndicador(hiinId);
        } catch (Exception e) {
            throw e;
        }

        return gluoHistorialIndicador;
    }

    public List<GluoHistorialIndicador> findByCriteriaInGluoHistorialIndicador(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return gluoHistorialIndicadorLogic.findByCriteria(variables,
            variablesBetween, variablesBetweenDates);
    }

    public List<GluoHistorialIndicador> findPageGluoHistorialIndicador(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        return gluoHistorialIndicadorLogic.findPageGluoHistorialIndicador(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberGluoHistorialIndicador()
        throws Exception {
        return gluoHistorialIndicadorLogic.findTotalNumberGluoHistorialIndicador();
    }

    public List<GluoHistorialIndicadorDTO> getDataGluoHistorialIndicador()
        throws Exception {
        return gluoHistorialIndicadorLogic.getDataGluoHistorialIndicador();
    }

    public void validateGluoHistorialIndicador(
        GluoHistorialIndicador gluoHistorialIndicador)
        throws Exception {
        gluoHistorialIndicadorLogic.validateGluoHistorialIndicador(gluoHistorialIndicador);
    }

    public List<GluoIndicador> getGluoIndicador() throws Exception {
        return gluoIndicadorLogic.getGluoIndicador();
    }
    
   
	public List<GluoIndicador> findIndicadorActivo() throws Exception {
	       return gluoIndicadorLogic.findIndicadorActivo();
	}

    public void saveGluoIndicador(GluoIndicador entity)
        throws Exception {
        gluoIndicadorLogic.saveGluoIndicador(entity);
    }

    public void deleteGluoIndicador(GluoIndicador entity)
        throws Exception {
        gluoIndicadorLogic.deleteGluoIndicador(entity);
    }

    public void updateGluoIndicador(GluoIndicador entity)
        throws Exception {
        gluoIndicadorLogic.updateGluoIndicador(entity);
    }

    public GluoIndicador getGluoIndicador(Integer indiId)
        throws Exception {
        GluoIndicador gluoIndicador = null;

        try {
            gluoIndicador = gluoIndicadorLogic.getGluoIndicador(indiId);
        } catch (Exception e) {
            throw e;
        }

        return gluoIndicador;
    }

    public List<GluoIndicador> findByCriteriaInGluoIndicador(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return gluoIndicadorLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<GluoIndicador> findPageGluoIndicador(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return gluoIndicadorLogic.findPageGluoIndicador(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberGluoIndicador() throws Exception {
        return gluoIndicadorLogic.findTotalNumberGluoIndicador();
    }

    public List<GluoIndicadorDTO> getDataGluoIndicador()
        throws Exception {
        return gluoIndicadorLogic.getDataGluoIndicador();
    }

    public void validateGluoIndicador(GluoIndicador gluoIndicador)
        throws Exception {
        gluoIndicadorLogic.validateGluoIndicador(gluoIndicador);
    }

    public List<GluoObjetivo> getGluoObjetivo() throws Exception {
        return gluoObjetivoLogic.getGluoObjetivo();
    }

    public void saveGluoObjetivo(GluoObjetivo entity) throws Exception {
        gluoObjetivoLogic.saveGluoObjetivo(entity);
    }

    public void deleteGluoObjetivo(GluoObjetivo entity)
        throws Exception {
        gluoObjetivoLogic.deleteGluoObjetivo(entity);
    }

    public void updateGluoObjetivo(GluoObjetivo entity)
        throws Exception {
        gluoObjetivoLogic.updateGluoObjetivo(entity);
    }

    public GluoObjetivo getGluoObjetivo(Integer objeId)
        throws Exception {
        GluoObjetivo gluoObjetivo = null;

        try {
            gluoObjetivo = gluoObjetivoLogic.getGluoObjetivo(objeId);
        } catch (Exception e) {
            throw e;
        }

        return gluoObjetivo;
    }
    
  
	public List<GluoObjetivo> findObjetivoActivo() throws Exception {
		
		return gluoObjetivoLogic.findObjetivoActivo();
	}

    public List<GluoObjetivo> findByCriteriaInGluoObjetivo(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return gluoObjetivoLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<GluoObjetivo> findPageGluoObjetivo(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return gluoObjetivoLogic.findPageGluoObjetivo(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberGluoObjetivo() throws Exception {
        return gluoObjetivoLogic.findTotalNumberGluoObjetivo();
    }

    public List<GluoObjetivoDTO> getDataGluoObjetivo()
        throws Exception {
        return gluoObjetivoLogic.getDataGluoObjetivo();
    }

    public void validateGluoObjetivo(GluoObjetivo gluoObjetivo)
        throws Exception {
        gluoObjetivoLogic.validateGluoObjetivo(gluoObjetivo);
    }

    public List<GluoPlanDesarrollo> getGluoPlanDesarrollo()
        throws Exception {
        return gluoPlanDesarrolloLogic.getGluoPlanDesarrollo();
    }

    public void saveGluoPlanDesarrollo(GluoPlanDesarrollo entity)
        throws Exception {
        gluoPlanDesarrolloLogic.saveGluoPlanDesarrollo(entity);
    }

    public void deleteGluoPlanDesarrollo(GluoPlanDesarrollo entity)
        throws Exception {
        gluoPlanDesarrolloLogic.deleteGluoPlanDesarrollo(entity);
    }

    public void updateGluoPlanDesarrollo(GluoPlanDesarrollo entity)
        throws Exception {
        gluoPlanDesarrolloLogic.updateGluoPlanDesarrollo(entity);
    }

    public GluoPlanDesarrollo getGluoPlanDesarrollo(Integer planId)
        throws Exception {
        GluoPlanDesarrollo gluoPlanDesarrollo = null;

        try {
            gluoPlanDesarrollo = gluoPlanDesarrolloLogic.getGluoPlanDesarrollo(planId);
        } catch (Exception e) {
            throw e;
        }

        return gluoPlanDesarrollo;
    }
    
    public List <GluoPlanDesarrollo> findPlanDesarrolloActivo()throws Exception{
    	
    	return gluoPlanDesarrolloLogic.findPlanDesarrolloActivo();
    	
    	
    }

    public List<GluoPlanDesarrollo> findByCriteriaInGluoPlanDesarrollo(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return gluoPlanDesarrolloLogic.findByCriteria(variables,
            variablesBetween, variablesBetweenDates);
    }

    public List<GluoPlanDesarrollo> findPageGluoPlanDesarrollo(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        return gluoPlanDesarrolloLogic.findPageGluoPlanDesarrollo(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberGluoPlanDesarrollo() throws Exception {
        return gluoPlanDesarrolloLogic.findTotalNumberGluoPlanDesarrollo();
    }

    public List<GluoPlanDesarrolloDTO> getDataGluoPlanDesarrollo()
        throws Exception {
        return gluoPlanDesarrolloLogic.getDataGluoPlanDesarrollo();
    }

    public void validateGluoPlanDesarrollo(
        GluoPlanDesarrollo gluoPlanDesarrollo) throws Exception {
        gluoPlanDesarrolloLogic.validateGluoPlanDesarrollo(gluoPlanDesarrollo);
    }

    public List<GluoPresupuesto> getGluoPresupuesto() throws Exception {
        return gluoPresupuestoLogic.getGluoPresupuesto();
    }

    public void saveGluoPresupuesto(GluoPresupuesto entity)
        throws Exception {
        gluoPresupuestoLogic.saveGluoPresupuesto(entity);
    }

    public void deleteGluoPresupuesto(GluoPresupuesto entity)
        throws Exception {
        gluoPresupuestoLogic.deleteGluoPresupuesto(entity);
    }

    public void updateGluoPresupuesto(GluoPresupuesto entity)
        throws Exception {
        gluoPresupuestoLogic.updateGluoPresupuesto(entity);
    }

    public GluoPresupuesto getGluoPresupuesto(Integer pptoId)
        throws Exception {
        GluoPresupuesto gluoPresupuesto = null;

        try {
            gluoPresupuesto = gluoPresupuestoLogic.getGluoPresupuesto(pptoId);
        } catch (Exception e) {
            throw e;
        }

        return gluoPresupuesto;
    }
    

	public List<GluoPresupuesto> findPresupuestoActivo() throws Exception {
		
		return gluoPresupuestoLogic.findPresupuestoActivo();
	}

    public List<GluoPresupuesto> findByCriteriaInGluoPresupuesto(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return gluoPresupuestoLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<GluoPresupuesto> findPageGluoPresupuesto(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        return gluoPresupuestoLogic.findPageGluoPresupuesto(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberGluoPresupuesto() throws Exception {
        return gluoPresupuestoLogic.findTotalNumberGluoPresupuesto();
    }

    public List<GluoPresupuestoDTO> getDataGluoPresupuesto()
        throws Exception {
        return gluoPresupuestoLogic.getDataGluoPresupuesto();
    }

    public void validateGluoPresupuesto(GluoPresupuesto gluoPresupuesto)
        throws Exception {
        gluoPresupuestoLogic.validateGluoPresupuesto(gluoPresupuesto);
    }

    public List<GluoPrograma> getGluoPrograma() throws Exception {
        return gluoProgramaLogic.getGluoPrograma();
    }
    
    @Override
	public List<GluoPrograma> findProgramaActivo() throws Exception {
		
		return gluoProgramaLogic.findProgramaActivo();
	}


    public void saveGluoPrograma(GluoPrograma entity) throws Exception {
        gluoProgramaLogic.saveGluoPrograma(entity);
    }

    public void deleteGluoPrograma(GluoPrograma entity)
        throws Exception {
        gluoProgramaLogic.deleteGluoPrograma(entity);
    }

    public void updateGluoPrograma(GluoPrograma entity)
        throws Exception {
        gluoProgramaLogic.updateGluoPrograma(entity);
    }

    public GluoPrograma getGluoPrograma(Integer progId)
        throws Exception {
        GluoPrograma gluoPrograma = null;

        try {
            gluoPrograma = gluoProgramaLogic.getGluoPrograma(progId);
        } catch (Exception e) {
            throw e;
        }

        return gluoPrograma;
    }

    public List<GluoPrograma> findByCriteriaInGluoPrograma(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return gluoProgramaLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<GluoPrograma> findPageGluoPrograma(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return gluoProgramaLogic.findPageGluoPrograma(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberGluoPrograma() throws Exception {
        return gluoProgramaLogic.findTotalNumberGluoPrograma();
    }

    public List<GluoProgramaDTO> getDataGluoPrograma()
        throws Exception {
        return gluoProgramaLogic.getDataGluoPrograma();
    }

    public void validateGluoPrograma(GluoPrograma gluoPrograma)
        throws Exception {
        gluoProgramaLogic.validateGluoPrograma(gluoPrograma);
    }

    public List<GluoProyecto> getGluoProyecto() throws Exception {
        return gluoProyectoLogic.getGluoProyecto();
    }
    
    

    public void saveGluoProyecto(GluoProyecto entity) throws Exception {
        gluoProyectoLogic.saveGluoProyecto(entity);
    }

    public void deleteGluoProyecto(GluoProyecto entity)
        throws Exception {
        gluoProyectoLogic.deleteGluoProyecto(entity);
    }

    public void updateGluoProyecto(GluoProyecto entity)
        throws Exception {
        gluoProyectoLogic.updateGluoProyecto(entity);
    }

    public GluoProyecto getGluoProyecto(Integer proyId)
        throws Exception {
        GluoProyecto gluoProyecto = null;

        try {
            gluoProyecto = gluoProyectoLogic.getGluoProyecto(proyId);
        } catch (Exception e) {
            throw e;
        }

        return gluoProyecto;
    }
    
 
	public List<GluoProyecto> findProyectoActivo() throws Exception {
		
		return gluoProyectoLogic.findProyectoActivo();
	}

    public List<GluoProyecto> findByCriteriaInGluoProyecto(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return gluoProyectoLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<GluoProyecto> findPageGluoProyecto(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return gluoProyectoLogic.findPageGluoProyecto(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberGluoProyecto() throws Exception {
        return gluoProyectoLogic.findTotalNumberGluoProyecto();
    }

    public List<GluoProyectoDTO> getDataGluoProyecto()
        throws Exception {
        return gluoProyectoLogic.getDataGluoProyecto();
    }

    public void validateGluoProyecto(GluoProyecto gluoProyecto)
        throws Exception {
        gluoProyectoLogic.validateGluoProyecto(gluoProyecto);
    }

    public List<GluoSectorEjeDimension> getGluoSectorEjeDimension()
        throws Exception {
        return gluoSectorEjeDimensionLogic.getGluoSectorEjeDimension();
    }

    public void saveGluoSectorEjeDimension(GluoSectorEjeDimension entity)
        throws Exception {
        gluoSectorEjeDimensionLogic.saveGluoSectorEjeDimension(entity);
    }

    public void deleteGluoSectorEjeDimension(GluoSectorEjeDimension entity)
        throws Exception {
        gluoSectorEjeDimensionLogic.deleteGluoSectorEjeDimension(entity);
    }

    public void updateGluoSectorEjeDimension(GluoSectorEjeDimension entity)
        throws Exception {
        gluoSectorEjeDimensionLogic.updateGluoSectorEjeDimension(entity);
    }

    public GluoSectorEjeDimension getGluoSectorEjeDimension(Integer sediId)
        throws Exception {
        GluoSectorEjeDimension gluoSectorEjeDimension = null;

        try {
            gluoSectorEjeDimension = gluoSectorEjeDimensionLogic.getGluoSectorEjeDimension(sediId);
        } catch (Exception e) {
            throw e;
        }

        return gluoSectorEjeDimension;
    }

    public List<GluoSectorEjeDimension> findByCriteriaInGluoSectorEjeDimension(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return gluoSectorEjeDimensionLogic.findByCriteria(variables,
            variablesBetween, variablesBetweenDates);
    }

    public List<GluoSectorEjeDimension> findPageGluoSectorEjeDimension(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        return gluoSectorEjeDimensionLogic.findPageGluoSectorEjeDimension(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberGluoSectorEjeDimension()
        throws Exception {
        return gluoSectorEjeDimensionLogic.findTotalNumberGluoSectorEjeDimension();
    }

    public List<GluoSectorEjeDimensionDTO> getDataGluoSectorEjeDimension()
        throws Exception {
        return gluoSectorEjeDimensionLogic.getDataGluoSectorEjeDimension();
    }

    public void validateGluoSectorEjeDimension(
        GluoSectorEjeDimension gluoSectorEjeDimension)
        throws Exception {
        gluoSectorEjeDimensionLogic.validateGluoSectorEjeDimension(gluoSectorEjeDimension);
    }

    public List<GluoSubprograma> getGluoSubprograma() throws Exception {
        return gluoSubprogramaLogic.getGluoSubprograma();
    }
    
  
	public List<GluoSectorEjeDimension> findSectorEjeDimensionActivo() throws Exception {
		
		return gluoSectorEjeDimensionLogic.findSectorEjeDimensionActivo();
	}

    public void saveGluoSubprograma(GluoSubprograma entity)
        throws Exception {
        gluoSubprogramaLogic.saveGluoSubprograma(entity);
    }

    public void deleteGluoSubprograma(GluoSubprograma entity)
        throws Exception {
        gluoSubprogramaLogic.deleteGluoSubprograma(entity);
    }

    public void updateGluoSubprograma(GluoSubprograma entity)
        throws Exception {
        gluoSubprogramaLogic.updateGluoSubprograma(entity);
    }

    public GluoSubprograma getGluoSubprograma(Integer subpId)
        throws Exception {
        GluoSubprograma gluoSubprograma = null;

        try {
            gluoSubprograma = gluoSubprogramaLogic.getGluoSubprograma(subpId);
        } catch (Exception e) {
            throw e;
        }

        return gluoSubprograma;
    }
    
    @Override
	public List<GluoSubprograma> findSubprogramaActivo() throws Exception {
		
		return gluoSubprogramaLogic.findSubprogramaActivo();
	}

    public List<GluoSubprograma> findByCriteriaInGluoSubprograma(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return gluoSubprogramaLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<GluoSubprograma> findPageGluoSubprograma(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        return gluoSubprogramaLogic.findPageGluoSubprograma(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberGluoSubprograma() throws Exception {
        return gluoSubprogramaLogic.findTotalNumberGluoSubprograma();
    }

    public List<GluoSubprogramaDTO> getDataGluoSubprograma()
        throws Exception {
        return gluoSubprogramaLogic.getDataGluoSubprograma();
    }

    public void validateGluoSubprograma(GluoSubprograma gluoSubprograma)
        throws Exception {
        gluoSubprogramaLogic.validateGluoSubprograma(gluoSubprograma);
    }

    public List<GluoTipoRecurso> getGluoTipoRecurso() throws Exception {
        return gluoTipoRecursoLogic.getGluoTipoRecurso();
    }

    public void saveGluoTipoRecurso(GluoTipoRecurso entity)
        throws Exception {
        gluoTipoRecursoLogic.saveGluoTipoRecurso(entity);
    }

    public void deleteGluoTipoRecurso(GluoTipoRecurso entity)
        throws Exception {
        gluoTipoRecursoLogic.deleteGluoTipoRecurso(entity);
    }

    public void updateGluoTipoRecurso(GluoTipoRecurso entity)
        throws Exception {
        gluoTipoRecursoLogic.updateGluoTipoRecurso(entity);
    }

    public GluoTipoRecurso getGluoTipoRecurso(Integer tireId)
        throws Exception {
        GluoTipoRecurso gluoTipoRecurso = null;

        try {
            gluoTipoRecurso = gluoTipoRecursoLogic.getGluoTipoRecurso(tireId);
        } catch (Exception e) {
            throw e;
        }

        return gluoTipoRecurso;
    }
    
   
	public List<GluoTipoRecurso> findTipoRecursoActivo() throws Exception {
		
		return gluoTipoRecursoLogic.findTipoRecursoActivo();
	}

    public List<GluoTipoRecurso> findByCriteriaInGluoTipoRecurso(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return gluoTipoRecursoLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<GluoTipoRecurso> findPageGluoTipoRecurso(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        return gluoTipoRecursoLogic.findPageGluoTipoRecurso(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberGluoTipoRecurso() throws Exception {
        return gluoTipoRecursoLogic.findTotalNumberGluoTipoRecurso();
    }

    public List<GluoTipoRecursoDTO> getDataGluoTipoRecurso()
        throws Exception {
        return gluoTipoRecursoLogic.getDataGluoTipoRecurso();
    }

    public void validateGluoTipoRecurso(GluoTipoRecurso gluoTipoRecurso)
        throws Exception {
        gluoTipoRecursoLogic.validateGluoTipoRecurso(gluoTipoRecurso);
    }

    public List<SegOpcion> getSegOpcion() throws Exception {
        return segOpcionLogic.getSegOpcion();
    }

    public void saveSegOpcion(SegOpcion entity) throws Exception {
        segOpcionLogic.saveSegOpcion(entity);
    }

    public void deleteSegOpcion(SegOpcion entity) throws Exception {
        segOpcionLogic.deleteSegOpcion(entity);
    }

    public void updateSegOpcion(SegOpcion entity) throws Exception {
        segOpcionLogic.updateSegOpcion(entity);
    }

    public SegOpcion getSegOpcion(Integer opcnId) throws Exception {
        SegOpcion segOpcion = null;

        try {
            segOpcion = segOpcionLogic.getSegOpcion(opcnId);
        } catch (Exception e) {
            throw e;
        }

        return segOpcion;
    }

    public List<SegOpcion> findByCriteriaInSegOpcion(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return segOpcionLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<SegOpcion> findPageSegOpcion(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return segOpcionLogic.findPageSegOpcion(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberSegOpcion() throws Exception {
        return segOpcionLogic.findTotalNumberSegOpcion();
    }

    public List<SegOpcionDTO> getDataSegOpcion() throws Exception {
        return segOpcionLogic.getDataSegOpcion();
    }

    public void validateSegOpcion(SegOpcion segOpcion)
        throws Exception {
        segOpcionLogic.validateSegOpcion(segOpcion);
    }

    public List<SegPermiso> getSegPermiso() throws Exception {
        return segPermisoLogic.getSegPermiso();
    }

    public void saveSegPermiso(SegPermiso entity) throws Exception {
        segPermisoLogic.saveSegPermiso(entity);
    }

    public void deleteSegPermiso(SegPermiso entity) throws Exception {
        segPermisoLogic.deleteSegPermiso(entity);
    }

    public void updateSegPermiso(SegPermiso entity) throws Exception {
        segPermisoLogic.updateSegPermiso(entity);
    }

    public SegPermiso getSegPermiso(Integer permId) throws Exception {
        SegPermiso segPermiso = null;

        try {
            segPermiso = segPermisoLogic.getSegPermiso(permId);
        } catch (Exception e) {
            throw e;
        }

        return segPermiso;
    }

    public List<SegPermiso> findByCriteriaInSegPermiso(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return segPermisoLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<SegPermiso> findPageSegPermiso(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return segPermisoLogic.findPageSegPermiso(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberSegPermiso() throws Exception {
        return segPermisoLogic.findTotalNumberSegPermiso();
    }

    public List<SegPermisoDTO> getDataSegPermiso() throws Exception {
        return segPermisoLogic.getDataSegPermiso();
    }

    public void validateSegPermiso(SegPermiso segPermiso)
        throws Exception {
        segPermisoLogic.validateSegPermiso(segPermiso);
    }

    public List<SegRol> getSegRol() throws Exception {
        return segRolLogic.getSegRol();
    }

    public void saveSegRol(SegRol entity) throws Exception {
        segRolLogic.saveSegRol(entity);
    }

    public void deleteSegRol(SegRol entity) throws Exception {
        segRolLogic.deleteSegRol(entity);
    }

    public void updateSegRol(SegRol entity) throws Exception {
        segRolLogic.updateSegRol(entity);
    }

    public SegRol getSegRol(Integer rolId) throws Exception {
        SegRol segRol = null;

        try {
            segRol = segRolLogic.getSegRol(rolId);
        } catch (Exception e) {
            throw e;
        }

        return segRol;
    }

    public List<SegRol> findByCriteriaInSegRol(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return segRolLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<SegRol> findPageSegRol(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return segRolLogic.findPageSegRol(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberSegRol() throws Exception {
        return segRolLogic.findTotalNumberSegRol();
    }

    public List<SegRolDTO> getDataSegRol() throws Exception {
        return segRolLogic.getDataSegRol();
    }

    public void validateSegRol(SegRol segRol) throws Exception {
        segRolLogic.validateSegRol(segRol);
    }

    public List<SegRolUsuario> getSegRolUsuario() throws Exception {
        return segRolUsuarioLogic.getSegRolUsuario();
    }

    public void saveSegRolUsuario(SegRolUsuario entity)
        throws Exception {
        segRolUsuarioLogic.saveSegRolUsuario(entity);
    }

    public void deleteSegRolUsuario(SegRolUsuario entity)
        throws Exception {
        segRolUsuarioLogic.deleteSegRolUsuario(entity);
    }

    public void updateSegRolUsuario(SegRolUsuario entity)
        throws Exception {
        segRolUsuarioLogic.updateSegRolUsuario(entity);
    }

    public SegRolUsuario getSegRolUsuario(Integer rlusId)
        throws Exception {
        SegRolUsuario segRolUsuario = null;

        try {
            segRolUsuario = segRolUsuarioLogic.getSegRolUsuario(rlusId);
        } catch (Exception e) {
            throw e;
        }

        return segRolUsuario;
    }

    public List<SegRolUsuario> findByCriteriaInSegRolUsuario(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return segRolUsuarioLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<SegRolUsuario> findPageSegRolUsuario(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return segRolUsuarioLogic.findPageSegRolUsuario(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberSegRolUsuario() throws Exception {
        return segRolUsuarioLogic.findTotalNumberSegRolUsuario();
    }

    public List<SegRolUsuarioDTO> getDataSegRolUsuario()
        throws Exception {
        return segRolUsuarioLogic.getDataSegRolUsuario();
    }

    public void validateSegRolUsuario(SegRolUsuario segRolUsuario)
        throws Exception {
        segRolUsuarioLogic.validateSegRolUsuario(segRolUsuario);
    }

    public List<SegUsuario> getSegUsuario() throws Exception {
        return segUsuarioLogic.getSegUsuario();
    }

    public void saveSegUsuario(SegUsuario entity) throws Exception {
        segUsuarioLogic.saveSegUsuario(entity);
    }

    public void deleteSegUsuario(SegUsuario entity) throws Exception {
        segUsuarioLogic.deleteSegUsuario(entity);
    }

    public void updateSegUsuario(SegUsuario entity) throws Exception {
        segUsuarioLogic.updateSegUsuario(entity);
    }

    public SegUsuario getSegUsuario(Integer usuId) throws Exception {
        SegUsuario segUsuario = null;

        try {
            segUsuario = segUsuarioLogic.getSegUsuario(usuId);
        } catch (Exception e) {
            throw e;
        }

        return segUsuario;
    }

    public List<SegUsuario> findByCriteriaInSegUsuario(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return segUsuarioLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<SegUsuario> findPageSegUsuario(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return segUsuarioLogic.findPageSegUsuario(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberSegUsuario() throws Exception {
        return segUsuarioLogic.findTotalNumberSegUsuario();
    }

    public List<SegUsuarioDTO> getDataSegUsuario() throws Exception {
        return segUsuarioLogic.getDataSegUsuario();
    }

    public void validateSegUsuario(SegUsuario segUsuario)
        throws Exception {
        segUsuarioLogic.validateSegUsuario(segUsuario);
    }

	public void crearGluoPlanDesarrollo(GluoPlanDesarrolloDTO gluoPlanDesarrolloDTO) throws Exception {
		
		gluoPlanDesarrolloLogic.crearGluoPlanDesarrollo(gluoPlanDesarrolloDTO);
	}
	
	public SegUsuario validarUsuario(String usuLogin, String usuClave) throws Exception{
		return segUsuarioLogic.validarUsuario(usuLogin,usuClave);
	}
	
	public SegRolUsuario obtenerIdRolUsuario(Integer id) throws Exception{
		return segRolUsuarioLogic.obtenerIdRolUsuario(id);
	}

	
	public List<GluoPlanDesarrollo> consultarTodoPlanDesarrollo() throws Exception {
		return gluoPlanDesarrolloLogic.consultarTodoPlanDesarrollo();
	}

	
	public List<GluoObjetivo> consultarTodoObjetivo() throws Exception {
		return gluoObjetivoLogic.consultarTodoObjetivo();
	}

	
	

}
