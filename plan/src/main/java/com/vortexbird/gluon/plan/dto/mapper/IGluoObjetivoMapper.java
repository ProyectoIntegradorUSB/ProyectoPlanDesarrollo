package com.vortexbird.gluon.plan.dto.mapper;

import com.vortexbird.gluon.plan.modelo.GluoObjetivo;
import com.vortexbird.gluon.plan.modelo.dto.GluoObjetivoDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface IGluoObjetivoMapper {
    public GluoObjetivoDTO gluoObjetivoToGluoObjetivoDTO(
        GluoObjetivo gluoObjetivo) throws Exception;

    public GluoObjetivo gluoObjetivoDTOToGluoObjetivo(
        GluoObjetivoDTO gluoObjetivoDTO) throws Exception;

    public List<GluoObjetivoDTO> listGluoObjetivoToListGluoObjetivoDTO(
        List<GluoObjetivo> gluoObjetivos) throws Exception;

    public List<GluoObjetivo> listGluoObjetivoDTOToListGluoObjetivo(
        List<GluoObjetivoDTO> gluoObjetivoDTOs) throws Exception;
}
