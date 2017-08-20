package com.vortexbird.gluon.plan.modelo.control;

import com.vortexbird.gluon.plan.modelo.GluoAnoFiscal;
import com.vortexbird.gluon.plan.modelo.dto.GluoAnoFiscalDTO;

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
public interface IGluoAnoFiscalLogic {
    public List<GluoAnoFiscal> getGluoAnoFiscal() throws Exception;

    /**
         * Save an new GluoAnoFiscal entity
         */
    public void saveGluoAnoFiscal(GluoAnoFiscal entity)
        throws Exception;

    /**
         * Delete an existing GluoAnoFiscal entity
         *
         */
    public void deleteGluoAnoFiscal(GluoAnoFiscal entity)
        throws Exception;

    /**
        * Update an existing GluoAnoFiscal entity
        *
        */
    public void updateGluoAnoFiscal(GluoAnoFiscal entity)
        throws Exception;

    /**
         * Load an existing GluoAnoFiscal entity
         *
         */
    public GluoAnoFiscal getGluoAnoFiscal(Integer anofId)
        throws Exception;

    public List<GluoAnoFiscal> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<GluoAnoFiscal> findPageGluoAnoFiscal(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberGluoAnoFiscal() throws Exception;

    public List<GluoAnoFiscalDTO> getDataGluoAnoFiscal()
        throws Exception;

    public void validateGluoAnoFiscal(GluoAnoFiscal gluoAnoFiscal)
        throws Exception;
}
