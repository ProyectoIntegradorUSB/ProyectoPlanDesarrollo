package com.vortexbird.gluon.plan.presentation.backingBeans;

import com.vortexbird.gluon.plan.exceptions.*;
import com.vortexbird.gluon.plan.modelo.*;
import com.vortexbird.gluon.plan.modelo.dto.GluoDetalleProyectoXRubroDTO;
import com.vortexbird.gluon.plan.presentation.businessDelegate.*;
import com.vortexbird.gluon.plan.utilities.*;

import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;


/**
 * @author Zathura Code Generator http://zathuracode.org/
 * www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class GluoDetalleProyectoXRubroView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(GluoDetalleProyectoXRubroView.class);
    private InputText txtActivo;
    private InputText txtDescripcion;
    
    private SelectOneMenu somDetalleProyecto;
	private List<SelectItem> losDetalleProyectoItems;
	
	private SelectOneMenu somDetallePresupuesto;
	private List<SelectItem> losDetallePresupuestoItems;
	
    private InputText txtValor;
    
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnClear;
    private List<GluoDetalleProyectoXRubroDTO> data;
    private GluoDetalleProyectoXRubroDTO selectedGluoDetalleProyectoXRubro;
    private GluoDetalleProyectoXRubro entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public GluoDetalleProyectoXRubroView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedGluoDetalleProyectoXRubro = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedGluoDetalleProyectoXRubro = null;

        if (txtActivo != null) {
            txtActivo.setValue(null);
            txtActivo.setDisabled(true);
        }

        if (txtDescripcion != null) {
            txtDescripcion.setValue(null);
            txtDescripcion.setDisabled(true);
        }


        if (txtValor != null) {
            txtValor.setValue(null);
            txtValor.setDisabled(true);
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
            Integer dpruId = FacesUtils.checkInteger(txtDpruId);
            entity = (dpruId != null)
                ? businessDelegatorView.getGluoDetalleProyectoXRubro(dpruId)
                : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtActivo.setDisabled(false);
            txtDescripcion.setDisabled(false);
            txtUsuCreador.setDisabled(false);
            txtUsuModificador.setDisabled(false);
            txtValor.setDisabled(false);
            txtDptoId_GluoDetallePresupuesto.setDisabled(false);
            txtDproId_GluoDetalleProyecto.setDisabled(false);
            txtFechaCreacion.setDisabled(false);
            txtFechaModificacion.setDisabled(false);
            txtDpruId.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtActivo.setValue(entity.getActivo());
            txtActivo.setDisabled(false);
            txtDescripcion.setValue(entity.getDescripcion());
            txtDescripcion.setDisabled(false);
            txtFechaCreacion.setValue(entity.getFechaCreacion());
            txtFechaCreacion.setDisabled(false);
            txtFechaModificacion.setValue(entity.getFechaModificacion());
            txtFechaModificacion.setDisabled(false);
            txtUsuCreador.setValue(entity.getUsuCreador());
            txtUsuCreador.setDisabled(false);
            txtUsuModificador.setValue(entity.getUsuModificador());
            txtUsuModificador.setDisabled(false);
            txtValor.setValue(entity.getValor());
            txtValor.setDisabled(false);
            txtDptoId_GluoDetallePresupuesto.setValue(entity.getGluoDetallePresupuesto()
                                                            .getDptoId());
            txtDptoId_GluoDetallePresupuesto.setDisabled(false);
            txtDproId_GluoDetalleProyecto.setValue(entity.getGluoDetalleProyecto()
                                                         .getDproId());
            txtDproId_GluoDetalleProyecto.setDisabled(false);
            txtDpruId.setValue(entity.getDpruId());
            txtDpruId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }
    */

    public String action_edit(ActionEvent evt) {
        selectedGluoDetalleProyectoXRubro = (GluoDetalleProyectoXRubroDTO) (evt.getComponent()
                                                                               .getAttributes()
                                                                               .get("selectedGluoDetalleProyectoXRubro"));
        txtActivo.setValue(selectedGluoDetalleProyectoXRubro.getActivo());
        txtActivo.setDisabled(false);
        txtDescripcion.setValue(selectedGluoDetalleProyectoXRubro.getDescripcion());
        txtDescripcion.setDisabled(false);
        txtValor.setValue(selectedGluoDetalleProyectoXRubro.getValor());
        txtValor.setDisabled(false);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedGluoDetalleProyectoXRubro == null) &&
                    (entity == null)) {
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
            entity = new GluoDetalleProyectoXRubro();
            
            entity.setActivo(FacesUtils.checkString(txtActivo));
            entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
            entity.setValor(FacesUtils.checkDouble(txtValor));
            
            SegUsuario segUsuario = (SegUsuario) FacesUtils.getfromSession("usuarioEnSession");
            Integer usuaCreador = Integer.valueOf(segUsuario.getUsuId());
            entity.setUsuCreador(usuaCreador);
            
            Integer idDetalleProyecto = Integer.valueOf(somDetalleProyecto.getValue().toString());
            GluoDetalleProyecto gluoDetalleProyecto = businessDelegatorView.getGluoDetalleProyecto(idDetalleProyecto);
            entity.setGluoDetalleProyecto(gluoDetalleProyecto);
            
            Integer idDetallePresupuesto = Integer.valueOf(somDetallePresupuesto.getValue().toString());
            GluoDetallePresupuesto gluoDetallePresupuesto= businessDelegatorView.getGluoDetallePresupuesto(idDetallePresupuesto);
            entity.setGluoDetallePresupuesto(gluoDetallePresupuesto);
                 
            businessDelegatorView.saveGluoDetalleProyectoXRubro(entity);
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
                Integer dpruId = new Integer(selectedGluoDetalleProyectoXRubro.getDpruId());
                entity = businessDelegatorView.getGluoDetalleProyectoXRubro(dpruId);
            }

            entity.setActivo(FacesUtils.checkString(txtActivo));
            entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
            entity.setValor(FacesUtils.checkDouble(txtValor));
            SegUsuario segUsuario = (SegUsuario) FacesUtils.getfromSession("usuarioEnSession");
            Integer usuaModificador = Integer.valueOf(segUsuario.getUsuId());
            entity.setUsuModificador(usuaModificador);
            
            businessDelegatorView.updateGluoDetalleProyectoXRubro(entity);
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
            selectedGluoDetalleProyectoXRubro = (GluoDetalleProyectoXRubroDTO) (evt.getComponent()
                                                                                   .getAttributes()
                                                                                   .get("selectedGluoDetalleProyectoXRubro"));

            Integer dpruId = new Integer(selectedGluoDetalleProyectoXRubro.getDpruId());
            entity = businessDelegatorView.getGluoDetalleProyectoXRubro(dpruId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer dpruId = FacesUtils.checkInteger(txtDpruId);
            entity = businessDelegatorView.getGluoDetalleProyectoXRubro(dpruId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteGluoDetalleProyectoXRubro(entity);
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

    public String action_modifyWitDTO(String activo, String descripcion,
        Integer dpruId, Date fechaCreacion, Date fechaModificacion,
        Integer usuCreador, Integer usuModificador, Double valor,
        Integer dptoId_GluoDetallePresupuesto,
        Integer dproId_GluoDetalleProyecto) throws Exception {
        try {
            entity.setActivo(FacesUtils.checkString(activo));
            entity.setDescripcion(FacesUtils.checkString(descripcion));
            entity.setValor(FacesUtils.checkDouble(valor));
            SegUsuario segUsuario = (SegUsuario) FacesUtils.getfromSession("usuarioEnSession");
            Integer usuaModificador = Integer.valueOf(segUsuario.getUsuId());
            entity.setUsuModificador(usuaModificador);
            businessDelegatorView.updateGluoDetalleProyectoXRubro(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("GluoDetalleProyectoXRubroView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }
    
    

    
	public List<SelectItem> getLosDetallePresupuestoItems() {
		try {
			if(losDetallePresupuestoItems == null) {
				losDetallePresupuestoItems = new ArrayList<SelectItem>();
				List<GluoDetallePresupuesto> losgluoDetallePresupuesto= businessDelegatorView.getGluoDetallePresupuesto();
				
				for (GluoDetallePresupuesto gluoDetallePresupuesto : losgluoDetallePresupuesto) {
					losDetallePresupuestoItems.add(new SelectItem(gluoDetallePresupuesto.getDptoId(),gluoDetallePresupuesto.getDescripcionCuenta()));
				}
				
			}
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
		return losDetallePresupuestoItems;
	}

	public void setLosDetallePresupuestoItems(List<SelectItem> losDetallePresupuestoItems) {
		this.losDetallePresupuestoItems = losDetallePresupuestoItems;
	}

	public List<SelectItem> getLosDetalleProyectoItems() {
		try {
			if(losDetalleProyectoItems == null) {
				losDetalleProyectoItems = new ArrayList<SelectItem>();
				List<GluoDetalleProyecto> losgluoDetalleProyecto= businessDelegatorView.getGluoDetalleProyecto();
				
				for (GluoDetalleProyecto gluoDetalleProyecto: losgluoDetalleProyecto) {
					losDetalleProyectoItems.add(new SelectItem(gluoDetalleProyecto.getDproId(),gluoDetalleProyecto.getGluoProyecto().getDescripcion()));
				}
				
			}
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
		return losDetalleProyectoItems;
	}

	public void setLosDetalleProyectoItems(List<SelectItem> losDetalleProyectoItems) {
		this.losDetalleProyectoItems = losDetalleProyectoItems;
	}

	public SelectOneMenu getSomDetallePresupuesto() {
		return somDetallePresupuesto;
	}

	public void setSomDetallePresupuesto(SelectOneMenu somDetallePresupuesto) {
		this.somDetallePresupuesto = somDetallePresupuesto;
	}
	
	public SelectOneMenu getSomDetalleProyecto() {
		return somDetalleProyecto;
	}

	public void setSomDetalleProyecto(SelectOneMenu somDetalleProyecto) {
		this.somDetalleProyecto = somDetalleProyecto;
	}

	

	public InputText getTxtActivo() {
        return txtActivo;
    }

    public void setTxtActivo(InputText txtActivo) {
        this.txtActivo = txtActivo;
    }

    public InputText getTxtDescripcion() {
        return txtDescripcion;
    }

    public void setTxtDescripcion(InputText txtDescripcion) {
        this.txtDescripcion = txtDescripcion;
    }

    public InputText getTxtValor() {
        return txtValor;
    }

    public void setTxtValor(InputText txtValor) {
        this.txtValor = txtValor;
    }

    
    public List<GluoDetalleProyectoXRubroDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataGluoDetalleProyectoXRubro();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(
        List<GluoDetalleProyectoXRubroDTO> gluoDetalleProyectoXRubroDTO) {
        this.data = gluoDetalleProyectoXRubroDTO;
    }

    public GluoDetalleProyectoXRubroDTO getSelectedGluoDetalleProyectoXRubro() {
        return selectedGluoDetalleProyectoXRubro;
    }

    public void setSelectedGluoDetalleProyectoXRubro(
        GluoDetalleProyectoXRubroDTO gluoDetalleProyectoXRubro) {
        this.selectedGluoDetalleProyectoXRubro = gluoDetalleProyectoXRubro;
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
