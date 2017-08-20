package com.vortexbird.gluon.plan.dto.mapper;

import com.vortexbird.gluon.plan.modelo.*;
import com.vortexbird.gluon.plan.modelo.GluoDetalleProyecto;
import com.vortexbird.gluon.plan.modelo.control.*;
import com.vortexbird.gluon.plan.modelo.dto.GluoDetalleProyectoDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
@Component
@Scope("singleton")
public class GluoDetalleProyectoMapper implements IGluoDetalleProyectoMapper {
    private static final Logger log = LoggerFactory.getLogger(GluoDetalleProyectoMapper.class);

    /**
    * Logic injected by Spring that manages GluoAnoFiscal entities
    *
    */
    @Autowired
    IGluoAnoFiscalLogic logicGluoAnoFiscal1;

    /**
    * Logic injected by Spring that manages GluoProyecto entities
    *
    */
    @Autowired
    IGluoProyectoLogic logicGluoProyecto2;

    @Transactional(readOnly = true)
    public GluoDetalleProyectoDTO gluoDetalleProyectoToGluoDetalleProyectoDTO(
        GluoDetalleProyecto gluoDetalleProyecto) throws Exception {
        try {
            GluoDetalleProyectoDTO gluoDetalleProyectoDTO = new GluoDetalleProyectoDTO();

            gluoDetalleProyectoDTO.setDproId(gluoDetalleProyecto.getDproId());
            gluoDetalleProyectoDTO.setActivo((gluoDetalleProyecto.getActivo() != null)
                ? gluoDetalleProyecto.getActivo() : null);
            gluoDetalleProyectoDTO.setFechaCreacion(gluoDetalleProyecto.getFechaCreacion());
            gluoDetalleProyectoDTO.setFechaModificacion(gluoDetalleProyecto.getFechaModificacion());
            gluoDetalleProyectoDTO.setUsuCreador((gluoDetalleProyecto.getUsuCreador() != null)
                ? gluoDetalleProyecto.getUsuCreador() : null);
            gluoDetalleProyectoDTO.setUsuModificador((gluoDetalleProyecto.getUsuModificador() != null)
                ? gluoDetalleProyecto.getUsuModificador() : null);
            gluoDetalleProyectoDTO.setValorTotalPresupuesto((gluoDetalleProyecto.getValorTotalPresupuesto() != null)
                ? gluoDetalleProyecto.getValorTotalPresupuesto() : null);
            gluoDetalleProyectoDTO.setAnofId_GluoAnoFiscal((gluoDetalleProyecto.getGluoAnoFiscal()
                                                                               .getAnofId() != null)
                ? gluoDetalleProyecto.getGluoAnoFiscal().getAnofId() : null);
            gluoDetalleProyectoDTO.setProyId_GluoProyecto((gluoDetalleProyecto.getGluoProyecto()
                                                                              .getProyId() != null)
                ? gluoDetalleProyecto.getGluoProyecto().getProyId() : null);

            return gluoDetalleProyectoDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public GluoDetalleProyecto gluoDetalleProyectoDTOToGluoDetalleProyecto(
        GluoDetalleProyectoDTO gluoDetalleProyectoDTO)
        throws Exception {
        try {
            GluoDetalleProyecto gluoDetalleProyecto = new GluoDetalleProyecto();

            gluoDetalleProyecto.setDproId(gluoDetalleProyectoDTO.getDproId());
            gluoDetalleProyecto.setActivo((gluoDetalleProyectoDTO.getActivo() != null)
                ? gluoDetalleProyectoDTO.getActivo() : null);
            gluoDetalleProyecto.setFechaCreacion(gluoDetalleProyectoDTO.getFechaCreacion());
            gluoDetalleProyecto.setFechaModificacion(gluoDetalleProyectoDTO.getFechaModificacion());
            gluoDetalleProyecto.setUsuCreador((gluoDetalleProyectoDTO.getUsuCreador() != null)
                ? gluoDetalleProyectoDTO.getUsuCreador() : null);
            gluoDetalleProyecto.setUsuModificador((gluoDetalleProyectoDTO.getUsuModificador() != null)
                ? gluoDetalleProyectoDTO.getUsuModificador() : null);
            gluoDetalleProyecto.setValorTotalPresupuesto((gluoDetalleProyectoDTO.getValorTotalPresupuesto() != null)
                ? gluoDetalleProyectoDTO.getValorTotalPresupuesto() : null);

            GluoAnoFiscal gluoAnoFiscal = new GluoAnoFiscal();

            if (gluoDetalleProyectoDTO.getAnofId_GluoAnoFiscal() != null) {
                gluoAnoFiscal = logicGluoAnoFiscal1.getGluoAnoFiscal(gluoDetalleProyectoDTO.getAnofId_GluoAnoFiscal());
            }

            if (gluoAnoFiscal != null) {
                gluoDetalleProyecto.setGluoAnoFiscal(gluoAnoFiscal);
            }

            GluoProyecto gluoProyecto = new GluoProyecto();

            if (gluoDetalleProyectoDTO.getProyId_GluoProyecto() != null) {
                gluoProyecto = logicGluoProyecto2.getGluoProyecto(gluoDetalleProyectoDTO.getProyId_GluoProyecto());
            }

            if (gluoProyecto != null) {
                gluoDetalleProyecto.setGluoProyecto(gluoProyecto);
            }

            return gluoDetalleProyecto;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<GluoDetalleProyectoDTO> listGluoDetalleProyectoToListGluoDetalleProyectoDTO(
        List<GluoDetalleProyecto> listGluoDetalleProyecto)
        throws Exception {
        try {
            List<GluoDetalleProyectoDTO> gluoDetalleProyectoDTOs = new ArrayList<GluoDetalleProyectoDTO>();

            for (GluoDetalleProyecto gluoDetalleProyecto : listGluoDetalleProyecto) {
                GluoDetalleProyectoDTO gluoDetalleProyectoDTO = gluoDetalleProyectoToGluoDetalleProyectoDTO(gluoDetalleProyecto);

                gluoDetalleProyectoDTOs.add(gluoDetalleProyectoDTO);
            }

            return gluoDetalleProyectoDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<GluoDetalleProyecto> listGluoDetalleProyectoDTOToListGluoDetalleProyecto(
        List<GluoDetalleProyectoDTO> listGluoDetalleProyectoDTO)
        throws Exception {
        try {
            List<GluoDetalleProyecto> listGluoDetalleProyecto = new ArrayList<GluoDetalleProyecto>();

            for (GluoDetalleProyectoDTO gluoDetalleProyectoDTO : listGluoDetalleProyectoDTO) {
                GluoDetalleProyecto gluoDetalleProyecto = gluoDetalleProyectoDTOToGluoDetalleProyecto(gluoDetalleProyectoDTO);

                listGluoDetalleProyecto.add(gluoDetalleProyecto);
            }

            return listGluoDetalleProyecto;
        } catch (Exception e) {
            throw e;
        }
    }
}
