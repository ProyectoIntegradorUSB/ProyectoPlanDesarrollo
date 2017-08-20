package com.vortexbird.gluon.plan.dto.mapper;

import com.vortexbird.gluon.plan.modelo.GluoSectorEjeDimension;
import com.vortexbird.gluon.plan.modelo.dto.GluoSectorEjeDimensionDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface IGluoSectorEjeDimensionMapper {
    public GluoSectorEjeDimensionDTO gluoSectorEjeDimensionToGluoSectorEjeDimensionDTO(
        GluoSectorEjeDimension gluoSectorEjeDimension)
        throws Exception;

    public GluoSectorEjeDimension gluoSectorEjeDimensionDTOToGluoSectorEjeDimension(
        GluoSectorEjeDimensionDTO gluoSectorEjeDimensionDTO)
        throws Exception;

    public List<GluoSectorEjeDimensionDTO> listGluoSectorEjeDimensionToListGluoSectorEjeDimensionDTO(
        List<GluoSectorEjeDimension> gluoSectorEjeDimensions)
        throws Exception;

    public List<GluoSectorEjeDimension> listGluoSectorEjeDimensionDTOToListGluoSectorEjeDimension(
        List<GluoSectorEjeDimensionDTO> gluoSectorEjeDimensionDTOs)
        throws Exception;
}
