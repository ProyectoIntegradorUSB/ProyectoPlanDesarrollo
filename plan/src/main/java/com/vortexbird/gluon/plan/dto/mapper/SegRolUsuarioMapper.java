package com.vortexbird.gluon.plan.dto.mapper;

import com.vortexbird.gluon.plan.modelo.*;
import com.vortexbird.gluon.plan.modelo.SegRolUsuario;
import com.vortexbird.gluon.plan.modelo.control.*;
import com.vortexbird.gluon.plan.modelo.dto.SegRolUsuarioDTO;

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
public class SegRolUsuarioMapper implements ISegRolUsuarioMapper {
    private static final Logger log = LoggerFactory.getLogger(SegRolUsuarioMapper.class);

    /**
    * Logic injected by Spring that manages SegRol entities
    *
    */
    @Autowired
    ISegRolLogic logicSegRol1;

    /**
    * Logic injected by Spring that manages SegUsuario entities
    *
    */
    @Autowired
    ISegUsuarioLogic logicSegUsuario2;

    @Transactional(readOnly = true)
    public SegRolUsuarioDTO segRolUsuarioToSegRolUsuarioDTO(
        SegRolUsuario segRolUsuario) throws Exception {
        try {
            SegRolUsuarioDTO segRolUsuarioDTO = new SegRolUsuarioDTO();

            segRolUsuarioDTO.setRlusId(segRolUsuario.getRlusId());
            segRolUsuarioDTO.setActivo((segRolUsuario.getActivo() != null)
                ? segRolUsuario.getActivo() : null);
            segRolUsuarioDTO.setFechaCreacion(segRolUsuario.getFechaCreacion());
            segRolUsuarioDTO.setFechaModificacion(segRolUsuario.getFechaModificacion());
            segRolUsuarioDTO.setUsuCreador((segRolUsuario.getUsuCreador() != null)
                ? segRolUsuario.getUsuCreador() : null);
            segRolUsuarioDTO.setUsuModificador((segRolUsuario.getUsuModificador() != null)
                ? segRolUsuario.getUsuModificador() : null);
            segRolUsuarioDTO.setRolId_SegRol((segRolUsuario.getSegRol()
                                                           .getRolId() != null)
                ? segRolUsuario.getSegRol().getRolId() : null);
            segRolUsuarioDTO.setUsuId_SegUsuario((segRolUsuario.getSegUsuario()
                                                               .getUsuId() != null)
                ? segRolUsuario.getSegUsuario().getUsuId() : null);

            return segRolUsuarioDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public SegRolUsuario segRolUsuarioDTOToSegRolUsuario(
        SegRolUsuarioDTO segRolUsuarioDTO) throws Exception {
        try {
            SegRolUsuario segRolUsuario = new SegRolUsuario();

            segRolUsuario.setRlusId(segRolUsuarioDTO.getRlusId());
            segRolUsuario.setActivo((segRolUsuarioDTO.getActivo() != null)
                ? segRolUsuarioDTO.getActivo() : null);
            segRolUsuario.setFechaCreacion(segRolUsuarioDTO.getFechaCreacion());
            segRolUsuario.setFechaModificacion(segRolUsuarioDTO.getFechaModificacion());
            segRolUsuario.setUsuCreador((segRolUsuarioDTO.getUsuCreador() != null)
                ? segRolUsuarioDTO.getUsuCreador() : null);
            segRolUsuario.setUsuModificador((segRolUsuarioDTO.getUsuModificador() != null)
                ? segRolUsuarioDTO.getUsuModificador() : null);

            SegRol segRol = new SegRol();

            if (segRolUsuarioDTO.getRolId_SegRol() != null) {
                segRol = logicSegRol1.getSegRol(segRolUsuarioDTO.getRolId_SegRol());
            }

            if (segRol != null) {
                segRolUsuario.setSegRol(segRol);
            }

            SegUsuario segUsuario = new SegUsuario();

            if (segRolUsuarioDTO.getUsuId_SegUsuario() != null) {
                segUsuario = logicSegUsuario2.getSegUsuario(segRolUsuarioDTO.getUsuId_SegUsuario());
            }

            if (segUsuario != null) {
                segRolUsuario.setSegUsuario(segUsuario);
            }

            return segRolUsuario;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<SegRolUsuarioDTO> listSegRolUsuarioToListSegRolUsuarioDTO(
        List<SegRolUsuario> listSegRolUsuario) throws Exception {
        try {
            List<SegRolUsuarioDTO> segRolUsuarioDTOs = new ArrayList<SegRolUsuarioDTO>();

            for (SegRolUsuario segRolUsuario : listSegRolUsuario) {
                SegRolUsuarioDTO segRolUsuarioDTO = segRolUsuarioToSegRolUsuarioDTO(segRolUsuario);

                segRolUsuarioDTOs.add(segRolUsuarioDTO);
            }

            return segRolUsuarioDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<SegRolUsuario> listSegRolUsuarioDTOToListSegRolUsuario(
        List<SegRolUsuarioDTO> listSegRolUsuarioDTO) throws Exception {
        try {
            List<SegRolUsuario> listSegRolUsuario = new ArrayList<SegRolUsuario>();

            for (SegRolUsuarioDTO segRolUsuarioDTO : listSegRolUsuarioDTO) {
                SegRolUsuario segRolUsuario = segRolUsuarioDTOToSegRolUsuario(segRolUsuarioDTO);

                listSegRolUsuario.add(segRolUsuario);
            }

            return listSegRolUsuario;
        } catch (Exception e) {
            throw e;
        }
    }
}
