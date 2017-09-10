package com.vortexbird.gluon.plan.presentation.backingBeans;

import com.vortexbird.gluon.plan.exceptions.*;
import com.vortexbird.gluon.plan.modelo.*;
import com.vortexbird.gluon.plan.modelo.dto.GluoPlanDesarrolloDTO;
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
public class GluoPlanDesarrolloView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(GluoPlanDesarrolloView.class);
    private String somActivo;
    private InputTextarea txtAreaDescripcion;
    private InputTextarea txtAreaEslogan;
    private InputText txtNombreAlcalde;
    private InputText txtUsuCreador;
    private InputText txtUsuModificador;
    private InputText txtPlanId;
    private Calendar txtAnoFin;
    private Calendar txtAnoInicio;
    private Calendar txtFechaCreacion;
    private Calendar txtFechaModificacion;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<GluoPlanDesarrolloDTO> data;
    private GluoPlanDesarrolloDTO selectedGluoPlanDesarrollo;
    private GluoPlanDesarrollo entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public GluoPlanDesarrolloView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedGluoPlanDesarrollo = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedGluoPlanDesarrollo = null;

//        if (txtActivo != null) {
//            txtActivo.setValue(null);
//            txtActivo.setDisabled(true);
//        }

        if (txtAreaDescripcion != null) {
        	txtAreaDescripcion.setValue(null);
        	txtAreaDescripcion.setDisabled(false);
        }

        if (txtAreaEslogan != null) {
        	txtAreaEslogan.setValue(null);
        	txtAreaEslogan.setDisabled(false);
        }

        if (txtNombreAlcalde != null) {
            txtNombreAlcalde.setValue(null);
            txtNombreAlcalde.setDisabled(true);
        }

        if (txtUsuCreador != null) {
            txtUsuCreador.setValue(null);
            txtUsuCreador.setDisabled(true);
        }

        if (txtUsuModificador != null) {
            txtUsuModificador.setValue(null);
            txtUsuModificador.setDisabled(true);
        }

        if (txtAnoFin != null) {
            txtAnoFin.setValue(null);
            txtAnoFin.setDisabled(false);
        }

        if (txtAnoInicio != null) {
            txtAnoInicio.setValue(null);
            txtAnoInicio.setDisabled(false);
        }

        if (txtFechaCreacion != null) {
            txtFechaCreacion.setValue(null);
            txtFechaCreacion.setDisabled(true);
        }

        if (txtFechaModificacion != null) {
            txtFechaModificacion.setValue(null);
            txtFechaModificacion.setDisabled(true);
        }

        if (txtPlanId != null) {
            txtPlanId.setValue(null);
            txtPlanId.setDisabled(false);
        }

        if (btnSave != null) {
            btnSave.setDisabled(false);
        }

        if (btnDelete != null) {
            btnDelete.setDisabled(true);
        }

        return "";
    }

    public void listener_txtAnoFin() {
        Date inputDate = (Date) txtAnoFin.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtAnoInicio() {
        Date inputDate = (Date) txtAnoInicio.getValue();
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
            Integer planId = FacesUtils.checkInteger(txtPlanId);
            entity = (planId != null)
                ? businessDelegatorView.getGluoPlanDesarrollo(planId) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
//            txtActivo.setDisabled(false);
        	txtAreaDescripcion.setDisabled(false);
        	txtAreaEslogan.setDisabled(false);
            txtNombreAlcalde.setDisabled(false);
            txtUsuCreador.setDisabled(false);
            txtUsuModificador.setDisabled(false);
            txtAnoFin.setDisabled(false);
            txtAnoInicio.setDisabled(false);
            txtFechaCreacion.setDisabled(false);
            txtFechaModificacion.setDisabled(false);
            txtPlanId.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
//            txtActivo.setValue(entity.getActivo());
//            txtActivo.setDisabled(false);
            txtAnoFin.setValue(entity.getAnoFin());
            txtAnoFin.setDisabled(false);
            txtAnoInicio.setValue(entity.getAnoInicio());
            txtAnoInicio.setDisabled(false);
            txtAreaDescripcion.setValue(entity.getDescripcion());
            txtAreaDescripcion.setDisabled(false);
            txtAreaEslogan.setValue(entity.getEslogan());
            txtAreaEslogan.setDisabled(false);
            txtFechaCreacion.setValue(entity.getFechaCreacion());
            txtFechaCreacion.setDisabled(false);
            txtFechaModificacion.setValue(entity.getFechaModificacion());
            txtFechaModificacion.setDisabled(false);
            txtNombreAlcalde.setValue(entity.getNombreAlcalde());
            txtNombreAlcalde.setDisabled(false);
            txtUsuCreador.setValue(entity.getUsuCreador());
            txtUsuCreador.setDisabled(false);
            txtUsuModificador.setValue(entity.getUsuModificador());
            txtUsuModificador.setDisabled(false);
            txtPlanId.setValue(entity.getPlanId());
            txtPlanId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedGluoPlanDesarrollo = (GluoPlanDesarrolloDTO) (evt.getComponent()
                                                                 .getAttributes()
                                                                 .get("selectedGluoPlanDesarrollo"));
//        txtActivo.setValue(selectedGluoPlanDesarrollo.getActivo());
//        txtActivo.setDisabled(false);
        txtAnoFin.setValue(selectedGluoPlanDesarrollo.getAnoFin());
        txtAnoFin.setDisabled(false);
        txtAnoInicio.setValue(selectedGluoPlanDesarrollo.getAnoInicio());
        txtAnoInicio.setDisabled(false);
        txtAreaDescripcion.setValue(selectedGluoPlanDesarrollo.getDescripcion());
        txtAreaDescripcion.setDisabled(false);
        txtAreaEslogan.setValue(selectedGluoPlanDesarrollo.getEslogan());
        txtAreaEslogan.setDisabled(false);
        txtFechaCreacion.setValue(selectedGluoPlanDesarrollo.getFechaCreacion());
        txtFechaCreacion.setDisabled(true);
        txtFechaModificacion.setValue(selectedGluoPlanDesarrollo.getFechaModificacion());
        txtFechaModificacion.setDisabled(true);
        txtNombreAlcalde.setValue(selectedGluoPlanDesarrollo.getNombreAlcalde());
        txtNombreAlcalde.setDisabled(false);
        txtUsuCreador.setValue(selectedGluoPlanDesarrollo.getUsuCreador());
        txtUsuCreador.setDisabled(true);
        txtUsuModificador.setValue(selectedGluoPlanDesarrollo.getUsuModificador());
        txtUsuModificador.setDisabled(true);
        txtPlanId.setValue(selectedGluoPlanDesarrollo.getPlanId());
        txtPlanId.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedGluoPlanDesarrollo == null) && (entity == null)) {
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
            entity = new GluoPlanDesarrollo();

//            Integer planId = FacesUtils.checkInteger(txtPlanId);

            entity.setActivo(somActivo);
            entity.setAnoFin(FacesUtils.checkDate(txtAnoFin));
            entity.setAnoInicio(FacesUtils.checkDate(txtAnoInicio));
            entity.setDescripcion(FacesUtils.checkString(txtAreaDescripcion));
            entity.setEslogan(FacesUtils.checkString(txtAreaEslogan));
            entity.setFechaCreacion(new Date());
//            entity.setFechaModificacion(FacesUtils.checkDate(
//                    txtFechaModificacion));
            entity.setNombreAlcalde(FacesUtils.checkString(txtNombreAlcalde));
//            entity.setPlanId(planId);
            SegUsuario segUsuario = (SegUsuario) FacesUtils.getfromSession("usuarioEnSession");
            Integer usuaCreador = Integer.valueOf(segUsuario.getUsuId());
            entity.setUsuCreador(usuaCreador);
//            entity.setUsuModificador(FacesUtils.checkInteger(txtUsuModificador));
            businessDelegatorView.saveGluoPlanDesarrollo(entity);
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
                Integer planId = new Integer(selectedGluoPlanDesarrollo.getPlanId());
                entity = businessDelegatorView.getGluoPlanDesarrollo(planId);
            }

            entity.setActivo(somActivo.toString());
            entity.setAnoFin(FacesUtils.checkDate(txtAnoFin));
            entity.setAnoInicio(FacesUtils.checkDate(txtAnoInicio));
            entity.setDescripcion(FacesUtils.checkString(txtAreaDescripcion));
            entity.setEslogan(FacesUtils.checkString(txtAreaEslogan));
//            entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
            entity.setFechaModificacion(
                    new Date());
            entity.setNombreAlcalde(FacesUtils.checkString(txtNombreAlcalde));
//            entity.setUsuCreador(FacesUtils.checkInteger(txtUsuCreador));
            SegUsuario segUsuario = (SegUsuario) FacesUtils.getfromSession("usuarioEnSession");
            Integer usuaModificador = Integer.valueOf(segUsuario.getUsuId());
            
            entity.setUsuModificador(usuaModificador);
            businessDelegatorView.updateGluoPlanDesarrollo(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedGluoPlanDesarrollo = (GluoPlanDesarrolloDTO) (evt.getComponent()
                                                                     .getAttributes()
                                                                     .get("selectedGluoPlanDesarrollo"));

            Integer planId = new Integer(selectedGluoPlanDesarrollo.getPlanId());
            entity = businessDelegatorView.getGluoPlanDesarrollo(planId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer planId = FacesUtils.checkInteger(txtPlanId);
            entity = businessDelegatorView.getGluoPlanDesarrollo(planId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteGluoPlanDesarrollo(entity);
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

    public String action_modifyWitDTO(String activo, Date anoFin,
        Date anoInicio, String descripcion, String eslogan, Date fechaCreacion,
        Date fechaModificacion, String nombreAlcalde, Integer planId,
        Integer usuCreador, Integer usuModificador) throws Exception {
        try {
            entity.setActivo(FacesUtils.checkString(activo));
            entity.setAnoFin(FacesUtils.checkDate(anoFin));
            entity.setAnoInicio(FacesUtils.checkDate(anoInicio));
            entity.setDescripcion(FacesUtils.checkString(descripcion));
            entity.setEslogan(FacesUtils.checkString(eslogan));
            entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
            entity.setNombreAlcalde(FacesUtils.checkString(nombreAlcalde));
            entity.setUsuCreador(FacesUtils.checkInteger(usuCreador));
            entity.setUsuModificador(FacesUtils.checkInteger(usuModificador));
            businessDelegatorView.updateGluoPlanDesarrollo(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("GluoPlanDesarrolloView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

//    public InputText getTxtActivo() {
//        return txtActivo;
//    }
//
//    public void setTxtActivo(InputText txtActivo) {
//        this.txtActivo = txtActivo;
//    }
//
//    public InputText getTxtDescripcion() {
//        return txtDescripcion;
//    }
//
//    public void setTxtDescripcion(InputText txtDescripcion) {
//        this.txtDescripcion = txtDescripcion;
//    }
//
//    public InputText getTxtEslogan() {
//        return txtEslogan;
//    }
//
//    public void setTxtEslogan(InputText txtEslogan) {
//        this.txtEslogan = txtEslogan;
//    }

    public InputText getTxtNombreAlcalde() {
        return txtNombreAlcalde;
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

	public InputTextarea getTxtAreaEslogan() {
		return txtAreaEslogan;
	}

	public void setTxtAreaEslogan(InputTextarea txtAreaEslogan) {
		this.txtAreaEslogan = txtAreaEslogan;
	}

	public void setTxtNombreAlcalde(InputText txtNombreAlcalde) {
        this.txtNombreAlcalde = txtNombreAlcalde;
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

    public Calendar getTxtAnoFin() {
        return txtAnoFin;
    }

    public void setTxtAnoFin(Calendar txtAnoFin) {
        this.txtAnoFin = txtAnoFin;
    }

    public Calendar getTxtAnoInicio() {
        return txtAnoInicio;
    }

    public void setTxtAnoInicio(Calendar txtAnoInicio) {
        this.txtAnoInicio = txtAnoInicio;
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

    public InputText getTxtPlanId() {
        return txtPlanId;
    }

    public void setTxtPlanId(InputText txtPlanId) {
        this.txtPlanId = txtPlanId;
    }

    public List<GluoPlanDesarrolloDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataGluoPlanDesarrollo();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<GluoPlanDesarrolloDTO> gluoPlanDesarrolloDTO) {
        this.data = gluoPlanDesarrolloDTO;
    }

    public GluoPlanDesarrolloDTO getSelectedGluoPlanDesarrollo() {
        return selectedGluoPlanDesarrollo;
    }

    public void setSelectedGluoPlanDesarrollo(
        GluoPlanDesarrolloDTO gluoPlanDesarrollo) {
        this.selectedGluoPlanDesarrollo = gluoPlanDesarrollo;
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
