package com.vortexbird.gluon.plan.dto.mapper;

import com.vortexbird.gluon.plan.modelo.*;
import com.vortexbird.gluon.plan.modelo.SegPermiso;
import com.vortexbird.gluon.plan.modelo.control.*;
import com.vortexbird.gluon.plan.modelo.dto.SegPermisoDTO;

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
public class SegPermisoMapper implements ISegPermisoMapper {
    private static final Logger log = LoggerFactory.getLogger(SegPermisoMapper.class);

    /**
    * Logic injected by Spring that manages SegOpcion entities
    *
    */
    @Autowired
    ISegOpcionLogic logicSegOpcion1;

    /**
    * Logic injected by Spring that manages SegRolUsuario entities
    *
    */
    @Autowired
    ISegRolUsuarioLogic logicSegRolUsuario2;

    @Transactional(readOnly = true)
    public SegPermisoDTO segPermisoToSegPermisoDTO(SegPermiso segPermiso)
        throws Exception {
        try {
            SegPermisoDTO segPermisoDTO = new SegPermisoDTO();

            segPermisoDTO.setPermId(segPermiso.getPermId());
            segPermisoDTO.setActivo((segPermiso.getActivo() != null)
                ? segPermiso.getActivo() : null);
            segPermisoDTO.setFechaCreacion(segPermiso.getFechaCreacion());
            segPermisoDTO.setFechaModificacion(segPermiso.getFechaModificacion());
            segPermisoDTO.setRolId((segPermiso.getRolId() != null)
                ? segPermiso.getRolId() : null);
            segPermisoDTO.setUsuCreador((segPermiso.getUsuCreador() != null)
                ? segPermiso.getUsuCreador() : null);
            segPermisoDTO.setUsuId((segPermiso.getUsuId() != null)
                ? segPermiso.getUsuId() : null);
            segPermisoDTO.setUsuModificador((segPermiso.getUsuModificador() != null)
                ? segPermiso.getUsuModificador() : null);
            segPermisoDTO.setOpcnId_SegOpcion((segPermiso.getSegOpcion()
                                                         .getOpcnId() != null)
                ? segPermiso.getSegOpcion().getOpcnId() : null);
            segPermisoDTO.setRlusId_SegRolUsuario((segPermiso.getSegRolUsuario()
                                                             .getRlusId() != null)
                ? segPermiso.getSegRolUsuario().getRlusId() : null);

            return segPermisoDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public SegPermiso segPermisoDTOToSegPermiso(SegPermisoDTO segPermisoDTO)
        throws Exception {
        try {
            SegPermiso segPermiso = new SegPermiso();

            segPermiso.setPermId(segPermisoDTO.getPermId());
            segPermiso.setActivo((segPermisoDTO.getActivo() != null)
                ? segPermisoDTO.getActivo() : null);
            segPermiso.setFechaCreacion(segPermisoDTO.getFechaCreacion());
            segPermiso.setFechaModificacion(segPermisoDTO.getFechaModificacion());
            segPermiso.setRolId((segPermisoDTO.getRolId() != null)
                ? segPermisoDTO.getRolId() : null);
            segPermiso.setUsuCreador((segPermisoDTO.getUsuCreador() != null)
                ? segPermisoDTO.getUsuCreador() : null);
            segPermiso.setUsuId((segPermisoDTO.getUsuId() != null)
                ? segPermisoDTO.getUsuId() : null);
            segPermiso.setUsuModificador((segPermisoDTO.getUsuModificador() != null)
                ? segPermisoDTO.getUsuModificador() : null);

            SegOpcion segOpcion = new SegOpcion();

            if (segPermisoDTO.getOpcnId_SegOpcion() != null) {
                segOpcion = logicSegOpcion1.getSegOpcion(segPermisoDTO.getOpcnId_SegOpcion());
            }

            if (segOpcion != null) {
                segPermiso.setSegOpcion(segOpcion);
            }

            SegRolUsuario segRolUsuario = new SegRolUsuario();

            if (segPermisoDTO.getRlusId_SegRolUsuario() != null) {
                segRolUsuario = logicSegRolUsuario2.getSegRolUsuario(segPermisoDTO.getRlusId_SegRolUsuario());
            }

            if (segRolUsuario != null) {
                segPermiso.setSegRolUsuario(segRolUsuario);
            }

            return segPermiso;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<SegPermisoDTO> listSegPermisoToListSegPermisoDTO(
        List<SegPermiso> listSegPermiso) throws Exception {
        try {
            List<SegPermisoDTO> segPermisoDTOs = new ArrayList<SegPermisoDTO>();

            for (SegPermiso segPermiso : listSegPermiso) {
                SegPermisoDTO segPermisoDTO = segPermisoToSegPermisoDTO(segPermiso);

                segPermisoDTOs.add(segPermisoDTO);
            }

            return segPermisoDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<SegPermiso> listSegPermisoDTOToListSegPermiso(
        List<SegPermisoDTO> listSegPermisoDTO) throws Exception {
        try {
            List<SegPermiso> listSegPermiso = new ArrayList<SegPermiso>();

            for (SegPermisoDTO segPermisoDTO : listSegPermisoDTO) {
                SegPermiso segPermiso = segPermisoDTOToSegPermiso(segPermisoDTO);

                listSegPermiso.add(segPermiso);
            }

            return listSegPermiso;
        } catch (Exception e) {
            throw e;
        }
    }
}
