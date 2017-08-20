package com.vortexbird.gluon.plan.dto.mapper;

import com.vortexbird.gluon.plan.modelo.GluoIndicador;
import com.vortexbird.gluon.plan.modelo.dto.GluoIndicadorDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface IGluoIndicadorMapper {
    public GluoIndicadorDTO gluoIndicadorToGluoIndicadorDTO(
        GluoIndicador gluoIndicador) throws Exception;

    public GluoIndicador gluoIndicadorDTOToGluoIndicador(
        GluoIndicadorDTO gluoIndicadorDTO) throws Exception;

    public List<GluoIndicadorDTO> listGluoIndicadorToListGluoIndicadorDTO(
        List<GluoIndicador> gluoIndicadors) throws Exception;

    public List<GluoIndicador> listGluoIndicadorDTOToListGluoIndicador(
        List<GluoIndicadorDTO> gluoIndicadorDTOs) throws Exception;
}
