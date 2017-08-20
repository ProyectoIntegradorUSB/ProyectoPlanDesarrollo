package com.vortexbird.gluon.plan.dto.mapper;

import com.vortexbird.gluon.plan.modelo.GluoPlanDesarrollo;
import com.vortexbird.gluon.plan.modelo.dto.GluoPlanDesarrolloDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface IGluoPlanDesarrolloMapper {
    public GluoPlanDesarrolloDTO gluoPlanDesarrolloToGluoPlanDesarrolloDTO(
        GluoPlanDesarrollo gluoPlanDesarrollo) throws Exception;

    public GluoPlanDesarrollo gluoPlanDesarrolloDTOToGluoPlanDesarrollo(
        GluoPlanDesarrolloDTO gluoPlanDesarrolloDTO) throws Exception;

    public List<GluoPlanDesarrolloDTO> listGluoPlanDesarrolloToListGluoPlanDesarrolloDTO(
        List<GluoPlanDesarrollo> gluoPlanDesarrollos) throws Exception;

    public List<GluoPlanDesarrollo> listGluoPlanDesarrolloDTOToListGluoPlanDesarrollo(
        List<GluoPlanDesarrolloDTO> gluoPlanDesarrolloDTOs)
        throws Exception;
}
