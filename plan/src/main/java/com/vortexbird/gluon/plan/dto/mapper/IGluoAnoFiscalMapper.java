package com.vortexbird.gluon.plan.dto.mapper;

import com.vortexbird.gluon.plan.modelo.GluoAnoFiscal;
import com.vortexbird.gluon.plan.modelo.dto.GluoAnoFiscalDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface IGluoAnoFiscalMapper {
    public GluoAnoFiscalDTO gluoAnoFiscalToGluoAnoFiscalDTO(
        GluoAnoFiscal gluoAnoFiscal) throws Exception;

    public GluoAnoFiscal gluoAnoFiscalDTOToGluoAnoFiscal(
        GluoAnoFiscalDTO gluoAnoFiscalDTO) throws Exception;

    public List<GluoAnoFiscalDTO> listGluoAnoFiscalToListGluoAnoFiscalDTO(
        List<GluoAnoFiscal> gluoAnoFiscals) throws Exception;

    public List<GluoAnoFiscal> listGluoAnoFiscalDTOToListGluoAnoFiscal(
        List<GluoAnoFiscalDTO> gluoAnoFiscalDTOs) throws Exception;
}
