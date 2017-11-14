package com.vortexbird.gluon.plan.presentation.backingBeans;

import com.vortexbird.gluon.plan.exceptions.*;
import com.vortexbird.gluon.plan.modelo.*;
import com.vortexbird.gluon.plan.modelo.dto.SegRolUsuarioDTO;
import com.vortexbird.gluon.plan.presentation.businessDelegate.*;
import com.vortexbird.gluon.plan.utilities.*;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
public class SegRolUsuarioView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(SegRolUsuarioView.class);
    
    
    private String somActivo;
    
    private SelectOneMenu somRoles;
	private List<SelectItem> losRolesItems;
	
	private SelectOneMenu somUsuarios;
	private List<SelectItem> losUsuariosItems;
    
    
    
    
    private InputText txtUsuCreador;
    private InputText txtUsuModificador;
    private InputText txtRolId_SegRol;
    private InputText txtUsuId_SegUsuario;
    private InputText txtRlusId;
    private Calendar txtFechaCreacion;
    private Calendar txtFechaModificacion;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<SegRolUsuarioDTO> data;
    private SegRolUsuarioDTO selectedSegRolUsuario;
    private SegRolUsuario entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public SegRolUsuarioView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedSegRolUsuario = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedSegRolUsuario = null;
/*
        if (txtActivo != null) {
            txtActivo.setValue(null);
            txtActivo.setDisabled(true);
        }
*/
        if (txtUsuCreador != null) {
            txtUsuCreador.setValue(null);
            txtUsuCreador.setDisabled(true);
        }

        if (txtUsuModificador != null) {
            txtUsuModificador.setValue(null);
            txtUsuModificador.setDisabled(true);
        }

        if (txtRolId_SegRol != null) {
            txtRolId_SegRol.setValue(null);
            txtRolId_SegRol.setDisabled(true);
        }

        if (txtUsuId_SegUsuario != null) {
            txtUsuId_SegUsuario.setValue(null);
            txtUsuId_SegUsuario.setDisabled(true);
        }

        if (txtFechaCreacion != null) {
            txtFechaCreacion.setValue(null);
            txtFechaCreacion.setDisabled(true);
        }

        if (txtFechaModificacion != null) {
            txtFechaModificacion.setValue(null);
            txtFechaModificacion.setDisabled(true);
        }

        if (txtRlusId != null) {
            txtRlusId.setValue(null);
            txtRlusId.setDisabled(false);
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
            Integer rlusId = FacesUtils.checkInteger(txtRlusId);
            entity = (rlusId != null)
                ? businessDelegatorView.getSegRolUsuario(rlusId) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
           // txtActivo.setDisabled(false);
            txtUsuCreador.setDisabled(false);
            txtUsuModificador.setDisabled(false);
            txtRolId_SegRol.setDisabled(false);
            txtUsuId_SegUsuario.setDisabled(false);
            txtFechaCreacion.setDisabled(false);
            txtFechaModificacion.setDisabled(false);
            txtRlusId.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            //txtActivo.setValue(entity.getActivo());
            //txtActivo.setDisabled(false);
            txtFechaCreacion.setValue(entity.getFechaCreacion());
            txtFechaCreacion.setDisabled(false);
            txtFechaModificacion.setValue(entity.getFechaModificacion());
            txtFechaModificacion.setDisabled(false);
            txtUsuCreador.setValue(entity.getUsuCreador());
            txtUsuCreador.setDisabled(false);
            txtUsuModificador.setValue(entity.getUsuModificador());
            txtUsuModificador.setDisabled(false);
            txtRolId_SegRol.setValue(entity.getSegRol().getRolId());
            txtRolId_SegRol.setDisabled(false);
            txtUsuId_SegUsuario.setValue(entity.getSegUsuario().getUsuId());
            txtUsuId_SegUsuario.setDisabled(false);
            txtRlusId.setValue(entity.getRlusId());
            txtRlusId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedSegRolUsuario = (SegRolUsuarioDTO) (evt.getComponent()
                                                       .getAttributes()
                                                       .get("selectedSegRolUsuario"));
        //txtActivo.setValue(selectedSegRolUsuario.getActivo());
        //txtActivo.setDisabled(false);
        txtFechaCreacion.setValue(selectedSegRolUsuario.getFechaCreacion());
        txtFechaCreacion.setDisabled(false);
        txtFechaModificacion.setValue(selectedSegRolUsuario.getFechaModificacion());
        txtFechaModificacion.setDisabled(false);
        txtUsuCreador.setValue(selectedSegRolUsuario.getUsuCreador());
        txtUsuCreador.setDisabled(false);
        txtUsuModificador.setValue(selectedSegRolUsuario.getUsuModificador());
        txtUsuModificador.setDisabled(false);
        //txtRolId_SegRol.setValue(selectedSegRolUsuario.getRolId_SegRol());
        //txtRolId_SegRol.setDisabled(false);
        //txtUsuId_SegUsuario.setValue(selectedSegRolUsuario.getUsuId_SegUsuario());
        //txtUsuId_SegUsuario.setDisabled(false);
        txtRlusId.setValue(selectedSegRolUsuario.getRlusId());
        txtRlusId.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedSegRolUsuario == null) && (entity == null)) {
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
            entity = new SegRolUsuario();

            //Integer rlusId = FacesUtils.checkInteger(txtRlusId);

            entity.setActivo(("A"));
            entity.setFechaCreacion(new Date());
            
            //entity.setRlusId(rlusId);
            
            SegUsuario segUsuario = (SegUsuario) FacesUtils.getfromSession("usuarioEnSession");
			Integer usuaCreador = Integer.valueOf(segUsuario.getUsuId());
			entity.setUsuCreador(usuaCreador);
			
			Integer idrol = Integer.valueOf(somRoles.getValue().toString());
			SegRol segRol = businessDelegatorView.getSegRol(idrol);
			entity.setSegRol(segRol);
			
			Integer idusuario = Integer.valueOf(somUsuarios.getValue().toString());
			SegUsuario usuario = businessDelegatorView.getSegUsuario(idusuario);
			entity.setSegUsuario(usuario);
			
                    /*
            entity.setSegRol((FacesUtils.checkInteger(txtRolId_SegRol) != null)
                ? businessDelegatorView.getSegRol(FacesUtils.checkInteger(
                        txtRolId_SegRol)) : null);
            entity.setSegUsuario((FacesUtils.checkInteger(txtUsuId_SegUsuario) != null)
                ? businessDelegatorView.getSegUsuario(FacesUtils.checkInteger(
                        txtUsuId_SegUsuario)) : null);
                        */
            businessDelegatorView.saveSegRolUsuario(entity);
            FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Se ha añadido un nuevo rol al usuario", ""));
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
                Integer rlusId = new Integer(selectedSegRolUsuario.getRlusId());
                entity = businessDelegatorView.getSegRolUsuario(rlusId);
            }

            entity.setActivo("A");
        
            entity.setFechaModificacion(new Date());
           
            SegUsuario segUsuario = (SegUsuario) FacesUtils.getfromSession("usuarioEnSession");
			Integer usuaModificador = Integer.valueOf(segUsuario.getUsuId());
			entity.setUsuModificador(usuaModificador);
			
			
			Integer idrol = Integer.valueOf(somRoles.getValue().toString());
			SegRol segRol = businessDelegatorView.getSegRol(idrol);
			entity.setSegRol(segRol);
			
			Integer idusuario = Integer.valueOf(somUsuarios.getValue().toString());
			SegUsuario usuario = businessDelegatorView.getSegUsuario(idusuario);
			entity.setSegUsuario(usuario);
            
            
            /*
            entity.setSegRol((FacesUtils.checkInteger(txtRolId_SegRol) != null)
                ? businessDelegatorView.getSegRol(FacesUtils.checkInteger(
                        txtRolId_SegRol)) : null);
            entity.setSegUsuario((FacesUtils.checkInteger(txtUsuId_SegUsuario) != null)
                ? businessDelegatorView.getSegUsuario(FacesUtils.checkInteger(
                        txtUsuId_SegUsuario)) : null);
                        */
            businessDelegatorView.updateSegRolUsuario(entity);
            FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Los datos se han modificado con exito", ""));
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedSegRolUsuario = (SegRolUsuarioDTO) (evt.getComponent()
                                                           .getAttributes()
                                                           .get("selectedSegRolUsuario"));

            Integer rlusId = new Integer(selectedSegRolUsuario.getRlusId());
            entity = businessDelegatorView.getSegRolUsuario(rlusId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer rlusId = FacesUtils.checkInteger(txtRlusId);
            entity = businessDelegatorView.getSegRolUsuario(rlusId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteSegRolUsuario(entity);
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
        Date fechaModificacion, Integer rlusId, Integer usuCreador,
        Integer usuModificador, Integer rolId_SegRol, Integer usuId_SegUsuario)
        throws Exception {
        try {
            entity.setActivo(FacesUtils.checkString(activo));
            entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
            entity.setUsuCreador(FacesUtils.checkInteger(usuCreador));
            entity.setUsuModificador(FacesUtils.checkInteger(usuModificador));
            businessDelegatorView.updateSegRolUsuario(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("SegRolUsuarioView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }
    
    
    

    public SelectOneMenu getSomRoles() {
		return somRoles;
	}

	public void setSomRoles(SelectOneMenu somRoles) {
		this.somRoles = somRoles;
	}

	public List<SelectItem> getLosRolesItems() {
		try {
			if (losRolesItems == null) {
				losRolesItems = new ArrayList<SelectItem>();
				List<SegRol> losRoles = businessDelegatorView.getSegRol();

				for (SegRol SegRol: losRoles) {
					losRolesItems.add(new SelectItem(SegRol.getRolId(),
							SegRol.getNombre()));
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

	public SelectOneMenu getSomUsuarios() {
		return somUsuarios;
	}

	public void setSomUsuarios(SelectOneMenu somUsuarios) {
		this.somUsuarios = somUsuarios;
	}

	public List<SelectItem> getLosUsuariosItems() {
		
		try {
			if (losUsuariosItems == null) {
				losUsuariosItems = new ArrayList<SelectItem>();
				List<SegUsuario> losUsuarios = businessDelegatorView.getSegUsuario();

				for (SegUsuario SegUsuario: losUsuarios) {
					losUsuariosItems.add(new SelectItem(SegUsuario.getUsuId(),
							SegUsuario.getUsuLogin()));
				}

			}
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
		
		return losUsuariosItems;
	}

	public void setLosUsuariosItems(List<SelectItem> losUsuariosItems) {
		this.losUsuariosItems = losUsuariosItems;
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

    public InputText getTxtRolId_SegRol() {
        return txtRolId_SegRol;
    }

    public void setTxtRolId_SegRol(InputText txtRolId_SegRol) {
        this.txtRolId_SegRol = txtRolId_SegRol;
    }

    public InputText getTxtUsuId_SegUsuario() {
        return txtUsuId_SegUsuario;
    }

    public void setTxtUsuId_SegUsuario(InputText txtUsuId_SegUsuario) {
        this.txtUsuId_SegUsuario = txtUsuId_SegUsuario;
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

    public InputText getTxtRlusId() {
        return txtRlusId;
    }

    public void setTxtRlusId(InputText txtRlusId) {
        this.txtRlusId = txtRlusId;
    }

    public List<SegRolUsuarioDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataSegRolUsuario();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<SegRolUsuarioDTO> segRolUsuarioDTO) {
        this.data = segRolUsuarioDTO;
    }

    public SegRolUsuarioDTO getSelectedSegRolUsuario() {
        return selectedSegRolUsuario;
    }

    public void setSelectedSegRolUsuario(SegRolUsuarioDTO segRolUsuario) {
        this.selectedSegRolUsuario = segRolUsuario;
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
