package com.vortexbird.gluon.plan.presentation.backingBeans;

import com.vortexbird.gluon.plan.exceptions.*;
import com.vortexbird.gluon.plan.modelo.*;
import com.vortexbird.gluon.plan.modelo.dto.SegUsuarioDTO;
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
public class SegUsuarioView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(SegUsuarioView.class);
    
    
    private List<SelectItem> losRolesItems;
	private SelectOneMenu somRoles;
	
	private String somActivo;
	
    private InputText txtActivo;
    private InputText txtUsuCreador;
    private InputText txtUsuLogin;
    private InputText txtUsuModificador;
    private InputText txtUsuPassword;
    private InputText txtUsuId;
    private Calendar txtFechaCreacion;
    private Calendar txtFechaModificacion;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<SegUsuarioDTO> data;
    private SegUsuarioDTO selectedSegUsuario;
    private SegUsuario entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public SegUsuarioView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedSegUsuario = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedSegUsuario = null;


        if (txtUsuLogin != null) {
            txtUsuLogin.setValue(null);
            txtUsuLogin.setDisabled(false);
        }

       

        if (txtUsuPassword != null) {
            txtUsuPassword.setValue(null);
            txtUsuPassword.setDisabled(false);
        }


        if (btnSave != null) {
            btnSave.setDisabled(true);
        }

        if (btnDelete != null) {
            btnDelete.setDisabled(false);
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
            Integer usuId = FacesUtils.checkInteger(txtUsuId);
            entity = (usuId != null)
                ? businessDelegatorView.getSegUsuario(usuId) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            //txtActivo.setDisabled(false);
            txtUsuCreador.setDisabled(false);
            txtUsuLogin.setDisabled(false);
            txtUsuModificador.setDisabled(false);
            txtUsuPassword.setDisabled(false);
            txtFechaCreacion.setDisabled(false);
            txtFechaModificacion.setDisabled(false);
            txtUsuId.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            //txtActivo.setValue(entity.getActivo());
           // txtActivo.setDisabled(false);
            txtFechaCreacion.setValue(entity.getFechaCreacion());
            txtFechaCreacion.setDisabled(false);
            txtFechaModificacion.setValue(entity.getFechaModificacion());
            txtFechaModificacion.setDisabled(false);
            txtUsuCreador.setValue(entity.getUsuCreador());
            txtUsuCreador.setDisabled(false);
            txtUsuLogin.setValue(entity.getUsuLogin());
            txtUsuLogin.setDisabled(false);
            txtUsuModificador.setValue(entity.getUsuModificador());
            txtUsuModificador.setDisabled(false);
            txtUsuPassword.setValue(entity.getUsuPassword());
            txtUsuPassword.setDisabled(false);
           // txtUsuId.setValue(entity.getUsuId());
            //txtUsuId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedSegUsuario = (SegUsuarioDTO) (evt.getComponent().getAttributes()
                                                 .get("selectedSegUsuario"));
      //  txtActivo.setValue(selectedSegUsuario.getActivo());
        //txtActivo.setDisabled(false);
        txtFechaCreacion.setValue(selectedSegUsuario.getFechaCreacion());
        txtFechaCreacion.setDisabled(false);
        txtFechaModificacion.setValue(selectedSegUsuario.getFechaModificacion());
        txtFechaModificacion.setDisabled(false);
        txtUsuCreador.setValue(selectedSegUsuario.getUsuCreador());
        txtUsuCreador.setDisabled(false);
        txtUsuLogin.setValue(selectedSegUsuario.getUsuLogin());
        txtUsuLogin.setDisabled(false);
        txtUsuModificador.setValue(selectedSegUsuario.getUsuModificador());
        txtUsuModificador.setDisabled(false);
        txtUsuPassword.setValue(selectedSegUsuario.getUsuPassword());
        txtUsuPassword.setDisabled(false);
       // txtUsuId.setValue(selectedSegUsuario.getUsuId());
        //txtUsuId.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedSegUsuario == null) && (entity == null)) {
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
            entity = new SegUsuario();

            //Integer usuId = FacesUtils.checkInteger(txtUsuId);

            entity.setActivo("A");
            entity.setFechaCreacion(new Date());
            
            SegUsuario segUsuario = (SegUsuario) FacesUtils.getfromSession("usuarioEnSession");
			Integer usuaCreador = Integer.valueOf(segUsuario.getUsuId());
			entity.setUsuCreador(usuaCreador);
			
            entity.setUsuLogin(FacesUtils.checkString(txtUsuLogin));
            entity.setUsuPassword(FacesUtils.checkString(txtUsuPassword));
            businessDelegatorView.saveSegUsuario(entity);
            FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_INFO, "El usuario se creó con exito", ""));
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
                Integer usuId = new Integer(selectedSegUsuario.getUsuId());
                entity = businessDelegatorView.getSegUsuario(usuId);
            }

            entity.setActivo(FacesUtils.checkString(txtActivo));
            entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(
                    txtFechaModificacion));
            entity.setUsuCreador(FacesUtils.checkInteger(txtUsuCreador));
            entity.setUsuLogin(FacesUtils.checkString(txtUsuLogin));
            entity.setUsuModificador(FacesUtils.checkInteger(txtUsuModificador));
            entity.setUsuPassword(FacesUtils.checkString(txtUsuPassword));
            businessDelegatorView.updateSegUsuario(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedSegUsuario = (SegUsuarioDTO) (evt.getComponent()
                                                     .getAttributes()
                                                     .get("selectedSegUsuario"));

            Integer usuId = new Integer(selectedSegUsuario.getUsuId());
            entity = businessDelegatorView.getSegUsuario(usuId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer usuId = FacesUtils.checkInteger(txtUsuId);
            entity = businessDelegatorView.getSegUsuario(usuId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteSegUsuario(entity);
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

    public String action_modifyWitDTO(String activo, Date fechaCreacion,
        Date fechaModificacion, Integer usuCreador, Integer usuId,
        String usuLogin, Integer usuModificador, String usuPassword)
        throws Exception {
        try {
            entity.setActivo(FacesUtils.checkString(activo));
            entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
            entity.setUsuCreador(FacesUtils.checkInteger(usuCreador));
            entity.setUsuLogin(FacesUtils.checkString(usuLogin));
            entity.setUsuModificador(FacesUtils.checkInteger(usuModificador));
            entity.setUsuPassword(FacesUtils.checkString(usuPassword));
            businessDelegatorView.updateSegUsuario(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("SegUsuarioView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }
    
    

    public List<SelectItem> getLosRolesItems() {
    	try {
			if (losRolesItems == null) {
				losRolesItems = new ArrayList<SelectItem>();
				List<SegRol> losRoles = businessDelegatorView.getSegRol();
				for (SegRol rol : losRoles) {
					losRolesItems.add(new SelectItem(rol.getRolId(), rol.getNombre()));
				}
			}
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
		return losRolesItems;
	}

	public void setLosRolesItems(List<SelectItem> losRolesItems) {
		this.losRolesItems = losRolesItems;
	}

	public SelectOneMenu getSomRoles() {
		return somRoles;
	}

	public void setSomRoles(SelectOneMenu somRoles) {
		this.somRoles = somRoles;
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

    public InputText getTxtUsuLogin() {
        return txtUsuLogin;
    }

    public void setTxtUsuLogin(InputText txtUsuLogin) {
        this.txtUsuLogin = txtUsuLogin;
    }

    public InputText getTxtUsuModificador() {
        return txtUsuModificador;
    }

    public void setTxtUsuModificador(InputText txtUsuModificador) {
        this.txtUsuModificador = txtUsuModificador;
    }

    public InputText getTxtUsuPassword() {
        return txtUsuPassword;
    }

    public void setTxtUsuPassword(InputText txtUsuPassword) {
        this.txtUsuPassword = txtUsuPassword;
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

    public InputText getTxtUsuId() {
        return txtUsuId;
    }

    public void setTxtUsuId(InputText txtUsuId) {
        this.txtUsuId = txtUsuId;
    }

    public List<SegUsuarioDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataSegUsuario();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<SegUsuarioDTO> segUsuarioDTO) {
        this.data = segUsuarioDTO;
    }

    public SegUsuarioDTO getSelectedSegUsuario() {
        return selectedSegUsuario;
    }

    public void setSelectedSegUsuario(SegUsuarioDTO segUsuario) {
        this.selectedSegUsuario = segUsuario;
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
