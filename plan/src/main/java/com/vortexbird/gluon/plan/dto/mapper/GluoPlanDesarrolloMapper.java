package com.vortexbird.gluon.plan.dto.mapper;

import com.vortexbird.gluon.plan.modelo.*;
import com.vortexbird.gluon.plan.modelo.GluoPlanDesarrollo;
import com.vortexbird.gluon.plan.modelo.control.*;
import com.vortexbird.gluon.plan.modelo.dto.GluoPlanDesarrolloDTO;

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
public class GluoPlanDesarrolloMapper implements IGluoPlanDesarrolloMapper {
    private static final Logger log = LoggerFactory.getLogger(GluoPlanDesarrolloMapper.class);

    @Transactional(readOnly = true)
    public GluoPlanDesarrolloDTO gluoPlanDesarrolloToGluoPlanDesarrolloDTO(
        GluoPlanDesarrollo gluoPlanDesarrollo) throws Exception {
        try {
            GluoPlanDesarrolloDTO gluoPlanDesarrolloDTO = new GluoPlanDesarrolloDTO();

            gluoPlanDesarrolloDTO.setPlanId(gluoPlanDesarrollo.getPlanId());
            gluoPlanDesarrolloDTO.setActivo((gluoPlanDesarrollo.getActivo() != null)
                ? gluoPlanDesarrollo.getActivo() : null);
            gluoPlanDesarrolloDTO.setAnoFin(gluoPlanDesarrollo.getAnoFin());
            gluoPlanDesarrolloDTO.setAnoInicio(gluoPlanDesarrollo.getAnoInicio());
            gluoPlanDesarrolloDTO.setDescripcion((gluoPlanDesarrollo.getDescripcion() != null)
                ? gluoPlanDesarrollo.getDescripcion() : null);
            gluoPlanDesarrolloDTO.setEslogan((gluoPlanDesarrollo.getEslogan() != null)
                ? gluoPlanDesarrollo.getEslogan() : null);
            gluoPlanDesarrolloDTO.setFechaCreacion(gluoPlanDesarrollo.getFechaCreacion());
            gluoPlanDesarrolloDTO.setFechaModificacion(gluoPlanDesarrollo.getFechaModificacion());
            gluoPlanDesarrolloDTO.setNombreAlcalde((gluoPlanDesarrollo.getNombreAlcalde() != null)
                ? gluoPlanDesarrollo.getNombreAlcalde() : null);
            gluoPlanDesarrolloDTO.setUsuCreador((gluoPlanDesarrollo.getUsuCreador() != null)
                ? gluoPlanDesarrollo.getUsuCreador() : null);
            gluoPlanDesarrolloDTO.setUsuModificador((gluoPlanDesarrollo.getUsuModificador() != null)
                ? gluoPlanDesarrollo.getUsuModificador() : null);

            return gluoPlanDesarrolloDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public GluoPlanDesarrollo gluoPlanDesarrolloDTOToGluoPlanDesarrollo(
        GluoPlanDesarrolloDTO gluoPlanDesarrolloDTO) throws Exception {
        try {
            GluoPlanDesarrollo gluoPlanDesarrollo = new GluoPlanDesarrollo();

            gluoPlanDesarrollo.setPlanId(gluoPlanDesarrolloDTO.getPlanId());
            gluoPlanDesarrollo.setActivo((gluoPlanDesarrolloDTO.getActivo() != null)
                ? gluoPlanDesarrolloDTO.getActivo() : null);
            gluoPlanDesarrollo.setAnoFin(gluoPlanDesarrolloDTO.getAnoFin());
            gluoPlanDesarrollo.setAnoInicio(gluoPlanDesarrolloDTO.getAnoInicio());
            gluoPlanDesarrollo.setDescripcion((gluoPlanDesarrolloDTO.getDescripcion() != null)
                ? gluoPlanDesarrolloDTO.getDescripcion() : null);
            gluoPlanDesarrollo.setEslogan((gluoPlanDesarrolloDTO.getEslogan() != null)
                ? gluoPlanDesarrolloDTO.getEslogan() : null);
            gluoPlanDesarrollo.setFechaCreacion(gluoPlanDesarrolloDTO.getFechaCreacion());
            gluoPlanDesarrollo.setFechaModificacion(gluoPlanDesarrolloDTO.getFechaModificacion());
            gluoPlanDesarrollo.setNombreAlcalde((gluoPlanDesarrolloDTO.getNombreAlcalde() != null)
                ? gluoPlanDesarrolloDTO.getNombreAlcalde() : null);
            gluoPlanDesarrollo.setUsuCreador((gluoPlanDesarrolloDTO.getUsuCreador() != null)
                ? gluoPlanDesarrolloDTO.getUsuCreador() : null);
            gluoPlanDesarrollo.setUsuModificador((gluoPlanDesarrolloDTO.getUsuModificador() != null)
                ? gluoPlanDesarrolloDTO.getUsuModificador() : null);

            return gluoPlanDesarrollo;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<GluoPlanDesarrolloDTO> listGluoPlanDesarrolloToListGluoPlanDesarrolloDTO(
        List<GluoPlanDesarrollo> listGluoPlanDesarrollo)
        throws Exception {
        try {
            List<GluoPlanDesarrolloDTO> gluoPlanDesarrolloDTOs = new ArrayList<GluoPlanDesarrolloDTO>();

            for (GluoPlanDesarrollo gluoPlanDesarrollo : listGluoPlanDesarrollo) {
                GluoPlanDesarrolloDTO gluoPlanDesarrolloDTO = gluoPlanDesarrolloToGluoPlanDesarrolloDTO(gluoPlanDesarrollo);

                gluoPlanDesarrolloDTOs.add(gluoPlanDesarrolloDTO);
            }

            return gluoPlanDesarrolloDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<GluoPlanDesarrollo> listGluoPlanDesarrolloDTOToListGluoPlanDesarrollo(
        List<GluoPlanDesarrolloDTO> listGluoPlanDesarrolloDTO)
        throws Exception {
        try {
            List<GluoPlanDesarrollo> listGluoPlanDesarrollo = new ArrayList<GluoPlanDesarrollo>();

            for (GluoPlanDesarrolloDTO gluoPlanDesarrolloDTO : listGluoPlanDesarrolloDTO) {
                GluoPlanDesarrollo gluoPlanDesarrollo = gluoPlanDesarrolloDTOToGluoPlanDesarrollo(gluoPlanDesarrolloDTO);

                listGluoPlanDesarrollo.add(gluoPlanDesarrollo);
            }

            return listGluoPlanDesarrollo;
        } catch (Exception e) {
            throw e;
        }
    }
}
