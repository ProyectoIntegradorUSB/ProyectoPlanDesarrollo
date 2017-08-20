package com.vortexbird.gluon.plan.modelo.control;

import com.vortexbird.gluon.plan.modelo.GluoHistorialIndicador;
import com.vortexbird.gluon.plan.modelo.dto.GluoHistorialIndicadorDTO;

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
public interface IGluoHistorialIndicadorLogic {
    public List<GluoHistorialIndicador> getGluoHistorialIndicador()
        throws Exception;

    /**
         * Save an new GluoHistorialIndicador entity
         */
    public void saveGluoHistorialIndicador(GluoHistorialIndicador entity)
        throws Exception;

    /**
         * Delete an existing GluoHistorialIndicador entity
         *
         */
    public void deleteGluoHistorialIndicador(GluoHistorialIndicador entity)
        throws Exception;

    /**
        * Update an existing GluoHistorialIndicador entity
        *
        */
    public void updateGluoHistorialIndicador(GluoHistorialIndicador entity)
        throws Exception;

    /**
         * Load an existing GluoHistorialIndicador entity
         *
         */
    public GluoHistorialIndicador getGluoHistorialIndicador(Integer hiinId)
        throws Exception;

    public List<GluoHistorialIndicador> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

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
}
