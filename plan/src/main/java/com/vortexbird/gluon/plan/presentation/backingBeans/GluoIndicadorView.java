package com.vortexbird.gluon.plan.presentation.backingBeans;

import com.vortexbird.gluon.plan.exceptions.*;
import com.vortexbird.gluon.plan.modelo.*;
import com.vortexbird.gluon.plan.modelo.dto.GluoIndicadorDTO;
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
public class GluoIndicadorView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(GluoIndicadorView.class);
    private InputText txtActivo;
    private InputText txtDescripcionIndicador;
    private InputText txtDescripcionLineaBase;
    private InputText txtDescripcionMeta;
    private InputText txtUsuCreador;
    private InputText txtUsuModificador;
    private InputText txtValorMeta;
    private InputText txtProyId_GluoProyecto;
    private InputText txtIndiId;
    private Calendar txtFechaCreacion;
    private Calendar txtFechaModificacion;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<GluoIndicadorDTO> data;
    private GluoIndicadorDTO selectedGluoIndicador;
    private GluoIndicador entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public GluoIndicadorView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedGluoIndicador = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedGluoIndicador = null;

        if (txtActivo != null) {
            txtActivo.setValue(null);
            txtActivo.setDisabled(true);
        }

        if (txtDescripcionIndicador != null) {
            txtDescripcionIndicador.setValue(null);
            txtDescripcionIndicador.setDisabled(true);
        }

        if (txtDescripcionLineaBase != null) {
            txtDescripcionLineaBase.setValue(null);
            txtDescripcionLineaBase.setDisabled(true);
        }

        if (txtDescripcionMeta != null) {
            txtDescripcionMeta.setValue(null);
            txtDescripcionMeta.setDisabled(true);
        }

        if (txtUsuCreador != null) {
            txtUsuCreador.setValue(null);
            txtUsuCreador.setDisabled(true);
        }

        if (txtUsuModificador != null) {
            txtUsuModificador.setValue(null);
            txtUsuModificador.setDisabled(true);
        }

        if (txtValorMeta != null) {
            txtValorMeta.setValue(null);
            txtValorMeta.setDisabled(true);
        }

        if (txtProyId_GluoProyecto != null) {
            txtProyId_GluoProyecto.setValue(null);
            txtProyId_GluoProyecto.setDisabled(true);
        }

        if (txtFechaCreacion != null) {
            txtFechaCreacion.setValue(null);
            txtFechaCreacion.setDisabled(true);
        }

        if (txtFechaModificacion != null) {
            txtFechaModificacion.setValue(null);
            txtFechaModificacion.setDisabled(true);
        }

        if (txtIndiId != null) {
            txtIndiId.setValue(null);
            txtIndiId.setDisabled(false);
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
            Integer indiId = FacesUtils.checkInteger(txtIndiId);
            entity = (indiId != null)
                ? businessDelegatorView.getGluoIndicador(indiId) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtActivo.setDisabled(false);
            txtDescripcionIndicador.setDisabled(false);
            txtDescripcionLineaBase.setDisabled(false);
            txtDescripcionMeta.setDisabled(false);
            txtUsuCreador.setDisabled(false);
            txtUsuModificador.setDisabled(false);
            txtValorMeta.setDisabled(false);
            txtProyId_GluoProyecto.setDisabled(false);
            txtFechaCreacion.setDisabled(false);
            txtFechaModificacion.setDisabled(false);
            txtIndiId.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtActivo.setValue(entity.getActivo());
            txtActivo.setDisabled(false);
            txtDescripcionIndicador.setValue(entity.getDescripcionIndicador());
            txtDescripcionIndicador.setDisabled(false);
            txtDescripcionLineaBase.setValue(entity.getDescripcionLineaBase());
            txtDescripcionLineaBase.setDisabled(false);
            txtDescripcionMeta.setValue(entity.getDescripcionMeta());
            txtDescripcionMeta.setDisabled(false);
            txtFechaCreacion.setValue(entity.getFechaCreacion());
            txtFechaCreacion.setDisabled(false);
            txtFechaModificacion.setValue(entity.getFechaModificacion());
            txtFechaModificacion.setDisabled(false);
            txtUsuCreador.setValue(entity.getUsuCreador());
            txtUsuCreador.setDisabled(false);
            txtUsuModificador.setValue(entity.getUsuModificador());
            txtUsuModificador.setDisabled(false);
            txtValorMeta.setValue(entity.getValorMeta());
            txtValorMeta.setDisabled(false);
            txtProyId_GluoProyecto.setValue(entity.getGluoProyecto().getProyId());
            txtProyId_GluoProyecto.setDisabled(false);
            txtIndiId.setValue(entity.getIndiId());
            txtIndiId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedGluoIndicador = (GluoIndicadorDTO) (evt.getComponent()
                                                       .getAttributes()
                                                       .get("selectedGluoIndicador"));
        txtActivo.setValue(selectedGluoIndicador.getActivo());
        txtActivo.setDisabled(false);
        txtDescripcionIndicador.setValue(selectedGluoIndicador.getDescripcionIndicador());
        txtDescripcionIndicador.setDisabled(false);
        txtDescripcionLineaBase.setValue(selectedGluoIndicador.getDescripcionLineaBase());
        txtDescripcionLineaBase.setDisabled(false);
        txtDescripcionMeta.setValue(selectedGluoIndicador.getDescripcionMeta());
        txtDescripcionMeta.setDisabled(false);
        txtFechaCreacion.setValue(selectedGluoIndicador.getFechaCreacion());
        txtFechaCreacion.setDisabled(false);
        txtFechaModificacion.setValue(selectedGluoIndicador.getFechaModificacion());
        txtFechaModificacion.setDisabled(false);
        txtUsuCreador.setValue(selectedGluoIndicador.getUsuCreador());
        txtUsuCreador.setDisabled(false);
        txtUsuModificador.setValue(selectedGluoIndicador.getUsuModificador());
        txtUsuModificador.setDisabled(false);
        txtValorMeta.setValue(selectedGluoIndicador.getValorMeta());
        txtValorMeta.setDisabled(false);
        txtProyId_GluoProyecto.setValue(selectedGluoIndicador.getProyId_GluoProyecto());
        txtProyId_GluoProyecto.setDisabled(false);
        txtIndiId.setValue(selectedGluoIndicador.getIndiId());
        txtIndiId.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedGluoIndicador == null) && (entity == null)) {
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
            entity = new GluoIndicador();

            Integer indiId = FacesUtils.checkInteger(txtIndiId);

            entity.setActivo(FacesUtils.checkString(txtActivo));
            entity.setDescripcionIndicador(FacesUtils.checkString(
                    txtDescripcionIndicador));
            entity.setDescripcionLineaBase(FacesUtils.checkString(
                    txtDescripcionLineaBase));
            entity.setDescripcionMeta(FacesUtils.checkString(txtDescripcionMeta));
            entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(
                    txtFechaModificacion));
            entity.setIndiId(indiId);
            entity.setUsuCreador(FacesUtils.checkInteger(txtUsuCreador));
            entity.setUsuModificador(FacesUtils.checkInteger(txtUsuModificador));
            entity.setValorMeta(FacesUtils.checkDouble(txtValorMeta));
            entity.setGluoProyecto((FacesUtils.checkInteger(
                    txtProyId_GluoProyecto) != null)
                ? businessDelegatorView.getGluoProyecto(FacesUtils.checkInteger(
                        txtProyId_GluoProyecto)) : null);
            businessDelegatorView.saveGluoIndicador(entity);
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
                Integer indiId = new Integer(selectedGluoIndicador.getIndiId());
                entity = businessDelegatorView.getGluoIndicador(indiId);
            }

            entity.setActivo(FacesUtils.checkString(txtActivo));
            entity.setDescripcionIndicador(FacesUtils.checkString(
                    txtDescripcionIndicador));
            entity.setDescripcionLineaBase(FacesUtils.checkString(
                    txtDescripcionLineaBase));
            entity.setDescripcionMeta(FacesUtils.checkString(txtDescripcionMeta));
            entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(
                    txtFechaModificacion));
            entity.setUsuCreador(FacesUtils.checkInteger(txtUsuCreador));
            entity.setUsuModificador(FacesUtils.checkInteger(txtUsuModificador));
            entity.setValorMeta(FacesUtils.checkDouble(txtValorMeta));
            entity.setGluoProyecto((FacesUtils.checkInteger(
                    txtProyId_GluoProyecto) != null)
                ? businessDelegatorView.getGluoProyecto(FacesUtils.checkInteger(
                        txtProyId_GluoProyecto)) : null);
            businessDelegatorView.updateGluoIndicador(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedGluoIndicador = (GluoIndicadorDTO) (evt.getComponent()
                                                           .getAttributes()
                                                           .get("selectedGluoIndicador"));

            Integer indiId = new Integer(selectedGluoIndicador.getIndiId());
            entity = businessDelegatorView.getGluoIndicador(indiId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer indiId = FacesUtils.checkInteger(txtIndiId);
            entity = businessDelegatorView.getGluoIndicador(indiId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteGluoIndicador(entity);
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

    public String action_modifyWitDTO(String activo,
        String descripcionIndicador, String descripcionLineaBase,
        String descripcionMeta, Date fechaCreacion, Date fechaModificacion,
        Integer indiId, Integer usuCreador, Integer usuModificador,
        Double valorMeta, Integer proyId_GluoProyecto)
        throws Exception {
        try {
            entity.setActivo(FacesUtils.checkString(activo));
            entity.setDescripcionIndicador(FacesUtils.checkString(
                    descripcionIndicador));
            entity.setDescripcionLineaBase(FacesUtils.checkString(
                    descripcionLineaBase));
            entity.setDescripcionMeta(FacesUtils.checkString(descripcionMeta));
            entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
            entity.setUsuCreador(FacesUtils.checkInteger(usuCreador));
            entity.setUsuModificador(FacesUtils.checkInteger(usuModificador));
            entity.setValorMeta(FacesUtils.checkDouble(valorMeta));
            businessDelegatorView.updateGluoIndicador(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("GluoIndicadorView").requestRender();
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

    public InputText getTxtDescripcionIndicador() {
        return txtDescripcionIndicador;
    }

    public void setTxtDescripcionIndicador(InputText txtDescripcionIndicador) {
        this.txtDescripcionIndicador = txtDescripcionIndicador;
    }

    public InputText getTxtDescripcionLineaBase() {
        return txtDescripcionLineaBase;
    }

    public void setTxtDescripcionLineaBase(InputText txtDescripcionLineaBase) {
        this.txtDescripcionLineaBase = txtDescripcionLineaBase;
    }

    public InputText getTxtDescripcionMeta() {
        return txtDescripcionMeta;
    }

    public void setTxtDescripcionMeta(InputText txtDescripcionMeta) {
        this.txtDescripcionMeta = txtDescripcionMeta;
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

    public InputText getTxtValorMeta() {
        return txtValorMeta;
    }

    public void setTxtValorMeta(InputText txtValorMeta) {
        this.txtValorMeta = txtValorMeta;
    }

    public InputText getTxtProyId_GluoProyecto() {
        return txtProyId_GluoProyecto;
    }

    public void setTxtProyId_GluoProyecto(InputText txtProyId_GluoProyecto) {
        this.txtProyId_GluoProyecto = txtProyId_GluoProyecto;
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

    public InputText getTxtIndiId() {
        return txtIndiId;
    }

    public void setTxtIndiId(InputText txtIndiId) {
        this.txtIndiId = txtIndiId;
    }

    public List<GluoIndicadorDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataGluoIndicador();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<GluoIndicadorDTO> gluoIndicadorDTO) {
        this.data = gluoIndicadorDTO;
    }

    public GluoIndicadorDTO getSelectedGluoIndicador() {
        return selectedGluoIndicador;
    }

    public void setSelectedGluoIndicador(GluoIndicadorDTO gluoIndicador) {
        this.selectedGluoIndicador = gluoIndicador;
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
