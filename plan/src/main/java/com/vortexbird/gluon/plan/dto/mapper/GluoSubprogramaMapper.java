package com.vortexbird.gluon.plan.dto.mapper;

import com.vortexbird.gluon.plan.modelo.*;
import com.vortexbird.gluon.plan.modelo.GluoSubprograma;
import com.vortexbird.gluon.plan.modelo.control.*;
import com.vortexbird.gluon.plan.modelo.dto.GluoSubprogramaDTO;

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
public class GluoSubprogramaMapper implements IGluoSubprogramaMapper {
    private static final Logger log = LoggerFactory.getLogger(GluoSubprogramaMapper.class);

    /**
    * Logic injected by Spring that manages GluoPrograma entities
    *
    */
    @Autowired
    IGluoProgramaLogic logicGluoPrograma1;

    @Transactional(readOnly = true)
    public GluoSubprogramaDTO gluoSubprogramaToGluoSubprogramaDTO(
        GluoSubprograma gluoSubprograma) throws Exception {
        try {
            GluoSubprogramaDTO gluoSubprogramaDTO = new GluoSubprogramaDTO();

            gluoSubprogramaDTO.setSubpId(gluoSubprograma.getSubpId());
            gluoSubprogramaDTO.setActivo((gluoSubprograma.getActivo() != null)
                ? gluoSubprograma.getActivo() : null);
            gluoSubprogramaDTO.setDescripcion((gluoSubprograma.getDescripcion() != null)
                ? gluoSubprograma.getDescripcion() : null);
            gluoSubprogramaDTO.setFechaCreacion(gluoSubprograma.getFechaCreacion());
            gluoSubprogramaDTO.setFechaModificacion(gluoSubprograma.getFechaModificacion());
            gluoSubprogramaDTO.setUsuCreador((gluoSubprograma.getUsuCreador() != null)
                ? gluoSubprograma.getUsuCreador() : null);
            gluoSubprogramaDTO.setUsuModificador((gluoSubprograma.getUsuModificador() != null)
                ? gluoSubprograma.getUsuModificador() : null);
            gluoSubprogramaDTO.setProgId_GluoPrograma((gluoSubprograma.getGluoPrograma()
                                                                      .getProgId() != null)
                ? gluoSubprograma.getGluoPrograma().getProgId() : null);

            return gluoSubprogramaDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public GluoSubprograma gluoSubprogramaDTOToGluoSubprograma(
        GluoSubprogramaDTO gluoSubprogramaDTO) throws Exception {
        try {
            GluoSubprograma gluoSubprograma = new GluoSubprograma();

            gluoSubprograma.setSubpId(gluoSubprogramaDTO.getSubpId());
            gluoSubprograma.setActivo((gluoSubprogramaDTO.getActivo() != null)
                ? gluoSubprogramaDTO.getActivo() : null);
            gluoSubprograma.setDescripcion((gluoSubprogramaDTO.getDescripcion() != null)
                ? gluoSubprogramaDTO.getDescripcion() : null);
            gluoSubprograma.setFechaCreacion(gluoSubprogramaDTO.getFechaCreacion());
            gluoSubprograma.setFechaModificacion(gluoSubprogramaDTO.getFechaModificacion());
            gluoSubprograma.setUsuCreador((gluoSubprogramaDTO.getUsuCreador() != null)
                ? gluoSubprogramaDTO.getUsuCreador() : null);
            gluoSubprograma.setUsuModificador((gluoSubprogramaDTO.getUsuModificador() != null)
                ? gluoSubprogramaDTO.getUsuModificador() : null);

            GluoPrograma gluoPrograma = new GluoPrograma();

            if (gluoSubprogramaDTO.getProgId_GluoPrograma() != null) {
                gluoPrograma = logicGluoPrograma1.getGluoPrograma(gluoSubprogramaDTO.getProgId_GluoPrograma());
            }

            if (gluoPrograma != null) {
                gluoSubprograma.setGluoPrograma(gluoPrograma);
            }

            return gluoSubprograma;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<GluoSubprogramaDTO> listGluoSubprogramaToListGluoSubprogramaDTO(
        List<GluoSubprograma> listGluoSubprograma) throws Exception {
        try {
            List<GluoSubprogramaDTO> gluoSubprogramaDTOs = new ArrayList<GluoSubprogramaDTO>();

            for (GluoSubprograma gluoSubprograma : listGluoSubprograma) {
                GluoSubprogramaDTO gluoSubprogramaDTO = gluoSubprogramaToGluoSubprogramaDTO(gluoSubprograma);

                gluoSubprogramaDTOs.add(gluoSubprogramaDTO);
            }

            return gluoSubprogramaDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<GluoSubprograma> listGluoSubprogramaDTOToListGluoSubprograma(
        List<GluoSubprogramaDTO> listGluoSubprogramaDTO)
        throws Exception {
        try {
            List<GluoSubprograma> listGluoSubprograma = new ArrayList<GluoSubprograma>();

            for (GluoSubprogramaDTO gluoSubprogramaDTO : listGluoSubprogramaDTO) {
                GluoSubprograma gluoSubprograma = gluoSubprogramaDTOToGluoSubprograma(gluoSubprogramaDTO);

                listGluoSubprograma.add(gluoSubprograma);
            }

            return listGluoSubprograma;
        } catch (Exception e) {
            throw e;
        }
    }
}
