package com.vortexbird.gluon.plan.modelo.control;

import com.vortexbird.gluon.plan.modelo.GluoSubprograma;
import com.vortexbird.gluon.plan.modelo.dto.GluoSubprogramaDTO;

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
public interface IGluoSubprogramaLogic {
    public List<GluoSubprograma> getGluoSubprograma() throws Exception;

    /**
         * Save an new GluoSubprograma entity
         */
    public void saveGluoSubprograma(GluoSubprograma entity)
        throws Exception;

    /**
         * Delete an existing GluoSubprograma entity
         *
         */
    public void deleteGluoSubprograma(GluoSubprograma entity)
        throws Exception;

    /**
        * Update an existing GluoSubprograma entity
        *
        */
    public void updateGluoSubprograma(GluoSubprograma entity)
        throws Exception;

    /**
         * Load an existing GluoSubprograma entity
         *
         */
    public GluoSubprograma getGluoSubprograma(Integer subpId)
        throws Exception;

    public List<GluoSubprograma> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<GluoSubprograma> findPageGluoSubprograma(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberGluoSubprograma() throws Exception;

    public List<GluoSubprogramaDTO> getDataGluoSubprograma()
        throws Exception;

    public void validateGluoSubprograma(GluoSubprograma gluoSubprograma)
        throws Exception;
}
