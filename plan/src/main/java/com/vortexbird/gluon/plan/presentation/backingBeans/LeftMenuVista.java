package com.vortexbird.gluon.plan.presentation.backingBeans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import org.primefaces.component.checkbox.Checkbox;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.password.Password;
import org.primefaces.component.selectcheckboxmenu.SelectCheckboxMenu;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.vortexbird.gluon.plan.modelo.SegOpcion;
import com.vortexbird.gluon.plan.modelo.SegPermiso;
import com.vortexbird.gluon.plan.modelo.SegRol;
import com.vortexbird.gluon.plan.modelo.SegRolUsuario;
import com.vortexbird.gluon.plan.modelo.SegUsuario;
import com.vortexbird.gluon.plan.presentation.businessDelegate.IBusinessDelegatorView;
import com.vortexbird.gluon.plan.utilities.FacesUtils;

import static java.lang.Math.toIntExact;

@ManagedBean
@ViewScoped
public class LeftMenuVista {
	
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	private static final Logger log = LoggerFactory.getLogger(LeftMenuVista.class);
	
	private List<SegOpcion> lasOpciones;
	private List<SegRol> losRoles;
	
	
	public boolean contains(String opcion) throws Exception {
		try {
			getLasOpciones();
						
			for(SegOpcion opc : lasOpciones) {
				if(opc.getNombre().toString().equals(opcion)) {
					log.info("TRUE");
					return true;
				}
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		}
		log.info("FALSE");
		return false;
	}
	
	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}

	public void setBusinessDelegatorView(IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}

	public List<SegOpcion> getLasOpciones() throws Exception {
		try {
			if(this.lasOpciones==null) {
				
				this.lasOpciones = new ArrayList<SegOpcion>();
				
				this.losRoles = (List<SegRol>) FacesUtils.getfromSession("roles");
				
				List<SegPermiso> losPermisos = new ArrayList<SegPermiso>();
				
				for(SegRol rol : this.losRoles) {
					
					Object[] variables = new Object[4];
					variables[0] = "rolId";
					variables[1] = false;
					variables[2] = rol.getRolId();
					variables[3] = "=";
					
					losPermisos = businessDelegatorView.findByCriteriaInSegPermiso(variables, null, null);
					
					for(SegPermiso permiso : losPermisos) {
						SegOpcion opc = businessDelegatorView.getSegOpcion(permiso.getSegOpcion().getOpcnId());
						this.lasOpciones.add(opc);
					}
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return this.lasOpciones;
	}

	public void setLasOpciones(List<SegOpcion> lasOpciones) {
		this.lasOpciones = lasOpciones;
	}
	
}