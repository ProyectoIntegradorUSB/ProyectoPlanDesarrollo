package com.vortexbird.gluon.plan.presentation.backingBeans;

import com.vortexbird.gluon.plan.exceptions.*;
import com.vortexbird.gluon.plan.modelo.*;
import com.vortexbird.gluon.plan.modelo.dto.SegPermisoDTO;
import com.vortexbird.gluon.plan.presentation.businessDelegate.*;
import com.vortexbird.gluon.plan.utilities.*;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;

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
public class SegPermisoView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(SegPermisoView.class);
    private InputText txtActivo;
    private InputText txtRolId;
    private InputText txtUsuCreador;
    private InputText txtUsuId;
    private InputText txtUsuModificador;
    private InputText txtOpcnId_SegOpcion;
    private InputText txtRlusId_SegRolUsuario;
    private InputText txtPermId;
    private Calendar txtFechaCreacion;
    private Calendar txtFechaModificacion;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<SegPermisoDTO> data;
    private SegPermisoDTO selectedSegPermiso;
    private SegPermiso entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public SegPermisoView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedSegPermiso = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedSegPermiso = null;

        if (txtActivo != null) {
            txtActivo.setValue(null);
            txtActivo.setDisabled(true);
        }

        if (txtRolId != null) {
            txtRolId.setValue(null);
            txtRolId.setDisabled(true);
        }

        if (txtUsuCreador != null) {
            txtUsuCreador.setValue(null);
            txtUsuCreador.setDisabled(true);
        }

        if (txtUsuId != null) {
            txtUsuId.setValue(null);
            txtUsuId.setDisabled(true);
        }

        if (txtUsuModificador != null) {
            txtUsuModificador.setValue(null);
            txtUsuModificador.setDisabled(true);
        }

        if (txtOpcnId_SegOpcion != null) {
            txtOpcnId_SegOpcion.setValue(null);
            txtOpcnId_SegOpcion.setDisabled(true);
        }

        if (txtRlusId_SegRolUsuario != null) {
            txtRlusId_SegRolUsuario.setValue(null);
            txtRlusId_SegRolUsuario.setDisabled(true);
        }

        if (txtFechaCreacion != null) {
            txtFechaCreacion.setValue(null);
            txtFechaCreacion.setDisabled(true);
        }

        if (txtFechaModificacion != null) {
            txtFechaModificacion.setValue(null);
            txtFechaModificacion.setDisabled(true);
        }

        if (txtPermId != null) {
            txtPermId.setValue(null);
            txtPermId.setDisabled(false);
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
            Integer permId = FacesUtils.checkInteger(txtPermId);
            entity = (permId != null)
                ? businessDelegatorView.getSegPermiso(permId) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtActivo.setDisabled(false);
            txtRolId.setDisabled(false);
            txtUsuCreador.setDisabled(false);
            txtUsuId.setDisabled(false);
            txtUsuModificador.setDisabled(false);
            txtOpcnId_SegOpcion.setDisabled(false);
            txtRlusId_SegRolUsuario.setDisabled(false);
            txtFechaCreacion.setDisabled(false);
            txtFechaModificacion.setDisabled(false);
            txtPermId.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtActivo.setValue(entity.getActivo());
            txtActivo.setDisabled(false);
            txtFechaCreacion.setValue(entity.getFechaCreacion());
            txtFechaCreacion.setDisabled(false);
            txtFechaModificacion.setValue(entity.getFechaModificacion());
            txtFechaModificacion.setDisabled(false);
            txtRolId.setValue(entity.getRolId());
            txtRolId.setDisabled(false);
            txtUsuCreador.setValue(entity.getUsuCreador());
            txtUsuCreador.setDisabled(false);
            txtUsuId.setValue(entity.getUsuId());
            txtUsuId.setDisabled(false);
            txtUsuModificador.setValue(entity.getUsuModificador());
            txtUsuModificador.setDisabled(false);
            txtOpcnId_SegOpcion.setValue(entity.getSegOpcion().getOpcnId());
            txtOpcnId_SegOpcion.setDisabled(false);
            txtRlusId_SegRolUsuario.setValue(entity.getSegRolUsuario()
                                                   .getRlusId());
            txtRlusId_SegRolUsuario.setDisabled(false);
            txtPermId.setValue(entity.getPermId());
            txtPermId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedSegPermiso = (SegPermisoDTO) (evt.getComponent().getAttributes()
                                                 .get("selectedSegPermiso"));
        txtActivo.setValue(selectedSegPermiso.getActivo());
        txtActivo.setDisabled(false);
        txtFechaCreacion.setValue(selectedSegPermiso.getFechaCreacion());
        txtFechaCreacion.setDisabled(false);
        txtFechaModificacion.setValue(selectedSegPermiso.getFechaModificacion());
        txtFechaModificacion.setDisabled(false);
        txtRolId.setValue(selectedSegPermiso.getRolId());
        txtRolId.setDisabled(false);
        txtUsuCreador.setValue(selectedSegPermiso.getUsuCreador());
        txtUsuCreador.setDisabled(false);
        txtUsuId.setValue(selectedSegPermiso.getUsuId());
        txtUsuId.setDisabled(false);
        txtUsuModificador.setValue(selectedSegPermiso.getUsuModificador());
        txtUsuModificador.setDisabled(false);
        txtOpcnId_SegOpcion.setValue(selectedSegPermiso.getOpcnId_SegOpcion());
        txtOpcnId_SegOpcion.setDisabled(false);
        txtRlusId_SegRolUsuario.setValue(selectedSegPermiso.getRlusId_SegRolUsuario());
        txtRlusId_SegRolUsuario.setDisabled(false);
        txtPermId.setValue(selectedSegPermiso.getPermId());
        txtPermId.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedSegPermiso == null) && (entity == null)) {
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
            entity = new SegPermiso();

            Integer permId = FacesUtils.checkInteger(txtPermId);

            entity.setActivo(FacesUtils.checkString(txtActivo));
            entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(
                    txtFechaModificacion));
            entity.setPermId(permId);
            entity.setRolId(FacesUtils.checkInteger(txtRolId));
            entity.setUsuCreador(FacesUtils.checkInteger(txtUsuCreador));
            entity.setUsuId(FacesUtils.checkInteger(txtUsuId));
            entity.setUsuModificador(FacesUtils.checkInteger(txtUsuModificador));
            entity.setSegOpcion((FacesUtils.checkInteger(txtOpcnId_SegOpcion) != null)
                ? businessDelegatorView.getSegOpcion(FacesUtils.checkInteger(
                        txtOpcnId_SegOpcion)) : null);
            entity.setSegRolUsuario((FacesUtils.checkInteger(
                    txtRlusId_SegRolUsuario) != null)
                ? businessDelegatorView.getSegRolUsuario(
                    FacesUtils.checkInteger(txtRlusId_SegRolUsuario)) : null);
            businessDelegatorView.saveSegPermiso(entity);
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
                Integer permId = new Integer(selectedSegPermiso.getPermId());
                entity = businessDelegatorView.getSegPermiso(permId);
            }

            entity.setActivo(FacesUtils.checkString(txtActivo));
            entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(
                    txtFechaModificacion));
            entity.setRolId(FacesUtils.checkInteger(txtRolId));
            entity.setUsuCreador(FacesUtils.checkInteger(txtUsuCreador));
            entity.setUsuId(FacesUtils.checkInteger(txtUsuId));
            entity.setUsuModificador(FacesUtils.checkInteger(txtUsuModificador));
            entity.setSegOpcion((FacesUtils.checkInteger(txtOpcnId_SegOpcion) != null)
                ? businessDelegatorView.getSegOpcion(FacesUtils.checkInteger(
                        txtOpcnId_SegOpcion)) : null);
            entity.setSegRolUsuario((FacesUtils.checkInteger(
                    txtRlusId_SegRolUsuario) != null)
                ? businessDelegatorView.getSegRolUsuario(
                    FacesUtils.checkInteger(txtRlusId_SegRolUsuario)) : null);
            businessDelegatorView.updateSegPermiso(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedSegPermiso = (SegPermisoDTO) (evt.getComponent()
                                                     .getAttributes()
                                                     .get("selectedSegPermiso"));

            Integer permId = new Integer(selectedSegPermiso.getPermId());
            entity = businessDelegatorView.getSegPermiso(permId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer permId = FacesUtils.checkInteger(txtPermId);
            entity = businessDelegatorView.getSegPermiso(permId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteSegPermiso(entity);
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

    public String action_modifyWitDTO(String activo, Date fechaCreacion,
        Date fechaModificacion, Integer permId, Integer rolId,
        Integer usuCreador, Integer usuId, Integer usuModificador,
        Integer opcnId_SegOpcion, Integer rlusId_SegRolUsuario)
        throws Exception {
        try {
            entity.setActivo(FacesUtils.checkString(activo));
            entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
            entity.setRolId(FacesUtils.checkInteger(rolId));
            entity.setUsuCreador(FacesUtils.checkInteger(usuCreador));
            entity.setUsuId(FacesUtils.checkInteger(usuId));
            entity.setUsuModificador(FacesUtils.checkInteger(usuModificador));
            businessDelegatorView.updateSegPermiso(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("SegPermisoView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtActivo() {
        return txtActivo;
    }

    public void setTxtActivo(InputText txtActivo) {
        this.txtActivo = txtActivo;
    }

    public InputText getTxtRolId() {
        return txtRolId;
    }

    public void setTxtRolId(InputText txtRolId) {
        this.txtRolId = txtRolId;
    }

    public InputText getTxtUsuCreador() {
        return txtUsuCreador;
    }

    public void setTxtUsuCreador(InputText txtUsuCreador) {
        this.txtUsuCreador = txtUsuCreador;
    }

    public InputText getTxtUsuId() {
        return txtUsuId;
    }

    public void setTxtUsuId(InputText txtUsuId) {
        this.txtUsuId = txtUsuId;
    }

    public InputText getTxtUsuModificador() {
        return txtUsuModificador;
    }

    public void setTxtUsuModificador(InputText txtUsuModificador) {
        this.txtUsuModificador = txtUsuModificador;
    }

    public InputText getTxtOpcnId_SegOpcion() {
        return txtOpcnId_SegOpcion;
    }

    public void setTxtOpcnId_SegOpcion(InputText txtOpcnId_SegOpcion) {
        this.txtOpcnId_SegOpcion = txtOpcnId_SegOpcion;
    }

    public InputText getTxtRlusId_SegRolUsuario() {
        return txtRlusId_SegRolUsuario;
    }

    public void setTxtRlusId_SegRolUsuario(InputText txtRlusId_SegRolUsuario) {
        this.txtRlusId_SegRolUsuario = txtRlusId_SegRolUsuario;
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

    public InputText getTxtPermId() {
        return txtPermId;
    }

    public void setTxtPermId(InputText txtPermId) {
        this.txtPermId = txtPermId;
    }

    public List<SegPermisoDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataSegPermiso();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<SegPermisoDTO> segPermisoDTO) {
        this.data = segPermisoDTO;
    }

    public SegPermisoDTO getSelectedSegPermiso() {
        return selectedSegPermiso;
    }

    public void setSelectedSegPermiso(SegPermisoDTO segPermiso) {
        this.selectedSegPermiso = segPermiso;
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
