package com.vortexbird.gluon.plan.dto.mapper;

import com.vortexbird.gluon.plan.modelo.SegUsuario;
import com.vortexbird.gluon.plan.modelo.dto.SegUsuarioDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface ISegUsuarioMapper {
    public SegUsuarioDTO segUsuarioToSegUsuarioDTO(SegUsuario segUsuario)
        throws Exception;

    public SegUsuario segUsuarioDTOToSegUsuario(SegUsuarioDTO segUsuarioDTO)
        throws Exception;

    public List<SegUsuarioDTO> listSegUsuarioToListSegUsuarioDTO(
        List<SegUsuario> segUsuarios) throws Exception;

    public List<SegUsuario> listSegUsuarioDTOToListSegUsuario(
        List<SegUsuarioDTO> segUsuarioDTOs) throws Exception;
}
