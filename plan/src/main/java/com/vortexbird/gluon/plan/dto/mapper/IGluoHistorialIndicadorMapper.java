package com.vortexbird.gluon.plan.dto.mapper;

import com.vortexbird.gluon.plan.modelo.GluoHistorialIndicador;
import com.vortexbird.gluon.plan.modelo.dto.GluoHistorialIndicadorDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface IGluoHistorialIndicadorMapper {
    public GluoHistorialIndicadorDTO gluoHistorialIndicadorToGluoHistorialIndicadorDTO(
        GluoHistorialIndicador gluoHistorialIndicador)
        throws Exception;

    public GluoHistorialIndicador gluoHistorialIndicadorDTOToGluoHistorialIndicador(
        GluoHistorialIndicadorDTO gluoHistorialIndicadorDTO)
        throws Exception;

    public List<GluoHistorialIndicadorDTO> listGluoHistorialIndicadorToListGluoHistorialIndicadorDTO(
        List<GluoHistorialIndicador> gluoHistorialIndicadors)
        throws Exception;

    public List<GluoHistorialIndicador> listGluoHistorialIndicadorDTOToListGluoHistorialIndicador(
        List<GluoHistorialIndicadorDTO> gluoHistorialIndicadorDTOs)
        throws Exception;
}
