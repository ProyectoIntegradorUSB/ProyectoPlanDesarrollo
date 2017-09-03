package com.vortexbird.gluon.plan.presentation.backingBeans;

import com.vortexbird.gluon.plan.exceptions.*;
import com.vortexbird.gluon.plan.modelo.*;
import com.vortexbird.gluon.plan.modelo.dto.GluoSubprogramaDTO;
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
public class GluoSubprogramaView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(GluoSubprogramaView.class);
    private InputText txtActivo;
    private InputText txtDescripcion;
    private List<SelectItem> losProgramasItems;
	private SelectOneMenu somPrograma;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnClear;
    private List<GluoSubprogramaDTO> data;
    private GluoSubprogramaDTO selectedGluoSubprograma;
    private GluoSubprograma entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public GluoSubprogramaView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedGluoSubprograma = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedGluoSubprograma = null;

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
            Integer subpId = FacesUtils.checkInteger(txtSubpId);
            entity = (subpId != null)
                ? businessDelegatorView.getGluoSubprograma(subpId) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtActivo.setDisabled(false);
            txtDescripcion.setDisabled(false);
            txtUsuCreador.setDisabled(false);
            txtUsuModificador.setDisabled(false);
            txtProgId_GluoPrograma.setDisabled(false);
            txtFechaCreacion.setDisabled(false);
            txtFechaModificacion.setDisabled(false);
            txtSubpId.setDisabled(false);
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
            txtProgId_GluoPrograma.setValue(entity.getGluoPrograma().getProgId());
            txtProgId_GluoPrograma.setDisabled(false);
            txtSubpId.setValue(entity.getSubpId());
            txtSubpId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }
*/
    public String action_edit(ActionEvent evt) {
        selectedGluoSubprograma = (GluoSubprogramaDTO) (evt.getComponent()
                                                           .getAttributes()
                                                           .get("selectedGluoSubprograma"));
        txtActivo.setValue(selectedGluoSubprograma.getActivo());
        txtActivo.setDisabled(false);
        txtDescripcion.setValue(selectedGluoSubprograma.getDescripcion());
        txtDescripcion.setDisabled(false);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedGluoSubprograma == null) && (entity == null)) {
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
            entity = new GluoSubprograma();

            //Integer subpId = FacesUtils.checkInteger(txtSubpId);

            entity.setActivo(FacesUtils.checkString(txtActivo));
            entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
            entity.setFechaCreacion(new Date());
            SegUsuario segUsuario = (SegUsuario) FacesUtils.getfromSession("usuarioEnSession");
            Integer usuaCreador = Integer.valueOf(segUsuario.getUsuId());
            entity.setUsuCreador(usuaCreador);
            
            Integer idprograma = Integer.valueOf(somPrograma.getValue().toString());
            GluoPrograma gluoPrograma = businessDelegatorView.getGluoPrograma(idprograma);
            entity.setGluoPrograma(gluoPrograma);
            
            businessDelegatorView.saveGluoSubprograma(entity);
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
                Integer subpId = new Integer(selectedGluoSubprograma.getSubpId());
                entity = businessDelegatorView.getGluoSubprograma(subpId);
            }

            entity.setActivo(FacesUtils.checkString(txtActivo));
            entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
            SegUsuario segUsuario = (SegUsuario) FacesUtils.getfromSession("usuarioEnSession");
            Integer usuaModificador = Integer.valueOf(segUsuario.getUsuId());
            entity.setUsuModificador(usuaModificador);
           
            businessDelegatorView.updateGluoSubprograma(entity);
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
            selectedGluoSubprograma = (GluoSubprogramaDTO) (evt.getComponent()
                                                               .getAttributes()
                                                               .get("selectedGluoSubprograma"));

            Integer subpId = new Integer(selectedGluoSubprograma.getSubpId());
            entity = businessDelegatorView.getGluoSubprograma(subpId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer subpId = FacesUtils.checkInteger(txtSubpId);
            entity = businessDelegatorView.getGluoSubprograma(subpId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteGluoSubprograma(entity);
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
        Date fechaCreacion, Date fechaModificacion, Integer subpId,
        Integer usuCreador, Integer usuModificador, Integer progId_GluoPrograma)
        throws Exception {
        try {
            entity.setActivo(FacesUtils.checkString(activo));
            entity.setDescripcion(FacesUtils.checkString(descripcion));
            SegUsuario segUsuario = (SegUsuario) FacesUtils.getfromSession("usuarioEnSession");
            Integer usuaModificador = Integer.valueOf(segUsuario.getUsuId());
            entity.setUsuModificador(usuaModificador);
            businessDelegatorView.updateGluoSubprograma(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("GluoSubprogramaView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }
    

    public List<SelectItem> getLosProgramasItems()throws Exception {
    	try {
			if(losProgramasItems == null) {
				losProgramasItems = new ArrayList<SelectItem>();
				List<GluoPrograma> losGluoPrograma = businessDelegatorView.getGluoPrograma();
				for (GluoPrograma gluoPrograma : losGluoPrograma) {				
					losProgramasItems.add(new SelectItem(gluoPrograma.getProgId(),gluoPrograma.getDescripcion()));
				}
			}
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
		return losProgramasItems;
	}

	public void setLosProgramasItems(List<SelectItem> losProgramasItems) {
		this.losProgramasItems = losProgramasItems;
	}

	public SelectOneMenu getSomPrograma() {
		return somPrograma;
	}

	public void setSomPrograma(SelectOneMenu somPrograma) {
		this.somPrograma = somPrograma;
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

    
    public List<GluoSubprogramaDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataGluoSubprograma();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<GluoSubprogramaDTO> gluoSubprogramaDTO) {
        this.data = gluoSubprogramaDTO;
    }

    public GluoSubprogramaDTO getSelectedGluoSubprograma() {
        return selectedGluoSubprograma;
    }

    public void setSelectedGluoSubprograma(GluoSubprogramaDTO gluoSubprograma) {
        this.selectedGluoSubprograma = gluoSubprograma;
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
