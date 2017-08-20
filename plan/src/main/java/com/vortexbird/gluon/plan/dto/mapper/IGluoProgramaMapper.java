package com.vortexbird.gluon.plan.dto.mapper;

import com.vortexbird.gluon.plan.modelo.GluoPrograma;
import com.vortexbird.gluon.plan.modelo.dto.GluoProgramaDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface IGluoProgramaMapper {
    public GluoProgramaDTO gluoProgramaToGluoProgramaDTO(
        GluoPrograma gluoPrograma) throws Exception;

    public GluoPrograma gluoProgramaDTOToGluoPrograma(
        GluoProgramaDTO gluoProgramaDTO) throws Exception;

    public List<GluoProgramaDTO> listGluoProgramaToListGluoProgramaDTO(
        List<GluoPrograma> gluoProgramas) throws Exception;

    public List<GluoPrograma> listGluoProgramaDTOToListGluoPrograma(
        List<GluoProgramaDTO> gluoProgramaDTOs) throws Exception;
}
