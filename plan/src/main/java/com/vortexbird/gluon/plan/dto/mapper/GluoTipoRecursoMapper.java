package com.vortexbird.gluon.plan.dto.mapper;

import com.vortexbird.gluon.plan.modelo.*;
import com.vortexbird.gluon.plan.modelo.GluoTipoRecurso;
import com.vortexbird.gluon.plan.modelo.control.*;
import com.vortexbird.gluon.plan.modelo.dto.GluoTipoRecursoDTO;

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
public class GluoTipoRecursoMapper implements IGluoTipoRecursoMapper {
    private static final Logger log = LoggerFactory.getLogger(GluoTipoRecursoMapper.class);

    @Transactional(readOnly = true)
    public GluoTipoRecursoDTO gluoTipoRecursoToGluoTipoRecursoDTO(
        GluoTipoRecurso gluoTipoRecurso) throws Exception {
        try {
            GluoTipoRecursoDTO gluoTipoRecursoDTO = new GluoTipoRecursoDTO();

            gluoTipoRecursoDTO.setTireId(gluoTipoRecurso.getTireId());
            gluoTipoRecursoDTO.setActivo((gluoTipoRecurso.getActivo() != null)
                ? gluoTipoRecurso.getActivo() : null);
            gluoTipoRecursoDTO.setCodigo((gluoTipoRecurso.getCodigo() != null)
                ? gluoTipoRecurso.getCodigo() : null);
            gluoTipoRecursoDTO.setDescripcion((gluoTipoRecurso.getDescripcion() != null)
                ? gluoTipoRecurso.getDescripcion() : null);
            gluoTipoRecursoDTO.setFechaCreacion(gluoTipoRecurso.getFechaCreacion());
            gluoTipoRecursoDTO.setFechaModificacion(gluoTipoRecurso.getFechaModificacion());
            gluoTipoRecursoDTO.setUsuCreador((gluoTipoRecurso.getUsuCreador() != null)
                ? gluoTipoRecurso.getUsuCreador() : null);
            gluoTipoRecursoDTO.setUsuModificador((gluoTipoRecurso.getUsuModificador() != null)
                ? gluoTipoRecurso.getUsuModificador() : null);

            return gluoTipoRecursoDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public GluoTipoRecurso gluoTipoRecursoDTOToGluoTipoRecurso(
        GluoTipoRecursoDTO gluoTipoRecursoDTO) throws Exception {
        try {
            GluoTipoRecurso gluoTipoRecurso = new GluoTipoRecurso();

            gluoTipoRecurso.setTireId(gluoTipoRecursoDTO.getTireId());
            gluoTipoRecurso.setActivo((gluoTipoRecursoDTO.getActivo() != null)
                ? gluoTipoRecursoDTO.getActivo() : null);
            gluoTipoRecurso.setCodigo((gluoTipoRecursoDTO.getCodigo() != null)
                ? gluoTipoRecursoDTO.getCodigo() : null);
            gluoTipoRecurso.setDescripcion((gluoTipoRecursoDTO.getDescripcion() != null)
                ? gluoTipoRecursoDTO.getDescripcion() : null);
            gluoTipoRecurso.setFechaCreacion(gluoTipoRecursoDTO.getFechaCreacion());
            gluoTipoRecurso.setFechaModificacion(gluoTipoRecursoDTO.getFechaModificacion());
            gluoTipoRecurso.setUsuCreador((gluoTipoRecursoDTO.getUsuCreador() != null)
                ? gluoTipoRecursoDTO.getUsuCreador() : null);
            gluoTipoRecurso.setUsuModificador((gluoTipoRecursoDTO.getUsuModificador() != null)
                ? gluoTipoRecursoDTO.getUsuModificador() : null);

            return gluoTipoRecurso;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<GluoTipoRecursoDTO> listGluoTipoRecursoToListGluoTipoRecursoDTO(
        List<GluoTipoRecurso> listGluoTipoRecurso) throws Exception {
        try {
            List<GluoTipoRecursoDTO> gluoTipoRecursoDTOs = new ArrayList<GluoTipoRecursoDTO>();

            for (GluoTipoRecurso gluoTipoRecurso : listGluoTipoRecurso) {
                GluoTipoRecursoDTO gluoTipoRecursoDTO = gluoTipoRecursoToGluoTipoRecursoDTO(gluoTipoRecurso);

                gluoTipoRecursoDTOs.add(gluoTipoRecursoDTO);
            }

            return gluoTipoRecursoDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<GluoTipoRecurso> listGluoTipoRecursoDTOToListGluoTipoRecurso(
        List<GluoTipoRecursoDTO> listGluoTipoRecursoDTO)
        throws Exception {
        try {
            List<GluoTipoRecurso> listGluoTipoRecurso = new ArrayList<GluoTipoRecurso>();

            for (GluoTipoRecursoDTO gluoTipoRecursoDTO : listGluoTipoRecursoDTO) {
                GluoTipoRecurso gluoTipoRecurso = gluoTipoRecursoDTOToGluoTipoRecurso(gluoTipoRecursoDTO);

                listGluoTipoRecurso.add(gluoTipoRecurso);
            }

            return listGluoTipoRecurso;
        } catch (Exception e) {
            throw e;
        }
    }
}
