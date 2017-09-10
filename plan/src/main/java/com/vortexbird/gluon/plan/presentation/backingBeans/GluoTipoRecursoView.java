package com.vortexbird.gluon.plan.presentation.backingBeans;

import com.vortexbird.gluon.plan.exceptions.*;
import com.vortexbird.gluon.plan.modelo.*;
import com.vortexbird.gluon.plan.modelo.dto.GluoTipoRecursoDTO;
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
 * @author Zathura Code Generator http://zathuracode.org/
 * www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class GluoTipoRecursoView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(GluoTipoRecursoView.class);
    private String somActivo;
    private InputText txtCodigo;
    private InputTextarea txtAreaDescripcion;
    private InputText txtUsuCreador;
    private InputText txtUsuModificador;
    private InputText txtTireId;
    private Calendar txtFechaCreacion;
    private Calendar txtFechaModificacion;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<GluoTipoRecursoDTO> data;
    private GluoTipoRecursoDTO selectedGluoTipoRecurso;
    private GluoTipoRecurso entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public GluoTipoRecursoView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedGluoTipoRecurso = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedGluoTipoRecurso = null;

//        if (txtActivo != null) {
//            txtActivo.setValue(null);
//            txtActivo.setDisabled(true);
//        }

        if (txtCodigo != null) {
            txtCodigo.setValue(null);
            txtCodigo.setDisabled(false);
        }

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

        if (txtFechaCreacion != null) {
            txtFechaCreacion.setValue(null);
            txtFechaCreacion.setDisabled(true);
        }

        if (txtFechaModificacion != null) {
            txtFechaModificacion.setValue(null);
            txtFechaModificacion.setDisabled(true);
        }

        if (txtTireId != null) {
            txtTireId.setValue(null);
            txtTireId.setDisabled(false);
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

    public void listener_txtId() {
        try {
            Integer tireId = FacesUtils.checkInteger(txtTireId);
            entity = (tireId != null)
                ? businessDelegatorView.getGluoTipoRecurso(tireId) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
//            txtActivo.setDisabled(false);
            txtCodigo.setDisabled(false);
            txtAreaDescripcion.setDisabled(false);
            txtUsuCreador.setDisabled(false);
            txtUsuModificador.setDisabled(false);
            txtFechaCreacion.setDisabled(false);
            txtFechaModificacion.setDisabled(false);
            txtTireId.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
//            txtActivo.setValue(entity.getActivo());
//            txtActivo.setDisabled(false);
            txtCodigo.setValue(entity.getCodigo());
            txtCodigo.setDisabled(false);
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
            txtTireId.setValue(entity.getTireId());
            txtTireId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedGluoTipoRecurso = (GluoTipoRecursoDTO) (evt.getComponent()
                                                           .getAttributes()
                                                           .get("selectedGluoTipoRecurso"));
//        txtActivo.setValue(selectedGluoTipoRecurso.getActivo());
//        txtActivo.setDisabled(false);
        txtCodigo.setValue(selectedGluoTipoRecurso.getCodigo());
        txtCodigo.setDisabled(false);
        txtAreaDescripcion.setValue(selectedGluoTipoRecurso.getDescripcion());
        txtAreaDescripcion.setDisabled(false);
        txtFechaCreacion.setValue(selectedGluoTipoRecurso.getFechaCreacion());
        txtFechaCreacion.setDisabled(true);
        txtFechaModificacion.setValue(selectedGluoTipoRecurso.getFechaModificacion());
        txtFechaModificacion.setDisabled(true);
        txtUsuCreador.setValue(selectedGluoTipoRecurso.getUsuCreador());
        txtUsuCreador.setDisabled(true);
        txtUsuModificador.setValue(selectedGluoTipoRecurso.getUsuModificador());
        txtUsuModificador.setDisabled(true);
        txtTireId.setValue(selectedGluoTipoRecurso.getTireId());
        txtTireId.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedGluoTipoRecurso == null) && (entity == null)) {
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
            entity = new GluoTipoRecurso();

//            Integer tireId = FacesUtils.checkInteger(txtTireId);

            entity.setActivo(somActivo);
            entity.setCodigo(FacesUtils.checkString(txtCodigo));
            entity.setDescripcion(FacesUtils.checkString(txtAreaDescripcion));
            entity.setFechaCreacion(new Date());
//            entity.setFechaModificacion(FacesUtils.checkDate(
//                    txtFechaModificacion));
//            entity.setTireId(tireId);
            SegUsuario segUsuario = (SegUsuario) FacesUtils.getfromSession("usuarioEnSession");
            Integer usuaCreador = Integer.valueOf(segUsuario.getUsuId());
            entity.setUsuCreador(usuaCreador);
//            entity.setUsuModificador(FacesUtils.checkInteger(txtUsuModificador));
            businessDelegatorView.saveGluoTipoRecurso(entity);
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
                Integer tireId = new Integer(selectedGluoTipoRecurso.getTireId());
                entity = businessDelegatorView.getGluoTipoRecurso(tireId);
            }

            entity.setActivo(somActivo);
            entity.setCodigo(FacesUtils.checkString(txtCodigo));
            entity.setDescripcion(FacesUtils.checkString(txtAreaDescripcion));
//            entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
            entity.setFechaModificacion(new Date());
//            entity.setUsuCreador(FacesUtils.checkInteger(txtUsuCreador));
            SegUsuario segUsuario = (SegUsuario) FacesUtils.getfromSession("usuarioEnSession");
            Integer usuaModificador = Integer.valueOf(segUsuario.getUsuId());
            entity.setUsuModificador(usuaModificador);
            businessDelegatorView.updateGluoTipoRecurso(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedGluoTipoRecurso = (GluoTipoRecursoDTO) (evt.getComponent()
                                                               .getAttributes()
                                                               .get("selectedGluoTipoRecurso"));

            Integer tireId = new Integer(selectedGluoTipoRecurso.getTireId());
            entity = businessDelegatorView.getGluoTipoRecurso(tireId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer tireId = FacesUtils.checkInteger(txtTireId);
            entity = businessDelegatorView.getGluoTipoRecurso(tireId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteGluoTipoRecurso(entity);
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

    public String action_modifyWitDTO(String activo, String codigo,
        String descripcion, Date fechaCreacion, Date fechaModificacion,
        Integer tireId, Integer usuCreador, Integer usuModificador)
        throws Exception {
        try {
            entity.setActivo(FacesUtils.checkString(activo));
            entity.setCodigo(FacesUtils.checkString(codigo));
            entity.setDescripcion(FacesUtils.checkString(descripcion));
            entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
            entity.setUsuCreador(FacesUtils.checkInteger(usuCreador));
            entity.setUsuModificador(FacesUtils.checkInteger(usuModificador));
            businessDelegatorView.updateGluoTipoRecurso(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("GluoTipoRecursoView").requestRender();
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

	public InputTextarea getTxtAreaDescripcion() {
		return txtAreaDescripcion;
	}

	public void setTxtAreaDescripcion(InputTextarea txtAreaDescripcion) {
		this.txtAreaDescripcion = txtAreaDescripcion;
	}

	public InputText getTxtCodigo() {
        return txtCodigo;
    }

    public void setTxtCodigo(InputText txtCodigo) {
        this.txtCodigo = txtCodigo;
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

    public InputText getTxtTireId() {
        return txtTireId;
    }

    public void setTxtTireId(InputText txtTireId) {
        this.txtTireId = txtTireId;
    }

    public List<GluoTipoRecursoDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataGluoTipoRecurso();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<GluoTipoRecursoDTO> gluoTipoRecursoDTO) {
        this.data = gluoTipoRecursoDTO;
    }

    public GluoTipoRecursoDTO getSelectedGluoTipoRecurso() {
        return selectedGluoTipoRecurso;
    }

    public void setSelectedGluoTipoRecurso(GluoTipoRecursoDTO gluoTipoRecurso) {
        this.selectedGluoTipoRecurso = gluoTipoRecurso;
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
