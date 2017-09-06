package com.vortexbird.gluon.plan.presentation.backingBeans;

import com.vortexbird.gluon.plan.exceptions.*;
import com.vortexbird.gluon.plan.modelo.*;
import com.vortexbird.gluon.plan.modelo.dto.GluoSubprogramaDTO;
import com.vortexbird.gluon.plan.presentation.businessDelegate.*;
import com.vortexbird.gluon.plan.utilities.*;

import org.primefaces.component.calendar.*;
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
public class GluoSubprogramaView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(GluoSubprogramaView.class);
	private String somActivo;
	private InputTextarea txtAreaDescripcion;

	private List<SelectItem> losProgramasItems;
	private SelectOneMenu somPrograma;

	private InputText txtUsuCreador;
	private InputText txtUsuModificador;
	private InputText txtProgId_GluoPrograma;
	private InputText txtSubpId;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<GluoSubprogramaDTO> data;
	private GluoSubprogramaDTO selectedGluoSubprograma;
	private GluoSubprograma entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public GluoSubprogramaView() {
		super();
	}

	public String action_new() {
		action_clear();
		selectedGluoSubprograma = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedGluoSubprograma = null;

//		 if (somActivo != null) {
//		 somActivo.setValue(null);
//		 somActivo.setDisabled(true);
//		 }

		if (txtAreaDescripcion != null) {
			txtAreaDescripcion.setValue(null);
			txtAreaDescripcion.setDisabled(true);
		}

		if (txtUsuCreador != null) {
			txtUsuCreador.setValue(null);
			txtUsuCreador.setDisabled(true);
		}

		if (txtUsuModificador != null) {
			txtUsuModificador.setValue(null);
			txtUsuModificador.setDisabled(true);
		}

		if (txtProgId_GluoPrograma != null) {
			txtProgId_GluoPrograma.setValue(null);
			txtProgId_GluoPrograma.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtSubpId != null) {
			txtSubpId.setValue(null);
			txtSubpId.setDisabled(false);
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

	public void listener_txtFechaModificacion() {
		Date inputDate = (Date) txtFechaModificacion.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public void listener_txtId() {
		try {
			Integer subpId = FacesUtils.checkInteger(txtSubpId);
			entity = (subpId != null) ? businessDelegatorView.getGluoSubprograma(subpId) : null;
		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {
			// txtActivo.setDisabled(false);
			txtAreaDescripcion.setDisabled(false);
			txtUsuCreador.setDisabled(false);
			txtUsuModificador.setDisabled(false);
			txtProgId_GluoPrograma.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtSubpId.setDisabled(false);
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
			txtProgId_GluoPrograma.setValue(entity.getGluoPrograma().getProgId());
			txtProgId_GluoPrograma.setDisabled(false);
			txtSubpId.setValue(entity.getSubpId());
			txtSubpId.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedGluoSubprograma = (GluoSubprogramaDTO) (evt.getComponent().getAttributes()
				.get("selectedGluoSubprograma"));
		// txtActivo.setValue(selectedGluoSubprograma.getActivo());
		// txtActivo.setDisabled(false);
		txtAreaDescripcion.setValue(selectedGluoSubprograma.getDescripcion());
		txtAreaDescripcion.setDisabled(false);
		txtFechaCreacion.setValue(selectedGluoSubprograma.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedGluoSubprograma.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtUsuCreador.setValue(selectedGluoSubprograma.getUsuCreador());
		txtUsuCreador.setDisabled(false);
		txtUsuModificador.setValue(selectedGluoSubprograma.getUsuModificador());
		txtUsuModificador.setDisabled(false);
		// txtProgId_GluoPrograma.setValue(selectedGluoSubprograma.getProgId_GluoPrograma());
		// txtProgId_GluoPrograma.setDisabled(false);
		txtSubpId.setValue(selectedGluoSubprograma.getSubpId());
		txtSubpId.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedGluoSubprograma == null) && (entity == null)) {
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
			entity = new GluoSubprograma();

			// Integer subpId = FacesUtils.checkInteger(txtSubpId);

			entity.setActivo(FacesUtils.checkString(somActivo));
			entity.setDescripcion(FacesUtils.checkString(txtAreaDescripcion));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			// entity.setFechaModificacion(FacesUtils.checkDate(
			// txtFechaModificacion));
			// entity.setSubpId(subpId);
			SegUsuario segUsuario = (SegUsuario) FacesUtils.getfromSession("usuarioEnSession");
			Integer usuaCreador = Integer.valueOf(segUsuario.getUsuId());
			entity.setUsuCreador(usuaCreador);
			
			Integer idprograma = Integer.valueOf(somPrograma.getValue().toString());
            GluoPrograma gluoPrograma = businessDelegatorView.getGluoPrograma(idprograma);
            entity.setGluoPrograma(gluoPrograma);
			//entity.setUsuModificador(FacesUtils.checkInteger(txtUsuModificador));
//			entity.setGluoPrograma((FacesUtils.checkInteger(txtProgId_GluoPrograma) != null)
//					? businessDelegatorView.getGluoPrograma(FacesUtils.checkInteger(txtProgId_GluoPrograma))
//					: null);
			businessDelegatorView.saveGluoSubprograma(entity);
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
				Integer subpId = new Integer(selectedGluoSubprograma.getSubpId());
				entity = businessDelegatorView.getGluoSubprograma(subpId);
			}

			entity.setActivo(FacesUtils.checkString(somActivo));
			entity.setDescripcion(FacesUtils.checkString(txtAreaDescripcion));
			//entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(txtFechaModificacion));
			//entity.setUsuCreador(FacesUtils.checkInteger(txtUsuCreador));
			SegUsuario segUsuario = (SegUsuario) FacesUtils.getfromSession("usuarioEnSession");
			Integer usuaModificador = Integer.valueOf(segUsuario.getUsuId());
			entity.setUsuModificador(usuaModificador);
			
			Integer idprograma = Integer.valueOf(somPrograma.getValue().toString());
            GluoPrograma gluoPrograma = businessDelegatorView.getGluoPrograma(idprograma);
            entity.setGluoPrograma(gluoPrograma);
            
			//entity.setUsuModificador(FacesUtils.checkInteger(txtUsuModificador));
//			entity.setGluoPrograma((FacesUtils.checkInteger(txtProgId_GluoPrograma) != null)
//					? businessDelegatorView.getGluoPrograma(FacesUtils.checkInteger(txtProgId_GluoPrograma))
//					: null);
			businessDelegatorView.updateGluoSubprograma(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedGluoSubprograma = (GluoSubprogramaDTO) (evt.getComponent().getAttributes()
					.get("selectedGluoSubprograma"));

			Integer subpId = new Integer(selectedGluoSubprograma.getSubpId());
			entity = businessDelegatorView.getGluoSubprograma(subpId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Integer subpId = FacesUtils.checkInteger(txtSubpId);
			entity = businessDelegatorView.getGluoSubprograma(subpId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteGluoSubprograma(entity);
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
			Integer subpId, Integer usuCreador, Integer usuModificador, Integer progId_GluoPrograma) throws Exception {
		try {
			entity.setActivo(FacesUtils.checkString(activo));
			entity.setDescripcion(FacesUtils.checkString(descripcion));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setUsuCreador(FacesUtils.checkInteger(usuCreador));
			entity.setUsuModificador(FacesUtils.checkInteger(usuModificador));
			businessDelegatorView.updateGluoSubprograma(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("GluoSubprogramaView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public List<SelectItem> getLosProgramasItems() throws Exception {
		try {
			if (losProgramasItems == null) {
				losProgramasItems = new ArrayList<SelectItem>();
				List<GluoPrograma> losGluoPrograma = businessDelegatorView.getGluoPrograma();
				for (GluoPrograma gluoPrograma : losGluoPrograma) {
					losProgramasItems.add(new SelectItem(gluoPrograma.getProgId(), gluoPrograma.getDescripcion()));
				}
			}
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
		return losProgramasItems;
	}

	public void setLosProgramasItems(List<SelectItem> losProgramasItems) {
		this.losProgramasItems = losProgramasItems;
	}

	public SelectOneMenu getSomPrograma() {
		return somPrograma;
	}

	public void setSomPrograma(SelectOneMenu somPrograma) {
		this.somPrograma = somPrograma;
	}

	public String getSomActivo() {
		return somActivo;
	}

	public void setSomActivo(String somActivo) {
		this.somActivo = somActivo;
	}

	public InputTextarea getTxtAreaDescripcion() {
		return txtAreaDescripcion;
	}

	public void setTxtAreaDescripcion(InputTextarea txtAreaDescripcion) {
		this.txtAreaDescripcion = txtAreaDescripcion;
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

	public InputText getTxtProgId_GluoPrograma() {
		return txtProgId_GluoPrograma;
	}

	public void setTxtProgId_GluoPrograma(InputText txtProgId_GluoPrograma) {
		this.txtProgId_GluoPrograma = txtProgId_GluoPrograma;
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

	public InputText getTxtSubpId() {
		return txtSubpId;
	}

	public void setTxtSubpId(InputText txtSubpId) {
		this.txtSubpId = txtSubpId;
	}

	public List<GluoSubprogramaDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataGluoSubprograma();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<GluoSubprogramaDTO> gluoSubprogramaDTO) {
		this.data = gluoSubprogramaDTO;
	}

	public GluoSubprogramaDTO getSelectedGluoSubprograma() {
		return selectedGluoSubprograma;
	}

	public void setSelectedGluoSubprograma(GluoSubprogramaDTO gluoSubprograma) {
		this.selectedGluoSubprograma = gluoSubprograma;
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
