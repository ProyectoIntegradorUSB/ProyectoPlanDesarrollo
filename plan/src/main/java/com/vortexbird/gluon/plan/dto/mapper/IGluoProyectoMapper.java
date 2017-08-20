package com.vortexbird.gluon.plan.dto.mapper;

import com.vortexbird.gluon.plan.modelo.GluoProyecto;
import com.vortexbird.gluon.plan.modelo.dto.GluoProyectoDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface IGluoProyectoMapper {
    public GluoProyectoDTO gluoProyectoToGluoProyectoDTO(
        GluoProyecto gluoProyecto) throws Exception;

    public GluoProyecto gluoProyectoDTOToGluoProyecto(
        GluoProyectoDTO gluoProyectoDTO) throws Exception;

    public List<GluoProyectoDTO> listGluoProyectoToListGluoProyectoDTO(
        List<GluoProyecto> gluoProyectos) throws Exception;

    public List<GluoProyecto> listGluoProyectoDTOToListGluoProyecto(
        List<GluoProyectoDTO> gluoProyectoDTOs) throws Exception;
}
