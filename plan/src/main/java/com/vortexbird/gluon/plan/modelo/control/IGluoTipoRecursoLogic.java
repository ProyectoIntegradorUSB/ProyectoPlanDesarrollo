package com.vortexbird.gluon.plan.modelo.control;

import com.vortexbird.gluon.plan.modelo.GluoAnoFiscal;
import com.vortexbird.gluon.plan.modelo.GluoTipoRecurso;
import com.vortexbird.gluon.plan.modelo.dto.GluoTipoRecursoDTO;

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
public interface IGluoTipoRecursoLogic {
    public List<GluoTipoRecurso> getGluoTipoRecurso() throws Exception;

    /**
         * Save an new GluoTipoRecurso entity
         */
    public void saveGluoTipoRecurso(GluoTipoRecurso entity)
        throws Exception;

    /**
         * Delete an existing GluoTipoRecurso entity
         *
         */
    public void deleteGluoTipoRecurso(GluoTipoRecurso entity)
        throws Exception;

    /**
        * Update an existing GluoTipoRecurso entity
        *
        */
    public void updateGluoTipoRecurso(GluoTipoRecurso entity)
        throws Exception;

    /**
         * Load an existing GluoTipoRecurso entity
         *
         */
    public GluoTipoRecurso getGluoTipoRecurso(Integer tireId)
        throws Exception;
    
    public List <GluoTipoRecurso> findTipoRecursoActivo()throws Exception;

    public List<GluoTipoRecurso> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<GluoTipoRecurso> findPageGluoTipoRecurso(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberGluoTipoRecurso() throws Exception;

    public List<GluoTipoRecursoDTO> getDataGluoTipoRecurso()
        throws Exception;

    public void validateGluoTipoRecurso(GluoTipoRecurso gluoTipoRecurso)
        throws Exception;
}
