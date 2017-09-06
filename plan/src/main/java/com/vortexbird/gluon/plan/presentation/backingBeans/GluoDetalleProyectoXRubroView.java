package com.vortexbird.gluon.plan.presentation.backingBeans;

import com.vortexbird.gluon.plan.exceptions.*;
import com.vortexbird.gluon.plan.modelo.*;
import com.vortexbird.gluon.plan.modelo.dto.GluoDetalleProyectoXRubroDTO;
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
public class GluoDetalleProyectoXRubroView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(GluoDetalleProyectoXRubroView.class);
    private String somActivo;
    
    private SelectOneMenu somDetalleProyecto;
	private List<SelectItem> losDetalleProyectoItems;
	
	private SelectOneMenu somDetallePresupuesto;
	private List<SelectItem> losDetallePresupuestoItems;

    
    private InputTextarea txtAreaDescripcion;
    private InputText txtUsuCreador;
    private InputText txtUsuModificador;
    private InputText txtValor;
    private InputText txtDptoId_GluoDetallePresupuesto;
    private InputText txtDproId_GluoDetalleProyecto;
    private InputText txtDpruId;
    private Calendar txtFechaCreacion;
    private Calendar txtFechaModificacion;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
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

//        if (txtActivo != null) {
//            txtActivo.setValue(null);
//            txtActivo.setDisabled(true);
//        }

        if (txtAreaDescripcion != null) {
            txtAreaDescripcion.setValue(null);
            txtAreaDescripcion.setDisabled(true);
        }

        if (txtUsuCreador != null) {
            txtUsuCreador.setValue(null);
            txtUsuCreador.setDisabled(true);
        }

        if (txtUsuModificador != null) {
            txtUsuModificador.setValue(null);
            txtUsuModificador.setDisabled(true);
        }

        if (txtValor != null) {
            txtValor.setValue(null);
            txtValor.setDisabled(true);
        }

        if (txtDptoId_GluoDetallePresupuesto != null) {
            txtDptoId_GluoDetallePresupuesto.setValue(null);
            txtDptoId_GluoDetallePresupuesto.setDisabled(true);
        }

        if (txtDproId_GluoDetalleProyecto != null) {
            txtDproId_GluoDetalleProyecto.setValue(null);
            txtDproId_GluoDetalleProyecto.setDisabled(true);
        }

        if (txtFechaCreacion != null) {
            txtFechaCreacion.setValue(null);
            txtFechaCreacion.setDisabled(true);
        }

        if (txtFechaModificacion != null) {
            txtFechaModificacion.setValue(null);
            txtFechaModificacion.setDisabled(true);
        }

        if (txtDpruId != null) {
            txtDpruId.setValue(null);
            txtDpruId.setDisabled(false);
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
            Integer dpruId = FacesUtils.checkInteger(txtDpruId);
            entity = (dpruId != null)
                ? businessDelegatorView.getGluoDetalleProyectoXRubro(dpruId)
                : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            //txtActivo.setDisabled(false);
        	txtAreaDescripcion.setDisabled(false);
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
           // txtActivo.setValue(entity.getActivo());
            //txtActivo.setDisabled(false);
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

    public String action_edit(ActionEvent evt) {
        selectedGluoDetalleProyectoXRubro = (GluoDetalleProyectoXRubroDTO) (evt.getComponent()
                                                                               .getAttributes()
                                                                               .get("selectedGluoDetalleProyectoXRubro"));
       // txtActivo.setValue(selectedGluoDetalleProyectoXRubro.getActivo());
        //txtActivo.setDisabled(false);
        txtAreaDescripcion.setValue(selectedGluoDetalleProyectoXRubro.getDescripcion());
        txtAreaDescripcion.setDisabled(false);
        txtFechaCreacion.setValue(selectedGluoDetalleProyectoXRubro.getFechaCreacion());
        txtFechaCreacion.setDisabled(false);
        txtFechaModificacion.setValue(selectedGluoDetalleProyectoXRubro.getFechaModificacion());
        txtFechaModificacion.setDisabled(false);
        txtUsuCreador.setValue(selectedGluoDetalleProyectoXRubro.getUsuCreador());
        txtUsuCreador.setDisabled(false);
        txtUsuModificador.setValue(selectedGluoDetalleProyectoXRubro.getUsuModificador());
        txtUsuModificador.setDisabled(false);
        txtValor.setValue(selectedGluoDetalleProyectoXRubro.getValor());
        txtValor.setDisabled(false);
       // txtDptoId_GluoDetallePresupuesto.setValue(selectedGluoDetalleProyectoXRubro.getDptoId_GluoDetallePresupuesto());
        //txtDptoId_GluoDetallePresupuesto.setDisabled(false);
        //txtDproId_GluoDetalleProyecto.setValue(selectedGluoDetalleProyectoXRubro.getDproId_GluoDetalleProyecto());
        //txtDproId_GluoDetalleProyecto.setDisabled(false);
        txtDpruId.setValue(selectedGluoDetalleProyectoXRubro.getDpruId());
        txtDpruId.setDisabled(true);
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

           // Integer dpruId = FacesUtils.checkInteger(txtDpruId);

            entity.setActivo(somActivo);
            entity.setDescripcion(FacesUtils.checkString(txtAreaDescripcion));
            //entity.setDpruId(dpruId);
            entity.setFechaCreacion(new Date());
           // entity.setFechaModificacion(FacesUtils.checkDate(txtFechaModificacion));
            SegUsuario segUsuario = (SegUsuario) FacesUtils.getfromSession("usuarioEnSession");
			Integer usuaCreador = Integer.valueOf(segUsuario.getUsuId());
			entity.setUsuCreador(usuaCreador);
			
			Integer idDetalleProyecto = Integer.valueOf(somDetalleProyecto.getValue().toString());
			GluoDetalleProyecto gluoDetalleProyecto = businessDelegatorView.getGluoDetalleProyecto(idDetalleProyecto);
			entity.setGluoDetalleProyecto(gluoDetalleProyecto);
			
			Integer idDetallePresupuesto = Integer.valueOf(somDetallePresupuesto.getValue().toString());
			GluoDetallePresupuesto gluoDetallePresupuesto = businessDelegatorView.getGluoDetallePresupuesto(idDetallePresupuesto);
			entity.setGluoDetallePresupuesto(gluoDetallePresupuesto);
            
            //entity.setUsuCreador(FacesUtils.checkInteger(txtUsuCreador));
            
            //entity.setUsuModificador(FacesUtils.checkInteger(txtUsuModificador));
            
            entity.setValor(FacesUtils.checkDouble(txtValor));
//            entity.setGluoDetallePresupuesto((FacesUtils.checkInteger(
//                    txtDptoId_GluoDetallePresupuesto) != null)
//                ? businessDelegatorView.getGluoDetallePresupuesto(
//                    FacesUtils.checkInteger(txtDptoId_GluoDetallePresupuesto))
//                : null);
//            entity.setGluoDetalleProyecto((FacesUtils.checkInteger(
//                    txtDproId_GluoDetalleProyecto) != null)
//                ? businessDelegatorView.getGluoDetalleProyecto(
//                    FacesUtils.checkInteger(txtDproId_GluoDetalleProyecto)) : null);
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

            entity.setActivo(somActivo);
            entity.setDescripcion(FacesUtils.checkString(txtAreaDescripcion));
            //entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(
                    txtFechaModificacion));
            //entity.setUsuCreador(FacesUtils.checkInteger(txtUsuCreador));
            
            SegUsuario segUsuario = (SegUsuario) FacesUtils.getfromSession("usuarioEnSession");
			Integer usuaModificador = Integer.valueOf(segUsuario.getUsuId());
			entity.setUsuModificador(usuaModificador);
			
			Integer idDetalleProyecto = Integer.valueOf(somDetalleProyecto.getValue().toString());
			GluoDetalleProyecto gluoDetalleProyecto = businessDelegatorView.getGluoDetalleProyecto(idDetalleProyecto);
			entity.setGluoDetalleProyecto(gluoDetalleProyecto);
			
			Integer idDetallePresupuesto = Integer.valueOf(somDetallePresupuesto.getValue().toString());
			GluoDetallePresupuesto gluoDetallePresupuesto = businessDelegatorView.getGluoDetallePresupuesto(idDetallePresupuesto);
			entity.setGluoDetallePresupuesto(gluoDetallePresupuesto);
			
           // entity.setUsuModificador(FacesUtils.checkInteger(txtUsuModificador));
            entity.setValor(FacesUtils.checkDouble(txtValor));
//            entity.setGluoDetallePresupuesto((FacesUtils.checkInteger(
//                    txtDptoId_GluoDetallePresupuesto) != null)
//                ? businessDelegatorView.getGluoDetallePresupuesto(
//                    FacesUtils.checkInteger(txtDptoId_GluoDetallePresupuesto))
//                : null);
//            entity.setGluoDetalleProyecto((FacesUtils.checkInteger(
//                    txtDproId_GluoDetalleProyecto) != null)
//                ? businessDelegatorView.getGluoDetalleProyecto(
//                    FacesUtils.checkInteger(txtDproId_GluoDetalleProyecto)) : null);
            businessDelegatorView.updateGluoDetalleProyectoXRubro(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

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
            entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
            entity.setUsuCreador(FacesUtils.checkInteger(usuCreador));
            entity.setUsuModificador(FacesUtils.checkInteger(usuModificador));
            entity.setValor(FacesUtils.checkDouble(valor));
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
					losDetalleProyectoItems.add(new SelectItem(gluoDetalleProyecto.getDproId(),gluoDetalleProyecto.getActivo()));
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

    public InputText getTxtValor() {
        return txtValor;
    }

    public void setTxtValor(InputText txtValor) {
        this.txtValor = txtValor;
    }

    public InputText getTxtDptoId_GluoDetallePresupuesto() {
        return txtDptoId_GluoDetallePresupuesto;
    }

    public void setTxtDptoId_GluoDetallePresupuesto(
        InputText txtDptoId_GluoDetallePresupuesto) {
        this.txtDptoId_GluoDetallePresupuesto = txtDptoId_GluoDetallePresupuesto;
    }

    public InputText getTxtDproId_GluoDetalleProyecto() {
        return txtDproId_GluoDetalleProyecto;
    }

    public void setTxtDproId_GluoDetalleProyecto(
        InputText txtDproId_GluoDetalleProyecto) {
        this.txtDproId_GluoDetalleProyecto = txtDproId_GluoDetalleProyecto;
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

    public InputText getTxtDpruId() {
        return txtDpruId;
    }

    public void setTxtDpruId(InputText txtDpruId) {
        this.txtDpruId = txtDpruId;
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
