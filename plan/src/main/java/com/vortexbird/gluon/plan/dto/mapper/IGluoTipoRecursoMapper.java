package com.vortexbird.gluon.plan.dto.mapper;

import com.vortexbird.gluon.plan.modelo.GluoTipoRecurso;
import com.vortexbird.gluon.plan.modelo.dto.GluoTipoRecursoDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface IGluoTipoRecursoMapper {
    public GluoTipoRecursoDTO gluoTipoRecursoToGluoTipoRecursoDTO(
        GluoTipoRecurso gluoTipoRecurso) throws Exception;

    public GluoTipoRecurso gluoTipoRecursoDTOToGluoTipoRecurso(
        GluoTipoRecursoDTO gluoTipoRecursoDTO) throws Exception;

    public List<GluoTipoRecursoDTO> listGluoTipoRecursoToListGluoTipoRecursoDTO(
        List<GluoTipoRecurso> gluoTipoRecursos) throws Exception;

    public List<GluoTipoRecurso> listGluoTipoRecursoDTOToListGluoTipoRecurso(
        List<GluoTipoRecursoDTO> gluoTipoRecursoDTOs) throws Exception;
}
