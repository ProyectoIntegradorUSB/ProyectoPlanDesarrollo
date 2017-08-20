package com.vortexbird.gluon.plan.modelo.control;

import com.vortexbird.gluon.plan.modelo.GluoObjetivo;
import com.vortexbird.gluon.plan.modelo.dto.GluoObjetivoDTO;

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
public interface IGluoObjetivoLogic {
    public List<GluoObjetivo> getGluoObjetivo() throws Exception;

    /**
         * Save an new GluoObjetivo entity
         */
    public void saveGluoObjetivo(GluoObjetivo entity) throws Exception;

    /**
         * Delete an existing GluoObjetivo entity
         *
         */
    public void deleteGluoObjetivo(GluoObjetivo entity)
        throws Exception;

    /**
        * Update an existing GluoObjetivo entity
        *
        */
    public void updateGluoObjetivo(GluoObjetivo entity)
        throws Exception;

    /**
         * Load an existing GluoObjetivo entity
         *
         */
    public GluoObjetivo getGluoObjetivo(Integer objeId)
        throws Exception;

    public List<GluoObjetivo> findByCriteria(Object[] variables,
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
}
