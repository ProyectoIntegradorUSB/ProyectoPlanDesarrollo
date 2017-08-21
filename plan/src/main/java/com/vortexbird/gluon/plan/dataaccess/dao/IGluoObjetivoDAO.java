package com.vortexbird.gluon.plan.dataaccess.dao;

import java.util.List;

import com.vortexbird.gluon.plan.dataaccess.api.Dao;
import com.vortexbird.gluon.plan.modelo.GluoObjetivo;


/**
* Interface for   GluoObjetivoDAO.
*
*/
public interface IGluoObjetivoDAO extends Dao<GluoObjetivo, Integer> {

	public List<GluoObjetivo> consultarTodoObjetivo();
}
