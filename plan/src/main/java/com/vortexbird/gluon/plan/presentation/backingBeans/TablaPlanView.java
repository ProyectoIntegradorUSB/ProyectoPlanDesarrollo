package com.vortexbird.gluon.plan.presentation.backingBeans;

import com.vortexbird.gluon.plan.exceptions.*;
import com.vortexbird.gluon.plan.modelo.*;
import com.vortexbird.gluon.plan.modelo.dto.GluoPlanDesarrolloDTO;
import com.vortexbird.gluon.plan.presentation.businessDelegate.*;
import com.vortexbird.gluon.plan.utilities.*;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import java.sql.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;


@ManagedBean
@ViewScoped
public class TablaPlanView {
	  private static final long serialVersionUID = 1L;
	  private static final Logger log = LoggerFactory.getLogger(GluoPlanDesarrolloView.class);
	  //componentes para la tabla
	    private InputTextarea txtAreaDescripcion;
	    private InputTextarea txtAreaDescripcion1;
	    private InputTextarea txtAreaDescripcion2;
	    private InputTextarea txtAreaDescripcion3;
	    private InputTextarea txtAreaDescripcion4;
	    
	    private InputTextarea txtAreaEslogan;
		private InputTextarea txtAreaEslogan1;
	    private InputTextarea txtAreaEslogan2;
	    private InputTextarea txtAreaEslogan3;
	    private InputTextarea txtAreaEslogan4;
	    
	    private InputText txtNombreAlcalde;
	    private InputText txtNombreAlcalde1;
	    private InputText txtNombreAlcalde2;
	    private InputText txtNombreAlcalde3;
	    private InputText txtNombreAlcalde4;
	    
	    private Calendar txtAnoFin;
	    private Calendar txtAnoFin1;
	    private Calendar txtAnoFin2;
	    private Calendar txtAnoFin3;
	    private Calendar txtAnoFin4;
	    
	    private Calendar txtAnoInicio;
	    private Calendar txtAnoInicio1;
	    private Calendar txtAnoInicio2;
	    private Calendar txtAnoInicio3;
	    private Calendar txtAnoInicio4;
	    //fin componentes para la tabla
	    
	    private InputText txtUsuCreador;
	    private InputText txtUsuModificador;
	    private InputText txtPlanId;
	    private Calendar txtFechaCreacion;
	    private Calendar txtFechaModificacion;
	    private CommandButton btnSave;
	    private CommandButton btnSave1;
	    private CommandButton btnSave2;
	    private CommandButton btnSave3;
	    private CommandButton btnSave4;
	    

		private List<GluoPlanDesarrolloDTO> data;
	    private GluoPlanDesarrolloDTO selectedGluoPlanDesarrollo;
	    private GluoPlanDesarrollo entity;
	    private boolean showDialog;
	    @ManagedProperty(value = "#{BusinessDelegatorView}")
	    private IBusinessDelegatorView businessDelegatorView;
	    
	    public TablaPlanView() {
	        super();
	    }
	    public String action_listenerCreate() {
	    	if(txtNombreAlcalde != null && txtAreaDescripcion != null) {
	    		listerner_guardar();
	    	}
	    	if (txtNombreAlcalde1 != null && txtAreaDescripcion1 !=null) {
	    		listerner_guardar1();
			}
	    	if (txtNombreAlcalde2 != null && txtAreaDescripcion2 !=null) {
	    		listerner_guardar2();
			}
	    	if (txtNombreAlcalde3 != null && txtAreaDescripcion3 !=null) {
	    		listerner_guardar3();
			}
	    	if (txtNombreAlcalde4 != null && txtAreaDescripcion4 !=null) {
	    		listerner_guardar4();
			}
	    	
	    	return "";
	    }
	    public String action_new() {
	        action_clear();
	        selectedGluoPlanDesarrollo = null;
	        setShowDialog(true);

	        return "";
	    }

	    public String action_clear() {
	        entity = null;
	        selectedGluoPlanDesarrollo = null;
	        

	        if (txtAreaDescripcion != null) {
	        	txtAreaDescripcion.setValue(null);
	        	txtAreaDescripcion.setDisabled(false);
	        }
	        if (txtAreaDescripcion1 != null) {
	        	txtAreaDescripcion1.setValue(null);
	        	txtAreaDescripcion1.setDisabled(false);
	        }
	        if (txtAreaDescripcion2 != null) {
	        	txtAreaDescripcion2.setValue(null);
	        	txtAreaDescripcion2.setDisabled(false);
	        }
	        if (txtAreaDescripcion3 != null) {
	        	txtAreaDescripcion3.setValue(null);
	        	txtAreaDescripcion3.setDisabled(false);
	        }
	        if (txtAreaDescripcion4 != null) {
	        	txtAreaDescripcion4.setValue(null);
	        	txtAreaDescripcion4.setDisabled(false);
	        }

	        if (txtAreaEslogan != null) {
	        	txtAreaEslogan.setValue(null);
	        	txtAreaEslogan.setDisabled(false);
	        }
	        if (txtAreaEslogan1 != null) {
	        	txtAreaEslogan1.setValue(null);
	        	txtAreaEslogan1.setDisabled(false);
	        }
	        if (txtAreaEslogan2 != null) {
	        	txtAreaEslogan2.setValue(null);
	        	txtAreaEslogan2.setDisabled(false);
	        }
	        if (txtAreaEslogan3 != null) {
	        	txtAreaEslogan3.setValue(null);
	        	txtAreaEslogan3.setDisabled(false);
	        }
	        if (txtAreaEslogan4 != null) {
	        	txtAreaEslogan4.setValue(null);
	        	txtAreaEslogan4.setDisabled(false);
	        }

	        if (txtNombreAlcalde != null) {
	            txtNombreAlcalde.setValue(null);
	            txtNombreAlcalde.setDisabled(true);
	        }
	        if (txtNombreAlcalde1 != null) {
	            txtNombreAlcalde1.setValue(null);
	            txtNombreAlcalde1.setDisabled(true);
	        }
	        if (txtNombreAlcalde2 != null) {
	            txtNombreAlcalde2.setValue(null);
	            txtNombreAlcalde2.setDisabled(true);
	        }
	        if (txtNombreAlcalde3 != null) {
	            txtNombreAlcalde3.setValue(null);
	            txtNombreAlcalde3.setDisabled(true);
	        }
	        if (txtNombreAlcalde4 != null) {
	            txtNombreAlcalde4.setValue(null);
	            txtNombreAlcalde4.setDisabled(true);
	        }

	        if (txtUsuCreador != null) {
	            txtUsuCreador.setValue(null);
	            txtUsuCreador.setDisabled(true);
	        }

	        if (txtUsuModificador != null) {
	            txtUsuModificador.setValue(null);
	            txtUsuModificador.setDisabled(true);
	        }

	        if (txtAnoFin != null) {
	            txtAnoFin.setValue(null);
	            txtAnoFin.setDisabled(false);
	        }
	        if (txtAnoFin1 != null) {
	            txtAnoFin1.setValue(null);
	            txtAnoFin1.setDisabled(false);
	        }
	        if (txtAnoFin2 != null) {
	            txtAnoFin2.setValue(null);
	            txtAnoFin2.setDisabled(false);
	        }
	        if (txtAnoFin3 != null) {
	            txtAnoFin3.setValue(null);
	            txtAnoFin3.setDisabled(false);
	        }
	        if (txtAnoFin4 != null) {
	            txtAnoFin4.setValue(null);
	            txtAnoFin4.setDisabled(false);
	        }
	        
	        if (txtAnoInicio != null) {
	            txtAnoInicio.setValue(null);
	            txtAnoInicio.setDisabled(false);
	        }
	        if (txtAnoInicio1 != null) {
	            txtAnoInicio1.setValue(null);
	            txtAnoInicio1.setDisabled(false);
	        }
	        if (txtAnoInicio2 != null) {
	            txtAnoInicio2.setValue(null);
	            txtAnoInicio2.setDisabled(false);
	        }
	        if (txtAnoInicio3 != null) {
	            txtAnoInicio3.setValue(null);
	            txtAnoInicio3.setDisabled(false);
	        }
	        if (txtAnoInicio4 != null) {
	            txtAnoInicio4.setValue(null);
	            txtAnoInicio4.setDisabled(false);
	        }

	        if (txtFechaCreacion != null) {
	            txtFechaCreacion.setValue(null);
	            txtFechaCreacion.setDisabled(true);
	        }

	        if (txtFechaModificacion != null) {
	            txtFechaModificacion.setValue(null);
	            txtFechaModificacion.setDisabled(true);
	        }

	        if (txtPlanId != null) {
	            txtPlanId.setValue(null);
	            txtPlanId.setDisabled(false);
	        }

	        if (btnSave != null) {
	            btnSave.setDisabled(false);
	        }

	        return "";
	    }

	    public void listener_txtAnoFin() {
	        Date inputDate = (Date) txtAnoFin.getValue();
	        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	        FacesContext.getCurrentInstance()
	                    .addMessage("",
	            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	    }

	    public void listener_txtAnoInicio() {
	        Date inputDate = (Date) txtAnoInicio.getValue();
	        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	        FacesContext.getCurrentInstance()
	                    .addMessage("",
	            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	    }

	    public void listener_txtFechaCreacion() {
	        Date inputDate = (Date) txtFechaCreacion.getValue();
	        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	        FacesContext.getCurrentInstance()
	                    .addMessage("",
	            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	    }

	    public void listener_txtFechaModificacion() {
	        Date inputDate = (Date) txtFechaModificacion.getValue();
	        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	        FacesContext.getCurrentInstance()
	                    .addMessage("",
	            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	    }
	    
	    public String listerner_guardar(){
	    	 try {
		            entity = new GluoPlanDesarrollo();

//		            Integer planId = FacesUtils.checkInteger(txtPlanId);

		            entity.setActivo("A");
		            entity.setAnoFin(FacesUtils.checkDate(txtAnoFin));
		            entity.setAnoInicio(FacesUtils.checkDate(txtAnoInicio));
		            entity.setDescripcion(FacesUtils.checkString(txtAreaDescripcion));
		            entity.setEslogan(FacesUtils.checkString(txtAreaEslogan));
		            entity.setFechaCreacion(new Date());
//		            entity.setFechaModificacion(FacesUtils.checkDate(
//		                    txtFechaModificacion));
		            entity.setNombreAlcalde(FacesUtils.checkString(txtNombreAlcalde));
//		            entity.setPlanId(planId);
		            SegUsuario segUsuario = (SegUsuario) FacesUtils.getfromSession("usuarioEnSession");
		            Integer usuaCreador = Integer.valueOf(segUsuario.getUsuId());
		            entity.setUsuCreador(usuaCreador);
//		            entity.setUsuModificador(FacesUtils.checkInteger(txtUsuModificador));
		            businessDelegatorView.saveGluoPlanDesarrollo(entity);
		            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
		            action_clear();
		        } catch (Exception e) {
		            entity = null;
		            FacesUtils.addErrorMessage(e.getMessage());
		        }

		        return "";
	    }
	    
	    public String listerner_guardar1(){
	    	 try {
		            entity = new GluoPlanDesarrollo();

//		            Integer planId = FacesUtils.checkInteger(txtPlanId);

		            entity.setActivo("A");
		            entity.setAnoFin(FacesUtils.checkDate(txtAnoFin1));
		            entity.setAnoInicio(FacesUtils.checkDate(txtAnoInicio1));
		            entity.setDescripcion(FacesUtils.checkString(txtAreaDescripcion1));
		            entity.setEslogan(FacesUtils.checkString(txtAreaEslogan1));
		            entity.setFechaCreacion(new Date());
//		            entity.setFechaModificacion(FacesUtils.checkDate(
//		                    txtFechaModificacion));
		            entity.setNombreAlcalde(FacesUtils.checkString(txtNombreAlcalde1));
//		            entity.setPlanId(planId);
		            SegUsuario segUsuario = (SegUsuario) FacesUtils.getfromSession("usuarioEnSession");
		            Integer usuaCreador = Integer.valueOf(segUsuario.getUsuId());
		            entity.setUsuCreador(usuaCreador);
//		            entity.setUsuModificador(FacesUtils.checkInteger(txtUsuModificador));
		            businessDelegatorView.saveGluoPlanDesarrollo(entity);
		            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
		            action_clear();
		        } catch (Exception e) {
		            entity = null;
		            FacesUtils.addErrorMessage(e.getMessage());
		        }

		        return "";
	    }
	    
	    public String listerner_guardar2(){
	    	 try {
		            entity = new GluoPlanDesarrollo();

//		            Integer planId = FacesUtils.checkInteger(txtPlanId);

		            entity.setActivo("A");
		            entity.setAnoFin(FacesUtils.checkDate(txtAnoFin2));
		            entity.setAnoInicio(FacesUtils.checkDate(txtAnoInicio2));
		            entity.setDescripcion(FacesUtils.checkString(txtAreaDescripcion2));
		            entity.setEslogan(FacesUtils.checkString(txtAreaEslogan2));
		            entity.setFechaCreacion(new Date());
//		            entity.setFechaModificacion(FacesUtils.checkDate(
//		                    txtFechaModificacion));
		            entity.setNombreAlcalde(FacesUtils.checkString(txtNombreAlcalde2));
//		            entity.setPlanId(planId);
		            SegUsuario segUsuario = (SegUsuario) FacesUtils.getfromSession("usuarioEnSession");
		            Integer usuaCreador = Integer.valueOf(segUsuario.getUsuId());
		            entity.setUsuCreador(usuaCreador);
//		            entity.setUsuModificador(FacesUtils.checkInteger(txtUsuModificador));
		            businessDelegatorView.saveGluoPlanDesarrollo(entity);
		            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
		            action_clear();
		        } catch (Exception e) {
		            entity = null;
		            FacesUtils.addErrorMessage(e.getMessage());
		        }

		        return "";
	    }
	    
	    public String listerner_guardar3(){
	    	 try {
		            entity = new GluoPlanDesarrollo();

//		            Integer planId = FacesUtils.checkInteger(txtPlanId);

		            entity.setActivo("A");
		            entity.setAnoFin(FacesUtils.checkDate(txtAnoFin3));
		            entity.setAnoInicio(FacesUtils.checkDate(txtAnoInicio3));
		            entity.setDescripcion(FacesUtils.checkString(txtAreaDescripcion3));
		            entity.setEslogan(FacesUtils.checkString(txtAreaEslogan3));
		            entity.setFechaCreacion(new Date());
//		            entity.setFechaModificacion(FacesUtils.checkDate(
//		                    txtFechaModificacion));
		            entity.setNombreAlcalde(FacesUtils.checkString(txtNombreAlcalde3));
//		            entity.setPlanId(planId);
		            SegUsuario segUsuario = (SegUsuario) FacesUtils.getfromSession("usuarioEnSession");
		            Integer usuaCreador = Integer.valueOf(segUsuario.getUsuId());
		            entity.setUsuCreador(usuaCreador);
//		            entity.setUsuModificador(FacesUtils.checkInteger(txtUsuModificador));
		            businessDelegatorView.saveGluoPlanDesarrollo(entity);
		            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
		            action_clear();
		        } catch (Exception e) {
		            entity = null;
		            FacesUtils.addErrorMessage(e.getMessage());
		        }

		        return "";
	    }
	    
	    public String listerner_guardar4(){
	    	 try {
		            entity = new GluoPlanDesarrollo();

//		            Integer planId = FacesUtils.checkInteger(txtPlanId);

		            entity.setActivo("A");
		            entity.setAnoFin(FacesUtils.checkDate(txtAnoFin4));
		            entity.setAnoInicio(FacesUtils.checkDate(txtAnoInicio4));
		            entity.setDescripcion(FacesUtils.checkString(txtAreaDescripcion4));
		            entity.setEslogan(FacesUtils.checkString(txtAreaEslogan4));
		            entity.setFechaCreacion(new Date());
//		            entity.setFechaModificacion(FacesUtils.checkDate(
//		                    txtFechaModificacion));
		            entity.setNombreAlcalde(FacesUtils.checkString(txtNombreAlcalde4));
//		            entity.setPlanId(planId);
		            SegUsuario segUsuario = (SegUsuario) FacesUtils.getfromSession("usuarioEnSession");
		            Integer usuaCreador = Integer.valueOf(segUsuario.getUsuId());
		            entity.setUsuCreador(usuaCreador);
//		            entity.setUsuModificador(FacesUtils.checkInteger(txtUsuModificador));
		            businessDelegatorView.saveGluoPlanDesarrollo(entity);
		            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
		            action_clear();
		        } catch (Exception e) {
		            entity = null;
		            FacesUtils.addErrorMessage(e.getMessage());
		        }

		        return "";
	    }
	    public void onCellEdit(CellEditEvent event) {
	        Object oldValue = event.getOldValue();
	        Object newValue = event.getNewValue();
	         
	        if(newValue != null && !newValue.equals(oldValue)) {
	            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
	            FacesContext.getCurrentInstance().addMessage(null, msg);
	        }
	    }
	        
	    public void listener_txtId() {
	        try {
	            Integer planId = FacesUtils.checkInteger(txtPlanId);
	            entity = (planId != null)
	                ? businessDelegatorView.getGluoPlanDesarrollo(planId) : null;
	        } catch (Exception e) {
	            entity = null;
	        }

	        if (entity == null) {
//	            txtActivo.setDisabled(false);
	        	txtAreaDescripcion.setDisabled(false);
	        	txtAreaEslogan.setDisabled(false);
	            txtNombreAlcalde.setDisabled(false);
	            txtUsuCreador.setDisabled(false);
	            txtUsuModificador.setDisabled(false);
	            txtAnoFin.setDisabled(false);
	            txtAnoInicio.setDisabled(false);
	            txtFechaCreacion.setDisabled(false);
	            txtFechaModificacion.setDisabled(false);
	            txtPlanId.setDisabled(false);
	            btnSave.setDisabled(false);
	        } else {
//	            txtActivo.setValue(entity.getActivo());
//	            txtActivo.setDisabled(false);
	            txtAnoFin.setValue(entity.getAnoFin());
	            txtAnoFin.setDisabled(false);
	            txtAnoInicio.setValue(entity.getAnoInicio());
	            txtAnoInicio.setDisabled(false);
	            txtAreaDescripcion.setValue(entity.getDescripcion());
	            txtAreaDescripcion.setDisabled(false);
	            txtAreaEslogan.setValue(entity.getEslogan());
	            txtAreaEslogan.setDisabled(false);
	            txtFechaCreacion.setValue(entity.getFechaCreacion());
	            txtFechaCreacion.setDisabled(false);
	            txtFechaModificacion.setValue(entity.getFechaModificacion());
	            txtFechaModificacion.setDisabled(false);
	            txtNombreAlcalde.setValue(entity.getNombreAlcalde());
	            txtNombreAlcalde.setDisabled(false);
	            txtUsuCreador.setValue(entity.getUsuCreador());
	            txtUsuCreador.setDisabled(false);
	            txtUsuModificador.setValue(entity.getUsuModificador());
	            txtUsuModificador.setDisabled(false);
	            txtPlanId.setValue(entity.getPlanId());
	            txtPlanId.setDisabled(true);
	            btnSave.setDisabled(false);
	        }
	    }

	    public String action_edit(ActionEvent evt) {
	        selectedGluoPlanDesarrollo = (GluoPlanDesarrolloDTO) (evt.getComponent()
	                                                                 .getAttributes()
	                                                                 .get("selectedGluoPlanDesarrollo"));
//	        txtActivo.setValue(selectedGluoPlanDesarrollo.getActivo());
//	        txtActivo.setDisabled(false);
	        txtAnoFin.setValue(selectedGluoPlanDesarrollo.getAnoFin());
	        txtAnoFin.setDisabled(false);
	        txtAnoInicio.setValue(selectedGluoPlanDesarrollo.getAnoInicio());
	        txtAnoInicio.setDisabled(false);
	        txtAreaDescripcion.setValue(selectedGluoPlanDesarrollo.getDescripcion());
	        txtAreaDescripcion.setDisabled(false);
	        txtAreaEslogan.setValue(selectedGluoPlanDesarrollo.getEslogan());
	        txtAreaEslogan.setDisabled(false);
	        txtFechaCreacion.setValue(selectedGluoPlanDesarrollo.getFechaCreacion());
	        txtFechaCreacion.setDisabled(true);
	        txtFechaModificacion.setValue(selectedGluoPlanDesarrollo.getFechaModificacion());
	        txtFechaModificacion.setDisabled(true);
	        txtNombreAlcalde.setValue(selectedGluoPlanDesarrollo.getNombreAlcalde());
	        txtNombreAlcalde.setDisabled(false);
	        txtUsuCreador.setValue(selectedGluoPlanDesarrollo.getUsuCreador());
	        txtUsuCreador.setDisabled(true);
	        txtUsuModificador.setValue(selectedGluoPlanDesarrollo.getUsuModificador());
	        txtUsuModificador.setDisabled(true);
	        txtPlanId.setValue(selectedGluoPlanDesarrollo.getPlanId());
	        txtPlanId.setDisabled(true);
	        btnSave.setDisabled(false);
	        setShowDialog(true);

	        return "";
	    }

	    public String action_save() {
	        try {
	            if ((selectedGluoPlanDesarrollo == null) && (entity == null)) {
	                action_create();
	            } else {
	                action_modify();
	            }

	            data = null;
	        } catch (Exception e) {
	            FacesUtils.addErrorMessage(e.getMessage());
	        }

	        return "";
	    }

	    public String action_create() {
	        try {
	            entity = new GluoPlanDesarrollo();

//	            Integer planId = FacesUtils.checkInteger(txtPlanId);

	            entity.setActivo("A");
	            entity.setAnoFin(FacesUtils.checkDate(txtAnoFin));
	            entity.setAnoInicio(FacesUtils.checkDate(txtAnoInicio));
	            entity.setDescripcion(FacesUtils.checkString(txtAreaDescripcion));
	            entity.setEslogan(FacesUtils.checkString(txtAreaEslogan));
	            entity.setFechaCreacion(new Date());
//	            entity.setFechaModificacion(FacesUtils.checkDate(
//	                    txtFechaModificacion));
	            entity.setNombreAlcalde(FacesUtils.checkString(txtNombreAlcalde));
//	            entity.setPlanId(planId);
	            SegUsuario segUsuario = (SegUsuario) FacesUtils.getfromSession("usuarioEnSession");
	            Integer usuaCreador = Integer.valueOf(segUsuario.getUsuId());
	            entity.setUsuCreador(usuaCreador);
//	            entity.setUsuModificador(FacesUtils.checkInteger(txtUsuModificador));
	            businessDelegatorView.saveGluoPlanDesarrollo(entity);
	            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
	            action_clear();
	        } catch (Exception e) {
	            entity = null;
	            FacesUtils.addErrorMessage(e.getMessage());
	        }

	        return "";
	    }

	    public String action_modify() {
	        try {
	            if (entity == null) {
	                Integer planId = new Integer(selectedGluoPlanDesarrollo.getPlanId());
	                entity = businessDelegatorView.getGluoPlanDesarrollo(planId);
	            }

	            entity.setActivo("A");
	            entity.setAnoFin(FacesUtils.checkDate(txtAnoFin));
	            entity.setAnoInicio(FacesUtils.checkDate(txtAnoInicio));
	            entity.setDescripcion(FacesUtils.checkString(txtAreaDescripcion));
	            entity.setEslogan(FacesUtils.checkString(txtAreaEslogan));
//	            entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
	            entity.setFechaModificacion(
	                    new Date());
	            entity.setNombreAlcalde(FacesUtils.checkString(txtNombreAlcalde));
//	            entity.setUsuCreador(FacesUtils.checkInteger(txtUsuCreador));
	            SegUsuario segUsuario = (SegUsuario) FacesUtils.getfromSession("usuarioEnSession");
	            Integer usuaModificador = Integer.valueOf(segUsuario.getUsuId());
	            
	            entity.setUsuModificador(usuaModificador);
	            businessDelegatorView.updateGluoPlanDesarrollo(entity);
	            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
	        } catch (Exception e) {
	            data = null;
	            FacesUtils.addErrorMessage(e.getMessage());
	        }

	        return "";
	    }

	    public String action_delete_datatable(ActionEvent evt) {
	        try {
	            selectedGluoPlanDesarrollo = (GluoPlanDesarrolloDTO) (evt.getComponent()
	                                                                     .getAttributes()
	                                                                     .get("selectedGluoPlanDesarrollo"));

	            Integer planId = new Integer(selectedGluoPlanDesarrollo.getPlanId());
	            entity = businessDelegatorView.getGluoPlanDesarrollo(planId);
	            action_delete();
	        } catch (Exception e) {
	            FacesUtils.addErrorMessage(e.getMessage());
	        }

	        return "";
	    }

	    public String action_delete_master() {
	        try {
	            Integer planId = FacesUtils.checkInteger(txtPlanId);
	            entity = businessDelegatorView.getGluoPlanDesarrollo(planId);
	            action_delete();
	        } catch (Exception e) {
	            FacesUtils.addErrorMessage(e.getMessage());
	        }

	        return "";
	    }

	    public void action_delete() throws Exception {
	        try {
	            businessDelegatorView.deleteGluoPlanDesarrollo(entity);
	            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
	            action_clear();
	            data = null;
	        } catch (Exception e) {
	            throw e;
	        }
	    }

	    public String action_closeDialog() {
	        setShowDialog(false);
	        action_clear();

	        return "";
	    }

	    public String action_modifyWitDTO(String activo, Date anoFin,
	        Date anoInicio, String descripcion, String eslogan, Date fechaCreacion,
	        Date fechaModificacion, String nombreAlcalde, Integer planId,
	        Integer usuCreador, Integer usuModificador) throws Exception {
	        try {
	            entity.setActivo(FacesUtils.checkString(activo));
	            entity.setAnoFin(FacesUtils.checkDate(anoFin));
	            entity.setAnoInicio(FacesUtils.checkDate(anoInicio));
	            entity.setDescripcion(FacesUtils.checkString(descripcion));
	            entity.setEslogan(FacesUtils.checkString(eslogan));
	            entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
	            entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
	            entity.setNombreAlcalde(FacesUtils.checkString(nombreAlcalde));
	            entity.setUsuCreador(FacesUtils.checkInteger(usuCreador));
	            entity.setUsuModificador(FacesUtils.checkInteger(usuModificador));
	            businessDelegatorView.updateGluoPlanDesarrollo(entity);
	            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
	        } catch (Exception e) {
	            //renderManager.getOnDemandRenderer("GluoPlanDesarrolloView").requestRender();
	            FacesUtils.addErrorMessage(e.getMessage());
	            throw e;
	        }

	        return "";
	    }
	    public CommandButton getBtnSave1() {
			return btnSave1;
		}
		public void setBtnSave1(CommandButton btnSave1) {
			this.btnSave1 = btnSave1;
		}
		public CommandButton getBtnSave2() {
			return btnSave2;
		}
		public void setBtnSave2(CommandButton btnSave2) {
			this.btnSave2 = btnSave2;
		}
		public CommandButton getBtnSave3() {
			return btnSave3;
		}
		public void setBtnSave3(CommandButton btnSave3) {
			this.btnSave3 = btnSave3;
		}
		public CommandButton getBtnSave4() {
			return btnSave4;
		}
		public void setBtnSave4(CommandButton btnSave4) {
			this.btnSave4 = btnSave4;
		}
	    public InputTextarea getTxtAreaDescripcion1() {
			return txtAreaDescripcion1;
		}
		public void setTxtAreaDescripcion1(InputTextarea txtAreaDescripcion1) {
			this.txtAreaDescripcion1 = txtAreaDescripcion1;
		}
		public InputTextarea getTxtAreaDescripcion2() {
			return txtAreaDescripcion2;
		}
		public void setTxtAreaDescripcion2(InputTextarea txtAreaDescripcion2) {
			this.txtAreaDescripcion2 = txtAreaDescripcion2;
		}
		public InputTextarea getTxtAreaDescripcion3() {
			return txtAreaDescripcion3;
		}
		public void setTxtAreaDescripcion3(InputTextarea txtAreaDescripcion3) {
			this.txtAreaDescripcion3 = txtAreaDescripcion3;
		}
		public InputTextarea getTxtAreaDescripcion4() {
			return txtAreaDescripcion4;
		}
		public void setTxtAreaDescripcion4(InputTextarea txtAreaDescripcion4) {
			this.txtAreaDescripcion4 = txtAreaDescripcion4;
		}
		public InputTextarea getTxtAreaEslogan1() {
			return txtAreaEslogan1;
		}
		public void setTxtAreaEslogan1(InputTextarea txtAreaEslogan1) {
			this.txtAreaEslogan1 = txtAreaEslogan1;
		}
		public InputTextarea getTxtAreaEslogan2() {
			return txtAreaEslogan2;
		}
		public void setTxtAreaEslogan2(InputTextarea txtAreaEslogan2) {
			this.txtAreaEslogan2 = txtAreaEslogan2;
		}
		public InputTextarea getTxtAreaEslogan3() {
			return txtAreaEslogan3;
		}
		public void setTxtAreaEslogan3(InputTextarea txtAreaEslogan3) {
			this.txtAreaEslogan3 = txtAreaEslogan3;
		}
		public InputTextarea getTxtAreaEslogan4() {
			return txtAreaEslogan4;
		}
		public void setTxtAreaEslogan4(InputTextarea txtAreaEslogan4) {
			this.txtAreaEslogan4 = txtAreaEslogan4;
		}
		public InputText getTxtNombreAlcalde1() {
			return txtNombreAlcalde1;
		}
		public void setTxtNombreAlcalde1(InputText txtNombreAlcalde1) {
			this.txtNombreAlcalde1 = txtNombreAlcalde1;
		}
		public InputText getTxtNombreAlcalde2() {
			return txtNombreAlcalde2;
		}
		public void setTxtNombreAlcalde2(InputText txtNombreAlcalde2) {
			this.txtNombreAlcalde2 = txtNombreAlcalde2;
		}
		public InputText getTxtNombreAlcalde3() {
			return txtNombreAlcalde3;
		}
		public void setTxtNombreAlcalde3(InputText txtNombreAlcalde3) {
			this.txtNombreAlcalde3 = txtNombreAlcalde3;
		}
		public InputText getTxtNombreAlcalde4() {
			return txtNombreAlcalde4;
		}
		public void setTxtNombreAlcalde4(InputText txtNombreAlcalde4) {
			this.txtNombreAlcalde4 = txtNombreAlcalde4;
		}
		public Calendar getTxtAnoFin1() {
			return txtAnoFin1;
		}
		public void setTxtAnoFin1(Calendar txtAnoFin1) {
			this.txtAnoFin1 = txtAnoFin1;
		}
		public Calendar getTxtAnoFin2() {
			return txtAnoFin2;
		}
		public void setTxtAnoFin2(Calendar txtAnoFin2) {
			this.txtAnoFin2 = txtAnoFin2;
		}
		public Calendar getTxtAnoFin3() {
			return txtAnoFin3;
		}
		public void setTxtAnoFin3(Calendar txtAnoFin3) {
			this.txtAnoFin3 = txtAnoFin3;
		}
		public Calendar getTxtAnoFin4() {
			return txtAnoFin4;
		}
		public void setTxtAnoFin4(Calendar txtAnoFin4) {
			this.txtAnoFin4 = txtAnoFin4;
		}
		public Calendar getTxtAnoInicio1() {
			return txtAnoInicio1;
		}
		public void setTxtAnoInicio1(Calendar txtAnoInicio1) {
			this.txtAnoInicio1 = txtAnoInicio1;
		}
		public Calendar getTxtAnoInicio2() {
			return txtAnoInicio2;
		}
		public void setTxtAnoInicio2(Calendar txtAnoInicio2) {
			this.txtAnoInicio2 = txtAnoInicio2;
		}
		public Calendar getTxtAnoInicio3() {
			return txtAnoInicio3;
		}
		public void setTxtAnoInicio3(Calendar txtAnoInicio3) {
			this.txtAnoInicio3 = txtAnoInicio3;
		}
		public Calendar getTxtAnoInicio4() {
			return txtAnoInicio4;
		}
		public void setTxtAnoInicio4(Calendar txtAnoInicio4) {
			this.txtAnoInicio4 = txtAnoInicio4;
		}

	    public InputText getTxtNombreAlcalde() {
	        return txtNombreAlcalde;
	    }


		public InputTextarea getTxtAreaDescripcion() {
			return txtAreaDescripcion;
		}

		public void setTxtAreaDescripcion(InputTextarea txtAreaDescripcion) {
			this.txtAreaDescripcion = txtAreaDescripcion;
		}

		public InputTextarea getTxtAreaEslogan() {
			return txtAreaEslogan;
		}

		public void setTxtAreaEslogan(InputTextarea txtAreaEslogan) {
			this.txtAreaEslogan = txtAreaEslogan;
		}

		public void setTxtNombreAlcalde(InputText txtNombreAlcalde) {
	        this.txtNombreAlcalde = txtNombreAlcalde;
	    }

	    public InputText getTxtUsuCreador() {
	        return txtUsuCreador;
	    }

	    public void setTxtUsuCreador(InputText txtUsuCreador) {
	        this.txtUsuCreador = txtUsuCreador;
	    }

	    public InputText getTxtUsuModificador() {
	        return txtUsuModificador;
	    }

	    public void setTxtUsuModificador(InputText txtUsuModificador) {
	        this.txtUsuModificador = txtUsuModificador;
	    }

	    public Calendar getTxtAnoFin() {
	        return txtAnoFin;
	    }

	    public void setTxtAnoFin(Calendar txtAnoFin) {
	        this.txtAnoFin = txtAnoFin;
	    }

	    public Calendar getTxtAnoInicio() {
	        return txtAnoInicio;
	    }

	    public void setTxtAnoInicio(Calendar txtAnoInicio) {
	        this.txtAnoInicio = txtAnoInicio;
	    }

	    public Calendar getTxtFechaCreacion() {
	        return txtFechaCreacion;
	    }

	    public void setTxtFechaCreacion(Calendar txtFechaCreacion) {
	        this.txtFechaCreacion = txtFechaCreacion;
	    }

	    public Calendar getTxtFechaModificacion() {
	        return txtFechaModificacion;
	    }

	    public void setTxtFechaModificacion(Calendar txtFechaModificacion) {
	        this.txtFechaModificacion = txtFechaModificacion;
	    }

	    public InputText getTxtPlanId() {
	        return txtPlanId;
	    }

	    public void setTxtPlanId(InputText txtPlanId) {
	        this.txtPlanId = txtPlanId;
	    }

	    public List<GluoPlanDesarrolloDTO> getData() {
	        try {
	            if (data == null) {
	                data = businessDelegatorView.getDataGluoPlanDesarrollo();
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return data;
	    }

	    public void setData(List<GluoPlanDesarrolloDTO> gluoPlanDesarrolloDTO) {
	        this.data = gluoPlanDesarrolloDTO;
	    }

	    public GluoPlanDesarrolloDTO getSelectedGluoPlanDesarrollo() {
	        return selectedGluoPlanDesarrollo;
	    }

	    public void setSelectedGluoPlanDesarrollo(
	        GluoPlanDesarrolloDTO gluoPlanDesarrollo) {
	        this.selectedGluoPlanDesarrollo = gluoPlanDesarrollo;
	    }

	    public CommandButton getBtnSave() {
	        return btnSave;
	    }

	    public void setBtnSave(CommandButton btnSave) {
	        this.btnSave = btnSave;
	    }

	    public TimeZone getTimeZone() {
	        return java.util.TimeZone.getDefault();
	    }

	    public IBusinessDelegatorView getBusinessDelegatorView() {
	        return businessDelegatorView;
	    }

	    public void setBusinessDelegatorView(
	        IBusinessDelegatorView businessDelegatorView) {
	        this.businessDelegatorView = businessDelegatorView;
	    }

	    public boolean isShowDialog() {
	        return showDialog;
	    }

	    public void setShowDialog(boolean showDialog) {
	        this.showDialog = showDialog;
	    }
	}
