package com.vortexbird.gluon.plan.presentation.backingBeans;

import javax.faces.bean.ManagedBean;

import com.vortexbird.gluon.plan.modelo.SegUsuario;
import com.vortexbird.gluon.plan.utilities.*;


@ManagedBean
public class UsuarioSession{
	
	private SegUsuario segUsuario;
	
	public SegUsuario getsession() {
		segUsuario =(SegUsuario)FacesUtils.getfromSession("usuarioEnSession");
		return segUsuario;
	}
	public void setUsuarios(SegUsuario segUsuario) {
		this.segUsuario = segUsuario;
	}
}