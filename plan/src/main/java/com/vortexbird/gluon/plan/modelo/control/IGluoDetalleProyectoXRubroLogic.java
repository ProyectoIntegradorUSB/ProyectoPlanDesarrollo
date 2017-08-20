package com.vortexbird.gluon.plan.modelo.control;

import com.vortexbird.gluon.plan.modelo.GluoDetalleProyectoXRubro;
import com.vortexbird.gluon.plan.modelo.dto.GluoDetalleProyectoXRubroDTO;

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
public interface IGluoDetalleProyectoXRubroLogic {
    public List<GluoDetalleProyectoXRubro> getGluoDetalleProyectoXRubro()
        throws Exception;

    /**
         * Save an new GluoDetalleProyectoXRubro entity
         */
    public void saveGluoDetalleProyectoXRubro(GluoDetalleProyectoXRubro entity)
        throws Exception;

    /**
         * Delete an existing GluoDetalleProyectoXRubro entity
         *
         */
    public void deleteGluoDetalleProyectoXRubro(
        GluoDetalleProyectoXRubro entity) throws Exception;

    /**
        * Update an existing GluoDetalleProyectoXRubro entity
        *
        */
    public void updateGluoDetalleProyectoXRubro(
        GluoDetalleProyectoXRubro entity) throws Exception;

    /**
         * Load an existing GluoDetalleProyectoXRubro entity
         *
         */
    public GluoDetalleProyectoXRubro getGluoDetalleProyectoXRubro(
        Integer dpruId) throws Exception;

    public List<GluoDetalleProyectoXRubro> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<GluoDetalleProyectoXRubro> findPageGluoDetalleProyectoXRubro(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberGluoDetalleProyectoXRubro()
        throws Exception;

    public List<GluoDetalleProyectoXRubroDTO> getDataGluoDetalleProyectoXRubro()
        throws Exception;

    public void validateGluoDetalleProyectoXRubro(
        GluoDetalleProyectoXRubro gluoDetalleProyectoXRubro)
        throws Exception;
}
