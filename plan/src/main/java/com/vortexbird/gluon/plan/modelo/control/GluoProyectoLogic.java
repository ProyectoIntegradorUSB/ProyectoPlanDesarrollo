package com.vortexbird.gluon.plan.modelo.control;

import com.vortexbird.gluon.plan.dataaccess.dao.*;
import com.vortexbird.gluon.plan.dto.mapper.IGluoProyectoMapper;
import com.vortexbird.gluon.plan.exceptions.*;
import com.vortexbird.gluon.plan.modelo.*;
import com.vortexbird.gluon.plan.modelo.dto.GluoProyectoDTO;
import com.vortexbird.gluon.plan.presentation.backingBeans.GluoProyectoView;
import com.vortexbird.gluon.plan.presentation.businessDelegate.IBusinessDelegatorView;
import com.vortexbird.gluon.plan.utilities.FacesUtils;
import com.vortexbird.gluon.plan.utilities.Utilities;

import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.faces.bean.ManagedProperty;
import javax.faces.model.SelectItem;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("GluoProyectoLogic")
public class GluoProyectoLogic implements IGluoProyectoLogic {
    private static final Logger log = LoggerFactory.getLogger(GluoProyectoLogic.class);

    /**
     * DAO injected by Spring that manages GluoProyecto entities
     *
     */
    @Autowired
    private IGluoProyectoDAO gluoProyectoDAO;
    @Autowired
    private IGluoProyectoMapper gluoProyectoMapper;
    @Autowired
    private Validator validator;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;
    
    private List<SelectItem> losSubProgramasItems;
	private SelectOneMenu somSubPrograma;

    /**
    * DAO injected by Spring that manages GluoDetalleProyecto entities
    *
    */
    @Autowired
    private IGluoDetalleProyectoDAO gluoDetalleProyectoDAO;

    /**
    * DAO injected by Spring that manages GluoIndicador entities
    *
    */
    @Autowired
    private IGluoIndicadorDAO gluoIndicadorDAO;

    /**
    * Logic injected by Spring that manages GluoSubprograma entities
    *
    */
    @Autowired
    IGluoSubprogramaLogic logicGluoSubprograma1;
    
    
    

    public List<SelectItem> getLosSubProgramasItems() {
    	try {
			if (losSubProgramasItems == null) {
				losSubProgramasItems = new ArrayList<SelectItem>();
				List<GluoSubprograma> losGluoSubPrograma = businessDelegatorView.getGluoSubprograma();
				for (GluoSubprograma gluoSubPrograma : losGluoSubPrograma) {
					losSubProgramasItems
							.add(new SelectItem(gluoSubPrograma.getSubpId(), gluoSubPrograma.getDescripcion()));
				}
			}
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return losSubProgramasItems;
	}

	public void setLosSubProgramasItems(List<SelectItem> losSubProgramasItems) {
		this.losSubProgramasItems = losSubProgramasItems;
	}

	public SelectOneMenu getSomSubPrograma() {
		return somSubPrograma;
	}

	public void setSomSubPrograma(SelectOneMenu somSubPrograma) {
		this.somSubPrograma = somSubPrograma;
	}

	public void validateGluoProyecto(GluoProyecto gluoProyecto)
        throws Exception {
        try {
            Set<ConstraintViolation<GluoProyecto>> constraintViolations = validator.validate(gluoProyecto);

            if (constraintViolations.size() > 0) {
                StringBuilder strMessage = new StringBuilder();

                for (ConstraintViolation<GluoProyecto> constraintViolation : constraintViolations) {
                    strMessage.append(constraintViolation.getPropertyPath()
                                                         .toString());
                    strMessage.append(" - ");
                    strMessage.append(constraintViolation.getMessage());
                    strMessage.append(". \n");
                }

                throw new Exception(strMessage.toString());
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<GluoProyecto> getGluoProyecto() throws Exception {
        log.debug("finding all GluoProyecto instances");

        List<GluoProyecto> list = new ArrayList<GluoProyecto>();

        try {
            list = gluoProyectoDAO.findAll();
        } catch (Exception e) {
            log.error("finding all GluoProyecto failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "GluoProyecto");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveGluoProyecto(GluoProyecto entity) throws Exception {
        log.debug("saving GluoProyecto instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion("GluoProyecto");
            }

            validateGluoProyecto(entity);
            
            /*
            if (getGluoProyecto(entity.getProyId()) != null) {
                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
            }
            */
            gluoProyectoDAO.save(entity);

            log.debug("save GluoProyecto successful");
        } catch (Exception e) {
            log.error("save GluoProyecto failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteGluoProyecto(GluoProyecto entity)
        throws Exception {
        log.debug("deleting GluoProyecto instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("GluoProyecto");
        }

        if (entity.getProyId() == null) {
            throw new ZMessManager().new EmptyFieldException("proyId");
        }

        List<GluoDetalleProyecto> gluoDetalleProyectos = null;
        List<GluoIndicador> gluoIndicadors = null;

        try {
            gluoDetalleProyectos = gluoDetalleProyectoDAO.findByProperty("gluoProyecto.proyId",
                    entity.getProyId());

            if (Utilities.validationsList(gluoDetalleProyectos) == true) {
                throw new ZMessManager().new DeletingException(
                    "gluoDetalleProyectos");
            }

            gluoIndicadors = gluoIndicadorDAO.findByProperty("gluoProyecto.proyId",
                    entity.getProyId());

            if (Utilities.validationsList(gluoIndicadors) == true) {
                throw new ZMessManager().new DeletingException("gluoIndicadors");
            }

            gluoProyectoDAO.delete(entity);

            log.debug("delete GluoProyecto successful");
        } catch (Exception e) {
            log.error("delete GluoProyecto failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateGluoProyecto(GluoProyecto entity)
        throws Exception {
        log.debug("updating GluoProyecto instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion("GluoProyecto");
            }

            validateGluoProyecto(entity);

            gluoProyectoDAO.update(entity);

            log.debug("update GluoProyecto successful");
        } catch (Exception e) {
            log.error("update GluoProyecto failed", e);
            throw e;
        } finally {
        }
    }
    
    @Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
    public void crearProyecto(GluoProyecto gluoProyecto)throws Exception {
    	
    	if(gluoProyecto==null) {
    		
    		throw new Exception("El Proyecto no puede ser nulo");    		
    	}
    	
    	validateGluoProyecto(gluoProyecto);
    	
    	GluoProyecto gluoProyectoID= gluoProyectoDAO.findById(gluoProyecto.getProyId());
    	
    	SegUsuario segUsuario = (SegUsuario) FacesUtils.getfromSession("usuarioEnSession");
		Integer usuaCreador = Integer.valueOf(segUsuario.getUsuId());
		
		Integer idSubprograma = Integer.valueOf(somSubPrograma.getValue().toString());
		GluoSubprograma gluoSubPrograma = businessDelegatorView.getGluoSubprograma(idSubprograma);
		
		
    	
    	String var=gluoProyectoID.getDescripcion().toString();
    	GluoProyecto gluoProject=new GluoProyecto();
    	
    	
    	gluoProject.setActivo("A");
    	gluoProject.setDescripcion(var);
    	gluoProject.setFechaCreacion(new Date());
    	gluoProject.setUsuCreador(usuaCreador);
    	gluoProject.setGluoSubprograma(gluoSubPrograma);
    	
    	gluoProyectoDAO.save(gluoProject);
    	
    	
    }
    
    
    

    @Transactional(readOnly = true)
    public List<GluoProyectoDTO> getDataGluoProyecto()
        throws Exception {
        try {
            List<GluoProyecto> gluoProyecto = gluoProyectoDAO.findAll();

            List<GluoProyectoDTO> gluoProyectoDTO = new ArrayList<GluoProyectoDTO>();

            for (GluoProyecto gluoProyectoTmp : gluoProyecto) {
                GluoProyectoDTO gluoProyectoDTO2 = gluoProyectoMapper.gluoProyectoToGluoProyectoDTO(gluoProyectoTmp);
                gluoProyectoDTO.add(gluoProyectoDTO2);
            }

            return gluoProyectoDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public GluoProyecto getGluoProyecto(Integer proyId)
        throws Exception {
        log.debug("getting GluoProyecto instance");

        GluoProyecto entity = null;

        try {
            entity = gluoProyectoDAO.findById(proyId);
        } catch (Exception e) {
            log.error("get GluoProyecto failed", e);
            throw new ZMessManager().new FindingException("GluoProyecto");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<GluoProyecto> findPageGluoProyecto(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        List<GluoProyecto> entity = null;

        try {
            entity = gluoProyectoDAO.findPage(sortColumnName, sortAscending,
                    startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("GluoProyecto Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberGluoProyecto() throws Exception {
        Long entity = null;

        try {
            entity = gluoProyectoDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("GluoProyecto Count");
        } finally {
        }

        return entity;
    }

    /**
    *
    * @param varibles
    *            este arreglo debera tener:
    *
    * [0] = String variable = (String) varibles[i]; representa como se llama la
    * variable en el pojo
    *
    * [1] = Boolean booVariable = (Boolean) varibles[i + 1]; representa si el
    * valor necesita o no ''(comillas simples)usado para campos de tipo string
    *
    * [2] = Object value = varibles[i + 2]; representa el valor que se va a
    * buscar en la BD
    *
    * [3] = String comparator = (String) varibles[i + 3]; representa que tipo
    * de busqueda voy a hacer.., ejemplo: where nombre=william o where nombre<>william,
        * en este campo iria el tipo de comparador que quiero si es = o <>
            *
            * Se itera de 4 en 4..., entonces 4 registros del arreglo representan 1
            * busqueda en un campo, si se ponen mas pues el continuara buscando en lo
            * que se le ingresen en los otros 4
            *
            *
            * @param variablesBetween
            *
            * la diferencia son estas dos posiciones
            *
            * [0] = String variable = (String) varibles[j]; la variable ne la BD que va
            * a ser buscada en un rango
            *
            * [1] = Object value = varibles[j + 1]; valor 1 para buscar en un rango
            *
            * [2] = Object value2 = varibles[j + 2]; valor 2 para buscar en un rango
            * ejempolo: a > 1 and a < 5 --> 1 seria value y 5 seria value2
                *
                * [3] = String comparator1 = (String) varibles[j + 3]; comparador 1
                * ejemplo: a comparator1 1 and a < 5
                    *
                    * [4] = String comparator2 = (String) varibles[j + 4]; comparador 2
                    * ejemplo: a comparador1>1  and a comparador2<5  (el original: a > 1 and a <
                            * 5) *
                            * @param variablesBetweenDates(en
                            *            este caso solo para mysql)
                            *  [0] = String variable = (String) varibles[k]; el nombre de la variable que hace referencia a
                            *            una fecha
                            *
                            * [1] = Object object1 = varibles[k + 2]; fecha 1 a comparar(deben ser
                            * dates)
                            *
                            * [2] = Object object2 = varibles[k + 3]; fecha 2 a comparar(deben ser
                            * dates)
                            *
                            * esto hace un between entre las dos fechas.
                            *
                            * @return lista con los objetos que se necesiten
                            * @throws Exception
                            */
    @Transactional(readOnly = true)
    public List<GluoProyecto> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<GluoProyecto> list = new ArrayList<GluoProyecto>();
        String where = new String();
        String tempWhere = new String();

        if (variables != null) {
            for (int i = 0; i < variables.length; i++) {
                if ((variables[i] != null) && (variables[i + 1] != null) &&
                        (variables[i + 2] != null) &&
                        (variables[i + 3] != null)) {
                    String variable = (String) variables[i];
                    Boolean booVariable = (Boolean) variables[i + 1];
                    Object value = variables[i + 2];
                    String comparator = (String) variables[i + 3];

                    if (booVariable.booleanValue()) {
                        tempWhere = (tempWhere.length() == 0)
                            ? ("(model." + variable + " " + comparator + " \'" +
                            value + "\' )")
                            : (tempWhere + " AND (model." + variable + " " +
                            comparator + " \'" + value + "\' )");
                    } else {
                        tempWhere = (tempWhere.length() == 0)
                            ? ("(model." + variable + " " + comparator + " " +
                            value + " )")
                            : (tempWhere + " AND (model." + variable + " " +
                            comparator + " " + value + " )");
                    }
                }

                i = i + 3;
            }
        }

        if (variablesBetween != null) {
            for (int j = 0; j < variablesBetween.length; j++) {
                if ((variablesBetween[j] != null) &&
                        (variablesBetween[j + 1] != null) &&
                        (variablesBetween[j + 2] != null) &&
                        (variablesBetween[j + 3] != null) &&
                        (variablesBetween[j + 4] != null)) {
                    String variable = (String) variablesBetween[j];
                    Object value = variablesBetween[j + 1];
                    Object value2 = variablesBetween[j + 2];
                    String comparator1 = (String) variablesBetween[j + 3];
                    String comparator2 = (String) variablesBetween[j + 4];
                    tempWhere = (tempWhere.length() == 0)
                        ? ("(" + value + " " + comparator1 + " " + variable +
                        " and " + variable + " " + comparator2 + " " + value2 +
                        " )")
                        : (tempWhere + " AND (" + value + " " + comparator1 +
                        " " + variable + " and " + variable + " " +
                        comparator2 + " " + value2 + " )");
                }

                j = j + 4;
            }
        }

        if (variablesBetweenDates != null) {
            for (int k = 0; k < variablesBetweenDates.length; k++) {
                if ((variablesBetweenDates[k] != null) &&
                        (variablesBetweenDates[k + 1] != null) &&
                        (variablesBetweenDates[k + 2] != null)) {
                    String variable = (String) variablesBetweenDates[k];
                    Object object1 = variablesBetweenDates[k + 1];
                    Object object2 = variablesBetweenDates[k + 2];
                    String value = null;
                    String value2 = null;

                    try {
                        Date date1 = (Date) object1;
                        Date date2 = (Date) object2;
                        value = Utilities.formatDateWithoutTimeInAStringForBetweenWhere(date1);
                        value2 = Utilities.formatDateWithoutTimeInAStringForBetweenWhere(date2);
                    } catch (Exception e) {
                        list = null;
                        throw e;
                    }

                    tempWhere = (tempWhere.length() == 0)
                        ? ("(model." + variable + " between " + value +
                        " and " + value2 + ")")
                        : (tempWhere + " AND (model." + variable + " between " +
                        value + " and " + value2 + ")");
                }

                k = k + 2;
            }
        }

        if (tempWhere.length() == 0) {
            where = null;
        } else {
            where = "(" + tempWhere + ")";
        }

        try {
            list = gluoProyectoDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
