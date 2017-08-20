package com.vortexbird.gluon.plan.modelo.control;

import com.vortexbird.gluon.plan.modelo.SegRol;
import com.vortexbird.gluon.plan.modelo.dto.SegRolDTO;

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
public interface ISegRolLogic {
    public List<SegRol> getSegRol() throws Exception;

    /**
         * Save an new SegRol entity
         */
    public void saveSegRol(SegRol entity) throws Exception;

    /**
         * Delete an existing SegRol entity
         *
         */
    public void deleteSegRol(SegRol entity) throws Exception;

    /**
        * Update an existing SegRol entity
        *
        */
    public void updateSegRol(SegRol entity) throws Exception;

    /**
         * Load an existing SegRol entity
         *
         */
    public SegRol getSegRol(Integer rolId) throws Exception;

    public List<SegRol> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<SegRol> findPageSegRol(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberSegRol() throws Exception;

    public List<SegRolDTO> getDataSegRol() throws Exception;

    public void validateSegRol(SegRol segRol) throws Exception;
}
