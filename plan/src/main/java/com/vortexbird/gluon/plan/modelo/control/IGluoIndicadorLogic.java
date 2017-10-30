package com.vortexbird.gluon.plan.modelo.control;

import com.vortexbird.gluon.plan.modelo.GluoHistorialIndicador;
import com.vortexbird.gluon.plan.modelo.GluoIndicador;
import com.vortexbird.gluon.plan.modelo.dto.GluoIndicadorDTO;

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
public interface IGluoIndicadorLogic {
    public List<GluoIndicador> getGluoIndicador() throws Exception;

    /**
         * Save an new GluoIndicador entity
         */
    public void saveGluoIndicador(GluoIndicador entity)
        throws Exception;

    /**
         * Delete an existing GluoIndicador entity
         *
         */
    public void deleteGluoIndicador(GluoIndicador entity)
        throws Exception;

    /**
        * Update an existing GluoIndicador entity
        *
        */
    public void updateGluoIndicador(GluoIndicador entity)
        throws Exception;

    /**
         * Load an existing GluoIndicador entity
         *
         */
    public GluoIndicador getGluoIndicador(Integer indiId)
        throws Exception;
    
    public List <GluoIndicador> findIndicadorActivo()
    		throws Exception;

    public List<GluoIndicador> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<GluoIndicador> findPageGluoIndicador(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberGluoIndicador() throws Exception;

    public List<GluoIndicadorDTO> getDataGluoIndicador()
        throws Exception;

    public void validateGluoIndicador(GluoIndicador gluoIndicador)
        throws Exception;
}
