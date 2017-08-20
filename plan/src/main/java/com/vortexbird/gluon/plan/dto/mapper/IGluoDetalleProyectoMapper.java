package com.vortexbird.gluon.plan.dto.mapper;

import com.vortexbird.gluon.plan.modelo.GluoDetalleProyecto;
import com.vortexbird.gluon.plan.modelo.dto.GluoDetalleProyectoDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface IGluoDetalleProyectoMapper {
    public GluoDetalleProyectoDTO gluoDetalleProyectoToGluoDetalleProyectoDTO(
        GluoDetalleProyecto gluoDetalleProyecto) throws Exception;

    public GluoDetalleProyecto gluoDetalleProyectoDTOToGluoDetalleProyecto(
        GluoDetalleProyectoDTO gluoDetalleProyectoDTO)
        throws Exception;

    public List<GluoDetalleProyectoDTO> listGluoDetalleProyectoToListGluoDetalleProyectoDTO(
        List<GluoDetalleProyecto> gluoDetalleProyectos)
        throws Exception;

    public List<GluoDetalleProyecto> listGluoDetalleProyectoDTOToListGluoDetalleProyecto(
        List<GluoDetalleProyectoDTO> gluoDetalleProyectoDTOs)
        throws Exception;
}
