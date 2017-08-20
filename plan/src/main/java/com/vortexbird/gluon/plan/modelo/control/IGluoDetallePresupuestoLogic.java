package com.vortexbird.gluon.plan.modelo.control;

import com.vortexbird.gluon.plan.modelo.GluoDetallePresupuesto;
import com.vortexbird.gluon.plan.modelo.dto.GluoDetallePresupuestoDTO;

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
public interface IGluoDetallePresupuestoLogic {
    public List<GluoDetallePresupuesto> getGluoDetallePresupuesto()
        throws Exception;

    /**
         * Save an new GluoDetallePresupuesto entity
         */
    public void saveGluoDetallePresupuesto(GluoDetallePresupuesto entity)
        throws Exception;

    /**
         * Delete an existing GluoDetallePresupuesto entity
         *
         */
    public void deleteGluoDetallePresupuesto(GluoDetallePresupuesto entity)
        throws Exception;

    /**
        * Update an existing GluoDetallePresupuesto entity
        *
        */
    public void updateGluoDetallePresupuesto(GluoDetallePresupuesto entity)
        throws Exception;

    /**
         * Load an existing GluoDetallePresupuesto entity
         *
         */
    public GluoDetallePresupuesto getGluoDetallePresupuesto(Integer dptoId)
        throws Exception;

    public List<GluoDetallePresupuesto> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<GluoDetallePresupuesto> findPageGluoDetallePresupuesto(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberGluoDetallePresupuesto()
        throws Exception;

    public List<GluoDetallePresupuestoDTO> getDataGluoDetallePresupuesto()
        throws Exception;

    public void validateGluoDetallePresupuesto(
        GluoDetallePresupuesto gluoDetallePresupuesto)
        throws Exception;
}
