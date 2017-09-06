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
    
    
    
    private List<SelectItem> losProyectosItems;
    private SelectOneMenu somProyecto;
    
    private List<SelectItem> AnoFiscalItems;
    private SelectOneMenu somAnoFiscal;

    private String somActivo;
    private InputText txtUsuCreador;
    private InputText txtUsuModificador;
    private InputText txtValorTotalPresupuesto;
    private InputText txtAnofId_GluoAnoFiscal;
    private InputText txtProyId_GluoProyecto;
    private InputText txtDproId;
    private Calendar txtFechaCreacion;
    private Calendar txtFechaModificacion;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
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

//        if (somActivo != null) {
//        	somActivo.setValue(null);
//        	somActivo.setDisabled(true);
//        }

        if (txtUsuCreador != null) {
            txtUsuCreador.setValue(null);
            txtUsuCreador.setDisabled(true);
        }

        if (txtUsuModificador != null) {
            txtUsuModificador.setValue(null);
            txtUsuModificador.setDisabled(true);
        }

        if (txtValorTotalPresupuesto != null) {
            txtValorTotalPresupuesto.setValue(null);
            txtValorTotalPresupuesto.setDisabled(true);
        }

        if (txtAnofId_GluoAnoFiscal != null) {
            txtAnofId_GluoAnoFiscal.setValue(null);
            txtAnofId_GluoAnoFiscal.setDisabled(true);
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

        if (txtDproId != null) {
            txtDproId.setValue(null);
            txtDproId.setDisabled(false);
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
            Integer dproId = FacesUtils.checkInteger(txtDproId);
            entity = (dproId != null)
                ? businessDelegatorView.getGluoDetalleProyecto(dproId) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
          //  txtActivo.setDisabled(false);
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
           // txtActivo.setValue(entity.getActivo());
            //txtActivo.setDisabled(false);
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

    public String action_edit(ActionEvent evt) {
        selectedGluoDetalleProyecto = (GluoDetalleProyectoDTO) (evt.getComponent()
                                                                   .getAttributes()
                                                                   .get("selectedGluoDetalleProyecto"));
        //txtActivo.setValue(selectedGluoDetalleProyecto.getActivo());
        //txtActivo.setDisabled(false);
        txtFechaCreacion.setValue(selectedGluoDetalleProyecto.getFechaCreacion());
        txtFechaCreacion.setDisabled(false);
        txtFechaModificacion.setValue(selectedGluoDetalleProyecto.getFechaModificacion());
        txtFechaModificacion.setDisabled(false);
        txtUsuCreador.setValue(selectedGluoDetalleProyecto.getUsuCreador());
        txtUsuCreador.setDisabled(false);
        txtUsuModificador.setValue(selectedGluoDetalleProyecto.getUsuModificador());
        txtUsuModificador.setDisabled(false);
        txtValorTotalPresupuesto.setValue(selectedGluoDetalleProyecto.getValorTotalPresupuesto());
        txtValorTotalPresupuesto.setDisabled(false);
        //txtAnofId_GluoAnoFiscal.setValue(selectedGluoDetalleProyecto.getAnofId_GluoAnoFiscal());
        //txtAnofId_GluoAnoFiscal.setDisabled(false);
       // txtProyId_GluoProyecto.setValue(selectedGluoDetalleProyecto.getProyId_GluoProyecto());
       // txtProyId_GluoProyecto.setDisabled(false);
        txtDproId.setValue(selectedGluoDetalleProyecto.getDproId());
        txtDproId.setDisabled(true);
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

           // Integer dproId = FacesUtils.checkInteger(txtDproId);

            entity.setActivo(somActivo);
            //entity.setDproId(dproId);
            entity.setFechaCreacion(new Date());
            SegUsuario segUsuario = (SegUsuario) FacesUtils.getfromSession("usuarioEnSession");
			Integer usuaCreador = Integer.valueOf(segUsuario.getUsuId());
			entity.setUsuCreador(usuaCreador);
            //entity.setFechaModificacion(FacesUtils.checkDate( txtFechaModificacion));
           // entity.setUsuCreador(FacesUtils.checkInteger(txtUsuCreador));
            //entity.setUsuModificador(FacesUtils.checkInteger(txtUsuModificador));
			
			Integer idProyecto = Integer.valueOf(somProyecto.getValue().toString());
			GluoProyecto gluoProyecto = businessDelegatorView.getGluoProyecto(idProyecto);
			entity.setGluoProyecto(gluoProyecto);
			
			Integer idAnoFiscal = Integer.valueOf(somAnoFiscal.getValue().toString());
			GluoAnoFiscal gluoAnoFiscal = businessDelegatorView.getGluoAnoFiscal(idAnoFiscal);
			entity.setGluoAnoFiscal(gluoAnoFiscal);
			
            entity.setValorTotalPresupuesto(FacesUtils.checkDouble(
                    txtValorTotalPresupuesto));
//            entity.setGluoAnoFiscal((FacesUtils.checkInteger(
//                    txtAnofId_GluoAnoFiscal) != null)
//                ? businessDelegatorView.getGluoAnoFiscal(
//                    FacesUtils.checkInteger(txtAnofId_GluoAnoFiscal)) : null);
//            entity.setGluoProyecto((FacesUtils.checkInteger(
//                    txtProyId_GluoProyecto) != null)
//                ? businessDelegatorView.getGluoProyecto(FacesUtils.checkInteger(
//                        txtProyId_GluoProyecto)) : null);
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

            entity.setActivo(FacesUtils.checkString(somActivo));
           // entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(
                    txtFechaModificacion));
          //  entity.setUsuCreador(FacesUtils.checkInteger(txtUsuCreador));
            SegUsuario segUsuario = (SegUsuario) FacesUtils.getfromSession("usuarioEnSession");
			Integer usuaCreador = Integer.valueOf(segUsuario.getUsuId());
			entity.setUsuCreador(usuaCreador);
			
			Integer idProyecto = Integer.valueOf(somProyecto.getValue().toString());
			GluoProyecto gluoProyecto = businessDelegatorView.getGluoProyecto(idProyecto);
			entity.setGluoProyecto(gluoProyecto);
			
			Integer idAnoFiscal = Integer.valueOf(somAnoFiscal.getValue().toString());
			GluoAnoFiscal gluoAnoFiscal = businessDelegatorView.getGluoAnoFiscal(idAnoFiscal);
			entity.setGluoAnoFiscal(gluoAnoFiscal);
			
           // entity.setUsuModificador(FacesUtils.checkInteger(txtUsuModificador));
            entity.setValorTotalPresupuesto(FacesUtils.checkDouble(
                    txtValorTotalPresupuesto));
//            entity.setGluoAnoFiscal((FacesUtils.checkInteger(
//                    txtAnofId_GluoAnoFiscal) != null)
//                ? businessDelegatorView.getGluoAnoFiscal(
//                    FacesUtils.checkInteger(txtAnofId_GluoAnoFiscal)) : null);
//            entity.setGluoProyecto((FacesUtils.checkInteger(
//                    txtProyId_GluoProyecto) != null)
//                ? businessDelegatorView.getGluoProyecto(FacesUtils.checkInteger(
//                        txtProyId_GluoProyecto)) : null);
            businessDelegatorView.updateGluoDetalleProyecto(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

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
    
    public List<SelectItem> getAnoFiscalItems() throws Exception{
    	try {
			if (AnoFiscalItems == null) {
				AnoFiscalItems = new ArrayList<SelectItem>();
				List<GluoAnoFiscal> losGluoAnoFiscal= businessDelegatorView.getGluoAnoFiscal();
				for (GluoAnoFiscal gluoAnoFiscal: losGluoAnoFiscal) {
					AnoFiscalItems.add(new SelectItem(gluoAnoFiscal.getAnofId(),gluoAnoFiscal.getDescripcion()));
				}
			}
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
		return AnoFiscalItems;
	}

	public void setAnoFiscalItems(List<SelectItem> losProyectosItems) {
		this.losProyectosItems = losProyectosItems;
	}

	public SelectOneMenu getSomAnoFiscal() {
		return somAnoFiscal;
	}

	public void setSomAnoFiscal(SelectOneMenu somAnoFiscal) {
		this.somAnoFiscal = somAnoFiscal;
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



    public String getSomActivo() {
        return somActivo;
    }

    public void setSomActivo(String somActivo) {
        this.somActivo = somActivo;
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

    public InputText getTxtDproId() {
        return txtDproId;
    }

    public void setTxtDproId(InputText txtDproId) {
        this.txtDproId = txtDproId;
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
