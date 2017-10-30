package com.vortexbird.gluon.plan.modelo.control;

import com.vortexbird.gluon.plan.modelo.GluoAnoFiscal;
import com.vortexbird.gluon.plan.modelo.GluoPrograma;
import com.vortexbird.gluon.plan.modelo.dto.GluoProgramaDTO;

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
public interface IGluoProgramaLogic {
    public List<GluoPrograma> getGluoPrograma() throws Exception;

    /**
         * Save an new GluoPrograma entity
         */
    public void saveGluoPrograma(GluoPrograma entity) throws Exception;

    /**
         * Delete an existing GluoPrograma entity
         *
         */
    public void deleteGluoPrograma(GluoPrograma entity)
        throws Exception;

    /**
        * Update an existing GluoPrograma entity
        *
        */
    public void updateGluoPrograma(GluoPrograma entity)
        throws Exception;

    /**
         * Load an existing GluoPrograma entity
         *
         */
    public GluoPrograma getGluoPrograma(Integer progId)
        throws Exception;
    
    public List <GluoPrograma> findProgramaActivo()throws Exception;

    public List<GluoPrograma> findByCriteria(Object[] variables,
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
}
