package com.vortexbird.gluon.plan.dto.mapper;

import com.vortexbird.gluon.plan.modelo.*;
import com.vortexbird.gluon.plan.modelo.GluoProyecto;
import com.vortexbird.gluon.plan.modelo.control.*;
import com.vortexbird.gluon.plan.modelo.dto.GluoProyectoDTO;

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
public class GluoProyectoMapper implements IGluoProyectoMapper {
    private static final Logger log = LoggerFactory.getLogger(GluoProyectoMapper.class);

    /**
    * Logic injected by Spring that manages GluoSubprograma entities
    *
    */
    @Autowired
    IGluoSubprogramaLogic logicGluoSubprograma1;

    @Transactional(readOnly = true)
    public GluoProyectoDTO gluoProyectoToGluoProyectoDTO(
        GluoProyecto gluoProyecto) throws Exception {
        try {
            GluoProyectoDTO gluoProyectoDTO = new GluoProyectoDTO();

            gluoProyectoDTO.setProyId(gluoProyecto.getProyId());
            gluoProyectoDTO.setActivo((gluoProyecto.getActivo() != null)
                ? gluoProyecto.getActivo() : null);
            gluoProyectoDTO.setDescripcion((gluoProyecto.getDescripcion() != null)
                ? gluoProyecto.getDescripcion() : null);
            gluoProyectoDTO.setFechaCreacion(gluoProyecto.getFechaCreacion());
            gluoProyectoDTO.setFechaModificacion(gluoProyecto.getFechaModificacion());
            gluoProyectoDTO.setUsuCreador((gluoProyecto.getUsuCreador() != null)
                ? gluoProyecto.getUsuCreador() : null);
            gluoProyectoDTO.setUsuModificador((gluoProyecto.getUsuModificador() != null)
                ? gluoProyecto.getUsuModificador() : null);
            gluoProyectoDTO.setSubpId_GluoSubprograma((gluoProyecto.getGluoSubprograma()
                                                                   .getSubpId() != null)
                ? gluoProyecto.getGluoSubprograma().getSubpId() : null);

            return gluoProyectoDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public GluoProyecto gluoProyectoDTOToGluoProyecto(
        GluoProyectoDTO gluoProyectoDTO) throws Exception {
        try {
            GluoProyecto gluoProyecto = new GluoProyecto();

            gluoProyecto.setProyId(gluoProyectoDTO.getProyId());
            gluoProyecto.setActivo((gluoProyectoDTO.getActivo() != null)
                ? gluoProyectoDTO.getActivo() : null);
            gluoProyecto.setDescripcion((gluoProyectoDTO.getDescripcion() != null)
                ? gluoProyectoDTO.getDescripcion() : null);
            gluoProyecto.setFechaCreacion(gluoProyectoDTO.getFechaCreacion());
            gluoProyecto.setFechaModificacion(gluoProyectoDTO.getFechaModificacion());
            gluoProyecto.setUsuCreador((gluoProyectoDTO.getUsuCreador() != null)
                ? gluoProyectoDTO.getUsuCreador() : null);
            gluoProyecto.setUsuModificador((gluoProyectoDTO.getUsuModificador() != null)
                ? gluoProyectoDTO.getUsuModificador() : null);

            GluoSubprograma gluoSubprograma = new GluoSubprograma();

            if (gluoProyectoDTO.getSubpId_GluoSubprograma() != null) {
                gluoSubprograma = logicGluoSubprograma1.getGluoSubprograma(gluoProyectoDTO.getSubpId_GluoSubprograma());
            }

            if (gluoSubprograma != null) {
                gluoProyecto.setGluoSubprograma(gluoSubprograma);
            }

            return gluoProyecto;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<GluoProyectoDTO> listGluoProyectoToListGluoProyectoDTO(
        List<GluoProyecto> listGluoProyecto) throws Exception {
        try {
            List<GluoProyectoDTO> gluoProyectoDTOs = new ArrayList<GluoProyectoDTO>();

            for (GluoProyecto gluoProyecto : listGluoProyecto) {
                GluoProyectoDTO gluoProyectoDTO = gluoProyectoToGluoProyectoDTO(gluoProyecto);

                gluoProyectoDTOs.add(gluoProyectoDTO);
            }

            return gluoProyectoDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<GluoProyecto> listGluoProyectoDTOToListGluoProyecto(
        List<GluoProyectoDTO> listGluoProyectoDTO) throws Exception {
        try {
            List<GluoProyecto> listGluoProyecto = new ArrayList<GluoProyecto>();

            for (GluoProyectoDTO gluoProyectoDTO : listGluoProyectoDTO) {
                GluoProyecto gluoProyecto = gluoProyectoDTOToGluoProyecto(gluoProyectoDTO);

                listGluoProyecto.add(gluoProyecto);
            }

            return listGluoProyecto;
        } catch (Exception e) {
            throw e;
        }
    }
}
