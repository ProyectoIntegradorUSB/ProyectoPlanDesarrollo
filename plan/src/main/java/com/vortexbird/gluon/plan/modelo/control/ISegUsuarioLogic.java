package com.vortexbird.gluon.plan.modelo.control;

import com.vortexbird.gluon.plan.modelo.SegUsuario;
import com.vortexbird.gluon.plan.modelo.dto.SegUsuarioDTO;

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
public interface ISegUsuarioLogic {
    public List<SegUsuario> getSegUsuario() throws Exception;

    /**
         * Save an new SegUsuario entity
         */
    public void saveSegUsuario(SegUsuario entity) throws Exception;

    /**
         * Delete an existing SegUsuario entity
         *
         */
    public void deleteSegUsuario(SegUsuario entity) throws Exception;

    /**
        * Update an existing SegUsuario entity
        *
        */
    public void updateSegUsuario(SegUsuario entity) throws Exception;

    /**
         * Load an existing SegUsuario entity
         *
         */
    public SegUsuario getSegUsuario(Integer usuId) throws Exception;

    public List<SegUsuario> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<SegUsuario> findPageSegUsuario(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberSegUsuario() throws Exception;

    public List<SegUsuarioDTO> getDataSegUsuario() throws Exception;

    public void validateSegUsuario(SegUsuario segUsuario)
        throws Exception;

	public SegUsuario validarUsuario(String usuLogin, String usuClave) throws Exception;
}
