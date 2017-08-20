package com.vortexbird.gluon.plan.dto.mapper;

import com.vortexbird.gluon.plan.modelo.*;
import com.vortexbird.gluon.plan.modelo.GluoObjetivo;
import com.vortexbird.gluon.plan.modelo.control.*;
import com.vortexbird.gluon.plan.modelo.dto.GluoObjetivoDTO;

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
public class GluoObjetivoMapper implements IGluoObjetivoMapper {
    private static final Logger log = LoggerFactory.getLogger(GluoObjetivoMapper.class);

    /**
    * Logic injected by Spring that manages GluoSectorEjeDimension entities
    *
    */
    @Autowired
    IGluoSectorEjeDimensionLogic logicGluoSectorEjeDimension1;

    @Transactional(readOnly = true)
    public GluoObjetivoDTO gluoObjetivoToGluoObjetivoDTO(
        GluoObjetivo gluoObjetivo) throws Exception {
        try {
            GluoObjetivoDTO gluoObjetivoDTO = new GluoObjetivoDTO();

            gluoObjetivoDTO.setObjeId(gluoObjetivo.getObjeId());
            gluoObjetivoDTO.setActivo((gluoObjetivo.getActivo() != null)
                ? gluoObjetivo.getActivo() : null);
            gluoObjetivoDTO.setDescripcion((gluoObjetivo.getDescripcion() != null)
                ? gluoObjetivo.getDescripcion() : null);
            gluoObjetivoDTO.setFechaCreacion(gluoObjetivo.getFechaCreacion());
            gluoObjetivoDTO.setFechaModificacion(gluoObjetivo.getFechaModificacion());
            gluoObjetivoDTO.setUsuCreador((gluoObjetivo.getUsuCreador() != null)
                ? gluoObjetivo.getUsuCreador() : null);
            gluoObjetivoDTO.setUsuModificador((gluoObjetivo.getUsuModificador() != null)
                ? gluoObjetivo.getUsuModificador() : null);
            gluoObjetivoDTO.setSediId_GluoSectorEjeDimension((gluoObjetivo.getGluoSectorEjeDimension()
                                                                          .getSediId() != null)
                ? gluoObjetivo.getGluoSectorEjeDimension().getSediId() : null);

            return gluoObjetivoDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public GluoObjetivo gluoObjetivoDTOToGluoObjetivo(
        GluoObjetivoDTO gluoObjetivoDTO) throws Exception {
        try {
            GluoObjetivo gluoObjetivo = new GluoObjetivo();

            gluoObjetivo.setObjeId(gluoObjetivoDTO.getObjeId());
            gluoObjetivo.setActivo((gluoObjetivoDTO.getActivo() != null)
                ? gluoObjetivoDTO.getActivo() : null);
            gluoObjetivo.setDescripcion((gluoObjetivoDTO.getDescripcion() != null)
                ? gluoObjetivoDTO.getDescripcion() : null);
            gluoObjetivo.setFechaCreacion(gluoObjetivoDTO.getFechaCreacion());
            gluoObjetivo.setFechaModificacion(gluoObjetivoDTO.getFechaModificacion());
            gluoObjetivo.setUsuCreador((gluoObjetivoDTO.getUsuCreador() != null)
                ? gluoObjetivoDTO.getUsuCreador() : null);
            gluoObjetivo.setUsuModificador((gluoObjetivoDTO.getUsuModificador() != null)
                ? gluoObjetivoDTO.getUsuModificador() : null);

            GluoSectorEjeDimension gluoSectorEjeDimension = new GluoSectorEjeDimension();

            if (gluoObjetivoDTO.getSediId_GluoSectorEjeDimension() != null) {
                gluoSectorEjeDimension = logicGluoSectorEjeDimension1.getGluoSectorEjeDimension(gluoObjetivoDTO.getSediId_GluoSectorEjeDimension());
            }

            if (gluoSectorEjeDimension != null) {
                gluoObjetivo.setGluoSectorEjeDimension(gluoSectorEjeDimension);
            }

            return gluoObjetivo;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<GluoObjetivoDTO> listGluoObjetivoToListGluoObjetivoDTO(
        List<GluoObjetivo> listGluoObjetivo) throws Exception {
        try {
            List<GluoObjetivoDTO> gluoObjetivoDTOs = new ArrayList<GluoObjetivoDTO>();

            for (GluoObjetivo gluoObjetivo : listGluoObjetivo) {
                GluoObjetivoDTO gluoObjetivoDTO = gluoObjetivoToGluoObjetivoDTO(gluoObjetivo);

                gluoObjetivoDTOs.add(gluoObjetivoDTO);
            }

            return gluoObjetivoDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<GluoObjetivo> listGluoObjetivoDTOToListGluoObjetivo(
        List<GluoObjetivoDTO> listGluoObjetivoDTO) throws Exception {
        try {
            List<GluoObjetivo> listGluoObjetivo = new ArrayList<GluoObjetivo>();

            for (GluoObjetivoDTO gluoObjetivoDTO : listGluoObjetivoDTO) {
                GluoObjetivo gluoObjetivo = gluoObjetivoDTOToGluoObjetivo(gluoObjetivoDTO);

                listGluoObjetivo.add(gluoObjetivo);
            }

            return listGluoObjetivo;
        } catch (Exception e) {
            throw e;
        }
    }
}
