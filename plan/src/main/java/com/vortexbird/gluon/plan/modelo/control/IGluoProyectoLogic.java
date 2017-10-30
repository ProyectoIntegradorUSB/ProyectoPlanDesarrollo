package com.vortexbird.gluon.plan.modelo.control;

import com.vortexbird.gluon.plan.modelo.GluoAnoFiscal;
import com.vortexbird.gluon.plan.modelo.GluoProyecto;
import com.vortexbird.gluon.plan.modelo.dto.GluoProyectoDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface IGluoProyectoLogic {
    public List<GluoProyecto> getGluoProyecto() throws Exception;

    /**
         * Save an new GluoProyecto entity
         */
    public void saveGluoProyecto(GluoProyecto entity) throws Exception;

    /**
         * Delete an existing GluoProyecto entity
         *
         */
    public void deleteGluoProyecto(GluoProyecto entity)
        throws Exception;

    /**
        * Update an existing GluoProyecto entity
        *
        */
    public void updateGluoProyecto(GluoProyecto entity)
        throws Exception;

    /**
         * Load an existing GluoProyecto entity
         *
         */
    public GluoProyecto getGluoProyecto(Integer proyId)
        throws Exception;
    
    public List <GluoProyecto> findProyectoActivo()throws Exception;

    public List<GluoProyecto> findByCriteria(Object[] variables,
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
}
