package com.vortexbird.gluon.plan.modelo.control;

import com.vortexbird.gluon.plan.modelo.SegOpcion;
import com.vortexbird.gluon.plan.modelo.dto.SegOpcionDTO;

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
public interface ISegOpcionLogic {
    public List<SegOpcion> getSegOpcion() throws Exception;

    /**
         * Save an new SegOpcion entity
         */
    public void saveSegOpcion(SegOpcion entity) throws Exception;

    /**
         * Delete an existing SegOpcion entity
         *
         */
    public void deleteSegOpcion(SegOpcion entity) throws Exception;

    /**
        * Update an existing SegOpcion entity
        *
        */
    public void updateSegOpcion(SegOpcion entity) throws Exception;

    /**
         * Load an existing SegOpcion entity
         *
         */
    public SegOpcion getSegOpcion(Integer opcnId) throws Exception;

    public List<SegOpcion> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<SegOpcion> findPageSegOpcion(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberSegOpcion() throws Exception;

    public List<SegOpcionDTO> getDataSegOpcion() throws Exception;

    public void validateSegOpcion(SegOpcion segOpcion)
        throws Exception;
}
