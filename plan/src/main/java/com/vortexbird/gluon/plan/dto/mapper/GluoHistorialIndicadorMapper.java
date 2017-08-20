package com.vortexbird.gluon.plan.dto.mapper;

import com.vortexbird.gluon.plan.modelo.*;
import com.vortexbird.gluon.plan.modelo.GluoHistorialIndicador;
import com.vortexbird.gluon.plan.modelo.control.*;
import com.vortexbird.gluon.plan.modelo.dto.GluoHistorialIndicadorDTO;

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
public class GluoHistorialIndicadorMapper
    implements IGluoHistorialIndicadorMapper {
    private static final Logger log = LoggerFactory.getLogger(GluoHistorialIndicadorMapper.class);

    /**
    * Logic injected by Spring that manages GluoIndicador entities
    *
    */
    @Autowired
    IGluoIndicadorLogic logicGluoIndicador1;

    @Transactional(readOnly = true)
    public GluoHistorialIndicadorDTO gluoHistorialIndicadorToGluoHistorialIndicadorDTO(
        GluoHistorialIndicador gluoHistorialIndicador)
        throws Exception {
        try {
            GluoHistorialIndicadorDTO gluoHistorialIndicadorDTO = new GluoHistorialIndicadorDTO();

            gluoHistorialIndicadorDTO.setHiinId(gluoHistorialIndicador.getHiinId());
            gluoHistorialIndicadorDTO.setActivo((gluoHistorialIndicador.getActivo() != null)
                ? gluoHistorialIndicador.getActivo() : null);
            gluoHistorialIndicadorDTO.setFecha(gluoHistorialIndicador.getFecha());
            gluoHistorialIndicadorDTO.setFechaCreacion(gluoHistorialIndicador.getFechaCreacion());
            gluoHistorialIndicadorDTO.setFechaModificacion(gluoHistorialIndicador.getFechaModificacion());
            gluoHistorialIndicadorDTO.setUsuCreador((gluoHistorialIndicador.getUsuCreador() != null)
                ? gluoHistorialIndicador.getUsuCreador() : null);
            gluoHistorialIndicadorDTO.setUsuModificador((gluoHistorialIndicador.getUsuModificador() != null)
                ? gluoHistorialIndicador.getUsuModificador() : null);
            gluoHistorialIndicadorDTO.setValorReal((gluoHistorialIndicador.getValorReal() != null)
                ? gluoHistorialIndicador.getValorReal() : null);
            gluoHistorialIndicadorDTO.setIndiId_GluoIndicador((gluoHistorialIndicador.getGluoIndicador()
                                                                                     .getIndiId() != null)
                ? gluoHistorialIndicador.getGluoIndicador().getIndiId() : null);

            return gluoHistorialIndicadorDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public GluoHistorialIndicador gluoHistorialIndicadorDTOToGluoHistorialIndicador(
        GluoHistorialIndicadorDTO gluoHistorialIndicadorDTO)
        throws Exception {
        try {
            GluoHistorialIndicador gluoHistorialIndicador = new GluoHistorialIndicador();

            gluoHistorialIndicador.setHiinId(gluoHistorialIndicadorDTO.getHiinId());
            gluoHistorialIndicador.setActivo((gluoHistorialIndicadorDTO.getActivo() != null)
                ? gluoHistorialIndicadorDTO.getActivo() : null);
            gluoHistorialIndicador.setFecha(gluoHistorialIndicadorDTO.getFecha());
            gluoHistorialIndicador.setFechaCreacion(gluoHistorialIndicadorDTO.getFechaCreacion());
            gluoHistorialIndicador.setFechaModificacion(gluoHistorialIndicadorDTO.getFechaModificacion());
            gluoHistorialIndicador.setUsuCreador((gluoHistorialIndicadorDTO.getUsuCreador() != null)
                ? gluoHistorialIndicadorDTO.getUsuCreador() : null);
            gluoHistorialIndicador.setUsuModificador((gluoHistorialIndicadorDTO.getUsuModificador() != null)
                ? gluoHistorialIndicadorDTO.getUsuModificador() : null);
            gluoHistorialIndicador.setValorReal((gluoHistorialIndicadorDTO.getValorReal() != null)
                ? gluoHistorialIndicadorDTO.getValorReal() : null);

            GluoIndicador gluoIndicador = new GluoIndicador();

            if (gluoHistorialIndicadorDTO.getIndiId_GluoIndicador() != null) {
                gluoIndicador = logicGluoIndicador1.getGluoIndicador(gluoHistorialIndicadorDTO.getIndiId_GluoIndicador());
            }

            if (gluoIndicador != null) {
                gluoHistorialIndicador.setGluoIndicador(gluoIndicador);
            }

            return gluoHistorialIndicador;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<GluoHistorialIndicadorDTO> listGluoHistorialIndicadorToListGluoHistorialIndicadorDTO(
        List<GluoHistorialIndicador> listGluoHistorialIndicador)
        throws Exception {
        try {
            List<GluoHistorialIndicadorDTO> gluoHistorialIndicadorDTOs = new ArrayList<GluoHistorialIndicadorDTO>();

            for (GluoHistorialIndicador gluoHistorialIndicador : listGluoHistorialIndicador) {
                GluoHistorialIndicadorDTO gluoHistorialIndicadorDTO = gluoHistorialIndicadorToGluoHistorialIndicadorDTO(gluoHistorialIndicador);

                gluoHistorialIndicadorDTOs.add(gluoHistorialIndicadorDTO);
            }

            return gluoHistorialIndicadorDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<GluoHistorialIndicador> listGluoHistorialIndicadorDTOToListGluoHistorialIndicador(
        List<GluoHistorialIndicadorDTO> listGluoHistorialIndicadorDTO)
        throws Exception {
        try {
            List<GluoHistorialIndicador> listGluoHistorialIndicador = new ArrayList<GluoHistorialIndicador>();

            for (GluoHistorialIndicadorDTO gluoHistorialIndicadorDTO : listGluoHistorialIndicadorDTO) {
                GluoHistorialIndicador gluoHistorialIndicador = gluoHistorialIndicadorDTOToGluoHistorialIndicador(gluoHistorialIndicadorDTO);

                listGluoHistorialIndicador.add(gluoHistorialIndicador);
            }

            return listGluoHistorialIndicador;
        } catch (Exception e) {
            throw e;
        }
    }
}
