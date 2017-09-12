package com.vortexbird.gluon.plan.presentation.backingBeans;

import com.vortexbird.gluon.plan.exceptions.*;
import com.vortexbird.gluon.plan.modelo.*;
import com.vortexbird.gluon.plan.modelo.dto.GluoAnoFiscalDTO;
import com.vortexbird.gluon.plan.presentation.businessDelegate.*;
import com.vortexbird.gluon.plan.utilities.*;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
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

/**
 * @author Zathura Code Generator http://zathuracode.org/ www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class GluoAnoFiscalView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(GluoAnoFiscalView.class);

	private String somActivo;

	private InputText txtAnoFiscal;
	private InputTextarea txtAreaDescripcion;
	private InputText txtEmprId;
	private InputText txtEstado;
	private InputText txtUsuCreador;
	private InputText txtUsuModificador;
	private InputText txtValorSalarioMinimo;
	private InputText txtAnofId;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaIncioAnoFiscal;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<GluoAnoFiscalDTO> data;
	private GluoAnoFiscalDTO selectedGluoAnoFiscal;
	private GluoAnoFiscal entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public GluoAnoFiscalView() {
		super();
	}

	public String action_new() {
		action_clear();
		selectedGluoAnoFiscal = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedGluoAnoFiscal = null;

		// if (txtActivo != null) {
		// txtActivo.setValue(null);
		// txtActivo.setDisabled(true);
		// }

		if (txtAnoFiscal != null) {
			txtAnoFiscal.setValue(null);
			txtAnoFiscal.setDisabled(true);
		}

		if (txtAreaDescripcion != null) {
			txtAreaDescripcion.setValue(null);
			txtAreaDescripcion.setDisabled(true);
		}

		if (txtEmprId != null) {
			txtEmprId.setValue(null);
			txtEmprId.setDisabled(true);
		}

		if (txtEstado != null) {
			txtEstado.setValue(null);
			txtEstado.setDisabled(true);
		}

		if (txtUsuCreador != null) {
			txtUsuCreador.setValue(null);
			txtUsuCreador.setDisabled(true);
		}

		if (txtUsuModificador != null) {
			txtUsuModificador.setValue(null);
			txtUsuModificador.setDisabled(true);
		}

		if (txtValorSalarioMinimo != null) {
			txtValorSalarioMinimo.setValue(null);
			txtValorSalarioMinimo.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaIncioAnoFiscal != null) {
			txtFechaIncioAnoFiscal.setValue(null);
			txtFechaIncioAnoFiscal.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtAnofId != null) {
			txtAnofId.setValue(null);
			txtAnofId.setDisabled(false);
		}

		if (btnSave != null) {
			btnSave.setDisabled(true);
		}

		if (btnDelete != null) {
			btnDelete.setDisabled(true);
		}

		return "";
	}

	public void listener_txtFechaCreacion() {
		Date inputDate = (Date) txtFechaCreacion.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public void listener_txtFechaIncioAnoFiscal() {
		Date inputDate = (Date) txtFechaIncioAnoFiscal.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public void listener_txtFechaModificacion() {
		Date inputDate = (Date) txtFechaModificacion.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public void listener_txtId() {
		try {
			Integer anofId = FacesUtils.checkInteger(txtAnofId);
			entity = (anofId != null) ? businessDelegatorView.getGluoAnoFiscal(anofId) : null;
		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {
			// txtActivo.setDisabled(false);
			txtAnoFiscal.setDisabled(false);
			txtAreaDescripcion.setDisabled(false);
			txtEmprId.setDisabled(false);
			txtEstado.setDisabled(false);
			txtUsuCreador.setDisabled(false);
			txtUsuModificador.setDisabled(false);
			txtValorSalarioMinimo.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaIncioAnoFiscal.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtAnofId.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			// txtActivo.setValue(entity.getActivo());
			// txtActivo.setDisabled(false);
			txtAnoFiscal.setValue(entity.getAnoFiscal());
			txtAnoFiscal.setDisabled(false);
			txtAreaDescripcion.setValue(entity.getDescripcion());
			txtAreaDescripcion.setDisabled(false);
			txtEmprId.setValue(entity.getEmprId());
			txtEmprId.setDisabled(false);
			txtEstado.setValue(entity.getEstado());
			txtEstado.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaIncioAnoFiscal.setValue(entity.getFechaIncioAnoFiscal());
			txtFechaIncioAnoFiscal.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtUsuCreador.setValue(entity.getUsuCreador());
			txtUsuCreador.setDisabled(false);
			txtUsuModificador.setValue(entity.getUsuModificador());
			txtUsuModificador.setDisabled(false);
			txtValorSalarioMinimo.setValue(entity.getValorSalarioMinimo());
			txtValorSalarioMinimo.setDisabled(false);
			txtAnofId.setValue(entity.getAnofId());
			txtAnofId.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedGluoAnoFiscal = (GluoAnoFiscalDTO) (evt.getComponent().getAttributes().get("selectedGluoAnoFiscal"));
		// txtActivo.setValue(selectedGluoAnoFiscal.getActivo());
		// txtActivo.setDisabled(false);
		txtAnoFiscal.setValue(selectedGluoAnoFiscal.getAnoFiscal());
		txtAnoFiscal.setDisabled(false);
		txtAreaDescripcion.setValue(selectedGluoAnoFiscal.getDescripcion());
		txtAreaDescripcion.setDisabled(false);
		txtEmprId.setValue(selectedGluoAnoFiscal.getEmprId());
		txtEmprId.setDisabled(false);
		txtEstado.setValue(selectedGluoAnoFiscal.getEstado());
		txtEstado.setDisabled(false);
		txtFechaCreacion.setValue(selectedGluoAnoFiscal.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaIncioAnoFiscal.setValue(selectedGluoAnoFiscal.getFechaIncioAnoFiscal());
		txtFechaIncioAnoFiscal.setDisabled(false);
		txtFechaModificacion.setValue(selectedGluoAnoFiscal.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtUsuCreador.setValue(selectedGluoAnoFiscal.getUsuCreador());
		txtUsuCreador.setDisabled(false);
		txtUsuModificador.setValue(selectedGluoAnoFiscal.getUsuModificador());
		txtUsuModificador.setDisabled(false);
		txtValorSalarioMinimo.setValue(selectedGluoAnoFiscal.getValorSalarioMinimo());
		txtValorSalarioMinimo.setDisabled(false);
		txtAnofId.setValue(selectedGluoAnoFiscal.getAnofId());
		txtAnofId.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedGluoAnoFiscal == null) && (entity == null)) {
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
			entity = new GluoAnoFiscal();

			// Integer anofId = FacesUtils.checkInteger(txtAnofId);

			entity.setActivo(somActivo);
			entity.setAnoFiscal(FacesUtils.checkInteger(txtAnoFiscal));
			
			entity.setDescripcion(FacesUtils.checkString(txtAreaDescripcion));
			entity.setEmprId(FacesUtils.checkInteger(txtEmprId));
			entity.setEstado(FacesUtils.checkString(txtEstado));
			entity.setFechaCreacion(new Date());
            entity.setFechaIncioAnoFiscal(FacesUtils.checkDate(txtFechaIncioAnoFiscal));
            
			SegUsuario segUsuario = (SegUsuario) FacesUtils.getfromSession("usuarioEnSession");
			Integer usuaCreador = Integer.valueOf(segUsuario.getUsuId());
			entity.setUsuCreador(usuaCreador);
            // entity.setAnofId(anofId);
			
			// entity.setFechaModificacion(FacesUtils.checkDate( txtFechaModificacion));
			// entity.setUsuCreador(FacesUtils.checkInteger(txtUsuCreador));
			// entity.setUsuModificador(FacesUtils.checkInteger(txtUsuModificador));
			entity.setValorSalarioMinimo(FacesUtils.checkDouble(txtValorSalarioMinimo));
			businessDelegatorView.saveGluoAnoFiscal(entity);
			FacesContext.getCurrentInstance().addMessage("", 
					new FacesMessage(FacesMessage.SEVERITY_INFO, "El Año Fiscal se ha almacenado con exito", ""));
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
				Integer anofId = new Integer(selectedGluoAnoFiscal.getAnofId());
				entity = businessDelegatorView.getGluoAnoFiscal(anofId);
			}

			entity.setActivo(somActivo);
			entity.setAnoFiscal(FacesUtils.checkInteger(txtAnoFiscal));
			entity.setDescripcion(FacesUtils.checkString(txtAreaDescripcion));
			entity.setEmprId(FacesUtils.checkInteger(txtEmprId));
			entity.setEstado(FacesUtils.checkString(txtEstado));

			entity.setFechaIncioAnoFiscal(FacesUtils.checkDate(txtFechaIncioAnoFiscal));
			entity.setFechaModificacion(new Date());

			SegUsuario segUsuario = (SegUsuario) FacesUtils.getfromSession("usuarioEnSession");
			Integer usuaModificador = Integer.valueOf(segUsuario.getUsuId());
			entity.setUsuModificador(usuaModificador);
			
			// entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			// entity.setUsuCreador(FacesUtils.checkInteger(txtUsuCreador));
			// entity.setUsuModificador(FacesUtils.checkInteger(txtUsuModificador));
			entity.setValorSalarioMinimo(FacesUtils.checkDouble(txtValorSalarioMinimo));
			businessDelegatorView.updateGluoAnoFiscal(entity);
			FacesContext.getCurrentInstance().addMessage("", 
					new FacesMessage(FacesMessage.SEVERITY_WARN, "El Año Fiscal ha sido modificado", ""));
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedGluoAnoFiscal = (GluoAnoFiscalDTO) (evt.getComponent().getAttributes()
					.get("selectedGluoAnoFiscal"));

			Integer anofId = new Integer(selectedGluoAnoFiscal.getAnofId());
			entity = businessDelegatorView.getGluoAnoFiscal(anofId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Integer anofId = FacesUtils.checkInteger(txtAnofId);
			entity = businessDelegatorView.getGluoAnoFiscal(anofId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteGluoAnoFiscal(entity);
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

	public String action_modifyWitDTO(String activo, Integer anoFiscal, Integer anofId, String descripcion,
			Integer emprId, String estado, Date fechaCreacion, Date fechaIncioAnoFiscal, Date fechaModificacion,
			Integer usuCreador, Integer usuModificador, Double valorSalarioMinimo) throws Exception {
		try {
			entity.setActivo(FacesUtils.checkString(activo));
			entity.setAnoFiscal(FacesUtils.checkInteger(anoFiscal));
			entity.setDescripcion(FacesUtils.checkString(descripcion));
			entity.setEmprId(FacesUtils.checkInteger(emprId));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaIncioAnoFiscal(FacesUtils.checkDate(fechaIncioAnoFiscal));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setUsuCreador(FacesUtils.checkInteger(usuCreador));
			entity.setUsuModificador(FacesUtils.checkInteger(usuModificador));
			entity.setValorSalarioMinimo(FacesUtils.checkDouble(valorSalarioMinimo));
			businessDelegatorView.updateGluoAnoFiscal(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("GluoAnoFiscalView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public String getSomActivo() {
		return somActivo;
	}

	public void setSomActivo(String somActivo) {
		this.somActivo = somActivo;
	}

	public InputText getTxtAnoFiscal() {
		return txtAnoFiscal;
	}

	public void setTxtAnoFiscal(InputText txtAnoFiscal) {
		this.txtAnoFiscal = txtAnoFiscal;
	}

	public InputTextarea getTxtAreaDescripcion() {
		return txtAreaDescripcion;
	}

	public void setTxtAreaDescripcion(InputTextarea txtAreaDescripcion) {
		this.txtAreaDescripcion = txtAreaDescripcion;
	}

	public InputText getTxtEmprId() {
		return txtEmprId;
	}

	public void setTxtEmprId(InputText txtEmprId) {
		this.txtEmprId = txtEmprId;
	}

	public InputText getTxtEstado() {
		return txtEstado;
	}

	public void setTxtEstado(InputText txtEstado) {
		this.txtEstado = txtEstado;
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

	public InputText getTxtValorSalarioMinimo() {
		return txtValorSalarioMinimo;
	}

	public void setTxtValorSalarioMinimo(InputText txtValorSalarioMinimo) {
		this.txtValorSalarioMinimo = txtValorSalarioMinimo;
	}

	public Calendar getTxtFechaCreacion() {
		return txtFechaCreacion;
	}

	public void setTxtFechaCreacion(Calendar txtFechaCreacion) {
		this.txtFechaCreacion = txtFechaCreacion;
	}

	public Calendar getTxtFechaIncioAnoFiscal() {
		return txtFechaIncioAnoFiscal;
	}

	public void setTxtFechaIncioAnoFiscal(Calendar txtFechaIncioAnoFiscal) {
		this.txtFechaIncioAnoFiscal = txtFechaIncioAnoFiscal;
	}

	public Calendar getTxtFechaModificacion() {
		return txtFechaModificacion;
	}

	public void setTxtFechaModificacion(Calendar txtFechaModificacion) {
		this.txtFechaModificacion = txtFechaModificacion;
	}

	public InputText getTxtAnofId() {
		return txtAnofId;
	}

	public void setTxtAnofId(InputText txtAnofId) {
		this.txtAnofId = txtAnofId;
	}

	public List<GluoAnoFiscalDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataGluoAnoFiscal();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<GluoAnoFiscalDTO> gluoAnoFiscalDTO) {
		this.data = gluoAnoFiscalDTO;
	}

	public GluoAnoFiscalDTO getSelectedGluoAnoFiscal() {
		return selectedGluoAnoFiscal;
	}

	public void setSelectedGluoAnoFiscal(GluoAnoFiscalDTO gluoAnoFiscal) {
		this.selectedGluoAnoFiscal = gluoAnoFiscal;
	}

	public CommandButton getBtnSave() {
		return btnSave;
	}

	public void setBtnSave(CommandButton btnSave) {
		this.btnSave = btnSave;
	}

	public CommandButton getBtnModify() {
		return btnModify;
	}

	public void setBtnModify(CommandButton btnModify) {
		this.btnModify = btnModify;
	}

	public CommandButton getBtnDelete() {
		return btnDelete;
	}

	public void setBtnDelete(CommandButton btnDelete) {
		this.btnDelete = btnDelete;
	}

	public CommandButton getBtnClear() {
		return btnClear;
	}

	public void setBtnClear(CommandButton btnClear) {
		this.btnClear = btnClear;
	}

	public TimeZone getTimeZone() {
		return java.util.TimeZone.getDefault();
	}

	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}

	public void setBusinessDelegatorView(IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}

	public boolean isShowDialog() {
		return showDialog;
	}

	public void setShowDialog(boolean showDialog) {
		this.showDialog = showDialog;
	}
}
