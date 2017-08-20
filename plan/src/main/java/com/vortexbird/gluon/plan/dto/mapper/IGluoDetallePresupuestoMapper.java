package com.vortexbird.gluon.plan.dto.mapper;

import com.vortexbird.gluon.plan.modelo.GluoDetallePresupuesto;
import com.vortexbird.gluon.plan.modelo.dto.GluoDetallePresupuestoDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface IGluoDetallePresupuestoMapper {
    public GluoDetallePresupuestoDTO gluoDetallePresupuestoToGluoDetallePresupuestoDTO(
        GluoDetallePresupuesto gluoDetallePresupuesto)
        throws Exception;

    public GluoDetallePresupuesto gluoDetallePresupuestoDTOToGluoDetallePresupuesto(
        GluoDetallePresupuestoDTO gluoDetallePresupuestoDTO)
        throws Exception;

    public List<GluoDetallePresupuestoDTO> listGluoDetallePresupuestoToListGluoDetallePresupuestoDTO(
        List<GluoDetallePresupuesto> gluoDetallePresupuestos)
        throws Exception;

    public List<GluoDetallePresupuesto> listGluoDetallePresupuestoDTOToListGluoDetallePresupuesto(
        List<GluoDetallePresupuestoDTO> gluoDetallePresupuestoDTOs)
        throws Exception;
}
