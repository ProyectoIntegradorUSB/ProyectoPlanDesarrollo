package com.vortexbird.gluon.plan.presentation.backingBeans;

import com.vortexbird.gluon.plan.exceptions.*;
import com.vortexbird.gluon.plan.modelo.*;
import com.vortexbird.gluon.plan.modelo.dto.GluoProyectoDTO;
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
public class GluoProyectoView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(GluoProyectoView.class);
    private InputText txtActivo;
    private InputText txtDescripcion;
    private List<SelectItem> losSubProgramasItems;
	private SelectOneMenu somSubPrograma;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnClear;
    private List<GluoProyectoDTO> data;
    private GluoProyectoDTO selectedGluoProyecto;
    private GluoProyecto entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public GluoProyectoView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedGluoProyecto = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedGluoProyecto = null;

        if (txtActivo != null) {
            txtActivo.setValue(null);
            txtActivo.setDisabled(true);
        }

        if (txtDescripcion != null) {
            txtDescripcion.setValue(null);
            txtDescripcion.setDisabled(true);
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
            Integer proyId = FacesUtils.checkInteger(txtProyId);
            entity = (proyId != null)
                ? businessDelegatorView.getGluoProyecto(proyId) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtActivo.setDisabled(false);
            txtDescripcion.setDisabled(false);
            txtUsuCreador.setDisabled(false);
            txtUsuModificador.setDisabled(false);
            txtSubpId_GluoSubprograma.setDisabled(false);
            txtFechaCreacion.setDisabled(false);
            txtFechaModificacion.setDisabled(false);
            txtProyId.setDisabled(false);
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
            txtSubpId_GluoSubprograma.setValue(entity.getGluoSubprograma()
                                                     .getSubpId());
            txtSubpId_GluoSubprograma.setDisabled(false);
            txtProyId.setValue(entity.getProyId());
            txtProyId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }
*/
    public String action_edit(ActionEvent evt) {
        selectedGluoProyecto = (GluoProyectoDTO) (evt.getComponent()
                                                     .getAttributes()
                                                     .get("selectedGluoProyecto"));
        txtActivo.setValue(selectedGluoProyecto.getActivo());
        txtActivo.setDisabled(false);
        txtDescripcion.setValue(selectedGluoProyecto.getDescripcion());
        txtDescripcion.setDisabled(false);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedGluoProyecto == null) && (entity == null)) {
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
            entity = new GluoProyecto();


            entity.setActivo(FacesUtils.checkString(txtActivo));
            entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
            entity.setFechaCreacion(new Date());
            
            SegUsuario segUsuario = (SegUsuario) FacesUtils.getfromSession("usuarioEnSession");
            Integer usuaCreador = Integer.valueOf(segUsuario.getUsuId());
            entity.setUsuCreador(usuaCreador);
            
            Integer idSubPrograma = Integer.valueOf(somSubPrograma.getValue().toString());
            GluoSubprograma gluoSubPrograma = businessDelegatorView.getGluoSubprograma(idSubPrograma);
            entity.setGluoSubprograma(gluoSubPrograma);
           
            businessDelegatorView.saveGluoProyecto(entity);
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
                Integer proyId = new Integer(selectedGluoProyecto.getProyId());
                entity = businessDelegatorView.getGluoProyecto(proyId);
            }

            entity.setActivo(FacesUtils.checkString(txtActivo));
            entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
            SegUsuario segUsuario = (SegUsuario) FacesUtils.getfromSession("usuarioEnSession");
            Integer usuaModificador = Integer.valueOf(segUsuario.getUsuId());
            entity.setUsuModificador(usuaModificador);
            
            
            businessDelegatorView.updateGluoProyecto(entity);
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
            selectedGluoProyecto = (GluoProyectoDTO) (evt.getComponent()
                                                         .getAttributes()
                                                         .get("selectedGluoProyecto"));

            Integer proyId = new Integer(selectedGluoProyecto.getProyId());
            entity = businessDelegatorView.getGluoProyecto(proyId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer proyId = FacesUtils.checkInteger(txtProyId);
            entity = businessDelegatorView.getGluoProyecto(proyId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteGluoProyecto(entity);
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
        Date fechaCreacion, Date fechaModificacion, Integer proyId,
        Integer usuCreador, Integer usuModificador,
        Integer subpId_GluoSubprograma) throws Exception {
        try {
            entity.setActivo(FacesUtils.checkString(activo));
            entity.setDescripcion(FacesUtils.checkString(descripcion));
            SegUsuario segUsuario = (SegUsuario) FacesUtils.getfromSession("usuarioEnSession");
            Integer usuaModificador = Integer.valueOf(segUsuario.getUsuId());
            entity.setUsuModificador(usuaModificador);
            businessDelegatorView.updateGluoProyecto(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("GluoProyectoView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }
    
    

    public List<SelectItem> getLosSubProgramasItems() {
    	try {
			if (losSubProgramasItems == null) {
				losSubProgramasItems = new ArrayList<SelectItem>();
				List<GluoSubprograma> losGluoSubPrograma = businessDelegatorView.getGluoSubprograma();
				for (GluoSubprograma gluoSubPrograma : losGluoSubPrograma) {
					losSubProgramasItems.add(new SelectItem(gluoSubPrograma.getSubpId(), gluoSubPrograma.getDescripcion()));
				}
			}
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
    	
		return losSubProgramasItems;
	}

	public void setLosSubProgramasItems(List<SelectItem> losSubProgramasItems) {
		this.losSubProgramasItems = losSubProgramasItems;
	}

	public SelectOneMenu getSomSubPrograma() {
		return somSubPrograma;
	}

	public void setSomSubPrograma(SelectOneMenu somSubPrograma) {
		this.somSubPrograma = somSubPrograma;
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

    
    public List<GluoProyectoDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataGluoProyecto();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<GluoProyectoDTO> gluoProyectoDTO) {
        this.data = gluoProyectoDTO;
    }

    public GluoProyectoDTO getSelectedGluoProyecto() {
        return selectedGluoProyecto;
    }

    public void setSelectedGluoProyecto(GluoProyectoDTO gluoProyecto) {
        this.selectedGluoProyecto = gluoProyecto;
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
