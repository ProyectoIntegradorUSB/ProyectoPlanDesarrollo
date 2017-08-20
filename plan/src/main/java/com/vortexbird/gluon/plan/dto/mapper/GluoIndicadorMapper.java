package com.vortexbird.gluon.plan.dto.mapper;

import com.vortexbird.gluon.plan.modelo.*;
import com.vortexbird.gluon.plan.modelo.GluoIndicador;
import com.vortexbird.gluon.plan.modelo.control.*;
import com.vortexbird.gluon.plan.modelo.dto.GluoIndicadorDTO;

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
public class GluoIndicadorMapper implements IGluoIndicadorMapper {
    private static final Logger log = LoggerFactory.getLogger(GluoIndicadorMapper.class);

    /**
    * Logic injected by Spring that manages GluoProyecto entities
    *
    */
    @Autowired
    IGluoProyectoLogic logicGluoProyecto1;

    @Transactional(readOnly = true)
    public GluoIndicadorDTO gluoIndicadorToGluoIndicadorDTO(
        GluoIndicador gluoIndicador) throws Exception {
        try {
            GluoIndicadorDTO gluoIndicadorDTO = new GluoIndicadorDTO();

            gluoIndicadorDTO.setIndiId(gluoIndicador.getIndiId());
            gluoIndicadorDTO.setActivo((gluoIndicador.getActivo() != null)
                ? gluoIndicador.getActivo() : null);
            gluoIndicadorDTO.setDescripcionIndicador((gluoIndicador.getDescripcionIndicador() != null)
                ? gluoIndicador.getDescripcionIndicador() : null);
            gluoIndicadorDTO.setDescripcionLineaBase((gluoIndicador.getDescripcionLineaBase() != null)
                ? gluoIndicador.getDescripcionLineaBase() : null);
            gluoIndicadorDTO.setDescripcionMeta((gluoIndicador.getDescripcionMeta() != null)
                ? gluoIndicador.getDescripcionMeta() : null);
            gluoIndicadorDTO.setFechaCreacion(gluoIndicador.getFechaCreacion());
            gluoIndicadorDTO.setFechaModificacion(gluoIndicador.getFechaModificacion());
            gluoIndicadorDTO.setUsuCreador((gluoIndicador.getUsuCreador() != null)
                ? gluoIndicador.getUsuCreador() : null);
            gluoIndicadorDTO.setUsuModificador((gluoIndicador.getUsuModificador() != null)
                ? gluoIndicador.getUsuModificador() : null);
            gluoIndicadorDTO.setValorMeta((gluoIndicador.getValorMeta() != null)
                ? gluoIndicador.getValorMeta() : null);
            gluoIndicadorDTO.setProyId_GluoProyecto((gluoIndicador.getGluoProyecto()
                                                                  .getProyId() != null)
                ? gluoIndicador.getGluoProyecto().getProyId() : null);

            return gluoIndicadorDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public GluoIndicador gluoIndicadorDTOToGluoIndicador(
        GluoIndicadorDTO gluoIndicadorDTO) throws Exception {
        try {
            GluoIndicador gluoIndicador = new GluoIndicador();

            gluoIndicador.setIndiId(gluoIndicadorDTO.getIndiId());
            gluoIndicador.setActivo((gluoIndicadorDTO.getActivo() != null)
                ? gluoIndicadorDTO.getActivo() : null);
            gluoIndicador.setDescripcionIndicador((gluoIndicadorDTO.getDescripcionIndicador() != null)
                ? gluoIndicadorDTO.getDescripcionIndicador() : null);
            gluoIndicador.setDescripcionLineaBase((gluoIndicadorDTO.getDescripcionLineaBase() != null)
                ? gluoIndicadorDTO.getDescripcionLineaBase() : null);
            gluoIndicador.setDescripcionMeta((gluoIndicadorDTO.getDescripcionMeta() != null)
                ? gluoIndicadorDTO.getDescripcionMeta() : null);
            gluoIndicador.setFechaCreacion(gluoIndicadorDTO.getFechaCreacion());
            gluoIndicador.setFechaModificacion(gluoIndicadorDTO.getFechaModificacion());
            gluoIndicador.setUsuCreador((gluoIndicadorDTO.getUsuCreador() != null)
                ? gluoIndicadorDTO.getUsuCreador() : null);
            gluoIndicador.setUsuModificador((gluoIndicadorDTO.getUsuModificador() != null)
                ? gluoIndicadorDTO.getUsuModificador() : null);
            gluoIndicador.setValorMeta((gluoIndicadorDTO.getValorMeta() != null)
                ? gluoIndicadorDTO.getValorMeta() : null);

            GluoProyecto gluoProyecto = new GluoProyecto();

            if (gluoIndicadorDTO.getProyId_GluoProyecto() != null) {
                gluoProyecto = logicGluoProyecto1.getGluoProyecto(gluoIndicadorDTO.getProyId_GluoProyecto());
            }

            if (gluoProyecto != null) {
                gluoIndicador.setGluoProyecto(gluoProyecto);
            }

            return gluoIndicador;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<GluoIndicadorDTO> listGluoIndicadorToListGluoIndicadorDTO(
        List<GluoIndicador> listGluoIndicador) throws Exception {
        try {
            List<GluoIndicadorDTO> gluoIndicadorDTOs = new ArrayList<GluoIndicadorDTO>();

            for (GluoIndicador gluoIndicador : listGluoIndicador) {
                GluoIndicadorDTO gluoIndicadorDTO = gluoIndicadorToGluoIndicadorDTO(gluoIndicador);

                gluoIndicadorDTOs.add(gluoIndicadorDTO);
            }

            return gluoIndicadorDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<GluoIndicador> listGluoIndicadorDTOToListGluoIndicador(
        List<GluoIndicadorDTO> listGluoIndicadorDTO) throws Exception {
        try {
            List<GluoIndicador> listGluoIndicador = new ArrayList<GluoIndicador>();

            for (GluoIndicadorDTO gluoIndicadorDTO : listGluoIndicadorDTO) {
                GluoIndicador gluoIndicador = gluoIndicadorDTOToGluoIndicador(gluoIndicadorDTO);

                listGluoIndicador.add(gluoIndicador);
            }

            return listGluoIndicador;
        } catch (Exception e) {
            throw e;
        }
    }
}
