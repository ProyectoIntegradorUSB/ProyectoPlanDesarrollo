package com.vortexbird.gluon.plan.modelo.control;

import com.vortexbird.gluon.plan.modelo.GluoAnoFiscal;
import com.vortexbird.gluon.plan.modelo.GluoPresupuesto;
import com.vortexbird.gluon.plan.modelo.dto.GluoPresupuestoDTO;

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
public interface IGluoPresupuestoLogic {
    public List<GluoPresupuesto> getGluoPresupuesto() throws Exception;

    /**
         * Save an new GluoPresupuesto entity
         */
    public void saveGluoPresupuesto(GluoPresupuesto entity)
        throws Exception;

    /**
         * Delete an existing GluoPresupuesto entity
         *
         */
    public void deleteGluoPresupuesto(GluoPresupuesto entity)
        throws Exception;

    /**
        * Update an existing GluoPresupuesto entity
        *
        */
    public void updateGluoPresupuesto(GluoPresupuesto entity)
        throws Exception;

    /**
         * Load an existing GluoPresupuesto entity
         *
         */
    public GluoPresupuesto getGluoPresupuesto(Integer pptoId)
        throws Exception;
    
    public List <GluoPresupuesto> findPresupuestoActivo()throws Exception;

    public List<GluoPresupuesto> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<GluoPresupuesto> findPageGluoPresupuesto(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberGluoPresupuesto() throws Exception;

    public List<GluoPresupuestoDTO> getDataGluoPresupuesto()
        throws Exception;

    public void validateGluoPresupuesto(GluoPresupuesto gluoPresupuesto)
        throws Exception;
}
