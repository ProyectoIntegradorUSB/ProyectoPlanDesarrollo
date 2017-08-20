package com.vortexbird.gluon.plan.dto.mapper;

import com.vortexbird.gluon.plan.modelo.GluoPresupuesto;
import com.vortexbird.gluon.plan.modelo.dto.GluoPresupuestoDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface IGluoPresupuestoMapper {
    public GluoPresupuestoDTO gluoPresupuestoToGluoPresupuestoDTO(
        GluoPresupuesto gluoPresupuesto) throws Exception;

    public GluoPresupuesto gluoPresupuestoDTOToGluoPresupuesto(
        GluoPresupuestoDTO gluoPresupuestoDTO) throws Exception;

    public List<GluoPresupuestoDTO> listGluoPresupuestoToListGluoPresupuestoDTO(
        List<GluoPresupuesto> gluoPresupuestos) throws Exception;

    public List<GluoPresupuesto> listGluoPresupuestoDTOToListGluoPresupuesto(
        List<GluoPresupuestoDTO> gluoPresupuestoDTOs) throws Exception;
}
