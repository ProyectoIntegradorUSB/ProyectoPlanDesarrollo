package com.vortexbird.gluon.plan.modelo.control;

import com.vortexbird.gluon.plan.modelo.GluoSectorEjeDimension;
import com.vortexbird.gluon.plan.modelo.dto.GluoSectorEjeDimensionDTO;

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
public interface IGluoSectorEjeDimensionLogic {
    public List<GluoSectorEjeDimension> getGluoSectorEjeDimension()
        throws Exception;

    /**
         * Save an new GluoSectorEjeDimension entity
         */
    public void saveGluoSectorEjeDimension(GluoSectorEjeDimension entity)
        throws Exception;

    /**
         * Delete an existing GluoSectorEjeDimension entity
         *
         */
    public void deleteGluoSectorEjeDimension(GluoSectorEjeDimension entity)
        throws Exception;

    /**
        * Update an existing GluoSectorEjeDimension entity
        *
        */
    public void updateGluoSectorEjeDimension(GluoSectorEjeDimension entity)
        throws Exception;

    /**
         * Load an existing GluoSectorEjeDimension entity
         *
         */
    public GluoSectorEjeDimension getGluoSectorEjeDimension(Integer sediId)
        throws Exception;

    public List<GluoSectorEjeDimension> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<GluoSectorEjeDimension> findPageGluoSectorEjeDimension(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberGluoSectorEjeDimension()
        throws Exception;

    public List<GluoSectorEjeDimensionDTO> getDataGluoSectorEjeDimension()
        throws Exception;

    public void validateGluoSectorEjeDimension(
        GluoSectorEjeDimension gluoSectorEjeDimension)
        throws Exception;
}
