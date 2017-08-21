package com.vortexbird.gluon.plan.dataaccess.dao;

import java.util.List;

import com.vortexbird.gluon.plan.dataaccess.api.Dao;
import com.vortexbird.gluon.plan.modelo.GluoPlanDesarrollo;


/**
* Interface for   GluoPlanDesarrolloDAO.
*
*/
public interface IGluoPlanDesarrolloDAO extends Dao<GluoPlanDesarrollo, Integer> {
	
	public List<GluoPlanDesarrollo> consultarTodoPlanLosDesarrollo();
	
}

