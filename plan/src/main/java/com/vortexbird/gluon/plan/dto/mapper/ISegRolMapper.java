package com.vortexbird.gluon.plan.dto.mapper;

import com.vortexbird.gluon.plan.modelo.SegRol;
import com.vortexbird.gluon.plan.modelo.dto.SegRolDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface ISegRolMapper {
    public SegRolDTO segRolToSegRolDTO(SegRol segRol) throws Exception;

    public SegRol segRolDTOToSegRol(SegRolDTO segRolDTO)
        throws Exception;

    public List<SegRolDTO> listSegRolToListSegRolDTO(List<SegRol> segRols)
        throws Exception;

    public List<SegRol> listSegRolDTOToListSegRol(List<SegRolDTO> segRolDTOs)
        throws Exception;
}
