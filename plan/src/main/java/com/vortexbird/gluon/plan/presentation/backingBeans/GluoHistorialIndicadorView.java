package com.vortexbird.gluon.plan.presentation.backingBeans;

import com.vortexbird.gluon.plan.exceptions.*;
import com.vortexbird.gluon.plan.modelo.*;
import com.vortexbird.gluon.plan.modelo.dto.GluoHistorialIndicadorDTO;
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
public class GluoHistorialIndicadorView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(GluoHistorialIndicadorView.class);
    private InputText txtActivo;
    private InputText txtUsuCreador;
    private InputText txtUsuModificador;
    private InputText txtValorReal;
    private InputText txtIndiId_GluoIndicador;
    private InputText txtHiinId;
    private Calendar txtFecha;
    private Calendar txtFechaCreacion;
    private Calendar txtFechaModificacion;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<GluoHistorialIndicadorDTO> data;
    private GluoHistorialIndicadorDTO selectedGluoHistorialIndicador;
    private GluoHistorialIndicador entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public GluoHistorialIndicadorView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedGluoHistorialIndicador = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedGluoHistorialIndicador = null;

        if (txtActivo != null) {
            txtActivo.setValue(null);
            txtActivo.setDisabled(true);
        }

        if (txtUsuCreador != null) {
            txtUsuCreador.setValue(null);
            txtUsuCreador.setDisabled(true);
        }

        if (txtUsuModificador != null) {
            txtUsuModificador.setValue(null);
            txtUsuModificador.setDisabled(true);
        }

        if (txtValorReal != null) {
            txtValorReal.setValue(null);
            txtValorReal.setDisabled(true);
        }

        if (txtIndiId_GluoIndicador != null) {
            txtIndiId_GluoIndicador.setValue(null);
            txtIndiId_GluoIndicador.setDisabled(true);
        }

        if (txtFecha != null) {
            txtFecha.setValue(null);
            txtFecha.setDisabled(true);
        }

        if (txtFechaCreacion != null) {
            txtFechaCreacion.setValue(null);
            txtFechaCreacion.setDisabled(true);
        }

        if (txtFechaModificacion != null) {
            txtFechaModificacion.setValue(null);
            txtFechaModificacion.setDisabled(true);
        }

        if (txtHiinId != null) {
            txtHiinId.setValue(null);
            txtHiinId.setDisabled(false);
        }

        if (btnSave != null) {
            btnSave.setDisabled(true);
        }

        if (btnDelete != null) {
            btnDelete.setDisabled(true);
        }

        return "";
    }

    public void listener_txtFecha() {
        Date inputDate = (Date) txtFecha.getValue();
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

    public void listener_txtId() {
        try {
            Integer hiinId = FacesUtils.checkInteger(txtHiinId);
            entity = (hiinId != null)
                ? businessDelegatorView.getGluoHistorialIndicador(hiinId) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtActivo.setDisabled(false);
            txtUsuCreador.setDisabled(false);
            txtUsuModificador.setDisabled(false);
            txtValorReal.setDisabled(false);
            txtIndiId_GluoIndicador.setDisabled(false);
            txtFecha.setDisabled(false);
            txtFechaCreacion.setDisabled(false);
            txtFechaModificacion.setDisabled(false);
            txtHiinId.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtActivo.setValue(entity.getActivo());
            txtActivo.setDisabled(false);
            txtFecha.setValue(entity.getFecha());
            txtFecha.setDisabled(false);
            txtFechaCreacion.setValue(entity.getFechaCreacion());
            txtFechaCreacion.setDisabled(false);
            txtFechaModificacion.setValue(entity.getFechaModificacion());
            txtFechaModificacion.setDisabled(false);
            txtUsuCreador.setValue(entity.getUsuCreador());
            txtUsuCreador.setDisabled(false);
            txtUsuModificador.setValue(entity.getUsuModificador());
            txtUsuModificador.setDisabled(false);
            txtValorReal.setValue(entity.getValorReal());
            txtValorReal.setDisabled(false);
            txtIndiId_GluoIndicador.setValue(entity.getGluoIndicador()
                                                   .getIndiId());
            txtIndiId_GluoIndicador.setDisabled(false);
            txtHiinId.setValue(entity.getHiinId());
            txtHiinId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedGluoHistorialIndicador = (GluoHistorialIndicadorDTO) (evt.getComponent()
                                                                         .getAttributes()
                                                                         .get("selectedGluoHistorialIndicador"));
        txtActivo.setValue(selectedGluoHistorialIndicador.getActivo());
        txtActivo.setDisabled(false);
        txtFecha.setValue(selectedGluoHistorialIndicador.getFecha());
        txtFecha.setDisabled(false);
        txtFechaCreacion.setValue(selectedGluoHistorialIndicador.getFechaCreacion());
        txtFechaCreacion.setDisabled(false);
        txtFechaModificacion.setValue(selectedGluoHistorialIndicador.getFechaModificacion());
        txtFechaModificacion.setDisabled(false);
        txtUsuCreador.setValue(selectedGluoHistorialIndicador.getUsuCreador());
        txtUsuCreador.setDisabled(false);
        txtUsuModificador.setValue(selectedGluoHistorialIndicador.getUsuModificador());
        txtUsuModificador.setDisabled(false);
        txtValorReal.setValue(selectedGluoHistorialIndicador.getValorReal());
        txtValorReal.setDisabled(false);
        txtIndiId_GluoIndicador.setValue(selectedGluoHistorialIndicador.getIndiId_GluoIndicador());
        txtIndiId_GluoIndicador.setDisabled(false);
        txtHiinId.setValue(selectedGluoHistorialIndicador.getHiinId());
        txtHiinId.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedGluoHistorialIndicador == null) && (entity == null)) {
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
            entity = new GluoHistorialIndicador();

            Integer hiinId = FacesUtils.checkInteger(txtHiinId);

            entity.setActivo(FacesUtils.checkString(txtActivo));
            entity.setFecha(FacesUtils.checkDate(txtFecha));
            entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(
                    txtFechaModificacion));
            entity.setHiinId(hiinId);
            entity.setUsuCreador(FacesUtils.checkInteger(txtUsuCreador));
            entity.setUsuModificador(FacesUtils.checkInteger(txtUsuModificador));
            entity.setValorReal(FacesUtils.checkDouble(txtValorReal));
            entity.setGluoIndicador((FacesUtils.checkInteger(
                    txtIndiId_GluoIndicador) != null)
                ? businessDelegatorView.getGluoIndicador(
                    FacesUtils.checkInteger(txtIndiId_GluoIndicador)) : null);
            businessDelegatorView.saveGluoHistorialIndicador(entity);
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
                Integer hiinId = new Integer(selectedGluoHistorialIndicador.getHiinId());
                entity = businessDelegatorView.getGluoHistorialIndicador(hiinId);
            }

            entity.setActivo(FacesUtils.checkString(txtActivo));
            entity.setFecha(FacesUtils.checkDate(txtFecha));
            entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(
                    txtFechaModificacion));
            entity.setUsuCreador(FacesUtils.checkInteger(txtUsuCreador));
            entity.setUsuModificador(FacesUtils.checkInteger(txtUsuModificador));
            entity.setValorReal(FacesUtils.checkDouble(txtValorReal));
            entity.setGluoIndicador((FacesUtils.checkInteger(
                    txtIndiId_GluoIndicador) != null)
                ? businessDelegatorView.getGluoIndicador(
                    FacesUtils.checkInteger(txtIndiId_GluoIndicador)) : null);
            businessDelegatorView.updateGluoHistorialIndicador(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedGluoHistorialIndicador = (GluoHistorialIndicadorDTO) (evt.getComponent()
                                                                             .getAttributes()
                                                                             .get("selectedGluoHistorialIndicador"));

            Integer hiinId = new Integer(selectedGluoHistorialIndicador.getHiinId());
            entity = businessDelegatorView.getGluoHistorialIndicador(hiinId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer hiinId = FacesUtils.checkInteger(txtHiinId);
            entity = businessDelegatorView.getGluoHistorialIndicador(hiinId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteGluoHistorialIndicador(entity);
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

    public String action_modifyWitDTO(String activo, Date fecha,
        Date fechaCreacion, Date fechaModificacion, Integer hiinId,
        Integer usuCreador, Integer usuModificador, Double valorReal,
        Integer indiId_GluoIndicador) throws Exception {
        try {
            entity.setActivo(FacesUtils.checkString(activo));
            entity.setFecha(FacesUtils.checkDate(fecha));
            entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
            entity.setUsuCreador(FacesUtils.checkInteger(usuCreador));
            entity.setUsuModificador(FacesUtils.checkInteger(usuModificador));
            entity.setValorReal(FacesUtils.checkDouble(valorReal));
            businessDelegatorView.updateGluoHistorialIndicador(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("GluoHistorialIndicadorView").requestRender();
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

    public InputText getTxtValorReal() {
        return txtValorReal;
    }

    public void setTxtValorReal(InputText txtValorReal) {
        this.txtValorReal = txtValorReal;
    }

    public InputText getTxtIndiId_GluoIndicador() {
        return txtIndiId_GluoIndicador;
    }

    public void setTxtIndiId_GluoIndicador(InputText txtIndiId_GluoIndicador) {
        this.txtIndiId_GluoIndicador = txtIndiId_GluoIndicador;
    }

    public Calendar getTxtFecha() {
        return txtFecha;
    }

    public void setTxtFecha(Calendar txtFecha) {
        this.txtFecha = txtFecha;
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

    public InputText getTxtHiinId() {
        return txtHiinId;
    }

    public void setTxtHiinId(InputText txtHiinId) {
        this.txtHiinId = txtHiinId;
    }

    public List<GluoHistorialIndicadorDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataGluoHistorialIndicador();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(
        List<GluoHistorialIndicadorDTO> gluoHistorialIndicadorDTO) {
        this.data = gluoHistorialIndicadorDTO;
    }

    public GluoHistorialIndicadorDTO getSelectedGluoHistorialIndicador() {
        return selectedGluoHistorialIndicador;
    }

    public void setSelectedGluoHistorialIndicador(
        GluoHistorialIndicadorDTO gluoHistorialIndicador) {
        this.selectedGluoHistorialIndicador = gluoHistorialIndicador;
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
