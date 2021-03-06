package com.vortexbird.gluon.plan.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.vortexbird.gluon.plan.modelo.SegRol;
import com.vortexbird.gluon.plan.modelo.SegRolUsuario;
import com.vortexbird.gluon.plan.modelo.SegUsuario;
import com.vortexbird.gluon.plan.modelo.control.ISegRolUsuarioLogic;
import com.vortexbird.gluon.plan.presentation.businessDelegate.IBusinessDelegatorView;
import com.vortexbird.gluon.plan.utilities.*;
/**
* @author Zathura Code Generator http://code.google.com/p/zathura/
* www.zathuracode.org
*
*/
@Scope("singleton")
@Component("zathuraCodeAuthenticationProvider")
public class ZathuraCodeAuthenticationProvider implements AuthenticationProvider {
    /**
     * Security Implementation
     */
	@Autowired
	private IBusinessDelegatorView businessDelegatorView;
	
    @Override
    public Authentication authenticate(Authentication authentication)
        throws AuthenticationException {
    	
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        
        try {
			
        	SegUsuario segUsuario = businessDelegatorView.validarUsuario(name, password);
//        	SegRolUsuario segRolusuario= businessDelegatorView.obtenerIdRolUsuario(segUsuario.getSegRolUsuarios()); 
        	
        	 if (segUsuario!=null) {
                 final List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>(); 
                 Object datosRol[] = new Object[4];
                 datosRol[0]="segUsuario";
                 datosRol[1]=false;
                 datosRol[2]=segUsuario.getUsuId();
                 datosRol[3]="=";
                 
                 FacesUtils.putinSession("usuarioEnSession", segUsuario);
                 
                 List<SegRolUsuario> segRolUsuario = businessDelegatorView.findByCriteriaInSegRolUsuario(datosRol, null, null);
                 List<SegRol> segRol = new ArrayList<SegRol>();
                 
                 
                 for (SegRolUsuario segRolUsuario2 : segRolUsuario) {
					SegRol rol = businessDelegatorView.getSegRol(segRolUsuario2.getSegRol().getRolId());
					segRol.add(rol);
					grantedAuths.add(new SimpleGrantedAuthority("ROLE_"+rol.getNombre()));
				}
                 
                 FacesUtils.putinSession("rol", segRol);
                 
//                 grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
//                 grantedAuths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
                 //grantedAuths.add(new SimpleGrantedAuthority(usuarios.getTiposUsuarios().getTusuNombre()));
                 
                 
                 final UserDetails principal = new User(name, password, grantedAuths);
                 final Authentication auth = new UsernamePasswordAuthenticationToken(principal,password, grantedAuths);
                 
                 
                 
                 return auth;
        	 } else {
                 return null;
             }
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
      
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
