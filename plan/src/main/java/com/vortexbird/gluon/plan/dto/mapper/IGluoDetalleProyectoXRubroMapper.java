package com.vortexbird.gluon.plan.dto.mapper;

import com.vortexbird.gluon.plan.modelo.GluoDetalleProyectoXRubro;
import com.vortexbird.gluon.plan.modelo.dto.GluoDetalleProyectoXRubroDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface IGluoDetalleProyectoXRubroMapper {
    public GluoDetalleProyectoXRubroDTO gluoDetalleProyectoXRubroToGluoDetalleProyectoXRubroDTO(
        GluoDetalleProyectoXRubro gluoDetalleProyectoXRubro)
        throws Exception;

    public GluoDetalleProyectoXRubro gluoDetalleProyectoXRubroDTOToGluoDetalleProyectoXRubro(
        GluoDetalleProyectoXRubroDTO gluoDetalleProyectoXRubroDTO)
        throws Exception;

    public List<GluoDetalleProyectoXRubroDTO> listGluoDetalleProyectoXRubroToListGluoDetalleProyectoXRubroDTO(
        List<GluoDetalleProyectoXRubro> gluoDetalleProyectoXRubros)
        throws Exception;

    public List<GluoDetalleProyectoXRubro> listGluoDetalleProyectoXRubroDTOToListGluoDetalleProyectoXRubro(
        List<GluoDetalleProyectoXRubroDTO> gluoDetalleProyectoXRubroDTOs)
        throws Exception;
}
