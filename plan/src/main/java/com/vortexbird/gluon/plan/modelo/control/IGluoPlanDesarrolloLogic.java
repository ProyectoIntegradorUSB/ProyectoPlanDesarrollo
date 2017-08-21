package com.vortexbird.gluon.plan.modelo.control;

import com.vortexbird.gluon.plan.modelo.GluoPlanDesarrollo;
import com.vortexbird.gluon.plan.modelo.dto.GluoPlanDesarrolloDTO;

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
public interface IGluoPlanDesarrolloLogic {
    public List<GluoPlanDesarrollo> getGluoPlanDesarrollo()
        throws Exception;

    /**
         * Save an new GluoPlanDesarrollo entity
         */
    public void saveGluoPlanDesarrollo(GluoPlanDesarrollo entity)
        throws Exception;

    /**
         * Delete an existing GluoPlanDesarrollo entity
         *
         */
    public void deleteGluoPlanDesarrollo(GluoPlanDesarrollo entity)
        throws Exception;

    /**
        * Update an existing GluoPlanDesarrollo entity
        *
        */
    public void updateGluoPlanDesarrollo(GluoPlanDesarrollo entity)
        throws Exception;

    /**
         * Load an existing GluoPlanDesarrollo entity
         *
         */
    public GluoPlanDesarrollo getGluoPlanDesarrollo(Integer planId)
        throws Exception;

    public List<GluoPlanDesarrollo> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<GluoPlanDesarrollo> findPageGluoPlanDesarrollo(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberGluoPlanDesarrollo() throws Exception;

    public List<GluoPlanDesarrolloDTO> getDataGluoPlanDesarrollo()
        throws Exception;

    public void validateGluoPlanDesarrollo(
        GluoPlanDesarrollo gluoPlanDesarrollo) throws Exception;

	public void crearGluoPlanDesarrollo(GluoPlanDesarrolloDTO gluoPlanDesarrolloDTO) throws Exception;

	public List<GluoPlanDesarrollo> consultarTodoPlanDesarrollo() throws Exception;
}
