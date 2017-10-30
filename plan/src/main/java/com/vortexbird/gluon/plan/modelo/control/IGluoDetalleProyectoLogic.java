package com.vortexbird.gluon.plan.modelo.control;

import com.vortexbird.gluon.plan.modelo.GluoAnoFiscal;
import com.vortexbird.gluon.plan.modelo.GluoDetalleProyecto;
import com.vortexbird.gluon.plan.modelo.dto.GluoDetalleProyectoDTO;

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
public interface IGluoDetalleProyectoLogic {
    public List<GluoDetalleProyecto> getGluoDetalleProyecto()
        throws Exception;

    /**
         * Save an new GluoDetalleProyecto entity
         */
    public void saveGluoDetalleProyecto(GluoDetalleProyecto entity)
        throws Exception;

    /**
         * Delete an existing GluoDetalleProyecto entity
         *
         */
    public void deleteGluoDetalleProyecto(GluoDetalleProyecto entity)
        throws Exception;

    /**
        * Update an existing GluoDetalleProyecto entity
        *
        */
    public void updateGluoDetalleProyecto(GluoDetalleProyecto entity)
        throws Exception;

    /**
         * Load an existing GluoDetalleProyecto entity
         *
         */
    public GluoDetalleProyecto getGluoDetalleProyecto(Integer dproId)
        throws Exception;
    
    public List <GluoDetalleProyecto> findDetalleProyectoActivo()throws Exception;

    public List<GluoDetalleProyecto> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<GluoDetalleProyecto> findPageGluoDetalleProyecto(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberGluoDetalleProyecto() throws Exception;

    public List<GluoDetalleProyectoDTO> getDataGluoDetalleProyecto()
        throws Exception;

    public void validateGluoDetalleProyecto(
        GluoDetalleProyecto gluoDetalleProyecto) throws Exception;
}
