package com.vortexbird.gluon.plan.dto.mapper;

import com.vortexbird.gluon.plan.modelo.*;
import com.vortexbird.gluon.plan.modelo.SegUsuario;
import com.vortexbird.gluon.plan.modelo.control.*;
import com.vortexbird.gluon.plan.modelo.dto.SegUsuarioDTO;

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
public class SegUsuarioMapper implements ISegUsuarioMapper {
    private static final Logger log = LoggerFactory.getLogger(SegUsuarioMapper.class);

    @Transactional(readOnly = true)
    public SegUsuarioDTO segUsuarioToSegUsuarioDTO(SegUsuario segUsuario)
        throws Exception {
        try {
            SegUsuarioDTO segUsuarioDTO = new SegUsuarioDTO();

            segUsuarioDTO.setUsuId(segUsuario.getUsuId());
            segUsuarioDTO.setActivo((segUsuario.getActivo() != null)
                ? segUsuario.getActivo() : null);
            segUsuarioDTO.setFechaCreacion(segUsuario.getFechaCreacion());
            segUsuarioDTO.setFechaModificacion(segUsuario.getFechaModificacion());
            segUsuarioDTO.setUsuCreador((segUsuario.getUsuCreador() != null)
                ? segUsuario.getUsuCreador() : null);
            segUsuarioDTO.setUsuLogin((segUsuario.getUsuLogin() != null)
                ? segUsuario.getUsuLogin() : null);
            segUsuarioDTO.setUsuModificador((segUsuario.getUsuModificador() != null)
                ? segUsuario.getUsuModificador() : null);
            segUsuarioDTO.setUsuPassword((segUsuario.getUsuPassword() != null)
                ? segUsuario.getUsuPassword() : null);

            return segUsuarioDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public SegUsuario segUsuarioDTOToSegUsuario(SegUsuarioDTO segUsuarioDTO)
        throws Exception {
        try {
            SegUsuario segUsuario = new SegUsuario();

            segUsuario.setUsuId(segUsuarioDTO.getUsuId());
            segUsuario.setActivo((segUsuarioDTO.getActivo() != null)
                ? segUsuarioDTO.getActivo() : null);
            segUsuario.setFechaCreacion(segUsuarioDTO.getFechaCreacion());
            segUsuario.setFechaModificacion(segUsuarioDTO.getFechaModificacion());
            segUsuario.setUsuCreador((segUsuarioDTO.getUsuCreador() != null)
                ? segUsuarioDTO.getUsuCreador() : null);
            segUsuario.setUsuLogin((segUsuarioDTO.getUsuLogin() != null)
                ? segUsuarioDTO.getUsuLogin() : null);
            segUsuario.setUsuModificador((segUsuarioDTO.getUsuModificador() != null)
                ? segUsuarioDTO.getUsuModificador() : null);
            segUsuario.setUsuPassword((segUsuarioDTO.getUsuPassword() != null)
                ? segUsuarioDTO.getUsuPassword() : null);

            return segUsuario;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<SegUsuarioDTO> listSegUsuarioToListSegUsuarioDTO(
        List<SegUsuario> listSegUsuario) throws Exception {
        try {
            List<SegUsuarioDTO> segUsuarioDTOs = new ArrayList<SegUsuarioDTO>();

            for (SegUsuario segUsuario : listSegUsuario) {
                SegUsuarioDTO segUsuarioDTO = segUsuarioToSegUsuarioDTO(segUsuario);

                segUsuarioDTOs.add(segUsuarioDTO);
            }

            return segUsuarioDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<SegUsuario> listSegUsuarioDTOToListSegUsuario(
        List<SegUsuarioDTO> listSegUsuarioDTO) throws Exception {
        try {
            List<SegUsuario> listSegUsuario = new ArrayList<SegUsuario>();

            for (SegUsuarioDTO segUsuarioDTO : listSegUsuarioDTO) {
                SegUsuario segUsuario = segUsuarioDTOToSegUsuario(segUsuarioDTO);

                listSegUsuario.add(segUsuario);
            }

            return listSegUsuario;
        } catch (Exception e) {
            throw e;
        }
    }
}
