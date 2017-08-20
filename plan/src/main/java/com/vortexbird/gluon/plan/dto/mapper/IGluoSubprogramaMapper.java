package com.vortexbird.gluon.plan.dto.mapper;

import com.vortexbird.gluon.plan.modelo.GluoSubprograma;
import com.vortexbird.gluon.plan.modelo.dto.GluoSubprogramaDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface IGluoSubprogramaMapper {
    public GluoSubprogramaDTO gluoSubprogramaToGluoSubprogramaDTO(
        GluoSubprograma gluoSubprograma) throws Exception;

    public GluoSubprograma gluoSubprogramaDTOToGluoSubprograma(
        GluoSubprogramaDTO gluoSubprogramaDTO) throws Exception;

    public List<GluoSubprogramaDTO> listGluoSubprogramaToListGluoSubprogramaDTO(
        List<GluoSubprograma> gluoSubprogramas) throws Exception;

    public List<GluoSubprograma> listGluoSubprogramaDTOToListGluoSubprograma(
        List<GluoSubprogramaDTO> gluoSubprogramaDTOs) throws Exception;
}
