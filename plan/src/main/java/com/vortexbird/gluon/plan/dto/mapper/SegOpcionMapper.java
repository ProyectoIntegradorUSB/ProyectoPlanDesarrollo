package com.vortexbird.gluon.plan.dto.mapper;

import com.vortexbird.gluon.plan.modelo.*;
import com.vortexbird.gluon.plan.modelo.SegOpcion;
import com.vortexbird.gluon.plan.modelo.control.*;
import com.vortexbird.gluon.plan.modelo.dto.SegOpcionDTO;

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
public class SegOpcionMapper implements ISegOpcionMapper {
    private static final Logger log = LoggerFactory.getLogger(SegOpcionMapper.class);

    @Transactional(readOnly = true)
    public SegOpcionDTO segOpcionToSegOpcionDTO(SegOpcion segOpcion)
        throws Exception {
        try {
            SegOpcionDTO segOpcionDTO = new SegOpcionDTO();

            segOpcionDTO.setOpcnId(segOpcion.getOpcnId());
            segOpcionDTO.setActivo((segOpcion.getActivo() != null)
                ? segOpcion.getActivo() : null);
            segOpcionDTO.setFechaCreacion(segOpcion.getFechaCreacion());
            segOpcionDTO.setFechaModificacion(segOpcion.getFechaModificacion());
            segOpcionDTO.setNombre((segOpcion.getNombre() != null)
                ? segOpcion.getNombre() : null);
            segOpcionDTO.setUsuCreador((segOpcion.getUsuCreador() != null)
                ? segOpcion.getUsuCreador() : null);
            segOpcionDTO.setUsuModificador((segOpcion.getUsuModificador() != null)
                ? segOpcion.getUsuModificador() : null);

            return segOpcionDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public SegOpcion segOpcionDTOToSegOpcion(SegOpcionDTO segOpcionDTO)
        throws Exception {
        try {
            SegOpcion segOpcion = new SegOpcion();

            segOpcion.setOpcnId(segOpcionDTO.getOpcnId());
            segOpcion.setActivo((segOpcionDTO.getActivo() != null)
                ? segOpcionDTO.getActivo() : null);
            segOpcion.setFechaCreacion(segOpcionDTO.getFechaCreacion());
            segOpcion.setFechaModificacion(segOpcionDTO.getFechaModificacion());
            segOpcion.setNombre((segOpcionDTO.getNombre() != null)
                ? segOpcionDTO.getNombre() : null);
            segOpcion.setUsuCreador((segOpcionDTO.getUsuCreador() != null)
                ? segOpcionDTO.getUsuCreador() : null);
            segOpcion.setUsuModificador((segOpcionDTO.getUsuModificador() != null)
                ? segOpcionDTO.getUsuModificador() : null);

            return segOpcion;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<SegOpcionDTO> listSegOpcionToListSegOpcionDTO(
        List<SegOpcion> listSegOpcion) throws Exception {
        try {
            List<SegOpcionDTO> segOpcionDTOs = new ArrayList<SegOpcionDTO>();

            for (SegOpcion segOpcion : listSegOpcion) {
                SegOpcionDTO segOpcionDTO = segOpcionToSegOpcionDTO(segOpcion);

                segOpcionDTOs.add(segOpcionDTO);
            }

            return segOpcionDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<SegOpcion> listSegOpcionDTOToListSegOpcion(
        List<SegOpcionDTO> listSegOpcionDTO) throws Exception {
        try {
            List<SegOpcion> listSegOpcion = new ArrayList<SegOpcion>();

            for (SegOpcionDTO segOpcionDTO : listSegOpcionDTO) {
                SegOpcion segOpcion = segOpcionDTOToSegOpcion(segOpcionDTO);

                listSegOpcion.add(segOpcion);
            }

            return listSegOpcion;
        } catch (Exception e) {
            throw e;
        }
    }
}
