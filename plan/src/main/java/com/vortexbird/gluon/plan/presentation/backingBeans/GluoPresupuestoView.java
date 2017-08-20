package com.vortexbird.gluon.plan.presentation.backingBeans;

import com.vortexbird.gluon.plan.exceptions.*;
import com.vortexbird.gluon.plan.modelo.*;
import com.vortexbird.gluon.plan.modelo.dto.GluoPresupuestoDTO;
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
public class GluoPresupuestoView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(GluoPresupuestoView.class);
    private InputText txtActivo;
    private InputText txtAprobado;
    private InputText txtContabilizado;
    private InputText txtTippId;
    private InputText txtUsuAprobador;
    private InputText txtUsuCreador;
    private InputText txtUsuModificador;
    private InputText txtAnofId_GluoAnoFiscal;
    private InputText txtPptoId;
    private Calendar txtFechaCreacion;
    private Calendar txtFechaModificacion;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<GluoPresupuestoDTO> data;
    private GluoPresupuestoDTO selectedGluoPresupuesto;
    private GluoPresupuesto entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public GluoPresupuestoView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedGluoPresupuesto = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedGluoPresupuesto = null;

        if (txtActivo != null) {
            txtActivo.setValue(null);
            txtActivo.setDisabled(true);
        }

        if (txtAprobado != null) {
            txtAprobado.setValue(null);
            txtAprobado.setDisabled(true);
        }

        if (txtContabilizado != null) {
            txtContabilizado.setValue(null);
            txtContabilizado.setDisabled(true);
        }

        if (txtTippId != null) {
            txtTippId.setValue(null);
            txtTippId.setDisabled(true);
        }

        if (txtUsuAprobador != null) {
            txtUsuAprobador.setValue(null);
            txtUsuAprobador.setDisabled(true);
        }

        if (txtUsuCreador != null) {
            txtUsuCreador.setValue(null);
            txtUsuCreador.setDisabled(true);
        }

        if (txtUsuModificador != null) {
            txtUsuModificador.setValue(null);
            txtUsuModificador.setDisabled(true);
        }

        if (txtAnofId_GluoAnoFiscal != null) {
            txtAnofId_GluoAnoFiscal.setValue(null);
            txtAnofId_GluoAnoFiscal.setDisabled(true);
        }

        if (txtFechaCreacion != null) {
            txtFechaCreacion.setValue(null);
            txtFechaCreacion.setDisabled(true);
        }

        if (txtFechaModificacion != null) {
            txtFechaModificacion.setValue(null);
            txtFechaModificacion.setDisabled(true);
        }

        if (txtPptoId != null) {
            txtPptoId.setValue(null);
            txtPptoId.setDisabled(false);
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
            Integer pptoId = FacesUtils.checkInteger(txtPptoId);
            entity = (pptoId != null)
                ? businessDelegatorView.getGluoPresupuesto(pptoId) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtActivo.setDisabled(false);
            txtAprobado.setDisabled(false);
            txtContabilizado.setDisabled(false);
            txtTippId.setDisabled(false);
            txtUsuAprobador.setDisabled(false);
            txtUsuCreador.setDisabled(false);
            txtUsuModificador.setDisabled(false);
            txtAnofId_GluoAnoFiscal.setDisabled(false);
            txtFechaCreacion.setDisabled(false);
            txtFechaModificacion.setDisabled(false);
            txtPptoId.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtActivo.setValue(entity.getActivo());
            txtActivo.setDisabled(false);
            txtAprobado.setValue(entity.getAprobado());
            txtAprobado.setDisabled(false);
            txtContabilizado.setValue(entity.getContabilizado());
            txtContabilizado.setDisabled(false);
            txtFechaCreacion.setValue(entity.getFechaCreacion());
            txtFechaCreacion.setDisabled(false);
            txtFechaModificacion.setValue(entity.getFechaModificacion());
            txtFechaModificacion.setDisabled(false);
            txtTippId.setValue(entity.getTippId());
            txtTippId.setDisabled(false);
            txtUsuAprobador.setValue(entity.getUsuAprobador());
            txtUsuAprobador.setDisabled(false);
            txtUsuCreador.setValue(entity.getUsuCreador());
            txtUsuCreador.setDisabled(false);
            txtUsuModificador.setValue(entity.getUsuModificador());
            txtUsuModificador.setDisabled(false);
            txtAnofId_GluoAnoFiscal.setValue(entity.getGluoAnoFiscal()
                                                   .getAnofId());
            txtAnofId_GluoAnoFiscal.setDisabled(false);
            txtPptoId.setValue(entity.getPptoId());
            txtPptoId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedGluoPresupuesto = (GluoPresupuestoDTO) (evt.getComponent()
                                                           .getAttributes()
                                                           .get("selectedGluoPresupuesto"));
        txtActivo.setValue(selectedGluoPresupuesto.getActivo());
        txtActivo.setDisabled(false);
        txtAprobado.setValue(selectedGluoPresupuesto.getAprobado());
        txtAprobado.setDisabled(false);
        txtContabilizado.setValue(selectedGluoPresupuesto.getContabilizado());
        txtContabilizado.setDisabled(false);
        txtFechaCreacion.setValue(selectedGluoPresupuesto.getFechaCreacion());
        txtFechaCreacion.setDisabled(false);
        txtFechaModificacion.setValue(selectedGluoPresupuesto.getFechaModificacion());
        txtFechaModificacion.setDisabled(false);
        txtTippId.setValue(selectedGluoPresupuesto.getTippId());
        txtTippId.setDisabled(false);
        txtUsuAprobador.setValue(selectedGluoPresupuesto.getUsuAprobador());
        txtUsuAprobador.setDisabled(false);
        txtUsuCreador.setValue(selectedGluoPresupuesto.getUsuCreador());
        txtUsuCreador.setDisabled(false);
        txtUsuModificador.setValue(selectedGluoPresupuesto.getUsuModificador());
        txtUsuModificador.setDisabled(false);
        txtAnofId_GluoAnoFiscal.setValue(selectedGluoPresupuesto.getAnofId_GluoAnoFiscal());
        txtAnofId_GluoAnoFiscal.setDisabled(false);
        txtPptoId.setValue(selectedGluoPresupuesto.getPptoId());
        txtPptoId.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedGluoPresupuesto == null) && (entity == null)) {
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
            entity = new GluoPresupuesto();

            Integer pptoId = FacesUtils.checkInteger(txtPptoId);

            entity.setActivo(FacesUtils.checkString(txtActivo));
            entity.setAprobado(FacesUtils.checkString(txtAprobado));
            entity.setContabilizado(FacesUtils.checkString(txtContabilizado));
            entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(
                    txtFechaModificacion));
            entity.setPptoId(pptoId);
            entity.setTippId(FacesUtils.checkInteger(txtTippId));
            entity.setUsuAprobador(FacesUtils.checkInteger(txtUsuAprobador));
            entity.setUsuCreador(FacesUtils.checkInteger(txtUsuCreador));
            entity.setUsuModificador(FacesUtils.checkInteger(txtUsuModificador));
            entity.setGluoAnoFiscal((FacesUtils.checkInteger(
                    txtAnofId_GluoAnoFiscal) != null)
                ? businessDelegatorView.getGluoAnoFiscal(
                    FacesUtils.checkInteger(txtAnofId_GluoAnoFiscal)) : null);
            businessDelegatorView.saveGluoPresupuesto(entity);
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
                Integer pptoId = new Integer(selectedGluoPresupuesto.getPptoId());
                entity = businessDelegatorView.getGluoPresupuesto(pptoId);
            }

            entity.setActivo(FacesUtils.checkString(txtActivo));
            entity.setAprobado(FacesUtils.checkString(txtAprobado));
            entity.setContabilizado(FacesUtils.checkString(txtContabilizado));
            entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(
                    txtFechaModificacion));
            entity.setTippId(FacesUtils.checkInteger(txtTippId));
            entity.setUsuAprobador(FacesUtils.checkInteger(txtUsuAprobador));
            entity.setUsuCreador(FacesUtils.checkInteger(txtUsuCreador));
            entity.setUsuModificador(FacesUtils.checkInteger(txtUsuModificador));
            entity.setGluoAnoFiscal((FacesUtils.checkInteger(
                    txtAnofId_GluoAnoFiscal) != null)
                ? businessDelegatorView.getGluoAnoFiscal(
                    FacesUtils.checkInteger(txtAnofId_GluoAnoFiscal)) : null);
            businessDelegatorView.updateGluoPresupuesto(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedGluoPresupuesto = (GluoPresupuestoDTO) (evt.getComponent()
                                                               .getAttributes()
                                                               .get("selectedGluoPresupuesto"));

            Integer pptoId = new Integer(selectedGluoPresupuesto.getPptoId());
            entity = businessDelegatorView.getGluoPresupuesto(pptoId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer pptoId = FacesUtils.checkInteger(txtPptoId);
            entity = businessDelegatorView.getGluoPresupuesto(pptoId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteGluoPresupuesto(entity);
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

    public String action_modifyWitDTO(String activo, String aprobado,
        String contabilizado, Date fechaCreacion, Date fechaModificacion,
        Integer pptoId, Integer tippId, Integer usuAprobador,
        Integer usuCreador, Integer usuModificador, Integer anofId_GluoAnoFiscal)
        throws Exception {
        try {
            entity.setActivo(FacesUtils.checkString(activo));
            entity.setAprobado(FacesUtils.checkString(aprobado));
            entity.setContabilizado(FacesUtils.checkString(contabilizado));
            entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
            entity.setTippId(FacesUtils.checkInteger(tippId));
            entity.setUsuAprobador(FacesUtils.checkInteger(usuAprobador));
            entity.setUsuCreador(FacesUtils.checkInteger(usuCreador));
            entity.setUsuModificador(FacesUtils.checkInteger(usuModificador));
            businessDelegatorView.updateGluoPresupuesto(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("GluoPresupuestoView").requestRender();
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

    public InputText getTxtAprobado() {
        return txtAprobado;
    }

    public void setTxtAprobado(InputText txtAprobado) {
        this.txtAprobado = txtAprobado;
    }

    public InputText getTxtContabilizado() {
        return txtContabilizado;
    }

    public void setTxtContabilizado(InputText txtContabilizado) {
        this.txtContabilizado = txtContabilizado;
    }

    public InputText getTxtTippId() {
        return txtTippId;
    }

    public void setTxtTippId(InputText txtTippId) {
        this.txtTippId = txtTippId;
    }

    public InputText getTxtUsuAprobador() {
        return txtUsuAprobador;
    }

    public void setTxtUsuAprobador(InputText txtUsuAprobador) {
        this.txtUsuAprobador = txtUsuAprobador;
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

    public InputText getTxtAnofId_GluoAnoFiscal() {
        return txtAnofId_GluoAnoFiscal;
    }

    public void setTxtAnofId_GluoAnoFiscal(InputText txtAnofId_GluoAnoFiscal) {
        this.txtAnofId_GluoAnoFiscal = txtAnofId_GluoAnoFiscal;
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

    public InputText getTxtPptoId() {
        return txtPptoId;
    }

    public void setTxtPptoId(InputText txtPptoId) {
        this.txtPptoId = txtPptoId;
    }

    public List<GluoPresupuestoDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataGluoPresupuesto();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<GluoPresupuestoDTO> gluoPresupuestoDTO) {
        this.data = gluoPresupuestoDTO;
    }

    public GluoPresupuestoDTO getSelectedGluoPresupuesto() {
        return selectedGluoPresupuesto;
    }

    public void setSelectedGluoPresupuesto(GluoPresupuestoDTO gluoPresupuesto) {
        this.selectedGluoPresupuesto = gluoPresupuesto;
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
