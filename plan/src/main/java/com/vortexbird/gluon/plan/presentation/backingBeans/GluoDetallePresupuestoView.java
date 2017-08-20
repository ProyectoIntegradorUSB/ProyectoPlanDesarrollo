package com.vortexbird.gluon.plan.presentation.backingBeans;

import com.vortexbird.gluon.plan.exceptions.*;
import com.vortexbird.gluon.plan.modelo.*;
import com.vortexbird.gluon.plan.modelo.dto.GluoDetallePresupuestoDTO;
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
public class GluoDetallePresupuestoView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(GluoDetallePresupuestoView.class);
    private InputText txtActivo;
    private InputText txtCodigoCuenta;
    private InputText txtDescripcionCuenta;
    private InputText txtSaldoEnCdps;
    private InputText txtSectId;
    private InputText txtTipoTransferencia;
    private InputText txtUsuCreador;
    private InputText txtUsuModificador;
    private InputText txtValorAplazado;
    private InputText txtValorDespuesDeModificaciones;
    private InputText txtValorInicial;
    private InputText txtDptoId_GluoDetallePresupuesto;
    private InputText txtPptoId_GluoPresupuesto;
    private InputText txtTireId_GluoTipoRecurso;
    private InputText txtDptoId;
    private Calendar txtFechaCreacion;
    private Calendar txtFechaModificacion;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<GluoDetallePresupuestoDTO> data;
    private GluoDetallePresupuestoDTO selectedGluoDetallePresupuesto;
    private GluoDetallePresupuesto entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public GluoDetallePresupuestoView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedGluoDetallePresupuesto = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedGluoDetallePresupuesto = null;

        if (txtActivo != null) {
            txtActivo.setValue(null);
            txtActivo.setDisabled(true);
        }

        if (txtCodigoCuenta != null) {
            txtCodigoCuenta.setValue(null);
            txtCodigoCuenta.setDisabled(true);
        }

        if (txtDescripcionCuenta != null) {
            txtDescripcionCuenta.setValue(null);
            txtDescripcionCuenta.setDisabled(true);
        }

        if (txtSaldoEnCdps != null) {
            txtSaldoEnCdps.setValue(null);
            txtSaldoEnCdps.setDisabled(true);
        }

        if (txtSectId != null) {
            txtSectId.setValue(null);
            txtSectId.setDisabled(true);
        }

        if (txtTipoTransferencia != null) {
            txtTipoTransferencia.setValue(null);
            txtTipoTransferencia.setDisabled(true);
        }

        if (txtUsuCreador != null) {
            txtUsuCreador.setValue(null);
            txtUsuCreador.setDisabled(true);
        }

        if (txtUsuModificador != null) {
            txtUsuModificador.setValue(null);
            txtUsuModificador.setDisabled(true);
        }

        if (txtValorAplazado != null) {
            txtValorAplazado.setValue(null);
            txtValorAplazado.setDisabled(true);
        }

        if (txtValorDespuesDeModificaciones != null) {
            txtValorDespuesDeModificaciones.setValue(null);
            txtValorDespuesDeModificaciones.setDisabled(true);
        }

        if (txtValorInicial != null) {
            txtValorInicial.setValue(null);
            txtValorInicial.setDisabled(true);
        }

        if (txtDptoId_GluoDetallePresupuesto != null) {
            txtDptoId_GluoDetallePresupuesto.setValue(null);
            txtDptoId_GluoDetallePresupuesto.setDisabled(true);
        }

        if (txtPptoId_GluoPresupuesto != null) {
            txtPptoId_GluoPresupuesto.setValue(null);
            txtPptoId_GluoPresupuesto.setDisabled(true);
        }

        if (txtTireId_GluoTipoRecurso != null) {
            txtTireId_GluoTipoRecurso.setValue(null);
            txtTireId_GluoTipoRecurso.setDisabled(true);
        }

        if (txtFechaCreacion != null) {
            txtFechaCreacion.setValue(null);
            txtFechaCreacion.setDisabled(true);
        }

        if (txtFechaModificacion != null) {
            txtFechaModificacion.setValue(null);
            txtFechaModificacion.setDisabled(true);
        }

        if (txtDptoId != null) {
            txtDptoId.setValue(null);
            txtDptoId.setDisabled(false);
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
            Integer dptoId = FacesUtils.checkInteger(txtDptoId);
            entity = (dptoId != null)
                ? businessDelegatorView.getGluoDetallePresupuesto(dptoId) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtActivo.setDisabled(false);
            txtCodigoCuenta.setDisabled(false);
            txtDescripcionCuenta.setDisabled(false);
            txtSaldoEnCdps.setDisabled(false);
            txtSectId.setDisabled(false);
            txtTipoTransferencia.setDisabled(false);
            txtUsuCreador.setDisabled(false);
            txtUsuModificador.setDisabled(false);
            txtValorAplazado.setDisabled(false);
            txtValorDespuesDeModificaciones.setDisabled(false);
            txtValorInicial.setDisabled(false);
            txtDptoId_GluoDetallePresupuesto.setDisabled(false);
            txtPptoId_GluoPresupuesto.setDisabled(false);
            txtTireId_GluoTipoRecurso.setDisabled(false);
            txtFechaCreacion.setDisabled(false);
            txtFechaModificacion.setDisabled(false);
            txtDptoId.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtActivo.setValue(entity.getActivo());
            txtActivo.setDisabled(false);
            txtCodigoCuenta.setValue(entity.getCodigoCuenta());
            txtCodigoCuenta.setDisabled(false);
            txtDescripcionCuenta.setValue(entity.getDescripcionCuenta());
            txtDescripcionCuenta.setDisabled(false);
            txtFechaCreacion.setValue(entity.getFechaCreacion());
            txtFechaCreacion.setDisabled(false);
            txtFechaModificacion.setValue(entity.getFechaModificacion());
            txtFechaModificacion.setDisabled(false);
            txtSaldoEnCdps.setValue(entity.getSaldoEnCdps());
            txtSaldoEnCdps.setDisabled(false);
            txtSectId.setValue(entity.getSectId());
            txtSectId.setDisabled(false);
            txtTipoTransferencia.setValue(entity.getTipoTransferencia());
            txtTipoTransferencia.setDisabled(false);
            txtUsuCreador.setValue(entity.getUsuCreador());
            txtUsuCreador.setDisabled(false);
            txtUsuModificador.setValue(entity.getUsuModificador());
            txtUsuModificador.setDisabled(false);
            txtValorAplazado.setValue(entity.getValorAplazado());
            txtValorAplazado.setDisabled(false);
            txtValorDespuesDeModificaciones.setValue(entity.getValorDespuesDeModificaciones());
            txtValorDespuesDeModificaciones.setDisabled(false);
            txtValorInicial.setValue(entity.getValorInicial());
            txtValorInicial.setDisabled(false);
            txtDptoId_GluoDetallePresupuesto.setValue(entity.getGluoDetallePresupuesto()
                                                            .getDptoId());
            txtDptoId_GluoDetallePresupuesto.setDisabled(false);
            txtPptoId_GluoPresupuesto.setValue(entity.getGluoPresupuesto()
                                                     .getPptoId());
            txtPptoId_GluoPresupuesto.setDisabled(false);
            txtTireId_GluoTipoRecurso.setValue(entity.getGluoTipoRecurso()
                                                     .getTireId());
            txtTireId_GluoTipoRecurso.setDisabled(false);
            txtDptoId.setValue(entity.getDptoId());
            txtDptoId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedGluoDetallePresupuesto = (GluoDetallePresupuestoDTO) (evt.getComponent()
                                                                         .getAttributes()
                                                                         .get("selectedGluoDetallePresupuesto"));
        txtActivo.setValue(selectedGluoDetallePresupuesto.getActivo());
        txtActivo.setDisabled(false);
        txtCodigoCuenta.setValue(selectedGluoDetallePresupuesto.getCodigoCuenta());
        txtCodigoCuenta.setDisabled(false);
        txtDescripcionCuenta.setValue(selectedGluoDetallePresupuesto.getDescripcionCuenta());
        txtDescripcionCuenta.setDisabled(false);
        txtFechaCreacion.setValue(selectedGluoDetallePresupuesto.getFechaCreacion());
        txtFechaCreacion.setDisabled(false);
        txtFechaModificacion.setValue(selectedGluoDetallePresupuesto.getFechaModificacion());
        txtFechaModificacion.setDisabled(false);
        txtSaldoEnCdps.setValue(selectedGluoDetallePresupuesto.getSaldoEnCdps());
        txtSaldoEnCdps.setDisabled(false);
        txtSectId.setValue(selectedGluoDetallePresupuesto.getSectId());
        txtSectId.setDisabled(false);
        txtTipoTransferencia.setValue(selectedGluoDetallePresupuesto.getTipoTransferencia());
        txtTipoTransferencia.setDisabled(false);
        txtUsuCreador.setValue(selectedGluoDetallePresupuesto.getUsuCreador());
        txtUsuCreador.setDisabled(false);
        txtUsuModificador.setValue(selectedGluoDetallePresupuesto.getUsuModificador());
        txtUsuModificador.setDisabled(false);
        txtValorAplazado.setValue(selectedGluoDetallePresupuesto.getValorAplazado());
        txtValorAplazado.setDisabled(false);
        txtValorDespuesDeModificaciones.setValue(selectedGluoDetallePresupuesto.getValorDespuesDeModificaciones());
        txtValorDespuesDeModificaciones.setDisabled(false);
        txtValorInicial.setValue(selectedGluoDetallePresupuesto.getValorInicial());
        txtValorInicial.setDisabled(false);
        txtDptoId_GluoDetallePresupuesto.setValue(selectedGluoDetallePresupuesto.getDptoId_GluoDetallePresupuesto());
        txtDptoId_GluoDetallePresupuesto.setDisabled(false);
        txtPptoId_GluoPresupuesto.setValue(selectedGluoDetallePresupuesto.getPptoId_GluoPresupuesto());
        txtPptoId_GluoPresupuesto.setDisabled(false);
        txtTireId_GluoTipoRecurso.setValue(selectedGluoDetallePresupuesto.getTireId_GluoTipoRecurso());
        txtTireId_GluoTipoRecurso.setDisabled(false);
        txtDptoId.setValue(selectedGluoDetallePresupuesto.getDptoId());
        txtDptoId.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedGluoDetallePresupuesto == null) && (entity == null)) {
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
            entity = new GluoDetallePresupuesto();

            Integer dptoId = FacesUtils.checkInteger(txtDptoId);

            entity.setActivo(FacesUtils.checkString(txtActivo));
            entity.setCodigoCuenta(FacesUtils.checkString(txtCodigoCuenta));
            entity.setDescripcionCuenta(FacesUtils.checkString(
                    txtDescripcionCuenta));
            entity.setDptoId(dptoId);
            entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(
                    txtFechaModificacion));
            entity.setSaldoEnCdps(FacesUtils.checkDouble(txtSaldoEnCdps));
            entity.setSectId(FacesUtils.checkInteger(txtSectId));
            entity.setTipoTransferencia(FacesUtils.checkString(
                    txtTipoTransferencia));
            entity.setUsuCreador(FacesUtils.checkInteger(txtUsuCreador));
            entity.setUsuModificador(FacesUtils.checkInteger(txtUsuModificador));
            entity.setValorAplazado(FacesUtils.checkDouble(txtValorAplazado));
            entity.setValorDespuesDeModificaciones(FacesUtils.checkDouble(
                    txtValorDespuesDeModificaciones));
            entity.setValorInicial(FacesUtils.checkDouble(txtValorInicial));
            entity.setGluoDetallePresupuesto((FacesUtils.checkInteger(
                    txtDptoId_GluoDetallePresupuesto) != null)
                ? businessDelegatorView.getGluoDetallePresupuesto(
                    FacesUtils.checkInteger(txtDptoId_GluoDetallePresupuesto))
                : null);
            entity.setGluoPresupuesto((FacesUtils.checkInteger(
                    txtPptoId_GluoPresupuesto) != null)
                ? businessDelegatorView.getGluoPresupuesto(
                    FacesUtils.checkInteger(txtPptoId_GluoPresupuesto)) : null);
            entity.setGluoTipoRecurso((FacesUtils.checkInteger(
                    txtTireId_GluoTipoRecurso) != null)
                ? businessDelegatorView.getGluoTipoRecurso(
                    FacesUtils.checkInteger(txtTireId_GluoTipoRecurso)) : null);
            businessDelegatorView.saveGluoDetallePresupuesto(entity);
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
                Integer dptoId = new Integer(selectedGluoDetallePresupuesto.getDptoId());
                entity = businessDelegatorView.getGluoDetallePresupuesto(dptoId);
            }

            entity.setActivo(FacesUtils.checkString(txtActivo));
            entity.setCodigoCuenta(FacesUtils.checkString(txtCodigoCuenta));
            entity.setDescripcionCuenta(FacesUtils.checkString(
                    txtDescripcionCuenta));
            entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(
                    txtFechaModificacion));
            entity.setSaldoEnCdps(FacesUtils.checkDouble(txtSaldoEnCdps));
            entity.setSectId(FacesUtils.checkInteger(txtSectId));
            entity.setTipoTransferencia(FacesUtils.checkString(
                    txtTipoTransferencia));
            entity.setUsuCreador(FacesUtils.checkInteger(txtUsuCreador));
            entity.setUsuModificador(FacesUtils.checkInteger(txtUsuModificador));
            entity.setValorAplazado(FacesUtils.checkDouble(txtValorAplazado));
            entity.setValorDespuesDeModificaciones(FacesUtils.checkDouble(
                    txtValorDespuesDeModificaciones));
            entity.setValorInicial(FacesUtils.checkDouble(txtValorInicial));
            entity.setGluoDetallePresupuesto((FacesUtils.checkInteger(
                    txtDptoId_GluoDetallePresupuesto) != null)
                ? businessDelegatorView.getGluoDetallePresupuesto(
                    FacesUtils.checkInteger(txtDptoId_GluoDetallePresupuesto))
                : null);
            entity.setGluoPresupuesto((FacesUtils.checkInteger(
                    txtPptoId_GluoPresupuesto) != null)
                ? businessDelegatorView.getGluoPresupuesto(
                    FacesUtils.checkInteger(txtPptoId_GluoPresupuesto)) : null);
            entity.setGluoTipoRecurso((FacesUtils.checkInteger(
                    txtTireId_GluoTipoRecurso) != null)
                ? businessDelegatorView.getGluoTipoRecurso(
                    FacesUtils.checkInteger(txtTireId_GluoTipoRecurso)) : null);
            businessDelegatorView.updateGluoDetallePresupuesto(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedGluoDetallePresupuesto = (GluoDetallePresupuestoDTO) (evt.getComponent()
                                                                             .getAttributes()
                                                                             .get("selectedGluoDetallePresupuesto"));

            Integer dptoId = new Integer(selectedGluoDetallePresupuesto.getDptoId());
            entity = businessDelegatorView.getGluoDetallePresupuesto(dptoId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer dptoId = FacesUtils.checkInteger(txtDptoId);
            entity = businessDelegatorView.getGluoDetallePresupuesto(dptoId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteGluoDetallePresupuesto(entity);
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

    public String action_modifyWitDTO(String activo, String codigoCuenta,
        String descripcionCuenta, Integer dptoId, Date fechaCreacion,
        Date fechaModificacion, Double saldoEnCdps, Integer sectId,
        String tipoTransferencia, Integer usuCreador, Integer usuModificador,
        Double valorAplazado, Double valorDespuesDeModificaciones,
        Double valorInicial, Integer dptoId_GluoDetallePresupuesto,
        Integer pptoId_GluoPresupuesto, Integer tireId_GluoTipoRecurso)
        throws Exception {
        try {
            entity.setActivo(FacesUtils.checkString(activo));
            entity.setCodigoCuenta(FacesUtils.checkString(codigoCuenta));
            entity.setDescripcionCuenta(FacesUtils.checkString(
                    descripcionCuenta));
            entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
            entity.setSaldoEnCdps(FacesUtils.checkDouble(saldoEnCdps));
            entity.setSectId(FacesUtils.checkInteger(sectId));
            entity.setTipoTransferencia(FacesUtils.checkString(
                    tipoTransferencia));
            entity.setUsuCreador(FacesUtils.checkInteger(usuCreador));
            entity.setUsuModificador(FacesUtils.checkInteger(usuModificador));
            entity.setValorAplazado(FacesUtils.checkDouble(valorAplazado));
            entity.setValorDespuesDeModificaciones(FacesUtils.checkDouble(
                    valorDespuesDeModificaciones));
            entity.setValorInicial(FacesUtils.checkDouble(valorInicial));
            businessDelegatorView.updateGluoDetallePresupuesto(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("GluoDetallePresupuestoView").requestRender();
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

    public InputText getTxtCodigoCuenta() {
        return txtCodigoCuenta;
    }

    public void setTxtCodigoCuenta(InputText txtCodigoCuenta) {
        this.txtCodigoCuenta = txtCodigoCuenta;
    }

    public InputText getTxtDescripcionCuenta() {
        return txtDescripcionCuenta;
    }

    public void setTxtDescripcionCuenta(InputText txtDescripcionCuenta) {
        this.txtDescripcionCuenta = txtDescripcionCuenta;
    }

    public InputText getTxtSaldoEnCdps() {
        return txtSaldoEnCdps;
    }

    public void setTxtSaldoEnCdps(InputText txtSaldoEnCdps) {
        this.txtSaldoEnCdps = txtSaldoEnCdps;
    }

    public InputText getTxtSectId() {
        return txtSectId;
    }

    public void setTxtSectId(InputText txtSectId) {
        this.txtSectId = txtSectId;
    }

    public InputText getTxtTipoTransferencia() {
        return txtTipoTransferencia;
    }

    public void setTxtTipoTransferencia(InputText txtTipoTransferencia) {
        this.txtTipoTransferencia = txtTipoTransferencia;
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

    public InputText getTxtValorAplazado() {
        return txtValorAplazado;
    }

    public void setTxtValorAplazado(InputText txtValorAplazado) {
        this.txtValorAplazado = txtValorAplazado;
    }

    public InputText getTxtValorDespuesDeModificaciones() {
        return txtValorDespuesDeModificaciones;
    }

    public void setTxtValorDespuesDeModificaciones(
        InputText txtValorDespuesDeModificaciones) {
        this.txtValorDespuesDeModificaciones = txtValorDespuesDeModificaciones;
    }

    public InputText getTxtValorInicial() {
        return txtValorInicial;
    }

    public void setTxtValorInicial(InputText txtValorInicial) {
        this.txtValorInicial = txtValorInicial;
    }

    public InputText getTxtDptoId_GluoDetallePresupuesto() {
        return txtDptoId_GluoDetallePresupuesto;
    }

    public void setTxtDptoId_GluoDetallePresupuesto(
        InputText txtDptoId_GluoDetallePresupuesto) {
        this.txtDptoId_GluoDetallePresupuesto = txtDptoId_GluoDetallePresupuesto;
    }

    public InputText getTxtPptoId_GluoPresupuesto() {
        return txtPptoId_GluoPresupuesto;
    }

    public void setTxtPptoId_GluoPresupuesto(
        InputText txtPptoId_GluoPresupuesto) {
        this.txtPptoId_GluoPresupuesto = txtPptoId_GluoPresupuesto;
    }

    public InputText getTxtTireId_GluoTipoRecurso() {
        return txtTireId_GluoTipoRecurso;
    }

    public void setTxtTireId_GluoTipoRecurso(
        InputText txtTireId_GluoTipoRecurso) {
        this.txtTireId_GluoTipoRecurso = txtTireId_GluoTipoRecurso;
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

    public InputText getTxtDptoId() {
        return txtDptoId;
    }

    public void setTxtDptoId(InputText txtDptoId) {
        this.txtDptoId = txtDptoId;
    }

    public List<GluoDetallePresupuestoDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataGluoDetallePresupuesto();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(
        List<GluoDetallePresupuestoDTO> gluoDetallePresupuestoDTO) {
        this.data = gluoDetallePresupuestoDTO;
    }

    public GluoDetallePresupuestoDTO getSelectedGluoDetallePresupuesto() {
        return selectedGluoDetallePresupuesto;
    }

    public void setSelectedGluoDetallePresupuesto(
        GluoDetallePresupuestoDTO gluoDetallePresupuesto) {
        this.selectedGluoDetallePresupuesto = gluoDetallePresupuesto;
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
