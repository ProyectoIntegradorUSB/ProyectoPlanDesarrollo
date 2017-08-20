package com.vortexbird.gluon.plan.dto.mapper;

import com.vortexbird.gluon.plan.modelo.SegRolUsuario;
import com.vortexbird.gluon.plan.modelo.dto.SegRolUsuarioDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface ISegRolUsuarioMapper {
    public SegRolUsuarioDTO segRolUsuarioToSegRolUsuarioDTO(
        SegRolUsuario segRolUsuario) throws Exception;

    public SegRolUsuario segRolUsuarioDTOToSegRolUsuario(
        SegRolUsuarioDTO segRolUsuarioDTO) throws Exception;

    public List<SegRolUsuarioDTO> listSegRolUsuarioToListSegRolUsuarioDTO(
        List<SegRolUsuario> segRolUsuarios) throws Exception;

    public List<SegRolUsuario> listSegRolUsuarioDTOToListSegRolUsuario(
        List<SegRolUsuarioDTO> segRolUsuarioDTOs) throws Exception;
}
