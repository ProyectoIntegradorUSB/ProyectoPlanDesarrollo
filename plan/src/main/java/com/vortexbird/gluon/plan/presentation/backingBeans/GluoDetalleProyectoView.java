package com.vortexbird.gluon.plan.presentation.backingBeans;

import com.vortexbird.gluon.plan.exceptions.*;
import com.vortexbird.gluon.plan.modelo.*;
import com.vortexbird.gluon.plan.modelo.dto.GluoDetalleProyectoDTO;
import com.vortexbird.gluon.plan.presentation.businessDelegate.*;
import com.vortexbird.gluon.plan.utilities.*;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
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
 * @author Zathura Code Generator http://zathuracode.org/
 * www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class GluoDetalleProyectoView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(GluoDetalleProyectoView.class);
    private InputText txtActivo;
    
    private List<SelectItem> losProyectosItems;
	private SelectOneMenu somProyecto;
    
    private InputText txtValorTotalPresupuesto;
    private InputText txtAnofId_GluoAnoFiscal;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnClear;
    private List<GluoDetalleProyectoDTO> data;
    private GluoDetalleProyectoDTO selectedGluoDetalleProyecto;
    private GluoDetalleProyecto entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public GluoDetalleProyectoView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedGluoDetalleProyecto = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedGluoDetalleProyecto = null;

        if (txtActivo != null) {
            txtActivo.setValue(null);
            txtActivo.setDisabled(true);
        }


        if (txtValorTotalPresupuesto != null) {
            txtValorTotalPresupuesto.setValue(null);
            txtValorTotalPresupuesto.setDisabled(true);
        }

        if (txtAnofId_GluoAnoFiscal != null) {
            txtAnofId_GluoAnoFiscal.setValue(null);
            txtAnofId_GluoAnoFiscal.setDisabled(true);
        }


        if (btnSave != null) {
            btnSave.setDisabled(true);
        }


        return "";
    }
/*
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
            Integer dproId = FacesUtils.checkInteger(txtDproId);
            entity = (dproId != null)
                ? businessDelegatorView.getGluoDetalleProyecto(dproId) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtActivo.setDisabled(false);
            txtUsuCreador.setDisabled(false);
            txtUsuModificador.setDisabled(false);
            txtValorTotalPresupuesto.setDisabled(false);
            txtAnofId_GluoAnoFiscal.setDisabled(false);
            txtProyId_GluoProyecto.setDisabled(false);
            txtFechaCreacion.setDisabled(false);
            txtFechaModificacion.setDisabled(false);
            txtDproId.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtActivo.setValue(entity.getActivo());
            txtActivo.setDisabled(false);
            txtFechaCreacion.setValue(entity.getFechaCreacion());
            txtFechaCreacion.setDisabled(false);
            txtFechaModificacion.setValue(entity.getFechaModificacion());
            txtFechaModificacion.setDisabled(false);
            txtUsuCreador.setValue(entity.getUsuCreador());
            txtUsuCreador.setDisabled(false);
            txtUsuModificador.setValue(entity.getUsuModificador());
            txtUsuModificador.setDisabled(false);
            txtValorTotalPresupuesto.setValue(entity.getValorTotalPresupuesto());
            txtValorTotalPresupuesto.setDisabled(false);
            txtAnofId_GluoAnoFiscal.setValue(entity.getGluoAnoFiscal()
                                                   .getAnofId());
            txtAnofId_GluoAnoFiscal.setDisabled(false);
            txtProyId_GluoProyecto.setValue(entity.getGluoProyecto().getProyId());
            txtProyId_GluoProyecto.setDisabled(false);
            txtDproId.setValue(entity.getDproId());
            txtDproId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }
*/
    public String action_edit(ActionEvent evt) {
        selectedGluoDetalleProyecto = (GluoDetalleProyectoDTO) (evt.getComponent()
                                                                   .getAttributes()
                                                                   .get("selectedGluoDetalleProyecto"));
        txtActivo.setValue(selectedGluoDetalleProyecto.getActivo());
        txtActivo.setDisabled(false);
        txtValorTotalPresupuesto.setValue(selectedGluoDetalleProyecto.getValorTotalPresupuesto());
        txtValorTotalPresupuesto.setDisabled(false);
        txtAnofId_GluoAnoFiscal.setValue(selectedGluoDetalleProyecto.getAnofId_GluoAnoFiscal());
        txtAnofId_GluoAnoFiscal.setDisabled(false);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedGluoDetalleProyecto == null) && (entity == null)) {
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
            entity = new GluoDetalleProyecto();
            
            entity.setActivo(FacesUtils.checkString(txtActivo));
            entity.setFechaCreacion(new Date());
            entity.setValorTotalPresupuesto(FacesUtils.checkDouble(
                    txtValorTotalPresupuesto));
            entity.setGluoAnoFiscal((FacesUtils.checkInteger(
                    txtAnofId_GluoAnoFiscal) != null)
                ? businessDelegatorView.getGluoAnoFiscal(
                    FacesUtils.checkInteger(txtAnofId_GluoAnoFiscal)) : null);
            
            SegUsuario segUsuario = (SegUsuario) FacesUtils.getfromSession("usuarioEnSession");
            Integer usuaCreador = Integer.valueOf(segUsuario.getUsuId());
            entity.setUsuCreador(usuaCreador);
            
            Integer idProyecto = Integer.valueOf(somProyecto.getValue().toString());
            GluoProyecto gluoProyecto = businessDelegatorView.getGluoProyecto(idProyecto);       
            entity.setGluoProyecto(gluoProyecto);
            businessDelegatorView.saveGluoDetalleProyecto(entity);
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
                Integer dproId = new Integer(selectedGluoDetalleProyecto.getDproId());
                entity = businessDelegatorView.getGluoDetalleProyecto(dproId);
            }

            entity.setActivo(FacesUtils.checkString(txtActivo));
            SegUsuario segUsuario = (SegUsuario) FacesUtils.getfromSession("usuarioEnSession");
            Integer usuaModificador = Integer.valueOf(segUsuario.getUsuId());
            entity.setUsuModificador(usuaModificador);
            
            
            entity.setValorTotalPresupuesto(FacesUtils.checkDouble(
                    txtValorTotalPresupuesto));
            entity.setGluoAnoFiscal((FacesUtils.checkInteger(
                    txtAnofId_GluoAnoFiscal) != null)
                ? businessDelegatorView.getGluoAnoFiscal(
                    FacesUtils.checkInteger(txtAnofId_GluoAnoFiscal)) : null);
            
            businessDelegatorView.updateGluoDetalleProyecto(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }
/*
    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedGluoDetalleProyecto = (GluoDetalleProyectoDTO) (evt.getComponent()
                                                                       .getAttributes()
                                                                       .get("selectedGluoDetalleProyecto"));

            Integer dproId = new Integer(selectedGluoDetalleProyecto.getDproId());
            entity = businessDelegatorView.getGluoDetalleProyecto(dproId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    
    public String action_delete_master() {
        try {
            Integer dproId = FacesUtils.checkInteger(txtDproId);
            entity = businessDelegatorView.getGluoDetalleProyecto(dproId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteGluoDetalleProyecto(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
            data = null;
        } catch (Exception e) {
            throw e;
        }
    }
*/
    public String action_closeDialog() {
        setShowDialog(false);
        action_clear();

        return "";
    }

    public String action_modifyWitDTO(String activo, Integer dproId,
        Date fechaCreacion, Date fechaModificacion, Integer usuCreador,
        Integer usuModificador, Double valorTotalPresupuesto,
        Integer anofId_GluoAnoFiscal, Integer proyId_GluoProyecto)
        throws Exception {
        try {
            entity.setActivo(FacesUtils.checkString(activo));
            entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
            entity.setUsuCreador(FacesUtils.checkInteger(usuCreador));
            entity.setUsuModificador(FacesUtils.checkInteger(usuModificador));
            entity.setValorTotalPresupuesto(FacesUtils.checkDouble(
                    valorTotalPresupuesto));
            SegUsuario segUsuario = (SegUsuario) FacesUtils.getfromSession("usuarioEnSession");
            Integer usuaModificador = Integer.valueOf(segUsuario.getUsuId());
            entity.setUsuModificador(usuaModificador);
            
            businessDelegatorView.updateGluoDetalleProyecto(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("GluoDetalleProyectoView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }
    
    

    public List<SelectItem> getLosProyectosItems() throws Exception{
    	try {
			if (losProyectosItems == null) {
				losProyectosItems = new ArrayList<SelectItem>();
				List<GluoProyecto> losGluoProyecto= businessDelegatorView.getGluoProyecto();
				for (GluoProyecto gluoProyecto: losGluoProyecto) {
					losProyectosItems.add(new SelectItem(gluoProyecto.getProyId(), gluoProyecto.getDescripcion()));
				}
			}
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
		return losProyectosItems;
	}

	public void setLosProyectosItems(List<SelectItem> losProyectosItems) {
		this.losProyectosItems = losProyectosItems;
	}

	public SelectOneMenu getSomProyecto() {
		return somProyecto;
	}

	public void setSomProyecto(SelectOneMenu somProyecto) {
		this.somProyecto = somProyecto;
	}

	public InputText getTxtActivo() {
        return txtActivo;
    }

    public void setTxtActivo(InputText txtActivo) {
        this.txtActivo = txtActivo;
    }

    public InputText getTxtValorTotalPresupuesto() {
        return txtValorTotalPresupuesto;
    }

    public void setTxtValorTotalPresupuesto(InputText txtValorTotalPresupuesto) {
        this.txtValorTotalPresupuesto = txtValorTotalPresupuesto;
    }

    public InputText getTxtAnofId_GluoAnoFiscal() {
        return txtAnofId_GluoAnoFiscal;
    }

    public void setTxtAnofId_GluoAnoFiscal(InputText txtAnofId_GluoAnoFiscal) {
        this.txtAnofId_GluoAnoFiscal = txtAnofId_GluoAnoFiscal;
    }


    public List<GluoDetalleProyectoDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataGluoDetalleProyecto();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<GluoDetalleProyectoDTO> gluoDetalleProyectoDTO) {
        this.data = gluoDetalleProyectoDTO;
    }

    public GluoDetalleProyectoDTO getSelectedGluoDetalleProyecto() {
        return selectedGluoDetalleProyecto;
    }

    public void setSelectedGluoDetalleProyecto(
        GluoDetalleProyectoDTO gluoDetalleProyecto) {
        this.selectedGluoDetalleProyecto = gluoDetalleProyecto;
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
