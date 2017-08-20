package com.vortexbird.gluon.plan.modelo.control;

import com.vortexbird.gluon.plan.modelo.SegPermiso;
import com.vortexbird.gluon.plan.modelo.dto.SegPermisoDTO;

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
public interface ISegPermisoLogic {
    public List<SegPermiso> getSegPermiso() throws Exception;

    /**
         * Save an new SegPermiso entity
         */
    public void saveSegPermiso(SegPermiso entity) throws Exception;

    /**
         * Delete an existing SegPermiso entity
         *
         */
    public void deleteSegPermiso(SegPermiso entity) throws Exception;

    /**
        * Update an existing SegPermiso entity
        *
        */
    public void updateSegPermiso(SegPermiso entity) throws Exception;

    /**
         * Load an existing SegPermiso entity
         *
         */
    public SegPermiso getSegPermiso(Integer permId) throws Exception;

    public List<SegPermiso> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<SegPermiso> findPageSegPermiso(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberSegPermiso() throws Exception;

    public List<SegPermisoDTO> getDataSegPermiso() throws Exception;

    public void validateSegPermiso(SegPermiso segPermiso)
        throws Exception;
}
