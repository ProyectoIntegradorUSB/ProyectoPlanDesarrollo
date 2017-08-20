package com.vortexbird.gluon.plan.dto.mapper;

import com.vortexbird.gluon.plan.modelo.*;
import com.vortexbird.gluon.plan.modelo.GluoPrograma;
import com.vortexbird.gluon.plan.modelo.control.*;
import com.vortexbird.gluon.plan.modelo.dto.GluoProgramaDTO;

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
public class GluoProgramaMapper implements IGluoProgramaMapper {
    private static final Logger log = LoggerFactory.getLogger(GluoProgramaMapper.class);

    /**
    * Logic injected by Spring that manages GluoObjetivo entities
    *
    */
    @Autowired
    IGluoObjetivoLogic logicGluoObjetivo1;

    @Transactional(readOnly = true)
    public GluoProgramaDTO gluoProgramaToGluoProgramaDTO(
        GluoPrograma gluoPrograma) throws Exception {
        try {
            GluoProgramaDTO gluoProgramaDTO = new GluoProgramaDTO();

            gluoProgramaDTO.setProgId(gluoPrograma.getProgId());
            gluoProgramaDTO.setActivo((gluoPrograma.getActivo() != null)
                ? gluoPrograma.getActivo() : null);
            gluoProgramaDTO.setDescripcion((gluoPrograma.getDescripcion() != null)
                ? gluoPrograma.getDescripcion() : null);
            gluoProgramaDTO.setFechaCreacion(gluoPrograma.getFechaCreacion());
            gluoProgramaDTO.setFechaModificacion(gluoPrograma.getFechaModificacion());
            gluoProgramaDTO.setUsuCreador((gluoPrograma.getUsuCreador() != null)
                ? gluoPrograma.getUsuCreador() : null);
            gluoProgramaDTO.setUsuModificador((gluoPrograma.getUsuModificador() != null)
                ? gluoPrograma.getUsuModificador() : null);
            gluoProgramaDTO.setObjeId_GluoObjetivo((gluoPrograma.getGluoObjetivo()
                                                                .getObjeId() != null)
                ? gluoPrograma.getGluoObjetivo().getObjeId() : null);

            return gluoProgramaDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public GluoPrograma gluoProgramaDTOToGluoPrograma(
        GluoProgramaDTO gluoProgramaDTO) throws Exception {
        try {
            GluoPrograma gluoPrograma = new GluoPrograma();

            gluoPrograma.setProgId(gluoProgramaDTO.getProgId());
            gluoPrograma.setActivo((gluoProgramaDTO.getActivo() != null)
                ? gluoProgramaDTO.getActivo() : null);
            gluoPrograma.setDescripcion((gluoProgramaDTO.getDescripcion() != null)
                ? gluoProgramaDTO.getDescripcion() : null);
            gluoPrograma.setFechaCreacion(gluoProgramaDTO.getFechaCreacion());
            gluoPrograma.setFechaModificacion(gluoProgramaDTO.getFechaModificacion());
            gluoPrograma.setUsuCreador((gluoProgramaDTO.getUsuCreador() != null)
                ? gluoProgramaDTO.getUsuCreador() : null);
            gluoPrograma.setUsuModificador((gluoProgramaDTO.getUsuModificador() != null)
                ? gluoProgramaDTO.getUsuModificador() : null);

            GluoObjetivo gluoObjetivo = new GluoObjetivo();

            if (gluoProgramaDTO.getObjeId_GluoObjetivo() != null) {
                gluoObjetivo = logicGluoObjetivo1.getGluoObjetivo(gluoProgramaDTO.getObjeId_GluoObjetivo());
            }

            if (gluoObjetivo != null) {
                gluoPrograma.setGluoObjetivo(gluoObjetivo);
            }

            return gluoPrograma;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<GluoProgramaDTO> listGluoProgramaToListGluoProgramaDTO(
        List<GluoPrograma> listGluoPrograma) throws Exception {
        try {
            List<GluoProgramaDTO> gluoProgramaDTOs = new ArrayList<GluoProgramaDTO>();

            for (GluoPrograma gluoPrograma : listGluoPrograma) {
                GluoProgramaDTO gluoProgramaDTO = gluoProgramaToGluoProgramaDTO(gluoPrograma);

                gluoProgramaDTOs.add(gluoProgramaDTO);
            }

            return gluoProgramaDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<GluoPrograma> listGluoProgramaDTOToListGluoPrograma(
        List<GluoProgramaDTO> listGluoProgramaDTO) throws Exception {
        try {
            List<GluoPrograma> listGluoPrograma = new ArrayList<GluoPrograma>();

            for (GluoProgramaDTO gluoProgramaDTO : listGluoProgramaDTO) {
                GluoPrograma gluoPrograma = gluoProgramaDTOToGluoPrograma(gluoProgramaDTO);

                listGluoPrograma.add(gluoPrograma);
            }

            return listGluoPrograma;
        } catch (Exception e) {
            throw e;
        }
    }
}
