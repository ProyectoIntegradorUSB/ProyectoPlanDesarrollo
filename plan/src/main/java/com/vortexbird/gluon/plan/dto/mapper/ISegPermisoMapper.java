package com.vortexbird.gluon.plan.dto.mapper;

import com.vortexbird.gluon.plan.modelo.SegPermiso;
import com.vortexbird.gluon.plan.modelo.dto.SegPermisoDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface ISegPermisoMapper {
    public SegPermisoDTO segPermisoToSegPermisoDTO(SegPermiso segPermiso)
        throws Exception;

    public SegPermiso segPermisoDTOToSegPermiso(SegPermisoDTO segPermisoDTO)
        throws Exception;

    public List<SegPermisoDTO> listSegPermisoToListSegPermisoDTO(
        List<SegPermiso> segPermisos) throws Exception;

    public List<SegPermiso> listSegPermisoDTOToListSegPermiso(
        List<SegPermisoDTO> segPermisoDTOs) throws Exception;
}
