package com.vortexbird.gluon.plan.presentation.backingBeans;

import com.vortexbird.gluon.plan.exceptions.*;
import com.vortexbird.gluon.plan.modelo.*;
import com.vortexbird.gluon.plan.modelo.dto.GluoProyectoDTO;
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
public class GluoProyectoView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(GluoProyectoView.class);
    private String somActivo;
    private InputTextarea txtAreaDescripcion;

    private List<SelectItem> losSubProgramasItems;
	private SelectOneMenu somSubPrograma;

    private InputText txtUsuCreador;
    private InputText txtUsuModificador;
    private InputText txtSubpId_GluoSubprograma;
    private InputText txtProyId;
    private Calendar txtFechaCreacion;
    private Calendar txtFechaModificacion;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
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

        if (txtSubpId_GluoSubprograma != null) {
            txtSubpId_GluoSubprograma.setValue(null);
            txtSubpId_GluoSubprograma.setDisabled(true);
        }

        if (txtFechaCreacion != null) {
            txtFechaCreacion.setValue(null);
            txtFechaCreacion.setDisabled(true);
        }

        if (txtFechaModificacion != null) {
            txtFechaModificacion.setValue(null);
            txtFechaModificacion.setDisabled(true);
        }

        if (txtProyId != null) {
            txtProyId.setValue(null);
            txtProyId.setDisabled(false);
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
            Integer proyId = FacesUtils.checkInteger(txtProyId);
            entity = (proyId != null)
                ? businessDelegatorView.getGluoProyecto(proyId) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
           // txtActivo.setDisabled(false);
            txtAreaDescripcion.setDisabled(false);
            txtUsuCreador.setDisabled(false);
            txtUsuModificador.setDisabled(false);
            txtSubpId_GluoSubprograma.setDisabled(false);
            txtFechaCreacion.setDisabled(false);
            txtFechaModificacion.setDisabled(false);
            txtProyId.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
          //  txtActivo.setValue(entity.getActivo());
          //  txtActivo.setDisabled(false);
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
            txtSubpId_GluoSubprograma.setValue(entity.getGluoSubprograma().getSubpId());
            txtSubpId_GluoSubprograma.setDisabled(false);
            txtProyId.setValue(entity.getProyId());
            txtProyId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedGluoProyecto = (GluoProyectoDTO) (evt.getComponent()
                                                     .getAttributes()
                                                     .get("selectedGluoProyecto"));
       // txtActivo.setValue(selectedGluoProyecto.getActivo());
       // txtActivo.setDisabled(false);
        txtAreaDescripcion.setValue(selectedGluoProyecto.getDescripcion());
        txtAreaDescripcion.setDisabled(false);
        txtFechaCreacion.setValue(selectedGluoProyecto.getFechaCreacion());
        txtFechaCreacion.setDisabled(false);
        txtFechaModificacion.setValue(selectedGluoProyecto.getFechaModificacion());
        txtFechaModificacion.setDisabled(false);
        txtUsuCreador.setValue(selectedGluoProyecto.getUsuCreador());
        txtUsuCreador.setDisabled(false);
        txtUsuModificador.setValue(selectedGluoProyecto.getUsuModificador());
        txtUsuModificador.setDisabled(false);
        //txtSubpId_GluoSubprograma.setValue(selectedGluoProyecto.getSubpId_GluoSubprograma());
       // txtSubpId_GluoSubprograma.setDisabled(false);
        txtProyId.setValue(selectedGluoProyecto.getProyId());
        txtProyId.setDisabled(true);
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

            //Integer proyId = FacesUtils.checkInteger(txtProyId);

            entity.setActivo(somActivo);
            entity.setDescripcion(FacesUtils.checkString(txtAreaDescripcion));
            entity.setFechaCreacion(new Date());
            //entity.setFechaModificacion(FacesUtils.checkDate(txtFechaModificacion));
            //entity.setProyId(proyId);
            SegUsuario segUsuario = (SegUsuario) FacesUtils.getfromSession("usuarioEnSession");
			Integer usuaCreador = Integer.valueOf(segUsuario.getUsuId());
			entity.setUsuCreador(usuaCreador);
			
			Integer idSubprograma = Integer.valueOf(somSubPrograma.getValue().toString());
            GluoSubprograma gluoSubPrograma = businessDelegatorView.getGluoSubprograma(idSubprograma);
            entity.setGluoSubprograma(gluoSubPrograma);
            //entity.setUsuModificador(FacesUtils.checkInteger(txtUsuModificador));
//            entity.setGluoSubprograma((FacesUtils.checkInteger(
//                    txtSubpId_GluoSubprograma) != null)
//                ? businessDelegatorView.getGluoSubprograma(
//                    FacesUtils.checkInteger(txtSubpId_GluoSubprograma)) : null);
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

            entity.setActivo(somActivo);
            entity.setDescripcion(FacesUtils.checkString(txtAreaDescripcion));
            ///entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
            SegUsuario segUsuario = (SegUsuario) FacesUtils.getfromSession("usuarioEnSession");
			Integer usuaModificador = Integer.valueOf(segUsuario.getUsuId());
			entity.setUsuModificador(usuaModificador);
            entity.setFechaModificacion(FacesUtils.checkDate(txtFechaModificacion));
            
            Integer idSubprograma = Integer.valueOf(somSubPrograma.getValue().toString());
            GluoSubprograma gluoSubPrograma = businessDelegatorView.getGluoSubprograma(idSubprograma);
            entity.setGluoSubprograma(gluoSubPrograma);
            //entity.setUsuCreador(FacesUtils.checkInteger(txtUsuCreador));
            //entity.setUsuModificador(FacesUtils.checkInteger(txtUsuModificador));
            
//            entity.setGluoSubprograma((FacesUtils.checkInteger(
//                    txtSubpId_GluoSubprograma) != null)
//                ? businessDelegatorView.getGluoSubprograma(
//                    FacesUtils.checkInteger(txtSubpId_GluoSubprograma)) : null);
            businessDelegatorView.updateGluoProyecto(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

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
            entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
            entity.setUsuCreador(FacesUtils.checkInteger(usuCreador));
            entity.setUsuModificador(FacesUtils.checkInteger(usuModificador));
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

    public InputText getTxtSubpId_GluoSubprograma() {
        return txtSubpId_GluoSubprograma;
    }

    public void setTxtSubpId_GluoSubprograma(
        InputText txtSubpId_GluoSubprograma) {
        this.txtSubpId_GluoSubprograma = txtSubpId_GluoSubprograma;
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

    public InputText getTxtProyId() {
        return txtProyId;
    }

    public void setTxtProyId(InputText txtProyId) {
        this.txtProyId = txtProyId;
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
