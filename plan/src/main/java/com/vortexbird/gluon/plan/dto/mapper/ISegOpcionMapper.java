package com.vortexbird.gluon.plan.dto.mapper;

import com.vortexbird.gluon.plan.modelo.SegOpcion;
import com.vortexbird.gluon.plan.modelo.dto.SegOpcionDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface ISegOpcionMapper {
    public SegOpcionDTO segOpcionToSegOpcionDTO(SegOpcion segOpcion)
        throws Exception;

    public SegOpcion segOpcionDTOToSegOpcion(SegOpcionDTO segOpcionDTO)
        throws Exception;

    public List<SegOpcionDTO> listSegOpcionToListSegOpcionDTO(
        List<SegOpcion> segOpcions) throws Exception;

    public List<SegOpcion> listSegOpcionDTOToListSegOpcion(
        List<SegOpcionDTO> segOpcionDTOs) throws Exception;
}
