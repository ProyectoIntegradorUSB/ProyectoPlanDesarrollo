package com.vortexbird.gluon.plan.dto.mapper;

import com.vortexbird.gluon.plan.modelo.*;
import com.vortexbird.gluon.plan.modelo.GluoPresupuesto;
import com.vortexbird.gluon.plan.modelo.control.*;
import com.vortexbird.gluon.plan.modelo.dto.GluoPresupuestoDTO;

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
public class GluoPresupuestoMapper implements IGluoPresupuestoMapper {
    private static final Logger log = LoggerFactory.getLogger(GluoPresupuestoMapper.class);

    /**
    * Logic injected by Spring that manages GluoAnoFiscal entities
    *
    */
    @Autowired
    IGluoAnoFiscalLogic logicGluoAnoFiscal1;

    @Transactional(readOnly = true)
    public GluoPresupuestoDTO gluoPresupuestoToGluoPresupuestoDTO(
        GluoPresupuesto gluoPresupuesto) throws Exception {
        try {
            GluoPresupuestoDTO gluoPresupuestoDTO = new GluoPresupuestoDTO();

            gluoPresupuestoDTO.setPptoId(gluoPresupuesto.getPptoId());
            gluoPresupuestoDTO.setActivo((gluoPresupuesto.getActivo() != null)
                ? gluoPresupuesto.getActivo() : null);
            gluoPresupuestoDTO.setAprobado((gluoPresupuesto.getAprobado() != null)
                ? gluoPresupuesto.getAprobado() : null);
            gluoPresupuestoDTO.setContabilizado((gluoPresupuesto.getContabilizado() != null)
                ? gluoPresupuesto.getContabilizado() : null);
            gluoPresupuestoDTO.setFechaCreacion(gluoPresupuesto.getFechaCreacion());
            gluoPresupuestoDTO.setFechaModificacion(gluoPresupuesto.getFechaModificacion());
            gluoPresupuestoDTO.setTippId((gluoPresupuesto.getTippId() != null)
                ? gluoPresupuesto.getTippId() : null);
            gluoPresupuestoDTO.setUsuAprobador((gluoPresupuesto.getUsuAprobador() != null)
                ? gluoPresupuesto.getUsuAprobador() : null);
            gluoPresupuestoDTO.setUsuCreador((gluoPresupuesto.getUsuCreador() != null)
                ? gluoPresupuesto.getUsuCreador() : null);
            gluoPresupuestoDTO.setUsuModificador((gluoPresupuesto.getUsuModificador() != null)
                ? gluoPresupuesto.getUsuModificador() : null);
            gluoPresupuestoDTO.setAnofId_GluoAnoFiscal((gluoPresupuesto.getGluoAnoFiscal()
                                                                       .getAnofId() != null)
                ? gluoPresupuesto.getGluoAnoFiscal().getAnofId() : null);

            return gluoPresupuestoDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public GluoPresupuesto gluoPresupuestoDTOToGluoPresupuesto(
        GluoPresupuestoDTO gluoPresupuestoDTO) throws Exception {
        try {
            GluoPresupuesto gluoPresupuesto = new GluoPresupuesto();

            gluoPresupuesto.setPptoId(gluoPresupuestoDTO.getPptoId());
            gluoPresupuesto.setActivo((gluoPresupuestoDTO.getActivo() != null)
                ? gluoPresupuestoDTO.getActivo() : null);
            gluoPresupuesto.setAprobado((gluoPresupuestoDTO.getAprobado() != null)
                ? gluoPresupuestoDTO.getAprobado() : null);
            gluoPresupuesto.setContabilizado((gluoPresupuestoDTO.getContabilizado() != null)
                ? gluoPresupuestoDTO.getContabilizado() : null);
            gluoPresupuesto.setFechaCreacion(gluoPresupuestoDTO.getFechaCreacion());
            gluoPresupuesto.setFechaModificacion(gluoPresupuestoDTO.getFechaModificacion());
            gluoPresupuesto.setTippId((gluoPresupuestoDTO.getTippId() != null)
                ? gluoPresupuestoDTO.getTippId() : null);
            gluoPresupuesto.setUsuAprobador((gluoPresupuestoDTO.getUsuAprobador() != null)
                ? gluoPresupuestoDTO.getUsuAprobador() : null);
            gluoPresupuesto.setUsuCreador((gluoPresupuestoDTO.getUsuCreador() != null)
                ? gluoPresupuestoDTO.getUsuCreador() : null);
            gluoPresupuesto.setUsuModificador((gluoPresupuestoDTO.getUsuModificador() != null)
                ? gluoPresupuestoDTO.getUsuModificador() : null);

            GluoAnoFiscal gluoAnoFiscal = new GluoAnoFiscal();

            if (gluoPresupuestoDTO.getAnofId_GluoAnoFiscal() != null) {
                gluoAnoFiscal = logicGluoAnoFiscal1.getGluoAnoFiscal(gluoPresupuestoDTO.getAnofId_GluoAnoFiscal());
            }

            if (gluoAnoFiscal != null) {
                gluoPresupuesto.setGluoAnoFiscal(gluoAnoFiscal);
            }

            return gluoPresupuesto;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<GluoPresupuestoDTO> listGluoPresupuestoToListGluoPresupuestoDTO(
        List<GluoPresupuesto> listGluoPresupuesto) throws Exception {
        try {
            List<GluoPresupuestoDTO> gluoPresupuestoDTOs = new ArrayList<GluoPresupuestoDTO>();

            for (GluoPresupuesto gluoPresupuesto : listGluoPresupuesto) {
                GluoPresupuestoDTO gluoPresupuestoDTO = gluoPresupuestoToGluoPresupuestoDTO(gluoPresupuesto);

                gluoPresupuestoDTOs.add(gluoPresupuestoDTO);
            }

            return gluoPresupuestoDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<GluoPresupuesto> listGluoPresupuestoDTOToListGluoPresupuesto(
        List<GluoPresupuestoDTO> listGluoPresupuestoDTO)
        throws Exception {
        try {
            List<GluoPresupuesto> listGluoPresupuesto = new ArrayList<GluoPresupuesto>();

            for (GluoPresupuestoDTO gluoPresupuestoDTO : listGluoPresupuestoDTO) {
                GluoPresupuesto gluoPresupuesto = gluoPresupuestoDTOToGluoPresupuesto(gluoPresupuestoDTO);

                listGluoPresupuesto.add(gluoPresupuesto);
            }

            return listGluoPresupuesto;
        } catch (Exception e) {
            throw e;
        }
    }
}
