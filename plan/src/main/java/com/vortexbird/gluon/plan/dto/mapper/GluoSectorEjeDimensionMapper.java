package com.vortexbird.gluon.plan.dto.mapper;

import com.vortexbird.gluon.plan.modelo.*;
import com.vortexbird.gluon.plan.modelo.GluoSectorEjeDimension;
import com.vortexbird.gluon.plan.modelo.control.*;
import com.vortexbird.gluon.plan.modelo.dto.GluoSectorEjeDimensionDTO;

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
public class GluoSectorEjeDimensionMapper
    implements IGluoSectorEjeDimensionMapper {
    private static final Logger log = LoggerFactory.getLogger(GluoSectorEjeDimensionMapper.class);

    /**
    * Logic injected by Spring that manages GluoPlanDesarrollo entities
    *
    */
    @Autowired
    IGluoPlanDesarrolloLogic logicGluoPlanDesarrollo1;

    @Transactional(readOnly = true)
    public GluoSectorEjeDimensionDTO gluoSectorEjeDimensionToGluoSectorEjeDimensionDTO(
        GluoSectorEjeDimension gluoSectorEjeDimension)
        throws Exception {
        try {
            GluoSectorEjeDimensionDTO gluoSectorEjeDimensionDTO = new GluoSectorEjeDimensionDTO();

            gluoSectorEjeDimensionDTO.setSediId(gluoSectorEjeDimension.getSediId());
            gluoSectorEjeDimensionDTO.setActivo((gluoSectorEjeDimension.getActivo() != null)
                ? gluoSectorEjeDimension.getActivo() : null);
            gluoSectorEjeDimensionDTO.setDescripcion((gluoSectorEjeDimension.getDescripcion() != null)
                ? gluoSectorEjeDimension.getDescripcion() : null);
            gluoSectorEjeDimensionDTO.setFechaCreacion(gluoSectorEjeDimension.getFechaCreacion());
            gluoSectorEjeDimensionDTO.setFechaModificacion(gluoSectorEjeDimension.getFechaModificacion());
            gluoSectorEjeDimensionDTO.setUsuCreador((gluoSectorEjeDimension.getUsuCreador() != null)
                ? gluoSectorEjeDimension.getUsuCreador() : null);
            gluoSectorEjeDimensionDTO.setUsuModificador((gluoSectorEjeDimension.getUsuModificador() != null)
                ? gluoSectorEjeDimension.getUsuModificador() : null);
            gluoSectorEjeDimensionDTO.setPlanId_GluoPlanDesarrollo((gluoSectorEjeDimension.getGluoPlanDesarrollo()
                                                                                          .getPlanId() != null)
                ? gluoSectorEjeDimension.getGluoPlanDesarrollo().getPlanId()
                : null);

            return gluoSectorEjeDimensionDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public GluoSectorEjeDimension gluoSectorEjeDimensionDTOToGluoSectorEjeDimension(
        GluoSectorEjeDimensionDTO gluoSectorEjeDimensionDTO)
        throws Exception {
        try {
            GluoSectorEjeDimension gluoSectorEjeDimension = new GluoSectorEjeDimension();

            gluoSectorEjeDimension.setSediId(gluoSectorEjeDimensionDTO.getSediId());
            gluoSectorEjeDimension.setActivo((gluoSectorEjeDimensionDTO.getActivo() != null)
                ? gluoSectorEjeDimensionDTO.getActivo() : null);
            gluoSectorEjeDimension.setDescripcion((gluoSectorEjeDimensionDTO.getDescripcion() != null)
                ? gluoSectorEjeDimensionDTO.getDescripcion() : null);
            gluoSectorEjeDimension.setFechaCreacion(gluoSectorEjeDimensionDTO.getFechaCreacion());
            gluoSectorEjeDimension.setFechaModificacion(gluoSectorEjeDimensionDTO.getFechaModificacion());
            gluoSectorEjeDimension.setUsuCreador((gluoSectorEjeDimensionDTO.getUsuCreador() != null)
                ? gluoSectorEjeDimensionDTO.getUsuCreador() : null);
            gluoSectorEjeDimension.setUsuModificador((gluoSectorEjeDimensionDTO.getUsuModificador() != null)
                ? gluoSectorEjeDimensionDTO.getUsuModificador() : null);

            GluoPlanDesarrollo gluoPlanDesarrollo = new GluoPlanDesarrollo();

            if (gluoSectorEjeDimensionDTO.getPlanId_GluoPlanDesarrollo() != null) {
                gluoPlanDesarrollo = logicGluoPlanDesarrollo1.getGluoPlanDesarrollo(gluoSectorEjeDimensionDTO.getPlanId_GluoPlanDesarrollo());
            }

            if (gluoPlanDesarrollo != null) {
                gluoSectorEjeDimension.setGluoPlanDesarrollo(gluoPlanDesarrollo);
            }

            return gluoSectorEjeDimension;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<GluoSectorEjeDimensionDTO> listGluoSectorEjeDimensionToListGluoSectorEjeDimensionDTO(
        List<GluoSectorEjeDimension> listGluoSectorEjeDimension)
        throws Exception {
        try {
            List<GluoSectorEjeDimensionDTO> gluoSectorEjeDimensionDTOs = new ArrayList<GluoSectorEjeDimensionDTO>();

            for (GluoSectorEjeDimension gluoSectorEjeDimension : listGluoSectorEjeDimension) {
                GluoSectorEjeDimensionDTO gluoSectorEjeDimensionDTO = gluoSectorEjeDimensionToGluoSectorEjeDimensionDTO(gluoSectorEjeDimension);

                gluoSectorEjeDimensionDTOs.add(gluoSectorEjeDimensionDTO);
            }

            return gluoSectorEjeDimensionDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<GluoSectorEjeDimension> listGluoSectorEjeDimensionDTOToListGluoSectorEjeDimension(
        List<GluoSectorEjeDimensionDTO> listGluoSectorEjeDimensionDTO)
        throws Exception {
        try {
            List<GluoSectorEjeDimension> listGluoSectorEjeDimension = new ArrayList<GluoSectorEjeDimension>();

            for (GluoSectorEjeDimensionDTO gluoSectorEjeDimensionDTO : listGluoSectorEjeDimensionDTO) {
                GluoSectorEjeDimension gluoSectorEjeDimension = gluoSectorEjeDimensionDTOToGluoSectorEjeDimension(gluoSectorEjeDimensionDTO);

                listGluoSectorEjeDimension.add(gluoSectorEjeDimension);
            }

            return listGluoSectorEjeDimension;
        } catch (Exception e) {
            throw e;
        }
    }
}
