package com.vortexbird.gluon.plan.dataaccess.dao;

import com.vortexbird.gluon.plan.dataaccess.api.Dao;
import com.vortexbird.gluon.plan.modelo.SegUsuario;


/**
* Interface for   SegUsuarioDAO.
*
*/
public interface ISegUsuarioDAO extends Dao<SegUsuario, Integer> {

	SegUsuario consultarUsuarioPorLogin(String usuLogin);
}
