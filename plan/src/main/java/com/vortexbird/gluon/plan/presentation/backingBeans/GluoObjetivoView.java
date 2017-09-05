package com.vortexbird.gluon.plan.presentation.backingBeans;

import com.vortexbird.gluon.plan.exceptions.*;
import com.vortexbird.gluon.plan.modelo.*;
import com.vortexbird.gluon.plan.modelo.dto.GluoObjetivoDTO;
import com.vortexbird.gluon.plan.presentation.businessDelegate.*;
import com.vortexbird.gluon.plan.utilities.*;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.selectonemenu.SelectOneMenu;
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
import javax.faces.model.SelectItem;

/**
 * @author Zathura Code Generator http://zathuracode.org/ www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class GluoObjetivoView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(GluoObjetivoView.class);

	private String somActivo;
	private SelectOneMenu somSectorEje;
	private List<SelectItem> losSectorEjeItems;

	private InputTextarea txtAreaDescripcion;
	private InputText txtUsuCreador;
	private InputText txtUsuModificador;
	private InputText txtSediId_GluoSectorEjeDimension;
	private InputText txtObjeId;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<GluoObjetivoDTO> data;
	private GluoObjetivoDTO selectedGluoObjetivo;
	private GluoObjetivo entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public GluoObjetivoView() {
		super();
	}

	public String action_new() {
		action_clear();
		selectedGluoObjetivo = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedGluoObjetivo = null;

		// if (txtActivo != null) {
		// txtActivo.setValue(null);
		// txtActivo.setDisabled(true);
		// }

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

		if (txtSediId_GluoSectorEjeDimension != null) {
			txtSediId_GluoSectorEjeDimension.setValue(null);
			txtSediId_GluoSectorEjeDimension.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtObjeId != null) {
			txtObjeId.setValue(null);
			txtObjeId.setDisabled(false);
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
			Integer objeId = FacesUtils.checkInteger(txtObjeId);
			entity = (objeId != null) ? businessDelegatorView.getGluoObjetivo(objeId) : null;
		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {
			// txtActivo.setDisabled(false);
			txtAreaDescripcion.setDisabled(false);
			txtUsuCreador.setDisabled(false);
			txtUsuModificador.setDisabled(false);
			txtSediId_GluoSectorEjeDimension.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtObjeId.setDisabled(false);
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
			txtSediId_GluoSectorEjeDimension.setValue(entity.getGluoSectorEjeDimension().getSediId());
			txtSediId_GluoSectorEjeDimension.setDisabled(false);
			txtObjeId.setValue(entity.getObjeId());
			txtObjeId.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedGluoObjetivo = (GluoObjetivoDTO) (evt.getComponent().getAttributes().get("selectedGluoObjetivo"));
		// txtActivo.setValue(selectedGluoObjetivo.getActivo());
		// txtActivo.setDisabled(false);
		txtAreaDescripcion.setValue(selectedGluoObjetivo.getDescripcion());
		txtAreaDescripcion.setDisabled(false);
		txtFechaCreacion.setValue(selectedGluoObjetivo.getFechaCreacion());
		txtFechaCreacion.setDisabled(true);
		txtFechaModificacion.setValue(selectedGluoObjetivo.getFechaModificacion());
		txtFechaModificacion.setDisabled(true);
		txtUsuCreador.setValue(selectedGluoObjetivo.getUsuCreador());
		txtUsuCreador.setDisabled(true);
		txtUsuModificador.setValue(selectedGluoObjetivo.getUsuModificador());
		txtUsuModificador.setDisabled(true);
		// txtSediId_GluoSectorEjeDimension.setValue(selectedGluoObjetivo.getSediId_GluoSectorEjeDimension());
		// txtSediId_GluoSectorEjeDimension.setDisabled(false);
		txtObjeId.setValue(selectedGluoObjetivo.getObjeId());
		txtObjeId.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedGluoObjetivo == null) && (entity == null)) {
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
			entity = new GluoObjetivo();

			// Integer objeId = FacesUtils.checkInteger(txtObjeId);

			entity.setActivo(somActivo);
			entity.setDescripcion(FacesUtils.checkString(txtAreaDescripcion));
			entity.setFechaCreacion(new Date());
			// entity.setFechaModificacion(FacesUtils.checkDate(
			// txtFechaModificacion));
			// entity.setObjeId(objeId);

			SegUsuario segUsuario = (SegUsuario) FacesUtils.getfromSession("usuarioEnSession");
			Integer usuaCreador = Integer.valueOf(segUsuario.getUsuId());

			entity.setUsuCreador(usuaCreador);
			// entity.setUsuModificador(FacesUtils.checkInteger(txtUsuModificador));

			Integer idsector = Integer.valueOf(somSectorEje.getValue().toString());
			GluoSectorEjeDimension gluoSectorEjeDimencional = businessDelegatorView.getGluoSectorEjeDimension(idsector);
			entity.setGluoSectorEjeDimension(gluoSectorEjeDimencional);
			// entity.setGluoSectorEjeDimension((FacesUtils.checkInteger(
			// txtSediId_GluoSectorEjeDimension) != null)
			// ? businessDelegatorView.getGluoSectorEjeDimension(
			// FacesUtils.checkInteger(txtSediId_GluoSectorEjeDimension))
			// : null);

			businessDelegatorView.saveGluoObjetivo(entity);
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
				Integer objeId = new Integer(selectedGluoObjetivo.getObjeId());
				entity = businessDelegatorView.getGluoObjetivo(objeId);
			}

			entity.setActivo(somActivo);
			entity.setDescripcion(FacesUtils.checkString(txtAreaDescripcion));
			// entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(txtFechaModificacion));
			// entity.setUsuCreador(FacesUtils.checkInteger(txtUsuCreador));
			SegUsuario segUsuario = (SegUsuario) FacesUtils.getfromSession("usuarioEnSession");
			Integer usuaModificador = Integer.valueOf(segUsuario.getUsuId());
			entity.setUsuModificador(usuaModificador);

			Integer idsector = Integer.valueOf(somSectorEje.getValue().toString());
			GluoSectorEjeDimension gluoSectorEjeDimencional = businessDelegatorView.getGluoSectorEjeDimension(idsector);
			entity.setGluoSectorEjeDimension(gluoSectorEjeDimencional);

			// entity.setGluoSectorEjeDimension((FacesUtils.checkInteger(
			// txtSediId_GluoSectorEjeDimension) != null)
			// ? businessDelegatorView.getGluoSectorEjeDimension(
			// FacesUtils.checkInteger(txtSediId_GluoSectorEjeDimension))
			// : null);

			businessDelegatorView.updateGluoObjetivo(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String getSomActivo() {
		return somActivo;
	}

	public void setSomActivo(String somActivo) {
		this.somActivo = somActivo;
	}

	public SelectOneMenu getSomSectorEje() {
		return somSectorEje;
	}

	public void setSomSectorEje(SelectOneMenu somSectorEje) {
		this.somSectorEje = somSectorEje;
	}

	public List<SelectItem> losSectorEjeItems() {
		try {
			if (losSectorEjeItems == null) {
				losSectorEjeItems = new ArrayList<SelectItem>();
				List<GluoSectorEjeDimension> losgluoSector = businessDelegatorView.getGluoSectorEjeDimension();

				for (GluoSectorEjeDimension gluoSectorEjeDimension : losgluoSector) {
					losSectorEjeItems.add(new SelectItem(gluoSectorEjeDimension.getSediId(),
							gluoSectorEjeDimension.getDescripcion()));
				}

			}
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
		return losSectorEjeItems;
	}

	public void setLosSectorEjeItems(List<SelectItem> losSectorEjeItems) {
		this.losSectorEjeItems = losSectorEjeItems;
	}

	public InputTextarea getTxtAreaDescripcion() {
		return txtAreaDescripcion;
	}

	public void setTxtAreaDescripcion(InputTextarea txtAreaDescripcion) {
		this.txtAreaDescripcion = txtAreaDescripcion;
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedGluoObjetivo = (GluoObjetivoDTO) (evt.getComponent().getAttributes().get("selectedGluoObjetivo"));

			Integer objeId = new Integer(selectedGluoObjetivo.getObjeId());
			entity = businessDelegatorView.getGluoObjetivo(objeId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Integer objeId = FacesUtils.checkInteger(txtObjeId);
			entity = businessDelegatorView.getGluoObjetivo(objeId);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteGluoObjetivo(entity);
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
			Integer objeId, Integer usuCreador, Integer usuModificador, Integer sediId_GluoSectorEjeDimension)
			throws Exception {
		try {
			entity.setActivo(FacesUtils.checkString(activo));
			entity.setDescripcion(FacesUtils.checkString(descripcion));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setUsuCreador(FacesUtils.checkInteger(usuCreador));
			entity.setUsuModificador(FacesUtils.checkInteger(usuModificador));
			businessDelegatorView.updateGluoObjetivo(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("GluoObjetivoView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
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

	public InputText getTxtSediId_GluoSectorEjeDimension() {
		return txtSediId_GluoSectorEjeDimension;
	}

	public void setTxtSediId_GluoSectorEjeDimension(InputText txtSediId_GluoSectorEjeDimension) {
		this.txtSediId_GluoSectorEjeDimension = txtSediId_GluoSectorEjeDimension;
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

	public InputText getTxtObjeId() {
		return txtObjeId;
	}

	public void setTxtObjeId(InputText txtObjeId) {
		this.txtObjeId = txtObjeId;
	}

	public List<GluoObjetivoDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataGluoObjetivo();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<GluoObjetivoDTO> gluoObjetivoDTO) {
		this.data = gluoObjetivoDTO;
	}

	public GluoObjetivoDTO getSelectedGluoObjetivo() {
		return selectedGluoObjetivo;
	}

	public void setSelectedGluoObjetivo(GluoObjetivoDTO gluoObjetivo) {
		this.selectedGluoObjetivo = gluoObjetivo;
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
