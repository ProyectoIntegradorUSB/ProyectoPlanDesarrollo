package com.vortexbird.gluon.plan.dto.mapper;

import com.vortexbird.gluon.plan.modelo.*;
import com.vortexbird.gluon.plan.modelo.SegRol;
import com.vortexbird.gluon.plan.modelo.control.*;
import com.vortexbird.gluon.plan.modelo.dto.SegRolDTO;

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
public class SegRolMapper implements ISegRolMapper {
    private static final Logger log = LoggerFactory.getLogger(SegRolMapper.class);

    @Transactional(readOnly = true)
    public SegRolDTO segRolToSegRolDTO(SegRol segRol) throws Exception {
        try {
            SegRolDTO segRolDTO = new SegRolDTO();

            segRolDTO.setRolId(segRol.getRolId());
            segRolDTO.setActivo((segRol.getActivo() != null)
                ? segRol.getActivo() : null);
            segRolDTO.setFechaCreacion(segRol.getFechaCreacion());
            segRolDTO.setFechaModificacion(segRol.getFechaModificacion());
            segRolDTO.setNombre((segRol.getNombre() != null)
                ? segRol.getNombre() : null);
            segRolDTO.setUsuCreador((segRol.getUsuCreador() != null)
                ? segRol.getUsuCreador() : null);
            segRolDTO.setUsuModificador((segRol.getUsuModificador() != null)
                ? segRol.getUsuModificador() : null);

            return segRolDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public SegRol segRolDTOToSegRol(SegRolDTO segRolDTO)
        throws Exception {
        try {
            SegRol segRol = new SegRol();

            segRol.setRolId(segRolDTO.getRolId());
            segRol.setActivo((segRolDTO.getActivo() != null)
                ? segRolDTO.getActivo() : null);
            segRol.setFechaCreacion(segRolDTO.getFechaCreacion());
            segRol.setFechaModificacion(segRolDTO.getFechaModificacion());
            segRol.setNombre((segRolDTO.getNombre() != null)
                ? segRolDTO.getNombre() : null);
            segRol.setUsuCreador((segRolDTO.getUsuCreador() != null)
                ? segRolDTO.getUsuCreador() : null);
            segRol.setUsuModificador((segRolDTO.getUsuModificador() != null)
                ? segRolDTO.getUsuModificador() : null);

            return segRol;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<SegRolDTO> listSegRolToListSegRolDTO(List<SegRol> listSegRol)
        throws Exception {
        try {
            List<SegRolDTO> segRolDTOs = new ArrayList<SegRolDTO>();

            for (SegRol segRol : listSegRol) {
                SegRolDTO segRolDTO = segRolToSegRolDTO(segRol);

                segRolDTOs.add(segRolDTO);
            }

            return segRolDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<SegRol> listSegRolDTOToListSegRol(List<SegRolDTO> listSegRolDTO)
        throws Exception {
        try {
            List<SegRol> listSegRol = new ArrayList<SegRol>();

            for (SegRolDTO segRolDTO : listSegRolDTO) {
                SegRol segRol = segRolDTOToSegRol(segRolDTO);

                listSegRol.add(segRol);
            }

            return listSegRol;
        } catch (Exception e) {
            throw e;
        }
    }
}
