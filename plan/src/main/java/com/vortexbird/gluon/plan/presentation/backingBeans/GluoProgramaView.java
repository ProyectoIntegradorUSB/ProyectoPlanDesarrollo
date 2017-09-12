package com.vortexbird.gluon.plan.presentation.backingBeans;

import com.vortexbird.gluon.plan.exceptions.*;
import com.vortexbird.gluon.plan.modelo.*;
import com.vortexbird.gluon.plan.modelo.dto.GluoProgramaDTO;
import com.vortexbird.gluon.plan.presentation.businessDelegate.*;
import com.vortexbird.gluon.plan.utilities.*;

import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;

import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

/**
 * @author Zathura Code Generator http://zathuracode.org/ www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class GluoProgramaView implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(GluoProgramaView.class);

	private String somActivo;
	private InputTextarea txtAreaDescripcion;

	private List<SelectItem> losObjetivosItems;

	private SelectOneMenu somObjetivos;

	private InputText txtUsuCreador;
	private InputText txtUsuModificador;
	private InputText txtObjeId_GluoObjetivo;
	private InputText txtProgId;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<GluoProgramaDTO> data;
	private GluoProgramaDTO selectedGluoPrograma;
	private GluoPrograma entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public GluoProgramaView() {
		super();
	}

	public String action_new() {
		action_clear();
		selectedGluoPrograma = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedGluoPrograma = null;

		// if (txtActivo != null) {
		// txtActivo.setValue(null);
		// txtActivo.setDisabled(true);
		// }
		if (txtAreaDescripcion != null) {
			txtAreaDescripcion.setValue(null);
			txtAreaDescripcion.setDisabled(false);
		}

		if (txtUsuCreador != null) {
			txtUsuCreador.setValue(null);
			txtUsuCreador.setDisabled(true);
		}

		if (txtUsuModificador != null) {
			txtUsuModificador.setValue(null);
			txtUsuModificador.setDisabled(true);
		}

		if (txtObjeId_GluoObjetivo != null) {
			txtObjeId_GluoObjetivo.setValue(null);
			txtObjeId_GluoObjetivo.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtProgId != null) {
			txtProgId.setValue(null);
			txtProgId.setDisabled(false);
		}

		if (btnSave != null) {
			btnSave.setDisabled(false);
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

	public void listener_txtFechaModificacion() {
		Date inputDate = (Date) txtFechaModificacion.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public void listener_txtId() {
		try {
			Integer progId = FacesUtils.checkInteger(txtProgId);
			entity = (progId != null) ? businessDelegatorView.getGluoPrograma(progId) : null;
		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {
			// txtActivo.setDisabled(false);
			txtAreaDescripcion.setDisabled(false);
			txtUsuCreador.setDisabled(false);
			txtUsuModificador.setDisabled(false);
			txtObjeId_GluoObjetivo.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtProgId.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			// txtActivo.setValue(entity.getActivo());
			// txtActivo.setDisabled(false);
			txtAreaDescripcion.setValue(entity.getDescripcion());
			txtAreaDescripcion.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtUsuCreador.setValue(entity.getUsuCreador());
			txtUsuCreador.setDisabled(false);
			txtUsuModificador.setValue(entity.getUsuModificador());
			txtUsuModificador.setDisabled(false);
			txtObjeId_GluoObjetivo.setValue(entity.getGluoObjetivo().getObjeId());
			txtObjeId_GluoObjetivo.setDisabled(false);
			txtProgId.setValue(entity.getProgId());
			txtProgId.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedGluoPrograma = (GluoProgramaDTO) (evt.getComponent().getAttributes().get("selectedGluoPrograma"));
		// txtActivo.setValue(selectedGluoPrograma.getActivo());
		// txtActivo.setDisabled(false);
		txtAreaDescripcion.setValue(selectedGluoPrograma.getDescripcion());
		txtAreaDescripcion.setDisabled(false);
		txtFechaCreacion.setValue(selectedGluoPrograma.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedGluoPrograma.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtUsuCreador.setValue(selectedGluoPrograma.getUsuCreador());
		txtUsuCreador.setDisabled(false);
		txtUsuModificador.setValue(selectedGluoPrograma.getUsuModificador());
		txtUsuModificador.setDisabled(false);
		// txtObjeId_GluoObjetivo.setValue(selectedGluoPrograma.getObjeId_GluoObjetivo());
		// txtObjeId_GluoObjetivo.setDisabled(false);
		txtProgId.setValue(selectedGluoPrograma.getProgId());
		txtProgId.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedGluoPrograma == null) && (entity == null)) {
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
			entity = new GluoPrograma();

			// Integer progId = FacesUtils.checkInteger(txtProgId);

			entity.setActivo((somActivo));
			entity.setDescripcion(FacesUtils.checkString(txtAreaDescripcion));
			entity.setFechaCreacion(new Date());

			SegUsuario segUsuario = (SegUsuario) FacesUtils.getfromSession("usuarioEnSession");
			Integer usuaCreador = Integer.valueOf(segUsuario.getUsuId());
			entity.setUsuCreador(usuaCreador);

			Integer idObjetivo = Integer.valueOf(somObjetivos.getValue().toString());
			GluoObjetivo gluoObjetivo = businessDelegatorView.getGluoObjetivo(idObjetivo);
			entity.setGluoObjetivo(gluoObjetivo);

			// entity.setFechaModificacion(FacesUtils.checkDate(
			// txtFechaModificacion));
			// entity.setProgId(progId);
			// entity.setUsuCreador(FacesUtils.checkInteger(txtUsuCreador));
			// entity.setUsuModificador(FacesUtils.checkInteger(txtUsuModificador));
			// entity.setGluoObjetivo((FacesUtils.checkInteger(txtObjeId_GluoObjetivo) !=
			// null)
			// ?
			// businessDelegatorView.getGluoObjetivo(FacesUtils.checkInteger(txtObjeId_GluoObjetivo))
			// : null);
			businessDelegatorView.saveGluoPrograma(entity);
			FacesContext.getCurrentInstance().addMessage("", 
					new FacesMessage(FacesMessage.SEVERITY_INFO, "El Programa se ha almacenado con exito", ""));
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
				Integer progId = new Integer(selectedGluoPrograma.getProgId());
				entity = businessDelegatorView.getGluoPrograma(progId);
			}

			entity.setActivo(somActivo);
			entity.setDescripcion(FacesUtils.checkString(txtAreaDescripcion));

			entity.setFechaModificacion(new Date());
			SegUsuario segUsuario = (SegUsuario) FacesUtils.getfromSession("usuarioEnSession");
			Integer usuaModificador = Integer.valueOf(segUsuario.getUsuId());
			entity.setUsuModificador(usuaModificador);

			Integer idObjetivo = Integer.valueOf(somObjetivos.getValue().toString());
			GluoObjetivo gluoObjetivo = businessDelegatorView.getGluoObjetivo(idObjetivo);
			entity.setGluoObjetivo(gluoObjetivo);
			// entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			// entity.setUsuCreador(FacesUtils.checkInteger(txtUsuCreador));
			// entity.setUsuModificador(FacesUtils.checkInteger(txtUsuModificador));
			// entity.setGluoObjetivo((FacesUtils.checkInteger(txtObjeId_GluoObjetivo) !=
			// null)
			// ?
			// businessDelegatorView.getGluoObjetivo(FacesUtils.checkInteger(txtObjeId_GluoObjetivo))
			// : null);
			businessDelegatorView.updateGluoPrograma(entity);
			FacesContext.getCurrentInstance().addMessage("", 
					new FacesMessage(FacesMessage.SEVERITY_WARN, "El Programa ha sido modificado", ""));
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedGluoPrograma = (GluoProgramaDTO) (evt.getComponent().getAttributes().get("selectedGluoPrograma"));

			Integer progId = new Integer(selectedGluoPrograma.getProgId());
			entity = businessDelegatorView.getGluoPrograma(progId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Integer progId = FacesUtils.checkInteger(txtProgId);
			entity = businessDelegatorView.getGluoPrograma(progId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteGluoPrograma(entity);
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

	public String action_modifyWitDTO(String activo, String descripcion, Date fechaCreacion, Date fechaModificacion,
			Integer progId, Integer usuCreador, Integer usuModificador, Integer objeId_GluoObjetivo) throws Exception {
		try {
			entity.setActivo(FacesUtils.checkString(activo));
			entity.setDescripcion(FacesUtils.checkString(descripcion));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setUsuCreador(FacesUtils.checkInteger(usuCreador));
			entity.setUsuModificador(FacesUtils.checkInteger(usuModificador));
			businessDelegatorView.updateGluoPrograma(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("GluoProgramaView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	// public InputText getTxtActivo() {
	// return txtActivo;
	// }
	//
	// public void setTxtActivo(InputText txtActivo) {
	// this.txtActivo = txtActivo;
	// }

	// public InputText getTxtDescripcion() {
	// return txtDescripcion;
	// }

	// public void setTxtDescripcion(InputText txtDescripcion) {
	// this.txtDescripcion = txtDescripcion;
	// }

	public List<SelectItem> getLosObjetivosItems() throws Exception {
		try {
			if (losObjetivosItems == null) {
				losObjetivosItems = new ArrayList<SelectItem>();
				List<GluoObjetivo> losGluoObjetivo = businessDelegatorView.getGluoObjetivo();
				for (GluoObjetivo gluoObjetivo : losGluoObjetivo) {
					losObjetivosItems.add(new SelectItem(gluoObjetivo.getObjeId(), gluoObjetivo.getDescripcion()));
				}
			}
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
		return losObjetivosItems;
	}

	public void setLosObjetivosItems(List<SelectItem> losObjetivosItems) {
		this.losObjetivosItems = losObjetivosItems;
	}

	public SelectOneMenu getSomObjetivos() {
		return somObjetivos;
	}

	public void setSomObjetivos(SelectOneMenu somObjetivos) {
		this.somObjetivos = somObjetivos;
	}

	public String getSomActivo() {
		return somActivo;
	}

	public InputTextarea getTxtAreaDescripcion() {
		return txtAreaDescripcion;
	}

	public void setTxtAreaDescripcion(InputTextarea txtAreaDescripcion) {
		this.txtAreaDescripcion = txtAreaDescripcion;
	}

	public void setSomActivo(String somActivo) {
		this.somActivo = somActivo;
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

	public InputText getTxtObjeId_GluoObjetivo() {
		return txtObjeId_GluoObjetivo;
	}

	public void setTxtObjeId_GluoObjetivo(InputText txtObjeId_GluoObjetivo) {
		this.txtObjeId_GluoObjetivo = txtObjeId_GluoObjetivo;
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

	public InputText getTxtProgId() {
		return txtProgId;
	}

	public void setTxtProgId(InputText txtProgId) {
		this.txtProgId = txtProgId;
	}

	public List<GluoProgramaDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataGluoPrograma();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<GluoProgramaDTO> gluoProgramaDTO) {
		this.data = gluoProgramaDTO;
	}

	public GluoProgramaDTO getSelectedGluoPrograma() {
		return selectedGluoPrograma;
	}

	public void setSelectedGluoPrograma(GluoProgramaDTO gluoPrograma) {
		this.selectedGluoPrograma = gluoPrograma;
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
