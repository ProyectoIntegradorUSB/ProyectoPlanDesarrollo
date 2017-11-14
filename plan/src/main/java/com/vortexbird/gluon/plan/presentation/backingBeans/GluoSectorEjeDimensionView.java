package com.vortexbird.gluon.plan.presentation.backingBeans;

import com.vortexbird.gluon.plan.exceptions.*;
import com.vortexbird.gluon.plan.modelo.*;
import com.vortexbird.gluon.plan.modelo.dto.GluoSectorEjeDimensionDTO;
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
 * @author Zathura Code Generator http://zathuracode.org/
 * www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class GluoSectorEjeDimensionView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(GluoSectorEjeDimensionView.class);
    
    private String somActivo;
    private List<SelectItem> losPlanDesarrolloItems;
    private SelectOneMenu somPlanDesarrollo;
    
    private InputTextarea txtAreaDescripcion;
    private InputText txtUsuCreador;
    private InputText txtUsuModificador;
    private InputText txtPlanId_GluoPlanDesarrollo;
    private InputText txtSediId;
    private Calendar txtFechaCreacion;
    private Calendar txtFechaModificacion;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<GluoSectorEjeDimensionDTO> data;
    private GluoSectorEjeDimensionDTO selectedGluoSectorEjeDimension;
    private GluoSectorEjeDimension entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public GluoSectorEjeDimensionView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedGluoSectorEjeDimension = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedGluoSectorEjeDimension = null;

//        if (txtActivo != null) {
//            txtActivo.setValue(null);
//            txtActivo.setDisabled(true);
//        }

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

        if (txtPlanId_GluoPlanDesarrollo != null) {
            txtPlanId_GluoPlanDesarrollo.setValue(null);
            txtPlanId_GluoPlanDesarrollo.setDisabled(true);
        }

        if (txtFechaCreacion != null) {
            txtFechaCreacion.setValue(null);
            txtFechaCreacion.setDisabled(true);
        }

        if (txtFechaModificacion != null) {
            txtFechaModificacion.setValue(null);
            txtFechaModificacion.setDisabled(true);
        }

        if (txtSediId != null) {
            txtSediId.setValue(null);
            txtSediId.setDisabled(false);
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
            Integer sediId = FacesUtils.checkInteger(txtSediId);
            entity = (sediId != null)
                ? businessDelegatorView.getGluoSectorEjeDimension(sediId) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
//            txtActivo.setDisabled(false);
        	txtAreaDescripcion.setDisabled(false);
            txtUsuCreador.setDisabled(false);
            txtUsuModificador.setDisabled(false);
            txtPlanId_GluoPlanDesarrollo.setDisabled(false);
            txtFechaCreacion.setDisabled(false);
            txtFechaModificacion.setDisabled(false);
            txtSediId.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
//            txtActivo.setValue(entity.getActivo());
//            txtActivo.setDisabled(false);
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
            txtPlanId_GluoPlanDesarrollo.setValue(entity.getGluoPlanDesarrollo()
                                                        .getPlanId());
            txtPlanId_GluoPlanDesarrollo.setDisabled(false);
            txtSediId.setValue(entity.getSediId());
            txtSediId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedGluoSectorEjeDimension = (GluoSectorEjeDimensionDTO) (evt.getComponent()
                                                                         .getAttributes()
                                                                         .get("selectedGluoSectorEjeDimension"));
//        txtActivo.setValue(selectedGluoSectorEjeDimension.getActivo());
//        txtActivo.setDisabled(false);
        txtAreaDescripcion.setValue(selectedGluoSectorEjeDimension.getDescripcion());
        txtAreaDescripcion.setDisabled(false);
        txtFechaCreacion.setValue(selectedGluoSectorEjeDimension.getFechaCreacion());
        txtFechaCreacion.setDisabled(true);
        txtFechaModificacion.setValue(selectedGluoSectorEjeDimension.getFechaModificacion());
        txtFechaModificacion.setDisabled(true);
        txtUsuCreador.setValue(selectedGluoSectorEjeDimension.getUsuCreador());
        txtUsuCreador.setDisabled(true);
        txtUsuModificador.setValue(selectedGluoSectorEjeDimension.getUsuModificador());
        txtUsuModificador.setDisabled(true);
//        txtPlanId_GluoPlanDesarrollo.setValue(selectedGluoSectorEjeDimension.getPlanId_GluoPlanDesarrollo());
//        txtPlanId_GluoPlanDesarrollo.setDisabled(false);
        txtSediId.setValue(selectedGluoSectorEjeDimension.getSediId());
        txtSediId.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedGluoSectorEjeDimension == null) && (entity == null)) {
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
            entity = new GluoSectorEjeDimension();

//            Integer sediId = FacesUtils.checkInteger(txtSediId);

            entity.setActivo("A");
            entity.setDescripcion(FacesUtils.checkString(txtAreaDescripcion));
            entity.setFechaCreacion(new Date());
//            entity.setFechaModificacion(FacesUtils.checkDate(
//                    txtFechaModificacion));
//            entity.setSediId(sediId);
            
            SegUsuario segUsuario = (SegUsuario) FacesUtils.getfromSession("usuarioEnSession");
			Integer usuaCreador = Integer.valueOf(segUsuario.getUsuId());
			
            entity.setUsuCreador(usuaCreador);
//            entity.setUsuModificador(FacesUtils.checkInteger(txtUsuModificador));
            
            Integer idPlanDesarrollo = Integer.valueOf(somPlanDesarrollo.getValue().toString());
			GluoPlanDesarrollo gluoPlanDesarrollo = businessDelegatorView.getGluoPlanDesarrollo(idPlanDesarrollo);
			entity.setGluoPlanDesarrollo(gluoPlanDesarrollo);
			
//            entity.setGluoPlanDesarrollo((FacesUtils.checkInteger(
//                    txtPlanId_GluoPlanDesarrollo) != null)
//                ? businessDelegatorView.getGluoPlanDesarrollo(
//                    FacesUtils.checkInteger(txtPlanId_GluoPlanDesarrollo)) : null);
            
            businessDelegatorView.saveGluoSectorEjeDimension(entity);
            FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Se ha creado un nuevo sector dimensional para el proyecto", ""));
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
                Integer sediId = new Integer(selectedGluoSectorEjeDimension.getSediId());
                entity = businessDelegatorView.getGluoSectorEjeDimension(sediId);
            }

            entity.setActivo(somActivo);
            entity.setDescripcion(FacesUtils.checkString(txtAreaDescripcion));
//            entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
            entity.setFechaModificacion(new Date());
            
//            entity.setUsuCreador(FacesUtils.checkInteger(txtUsuCreador));
            SegUsuario segUsuario = (SegUsuario) FacesUtils.getfromSession("usuarioEnSession");
            Integer usuaModificador = Integer.valueOf(segUsuario.getUsuId());
            entity.setUsuModificador(usuaModificador);
            
//            entity.setGluoPlanDesarrollo((FacesUtils.checkInteger(
//                    txtPlanId_GluoPlanDesarrollo) != null)
//                ? businessDelegatorView.getGluoPlanDesarrollo(
//                    FacesUtils.checkInteger(txtPlanId_GluoPlanDesarrollo)) : null);
            
            Integer idPlanDesarrollo = Integer.valueOf(somPlanDesarrollo.getValue().toString());
            GluoPlanDesarrollo gluoplan = businessDelegatorView.getGluoPlanDesarrollo(idPlanDesarrollo);
            entity.setGluoPlanDesarrollo(gluoplan);
            
            businessDelegatorView.updateGluoSectorEjeDimension(entity);
            FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Se ha modificado el  sector dimensional del plan", ""));
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedGluoSectorEjeDimension = (GluoSectorEjeDimensionDTO) (evt.getComponent()
                                                                             .getAttributes()
                                                                             .get("selectedGluoSectorEjeDimension"));

            Integer sediId = new Integer(selectedGluoSectorEjeDimension.getSediId());
            entity = businessDelegatorView.getGluoSectorEjeDimension(sediId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer sediId = FacesUtils.checkInteger(txtSediId);
            entity = businessDelegatorView.getGluoSectorEjeDimension(sediId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteGluoSectorEjeDimension(entity);
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

    public String action_modifyWitDTO(String activo, String descripcion,
        Date fechaCreacion, Date fechaModificacion, Integer sediId,
        Integer usuCreador, Integer usuModificador,
        Integer planId_GluoPlanDesarrollo) throws Exception {
        try {
            entity.setActivo(FacesUtils.checkString(activo));
            entity.setDescripcion(FacesUtils.checkString(descripcion));
            entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
            entity.setUsuCreador(FacesUtils.checkInteger(usuCreador));
            entity.setUsuModificador(FacesUtils.checkInteger(usuModificador));
            businessDelegatorView.updateGluoSectorEjeDimension(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("GluoSectorEjeDimensionView").requestRender();
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

//    public InputText getTxtDescripcion() {
//        return txtDescripcion;
//    }
//
//    public void setTxtDescripcion(InputText txtDescripcion) {
//        this.txtDescripcion = txtDescripcion;
//    }

    public InputText getTxtUsuCreador() {
        return txtUsuCreador;
    }

    public String getSomActivo() {
		return somActivo;
	}

	public void setSomActivo(String somActivo) {
		this.somActivo = somActivo;
	}

	public List<SelectItem> getLosPlanDesarrolloItems() {
		try {
			if(losPlanDesarrolloItems == null) {
				losPlanDesarrolloItems = new ArrayList<SelectItem>();
				List<GluoPlanDesarrollo> losGluoPlanDesarrollo = businessDelegatorView.findPlanDesarrolloActivo();
				for (GluoPlanDesarrollo gluoPlanDesarrollo : losGluoPlanDesarrollo) {
					losPlanDesarrolloItems.add(new SelectItem(gluoPlanDesarrollo.getPlanId(),gluoPlanDesarrollo.getDescripcion()));
				}
			}
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
		return losPlanDesarrolloItems;
	}

	public void setLosPlanDesarrolloItems(List<SelectItem> losPlanDesarrolloItems) {
		this.losPlanDesarrolloItems = losPlanDesarrolloItems;
	}

	public SelectOneMenu getSomPlanDesarrollo() {
		return somPlanDesarrollo;
	}

	public void setSomPlanDesarrollo(SelectOneMenu somPlanDesarrollo) {
		this.somPlanDesarrollo = somPlanDesarrollo;
	}

	public InputTextarea getTxtAreaDescripcion() {
		return txtAreaDescripcion;
	}

	public void setTxtAreaDescripcion(InputTextarea txtAreaDescripcion) {
		this.txtAreaDescripcion = txtAreaDescripcion;
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

    public InputText getTxtPlanId_GluoPlanDesarrollo() {
        return txtPlanId_GluoPlanDesarrollo;
    }

    public void setTxtPlanId_GluoPlanDesarrollo(
        InputText txtPlanId_GluoPlanDesarrollo) {
        this.txtPlanId_GluoPlanDesarrollo = txtPlanId_GluoPlanDesarrollo;
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

    public InputText getTxtSediId() {
        return txtSediId;
    }

    public void setTxtSediId(InputText txtSediId) {
        this.txtSediId = txtSediId;
    }

    public List<GluoSectorEjeDimensionDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataGluoSectorEjeDimension();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(
        List<GluoSectorEjeDimensionDTO> gluoSectorEjeDimensionDTO) {
        this.data = gluoSectorEjeDimensionDTO;
    }

    public GluoSectorEjeDimensionDTO getSelectedGluoSectorEjeDimension() {
        return selectedGluoSectorEjeDimension;
    }

    public void setSelectedGluoSectorEjeDimension(
        GluoSectorEjeDimensionDTO gluoSectorEjeDimension) {
        this.selectedGluoSectorEjeDimension = gluoSectorEjeDimension;
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
